

/**
 * Arricchimenti standard per il ContentPanel [cpGestReeConfirm] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestReeConfirm() {
	var contentPanelName = "cpGestReeConfirm";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestReeConfirm(){
/*PROTECTED REGION ID(R1002966876) ENABLED START*/
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

function initUIStructCpGestReeConfirm(){
	var contentPanelName = "cpGestReeConfirm";
	var structure =
      {
        name: "p_fpGestReeConfirm", panels: [
        {
          name: "p_fpCenter", panels: [
          {
            name: "p_stdMsgConfirm", panels: [
            ]
          }
,          {
            name: "p_wpGestReeConfirm", panels: []
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

	initStdEnrichments4CpGestReeConfirm();
	initCustomEnrichments4CpGestReeConfirm();
	initUIStructCpGestReeConfirm();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestReeConfirm");

});



