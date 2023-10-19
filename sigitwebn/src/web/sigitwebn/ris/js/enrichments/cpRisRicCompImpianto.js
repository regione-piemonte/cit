

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicCompImpianto] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicCompImpianto() {
	var contentPanelName = "cpRisRicCompImpianto";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicCompImpianto(){
/*PROTECTED REGION ID(R-564490285) ENABLED START*/
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

function initUIStructCpRisRicCompImpianto(){
	var contentPanelName = "cpRisRicCompImpianto";
	var structure =
      {
        name: "p_fpRisRicImpiantoG", panels: [
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
            name: "p_fpRisRicImpianto", panels: [
            ]
          }
,          {
            name: "p_stdMsgPRisRicImp", panels: [
            ]
          }
,          {
            name: "p_wpRisImp", panels: []
          }
,          {
            name: "p_cpNavRisRicImpianto", panels: []
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

	initStdEnrichments4CpRisRicCompImpianto();
	initCustomEnrichments4CpRisRicCompImpianto();
	initUIStructCpRisRicCompImpianto();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicCompImpianto");

});



