

/**
 * Arricchimenti standard per il ContentPanel [cpGestSubentroMassivo] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestSubentroMassivo() {
	var contentPanelName = "cpGestSubentroMassivo";
	/// arricchimento per guigen::ComboBox [cbImpAttSiglaRea]: autonarrowing
	var addNarrowingToCbImpAttSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpAttSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpAtt", addNarrowingToCbImpAttSiglaRea);


	/// arricchimento di base per guigen::TextField [tfImpAttNumRea]
	var addBasicEnrichmentToTfImpAttNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpAttNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpAtt", addBasicEnrichmentToTfImpAttNumRea);
	/// arricchimento di base per guigen::TextField [tfImpAttCf]
	var addBasicEnrichmentToTfImpAttCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpAttCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpAtt", addBasicEnrichmentToTfImpAttCf);
	/// arricchimento per guigen::ComboBox [cbImpreseAttuali]: autonarrowing
	var addNarrowingToCbImpreseAttuali =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpreseAttuali',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpAtt", addNarrowingToCbImpreseAttuali);


	/// arricchimento per guigen::ComboBox [cbImpSubSiglaRea]: autonarrowing
	var addNarrowingToCbImpSubSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpSubSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpSub", addNarrowingToCbImpSubSiglaRea);


	/// arricchimento di base per guigen::TextField [tfImpSubNumRea]
	var addBasicEnrichmentToTfImpSubNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpSubNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpSub", addBasicEnrichmentToTfImpSubNumRea);
	/// arricchimento di base per guigen::TextField [tfImpSubCf]
	var addBasicEnrichmentToTfImpSubCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpSubCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpSub", addBasicEnrichmentToTfImpSubCf);
	/// arricchimento per guigen::ComboBox [cbImpreseSubentro]: autonarrowing
	var addNarrowingToCbImpreseSubentro =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpreseSubentro',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestSubImpSub", addNarrowingToCbImpreseSubentro);


	/// arricchimento per guigen::ComboBox [cbTipoSubentro]: autonarrowing
	var addNarrowingToCbTipoSubentro =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoSubentro',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpGestTipoSub", addNarrowingToCbTipoSubentro);




}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestSubentroMassivo(){
/*PROTECTED REGION ID(R-264424100) ENABLED START*/
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

function initUIStructCpGestSubentroMassivo(){
	var contentPanelName = "cpGestSubentroMassivo";
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
            name: "p_udpSubMass", panels: [
            ]
          }
,          {
            name: "p_fpSubentroMass", panels: [
            {
              name: "p_stdMsgPHome", panels: [
              ]
            }
,            {
              name: "p_fpAbilitazioni", panels: [
              {
                name: "p_wpGestSubImpAtt", panels: []
              }
,              {
                name: "p_wpGestSubImpSub", panels: []
              }
,              {
                name: "p_wpGestTipoSub", panels: []
              }
,              {
                name: "p_cpSibentro", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpElencoAbilBack", panels: []
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

	initStdEnrichments4CpGestSubentroMassivo();
	initCustomEnrichments4CpGestSubentroMassivo();
	initUIStructCpGestSubentroMassivo();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestSubentroMassivo");

});



