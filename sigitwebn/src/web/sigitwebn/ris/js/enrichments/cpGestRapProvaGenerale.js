

/**
 * Arricchimenti standard per il ContentPanel [cpGestRapProvaGenerale] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestRapProvaGenerale() {
	var contentPanelName = "cpGestRapProvaGenerale";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestRapProvaGenerale(){
/*PROTECTED REGION ID(R249391906) ENABLED START*/
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

function initUIStructCpGestRapProvaGenerale(){
	var contentPanelName = "cpGestRapProvaGenerale";
	var structure =
      {
        name: "p_fpGestRapProva", panels: [
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
            name: "p_wpMenuRapProva", panels: []
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpGestRapProvaDatiGen", panels: [
            ]
          }
,          {
            name: "p_stdMsgRapProva", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpDatiGenerali1", panels: []
          }
,          {
            name: "p_wpTabellaLocalizzazioni", panels: []
          }
,          {
            name: "p_wpDatiGenerali2", panels: []
          }
,          {
            name: "p_wpDestinazione", panels: []
          }
,          {
            name: "p_cpNavGestRapProva", panels: []
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

	initStdEnrichments4CpGestRapProvaGenerale();
	initCustomEnrichments4CpGestRapProvaGenerale();
	initUIStructCpGestRapProvaGenerale();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestRapProvaGenerale");

});



