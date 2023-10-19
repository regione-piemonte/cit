

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda7] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda7() {
	var contentPanelName = "cpGestLibScheda7";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda7(){
/*PROTECTED REGION ID(R-1557114442) ENABLED START*/
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

function initUIStructCpGestLibScheda7(){
	var contentPanelName = "cpGestLibScheda7";
	var structure =
      {
        name: "p_fpGestLibScheda7", panels: [
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
            name: "p_fpSchedaImpianto", panels: [
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
            name: "p_wpSistemaEmissione", panels: []
          }
,          {
            name: "p_cpFunGestScheda7", panels: []
          }
,          {
            name: "p_cpNavGestScheda7", panels: []
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

	initStdEnrichments4CpGestLibScheda7();
	initCustomEnrichments4CpGestLibScheda7();
	initUIStructCpGestLibScheda7();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda7");

});



