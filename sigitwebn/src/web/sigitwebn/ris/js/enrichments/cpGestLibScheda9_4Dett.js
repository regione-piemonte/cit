

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda9_4Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda9_4Dett() {
	var contentPanelName = "cpGestLibScheda9_4Dett";
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
	/// arricchimento di base per guigen::TextField [tLungCircuito]
	var addBasicEnrichmentToTLungCircuito =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tLungCircuito',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTLungCircuito);
	/// arricchimento di base per guigen::TextField [tSupScambiatore]
	var addBasicEnrichmentToTSupScambiatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tSupScambiatore',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTSupScambiatore);
	/// arricchimento di base per guigen::TextField [tProfInstallaz]
	var addBasicEnrichmentToTProfInstallaz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tProfInstallaz',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTProfInstallaz);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda9_4Dett(){
/*PROTECTED REGION ID(R-1370607794) ENABLED START*/
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

function initUIStructCpGestLibScheda9_4Dett(){
	var contentPanelName = "cpGestLibScheda9_4Dett";
	var structure =
      {
        name: "p_fpGestLibScheda9_4Dett", panels: [
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
            name: "p_fpScheda9Dett", panels: [
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

	initStdEnrichments4CpGestLibScheda9_4Dett();
	initCustomEnrichments4CpGestLibScheda9_4Dett();
	initUIStructCpGestLibScheda9_4Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda9_4Dett");

});



