

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda13] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda13() {
	var contentPanelName = "cpGestLibScheda13";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda13(){
/*PROTECTED REGION ID(R-1668958649) ENABLED START*/
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

function initUIStructCpGestLibScheda13(){
	var contentPanelName = "cpGestLibScheda13";
	var structure =
      {
        name: "p_fpGestLibScheda13", panels: [
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
            name: "p_fpScheda13", panels: [
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
            name: "p_wpScheda13", panels: []
          }
,          {
            name: "p_cpFunGestScheda13", panels: []
          }
,          {
            name: "p_cpNavGestScheda13", panels: []
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

	initStdEnrichments4CpGestLibScheda13();
	initCustomEnrichments4CpGestLibScheda13();
	initUIStructCpGestLibScheda13();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda13");

});



