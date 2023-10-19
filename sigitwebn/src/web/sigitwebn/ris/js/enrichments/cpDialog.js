

/**
 * Arricchimenti standard per il ContentPanel [cpDialog] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDialog() {
	var contentPanelName = "cpDialog";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDialog(){
/*PROTECTED REGION ID(R755627511) ENABLED START*/
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

function initUIStructCpDialog(){
	var contentPanelName = "cpDialog";
	var structure =
      {
        name: "p_fpMainG", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpMain", panels: [
            ]
          }
,          {
            name: "p_wpMain", panels: []
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

	initStdEnrichments4CpDialog();
	initCustomEnrichments4CpDialog();
	initUIStructCpDialog();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDialog");

});



