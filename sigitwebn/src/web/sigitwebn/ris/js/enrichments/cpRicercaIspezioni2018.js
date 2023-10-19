

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaIspezioni2018] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaIspezioni2018() {
	var contentPanelName = "cpRicercaIspezioni2018";
	/// arricchimento di base per guigen::TextField [tfIdentificativo]
	var addBasicEnrichmentToTfIdentificativo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIdentificativo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addBasicEnrichmentToTfIdentificativo);
	/// arricchimento per guigen::ComboBox [cbCodiceFiscale]: autonarrowing
	var addNarrowingToCbCodiceFiscale =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCodiceFiscale',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addNarrowingToCbCodiceFiscale);


	/// arricchimento per guigen::Calendar [clDataCreazioneDa]: aggiunta datepicker
	var addDateToClDataCreazioneDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataCreazioneDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addDateToClDataCreazioneDa);
	/// arricchimento per guigen::Calendar [clDataCreazioneA]: aggiunta datepicker
	var addDateToClDataCreazioneA = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataCreazioneA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addDateToClDataCreazioneA);
	/// arricchimento per guigen::Calendar [clDataConclusioneDa]: aggiunta datepicker
	var addDateToClDataConclusioneDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataConclusioneDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addDateToClDataConclusioneDa);
	/// arricchimento per guigen::Calendar [clDataConclusioneA]: aggiunta datepicker
	var addDateToClDataConclusioneA = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataConclusioneA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addDateToClDataConclusioneA);
	/// arricchimento per guigen::ComboBox [cbStatoIspezione]: autonarrowing
	var addNarrowingToCbStatoIspezione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatoIspezione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addNarrowingToCbStatoIspezione);


	/// arricchimento per guigen::ComboBox [cbEsitoIspezione]: autonarrowing
	var addNarrowingToCbEsitoIspezione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbEsitoIspezione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addNarrowingToCbEsitoIspezione);


	/// arricchimento di base per guigen::TextField [tfCodiceImpianto]
	var addBasicEnrichmentToTfCodiceImpianto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodiceImpianto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addBasicEnrichmentToTfCodiceImpianto);
	/// arricchimento per guigen::ComboBox [cbProvComp]: autonarrowing
	var addNarrowingToCbProvComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvComp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addNarrowingToCbProvComp);


	/// arricchimento per guigen::ComboBox [cbComComp]: autonarrowing
	var addNarrowingToCbComComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComComp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaIspezioni", addNarrowingToCbComComp);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaIspezioni2018(){
/*PROTECTED REGION ID(R376463449) ENABLED START*/
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

function initUIStructCpRicercaIspezioni2018(){
	var contentPanelName = "cpRicercaIspezioni2018";
	var structure =
      {
        name: "p_fpRicercaIspezioni2018", panels: [
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
            name: "p_fpTitle", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageRicercaIspezione", panels: [
            ]
          }
,          {
            name: "p_wpRicercaIspezioni", panels: []
          }
,          {
            name: "p_cpFunRicercaIspezioni", panels: []
          }
,          {
            name: "p_cpNavRicercaIspezioni", panels: []
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

	initStdEnrichments4CpRicercaIspezioni2018();
	initCustomEnrichments4CpRicercaIspezioni2018();
	initUIStructCpRicercaIspezioni2018();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaIspezioni2018");

});



