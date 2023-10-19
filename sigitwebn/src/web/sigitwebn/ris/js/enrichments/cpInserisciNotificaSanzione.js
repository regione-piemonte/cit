

/**
 * Arricchimenti standard per il ContentPanel [cpInserisciNotificaSanzione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpInserisciNotificaSanzione() {
	var contentPanelName = "cpInserisciNotificaSanzione";
	/// arricchimento di base per guigen::TextField [tfValoreSanzione]
	var addBasicEnrichmentToTfValoreSanzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfValoreSanzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserisciSanzione", addBasicEnrichmentToTfValoreSanzione);
	/// arricchimento di base per guigen::TextField [tfCodiceFiscale]
	var addBasicEnrichmentToTfCodiceFiscale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodiceFiscale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfCodiceFiscale);
	/// arricchimento di base per guigen::TextField [tfCognome]
	var addBasicEnrichmentToTfCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfCognome);
	/// arricchimento di base per guigen::TextField [tfNome]
	var addBasicEnrichmentToTfNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfNome);
	/// arricchimento per guigen::ComboBox [cbProvincia]: autonarrowing
	var addNarrowingToCbProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addNarrowingToCbProvincia);


	/// arricchimento per guigen::ComboBox [cbComune]: autonarrowing
	var addNarrowingToCbComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addNarrowingToCbComune);


	/// arricchimento di base per guigen::TextField [tfIndirizzo]
	var addBasicEnrichmentToTfIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfIndirizzo);
	/// arricchimento per guigen::ComboBox [cbIndirizzo]: autonarrowing
	var addNarrowingToCbIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addNarrowingToCbIndirizzo);


	/// arricchimento di base per guigen::TextField [tfNoStradario]
	var addBasicEnrichmentToTfNoStradario =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoStradario',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfNoStradario);
	/// arricchimento di base per guigen::TextField [tfCivico]
	var addBasicEnrichmentToTfCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfCivico);
	/// arricchimento di base per guigen::TextField [tfStatoEstero]
	var addBasicEnrichmentToTfStatoEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfStatoEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfStatoEstero);
	/// arricchimento di base per guigen::TextField [tfCittaEstera]
	var addBasicEnrichmentToTfCittaEstera =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCittaEstera',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfCittaEstera);
	/// arricchimento di base per guigen::TextField [tfIndirizzoEstero]
	var addBasicEnrichmentToTfIndirizzoEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfIndirizzoEstero);
	/// arricchimento di base per guigen::TextField [tfCivicoEstero]
	var addBasicEnrichmentToTfCivicoEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCivicoEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfCivicoEstero);
	/// arricchimento di base per guigen::TextField [tfCapEstero]
	var addBasicEnrichmentToTfCapEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCapEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPersonaSanzionata", addBasicEnrichmentToTfCapEstero);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpInserisciNotificaSanzione(){
/*PROTECTED REGION ID(R-2039709074) ENABLED START*/
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

function initUIStructCpInserisciNotificaSanzione(){
	var contentPanelName = "cpInserisciNotificaSanzione";
	var structure =
      {
        name: "p_fpInsNotSanzione", panels: [
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
            name: "p_stdErrorMessageInserisciNotificaSanzione", panels: [
            ]
          }
,          {
            name: "p_wpInserisciSanzione", panels: []
          }
,          {
            name: "p_mpSanzionati", panels: [
            {
              name: "p_fpSanzionato", panels: [
              {
                name: "p_wpPersonaSanzionata", panels: []
              }
              ]
            }
,            {
              name: "p_fpElencoSanzionati", panels: [
              {
                name: "p_wpElencoSanzionati", panels: []
              }
,              {
                name: "p_cpElencoSanzionabili", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpFunDettaglioSanzione", panels: []
          }
,          {
            name: "p_cpNavDettaglioSanzione", panels: []
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

	initStdEnrichments4CpInserisciNotificaSanzione();
	initCustomEnrichments4CpInserisciNotificaSanzione();
	initUIStructCpInserisciNotificaSanzione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpInserisciNotificaSanzione");

});



