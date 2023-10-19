

/**
 * Arricchimenti standard per il ContentPanel [cpDettWMS] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettWMS() {
	var contentPanelName = "cpDettWMS";
	/// arricchimento di base per guigen::TextField [tfImpianto]
	var addBasicEnrichmentToTfImpianto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpianto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToTfImpianto);
	/// arricchimento di base per guigen::TextField [tfUbicazione]
	var addBasicEnrichmentToTfUbicazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfUbicazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToTfUbicazione);
	/// arricchimento di base per guigen::TextField [tfVolRiscM3]
	var addBasicEnrichmentToTfVolRiscM3 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolRiscM3',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToTfVolRiscM3);
	/// arricchimento di base per guigen::TextField [tfvolRaffM3]
	var addBasicEnrichmentToTfvolRaffM3 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfvolRaffM3',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToTfvolRaffM3);
	/// arricchimento di base per guigen::TextField [potClimaInv]
	var addBasicEnrichmentToPotClimaInv =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_potClimaInv',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToPotClimaInv);
	/// arricchimento di base per guigen::TextField [tfPotClimaEst]
	var addBasicEnrichmentToTfPotClimaEst =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotClimaEst',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToTfPotClimaEst);
	/// arricchimento di base per guigen::TextField [componente]
	var addBasicEnrichmentToComponente =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_componente',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wDettWMS", addBasicEnrichmentToComponente);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettWMS(){
/*PROTECTED REGION ID(R-2113468399) ENABLED START*/
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

function initUIStructCpDettWMS(){
	var contentPanelName = "cpDettWMS";
	var structure =
      {
        name: "p_pDettWMS", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_multiDataPanel", panels: [
            {
              name: "p_fpDati", panels: [
              {
                name: "p_wDettWMS", panels: []
              }
,              {
                name: "p_pDettaglioFun", panels: []
              }
              ]
            }
,            {
              name: "p_fpMessaggio", panels: [
              {
                name: "p_msgBoxNoElement", panels: [
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

	initStdEnrichments4CpDettWMS();
	initCustomEnrichments4CpDettWMS();
	initUIStructCpDettWMS();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettWMS");

});



