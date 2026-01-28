

/**
 * Arricchimenti standard per il ContentPanel [cpGestReeTipo1Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestReeTipo1Dett() {
	var contentPanelName = "cpGestReeTipo1Dett";
	/// arricchimento di base per guigen::TextField [tfPotMax]
	var addBasicEnrichmentToTfPotMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfPotMax);
	/// arricchimento per guigen::ComboBox [cbTipologiaTipo1B]: autonarrowing
	var addNarrowingToCbTipologiaTipo1B =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipologiaTipo1B',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbTipologiaTipo1B);


	/// arricchimento per guigen::ComboBox [cbStelle]: autonarrowing
	var addNarrowingToCbStelle =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStelle',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbStelle);


	/// arricchimento per guigen::ComboBox [cbApparecchiatura]: autonarrowing
	var addNarrowingToCbApparecchiatura =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbApparecchiatura',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbApparecchiatura);


	/// arricchimento di base per guigen::TextField [tfDepCan]
	var addBasicEnrichmentToTfDepCan =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDepCan',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfDepCan);
	/// arricchimento per guigen::ComboBox [cbMarcaturaCE]: autonarrowing
	var addNarrowingToCbMarcaturaCE =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbMarcaturaCE',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbMarcaturaCE);


	/// arricchimento per guigen::ComboBox [cbPlaccaCamino]: autonarrowing
	var addNarrowingToCbPlaccaCamino =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbPlaccaCamino',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbPlaccaCamino);


	/// arricchimento per guigen::ComboBox [cbModalita]: autonarrowing
	var addNarrowingToCbModalita =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbModalita',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbModalita);


	/// arricchimento per guigen::ComboBox [cbAriaComburente]: autonarrowing
	var addNarrowingToCbAriaComburente =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAriaComburente',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbAriaComburente);


	/// arricchimento per guigen::ComboBox [cbControlloAriaComburente]: autonarrowing
	var addNarrowingToCbControlloAriaComburente =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbControlloAriaComburente',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbControlloAriaComburente);


	/// arricchimento per guigen::ComboBox [cbCaricamentoCombustibile]: autonarrowing
	var addNarrowingToCbCaricamentoCombustibile =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCaricamentoCombustibile',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbCaricamentoCombustibile);



	/// arricchimento per guigen::ComboBox [cbModuli]: autonarrowing
	var addNarrowingToCbModuli =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbModuli',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpElencoNonCompilati", addNarrowingToCbModuli);


	/// arricchimento di base per guigen::TextField [tfTempFumiC]
	var addBasicEnrichmentToTfTempFumiC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempFumiC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfTempFumiC);
	/// arricchimento di base per guigen::TextField [tfTempAriaC]
	var addBasicEnrichmentToTfTempAriaC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempAriaC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfTempAriaC);
	/// arricchimento di base per guigen::TextField [tfO2Perc]
	var addBasicEnrichmentToTfO2Perc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfO2Perc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfO2Perc);
	/// arricchimento di base per guigen::TextField [tfCo2Perc]
	var addBasicEnrichmentToTfCo2Perc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCo2Perc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfCo2Perc);
	/// arricchimento di base per guigen::TextField [tfParticolatoPrimarioMgM3]
	var addBasicEnrichmentToTfParticolatoPrimarioMgM3 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticolatoPrimarioMgM3',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfParticolatoPrimarioMgM3);
	/// arricchimento di base per guigen::TextField [tfBacharachMin]
	var addBasicEnrichmentToTfBacharachMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfBacharachMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfBacharachMin);
	/// arricchimento di base per guigen::TextField [tfBacharachMed]
	var addBasicEnrichmentToTfBacharachMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfBacharachMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfBacharachMed);
	/// arricchimento di base per guigen::TextField [tfBacharachMax]
	var addBasicEnrichmentToTfBacharachMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfBacharachMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfBacharachMax);
	/// arricchimento di base per guigen::TextField [tfCoCorrettoPpm]
	var addBasicEnrichmentToTfCoCorrettoPpm =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCoCorrettoPpm',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfCoCorrettoPpm);
	/// arricchimento di base per guigen::TextField [tfCoCorrettoPpmTipo1B]
	var addBasicEnrichmentToTfCoCorrettoPpmTipo1B =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCoCorrettoPpmTipo1B',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfCoCorrettoPpmTipo1B);
	/// arricchimento di base per guigen::TextField [tfRendCombPerc]
	var addBasicEnrichmentToTfRendCombPerc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendCombPerc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfRendCombPerc);
	/// arricchimento di base per guigen::TextField [tfRendCombPercTipo1B]
	var addBasicEnrichmentToTfRendCombPercTipo1B =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendCombPercTipo1B',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfRendCombPercTipo1B);
	/// arricchimento di base per guigen::TextField [tfRendMInLeggePerc]
	var addBasicEnrichmentToTfRendMInLeggePerc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendMInLeggePerc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfRendMInLeggePerc);
	/// arricchimento di base per guigen::TextField [tfNoxPpm]
	var addBasicEnrichmentToTfNoxPpm =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoxPpm',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfNoxPpm);
	/// arricchimento di base per guigen::TextField [tfNoxPpmTipo1B]
	var addBasicEnrichmentToTfNoxPpmTipo1B =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoxPpmTipo1B',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfNoxPpmTipo1B);
	/// arricchimento di base per guigen::TextField [tfNoxNm3Tipo1B]
	var addBasicEnrichmentToTfNoxNm3Tipo1B =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoxNm3Tipo1B',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfNoxNm3Tipo1B);
	/// arricchimento per guigen::ComboBox [cbPortataCombUm]: autonarrowing
	var addNarrowingToCbPortataCombUm =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbPortataCombUm',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addNarrowingToCbPortataCombUm);


	/// arricchimento di base per guigen::TextField [tfPortataComb]
	var addBasicEnrichmentToTfPortataComb =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPortataComb',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfPortataComb);
	/// arricchimento di base per guigen::TextField [tfCoNoAriaPpm]
	var addBasicEnrichmentToTfCoNoAriaPpm =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCoNoAriaPpm',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfCoNoAriaPpm);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestReeTipo1Dett(){
/*PROTECTED REGION ID(R1028056698) ENABLED START*/
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

function initUIStructCpGestReeTipo1Dett(){
	var contentPanelName = "cpGestReeTipo1Dett";
	var structure =
      {
        name: "p_fpGestReeTipo1Dett", panels: [
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
            name: "p_mpReeTipo1Title", panels: [
            {
              name: "p_fpGestReeTitleTipo1", panels: [
              ]
            }
            ]
          }
,          {
            name: "p_mpReeTipo1BTitle", panels: [
            {
              name: "p_fpGestReeTitleTipo1B", panels: [
              ]
            }
            ]
          }
,          {
            name: "p_stdMsgReeDett", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpE", panels: []
          }
,          {
            name: "p_mpConsumoCombustibile", panels: [
            {
              name: "p_fpConsumoCombustibile", panels: [
              {
                name: "p_wpConsumoCombustibile", panels: []
              }
,              {
                name: "p_cpConsumoCombustibile", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_wpElencoNonCompilati", panels: []
          }
,          {
            name: "p_wpModulo", panels: []
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

	initStdEnrichments4CpGestReeTipo1Dett();
	initCustomEnrichments4CpGestReeTipo1Dett();
	initUIStructCpGestReeTipo1Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestReeTipo1Dett");

});



