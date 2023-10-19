

/**
 * Arricchimenti standard per il ContentPanel [cpGestAbilitazione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestAbilitazione() {
	var contentPanelName = "cpGestAbilitazione";
	/// arricchimento per guigen::ComboBox [cbElencoRuoli]: autonarrowing
	var addNarrowingToCbElencoRuoli =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoRuoli',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestAbilitazione", addNarrowingToCbElencoRuoli);


	/// arricchimento di base per guigen::TextField [tfCfUtente]
	var addBasicEnrichmentToTfCfUtente =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfUtente',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestAbilitazione", addBasicEnrichmentToTfCfUtente);
	/// arricchimento per guigen::ComboBox [cbElencoUtenti]: autonarrowing
	var addNarrowingToCbElencoUtenti =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoUtenti',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestAbilitazione", addNarrowingToCbElencoUtenti);


	/// arricchimento per guigen::ComboBox [cbProvinciaAbilitazione]: autonarrowing
	var addNarrowingToCbProvinciaAbilitazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvinciaAbilitazione',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestAbilitazione", addNarrowingToCbProvinciaAbilitazione);


	/// arricchimento per guigen::ComboBox [cbComuneAbilitazione]: autonarrowing
	var addNarrowingToCbComuneAbilitazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComuneAbilitazione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestAbilitazione", addNarrowingToCbComuneAbilitazione);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestAbilitazione(){
/*PROTECTED REGION ID(R-1105958445) ENABLED START*/
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

function initUIStructCpGestAbilitazione(){
	var contentPanelName = "cpGestAbilitazione";
	var structure =
      {
        name: "p_fpGestAbilitazioneG", panels: [
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
            name: "p_udpExpMass", panels: [
            ]
          }
,          {
            name: "p_fpElencoAbil", panels: [
            {
              name: "p_stdMsgPHome", panels: [
              ]
            }
,            {
              name: "p_fpAbilitazioni", panels: [
              {
                name: "p_wpGestAbilitazione", panels: []
              }
,              {
                name: "p_cpAbilitazioni", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpElencoAbilBack", panels: []
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

	initStdEnrichments4CpGestAbilitazione();
	initCustomEnrichments4CpGestAbilitazione();
	initUIStructCpGestAbilitazione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestAbilitazione");

});



