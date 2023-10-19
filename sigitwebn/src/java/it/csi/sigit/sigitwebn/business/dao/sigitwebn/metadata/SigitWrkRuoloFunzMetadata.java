package it.csi.sigit.sigitwebn.business.dao.sigitwebn.metadata;

import it.csi.sigit.sigitwebn.business.dao.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.business.dao.metadata.*;
import java.util.List;

/**
 * @generated
 */
public class SigitWrkRuoloFunzMetadata extends DAOMetadata {

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
	 * DAO: [sigitWrkRuoloFunz]
	 * tabella: [SIGIT_WRK_RUOLO_FUNZ].
	 */
	public SigitWrkRuoloFunzMetadata() {
		columnNames = new String[]{"RUOLO", "FLG_ACQ_BOLLINO", "FLG_ACQ_COD_IMP", "FLG_ACQ_BOLL_TRANS", "FLG_IMPIANTO",
				"FLG_ALLEGATO", "FLG_CONSULTAZIONE", "FLG_ISPEZIONE", "FLG_IMPORT_MASS_ALLEGATO", "FLG_SUBENTRO",
				"FLG_DELEGA", "FLG_3RESPONSABILE", "FLG_RIC_AVZ_IMPIANTI", "FLG_DISTRIBUTORI", "FLG_INCARICHI_CAT",
				"FLG_IMPRESA", "FLG_EXP_XML_MODOL"};
		propertyNames = new String[]{"ruolo", "flgAcqBollino", "flgAcqCodImp", "flgAcqBollTrans", "flgImpianto",
				"flgAllegato", "flgConsultazione", "flgIspezione", "flgImportMassAllegato", "flgSubentro", "flgDelega",
				"flg3responsabile", "flgRicAvzImpianti", "flgDistributori", "flgIncarichiCat", "flgImpresa",
				"flgExpXmlModol"};
		for (int i = 0; i < columnNames.length; i++) {
			columnsNamesMap.put(propertyNames[i], columnNames[i]);

		}
	}

	/**
	 * Method 'getTableName'
	 * Restituisce il nome della tabella a cui il DAO [sigitWrkRuoloFunz] fa riferimento
	 * (SIGIT_WRK_RUOLO_FUNZ).
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "SIGIT_WRK_RUOLO_FUNZ";
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
