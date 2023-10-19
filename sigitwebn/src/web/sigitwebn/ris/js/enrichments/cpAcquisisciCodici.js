

/**
 * Arricchimenti standard per il ContentPanel [cpAcquisisciCodici] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAcquisisciCodici() {
	var contentPanelName = "cpAcquisisciCodici";
	/// arricchimento per guigen::ComboBox [cbSiglaRea]: autonarrowing
	var addNarrowingToCbSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqCodManut", addNarrowingToCbSiglaRea);


	/// arricchimento di base per guigen::TextField [tfNumRea]
	var addBasicEnrichmentToTfNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqCodManut", addBasicEnrichmentToTfNumRea);
	/// arricchimento di base per guigen::TextField [tfCF]
	var addBasicEnrichmentToTfCF =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCF',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqCodManut", addBasicEnrichmentToTfCF);
	/// arricchimento di base per guigen::TextField [tfDitta]
	var addBasicEnrichmentToTfDitta =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDitta',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqCodManut", addBasicEnrichmentToTfDitta);
	/// arricchimento di base per guigen::TextField [tfDataConsegna]
	var addBasicEnrichmentToTfDataConsegna =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDataConsegna',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqCodImp", addBasicEnrichmentToTfDataConsegna);
	/// arricchimento di base per guigen::TextField [tfAcquisitiDa]
	var addBasicEnrichmentToTfAcquisitiDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAcquisitiDa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqCodImp", addBasicEnrichmentToTfAcquisitiDa);
	/// arricchimento di base per guigen::TextField [tfQuantita]
	var addBasicEnrichmentToTfQuantita =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfQuantita',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAcqCodImp", addBasicEnrichmentToTfQuantita);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAcquisisciCodici(){
/*PROTECTED REGION ID(R-1481217690) ENABLED START*/
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

function initUIStructCpAcquisisciCodici(){
	var contentPanelName = "cpAcquisisciCodici";
	var structure =
      {
        name: "p_fpAcqCodG", panels: [
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
            name: "p_fpAcqCodTitolo", panels: [
            ]
          }
,          {
            name: "p_fpAcqCod", panels: [
            {
              name: "p_stdMsgPAcqCod", panels: [
              ]
            }
,            {
              name: "p_wpAcqCodManut", panels: []
            }
,            {
              name: "p_wpAcqCodImp", panels: []
            }
,            {
              name: "p_cpFunAcqCod", panels: []
            }
,            {
              name: "p_cpNavAcqCod", panels: []
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

	initStdEnrichments4CpAcquisisciCodici();
	initCustomEnrichments4CpAcquisisciCodici();
	initUIStructCpAcquisisciCodici();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAcquisisciCodici");

});



