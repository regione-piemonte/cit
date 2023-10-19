

/**
 * Arricchimenti standard per il ContentPanel [cpConf3Resp] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpConf3Resp() {
	var contentPanelName = "cpConf3Resp";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpConf3Resp(){
/*PROTECTED REGION ID(R27788468) ENABLED START*/
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

function initUIStructCpConf3Resp(){
	var contentPanelName = "cpConf3Resp";
	var structure =
      {
        name: "p_fpConf3Resp", panels: [
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
            name: "p_fpConf3Responsabile", panels: [
            {
              name: "p_stdMsgPGest3Resp", panels: [
              ]
            }
,            {
              name: "p_wp3Responsabile", panels: []
            }
,            {
              name: "p_wpContratto", panels: []
            }
,            {
              name: "p_wpImpianto", panels: []
            }
,            {
              name: "p_wpAutodichiarazioni", panels: []
            }
,            {
              name: "p_cpFunGest3Resp", panels: []
            }
,            {
              name: "p_cpNavGest3Resp", panels: []
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

	initStdEnrichments4CpConf3Resp();
	initCustomEnrichments4CpConf3Resp();
	initUIStructCpConf3Resp();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpConf3Resp");

});



