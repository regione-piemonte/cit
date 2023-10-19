

/**
 * Arricchimenti standard per il ContentPanel [cpImportMassivo] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpImportMassivo() {
	var contentPanelName = "cpImportMassivo";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpImportMassivo(){
/*PROTECTED REGION ID(R1098300606) ENABLED START*/
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

function initUIStructCpImportMassivo(){
	var contentPanelName = "cpImportMassivo";
	var structure =
      {
        name: "p_fpImpMassG", panels: [
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
            name: "p_udpImpMass", panels: [
            ]
          }
,          {
            name: "p_fpImpMassivo", panels: [
            {
              name: "p_stdMsgPHome", panels: [
              ]
            }
,            {
              name: "p_wpRecBozze", panels: []
            }
,            {
              name: "p_cpImpMass", panels: []
            }
            ]
          }
,          {
            name: "p_cpImpMassBack", panels: []
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

	initStdEnrichments4CpImportMassivo();
	initCustomEnrichments4CpImportMassivo();
	initUIStructCpImportMassivo();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpImportMassivo");

});



