

/**
 * Arricchimenti standard per il ContentPanel [cpGestReeTipo3Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestReeTipo3Dett() {
	var contentPanelName = "cpGestReeTipo3Dett";
	/// arricchimento per guigen::ComboBox [cbAlimentazione]: autonarrowing
	var addNarrowingToCbAlimentazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAlimentazione',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbAlimentazione);


	/// arricchimento per guigen::ComboBox [cbFluido]: autonarrowing
	var addNarrowingToCbFluido =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFluido',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbFluido);


	/// arricchimento di base per guigen::TextField [tfTempEst]
	var addBasicEnrichmentToTfTempEst =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempEst',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfTempEst);
	/// arricchimento di base per guigen::TextField [tfTempMandPrimario]
	var addBasicEnrichmentToTfTempMandPrimario =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempMandPrimario',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfTempMandPrimario);
	/// arricchimento di base per guigen::TextField [tfTempRitPrimario]
	var addBasicEnrichmentToTfTempRitPrimario =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempRitPrimario',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfTempRitPrimario);
	/// arricchimento di base per guigen::TextField [tfPotTerm]
	var addBasicEnrichmentToTfPotTerm =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotTerm',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfPotTerm);
	/// arricchimento di base per guigen::TextField [tfPotFlu]
	var addBasicEnrichmentToTfPotFlu =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotFlu',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfPotFlu);
	/// arricchimento di base per guigen::TextField [tfTempMandSecond]
	var addBasicEnrichmentToTfTempMandSecond =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempMandSecond',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfTempMandSecond);
	/// arricchimento di base per guigen::TextField [tfTempRitSecond]
	var addBasicEnrichmentToTfTempRitSecond =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempRitSecond',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfTempRitSecond);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestReeTipo3Dett(){
/*PROTECTED REGION ID(R-777381636) ENABLED START*/
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

function initUIStructCpGestReeTipo3Dett(){
	var contentPanelName = "cpGestReeTipo3Dett";
	var structure =
      {
        name: "p_fpGestReeTipo3Dett", panels: [
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
            name: "p_fpGestRee", panels: [
            ]
          }
,          {
            name: "p_stdMsgRee", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpE", panels: []
          }
,          {
            name: "p_cpFunGestReeDett", panels: []
          }
,          {
            name: "p_cpNavGestReeDett", panels: []
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

	initStdEnrichments4CpGestReeTipo3Dett();
	initCustomEnrichments4CpGestReeTipo3Dett();
	initUIStructCpGestReeTipo3Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestReeTipo3Dett");

});



