

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda2] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda2() {
	var contentPanelName = "cpGestLibScheda2";
	/// arricchimento di base per guigen::TextField [tfClimaM3]
	var addBasicEnrichmentToTfClimaM3 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfClimaM3',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInfoGenerali", addBasicEnrichmentToTfClimaM3);
	/// arricchimento di base per guigen::TextField [tfDurezzaFr]
	var addBasicEnrichmentToTfDurezzaFr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDurezzaFr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInfoGenerali", addBasicEnrichmentToTfDurezzaFr);
	/// arricchimento di base per guigen::TextField [tfDurezzaTotFr]
	var addBasicEnrichmentToTfDurezzaTotFr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDurezzaTotFr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_3", addBasicEnrichmentToTfDurezzaTotFr);
	/// arricchimento di base per guigen::TextField [tfPercGliEtil]
	var addBasicEnrichmentToTfPercGliEtil =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPercGliEtil',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_3", addBasicEnrichmentToTfPercGliEtil);
	/// arricchimento di base per guigen::TextField [tfPhGliEtil]
	var addBasicEnrichmentToTfPhGliEtil =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPhGliEtil',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_3", addBasicEnrichmentToTfPhGliEtil);
	/// arricchimento di base per guigen::TextField [tfPercGliProp]
	var addBasicEnrichmentToTfPercGliProp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPercGliProp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_3", addBasicEnrichmentToTfPercGliProp);
	/// arricchimento di base per guigen::TextField [tfPhGliProp]
	var addBasicEnrichmentToTfPhGliProp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPhGliProp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_3", addBasicEnrichmentToTfPhGliProp);
	/// arricchimento di base per guigen::TextField [tfDurezzaAddolcFr]
	var addBasicEnrichmentToTfDurezzaAddolcFr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDurezzaAddolcFr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_4", addBasicEnrichmentToTfDurezzaAddolcFr);
	/// arricchimento per guigen::ComboBox [cbTipologiaCircuitoRaffreddamento]: autonarrowing
	var addNarrowingToCbTipologiaCircuitoRaffreddamento =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipologiaCircuitoRaffreddamento',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_5", addNarrowingToCbTipologiaCircuitoRaffreddamento);


	/// arricchimento per guigen::ComboBox [cbOrigineAcquaDiAlimento]: autonarrowing
	var addNarrowingToCbOrigineAcquaDiAlimento =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbOrigineAcquaDiAlimento',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_5", addNarrowingToCbOrigineAcquaDiAlimento);


	/// arricchimento per guigen::ComboBox [cbFiltrazione]: autonarrowing
	var addNarrowingToCbFiltrazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFiltrazione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_5", addNarrowingToCbFiltrazione);


	/// arricchimento per guigen::ComboBox [cbTrattamentoAcqua]: autonarrowing
	var addNarrowingToCbTrattamentoAcqua =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTrattamentoAcqua',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_5", addNarrowingToCbTrattamentoAcqua);


	/// arricchimento per guigen::ComboBox [cbCondizionamentoChimico]: autonarrowing
	var addNarrowingToCbCondizionamentoChimico =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCondizionamentoChimico',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_5", addNarrowingToCbCondizionamentoChimico);


	/// arricchimento di base per guigen::TextField [tfconducIngresso]
	var addBasicEnrichmentToTfconducIngresso =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfconducIngresso',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_5", addBasicEnrichmentToTfconducIngresso);
	/// arricchimento di base per guigen::TextField [tfTaratura]
	var addBasicEnrichmentToTfTaratura =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTaratura',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda2_5", addBasicEnrichmentToTfTaratura);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda2(){
/*PROTECTED REGION ID(R-1629722383) ENABLED START*/
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

function initUIStructCpGestLibScheda2(){
	var contentPanelName = "cpGestLibScheda2";
	var structure =
      {
        name: "p_fpGestLibScheda2", panels: [
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
            name: "p_fpScheda2", panels: [
            ]
          }
,          {
            name: "p_stdMsgLibretto", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpInfoGenerali", panels: []
          }
,          {
            name: "p_wpScheda2_3", panels: []
          }
,          {
            name: "p_wpScheda2_4", panels: []
          }
,          {
            name: "p_wpScheda2_5", panels: []
          }
,          {
            name: "p_cpFunGestScheda2", panels: []
          }
,          {
            name: "p_cpNavGestScheda2", panels: []
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

	initStdEnrichments4CpGestLibScheda2();
	initCustomEnrichments4CpGestLibScheda2();
	initUIStructCpGestLibScheda2();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda2");

});



