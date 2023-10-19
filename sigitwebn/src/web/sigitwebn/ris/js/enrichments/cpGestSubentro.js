

/**
 * Arricchimenti standard per il ContentPanel [cpGestSubentro] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestSubentro() {
	var contentPanelName = "cpGestSubentro";
	/// arricchimento per guigen::ComboBox [cbImpSiglaRea]: autonarrowing
	var addNarrowingToCbImpSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpResp", addNarrowingToCbImpSiglaRea);


	/// arricchimento di base per guigen::TextField [tfImpNumRea]
	var addBasicEnrichmentToTfImpNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpResp", addBasicEnrichmentToTfImpNumRea);
	/// arricchimento di base per guigen::TextField [tfImpCf]
	var addBasicEnrichmentToTfImpCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpCf',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpResp", addBasicEnrichmentToTfImpCf);
	/// arricchimento di base per guigen::TextField [tfImpImpresa]
	var addBasicEnrichmentToTfImpImpresa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpImpresa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpResp", addBasicEnrichmentToTfImpImpresa);
	/// arricchimento per guigen::ComboBox [cbImpLocProvincia]: autonarrowing
	var addNarrowingToCbImpLocProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpLocProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addNarrowingToCbImpLocProvincia);


	/// arricchimento per guigen::ComboBox [cbImpLocComune]: autonarrowing
	var addNarrowingToCbImpLocComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpLocComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addNarrowingToCbImpLocComune);


	/// arricchimento di base per guigen::TextField [tfImpLocIndirizzo]
	var addBasicEnrichmentToTfImpLocIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocIndirizzo);
	/// arricchimento per guigen::ComboBox [cbImpLocIndirizzo]: autonarrowing
	var addNarrowingToCbImpLocIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpLocIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addNarrowingToCbImpLocIndirizzo);


	/// arricchimento di base per guigen::TextField [tfImpLocNoStrad]
	var addBasicEnrichmentToTfImpLocNoStrad =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocNoStrad',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocNoStrad);
	/// arricchimento di base per guigen::TextField [tfImpLocCivico]
	var addBasicEnrichmentToTfImpLocCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocCivico);
	/// arricchimento di base per guigen::TextField [tfImpCodImp]
	var addBasicEnrichmentToTfImpCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpCodImp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpCodImp);
	/// arricchimento per guigen::ComboBox [cbTipoSubentro]: autonarrowing
	var addNarrowingToCbTipoSubentro =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoSubentro',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTipoSubentro", addNarrowingToCbTipoSubentro);


	



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestSubentro(){
/*PROTECTED REGION ID(R-719041482) ENABLED START*/
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

function initUIStructCpGestSubentro(){
	var contentPanelName = "cpGestSubentro";
	var structure =
      {
        name: "p_fpGestSubentroG", panels: [
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
            name: "p_fpGestSubentro", panels: [
            {
              name: "p_fpTitle", panels: [
              ]
            }
,            {
              name: "p_stdMsgPGestSub", panels: [
              ]
            }
,            {
              name: "p_wpImpResp", panels: []
            }
,            {
              name: "p_wpLocalizzazione", panels: []
            }
,            {
              name: "p_mpTipoSubentro", panels: [
              {
                name: "p_fpTipoSubentro", panels: [
                {
                  name: "p_wpTipoSubentro", panels: []
                }
,                {
                  name: "p_cpFunGestSubentro", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavGestSubentro", panels: []
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

	initStdEnrichments4CpGestSubentro();
	initCustomEnrichments4CpGestSubentro();
	initUIStructCpGestSubentro();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestSubentro");

});



