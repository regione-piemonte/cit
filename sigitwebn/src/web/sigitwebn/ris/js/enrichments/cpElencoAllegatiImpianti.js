

/**
 * Arricchimenti standard per il ContentPanel [cpElencoAllegatiImpianti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpElencoAllegatiImpianti() {
	var contentPanelName = "cpElencoAllegatiImpianti";



	/// arricchimento per guigen::Calendar [calDataControllo]: aggiunta datepicker
	var addDateToCalDataControllo = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataControllo", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAllegatoImpianti", addDateToCalDataControllo);
	/// arricchimento per guigen::ComboBox [cbTipoAllegato]: autonarrowing
	var addNarrowingToCbTipoAllegato =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoAllegato',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiAllegatoImpianti", addNarrowingToCbTipoAllegato);


	

	


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpElencoAllegatiImpianti(){
/*PROTECTED REGION ID(R-416667875) ENABLED START*/
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

function initUIStructCpElencoAllegatiImpianti(){
	var contentPanelName = "cpElencoAllegatiImpianti";
	var structure =
      {
        name: "p_fpElencoAllegatiImpianti", panels: [
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
            name: "p_wpElencoAllegatiImpianto", panels: []
          }
,          {
            name: "p_cpExportExcel", panels: []
          }
,          {
            name: "p_cpFunzElencoAllegatiPerImpianto", panels: []
          }
,          {
            name: "p_cpNavElencoAllegatiPerImpianto", panels: []
          }
,          {
            name: "p_mpDatiAllegato", panels: [
            {
              name: "p_fpDatiAllegato", panels: [
              {
                name: "p_wpDatiAllegatoImpianti", panels: []
              }
,              {
                name: "p_cpNavDatiAllegato", panels: []
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

	initStdEnrichments4CpElencoAllegatiImpianti();
	initCustomEnrichments4CpElencoAllegatiImpianti();
	initUIStructCpElencoAllegatiImpianti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpElencoAllegatiImpianti");

});



