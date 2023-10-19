

/**
 * Arricchimenti standard per il ContentPanel [cpGest3Resp] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGest3Resp() {
	var contentPanelName = "cpGest3Resp";
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
	/// arricchimento per guigen::Calendar [clDataInizio]: aggiunta datepicker
	var addDateToClDataInizio = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataInizio", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiContratto", addDateToClDataInizio);
	/// arricchimento per guigen::Calendar [clDataFine]: aggiunta datepicker
	var addDateToClDataFine = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataFine", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiContratto", addDateToClDataFine);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGest3Resp(){
/*PROTECTED REGION ID(R829839801) ENABLED START*/
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

function initUIStructCpGest3Resp(){
	var contentPanelName = "cpGest3Resp";
	var structure =
      {
        name: "p_fpGest3Resp", panels: [
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
            name: "p_fpGest3Responsabile", panels: [
            {
              name: "p_fpTitle", panels: [
              ]
            }
,            {
              name: "p_stdMsgPGest3Resp", panels: [
              ]
            }
,            {
              name: "p_wpImpResp", panels: []
            }
,            {
              name: "p_wpLocalizzazione", panels: []
            }
,            {
              name: "p_mpResponsabiliImp", panels: [
              {
                name: "p_fpRespImp2", panels: [
                {
                  name: "p_wpRespImpianto2", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_wpDatiContratto", panels: []
            }
,            {
              name: "p_cpFunGest3Resp", panels: []
            }
,            {
              name: "p_cpNavGest3Resp", panels: []
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

	initStdEnrichments4CpGest3Resp();
	initCustomEnrichments4CpGest3Resp();
	initUIStructCpGest3Resp();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGest3Resp");

});



