

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda10_1Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda10_1Dett() {
	var contentPanelName = "cpGestLibScheda10_1Dett";
	/// arricchimento per guigen::Calendar [cDataInstallazione]: aggiunta datepicker
	var addDateToCDataInstallazione = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataInstallazione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addDateToCDataInstallazione);
	/// arricchimento per guigen::Calendar [cDataDismissione]: aggiunta datepicker
	var addDateToCDataDismissione = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataDismissione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addDateToCDataDismissione);
	/// arricchimento per guigen::ComboBox [cbFabbricante]: autonarrowing
	var addNarrowingToCbFabbricante =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFabbricante',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addNarrowingToCbFabbricante);


	/// arricchimento di base per guigen::TextField [tModello]
	var addBasicEnrichmentToTModello =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tModello',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTModello);
	/// arricchimento per guigen::ComboBox [cbTipologia]: autonarrowing
	var addNarrowingToCbTipologia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipologia',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addNarrowingToCbTipologia);


	/// arricchimento di base per guigen::TextField [tAltro]
	var addBasicEnrichmentToTAltro =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tAltro',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTAltro);
	/// arricchimento di base per guigen::TextField [tPortMax]
	var addBasicEnrichmentToTPortMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortMax',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortMax);
	/// arricchimento di base per guigen::TextField [tPRendRec]
	var addBasicEnrichmentToTPRendRec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPRendRec',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPRendRec);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda10_1Dett(){
/*PROTECTED REGION ID(R99210839) ENABLED START*/
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

function initUIStructCpGestLibScheda10_1Dett(){
	var contentPanelName = "cpGestLibScheda10_1Dett";
	var structure =
      {
        name: "p_fpGestLibScheda10_1Dett", panels: [
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
            name: "p_wpMenuTree", panels: []
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpSchedaDett", panels: [
            ]
          }
,          {
            name: "p_stdMsgLibretto", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpComp", panels: []
          }
,          {
            name: "p_cpFunGestDett", panels: []
          }
,          {
            name: "p_wpSostComp", panels: []
          }
,          {
            name: "p_cpFunGest", panels: []
          }
,          {
            name: "p_cpNavGestScheda1_extra", panels: []
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

	initStdEnrichments4CpGestLibScheda10_1Dett();
	initCustomEnrichments4CpGestLibScheda10_1Dett();
	initUIStructCpGestLibScheda10_1Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda10_1Dett");

});



