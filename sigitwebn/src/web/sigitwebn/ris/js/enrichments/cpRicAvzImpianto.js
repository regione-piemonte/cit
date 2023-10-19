

/**
 * Arricchimenti standard per il ContentPanel [cpRicAvzImpianto] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicAvzImpianto() {
	var contentPanelName = "cpRicAvzImpianto";
	/// arricchimento di base per guigen::TextField [tfCodImp]
	var addBasicEnrichmentToTfCodImp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodImp',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfCodImp);
	/// arricchimento per guigen::ComboBox [cbProvincia]: autonarrowing
	var addNarrowingToCbProvincia =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbProvincia',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbProvincia);


	/// arricchimento per guigen::ComboBox [cbComune]: autonarrowing
	var addNarrowingToCbComune =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbComune',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbComune);


	/// arricchimento di base per guigen::TextField [tfDescComune]
	var addBasicEnrichmentToTfDescComune =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDescComune',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfDescComune);
	/// arricchimento di base per guigen::TextField [tfIndirizzo]
	var addBasicEnrichmentToTfIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfIndirizzo);
	/// arricchimento di base per guigen::TextField [tfCfResponsabile]
	var addBasicEnrichmentToTfCfResponsabile =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfResponsabile',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfCfResponsabile);
	/// arricchimento per guigen::ComboBox [cbStatoImp]: autonarrowing
	var addNarrowingToCbStatoImp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbStatoImp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbStatoImp);


	/// arricchimento di base per guigen::TextField [tfSezione]
	var addBasicEnrichmentToTfSezione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSezione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfSezione);
	/// arricchimento di base per guigen::TextField [tfFoglio]
	var addBasicEnrichmentToTfFoglio =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfFoglio',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfFoglio);
	/// arricchimento di base per guigen::TextField [tfParticella]
	var addBasicEnrichmentToTfParticella =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfParticella',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfParticella);
	/// arricchimento di base per guigen::TextField [tfSubalterno]
	var addBasicEnrichmentToTfSubalterno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSubalterno',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfSubalterno);
	/// arricchimento di base per guigen::TextField [tfPod]
	var addBasicEnrichmentToTfPod =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPod',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPod);
	/// arricchimento di base per guigen::TextField [tfPdr]
	var addBasicEnrichmentToTfPdr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPdr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPdr);
	/// arricchimento di base per guigen::TextField [tfPotAcsDa]
	var addBasicEnrichmentToTfPotAcsDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotAcsDa',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPotAcsDa);
	/// arricchimento di base per guigen::TextField [tfPotAcsA]
	var addBasicEnrichmentToTfPotAcsA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotAcsA',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPotAcsA);
	/// arricchimento di base per guigen::TextField [tfPotClmInvDa]
	var addBasicEnrichmentToTfPotClmInvDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotClmInvDa',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPotClmInvDa);
	/// arricchimento di base per guigen::TextField [tfPotClmInvA]
	var addBasicEnrichmentToTfPotClmInvA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotClmInvA',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPotClmInvA);
	/// arricchimento di base per guigen::TextField [tfPotClmEstDa]
	var addBasicEnrichmentToTfPotClmEstDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotClmEstDa',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPotClmEstDa);
	/// arricchimento di base per guigen::TextField [tfPotClmEstA]
	var addBasicEnrichmentToTfPotClmEstA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotClmEstA',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addBasicEnrichmentToTfPotClmEstA);
	/// arricchimento per guigen::ComboBox [cbImpTipo]: autonarrowing
	var addNarrowingToCbImpTipo =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbImpTipo',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbImpTipo);


	/// arricchimento per guigen::ComboBox [cbUiExt]: autonarrowing
	var addNarrowingToCbUiExt =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbUiExt',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbUiExt);


	/// arricchimento per guigen::ComboBox [cbContabilizzazione]: autonarrowing
	var addNarrowingToCbContabilizzazione =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbContabilizzazione',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpianto", addNarrowingToCbContabilizzazione);


	/// arricchimento per guigen::ComboBox [cbSglReaComp]: autonarrowing
	var addNarrowingToCbSglReaComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbSglReaComp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addNarrowingToCbSglReaComp);


	/// arricchimento di base per guigen::TextField [tfNumeroRea]
	var addBasicEnrichmentToTfNumeroRea =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumeroRea',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfNumeroRea);
	/// arricchimento di base per guigen::TextField [tfCfImpresa]
	var addBasicEnrichmentToTfCfImpresa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCfImpresa',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpImpresa", addBasicEnrichmentToTfCfImpresa);
	/// arricchimento per guigen::ComboBox [cbAllTipoDoc]: autonarrowing
	var addNarrowingToCbAllTipoDoc =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAllTipoDoc',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicAvzGen", addNarrowingToCbAllTipoDoc);


	/// arricchimento per guigen::ComboBox [cbTipoComp]: autonarrowing
	var addNarrowingToCbTipoComp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbTipoComp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addNarrowingToCbTipoComp);


	/// arricchimento per guigen::ComboBox [cbMarca]: autonarrowing
	var addNarrowingToCbMarca =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbMarca',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addNarrowingToCbMarca);


	/// arricchimento per guigen::ComboBox [cbCombu]: autonarrowing
	var addNarrowingToCbCombu =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbCombu',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addNarrowingToCbCombu);


	/// arricchimento di base per guigen::TextField [tfRendPercDa]
	var addBasicEnrichmentToTfRendPercDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendPercDa',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addBasicEnrichmentToTfRendPercDa);
	/// arricchimento di base per guigen::TextField [tfRendPercA]
	var addBasicEnrichmentToTfRendPercA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRendPercA',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addBasicEnrichmentToTfRendPercA);
	/// arricchimento di base per guigen::TextField [tfPotenzaDa]
	var addBasicEnrichmentToTfPotenzaDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaDa',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addBasicEnrichmentToTfPotenzaDa);
	/// arricchimento di base per guigen::TextField [tfPotenzaA]
	var addBasicEnrichmentToTfPotenzaA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPotenzaA',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addBasicEnrichmentToTfPotenzaA);
	/// arricchimento per guigen::Calendar [clDtInstallDa]: aggiunta datepicker
	var addDateToClDtInstallDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clDtInstallDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addDateToClDtInstallDa);
	/// arricchimento per guigen::Calendar [clDtInstallA]: aggiunta datepicker
	var addDateToClDtInstallA = function(){
		uiNRichLib.addDatePickerNRich("widg_clDtInstallA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabCompPanel", addDateToClDtInstallA);

	/// arricchimento per guigen::ComboBox [cbAllTipoRapp]: autonarrowing
	var addNarrowingToCbAllTipoRapp =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAllTipoRapp',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicAvzRee", addNarrowingToCbAllTipoRapp);


	/// arricchimento per guigen::ComboBox [cbRicAvzSic]: autonarrowing
	var addNarrowingToCbRicAvzSic =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbRicAvzSic',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicAvzRee", addNarrowingToCbRicAvzSic);


	/// arricchimento per guigen::ComboBox [cbAllVerAss]: autonarrowing
	var addNarrowingToCbAllVerAss =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAllVerAss',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicAvzRee", addNarrowingToCbAllVerAss);


	/// arricchimento per guigen::Calendar [clAllDatContrDa]: aggiunta datepicker
	var addDateToClAllDatContrDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clAllDatContrDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addDateToClAllDatContrDa);
	/// arricchimento per guigen::Calendar [clAllDatContrA]: aggiunta datepicker
	var addDateToClAllDatContrA = function(){
		uiNRichLib.addDatePickerNRich("widg_clAllDatContrA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addDateToClAllDatContrA);
	/// arricchimento per guigen::Calendar [clAllIntManRaccDa]: aggiunta datepicker
	var addDateToClAllIntManRaccDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clAllIntManRaccDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addDateToClAllIntManRaccDa);
	/// arricchimento per guigen::Calendar [clAllIntMantRaccA]: aggiunta datepicker
	var addDateToClAllIntMantRaccA = function(){
		uiNRichLib.addDatePickerNRich("widg_clAllIntMantRaccA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addDateToClAllIntMantRaccA);
	/// arricchimento di base per guigen::TextField [tfNumGiorniDopoDataControllo]
	var addBasicEnrichmentToTfNumGiorniDopoDataControllo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumGiorniDopoDataControllo',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addBasicEnrichmentToTfNumGiorniDopoDataControllo);
	/// arricchimento per guigen::ComboBox [cbAllUMisNox]: autonarrowing
	var addNarrowingToCbAllUMisNox =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAllUMisNox',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addNarrowingToCbAllUMisNox);


	/// arricchimento di base per guigen::TextField [tfNoxDa]
	var addBasicEnrichmentToTfNoxDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoxDa',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addBasicEnrichmentToTfNoxDa);
	/// arricchimento di base per guigen::TextField [tfNoxA]
	var addBasicEnrichmentToTfNoxA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNoxA',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addBasicEnrichmentToTfNoxA);
	/// arricchimento per guigen::ComboBox [cbAllSigleBoll]: autonarrowing
	var addNarrowingToCbAllSigleBoll =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbAllSigleBoll',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addNarrowingToCbAllSigleBoll);


	/// arricchimento di base per guigen::TextField [tfAllNumBoll]
	var addBasicEnrichmentToTfAllNumBoll =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAllNumBoll',
			 	false,
			 	'it.csi.sigit.sigitwebn.dto.common.UDTPositiveInteger',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addBasicEnrichmentToTfAllNumBoll);
	/// arricchimento per guigen::ComboBox [cbElencoCat]: autonarrowing
	var addNarrowingToCbElencoCat =
		function(){
			uiNRichLib.addComboNarrowingNRich(
				'widg_cbElencoCat',
			 	true);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTabAllPanel", addNarrowingToCbElencoCat);



	/// arricchimento di base per guigen::TextField [tfRespCodFis]
	var addBasicEnrichmentToTfRespCodFis =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespCodFis',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTerzoResp", addBasicEnrichmentToTfRespCodFis);
	/// arricchimento di base per guigen::TextField [tfRespDataInsGG]
	var addBasicEnrichmentToTfRespDataInsGG =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespDataInsGG',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTerzoResp", addBasicEnrichmentToTfRespDataInsGG);
	/// arricchimento di base per guigen::TextField [tfRespDataRevGG]
	var addBasicEnrichmentToTfRespDataRevGG =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRespDataRevGG',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTerzoResp", addBasicEnrichmentToTfRespDataRevGG);
	/// arricchimento per guigen::Calendar [clRespDatInizContrDa]: aggiunta datepicker
	var addDateToClRespDatInizContrDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clRespDatInizContrDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTerzoResp", addDateToClRespDatInizContrDa);
	/// arricchimento per guigen::Calendar [clRespDatInizContrA]: aggiunta datepicker
	var addDateToClRespDatInizContrA = function(){
		uiNRichLib.addDatePickerNRich("widg_clRespDatInizContrA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTerzoResp", addDateToClRespDatInizContrA);
	/// arricchimento per guigen::Calendar [clRespDatFineContrDa]: aggiunta datepicker
	var addDateToClRespDatFineContrDa = function(){
		uiNRichLib.addDatePickerNRich("widg_clRespDatFineContrDa", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTerzoResp", addDateToClRespDatFineContrDa);
	/// arricchimento per guigen::Calendar [clRespDatFineContrA]: aggiunta datepicker
	var addDateToClRespDatFineContrA = function(){
		uiNRichLib.addDatePickerNRich("widg_clRespDatFineContrA", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTerzoResp", addDateToClRespDatFineContrA);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicAvzImpianto(){
/*PROTECTED REGION ID(R-1023554931) ENABLED START*/
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

function initUIStructCpRicAvzImpianto(){
	var contentPanelName = "cpRicAvzImpianto";
	var structure =
      {
        name: "p_fpRicAvzImpiantoG", panels: [
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
          name: "p_fpCenterRicAvz", panels: [
          {
            name: "p_fpTitleRicAvz", panels: [
            ]
          }
,          {
            name: "p_fpRicImpianto", panels: [
            {
              name: "p_stdMsgPRicAvzImp", panels: [
              ]
            }
,            {
              name: "p_udpMappa", panels: [
              ]
            }
,            {
              name: "p_wpImpianto", panels: []
            }
,            {
              name: "p_wpImpresa", panels: []
            }
,            {
              name: "p_wpRicAvzGen", panels: []
            }
,            {
              name: "p_tsRicAvz", panels: [
              {
                name: "p_fpTabRicAvz", panels: [
                {
                  name: "p_wpTabCompPanel", panels: []
                }
,                {
                  name: "p_cpFunRicImpianto", panels: []
                }
                ]
              }
,              {
                name: "p_fpRicAvzAll", panels: [
                {
                  name: "p_wpRicAvzRee", panels: []
                }
,                {
                  name: "p_wpTabAllPanel", panels: []
                }
,                {
                  name: "p_cpFunRicAvzImpiantoAll", panels: []
                }
                ]
              }
,              {
                name: "p_fpRicAvz3Resp", panels: [
                {
                  name: "p_wpTerzoResp", panels: []
                }
,                {
                  name: "p_cpFunRicAvzImpiantoResp", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_cpNavRicImpianto", panels: []
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

	initStdEnrichments4CpRicAvzImpianto();
	initCustomEnrichments4CpRicAvzImpianto();
	initUIStructCpRicAvzImpianto();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicAvzImpianto");

});



