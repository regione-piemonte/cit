

/**
 * Arricchimenti standard per il ContentPanel [cpToken] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpToken() {
	var contentPanelName = "cpToken";
	/// arricchimento per guigen::ComboBox [cbFruitore]: autonarrowing
	var addNarrowingToCbFruitore =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFruitore',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFruitore", addNarrowingToCbFruitore);


	/// arricchimento di base per guigen::TextField [tfTokenDataGenFruitore]
	var addBasicEnrichmentToTfTokenDataGenFruitore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTokenDataGenFruitore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFruitore", addBasicEnrichmentToTfTokenDataGenFruitore);
	/// arricchimento per guigen::Calendar [calTokenDataScadenzaFruitore]: aggiunta datepicker
	var addDateToCalTokenDataScadenzaFruitore = function(){
		uiNRichLib.addDatePickerNRich("widg_calTokenDataScadenzaFruitore", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFruitore", addDateToCalTokenDataScadenzaFruitore);
	/// arricchimento di base per guigen::TextField [cbImpSiglaRea]
	var addBasicEnrichmentToCbImpSiglaRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_cbImpSiglaRea',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToCbImpSiglaRea);
	/// arricchimento di base per guigen::TextField [tfImpNumRea]
	var addBasicEnrichmentToTfImpNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfImpNumRea);
	/// arricchimento di base per guigen::TextField [tfImpCf]
	var addBasicEnrichmentToTfImpCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpCf',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfImpCf);
	/// arricchimento di base per guigen::TextField [tfImpImpresa]
	var addBasicEnrichmentToTfImpImpresa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpImpresa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfImpImpresa);
	/// arricchimento di base per guigen::TextField [tfTokenDataGen]
	var addBasicEnrichmentToTfTokenDataGen =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTokenDataGen',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfTokenDataGen);
	/// arricchimento di base per guigen::TextField [tfTokenDataScadenza]
	var addBasicEnrichmentToTfTokenDataScadenza =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTokenDataScadenza',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfTokenDataScadenza);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpToken(){
/*PROTECTED REGION ID(R-607424594) ENABLED START*/
	/*
	 * definire e registrare qui eventuali arricchimenti custom, nel formato:
	 * var customEnr_n = function(){
	 *	// codice da eseguire all'applicazione dell'arricchimento
	 * };
	 * String customEnr_fragmentID = p_[id del pannello a cui deve essere associato l'arricchimento];
	 * uiEnricherMgr.registerEnrichment(contentPanelName, customEnr_fragmentID, customEnr_n);
	*/
	
	var customFruitoreEnr_n = function(){
	 	var wpTokenFruitore = document.querySelector("#wpFruitoreTbl");
	 	if (wpTokenFruitore != null) {	 		
	 		wpTokenFruitore.style.wordBreak = "break-all";
	 	}
	 };
	 
	 uiEnricherMgr.registerEnrichment("cpToken", "p_wpFruitore", customFruitoreEnr_n);
 
	 var customImpresaEnr_n = function(){
	 	var wpTokenImpresa = document.querySelector("#wpImpresaTbl");
	 	if (wpTokenImpresa != null) {	 		
	 		wpTokenImpresa.style.wordBreak = "break-all";
	 	}
	 };
	 
	 uiEnricherMgr.registerEnrichment("cpToken", "p_wpImpresa", customImpresaEnr_n);

/*PROTECTED REGION END*/
}

function initUIStructCpToken(){
	var contentPanelName = "cpToken";
	var structure =
      {
        name: "p_fpGeneraTokenG", panels: [
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
            name: "p_fpGeneraTokenTitolo", panels: [
            ]
          }
,          {
            name: "p_fpGenToken", panels: [
            {
              name: "p_stdMsgPGeneraToken", panels: [
              ]
            }
,            {
              name: "p_mpFruitori", panels: [
              {
                name: "p_fpGeneraTokenFruitori", panels: [
                {
                  name: "p_wpFruitore", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpImpresa", panels: [
              {
                name: "p_fpGeneraToken", panels: [
                {
                  name: "p_wpImpresa", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavImpresa", panels: []
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

	initStdEnrichments4CpToken();
	initCustomEnrichments4CpToken();
	initUIStructCpToken();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpToken");

});



