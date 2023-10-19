

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoRicercaAllegati] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoRicercaAllegati() {
	var contentPanelName = "cpRisultatoRicercaAllegati";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoRicercaAllegati(){
/*PROTECTED REGION ID(R1845572862) ENABLED START*/
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

function initUIStructCpRisultatoRicercaAllegati(){
	var contentPanelName = "cpRisultatoRicercaAllegati";
	var structure =
      {
        name: "p_fpElencoAllegati", panels: [
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
            name: "p_fpRisRicercaAllegati", panels: [
            ]
          }
,          {
            name: "p_stdMsgElencoAllegati", panels: [
            ]
          }
,          {
            name: "p_wpRisRicercaAllegati", panels: []
          }
,          {
            name: "p_cpExportExcel", panels: []
          }
,          {
            name: "p_cpFunRisultatoRicercaAllegati", panels: []
          }
,          {
            name: "p_cpNavRisultatoRicercaAllegati", panels: []
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

	initStdEnrichments4CpRisultatoRicercaAllegati();
	initCustomEnrichments4CpRisultatoRicercaAllegati();
	initUIStructCpRisultatoRicercaAllegati();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoRicercaAllegati");

});



