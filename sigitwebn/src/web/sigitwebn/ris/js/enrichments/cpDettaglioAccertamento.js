

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioAccertamento] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioAccertamento() {
	var contentPanelName = "cpDettaglioAccertamento";
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
function initCustomEnrichments4CpDettaglioAccertamento(){
/*PROTECTED REGION ID(R-1979196490) ENABLED START*/
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

function initUIStructCpDettaglioAccertamento(){
	var contentPanelName = "cpDettaglioAccertamento";
	var structure =
      {
        name: "p_fpDettaglioAccertamento", panels: [
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
            name: "p_fpDettaglioAccertamento2", panels: [
            ]
          }
,          {
            name: "p_stdMsg", panels: [
            ]
          }
,          {
            name: "p_wpAccertamento", panels: []
          }
,          {
            name: "p_cpSalva", panels: []
          }
,          {
            name: "p_wpIspezioni", panels: []
          }
,          {
            name: "p_cpFunzioniIsp", panels: []
          }
,          {
            name: "p_wpSanzioni", panels: []
          }
,          {
            name: "p_cpFunzioniSanz", panels: []
          }
,          {
            name: "p_wpAzioni", panels: []
          }
,          {
            name: "p_cpFunzioni", panels: []
          }
,          {
            name: "p_cpNav", panels: []
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

	initStdEnrichments4CpDettaglioAccertamento();
	initCustomEnrichments4CpDettaglioAccertamento();
	initUIStructCpDettaglioAccertamento();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioAccertamento");

});



