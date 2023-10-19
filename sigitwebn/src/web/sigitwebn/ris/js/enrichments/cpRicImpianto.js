

/**
 * Arricchimenti standard per il ContentPanel [cpRicImpianto] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicImpianto() {
	var contentPanelName = "cpRicImpianto";
	/// arricchimento per guigen::ComboBox [cbStatiImpianto]: autonarrowing
	var addNarrowingToCbStatiImpianto =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatiImpianto',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbStatiImpianto);


	/// arricchimento di base per guigen::TextField [tfCodImp]
	var addBasicEnrichmentToTfCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodImp',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfCodImp);
	/// arricchimento per guigen::ComboBox [cbProvincia]: autonarrowing
	var addNarrowingToCbProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvincia',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbProvincia);


	/// arricchimento per guigen::ComboBox [cbComune]: autonarrowing
	var addNarrowingToCbComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbComune);


	/// arricchimento di base per guigen::TextField [tfDescComune]
	var addBasicEnrichmentToTfDescComune =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescComune',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfDescComune);
	/// arricchimento di base per guigen::TextField [tfIndirizzo]
	var addBasicEnrichmentToTfIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfIndirizzo);
	/// arricchimento di base per guigen::TextField [tfCivico]
	var addBasicEnrichmentToTfCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfCivico);
	/// arricchimento di base per guigen::TextField [tfCfResponsabile]
	var addBasicEnrichmentToTfCfResponsabile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfResponsabile',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfCfResponsabile);
	/// arricchimento di base per guigen::TextField [tfCfProprietario]
	var addBasicEnrichmentToTfCfProprietario =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfProprietario',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfCfProprietario);
	/// arricchimento di base per guigen::TextField [tfCf3Responsabile]
	var addBasicEnrichmentToTfCf3Responsabile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCf3Responsabile',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfCf3Responsabile);
	/// arricchimento di base per guigen::TextField [tfMatricola]
	var addBasicEnrichmentToTfMatricola =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMatricola',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfMatricola);
	/// arricchimento di base per guigen::TextField [tfPod]
	var addBasicEnrichmentToTfPod =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPod',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPod);
	/// arricchimento di base per guigen::TextField [tfPdr]
	var addBasicEnrichmentToTfPdr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPdr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPdr);

	/// arricchimento per guigen::ComboBox [cbSiglaRea]: autonarrowing
	var addNarrowingToCbSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addNarrowingToCbSiglaRea);


	/// arricchimento di base per guigen::TextField [tfNumeroRea]
	var addBasicEnrichmentToTfNumeroRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfNumeroRea);
	/// arricchimento di base per guigen::TextField [tfCfImpresa]
	var addBasicEnrichmentToTfCfImpresa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfImpresa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfCfImpresa);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicImpianto(){
/*PROTECTED REGION ID(R1519816102) ENABLED START*/
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

function initUIStructCpRicImpianto(){
	var contentPanelName = "cpRicImpianto";
	var structure =
      {
        name: "p_fpRicImpiantoG", panels: [
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
            name: "p_fpRicImpianto", panels: [
            {
              name: "p_stdMsgPRicImp", panels: [
              ]
            }
,            {
              name: "p_wpImpianto", panels: []
            }
,            {
              name: "p_cpNavRicCompImpianto", panels: []
            }
,            {
              name: "p_wpImpresa", panels: []
            }
,            {
              name: "p_cpFunRicImpianto", panels: []
            }
,            {
              name: "p_cpNavRicImpianto", panels: []
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

	initStdEnrichments4CpRicImpianto();
	initCustomEnrichments4CpRicImpianto();
	initUIStructCpRicImpianto();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicImpianto");

});



