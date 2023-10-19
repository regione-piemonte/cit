/*
 *
 *  * ******************************************************************************
 *  *  SPDX-License-Identifier: EUPL-1.2
 *  *  Copyright Regione Piemonte - 2021
 *  * *****************************************************************************
 *
 */

package it.csi.citpwa.business.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.csi.citpwa.business.service.ICitService;
import it.csi.citpwa.business.service.IControlliService;
import it.csi.citpwa.business.service.ValidationService;
import it.csi.citpwa.exception.SigitExtException;
import it.csi.citpwa.model.*;
import it.csi.citpwa.model.enums.TipoImportAllegatoEnum;
import it.csi.citpwa.model.sigitext.*;
import it.csi.citpwa.model.xml.ree.*;
import it.csi.citpwa.model.xsd.controllo1.*;
import it.csi.citpwa.model.xsd.controllo1B.MODIIB;
import it.csi.citpwa.model.xsd.controllo2.MODIII;
import it.csi.citpwa.model.xsd.controllo3.MODIV;
import it.csi.citpwa.model.xsd.controllo4.MODV;
import it.csi.citpwa.util.Constants;
import it.csi.citpwa.util.JWTUtil;
import it.csi.citpwa.util.MapDto;
import it.csi.sigit.sigitext.ws.service.client.Documento;
import it.csi.sigit.sigitext.ws.service.client.SigitUserNotAuthorizedException;
import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

@Service
public class ControlliServiceImp implements IControlliService {

	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME);
	@Autowired
	ICitService citService;

	@Autowired
	ValidationService validationService;

	@Override
	public DatiControlloModel recuperaDati(String codiceImpianto, String ordinamento, Integer numRighe, UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "getControlli - start");
		List<ControlloModel> controlloModelList = null;
		DatiControlloModel datiControlloModel = new DatiControlloModel();
		try {
			if (ordinamento == null)
				ordinamento = Constants.STATO_DEL_CONTROLLO;
			List<Controllo> controlloList = citService.getControlli(codiceImpianto, ordinamento, numRighe);
			if (controlloList != null) {
				controlloModelList = ControlloModel.dtoToModel.convert(controlloList);
				for (ControlloModel model : controlloModelList) {
					DatoControlloModel datoControlloModel = new DatoControlloModel();
					if (model.getIdAllegato() != null && model.getFkStatoRapp() != null && model.getFkStatoRapp().equals(Constants.BOZZA)) {
						String elencoApparecchiatura = model.getElencoApparecchiatura();
						String[] componenti = StringUtils.split(elencoApparecchiatura, '|');
						DatiGT[] gtControllo = null;
						byte[] xmlControllo = citService.getXMLControllo(model.getIdAllegato());
						switch (model.getFkTipoDocumento().toString()) {
							case Constants.ALLEGATO_TIPO_1:
								DatoControlloTipo1Model datoControlloTipo1 = new DatoControlloTipo1Model();
								if (xmlControllo != null) {
									Source source = new StreamSource(new ByteArrayInputStream(xmlControllo));
									JAXBContext context = JAXBContext.newInstance(MODII.class);
									JAXBElement<MODII> root = context.createUnmarshaller().unmarshal(source, MODII.class);
									datoControlloTipo1.setXmlControllo(MapDto.mod1reeDtoToModel(root.getValue()));
								}
								if (componenti != null) {
									for (String comp : componenti) {
										String progr = comp.split("-")[1];
										gtControllo = citService.getGT(codiceImpianto, Integer.parseInt(progr), null);
										if (gtControllo != null)
											datoControlloTipo1.addDatiGTModelList(DatiGTModel.dtoToModel.convert(List.of(gtControllo)));
									}
								}
								datoControlloModel = datoControlloTipo1;
								break;
							case Constants.ALLEGATO_TIPO_1B:
								DatoControlloTipo1BModel controlloTipo1BModel = new DatoControlloTipo1BModel();
								if (xmlControllo != null) {
									Source source = new StreamSource(new ByteArrayInputStream(xmlControllo));
									JAXBContext context = JAXBContext.newInstance(MODIIB.class);
									JAXBElement<MODIIB> root = context.createUnmarshaller().unmarshal(source, MODIIB.class);
									controlloTipo1BModel.setXmlControllo(MapDto.mod1BreeDtoToModel(root.getValue()));
								}
								if (componenti != null) {
									for (String comp : componenti) {
										String progr = comp.split("-")[1];
										gtControllo = citService.getGT(codiceImpianto, Integer.parseInt(progr), null);
										if (gtControllo != null)
											controlloTipo1BModel.addDatiGTModelList(DatiGTModel.dtoToModel.convert(List.of(gtControllo)));
									}
								}
								datoControlloModel = controlloTipo1BModel;
								break;

							case Constants.ALLEGATO_TIPO_2:
								DatoControlloTipo2Model controlloTipo2Model = new DatoControlloTipo2Model();
								if (xmlControllo != null) {
									Source source = new StreamSource(new ByteArrayInputStream(xmlControllo));
									JAXBContext context = JAXBContext.newInstance(MODIII.class);
									JAXBElement<MODIII> root = context.createUnmarshaller().unmarshal(source, MODIII.class);
									controlloTipo2Model.setXmlControllo(MapDto.mod2reeDtoToModel(root.getValue()));
								}
								if (componenti != null) {
									for (String comp : componenti) {
										String progr = comp.split("-")[1];
										DatiGF[] gfControllo = citService.getGF(codiceImpianto, Integer.parseInt(progr), null);
										if (gfControllo != null)
											controlloTipo2Model.addDatiGFmodelList(DatiGFModel.dtoToModel.convert(List.of(gfControllo)));
									}
								}
								datoControlloModel = controlloTipo2Model;
								break;
							case Constants.ALLEGATO_TIPO_3:
								DatoControlloTipo3Model controlloTipo3Model = new DatoControlloTipo3Model();
								if (xmlControllo != null) {
									Source source = new StreamSource(new ByteArrayInputStream(xmlControllo));
									JAXBContext context = JAXBContext.newInstance(MODIV.class);
									JAXBElement<MODIV> root = context.createUnmarshaller().unmarshal(source, MODIV.class);
									controlloTipo3Model.setXmlControllo(MapDto.mod3reeDtoToModel(root.getValue()));
								}
								if (componenti != null) {
									for (String comp : componenti) {
										String progr = comp.split("-")[1];
										DatiSC[] scControllo = citService.getSC(codiceImpianto, Integer.parseInt(progr), null);
										if (scControllo != null)
											controlloTipo3Model.addDatiGFmodelList(DatiSCModel.dtoToModel.convert(List.of(scControllo)));
									}
								}
								datoControlloModel = controlloTipo3Model;
								break;
							case Constants.ALLEGATO_TIPO_4:
								DatoControlloTipo4Model controlloTipo4Model = new DatoControlloTipo4Model();
								if (xmlControllo != null) {
									Source source = new StreamSource(new ByteArrayInputStream(xmlControllo));
									JAXBContext context = JAXBContext.newInstance(MODV.class);
									JAXBElement<MODV> root = context.createUnmarshaller().unmarshal(source, MODV.class);
									controlloTipo4Model.setXmlControllo(MapDto.mod4reeDtoToModel(root.getValue()));
								}
								if (componenti != null) {
									for (String comp : componenti) {
										String progr = comp.split("-")[1];
										DatiCG[] gfControllo = citService.getCG(codiceImpianto, Integer.parseInt(progr), null);
										if (gfControllo != null)
											controlloTipo4Model.addDatiCGmodelList(DatiCGModel.dtoToModel.convert(List.of(gfControllo)));
									}
								}
								datoControlloModel = controlloTipo4Model;
								break;
						}
					}
					datoControlloModel.setControlloModel(model);
					datiControlloModel.addControllo(datoControlloModel);
				}
				Integer idPersonaGiuridica = utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica();
				String ruolo = utenteLoggato.getRuoloLoggato().getRuolo();
				DatiGT[] gtList = null;
				DatiGF[] gfList = null;
				DatiSC[] scList = null;
				DatiCG[] cgList = null;
				if (Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo) || Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo)) {
					gtList = citService.getGT(codiceImpianto, null, null);
					gfList = citService.getGF(codiceImpianto, null, null);
					scList = citService.getSC(codiceImpianto, null, null);
					cgList = citService.getCG(codiceImpianto, null, null);
				} else if (idPersonaGiuridica != null) {
					gtList = citService.getGT(codiceImpianto, null, idPersonaGiuridica);
					gfList = citService.getGF(codiceImpianto, null, idPersonaGiuridica);
					scList = citService.getSC(codiceImpianto, null, idPersonaGiuridica);
					cgList = citService.getCG(codiceImpianto, null, idPersonaGiuridica);
				}
				if (gtList != null && gtList.length > 0) {
					datiControlloModel.setDatiGT(DatiGTModel.dtoToModel.convert(Arrays.asList(gtList)));
					CodiceDescrizione[] stelle = MapDto.mapStelle(citService.getStelle());
					CodiceDescrizione[] apparecchiature = citService.getApparecchiature();
					CodiceDescrizione[] ariaComburente = citService.getAriaComburente();
					CodiceDescrizione[] controlloAria = citService.getControlloAria();
					CodiceDescrizione[] unitaMisura = citService.getUnitaMisura();
					datiControlloModel.setStelle(Arrays.asList(stelle));
					datiControlloModel.setApparecchiature(Arrays.asList(apparecchiature));
					datiControlloModel.setAriaCombustibile(Arrays.asList(ariaComburente));
					datiControlloModel.setControlloAria(Arrays.asList(controlloAria));
					datiControlloModel.setUnitaMisura(Arrays.asList(unitaMisura));
				}
				if (gfList != null && gfList.length > 0) {
					datiControlloModel.setDatiGF(DatiGFModel.dtoToModel.convert(Arrays.asList(gfList)));
				}
				if (scList != null && scList.length > 0) {
					datiControlloModel.setDatiSC(DatiSCModel.dtoToModel.convert(Arrays.asList(scList)));
					CodiceDescrizione[] fluido = citService.getFluidoCIT();
					datiControlloModel.setFluido(Arrays.asList(fluido));
				}
				if (cgList != null && cgList.length > 0) {
					datiControlloModel.setDatiCG(DatiCGModel.dtoToModel.convert(Arrays.asList(cgList)));
					CodiceDescrizione[] fluido = citService.getFluidoCIT();
					datiControlloModel.setFluido(Arrays.asList(fluido));
				}
			}
			return datiControlloModel;
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "getControlli - timeout: ", e);
			throw e;
		} catch (NotFoundException e) {
			log.error(Constants.CONTROLLI_LOG + "getControlli - nessun controllo trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "getControlli - error: ", e);
			throw new Exception("Errore recupero controlli", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "getControlli - end");
		}

	}

	@Override
	public Object getXmlCOntrollo(Integer idAllegato, String tipoDoc, UtenteLoggato user) throws Exception {
		byte[] xmlControllo = citService.getXMLControllo(idAllegato);
		if (Constants.ALLEGATO_TIPO_1.equals(tipoDoc)) {
			Source source = new StreamSource(new ByteArrayInputStream(xmlControllo));
			JAXBContext context = JAXBContext.newInstance(MODII.class);
			JAXBElement<MODII> root = context.createUnmarshaller().unmarshal(source, MODII.class);
			return root.getValue();

		}
		if (Constants.ALLEGATO_TIPO_1B.equals(tipoDoc)) {
			Source source = new StreamSource(new ByteArrayInputStream(xmlControllo));
			JAXBContext context = JAXBContext.newInstance(MODIIB.class);
			JAXBElement<MODIIB> root = context.createUnmarshaller().unmarshal(source, MODIIB.class);
			return root.getValue();
		}
		return null;
	}

	@Override
	public byte[] getRicevuta(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "getRicevuta - start");
		byte[] ricevuta = null;
		try {
			String ruolo = utenteLoggato.getRuoloLoggato().getRuolo();
			if (Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo) || Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo)
					|| Constants.RUOLO_PROPRIETARIO.equals(ruolo) || Constants.RUOLO_IMPRESA.equals(ruolo)) {
				ricevuta = citService.getRicevutaControllo(tipoComponente, codiceImpianto, progressivo, dataInstallazione, idAllegato, utenteLoggato);
				return ricevuta;
			} else
				throw new SigitUserNotAuthorizedException();
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "getRicevuta - timeout: ", e);
			throw e;
		} catch (SigitUserNotAuthorizedException e) {
			log.error(Constants.CONTROLLI_LOG + "getRicevuta - utente non autorizzato al download del documento: ", e);
			throw new SigitUserNotAuthorizedException();
		} catch (NotFoundException e) {
			log.error(Constants.CONTROLLI_LOG + "getRicevuta - nessun controllo trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "getRicevuta - error: ", e);
			throw new Exception("Errore recupero ricevuta", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "getRicevuta - end");
		}
	}

	@Override
	public PdfControllo getPDFControllo(String tipoComponente, String codiceImpianto, Integer progressivo, Date dataInstallazione, String idAllegato, Boolean firmato, UtenteLoggato utenteLoggato)
			throws Exception {
		log.info(Constants.CONTROLLI_LOG + "getPDFControllo - start");
		PdfControllo ricevuta = null;
		try {
			String ruolo = utenteLoggato.getRuoloLoggato().getRuolo();
			if (Constants.RUOLO_SUPER.equals(ruolo) || Constants.RUOLO_VALIDATORE.equals(ruolo) || Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo)
					|| Constants.RUOLO_PROPRIETARIO.equals(ruolo) || Constants.RUOLO_IMPRESA.equals(ruolo)) {
				ricevuta = citService.getPDFControllo(tipoComponente, codiceImpianto, progressivo, dataInstallazione, idAllegato, firmato, utenteLoggato);
				return ricevuta;
			} else
				throw new SigitUserNotAuthorizedException();
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "getPDFControllo - timeout: ", e);
			throw e;
		} catch (SigitUserNotAuthorizedException e) {
			log.error(Constants.CONTROLLI_LOG + "getPDFControllo - utente non autorizzato al download del documento: ", e);
			throw new SigitUserNotAuthorizedException();
		} catch (NotFoundException e) {
			log.error(Constants.CONTROLLI_LOG + "getPDFControllo - nessun controllo trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "getPDFControllo - error: ", e);
			throw new Exception("Errore recupero ree", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "getPDFControllo - end");
		}
	}

	@Override
	public List<ControlloDisponibileModel> getControlliDisponibili(String codiceImpianto, String tipoComponente, String tipoControllo, String dataControllo, UtenteLoggato utenteLoggato)
			throws Exception {
		log.info(Constants.CONTROLLI_LOG + "getControlliDisponibili - start");
		List<ControlloDisponibile> controlli = null;
		try {
			String ruolo = utenteLoggato.getRuoloLoggato().getRuolo();
			if (!(Constants.RUOLO_ISPETTORE.equals(ruolo) || Constants.RUOLO_CONSULTATORE.equals(ruolo))) {
				switch (tipoComponente) {
					case Constants.TIPO_COMPONENTE_GT:
						tipoControllo = tipoControllo.equals(Constants.TIPO_CONTROLLO_MANUT) ? Constants.MANUTENZIONE_GT : Constants.ALLEGATO_TIPO_1;
						break;
					case Constants.TIPO_COMPONENTE_GF:
						tipoControllo = tipoControllo.equals(Constants.TIPO_CONTROLLO_MANUT) ? Constants.MANUTENZIONE_GF : Constants.ALLEGATO_TIPO_2;
						break;
					case Constants.TIPO_COMPONENTE_SC:
						tipoControllo = tipoControllo.equals(Constants.TIPO_CONTROLLO_MANUT) ? Constants.MANUTENZIONE_SC : Constants.ALLEGATO_TIPO_4;
						break;
					case Constants.TIPO_COMPONENTE_CG:
						tipoControllo = tipoControllo.equals(Constants.TIPO_CONTROLLO_MANUT) ? Constants.MANUTENZIONE_CG : Constants.ALLEGATO_TIPO_3;
						break;
				}
				controlli = citService.getControlliDisponibili(codiceImpianto, tipoComponente, tipoControllo, dataControllo, utenteLoggato);
				return ControlloDisponibileModel.dtoToModel.convert(controlli);
			} else
				throw new SigitUserNotAuthorizedException();
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "getControlliDisponibili - timeout: ", e);
			throw e;
		} catch (SigitUserNotAuthorizedException e) {
			log.error(Constants.CONTROLLI_LOG + "getControlliDisponibili - utente non autorizzato alla ricerca: ", e);
			throw new SigitUserNotAuthorizedException();
		} catch (SigitExtException e) {
			log.error(Constants.CONTROLLI_LOG + "getControlliDisponibili - errore validazione controlli: ", e);
			throw e;
		} catch (NotFoundException e) {
			log.error(Constants.CONTROLLI_LOG + "getControlliDisponibili - nessun controllo trovato: ", e);
			throw new NotFoundException();
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "getControlliDisponibili - error: ", e);
			throw new Exception("Errore recupero controlli disponibili", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "getControlliDisponibili - end");
		}
	}

	@Override
	public void uploadReeFirmato(Integer idAllegato, File ree, String fileName, String mimeType, UtenteLoggato user) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "uploadReeFirmato - start");
		try {
			byte[] fileContent = Files.readAllBytes(ree.toPath());
			citService.uploadReeFirmato(idAllegato, fileContent, fileName, mimeType, user.getRuoloLoggato().getIdPersonaGiuridica(), user.getRuoloLoggato().getPiva(), user.getRuoloLoggato()
					.getRuolo());
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "uploadReeFirmato - timeout: ", e);
			throw e;
		} catch (SigitExtException e) {
			log.error(Constants.CONTROLLI_LOG + "uploadReeFirmato - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "uploadReeFirmato - error: ", e);
			throw new Exception("Errore upload ree firmato", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "uploadReeFirmato - end");
		}
	}

	@Override
	public void inviaManutenzione(String codiceImpianto, String tipoControllo, ManutFormModel manutFormModel, UtenteLoggato user) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "inviaManutenzione - start");
		try {
			String[] nomeCognome = StringUtils.split(manutFormModel.getNomeCognomeTecnico(), ' ');
			String[] cognomeArray = nomeCognome != null && nomeCognome.length > 0 ? Arrays.copyOfRange(nomeCognome, 1, nomeCognome.length) : null;
			String nome = nomeCognome != null && nomeCognome.length > 0 ? nomeCognome[0] : "";
			String cognome = cognomeArray != null ? String.join(" ", cognomeArray) : "";
			XMLGregorianCalendar dataProssimoIntervento = validationService.convertToDate(manutFormModel.getProssimoInterventoEntro(), Constants.FORMAT);
			XMLGregorianCalendar dataControllo = validationService.convertToDate(manutFormModel.getDataControllo(), Constants.FORMAT);
			byte[] xmlManut = null;
			switch (tipoControllo) {
				case Constants.MANUTENZIONE_GT:
					String xmlStringGT = MapDto.createManutenzioneGTXML(manutFormModel, nome, cognome, dataProssimoIntervento, dataControllo, codiceImpianto, user);
					xmlManut = xmlStringGT.getBytes(StandardCharsets.UTF_8);
					break;
				case Constants.MANUTENZIONE_GF:
					String xmlStringGF = MapDto.createManutenzioneGFXML(manutFormModel, nome, cognome, dataProssimoIntervento, dataControllo, codiceImpianto, user);
					xmlManut = xmlStringGF.getBytes(StandardCharsets.UTF_8);
					break;
				case Constants.MANUTENZIONE_SC:
					String xmlStringSC = MapDto.createManutenzioneSCXML(manutFormModel, nome, cognome, dataProssimoIntervento, dataControllo, codiceImpianto, user);
					xmlManut = xmlStringSC.getBytes(StandardCharsets.UTF_8);
					break;
				case Constants.MANUTENZIONE_CG:
					String xmlStringCG = MapDto.createManutenzioneCGXML(manutFormModel, nome, cognome, dataProssimoIntervento, dataControllo, codiceImpianto, user);
					xmlManut = xmlStringCG.getBytes(StandardCharsets.UTF_8);
					break;
			}
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(user.getPfLoggato().getCodiceFiscalePF(), null);
			TipoImportAllegatoEnum tipoCOntrollo = TipoImportAllegatoEnum.valueOfId(tipoControllo);
			if (tipoCOntrollo != null) {
				citService.uploadXMLControlloJWT(Integer.parseInt(codiceImpianto), tipoCOntrollo.tipoImportLabel, xmlManut, tokenJWT.getToken());
			}
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "inviaManutenzione - timeout: ", e);
			throw e;
		} catch (SigitExtException e) {
			log.error(Constants.CONTROLLI_LOG + "inviaManutenzione - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "inviaManutenzione - error: ", e);
			throw new Exception("Errore invio nuova manutenzione", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "inviaManutenzione - end");
		}
	}

	@Override
	public Esito inserisciREE(String codiceImpianto, String tipoControllo, String ree, boolean invia, UtenteLoggato user) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "inviaRee - start");
		try {
			byte[] convertedXml = convertModModelToByteArray(ree, tipoControllo);
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(user.getPfLoggato().getCodiceFiscalePF(), null);
			TipoImportAllegatoEnum tipoCOntrollo = TipoImportAllegatoEnum.valueOfId(tipoControllo);
			if (tipoCOntrollo != null) {
				Integer id = citService.modificaControlloJWT(null,Integer.parseInt(codiceImpianto), tipoCOntrollo.tipoImportLabel, convertedXml, tokenJWT.getToken());
				if (id != null && invia) {
					try {
						inviaREE(id, user);
						return new Esito(Constants.OK, "Inserimento e invo ree avvenuto con successo");
					} catch (SigitExtException e) {
						return new Esito(Constants.KO, "Ree creato in bozza. L'invio è fallito per i seguenti motivi:\n" + e.getMessage(), id);
					}
				}
				return new Esito(Constants.OK, "Inserimento ree avvenuto con successo");
			} else
				throw new Exception();
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "inviaRee - timeout: ", e);
			throw e;
		} catch (SigitExtException e) {
			log.error(Constants.CONTROLLI_LOG + "inviaRee - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "inviaRee - error: ", e);
			throw new Exception("Errore invio ree", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "inviaRee - end");
		}
	}

	private byte[] convertModModelToByteArray(String ree, String tipoControllo) throws JsonProcessingException, JAXBException {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter sw = new StringWriter();
		MODModel reeModel = null;
		JAXBContext jaxbContext = null;
		Marshaller jaxbMarshaller = null;
		switch (tipoControllo) {
			case Constants.ALLEGATO_TIPO_1:
				reeModel = mapper.readValue(ree, MODModel.class);
				MODII modii = MapDto.mod1reeModelToDto(reeModel);
				jaxbContext = JAXBContext.newInstance(MODII.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(modii, sw);
				break;
			case Constants.ALLEGATO_TIPO_1B:
				reeModel = mapper.readValue(ree, MODModel.class);
				MODIIB modiib = MapDto.mod1BreeModelToDto(reeModel);
				jaxbContext = JAXBContext.newInstance(MODIIB.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(modiib, sw);
				break;
			case Constants.ALLEGATO_TIPO_2:
				reeModel = mapper.readValue(ree, MODModel.class);
				MODIII modiii = MapDto.mod2reeModelToDto(reeModel);
				jaxbContext = JAXBContext.newInstance(MODIII.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(modiii, sw);
				break;
			case Constants.ALLEGATO_TIPO_3:
				reeModel = mapper.readValue(ree, MODModel.class);
				MODIV modiv = MapDto.mod3reeModelToDto(reeModel);
				jaxbContext = JAXBContext.newInstance(MODIV.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(modiv, sw);
				break;
			case Constants.ALLEGATO_TIPO_4:
				reeModel = mapper.readValue(ree, MODModel.class);
				MODV modv = MapDto.mod4reeModelToDto(reeModel);
				jaxbContext = JAXBContext.newInstance(MODV.class);
				jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(modv, sw);
				break;
		}
		log.info(sw.toString());
		return sw.toString().getBytes(StandardCharsets.UTF_8);
	}

	@Override
	public void modificaREE(Integer idAllegato, String codiceImpianto, String tipoControllo, boolean invia, String ree, UtenteLoggato user) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "modificaREE - start");
		try {
			byte[] convertedXml = convertModModelToByteArray(ree, tipoControllo);
			Integer idAllegatoNew = null;
			JWTModel tokenJWT = JWTUtil.generaTokenFruitoreInterno(user.getPfLoggato().getCodiceFiscalePF(), null);
			TipoImportAllegatoEnum tipoCOntrollo = TipoImportAllegatoEnum.valueOfId(tipoControllo);
			if (tipoCOntrollo != null) {
				idAllegatoNew = citService.modificaControlloJWT(idAllegato, Integer.parseInt(codiceImpianto), tipoCOntrollo.tipoImportLabel, convertedXml, tokenJWT.getToken());
			}
			if (invia && idAllegatoNew != null) {
				inviaREE(idAllegatoNew, user);
			}
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "modificaREE - timeout: ", e);
			throw e;
		} catch (SigitExtException e) {
			log.error(Constants.CONTROLLI_LOG + "modificaREE - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "modificaREE - error: ", e);
			throw new Exception("Errore modifica ree", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "modificaREE - end");
		}
	}

	@Override
	public Esito inviaREE(Integer idAllegato, UtenteLoggato user) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "inviaREE - start");
		try {
			return citService.inviaREE(idAllegato, user.getRuoloLoggato().getIdPersonaGiuridica(), user.getPfLoggato().getCodiceFiscalePF(), user.getRuoloLoggato());
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "inviaREE - timeout: ", e);
			throw e;
		} catch (SigitExtException e) {
			log.error(Constants.CONTROLLI_LOG + "inviaREE - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "inviaREE - error: ", e);
			throw new Exception("Errore modifica ree", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "inviaREE - end");
		}
	}

	@Override
	public void deleteControllo(Integer idAllegato, Integer statoRapp, UtenteLoggato utenteLoggato) throws Exception {
		log.info(Constants.CONTROLLI_LOG + "deleteControllo - start");
		try {
			if (statoRapp.equals(Constants.BOZZA)) {
				Esito esito = citService.deleteControllo(idAllegato, utenteLoggato.getRuoloLoggato().getIdPersonaGiuridica(), utenteLoggato.getRuoloLoggato().getPiva(), utenteLoggato.getRuoloLoggato()
						.getRuolo());
				if (!esito.getEsito().equals(Constants.OK))
					throw new SigitExtException("Errore nella cancellazione del controllo");
			} else
				throw new SigitExtException("Impossible cancellare un controllo non in bozza");
		} catch (SocketTimeoutException e) {
			log.error(Constants.CONTROLLI_LOG + "deleteControllo - timeout: ", e);
			throw e;
		} catch (SigitExtException e) {
			log.error(Constants.CONTROLLI_LOG + "deleteControllo - error: ", e);
			throw e;
		} catch (Exception e) {
			log.error(Constants.CONTROLLI_LOG + "deleteControllo - error: ", e);
			throw new Exception("Errore cancellazione controllo", e);
		} finally {
			log.info(Constants.CONTROLLI_LOG + "deleteControllo - end");
		}
	}
}
