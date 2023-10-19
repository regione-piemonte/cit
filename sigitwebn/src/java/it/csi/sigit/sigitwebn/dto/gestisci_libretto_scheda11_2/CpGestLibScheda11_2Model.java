package it.csi.sigit.sigitwebn.dto.gestisci_libretto_scheda11_2;

import java.util.*;
import it.csi.sigit.sigitwebn.dto.*;
import it.csi.sigit.sigitwebn.dto.accesso.*;
import it.csi.sigit.sigitwebn.dto.codici_impianto.*;
import it.csi.sigit.sigitwebn.dto.common.*;
import it.csi.sigit.sigitwebn.dto.impianto.*;
import it.csi.sigit.sigitwebn.dto.main.*;
import it.csi.sigit.sigitwebn.dto.bollini.*;
import it.csi.sigit.sigitwebn.dto.allegati.*;
import it.csi.sigit.sigitwebn.dto.subentro.*;
import it.csi.sigit.sigitwebn.dto.delega.*;
import it.csi.sigit.sigitwebn.dto.terzoresponsabile.*;
import it.csi.sigit.sigitwebn.dto.ispezioni.*;
import it.csi.sigit.sigitwebn.dto.distributori.*;
import it.csi.sigit.sigitwebn.dto.incarico.*;
import it.csi.sigit.sigitwebn.dto.impresa.*;
import it.csi.sigit.sigitwebn.dto.documentazione.*;
import it.csi.sigit.sigitwebn.dto.libretto.*;
import it.csi.sigit.sigitwebn.dto.ree.*;
import it.csi.sigit.sigitwebn.dto.verifica.*;
import it.csi.sigit.sigitwebn.dto.accertamento.*;
import it.csi.sigit.sigitwebn.dto.azioni.*;
import it.csi.sigit.sigitwebn.dto.sanzioni.*;
import it.csi.sigit.sigitwebn.dto.rappprova.*;
import it.csi.sigit.sigitwebn.dto.back_office.*;
import it.csi.sigit.sigitwebn.dto.userws.*;

import it.csi.sigit.sigitwebn.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpGestLibScheda11_2]
 */
@Validation
public class CpGestLibScheda11_2Model extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @param value
	 * @generated
	 */

	public void setAppDatautenteLoggato(it.csi.sigit.sigitwebn.dto.main.UtenteLoggato value) {
		getSession().put("appDatautenteLoggato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatautenteLoggato'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.main.UtenteLoggato getAppDatautenteLoggato() {
		return (it.csi.sigit.sigitwebn.dto.main.UtenteLoggato) (getSession().get("appDatautenteLoggato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @param value
	 * @generated
	 */

	public void setAppDatalibrettoMenuTree(it.csi.custom.component.tree.base.TreeNode value) {
		getSession().put("appDatalibrettoMenuTree", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalibrettoMenuTree'
	 * @generated
	 */
	public it.csi.custom.component.tree.base.TreeNode getAppDatalibrettoMenuTree() {
		return (it.csi.custom.component.tree.base.TreeNode) (getSession().get("appDatalibrettoMenuTree"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaChiamante'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaChiamante(java.lang.String value) {
		getSession().put("appDatapaginaChiamante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaChiamante'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaChiamante() {
		return (java.lang.String) (getSession().get("appDatapaginaChiamante"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @param value
	 * @generated
	 */

	public void setAppDataidentificativoImpianto(it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto value) {
		getSession().put("appDataidentificativoImpianto", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidentificativoImpianto'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto getAppDataidentificativoImpianto() {
		return (it.csi.sigit.sigitwebn.dto.impianto.IdentificativoImpianto) (getSession()
				.get("appDataidentificativoImpianto"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatascheda12'
	 * @param value
	 * @generated
	 */

	public void setAppDatascheda12(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Scheda12> value) {
		getSession().put("appDatascheda12", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatascheda12'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Scheda12> getAppDatascheda12() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Scheda12>) (getSession()
				.get("appDatascheda12"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatascheda11Intest'
	 * @param value
	 * @generated
	 */

	public void setAppDatascheda11Intest(it.csi.sigit.sigitwebn.dto.libretto.Scheda11Intest value) {
		getSession().put("appDatascheda11Intest", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatascheda11Intest'
	 * @generated
	 */
	public it.csi.sigit.sigitwebn.dto.libretto.Scheda11Intest getAppDatascheda11Intest() {
		return (it.csi.sigit.sigitwebn.dto.libretto.Scheda11Intest) (getSession().get("appDatascheda11Intest"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatalistScheda11'
	 * @param value
	 * @generated
	 */

	public void setAppDatalistScheda11(java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Scheda11> value) {
		getSession().put("appDatalistScheda11", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatalistScheda11'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Scheda11> getAppDatalistScheda11() {
		return (java.util.ArrayList<it.csi.sigit.sigitwebn.dto.libretto.Scheda11>) (getSession()
				.get("appDatalistScheda11"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tbModuli

	private java.lang.String widgTbModuli;

	public void setWidg_tbModuli(java.lang.String value) {
		widgTbModuli = value;
	}

	public java.lang.String getWidg_tbModuli() {
		return widgTbModuli;
	}

	// Table tbModuliPag

	private java.lang.String widgTbModuliPag;

	public void setWidg_tbModuliPag(java.lang.String value) {
		widgTbModuliPag = value;
	}

	public java.lang.String getWidg_tbModuliPag() {
		return widgTbModuliPag;
	}

}
