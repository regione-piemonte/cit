

/**
 * Arricchimenti standard per il ContentPanel [cpInitRapProva] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpInitRapProva() {
	var contentPanelName = "cpInitRapProva";
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


	

	


	/// arricchimento per guigen::Calendar [calDataControlloMod]: aggiunta datepicker
	var addDateToCalDataControlloMod = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataControlloMod", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRapportoIspeImpiantiModifica", addDateToCalDataControlloMod);
	/// arricchimento per guigen::ComboBox [cbTipoAllegatoMod]: autonarrowing
	var addNarrowingToCbTipoAllegatoMod =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoAllegatoMod',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRapportoIspeImpiantiModifica", addNarrowingToCbTipoAllegatoMod);


	

	



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpInitRapProva(){
/*PROTECTED REGION ID(R2027382998) ENABLED START*/
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

function initUIStructCpInitRapProva(){
	var contentPanelName = "cpInitRapProva";
	var structure =
      {
        name: "p_fpInitRapProva", panels: [
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
            name: "p_fpGestRapProvaDatiGen", panels: [
            {
              name: "p_stdMsgRapProva", panels: [
              ]
            }
            ]
          }
,          {
            name: "p_fpDatiRapporto", panels: [
            {
              name: "p_mpGestioneAllegato", panels: [
              {
                name: "p_fpInserimento", panels: [
                {
                  name: "p_wpDatiRapportoIspeImpianti", panels: []
                }
,                {
                  name: "p_cpFunDatiRapporto", panels: []
                }
                ]
              }
,              {
                name: "p_fpModifica", panels: [
                {
                  name: "p_wpDatiRapportoIspeImpiantiModifica", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavDatiRapporto", panels: []
            }
,            {
              name: "p_mpUploadAllegato", panels: [
              {
                name: "p_fpUploadAllegato", panels: [
                {
                  name: "p_wpUploadAllegato", panels: []
                }
                ]
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpNavInitRapProva", panels: []
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

	initStdEnrichments4CpInitRapProva();
	initCustomEnrichments4CpInitRapProva();
	initUIStructCpInitRapProva();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpInitRapProva");

});



