

/**
 * Arricchimenti standard per il ContentPanel [cpRicBollini] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicBollini() {
	var contentPanelName = "cpRicBollini";
	/// arricchimento per guigen::ComboBox [cbSiglaBollino]: autonarrowing
	var addNarrowingToCbSiglaBollino =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaBollino',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicBolliniCodBoll", addNarrowingToCbSiglaBollino);


	/// arricchimento di base per guigen::TextField [tfNumBoll]
	var addBasicEnrichmentToTfNumBoll =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumBoll',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicBolliniCodBoll", addBasicEnrichmentToTfNumBoll);
	/// arricchimento per guigen::Calendar [clDtAcquDa]: aggiunta datepicker
	var addDateToClDtAcquDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clDtAcquDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicBolliniCodBoll", addDateToClDtAcquDa);
	/// arricchimento per guigen::Calendar [clDtAcquA]: aggiunta datepicker
	var addDateToClDtAcquA = function(){
		uiNRichLib.addDatePickerNRich("widg_clDtAcquA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicBolliniCodBoll", addDateToClDtAcquA);
	/// arricchimento per guigen::ComboBox [cbSiglaRea]: autonarrowing
	var addNarrowingToCbSiglaRea =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSiglaRea',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicBolliniManut", addNarrowingToCbSiglaRea);


	/// arricchimento di base per guigen::TextField [tfNumRea]
	var addBasicEnrichmentToTfNumRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicBolliniManut", addBasicEnrichmentToTfNumRea);
	/// arricchimento di base per guigen::TextField [tfCF]
	var addBasicEnrichmentToTfCF =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCF',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicBolliniManut", addBasicEnrichmentToTfCF);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicBollini(){
/*PROTECTED REGION ID(R-272003334) ENABLED START*/
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

function initUIStructCpRicBollini(){
	var contentPanelName = "cpRicBollini";
	var structure =
      {
        name: "p_fpRicBolliniG", panels: [
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
            name: "p_fpRicBollini", panels: [
            ]
          }
,          {
            name: "p_stdMsgPRicBollini", panels: [
            ]
          }
,          {
            name: "p_wpRicBolliniCodBoll", panels: []
          }
,          {
            name: "p_wpRicBolliniManut", panels: []
          }
,          {
            name: "p_cpFunAnnulla", panels: []
          }
,          {
            name: "p_cpNavRicBollini", panels: []
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

	initStdEnrichments4CpRicBollini();
	initCustomEnrichments4CpRicBollini();
	initUIStructCpRicBollini();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicBollini");

});



