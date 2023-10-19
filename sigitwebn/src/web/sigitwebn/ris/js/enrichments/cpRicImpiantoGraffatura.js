

/**
 * Arricchimenti standard per il ContentPanel [cpRicImpiantoGraffatura] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicImpiantoGraffatura() {
	var contentPanelName = "cpRicImpiantoGraffatura";
	/// arricchimento per guigen::ComboBox [cbStatiImpianto]: autonarrowing
	var addNarrowingToCbStatiImpianto =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatiImpianto',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addNarrowingToCbStatiImpianto);


	/// arricchimento di base per guigen::TextField [tfCodImp]
	var addBasicEnrichmentToTfCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodImp',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addBasicEnrichmentToTfCodImp);
	/// arricchimento per guigen::ComboBox [cbProvincia]: autonarrowing
	var addNarrowingToCbProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvincia',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addNarrowingToCbProvincia);


	/// arricchimento per guigen::ComboBox [cbComune]: autonarrowing
	var addNarrowingToCbComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addNarrowingToCbComune);


	/// arricchimento di base per guigen::TextField [tfDescComune]
	var addBasicEnrichmentToTfDescComune =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescComune',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addBasicEnrichmentToTfDescComune);
	/// arricchimento di base per guigen::TextField [tfIndirizzo]
	var addBasicEnrichmentToTfIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addBasicEnrichmentToTfIndirizzo);
	/// arricchimento di base per guigen::TextField [tfCfResponsabile]
	var addBasicEnrichmentToTfCfResponsabile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfResponsabile',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addBasicEnrichmentToTfCfResponsabile);
	/// arricchimento di base per guigen::TextField [tfCfProprietario]
	var addBasicEnrichmentToTfCfProprietario =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfProprietario',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addBasicEnrichmentToTfCfProprietario);
	/// arricchimento di base per guigen::TextField [tfCf3Responsabile]
	var addBasicEnrichmentToTfCf3Responsabile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCf3Responsabile',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpiantoGraffatura", addBasicEnrichmentToTfCf3Responsabile);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicImpiantoGraffatura(){
/*PROTECTED REGION ID(R1214818817) ENABLED START*/
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

function initUIStructCpRicImpiantoGraffatura(){
	var contentPanelName = "cpRicImpiantoGraffatura";
	var structure =
      {
        name: "p_fpRicImpiantoGGraffatura", panels: [
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
            name: "p_fpRicImpiantoGraffatura", panels: [
            {
              name: "p_stdMsgPRicImp", panels: [
              ]
            }
,            {
              name: "p_wpImpiantoGraffatura", panels: []
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

	initStdEnrichments4CpRicImpiantoGraffatura();
	initCustomEnrichments4CpRicImpiantoGraffatura();
	initUIStructCpRicImpiantoGraffatura();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicImpiantoGraffatura");

});



