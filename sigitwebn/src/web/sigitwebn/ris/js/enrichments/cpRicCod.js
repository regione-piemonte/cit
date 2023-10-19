

/**
 * Arricchimenti standard per il ContentPanel [cpRicCod] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicCod() {
	var contentPanelName = "cpRicCod";
	/// arricchimento di base per guigen::TextField [tfCodImp]
	var addBasicEnrichmentToTfCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodImp',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicCod", addBasicEnrichmentToTfCodImp);
	/// arricchimento per guigen::Calendar [clDtAcquDa]: aggiunta datepicker
	var addDateToClDtAcquDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clDtAcquDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicCod", addDateToClDtAcquDa);
	/// arricchimento per guigen::Calendar [clDtAcquA]: aggiunta datepicker
	var addDateToClDtAcquA = function(){
		uiNRichLib.addDatePickerNRich("widg_clDtAcquA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicCod", addDateToClDtAcquA);
	/// arricchimento per guigen::ComboBox [cbSiglaRea]: autonarrowing
	var addNarrowingToCbSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicCodManut", addNarrowingToCbSiglaRea);


	/// arricchimento di base per guigen::TextField [tfNumRea]
	var addBasicEnrichmentToTfNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicCodManut", addBasicEnrichmentToTfNumRea);
	/// arricchimento di base per guigen::TextField [tfCF]
	var addBasicEnrichmentToTfCF =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCF',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicCodManut", addBasicEnrichmentToTfCF);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicCod(){
/*PROTECTED REGION ID(R-1800616837) ENABLED START*/
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

function initUIStructCpRicCod(){
	var contentPanelName = "cpRicCod";
	var structure =
      {
        name: "p_fpRicCodG", panels: [
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
            name: "p_fpRicCod", panels: [
            ]
          }
,          {
            name: "p_stdMsgPRicCod", panels: [
            ]
          }
,          {
            name: "p_wpRicCod", panels: []
          }
,          {
            name: "p_wpRicCodManut", panels: []
          }
,          {
            name: "p_cpFunRicCod", panels: []
          }
,          {
            name: "p_cpNavRicCod", panels: []
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

	initStdEnrichments4CpRicCod();
	initCustomEnrichments4CpRicCod();
	initUIStructCpRicCod();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicCod");

});



