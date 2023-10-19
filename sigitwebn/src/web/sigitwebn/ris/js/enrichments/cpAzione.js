

/**
 * Arricchimenti standard per il ContentPanel [cpAzione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAzione() {
	var contentPanelName = "cpAzione";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAzione(){
/*PROTECTED REGION ID(R-44920251) ENABLED START*/
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

function initUIStructCpAzione(){
	var contentPanelName = "cpAzione";
	var structure =
      {
        name: "p_fpAzione", panels: [
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
            name: "p_fpDettaglioAzione", panels: [
            {
              name: "p_stdMsg", panels: [
              ]
            }
,            {
              name: "p_wpAzione", panels: []
            }
,            {
              name: "p_cpFun", panels: []
            }
,            {
              name: "p_cpNav", panels: []
            }
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

	initStdEnrichments4CpAzione();
	initCustomEnrichments4CpAzione();
	initUIStructCpAzione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAzione");

});



