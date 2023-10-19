

/**
 * Arricchimenti standard per il ContentPanel [cpGestReeTipo1] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestReeTipo1() {
	var contentPanelName = "cpGestReeTipo1";
	/// arricchimento di base per guigen::TextField [tfPotenzaTermicaNomMax]
	var addBasicEnrichmentToTfPotenzaTermicaNomMax =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaTermicaNomMax',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpA", addBasicEnrichmentToTfPotenzaTermicaNomMax);

	/// arricchimento per guigen::Calendar [cIntEntro]: aggiunta datepicker
	var addDateToCIntEntro = function(){
		uiNRichLib.addDatePickerNRich("widg_cIntEntro", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpF", addDateToCIntEntro);
	/// arricchimento di base per guigen::TextField [tfOraArrivo]
	var addBasicEnrichmentToTfOraArrivo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOraArrivo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpF", addBasicEnrichmentToTfOraArrivo);
	/// arricchimento di base per guigen::TextField [tfOraPart]
	var addBasicEnrichmentToTfOraPart =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOraPart',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpF", addBasicEnrichmentToTfOraPart);
	/// arricchimento di base per guigen::TextField [tfTec]
	var addBasicEnrichmentToTfTec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTec',
			 	true,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpF", addBasicEnrichmentToTfTec);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestReeTipo1(){
/*PROTECTED REGION ID(R1037434201) ENABLED START*/
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

function initUIStructCpGestReeTipo1(){
	var contentPanelName = "cpGestReeTipo1";
	var structure =
      {
        name: "p_fpGestReeTipo1", panels: [
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
            name: "p_stdMsgRee", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpA", panels: []
          }
,          {
            name: "p_wpB", panels: []
          }
,          {
            name: "p_wpC", panels: []
          }
,          {
            name: "p_mpAcquaReintegro", panels: [
            {
              name: "p_fpAcquaReintegro", panels: [
              {
                name: "p_wpAcquaReintegro", panels: []
              }
,              {
                name: "p_cpAcquaReintegro", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_wpD", panels: []
          }
,          {
            name: "p_wpF", panels: []
          }
,          {
            name: "p_cpFunGestRee", panels: []
          }
,          {
            name: "p_cpNavGestRee", panels: []
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

	initStdEnrichments4CpGestReeTipo1();
	initCustomEnrichments4CpGestReeTipo1();
	initUIStructCpGestReeTipo1();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestReeTipo1");

});



