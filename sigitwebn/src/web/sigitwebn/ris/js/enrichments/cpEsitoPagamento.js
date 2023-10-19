

/**
 * Arricchimenti standard per il ContentPanel [cpEsitoPagamento] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpEsitoPagamento() {
	var contentPanelName = "cpEsitoPagamento";
}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpEsitoPagamento(){
/*PROTECTED REGION ID(R2107171903) ENABLED START*/
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

function initUIStructCpEsitoPagamento(){
	var contentPanelName = "cpEsitoPagamento";
	var structure =
      {
        name: "p_fpEsitoPagamentoG", panels: [
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
            name: "p_fpEsitoPagamento", panels: [
            {
              name: "p_stdMsgPEsitoPagamento", panels: [
              ]
            }
,            {
              name: "p_pEsitoPagamento", panels: []
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

	initStdEnrichments4CpEsitoPagamento();
	initCustomEnrichments4CpEsitoPagamento();
	initUIStructCpEsitoPagamento();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpEsitoPagamento");

});



