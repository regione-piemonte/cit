<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fmDettImpresa" class="formPanelBlock"><!-- startFragment:p_fmDettImpresa -->
		
	
<div class="formPanel" id="fmDettImpresa">


	
	

	
	
			
	
	<div id="p_wpDettImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpDettImpresa -->
	
	
<h4 class="wpLabel">Dati impresa </h4>
<div class="widgetsPanel" id="wpDettImpresa">
	
	<customtag:widgetsPanel id="wpDettImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','cbSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbSiglaRea.label')}" labelFor="widg_cbSiglaRea" errorFor="appDataimpresa.siglaRea" labelId="cbSiglaReaLbl"
	position="first"  >


<!-- widget cbSiglaRea -->
<s:select name="appDataimpresa.siglaRea" id="widg_cbSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestImpresa','cbSiglaRea')"
	  listKey="code"
	  listValue="code"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfNumeroRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfNumeroRea.label')}" labelFor="widg_tfNumeroRea" errorFor="appDataimpresa.numeroRea" labelId="tfNumeroReaLbl"
	position="last"  >


<!-- widget tfNumeroRea -->
<s:textfield 
	
	
	name="appDataimpresa.numeroRea" id="widg_tfNumeroRea"
maxlength="11"	disabled="isWidgetDisabled('cpGestImpresa','tfNumeroRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaDenominazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaDenominazione.label')}" labelFor="widg_tfImpresaDenominazione" errorFor="appDataimpresa.denominazione" labelId="tfImpresaDenominazioneLbl"
	position="first"  >


<!-- widget tfImpresaDenominazione -->
<s:textfield 
	
	
	name="appDataimpresa.denominazione" id="widg_tfImpresaDenominazione"
maxlength="500"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaDenominazione')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaCfPi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaCfPi.label')}" labelFor="widg_tfImpresaCfPi" errorFor="appDataimpresa.codiceFiscale" labelId="tfImpresaCfPiLbl"
	position="last"  >


<!-- widget tfImpresaCfPi -->
<s:textfield 
	
	
	name="appDataimpresa.codiceFiscale" id="widg_tfImpresaCfPi"
maxlength="16"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaCfPi')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbStatoImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbStatoImpresa.label')}" labelFor="widg_cbStatoImpresa" errorFor="appDataimpresa.idStatoPg" labelId="cbStatoImpresaLbl"
	position="first"  >


<!-- widget cbStatoImpresa -->
	<csiuicore:ajaxify id="p_wpDettImpresa" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impresa/cpGestImpresa!handleCbStatoImpresa_VALUE_CHANGED.do"
		pageId="cpGestImpresa"
		formName="cpGestImpresa"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impresa">

<s:url id="widg_cbStatoImpresaurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpresa!handleCbStatoImpresa_VALUE_CHANGED" namespace="/base/gestisci_impresa"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataimpresa.idStatoPg" id="widg_cbStatoImpresa"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoImp"
	  disabled="isWidgetDisabled('cpGestImpresa','cbStatoImpresa')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbStatoImpresa','conferma','%{widg_cbStatoImpresaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbStatoImpresa','conferma','%{widg_cbStatoImpresaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettImpresa_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','clImpresaDataInizioAttivita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.clImpresaDataInizioAttivita.label')}" labelFor="widg_clImpresaDataInizioAttivita" errorFor="appDataimpresa.dataInizioAttivita" labelId="clImpresaDataInizioAttivitaLbl"
	position="first"  >


<!-- widget clImpresaDataInizioAttivita -->
<s:textfield 
	
	
	name="appDataimpresa.dataInizioAttivita" id="widg_clImpresaDataInizioAttivita"
	disabled="isWidgetDisabled('cpGestImpresa','clImpresaDataInizioAttivita')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','clImpresaDataCessazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.clImpresaDataCessazione.label')}" labelFor="widg_clImpresaDataCessazione" errorFor="appDataimpresa.dataCessazione" labelId="clImpresaDataCessazioneLbl"
	position="last"  >


<!-- widget clImpresaDataCessazione -->
<s:textfield 
	
	
	name="appDataimpresa.dataCessazione" id="widg_clImpresaDataCessazione"
	disabled="isWidgetDisabled('cpGestImpresa','clImpresaDataCessazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','clImpresaDataVariazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.clImpresaDataVariazione.label')}" labelFor="widg_clImpresaDataVariazione" errorFor="appDataimpresa.dataVariazione" labelId="clImpresaDataVariazioneLbl"
	position="first"  >


<!-- widget clImpresaDataVariazione -->
<s:textfield 
	
	
	name="appDataimpresa.dataVariazione" id="widg_clImpresaDataVariazione"
	disabled="isWidgetDisabled('cpGestImpresa','clImpresaDataVariazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaMotivVar')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaMotivVar.label')}" labelFor="widg_tfImpresaMotivVar" errorFor="appDataimpresa.motivoVariazione" labelId="tfImpresaMotivVarLbl"
	position="last"  >


<!-- widget tfImpresaMotivVar -->
<s:textfield 
	
	
	name="appDataimpresa.motivoVariazione" id="widg_tfImpresaMotivVar"
maxlength="500"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaMotivVar')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaIndirizzoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaIndirizzoEst.label')}" labelFor="widg_cbImpresaIndirizzoEst" errorFor="appDataimpresa.flgIndirizzoEst" labelId="cbImpresaIndirizzoEstLbl"
	position="first"  >


<!-- widget cbImpresaIndirizzoEst -->
<s:checkbox 
	
	
	name="appDataimpresa.flgIndirizzoEst" id="widg_cbImpresaIndirizzoEst"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaIndirizzoEst')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitwebn/base/gestisci_impresa/cpGestImpresa!handleCbImpresaIndirizzoEst_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaIndirizzoEst')" >
	<s:hidden name="__checkbox_appDataimpresa.flgIndirizzoEst" id="__checkbox_widg_cbImpresaIndirizzoEst" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettImpresa_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaProvincia.label')}" labelFor="widg_cbImpresaProvincia" errorFor="appDataimpresa.idProvinciaSelez" labelId="cbImpresaProvinciaLbl"
	position="first"  >


<!-- widget cbImpresaProvincia -->
	<csiuicore:ajaxify id="p_wpDettImpresa" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impresa/cpGestImpresa!handleCbImpresaProvincia_VALUE_CHANGED.do"
		pageId="cpGestImpresa"
		formName="cpGestImpresa"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impresa">

<s:url id="widg_cbImpresaProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpresa!handleCbImpresaProvincia_VALUE_CHANGED" namespace="/base/gestisci_impresa"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataimpresa.idProvinciaSelez" id="widg_cbImpresaProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvince"
	  disabled="isWidgetDisabled('cpGestImpresa','cbImpresaProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbImpresaProvincia','conferma','%{widg_cbImpresaProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbImpresaProvincia','conferma','%{widg_cbImpresaProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaComune.label')}" labelFor="widg_cbImpresaComune" errorFor="appDataimpresa.idComuneSelez" labelId="cbImpresaComuneLbl"
	position="last"  >


<!-- widget cbImpresaComune -->
<s:select name="appDataimpresa.idComuneSelez" id="widg_cbImpresaComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpGestImpresa','cbImpresaComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','btImpresaIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.btImpresaIndirizzo.label')}" labelFor="widg_btImpresaIndirizzo" errorFor="appDataimpresa.indirizzo" labelId="btImpresaIndirizzoLbl"
	position="first"  >


<!-- widget btImpresaIndirizzo -->
<s:textfield 
	
	
	name="appDataimpresa.indirizzo" id="widg_btImpresaIndirizzo"
	disabled="isWidgetDisabled('cpGestImpresa','btImpresaIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','btImpresaCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btImpresaCercaIndirizzo -->
<s:submit name="widg_btImpresaCercaIndirizzo" id="widg_btImpresaCercaIndirizzo" method="handleBtImpresaCercaIndirizzo_CLICKED"
	key="cpGestImpresa.btImpresaCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btImpresaCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaIndirizzo.label')}" labelFor="widg_cbImpresaIndirizzo" errorFor="appDataimpresa.idIndirizzoSel" labelId="cbImpresaIndirizzoLbl"
	position="first"  >


<!-- widget cbImpresaIndirizzo -->
<s:select name="appDataimpresa.idIndirizzoSel" id="widg_cbImpresaIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziImp"
	  disabled="isWidgetDisabled('cpGestImpresa','cbImpresaIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','btImpresaNuovaRicerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btImpresaNuovaRicerca -->
<s:submit name="widg_btImpresaNuovaRicerca" id="widg_btImpresaNuovaRicerca" method="handleBtImpresaNuovaRicerca_CLICKED"
	key="cpGestImpresa.btImpresaNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btImpresaNuovaRicerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaNonTrovato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaNonTrovato.label')}" labelFor="widg_tfImpresaNonTrovato" errorFor="appDataimpresa.indirizzoNonTrovato" labelId="tfImpresaNonTrovatoLbl"
	position="first"  >


<!-- widget tfImpresaNonTrovato -->
<s:textfield 
	
	
	name="appDataimpresa.indirizzoNonTrovato" id="widg_tfImpresaNonTrovato"
	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaNonTrovato')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettImpresa_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaCivico.label')}" labelFor="widg_tfImpresaCivico" errorFor="appDataimpresa.civico" labelId="tfImpresaCivicoLbl"
	position="first"  >


<!-- widget tfImpresaCivico -->
<s:textfield 
	
	
	name="appDataimpresa.civico" id="widg_tfImpresaCivico"
	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaCivico')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaCap.label')}" labelFor="widg_tfImpresaCap" errorFor="appDataimpresa.cap" labelId="tfImpresaCapLbl"
	position="last"  >


<!-- widget tfImpresaCap -->
<s:textfield 
	
	
	name="appDataimpresa.cap" id="widg_tfImpresaCap"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaCap')"
	size="30" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaEstStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaEstStato.label')}" labelFor="widg_tfImpresaEstStato" errorFor="appDataimpresa.estStato" labelId="tfImpresaEstStatoLbl"
	position="first"  >


<!-- widget tfImpresaEstStato -->
<s:textfield 
	
	
	name="appDataimpresa.estStato" id="widg_tfImpresaEstStato"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaEstStato')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaEstCitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaEstCitta.label')}" labelFor="widg_tfImpresaEstCitta" errorFor="appDataimpresa.estCitta" labelId="tfImpresaEstCittaLbl"
	position="last"  >


<!-- widget tfImpresaEstCitta -->
<s:textfield 
	
	
	name="appDataimpresa.estCitta" id="widg_tfImpresaEstCitta"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaEstCitta')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaEstIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaEstIndirizzo.label')}" labelFor="widg_tfImpresaEstIndirizzo" errorFor="appDataimpresa.estIndirizzo" labelId="tfImpresaEstIndirizzoLbl"
	position="first"  >


<!-- widget tfImpresaEstIndirizzo -->
<s:textfield 
	
	
	name="appDataimpresa.estIndirizzo" id="widg_tfImpresaEstIndirizzo"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaEstIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettImpresa_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaEstCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaEstCivico.label')}" labelFor="widg_tfImpresaEstCivico" errorFor="appDataimpresa.civico" labelId="tfImpresaEstCivicoLbl"
	position="first"  >


<!-- widget tfImpresaEstCivico -->
<s:textfield 
	
	
	name="appDataimpresa.civico" id="widg_tfImpresaEstCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaEstCivico')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaEstCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaEstCap.label')}" labelFor="widg_tfImpresaEstCap" errorFor="appDataimpresa.estCap" labelId="tfImpresaEstCapLbl"
	position="last"  >


<!-- widget tfImpresaEstCap -->
<s:textfield 
	
	
	name="appDataimpresa.estCap" id="widg_tfImpresaEstCap"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaEstCap')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpresaEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpresaEmail.label')}" labelFor="widg_tfImpresaEmail" errorFor="appDataimpresa.email" labelId="tfImpresaEmailLbl"
	position="first"  >


<!-- widget tfImpresaEmail -->
<s:textfield 
	
	
	name="appDataimpresa.email" id="widg_tfImpresaEmail"
	disabled="isWidgetDisabled('cpGestImpresa','tfImpresaEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','btImpresaVerificaEmail')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btImpresaVerificaEmail -->
<s:submit name="widg_btImpresaVerificaEmail" id="widg_btImpresaVerificaEmail" method="handleBtImpresaVerificaEmail_CLICKED"
	key="cpGestImpresa.btImpresaVerificaEmail.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btImpresaVerificaEmail')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfPec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfPec.label')}" labelFor="widg_tfPec" errorFor="appDataimpresa.pec" labelId="tfPecLbl"
	position="first"  >


<!-- widget tfPec -->
<s:textfield 
	
	
	name="appDataimpresa.pec" id="widg_tfPec"
	disabled="isWidgetDisabled('cpGestImpresa','tfPec')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_16_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettImpresa_16_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfTelefono.label')}" labelFor="widg_tfTelefono" errorFor="appDataimpresa.telefono" labelId="tfTelefonoLbl"
	position="first"  >


<!-- widget tfTelefono -->
<s:textfield 
	
	
	name="appDataimpresa.telefono" id="widg_tfTelefono"
	disabled="isWidgetDisabled('cpGestImpresa','tfTelefono')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_17_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettImpresa_17_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_18_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpDettImpresa_18_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpDettImpresa_18_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDettImpresa_18_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettImpresa --></div>

			
	
	<div id="p_wpAbilImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpAbilImpresa -->
	
	
<h4 class="wpLabel">Si dichiara che l'impresa &#233; abilitata ad operare sugli impianti di climatizzazione invernale/estiva ed &#233; abilitata ai sensi del DM 37/08, art.1 alle seguenti lettere: </h4>
<div class="widgetsPanel" id="wpAbilImpresa">
	
	<customtag:widgetsPanel id="wpAbilImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaDm37LetteraC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaDm37LetteraC.label')}" labelFor="widg_cbImpresaDm37LetteraC" errorFor="appDataimpresa.flgDm37LetteraC" labelId="cbImpresaDm37LetteraCLbl"
	position="first"  >


<!-- widget cbImpresaDm37LetteraC -->
<s:checkbox 
	
	
	name="appDataimpresa.flgDm37LetteraC" id="widg_cbImpresaDm37LetteraC"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaDm37LetteraC')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaDm37LetteraC')" >
	<s:hidden name="__checkbox_appDataimpresa.flgDm37LetteraC" id="__checkbox_widg_cbImpresaDm37LetteraC" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaDm37LetteraD')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaDm37LetteraD.label')}" labelFor="widg_cbImpresaDm37LetteraD" errorFor="appDataimpresa.flgDm37LetteraD" labelId="cbImpresaDm37LetteraDLbl"
	position="last"  >


<!-- widget cbImpresaDm37LetteraD -->
<s:checkbox 
	
	
	name="appDataimpresa.flgDm37LetteraD" id="widg_cbImpresaDm37LetteraD"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaDm37LetteraD')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaDm37LetteraD')" >
	<s:hidden name="__checkbox_appDataimpresa.flgDm37LetteraD" id="__checkbox_widg_cbImpresaDm37LetteraD" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaDm37LetteraE')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaDm37LetteraE.label')}" labelFor="widg_cbImpresaDm37LetteraE" errorFor="appDataimpresa.flgDm37LetteraE" labelId="cbImpresaDm37LetteraELbl"
	position="first"  >


<!-- widget cbImpresaDm37LetteraE -->
<s:checkbox 
	
	
	name="appDataimpresa.flgDm37LetteraE" id="widg_cbImpresaDm37LetteraE"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaDm37LetteraE')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaDm37LetteraE')" >
	<s:hidden name="__checkbox_appDataimpresa.flgDm37LetteraE" id="__checkbox_widg_cbImpresaDm37LetteraE" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpAbilImpresa_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAbilImpresa_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAbilImpresa --></div>

			
	
	<div id="p_wpAbilAltroImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpAbilAltroImpresa -->
	
	
<h4 class="wpLabel">Si dichiara inoltre che l'impresa: </h4>
<div class="widgetsPanel" id="wpAbilAltroImpresa">
	
	<customtag:widgetsPanel id="wpAbilAltroImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaFGas')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaFGas.label')}" labelFor="widg_cbImpresaFGas" errorFor="appDataimpresa.flgFGas" labelId="cbImpresaFGasLbl"
	position="first"  >


<!-- widget cbImpresaFGas -->
<s:checkbox 
	
	
	name="appDataimpresa.flgFGas" id="widg_cbImpresaFGas"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaFGas')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaFGas')" >
	<s:hidden name="__checkbox_appDataimpresa.flgFGas" id="__checkbox_widg_cbImpresaFGas" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaConduttore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaConduttore.label')}" labelFor="widg_cbImpresaConduttore" errorFor="appDataimpresa.flgConduttore" labelId="cbImpresaConduttoreLbl"
	position="last"  >


<!-- widget cbImpresaConduttore -->
<s:checkbox 
	
	
	name="appDataimpresa.flgConduttore" id="widg_cbImpresaConduttore"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaConduttore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaConduttore')" >
	<s:hidden name="__checkbox_appDataimpresa.flgConduttore" id="__checkbox_widg_cbImpresaConduttore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaTerzoResponsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaTerzoResponsabile.label')}" labelFor="widg_cbImpresaTerzoResponsabile" errorFor="appDataimpresa.flgTerzoResponsabile" labelId="cbImpresaTerzoResponsabileLbl"
	position="first"  >


<!-- widget cbImpresaTerzoResponsabile -->
<s:checkbox 
	
	
	name="appDataimpresa.flgTerzoResponsabile" id="widg_cbImpresaTerzoResponsabile"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaTerzoResponsabile')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaTerzoResponsabile')" >
	<s:hidden name="__checkbox_appDataimpresa.flgTerzoResponsabile" id="__checkbox_widg_cbImpresaTerzoResponsabile" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaSoggDelegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaSoggDelegato.label')}" labelFor="widg_cbImpresaSoggDelegato" errorFor="appDataimpresa.flgCat" labelId="cbImpresaSoggDelegatoLbl"
	position="last"  >


<!-- widget cbImpresaSoggDelegato -->
<s:checkbox 
	
	
	name="appDataimpresa.flgCat" id="widg_cbImpresaSoggDelegato"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaSoggDelegato')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaSoggDelegato')" >
	<s:hidden name="__checkbox_appDataimpresa.flgCat" id="__checkbox_widg_cbImpresaSoggDelegato" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaDistributore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaDistributore.label')}" labelFor="widg_cbImpresaDistributore" errorFor="appDataimpresa.flgDistributore" labelId="cbImpresaDistributoreLbl"
	position="first"  >


<!-- widget cbImpresaDistributore -->
<s:checkbox 
	
	
	name="appDataimpresa.flgDistributore" id="widg_cbImpresaDistributore"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaDistributore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaDistributore')" >
	<s:hidden name="__checkbox_appDataimpresa.flgDistributore" id="__checkbox_widg_cbImpresaDistributore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpAbilAltroImpresa_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAbilAltroImpresa_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAbilAltroImpresa --></div>

			
	
	<div id="p_wpAbilImpresaInQualitaDi" class="widgetsPanelBlock"><!-- startFragment:p_wpAbilImpresaInQualitaDi -->
	
	
<h4 class="wpLabel">La presente dichiarazione &#233; resa in qualit&#225; di: </h4>
<div class="widgetsPanel" id="wpAbilImpresaInQualitaDi">
	
	<customtag:widgetsPanel id="wpAbilImpresaInQualitaDiTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaAmministratore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaAmministratore.label')}" labelFor="widg_cbImpresaAmministratore" errorFor="appDataimpresa.flgAmministratore" labelId="cbImpresaAmministratoreLbl"
	position="first"  >


<!-- widget cbImpresaAmministratore -->
<s:checkbox 
	
	
	name="appDataimpresa.flgAmministratore" id="widg_cbImpresaAmministratore"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaAmministratore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaAmministratore')" >
	<s:hidden name="__checkbox_appDataimpresa.flgAmministratore" id="__checkbox_widg_cbImpresaAmministratore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpresaSoggIncaricato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpresaSoggIncaricato.label')}" labelFor="widg_cbImpresaSoggIncaricato" errorFor="appDataimpresa.flgSoggIncaricato" labelId="cbImpresaSoggIncaricatoLbl"
	  >


<!-- widget cbImpresaSoggIncaricato -->
<s:checkbox 
	
	
	name="appDataimpresa.flgSoggIncaricato" id="widg_cbImpresaSoggIncaricato"
	disabled="isWidgetDisabled('cpGestImpresa','cbImpresaSoggIncaricato')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpresa','cbImpresaSoggIncaricato')" >
	<s:hidden name="__checkbox_appDataimpresa.flgSoggIncaricato" id="__checkbox_widg_cbImpresaSoggIncaricato" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfSoggIncaricato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfSoggIncaricato" errorFor="appDataimpresa.delegaSoggIncaricato" labelId="tfSoggIncaricatoLbl"
	position="last"  >


<!-- widget tfSoggIncaricato -->
<s:textfield 
	
	
	name="appDataimpresa.delegaSoggIncaricato" id="widg_tfSoggIncaricato"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpresa','tfSoggIncaricato')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAbilImpresaInQualitaDi --></div>

			
	
	<div id="p_cpDettImpresa" class="commandPanelBlock"><!-- startFragment:p_cpDettImpresa -->
	
	
<div class="commandPanel functional" id="cpDettImpresa">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpresa','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpGestImpresa.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestImpresa','btSalvaImpresa')" >

	



<!-- widget btSalvaImpresa -->
<s:submit name="widg_btSalvaImpresa" id="widg_btSalvaImpresa" method="handleBtSalvaImpresa_CLICKED"
	key="cpGestImpresa.btSalvaImpresa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btSalvaImpresa')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDettImpresa --></div>

	

		
	
</div>

	<!-- endFragment:p_fmDettImpresa --></div>
