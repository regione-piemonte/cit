

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicercaVerifiche] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicercaVerifiche() {
	var contentPanelName = "cpRisRicercaVerifiche";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicercaVerifiche(){
/*PROTECTED REGION ID(R-121527439) ENABLED START*/
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

function initUIStructCpRisRicercaVerifiche(){
	var contentPanelName = "cpRisRicercaVerifiche";
	var structure =
      {
        name: "p_fpRisRicercaVerifiche", panels: [
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
            name: "p_wpRisVer", panels: []
          }
,          {
            name: "p_cpExportEcel", panels: []
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

	initStdEnrichments4CpRisRicercaVerifiche();
	initCustomEnrichments4CpRisRicercaVerifiche();
	initUIStructCpRisRicercaVerifiche();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicercaVerifiche");

});



