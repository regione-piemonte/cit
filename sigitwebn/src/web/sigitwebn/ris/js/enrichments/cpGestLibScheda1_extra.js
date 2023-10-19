

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda1_extra] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda1_extra() {
	var contentPanelName = "cpGestLibScheda1_extra";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda1_extra(){
/*PROTECTED REGION ID(R-1115588223) ENABLED START*/
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

function initUIStructCpGestLibScheda1_extra(){
	var contentPanelName = "cpGestLibScheda1_extra";
	var structure =
      {
        name: "p_fpGestLibScheda1_extra", panels: [
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
            name: "p_fpScheda1_extra", panels: [
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
            name: "p_wpScheda1_extra", panels: []
          }
,          {
            name: "p_cpFunGestScheda1_extra", panels: []
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

	initStdEnrichments4CpGestLibScheda1_extra();
	initCustomEnrichments4CpGestLibScheda1_extra();
	initUIStructCpGestLibScheda1_extra();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda1_extra");

});



