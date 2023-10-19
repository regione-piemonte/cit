package it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dao.*;
import it.csi.sigit.sigitwebn.business.dao.sigitwebn.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO SigitSAccessoDao.
 * @generated
 */
public class SigitSAccessoDto extends SigitSAccessoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna NOME
	 * @generated
	 */
	protected String nome;

	/**
	 * Imposta il valore della proprieta' nome associata alla
	 * colonna NOME.
	 * @generated
	 */
	public void setNome(String val) {

		nome = val;

	}

	/**
	 * Legge il valore della proprieta' nome associata alla
	 * @generated
	 */
	public String getNome() {

		return nome;

	}

	/**
	 * store della proprieta' associata alla colonna COGNOME
	 * @generated
	 */
	protected String cognome;

	/**
	 * Imposta il valore della proprieta' cognome associata alla
	 * colonna COGNOME.
	 * @generated
	 */
	public void setCognome(String val) {

		cognome = val;

	}

	/**
	 * Legge il valore della proprieta' cognome associata alla
	 * @generated
	 */
	public String getCognome() {

		return cognome;

	}

	/**
	 * store della proprieta' associata alla colonna RUOLO
	 * @generated
	 */
	protected String ruolo;

	/**
	 * Imposta il valore della proprieta' ruolo associata alla
	 * colonna RUOLO.
	 * @generated
	 */
	public void setRuolo(String val) {

		ruolo = val;

	}

	/**
	 * Legge il valore della proprieta' ruolo associata alla
	 * @generated
	 */
	public String getRuolo() {

		return ruolo;

	}

	/**
	 * Crea una istanza di SigitSAccessoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return SigitSAccessoPk
	 * @generated
	 */
	public SigitSAccessoPk createPk() {
		return new SigitSAccessoPk(dtAccesso, codiceFiscale);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
