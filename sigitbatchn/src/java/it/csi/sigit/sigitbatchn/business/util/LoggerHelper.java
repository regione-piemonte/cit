/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2021
 *******************************************************************************/
package it.csi.sigit.sigitbatchn.business.util;

import it.csi.util.performance.StopWatch;

import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Logger dell'applicazione
 * 
 * @author 71845 - Marco Giacometto
 */
public class LoggerHelper extends Log4JLogger {
	/**
	 * Identificativo univoco della classe
	 */
	private final static long serialVersionUID = 5994258471470786943L;
	/**
	 * Dimensione iniziale del buffer della stringa del messaggio da loggare
	 */
	private final static int INIT_MESSAGE_BUFFER_SIZE = 256;
	/**
	 * Buffer del messaggio da loggare
	 */
	private StringBuffer messageToLog = null;
	/**
	 * Cronometro per il calcolo dei tempi di esecuzione
	 */
	private StopWatch watcher = null;
	/**
	 * Codice dell'applicazione a cui e' associato il logger
	 */
	private String applicationCode = null;

	/**
	 * Inizializza un'istanza della classe ApplicationLogger
	 * 
	 * @param applicationCode Codice dell'applicazione a cui e' associato il
	 *            logger
	 * @param logicalLayer Strato logico di appartenenza della classe ove il
	 *            Logger e' istanziato
	 */
	public LoggerHelper(String applicationCode, String logicalLayer) {
		super(applicationCode + "." + logicalLayer);
		this.applicationCode = applicationCode;
		messageToLog = new StringBuffer(INIT_MESSAGE_BUFFER_SIZE);
	}

	/**
	 * Stampa un messaggio di inizio metodo
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 */
	public void debugBegin(String className, String methodName) {
		debug(className, methodName, "BEGIN.", null);
	}

	/**
	 * Stampa un messaggio di fine metodo
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 */
	public void debugEnd(String className, String methodName) {
		debug(className, methodName, "END.", null);
	}

	/**
	 * Stampa un messaggio di debug
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 */
	public void debug(String className, String methodName, String message) {
		debug(className, methodName, message, null);
	}

	/**
	 * Stampa un messaggio di debug
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 * @param t Eccezione da loggare
	 */
	public void debug(String className, String methodName, String message, Throwable t) {
		buildLogMessage(className, methodName, message);
		debug(messageToLog, t);
	}

	/**
	 * Stampa un messaggio di info
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 */
	public void info(String className, String methodName, String message) {
		info(className, methodName, message, null);
	}

	/**
	 * Stampa un messaggio di info
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 * @param t Eccezione da loggare
	 */
	public void info(String className, String methodName, String message, Throwable t) {
		buildLogMessage(className, methodName, message);
		info(messageToLog, t);
	}

	/**
	 * Stampa un messaggio di warn
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 */
	public void warn(String className, String methodName, String message) {
		warn(className, methodName, message, null);
	}

	/**
	 * Stampa un messaggio di warn
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 * @param t Eccezione da loggare
	 */
	public void warn(String className, String methodName, String message, Throwable t) {
		buildLogMessage(className, methodName, message);
		warn(messageToLog, t);
	}

	/**
	 * Stampa un messaggio di error
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 */
	public void error(String className, String methodName, String message) {
		error(className, methodName, message, null);
	}

	/**
	 * Stampa un messaggio di error
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 * @param t Eccezione da loggare
	 */
	public void error(String className, String methodName, String message, Throwable t) {
		buildLogMessage(className, methodName, message);
		error(messageToLog, t);
	}

	/**
	 * Stampa un messaggio di fatal
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 */
	public void fatal(String className, String methodName, String message) {
		fatal(className, methodName, message, null);
	}

	/**
	 * Stampa un messaggio di fatal
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 * @param t Eccezione da loggare
	 */
	public void fatal(String className, String methodName, String message, Throwable t) {
		buildLogMessage(className, methodName, message);
		fatal(messageToLog, t);
	}

	/**
	 * Fa partire il cronometro
	 */
	public void startWatch() {
		watcher = new StopWatch(applicationCode);
		watcher.start();
	}

	/**
	 * Logga il tempo trascorso senza fermare il cronometro
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param context Contesto in cui avviene il log
	 * @param message Messaggio da loggare
	 */
	public void elapsedWatch(String className, String methodName, String context, String message) {
		if(watcher != null) {
			watcher.dumpElapsed(className, methodName, context, message);
		}
	}

	/**
	 * Ferma il cronometro e logga il tempo trascorso
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param context Contesto in cui avviene il log
	 * @param message Messaggio da loggare
	 */
	public void stopWatch(String className, String methodName, String context, String message) {
		if(watcher != null) {
			watcher.stop();
			watcher.dumpElapsed(className, methodName, context, message);
			watcher = null;
		}
	}

	/**
	 * Costruisce il messaggio da loggare
	 * 
	 * @param className Nome della classe che logga
	 * @param methodName Nome del metodo che logga
	 * @param message Messaggio da loggare
	 */
	private void buildLogMessage(String className, String methodName, String message) {
		messageToLog.setLength(0);
		messageToLog.append("[").append(className).append("::").append(methodName).append("] ").append(message);
	}
}
