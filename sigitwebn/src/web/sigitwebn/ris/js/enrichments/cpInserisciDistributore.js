

/**
 * Arricchimenti standard per il ContentPanel [cpInserisciDistributore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpInserisciDistributore() {
	var contentPanelName = "cpInserisciDistributore";
	/// arricchimento di base per guigen::TextField [tfDistribCognome]
	var addBasicEnrichmentToTfDistribCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDistribCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiClienteForn", addBasicEnrichmentToTfDistribCognome);
	/// arricchimento di base per guigen::TextField [tfDistribNome]
	var addBasicEnrichmentToTfDistribNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDistribNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiClienteForn", addBasicEnrichmentToTfDistribNome);
	/// arricchimento di base per guigen::TextField [tfDistribCf]
	var addBasicEnrichmentToTfDistribCf =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDistribCf',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiClienteForn", addBasicEnrichmentToTfDistribCf);
	/// arricchimento per guigen::ComboBox [cbFornProvincia]: autonarrowing
	var addNarrowingToCbFornProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFornProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneForn", addNarrowingToCbFornProvincia);


	/// arricchimento per guigen::ComboBox [cbFornComune]: autonarrowing
	var addNarrowingToCbFornComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFornComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneForn", addNarrowingToCbFornComune);


	/// arricchimento di base per guigen::TextField [tfIndirizzoForn]
	var addBasicEnrichmentToTfIndirizzoForn =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoForn',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneForn", addBasicEnrichmentToTfIndirizzoForn);
	/// arricchimento per guigen::ComboBox [cbFornIndirizzo]: autonarrowing
	var addNarrowingToCbFornIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFornIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneForn", addNarrowingToCbFornIndirizzo);


	/// arricchimento di base per guigen::TextField [tfIFornNoStrad]
	var addBasicEnrichmentToTfIFornNoStrad =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIFornNoStrad',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneForn", addBasicEnrichmentToTfIFornNoStrad);
	/// arricchimento di base per guigen::TextField [tfIFornCivico]
	var addBasicEnrichmentToTfIFornCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIFornCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneForn", addBasicEnrichmentToTfIFornCivico);
	/// arricchimento di base per guigen::TextField [tfIFornCAP]
	var addBasicEnrichmentToTfIFornCAP =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIFornCAP',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneForn", addBasicEnrichmentToTfIFornCAP);
	/// arricchimento di base per guigen::TextField [tfAnnoRif]
	var addBasicEnrichmentToTfAnnoRif =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoRif',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addBasicEnrichmentToTfAnnoRif);
	/// arricchimento di base per guigen::TextField [tfNumMesi]
	var addBasicEnrichmentToTfNumMesi =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumMesi',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addBasicEnrichmentToTfNumMesi);
	/// arricchimento di base per guigen::TextField [tfPodPdr]
	var addBasicEnrichmentToTfPodPdr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPodPdr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addBasicEnrichmentToTfPodPdr);
	/// arricchimento per guigen::ComboBox [cbTipoContratto]: autonarrowing
	var addNarrowingToCbTipoContratto =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoContratto',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addNarrowingToCbTipoContratto);


	/// arricchimento per guigen::ComboBox [cbTipoCategoria]: autonarrowing
	var addNarrowingToCbTipoCategoria =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoCategoria',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addNarrowingToCbTipoCategoria);


	/// arricchimento per guigen::ComboBox [cbTipoCombustibile]: autonarrowing
	var addNarrowingToCbTipoCombustibile =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoCombustibile',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addNarrowingToCbTipoCombustibile);


	/// arricchimento di base per guigen::TextField [tfConsumoAnno]
	var addBasicEnrichmentToTfConsumoAnno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfConsumoAnno',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addBasicEnrichmentToTfConsumoAnno);
	/// arricchimento per guigen::ComboBox [cbTipoMisura]: autonarrowing
	var addNarrowingToCbTipoMisura =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoMisura',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addNarrowingToCbTipoMisura);


	/// arricchimento di base per guigen::TextField [tfVolumeRiscaldato]
	var addBasicEnrichmentToTfVolumeRiscaldato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolumeRiscaldato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFornitura", addBasicEnrichmentToTfVolumeRiscaldato);
	/// arricchimento di base per guigen::TextField [tfDistribCognomeFatt]
	var addBasicEnrichmentToTfDistribCognomeFatt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDistribCognomeFatt',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiClienteFatt", addBasicEnrichmentToTfDistribCognomeFatt);
	/// arricchimento di base per guigen::TextField [tfDistribNomeFatt]
	var addBasicEnrichmentToTfDistribNomeFatt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDistribNomeFatt',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiClienteFatt", addBasicEnrichmentToTfDistribNomeFatt);
	/// arricchimento di base per guigen::TextField [tfDistribCfFatt]
	var addBasicEnrichmentToTfDistribCfFatt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDistribCfFatt',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiClienteFatt", addBasicEnrichmentToTfDistribCfFatt);
	/// arricchimento per guigen::ComboBox [cbFornProvinciaFatt]: autonarrowing
	var addNarrowingToCbFornProvinciaFatt =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFornProvinciaFatt',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addNarrowingToCbFornProvinciaFatt);


	/// arricchimento per guigen::ComboBox [cbFornComuneFatt]: autonarrowing
	var addNarrowingToCbFornComuneFatt =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFornComuneFatt',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addNarrowingToCbFornComuneFatt);


	/// arricchimento di base per guigen::TextField [tfIndirizzoFatt]
	var addBasicEnrichmentToTfIndirizzoFatt =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzoFatt',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addBasicEnrichmentToTfIndirizzoFatt);
	/// arricchimento per guigen::ComboBox [cbFattIndirizzo]: autonarrowing
	var addNarrowingToCbFattIndirizzo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbFattIndirizzo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addNarrowingToCbFattIndirizzo);


	/// arricchimento di base per guigen::TextField [tfIFattNoStrad]
	var addBasicEnrichmentToTfIFattNoStrad =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIFattNoStrad',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addBasicEnrichmentToTfIFattNoStrad);
	/// arricchimento di base per guigen::TextField [tfIFattEstero]
	var addBasicEnrichmentToTfIFattEstero =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIFattEstero',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addBasicEnrichmentToTfIFattEstero);
	/// arricchimento di base per guigen::TextField [tfIFattCivico]
	var addBasicEnrichmentToTfIFattCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIFattCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addBasicEnrichmentToTfIFattCivico);
	/// arricchimento di base per guigen::TextField [tfIFattCAP]
	var addBasicEnrichmentToTfIFattCAP =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIFattCAP',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpLocazioneFatt", addBasicEnrichmentToTfIFattCAP);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpInserisciDistributore(){
/*PROTECTED REGION ID(R692094814) ENABLED START*/
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

function initUIStructCpInserisciDistributore(){
	var contentPanelName = "cpInserisciDistributore";
	var structure =
      {
        name: "p_fpInsDistributori", panels: [
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
            name: "p_fpGestDistributoriTitolo", panels: [
            ]
          }
,          {
            name: "p_fpGestDistributori", panels: [
            {
              name: "p_stdMsgPGestDistr", panels: [
              ]
            }
,            {
              name: "p_wpDatiClienteForn", panels: []
            }
,            {
              name: "p_wpLocazioneForn", panels: []
            }
,            {
              name: "p_wpFornitura", panels: []
            }
,            {
              name: "p_wpDatiFattUguale", panels: []
            }
,            {
              name: "p_mpFatturazione", panels: [
              {
                name: "p_fpFatturazione", panels: [
                {
                  name: "p_wpDatiClienteFatt", panels: []
                }
,                {
                  name: "p_wpLocazioneFatt", panels: []
                }
                ]
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpFunGestDistributori", panels: []
          }
,          {
            name: "p_cpNavGestDistributori", panels: []
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

	initStdEnrichments4CpInserisciDistributore();
	initCustomEnrichments4CpInserisciDistributore();
	initUIStructCpInserisciDistributore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpInserisciDistributore");

});



