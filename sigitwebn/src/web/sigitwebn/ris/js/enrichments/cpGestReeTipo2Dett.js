

/**
 * Arricchimenti standard per il ContentPanel [cpGestReeTipo2Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestReeTipo2Dett() {
	var contentPanelName = "cpGestReeTipo2Dett";
	/// arricchimento per guigen::ComboBox [cbCircuiti]: autonarrowing
	var addNarrowingToCbCircuiti =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCircuiti',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpElencoNonCompilati", addNarrowingToCbCircuiti);


	/// arricchimento di base per guigen::TextField [tfSurrisc]
	var addBasicEnrichmentToTfSurrisc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSurrisc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfSurrisc);
	/// arricchimento di base per guigen::TextField [tfSottoraffredd]
	var addBasicEnrichmentToTfSottoraffredd =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSottoraffredd',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfSottoraffredd);
	/// arricchimento di base per guigen::TextField [tfCondensazione]
	var addBasicEnrichmentToTfCondensazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCondensazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfCondensazione);
	/// arricchimento di base per guigen::TextField [tfEvaporazione]
	var addBasicEnrichmentToTfEvaporazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEvaporazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfEvaporazione);
	/// arricchimento di base per guigen::TextField [tfInLatoEst]
	var addBasicEnrichmentToTfInLatoEst =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInLatoEst',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfInLatoEst);
	/// arricchimento di base per guigen::TextField [tfOutLatoEst]
	var addBasicEnrichmentToTfOutLatoEst =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOutLatoEst',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfOutLatoEst);
	/// arricchimento di base per guigen::TextField [tfInLatoUtenze]
	var addBasicEnrichmentToTfInLatoUtenze =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInLatoUtenze',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfInLatoUtenze);
	/// arricchimento di base per guigen::TextField [tfOutLatoUtenze]
	var addBasicEnrichmentToTfOutLatoUtenze =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOutLatoUtenze',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfOutLatoUtenze);
	/// arricchimento di base per guigen::TextField [tfTorreOutFluido]
	var addBasicEnrichmentToTfTorreOutFluido =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTorreOutFluido',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfTorreOutFluido);
	/// arricchimento di base per guigen::TextField [tfTorreBulboUmido]
	var addBasicEnrichmentToTfTorreBulboUmido =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTorreBulboUmido',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfTorreBulboUmido);
	/// arricchimento di base per guigen::TextField [tfScambiatoreInExt]
	var addBasicEnrichmentToTfScambiatoreInExt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfScambiatoreInExt',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfScambiatoreInExt);
	/// arricchimento di base per guigen::TextField [tfScambiatoreOutExt]
	var addBasicEnrichmentToTfScambiatoreOutExt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfScambiatoreOutExt',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfScambiatoreOutExt);
	/// arricchimento di base per guigen::TextField [tfScambiatoreInMacchina]
	var addBasicEnrichmentToTfScambiatoreInMacchina =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfScambiatoreInMacchina',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfScambiatoreInMacchina);
	/// arricchimento di base per guigen::TextField [tfScambiatoreOutMacchina]
	var addBasicEnrichmentToTfScambiatoreOutMacchina =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfScambiatoreOutMacchina',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfScambiatoreOutMacchina);
	/// arricchimento di base per guigen::TextField [tfPotenzaAssorbitaKw]
	var addBasicEnrichmentToTfPotenzaAssorbitaKw =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaAssorbitaKw',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addBasicEnrichmentToTfPotenzaAssorbitaKw);
	/// arricchimento per guigen::Calendar [cDataRipristino]: aggiunta datepicker
	var addDateToCDataRipristino = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataRipristino", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCircuito", addDateToCDataRipristino);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestReeTipo2Dett(){
/*PROTECTED REGION ID(R-2022146117) ENABLED START*/
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

function initUIStructCpGestReeTipo2Dett(){
	var contentPanelName = "cpGestReeTipo2Dett";
	var structure =
      {
        name: "p_fpGestReeTipo2Dett", panels: [
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
            name: "p_wpElencoNonCompilati", panels: []
          }
,          {
            name: "p_wpCircuito", panels: []
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

	initStdEnrichments4CpGestReeTipo2Dett();
	initCustomEnrichments4CpGestReeTipo2Dett();
	initUIStructCpGestReeTipo2Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestReeTipo2Dett");

});



