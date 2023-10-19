package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import it.csi.aaep.aaeporch.business.Impresa;
import it.csi.aaep.aaeporch.business.OrchestratoreImplService;
import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.CSIException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitRComp4ManutDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTImpiantoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTLibrettoDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitTPersonaGiuridicaDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.SigitVCompGtDettDto;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.SigitDRuoloDaoException;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.filter.ImportFilter;
import it.csi.sigit.sigitwebn.business.manager.ValidationMgr;
import it.csi.sigit.sigitwebn.business.manager.util.DbManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.ManagerException;
import it.csi.sigit.sigitwebn.business.manager.util.Message;
import it.csi.sigit.sigitwebn.business.manager.util.ServiceException;
import it.csi.sigit.sigitwebn.business.manager.util.ValidationManagerException;
import it.csi.sigit.sigitwebn.dto.ExecResults;
import it.csi.sigit.sigitwebn.dto.common.CodeDescription;
import it.csi.sigit.sigitwebn.dto.index.DettaglioAllegatoIndex;
import it.csi.sigit.sigitwebn.dto.index.Metadati;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda11;
import it.csi.sigit.sigitwebn.dto.libretto.Scheda12;
import it.csi.sigit.sigitwebn.util.ComparatorDto;
import it.csi.sigit.sigitwebn.util.ComparatorUtil;
import it.csi.sigit.sigitwebn.util.Constants;
import it.csi.sigit.sigitwebn.util.ConstantsField;
import it.csi.sigit.sigitwebn.util.ConvertUtil;
import it.csi.sigit.sigitwebn.util.DateUtil;
import it.csi.sigit.sigitwebn.util.GenericUtil;
import it.csi.sigit.sigitwebn.util.MapDto;
import it.csi.sigit.sigitwebn.util.Messages;
import it.csi.sigit.sigitwebn.util.Validator;
import it.csi.sigit.sigitwebn.util.XmlBeanUtils;
import it.csi.sigit.sigitwebn.util.XmlValidator;
import it.csi.sigit.sigitwebn.util.XmlValidatorException;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51SistemaRegolazioneDocument.L51SistemaRegolazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51ValvolaRegolazioneDocument.L51ValvolaRegolazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoDocument;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51SistemaRegolazioneSostituitoDocument.L51SistemaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L51ValvolaRegolazioneSostituitoDocument.L51ValvolaRegolazioneSostituito;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51SR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.L5SistemiRegolazioneContabilizzazioneDocument.L5SistemiRegolazioneContabilizzazione.L51VR;
import it.csi.sigit.sigitwebn.xml.importmassivo.libretto.data.LibrettoCatastoDocument.LibrettoCatasto;
import it.csi.sitad.tpnm.entity.Via;
import it.csi.sitad.tpnm.interf.ToponomasticaInterface;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//numIntero();
		
		//System.out.println("PROVA: "+java.lang.Integer.MAX_VALUE);
		//provaGestioneEccezione();
		
//		String pathProv = null;
//		String pathCom = null;
//		String pathCodImp = null;
//		
//		StringBuilder query = new StringBuilder();
//		
//		query.append(Constants.INDEX_ROOT);
//		query.append(Constants.INDEX_FOLDER_SUFFIX);
//		query.append("001");
//		
//		pathProv = query.toString();
//		
//		
//		
//		query.append(Constants.INDEX_FOLDER_SUFFIX);
//		query.append("001272");
//		pathCom = query.toString();
//		
//
//		
//		
//		query.append(Constants.INDEX_FOLDER_SUFFIX);
//		query.append("1234567");
//
//		pathCodImp = query.toString();
//		
//		
//		System.out.println("query # pathProv: "+pathProv);
//		System.out.println("query # pathCom: "+pathCom);
//		System.out.println("query # pathCodImp: "+pathCodImp);

		//testValidatore();
		//testTimeStamp();
		//eliminaCampoVuoto();
		//getFkManut();
		//getProgressivo();
		//aggiungiListaPrimaPosizione();
		//testUnivocitaVoce();
		//testStringTokenizer();
		//testStringTokenizerNew();
		//recuperaIndirizzo();
		//testSubstring();
		
		//testAaep();
		//testContiene();
		//testEspressioneReg();
		//testNumerico();
		
		//testFormatZeroNumero();
		
		//testMassimoDecimali();
		//provaSubList();
		
		//System.out.println("FLG: "+ConvertUtil.flagPdfString(1));
		
		//testFormattaScheda11_1();
		//testSubString();
		
		//testMaxValue();
		
		//testNumeroNegativo();
		
		/*
		try
		{
			ValidationMgr.checkNumero("33333,91", "appDatareeTipo1Dett.deprCanaleFumoPa", 5, 2, null, false);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		Integer pippo = new Integer(1);
		
		System.out.println("pippo: "+pippo);
		boolean isUguale = pippo.equals(1);
		
		System.out.println(isUguale);
	}
	
	public static void testNumeroNegativo(){
	    
		//checkNumero(tipo1Dett.getDeprCanaleFumoPa(), "appDatareeTipo1Dett.deprCanaleFumoPa", 5, 2, validationException, false);

		try
		{
			ValidationManagerException validationException = new ValidationManagerException();
	
			boolean isNumber = checkNumero("-10", "prova", 5, 2, validationException, false);
			
			System.out.println("Stampo isNumber: "+isNumber);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	protected static boolean checkNumero(String numeroDaVerificare, String numberField, Integer maxInteger, Integer maxDecimal, ValidationManagerException ex, boolean checkPositive) throws ValidationManagerException {
		Message message =  checkNumero(numeroDaVerificare, maxInteger, maxDecimal, checkPositive);
		boolean throwEx = false;
		if (ex == null) { //se non viene passata l'eccezione da arricchire allora ci si limita a crearne una e a sollevarla (come e' stato fatto finora)
			//in questo modo si da la possibilita' di arricchire eccezioni pre-invocazione
			ex = new ValidationManagerException();
			throwEx = true;
		}
		if (message != null) {
			ex.addField(numberField, message.getText());
			
			if (throwEx) {
				throw ex;
			} 
			return false; //si errore
		}
		
		return true; //noErrore
		
	}
	
	protected static Message checkNumero(String numeroDaVerificare, Integer maxInteger, Integer maxDecimal, boolean checkPositive){

		Message message = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			// Se il numero ha la virgola, si sostituisce l'eventuale punto con
			// la virgola
			numeroDaVerificare = numeroDaVerificare.replace(",", ".");

			if (!GenericUtil.isNumeroDecimaleValido(numeroDaVerificare, maxInteger, maxDecimal, checkPositive))
			{
				return createNumberErrorMessage(numeroDaVerificare, maxInteger, maxDecimal, null, checkPositive);
			} 
		}
		return message;
	}
	
	private static Message createNumberErrorMessage (String numeroDaVerificare, Integer maxInteger, Integer maxDecimal, Integer maxLength, boolean checkPositive) {
		Message message = null;
		
		if (numeroDaVerificare.startsWith("-") && checkPositive) {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_POSITIVO);
		} else if (maxInteger != null ) {
			if (maxDecimal != null) { //se si valutano sia i maxInteri che i maxDecimali non ha senso valutare la lunghezza massima
				message = new Message(Messages.ERROR_NUMERO_NON_CORRETTO);
				message.replacePlaceholder(maxInteger.toString(), maxDecimal.toString());
			} else {
				if (maxLength != null) {
					message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI_DI_CUI_INTERI);
					message.replacePlaceholder(maxLength.toString(), maxInteger.toString());
				} else {
					message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI);
					message.replacePlaceholder(maxInteger);
				}
			}
		} else if (maxDecimal != null && maxLength != null) {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI_DI_CUI_DECIMALI);
			message.replacePlaceholder(maxDecimal.toString(), maxLength.toString());
		} else if (maxLength != null) {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO_TOT_CARATTERI);
			message.replacePlaceholder(maxLength);
		} else {
			message = new Message(Messages.ERROR_DEVE_ESSERE_NUMERICO);
		}
		
		return message;
	}
	
	public static void testMaxValue(){
	    
		Integer vInteger = Integer.MAX_VALUE;
		int vInt = Integer.MAX_VALUE;
	    System.out.println(vInteger);   
		System.out.println(vInt);   

		System.out.println("java.math.BigDecimal.ZERO: "+java.math.BigDecimal.ZERO);
		System.out.println("java.math.BigDecimal.ONE: "+java.math.BigDecimal.ONE);

		String msgError = "1234567";
		//System.out.println("pippo: "+msgError);
		//System.out.println("pippo: "+msgError.substring(0,100));
		
		System.out.println("pippo: "+msgError.substring(0, (msgError.length() > 10?10:msgError.length())));

	}
	
	public static void testSubString(){
		String clickedNodeId = "F-tipo1E-198";
		
		String cost = "F-tipo1E-";
		
		int pos = cost.length();
		System.out.println("pos: "+pos);
		String res = clickedNodeId.substring(cost.length());
		System.out.println("res: *"+res+"*");
	}
	
	public static void provaSubList(){
		ArrayList<String> al = new ArrayList<String>();

		//Addition of elements in ArrayList
		al.add("Steve");
		al.add("Justin");
		al.add("Ajeet");
		al.add("John");
		al.add("Arnold");
		al.add("Chaitanya");

		System.out.println("Original ArrayList Content: "+al);

		//Sublist to ArrayList
		//ArrayList<String> al2 = new ArrayList<String>(al.subList(1, 4));
		//System.out.println("SubList stored in ArrayList: "+al2);

		//Sublist to List
		List<String> list = al.subList(0, 2);
		System.out.println("SubList stored in List: "+list);
	}


	public static void testFormattaScheda11_1()
	{
		List<SigitVCompGtDettDto> listControlliAll = getTestSigitVCompGtDettDto();
		ArrayList<Scheda11> scheda11List = new ArrayList<Scheda11>();

		List<SigitVCompGtDettDto> listControlli = null;
		
		int righeMax = 6;
		int righeNum = 0; // per la paginazione

		int listAll = listControlliAll.size();
		int listAnalizzati = 0; 
		
		int collMax = 4;
		int listStart = 0;
		int listStop = 0;
		
		
		boolean condition = true;
		
		while (condition) {
			
			if (listAnalizzati <= listAll)
			{
				// devo calcolare lo stop
				if ((listAnalizzati+collMax) >= listAll)
				{
					listStop = listAll;
					
					// Al prossimo giro devo uscire
					condition = false;
				}
				else
				{
					listStop = listAnalizzati+collMax;
				}
				
			}
			
			
			System.out.println("Stampo listStart: "+listStart);
			System.out.println("Stampo listStop: "+listStop);
			System.out.println("Stampo righeMax: "+righeMax);
			System.out.println("Stampo collMax: "+collMax);
			System.out.println("\n\n");
			
			
			// Recupero solo il numero massimo per pagina (orizzontale, 6 per esempio)
			listControlli = listControlliAll.subList(listStart, listStop);
			
			for (SigitVCompGtDettDto controllo : listControlli) {
				System.out.println("controllo.getEBacharachMin(): "+controllo.getEBacharachMin());
			}
			
			scheda11List = getTestListScheda11_1_Intestazione(scheda11List, righeNum, righeMax);
			scheda11List = getTestListScheda11_1_Dati(scheda11List, listControlli, righeNum);
			
			listStart = listStop;
			listAnalizzati = listStop;
			righeNum = righeNum + righeMax;

		}
		
		
		
		
		
		
		for (Scheda11 scheda11 : scheda11List) {
			System.out.println(scheda11.getIntestazione() + " - " + scheda11.getCol1() + " - " + scheda11.getCol2() + " - " + scheda11.getCol3() + " - " + scheda11.getCol4());
		}
		
	}
	
	private static ArrayList<Scheda11> getTestListScheda11_1_Intestazione(ArrayList<Scheda11> scheda11List, int rigaNum, int righeMax)
	{

		// Il numero è uguale alle righe per singola pagina
		for (int i = 0; i < righeMax; i++) {
			scheda11List.add(new Scheda11());
		}


		// Ho settato le intestazioni
		
		
		scheda11List.get(rigaNum++).setIntestazione("Data invio");
		scheda11List.get(rigaNum++).setIntestazione("Modulo Termico");
		scheda11List.get(rigaNum++).setIntestazione("Fumi");
		scheda11List.get(rigaNum++).setIntestazione("Mid");
		scheda11List.get(rigaNum++).setIntestazione("Med");
		scheda11List.get(rigaNum++).setIntestazione("Max");
		
		return scheda11List;
	}
	
	private static ArrayList<Scheda11> getTestListScheda11_1_Dati(ArrayList<Scheda11> scheda11List, List<SigitVCompGtDettDto> listControlli, int rigaNum)
	{
		
		int riga = rigaNum;
		int collMax = listControlli.size();
		// Devo settare i dati
		System.out.println("Stampo collMax: "+collMax);

			int i = 0;
			SigitVCompGtDettDto dto  = null;
			
			if (collMax > 0)
			{
				dto  = listControlli.get(i++);

				riga = rigaNum;

				scheda11List.get(riga++).setCol1(ConvertUtil.convertToString(dto.getDataControllo()));
				scheda11List.get(riga++).setCol1(ConvertUtil.convertToString(dto.getENModuloTermico()));
				scheda11List.get(riga++).setCol1(dto.getEFlgEvacuFumi());
				scheda11List.get(riga++).setCol1(dto.getEBacharachMin());
				scheda11List.get(riga++).setCol1(dto.getEBacharachMed());
				scheda11List.get(riga++).setCol1(dto.getEBacharachMax());
			}

			if (collMax > 1)
			{
				dto  = listControlli.get(i++);
				riga = rigaNum;

				scheda11List.get(riga++).setCol2(ConvertUtil.convertToString(dto.getDataControllo()));
				scheda11List.get(riga++).setCol2(ConvertUtil.convertToString(dto.getENModuloTermico()));
				scheda11List.get(riga++).setCol2(dto.getEFlgEvacuFumi());
				scheda11List.get(riga++).setCol2(dto.getEBacharachMin());
				scheda11List.get(riga++).setCol2(dto.getEBacharachMed());
				scheda11List.get(riga++).setCol2(dto.getEBacharachMax());
			}

			if (collMax > 2)
			{
				dto  = listControlli.get(i++);
				riga = rigaNum;

				scheda11List.get(riga++).setCol3(ConvertUtil.convertToString(dto.getDataControllo()));
				scheda11List.get(riga++).setCol3(ConvertUtil.convertToString(dto.getENModuloTermico()));
				scheda11List.get(riga++).setCol3(dto.getEFlgEvacuFumi());
				scheda11List.get(riga++).setCol3(dto.getEBacharachMin());
				scheda11List.get(riga++).setCol3(dto.getEBacharachMed());
				scheda11List.get(riga++).setCol3(dto.getEBacharachMax());
			}

			if (collMax > 3)
			{
				dto  = listControlli.get(i++);
				riga = rigaNum;

				scheda11List.get(riga++).setCol4(ConvertUtil.convertToString(dto.getDataControllo()));
				scheda11List.get(riga++).setCol4(ConvertUtil.convertToString(dto.getENModuloTermico()));
				scheda11List.get(riga++).setCol4(dto.getEFlgEvacuFumi());
				scheda11List.get(riga++).setCol4(dto.getEBacharachMin());
				scheda11List.get(riga++).setCol4(dto.getEBacharachMed());
				scheda11List.get(riga++).setCol4(dto.getEBacharachMax());
			}
			
			/*
			if (collMax > 4)
			{
				dto  = listControlli.get(i++);
				riga = rigaNum;

				scheda11List.get(riga++).setCol5(ConvertUtil.convertToString(dto.getDataControllo()));
				scheda11List.get(riga++).setCol5(dto.getENModuloTermico());
				scheda11List.get(riga++).setCol5(dto.getEFlgEvacuFumi());
				scheda11List.get(riga++).setCol5(dto.getEBacharachMin());
				scheda11List.get(riga++).setCol5(dto.getEBacharachMed());
				scheda11List.get(riga++).setCol5(dto.getEBacharachMax());
			}

			if (collMax > 5)
			{
				dto  = listControlli.get(i++);
				riga = rigaNum;

				scheda11List.get(riga++).setCol6(ConvertUtil.convertToString(dto.getDataControllo()));
				scheda11List.get(riga++).setCol6(dto.getENModuloTermico());
				scheda11List.get(riga++).setCol6(dto.getEFlgEvacuFumi());
				scheda11List.get(riga++).setCol6(dto.getEBacharachMin());
				scheda11List.get(riga++).setCol6(dto.getEBacharachMed());
				scheda11List.get(riga++).setCol6(dto.getEBacharachMax());
			}
			*/
			
		return scheda11List;
	}
	
	private static List<SigitVCompGtDettDto> getTestSigitVCompGtDettDto()
	{
		List<SigitVCompGtDettDto> listControlli = new ArrayList<SigitVCompGtDettDto>();

		int num = 1;
		SigitVCompGtDettDto dto = new SigitVCompGtDettDto();
		dto.setDataControllo(DateUtil.getSqlCurrentDate());
		dto.setENModuloTermico(num);
		dto.setEFlgEvacuFumi("fumi_"+num);
		dto.setEBacharachMin("min_"+num);
		dto.setEBacharachMed("med_"+num);
		dto.setEBacharachMax("max_"+num);
		
		listControlli.add(dto);
		
		
		num++;
		
		dto = new SigitVCompGtDettDto();
		dto.setDataControllo(DateUtil.getSqlCurrentDate());
		dto.setENModuloTermico(num);
		dto.setEFlgEvacuFumi("fumi_"+num);
		dto.setEBacharachMin("min_"+num);
		dto.setEBacharachMed("med_"+num);
		dto.setEBacharachMax("max_"+num);

		listControlli.add(dto);

		num++;
		
		
		dto = new SigitVCompGtDettDto();
		dto.setDataControllo(DateUtil.getSqlCurrentDate());
		dto.setENModuloTermico(num);
		dto.setEFlgEvacuFumi("fumi_"+num);
		dto.setEBacharachMin("min_"+num);
		dto.setEBacharachMed("med_"+num);
		dto.setEBacharachMax("max_"+num);

		listControlli.add(dto);

		num++;
		
		
		dto = new SigitVCompGtDettDto();
		dto.setDataControllo(DateUtil.getSqlCurrentDate());
		dto.setENModuloTermico(num);
		dto.setEFlgEvacuFumi("fumi_"+num);
		dto.setEBacharachMin("min_"+num);
		dto.setEBacharachMed("med_"+num);
		dto.setEBacharachMax("max_"+num);
		
		listControlli.add(dto);
		
		
		return listControlli;
	}
	
	public static void testMassimoDecimali()
	{
		String yournumber = "1234567890123456.812";
		boolean number = GenericUtil.isNumeroDecimaleValidoMaxDec(yournumber, 2);
		System.out.println(number);

		
	}
	
	public static void testFormatZeroNumero()
	{
		int yournumber = 59;
		String number = String.format("%02d", yournumber);
		System.out.println(number);

		String descComponente = "AC-2";
		System.out.println("descComponente: "+descComponente);
		System.out.println("TipoComponente: "+GenericUtil.getTipoComponente(descComponente));
		System.out.println("ProgrComponente: "+GenericUtil.getProgrComponente(descComponente));
		
	}
	
	public static void testNumerico()
	{
		String valore = "01.1234567890123456789";
		//boolean res = GenericUtil.checkIsNotInteger(valore);
		
		boolean res = GenericUtil.isDecimalNumber(valore);
		System.out.println("Stampo res: "+res);
		
		String resS = ConvertUtil.convertToString(new BigDecimal(valore), 14);
		System.out.println("Stampo resS: "+resS);
		
		//BigDecimal resB = ConvertUtil.convertToBigDecimal(valore, 14);
//		System.out.println("Stampo resB: "+resB);
		
		
		BigDecimal resN = ConvertUtil.convertToBigDecimal(valore, 14);
//		new BigDecimal(valore);
//		resN = resN.setScale(14, BigDecimal.ROUND_HALF_UP);
		
		System.out.println("Stampo resN: "+resN);

		

	}
	
	public static void testEspressioneReg()
	{
		/*
		String CODICE_FISCALE = "[a-zA-Z]{6}[\\dlmnpqrstuvLMNPQRSTUV]{2}[abcdehlmprstABCDEHLMPRST][\\dlmnpqrstuvLMNPQRSTUV]{2}[a-zA-Z][\\dlmnpqrstuvLMNPQRSTUV]{3}[a-zA-Z]";
		
		//IT000E0000000
		String pdr = "IT020E00949669";
		String regExp = "IT[0-9]{3}[a-zA-Z]{1}[0-9]";

		String pdrN = "IT020E00949669";
		String regExpN = "IT[0-9]{3}[a-zA-Z]{1}[0-9]+";
		
		boolean result = GenericUtil.isStringValid(pdrN, regExpN);
		
		System.out.println("Stampo il result: "+result);
		*/
		ValidationMgr vMgr = new ValidationMgr();
		try {
			System.out.println("Prima");
			vMgr.checkPDR("AAAAAAAAAAAAAAA", ConstantsField.GESTISCI_IMPIANTO_LOC_PDR);
			System.out.println("Dopo");
		} catch (ValidationManagerException e) {
			
			System.out.println("sono nel catch"); 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public static void testContiene()
	{
		String errore = " cercaPerCodiceFiscaleINFOCAMERE: Nessun record trovato";
		
		if (errore.contains(Constants.AAEP_COD_NESSUN_RISULTATO))
		{
			System.out.println("ERRORE: NESSUN ELEMENTO TROVATO");
		}
		else
		{
			System.out.println("ERRORE: ALTRO");
		}
		
	}
	public static void testAaep()
	{
		try
		{
			URL url = new URL("http://tst-applogic.reteunitaria.piemonte.it/aaeporch/OrchestratoreService?wsdl");

			OrchestratoreImplService serviceAaep = new OrchestratoreImplService(url);

			it.csi.aaep.aaeporch.business.Utente utente = new it.csi.aaep.aaeporch.business.Utente();
			utente.setCodiceFiscaleUtente("01454840032");
			Impresa impresa = serviceAaep.getOrchestratoreImplPort().getDettaglioImpresa(utente, "INFOC", "01454840032");

			GenericUtil.stampa(impresa, true, 3);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void testSubstring()
	{
		String descCompl = Constants.CAT_RUOLO_IMPRESA;
		String desc = null;
		
		System.out.println("is CAT: "+descCompl.startsWith(Constants.CAT_RUOLO_PREFISSO));
		
		System.out.println("Stampo la desc completa: "+descCompl);
		System.out.println("Posizione: "+descCompl.indexOf(Constants.CAT_RUOLO_PREFISSO));
		
		desc = descCompl.replace(Constants.CAT_RUOLO_PREFISSO, "");
		
		System.out.println("Stampo la desc mod: *"+desc+"*");

		
	}
	
	private static ToponomasticaInterface getToponomastica() {
		System.out.println("[ServiziMgr::getToponomastica] BEGIN");
		
		
		InfoPortaDelegata info = PDConfigReader
				.read("pd_topesv_Topo.xml");
		
		it.csi.sitad.tpnm.interf.ToponomasticaInterface pd = (it.csi.sitad.tpnm.interf.ToponomasticaInterface) PDProxy
				.newInstance(info);
		
		return pd;
		/*
		
		
		InputStream is = getClass().getResourceAsStream("/test/pd_topesv_Topo.xml");
		if (is != null) {
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				return (ToponomasticaInterface) PDProxy.newInstance(info);
			} 
			catch (Exception e) {
				System.out.println("[ServiziMgr::getToponomastica] errore nella parsificazione della configurazione di TOPE:"+ e);
				throw new IllegalArgumentException("errore nella parsificazione della configurazione di TOPE");
			}
			
		} else{
			System.out.println("[ServiziMgr::getToponomastica] configurazione di TOPE non trovata");
		}
		throw new IllegalArgumentException("configurazione di TOPE non trovata");
		*/
	}
	
	public static void recuperaIndirizzo()
	{
		ToponomasticaInterface pd = getToponomastica();
		
		try {
			Via via = pd.cercaViaById(17658);
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CSIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(pd);
	}
	
	public static void testStringTokenizer()
	{
	
	
		StringBuffer sb = new StringBuffer();
		
		
			StringTokenizer tok = new StringTokenizer("GT-2 (AB - 2RG6 (Pot. Term. focol. 115,12 kw)), GT-4 (ABS - DUOTERM 21 (FERELLA C24 MEL), GT-7 (AB PROVA - 2RG6 (Pot. Term. focol. 115,12 (kw))", ",");

			String app = null;
			while (tok.hasMoreTokens()) {
				String tmp = tok.nextToken();

				System.out.println("Stampo tmp: "+tmp);
				
				if (tmp.indexOf(" (") != -1)
				{
					app = tmp.substring(0, tmp.indexOf(" ("));
	
					//System.out.println("temp2 *"+app+"*");
	
					if (sb.length() > 0)
					{
						sb.append(", ");
					}
					
					sb.append(app.trim());
				}
			}
				
		System.out.println("RESULT: "+sb);
		
	}
	
	public static void testStringTokenizerNew()
	{
	
	
		StringBuffer sb = new StringBuffer();
		
		String valore = ",,12344,4345, , 45454, 44,";
		
		int virgola = valore.indexOf(",,");
		
		System.out.println("Stampo virgola: "+virgola);
		
			StringTokenizer tok = new StringTokenizer(valore, ",");

			String app = null;
			while (tok.hasMoreTokens()) {
				String tmp = tok.nextToken();
				System.out.println("Stampo tmp: *"+tmp+"*");

				/*
				if (tmp.indexOf(" (") != -1)
				{
					app = tmp.substring(0, tmp.indexOf(" ("));
	
					//System.out.println("temp2 *"+app+"*");
	
					if (sb.length() > 0)
					{
						sb.append(", ");
					}
					
					sb.append(app.trim());
				}
				*/
			}
				
		System.out.println("RESULT: "+sb);
		
	}
	
	public static void testUnivocitaVoce()
	{
		HashMap<String, String> hashComb = new HashMap<String, String>();

		hashComb.put("a", "a");
		hashComb.put("b", "b");
		hashComb.put("a", "a");
		hashComb.put("b", "b");
		hashComb.put("a", "a");
		
		System.out.println("hashComb: "+hashComb);
		
		Collection coll = hashComb.values();
		
		for (Object object : coll) {
			System.out.println("Stampo object: "+object);
			String obj = (String)object;
			System.out.println("Stampo obj: "+obj);

		}
	}
	
	public static void aggiungiListaPrimaPosizione()
	{
		ArrayList<String> apparecchiatureList = new ArrayList<String>();
		
		apparecchiatureList.add("UNO");
		apparecchiatureList.add("DUE");
		apparecchiatureList.add("TRE");
		apparecchiatureList.add("QUATTRO");
		
		apparecchiatureList.add(0, "ZERO");
		
		System.out.println("Stampo la lista: "+apparecchiatureList);
	}
	
	public static void getFkManut()
	{
		
		String manutProgressivo = "-2--2-1";
		System.out.println("input: "+manutProgressivo);

		
		StringTokenizer st = new StringTokenizer(manutProgressivo,Constants.INTERVAL_SEP);
		
		String idManut4 = st.nextToken();
		System.out.println("idManut4: "+idManut4);
		
		String manut = st.nextToken();
		System.out.println("manut: "+manut);

		
		
		String prog = st.nextToken();
		System.out.println("prog: "+prog);
		
		/*
		String manut = manutProgressivo.substring(0,manutProgressivo.indexOf(Constants.INTERVAL_SEP));
		System.out.println("manut: "+manut);

		String idManut4 = manutProgressivo.substring(manutProgressivo.indexOf(Constants.INTERVAL_SEP),manutProgressivo.indexOf(Constants.INTERVAL_SEP));
		System.out.println("idManut4: "+idManut4);
		
		String prog = manutProgressivo.substring(manutProgressivo.indexOf(Constants.INTERVAL_SEP)+1);
		System.out.println("prog: "+prog);
		*/
	}
	
	public static void getIdManut4()
	{
		String manutProgressivo = "123-456-7";
		System.out.println("input: "+manutProgressivo);

		String ret = manutProgressivo.substring(0,manutProgressivo.indexOf(Constants.INTERVAL_SEP));
		System.out.println("ret: "+ret);
	}
	
	
	public static void getProgressivo()
	{
		String manutProgressivo = "123-456-7";
		System.out.println("input: "+manutProgressivo);

		String ret = manutProgressivo.substring(manutProgressivo.indexOf(Constants.INTERVAL_SEP)+1);
		System.out.println("ret: "+ret);
	}
	
	public static void eliminaCampoVuoto()
	{
		ArrayList<String> prova = new ArrayList<String>();
		
		prova.add(null);
		prova.add("");
		prova.add("primo");
		prova.add("secondo");
		
		prova.remove(null);
		prova.remove("");
		
		
		System.out.println("Prova: "+prova);
	}
	
	public static void testTimeStamp()
	{
		//java.sql.Timestamp stamp = new java.sql.Timestamp(System.currentTimeMillis());
		java.sql.Timestamp stamp = 
				new java.sql.Timestamp(2012, 2, 16, 05, 16, 17, 0);
		
		System.out.println(stamp);
		java.sql.Date date = new java.sql.Date(stamp.getTime());
		System.out.println(date);
	}
	
	public static void testValidatore()
	{
		String ruolo = "ISPETTOREX";
		String codImpianto = "";
		if (!(ruolo
				.equalsIgnoreCase(Constants.RUOLO_ISPETTORE) && 
				GenericUtil.isNullOrEmpty(codImpianto))) {

			System.out.println("Verifico codice impianto");
		}
		else
		{
			System.out.println("NON verifico codice impianto");
		}
		
	}
	
	public static void numIntero()
	{
		System.out.println("PROVA");

		//checkNumeroIntero("1111");
		checkNumeroIntero("1111", 3);
		//checkNumeroIntero(1111, 3);
		//calcola();
		//verificaInt();
		
	}
	
	
	private static void provaGestioneEccezione() 
	{
		try
		{
			generaDBException();
			//generaValidationException();
		} catch (ManagerException ex) {
			gestisciEccezione(ex);
		}
		
	}
	
	private static void generaDBException() throws DbManagerException
	{
		throw new DbManagerException(new SigitDRuoloDaoException("prova DB"), new Message(Messages.ERROR_UPDATE_DB));
	}
	
	private static void generaValidationException() throws ManagerException
	{
		throw new ValidationManagerException(new Message(Messages.ERROR_IS_IMPRESA_MANCANTE));
	}

	
	private static void gestisciEccezione(ManagerException e) {
		Message message = null;

		message = e.getMsg();

		System.out.println("STAMPO IL MESSAGGIO: "+message);
		
		System.out.println("Stampo l'eccezione: "+e);
		
		
		if (e instanceof ValidationManagerException)
		{
			System.out.println("E' un validation Exception");
		}
		else if (e instanceof DbManagerException)
		{
			System.out.println("E' un DB Exception");
		} 

	}
	
	private static void verificaInt() 
	{

		int prova = -1;
		
		System.out.println("Stampo prova: "+prova);
		
	}
	
	private static void checkNumeroIntero(String numeroDaVerificare) 
	{

		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
				if (!GenericUtil.checkValideNumber(numeroDaVerificare))
				{
					System.out.println("NON E' UN NUMERO INTERO");
				}
		}
		
	}
	
	private static void checkNumeroIntero(String numeroDaVerificare,  int maxLenght) {
		ValidationManagerException ex = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			if (!GenericUtil.checkValideLenghtNumber(numeroDaVerificare, maxLenght))
			{
				System.out.println("NON E' UN NUMERO INTERO");
			}
		}

	}
	
	private static void checkNumeroIntero(Integer numeroDaVerificare,  int maxLenght) {
		ValidationManagerException ex = null;
		if (GenericUtil.isNotNullOrEmpty(numeroDaVerificare))
		{
			System.out.println("numeroDaVerificare.SIZE: "+numeroDaVerificare.SIZE);
			
//			if (!GenericUtil.checkValideLenghtNumber(numeroDaVerificare, maxLenght))
//			{
//				System.out.println("NON E' UN NUMERO INTERO");
//			}
		}

	}
	private static void calcola()
	{
		Integer qtaMinore35 = 2;
		Integer qta35_116 = null;
		
		Double prezzoMinore35 = new Double("8.00");
		Double prezzo35_116 = new Double("18.50");;
		
		BigDecimal totale = new BigDecimal(0);

		if (GenericUtil.isNotNullOrEmpty(qtaMinore35)) {
			Double totMinore35 = (prezzoMinore35 * qtaMinore35);
			
			System.out.println("Stampo il tot parziale 35_116: "+totMinore35);
			totale = totale.add(new BigDecimal(totMinore35));
			System.out.println("Stampo il tot: "+totale);

		}

		if (GenericUtil.isNotNullOrEmpty(qta35_116)) {
			Double tot35_116 = (prezzo35_116 * qta35_116);
			System.out.println("Stampo il tot parziale 35_116: "+tot35_116);
			totale = totale.add(new BigDecimal(tot35_116));
			System.out.println("Stampo il tot: "+totale);

		}


		System.out.println("STAMP IL TOTALE: "+totale); 
	}
	
	
	public DettaglioAllegatoIndex getLibrettoIndexMARGE(String idImpianto) throws ServiceException {
		return null;
		
		// Questo codice funziona se implementato nell'applicativo
		/*
		log.debug("[ServiziMgr::getLibrettoIndexMARGE] BEGIN");
		DettaglioAllegatoIndex result = new DettaglioAllegatoIndex();
		try {
			OperationContext oc = indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

			byte[] file = null;
			String uid = null;


			List<SigitTLibrettoDto> librettoList = getDbMgr().cercaLibrettoByStato(idImpianto,  Constants.ID_STATO_LIBRETTO_CONSOLIDATO);
			
			if (librettoList == null || librettoList.size() == 0)
			{
				// Non esiste un libretto consolidato
				throw new ServiceException(Messages.S056);

			}
			
			//librettoList dovrebbe avere un solo libretto in stato bozza
			SigitTLibrettoDto libretto = librettoList.get(0);
			
			
			if (libretto != null)
			{
				if (GenericUtil.isNotNullOrEmpty(libretto.getUidIndex()))
				{
					uid = libretto.getUidIndex();
					file = indexOpenFileByUID(uid, libretto.getFileIndex(), oc);
				}
				
				if (file == null)
				{
					SigitTImpiantoDto impianto = getDbMgr().cercaImpiantoDtoById(idImpianto);

					Metadati md = new Metadati();
					md.setCodiceImpianto(ConvertUtil.convertToString(impianto.getCodiceImpianto()));
					md.setCodIstatComune(impianto.getIstatComune());
					md.setCodIstatProvincia(StringUtils.substring(impianto.getIstatComune(), 0, 3));
					md.setDataRapporto(ConvertUtil.convertToString(impianto.getDataIntervento()));
					md.setIdRapporto(ConvertUtil.convertToString(libretto.getIdLibretto()));
					
					uid = indexSearchUIDFileInFolderNew(libretto.getFileIndex(), md, oc, Constants.INDEX_FOLDER_LIBRETTI);
					
					if (uid != null)
					{
						file = indexOpenFileByUID(uid, libretto.getFileIndex(), oc);
					}
				}
				
			}

			log.debug("[ServiziMgr::getLibrettoIndexMARGE] INIZIO prova");

			// PROVO AD UNIRE I DUE LIBRETTI - inizio
	        List<byte[]> list = new ArrayList<byte[]>();
            list.add(file);
            list.add(file);

			Document document = new Document();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	        document.open();
	        PdfContentByte cb = writer.getDirectContent();
	        
	        for (byte[] in : list) {
	            PdfReader reader = new PdfReader(in);
	            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	                document.newPage();
	                //import the page from source pdf
	                PdfImportedPage page = writer.getImportedPage(reader, i);
	                //add the page to the destination pdf
	                cb.addTemplate(page, 0, 0);
	            }
	        }
	        
	        outputStream.flush();
	        document.close();
	        outputStream.close();
			
	        byte[] ret = outputStream.toByteArray();

	        log.debug("[ServiziMgr::getLibrettoIndexMARGE] FINE prova");

			
			// PROVO AD UNIRE I DUE LIBRETTI - fine
			
			result.setFile(ret);
			result.setNomeAllegato(libretto.getFileIndex());
			
			return result;

		}
		catch (ServiceException e) {
			log.error("ServiceException getLibrettoIndexMARGE",e);
			throw e;
		}
		catch (Exception e) {
			log.error("Errore getLibrettoIndexMARGE",e);
			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
		}finally{
			log.debug("[ServiziMgr::getLibrettoIndexMARGE] END");
		}
		*/
	}
}
