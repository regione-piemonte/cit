

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicBollini] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicBollini() {
	var contentPanelName = "cpRisRicBollini";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicBollini(){
/*PROTECTED REGION ID(R1642007804) ENABLED START*/
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

function initUIStructCpRisRicBollini(){
	var contentPanelName = "cpRisRicBollini";
	var structure =
      {
        name: "p_fpRisRicBolliniG", panels: [
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
            name: "p_fpRisRicBollini", panels: [
            ]
          }
,          {
            name: "p_stdMsgPRisRicBollini", panels: [
            ]
          }
,          {
            name: "p_wpRisRicBollini", panels: []
          }
,          {
            name: "p_cpFunRisRicBollini", panels: []
          }
,          {
            name: "p_cpNavRisRicBollini", panels: []
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

	initStdEnrichments4CpRisRicBollini();
	initCustomEnrichments4CpRisRicBollini();
	initUIStructCpRisRicBollini();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicBollini");

});



