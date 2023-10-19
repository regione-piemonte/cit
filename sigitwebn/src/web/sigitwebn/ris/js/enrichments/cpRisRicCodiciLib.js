

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicCodiciLib] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicCodiciLib() {
	var contentPanelName = "cpRisRicCodiciLib";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicCodiciLib(){
/*PROTECTED REGION ID(R1279641395) ENABLED START*/
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

function initUIStructCpRisRicCodiciLib(){
	var contentPanelName = "cpRisRicCodiciLib";
	var structure =
      {
        name: "p_fpRisRicCodiciLibG", panels: [
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
            name: "p_fpRisRicCodiciLib", panels: [
            ]
          }
,          {
            name: "p_stdMsgPRisRicCodLib", panels: [
            ]
          }
,          {
            name: "p_wpRisRicCodiciLib", panels: []
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

	initStdEnrichments4CpRisRicCodiciLib();
	initCustomEnrichments4CpRisRicCodiciLib();
	initUIStructCpRisRicCodiciLib();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicCodiciLib");

});



