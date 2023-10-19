

/**
 * Arricchimenti standard per il ContentPanel [cpGestRapProvaTipo1Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestRapProvaTipo1Dett() {
	var contentPanelName = "cpGestRapProvaTipo1Dett";
	/// arricchimento per guigen::ComboBox [cbEvac]: autonarrowing
	var addNarrowingToCbEvac =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbEvac',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addNarrowingToCbEvac);


	/// arricchimento per guigen::ComboBox [classDpr]: autonarrowing
	var addNarrowingToClassDpr =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_classDpr',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addNarrowingToClassDpr);


	/// arricchimento di base per guigen::TextField [tfPotTermFoc]
	var addBasicEnrichmentToTfPotTermFoc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotTermFoc',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addBasicEnrichmentToTfPotTermFoc);
	/// arricchimento di base per guigen::TextField [tfDa]
	var addBasicEnrichmentToTfDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addBasicEnrichmentToTfDa);
	/// arricchimento di base per guigen::TextField [tfA]
	var addBasicEnrichmentToTfA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfA',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addBasicEnrichmentToTfA);
	/// arricchimento di base per guigen::TextField [tfPrtComb1]
	var addBasicEnrichmentToTfPrtComb1 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPrtComb1',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addBasicEnrichmentToTfPrtComb1);
	/// arricchimento di base per guigen::TextField [tfPrtComb2]
	var addBasicEnrichmentToTfPrtComb2 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPrtComb2',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addBasicEnrichmentToTfPrtComb2);
	/// arricchimento di base per guigen::TextField [tfPtTermFoc]
	var addBasicEnrichmentToTfPtTermFoc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPtTermFoc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp6", addBasicEnrichmentToTfPtTermFoc);
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
	/// arricchimento per guigen::ComboBox [cbModuli]: autonarrowing
	var addNarrowingToCbModuli =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbModuli',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8", addNarrowingToCbModuli);


	/// arricchimento di base per guigen::TextField [tfTemp1]
	var addBasicEnrichmentToTfTemp1 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTemp1',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfTemp1);
	/// arricchimento di base per guigen::TextField [tfTemp2]
	var addBasicEnrichmentToTfTemp2 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTemp2',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfTemp2);
	/// arricchimento di base per guigen::TextField [tfTemp3]
	var addBasicEnrichmentToTfTemp3 =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTemp3',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfTemp3);
	/// arricchimento di base per guigen::TextField [tfMarca]
	var addBasicEnrichmentToTfMarca =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMarca',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfMarca);
	/// arricchimento di base per guigen::TextField [tfModello]
	var addBasicEnrichmentToTfModello =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfModello',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfModello);
	/// arricchimento di base per guigen::TextField [tfMatricola]
	var addBasicEnrichmentToTfMatricola =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMatricola',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfMatricola);
	/// arricchimento di base per guigen::TextField [tfTempFluido]
	var addBasicEnrichmentToTfTempFluido =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempFluido',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfTempFluido);
	/// arricchimento di base per guigen::TextField [tfTempAria]
	var addBasicEnrichmentToTfTempAria =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempAria',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfTempAria);
	/// arricchimento di base per guigen::TextField [tfTempFumi]
	var addBasicEnrichmentToTfTempFumi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTempFumi',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfTempFumi);
	/// arricchimento per guigen::ComboBox [percDi]: autonarrowing
	var addNarrowingToPercDi =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_percDi',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addNarrowingToPercDi);


	/// arricchimento di base per guigen::TextField [tfValore]
	var addBasicEnrichmentToTfValore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfValore',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfValore);
	/// arricchimento di base per guigen::TextField [tfCoFumi]
	var addBasicEnrichmentToTfCoFumi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCoFumi',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfCoFumi);
	/// arricchimento di base per guigen::TextField [tfNoOssigeno]
	var addBasicEnrichmentToTfNoOssigeno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoOssigeno',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfNoOssigeno);
	/// arricchimento di base per guigen::TextField [tfIndAria]
	var addBasicEnrichmentToTfIndAria =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndAria',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfIndAria);
	/// arricchimento di base per guigen::TextField [tfCoFumiSecchi]
	var addBasicEnrichmentToTfCoFumiSecchi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCoFumiSecchi',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfCoFumiSecchi);
	/// arricchimento di base per guigen::TextField [tfPotTermPers]
	var addBasicEnrichmentToTfPotTermPers =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotTermPers',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfPotTermPers);
	/// arricchimento di base per guigen::TextField [tfRecCalore]
	var addBasicEnrichmentToTfRecCalore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRecCalore',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfRecCalore);
	/// arricchimento di base per guigen::TextField [tfRecCombust]
	var addBasicEnrichmentToTfRecCombust =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRecCombust',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfRecCombust);
	/// arricchimento di base per guigen::TextField [tfNOxOss]
	var addBasicEnrichmentToTfNOxOss =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNOxOss',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp8Modulo", addBasicEnrichmentToTfNOxOss);
	/// arricchimento per guigen::ComboBox [cbFumosita]: autonarrowing
	var addNarrowingToCbFumosita =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFumosita',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp9", addNarrowingToCbFumosita);


	/// arricchimento di base per guigen::TextField [tf9Rend]
	var addBasicEnrichmentToTf9Rend =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tf9Rend',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp9", addBasicEnrichmentToTf9Rend);
	/// arricchimento per guigen::ComboBox [cbRenCombSuff]: autonarrowing
	var addNarrowingToCbRenCombSuff =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRenCombSuff',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp9", addNarrowingToCbRenCombSuff);


	/// arricchimento di base per guigen::TextField [tf9MinDi]
	var addBasicEnrichmentToTf9MinDi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tf9MinDi',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp9", addBasicEnrichmentToTf9MinDi);
	/// arricchimento per guigen::ComboBox [cbOssidiAzoto]: autonarrowing
	var addNarrowingToCbOssidiAzoto =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbOssidiAzoto',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wp9", addNarrowingToCbOssidiAzoto);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestRapProvaTipo1Dett(){
/*PROTECTED REGION ID(R1141621533) ENABLED START*/
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

function initUIStructCpGestRapProvaTipo1Dett(){
	var contentPanelName = "cpGestRapProvaTipo1Dett";
	var structure =
      {
        name: "p_fpGestRapProvaTipo1Dett", panels: [
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
              name: "p_stdMsgRapProvaDett", panels: [
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
            name: "p_wp8Modulo", panels: []
          }
,          {
            name: "p_wp9", panels: []
          }
,          {
            name: "p_cpFunGestRapProvaDett", panels: []
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

	initStdEnrichments4CpGestRapProvaTipo1Dett();
	initCustomEnrichments4CpGestRapProvaTipo1Dett();
	initUIStructCpGestRapProvaTipo1Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestRapProvaTipo1Dett");

});



