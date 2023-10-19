

/**
 * Arricchimenti standard per il ContentPanel [cpUploadReeFirmato] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpUploadReeFirmato() {
	var contentPanelName = "cpUploadReeFirmato";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpUploadReeFirmato(){
/*PROTECTED REGION ID(R923241660) ENABLED START*/
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

function initUIStructCpUploadReeFirmato(){
	var contentPanelName = "cpUploadReeFirmato";
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
            name: "p_fpReeFirmato", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageRespingiAllegato", panels: [
            ]
          }
,          {
            name: "p_wpReeFirmato", panels: []
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

	initStdEnrichments4CpUploadReeFirmato();
	initCustomEnrichments4CpUploadReeFirmato();
	initUIStructCpUploadReeFirmato();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpUploadReeFirmato");

});



