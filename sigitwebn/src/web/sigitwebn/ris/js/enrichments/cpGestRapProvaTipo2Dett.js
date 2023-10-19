

/**
 * Arricchimenti standard per il ContentPanel [cpGestRapProvaTipo2Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestRapProvaTipo2Dett() {
	var contentPanelName = "cpGestRapProvaTipo2Dett";
	/// arricchimento per guigen::ComboBox [freq]: autonarrowing
	var addNarrowingToFreq =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_freq',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp7", addNarrowingToFreq);


	/// arricchimento di base per guigen::TextField [tfFreqAltro]
	var addBasicEnrichmentToTfFreqAltro =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFreqAltro',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp7", addBasicEnrichmentToTfFreqAltro);
	/// arricchimento per guigen::Calendar [calManu]: aggiunta datepicker
	var addDateToCalManu = function(){
		uiNRichLib.addDatePickerNRich("widg_calManu", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp7", addDateToCalManu);
	/// arricchimento per guigen::Calendar [calPres]: aggiunta datepicker
	var addDateToCalPres = function(){
		uiNRichLib.addDatePickerNRich("widg_calPres", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp7", addDateToCalPres);
	/// arricchimento per guigen::ComboBox [cbCircuiti]: autonarrowing
	var addNarrowingToCbCircuiti =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCircuiti',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8", addNarrowingToCbCircuiti);


	/// arricchimento di base per guigen::TextField [tfMarca]
	var addBasicEnrichmentToTfMarca =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMarca',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfMarca);
	/// arricchimento di base per guigen::TextField [tfModello]
	var addBasicEnrichmentToTfModello =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfModello',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfModello);
	/// arricchimento di base per guigen::TextField [tfMatricola]
	var addBasicEnrichmentToTfMatricola =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMatricola',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfMatricola);
	/// arricchimento di base per guigen::TextField [s8fPotAssorbitaKw]
	var addBasicEnrichmentToS8fPotAssorbitaKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_s8fPotAssorbitaKw',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToS8fPotAssorbitaKw);
	/// arricchimento di base per guigen::TextField [tfSurriscaldamento]
	var addBasicEnrichmentToTfSurriscaldamento =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSurriscaldamento',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfSurriscaldamento);
	/// arricchimento di base per guigen::TextField [tfSottoraffreddamento]
	var addBasicEnrichmentToTfSottoraffreddamento =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottoraffreddamento',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfSottoraffreddamento);
	/// arricchimento di base per guigen::TextField [tfs8jTempCondensazioneC]
	var addBasicEnrichmentToTfs8jTempCondensazioneC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfs8jTempCondensazioneC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfs8jTempCondensazioneC);
	/// arricchimento di base per guigen::TextField [tfs8jTempEvaporazioneC]
	var addBasicEnrichmentToTfs8jTempEvaporazioneC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfs8jTempEvaporazioneC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfs8jTempEvaporazioneC);
	/// arricchimento di base per guigen::TextField [tfs8jTempSorgIngressoC]
	var addBasicEnrichmentToTfs8jTempSorgIngressoC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfs8jTempSorgIngressoC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfs8jTempSorgIngressoC);
	/// arricchimento di base per guigen::TextField [tfs8jTempSorgUscitaC]
	var addBasicEnrichmentToTfs8jTempSorgUscitaC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfs8jTempSorgUscitaC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfs8jTempSorgUscitaC);
	/// arricchimento di base per guigen::TextField [tfs8jTempIngressoFluidoC]
	var addBasicEnrichmentToTfs8jTempIngressoFluidoC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfs8jTempIngressoFluidoC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfs8jTempIngressoFluidoC);
	/// arricchimento di base per guigen::TextField [tfs8jTempUscitaFluidoC]
	var addBasicEnrichmentToTfs8jTempUscitaFluidoC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfs8jTempUscitaFluidoC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Circuito", addBasicEnrichmentToTfs8jTempUscitaFluidoC);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestRapProvaTipo2Dett(){
/*PROTECTED REGION ID(R-1908581282) ENABLED START*/
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

function initUIStructCpGestRapProvaTipo2Dett(){
	var contentPanelName = "cpGestRapProvaTipo2Dett";
	var structure =
      {
        name: "p_fpGestRapProvaTipo2", panels: [
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
            name: "p_wpMenuRapProva", panels: []
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpGestRapProva", panels: [
            {
              name: "p_stdMsgRapProva", panels: [
              ]
            }
            ]
          }
,          {
            name: "p_wp6", panels: []
          }
,          {
            name: "p_wp7", panels: []
          }
,          {
            name: "p_wp8", panels: []
          }
,          {
            name: "p_wp8Circuito", panels: []
          }
,          {
            name: "p_wp9", panels: []
          }
,          {
            name: "p_cpFunGestRapProva", panels: []
          }
,          {
            name: "p_cpNavGestRapProvaDett", panels: []
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

	initStdEnrichments4CpGestRapProvaTipo2Dett();
	initCustomEnrichments4CpGestRapProvaTipo2Dett();
	initUIStructCpGestRapProvaTipo2Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestRapProvaTipo2Dett");

});



