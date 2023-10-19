

/**
 * Arricchimenti standard per il ContentPanel [cpGestIncarico] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestIncarico() {
	var contentPanelName = "cpGestIncarico";
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

	/// arricchimento per guigen::ComboBox [cbIncCat]: autonarrowing
	var addNarrowingToCbIncCat =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbIncCat',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInsIncarico", addNarrowingToCbIncCat);


	/// arricchimento di base per guigen::TextField [tfDelDataDal]
	var addBasicEnrichmentToTfDelDataDal =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDelDataDal',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInsIncarico", addBasicEnrichmentToTfDelDataDal);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestIncarico(){
/*PROTECTED REGION ID(R-174527948) ENABLED START*/
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

function initUIStructCpGestIncarico(){
	var contentPanelName = "cpGestIncarico";
	var structure =
      {
        name: "p_fpGestIncaricoG", panels: [
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
            name: "p_fpGestIncaricoTitolo", panels: [
            ]
          }
,          {
            name: "p_fpGestIncarico", panels: [
            {
              name: "p_stdMsgPGestInc", panels: [
              ]
            }
,            {
              name: "p_wpImpresa", panels: []
            }
,            {
              name: "p_mpIncaricati", panels: [
              {
                name: "p_fpIncaricati", panels: [
                {
                  name: "p_wpIncaricati", panels: []
                }
,                {
                  name: "p_cpFunDelegati", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpInsIncarico", panels: [
              {
                name: "p_fpInsIncarico", panels: [
                {
                  name: "p_wpInsIncarico", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavGestIncarico", panels: []
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

	initStdEnrichments4CpGestIncarico();
	initCustomEnrichments4CpGestIncarico();
	initUIStructCpGestIncarico();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestIncarico");

});



