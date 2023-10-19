

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaVerifiche] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaVerifiche() {
	var contentPanelName = "cpRicercaVerifiche";
	/// arricchimento di base per guigen::TextField [tfIdentificativo]
	var addBasicEnrichmentToTfIdentificativo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIdentificativo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addBasicEnrichmentToTfIdentificativo);
	/// arricchimento per guigen::ComboBox [cbElencoValidatori]: autonarrowing
	var addNarrowingToCbElencoValidatori =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoValidatori',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addNarrowingToCbElencoValidatori);


	/// arricchimento per guigen::Calendar [cDataCreazioneDA]: aggiunta datepicker
	var addDateToCDataCreazioneDA = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataCreazioneDA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addDateToCDataCreazioneDA);
	/// arricchimento per guigen::Calendar [cDataCreazioneA]: aggiunta datepicker
	var addDateToCDataCreazioneA = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataCreazioneA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addDateToCDataCreazioneA);
	/// arricchimento per guigen::ComboBox [cbTipoVerifica]: autonarrowing
	var addNarrowingToCbTipoVerifica =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoVerifica',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addNarrowingToCbTipoVerifica);


	/// arricchimento di base per guigen::TextField [tfCodiceImpianto]
	var addBasicEnrichmentToTfCodiceImpianto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodiceImpianto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addBasicEnrichmentToTfCodiceImpianto);
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
	/// arricchimento di base per guigen::TextField [tfDatoDistrib]
	var addBasicEnrichmentToTfDatoDistrib =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDatoDistrib',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpVerifica", addBasicEnrichmentToTfDatoDistrib);


	/// arricchimento per guigen::ComboBox [cbTipoVerificaInserimentoIspezioniMassive]: autonarrowing
	var addNarrowingToCbTipoVerificaInserimentoIspezioniMassive =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoVerificaInserimentoIspezioniMassive',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInserimentoIspezioniMassive", addNarrowingToCbTipoVerificaInserimentoIspezioniMassive);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaVerifiche(){
/*PROTECTED REGION ID(R1870016239) ENABLED START*/
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

function initUIStructCpRicercaVerifiche(){
	var contentPanelName = "cpRicercaVerifiche";
	var structure =
      {
        name: "p_fpRicVerifiche", panels: [
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
          name: "p_fpVerifica", panels: [
          {
            name: "p_fpRicercaVerifiche", panels: [
            {
              name: "p_stdMsg", panels: [
              ]
            }
,            {
              name: "p_wpVerifica", panels: []
            }
,            {
              name: "p_cpFunRicVerifiche", panels: []
            }
,            {
              name: "p_cpNavRicVerifiche", panels: []
            }
,            {
              name: "p_mpInserimentoIspezioniMassive", panels: [
              {
                name: "p_fpInserimentoIspezioniMassive", panels: [
                {
                  name: "p_wpInserimentoIspezioniMassive", panels: []
                }
,                {
                  name: "p_cpNavInserimentoIspezioniMassive", panels: []
                }
                ]
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

	initStdEnrichments4CpRicercaVerifiche();
	initCustomEnrichments4CpRicercaVerifiche();
	initUIStructCpRicercaVerifiche();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaVerifiche");

});



