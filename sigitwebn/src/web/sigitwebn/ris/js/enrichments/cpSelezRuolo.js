

/**
 * Arricchimenti standard per il ContentPanel [cpSelezRuolo] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpSelezRuolo() {
	var contentPanelName = "cpSelezRuolo";
	/// arricchimento per guigen::ComboBox [cbFiltroRuoli]: autonarrowing
	var addNarrowingToCbFiltroRuoli =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFiltroRuoli',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFiltraRuoli", addNarrowingToCbFiltroRuoli);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpSelezRuolo(){
/*PROTECTED REGION ID(R1923106799) ENABLED START*/
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

function initUIStructCpSelezRuolo(){
	var contentPanelName = "cpSelezRuolo";
	var structure =
      {
        name: "p_fpSelezRuoloG", panels: [
        {
          name: "p_fpUpUserInfo", panels: [
          {
            name: "p_udpTestalino", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpSelezRuolo", panels: [
            {
              name: "p_stdMsgSelezRuolo", panels: [
              ]
            }
,            {
              name: "p_wpFiltraRuoli", panels: []
            }
,            {
              name: "p_wpSelezRuolo", panels: []
            }
,            {
              name: "p_cpFunSelezRuolo", panels: []
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

	initStdEnrichments4CpSelezRuolo();
	initCustomEnrichments4CpSelezRuolo();
	initUIStructCpSelezRuolo();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpSelezRuolo");

});



