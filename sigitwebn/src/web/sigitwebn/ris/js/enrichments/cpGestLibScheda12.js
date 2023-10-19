

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda12] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda12() {
	var contentPanelName = "cpGestLibScheda12";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda12(){
/*PROTECTED REGION ID(R-824486778) ENABLED START*/
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

function initUIStructCpGestLibScheda12(){
	var contentPanelName = "cpGestLibScheda12";
	var structure =
      {
        name: "p_fpGestLibScheda12", panels: [
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
            name: "p_fpScheda12", panels: [
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
            name: "p_wpScheda12", panels: []
          }
,          {
            name: "p_cpNavGestScheda12", panels: []
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

	initStdEnrichments4CpGestLibScheda12();
	initCustomEnrichments4CpGestLibScheda12();
	initUIStructCpGestLibScheda12();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda12");

});



