

/**
 * Arricchimenti standard per il ContentPanel [cpGestisciReeDocumenti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestisciReeDocumenti() {
	var contentPanelName = "cpGestisciReeDocumenti";


	/// arricchimento di base per guigen::TextField [tfDescDoc]
	var addBasicEnrichmentToTfDescDoc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescDoc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiDocumento", addBasicEnrichmentToTfDescDoc);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestisciReeDocumenti(){
/*PROTECTED REGION ID(R289741402) ENABLED START*/
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

function initUIStructCpGestisciReeDocumenti(){
	var contentPanelName = "cpGestisciReeDocumenti";
	var structure =
      {
        name: "p_fpElencoDocumentiRee", panels: [
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
            name: "p_fpElencoDocumenti", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageDocumenti", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpElencoDocumenti", panels: []
          }
,          {
            name: "p_cpFunzElencoDocumenti", panels: []
          }
,          {
            name: "p_cpNavElencoAllegatiPerImpianto", panels: []
          }
,          {
            name: "p_mpDatiDocumento", panels: [
            {
              name: "p_fpDatiDocumento", panels: [
              {
                name: "p_wpFileDocumento", panels: []
              }
,              {
                name: "p_wpDatiDocumento", panels: []
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

	initStdEnrichments4CpGestisciReeDocumenti();
	initCustomEnrichments4CpGestisciReeDocumenti();
	initUIStructCpGestisciReeDocumenti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestisciReeDocumenti");

});



