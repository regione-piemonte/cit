

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicercaAccertamenti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicercaAccertamenti() {
	var contentPanelName = "cpRisRicercaAccertamenti";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicercaAccertamenti(){
/*PROTECTED REGION ID(R941082490) ENABLED START*/
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

function initUIStructCpRisRicercaAccertamenti(){
	var contentPanelName = "cpRisRicercaAccertamenti";
	var structure =
      {
        name: "p_fpRisRicercaAccertamenti", panels: [
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
            name: "p_fpTitle", panels: [
            ]
          }
,          {
            name: "p_stdMsg", panels: [
            ]
          }
,          {
            name: "p_wpRisAcc", panels: []
          }
,          {
            name: "p_cpExportExcel", panels: []
          }
,          {
            name: "p_cpFun", panels: []
          }
,          {
            name: "p_cpNav", panels: []
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

	initStdEnrichments4CpRisRicercaAccertamenti();
	initCustomEnrichments4CpRisRicercaAccertamenti();
	initUIStructCpRisRicercaAccertamenti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicercaAccertamenti");

});



