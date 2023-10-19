

/**
 * Arricchimenti standard per il ContentPanel [cpElencoIspezioniImpianti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoIspezioniImpianti() {
	var contentPanelName = "cpElencoIspezioniImpianti";


	/// arricchimento di base per guigen::TextField [tfCodFiscale]
	var addBasicEnrichmentToTfCodFiscale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodFiscale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiIspettore", addBasicEnrichmentToTfCodFiscale);
	/// arricchimento di base per guigen::TextField [tfNome]
	var addBasicEnrichmentToTfNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiIspettore", addBasicEnrichmentToTfNome);
	/// arricchimento di base per guigen::TextField [tfCognome]
	var addBasicEnrichmentToTfCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiIspettore", addBasicEnrichmentToTfCognome);
	/// arricchimento per guigen::Calendar [calDataIspezione]: aggiunta datepicker
	var addDateToCalDataIspezione = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataIspezione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiIspezioneImpianti", addDateToCalDataIspezione);
	/// arricchimento di base per guigen::TextField [tfEnteIsp]
	var addBasicEnrichmentToTfEnteIsp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEnteIsp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiIspezioneImpianti", addBasicEnrichmentToTfEnteIsp);
	/// arricchimento di base per guigen::TextField [tfNote]
	var addBasicEnrichmentToTfNote =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNote',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiIspezioneImpianti", addBasicEnrichmentToTfNote);


	/// arricchimento per guigen::Calendar [calDataControllo]: aggiunta datepicker
	var addDateToCalDataControllo = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataControllo", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRapportoIspeImpianti", addDateToCalDataControllo);
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
function initCustomEnrichments4CpElencoIspezioniImpianti(){
/*PROTECTED REGION ID(R1575261076) ENABLED START*/
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

function initUIStructCpElencoIspezioniImpianti(){
	var contentPanelName = "cpElencoIspezioniImpianti";
	var structure =
      {
        name: "p_fpElencoIspezioniImpianti", panels: [
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
            name: "p_fpElencoIspezioni", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageIspezioniImpianti", panels: [
            ]
          }
,          {
            name: "p_wpInfoIspezione", panels: []
          }
,          {
            name: "p_wpElencoIspezioniImpianto", panels: []
          }
,          {
            name: "p_cpFunzElencoIspezioniPerImpianto", panels: []
          }
,          {
            name: "p_cpNavElencoIspezioniPerImpianto", panels: []
          }
,          {
            name: "p_mpDatiIspezione", panels: [
            {
              name: "p_fpDatiIspezioneIn", panels: [
              {
                name: "p_fpDatiIspezione", panels: [
                {
                  name: "p_wpDatiIspettore", panels: []
                }
,                {
                  name: "p_wpDatiIspezioneImpianti", panels: []
                }
,                {
                  name: "p_cpFunDatiIspezione", panels: []
                }
,                {
                  name: "p_cpNavDatiIspezione", panels: []
                }
                ]
              }
              ]
            }
            ]
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

	initStdEnrichments4CpElencoIspezioniImpianti();
	initCustomEnrichments4CpElencoIspezioniImpianti();
	initUIStructCpElencoIspezioniImpianti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoIspezioniImpianti");

});



