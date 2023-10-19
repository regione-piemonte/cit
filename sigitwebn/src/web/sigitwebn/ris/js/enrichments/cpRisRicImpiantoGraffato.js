

/**
 * Arricchimenti standard per il ContentPanel [cpRisRicImpiantoGraffato] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisRicImpiantoGraffato() {
	var contentPanelName = "cpRisRicImpiantoGraffato";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisRicImpiantoGraffato(){
/*PROTECTED REGION ID(R297033546) ENABLED START*/
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

function initUIStructCpRisRicImpiantoGraffato(){
	var contentPanelName = "cpRisRicImpiantoGraffato";
	var structure =
      {
        name: "p_fpRisRicImpiantoGGraff", panels: [
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

	initStdEnrichments4CpRisRicImpiantoGraffato();
	initCustomEnrichments4CpRisRicImpiantoGraffato();
	initUIStructCpRisRicImpiantoGraffato();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisRicImpiantoGraffato");

});



