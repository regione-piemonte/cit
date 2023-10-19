

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda4_1Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda4_1Dett() {
	var contentPanelName = "cpGestLibScheda4_1Dett";
	/// arricchimento per guigen::Calendar [cDataInstallazione]: aggiunta datepicker
	var addDateToCDataInstallazione = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataInstallazione", 
		true, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addDateToCDataInstallazione);
	/// arricchimento per guigen::Calendar [cDataDismissione]: aggiunta datepicker
	var addDateToCDataDismissione = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataDismissione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addDateToCDataDismissione);
	/// arricchimento per guigen::ComboBox [cbFabbricante]: autonarrowing
	var addNarrowingToCbFabbricante =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFabbricante',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbFabbricante);


	/// arricchimento di base per guigen::TextField [tfModello]
	var addBasicEnrichmentToTfModello =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfModello',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfModello);
	/// arricchimento di base per guigen::TextField [tfMatricola]
	var addBasicEnrichmentToTfMatricola =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMatricola',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfMatricola);
	/// arricchimento per guigen::ComboBox [cbCombustibile]: autonarrowing
	var addNarrowingToCbCombustibile =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCombustibile',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbCombustibile);


	/// arricchimento per guigen::ComboBox [cbFluido]: autonarrowing
	var addNarrowingToCbFluido =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFluido',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbFluido);


	/// arricchimento di base per guigen::TextField [tfPotenzaTermica]
	var addBasicEnrichmentToTfPotenzaTermica =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaTermica',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfPotenzaTermica);
	/// arricchimento di base per guigen::TextField [tfRendimentoPerc]
	var addBasicEnrichmentToTfRendimentoPerc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendimentoPerc',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfRendimentoPerc);
	/// arricchimento per guigen::ComboBox [cbTipologia]: autonarrowing
	var addNarrowingToCbTipologia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipologia',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbTipologia);


	/// arricchimento di base per guigen::TextField [tfModuli]
	var addBasicEnrichmentToTfModuli =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfModuli',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfModuli);
	/// arricchimento per guigen::ComboBox [cbTipologiaCannaFumaria]: autonarrowing
	var addNarrowingToCbTipologiaCannaFumaria =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipologiaCannaFumaria',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbTipologiaCannaFumaria);


	/// arricchimento di base per guigen::TextField [tfOreOperative]
	var addBasicEnrichmentToTfOreOperative =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOreOperative',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfOreOperative);
	/// arricchimento di base per guigen::TextField [tfAnni]
	var addBasicEnrichmentToTfAnni =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnni',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfAnni);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda4_1Dett(){
/*PROTECTED REGION ID(R986178182) ENABLED START*/
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

function initUIStructCpGestLibScheda4_1Dett(){
	var contentPanelName = "cpGestLibScheda4_1Dett";
	var structure =
      {
        name: "p_fpGestLibScheda4_1Dett", panels: [
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
            name: "p_fpTitolo", panels: [
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
            name: "p_wpComponente", panels: []
          }
,          {
            name: "p_cpFunGestComponente", panels: []
          }
,          {
            name: "p_wpComponentiSostituite", panels: []
          }
,          {
            name: "p_cpNavGestComponente", panels: []
          }
,          {
            name: "p_cpNavGest", panels: []
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

	initStdEnrichments4CpGestLibScheda4_1Dett();
	initCustomEnrichments4CpGestLibScheda4_1Dett();
	initUIStructCpGestLibScheda4_1Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda4_1Dett");

});



