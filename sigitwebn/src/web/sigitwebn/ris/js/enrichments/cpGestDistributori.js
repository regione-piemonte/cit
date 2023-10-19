

/**
 * Arricchimenti standard per il ContentPanel [cpGestDistributori] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestDistributori() {
	var contentPanelName = "cpGestDistributori";
	/// arricchimento per guigen::ComboBox [cbImpSiglaRea]: autonarrowing
	var addNarrowingToCbImpSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addNarrowingToCbImpSiglaRea);


	/// arricchimento di base per guigen::TextField [tfImpNumRea]
	var addBasicEnrichmentToTfImpNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfImpNumRea);
	/// arricchimento di base per guigen::TextField [tfInstCf]
	var addBasicEnrichmentToTfInstCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInstCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfInstCf);
	/// arricchimento di base per guigen::TextField [tfImpImpresa]
	var addBasicEnrichmentToTfImpImpresa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpImpresa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfImpImpresa);





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestDistributori(){
/*PROTECTED REGION ID(R-1668903184) ENABLED START*/
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

function initUIStructCpGestDistributori(){
	var contentPanelName = "cpGestDistributori";
	var structure =
      {
        name: "p_fpGestDistributoriG", panels: [
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
            name: "p_fpGestDistributoriTitolo", panels: [
            ]
          }
,          {
            name: "p_fpGestDistributori", panels: [
            {
              name: "p_stdMsgPGestDistr", panels: [
              ]
            }
,            {
              name: "p_wpImpresa", panels: []
            }
            ]
          }
,          {
            name: "p_mpInviati", panels: [
            {
              name: "p_fpInviati", panels: [
              {
                name: "p_wpInviati", panels: []
              }
,              {
                name: "p_cpFunInviati", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_mpImport", panels: [
            {
              name: "p_fpImport", panels: [
              {
                name: "p_wpImport", panels: []
              }
,              {
                name: "p_cpFunImport", panels: []
              }
,              {
                name: "p_cpNavImport", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_mpDettaglio", panels: [
            {
              name: "p_fpDettaglio", panels: [
              {
                name: "p_wpDettaglio", panels: []
              }
,              {
                name: "p_wpDettaglioErrori", panels: []
              }
,              {
                name: "p_cpNavErrori", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpNavGestDistributori", panels: []
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

	initStdEnrichments4CpGestDistributori();
	initCustomEnrichments4CpGestDistributori();
	initUIStructCpGestDistributori();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestDistributori");

});



