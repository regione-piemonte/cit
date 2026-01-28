

/**
 * Arricchimenti standard per il ContentPanel [cpGestImpianto] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestImpianto() {
	var contentPanelName = "cpGestImpianto";
	/// arricchimento per guigen::ComboBox [cbInstSiglaRea]: autonarrowing
	var addNarrowingToCbInstSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbInstSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInstallatore", addNarrowingToCbInstSiglaRea);


	/// arricchimento di base per guigen::TextField [tfInstNumRea]
	var addBasicEnrichmentToTfInstNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInstNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInstallatore", addBasicEnrichmentToTfInstNumRea);
	/// arricchimento di base per guigen::TextField [tfInstCf]
	var addBasicEnrichmentToTfInstCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInstCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInstallatore", addBasicEnrichmentToTfInstCf);
	/// arricchimento di base per guigen::TextField [tfInstImpresa]
	var addBasicEnrichmentToTfInstImpresa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfInstImpresa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInstallatore", addBasicEnrichmentToTfInstImpresa);
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
			 	'java.lang.String',
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





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestImpianto(){
/*PROTECTED REGION ID(R1088703443) ENABLED START*/
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

function initUIStructCpGestImpianto(){
	var contentPanelName = "cpGestImpianto";
	var structure =
      {
        name: "p_fpGestImpiantoG", panels: [
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
            name: "p_fpGestImpiantoTitolo", panels: [
            ]
          }
,          {
            name: "p_fpGestImpianto", panels: [
            {
              name: "p_stdMsgPGestImp", panels: [
              ]
            }
,            {
              name: "p_mpInstallatoreOLD", panels: [
              {
                name: "p_fpInstallatore", panels: [
                {
                  name: "p_wpInstallatore", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_wpManutentori", panels: []
            }
,            {
              name: "p_wpCodImpianto", panels: []
            }
,            {
              name: "p_wpLocalizzazione", panels: []
            }
,            {
              name: "p_cpFunGestImpianto", panels: []
            }
,            {
              name: "p_wpProprietario", panels: []
            }
,            {
              name: "p_cpFunProprietario", panels: []
            }
,            {
              name: "p_wpResponsabili", panels: []
            }
,            {
              name: "p_cpFunResponsabile", panels: []
            }
,            {
              name: "p_mpImportLibretto", panels: [
              {
                name: "p_FunImportLibretto", panels: [
                {
                  name: "p_wpImportDatiLibretto", panels: []
                }
,                {
                  name: "p_cpFunImportLibretto", panels: []
                }
                ]
              }
              ]
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

	initStdEnrichments4CpGestImpianto();
	initCustomEnrichments4CpGestImpianto();
	initUIStructCpGestImpianto();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestImpianto");

});



