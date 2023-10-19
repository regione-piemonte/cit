

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoRicercaIspezioni2018] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoRicercaIspezioni2018() {
	var contentPanelName = "cpRisultatoRicercaIspezioni2018";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoRicercaIspezioni2018(){
/*PROTECTED REGION ID(R-891437542) ENABLED START*/
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

function initUIStructCpRisultatoRicercaIspezioni2018(){
	var contentPanelName = "cpRisultatoRicercaIspezioni2018";
	var structure =
      {
        name: "p_fpRisultatoRicercaIspezioni2018", panels: [
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
            name: "p_fpTitle", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageRisultatoRicercaIspezione", panels: [
            ]
          }
,          {
            name: "p_wpRisultato", panels: []
          }
,          {
            name: "p_cpFunRisultatoRicercaIspezioni", panels: []
          }
,          {
            name: "p_cpNavRisultatoRicercaIspezioni", panels: []
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

	initStdEnrichments4CpRisultatoRicercaIspezioni2018();
	initCustomEnrichments4CpRisultatoRicercaIspezioni2018();
	initUIStructCpRisultatoRicercaIspezioni2018();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoRicercaIspezioni2018");

});



