

/**
 * Arricchimenti standard per il ContentPanel [cpRicerca] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicerca() {
	var contentPanelName = "cpRicerca";
	/// arricchimento per guigen::ComboBox [cbProvince]: autonarrowing
	var addNarrowingToCbProvince =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvince',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRicerca", addNarrowingToCbProvince);


	/// arricchimento per guigen::ComboBox [cbComuni]: autonarrowing
	var addNarrowingToCbComuni =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComuni',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRicerca", addNarrowingToCbComuni);


	/// arricchimento di base per guigen::TextField [Denominazione]
	var addBasicEnrichmentToDenominazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_Denominazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wRicerca", addBasicEnrichmentToDenominazione);


	/// arricchimento di base per guigen::TextField [tfDenomImpresa]
	var addBasicEnrichmentToTfDenomImpresa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDenomImpresa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfDenomImpresa);
	/// arricchimento di base per guigen::TextField [tfDettImpresaMan]
	var addBasicEnrichmentToTfDettImpresaMan =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettImpresaMan',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfDettImpresaMan);
	/// arricchimento di base per guigen::TextField [tfDettImpresa3resp]
	var addBasicEnrichmentToTfDettImpresa3resp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettImpresa3resp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfDettImpresa3resp);
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicerca(){
/*PROTECTED REGION ID(R1491863116) ENABLED START*/
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

function initUIStructCpRicerca(){
	var contentPanelName = "cpRicerca";
	var structure =
      {
        name: "p_pRicerca", panels: [
        {
          name: "p_pMenu", panels: [
          {
            name: "p_menuPanel", panels: []
          }
          ]
        }
,        {
          name: "p_pCenter", panels: [
          {
            name: "p_pnErroriInRicerca", panels: [
            ]
          }
,          {
            name: "p_wRicerca", panels: []
          }
,          {
            name: "p_pComandiTabella", panels: []
          }
,          {
            name: "p_mpManu", panels: [
            {
              name: "p_fpTab", panels: [
              {
                name: "p_pTabella", panels: []
              }
,              {
                name: "p_cpDettMan", panels: []
              }
,              {
                name: "p_mpDettManu", panels: [
                {
                  name: "p_fpCorsi", panels: [
                  {
                    name: "p_wpDettImpresa", panels: []
                  }
,                  {
                    name: "p_wpCorsi", panels: []
                  }
                  ]
                }
                ]
              }
              ]
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

	initStdEnrichments4CpRicerca();
	initCustomEnrichments4CpRicerca();
	initUIStructCpRicerca();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicerca");

});



