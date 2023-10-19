

/**
 * Arricchimenti standard per il ContentPanel [cpAcquistaBollini] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAcquistaBollini() {
	var contentPanelName = "cpAcquistaBollini";
	/// arricchimento per guigen::ComboBox [cbSiglaRea]: autonarrowing
	var addNarrowingToCbSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqBolManut", addNarrowingToCbSiglaRea);


	/// arricchimento di base per guigen::TextField [tfNumeroRea]
	var addBasicEnrichmentToTfNumeroRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqBolManut", addBasicEnrichmentToTfNumeroRea);
	/// arricchimento di base per guigen::TextField [tfCF]
	var addBasicEnrichmentToTfCF =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCF',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqBolManut", addBasicEnrichmentToTfCF);
	/// arricchimento di base per guigen::TextField [tfDitta]
	var addBasicEnrichmentToTfDitta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDitta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqBolManut", addBasicEnrichmentToTfDitta);
	/// arricchimento di base per guigen::TextField [tfCFOperatore]
	var addBasicEnrichmentToTfCFOperatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCFOperatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqBollini", addBasicEnrichmentToTfCFOperatore);
	/// arricchimento di base per guigen::TextField [tfDataAcquisto]
	var addBasicEnrichmentToTfDataAcquisto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDataAcquisto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqBollini", addBasicEnrichmentToTfDataAcquisto);
	/// arricchimento di base per guigen::TextField [siglaBollino]
	var addBasicEnrichmentToSiglaBollino =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_siglaBollino',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqBollini", addBasicEnrichmentToSiglaBollino);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAcquistaBollini(){
/*PROTECTED REGION ID(R-1251922097) ENABLED START*/
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

function initUIStructCpAcquistaBollini(){
	var contentPanelName = "cpAcquistaBollini";
	var structure =
      {
        name: "p_fpAcqBolliniG", panels: [
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
            name: "p_fpAcquisisciBolliniTitolo", panels: [
            ]
          }
,          {
            name: "p_fpAcqBollini", panels: [
            {
              name: "p_stdMsgPAcqBol", panels: [
              ]
            }
,            {
              name: "p_wpAcqBolManut", panels: []
            }
,            {
              name: "p_wpAcqBollini", panels: []
            }
,            {
              name: "p_wpAcqBolliniQta", panels: []
            }
,            {
              name: "p_cpFunAcqBol", panels: []
            }
,            {
              name: "p_cpNavAcqBol", panels: []
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

	initStdEnrichments4CpAcquistaBollini();
	initCustomEnrichments4CpAcquistaBollini();
	initUIStructCpAcquistaBollini();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAcquistaBollini");

});



