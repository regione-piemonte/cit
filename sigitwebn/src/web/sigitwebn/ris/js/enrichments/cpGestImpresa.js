

/**
 * Arricchimenti standard per il ContentPanel [cpGestImpresa] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestImpresa() {
	var contentPanelName = "cpGestImpresa";
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
	/// arricchimento di base per guigen::TextField [tfImpCf]
	var addBasicEnrichmentToTfImpCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpCf',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfImpCf);
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
	/// arricchimento per guigen::ComboBox [cbRuolo]: autonarrowing
	var addNarrowingToCbRuolo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRuolo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addNarrowingToCbRuolo);


	/// arricchimento per guigen::ComboBox [cbStatoImp]: autonarrowing
	var addNarrowingToCbStatoImp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatoImp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addNarrowingToCbStatoImp);



	/// arricchimento per guigen::ComboBox [cbSiglaRea]: autonarrowing
	var addNarrowingToCbSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addNarrowingToCbSiglaRea);


	/// arricchimento di base per guigen::TextField [tfNumeroRea]
	var addBasicEnrichmentToTfNumeroRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfNumeroRea);
	/// arricchimento di base per guigen::TextField [tfImpresaDenominazione]
	var addBasicEnrichmentToTfImpresaDenominazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaDenominazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaDenominazione);
	/// arricchimento di base per guigen::TextField [tfImpresaCfPi]
	var addBasicEnrichmentToTfImpresaCfPi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaCfPi',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaCfPi);
	/// arricchimento per guigen::ComboBox [cbStatoImpresa]: autonarrowing
	var addNarrowingToCbStatoImpresa =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatoImpresa',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addNarrowingToCbStatoImpresa);


	/// arricchimento per guigen::Calendar [clImpresaDataInizioAttivita]: aggiunta datepicker
	var addDateToClImpresaDataInizioAttivita = function(){
		uiNRichLib.addDatePickerNRich("widg_clImpresaDataInizioAttivita", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addDateToClImpresaDataInizioAttivita);
	/// arricchimento per guigen::Calendar [clImpresaDataCessazione]: aggiunta datepicker
	var addDateToClImpresaDataCessazione = function(){
		uiNRichLib.addDatePickerNRich("widg_clImpresaDataCessazione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addDateToClImpresaDataCessazione);
	/// arricchimento per guigen::Calendar [clImpresaDataVariazione]: aggiunta datepicker
	var addDateToClImpresaDataVariazione = function(){
		uiNRichLib.addDatePickerNRich("widg_clImpresaDataVariazione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addDateToClImpresaDataVariazione);
	/// arricchimento di base per guigen::TextField [tfImpresaMotivVar]
	var addBasicEnrichmentToTfImpresaMotivVar =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaMotivVar',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaMotivVar);
	/// arricchimento per guigen::ComboBox [cbImpresaProvincia]: autonarrowing
	var addNarrowingToCbImpresaProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpresaProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addNarrowingToCbImpresaProvincia);


	/// arricchimento per guigen::ComboBox [cbImpresaComune]: autonarrowing
	var addNarrowingToCbImpresaComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpresaComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addNarrowingToCbImpresaComune);


	/// arricchimento di base per guigen::TextField [btImpresaIndirizzo]
	var addBasicEnrichmentToBtImpresaIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_btImpresaIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToBtImpresaIndirizzo);
	/// arricchimento per guigen::ComboBox [cbImpresaIndirizzo]: autonarrowing
	var addNarrowingToCbImpresaIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpresaIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addNarrowingToCbImpresaIndirizzo);


	/// arricchimento di base per guigen::TextField [tfImpresaNonTrovato]
	var addBasicEnrichmentToTfImpresaNonTrovato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaNonTrovato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaNonTrovato);
	/// arricchimento di base per guigen::TextField [tfImpresaCivico]
	var addBasicEnrichmentToTfImpresaCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaCivico);
	/// arricchimento di base per guigen::TextField [tfImpresaCap]
	var addBasicEnrichmentToTfImpresaCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaCap',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaCap);
	/// arricchimento di base per guigen::TextField [tfImpresaEstStato]
	var addBasicEnrichmentToTfImpresaEstStato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstStato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaEstStato);
	/// arricchimento di base per guigen::TextField [tfImpresaEstCitta]
	var addBasicEnrichmentToTfImpresaEstCitta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstCitta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaEstCitta);
	/// arricchimento di base per guigen::TextField [tfImpresaEstIndirizzo]
	var addBasicEnrichmentToTfImpresaEstIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaEstIndirizzo);
	/// arricchimento di base per guigen::TextField [tfImpresaEstCivico]
	var addBasicEnrichmentToTfImpresaEstCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaEstCivico);
	/// arricchimento di base per guigen::TextField [tfImpresaEstCap]
	var addBasicEnrichmentToTfImpresaEstCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaEstCap);
	/// arricchimento di base per guigen::TextField [tfImpresaEmail]
	var addBasicEnrichmentToTfImpresaEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfImpresaEmail);
	/// arricchimento di base per guigen::TextField [tfPec]
	var addBasicEnrichmentToTfPec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfPec);
	/// arricchimento di base per guigen::TextField [tfTelefono]
	var addBasicEnrichmentToTfTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettImpresa", addBasicEnrichmentToTfTelefono);
	/// arricchimento di base per guigen::TextField [tfSoggIncaricato]
	var addBasicEnrichmentToTfSoggIncaricato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSoggIncaricato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAbilImpresaInQualitaDi", addBasicEnrichmentToTfSoggIncaricato);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestImpresa(){
/*PROTECTED REGION ID(R-2003901181) ENABLED START*/
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

function initUIStructCpGestImpresa(){
	var contentPanelName = "cpGestImpresa";
	var structure =
      {
        name: "p_fpGestImpresaG", panels: [
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
            name: "p_fpGestImpresa", panels: [
            {
              name: "p_stdMsgPGestImpresa", panels: [
              ]
            }
,            {
              name: "p_wpImpresa", panels: []
            }
,            {
              name: "p_mpImTrovate", panels: [
              {
                name: "p_fpImpTrovate", panels: [
                {
                  name: "p_wpImpTrovate", panels: []
                }
,                {
                  name: "p_cpImprese", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpImpresa", panels: [
              {
                name: "p_fmDettImpresa", panels: [
                {
                  name: "p_wpDettImpresa", panels: []
                }
,                {
                  name: "p_wpAbilImpresa", panels: []
                }
,                {
                  name: "p_wpAbilAltroImpresa", panels: []
                }
,                {
                  name: "p_wpAbilImpresaInQualitaDi", panels: []
                }
,                {
                  name: "p_cpDettImpresa", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpVisuraImpresa", panels: [
              {
                name: "p_fmVisuraImpresa", panels: [
                {
                  name: "p_wpVisuraImpresa", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpDatiCat", panels: [
              {
                name: "p_fmDatiCat", panels: [
                {
                  name: "p_wpDatiCat", panels: []
                }
,                {
                  name: "p_wpNumRapInv", panels: []
                }
,                {
                  name: "p_cpDatiCat", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavImpresa", panels: []
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

	initStdEnrichments4CpGestImpresa();
	initCustomEnrichments4CpGestImpresa();
	initUIStructCpGestImpresa();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestImpresa");

});



