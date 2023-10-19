

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglio3Resp] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglio3Resp() {
	var contentPanelName = "cpDettaglio3Resp";

	/// arricchimento per guigen::Calendar [calDataFineContratto]: aggiunta datepicker
	var addDateToCalDataFineContratto = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataFineContratto", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpProroga", addDateToCalDataFineContratto);



	/// arricchimento di base per guigen::TextField [tfDescrizioneDoc]
	var addBasicEnrichmentToTfDescrizioneDoc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescrizioneDoc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpInsDocumento", addBasicEnrichmentToTfDescrizioneDoc);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglio3Resp(){
/*PROTECTED REGION ID(R1631485607) ENABLED START*/
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

function initUIStructCpDettaglio3Resp(){
	var contentPanelName = "cpDettaglio3Resp";
	var structure =
      {
        name: "p_fpDettaglio3Resp", panels: [
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
          name: "p_fpLeftMenu", panels: [
          {
            name: "p_udpFunzionalita", panels: [
            ]
          }
,          {
            name: "p_wpMenuTree", panels: []
          }
          ]
        }
,        {
          name: "p_fpCenter", panels: [
          {
            name: "p_fpDettaglioNomina", panels: [
            ]
          }
,          {
            name: "p_stdMsgProroga", panels: [
            ]
          }
,          {
            name: "p_wpDatiTerzoResp", panels: []
          }
,          {
            name: "p_wpDatiContratto", panels: []
          }
,          {
            name: "p_wpImpianto", panels: []
          }
,          {
            name: "p_cpProroga", panels: []
          }
,          {
            name: "p_mpProroga", panels: [
            {
              name: "p_fpProroga", panels: [
              {
                name: "p_wpProroga", panels: []
              }
,              {
                name: "p_cpPanelProrogaFun", panels: []
              }
,              {
                name: "p_cpPanelProrogaNav", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_wpDocumenti", panels: []
          }
,          {
            name: "p_cpAzioniDoc", panels: []
          }
,          {
            name: "p_mpInserimentoDocumento", panels: [
            {
              name: "p_fpInsDocumento", panels: [
              {
                name: "p_wpInsDocumento", panels: []
              }
,              {
                name: "p_cpCaricaDoc", panels: []
              }
,              {
                name: "p_cpChiudiDoc", panels: []
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpNavGest", panels: []
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

	initStdEnrichments4CpDettaglio3Resp();
	initCustomEnrichments4CpDettaglio3Resp();
	initUIStructCpDettaglio3Resp();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglio3Resp");

});



