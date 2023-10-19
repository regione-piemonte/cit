

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicAvzImpianto] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicAvzImpianto() {
	var contentPanelName = "cpRisRicAvzImpianto";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicAvzImpianto(){
/*PROTECTED REGION ID(R306214799) ENABLED START*/
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

function initUIStructCpRisRicAvzImpianto(){
	var contentPanelName = "cpRisRicAvzImpianto";
	var structure =
      {
        name: "p_fpRisRicAvzImpiantoG", panels: [
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
            name: "p_fpRisRicAvzImpianto", panels: [
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
            name: "p_exportTable", panels: []
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

	initStdEnrichments4CpRisRicAvzImpianto();
	initCustomEnrichments4CpRisRicAvzImpianto();
	initUIStructCpRisRicAvzImpianto();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicAvzImpianto");

});



