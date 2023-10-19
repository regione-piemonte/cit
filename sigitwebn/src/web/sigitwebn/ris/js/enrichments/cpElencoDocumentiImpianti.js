

/**
 * Arricchimenti standard per il ContentPanel [cpElencoDocumentiImpianti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoDocumentiImpianti() {
	var contentPanelName = "cpElencoDocumentiImpianti";

	/// arricchimento per guigen::ComboBox [cbTipoDoc]: autonarrowing
	var addNarrowingToCbTipoDoc =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoDoc',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiDocumento", addNarrowingToCbTipoDoc);


	/// arricchimento di base per guigen::TextField [tfAltroDoc]
	var addBasicEnrichmentToTfAltroDoc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAltroDoc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiDocumento", addBasicEnrichmentToTfAltroDoc);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoDocumentiImpianti(){
/*PROTECTED REGION ID(R-280320986) ENABLED START*/
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

function initUIStructCpElencoDocumentiImpianti(){
	var contentPanelName = "cpElencoDocumentiImpianti";
	var structure =
      {
        name: "p_fpElencoDocumentiImpianti", panels: [
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
          name: "p_fpCenter", panels: [
          {
            name: "p_fpElencoAllegati", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageAllegatiImpianti", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_mpDatiIspezione", panels: [
            {
              name: "p_fpDatiIspezione", panels: [
              {
                name: "p_wpInfoIspezione", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_wpElencoDocumenti", panels: []
          }
,          {
            name: "p_cpFunzElencoDocumenti", panels: []
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
,          {
            name: "p_mpElencoLibrettiCons", panels: [
            {
              name: "p_fpElencoLibrettiConsolidato", panels: [
              {
                name: "p_wpArchivioLibrettiConsolidatiStorico", panels: []
              }
,              {
                name: "p_cpVisualizzaLibrettoCons", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_wpStoricoREE", panels: []
          }
,          {
            name: "p_cpFunzElencoAllegatiPerImpianto", panels: []
          }
,          {
            name: "p_cpNavElencoAllegatiPerImpianto", panels: []
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

	initStdEnrichments4CpElencoDocumentiImpianti();
	initCustomEnrichments4CpElencoDocumentiImpianti();
	initUIStructCpElencoDocumentiImpianti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoDocumentiImpianti");

});



