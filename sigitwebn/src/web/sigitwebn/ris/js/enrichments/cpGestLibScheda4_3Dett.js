

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda4_3Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda4_3Dett() {
	var contentPanelName = "cpGestLibScheda4_3Dett";
	/// arricchimento per guigen::ComboBox [cbGruppoTermico]: autonarrowing
	var addNarrowingToCbGruppoTermico =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbGruppoTermico',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addNarrowingToCbGruppoTermico);


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
	/// arricchimento di base per guigen::TextField [tfPortataMax]
	var addBasicEnrichmentToTfPortataMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPortataMax',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpComponente", addBasicEnrichmentToTfPortataMax);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda4_3Dett(){
/*PROTECTED REGION ID(R-819260152) ENABLED START*/
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

function initUIStructCpGestLibScheda4_3Dett(){
	var contentPanelName = "cpGestLibScheda4_3Dett";
	var structure =
      {
        name: "p_fpGestLibScheda4_3Dett", panels: [
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

	initStdEnrichments4CpGestLibScheda4_3Dett();
	initCustomEnrichments4CpGestLibScheda4_3Dett();
	initUIStructCpGestLibScheda4_3Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda4_3Dett");

});



