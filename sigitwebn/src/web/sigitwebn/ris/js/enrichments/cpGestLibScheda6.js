

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda6] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda6() {
	var contentPanelName = "cpGestLibScheda6";
	/// arricchimento per guigen::ComboBox [cbCoibentazione]: autonarrowing
	var addNarrowingToCbCoibentazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCoibentazione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpCoibentazioneReteDistribuzione", addNarrowingToCbCoibentazione);





}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda6(){
/*PROTECTED REGION ID(R-712642571) ENABLED START*/
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

function initUIStructCpGestLibScheda6(){
	var contentPanelName = "cpGestLibScheda6";
	var structure =
      {
        name: "p_fpGestLibScheda6", panels: [
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
            name: "p_fpTitolo", panels: [
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
            name: "p_wpTipoDistribuzione", panels: []
          }
,          {
            name: "p_wpCoibentazioneReteDistribuzione", panels: []
          }
,          {
            name: "p_wpVasiEspansione", panels: []
          }
,          {
            name: "p_cpFunGestTable", panels: []
          }
,          {
            name: "p_cpFunGest", panels: []
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

	initStdEnrichments4CpGestLibScheda6();
	initCustomEnrichments4CpGestLibScheda6();
	initUIStructCpGestLibScheda6();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda6");

});



