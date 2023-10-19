

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda9_6Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda9_6Dett() {
	var contentPanelName = "cpGestLibScheda9_6Dett";
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
	/// arricchimento di base per guigen::TextField [tTipologia]
	var addBasicEnrichmentToTTipologia =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tTipologia',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTTipologia);
	/// arricchimento per guigen::ComboBox [cbTipoInst]: autonarrowing
	var addNarrowingToCbTipoInst =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoInst',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addNarrowingToCbTipoInst);


	/// arricchimento di base per guigen::TextField [tPortVentMandLs]
	var addBasicEnrichmentToTPortVentMandLs =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentMandLs',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentMandLs);
	/// arricchimento di base per guigen::TextField [tPortVentMandKw]
	var addBasicEnrichmentToTPortVentMandKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentMandKw',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentMandKw);
	/// arricchimento di base per guigen::TextField [tPortVentRipresaLs]
	var addBasicEnrichmentToTPortVentRipresaLs =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentRipresaLs',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentRipresaLs);
	/// arricchimento di base per guigen::TextField [tPortVentRipresaKw]
	var addBasicEnrichmentToTPortVentRipresaKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tPortVentRipresaKw',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComp", addBasicEnrichmentToTPortVentRipresaKw);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda9_6Dett(){
/*PROTECTED REGION ID(R1118921168) ENABLED START*/
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

function initUIStructCpGestLibScheda9_6Dett(){
	var contentPanelName = "cpGestLibScheda9_6Dett";
	var structure =
      {
        name: "p_fpGestLibScheda9_6Dett", panels: [
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

	initStdEnrichments4CpGestLibScheda9_6Dett();
	initCustomEnrichments4CpGestLibScheda9_6Dett();
	initUIStructCpGestLibScheda9_6Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda9_6Dett");

});



