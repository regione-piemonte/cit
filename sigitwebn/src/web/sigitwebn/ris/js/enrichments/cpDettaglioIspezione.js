

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioIspezione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioIspezione() {
	var contentPanelName = "cpDettaglioIspezione";


	/// arricchimento per guigen::Calendar [calDataControllo]: aggiunta datepicker
	var addDateToCalDataControllo = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataControllo", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRapportoIspeImpianti", addDateToCalDataControllo);
	/// arricchimento di base per guigen::TextField [tfOra]
	var addBasicEnrichmentToTfOra =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfOra',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRapportoIspeImpianti", addBasicEnrichmentToTfOra);
	/// arricchimento per guigen::ComboBox [cbTipoAllegato]: autonarrowing
	var addNarrowingToCbTipoAllegato =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoAllegato',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRapportoIspeImpianti", addNarrowingToCbTipoAllegato);


	

	



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioIspezione(){
/*PROTECTED REGION ID(R-180255940) ENABLED START*/
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

function initUIStructCpDettaglioIspezione(){
	var contentPanelName = "cpDettaglioIspezione";
	var structure =
      {
        name: "p_fpDettaglioIspezione", panels: [
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
            name: "p_fpDettIspezione", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageDettIspezione", panels: [
            ]
          }
,          {
            name: "p_wpDettIspezione", panels: []
          }
,          {
            name: "p_wpDettIspezione2", panels: []
          }
,          {
            name: "p_wpElencoRappProva", panels: []
          }
,          {
            name: "p_cpFunzDettIspezione", panels: []
          }
,          {
            name: "p_cpNavDettIspezione", panels: []
          }
,          {
            name: "p_mpDatiAllegato", panels: [
            {
              name: "p_fpDatiRapporto", panels: [
              {
                name: "p_wpDatiRapportoIspeImpianti", panels: []
              }
,              {
                name: "p_cpFunDatiRapporto", panels: []
              }
,              {
                name: "p_cpNavDatiRapporto", panels: []
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

	initStdEnrichments4CpDettaglioIspezione();
	initCustomEnrichments4CpDettaglioIspezione();
	initUIStructCpDettaglioIspezione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioIspezione");

});



