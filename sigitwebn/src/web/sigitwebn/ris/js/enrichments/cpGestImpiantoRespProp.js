

/**
 * Arricchimenti standard per il ContentPanel [cpGestImpiantoRespProp] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestImpiantoRespProp() {
	var contentPanelName = "cpGestImpiantoRespProp";
	/// arricchimento per guigen::ComboBox [cbRespTitolo]: autonarrowing
	var addNarrowingToCbRespTitolo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespTitolo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addNarrowingToCbRespTitolo);


	/// arricchimento per guigen::ComboBox [cbRespSiglaRea]: autonarrowing
	var addNarrowingToCbRespSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addNarrowingToCbRespSiglaRea);


	/// arricchimento di base per guigen::TextField [tfRespNumRea]
	var addBasicEnrichmentToTfRespNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespNumRea);
	/// arricchimento di base per guigen::TextField [tfRespCf]
	var addBasicEnrichmentToTfRespCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespCf);
	/// arricchimento di base per guigen::TextField [tfRespCognome]
	var addBasicEnrichmentToTfRespCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespCognome);
	/// arricchimento di base per guigen::TextField [tfRespNome]
	var addBasicEnrichmentToTfRespNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespNome);
	/// arricchimento per guigen::ComboBox [cbRespProvincia]: autonarrowing
	var addNarrowingToCbRespProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addNarrowingToCbRespProvincia);


	/// arricchimento per guigen::ComboBox [cbRespComune]: autonarrowing
	var addNarrowingToCbRespComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addNarrowingToCbRespComune);


	/// arricchimento di base per guigen::TextField [tfRespIndirizzo]
	var addBasicEnrichmentToTfRespIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespIndirizzo);
	/// arricchimento per guigen::ComboBox [cbRespIndirizzo]: autonarrowing
	var addNarrowingToCbRespIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addNarrowingToCbRespIndirizzo);


	/// arricchimento di base per guigen::TextField [tfIRespNoStrad]
	var addBasicEnrichmentToTfIRespNoStrad =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIRespNoStrad',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfIRespNoStrad);
	/// arricchimento di base per guigen::TextField [tfRespCivico]
	var addBasicEnrichmentToTfRespCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespCivico);
	/// arricchimento di base per guigen::TextField [tfRespCap]
	var addBasicEnrichmentToTfRespCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespCap);
	/// arricchimento di base per guigen::TextField [tfRespEstStato]
	var addBasicEnrichmentToTfRespEstStato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstStato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespEstStato);
	/// arricchimento di base per guigen::TextField [tfRespEstCitta]
	var addBasicEnrichmentToTfRespEstCitta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstCitta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespEstCitta);
	/// arricchimento di base per guigen::TextField [tfRespEstIndirizzo]
	var addBasicEnrichmentToTfRespEstIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespEstIndirizzo);
	/// arricchimento di base per guigen::TextField [tfRespEstCivico]
	var addBasicEnrichmentToTfRespEstCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespEstCivico);
	/// arricchimento di base per guigen::TextField [tfRespEstCap]
	var addBasicEnrichmentToTfRespEstCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespEstCap);
	/// arricchimento per guigen::Calendar [cRespDataInizioResp]: aggiunta datepicker
	var addDateToCRespDataInizioResp = function(){
		uiNRichLib.addDatePickerNRich("widg_cRespDataInizioResp", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addDateToCRespDataInizioResp);
	/// arricchimento per guigen::Calendar [cRespDataFineResp]: aggiunta datepicker
	var addDateToCRespDataFineResp = function(){
		uiNRichLib.addDatePickerNRich("widg_cRespDataFineResp", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addDateToCRespDataFineResp);
	/// arricchimento di base per guigen::TextField [tfRespEmail]
	var addBasicEnrichmentToTfRespEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespEmail);
	/// arricchimento di base per guigen::TextField [tfRespPec]
	var addBasicEnrichmentToTfRespPec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespPec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespPec);
	/// arricchimento di base per guigen::TextField [tfRespTelefono]
	var addBasicEnrichmentToTfRespTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRespProp", addBasicEnrichmentToTfRespTelefono);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestImpiantoRespProp(){
/*PROTECTED REGION ID(R-1682267258) ENABLED START*/
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

function initUIStructCpGestImpiantoRespProp(){
	var contentPanelName = "cpGestImpiantoRespProp";
	var structure =
      {
        name: "p_fpGestImpiantoRespPropG", panels: [
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
            name: "p_mpRespProp", panels: [
            {
              name: "p_fpGestImpiantoResponsabileTitolo", panels: [
              ]
            }
,            {
              name: "p_fpGestImpiantoProprietarioTitolo", panels: [
              ]
            }
            ]
          }
,          {
            name: "p_fpGestImpianto", panels: [
            {
              name: "p_stdMsgPGestImp", panels: [
              ]
            }
,            {
              name: "p_mpResponsabile", panels: [
              {
                name: "p_fpRespProp", panels: [
                {
                  name: "p_wpRespProp", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpresponsabiliTrovatiTemp", panels: [
              {
                name: "p_FunResponsabiliTemp", panels: [
                {
                  name: "p_wpResponsabiliTrovatiTemp", panels: []
                }
,                {
                  name: "p_cpFunResponsabiliTemp", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavImpianto", panels: []
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

	initStdEnrichments4CpGestImpiantoRespProp();
	initCustomEnrichments4CpGestImpiantoRespProp();
	initUIStructCpGestImpiantoRespProp();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestImpiantoRespProp");

});



