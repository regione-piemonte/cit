package it.csi.sigit.citpdnd.dao;

import it.csi.sigit.citpdnd.api.dto.Impianto;
import it.csi.sigit.citpdnd.api.dto.ListaImpianti;
import it.csi.sigit.citpdnd.entities.SigitLibretto;
import it.csi.sigit.citpdnd.entities.SigitUnitaImmobiliare;
import it.csi.sigit.citpdnd.entities.VistaRicercaImpianti;
import it.csi.sigit.citpdnd.exception.CitpdndException;
import it.csi.sigit.citpdnd.services.IndexService;
import it.csi.sigit.citpdnd.utils.Constants;
import it.csi.sigit.citpdnd.utils.MapDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ImpiantiDao {

    protected static final Logger log = Logger.getLogger(Constants.APPLICATION_NAME);

    @Inject
    EntityManager entityManager;

    @Inject
    AuditDao auditDao;

    @Inject
    ConfigDao configDao;

    @Inject
    IndexService indexService;

    public ListaImpianti getImpiantoByCodiceImpianto(BigDecimal codImpianto) throws CitpdndException {

        ListaImpianti impianti = new ListaImpianti();
        Impianto dtoImpianto = null;

        try {
            auditDao.insertAccesso("getImpiantoByCodiceImpianto("+codImpianto+")");

            VistaRicercaImpianti impianto = VistaRicercaImpianti.findById(codImpianto);
            SigitUnitaImmobiliare unitaImmobiliare = SigitUnitaImmobiliare.find("codiceImpianto = ?1 and flgPrincipale = ?2", codImpianto, BigDecimal.ONE).firstResult();

            if (impianto != null) {
                dtoImpianto = MapDto.mapImpiantoToImpiantoDto(impianto, unitaImmobiliare);
                impianti.add(dtoImpianto);
            }
        } catch (Exception e) {
            log.error("ImpiantiDao.getImpiantoByCodiceImpianto - " + e.getMessage(), e);
            throw new CitpdndException("01", Constants.ERROR_MESSAGE_CODE_01);
        }

        return impianti;
    }

    public ListaImpianti getImpiantoByIndirizzoImpianto(String indirizzo, String istatComune, String civico) throws CitpdndException {

        ListaImpianti impianti = new ListaImpianti();

        boolean isCivicoPresente = civico != null && !civico.trim().equals("");
        if (indirizzo == null || indirizzo.trim().length() < 3) {
            log.error("ImpiantiDao.getImpiantoByIndirizzoImpianto - Indirizzo non valido.");
            throw new CitpdndException("02", Constants.ERROR_MESSAGE_CODE_02);
        }

        String jpql = "select vri from VistaRicercaImpianti vri where upper(vri.indirizzoUnitaImmob) like :indirizzo and vri.istatComune = :istatComune ";
        if (isCivicoPresente) {
            jpql += "and vri.civico like :civico ";
        }

        try {
            auditDao.insertAccesso("getImpiantoByIndirizzoImpianto("+istatComune+";"+indirizzo+";"+civico+")");

            TypedQuery<VistaRicercaImpianti> query = entityManager.createQuery(jpql, VistaRicercaImpianti.class);
            query.setParameter("indirizzo", "%" + indirizzo.trim().toUpperCase() + "%");
            query.setParameter("istatComune", istatComune);
            if (isCivicoPresente) {
                query.setParameter("civico", civico + "%");
            }
            List<VistaRicercaImpianti> vImpianti = query.getResultList();

            if (vImpianti.size() > configDao.getMaxRisultati().intValue()) {
                log.error("ImpiantiDao.getImpiantoByIndirizzoImpianto - Superato il numero massimo di risultati ammissibili.");
                throw new CitpdndException("05", Constants.ERROR_MESSAGE_CODE_05);
            }

            for(VistaRicercaImpianti vImpianto : vImpianti) {
                SigitUnitaImmobiliare unitaImmobiliare = SigitUnitaImmobiliare.find("codiceImpianto = ?1 and flgPrincipale = ?2", vImpianto.getCodiceImpianto(), BigDecimal.ONE).firstResult();

                Impianto impianto = MapDto.mapImpiantoToImpiantoDto(vImpianto, unitaImmobiliare);
                impianti.add(impianto);
            }
        } catch (CitpdndException e) {
            throw e;
        } catch (Exception e) {
            log.error("ImpiantiDao.getImpiantoByIndirizzoImpianto - " + e.getMessage(), e);
            throw new CitpdndException("01", Constants.ERROR_MESSAGE_CODE_01);
        }

        return impianti;
    }

    public Response getLibrettoByCodiceImpianto(BigDecimal codImpianto) throws CitpdndException {

        try {
            auditDao.insertAccesso("getLibrettoByCodiceImpianto("+codImpianto+")");

            Optional<SigitLibretto> libretto = SigitLibretto.find("codiceImpianto = ?1 and fkStato = 2", codImpianto).singleResultOptional();
            if (libretto.isPresent()) {

                byte[] librettoDoc = indexService.getLibrettoPdf(libretto.get());

                InputStream is = new ByteArrayInputStream(librettoDoc);
                Response.ResponseBuilder responseBuilder = Response.ok((Object) is);
                responseBuilder.type("application/pdf");
                responseBuilder.header("Content-Disposition", "filename=test.pdf");

                return responseBuilder.build();

            } else {
                log.error("ImpiantiDao.getLibrettoByCodiceImpianto - Libretto non trovato.");
                throw new CitpdndException("03", Constants.ERROR_MESSAGE_CODE_03);
            }
        } catch (CitpdndException e) {
            throw e;
        } catch (Exception e) {
            log.error("ImpiantiDao.getLibrettoByCodiceImpianto - " + e.getMessage(), e);
            throw new CitpdndException("01", Constants.ERROR_MESSAGE_CODE_01);
        }

    }
}
