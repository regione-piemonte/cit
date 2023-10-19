

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioIspezione2018] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioIspezione2018() {
	var contentPanelName = "cpDettaglioIspezione2018";
	/// arricchimento per guigen::ComboBox [cbSecondoIspettore]: autonarrowing
	var addNarrowingToCbSecondoIspettore =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSecondoIspettore',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioIspezione", addNarrowingToCbSecondoIspettore);


	/// arricchimento per guigen::ComboBox [provComp]: autonarrowing
	var addNarrowingToProvComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_provComp',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioIspezione", addNarrowingToProvComp);


	/// arricchimento per guigen::ComboBox [comComp]: autonarrowing
	var addNarrowingToComComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_comComp',
			 	false);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioIspezione", addNarrowingToComComp);







	/// arricchimento di base per guigen::TextField [tfEnteCompetenteConclusione]
	var addBasicEnrichmentToTfEnteCompetenteConclusione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEnteCompetenteConclusione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpConcludiIspezione", addBasicEnrichmentToTfEnteCompetenteConclusione);

	/// arricchimento per guigen::ComboBox [cbElencoIspettori]: autonarrowing
	var addNarrowingToCbElencoIspettori =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoIspettori',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAssegnaIspezione", addNarrowingToCbElencoIspettori);



	/// arricchimento di base per guigen::TextField [tfCercaCodiceImpianto]
	var addBasicEnrichmentToTfCercaCodiceImpianto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCercaCodiceImpianto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAssociaCodiceImpianto", addBasicEnrichmentToTfCercaCodiceImpianto);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioIspezione2018(){
/*PROTECTED REGION ID(R-1047868447) ENABLED START*/
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

function initUIStructCpDettaglioIspezione2018(){
	var contentPanelName = "cpDettaglioIspezione2018";
	var structure =
      {
        name: "p_fpDettaglioIspezione2018", panels: [
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
            name: "p_fpTitle", panels: [
            ]
          }
,          {
            name: "p_stdErrorMessageDettaglioIspezione", panels: [
            ]
          }
,          {
            name: "p_wpDettaglioIspezione", panels: []
          }
,          {
            name: "p_cpFunIspezione", panels: []
          }
,          {
            name: "p_mpElenchi", panels: [
            {
              name: "p_fpElenchi", panels: [
              {
                name: "p_fpElencoSanzioni", panels: [
                {
                  name: "p_wpSanzioni", panels: []
                }
,                {
                  name: "p_cpFunSanzioni", panels: []
                }
                ]
              }
,              {
                name: "p_fpElencoRapProva", panels: [
                {
                  name: "p_wpRapportiProva", panels: []
                }
,                {
                  name: "p_cpFunRappProva", panels: []
                }
,                {
                  name: "p_mpUploadRappProvaFirmato", panels: [
                  {
                    name: "p_fpUploadRappProvaFirmato", panels: [
                    {
                      name: "p_wpUploadRappProvaFirmato", panels: []
                    }
,                    {
                      name: "p_cpUploadRappProvaFirmato", panels: []
                    }
                    ]
                  }
                  ]
                }
                ]
              }
,              {
                name: "p_fpElencoAzioni", panels: [
                {
                  name: "p_wpAzioniSvolte", panels: []
                }
,                {
                  name: "p_cpFunAzioni", panels: []
                }
                ]
              }
,              {
                name: "p_mpAzioniIspezione", panels: [
                {
                  name: "p_fpConcludiIspezione", panels: [
                  {
                    name: "p_wpConcludiIspezione", panels: []
                  }
,                  {
                    name: "p_cpConclusione", panels: []
                  }
                  ]
                }
,                {
                  name: "p_fpAssegnaIspezione", panels: [
                  {
                    name: "p_wpAssegnaIspezione", panels: []
                  }
,                  {
                    name: "p_cpAssegna", panels: []
                  }
                  ]
                }
,                {
                  name: "p_fpAssociaCodiceImpianto", panels: [
                  {
                    name: "p_wpAssociaCodiceImpianto", panels: []
                  }
,                  {
                    name: "p_cpAssociaCodiceImpianto", panels: []
                  }
                  ]
                }
                ]
              }
              ]
            }
            ]
          }
,          {
            name: "p_cpNavIspezione", panels: []
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

	initStdEnrichments4CpDettaglioIspezione2018();
	initCustomEnrichments4CpDettaglioIspezione2018();
	initUIStructCpDettaglioIspezione2018();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioIspezione2018");

});



