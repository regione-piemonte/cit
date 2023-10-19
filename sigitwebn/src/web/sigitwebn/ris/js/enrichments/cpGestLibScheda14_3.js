

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda14_3] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda14_3() {
	var contentPanelName = "cpGestLibScheda14_3";
	/// arricchimento per guigen::ComboBox [cbUnitaMisura]: autonarrowing
	var addNarrowingToCbUnitaMisura =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUnitaMisura',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda14_3_um", addNarrowingToCbUnitaMisura);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda14_3(){
/*PROTECTED REGION ID(R1563819324) ENABLED START*/
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

function initUIStructCpGestLibScheda14_3(){
	var contentPanelName = "cpGestLibScheda14_3";
	var structure =
      {
        name: "p_fpGestLibScheda14_3", panels: [
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
            name: "p_fpScheda14_3", panels: [
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
            name: "p_wpScheda14_3_um", panels: []
          }
,          {
            name: "p_wpScheda14_3", panels: []
          }
,          {
            name: "p_cpFunGestScheda14_3", panels: []
          }
,          {
            name: "p_cpNavGestScheda14_3", panels: []
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

	initStdEnrichments4CpGestLibScheda14_3();
	initCustomEnrichments4CpGestLibScheda14_3();
	initUIStructCpGestLibScheda14_3();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda14_3");

});



