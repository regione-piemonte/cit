

/**
 * Arricchimenti standard per il ContentPanel [cpAccreditamento] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAccreditamento() {
	var contentPanelName = "cpAccreditamento";
	/// arricchimento di base per guigen::TextField [tfAccredDenom]
	var addBasicEnrichmentToTfAccredDenom =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredDenom',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredDenom);
	/// arricchimento di base per guigen::TextField [tfAccredCF]
	var addBasicEnrichmentToTfAccredCF =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredCF',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredCF);
	/// arricchimento per guigen::ComboBox [cbAccredProvincia]: autonarrowing
	var addNarrowingToCbAccredProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAccredProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addNarrowingToCbAccredProvincia);


	/// arricchimento per guigen::ComboBox [cbAccredComune]: autonarrowing
	var addNarrowingToCbAccredComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAccredComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addNarrowingToCbAccredComune);


	/// arricchimento di base per guigen::TextField [tfIndirizzo]
	var addBasicEnrichmentToTfIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfIndirizzo);
	/// arricchimento per guigen::ComboBox [cbElencoIndirizzi]: autonarrowing
	var addNarrowingToCbElencoIndirizzi =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoIndirizzi',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addNarrowingToCbElencoIndirizzi);


	/// arricchimento di base per guigen::TextField [tfNonTrov]
	var addBasicEnrichmentToTfNonTrov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNonTrov',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfNonTrov);
	/// arricchimento di base per guigen::TextField [tfCivico]
	var addBasicEnrichmentToTfCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfCivico);
	/// arricchimento di base per guigen::TextField [tfAccredCap]
	var addBasicEnrichmentToTfAccredCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredCap);
	/// arricchimento di base per guigen::TextField [tfAccredEstStato]
	var addBasicEnrichmentToTfAccredEstStato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredEstStato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredEstStato);
	/// arricchimento di base per guigen::TextField [tfAccredEstCitta]
	var addBasicEnrichmentToTfAccredEstCitta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredEstCitta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredEstCitta);
	/// arricchimento di base per guigen::TextField [tfAccredEstIndirizzo]
	var addBasicEnrichmentToTfAccredEstIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredEstIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredEstIndirizzo);
	/// arricchimento di base per guigen::TextField [tfAccredEstCivico]
	var addBasicEnrichmentToTfAccredEstCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredEstCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredEstCivico);
	/// arricchimento di base per guigen::TextField [tfAccredEstCap]
	var addBasicEnrichmentToTfAccredEstCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAccredEstCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAccreditamento", addBasicEnrichmentToTfAccredEstCap);


	/// arricchimento per guigen::Calendar [clDataCorso]: aggiunta datepicker
	var addDateToClDataCorso = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataCorso", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaFormazione", addDateToClDataCorso);
	/// arricchimento di base per guigen::TextField [tfDesCorso]
	var addBasicEnrichmentToTfDesCorso =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDesCorso',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaFormazione", addBasicEnrichmentToTfDesCorso);


	/// arricchimento per guigen::ComboBox [cbSiglaRea]: autonarrowing
	var addNarrowingToCbSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addNarrowingToCbSiglaRea);


	/// arricchimento di base per guigen::TextField [tfNumeroRea]
	var addBasicEnrichmentToTfNumeroRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroRea',
			 	false,
			 	'int',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfNumeroRea);
	/// arricchimento di base per guigen::TextField [tfImpresaDenominazione]
	var addBasicEnrichmentToTfImpresaDenominazione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaDenominazione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaDenominazione);
	/// arricchimento di base per guigen::TextField [tfImpresaCfPi]
	var addBasicEnrichmentToTfImpresaCfPi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaCfPi',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaCfPi);
	/// arricchimento per guigen::Calendar [clImpresaDataInizioAttivita]: aggiunta datepicker
	var addDateToClImpresaDataInizioAttivita = function(){
		uiNRichLib.addDatePickerNRich("widg_clImpresaDataInizioAttivita", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addDateToClImpresaDataInizioAttivita);
	/// arricchimento per guigen::Calendar [clImpresaDataCessazione]: aggiunta datepicker
	var addDateToClImpresaDataCessazione = function(){
		uiNRichLib.addDatePickerNRich("widg_clImpresaDataCessazione", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addDateToClImpresaDataCessazione);
	/// arricchimento per guigen::ComboBox [cbImpresaProvincia]: autonarrowing
	var addNarrowingToCbImpresaProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpresaProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addNarrowingToCbImpresaProvincia);


	/// arricchimento per guigen::ComboBox [cbImpresaComune]: autonarrowing
	var addNarrowingToCbImpresaComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpresaComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addNarrowingToCbImpresaComune);


	/// arricchimento di base per guigen::TextField [btImpresaIndirizzo]
	var addBasicEnrichmentToBtImpresaIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_btImpresaIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToBtImpresaIndirizzo);
	/// arricchimento per guigen::ComboBox [cbImpresaIndirizzo]: autonarrowing
	var addNarrowingToCbImpresaIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpresaIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addNarrowingToCbImpresaIndirizzo);


	/// arricchimento di base per guigen::TextField [tfImpresaNonTrovato]
	var addBasicEnrichmentToTfImpresaNonTrovato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaNonTrovato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaNonTrovato);
	/// arricchimento di base per guigen::TextField [tfImpresaCivico]
	var addBasicEnrichmentToTfImpresaCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaCivico);
	/// arricchimento di base per guigen::TextField [tfImpresaCap]
	var addBasicEnrichmentToTfImpresaCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaCap);
	/// arricchimento di base per guigen::TextField [tfImpresaEstStato]
	var addBasicEnrichmentToTfImpresaEstStato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstStato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaEstStato);
	/// arricchimento di base per guigen::TextField [tfImpresaEstCitta]
	var addBasicEnrichmentToTfImpresaEstCitta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstCitta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaEstCitta);
	/// arricchimento di base per guigen::TextField [tfImpresaEstIndirizzo]
	var addBasicEnrichmentToTfImpresaEstIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaEstIndirizzo);
	/// arricchimento di base per guigen::TextField [tfImpresaEstCivico]
	var addBasicEnrichmentToTfImpresaEstCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaEstCivico);
	/// arricchimento di base per guigen::TextField [tfImpresaEstCap]
	var addBasicEnrichmentToTfImpresaEstCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEstCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaEstCap);
	/// arricchimento di base per guigen::TextField [tfImpresaEmail]
	var addBasicEnrichmentToTfImpresaEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaEmail);
	/// arricchimento di base per guigen::TextField [tfImpresaPec]
	var addBasicEnrichmentToTfImpresaPec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaPec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaPec);
	/// arricchimento di base per guigen::TextField [tfImpresaTelefono]
	var addBasicEnrichmentToTfImpresaTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpNuovaImpresa", addBasicEnrichmentToTfImpresaTelefono);
	/// arricchimento di base per guigen::TextField [tfImpresaSoggDelegato]
	var addBasicEnrichmentToTfImpresaSoggDelegato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfImpresaSoggDelegato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDichImpresa", addBasicEnrichmentToTfImpresaSoggDelegato);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAccreditamento(){
/*PROTECTED REGION ID(R-1895229094) ENABLED START*/
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

function initUIStructCpAccreditamento(){
	var contentPanelName = "cpAccreditamento";
	var structure =
      {
        name: "p_fpAccreditamentoG", panels: [
        {
          name: "p_fpLeft", panels: [
          {
            name: "p_menuPanel", panels: []
          }
          ]
        }
,        {
          name: "p_fpUpUserInfo", panels: [
          {
            name: "p_udpTestalino", panels: [
            ]
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpAccreditamento", panels: [
            {
              name: "p_stdMsgPHome", panels: [
              ]
            }
,            {
              name: "p_wpAccreditamento", panels: []
            }
,            {
              name: "p_cpAccreditamentoNAV", panels: []
            }
,            {
              name: "p_wpFormazione", panels: []
            }
,            {
              name: "p_cpFormazione", panels: []
            }
,            {
              name: "p_mpFormazione", panels: [
              {
                name: "p_fpNuovaFormazione", panels: [
                {
                  name: "p_wpNuovaFormazione", panels: []
                }
,                {
                  name: "p_cpInsFormazione", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_wpImprese", panels: []
            }
,            {
              name: "p_cpImprese", panels: []
            }
,            {
              name: "p_mpImpresa", panels: [
              {
                name: "p_fmNuovaImpresa", panels: [
                {
                  name: "p_wpNuovaImpresa", panels: []
                }
,                {
                  name: "p_wpAbilImpresa", panels: []
                }
,                {
                  name: "p_wpAbilAltroImpresa", panels: []
                }
,                {
                  name: "p_wpDichImpresa", panels: []
                }
,                {
                  name: "p_cpNuovaImpresa", panels: []
                }
                ]
              }
              ]
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

	initStdEnrichments4CpAccreditamento();
	initCustomEnrichments4CpAccreditamento();
	initUIStructCpAccreditamento();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAccreditamento");

});



