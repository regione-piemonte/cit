

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda14_4] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda14_4() {
	var contentPanelName = "cpGestLibScheda14_4";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda14_4(){
/*PROTECTED REGION ID(R719347453) ENABLED START*/
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

function initUIStructCpGestLibScheda14_4(){
	var contentPanelName = "cpGestLibScheda14_4";
	var structure =
      {
        name: "p_fpGestLibScheda14_4", panels: [
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
            name: "p_fpScheda14_4", panels: [
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
            name: "p_wpScheda14_4", panels: []
          }
,          {
            name: "p_cpFunGestScheda14_4", panels: []
          }
,          {
            name: "p_cpNavGestScheda14_4", panels: []
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

	initStdEnrichments4CpGestLibScheda14_4();
	initCustomEnrichments4CpGestLibScheda14_4();
	initUIStructCpGestLibScheda14_4();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda14_4");

});



