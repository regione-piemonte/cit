

/**
 * Arricchimenti standard per il ContentPanel [cpGestDelega] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestDelega() {
	var contentPanelName = "cpGestDelega";
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

	/// arricchimento di base per guigen::TextField [tfDelCf]
	var addBasicEnrichmentToTfDelCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDelCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInsDelegato", addBasicEnrichmentToTfDelCf);
	/// arricchimento di base per guigen::TextField [tfDelCognome]
	var addBasicEnrichmentToTfDelCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDelCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInsDelegato", addBasicEnrichmentToTfDelCognome);
	/// arricchimento di base per guigen::TextField [tfDelNome]
	var addBasicEnrichmentToTfDelNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDelNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInsDelegato", addBasicEnrichmentToTfDelNome);
	/// arricchimento di base per guigen::TextField [tfDelDataDal]
	var addBasicEnrichmentToTfDelDataDal =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDelDataDal',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInsDelegato", addBasicEnrichmentToTfDelDataDal);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestDelega(){
/*PROTECTED REGION ID(R1338787362) ENABLED START*/
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

function initUIStructCpGestDelega(){
	var contentPanelName = "cpGestDelega";
	var structure =
      {
        name: "p_fpGestDelegaG", panels: [
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
            name: "p_fpGestDelegaTitolo", panels: [
            ]
          }
,          {
            name: "p_fpGestDelega", panels: [
            {
              name: "p_stdMsgPGestDel", panels: [
              ]
            }
,            {
              name: "p_wpImpresa", panels: []
            }
,            {
              name: "p_mpDelegati", panels: [
              {
                name: "p_fpDelegati", panels: [
                {
                  name: "p_wpDelegati", panels: []
                }
,                {
                  name: "p_cpFunDelegati", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpInsDelegato", panels: [
              {
                name: "p_fpInsDelegato", panels: [
                {
                  name: "p_wpInsDelegato", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpDelegatiPotenziali", panels: [
              {
                name: "p_fpDelegatiPotenziali", panels: [
                {
                  name: "p_wpDelegatiPotenziali", panels: []
                }
,                {
                  name: "p_cpFunDelegatiPotenziali", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavGestDelega", panels: []
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

	initStdEnrichments4CpGestDelega();
	initCustomEnrichments4CpGestDelega();
	initUIStructCpGestDelega();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestDelega");

});



