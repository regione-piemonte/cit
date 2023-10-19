

/**
 * Arricchimenti standard per il ContentPanel [cpGestReeTipo4Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestReeTipo4Dett() {
	var contentPanelName = "cpGestReeTipo4Dett";
	/// arricchimento per guigen::ComboBox [cbFluido]: autonarrowing
	var addNarrowingToCbFluido =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFluido',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addNarrowingToCbFluido);


	/// arricchimento di base per guigen::TextField [tfPotAssorbCombKw]
	var addBasicEnrichmentToTfPotAssorbCombKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotAssorbCombKw',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfPotAssorbCombKw);
	/// arricchimento di base per guigen::TextField [tfPotTermBypassKw]
	var addBasicEnrichmentToTfPotTermBypassKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotTermBypassKw',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpE", addBasicEnrichmentToTfPotTermBypassKw);
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
	/// arricchimento di base per guigen::TextField [tfTempH2oOutC]
	var addBasicEnrichmentToTfTempH2oOutC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempH2oOutC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfTempH2oOutC);
	/// arricchimento di base per guigen::TextField [tfTempH2oInC]
	var addBasicEnrichmentToTfTempH2oInC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempH2oInC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfTempH2oInC);
	/// arricchimento di base per guigen::TextField [tfPotenzaMorsettiKw]
	var addBasicEnrichmentToTfPotenzaMorsettiKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaMorsettiKw',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfPotenzaMorsettiKw);
	/// arricchimento di base per guigen::TextField [tfTempH2oMotoreC]
	var addBasicEnrichmentToTfTempH2oMotoreC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempH2oMotoreC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfTempH2oMotoreC);
	/// arricchimento di base per guigen::TextField [tfTempFumiValleC]
	var addBasicEnrichmentToTfTempFumiValleC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempFumiValleC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfTempFumiValleC);
	/// arricchimento di base per guigen::TextField [tfTempFumiMonteC]
	var addBasicEnrichmentToTfTempFumiMonteC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempFumiMonteC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfTempFumiMonteC);
	/// arricchimento di base per guigen::TextField [tfSovrafreqSogliaHzMin]
	var addBasicEnrichmentToTfSovrafreqSogliaHzMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovrafreqSogliaHzMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovrafreqSogliaHzMin);
	/// arricchimento di base per guigen::TextField [tfSovrafreqSogliaHzMed]
	var addBasicEnrichmentToTfSovrafreqSogliaHzMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovrafreqSogliaHzMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovrafreqSogliaHzMed);
	/// arricchimento di base per guigen::TextField [tfSovrafreqSogliaHzMax]
	var addBasicEnrichmentToTfSovrafreqSogliaHzMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovrafreqSogliaHzMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovrafreqSogliaHzMax);
	/// arricchimento di base per guigen::TextField [tfSovrafreqTempoSMin]
	var addBasicEnrichmentToTfSovrafreqTempoSMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovrafreqTempoSMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovrafreqTempoSMin);
	/// arricchimento di base per guigen::TextField [tfSovrafreqTempoSMed]
	var addBasicEnrichmentToTfSovrafreqTempoSMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovrafreqTempoSMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovrafreqTempoSMed);
	/// arricchimento di base per guigen::TextField [tfSovrafreqTempoSMax]
	var addBasicEnrichmentToTfSovrafreqTempoSMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovrafreqTempoSMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovrafreqTempoSMax);
	/// arricchimento di base per guigen::TextField [tfSottofreqSogliaHzMin]
	var addBasicEnrichmentToTfSottofreqSogliaHzMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottofreqSogliaHzMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottofreqSogliaHzMin);
	/// arricchimento di base per guigen::TextField [tfSottofreqSogliaHzMed]
	var addBasicEnrichmentToTfSottofreqSogliaHzMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottofreqSogliaHzMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottofreqSogliaHzMed);
	/// arricchimento di base per guigen::TextField [tfSottofreqSogliaHzMax]
	var addBasicEnrichmentToTfSottofreqSogliaHzMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottofreqSogliaHzMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottofreqSogliaHzMax);
	/// arricchimento di base per guigen::TextField [tfSottofreqTempoSMin]
	var addBasicEnrichmentToTfSottofreqTempoSMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottofreqTempoSMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottofreqTempoSMin);
	/// arricchimento di base per guigen::TextField [tfSottofreqTempoSMed]
	var addBasicEnrichmentToTfSottofreqTempoSMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottofreqTempoSMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottofreqTempoSMed);
	/// arricchimento di base per guigen::TextField [tfSottofreqTempoSMax]
	var addBasicEnrichmentToTfSottofreqTempoSMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottofreqTempoSMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottofreqTempoSMax);
	/// arricchimento di base per guigen::TextField [tfSovratensSogliaVMin]
	var addBasicEnrichmentToTfSovratensSogliaVMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovratensSogliaVMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovratensSogliaVMin);
	/// arricchimento di base per guigen::TextField [tfSovratensSogliaVMed]
	var addBasicEnrichmentToTfSovratensSogliaVMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovratensSogliaVMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovratensSogliaVMed);
	/// arricchimento di base per guigen::TextField [tfSovratensSogliaVMax]
	var addBasicEnrichmentToTfSovratensSogliaVMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovratensSogliaVMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovratensSogliaVMax);
	/// arricchimento di base per guigen::TextField [tfSovratensTempoSMin]
	var addBasicEnrichmentToTfSovratensTempoSMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovratensTempoSMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovratensTempoSMin);
	/// arricchimento di base per guigen::TextField [tfSovratensTempoSMed]
	var addBasicEnrichmentToTfSovratensTempoSMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovratensTempoSMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovratensTempoSMed);
	/// arricchimento di base per guigen::TextField [tfSovratensTempoSMax]
	var addBasicEnrichmentToTfSovratensTempoSMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSovratensTempoSMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSovratensTempoSMax);
	/// arricchimento di base per guigen::TextField [tfSottotensSogliaVMin]
	var addBasicEnrichmentToTfSottotensSogliaVMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottotensSogliaVMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottotensSogliaVMin);
	/// arricchimento di base per guigen::TextField [tfSottotensSogliaVMed]
	var addBasicEnrichmentToTfSottotensSogliaVMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottotensSogliaVMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottotensSogliaVMed);
	/// arricchimento di base per guigen::TextField [tfSottotensSogliaVMax]
	var addBasicEnrichmentToTfSottotensSogliaVMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottotensSogliaVMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottotensSogliaVMax);
	/// arricchimento di base per guigen::TextField [tfSottotensTempoSMin]
	var addBasicEnrichmentToTfSottotensTempoSMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottotensTempoSMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottotensTempoSMin);
	/// arricchimento di base per guigen::TextField [tfSottotensTempoSMed]
	var addBasicEnrichmentToTfSottotensTempoSMed =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottotensTempoSMed',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottotensTempoSMed);
	/// arricchimento di base per guigen::TextField [tfSottotensTempoSMax]
	var addBasicEnrichmentToTfSottotensTempoSMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottotensTempoSMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpModulo", addBasicEnrichmentToTfSottotensTempoSMax);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestReeTipo4Dett(){
/*PROTECTED REGION ID(R467382845) ENABLED START*/
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

function initUIStructCpGestReeTipo4Dett(){
	var contentPanelName = "cpGestReeTipo4Dett";
	var structure =
      {
        name: "p_fpGestReeTipo4Dett", panels: [
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

	initStdEnrichments4CpGestReeTipo4Dett();
	initCustomEnrichments4CpGestReeTipo4Dett();
	initUIStructCpGestReeTipo4Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestReeTipo4Dett");

});



