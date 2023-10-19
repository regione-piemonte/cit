

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioSanzione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioSanzione() {
	var contentPanelName = "cpDettaglioSanzione";

	/// arricchimento per guigen::Calendar [dtPagamentoFormPaga]: aggiunta datepicker
	var addDateToDtPagamentoFormPaga = function(){
		uiNRichLib.addDatePickerNRich("widg_dtPagamentoFormPaga", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPagamento", addDateToDtPagamentoFormPaga);

	/// arricchimento per guigen::ComboBox [cbComboValidatori]: autonarrowing
	var addNarrowingToCbComboValidatori =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComboValidatori',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAssegnaA", addNarrowingToCbComboValidatori);


	/// arricchimento per guigen::ComboBox [cbComboIspettori]: autonarrowing
	var addNarrowingToCbComboIspettori =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComboIspettori',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAssegnaA", addNarrowingToCbComboIspettori);





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioSanzione(){
/*PROTECTED REGION ID(R1287355799) ENABLED START*/
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

function initUIStructCpDettaglioSanzione(){
	var contentPanelName = "cpDettaglioSanzione";
	var structure =
      {
        name: "p_fpDettaglioSanzione", panels: [
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
            name: "p_fpTitle", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageDettaglioSanzione", panels: [
            ]
          }
,          {
            name: "p_wpDettaglioSanzione", panels: []
          }
,          {
            name: "p_wpAzioni", panels: []
          }
,          {
            name: "p_cpFunDettaglioSanzione", panels: []
          }
,          {
            name: "p_mpAzioniSanzione", panels: [
            {
              name: "p_fpPagamento", panels: [
              {
                name: "p_wpPagamento", panels: []
              }
,              {
                name: "p_cpPagamento", panels: []
              }
              ]
            }
,            {
              name: "p_fpAssegnaA", panels: [
              {
                name: "p_wpAssegnaA", panels: []
              }
,              {
                name: "p_cpAssegnaA", panels: []
              }
              ]
            }
,            {
              name: "p_fpAnnullamento", panels: [
              {
                name: "p_wpAnnullamento", panels: []
              }
,              {
                name: "p_cpConfEliminaSanzione", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpNavDettaglioSanzione", panels: []
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

	initStdEnrichments4CpDettaglioSanzione();
	initCustomEnrichments4CpDettaglioSanzione();
	initUIStructCpDettaglioSanzione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioSanzione");

});



