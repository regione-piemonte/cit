

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaAccertamenti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaAccertamenti() {
	var contentPanelName = "cpRicercaAccertamenti";
	/// arricchimento di base per guigen::TextField [tfIdentificativo]
	var addBasicEnrichmentToTfIdentificativo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIdentificativo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addBasicEnrichmentToTfIdentificativo);
	/// arricchimento per guigen::ComboBox [cbElencoValidatori]: autonarrowing
	var addNarrowingToCbElencoValidatori =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoValidatori',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addNarrowingToCbElencoValidatori);


	/// arricchimento per guigen::Calendar [cDataCreazioneDA]: aggiunta datepicker
	var addDateToCDataCreazioneDA = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataCreazioneDA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addDateToCDataCreazioneDA);
	/// arricchimento per guigen::Calendar [cDataCreazioneA]: aggiunta datepicker
	var addDateToCDataCreazioneA = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataCreazioneA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addDateToCDataCreazioneA);
	/// arricchimento per guigen::Calendar [cDataConclusioneDA]: aggiunta datepicker
	var addDateToCDataConclusioneDA = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataConclusioneDA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addDateToCDataConclusioneDA);
	/// arricchimento per guigen::Calendar [cDataConclusioneA]: aggiunta datepicker
	var addDateToCDataConclusioneA = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataConclusioneA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addDateToCDataConclusioneA);
	/// arricchimento per guigen::ComboBox [cbStatoAccertamento]: autonarrowing
	var addNarrowingToCbStatoAccertamento =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatoAccertamento',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addNarrowingToCbStatoAccertamento);


	/// arricchimento per guigen::ComboBox [cbTipoAnomalia]: autonarrowing
	var addNarrowingToCbTipoAnomalia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoAnomalia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addNarrowingToCbTipoAnomalia);


	/// arricchimento per guigen::ComboBox [cbTipoConclusione]: autonarrowing
	var addNarrowingToCbTipoConclusione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoConclusione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addNarrowingToCbTipoConclusione);


	/// arricchimento di base per guigen::TextField [tfCodiceImpianto]
	var addBasicEnrichmentToTfCodiceImpianto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodiceImpianto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccertamento", addBasicEnrichmentToTfCodiceImpianto);
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




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaAccertamenti(){
/*PROTECTED REGION ID(R340566844) ENABLED START*/
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

function initUIStructCpRicercaAccertamenti(){
	var contentPanelName = "cpRicercaAccertamenti";
	var structure =
      {
        name: "p_fpRicAccertamenti", panels: [
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
          name: "p_fpAccertamenti", panels: [
          {
            name: "p_fpRicercaAccertamenti", panels: [
            {
              name: "p_stdMsg", panels: [
              ]
            }
,            {
              name: "p_wpAccertamento", panels: []
            }
,            {
              name: "p_cpFunRicVerifiche", panels: []
            }
,            {
              name: "p_cpNavRicVerifiche", panels: []
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

	initStdEnrichments4CpRicercaAccertamenti();
	initCustomEnrichments4CpRicercaAccertamenti();
	initUIStructCpRicercaAccertamenti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaAccertamenti");

});



