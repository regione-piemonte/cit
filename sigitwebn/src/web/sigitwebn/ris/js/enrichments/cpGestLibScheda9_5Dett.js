

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda9_5Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda9_5Dett() {
	var contentPanelName = "cpGestLibScheda9_5Dett";
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
	/// arricchimento di base per guigen::TextField [tMatricola]
	var addBasicEnrichmentToTMatricola =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tMatricola',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTMatricola);
	/// arricchimento di base per guigen::TextField [tPortVentMandLs]
	var addBasicEnrichmentToTPortVentMandLs =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentMandLs',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentMandLs);
	/// arricchimento di base per guigen::TextField [tPortVentMandKw]
	var addBasicEnrichmentToTPortVentMandKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentMandKw',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentMandKw);
	/// arricchimento di base per guigen::TextField [tPortVentRipresaLs]
	var addBasicEnrichmentToTPortVentRipresaLs =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentRipresaLs',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentRipresaLs);
	/// arricchimento di base per guigen::TextField [tPortVentRipresaKw]
	var addBasicEnrichmentToTPortVentRipresaKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentRipresaKw',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentRipresaKw);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda9_5Dett(){
/*PROTECTED REGION ID(R-125843313) ENABLED START*/
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

function initUIStructCpGestLibScheda9_5Dett(){
	var contentPanelName = "cpGestLibScheda9_5Dett";
	var structure =
      {
        name: "p_fpGestLibScheda9_5Dett", panels: [
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

	initStdEnrichments4CpGestLibScheda9_5Dett();
	initCustomEnrichments4CpGestLibScheda9_5Dett();
	initUIStructCpGestLibScheda9_5Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda9_5Dett");

});



