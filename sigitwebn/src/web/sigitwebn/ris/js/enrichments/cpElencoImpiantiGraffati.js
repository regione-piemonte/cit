

/**
 * Arricchimenti standard per il ContentPanel [cpElencoImpiantiGraffati] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoImpiantiGraffati() {
	var contentPanelName = "cpElencoImpiantiGraffati";



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoImpiantiGraffati(){
/*PROTECTED REGION ID(R-1026451734) ENABLED START*/
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

function initUIStructCpElencoImpiantiGraffati(){
	var contentPanelName = "cpElencoImpiantiGraffati";
	var structure =
      {
        name: "p_fpElencoImpiantiGraffati", panels: [
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
            name: "p_tsGraffatura", panels: [
            {
              name: "p_fpImpiantiGraffati", panels: [
              {
                name: "p_stdMsgPElImpGraf", panels: [
                ]
              }
,              {
                name: "p_wpElenImpGraf", panels: []
              }
,              {
                name: "p_cpFunImpGraff", panels: []
              }
,              {
                name: "p_cpNavImpGraf", panels: []
              }
              ]
            }
,            {
              name: "p_fpStoricoVariazione", panels: [
              {
                name: "p_stdMsgPElImpGraf", panels: [
                ]
              }
,              {
                name: "p_wpStoricoVariazione", panels: []
              }
,              {
                name: "p_cpNavStorico", panels: []
              }
              ]
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

	initStdEnrichments4CpElencoImpiantiGraffati();
	initCustomEnrichments4CpElencoImpiantiGraffati();
	initUIStructCpElencoImpiantiGraffati();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoImpiantiGraffati");

});



