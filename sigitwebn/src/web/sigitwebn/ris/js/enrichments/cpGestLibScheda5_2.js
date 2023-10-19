

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda5_2] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda5_2() {
	var contentPanelName = "cpGestLibScheda5_2";
	/// arricchimento per guigen::ComboBox [l5_2tipoRegolazione]: autonarrowing
	var addNarrowingToL5_2tipoRegolazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_2tipoRegolazione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_2RegolazioneAmbiente", addNarrowingToL5_2tipoRegolazione);


	/// arricchimento per guigen::ComboBox [l5_2valvoleTermo]: autonarrowing
	var addNarrowingToL5_2valvoleTermo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_2valvoleTermo',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_2RegolazioneAmbiente", addNarrowingToL5_2valvoleTermo);


	/// arricchimento per guigen::ComboBox [l5_2valvole2]: autonarrowing
	var addNarrowingToL5_2valvole2 =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_2valvole2',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_2RegolazioneAmbiente", addNarrowingToL5_2valvole2);


	/// arricchimento per guigen::ComboBox [l5_2valvole3]: autonarrowing
	var addNarrowingToL5_2valvole3 =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_2valvole3',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_2RegolazioneAmbiente", addNarrowingToL5_2valvole3);


	/// arricchimento per guigen::ComboBox [l5_3telelettura]: autonarrowing
	var addNarrowingToL5_3telelettura =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_3telelettura',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_3SistemiTelematici", addNarrowingToL5_3telelettura);


	/// arricchimento per guigen::ComboBox [l5_3telegestione]: autonarrowing
	var addNarrowingToL5_3telegestione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_3telegestione',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_3SistemiTelematici", addNarrowingToL5_3telegestione);


	/// arricchimento per guigen::Calendar [l5_3DataSostituz]: aggiunta datepicker
	var addDateToL5_3DataSostituz = function(){
		uiNRichLib.addDatePickerNRich("widg_l5_3DataSostituz", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_3SistemiTelematici", addDateToL5_3DataSostituz);
	/// arricchimento per guigen::ComboBox [l5_4FlgUic]: autonarrowing
	var addNarrowingToL5_4FlgUic =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_4FlgUic',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_4Contabilizzazione", addNarrowingToL5_4FlgUic);


	/// arricchimento per guigen::ComboBox [l5_4FlgTipologia]: autonarrowing
	var addNarrowingToL5_4FlgTipologia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_l5_4FlgTipologia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_4Contabilizzazione", addNarrowingToL5_4FlgTipologia);


	/// arricchimento per guigen::Calendar [l5_4DataSostituz]: aggiunta datepicker
	var addDateToL5_4DataSostituz = function(){
		uiNRichLib.addDatePickerNRich("widg_l5_4DataSostituz", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda5_4Contabilizzazione", addDateToL5_4DataSostituz);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda5_2(){
/*PROTECTED REGION ID(R1882338983) ENABLED START*/
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

function initUIStructCpGestLibScheda5_2(){
	var contentPanelName = "cpGestLibScheda5_2";
	var structure =
      {
        name: "p_fpGestLibScheda5_2", panels: [
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
            name: "p_wpScheda5_1RegolazionePrimaria", panels: []
          }
,          {
            name: "p_wpScheda5_2RegolazioneAmbiente", panels: []
          }
,          {
            name: "p_wpScheda5_3SistemiTelematici", panels: []
          }
,          {
            name: "p_wpScheda5_4Contabilizzazione", panels: []
          }
,          {
            name: "p_cpFunGest", panels: []
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

	initStdEnrichments4CpGestLibScheda5_2();
	initCustomEnrichments4CpGestLibScheda5_2();
	initUIStructCpGestLibScheda5_2();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda5_2");

});



