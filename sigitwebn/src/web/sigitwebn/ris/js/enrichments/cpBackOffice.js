

/**
 * Arricchimenti standard per il ContentPanel [cpBackOffice] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpBackOffice() {
	var contentPanelName = "cpBackOffice";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpBackOffice(){
/*PROTECTED REGION ID(R-1261348878) ENABLED START*/
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

function initUIStructCpBackOffice(){
	var contentPanelName = "cpBackOffice";
	var structure =
      {
        name: "p_fpBackOfficeG", panels: [
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
            name: "p_udpBackOffice", panels: [
            ]
          }
,          {
            name: "p_fpBackOffice", panels: [
            {
              name: "p_stdMsgPHome", panels: [
              ]
            }
,            {
              name: "p_wpBackOffice", panels: []
            }
            ]
          }
,          {
            name: "p_cpBackOfficeBack", panels: []
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

	initStdEnrichments4CpBackOffice();
	initCustomEnrichments4CpBackOffice();
	initUIStructCpBackOffice();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpBackOffice");

});



