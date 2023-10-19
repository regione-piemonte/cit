

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibAggiornamenti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibAggiornamenti() {
	var contentPanelName = "cpGestLibAggiornamenti";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibAggiornamenti(){
/*PROTECTED REGION ID(R903539382) ENABLED START*/
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

function initUIStructCpGestLibAggiornamenti(){
	var contentPanelName = "cpGestLibAggiornamenti";
	var structure =
      {
        name: "p_fpGestLibAggiornamenti", panels: [
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
          name: "p_fpLeftMenu", panels: [
          {
            name: "p_udpFunzionalita", panels: [
            ]
          }
,          {
            name: "p_wpMenuTree", panels: []
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpAggLibretti", panels: [
            ]
          }
,          {
            name: "p_stdMsgAggLibretti", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpInfoControlli", panels: []
          }
,          {
            name: "p_wpVerificheImpianto", panels: []
          }
,          {
            name: "p_wpAccertamentiImpianto", panels: []
          }
,          {
            name: "p_mpElencoLibretti", panels: [
            {
              name: "p_fpElencoLibretti", panels: [
              {
                name: "p_wpElencoLibretti", panels: []
              }
,              {
                name: "p_cpFunGestAggiornamenti", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpNavGestAggiornamenti", panels: []
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

	initStdEnrichments4CpGestLibAggiornamenti();
	initCustomEnrichments4CpGestLibAggiornamenti();
	initUIStructCpGestLibAggiornamenti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibAggiornamenti");

});



