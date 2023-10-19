

/**
 * Arricchimenti standard per il ContentPanel [cpGestRapProvaTipo2] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestRapProvaTipo2() {
	var contentPanelName = "cpGestRapProvaTipo2";
	/// arricchimento per guigen::ComboBox [cbSiglaBollino]: autonarrowing
	var addNarrowingToCbSiglaBollino =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaBollino',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addNarrowingToCbSiglaBollino);


	/// arricchimento di base per guigen::TextField [tfNumeroBollino]
	var addBasicEnrichmentToTfNumeroBollino =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroBollino',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfNumeroBollino);
	/// arricchimento per guigen::Calendar [calDataBollino]: aggiunta datepicker
	var addDateToCalDataBollino = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataBollino", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addDateToCalDataBollino);
	/// arricchimento per guigen::Calendar [calDataPrimaInstallazione]: aggiunta datepicker
	var addDateToCalDataPrimaInstallazione = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataPrimaInstallazione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addDateToCalDataPrimaInstallazione);
	/// arricchimento di base per guigen::TextField [tfpotenzafocolare]
	var addBasicEnrichmentToTfpotenzafocolare =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfpotenzafocolare',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfpotenzafocolare);
	/// arricchimento di base per guigen::TextField [tfCognomeNome]
	var addBasicEnrichmentToTfCognomeNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognomeNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiGenerali", addBasicEnrichmentToTfCognomeNome);
	/// arricchimento di base per guigen::TextField [tfMotivo]
	var addBasicEnrichmentToTfMotivo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMotivo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp5", addBasicEnrichmentToTfMotivo);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestRapProvaTipo2(){
/*PROTECTED REGION ID(R-904198851) ENABLED START*/
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

function initUIStructCpGestRapProvaTipo2(){
	var contentPanelName = "cpGestRapProvaTipo2";
	var structure =
      {
        name: "p_fpGestRapProvaTipo2", panels: [
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
          name: "p_fpLeftMenu", panels: [
          {
            name: "p_udpFunzionalita", panels: [
            ]
          }
,          {
            name: "p_wpMenuRapProva", panels: []
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpGestRapProva", panels: [
            ]
          }
,          {
            name: "p_stdMsgRapProva", panels: [
            ]
          }
,          {
            name: "p_wpDatiGenerali", panels: []
          }
,          {
            name: "p_wpDestinazione", panels: []
          }
,          {
            name: "p_wpControllo", panels: []
          }
,          {
            name: "p_wpStatoDoc", panels: []
          }
,          {
            name: "p_wp5", panels: []
          }
,          {
            name: "p_wp10", panels: []
          }
,          {
            name: "p_wp11", panels: []
          }
,          {
            name: "p_wp12", panels: []
          }
,          {
            name: "p_cpFunGestRapProva", panels: []
          }
,          {
            name: "p_cpNavGestRapProvaDett", panels: []
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

	initStdEnrichments4CpGestRapProvaTipo2();
	initCustomEnrichments4CpGestRapProvaTipo2();
	initUIStructCpGestRapProvaTipo2();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestRapProvaTipo2");

});



