/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn;

import it.csi.sigit.sigitbatchn.batch.Batch;
import it.csi.sigit.sigitbatchn.batch.BatchEnum;
import it.csi.sigit.sigitbatchn.batch.BatchException;
import it.csi.sigit.sigitbatchn.business.util.LoggerHelper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Esegue il batch richiesto
 * 
 * @author 71845 - Marco Giacometto
 */
public class Exec {
	/**
	 * Nome della classe
	 */
	private final static String CLASS_NAME = Exec.class.getSimpleName();
	/**
	 * Argomento contenente il nome del batch da eseguire
	 */
	private final static int BATCH_NAME_ARG = 0;
	/**
	 * Indice dell'application context dei DAO
	 */
	private final static int DAO_APPLICATION_CONTEXT_INDEX = 0;
	/**
	 * Indice dell'application context comune a tutti i batch
	 */
	private final static int COMMON_APPLICATION_CONTEXT_INDEX = 1;
	/**
	 * Indice dell'application context dei singoli batch
	 */
	private final static int BATCH_APPLICATION_CONTEXT_INDEX = 2;
	/**
	 * Numero di application context da caricare
	 */
	private final static int TOTAL_APPLICATION_CONTEXT = 3;
	/**
	 * Logger da utilizzare
	 */
	private static LoggerHelper loggerHelper = null;
	/**
	 * Application context Spring
	 */
	private static ApplicationContext context = null;

	/**
	 * Main per l'esecuzione dei batch
	 * 
	 * @param args Nome del batch da lanciare
	 */
	public static void main(String[] args) {
		final String METHOD_NAME = "main";
		BatchEnum batchValue = null;
		Batch batch = null;

		try {
			batchValue = BatchEnum.valueOf(args[BATCH_NAME_ARG].toUpperCase());
			//initLogger(batchValue);
			batch = (Batch) getContext(batchValue).getBean(batchValue.getPrefix() + "Batch");
			try {
				batch.execute();
			}
			catch(BatchException e) {
				//loggerHelper.error(CLASS_NAME, METHOD_NAME, "Batch fallito", e);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			// Il logger potrebbe non essere inizializzato
			//initLogger(batchValue);
			//loggerHelper.error(CLASS_NAME, METHOD_NAME, "Batch sconosciuto", e);
		}
		//loggerHelper.debugEnd(CLASS_NAME, METHOD_NAME);
	}

	/**
	 * Inizializza se necessario il logger
	 * 
	 * @param batchValue Batch che deve essere eseguito
	 */
	private static void initLogger(BatchEnum batchValue) {
		final String METHOD_NAME = "initLogger";

		if(loggerHelper == null) {
			/*
			loggerHelper = (LoggerHelper) getContext(batchValue).getBean("loggerHelper");
			loggerHelper.debugBegin(CLASS_NAME, METHOD_NAME);
			*/
		}
	}

	/**
	 * Restituisce il contesto Spring
	 * 
	 * @return Contesto Spring
	 */
	private static ApplicationContext getContext(BatchEnum batchValue) {
		String[] applicationContexts = null;
		String batchName = null;

		if(context == null) {
			if(batchValue != null) {
				batchName = batchValue.getPrefix();
				applicationContexts = new String[TOTAL_APPLICATION_CONTEXT];
				applicationContexts[BATCH_APPLICATION_CONTEXT_INDEX] = "META-INF/" + batchName + "ApplicationContext.xml";
			}
			else {
				// E' stato passato come parametro il nome di un batch sconosciuto
				applicationContexts = new String[TOTAL_APPLICATION_CONTEXT - 1];
			}
			applicationContexts[DAO_APPLICATION_CONTEXT_INDEX] = "META-INF/dao-beans.xml";
			applicationContexts[COMMON_APPLICATION_CONTEXT_INDEX] = "META-INF/applicationContext.xml";
		
			
//			for (String app : applicationContexts) {
//				System.out.println("Stampo l'appicationContext: "+app);
//			}
			
			
			context = new ClassPathXmlApplicationContext(applicationContexts);
		}
		return context;
	}
}
