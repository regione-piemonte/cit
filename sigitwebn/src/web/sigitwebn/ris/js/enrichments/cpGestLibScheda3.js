

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda3] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda3() {
	var contentPanelName = "cpGestLibScheda3";

	/// arricchimento per guigen::ComboBox [cbTipiCessazione]: autonarrowing
	var addNarrowingToCbTipiCessazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipiCessazione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRevResp", addNarrowingToCbTipiCessazione);


	/// arricchimento per guigen::Calendar [clDataRevoca]: aggiunta datepicker
	var addDateToClDataRevoca = function(){
		uiNRichLib.addDatePickerNRich("widg_clDataRevoca", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRevResp", addDateToClDataRevoca);



}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda3(){
/*PROTECTED REGION ID(R1820773042) ENABLED START*/
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

function initUIStructCpGestLibScheda3(){
	var contentPanelName = "cpGestLibScheda3";
	var structure =
      {
        name: "p_fpGestLibScheda3", panels: [
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
            name: "p_fpScheda3", panels: [
            ]
          }
,          {
            name: "p_stdMsgLibretto", panels: [
            ]
          }
,          {
            name: "p_wpInfoImpianto", panels: []
          }
,          {
            name: "p_wpScheda", panels: []
          }
,          {
            name: "p_cpFunGest", panels: []
          }
,          {
            name: "p_mpDataRevoca", panels: [
            {
              name: "p_fpMpRevoca", panels: [
              {
                name: "p_wpRevResp", panels: []
              }
,              {
                name: "p_mpAutodichiarazioni", panels: [
                {
                  name: "p_fpAutodichiarazioni", panels: [
                  {
                    name: "p_wpAutodichiarazioni", panels: []
                  }
                  ]
                }
                ]
              }
,              {
                name: "p_cpConfRevoca3", panels: []
              }
,              {
                name: "p_cpIndietroConfRevoca3", panels: []
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

	initStdEnrichments4CpGestLibScheda3();
	initCustomEnrichments4CpGestLibScheda3();
	initUIStructCpGestLibScheda3();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda3");

});



