

/**
 * Arricchimenti standard per il ContentPanel [cpExportMassivo] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpExportMassivo() {
	var contentPanelName = "cpExportMassivo";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpExportMassivo(){
/*PROTECTED REGION ID(R-180421745) ENABLED START*/
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

function initUIStructCpExportMassivo(){
	var contentPanelName = "cpExportMassivo";
	var structure =
      {
        name: "p_fpExpMassG", panels: [
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
            name: "p_udpExpMass", panels: [
            ]
          }
,          {
            name: "p_fpExpMassivo", panels: [
            {
              name: "p_stdMsgPHome", panels: [
              ]
            }
,            {
              name: "p_wpExpMass", panels: []
            }
,            {
              name: "p_cpExpMass", panels: []
            }
            ]
          }
,          {
            name: "p_cpExpMassBack", panels: []
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

	initStdEnrichments4CpExportMassivo();
	initCustomEnrichments4CpExportMassivo();
	initUIStructCpExportMassivo();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpExportMassivo");

});



