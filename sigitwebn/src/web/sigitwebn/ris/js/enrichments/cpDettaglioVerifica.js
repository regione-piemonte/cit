

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioVerifica] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioVerifica() {
	var contentPanelName = "cpDettaglioVerifica";





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioVerifica(){
/*PROTECTED REGION ID(R1543441191) ENABLED START*/
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

function initUIStructCpDettaglioVerifica(){
	var contentPanelName = "cpDettaglioVerifica";
	var structure =
      {
        name: "p_fpDettaglioVerifica", panels: [
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
            name: "p_fpDettaglioVerifica2", panels: [
            ]
          }
,          {
            name: "p_stdMsg", panels: [
            ]
          }
,          {
            name: "p_wpVerifica", panels: []
          }
,          {
            name: "p_cpSalva", panels: []
          }
,          {
            name: "p_wpAzioni", panels: []
          }
,          {
            name: "p_cpFunzioni", panels: []
          }
,          {
            name: "p_cpNav", panels: []
          }
,          {
            name: "p_mpGestioneSveglia", panels: [
            {
              name: "p_fpGestioneSveglia", panels: [
              {
                name: "p_stdMsgSveglia", panels: [
                ]
              }
,              {
                name: "p_wpGestioneSveglia", panels: []
              }
,              {
                name: "p_cpFun", panels: []
              }
,              {
                name: "p_cpFun2", panels: []
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

	initStdEnrichments4CpDettaglioVerifica();
	initCustomEnrichments4CpDettaglioVerifica();
	initUIStructCpDettaglioVerifica();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioVerifica");

});



