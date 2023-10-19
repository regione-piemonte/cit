

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda15Dett] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda15Dett() {
	var contentPanelName = "cpGestLibScheda15Dett";
	/// arricchimento per guigen::Calendar [calDataManut]: aggiunta datepicker
	var addDateToCalDataManut = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataManut", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addDateToCalDataManut);
	/// arricchimento per guigen::ComboBox [cbTipoManut]: autonarrowing
	var addNarrowingToCbTipoManut =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoManut',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addNarrowingToCbTipoManut);


	

	/// arricchimento per guigen::ComboBox [cbTipoIntervento]: autonarrowing
	var addNarrowingToCbTipoIntervento =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoIntervento',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addNarrowingToCbTipoIntervento);


	/// arricchimento di base per guigen::TextField [tfAltro]
	var addBasicEnrichmentToTfAltro =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAltro',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addBasicEnrichmentToTfAltro);
	/// arricchimento di base per guigen::TextField [tfOraArrivo]
	var addBasicEnrichmentToTfOraArrivo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOraArrivo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addBasicEnrichmentToTfOraArrivo);
	/// arricchimento di base per guigen::TextField [tfOraPart]
	var addBasicEnrichmentToTfOraPart =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOraPart',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addBasicEnrichmentToTfOraPart);
	/// arricchimento di base per guigen::TextField [tfTec]
	var addBasicEnrichmentToTfTec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addBasicEnrichmentToTfTec);
	/// arricchimento per guigen::Calendar [cIntEntro]: aggiunta datepicker
	var addDateToCIntEntro = function(){
		uiNRichLib.addDatePickerNRich("widg_cIntEntro", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda15Dett", addDateToCIntEntro);



	/// arricchimento di base per guigen::TextField [tfDescDoc]
	var addBasicEnrichmentToTfDescDoc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescDoc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFileDocumento", addBasicEnrichmentToTfDescDoc);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda15Dett(){
/*PROTECTED REGION ID(R1859627754) ENABLED START*/
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

function initUIStructCpGestLibScheda15Dett(){
	var contentPanelName = "cpGestLibScheda15Dett";
	var structure =
      {
        name: "p_fpGestLibScheda15Dett", panels: [
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
            name: "p_fpScheda15", panels: [
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
            name: "p_wpScheda15Dett", panels: []
          }
,          {
            name: "p_cpFunGest", panels: []
          }
,          {
            name: "p_mpElencoDocumenti", panels: [
            {
              name: "p_fpElencoDocumenti", panels: [
              {
                name: "p_wpElencoDocumenti", panels: []
              }
,              {
                name: "p_cpFunzElencoDocumenti", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpNavGest", panels: []
          }
,          {
            name: "p_mpDatiDocumento", panels: [
            {
              name: "p_fpDatiDocumento", panels: [
              {
                name: "p_wpFileDocumento", panels: []
              }
,              {
                name: "p_cpNavDatiDocumento", panels: []
              }
              ]
            }
            ]
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

	initStdEnrichments4CpGestLibScheda15Dett();
	initCustomEnrichments4CpGestLibScheda15Dett();
	initUIStructCpGestLibScheda15Dett();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda15Dett");

});



