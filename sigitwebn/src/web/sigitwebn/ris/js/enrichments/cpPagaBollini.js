

/**
 * Arricchimenti standard per il ContentPanel [cpPagaBollini] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpPagaBollini() {
	var contentPanelName = "cpPagaBollini";
	/// arricchimento per guigen::ComboBox [cbGestModPagamento]: autonarrowing
	var addNarrowingToCbGestModPagamento =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbGestModPagamento',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpPagaBollini", addNarrowingToCbGestModPagamento);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpPagaBollini(){
/*PROTECTED REGION ID(R-1971204639) ENABLED START*/
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

function initUIStructCpPagaBollini(){
	var contentPanelName = "cpPagaBollini";
	var structure =
      {
        name: "p_fpPagaBolliniG", panels: [
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
            name: "p_fpPagaBollini", panels: [
            {
              name: "p_stdMsgPPagaBol", panels: [
              ]
            }
,            {
              name: "p_wpPagaBollini", panels: []
            }
,            {
              name: "p_cpNavPagaBollini", panels: []
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

	initStdEnrichments4CpPagaBollini();
	initCustomEnrichments4CpPagaBollini();
	initUIStructCpPagaBollini();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpPagaBollini");

});



