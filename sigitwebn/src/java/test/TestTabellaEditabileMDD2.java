package test;

import java.util.ArrayList;

import it.csi.sigit.sigitwebn.dto.libretto.Consumo;


public class TestTabellaEditabileMDD2 {

	/**
	 * @param args
	 */

	// Questi sono elementi da mantenere in sessione
	private static ArrayList<Consumo> listRisultatiConsumoMemoria = null;
	private static ArrayList<Consumo> listRisultatiConsumoWeb = null;
	private static ArrayList<Integer> listConsumiDaEliminare = new ArrayList<Integer>();

	public static void main(String[] args) {

		Consumo testConsumoMemoria;

		listRisultatiConsumoMemoria = testMDDRecuperaTabellaDB();
		listRisultatiConsumoWeb = testMDDCreaTabWeb(listRisultatiConsumoMemoria);
		testMDDStampaTabMemoria(listRisultatiConsumoMemoria);
		testMDDStampaTabWeb(listRisultatiConsumoWeb);

		//////////////////////////

		// Arriva il comando di eliminare la riga 3 (quindi posizione 2 dell'Array in memoria)
		int rigaRemove = 3;
		testMDDRimuoviElemento(rigaRemove);

		// Arriva il comando di aggiungere una riga
		testMDDAggiungiElemento();

		// Arriva il comando di aggiungere una riga
		testMDDAggiungiElemento();

		// Arriva il comando di eliminare la riga 5 (quindi posizione 4 dell'Array in memoria)
		rigaRemove = 5;
		testMDDRimuoviElemento(rigaRemove);

		// Arriva il comando di eliminare la riga 3 (quindi posizione 2 dell'Array in memoria)
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
			testConsumoMemoria = listRisultatiConsumoMemoria.get(i);

			if (testConsumoMemoria != null && testConsumoMemoria.getIdConsumo() != null)
			{
				testConsumoWeb.setIdConsumo(testConsumoMemoria.getIdConsumo());
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
		System.out.println("Tolgo la riga "+rigaRemove + " - quindi l'elento " + (rigaRemove-1) + " della memoria ");

		Consumo testConsumoMemoria = listRisultatiConsumoMemoria.get(rigaRemove-1);

		// Verifico se l'elemento da eliminare ha l'id (del DB)

		if (testConsumoMemoria != null && testConsumoMemoria.getIdConsumo() != null)
		{
			// Sto eliminando una riga che era presente sul DB
			listConsumiDaEliminare.add(testConsumoMemoria.getIdConsumo());
		}

		listRisultatiConsumoMemoria.remove(rigaRemove-1);

		listRisultatiConsumoMemoria = testMDDCreaTabMomoria(listRisultatiConsumoMemoria);
		listRisultatiConsumoWeb = testMDDCreaTabWeb(listRisultatiConsumoMemoria);
		testMDDStampaTabMemoria(listRisultatiConsumoMemoria);
		testMDDStampaTabWeb(listRisultatiConsumoWeb);

	}

	private static void testMDDAggiungiElemento()
	{
		System.out.println("\n\n-------------------------------------------------");
		System.out.println("Aggiungo una riga");

		Consumo testConsumoMemoria = new Consumo();
		listRisultatiConsumoMemoria.add(testConsumoMemoria);

		listRisultatiConsumoMemoria = testMDDCreaTabMomoria(listRisultatiConsumoMemoria);
		listRisultatiConsumoWeb = testMDDCreaTabWeb(listRisultatiConsumoMemoria);
		testMDDStampaTabMemoria(listRisultatiConsumoMemoria);
		testMDDStampaTabWeb(listRisultatiConsumoWeb);

	}


	private static ArrayList<Consumo> testMDDCreaTabMomoria(ArrayList<Consumo> listRisultatiConsumoWebOld)
	{
		ArrayList<Consumo> listRisultatiConsumoWeb = new ArrayList<Consumo>();

		Consumo testConsumo;
		Consumo consumo;

		for (int i = 0; i < listRisultatiConsumoWebOld.size(); i++) {
			consumo = listRisultatiConsumoWebOld.get(i);

			testConsumo = new Consumo();
			testConsumo.setIndice(i);
			testConsumo.setIdConsumo(consumo.getIdConsumo());
			testConsumo.setEsercizioDa(consumo.getEsercizioDa());
			testConsumo.setEsercizioA(consumo.getEsercizioA());

			listRisultatiConsumoWeb.add(testConsumo);
		}

		return listRisultatiConsumoWeb;
	}

	private static ArrayList<Consumo> testMDDCreaTabWeb(ArrayList<Consumo> listRisultatiConsumoMemoria)
	{
		ArrayList<Consumo> listRisultatiConsumoWeb = new ArrayList<Consumo>();

		Consumo testConsumo;
		Consumo consumo;

		for (int i = 0; i < listRisultatiConsumoMemoria.size(); i++) {
			consumo = listRisultatiConsumoMemoria.get(i);

			testConsumo = new Consumo();
			testConsumo.setIndice(i+1);
			//testConsumo.setIdConsumo(consumo.getIdConsumo());
			testConsumo.setEsercizioDa(consumo.getEsercizioDa());
			testConsumo.setEsercizioA(consumo.getEsercizioA());

			listRisultatiConsumoWeb.add(testConsumo);
		}

		return listRisultatiConsumoWeb;
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

	private static void testMDDStampaTabMemoria(ArrayList<Consumo> listRisultatiConsumoWeb)
	{
		Consumo testConsumo;

		System.out.println("\n\nStampo la tabella MEMORIA (di appoggio)\n");
		for (int i = 0; i < listRisultatiConsumoWeb.size(); i++) {
			testConsumo = listRisultatiConsumoWeb.get(i);

			System.out.println(testConsumo.getIndice() + " - " + testConsumo.getIdConsumo() + " - " + testConsumo.getEsercizioDa() + " - " + testConsumo.getEsercizioA());
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

			System.out.println(consumo.getIdConsumo() + " - " + consumo.getEsercizioDa() + " - " + consumo.getEsercizioA());
		}

		ArrayList<Consumo> listRisultatiConsumoMemoria = testMDDCreaTabMemoriaOrig(listRisultatiConsumo);

		return listRisultatiConsumoMemoria;
	}

}
