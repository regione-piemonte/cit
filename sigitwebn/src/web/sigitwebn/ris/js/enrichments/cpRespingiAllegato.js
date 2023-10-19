

/**
 * Arricchimenti standard per il ContentPanel [cpRespingiAllegato] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRespingiAllegato() {
	var contentPanelName = "cpRespingiAllegato";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRespingiAllegato(){
/*PROTECTED REGION ID(R-1819992609) ENABLED START*/
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

function initUIStructCpRespingiAllegato(){
	var contentPanelName = "cpRespingiAllegato";
	var structure =
      {
        name: "p_fpRespingi", panels: [
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
            name: "p_fpRespingiAllegato", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageRespingiAllegato", panels: [
            ]
          }
,          {
            name: "p_wpRespingiAllegato", panels: []
          }
,          {
            name: "p_cpFunzRespingiAllegato", panels: []
          }
,          {
            name: "p_cpNavRespingiAllegato", panels: []
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

	initStdEnrichments4CpRespingiAllegato();
	initCustomEnrichments4CpRespingiAllegato();
	initUIStructCpRespingiAllegato();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRespingiAllegato");

});



