

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda4_4Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda4_4Dett() {
	var contentPanelName = "cpGestLibScheda4_4Dett";
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
	/// arricchimento di base per guigen::TextField [tfFluidoFrigorigeno]
	var addBasicEnrichmentToTfFluidoFrigorigeno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFluidoFrigorigeno',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfFluidoFrigorigeno);
	/// arricchimento per guigen::ComboBox [cbFonteEnergiaSfruttata]: autonarrowing
	var addNarrowingToCbFonteEnergiaSfruttata =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFonteEnergiaSfruttata',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbFonteEnergiaSfruttata);


	/// arricchimento per guigen::ComboBox [cbFluidoLatoUtenze]: autonarrowing
	var addNarrowingToCbFluidoLatoUtenze =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFluidoLatoUtenze',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbFluidoLatoUtenze);


	/// arricchimento per guigen::ComboBox [cbTipologia]: autonarrowing
	var addNarrowingToCbTipologia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipologia',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbTipologia);


	/// arricchimento per guigen::ComboBox [cbCombustibile]: autonarrowing
	var addNarrowingToCbCombustibile =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCombustibile',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbCombustibile);


	/// arricchimento di base per guigen::TextField [tfNumCircuiti]
	var addBasicEnrichmentToTfNumCircuiti =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumCircuiti',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfNumCircuiti);
	/// arricchimento di base per guigen::TextField [tfManutenzione]
	var addBasicEnrichmentToTfManutenzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfManutenzione',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfManutenzione);
	/// arricchimento di base per guigen::TextField [tfEer]
	var addBasicEnrichmentToTfEer =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEer',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRaffrescamentoRiscaldamento", addBasicEnrichmentToTfEer);
	/// arricchimento di base per guigen::TextField [tfPotenzaFrigo]
	var addBasicEnrichmentToTfPotenzaFrigo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaFrigo',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRaffrescamentoRiscaldamento", addBasicEnrichmentToTfPotenzaFrigo);
	/// arricchimento di base per guigen::TextField [tfPotenzaAssNom]
	var addBasicEnrichmentToTfPotenzaAssNom =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaAssNom',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRaffrescamentoRiscaldamento", addBasicEnrichmentToTfPotenzaAssNom);
	/// arricchimento di base per guigen::TextField [tfCop]
	var addBasicEnrichmentToTfCop =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCop',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRaffrescamentoRiscaldamento", addBasicEnrichmentToTfCop);
	/// arricchimento di base per guigen::TextField [tfPotenzaRisc]
	var addBasicEnrichmentToTfPotenzaRisc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaRisc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRaffrescamentoRiscaldamento", addBasicEnrichmentToTfPotenzaRisc);
	/// arricchimento di base per guigen::TextField [tfPotenzaAssRiscNom]
	var addBasicEnrichmentToTfPotenzaAssRiscNom =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaAssRiscNom',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRaffrescamentoRiscaldamento", addBasicEnrichmentToTfPotenzaAssRiscNom);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda4_4Dett(){
/*PROTECTED REGION ID(R425504329) ENABLED START*/
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

function initUIStructCpGestLibScheda4_4Dett(){
	var contentPanelName = "cpGestLibScheda4_4Dett";
	var structure =
      {
        name: "p_fpGestLibScheda4_4Dett", panels: [
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
            name: "p_wpRaffrescamentoRiscaldamento", panels: []
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

	initStdEnrichments4CpGestLibScheda4_4Dett();
	initCustomEnrichments4CpGestLibScheda4_4Dett();
	initUIStructCpGestLibScheda4_4Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda4_4Dett");

});



