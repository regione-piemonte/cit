

/**
 * Arricchimenti standard per il ContentPanel [cpElencoSveglie] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoSveglie() {
	var contentPanelName = "cpElencoSveglie";
	/// arricchimento di base per guigen::TextField [cfUtente]
	var addBasicEnrichmentToCfUtente =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_cfUtente',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpUtente", addBasicEnrichmentToCfUtente);







}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoSveglie(){
/*PROTECTED REGION ID(R-1826943556) ENABLED START*/
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

function initUIStructCpElencoSveglie(){
	var contentPanelName = "cpElencoSveglie";
	var structure =
      {
        name: "p_fpElencoSveglie", panels: [
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
            name: "p_fpSveglie", panels: [
            {
              name: "p_stdMsgSveglia", panels: [
              ]
            }
,            {
              name: "p_wpUtente", panels: []
            }
,            {
              name: "p_wpVerifiche", panels: []
            }
,            {
              name: "p_cpFunVerifiche", panels: []
            }
,            {
              name: "p_wpAccertamento", panels: []
            }
,            {
              name: "p_cpFunAccertamento", panels: []
            }
,            {
              name: "p_wpIspezione", panels: []
            }
,            {
              name: "p_cpFunIspezione", panels: []
            }
,            {
              name: "p_wpSanzione", panels: []
            }
,            {
              name: "p_cpFunSanzione", panels: []
            }
,            {
              name: "p_wpAccertamentoNonAss", panels: []
            }
,            {
              name: "p_cpFunAccertamentoNonAss", panels: []
            }
,            {
              name: "p_wpIspezioneNonAss", panels: []
            }
,            {
              name: "p_cpFunIspezioneNonAss", panels: []
            }
,            {
              name: "p_cpNav", panels: []
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

	initStdEnrichments4CpElencoSveglie();
	initCustomEnrichments4CpElencoSveglie();
	initUIStructCpElencoSveglie();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoSveglie");

});



