

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioAccertamentoConf] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioAccertamentoConf() {
	var contentPanelName = "cpDettaglioAccertamentoConf";
	/// arricchimento per guigen::ComboBox [cbTipoConclusione]: autonarrowing
	var addNarrowingToCbTipoConclusione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoConclusione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpConcludiAcc", addNarrowingToCbTipoConclusione);


	/// arricchimento di base per guigen::TextField [tfCodImp]
	var addBasicEnrichmentToTfCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodImp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpConcludiAcc", addBasicEnrichmentToTfCodImp);

	/// arricchimento per guigen::ComboBox [cbElencoValidatori]: autonarrowing
	var addNarrowingToCbElencoValidatori =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoValidatori',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAssociaAcc", addNarrowingToCbElencoValidatori);



	/// arricchimento di base per guigen::TextField [tfCercaCodiceImpianto]
	var addBasicEnrichmentToTfCercaCodiceImpianto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCercaCodiceImpianto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAssociaCodImp", addBasicEnrichmentToTfCercaCodiceImpianto);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioAccertamentoConf(){
/*PROTECTED REGION ID(R-1865430022) ENABLED START*/
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

function initUIStructCpDettaglioAccertamentoConf(){
	var contentPanelName = "cpDettaglioAccertamentoConf";
	var structure =
      {
        name: "p_fpDettaglioAccertamentoConf", panels: [
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
            name: "p_fpConfermaAccertamento", panels: [
            {
              name: "p_fpTitle", panels: [
              ]
            }
,            {
              name: "p_stdMsg", panels: [
              ]
            }
,            {
              name: "p_wpAccertamento", panels: []
            }
,            {
              name: "p_mpConcludiAcc", panels: [
              {
                name: "p_fpConcludiAcc", panels: [
                {
                  name: "p_wpConcludiAcc", panels: []
                }
,                {
                  name: "p_cpFun", panels: []
                }
                ]
              }
,              {
                name: "p_fpAssociaAcc", panels: [
                {
                  name: "p_wpAssociaAcc", panels: []
                }
,                {
                  name: "p_cpFunAssociaAcc", panels: []
                }
                ]
              }
,              {
                name: "p_fpAssociaCodImp", panels: [
                {
                  name: "p_wpAssociaCodImp", panels: []
                }
,                {
                  name: "p_cpFunAssociaCodImp", panels: []
                }
                ]
              }
              ]
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

	initStdEnrichments4CpDettaglioAccertamentoConf();
	initCustomEnrichments4CpDettaglioAccertamentoConf();
	initUIStructCpDettaglioAccertamentoConf();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioAccertamentoConf");

});



