package test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRComp4ManutDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompCgDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompGfDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompGtDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompScDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDRuoloDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFilter;
import it.csi.sigit.sigitwebn.business.manager.DbMgr;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.util.ComparatorDto;
import it.csi.sigit.sigitwebn.util.ComparatorUtil;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.util.XmlValidator;
import it.csi.sigit.sigitwebn.util.XmlValidatorException;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L101VentilazioneMeccanicaDocument.L101VentilazioneMeccanica;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L101VentilazioneMeccanicaSostituitoDocument.L101VentilazioneMeccanicaSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L10VentilazioneDocument.L10Ventilazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L10VentilazioneDocument.L10Ventilazione.L101VM;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L144DatiConsumoProdottiChimiciDocument.L144DatiConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L141ConsumoCombustibile;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L143ConsumoAcqua;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L14ConsumiDocument.L14Consumi.L144ConsumoProdottiChimici;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L1SchedaIdentificativaDocument.L1SchedaIdentificativa;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L2TrattamentoAcquaDocument.L2TrattamentoAcqua;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L41GruppoTermicoDocument.L41GruppoTermico;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L41GruppoTermicoSostituitoDocument.L41GruppoTermicoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L42BruciatoreDocument.L42Bruciatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L42BruciatoreSostituitoDocument.L42BruciatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L43RecuperatoreDocument.L43Recuperatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L43RecuperatoreSostituitoDocument.L43RecuperatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L44GruppoFrigoDocument.L44GruppoFrigo;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L44GruppoFrigoSostituitoDocument.L44GruppoFrigoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L45ScambiatoreDocument.L45Scambiatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L45ScambiatoreSostituitoDocument.L45ScambiatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L46CogeneratoreDocument.L46Cogeneratore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L46CogeneratoreSostituitoDocument.L46CogeneratoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L47CampoSolareTermicoDocument.L47CampoSolareTermico;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L47CampoSolareTermicoSostituitoDocument.L47CampoSolareTermicoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L48AltroGeneratoreDocument.L48AltroGeneratore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L48AltroGeneratoreSostituitoDocument.L48AltroGeneratoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L41GT;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L42BR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L43RC;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L44GF;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L45SC;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L46CG;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L47CS;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L4GeneratoriDocument.L4Generatori.L48AG;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51SistemaRegolazioneDocument.L51SistemaRegolazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51ValvolaRegolazioneDocument.L51ValvolaRegolazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L64PompaDocument.L64Pompa;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L64PompaSostituitoDocument.L64PompaSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L6SistemiDistribuzioneDocument.L6SistemiDistribuzione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L6SistemiDistribuzioneDocument.L6SistemiDistribuzione.L64PO;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L7SistemiEmissioneDocument.L7SistemiEmissione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L81AccumuloDocument.L81Accumulo;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L81AccumuloSostituitoDocument.L81AccumuloSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L8SistemiAccumuloDocument.L8SistemiAccumulo;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L8SistemiAccumuloDocument.L8SistemiAccumulo.L81AC;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L91TorreDocument.L91Torre;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L91TorreSostituitoDocument.L91TorreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L92RaffreddatoreDocument.L92Raffreddatore;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L92RaffreddatoreSostituitoDocument.L92RaffreddatoreSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L93ScambiatoreIntermedioDocument.L93ScambiatoreIntermedio;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L93ScambiatoreIntermedioSostituitoDocument.L93ScambiatoreIntermedioSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L94CircuitoDocument.L94Circuito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L94CircuitoSostituitoDocument.L94CircuitoSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L95UnitaTrattAriaDocument.L95UnitaTrattAria;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L95UnitaTrattAriaSostituitoDocument.L95UnitaTrattAriaSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L96RecuperatoreAriaAmbDocument.L96RecuperatoreAriaAmb;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L96RecuperatoreAriaAmbSostituitoDocument.L96RecuperatoreAriaAmbSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L91TE;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L92RV;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L93SCX;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L94CI;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L95UT;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L9AltriComponentiDocument.L9AltriComponenti.L96RCX;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51SistemaRegolazioneSostituitoDocument.L51SistemaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51ValvolaRegolazioneSostituitoDocument.L51ValvolaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51SR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51VR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoCatastoDocument.LibrettoCatasto;
import it.csi.sigit.sigitwebn.xml.libretto.data.MODDocument;
import it.csi.sigit.sigitwebn.xml.libretto.data.DatiPrecompilatiDocument.DatiPrecompilati;
import it.csi.sigit.sigitwebn.xml.libretto.data.RichiestaDocument.Richiesta;
import it.csi.sitad.tpnm.entity.Via;
import it.csi.sitad.tpnm.interf.ToponomasticaInterface;

public class TestImportLibretto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//numIntero();

		//System.out.println("PROVA: "+java.lang.Integer.MAX_VALUE);
		//provaGestioneEccezione();
		//testImportLibrettoTemp();
		testImportLibretto();

	}


	public static void testImportLibrettoTemp()
	{
		List<String> list = new ArrayList<String>();
		list.add("Z");
		list.add("F");
		list.add("A");
		list.add("B");

		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("\n\n");
		Collections.sort(list, ComparatorUtil.prova());


		for (String string : list) {
			System.out.println(string);
		}
	}


	public static void testImportLibretto()
	{
		String nomeFile = "libretto_MAD_err_GT2DateSost.xml";//"libretto_full.xml"; //libretto_parz
		File file = new File("D:\\progetti\\eclipse luna\\energia\\sigit_sigitwebn\\docs\\"+nomeFile);

		System.out.println(file);

		try
		{
			validazioneXmlImportLibretto(file, nomeFile);
		}
		catch (ValidationManagerException v)
		{
			v.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		//new zioneMa validazioneXmlImportLibretto
	}

	public static void validazioneXmlImportLibretto(File file, String fileName) throws ValidationManagerException
	{
		System.out.println("validazioneXmlImport START");
		String schemasDir = "schemaorg_apache_xmlbeans/src/src/adobe/Schemas/";
		//DA SCOMMENTARE
		//String all2Schema = schemasDir + "Import-Libretto-1.0.0.xsd";

		//DA COMMENTARE
		String all2Schema = "D:\\progetti\\eclipse luna\\energia\\sigit_sigitwebn\\src\\adobe\\Schemas\\Import-Libretto-1.0.0.xsd";

		System.out.println("nome file: " + fileName);
		try{
			FileReader fileReader = new FileReader(file);
			System.out.println("fileReader ok");
			String readFile = XmlBeanUtils.readFile(new FileReader(file));

			byte[] theXml = null;
			LibrettoDocument document = null;
			LibrettoCatasto richiesta = null;
			
			if(fileName.toLowerCase().startsWith(Constants.PREFIX_NOME_XSD_IMPORT_LIBRETTO.toLowerCase()))
			{
				System.out.println("lettura xml dell'allegato 2");
				//File xmlSchemaReader = new File(all2Schema);

				FileReader xmlSchemaReader = new FileReader(all2Schema);


				XmlValidator.validate(fileReader, xmlSchemaReader);
				theXml = XmlBeanUtils.readString(readFile);
				System.out.println("xml as byte[] readed");
				document = MapDto.mapToLibrettoDocument(theXml);
				System.out.println("convertito xml in java");
				richiesta = document.getLibretto().getLibrettoCatasto();
			}
			else
			{
				System.out.println("Nome file non conosciuto");
				throw new ValidationManagerException(new Message(Messages.S097, fileName));
			}

			validazioneL1SchedaIdentificativa(richiesta);

			validazioneL4Generatori(richiesta);
			
//			validazioneL5SistemiRegolazioneContabilizzazione(richiesta);
//			validazioneL6Pompa(richiesta);
//			validazioneL8Accumulo(richiesta);
//			validazioneL9TeRvScxCiUtRcx(richiesta);
//			validazioneL10VentilazioneMeccanica(richiesta);

			// Verifico i valori delle combo, non validati nei punti successivi
			validazioneComboXml(richiesta);

			System.out.println("Stampo il document prima del mapping: \n"+document);
			
			MODDocument modDoc = testGetModuloFittizio();
			margeLibrettoDocumentToMODDocument(modDoc, document);
			
			

			//			L5SistemiRegolazioneContabilizzazione l5SistRegCont = richiesta.getL5SistemiRegolazioneContabilizzazione();
			//			System.out.println("\n\n\nNEW\n");
			//			System.out.println(l5SistRegCont.getL51SRList());


		} catch (IOException e) {
			System.out.println("Errore: "+e);
			throw new ValidationManagerException(new Message(Messages.S096));
		} catch (XmlValidatorException e) {
			System.out.println("errore validazione xml"+ e);
			throw new ValidationManagerException(new Message(Messages.S098, fileName));
		} 
		catch (ServiceException e) {
			System.out.println("Errore: "+e);
			throw new ValidationManagerException(new Message(Messages.S096));
		} 
		finally
		{
			System.out.println("validazioneXmlImport END");
		}
	}


	private static void validazioneL1SchedaIdentificativa(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L1SchedaIdentificativa l1SchedaIdent = richiesta.getL1SchedaIdentificativa();

		/*
		if ((l1SchedaIdent.getL13ServizioACS() == null || l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType() == null || !l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType().getFlg()) &&
				(l1SchedaIdent.getL13ServizioClimaInv() == null || l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType() == null || !l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType().getFlg()) &&
				(l1SchedaIdent.getL13ServizioClimaEst() == null || l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType() == null || !l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType().getFlg()) &&
				(l1SchedaIdent.getL13ServizioAltro() == null || l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType() == null || !l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType().getFlg()))
		{
			throw new ValidationManagerException(new Message(Messages.S137, "L1_3"));
		}
		
		
		if (l1SchedaIdent.getL13ServizioACS() != null && 
				l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType() != null && 
				l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioACS().getFlgDecimaleType().getDecimale()))
		{
			throw new ValidationManagerException(new Message(Messages.S136, "L1_3servizioACS"));
		}
		
		if (l1SchedaIdent.getL13ServizioClimaInv() != null && 
				l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType() != null && 
				l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioClimaInv().getFlgDecimaleType().getDecimale()))
		{
			throw new ValidationManagerException(new Message(Messages.S136, "L1_3servizioClimaInv"));
		}
		
		if (l1SchedaIdent.getL13ServizioClimaEst() != null && 
				l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType() != null && 
				l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioClimaEst().getFlgDecimaleType().getDecimale()))
		{
			throw new ValidationManagerException(new Message(Messages.S136, "L1_3servizioClimaEst"));
		}
		
		
		if (l1SchedaIdent.getL13ServizioAltro() != null && 
				l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType() != null && 
				l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType().getFlg() &&
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL13ServizioAltro().getFlgDescrizioneType().getDescrizione()))
		{
			throw new ValidationManagerException(new Message(Messages.S135, "L1_3servizioAltro"));
		}
		*/
		
		if (!l1SchedaIdent.getL14FluidoAcqua() && !l1SchedaIdent.getL14FluidoAria() && GenericUtil.isNullOrEmpty(l1SchedaIdent.getL14FluidoAltro()))
		{
			throw new ValidationManagerException(new Message(Messages.S137, "L1_4"));
		}
				
		if (!l1SchedaIdent.getL15TipoGeneratore()  && !l1SchedaIdent.getL15TipoPompa() &&
				!l1SchedaIdent.getL15TipoFrigo()  && !l1SchedaIdent.getL15TipoTelerisc() && 
				!l1SchedaIdent.getL15TipoTeleraff()  && !l1SchedaIdent.getL15TipoCogen() && 
				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL15TipoAltro()))
		{
			throw new ValidationManagerException(new Message(Messages.S137, "L1_5"));
		}
		
//		if (l1SchedaIdent.getL15TipoIntegrazioneAltro() != null && 
//				l1SchedaIdent.getL15TipoIntegrazioneAltro().getFlgDescrizioneDecimaleType() != null && 
//				l1SchedaIdent.getL15TipoIntegrazioneAltro().getFlgDescrizioneDecimaleType().getFlg() &&
//				GenericUtil.isNullOrEmpty(l1SchedaIdent.getL15TipoIntegrazioneAltro().getFlgDescrizioneDecimaleType().getDescrizione()))
//		{
//			throw new ValidationManagerException(new Message(Messages.S135));
//		}
		
	}
	
	public static MODDocument margeLibrettoDocumentToMODDocument(MODDocument document, LibrettoDocument librettoImport)
	{
		System.out.println("[MapDto::margeLibrettoDocumentToMODDocument] start");

		Richiesta richiesta = document.getMOD().getRichiesta();

		LibrettoCatasto librettoCat = librettoImport.getLibretto().getLibrettoCatasto();
		
		MapDto.mapToSchedaIdentificativaImpiantoImport(richiesta.addNewDatiSchedaIdentificativaImp(), librettoCat.getL1SchedaIdentificativa());
		
		//MapDto.mapToL1SchedaIdentificativa
		
		//librettoCat.getL1SchedaIdentificativa().get
		
		L2TrattamentoAcqua l2TrattamentoAcqua = librettoCat.getL2TrattamentoAcqua();

		if (l2TrattamentoAcqua != null)
		{
			//MapDto.mapToSchedaTrattH2o(l2TrattamentoAcqua, richiesta.addNewDatiSchedaTrattH2O());
			MapDto.mapToL2TrattamentoAcquaImport(l2TrattamentoAcqua, richiesta.addNewDatiSchedaTrattH2O());
		}

		
		L4Generatori l4Generatori = librettoCat.getL4Generatori();
		
		if (l4Generatori != null)
		{
			MapDto.mapToL4GeneratoriSezGT(l4Generatori.getL41GTList(), richiesta.addNewDatiSchedaGT().addNewSezGruppiTermici());
			MapDto.mapToL4GeneratoriSezBR(l4Generatori.getL42BRList(), richiesta.addNewDatiSchedaBR().addNewSezBR());
			MapDto.mapToL4GeneratoriSezRC(l4Generatori.getL43RCList(), richiesta.addNewDatiSchedaRC().addNewSezRC());
			MapDto.mapToL4GeneratoriSezGF(l4Generatori.getL44GFList(), richiesta.addNewDatiSchedaGF().addNewSezGF());
			MapDto.mapToL4GeneratoriSezSC(l4Generatori.getL45SCList(), richiesta.addNewDatiSchedaSC().addNewSezSC());
			MapDto.mapToL4GeneratoriSezCG(l4Generatori.getL46CGList(), richiesta.addNewDatiSchedaCG().addNewSezCG());
			MapDto.mapToL4GeneratoriSezCS(l4Generatori.getL47CSList(), richiesta.addNewDatiSchedaCS().addNewSezCS());
			MapDto.mapToL4GeneratoriSezAG(l4Generatori.getL48AGList(), richiesta.addNewDatiSchedaAG().addNewSezAG());
		}
		
		L5SistemiRegolazioneContabilizzazione l5SistRegCont = librettoCat.getL5SistemiRegolazioneContabilizzazione();

		if (l5SistRegCont != null)
		{
			//5.1
			//MapDto.mapToSchedaSistemiRegolarizzazionePrimaria(richiesta.addNewDatiSchedaSistemiRegolaz().addNewRegolazionePrimaria(), compXSemplice);
			// 5.2 5.3 5.4
			//MapDto.mapToSchedaSistemiRegolarizzazioneSingoloAmbiente(richiesta.getDatiSchedaSistemiRegolaz().addNewRegolazioneSingoloAmb(), compXSemplice);
			// 5.1 5.2 5.3 5.4
			MapDto.mapToL5SistRegCont(l5SistRegCont, richiesta.addNewDatiSchedaSistemiRegolaz().addNewRegolazionePrimaria());
			MapDto.mapToL5SistRegCont(l5SistRegCont, richiesta.addNewDatiSchedaSistemiRegolaz().addNewRegolazioneSingoloAmb());

		}

		L6SistemiDistribuzione l6SistDistr = librettoCat.getL6SistemiDistribuzione();
		
		if (l6SistDistr != null)
		{
			MapDto.mapToL6SistDistribuzione(l6SistDistr, richiesta.addNewDatiSchedaSistemiDistrib());
		}

		L7SistemiEmissione l7SistEmiss = librettoCat.getL7SistemiEmissione();
		
		if (l7SistEmiss != null)
		{
			MapDto.mapToL7SistDistribuzione(l7SistEmiss, richiesta.addNewDatiSchedaSistemaEmissione());
		}
		
		L8SistemiAccumulo l8SistAcc = librettoCat.getL8SistemiAccumulo();
		
		if (l8SistAcc != null && l8SistAcc.getL81ACList() != null && l8SistAcc.getL81ACList().size() > 0)
		{
			MapDto.mapToL8SistAccSezAC(l8SistAcc.getL81ACList(), richiesta.addNewDatiSchedaSistemaAC().addNewSezAC());

		}
		
		L9AltriComponenti l9AltriComponenti = librettoCat.getL9AltriComponenti();
		
		if (l9AltriComponenti != null)
		{
			MapDto.mapToL9AltriCompSezTE(l9AltriComponenti.getL91TEList(), richiesta.addNewDatiAltriComponentiTE().addNewSezTE());
			MapDto.mapToL9AltriCompSezRV(l9AltriComponenti.getL92RVList(), richiesta.addNewDatiAltriComponentiRV().addNewSezRV());
			MapDto.mapToL9AltriCompSezSC(l9AltriComponenti.getL93SCXList(), richiesta.addNewDatiAltriComponentiSC().addNewSezSC());
			MapDto.mapToL9AltriCompSezCI(l9AltriComponenti.getL94CIList(), richiesta.addNewDatiAltriComponentiCI().addNewSezCI());
			MapDto.mapToL9AltriCompSezUT(l9AltriComponenti.getL95UTList(), richiesta.addNewDatiAltriComponentiUT().addNewSezUT());
			MapDto.mapToL9AltriCompSezRC(l9AltriComponenti.getL96RCXList(), richiesta.addNewDatiAltriComponentiRC().addNewSezRC());
		}

		L10Ventilazione l10Ventilazione = librettoCat.getL10Ventilazione();
		if (l10Ventilazione != null)
		{
			MapDto.mapToL10VentilazioneSezVM(l10Ventilazione.getL101VMList(), richiesta.addNewDatiVentilazMeccanicaVM().addNewSezVM());
		}
		
		L14Consumi l14Consumi = librettoCat.getL14Consumi();
		
		if (l14Consumi != null)
		{
			MapDto.mapToL14ConsumiSezCombu(l14Consumi.getL141ConsumoCombustibileList(), richiesta.addNewDatiConsumoCombu().addNewSezCombu());
			MapDto.mapToL14ConsumiSezEE(l14Consumi.getL142ConsumoEnergiaElettrica(), richiesta.addNewDatiConsumoEE().addNewSezConsumo());
			MapDto.mapToL14ConsumiSezH2O(l14Consumi.getL143ConsumoAcqua(), richiesta.addNewDatiConsumoH2O());
			MapDto.mapToL14ConsumiSezPChim(l14Consumi.getL144ConsumoProdottiChimici(), richiesta.addNewDatiConsumoProdottiChimici().addNewSezConsumo());
		}
		
		//xxxxx
		
		System.out.println("\n\nStampo il DOCUMENT definitivo: ");
		System.out.println(document);

		System.out.println("[MapDto::margeLibrettoDocumentToMODDocument] end");
		return document;
	}

	private static void validazioneComboXml(LibrettoCatasto richiesta) throws ValidationManagerException
	{

		L14Consumi l14Consumi = richiesta.getL14Consumi();
		
		if (l14Consumi != null)
		{
		List<L141ConsumoCombustibile> l141ConCombList = l14Consumi.getL141ConsumoCombustibileList();

		for (L141ConsumoCombustibile l141ConsumoCombustibile : l141ConCombList) {

			validazioneCombustibile(l141ConsumoCombustibile.getL141Combustibile());

			validazioneUnitaMisura(l141ConsumoCombustibile.getL141UnitaMisura());

		}


		if (l14Consumi.getL143ConsumoAcqua() != null)
		{
			validazioneUnitaMisura(l14Consumi.getL143ConsumoAcqua().getL143UnitaMisura());

		}
//		List<L143ConsumoAcqua> l143ConsumoAcquaList = l14Consumi.getL143ConsumoAcqua();
//		for (L143ConsumoAcqua l143ConsumoAcqua : l143ConsumoAcquaList) {
//
//			validazioneUnitaMisura(l143ConsumoAcqua.getL143UnitaMisura());
//
//		}

		if (l14Consumi.getL144ConsumoProdottiChimici() != null)
		{
			List<L144DatiConsumoProdottiChimici> l144DatiConsumoProdChimiciList = l14Consumi.getL144ConsumoProdottiChimici().getL144DatiConsumoProdottiChimiciList();
			for (L144DatiConsumoProdottiChimici l144DatiConsumoProdChimici : l144DatiConsumoProdChimiciList) {

				validazioneUnitaMisura(l144DatiConsumoProdChimici.getL144UnitaMisura());

			}
		}
		}
	}



	private static void validazioneCombustibile(int idCombustibile) throws ValidationManagerException
	{
		DbMgr db = new DbMgr();
//		try
//		{
//			if (db.getCombustibileById(idCombustibile) == null)
//			{
//				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_COMBUSTIBILE, ConvertUtil.convertToString(idCombustibile)));
//			}
//		} catch (DbManagerException e) {
//			System.out.println("Errore: "+e);
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
//		} 
	}

	private static void validazioneUnitaMisura(int idUnitaMisura) throws ValidationManagerException
	{
		DbMgr db = new DbMgr();
//		try
//		{
//			if (db.getUnitaMisuraById(idUnitaMisura) == null)
//			{
//				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_UNITA_MISURA, ConvertUtil.convertToString(idUnitaMisura)));
//			}
//		} catch (DbManagerException e) {
//			System.out.println("Errore: "+e);
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
//		} 
	}

	private static void validazioneMarca(int idMarca) throws ValidationManagerException
	{
		DbMgr db = new DbMgr();
//		try
//		{
//			if (db.getMarcaById(idMarca) == null)
//			{
//				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_MARCA, ConvertUtil.convertToString(idMarca)));
//			}
//		} catch (DbManagerException e) {
//			System.out.println("Errore: "+e);
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
//		} 
	}

	private static void validazioneFluido(int idFluido) throws ValidationManagerException
	{
		DbMgr db = new DbMgr();
//		try
//		{
//			if (db.getFluidoById(idFluido) == null)
//			{
//				throw new ValidationManagerException(new Message(Messages.S133, Constants.DESC_TABELLA_FLUIDO, ConvertUtil.convertToString(idFluido)));
//			}
//		} catch (DbManagerException e) {
//			System.out.println("Errore: "+e);
//			throw new ValidationManagerException(new Message(Messages.ERROR_RECUPERO_SERVIZIO));
//		} 
	}

	private static void validazioneL4Generatori(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L4Generatori l4Generatori = richiesta.getL4Generatori();

		// L4_1GT - L4_2BR - L4_3RC
		validazioneL4GtBrRc(l4Generatori);

		//validazioneL4GfScCgCsAg(l4Generatori);
	}

	private static void validazioneL4GtBrRc(L4Generatori l4Generatori) throws ValidationManagerException
	{
		// Devo verificare le date
		// devo ordinare le sostituite per data installazione

		// L4_generatori

		if (l4Generatori != null)
		{

			List<L41GT> l41GTList = l4Generatori.getL41GTList();
			List<L42BR> l42BRList = l4Generatori.getL42BRList();
			List<L43RC> l43RCList = l4Generatori.getL43RCList();

			String numComponente = null;
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			// Devo verificare che gli elementi BR E RC abbiano come riferimento un GT presente nel'xml

			boolean isPresente = false;
			int gtCollegato = 0;
			int numeroComp = 0;
			if (l42BRList != null && l42BRList.size() > 0)
			{
				for (L42BR l42BR : l42BRList) {

					numeroComp = l42BR.getL42Numero().intValue();

					// Recupero il GT collegato
					gtCollegato = l42BR.getL42GtCollegato().intValue();

					// Ciclo per tutti i GT, per cercare quello collegato
					for (L41GT l41GT : l41GTList) {
						if (gtCollegato == l41GT.getL41Numero().intValue())
						{
							isPresente = true;
							break;
						}
					}

					if (!isPresente)
					{
						throw new ValidationManagerException(new Message(Messages.S132, ConvertUtil.convertToString(numeroComp), ConvertUtil.convertToString(gtCollegato)));
					}
				}
			}


			if (l43RCList != null && l43RCList.size() > 0)
			{
				isPresente = false;
				gtCollegato = 0;
				numeroComp = 0;

				for (L43RC l43RC : l43RCList) {

					numeroComp = l43RC.getL43Numero().intValue();

					// Recupero il GT collegato
					gtCollegato = l43RC.getL43GtCollegato().intValue();

					// Ciclo per tutti i GT, per cercare quello collegato
					for (L41GT l41GT : l41GTList) {
						if (gtCollegato == l41GT.getL41Numero().intValue())
						{
							isPresente = true;
							break;
						}
					}

					if (!isPresente)
					{
						throw new ValidationManagerException(new Message(Messages.S132, ConvertUtil.convertToString(numeroComp), ConvertUtil.convertToString(gtCollegato)));
					}
				}
			}

			// Verificao che ci siano delle GT
			if (l41GTList != null && l41GTList.size() > 0)
			{
				for (L41GT l41Gt : l41GTList) 
				{

					numComponente = ConvertUtil.convertToString(l41Gt.getL41Numero());

					L41GruppoTermico l41GruppoTermico =l41Gt.getL41GruppoTermico();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermico.getL41DataInstallazione(), l41GruppoTermico.getL41DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l41GruppoTermico.getL41Fabbricante());
					validazioneCombustibile(l41GruppoTermico.getL41Combustibile());
					validazioneFluido(l41GruppoTermico.getL41Fluido());
					
					/*
					if (!l1SchedaIdent.getL15TipoGeneratore()  && !l1SchedaIdent.getL15TipoPompa() &&
							!l1SchedaIdent.getL15TipoFrigo()  && !l1SchedaIdent.getL15TipoTelerisc() && 
							!l1SchedaIdent.getL15TipoTeleraff()  && !l1SchedaIdent.getL15TipoCogen() && 
							(l1SchedaIdent.getL15TipoAltro() == null || l1SchedaIdent.getL15TipoAltro().getFlgDescrizioneType() == null || !l1SchedaIdent.getL15TipoAltro().getFlgDescrizioneType().getFlg()))
					{
						throw new ValidationManagerException(new Message(Messages.S137, "L1_5"));
					}
					*/
					
					List<L41GruppoTermicoSostituito> l41GruppoTermicoSostListOrig = l41Gt.getL41GruppoTermicoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l41GruppoTermicoSostListOrig != null && l41GruppoTermicoSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
						for (int i = 0; i < l41GruppoTermicoSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l41GruppoTermicoSostListOrig.get(i).getL41DataInstallazione())));
						}

						/*
									System.out.println("\n\nPrima l'ordinamento - inizio");
									System.out.println("#######################");
									for (ComparatorDto l51SistRegSost : compList) {

										System.out.println(l51SistRegSost.getData() + " - " +l51SistRegSost.getIdData());
									}
									System.out.println("#######################");
									System.out.println("Prima l'ordinamento - fine\n\n");
						 */

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

						/*
									System.out.println("#######################");
									for (ComparatorDto l51SistRegSost : compList) {

										System.out.println(l51SistRegSost.getData() + " - " +l51SistRegSost.getIdData());
									}
									System.out.println("#######################");
						 */

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L41GruppoTermicoSostituito[] l41GruppoTermicoSostArray = new L41GruppoTermicoSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l41GruppoTermicoSostArray[i] = l41GruppoTermicoSostListOrig.get(compList.get(i).getIdData());

						}


						/*
									// STAMPO la lista ordinata originale
									for (L51SistemaRegolazioneSostituito l51SistemaRegolazioneSostituito : l51SistRegSostListNew) {

										//System.out.println(l51SistemaRegolazioneSostituito.getL51DataInstallazione() + " - " + l51SistemaRegolazioneSostituito.getL51DataDismissione());
										System.out.println(l51SistemaRegolazioneSostituito);
									}
						 */

						//Risetto l'array ordinato
						l41Gt.setL41GruppoTermicoSostituitoArray(l41GruppoTermicoSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L41GruppoTermicoSostituito> l41GruppoTermicoSostListNew = l41Gt.getL41GruppoTermicoSostituitoList();

						/*
									System.out.println("\n\nprima del controllo dell'oggetto originale modificato - inizio");

									// STAMPO l'ordinamento
									for (L51SistemaRegolazioneSostituito l51SistemaRegolazioneSostituito : l51SistRegSostListNew) {

										//System.out.println(l51SistemaRegolazioneSostituito.getL51DataInstallazione() + " - " + l51SistemaRegolazioneSostituito.getL51DataDismissione());
										System.out.println(l51SistemaRegolazioneSostituito);
									}

									System.out.println("Dopo del controllo dell'oggetto originale modificato - fine\n\n");
						 */


						int listSize = l41GruppoTermicoSostListNew.size();

						//							System.out.println("l51SistRegSostArray.length: "+l51SistRegSostArray.length);

						for (int i = 0; i < listSize; i++) {

							L41GruppoTermicoSostituito l41GruppoTermicoSost = l41GruppoTermicoSostListNew.get(i);

//							System.out.println("prima");
//							GenericUtil.stampa(l41GruppoTermicoSost, false, 3);
//
//							System.out.println("l41GruppoTermicoSost: "+l41GruppoTermicoSost.getL41DataDismissione());

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSost.getL41DataDismissione(), l41GruppoTermico.getL41DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSost.getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSostListNew.get(i+1).getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataDismissione());
								
								validazioneDataInstSuccDataInstImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSostListNew.get(i+1).getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataInstallazione());
								validazioneDataDismisSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_GT, numComponente, l41GruppoTermicoSostListNew.get(i+1).getL41DataDismissione(), l41GruppoTermicoSost.getL41DataDismissione());
								
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l41GruppoTermicoSost.getL41Fabbricante());
							validazioneCombustibile(l41GruppoTermicoSost.getL41Combustibile());
							validazioneFluido(l41GruppoTermicoSost.getL41Fluido());
						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// DEVO CONSIDERARE CHE GLI ELEMENTI BR E RC HANNO DEI PUNTAMENTI CON IL GT (quindi devo verificare che il numero dei BR e RC sia corrispondente ad uno presente nei GT)

				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L41GruppoTermicoSostituito non funziona
				for (int j = 0; j < l41GTList.size(); j++) {
					compList.add(new ComparatorDto(j, l41GTList.get(j).getL41Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L41GT ordinati
				L41GT[] l41GTArray = new L41GT[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l41GTArray[i] = l41GTList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL41GTArray(l41GTArray);

				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L41GT> l41GTListNew = l4Generatori.getL41GTList();


				// Devo rinominare il progressivo (L41Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				// Devo rinominare anche le componenti BR e RC collegate al GT che sto rinominando
				int count = 1; 
				int numeroCompGtOld = 0;
				for (L41GT l51Sr : l41GTListNew) {
					numeroCompGtOld = l51Sr.getL41Numero().intValue();

					for (L42BR l42Br : l42BRList) {

						if (l42Br.getL42GtCollegato().intValue() == numeroCompGtOld)
						{
							l42Br.setL42GtCollegato(ConvertUtil.convertToBigInteger(count));
						}
					}

					for (L43RC l43Rc : l43RCList) {

						if (l43Rc.getL43GtCollegato().intValue() == numeroCompGtOld)
						{
							l43Rc.setL43GtCollegato(ConvertUtil.convertToBigInteger(count));
						}
					}

					l51Sr.setL41Numero(ConvertUtil.convertToBigInteger(count++));
				}

//				System.out.println("l4Generatori.getL41GTList()");
//				System.out.println(l4Generatori.getL41GTList());

			}


			// Verificao che ci siano delle BR
			if (l42BRList != null && l42BRList.size() > 0)
			{
				for (L42BR l42Br : l42BRList) 
				{

					numComponente = ConvertUtil.convertToString(l42Br.getL42Numero());

					L42Bruciatore l42Bruciatore =l42Br.getL42Bruciatore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42Bruciatore.getL42DataInstallazione(), l42Bruciatore.getL42DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l42Bruciatore.getL42Fabbricante());
					validazioneCombustibile(l42Bruciatore.getL42Combustibile());

					List<L42BruciatoreSostituito> l42BruciatoreSostListOrig = l42Br.getL42BruciatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l42BruciatoreSostListOrig != null && l42BruciatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l42BruciatoreSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l42BruciatoreSostListOrig.get(i).getL42DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L42BruciatoreSostituito[] l42BruciatoreSostArray = new L42BruciatoreSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l42BruciatoreSostArray[i] = l42BruciatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l42Br.setL42BruciatoreSostituitoArray(l42BruciatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L42BruciatoreSostituito> l42BruciatoreSostListNew = l42Br.getL42BruciatoreSostituitoList();

						int listSize = l42BruciatoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L42BruciatoreSostituito l42BruciatoreSost = l42BruciatoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSost.getL42DataDismissione(), l42Bruciatore.getL42DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSost.getL42DataInstallazione(), l42BruciatoreSost.getL42DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_BR, numComponente, l42BruciatoreSostListNew.get(i+1).getL42DataInstallazione(), l42BruciatoreSost.getL42DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l42BruciatoreSost.getL42Fabbricante());
							validazioneCombustibile(l42BruciatoreSost.getL42Combustibile());
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L42BruciatoreSostituito non funziona
				for (int j = 0; j < l42BRList.size(); j++) {
					compList.add(new ComparatorDto(j, l42BRList.get(j).getL42Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L42BR ordinati
				L42BR[] l42BRArray = new L42BR[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l42BRArray[i] = l42BRList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL42BRArray(l42BRArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L42BR> l42BRListNew = l4Generatori.getL42BRList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L42BR l42Br : l42BRListNew) {

					l42Br.setL42Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle RC
			if (l43RCList != null && l43RCList.size() > 0)
			{
				for (L43RC l43Rc : l43RCList) 
				{

					numComponente = ConvertUtil.convertToString(l43Rc.getL43Numero());

					L43Recuperatore l43Recuperatore =l43Rc.getL43Recuperatore();

					validazioneDataInstDataDismisSePresImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43Recuperatore.getL43DataInstallazione(), l43Recuperatore.getL43DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l43Recuperatore.getL43Fabbricante());

					List<L43RecuperatoreSostituito> l43RecuperatoreSostListOrig = l43Rc.getL43RecuperatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l43RecuperatoreSostListOrig != null && l43RecuperatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L43RecuperatoreSostituito non funziona
						for (int i = 0; i < l43RecuperatoreSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l43RecuperatoreSostListOrig.get(i).getL43DataInstallazione())));
						}



						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L43RecuperatoreSostituito[] l43RecuperatoreSostArray = new L43RecuperatoreSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l43RecuperatoreSostArray[i] = l43RecuperatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l43Rc.setL43RecuperatoreSostituitoArray(l43RecuperatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L43RecuperatoreSostituito> l43RecuperatoreSostListNew = l43Rc.getL43RecuperatoreSostituitoList();




						int listSize = l43RecuperatoreSostListNew.size();

						//	System.out.println("l43RecuperatoreSostArray.length: "+l43RecuperatoreSostArray.length);

						for (int i = 0; i < listSize; i++) {

							L43RecuperatoreSostituito l43RecuperatoreSost = l43RecuperatoreSostListNew.get(i);

//							System.out.println("prima");
//							GenericUtil.stampa(l43RecuperatoreSost, false, 3);
//
//							System.out.println("l51SistRegSost: "+l43RecuperatoreSost.getL43DataDismissione());

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSost.getL43DataDismissione(), l43Recuperatore.getL43DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSost.getL43DataInstallazione(), l43RecuperatoreSost.getL43DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(Constants.TIPO_COMPONENTE_RC, numComponente, l43RecuperatoreSostListNew.get(i+1).getL43DataInstallazione(), l43RecuperatoreSost.getL43DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l43RecuperatoreSost.getL43Fabbricante());

						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// DEVO CONSIDERARE CHE GLI ELEMENTI BR E RC HANNO DEI PUNTAMENTI CON IL GT (quindi devo verificare che il numero dei BR e RC sia corrispondente ad uno presente nei GT)

				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
				for (int j = 0; j < l43RCList.size(); j++) {
					compList.add(new ComparatorDto(j, l43RCList.get(j).getL43Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L51SR ordinati
				L43RC[] l43RCArray = new L43RC[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l43RCArray[i] = l43RCList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL43RCArray(l43RCArray);

				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L43RC> l43RCListNew = l4Generatori.getL43RCList();


				// Devo rinominare il progressivo (L51Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L43RC l43Rc : l43RCListNew) {

					l43Rc.setL43Numero(ConvertUtil.convertToBigInteger(count++));
				}

//				System.out.println("l4Generatori.getL43RCList()");
//				System.out.println(l4Generatori.getL43RCList());

			}
		}
	}
	
	private static void validazioneL4GtBrRcOld(L4Generatori l4Generatori) throws ValidationManagerException
	{
		// Devo verificare le date
		// devo ordinare le sostituite per data installazione

		// L4_generatori

		if (l4Generatori != null)
		{

			List<L41GT> l41GTList = l4Generatori.getL41GTList();
			List<L42BR> l42BRList = l4Generatori.getL42BRList();
			List<L43RC> l43RCList = l4Generatori.getL43RCList();

			String numComponente = null;
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			// Devo verificare che gli elementi BR E RC abbiano come riferimento un GT presente nel'xml

			boolean isPresente = false;
			int gtCollegato = 0;
			int numeroComp = 0;
			if (l42BRList != null && l42BRList.size() > 0)
			{
				for (L42BR l42BR : l42BRList) {

					numeroComp = l42BR.getL42Numero().intValue();

					// Recupero il GT collegato
					gtCollegato = l42BR.getL42GtCollegato().intValue();

					// Ciclo per tutti i GT, per cercare quello collegato
					for (L41GT l41GT : l41GTList) {
						if (gtCollegato == l41GT.getL41Numero().intValue())
						{
							isPresente = true;
							break;
						}
					}

					if (!isPresente)
					{
						throw new ValidationManagerException(new Message(Messages.S132, ConvertUtil.convertToString(numeroComp), ConvertUtil.convertToString(gtCollegato)));
					}
				}
			}


			if (l43RCList != null && l43RCList.size() > 0)
			{
				isPresente = false;
				gtCollegato = 0;
				numeroComp = 0;

				for (L43RC l43RC : l43RCList) {

					numeroComp = l43RC.getL43Numero().intValue();

					// Recupero il GT collegato
					gtCollegato = l43RC.getL43GtCollegato().intValue();

					// Ciclo per tutti i GT, per cercare quello collegato
					for (L41GT l41GT : l41GTList) {
						if (gtCollegato == l41GT.getL41Numero().intValue())
						{
							isPresente = true;
							break;
						}
					}

					if (!isPresente)
					{
						throw new ValidationManagerException(new Message(Messages.S132, ConvertUtil.convertToString(numeroComp), ConvertUtil.convertToString(gtCollegato)));
					}
				}
			}

			// Verificao che ci siano delle GT
			if (l41GTList != null && l41GTList.size() > 0)
			{
				for (L41GT l41Gt : l41GTList) 
				{

					numComponente = ConvertUtil.convertToString(l41Gt.getL41Numero());

					L41GruppoTermico l41GruppoTermico =l41Gt.getL41GruppoTermico();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l41GruppoTermico.getL41DataInstallazione(), l41GruppoTermico.getL41DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l41GruppoTermico.getL41Fabbricante());
					validazioneCombustibile(l41GruppoTermico.getL41Combustibile());
					validazioneFluido(l41GruppoTermico.getL41Fluido());

					List<L41GruppoTermicoSostituito> l41GruppoTermicoSostListOrig = l41Gt.getL41GruppoTermicoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l41GruppoTermicoSostListOrig != null && l41GruppoTermicoSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
						for (int i = 0; i < l41GruppoTermicoSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l41GruppoTermicoSostListOrig.get(i).getL41DataInstallazione())));
						}

						/*
									System.out.println("\n\nPrima l'ordinamento - inizio");
									System.out.println("#######################");
									for (ComparatorDto l51SistRegSost : compList) {

										System.out.println(l51SistRegSost.getData() + " - " +l51SistRegSost.getIdData());
									}
									System.out.println("#######################");
									System.out.println("Prima l'ordinamento - fine\n\n");
						 */

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

						/*
									System.out.println("#######################");
									for (ComparatorDto l51SistRegSost : compList) {

										System.out.println(l51SistRegSost.getData() + " - " +l51SistRegSost.getIdData());
									}
									System.out.println("#######################");
						 */

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L41GruppoTermicoSostituito[] l41GruppoTermicoSostArray = new L41GruppoTermicoSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l41GruppoTermicoSostArray[i] = l41GruppoTermicoSostListOrig.get(compList.get(i).getIdData());

						}


						/*
									// STAMPO la lista ordinata originale
									for (L51SistemaRegolazioneSostituito l51SistemaRegolazioneSostituito : l51SistRegSostListNew) {

										//System.out.println(l51SistemaRegolazioneSostituito.getL51DataInstallazione() + " - " + l51SistemaRegolazioneSostituito.getL51DataDismissione());
										System.out.println(l51SistemaRegolazioneSostituito);
									}
						 */

						//Risetto l'array ordinato
						l41Gt.setL41GruppoTermicoSostituitoArray(l41GruppoTermicoSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L41GruppoTermicoSostituito> l41GruppoTermicoSostListNew = l41Gt.getL41GruppoTermicoSostituitoList();

						/*
									System.out.println("\n\nprima del controllo dell'oggetto originale modificato - inizio");

									// STAMPO l'ordinamento
									for (L51SistemaRegolazioneSostituito l51SistemaRegolazioneSostituito : l51SistRegSostListNew) {

										//System.out.println(l51SistemaRegolazioneSostituito.getL51DataInstallazione() + " - " + l51SistemaRegolazioneSostituito.getL51DataDismissione());
										System.out.println(l51SistemaRegolazioneSostituito);
									}

									System.out.println("Dopo del controllo dell'oggetto originale modificato - fine\n\n");
						 */


						int listSize = l41GruppoTermicoSostListNew.size();

						//							System.out.println("l51SistRegSostArray.length: "+l51SistRegSostArray.length);

						for (int i = 0; i < listSize; i++) {

							L41GruppoTermicoSostituito l41GruppoTermicoSost = l41GruppoTermicoSostListNew.get(i);

							//System.out.println("prima");
							//GenericUtil.stampa(l41GruppoTermicoSost, false, 3);

							//System.out.println("l41GruppoTermicoSost: "+l41GruppoTermicoSost.getL41DataDismissione());

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l41GruppoTermicoSost.getL41DataDismissione(), l41GruppoTermico.getL41DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l41GruppoTermicoSost.getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l41GruppoTermicoSostListNew.get(i+1).getL41DataInstallazione(), l41GruppoTermicoSost.getL41DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l41GruppoTermicoSost.getL41Fabbricante());
							validazioneCombustibile(l41GruppoTermicoSost.getL41Combustibile());
							validazioneFluido(l41GruppoTermicoSost.getL41Fluido());
						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// DEVO CONSIDERARE CHE GLI ELEMENTI BR E RC HANNO DEI PUNTAMENTI CON IL GT (quindi devo verificare che il numero dei BR e RC sia corrispondente ad uno presente nei GT)

				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L41GruppoTermicoSostituito non funziona
				for (int j = 0; j < l41GTList.size(); j++) {
					compList.add(new ComparatorDto(j, l41GTList.get(j).getL41Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L41GT ordinati
				L41GT[] l41GTArray = new L41GT[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l41GTArray[i] = l41GTList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL41GTArray(l41GTArray);

				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L41GT> l41GTListNew = l4Generatori.getL41GTList();


				// Devo rinominare il progressivo (L41Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				// Devo rinominare anche le componenti BR e RC collegate al GT che sto rinominando
				int count = 1; 
				int numeroCompGtOld = 0;
				for (L41GT l51Sr : l41GTListNew) {
					numeroCompGtOld = l51Sr.getL41Numero().intValue();

					for (L42BR l42Br : l42BRList) {

						if (l42Br.getL42GtCollegato().intValue() == numeroCompGtOld)
						{
							l42Br.setL42GtCollegato(ConvertUtil.convertToBigInteger(count));
						}
					}

					for (L43RC l43Rc : l43RCList) {

						if (l43Rc.getL43GtCollegato().intValue() == numeroCompGtOld)
						{
							l43Rc.setL43GtCollegato(ConvertUtil.convertToBigInteger(count));
						}
					}

					l51Sr.setL41Numero(ConvertUtil.convertToBigInteger(count++));
				}

				//System.out.println("l4Generatori.getL41GTList()");
				//System.out.println(l4Generatori.getL41GTList());

			}


			// Verificao che ci siano delle BR
			if (l42BRList != null && l42BRList.size() > 0)
			{
				for (L42BR l42Br : l42BRList) 
				{

					numComponente = ConvertUtil.convertToString(l42Br.getL42Numero());

					L42Bruciatore l42Bruciatore =l42Br.getL42Bruciatore();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l42Bruciatore.getL42DataInstallazione(), l42Bruciatore.getL42DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l42Bruciatore.getL42Fabbricante());
					validazioneCombustibile(l42Bruciatore.getL42Combustibile());

					List<L42BruciatoreSostituito> l42BruciatoreSostListOrig = l42Br.getL42BruciatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l42BruciatoreSostListOrig != null && l42BruciatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l42BruciatoreSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l42BruciatoreSostListOrig.get(i).getL42DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L42BruciatoreSostituito[] l42BruciatoreSostArray = new L42BruciatoreSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l42BruciatoreSostArray[i] = l42BruciatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l42Br.setL42BruciatoreSostituitoArray(l42BruciatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L42BruciatoreSostituito> l42BruciatoreSostListNew = l42Br.getL42BruciatoreSostituitoList();

						int listSize = l42BruciatoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L42BruciatoreSostituito l42BruciatoreSost = l42BruciatoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l42BruciatoreSost.getL42DataDismissione(), l42Bruciatore.getL42DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l42BruciatoreSost.getL42DataInstallazione(), l42BruciatoreSost.getL42DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l42BruciatoreSostListNew.get(i+1).getL42DataInstallazione(), l42BruciatoreSost.getL42DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l42BruciatoreSost.getL42Fabbricante());
							validazioneCombustibile(l42BruciatoreSost.getL42Combustibile());
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L42BruciatoreSostituito non funziona
				for (int j = 0; j < l42BRList.size(); j++) {
					compList.add(new ComparatorDto(j, l42BRList.get(j).getL42Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L42BR ordinati
				L42BR[] l42BRArray = new L42BR[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l42BRArray[i] = l42BRList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL42BRArray(l42BRArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L42BR> l42BRListNew = l4Generatori.getL42BRList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L42BR l42Br : l42BRListNew) {

					l42Br.setL42Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle RC
			if (l43RCList != null && l43RCList.size() > 0)
			{
				for (L43RC l43Rc : l43RCList) 
				{

					numComponente = ConvertUtil.convertToString(l43Rc.getL43Numero());

					L43Recuperatore l43Recuperatore =l43Rc.getL43Recuperatore();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l43Recuperatore.getL43DataInstallazione(), l43Recuperatore.getL43DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l43Recuperatore.getL43Fabbricante());

					List<L43RecuperatoreSostituito> l43RecuperatoreSostListOrig = l43Rc.getL43RecuperatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l43RecuperatoreSostListOrig != null && l43RecuperatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L43RecuperatoreSostituito non funziona
						for (int i = 0; i < l43RecuperatoreSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l43RecuperatoreSostListOrig.get(i).getL43DataInstallazione())));
						}



						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L43RecuperatoreSostituito[] l43RecuperatoreSostArray = new L43RecuperatoreSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l43RecuperatoreSostArray[i] = l43RecuperatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l43Rc.setL43RecuperatoreSostituitoArray(l43RecuperatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L43RecuperatoreSostituito> l43RecuperatoreSostListNew = l43Rc.getL43RecuperatoreSostituitoList();




						int listSize = l43RecuperatoreSostListNew.size();

						//	System.out.println("l43RecuperatoreSostArray.length: "+l43RecuperatoreSostArray.length);

						for (int i = 0; i < listSize; i++) {

							L43RecuperatoreSostituito l43RecuperatoreSost = l43RecuperatoreSostListNew.get(i);

							//System.out.println("prima");
							//GenericUtil.stampa(l43RecuperatoreSost, false, 3);

							//System.out.println("l51SistRegSost: "+l43RecuperatoreSost.getL43DataDismissione());

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l43RecuperatoreSost.getL43DataDismissione(), l43Recuperatore.getL43DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l43RecuperatoreSost.getL43DataInstallazione(), l43RecuperatoreSost.getL43DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l43RecuperatoreSostListNew.get(i+1).getL43DataInstallazione(), l43RecuperatoreSost.getL43DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l43RecuperatoreSost.getL43Fabbricante());

						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// DEVO CONSIDERARE CHE GLI ELEMENTI BR E RC HANNO DEI PUNTAMENTI CON IL GT (quindi devo verificare che il numero dei BR e RC sia corrispondente ad uno presente nei GT)

				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
				for (int j = 0; j < l43RCList.size(); j++) {
					compList.add(new ComparatorDto(j, l43RCList.get(j).getL43Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L51SR ordinati
				L43RC[] l43RCArray = new L43RC[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l43RCArray[i] = l43RCList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL43RCArray(l43RCArray);

				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L43RC> l43RCListNew = l4Generatori.getL43RCList();


				// Devo rinominare il progressivo (L51Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L43RC l43Rc : l43RCListNew) {

					l43Rc.setL43Numero(ConvertUtil.convertToBigInteger(count++));
				}

				//System.out.println("l4Generatori.getL43RCList()");
				//System.out.println(l4Generatori.getL43RCList());

			}
		}
	}

	private static void validazioneL4GfScCgCsAg(L4Generatori l4Generatori) throws ValidationManagerException
	{
		// Devo verificare le date
		// devo ordinare le sostituite per data installazione

		// L4_generatori

		if (l4Generatori != null)
		{

			List<L44GF> l44GFList = l4Generatori.getL44GFList();
			List<L45SC> l45SCList = l4Generatori.getL45SCList();
			List<L46CG> l46CGList = l4Generatori.getL46CGList();
			List<L47CS> l47CSList = l4Generatori.getL47CSList();
			List<L48AG> l48AGList = l4Generatori.getL48AGList();

			String numComponente = null;
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			// Verificao che ci siano delle GF
			if (l44GFList != null && l44GFList.size() > 0)
			{
				for (L44GF l44Gf : l44GFList) 
				{

					numComponente = ConvertUtil.convertToString(l44Gf.getL44Numero());

					L44GruppoFrigo l44GruppoFrigo =l44Gf.getL44GruppoFrigo();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l44GruppoFrigo.getL44DataInstallazione(), l44GruppoFrigo.getL44DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l44GruppoFrigo.getL44Fabbricante());


					if (GenericUtil.isNotNullOrEmpty(l44GruppoFrigo.getL44CombustibileAssorbimentoFiammaDiretta()))
					{
						validazioneCombustibile(l44GruppoFrigo.getL44CombustibileAssorbimentoFiammaDiretta());
					}


					List<L44GruppoFrigoSostituito> l44GruppoFrigoSostListOrig = l44Gf.getL44GruppoFrigoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l44GruppoFrigoSostListOrig != null && l44GruppoFrigoSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l44GruppoFrigoSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l44GruppoFrigoSostListOrig.get(i).getL44DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L44GruppoFrigoSostituito[] l44GruppoFrigoSostArray = new L44GruppoFrigoSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l44GruppoFrigoSostArray[i] = l44GruppoFrigoSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l44Gf.setL44GruppoFrigoSostituitoArray(l44GruppoFrigoSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L44GruppoFrigoSostituito> l44GruppoFrigoSostListNew = l44Gf.getL44GruppoFrigoSostituitoList();

						int listSize = l44GruppoFrigoSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L44GruppoFrigoSostituito l44GruppoFrigoSost = l44GruppoFrigoSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l44GruppoFrigoSost.getL44DataDismissione(), l44GruppoFrigo.getL44DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l44GruppoFrigoSost.getL44DataInstallazione(), l44GruppoFrigoSost.getL44DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l44GruppoFrigoSostListNew.get(i+1).getL44DataInstallazione(), l44GruppoFrigoSost.getL44DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l44GruppoFrigoSost.getL44Fabbricante());

							if (GenericUtil.isNotNullOrEmpty(l44GruppoFrigoSost.getL44CombustibileAssorbimentoFiammaDiretta()))
							{
								validazioneCombustibile(l44GruppoFrigoSost.getL44CombustibileAssorbimentoFiammaDiretta());
							}
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L44GruppoFrigoSostituito non funziona
				for (int j = 0; j < l44GFList.size(); j++) {
					compList.add(new ComparatorDto(j, l44GFList.get(j).getL44Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L44GF ordinati
				L44GF[] l44GFArray = new L44GF[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l44GFArray[i] = l44GFList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL44GFArray(l44GFArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L44GF> l44GFListNew = l4Generatori.getL44GFList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L44GF l44Gf : l44GFListNew) {

					l44Gf.setL44Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle SC
			if (l45SCList != null && l45SCList.size() > 0)
			{
				for (L45SC l45Sc : l45SCList) 
				{

					numComponente = ConvertUtil.convertToString(l45Sc.getL45Numero());

					L45Scambiatore l45Scambiatore =l45Sc.getL45Scambiatore();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l45Scambiatore.getL45DataInstallazione(), l45Scambiatore.getL45DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l45Scambiatore.getL45Fabbricante());

					List<L45ScambiatoreSostituito> l45ScambiatoreSostListOrig = l45Sc.getL45ScambiatoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l45ScambiatoreSostListOrig != null && l45ScambiatoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l45ScambiatoreSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l45ScambiatoreSostListOrig.get(i).getL45DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L45ScambiatoreSostituito[] l45ScambiatoreSostArray = new L45ScambiatoreSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l45ScambiatoreSostArray[i] = l45ScambiatoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l45Sc.setL45ScambiatoreSostituitoArray(l45ScambiatoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L45ScambiatoreSostituito> l45ScambiatoreSostListNew = l45Sc.getL45ScambiatoreSostituitoList();

						int listSize = l45ScambiatoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L45ScambiatoreSostituito l45ScambiatoreSost = l45ScambiatoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l45ScambiatoreSost.getL45DataDismissione(), l45Scambiatore.getL45DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l45ScambiatoreSost.getL45DataInstallazione(), l45ScambiatoreSost.getL45DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l45ScambiatoreSostListNew.get(i+1).getL45DataInstallazione(), l45ScambiatoreSost.getL45DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l45ScambiatoreSost.getL45Fabbricante());

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L45ScambiatoreSostituito non funziona
				for (int j = 0; j < l45SCList.size(); j++) {
					compList.add(new ComparatorDto(j, l45SCList.get(j).getL45Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L42BR ordinati
				L45SC[] l45SCArray = new L45SC[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l45SCArray[i] = l45SCList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL45SCArray(l45SCArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L45SC> l45SCListNew = l4Generatori.getL45SCList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L45SC l45Sc : l45SCListNew) {

					l45Sc.setL45Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}

			// Verificao che ci siano delle CG
			if (l46CGList != null && l46CGList.size() > 0)
			{
				for (L46CG l46Cg : l46CGList) 
				{

					numComponente = ConvertUtil.convertToString(l46Cg.getL46Numero());

					L46Cogeneratore l46Cogeneratore =l46Cg.getL46Cogeneratore();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l46Cogeneratore.getL46DataInstallazione(), l46Cogeneratore.getL46DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l46Cogeneratore.getL46Fabbricante());
					validazioneCombustibile(l46Cogeneratore.getL46Alimentazione());


					List<L46CogeneratoreSostituito> l46CogeneratoreSostListOrig = l46Cg.getL46CogeneratoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l46CogeneratoreSostListOrig != null && l46CogeneratoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l46CogeneratoreSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l46CogeneratoreSostListOrig.get(i).getL46DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L46CogeneratoreSostituito[] l46CogeneratoreSostArray = new L46CogeneratoreSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l46CogeneratoreSostArray[i] = l46CogeneratoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l46Cg.setL46CogeneratoreSostituitoArray(l46CogeneratoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L46CogeneratoreSostituito> l46CogeneratoreSostListNew = l46Cg.getL46CogeneratoreSostituitoList();

						int listSize = l46CogeneratoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L46CogeneratoreSostituito l46CogeneratoreSost = l46CogeneratoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l46CogeneratoreSost.getL46DataDismissione(), l46Cogeneratore.getL46DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l46CogeneratoreSost.getL46DataInstallazione(), l46CogeneratoreSost.getL46DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l46CogeneratoreSostListNew.get(i+1).getL46DataInstallazione(), l46CogeneratoreSost.getL46DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l46CogeneratoreSost.getL46Fabbricante());
							validazioneCombustibile(l46CogeneratoreSost.getL46Alimentazione());
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L46CogeneratoreSostituito non funziona
				for (int j = 0; j < l46CGList.size(); j++) {
					compList.add(new ComparatorDto(j, l46CGList.get(j).getL46Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L46CG ordinati
				L46CG[] l46CGArray = new L46CG[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l46CGArray[i] = l46CGList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL46CGArray(l46CGArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L46CG> l46CGListNew = l4Generatori.getL46CGList();


				// Devo rinominare il progressivo (L46Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L46CG l46Cg : l46CGListNew) {

					l46Cg.setL46Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle CS
			if (l47CSList != null && l47CSList.size() > 0)
			{
				for (L47CS l47Cs : l47CSList) 
				{

					numComponente = ConvertUtil.convertToString(l47Cs.getL47Numero());

					L47CampoSolareTermico l47CamSolTer =l47Cs.getL47CampoSolareTermico();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l47CamSolTer.getL47DataInstallazione(), l47CamSolTer.getL47DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l47CamSolTer.getL47Fabbricante());

					List<L47CampoSolareTermicoSostituito> l47CamSolTerSostListOrig = l47Cs.getL47CampoSolareTermicoSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l47CamSolTerSostListOrig != null && l47CamSolTerSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l47CamSolTerSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l47CamSolTerSostListOrig.get(i).getL47DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L47CampoSolareTermicoSostituito[] l47CamSolTerSostArray = new L47CampoSolareTermicoSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l47CamSolTerSostArray[i] = l47CamSolTerSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l47Cs.setL47CampoSolareTermicoSostituitoArray(l47CamSolTerSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L47CampoSolareTermicoSostituito> l47CamSolTerSostListNew = l47Cs.getL47CampoSolareTermicoSostituitoList();

						int listSize = l47CamSolTerSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L47CampoSolareTermicoSostituito l47CamSolTerSost = l47CamSolTerSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l47CamSolTerSost.getL47DataDismissione(), l47CamSolTer.getL47DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l47CamSolTerSost.getL47DataInstallazione(), l47CamSolTerSost.getL47DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l47CamSolTerSostListNew.get(i+1).getL47DataInstallazione(), l47CamSolTerSost.getL47DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l47CamSolTerSost.getL47Fabbricante());
						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L47CampoSolareTerSostituito non funziona
				for (int j = 0; j < l47CSList.size(); j++) {
					compList.add(new ComparatorDto(j, l47CSList.get(j).getL47Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L42BR ordinati
				L47CS[] l47CSArray = new L47CS[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l47CSArray[i] = l47CSList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL47CSArray(l47CSArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L47CS> l47CSListNew = l4Generatori.getL47CSList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L47CS l47Cs : l47CSListNew) {

					l47Cs.setL47Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}


			// Verificao che ci siano delle AG
			if (l48AGList != null && l48AGList.size() > 0)
			{
				for (L48AG l49Ag : l48AGList) 
				{

					numComponente = ConvertUtil.convertToString(l49Ag.getL48Numero());

					L48AltroGeneratore l48AltroGeneratore =l49Ag.getL48AltroGeneratore();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l48AltroGeneratore.getL48DataInstallazione(), l48AltroGeneratore.getL48DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l48AltroGeneratore.getL48Fabbricante());

					List<L48AltroGeneratoreSostituito> l48AltroGeneratoreSostListOrig = l49Ag.getL48AltroGeneratoreSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l48AltroGeneratoreSostListOrig != null && l48AltroGeneratoreSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
						for (int i = 0; i < l48AltroGeneratoreSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l48AltroGeneratoreSostListOrig.get(i).getL48DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
						L48AltroGeneratoreSostituito[] l48AltroGeneratoreSostArray = new L48AltroGeneratoreSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l48AltroGeneratoreSostArray[i] = l48AltroGeneratoreSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l49Ag.setL48AltroGeneratoreSostituitoArray(l48AltroGeneratoreSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
						List<L48AltroGeneratoreSostituito> l48AltroGeneratoreSostListNew = l49Ag.getL48AltroGeneratoreSostituitoList();

						int listSize = l48AltroGeneratoreSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L48AltroGeneratoreSostituito l48AltroGeneratoreSost = l48AltroGeneratoreSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l48AltroGeneratoreSost.getL48DataDismissione(), l48AltroGeneratore.getL48DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l48AltroGeneratoreSost.getL48DataInstallazione(), l48AltroGeneratoreSost.getL48DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l48AltroGeneratoreSostListNew.get(i+1).getL48DataInstallazione(), l48AltroGeneratoreSost.getL48DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l48AltroGeneratoreSost.getL48Fabbricante());

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L48AltroGeneratoreSostituito non funziona
				for (int j = 0; j < l48AGList.size(); j++) {
					compList.add(new ComparatorDto(j, l48AGList.get(j).getL48Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L48AG ordinati
				L48AG[] l48AGArray = new L48AG[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l48AGArray[i] = l48AGList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l4Generatori.setL48AGArray(l48AGArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L48AG> l48AGListNew = l4Generatori.getL48AGList();


				// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L48AG l48Ag : l48AGListNew) {

					l48Ag.setL48Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}
	}



	private static void validazioneL5SistemiRegolazioneContabilizzazione(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		// Devo verificare le date
		// devo ordinare le sostituite per data installazione

		// L5_sistemiRegolazioneContabilizzazione

		// L5_1sistemaRegolazioneSostituito
		// L5_1valvolaRegolazioneSostituito

		L5SistemiRegolazioneContabilizzazione l5SistRegCont = richiesta.getL5SistemiRegolazioneContabilizzazione();

		if (l5SistRegCont != null)
		{

			List<L51SR> l51SRList = l5SistRegCont.getL51SRList();
			List<L51VR> l51VRList = l5SistRegCont.getL51VRList();

			String numComponente = null;
			List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

			// Verificao che ci siano delle SR
			if (l51SRList != null && l51SRList.size() > 0)
			{
				for (L51SR l51sr : l51SRList) 
				{

					numComponente = ConvertUtil.convertToString(l51sr.getL51Numero());

					L51SistemaRegolazione l51SistReg =l51sr.getL51SistemaRegolazione();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l51SistReg.getL51DataInstallazione(), l51SistReg.getL51DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l51SistReg.getL51Fabbricante());


					List<L51SistemaRegolazioneSostituito> l51SistRegSostListOrig = l51sr.getL51SistemaRegolazioneSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l51SistRegSostListOrig != null && l51SistRegSostListOrig.size() > 0)
					{

						//compList = new ArrayList<ComparatorDto>();

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
						for (int i = 0; i < l51SistRegSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l51SistRegSostListOrig.get(i).getL51DataInstallazione())));
						}

						
									System.out.println("\n\nPrima l'ordinamento - inizio");
									System.out.println("#######################");
									for (ComparatorDto l51SistRegSost : compList) {

										System.out.println(l51SistRegSost.getData() + " - " +l51SistRegSost.getIdData());
									}
									System.out.println("#######################");
									System.out.println("Prima l'ordinamento - fine\n\n");

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());

									System.out.println("#######################");
									for (ComparatorDto l51SistRegSost : compList) {

										System.out.println(l51SistRegSost.getData() + " - " +l51SistRegSost.getIdData());
									}
									System.out.println("#######################");

						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L51SistemaRegolazioneSostituito[] l51SistRegSostArray = new L51SistemaRegolazioneSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l51SistRegSostArray[i] = l51SistRegSostListOrig.get(compList.get(i).getIdData());

						}


						/*
									// STAMPO la lista ordinata originale
									for (L51SistemaRegolazioneSostituito l51SistemaRegolazioneSostituito : l51SistRegSostListNew) {

										//System.out.println(l51SistemaRegolazioneSostituito.getL51DataInstallazione() + " - " + l51SistemaRegolazioneSostituito.getL51DataDismissione());
										System.out.println(l51SistemaRegolazioneSostituito);
									}
						 */

						//Risetto l'array ordinato
						l51sr.setL51SistemaRegolazioneSostituitoArray(l51SistRegSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi
						List<L51SistemaRegolazioneSostituito> l51SistRegSostListNew = l51sr.getL51SistemaRegolazioneSostituitoList();

						
									System.out.println("\n\nprima del controllo dell'oggetto originale modificato - inizio");

									// STAMPO l'ordinamento
									for (L51SistemaRegolazioneSostituito l51SistemaRegolazioneSostituito : l51SistRegSostListNew) {

										//System.out.println(l51SistemaRegolazioneSostituito.getL51DataInstallazione() + " - " + l51SistemaRegolazioneSostituito.getL51DataDismissione());
										System.out.println(l51SistemaRegolazioneSostituito);
									}

									System.out.println("Dopo del controllo dell'oggetto originale modificato - fine\n\n");
						


						int listSize = l51SistRegSostListNew.size();

						//							System.out.println("l51SistRegSostArray.length: "+l51SistRegSostArray.length);

						for (int i = 0; i < listSize; i++) {

							L51SistemaRegolazioneSostituito l51SistRegSost = l51SistRegSostListNew.get(i);

							//System.out.println("prima");
							//GenericUtil.stampa(l51SistRegSost, false, 3);

							//System.out.println("l51SistRegSost: "+l51SistRegSost.getL51DataDismissione());

							if (i == 0)
							{
								System.out.println("Elemento 0");
								System.out.println(l51SistReg.getL51DataInstallazione()+" - "+l51SistRegSost.getL51DataDismissione());
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l51SistRegSost.getL51DataDismissione(), l51SistReg.getL51DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								
								System.out.println("# "+l51SistRegSostListNew.get(i+1).getL51DataInstallazione()+" : "+l51SistRegSost.getL51DataDismissione());
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l51SistRegSostListNew.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l51SistRegSost.getL51Fabbricante());

						}


					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
				for (int j = 0; j < l51SRList.size(); j++) {
					compList.add(new ComparatorDto(j, l51SRList.get(j).getL51Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L51SR ordinati
				L51SR[] l51SRArray = new L51SR[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l51SRArray[i] = l51SRList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l5SistRegCont.setL51SRArray(l51SRArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L51SR> l51SRListNew = l5SistRegCont.getL51SRList();


				// Devo rinominare il progressivo (L51Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L51SR l51Sr : l51SRListNew) {

					l51Sr.setL51Numero(ConvertUtil.convertToBigInteger(count++));
				}

				//System.out.println("l5SistRegCont.getL51SRList()");
				//System.out.println(l5SistRegCont.getL51SRList());

			}


			// Verificao che ci siano delle SR
			if (l51VRList != null && l51VRList.size() > 0)
			{
				for (L51VR l51vr : l51VRList) 
				{

					numComponente = ConvertUtil.convertToString(l51vr.getL51Numero());

					L51ValvolaRegolazione l51ValvReg =l51vr.getL51ValvolaRegolazione();

					validazioneDataInstDataDismisSePresImpLib(numComponente, l51ValvReg.getL51DataInstallazione(), l51ValvReg.getL51DataDismissione());

					// Verifico i valori delle combo
					validazioneMarca(l51ValvReg.getL51Fabbricante());


					List<L51ValvolaRegolazioneSostituito> l51ValvRegSostListOrig = l51vr.getL51ValvolaRegolazioneSostituitoList();

					// Verificao che ci siano delle sostituzioni
					if (l51ValvRegSostListOrig != null && l51ValvRegSostListOrig.size() > 0)
					{

						compList.clear();

						// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
						for (int i = 0; i < l51ValvRegSostListOrig.size(); i++) 
						{
							compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l51ValvRegSostListOrig.get(i).getL51DataInstallazione())));
						}

						// ordino per dataInstallazione la lista
						Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


						// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di L51SistemaRegolazioneSostituito ordinati
						L51ValvolaRegolazioneSostituito[] l51ValvRegSostArray = new L51ValvolaRegolazioneSostituito[compList.size()]; 

						for (int i = 0; i < compList.size(); i++) {
							l51ValvRegSostArray[i] = l51ValvRegSostListOrig.get(compList.get(i).getIdData());

						}

						//Risetto l'array ordinato
						l51vr.setL51ValvolaRegolazioneSostituitoArray(l51ValvRegSostArray);



						// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi
						List<L51ValvolaRegolazioneSostituito> l51ValvRegSostListNew = l51vr.getL51ValvolaRegolazioneSostituitoList();

						int listSize = l51ValvRegSostListNew.size();

						for (int i = 0; i < listSize; i++) {

							L51ValvolaRegolazioneSostituito l51ValvRegSost = l51ValvRegSostListNew.get(i);

							if (i == 0)
							{
								// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
								validazioneDataInstSuccDataDismisImpLib(numComponente, l51ValvRegSost.getL51DataDismissione(), l51ValvReg.getL51DataInstallazione());
							}

							// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
							validazioneDataInstDataDismisImpLib(numComponente, l51ValvRegSost.getL51DataInstallazione(), l51ValvRegSost.getL51DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

							if (i != listSize-1)
							{
								// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
								validazioneDataInstSuccDataDismisImpLib(numComponente, l51ValvRegSostListNew.get(i+1).getL51DataInstallazione(), l51ValvRegSost.getL51DataDismissione());
								//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

							}

							// Verifico i valori delle combo
							validazioneMarca(l51ValvRegSost.getL51Fabbricante());

						}
					}
				}

				// Pulisco la lista
				compList.clear();


				// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L51SistemaRegolazioneSostituito non funziona
				for (int j = 0; j < l51VRList.size(); j++) {
					compList.add(new ComparatorDto(j, l51VRList.get(j).getL51Numero()));
				}

				// ordino per progressivo la lista
				Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

				// Dopo aver ordinato per la progressivo devo ricostruire la lista di L51SR ordinati
				L51VR[] l51VRArray = new L51VR[compList.size()]; 

				for (int i = 0; i < compList.size(); i++) {
					l51VRArray[i] = l51VRList.get(compList.get(i).getIdData());

				}

				//Risetto l'array ordinato
				l5SistRegCont.setL51VRArray(l51VRArray);


				// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
				List<L51VR> l51VRListNew = l5SistRegCont.getL51VRList();


				// Devo rinominare il progressivo (L51Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
				int count = 1; 
				for (L51VR l51Vr : l51VRListNew) {

					l51Vr.setL51Numero(ConvertUtil.convertToBigInteger(count++));
				}
			}
		}
	}

	private static void validazioneL6Pompa(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L6SistemiDistribuzione l6SistDistrib = richiesta.getL6SistemiDistribuzione();
		List<L64PO> l64POList = l6SistDistrib.getL64POList();

		List<ComparatorDto> compList = new ArrayList<ComparatorDto>();
		// Verificao che ci siano delle PO
		if (l64POList != null && l64POList.size() > 0)
		{
			for (L64PO l64Po : l64POList) 
			{

				String numComponente = ConvertUtil.convertToString(l64Po.getL64Numero());

				L64Pompa l64Pompa =l64Po.getL64Pompa();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l64Pompa.getL64DataInstallazione(), l64Pompa.getL64DataDismissione());

				validazioneMarca(l64Pompa.getL64Fabbricante());

				List<L64PompaSostituito> l64PompaSostListOrig = l64Po.getL64PompaSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l64PompaSostListOrig != null && l64PompaSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l64PompaSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l64PompaSostListOrig.get(i).getL64DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L64PompaSostituito[] l64PompaSostArray = new L64PompaSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l64PompaSostArray[i] = l64PompaSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l64Po.setL64PompaSostituitoArray(l64PompaSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L64PompaSostituito> l64PompaSostListNew = l64Po.getL64PompaSostituitoList();

					int listSize = l64PompaSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L64PompaSostituito l64PompaSost = l64PompaSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l64PompaSost.getL64DataDismissione(), l64Pompa.getL64DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l64PompaSost.getL64DataInstallazione(), l64PompaSost.getL64DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l64PompaSostListNew.get(i+1).getL64DataInstallazione(), l64PompaSost.getL64DataDismissione());

						}

						validazioneMarca(l64PompaSost.getL64Fabbricante());

					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L64PompaSostituito non funziona
			for (int j = 0; j < l64POList.size(); j++) {
				compList.add(new ComparatorDto(j, l64POList.get(j).getL64Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L64PO ordinati
			L64PO[] l64POArray = new L64PO[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l64POArray[i] = l64POList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l6SistDistrib.setL64POArray(l64POArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L64PO> l64POListNew = l6SistDistrib.getL64POList();


			// Devo rinominare il progressivo (L64Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L64PO l64Po : l64POListNew) {

				l64Po.setL64Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}
	}

	private static void validazioneL8Accumulo(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L8SistemiAccumulo l8SistAccumulo = richiesta.getL8SistemiAccumulo();
		
		if (l8SistAccumulo != null)
		{
		List<L81AC> l81ACList = l8SistAccumulo.getL81ACList();

		List<ComparatorDto> compList = new ArrayList<ComparatorDto>();
		// Verificao che ci siano delle AC
		if (l81ACList != null && l81ACList.size() > 0)
		{
			for (L81AC l81Ac : l81ACList) 
			{

				String numComponente = ConvertUtil.convertToString(l81Ac.getL81Numero());

				L81Accumulo l81Accumulo =l81Ac.getL81Accumulo();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l81Accumulo.getL81DataInstallazione(), l81Accumulo.getL81DataDismissione());

				validazioneMarca(l81Accumulo.getL81Fabbricante());

				List<L81AccumuloSostituito> l81AccumuloSostListOrig = l81Ac.getL81AccumuloSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l81AccumuloSostListOrig != null && l81AccumuloSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l81AccumuloSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l81AccumuloSostListOrig.get(i).getL81DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L81AccumuloSostituito[] l81AccumuloSostArray = new L81AccumuloSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l81AccumuloSostArray[i] = l81AccumuloSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l81Ac.setL81AccumuloSostituitoArray(l81AccumuloSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L81AccumuloSostituito> l81AccumuloSostListNew = l81Ac.getL81AccumuloSostituitoList();

					int listSize = l81AccumuloSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L81AccumuloSostituito l81AccumuloSost = l81AccumuloSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l81AccumuloSost.getL81DataDismissione(), l81Accumulo.getL81DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l81AccumuloSost.getL81DataInstallazione(), l81AccumuloSost.getL81DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l81AccumuloSostListNew.get(i+1).getL81DataInstallazione(), l81AccumuloSost.getL81DataDismissione());

						}

						validazioneMarca(l81AccumuloSost.getL81Fabbricante());

					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L81AccumuloSostituito non funziona
			for (int j = 0; j < l81ACList.size(); j++) {
				compList.add(new ComparatorDto(j, l81ACList.get(j).getL81Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L81AC ordinati
			L81AC[] l81ACArray = new L81AC[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l81ACArray[i] = l81ACList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l8SistAccumulo.setL81ACArray(l81ACArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L81AC> l81ACListNew = l8SistAccumulo.getL81ACList();


			// Devo rinominare il progressivo (L64Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L81AC l81Ac : l81ACListNew) {

				l81Ac.setL81Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}
		}
	}



	private static void validazioneL9TeRvScxCiUtRcx(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L9AltriComponenti l9AltriComp = richiesta.getL9AltriComponenti();
		
		if (l9AltriComp != null)
		{
		List<L91TE> l91TEList = l9AltriComp.getL91TEList();
		List<L92RV> l92RVList = l9AltriComp.getL92RVList();
		List<L93SCX> l93SCXList = l9AltriComp.getL93SCXList();

		List<L94CI> l94CIList = l9AltriComp.getL94CIList();
		List<L95UT> l95UTList = l9AltriComp.getL95UTList();
		List<L96RCX> l96RCXList = l9AltriComp.getL96RCXList();

		List<ComparatorDto> compList = new ArrayList<ComparatorDto>();

		String numComponente = null;

		// Verificao che ci siano delle PO
		if (l91TEList != null && l91TEList.size() > 0)
		{
			for (L91TE l91Te : l91TEList) 
			{

				numComponente = ConvertUtil.convertToString(l91Te.getL91Numero());

				L91Torre l91Torre =l91Te.getL91Torre();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l91Torre.getL91DataInstallazione(), l91Torre.getL91DataDismissione());

				validazioneMarca(l91Torre.getL91Fabbricante());

				List<L91TorreSostituito> l91TorreSostListOrig = l91Te.getL91TorreSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l91TorreSostListOrig != null && l91TorreSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l91TorreSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l91TorreSostListOrig.get(i).getL91DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L91TorreSostituito[] l91TorreSostArray = new L91TorreSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l91TorreSostArray[i] = l91TorreSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l91Te.setL91TorreSostituitoArray(l91TorreSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L91TorreSostituito> l91TorreSostListNew = l91Te.getL91TorreSostituitoList();

					int listSize = l91TorreSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L91TorreSostituito l91TorreSost = l91TorreSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l91TorreSost.getL91DataDismissione(), l91Torre.getL91DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l91TorreSost.getL91DataInstallazione(), l91TorreSost.getL91DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l91TorreSostListNew.get(i+1).getL91DataInstallazione(), l91TorreSost.getL91DataDismissione());

						}

						validazioneMarca(l91TorreSost.getL91Fabbricante());

					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L91TorreSostituito non funziona
			for (int j = 0; j < l91TEList.size(); j++) {
				compList.add(new ComparatorDto(j, l91TEList.get(j).getL91Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L91PO ordinati
			L91TE[] l91TEArray = new L91TE[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l91TEArray[i] = l91TEList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l9AltriComp.setL91TEArray(l91TEArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L91TE> l91TEListNew = l9AltriComp.getL91TEList();


			// Devo rinominare il progressivo (L91Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L91TE l91Te : l91TEListNew) {

				l91Te.setL91Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}



		// Verificao che ci siano delle RV
		if (l92RVList != null && l92RVList.size() > 0)
		{
			for (L92RV l92Rv : l92RVList) 
			{

				numComponente = ConvertUtil.convertToString(l92Rv.getL92Numero());

				L92Raffreddatore l92Raffreddatore =l92Rv.getL92Raffreddatore();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l92Raffreddatore.getL92DataInstallazione(), l92Raffreddatore.getL92DataDismissione());

				validazioneMarca(l92Raffreddatore.getL92Fabbricante());

				List<L92RaffreddatoreSostituito> l92RaffreddatoreSostListOrig = l92Rv.getL92RaffreddatoreSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l92RaffreddatoreSostListOrig != null && l92RaffreddatoreSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l92RaffreddatoreSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l92RaffreddatoreSostListOrig.get(i).getL92DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L92RaffreddatoreSostituito[] l92RaffreddatoreSostArray = new L92RaffreddatoreSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l92RaffreddatoreSostArray[i] = l92RaffreddatoreSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l92Rv.setL92RaffreddatoreSostituitoArray(l92RaffreddatoreSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L92RaffreddatoreSostituito> l92RaffreddatoreSostListNew = l92Rv.getL92RaffreddatoreSostituitoList();

					int listSize = l92RaffreddatoreSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L92RaffreddatoreSostituito l92RaffreddatoreSost = l92RaffreddatoreSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l92RaffreddatoreSost.getL92DataDismissione(), l92Raffreddatore.getL92DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l92RaffreddatoreSost.getL92DataInstallazione(), l92RaffreddatoreSost.getL92DataDismissione());
						//DateUtil.checkDateOrder(l51SistRegSost.getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), true);

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l92RaffreddatoreSostListNew.get(i+1).getL92DataInstallazione(), l92RaffreddatoreSost.getL92DataDismissione());
							//DateUtil.checkDateOrder(l51SistRegSostList.get(i+1).getL51DataInstallazione(), l51SistRegSost.getL51DataDismissione(), false);

						}

						validazioneMarca(l92RaffreddatoreSost.getL92Fabbricante());

					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L92RaffreddatoreSostituito non funziona
			for (int j = 0; j < l92RVList.size(); j++) {
				compList.add(new ComparatorDto(j, l92RVList.get(j).getL92Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L92RV ordinati
			L92RV[] l92RVArray = new L92RV[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l92RVArray[i] = l92RVList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l9AltriComp.setL92RVArray(l92RVArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L92RV> l92RVListNew = l9AltriComp.getL92RVList();


			// Devo rinominare il progressivo (L42Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L92RV l92Rv : l92RVListNew) {

				l92Rv.setL92Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}


		// Verificao che ci siano delle SCX
		if (l93SCXList != null && l93SCXList.size() > 0)
		{
			for (L93SCX l93Scx : l93SCXList) 
			{

				numComponente = ConvertUtil.convertToString(l93Scx.getL93Numero());

				L93ScambiatoreIntermedio l93ScambInter =l93Scx.getL93ScambiatoreIntermedio();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l93ScambInter.getL93DataInstallazione(), l93ScambInter.getL93DataDismissione());

				validazioneMarca(l93ScambInter.getL93Fabbricante());

				List<L93ScambiatoreIntermedioSostituito> l93ScambInterSostListOrig = l93Scx.getL93ScambiatoreIntermedioSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l93ScambInterSostListOrig != null && l93ScambInterSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l93ScambInterSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l93ScambInterSostListOrig.get(i).getL93DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L93ScambiatoreIntermedioSostituito[] l93ScambInterSostArray = new L93ScambiatoreIntermedioSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l93ScambInterSostArray[i] = l93ScambInterSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l93Scx.setL93ScambiatoreIntermedioSostituitoArray(l93ScambInterSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L93ScambiatoreIntermedioSostituito> l93ScambInterSostListNew = l93Scx.getL93ScambiatoreIntermedioSostituitoList();

					int listSize = l93ScambInterSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L93ScambiatoreIntermedioSostituito l93ScambInterSost = l93ScambInterSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l93ScambInterSost.getL93DataDismissione(), l93ScambInter.getL93DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l93ScambInterSost.getL93DataInstallazione(), l93ScambInterSost.getL93DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l93ScambInterSostListNew.get(i+1).getL93DataInstallazione(), l93ScambInterSost.getL93DataDismissione());

						}

						validazioneMarca(l93ScambInterSost.getL93Fabbricante());

					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L93ScambInterSostituito non funziona
			for (int j = 0; j < l93SCXList.size(); j++) {
				compList.add(new ComparatorDto(j, l93SCXList.get(j).getL93Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L93SCX ordinati
			L93SCX[] l93SCXArray = new L93SCX[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l93SCXArray[i] = l93SCXList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l9AltriComp.setL93SCXArray(l93SCXArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L93SCX> l93SCXListNew = l9AltriComp.getL93SCXList();


			// Devo rinominare il progressivo (L93Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L93SCX l93Scx : l93SCXListNew) {

				l93Scx.setL93Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}


		// Verificao che ci siano delle CI
		if (l94CIList != null && l94CIList.size() > 0)
		{
			for (L94CI l94Ci : l94CIList) 
			{

				numComponente = ConvertUtil.convertToString(l94Ci.getL94Numero());

				L94Circuito l94Circuito =l94Ci.getL94Circuito();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l94Circuito.getL94DataInstallazione(), l94Circuito.getL94DataDismissione());

				List<L94CircuitoSostituito> l94CircuitoSostListOrig = l94Ci.getL94CircuitoSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l94CircuitoSostListOrig != null && l94CircuitoSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l94CircuitoSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l94CircuitoSostListOrig.get(i).getL94DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L94CircuitoSostituito[] l94CircuitoSostArray = new L94CircuitoSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l94CircuitoSostArray[i] = l94CircuitoSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l94Ci.setL94CircuitoSostituitoArray(l94CircuitoSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L94CircuitoSostituito> l94CircuitoSostListNew = l94Ci.getL94CircuitoSostituitoList();

					int listSize = l94CircuitoSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L94CircuitoSostituito l94CircuitoSost = l94CircuitoSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l94CircuitoSost.getL94DataDismissione(), l94Circuito.getL94DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l94CircuitoSost.getL94DataInstallazione(), l94CircuitoSost.getL94DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l94CircuitoSostListNew.get(i+1).getL94DataInstallazione(), l94CircuitoSost.getL94DataDismissione());

						}
					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L94CircuitoSostituito non funziona
			for (int j = 0; j < l94CIList.size(); j++) {
				compList.add(new ComparatorDto(j, l94CIList.get(j).getL94Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L94CI ordinati
			L94CI[] l94CIArray = new L94CI[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l94CIArray[i] = l94CIList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l9AltriComp.setL94CIArray(l94CIArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L94CI> l94CIListNew = l9AltriComp.getL94CIList();


			// Devo rinominare il progressivo (L94Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L94CI l94Ci : l94CIListNew) {

				l94Ci.setL94Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}



		// Verificao che ci siano delle UT
		if (l95UTList != null && l95UTList.size() > 0)
		{
			for (L95UT l95Ut : l95UTList) 
			{

				numComponente = ConvertUtil.convertToString(l95Ut.getL95Numero());

				L95UnitaTrattAria l95UnitaTrattAria =l95Ut.getL95UnitaTrattAria();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l95UnitaTrattAria.getL95DataInstallazione(), l95UnitaTrattAria.getL95DataDismissione());

				validazioneMarca(l95UnitaTrattAria.getL95Fabbricante());

				List<L95UnitaTrattAriaSostituito> l95UnitaTrattAriaSostListOrig = l95Ut.getL95UnitaTrattAriaSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l95UnitaTrattAriaSostListOrig != null && l95UnitaTrattAriaSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l95UnitaTrattAriaSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l95UnitaTrattAriaSostListOrig.get(i).getL95DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L95UnitaTrattAriaSostituito[] l95UnitaTrattAriaSostArray = new L95UnitaTrattAriaSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l95UnitaTrattAriaSostArray[i] = l95UnitaTrattAriaSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l95Ut.setL95UnitaTrattAriaSostituitoArray(l95UnitaTrattAriaSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L95UnitaTrattAriaSostituito> l95UnitaTrattAriaSostListNew = l95Ut.getL95UnitaTrattAriaSostituitoList();

					int listSize = l95UnitaTrattAriaSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L95UnitaTrattAriaSostituito l95UnitaTrattAriaSost = l95UnitaTrattAriaSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l95UnitaTrattAriaSost.getL95DataDismissione(), l95UnitaTrattAria.getL95DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l95UnitaTrattAriaSost.getL95DataInstallazione(), l95UnitaTrattAriaSost.getL95DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l95UnitaTrattAriaSostListNew.get(i+1).getL95DataInstallazione(), l95UnitaTrattAriaSost.getL95DataDismissione());

						}

						validazioneMarca(l95UnitaTrattAriaSost.getL95Fabbricante());

					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L95UnitaTrattAriaSostituito non funziona
			for (int j = 0; j < l95UTList.size(); j++) {
				compList.add(new ComparatorDto(j, l95UTList.get(j).getL95Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L95UT ordinati
			L95UT[] l95UTArray = new L95UT[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l95UTArray[i] = l95UTList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l9AltriComp.setL95UTArray(l95UTArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L95UT> l95UTListNew = l9AltriComp.getL95UTList();


			// Devo rinominare il progressivo (L95Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L95UT l95Ut : l95UTListNew) {

				l95Ut.setL95Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}



		// Verificao che ci siano delle RCX
		if (l96RCXList != null && l96RCXList.size() > 0)
		{
			for (L96RCX l96Rcx : l96RCXList) 
			{

				numComponente = ConvertUtil.convertToString(l96Rcx.getL96Numero());

				L96RecuperatoreAriaAmb l96RecAriaAmb =l96Rcx.getL96RecuperatoreAriaAmb();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l96RecAriaAmb.getL96DataInstallazione(), l96RecAriaAmb.getL96DataDismissione());

				List<L96RecuperatoreAriaAmbSostituito> l96RecAriaAmbSostListOrig = l96Rcx.getL96RecuperatoreAriaAmbSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l96RecAriaAmbSostListOrig != null && l96RecAriaAmbSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l96RecAriaAmbSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l96RecAriaAmbSostListOrig.get(i).getL96DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L96RecuperatoreAriaAmbSostituito[] l96RecAriaAmbSostArray = new L96RecuperatoreAriaAmbSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l96RecAriaAmbSostArray[i] = l96RecAriaAmbSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l96Rcx.setL96RecuperatoreAriaAmbSostituitoArray(l96RecAriaAmbSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L96RecuperatoreAriaAmbSostituito> l96RecAriaAmbSostListNew = l96Rcx.getL96RecuperatoreAriaAmbSostituitoList();

					int listSize = l96RecAriaAmbSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L96RecuperatoreAriaAmbSostituito l96RecAriaAmbSost = l96RecAriaAmbSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l96RecAriaAmbSost.getL96DataDismissione(), l96RecAriaAmb.getL96DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l96RecAriaAmbSost.getL96DataInstallazione(), l96RecAriaAmbSost.getL96DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l96RecAriaAmbSostListNew.get(i+1).getL96DataInstallazione(), l96RecAriaAmbSost.getL96DataDismissione());

						}
					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L96RecuperatoreAriaAmbSostituito non funziona
			for (int j = 0; j < l96RCXList.size(); j++) {
				compList.add(new ComparatorDto(j, l96RCXList.get(j).getL96Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L96RCX ordinati
			L96RCX[] l96RCXArray = new L96RCX[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l96RCXArray[i] = l96RCXList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l9AltriComp.setL96RCXArray(l96RCXArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L96RCX> l96RCXListNew = l9AltriComp.getL96RCXList();


			// Devo rinominare il progressivo (L96Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L96RCX l96Rcx : l96RCXListNew) {

				l96Rcx.setL96Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}
		}

	}

	private static void validazioneL10VentilazioneMeccanica(LibrettoCatasto richiesta) throws ValidationManagerException
	{
		L10Ventilazione l8SistAccumulo = richiesta.getL10Ventilazione();
		
		if (l8SistAccumulo != null)
		{
		List<L101VM> l101VMList = l8SistAccumulo.getL101VMList();

		List<ComparatorDto> compList = new ArrayList<ComparatorDto>();
		// Verificao che ci siano delle AC
		if (l101VMList != null && l101VMList.size() > 0)
		{
			for (L101VM l101Vm : l101VMList) 
			{

				String numComponente = ConvertUtil.convertToString(l101Vm.getL101Numero());

				L101VentilazioneMeccanica l101VentMeccanica =l101Vm.getL101VentilazioneMeccanica();

				validazioneDataInstDataDismisSePresImpLib(numComponente, l101VentMeccanica.getL101DataInstallazione(), l101VentMeccanica.getL101DataDismissione());

				validazioneMarca(l101VentMeccanica.getL101Fabbricante());

				List<L101VentilazioneMeccanicaSostituito> l101VentMeccanicaSostListOrig = l101Vm.getL101VentilazioneMeccanicaSostituitoList();

				// Verificao che ci siano delle sostituzioni
				if (l101VentMeccanicaSostListOrig != null && l101VentMeccanicaSostListOrig.size() > 0)
				{

					compList.clear();

					// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto Array[] non funziona
					for (int i = 0; i < l101VentMeccanicaSostListOrig.size(); i++) 
					{
						compList.add(new ComparatorDto(i, ConvertUtil.convertToDate(l101VentMeccanicaSostListOrig.get(i).getL101DataInstallazione())));
					}

					// ordino per dataInstallazione la lista
					Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByData());


					// Dopo aver ordinato per la dataInstallazione devo ricostruire la lista di oggetti ordinati
					L101VentilazioneMeccanicaSostituito[] l101VentMeccanicaSostArray = new L101VentilazioneMeccanicaSostituito[compList.size()]; 

					for (int i = 0; i < compList.size(); i++) {
						l101VentMeccanicaSostArray[i] = l101VentMeccanicaSostListOrig.get(compList.get(i).getIdData());

					}

					//Risetto l'array ordinato
					l101Vm.setL101VentilazioneMeccanicaSostituitoArray(l101VentMeccanicaSostArray);



					// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
					List<L101VentilazioneMeccanicaSostituito> l101VentMeccanicaSostListNew = l101Vm.getL101VentilazioneMeccanicaSostituitoList();

					int listSize = l101VentMeccanicaSostListNew.size();

					for (int i = 0; i < listSize; i++) {

						L101VentilazioneMeccanicaSostituito l101VentMeccanicaSost = l101VentMeccanicaSostListNew.get(i);

						if (i == 0)
						{
							// Adesso che ho ordinato verifico che la dataDismissione del primo elemento (quindi quello piu' recente - l'elemento 0) sia precedente alla dataInstallazione dell'elemento attuale 
							validazioneDataInstSuccDataDismisImpLib(numComponente, l101VentMeccanicaSost.getL101DataDismissione(), l101VentMeccanica.getL101DataInstallazione());
						}

						// Adesso che ho ordinato le date devo verificarle, sia tra dataInizio -> dataFine, che la data inizio dell'ultima sia successiva alla data fine di quella precedente
						validazioneDataInstDataDismisImpLib(numComponente, l101VentMeccanicaSost.getL101DataInstallazione(), l101VentMeccanicaSost.getL101DataDismissione());

						if (i != listSize-1)
						{
							// Esistono ancora elementi successivi, quindi controllo la data fine attuale con la data inizio successiva
							validazioneDataInstSuccDataDismisImpLib(numComponente, l101VentMeccanicaSostListNew.get(i+1).getL101DataInstallazione(), l101VentMeccanicaSost.getL101DataDismissione());

						}

						validazioneMarca(l101VentMeccanicaSost.getL101Fabbricante());

					}
				}
			}

			// Pulisco la lista
			compList.clear();


			// Mi creo una lista specifica per fare l'ordinamento, perche' l'ordinamento con l'oggetto L101VentMeccanicaSostituito non funziona
			for (int j = 0; j < l101VMList.size(); j++) {
				compList.add(new ComparatorDto(j, l101VMList.get(j).getL101Numero()));
			}

			// ordino per progressivo la lista
			Collections.sort(compList, ComparatorUtil.compareCamparatorDtoByProgressivo());

			// Dopo aver ordinato per la progressivo devo ricostruire la lista di L101VM ordinati
			L101VM[] l101VMArray = new L101VM[compList.size()]; 

			for (int i = 0; i < compList.size(); i++) {
				l101VMArray[i] = l101VMList.get(compList.get(i).getIdData());

			}

			//Risetto l'array ordinato
			l8SistAccumulo.setL101VMArray(l101VMArray);


			// Recupero l'oggetto (ho notato che se riusavo l'array avevo dei problemi)
			List<L101VM> l101VMListNew = l8SistAccumulo.getL101VMList();


			// Devo rinominare il progressivo (L64Numero), in modo che sia 1,2,3,ecc. Perche' l'utente potrebbe aver inserito numeri a caso...
			int count = 1; 
			for (L101VM l101Ac : l101VMListNew) {

				l101Ac.setL101Numero(ConvertUtil.convertToBigInteger(count++));
			}
		}
		}
	}

	private static void validazioneDataInstDataDismisSePresImpLib(String tipoComp, String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = false;
		
		// verifico la data installazione che non sia futura
		check = DateUtil.checkDateFuture(dataInstallazione);
		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S134, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione)));
		}

		// verifico la data dismissione (se presente) che non sia futura
		check = DateUtil.checkDateFutureIsPresents(dataDismissione);
		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S134, tipoComp, componente, ConvertUtil.convertToString(dataDismissione)));
		}
		
		check = DateUtil.checkDateOrderIsPresents(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}
	
	private static void validazioneDataInstDataDismisSePresImpLib(String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = false;
		
		// verifico la data installazione che non sia futura
		check = DateUtil.checkDateFuture(dataInstallazione);
		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S134, componente, ConvertUtil.convertToString(dataInstallazione)));
		}

		// verifico la data dismissione (se presente) che non sia futura
		check = DateUtil.checkDateFutureIsPresents(dataDismissione);
		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S134, componente, ConvertUtil.convertToString(dataDismissione)));
		}
		
		check = DateUtil.checkDateOrderIsPresents(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}

	private static void validazioneDataInstDataDismisImpLib(String tipoComp, String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}

	private static void validazioneDataInstSuccDataDismisImpLib(String tipoComp, String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{

		System.out.println("tipoComp: "+tipoComp);
		System.out.println("componente: "+componente);
		System.out.println("dataInstallazione: "+dataInstallazione);
		System.out.println("dataDismissione (sost): "+dataDismissione);

		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, false);

		System.out.println("valadazioneDataInstSuccDataDismisImpLib");
		System.out.println(dataInstallazione +" - " + dataDismissione + ": "+check);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S131, tipoComp, componente, ConvertUtil.convertToString(dataInstallazione), ConvertUtil.convertToString(dataDismissione)));
		}
	}

	private static void validazioneDataInstSuccDataInstImpLib(String tipoComp, String componente, Calendar dataInstallazionePrec, Calendar dataInstallazione) throws ValidationManagerException
	{

		System.out.println("tipoComp: "+tipoComp);
		System.out.println("componente: "+componente);
		System.out.println("dataInstallazionePrec: "+dataInstallazionePrec);
		System.out.println("dataInstallazione (sost): "+dataInstallazione);

		boolean check = DateUtil.checkDateOrder(dataInstallazionePrec, dataInstallazione, false);

		System.out.println("validazioneDataDismisSuccDataDismisImpLib");
		System.out.println(dataInstallazionePrec +" - " + dataInstallazione + ": "+check);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S142, tipoComp, componente, ConvertUtil.convertToString(dataInstallazionePrec), ConvertUtil.convertToString(dataInstallazione)));
		}
	}

	
	private static void validazioneDataDismisSuccDataDismisImpLib(String tipoComp, String componente, Calendar dataDismissionePrec, Calendar dataDismissione) throws ValidationManagerException
	{

		System.out.println("tipoComp: "+tipoComp);
		System.out.println("componente: "+componente);
		System.out.println("dataDismissionePrec: "+dataDismissionePrec);
		System.out.println("dataDismissione (sost): "+dataDismissione);

		boolean check = DateUtil.checkDateOrder(dataDismissionePrec, dataDismissione, false);

		System.out.println("validazioneDataDismisSuccDataDismisImpLib");
		System.out.println(dataDismissionePrec +" - " + dataDismissione + ": "+check);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S143, tipoComp, componente, ConvertUtil.convertToString(dataDismissionePrec), ConvertUtil.convertToString(dataDismissione)));
		}
	}
	
	
	
	private static void validazioneDataInstDataDismisImpLib(String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{
		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, true);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S130, componente, ConvertUtil.convertToString(dataInstallazione)));
		}
	}

	private static void validazioneDataInstSuccDataDismisImpLib(String componente, Calendar dataInstallazione, Calendar dataDismissione) throws ValidationManagerException
	{

		System.out.println("componente: "+componente);
		System.out.println("dataInstallazione: "+dataInstallazione);
		System.out.println("dataDismissione (sost): "+dataDismissione);

		boolean check = DateUtil.checkDateOrder(dataInstallazione, dataDismissione, false);

		//System.out.println("valadazioneDataInstSuccDataDismisImpLib");
		System.out.println(dataInstallazione +" - " + dataDismissione + ": "+check);

		if (!check)
		{
			throw new ValidationManagerException(new Message(Messages.S131, componente, ConvertUtil.convertToString(dataInstallazione), ConvertUtil.convertToString(dataDismissione)));
		}
	}

	private static MODDocument testGetModuloFittizio() throws ServiceException
	{
		// Passata la validazione faccio il mapping
		//DbMgr db = new DbMgr();
		//MODDocument document = db.getModuloLibrettoImport("CodImp");

		MODDocument modDoc = MODDocument.Factory.newInstance();
		modDoc.addNewMOD().addNewRichiesta().addNewDatiPrecompilati().addNewSezCatasto();

//		Integer codImpiantoInt = new Integer(codImpianto);
		
		Richiesta richiesta = modDoc.getMOD().getRichiesta();
		DatiPrecompilati datiPrecompilati = richiesta.getDatiPrecompilati();
		
//		datiPrecompilati.setElencoCombustibile(MapDto.mapToElencoCombustibile(getElencoCombustibile()));
//		datiPrecompilati.setElencoFabbricante(MapDto.mapToElencoFabbricante(getElencoMarche()));
//		datiPrecompilati.setElencoFluidoTermoVett(MapDto.mapToElencoFluido(getElencoFluidi()));
//		datiPrecompilati.setElencoUM(MapDto.mapToElencoUnitaMisura(getElencoUnitaMisura()));
		
		//DA RIVEDERE
		//compilaScheda1Libretto(richiesta, libretto, impianto);
		
		// Import
		//richiesta.addNewDatiRisultatiGT().xsetL111FlagNorma(MapDto.getXmlBoolean(ConvertUtil.convertToBooleanAllways(libretto.getL111FlgNormaUni103891())));
		//richiesta.getDatiRisultatiGT().xsetL111FlagAltro(MapDto.getXmlBoolean(GenericUtil.isNotNullOrEmpty(libretto.getL111AltraNorma())));
		//richiesta.getDatiRisultatiGT().setL111DescrAltro(libretto.getL111AltraNorma());

//		List<SigitVCompGtDettDto> compGtImpiantoDett = getCompGtDett(codImpiantoInt);
//		List<SigitVCompGfDettDto> compGfImpiantoDett = getCompGfDett(codImpiantoInt);
//		List<SigitVCompScDettDto> compScImpiantoDett = getCompScDett(codImpiantoInt);
//		List<SigitVCompCgDettDto> compCgImpiantoDett = getCompCgDett(codImpiantoInt);
//		
//		compilaDatiResponsabiliEControlliLibretto(codImpiantoInt, richiesta, compGtImpiantoDett, compGfImpiantoDett, compScImpiantoDett, compCgImpiantoDett);
		
		datiPrecompilati.setStatoModulo(Constants.STATO_MODULO_BOZZA);
		modDoc.getMOD().addNewSystem().addNewCatDig().setModuloEditabile(true);
		modDoc.getMOD().getSystem().getCatDig().setBtSalva(true);
		
		return modDoc;
	}
}
