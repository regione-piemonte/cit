package it.csi.sigit.sigitext.business.be.manager;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitDStatoIspezioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitRIspezIspetDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAbilitazioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAccertamentoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAllegatoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTAzioneDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTImpiantoDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTIspezione2018Dao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTPersonaFisicaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTUnitaImmobiliareDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitTVerificaDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.SigitVRicercaAllegatiDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dao.WrkConfigDao;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitDStatoIspezioneDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitRIspezIspetDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Dto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitTIspezione2018Pk;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.SigitVRicercaAllegatiDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.dto.WrkConfigDto;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitDStatoIspezioneDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitRIspezIspetDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitTIspezione2018DaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.SigitVRicercaAllegatiDaoException;
import it.csi.sigit.sigitext.business.dao.sigitextdao.exceptions.WrkConfigDaoException;
import it.csi.sigit.sigitext.business.util.Constants;
import it.csi.sigit.sigitext.dto.sigitext.DatiIspezione;

public class DbIspezioneMgr {
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.db");
	
	private SigitTIspezione2018Dao sigitTIspezione2018Dao;
	
	private SigitDStatoIspezioneDao sigitDStatoIspezioneDao;
	
	private SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao;
	
	private SigitRIspezIspetDao sigitRIspezIspetDao;				
	
	private SigitTAllegatoDao sigitTAllegatoDao;		
	
	private SigitTAzioneDao sigitTAzioneDao;	
	
	private SigitTVerificaDao sigitTVerificaDao;
	
	private SigitTAccertamentoDao sigitTAccertamentoDao;
	
	private SigitTPersonaFisicaDao sigitTPersonaFisicaDao;	
	
	private SigitTAbilitazioneDao sigitTAbilitazioneDao;
	
	private SigitTImpiantoDao sigitTImpiantoDao;		
	
	private SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao;		
	
	public SigitTUnitaImmobiliareDao getSigitTUnitaImmobiliareDao() {
		return sigitTUnitaImmobiliareDao;
	}

	public void setSigitTUnitaImmobiliareDao(SigitTUnitaImmobiliareDao sigitTUnitaImmobiliareDao) {
		this.sigitTUnitaImmobiliareDao = sigitTUnitaImmobiliareDao;
	}

	public SigitTImpiantoDao getSigitTImpiantoDao() {
		return sigitTImpiantoDao;
	}

	public void setSigitTImpiantoDao(SigitTImpiantoDao sigitTImpiantoDao) {
		this.sigitTImpiantoDao = sigitTImpiantoDao;
	}

	public SigitTAbilitazioneDao getSigitTAbilitazioneDao() {
		return sigitTAbilitazioneDao;
	}

	public void setSigitTAbilitazioneDao(SigitTAbilitazioneDao sigitTAbilitazioneDao) {
		this.sigitTAbilitazioneDao = sigitTAbilitazioneDao;
	}

	public SigitTPersonaFisicaDao getSigitTPersonaFisicaDao() {
		return sigitTPersonaFisicaDao;
	}

	public void setSigitTPersonaFisicaDao(SigitTPersonaFisicaDao sigitTPersonaFisicaDao) {
		this.sigitTPersonaFisicaDao = sigitTPersonaFisicaDao;
	}

	public SigitTVerificaDao getSigitTVerificaDao() {
		return sigitTVerificaDao;
	}

	public void setSigitTVerificaDao(SigitTVerificaDao sigitTVerificaDao) {
		this.sigitTVerificaDao = sigitTVerificaDao;
	}

	public SigitTAccertamentoDao getSigitTAccertamentoDao() {
		return sigitTAccertamentoDao;
	}

	public void setSigitTAccertamentoDao(SigitTAccertamentoDao sigitTAccertamentoDao) {
		this.sigitTAccertamentoDao = sigitTAccertamentoDao;
	}

	public SigitTAzioneDao getSigitTAzioneDao() {
		return sigitTAzioneDao;
	}

	public void setSigitTAzioneDao(SigitTAzioneDao sigitTAzioneDao) {
		this.sigitTAzioneDao = sigitTAzioneDao;
	}

	public SigitTAllegatoDao getSigitTAllegatoDao() {
		return sigitTAllegatoDao;
	}

	public void setSigitTAllegatoDao(SigitTAllegatoDao sigitTAllegatoDao) {
		this.sigitTAllegatoDao = sigitTAllegatoDao;
	}

	public SigitRIspezIspetDao getSigitRIspezIspetDao() {
		return sigitRIspezIspetDao;
	}

	public void setSigitRIspezIspetDao(SigitRIspezIspetDao sigitRIspezIspetDao) {
		this.sigitRIspezIspetDao = sigitRIspezIspetDao;
	}

	public SigitVRicercaAllegatiDao getSigitVRicercaAllegatiDao() {
		return sigitVRicercaAllegatiDao;
	}

	public void setSigitVRicercaAllegatiDao(SigitVRicercaAllegatiDao sigitVRicercaAllegatiDao) {
		this.sigitVRicercaAllegatiDao = sigitVRicercaAllegatiDao;
	}

	private WrkConfigDao wrkConfigDao;			

	public SigitDStatoIspezioneDao getSigitDStatoIspezioneDao() {
		return sigitDStatoIspezioneDao;
	}

	public void setSigitDStatoIspezioneDao(SigitDStatoIspezioneDao sigitDStatoIspezioneDao) {
		this.sigitDStatoIspezioneDao = sigitDStatoIspezioneDao;
	}

	public WrkConfigDao getWrkConfigDao() {
		return wrkConfigDao;
	}

	public void setWrkConfigDao(WrkConfigDao wrkConfigDao) {
		this.wrkConfigDao = wrkConfigDao;
	}

	public SigitTIspezione2018Dao getSigitTIspezione2018Dao() {
		return sigitTIspezione2018Dao;
	}

	public void setSigitTIspezione2018Dao(SigitTIspezione2018Dao sigitTIspezione2018Dao) {
		this.sigitTIspezione2018Dao = sigitTIspezione2018Dao;
	}
	
	public BigDecimal getCountElencoIspezioni(DatiIspezione datiIspezione) throws DaoException {
	
		String method = "getCountElencoIspezioni";
		log.info("START: "+method);
		List<SigitTIspezione2018Dto> listSigitTIspezione2018Dto = getListSigitTIspezione2018Dto(datiIspezione);
		
		if(listSigitTIspezione2018Dto!=null) {		
			log.info("END: "+method);
			return new BigDecimal(listSigitTIspezione2018Dto.size());
		}else {
			SigitTIspezione2018DaoException e = new SigitTIspezione2018DaoException("Errore nel recupero delle ispezioni");
			log.error("ERROR: "+method,e);
			throw e;
		}
		
	}	
	
	public List<SigitTIspezione2018Dto> getElencoIspezioni(DatiIspezione datiIspezione) throws DaoException {
		String method = "getElencoIspezioni";
		log.info("START: "+method);			
		log.info("END: "+method);
		return getListSigitTIspezione2018Dto(datiIspezione);
		
	}
	
	private List<SigitTIspezione2018Dto> getListSigitTIspezione2018Dto(DatiIspezione datiIspezione)
			throws DaoException {
		String method = "getListSigitTIspezione2018Dto";
		log.info("START: "+method);		
		
		Long duration = (long)((23 * 60 * 60) + (59 * 60) + 59) * 1000;
		
		if(datiIspezione.getDtConclusioneA()!=null) {
			datiIspezione.setDtConclusioneA(datiIspezione.getDtConclusioneA()+duration);
		}
		if(datiIspezione.getDtCreazioneA()!=null) {
			datiIspezione.setDtCreazioneA(datiIspezione.getDtCreazioneA()+duration);
		}
		
		List<SigitTIspezione2018Dto> listSigitTIspezione2018Dto =  sigitTIspezione2018Dao.getElencoIspezioni(datiIspezione);
		log.info("END: "+method);
		return listSigitTIspezione2018Dto;
	}

	public SigitTIspezione2018Dto getDettaglioIspezione(Integer idIspezione2018) throws SigitTIspezione2018DaoException {
		String method = "getDettaglioIspezione";
		log.info("START: "+method);
		SigitTIspezione2018Pk pk = new SigitTIspezione2018Pk();
		pk.setIdIspezione2018(idIspezione2018);
		log.info("END: "+method);
		return sigitTIspezione2018Dao.findByPrimaryKey(pk);
		
	}
	
	public BigDecimal getMaxRigheRicAvzImp() throws SigitTIspezione2018DaoException {
		String method = "getMaxRigheRicAvzImp";
		log.info("START: "+method);

		List<WrkConfigDto> listWrkConfigDto;
		try {
			listWrkConfigDto = wrkConfigDao.findByChiaveConfig("MAX_RIGHE_RIC_AVZ_IMP");

			BigDecimal maxRigheRicAvzImp = null;

			if (listWrkConfigDto != null && !listWrkConfigDto.isEmpty()) {
				WrkConfigDto wrkConfigDto = listWrkConfigDto.get(0);
				maxRigheRicAvzImp = wrkConfigDto.getValoreConfigNum();
			}
		
			log.info("END: "+method);
			return maxRigheRicAvzImp;

		} catch (WrkConfigDaoException e) {
			log.error("ERROR: "+method,e);
			throw new SigitTIspezione2018DaoException(e.getMessage());
		}
				
	
	}

	public List<SigitDStatoIspezioneDto> getStatoIspezione() throws SigitDStatoIspezioneDaoException {		
		return sigitDStatoIspezioneDao.findAll();
	}
	
	public List<SigitRIspezIspetDto> getSigitRIspezIspetByFkPersonaFisica(BigDecimal fkPersonaFisica) throws SigitRIspezIspetDaoException{
		return sigitRIspezIspetDao.findByFkPersonaFisica(fkPersonaFisica);
	}
	
	public List<SigitRIspezIspetDto> getSigitRIspezIspetByIdIspezione2018(BigDecimal idIspezione2018) throws SigitRIspezIspetDaoException{
		return sigitRIspezIspetDao.findByIdIspezione2018(idIspezione2018);
	}
	
	public List<SigitVRicercaAllegatiDto> getSigitVRicercaAllegatiByCodImpianto(BigDecimal codiceImpianto) throws SigitVRicercaAllegatiDaoException{
		return sigitVRicercaAllegatiDao.findByCodImpianto(codiceImpianto.intValue());
	}

	public void updateSigitRIspezIspet(SigitRIspezIspetDto sigitRIspezIspetDto) throws SigitRIspezIspetDaoException {

		sigitRIspezIspetDao.update(sigitRIspezIspetDto);
		
	}

	public int insertSigitRIspezIspet(SigitRIspezIspetDto sigitRIspezIspetDto) throws SigitRIspezIspetDaoException {

		return sigitRIspezIspetDao.insert(sigitRIspezIspetDto);
		
	}

	
}
