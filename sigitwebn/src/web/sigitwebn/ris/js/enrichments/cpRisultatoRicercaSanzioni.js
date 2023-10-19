

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoRicercaSanzioni] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoRicercaSanzioni() {
	var contentPanelName = "cpRisultatoRicercaSanzioni";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoRicercaSanzioni(){
/*PROTECTED REGION ID(R1055410758) ENABLED START*/
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

function initUIStructCpRisultatoRicercaSanzioni(){
	var contentPanelName = "cpRisultatoRicercaSanzioni";
	var structure =
      {
        name: "p_fpRisultatoRicercaSanzioni", panels: [
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
            name: "p_stdErrorMessageRisultatoRicercaSanzioni", panels: [
            ]
          }
,          {
            name: "p_wpRisultato", panels: []
          }
,          {
            name: "p_cpFunRisultatoRicercaSanzioni", panels: []
          }
,          {
            name: "p_cpNavRisultatoRicercaSanzioni", panels: []
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

	initStdEnrichments4CpRisultatoRicercaSanzioni();
	initCustomEnrichments4CpRisultatoRicercaSanzioni();
	initUIStructCpRisultatoRicercaSanzioni();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoRicercaSanzioni");

});



