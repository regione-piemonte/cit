

/**
 * Arricchimenti standard per il ContentPanel [cpMsg] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpMsg() {
	var contentPanelName = "cpMsg";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpMsg(){
/*PROTECTED REGION ID(R-316595210) ENABLED START*/
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

function initUIStructCpMsg(){
	var contentPanelName = "cpMsg";
	var structure =
      {
        name: "p_fpMsgG", panels: [
        {
          name: "p_fpMsg", panels: [
          {
            name: "p_stdMsgPError", panels: [
            ]
          }
,          {
            name: "p_msgbError", panels: [
            ]
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

	initStdEnrichments4CpMsg();
	initCustomEnrichments4CpMsg();
	initUIStructCpMsg();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpMsg");

});



