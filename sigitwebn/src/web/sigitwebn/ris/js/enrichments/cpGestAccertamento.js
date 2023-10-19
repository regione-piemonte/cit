

/**
 * Arricchimenti standard per il ContentPanel [cpGestAccertamento] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestAccertamento() {
	var contentPanelName = "cpGestAccertamento";
	/// arricchimento per guigen::ComboBox [cbProvComp]: autonarrowing
	var addNarrowingToCbProvComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvComp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addNarrowingToCbProvComp);


	/// arricchimento per guigen::ComboBox [cbComComp]: autonarrowing
	var addNarrowingToCbComComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComComp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addNarrowingToCbComComp);


	/// arricchimento per guigen::ComboBox [cbTipoAnomalia]: autonarrowing
	var addNarrowingToCbTipoAnomalia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoAnomalia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addNarrowingToCbTipoAnomalia);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestAccertamento(){
/*PROTECTED REGION ID(R1294518372) ENABLED START*/
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

function initUIStructCpGestAccertamento(){
	var contentPanelName = "cpGestAccertamento";
	var structure =
      {
        name: "p_fpGestAccertamento", panels: [
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
            name: "p_fpInserisciAccertamento", panels: [
            {
              name: "p_stdMsg", panels: [
              ]
            }
,            {
              name: "p_wpAccertamento", panels: []
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

	initStdEnrichments4CpGestAccertamento();
	initCustomEnrichments4CpGestAccertamento();
	initUIStructCpGestAccertamento();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestAccertamento");

});



