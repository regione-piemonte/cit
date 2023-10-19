

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda4_6Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda4_6Dett() {
	var contentPanelName = "cpGestLibScheda4_6Dett";
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
	/// arricchimento di base per guigen::TextField [tfTipologia]
	var addBasicEnrichmentToTfTipologia =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTipologia',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfTipologia);
	/// arricchimento per guigen::ComboBox [cbAlimentazione]: autonarrowing
	var addNarrowingToCbAlimentazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAlimentazione',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbAlimentazione);


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
	/// arricchimento di base per guigen::TextField [tfPotenzaElettrica]
	var addBasicEnrichmentToTfPotenzaElettrica =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaElettrica',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfPotenzaElettrica);
	/// arricchimento di base per guigen::TextField [tftemperaturaH2OUscitaMin]
	var addBasicEnrichmentToTftemperaturaH2OUscitaMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaH2OUscitaMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaH2OUscitaMin);
	/// arricchimento di base per guigen::TextField [tftemperaturaH2OUscitaMax]
	var addBasicEnrichmentToTftemperaturaH2OUscitaMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaH2OUscitaMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaH2OUscitaMax);
	/// arricchimento di base per guigen::TextField [tftemperaturaH2OIngressoMin]
	var addBasicEnrichmentToTftemperaturaH2OIngressoMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaH2OIngressoMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaH2OIngressoMin);
	/// arricchimento di base per guigen::TextField [tftemperaturaH2OIngressoMax]
	var addBasicEnrichmentToTftemperaturaH2OIngressoMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaH2OIngressoMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaH2OIngressoMax);
	/// arricchimento di base per guigen::TextField [tftemperaturaH2OMotoreMin]
	var addBasicEnrichmentToTftemperaturaH2OMotoreMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaH2OMotoreMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaH2OMotoreMin);
	/// arricchimento di base per guigen::TextField [tftemperaturaH2OMotoreMax]
	var addBasicEnrichmentToTftemperaturaH2OMotoreMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaH2OMotoreMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaH2OMotoreMax);
	/// arricchimento di base per guigen::TextField [tftemperaturaFumiValleMin]
	var addBasicEnrichmentToTftemperaturaFumiValleMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaFumiValleMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaFumiValleMin);
	/// arricchimento di base per guigen::TextField [tftemperaturaFumiValleMax]
	var addBasicEnrichmentToTftemperaturaFumiValleMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaFumiValleMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaFumiValleMax);
	/// arricchimento di base per guigen::TextField [tftemperaturaFumiMonteMin]
	var addBasicEnrichmentToTftemperaturaFumiMonteMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaFumiMonteMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaFumiMonteMin);
	/// arricchimento di base per guigen::TextField [tftemperaturaFumiMonteMax]
	var addBasicEnrichmentToTftemperaturaFumiMonteMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tftemperaturaFumiMonteMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTftemperaturaFumiMonteMax);
	/// arricchimento di base per guigen::TextField [tfcoMin]
	var addBasicEnrichmentToTfcoMin =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfcoMin',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToTfcoMin);
	/// arricchimento di base per guigen::TextField [coMax]
	var addBasicEnrichmentToCoMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_coMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente2", addBasicEnrichmentToCoMax);
	/// arricchimento di base per guigen::TextField [tfManutenzione]
	var addBasicEnrichmentToTfManutenzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfManutenzione',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente3", addBasicEnrichmentToTfManutenzione);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda4_6Dett(){
/*PROTECTED REGION ID(R-1379934005) ENABLED START*/
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

function initUIStructCpGestLibScheda4_6Dett(){
	var contentPanelName = "cpGestLibScheda4_6Dett";
	var structure =
      {
        name: "p_fpGestLibScheda4_6Dett", panels: [
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
            name: "p_wpComponenteIntestazione", panels: []
          }
,          {
            name: "p_wpComponente2", panels: []
          }
,          {
            name: "p_wpComponente3", panels: []
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

	initStdEnrichments4CpGestLibScheda4_6Dett();
	initCustomEnrichments4CpGestLibScheda4_6Dett();
	initUIStructCpGestLibScheda4_6Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda4_6Dett");

});



