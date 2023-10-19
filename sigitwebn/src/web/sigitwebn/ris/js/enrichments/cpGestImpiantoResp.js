

/**
 * Arricchimenti standard per il ContentPanel [cpGestImpiantoResp] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestImpiantoResp() {
	var contentPanelName = "cpGestImpiantoResp";
	/// arricchimento di base per guigen::TextField [tfImpCodImp]
	var addBasicEnrichmentToTfImpCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpCodImp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCodImpianto", addBasicEnrichmentToTfImpCodImp);
	/// arricchimento per guigen::Calendar [cImpDataAss]: aggiunta datepicker
	var addDateToCImpDataAss = function(){
		uiNRichLib.addDatePickerNRich("widg_cImpDataAss", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCodImpianto", addDateToCImpDataAss);
	/// arricchimento per guigen::ComboBox [cbImpStatoImp]: autonarrowing
	var addNarrowingToCbImpStatoImp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpStatoImp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCodImpianto", addNarrowingToCbImpStatoImp);


	/// arricchimento per guigen::Calendar [cImpDataDismiss]: aggiunta datepicker
	var addDateToCImpDataDismiss = function(){
		uiNRichLib.addDatePickerNRich("widg_cImpDataDismiss", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCodImpianto", addDateToCImpDataDismiss);
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
	/// arricchimento di base per guigen::TextField [tfImpLocCap]
	var addBasicEnrichmentToTfImpLocCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocCap',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocCap);
	/// arricchimento di base per guigen::TextField [tfImpLocInterno]
	var addBasicEnrichmentToTfImpLocInterno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocInterno',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocInterno);
	/// arricchimento di base per guigen::TextField [tfImpLocScala]
	var addBasicEnrichmentToTfImpLocScala =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocScala',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocScala);
	/// arricchimento di base per guigen::TextField [tfImpLocPalazzo]
	var addBasicEnrichmentToTfImpLocPalazzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocPalazzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocPalazzo);
	/// arricchimento di base per guigen::TextField [tfImpLocSezione]
	var addBasicEnrichmentToTfImpLocSezione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocSezione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocSezione);
	/// arricchimento di base per guigen::TextField [tfImpLocFoglio]
	var addBasicEnrichmentToTfImpLocFoglio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocFoglio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocFoglio);
	/// arricchimento di base per guigen::TextField [tfImpLocParticella]
	var addBasicEnrichmentToTfImpLocParticella =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocParticella',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocParticella);
	/// arricchimento di base per guigen::TextField [tfImpLocSubalterno]
	var addBasicEnrichmentToTfImpLocSubalterno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocSubalterno',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocSubalterno);
	/// arricchimento di base per guigen::TextField [tfImpLocPod]
	var addBasicEnrichmentToTfImpLocPod =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocPod',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocPod);
	/// arricchimento di base per guigen::TextField [tfImpLocPdr]
	var addBasicEnrichmentToTfImpLocPdr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocPdr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocalizzazione", addBasicEnrichmentToTfImpLocPdr);
	/// arricchimento di base per guigen::TextField [tfImpLocProprietario]
	var addBasicEnrichmentToTfImpLocProprietario =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocProprietario',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpProprietario", addBasicEnrichmentToTfImpLocProprietario);
	/// arricchimento di base per guigen::TextField [tfImpLocPropDataInizio]
	var addBasicEnrichmentToTfImpLocPropDataInizio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocPropDataInizio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpProprietario", addBasicEnrichmentToTfImpLocPropDataInizio);
	/// arricchimento di base per guigen::TextField [tfImpLocPropIndirizzo]
	var addBasicEnrichmentToTfImpLocPropIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpLocPropIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpProprietario", addBasicEnrichmentToTfImpLocPropIndirizzo);
	/// arricchimento per guigen::Calendar [cImpDataCessazione]: aggiunta datepicker
	var addDateToCImpDataCessazione = function(){
		uiNRichLib.addDatePickerNRich("widg_cImpDataCessazione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpProprietario", addDateToCImpDataCessazione);

	/// arricchimento per guigen::ComboBox [cbRespTitolo]: autonarrowing
	var addNarrowingToCbRespTitolo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespTitolo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addNarrowingToCbRespTitolo);


	/// arricchimento per guigen::ComboBox [cbRespSiglaRea]: autonarrowing
	var addNarrowingToCbRespSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addNarrowingToCbRespSiglaRea);


	/// arricchimento di base per guigen::TextField [tfRespNumRea]
	var addBasicEnrichmentToTfRespNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespNumRea);
	/// arricchimento di base per guigen::TextField [tfRespCf]
	var addBasicEnrichmentToTfRespCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespCf);
	/// arricchimento di base per guigen::TextField [tfRespCognome]
	var addBasicEnrichmentToTfRespCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespCognome);
	/// arricchimento di base per guigen::TextField [tfRespNome]
	var addBasicEnrichmentToTfRespNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespNome);
	/// arricchimento per guigen::ComboBox [cbRespProvincia]: autonarrowing
	var addNarrowingToCbRespProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addNarrowingToCbRespProvincia);


	/// arricchimento per guigen::ComboBox [cbRespComune]: autonarrowing
	var addNarrowingToCbRespComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addNarrowingToCbRespComune);


	/// arricchimento di base per guigen::TextField [tfRespIndirizzo]
	var addBasicEnrichmentToTfRespIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespIndirizzo);
	/// arricchimento per guigen::ComboBox [cbRespIndirizzo]: autonarrowing
	var addNarrowingToCbRespIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRespIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addNarrowingToCbRespIndirizzo);


	/// arricchimento di base per guigen::TextField [tfIRespNoStrad]
	var addBasicEnrichmentToTfIRespNoStrad =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIRespNoStrad',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfIRespNoStrad);
	/// arricchimento di base per guigen::TextField [tfRespCivico]
	var addBasicEnrichmentToTfRespCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespCivico);
	/// arricchimento di base per guigen::TextField [tfRespCap]
	var addBasicEnrichmentToTfRespCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCap',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespCap);
	/// arricchimento di base per guigen::TextField [tfRespEstStato]
	var addBasicEnrichmentToTfRespEstStato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstStato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespEstStato);
	/// arricchimento di base per guigen::TextField [tfRespEstCitta]
	var addBasicEnrichmentToTfRespEstCitta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstCitta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespEstCitta);
	/// arricchimento di base per guigen::TextField [tfRespEstIndirizzo]
	var addBasicEnrichmentToTfRespEstIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespEstIndirizzo);
	/// arricchimento di base per guigen::TextField [tfRespEstCivico]
	var addBasicEnrichmentToTfRespEstCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespEstCivico);
	/// arricchimento di base per guigen::TextField [tfRespEstCap]
	var addBasicEnrichmentToTfRespEstCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEstCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespEstCap);
	/// arricchimento per guigen::Calendar [cRespDataInizioResp]: aggiunta datepicker
	var addDateToCRespDataInizioResp = function(){
		uiNRichLib.addDatePickerNRich("widg_cRespDataInizioResp", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addDateToCRespDataInizioResp);
	/// arricchimento di base per guigen::TextField [tfRespEmail]
	var addBasicEnrichmentToTfRespEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpResponsabile", addBasicEnrichmentToTfRespEmail);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestImpiantoResp(){
/*PROTECTED REGION ID(R-1741013181) ENABLED START*/
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

function initUIStructCpGestImpiantoResp(){
	var contentPanelName = "cpGestImpiantoResp";
	var structure =
      {
        name: "p_fpGestImpiantoRespG", panels: [
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
            name: "p_fpGestImpiantoRespTitolo", panels: [
            ]
          }
,          {
            name: "p_fpGestImpiantoResp", panels: [
            {
              name: "p_stdMsgPGestRespImp", panels: [
              ]
            }
,            {
              name: "p_wpCodImpianto", panels: []
            }
,            {
              name: "p_wpLocalizzazione", panels: []
            }
,            {
              name: "p_wpProprietario", panels: []
            }
,            {
              name: "p_cpFunProprietario", panels: []
            }
,            {
              name: "p_wpResponsabile", panels: []
            }
,            {
              name: "p_cpFunGestImpiantoResp", panels: []
            }
,            {
              name: "p_cpFunLibretto", panels: []
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

	initStdEnrichments4CpGestImpiantoResp();
	initCustomEnrichments4CpGestImpiantoResp();
	initUIStructCpGestImpiantoResp();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestImpiantoResp");

});



