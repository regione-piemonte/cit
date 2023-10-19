

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaAllegati] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaAllegati() {
	var contentPanelName = "cpRicercaAllegati";
	/// arricchimento per guigen::ComboBox [cbStatoAllegato]: autonarrowing
	var addNarrowingToCbStatoAllegato =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatoAllegato',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAllegati", addNarrowingToCbStatoAllegato);


	/// arricchimento per guigen::ComboBox [cbTipoAllegato]: autonarrowing
	var addNarrowingToCbTipoAllegato =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoAllegato',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAllegati", addNarrowingToCbTipoAllegato);


	/// arricchimento per guigen::Calendar [cDataControlloDaAllegati]: aggiunta datepicker
	var addDateToCDataControlloDaAllegati = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataControlloDaAllegati", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAllegati", addDateToCDataControlloDaAllegati);
	/// arricchimento per guigen::Calendar [cDataControlloAAllegati]: aggiunta datepicker
	var addDateToCDataControlloAAllegati = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataControlloAAllegati", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAllegati", addDateToCDataControlloAAllegati);
	/// arricchimento per guigen::ComboBox [cbSic]: autonarrowing
	var addNarrowingToCbSic =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSic',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAllegati", addNarrowingToCbSic);


	/// arricchimento per guigen::Calendar [cInterventoAllegatiDa]: aggiunta datepicker
	var addDateToCInterventoAllegatiDa = function(){
		uiNRichLib.addDatePickerNRich("widg_cInterventoAllegatiDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAllegati", addDateToCInterventoAllegatiDa);
	/// arricchimento per guigen::Calendar [cInterventoAallegati]: aggiunta datepicker
	var addDateToCInterventoAallegati = function(){
		uiNRichLib.addDatePickerNRich("widg_cInterventoAallegati", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAllegati", addDateToCInterventoAallegati);
	/// arricchimento per guigen::ComboBox [cbSiglaBollinoVerdeAllegati]: autonarrowing
	var addNarrowingToCbSiglaBollinoVerdeAllegati =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaBollinoVerdeAllegati',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpBollinoVerdeAllegati", addNarrowingToCbSiglaBollinoVerdeAllegati);


	/// arricchimento di base per guigen::TextField [tfNumeroBollinoVerdeAllegati]
	var addBasicEnrichmentToTfNumeroBollinoVerdeAllegati =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroBollinoVerdeAllegati',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpBollinoVerdeAllegati", addBasicEnrichmentToTfNumeroBollinoVerdeAllegati);
	/// arricchimento per guigen::ComboBox [cbSiglaReaAllegati]: autonarrowing
	var addNarrowingToCbSiglaReaAllegati =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaReaAllegati',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpManutentoreAllegati", addNarrowingToCbSiglaReaAllegati);


	/// arricchimento di base per guigen::TextField [tfNumeroReaAllegati]
	var addBasicEnrichmentToTfNumeroReaAllegati =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroReaAllegati',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpManutentoreAllegati", addBasicEnrichmentToTfNumeroReaAllegati);
	/// arricchimento di base per guigen::TextField [tfCodiceFiscaleAllegati]
	var addBasicEnrichmentToTfCodiceFiscaleAllegati =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodiceFiscaleAllegati',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpManutentoreAllegati", addBasicEnrichmentToTfCodiceFiscaleAllegati);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaAllegati(){
/*PROTECTED REGION ID(R433317727) ENABLED START*/
	/*
	 * definire e registrare qui eventuali arricchimenti custom, nel formato:
	 * var customEnr_n = function(){
	 *	// codice da eseguire all'applicazione dell'arricchimento
	 * };
	 * String customEnr_fragmentID = p_[id del pannello a cui deve essere associato l'arricchimento];
	 * uiEnricherMgr.registerEnrichment(contentPanelName, customEnr_fragmentID, customEnr_n);
	*/	
/*PROTECTED REGION END*/
}

function initUIStructCpRicercaAllegati(){
	var contentPanelName = "cpRicercaAllegati";
	var structure =
      {
        name: "p_fpAllegati", panels: [
        {
          name: "p_fpUpUserInfo", panels: [
          {
            name: "p_udpTestalino", panels: [
            ]
          }
,          {
            name: "p_menuPanel", panels: []
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpRicercaAllegati", panels: [
            ]
          }
,          {
            name: "p_stdMessageRicercaAllegati", panels: [
            ]
          }
,          {
            name: "p_wpRicercaAllegati", panels: []
          }
,          {
            name: "p_wpBollinoVerdeAllegati", panels: []
          }
,          {
            name: "p_wpManutentoreAllegati", panels: []
          }
,          {
            name: "p_cpAnnullaRicercaImpianti", panels: []
          }
,          {
            name: "p_cpRicercaAllegati", panels: []
          }
          ]
        }
        ]
      }
;
	uiEnricherMgr.setPageStructure(contentPanelName, structure);
}



// startup dell arricchimento con JQuery
$( function() {
	uiNRichLib.initStateManager();

	initStdEnrichments4CpRicercaAllegati();
	initCustomEnrichments4CpRicercaAllegati();
	initUIStructCpRicercaAllegati();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaAllegati");

});



