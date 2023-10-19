

/**
 * Arricchimenti standard per il ContentPanel [cpGestRapProvaConfirm] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestRapProvaConfirm() {
	var contentPanelName = "cpGestRapProvaConfirm";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestRapProvaConfirm(){
/*PROTECTED REGION ID(R-1101940545) ENABLED START*/
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

function initUIStructCpGestRapProvaConfirm(){
	var contentPanelName = "cpGestRapProvaConfirm";
	var structure =
      {
        name: "p_fpGestRapProvaConfirm", panels: [
        {
          name: "p_fpCenter", panels: [
          {
            name: "p_stdMsgConfirm", panels: [
            ]
          }
,          {
            name: "p_wpGestRapProvaConfirm", panels: []
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

	initStdEnrichments4CpGestRapProvaConfirm();
	initCustomEnrichments4CpGestRapProvaConfirm();
	initUIStructCpGestRapProvaConfirm();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestRapProvaConfirm");

});



