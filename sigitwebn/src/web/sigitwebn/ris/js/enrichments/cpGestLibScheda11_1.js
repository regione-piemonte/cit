

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda11_1] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda11_1() {
	var contentPanelName = "cpGestLibScheda11_1";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda11_1(){
/*PROTECTED REGION ID(R-1676256969) ENABLED START*/
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

function initUIStructCpGestLibScheda11_1(){
	var contentPanelName = "cpGestLibScheda11_1";
	var structure =
      {
        name: "p_fpGestLibScheda11_1", panels: [
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
            name: "p_fpScheda11_1", panels: [
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
            name: "p_wpScheda11Intest", panels: []
          }
,          {
            name: "p_wpScheda11_1", panels: []
          }
,          {
            name: "p_cpNavGestScheda11_1", panels: []
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

	initStdEnrichments4CpGestLibScheda11_1();
	initCustomEnrichments4CpGestLibScheda11_1();
	initUIStructCpGestLibScheda11_1();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda11_1");

});



