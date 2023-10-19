package test;

import java.util.ArrayList;

import it.csi.sigit.sigitwebn.dto.libretto.Consumo;
import it.csi.sigit.sigitwebn.util.ConvertUtil;


public class TestTabellaEditabileMDD {

	/**
	 * @param args
	 */

	// Questi sono elementi da mantenere in sessione
	private static ArrayList<TestPkMemConsumo> listRisultatiPkChiviMemoria = null;
	private static ArrayList<Consumo> listRisultatiConsumoWeb = null;
	private static ArrayList<Integer> listConsumiDaEliminare = new ArrayList<Integer>();

	public static void main(String[] args) {

		TestPkMemConsumo testConsumoPk;

		ArrayList<Consumo> listRisultatiConsumoDB = testMDDRecuperaTabellaDB();
		listRisultatiPkChiviMemoria = testMDDCreaTabPkMomoriaOrig(listRisultatiConsumoDB);
		listRisultatiConsumoWeb = testMDDCreaTabWeb(listRisultatiConsumoDB);
		
		testMDDStampaPkMemoria(listRisultatiPkChiviMemoria);;
		testMDDStampaTabWeb(listRisultatiConsumoWeb);

		//////////////////////////

		// Arriva il comando di eliminare la riga 3 (quindi posizione 2 dell'Array dei PK)
		int rigaRemove = 3;
		testMDDRimuoviElemento(rigaRemove);

		// Arriva il comando di aggiungere una riga
		testMDDAggiungiElemento();

		// Arriva il comando di aggiungere una riga
		testMDDAggiungiElemento();

		// Arriva il comando di eliminare la riga 5 (quindi posizione 4 dell'Array dei PK)
		rigaRemove = 5;
		testMDDRimuoviElemento(rigaRemove);

		// Arriva il comando di eliminare la riga 3 (quindi posizione 2 dell'Array dei PK)
		rigaRemove = 3;
		testMDDRimuoviElemento(rigaRemove);

		// L'utente decide di salvare
		// Devo capire di cosa fare l'insert/update/delete
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("Stampo cosa bisogna fare sul DB");
		// Recupero l'array del web per recuperare i dati per capire insert/update
		Consumo testConsumoWeb;
		
		for (int i = 0; i < listRisultatiConsumoWeb.size(); i++) {

			testConsumoWeb = listRisultatiConsumoWeb.get(i);
			testConsumoPk = listRisultatiPkChiviMemoria.get(i);

			if (testConsumoPk != null && testConsumoPk.getIdConsumo() != null)
			{
				testConsumoWeb.setIdConsumo(testConsumoPk.getIdConsumo());
				
				System.out.println("UPDATE: "+testConsumoWeb.getIndice() + " - " + testConsumoWeb.getIdConsumo() + " - " + testConsumoWeb.getEsercizioDa() + " - " + testConsumoWeb.getEsercizioA());

				// testConsumoWeb - oggetto di cui bisogna fare l'update

			}
			else
			{
				// testConsumoWeb - oggetto di cui bisogna fare l'insert
				System.out.println("INSERT: "+testConsumoWeb.getIndice() + " - " + testConsumoWeb.getEsercizioDa() + " - " + testConsumoWeb.getEsercizioA());

			}
		}

		for (Integer testConsumoEliminare : listConsumiDaEliminare) {
			System.out.println("DELETE: "+testConsumoEliminare);

		}
		
	}


	private static void testMDDRimuoviElemento(Integer rigaRemove)
	{
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("Tolgo la riga "+rigaRemove + " - quindi l'elemento " + (rigaRemove-1) + " dei PK ");

		TestPkMemConsumo testPkConsumoMemoria = listRisultatiPkChiviMemoria.get(rigaRemove-1);

		// Verifico se l'elemento da eliminare ha l'id (del DB)

		if (testPkConsumoMemoria != null && testPkConsumoMemoria.getIdConsumo() != null)
		{
			// Sto eliminando una riga che era presente sul DB
			listConsumiDaEliminare.add(testPkConsumoMemoria.getIdConsumo());
		}

		listRisultatiConsumoWeb.remove(rigaRemove-1);
		listRisultatiPkChiviMemoria.remove(rigaRemove-1);
		
		listRisultatiConsumoWeb = testMDDCreaTabWeb(listRisultatiConsumoWeb);
		listRisultatiPkChiviMemoria = testMDDCreaTabPkMomoria(listRisultatiPkChiviMemoria);
		
		testMDDStampaPkMemoria(listRisultatiPkChiviMemoria);
		testMDDStampaTabWeb(listRisultatiConsumoWeb);

	}

	private static void testMDDAggiungiElemento()
	{
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("Aggiungo una riga");

		//System.out.println("listRisultatiConsumoWeb.size(): "+listRisultatiConsumoWeb.size());
		//System.out.println("listRisultatiPkChiviMemoria.size(): "+listRisultatiPkChiviMemoria.size());

		//Consumo testConsumoMemoria = new Consumo();
		//testConsumoMemoria.setIndice(listRisultatiConsumoWeb.size());
		listRisultatiConsumoWeb.add(new Consumo());
		
		//TestPkMemConsumo testConsumoPk = new TestPkMemConsumo();
		//testConsumoPk.setIdTabella(listRisultatiPkChiviMemoria.size()-1);
		listRisultatiPkChiviMemoria.add(new TestPkMemConsumo());

		listRisultatiConsumoWeb = testMDDCreaTabWeb(listRisultatiConsumoWeb);
		listRisultatiPkChiviMemoria = testMDDCreaTabPkMomoria(listRisultatiPkChiviMemoria);
		
		testMDDStampaPkMemoria(listRisultatiPkChiviMemoria);
		testMDDStampaTabWeb(listRisultatiConsumoWeb);

	}



	private static ArrayList<TestPkMemConsumo> testMDDCreaTabPkMomoria(ArrayList<TestPkMemConsumo> listRisultatiPkChiviMemoriaOld)
	{
		ArrayList<TestPkMemConsumo> listRisultatiPkChiviMemoriaNew = new ArrayList<TestPkMemConsumo>();

		TestPkMemConsumo consumoNew;
		TestPkMemConsumo consumoOld;

		for (int i = 0; i < listRisultatiPkChiviMemoriaOld.size(); i++) {
			consumoOld = listRisultatiPkChiviMemoriaOld.get(i);

			consumoNew = new TestPkMemConsumo();
			consumoNew.setIdTabella(i);
			consumoNew.setIdConsumo(consumoOld.getIdConsumo());
			
			consumoNew.setTmpEsercizioDa(consumoOld.getTmpEsercizioDa());
			consumoNew.setTmpEsercizioA(consumoOld.getTmpEsercizioA());
			
			listRisultatiPkChiviMemoriaNew.add(consumoNew);
		}

		return listRisultatiPkChiviMemoriaNew;
	}
	
	private static ArrayList<Consumo> testMDDCreaTabWeb(ArrayList<Consumo> listRisultatiConsumoWeb)
	{
		ArrayList<Consumo> listRisultatiConsumoWebNew = new ArrayList<Consumo>();

		Consumo testConsumo;
		Consumo consumo;

		for (int i = 0; i < listRisultatiConsumoWeb.size(); i++) {
			consumo = listRisultatiConsumoWeb.get(i);

			testConsumo = new Consumo();
			testConsumo.setIndice(i+1);
			testConsumo.setEsercizioDa(consumo.getEsercizioDa());
			testConsumo.setEsercizioA(consumo.getEsercizioA());

			listRisultatiConsumoWebNew.add(testConsumo);
		}

		return listRisultatiConsumoWebNew;
	}

	private static ArrayList<TestPkMemConsumo> testMDDCreaTabPkMomoriaOrig(ArrayList<Consumo> listRisultatiConsumoWeb)
	{
		ArrayList<TestPkMemConsumo> listRisultatiPkChiviMemoriaNew = new ArrayList<TestPkMemConsumo>();

		TestPkMemConsumo testConsumo;
		Consumo consumo;

		for (int i = 0; i < listRisultatiConsumoWeb.size(); i++) {
			consumo = listRisultatiConsumoWeb.get(i);

			testConsumo = new TestPkMemConsumo();
			testConsumo.setIdTabella(i);
			testConsumo.setIdConsumo(consumo.getIdConsumo());
			
			testConsumo.setTmpEsercizioDa(ConvertUtil.convertToInteger(consumo.getEsercizioDa()));
			testConsumo.setTmpEsercizioA(ConvertUtil.convertToInteger(consumo.getEsercizioA()));
			
			listRisultatiPkChiviMemoriaNew.add(testConsumo);
		}

		return listRisultatiPkChiviMemoriaNew;
	}

	
	private static ArrayList<Consumo> testMDDCreaTabMemoriaOrig(ArrayList<Consumo> listRisultatiConsumo)
	{
		ArrayList<Consumo> listRisultatiConsumoWeb = new ArrayList<Consumo>();

		Consumo testConsumo;
		Consumo consumo;

		for (int i = 0; i < listRisultatiConsumo.size(); i++) {
			consumo = listRisultatiConsumo.get(i);

			testConsumo = new Consumo();
			testConsumo.setIndice(i);
			testConsumo.setIdConsumo(consumo.getIdConsumo());
			testConsumo.setEsercizioDa(consumo.getEsercizioDa());
			testConsumo.setEsercizioA(consumo.getEsercizioA());

			listRisultatiConsumoWeb.add(testConsumo);
		}

		return listRisultatiConsumoWeb;
	}

	private static void testMDDStampaPkMemoria(ArrayList<TestPkMemConsumo> listRisultatiConsumoWeb)
	{
		TestPkMemConsumo testConsumo;

		System.out.println("\n\nStampo la tabella PK MEMORIA (di appoggio)\n");
		for (int i = 0; i < listRisultatiConsumoWeb.size(); i++) {
			testConsumo = listRisultatiConsumoWeb.get(i);

			System.out.println(testConsumo.getIdTabella() + " - " + testConsumo.getIdConsumo() + " - (" + testConsumo.getTmpEsercizioDa() + ") - (" + testConsumo.getTmpEsercizioA() + ")");
		}
	}
	
	private static void testMDDStampaTabWeb(ArrayList<Consumo> listRisultatiConsumoWeb)
	{
		Consumo testConsumo;

		System.out.println("\n\nStampo la tabella WEB (da visualizzare)\n");
		for (int i = 0; i < listRisultatiConsumoWeb.size(); i++) {
			testConsumo = listRisultatiConsumoWeb.get(i);

			System.out.println(testConsumo.getIndice() + " - " + testConsumo.getEsercizioDa() + " - " + testConsumo.getEsercizioA());
		}
	}

	private static ArrayList<Consumo> testMDDRecuperaTabellaDB()
	{
		ArrayList<Consumo> listRisultatiConsumo = new ArrayList<Consumo>();

		Consumo consumo;

		consumo = new Consumo();
		consumo.setIdConsumo(123);
		consumo.setEsercizioDa("2000");
		consumo.setEsercizioA("2001");
		listRisultatiConsumo.add(consumo);

		consumo = new Consumo();
		consumo.setIdConsumo(534);
		consumo.setEsercizioDa("2002");
		consumo.setEsercizioA("2003");
		listRisultatiConsumo.add(consumo);

		consumo = new Consumo();
		consumo.setIdConsumo(756);
		consumo.setEsercizioDa("2004");
		consumo.setEsercizioA("2005");
		listRisultatiConsumo.add(consumo);

		consumo = new Consumo();
		consumo.setIdConsumo(676);
		consumo.setEsercizioDa("2006");
		consumo.setEsercizioA("2007");
		listRisultatiConsumo.add(consumo);

		consumo = new Consumo();
		consumo.setIdConsumo(234);
		consumo.setEsercizioDa("2008");
		consumo.setEsercizioA("2009");
		listRisultatiConsumo.add(consumo);

		System.out.println("Stampo la ricerca DB\n");
		// Stampo l'array listRisultatiConsumo
		for (int i = 0; i < listRisultatiConsumo.size(); i++) {
			consumo = listRisultatiConsumo.get(i);

			consumo.setIndice(i);
			
			System.out.println(consumo.getIdConsumo() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());
		}

		ArrayList<Consumo> listRisultatiConsumoMemoria = testMDDCreaTabMemoriaOrig(listRisultatiConsumo);

		return listRisultatiConsumoMemoria;
	}

}
