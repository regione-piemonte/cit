

/**
 * Arricchimenti standard per il ContentPanel [cpGestVerifica] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestVerifica() {
	var contentPanelName = "cpGestVerifica";
	/// arricchimento per guigen::ComboBox [cbTipoVerifica]: autonarrowing
	var addNarrowingToCbTipoVerifica =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoVerifica',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addNarrowingToCbTipoVerifica);


	/// arricchimento di base per guigen::TextField [tfCodImp]
	var addBasicEnrichmentToTfCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodImp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addBasicEnrichmentToTfCodImp);
	/// arricchimento per guigen::ComboBox [cbSiglaBollino]: autonarrowing
	var addNarrowingToCbSiglaBollino =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaBollino',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addNarrowingToCbSiglaBollino);


	/// arricchimento di base per guigen::TextField [tfNumeroBollino]
	var addBasicEnrichmentToTfNumeroBollino =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroBollino',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addBasicEnrichmentToTfNumeroBollino);
	/// arricchimento di base per guigen::TextField [tfDatoDistributore]
	var addBasicEnrichmentToTfDatoDistributore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatoDistributore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addBasicEnrichmentToTfDatoDistributore);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestVerifica(){
/*PROTECTED REGION ID(R-268599595) ENABLED START*/
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

function initUIStructCpGestVerifica(){
	var contentPanelName = "cpGestVerifica";
	var structure =
      {
        name: "p_fpGestVerifica", panels: [
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
            name: "p_fpInserisciVerifica", panels: [
            {
              name: "p_fpTitle", panels: [
              ]
            }
,            {
              name: "p_stdMsg", panels: [
              ]
            }
,            {
              name: "p_wpHidden", panels: []
            }
,            {
              name: "p_wpVerifica", panels: []
            }
,            {
              name: "p_cpFun", panels: []
            }
,            {
              name: "p_cpNav", panels: []
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

	initStdEnrichments4CpGestVerifica();
	initCustomEnrichments4CpGestVerifica();
	initUIStructCpGestVerifica();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestVerifica");

});



