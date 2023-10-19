

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda5_1SR] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda5_1SR() {
	var contentPanelName = "cpGestLibScheda5_1SR";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda5_1SR(){
/*PROTECTED REGION ID(R-358759291) ENABLED START*/
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

function initUIStructCpGestLibScheda5_1SR(){
	var contentPanelName = "cpGestLibScheda5_1SR";
	var structure =
      {
        name: "p_fpGestLibScheda5_1SR", panels: [
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
            name: "p_fpScheda8", panels: [
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
            name: "p_wpScheda", panels: []
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

	initStdEnrichments4CpGestLibScheda5_1SR();
	initCustomEnrichments4CpGestLibScheda5_1SR();
	initUIStructCpGestLibScheda5_1SR();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda5_1SR");

});



