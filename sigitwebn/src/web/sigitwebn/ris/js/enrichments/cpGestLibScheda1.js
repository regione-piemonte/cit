

/**
 * Arricchimenti standard per il ContentPanel [cpGestLibScheda1] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpGestLibScheda1() {
	var contentPanelName = "cpGestLibScheda1";
	/// arricchimento per guigen::Calendar [cDataIntervento]: aggiunta datepicker
	var addDateToCDataIntervento = function(){
		uiNRichLib.addDatePickerNRich("widg_cDataIntervento", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1TipoIntervento", addDateToCDataIntervento);
	/// arricchimento per guigen::ComboBox [cbTipoIntervento]: autonarrowing
	var addNarrowingToCbTipoIntervento =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoIntervento',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1TipoIntervento", addNarrowingToCbTipoIntervento);


	/// arricchimento per guigen::ComboBox [cbCategoria]: autonarrowing
	var addNarrowingToCbCategoria =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCategoria',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1DestinazioneEdificio", addNarrowingToCbCategoria);


	/// arricchimento di base per guigen::TextField [tfVolumeLordoRiscaldato]
	var addBasicEnrichmentToTfVolumeLordoRiscaldato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolumeLordoRiscaldato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1DestinazioneEdificio", addBasicEnrichmentToTfVolumeLordoRiscaldato);
	/// arricchimento di base per guigen::TextField [tfVolumeLordoRaffrescato]
	var addBasicEnrichmentToTfVolumeLordoRaffrescato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolumeLordoRaffrescato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1DestinazioneEdificio", addBasicEnrichmentToTfVolumeLordoRaffrescato);
	/// arricchimento di base per guigen::TextField [tfPotenzaUtileACS]
	var addBasicEnrichmentToTfPotenzaUtileACS =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaUtileACS',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1ServiziImpianto", addBasicEnrichmentToTfPotenzaUtileACS);
	/// arricchimento di base per guigen::TextField [tfPotenzaUtileClimatInvernale]
	var addBasicEnrichmentToTfPotenzaUtileClimatInvernale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaUtileClimatInvernale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1ServiziImpianto", addBasicEnrichmentToTfPotenzaUtileClimatInvernale);
	/// arricchimento di base per guigen::TextField [tfPotenzaUtileClimatEstiva]
	var addBasicEnrichmentToTfPotenzaUtileClimatEstiva =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaUtileClimatEstiva',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1ServiziImpianto", addBasicEnrichmentToTfPotenzaUtileClimatEstiva);
	/// arricchimento di base per guigen::TextField [tfIntegrazioniPannelliSolari]
	var addBasicEnrichmentToTfIntegrazioniPannelliSolari =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIntegrazioniPannelliSolari',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1TipologiaGeneratori", addBasicEnrichmentToTfIntegrazioniPannelliSolari);
	/// arricchimento di base per guigen::TextField [tfIntegrazioniPotenzaUtile]
	var addBasicEnrichmentToTfIntegrazioniPotenzaUtile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIntegrazioniPotenzaUtile',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpScheda1TipologiaGeneratori", addBasicEnrichmentToTfIntegrazioniPotenzaUtile);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpGestLibScheda1(){
/*PROTECTED REGION ID(R-785250512) ENABLED START*/
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

function initUIStructCpGestLibScheda1(){
	var contentPanelName = "cpGestLibScheda1";
	var structure =
      {
        name: "p_fpGestLibScheda1", panels: [
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
            name: "p_fpSchedaImpianto", panels: [
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
            name: "p_wpScheda1TipoIntervento", panels: []
          }
,          {
            name: "p_wpScheda1DestinazioneEdificio", panels: []
          }
,          {
            name: "p_wpScheda1ServiziImpianto", panels: []
          }
,          {
            name: "p_wpScheda1TipologiaFluidoVettore", panels: []
          }
,          {
            name: "p_wpScheda1TipologiaGeneratori", panels: []
          }
,          {
            name: "p_cpFunGestScheda1", panels: []
          }
,          {
            name: "p_cpNavGestScheda1", panels: []
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

	initStdEnrichments4CpGestLibScheda1();
	initCustomEnrichments4CpGestLibScheda1();
	initUIStructCpGestLibScheda1();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpGestLibScheda1");

});



