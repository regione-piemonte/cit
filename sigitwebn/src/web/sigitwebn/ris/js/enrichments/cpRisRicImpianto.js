

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicImpianto] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicImpianto() {
	var contentPanelName = "cpRisRicImpianto";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicImpianto(){
/*PROTECTED REGION ID(R724619236) ENABLED START*/
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

function initUIStructCpRisRicImpianto(){
	var contentPanelName = "cpRisRicImpianto";
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
            name: "p_cpExportExcel", panels: []
          }
,          {
            name: "p_cpFunRisRicImpianto", panels: []
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

	initStdEnrichments4CpRisRicImpianto();
	initCustomEnrichments4CpRisRicImpianto();
	initUIStructCpRisRicImpianto();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicImpianto");

});



