

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaSanzione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaSanzione() {
	var contentPanelName = "cpRicercaSanzione";
	/// arricchimento di base per guigen::TextField [tfIdentificativo]
	var addBasicEnrichmentToTfIdentificativo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIdentificativo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addBasicEnrichmentToTfIdentificativo);
	/// arricchimento per guigen::ComboBox [cbResponsabile]: autonarrowing
	var addNarrowingToCbResponsabile =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbResponsabile',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addNarrowingToCbResponsabile);


	/// arricchimento per guigen::Calendar [cldataCreazioneDa]: aggiunta datepicker
	var addDateToCldataCreazioneDa = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataCreazioneDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataCreazioneDa);
	/// arricchimento per guigen::Calendar [cldataCreazioneA]: aggiunta datepicker
	var addDateToCldataCreazioneA = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataCreazioneA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataCreazioneA);
	/// arricchimento per guigen::Calendar [cldataComunicazioneDa]: aggiunta datepicker
	var addDateToCldataComunicazioneDa = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataComunicazioneDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataComunicazioneDa);
	/// arricchimento per guigen::Calendar [cldataComunicazioneA]: aggiunta datepicker
	var addDateToCldataComunicazioneA = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataComunicazioneA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataComunicazioneA);
	/// arricchimento per guigen::Calendar [cldataPagamentoDa]: aggiunta datepicker
	var addDateToCldataPagamentoDa = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataPagamentoDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataPagamentoDa);
	/// arricchimento per guigen::Calendar [cldataPagamentoA]: aggiunta datepicker
	var addDateToCldataPagamentoA = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataPagamentoA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataPagamentoA);
	/// arricchimento per guigen::Calendar [cldataAnnullamentoDa]: aggiunta datepicker
	var addDateToCldataAnnullamentoDa = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataAnnullamentoDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataAnnullamentoDa);
	/// arricchimento per guigen::Calendar [cldataAnnullamentoA]: aggiunta datepicker
	var addDateToCldataAnnullamentoA = function(){
		uiNRichLib.addDatePickerNRich("widg_cldataAnnullamentoA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addDateToCldataAnnullamentoA);
	/// arricchimento di base per guigen::TextField [tfValoreDa]
	var addBasicEnrichmentToTfValoreDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfValoreDa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addBasicEnrichmentToTfValoreDa);
	/// arricchimento di base per guigen::TextField [tfValoreA]
	var addBasicEnrichmentToTfValoreA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfValoreA',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addBasicEnrichmentToTfValoreA);
	/// arricchimento per guigen::ComboBox [cbStato]: autonarrowing
	var addNarrowingToCbStato =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStato',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addNarrowingToCbStato);


	/// arricchimento per guigen::ComboBox [cbAssAccert]: autonarrowing
	var addNarrowingToCbAssAccert =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAssAccert',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addNarrowingToCbAssAccert);


	/// arricchimento per guigen::ComboBox [cbAssIspez]: autonarrowing
	var addNarrowingToCbAssIspez =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAssIspez',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addNarrowingToCbAssIspez);


	/// arricchimento di base per guigen::TextField [tfcfFisicoSanzionato]
	var addBasicEnrichmentToTfcfFisicoSanzionato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfcfFisicoSanzionato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addBasicEnrichmentToTfcfFisicoSanzionato);
	/// arricchimento di base per guigen::TextField [tfcfGiuridicoSanzionato]
	var addBasicEnrichmentToTfcfGiuridicoSanzionato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfcfGiuridicoSanzionato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addBasicEnrichmentToTfcfGiuridicoSanzionato);
	/// arricchimento di base per guigen::TextField [tfmotivo]
	var addBasicEnrichmentToTfmotivo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfmotivo',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaSanzioni", addBasicEnrichmentToTfmotivo);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaSanzione(){
/*PROTECTED REGION ID(R-1273924189) ENABLED START*/
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

function initUIStructCpRicercaSanzione(){
	var contentPanelName = "cpRicercaSanzione";
	var structure =
      {
        name: "p_fpRicercaSanzioni", panels: [
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
            name: "p_stdErrorMessageRicercaSanzioni", panels: [
            ]
          }
,          {
            name: "p_wpRicercaSanzioni", panels: []
          }
,          {
            name: "p_cpFunRicercaSanzioni", panels: []
          }
,          {
            name: "p_cpNavRicercaSanzioni", panels: []
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

	initStdEnrichments4CpRicercaSanzione();
	initCustomEnrichments4CpRicercaSanzione();
	initUIStructCpRicercaSanzione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaSanzione");

});



