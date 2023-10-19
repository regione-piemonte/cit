

/**
 * Arricchimenti standard per il ContentPanel [cpElencoAbilitazioni] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoAbilitazioni() {
	var contentPanelName = "cpElencoAbilitazioni";
	/// arricchimento per guigen::ComboBox [cbElencoRuoli]: autonarrowing
	var addNarrowingToCbElencoRuoli =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoRuoli',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAbilitazioni", addNarrowingToCbElencoRuoli);


	/// arricchimento per guigen::ComboBox [cbElencoUtenti]: autonarrowing
	var addNarrowingToCbElencoUtenti =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoUtenti',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAbilitazioni", addNarrowingToCbElencoUtenti);


	/// arricchimento per guigen::ComboBox [cbElencoIstat]: autonarrowing
	var addNarrowingToCbElencoIstat =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoIstat',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAbilitazioni", addNarrowingToCbElencoIstat);




	/// arricchimento di base per guigen::TextField [tfNewMail]
	var addBasicEnrichmentToTfNewMail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNewMail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAggMail", addBasicEnrichmentToTfNewMail);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoAbilitazioni(){
/*PROTECTED REGION ID(R-1592778476) ENABLED START*/
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

function initUIStructCpElencoAbilitazioni(){
	var contentPanelName = "cpElencoAbilitazioni";
	var structure =
      {
        name: "p_fpElencoAbilitazioniG", panels: [
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
                name: "p_wpRicercaAbilitazioni", panels: []
              }
,              {
                name: "p_cpAbilitazioni", panels: []
              }
,              {
                name: "p_wpElencoAbilitazioni", panels: []
              }
,              {
                name: "p_cpGestAbilitazioni", panels: []
              }
,              {
                name: "p_mpAggMail", panels: [
                {
                  name: "p_fpAggMail", panels: [
                  {
                    name: "p_wpAggMail", panels: []
                  }
,                  {
                    name: "p_cpAggMail", panels: []
                  }
                  ]
                }
                ]
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

	initStdEnrichments4CpElencoAbilitazioni();
	initCustomEnrichments4CpElencoAbilitazioni();
	initUIStructCpElencoAbilitazioni();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoAbilitazioni");

});



