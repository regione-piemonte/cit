package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitSAllegatoMetadata extends DAOMetadata {

	/**
	 * contiene l'elenco dei nomi delle property del DTO associato al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] propertyNames;

	/**
	 * contiene l'elenco dei nomi delle colonne della tabella associata al DAO a cui
	 * questi metadati fanno riferimento
	 */
	private final String[] columnNames;

	/**
	 * Contiene i metadati relativi a:
	 * DAO: [sigitSAllegato]
	 * tabella: [SIGIT_S_ALLEGATO].
	 */
	public SigitSAllegatoMetadata() {
		columnNames = new String[]{"ID_ALLEGATO", "FK_STATO_RAPP", "FK_IMP_RUOLO_PFPG", "FK_TIPO_DOCUMENTO",
				"FK_SIGLA_BOLLINO", "FK_NUMERO_BOLLINO", "DATA_CONTROLLO", "B_FLG_LIBRETTO_USO",
				"B_FLG_DICHIAR_CONFORM", "B_FLG_LIB_IMP", "B_FLG_LIB_COMPL", "F_OSSERVAZIONI", "F_RACCOMANDAZIONI",
				"F_PRESCRIZIONI", "F_FLG_PUO_FUNZIONARE", "F_INTERVENTO_ENTRO", "F_ORA_ARRIVO", "F_ORA_PARTENZA",
				"F_DENOMINAZ_TECNICO", "F_FLG_FIRMA_TECNICO", "F_FLG_FIRMA_RESPONSABILE", "DATA_INVIO", "NOME_ALLEGATO",
				"DATA_ULT_MOD", "UTENTE_ULT_MOD", "CF_REDATTORE", "UID_INDEX", "FLG_CONTROLLO_BOZZA",
				"A_POTENZA_TERMICA_NOMINALE_MAX", "F_FIRMA_TECNICO", "F_FIRMA_RESPONSABILE", "ELENCO_COMBUSTIBILI",
				"ELENCO_APPARECCHIATURE", "DATA_RESPINTA", "MOTIVO_RESPINTA", "FK_PG_CAT", "ABCDF_CONTROLLOWEB",
				"FK_TIPO_MANUTENZIONE", "ALTRO_DESCR", "DT_INVIO_MEMO", "MAIL_INVIO_MEMO", "UID_INDEX_FIRMATO",
				"NOME_ALLEGATO_FIRMATO"};
		propertyNames = new String[]{"idAllegato", "fkStatoRapp", "fkImpRuoloPfpg", "fkTipoDocumento", "fkSiglaBollino",
				"fkNumeroBollino", "dataControllo", "bFlgLibrettoUso", "bFlgDichiarConform", "bFlgLibImp",
				"bFlgLibCompl", "fOsservazioni", "fRaccomandazioni", "fPrescrizioni", "fFlgPuoFunzionare",
				"fInterventoEntro", "fOraArrivo", "fOraPartenza", "fDenominazTecnico", "fFlgFirmaTecnico",
				"fFlgFirmaResponsabile", "dataInvio", "nomeAllegato", "dataUltMod", "utenteUltMod", "cfRedattore",
				"uidIndex", "flgControlloBozza", "aPotenzaTermicaNominaleMax", "fFirmaTecnico", "fFirmaResponsabile",
				"elencoCombustibili", "elencoApparecchiature", "dataRespinta", "motivoRespinta", "fkPgCat",
				"abcdfControlloweb", "fkTipoManutenzione", "altroDescr", "dtInvioMemo", "mailInvioMemo",
				"uidIndexFirmato", "nomeAllegatoFirmato"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitSAllegato] fa riferimento
	 * (SIGIT_S_ALLEGATO).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_S_ALLEGATO";
	}

	/**
	 * Method 'getColumnNames'
	 * Restutuisce l'insieme dei nomi delle colonne gestite dal DAO.
	 * @return String[]
	 * @generated
	 */
	public String[] getColumnNames() {
		String ris[] = new String[columnNames.length];
		System.arraycopy(columnNames, 0, ris, 0, columnNames.length);
		return ris;
	}

}
