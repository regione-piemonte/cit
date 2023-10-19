

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda9_1Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda9_1Dett() {
	var contentPanelName = "cpGestLibScheda9_1Dett";
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
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addNarrowingToCbFabbricante);


	/// arricchimento di base per guigen::TextField [tModello]
	var addBasicEnrichmentToTModello =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tModello',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTModello);
	/// arricchimento di base per guigen::TextField [tMatricola]
	var addBasicEnrichmentToTMatricola =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tMatricola',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTMatricola);
	/// arricchimento di base per guigen::TextField [tCapacita]
	var addBasicEnrichmentToTCapacita =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tCapacita',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTCapacita);
	/// arricchimento di base per guigen::TextField [tNumVent]
	var addBasicEnrichmentToTNumVent =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tNumVent',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTNumVent);
	/// arricchimento di base per guigen::TextField [tTipoVent]
	var addBasicEnrichmentToTTipoVent =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tTipoVent',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTTipoVent);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda9_1Dett(){
/*PROTECTED REGION ID(R-809933941) ENABLED START*/
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

function initUIStructCpGestLibScheda9_1Dett(){
	var contentPanelName = "cpGestLibScheda9_1Dett";
	var structure =
      {
        name: "p_fpGestLibScheda9_1Dett", panels: [
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
            name: "p_fpScheda8Dett", panels: [
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

	initStdEnrichments4CpGestLibScheda9_1Dett();
	initCustomEnrichments4CpGestLibScheda9_1Dett();
	initUIStructCpGestLibScheda9_1Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda9_1Dett");

});



