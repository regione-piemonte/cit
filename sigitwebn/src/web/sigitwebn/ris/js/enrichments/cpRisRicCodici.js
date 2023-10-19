

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicCodici] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicCodici() {
	var contentPanelName = "cpRisRicCodici";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicCodici(){
/*PROTECTED REGION ID(R-204685898) ENABLED START*/
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

function initUIStructCpRisRicCodici(){
	var contentPanelName = "cpRisRicCodici";
	var structure =
      {
        name: "p_fpRisRicCodiciG", panels: [
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
          name: "p_fpCenter", panels: [
          {
            name: "p_fpRisRicCodici", panels: [
            ]
          }
,          {
            name: "p_stdMsgPRisRicCod", panels: [
            ]
          }
,          {
            name: "p_wpRisRicCodici", panels: []
          }
,          {
            name: "p_cpFunRisRicCod", panels: []
          }
,          {
            name: "p_cpNavRisRicCod", panels: []
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

	initStdEnrichments4CpRisRicCodici();
	initCustomEnrichments4CpRisRicCodici();
	initUIStructCpRisRicCodici();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicCodici");

});



