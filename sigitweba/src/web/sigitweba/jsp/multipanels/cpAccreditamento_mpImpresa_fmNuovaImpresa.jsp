<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fmNuovaImpresa" class="formPanelBlock"><!-- startFragment:p_fmNuovaImpresa -->
		
	
<div class="formPanel" id="fmNuovaImpresa">


	
	

	
	
			
	
	<div id="p_wpNuovaImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpNuovaImpresa -->
	
	
<h4 class="wpLabel">Dati impresa </h4>
<div class="widgetsPanel" id="wpNuovaImpresa">
	
	<customtag:widgetsPanel id="wpNuovaImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','cbSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbSiglaRea.label')}" labelFor="widg_cbSiglaRea" errorFor="appDatapersonaGiuridica.siglaRea" labelId="cbSiglaReaLbl"
	position="first"  >


<!-- widget cbSiglaRea -->
<s:select name="appDatapersonaGiuridica.siglaRea" id="widg_cbSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSigleRea"
	  disabled="isWidgetDisabled('cpAccreditamento','cbSiglaRea')"
	  listKey="code"
	  listValue="code"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfNumeroRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfNumeroRea.label')}" labelFor="widg_tfNumeroRea" errorFor="appDatapersonaGiuridica.numeroRea" labelId="tfNumeroReaLbl"
	position="last"  >


<!-- widget tfNumeroRea -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.numeroRea" id="widg_tfNumeroRea"
maxlength="11"	disabled="isWidgetDisabled('cpAccreditamento','tfNumeroRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaDenominazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaDenominazione.label')}" labelFor="widg_tfImpresaDenominazione" errorFor="appDatapersonaGiuridica.denominazione" labelId="tfImpresaDenominazioneLbl"
	position="first"  >


<!-- widget tfImpresaDenominazione -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.denominazione" id="widg_tfImpresaDenominazione"
maxlength="500"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaDenominazione')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaCfPi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaCfPi.label')}" labelFor="widg_tfImpresaCfPi" errorFor="appDatapersonaGiuridica.codiceFiscale" labelId="tfImpresaCfPiLbl"
	position="last"  >


<!-- widget tfImpresaCfPi -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.codiceFiscale" id="widg_tfImpresaCfPi"
maxlength="16"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaCfPi')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','ptStatoImpresa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpAccreditamento.ptStatoImpresa.label')}" labelFor="widg_ptStatoImpresa" errorFor="appDatapersonaGiuridica.descStatoPg" labelId="ptStatoImpresaLbl"  position="first" >


<!-- widget ptStatoImpresa -->
<s:property value="appDatapersonaGiuridica.descStatoPg" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','clImpresaDataInizioAttivita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.clImpresaDataInizioAttivita.label')}" labelFor="widg_clImpresaDataInizioAttivita" errorFor="appDatapersonaGiuridica.dataInizioAttivita" labelId="clImpresaDataInizioAttivitaLbl"
	position="first"  >


<!-- widget clImpresaDataInizioAttivita -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.dataInizioAttivita" id="widg_clImpresaDataInizioAttivita"
	disabled="isWidgetDisabled('cpAccreditamento','clImpresaDataInizioAttivita')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','clImpresaDataCessazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.clImpresaDataCessazione.label')}" labelFor="widg_clImpresaDataCessazione" errorFor="appDatapersonaGiuridica.dataCessazione" labelId="clImpresaDataCessazioneLbl"
	position="last"  >


<!-- widget clImpresaDataCessazione -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.dataCessazione" id="widg_clImpresaDataCessazione"
	disabled="isWidgetDisabled('cpAccreditamento','clImpresaDataCessazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaIndirizzoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaIndirizzoEst.label')}" labelFor="widg_cbImpresaIndirizzoEst" errorFor="appDatapersonaGiuridica.flgIndirizzoEst" labelId="cbImpresaIndirizzoEstLbl"
	position="first"  >


<!-- widget cbImpresaIndirizzoEst -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgIndirizzoEst" id="widg_cbImpresaIndirizzoEst"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaIndirizzoEst')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitweba/base/accreditamento_module/cpAccreditamento!handleCbImpresaIndirizzoEst_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaIndirizzoEst')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgIndirizzoEst" id="__checkbox_widg_cbImpresaIndirizzoEst" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaProvincia.label')}" labelFor="widg_cbImpresaProvincia" errorFor="appDatapersonaGiuridica.idProvinciaSelez" labelId="cbImpresaProvinciaLbl"
	position="first"  >


<!-- widget cbImpresaProvincia -->
	<csiuicore:ajaxify id="p_wpNuovaImpresa" 
		widgetType="combo" 
		requestUri="/sigitweba/base/accreditamento_module/cpAccreditamento!handleCbImpresaProvincia_VALUE_CHANGED.do"
		pageId="cpAccreditamento"
		formName="cpAccreditamento"
		javascriptDetection="false"
		nameSpace="/base/accreditamento_module">

<s:url id="widg_cbImpresaProvinciaurlComboBoxValueChange"
   action="/sigitweba/cpAccreditamento!handleCbImpresaProvincia_VALUE_CHANGED" namespace="/base/accreditamento_module"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatapersonaGiuridica.idProvinciaSelez" id="widg_cbImpresaProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvinceIT"
	  disabled="isWidgetDisabled('cpAccreditamento','cbImpresaProvincia')"
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


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaComune.label')}" labelFor="widg_cbImpresaComune" errorFor="appDatapersonaGiuridica.idComuneSelez" labelId="cbImpresaComuneLbl"
	position="last"  >


<!-- widget cbImpresaComune -->
<s:select name="appDatapersonaGiuridica.idComuneSelez" id="widg_cbImpresaComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniPG"
	  disabled="isWidgetDisabled('cpAccreditamento','cbImpresaComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','btImpresaIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.btImpresaIndirizzo.label')}" labelFor="widg_btImpresaIndirizzo" errorFor="appDatapersonaGiuridica.indirizzo" labelId="btImpresaIndirizzoLbl"
	position="first"  >


<!-- widget btImpresaIndirizzo -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.indirizzo" id="widg_btImpresaIndirizzo"
	disabled="isWidgetDisabled('cpAccreditamento','btImpresaIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','btImpresaCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btImpresaCercaIndirizzo -->
<s:submit name="widg_btImpresaCercaIndirizzo" id="widg_btImpresaCercaIndirizzo" method="handleBtImpresaCercaIndirizzo_CLICKED"
	key="cpAccreditamento.btImpresaCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btImpresaCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaIndirizzo.label')}" labelFor="widg_cbImpresaIndirizzo" errorFor="appDatapersonaGiuridica.idIndirizzoSel" labelId="cbImpresaIndirizzoLbl"
	position="first"  >


<!-- widget cbImpresaIndirizzo -->
<s:select name="appDatapersonaGiuridica.idIndirizzoSel" id="widg_cbImpresaIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziPG"
	  disabled="isWidgetDisabled('cpAccreditamento','cbImpresaIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','btImpresaNuovaRicerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btImpresaNuovaRicerca -->
<s:submit name="widg_btImpresaNuovaRicerca" id="widg_btImpresaNuovaRicerca" method="handleBtImpresaNuovaRicerca_CLICKED"
	key="cpAccreditamento.btImpresaNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btImpresaNuovaRicerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaNonTrovato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaNonTrovato.label')}" labelFor="widg_tfImpresaNonTrovato" errorFor="appDatapersonaGiuridica.indirizzoNonTrovato" labelId="tfImpresaNonTrovatoLbl"
	position="first"  >


<!-- widget tfImpresaNonTrovato -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.indirizzoNonTrovato" id="widg_tfImpresaNonTrovato"
	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaNonTrovato')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaCivico.label')}" labelFor="widg_tfImpresaCivico" errorFor="appDatapersonaGiuridica.civico" labelId="tfImpresaCivicoLbl"
	position="first"  >


<!-- widget tfImpresaCivico -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.civico" id="widg_tfImpresaCivico"
	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaCivico')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaCap.label')}" labelFor="widg_tfImpresaCap" errorFor="appDatapersonaGiuridica.cap" labelId="tfImpresaCapLbl"
	position="last"  >


<!-- widget tfImpresaCap -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.cap" id="widg_tfImpresaCap"
maxlength="5"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaCap')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaEstStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaEstStato.label')}" labelFor="widg_tfImpresaEstStato" errorFor="appDatapersonaGiuridica.estStato" labelId="tfImpresaEstStatoLbl"
	position="first"  >


<!-- widget tfImpresaEstStato -->
<s:textfield 
	
title=""	
	name="appDatapersonaGiuridica.estStato" id="widg_tfImpresaEstStato"
maxlength="50"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaEstStato')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaEstCitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaEstCitta.label')}" labelFor="widg_tfImpresaEstCitta" errorFor="appDatapersonaGiuridica.estCitta" labelId="tfImpresaEstCittaLbl"
	position="last"  >


<!-- widget tfImpresaEstCitta -->
<s:textfield 
	
title=""	
	name="appDatapersonaGiuridica.estCitta" id="widg_tfImpresaEstCitta"
maxlength="50"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaEstCitta')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaEstIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaEstIndirizzo.label')}" labelFor="widg_tfImpresaEstIndirizzo" errorFor="appDatapersonaGiuridica.estIndirizzo" labelId="tfImpresaEstIndirizzoLbl"
	position="first"  >


<!-- widget tfImpresaEstIndirizzo -->
<s:textfield 
	
title=""	
	name="appDatapersonaGiuridica.estIndirizzo" id="widg_tfImpresaEstIndirizzo"
maxlength="100"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaEstIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaEstCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaEstCivico.label')}" labelFor="widg_tfImpresaEstCivico" errorFor="appDatapersonaGiuridica.civico" labelId="tfImpresaEstCivicoLbl"
	position="first"  >


<!-- widget tfImpresaEstCivico -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.civico" id="widg_tfImpresaEstCivico"
maxlength="10"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaEstCivico')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaEstCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaEstCap.label')}" labelFor="widg_tfImpresaEstCap" errorFor="appDatapersonaGiuridica.estCap" labelId="tfImpresaEstCapLbl"
	position="last"  >


<!-- widget tfImpresaEstCap -->
<s:textfield 
	
title=""	
	name="appDatapersonaGiuridica.estCap" id="widg_tfImpresaEstCap"
maxlength="10"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaEstCap')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaEmail.label')}" labelFor="widg_tfImpresaEmail" errorFor="appDatapersonaGiuridica.email" labelId="tfImpresaEmailLbl"
	position="first"  >


<!-- widget tfImpresaEmail -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.email" id="widg_tfImpresaEmail"
	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','btImpresaVerificaEmail')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btImpresaVerificaEmail -->
<s:submit name="widg_btImpresaVerificaEmail" id="widg_btImpresaVerificaEmail" method="handleBtImpresaVerificaEmail_CLICKED"
	key="cpAccreditamento.btImpresaVerificaEmail.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btImpresaVerificaEmail')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaPec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaPec.label')}" labelFor="widg_tfImpresaPec" errorFor="appDatapersonaGiuridica.pec" labelId="tfImpresaPecLbl"
	position="first"  >


<!-- widget tfImpresaPec -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.pec" id="widg_tfImpresaPec"
	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaPec')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_15_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_15_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfImpresaTelefono.label')}" labelFor="widg_tfImpresaTelefono" errorFor="appDatapersonaGiuridica.telefono" labelId="tfImpresaTelefonoLbl"
	position="first"  >


<!-- widget tfImpresaTelefono -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.telefono" id="widg_tfImpresaTelefono"
	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaTelefono')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_16_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_16_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_17_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpNuovaImpresa_17_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_17_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_17_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_18_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpNuovaImpresa_18_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_18_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_18_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_19_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpNuovaImpresa_19_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpNuovaImpresa_19_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpNuovaImpresa_19_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpNuovaImpresa --></div>

			
	
	<div id="p_wpAbilImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpAbilImpresa -->
	
	
<h4 class="wpLabel">Si dichiara che l'impresa &#233; abilitata ad operare sugli impianti di climatizzazione invernale/estiva ed &#233; abilitata ai sensi del DM 37/08, art.1 alle seguenti lettere: </h4>
<div class="widgetsPanel" id="wpAbilImpresa">
	
	<customtag:widgetsPanel id="wpAbilImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaDm37LetteraC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaDm37LetteraC.label')}" labelFor="widg_cbImpresaDm37LetteraC" errorFor="appDatapersonaGiuridica.flgDm37LetteraC" labelId="cbImpresaDm37LetteraCLbl"
	position="first"  >


<!-- widget cbImpresaDm37LetteraC -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgDm37LetteraC" id="widg_cbImpresaDm37LetteraC"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaDm37LetteraC')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaDm37LetteraC')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgDm37LetteraC" id="__checkbox_widg_cbImpresaDm37LetteraC" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaDm37LetteraD')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaDm37LetteraD.label')}" labelFor="widg_cbImpresaDm37LetteraD" errorFor="appDatapersonaGiuridica.flgDm37LetteraD" labelId="cbImpresaDm37LetteraDLbl"
	position="last"  >


<!-- widget cbImpresaDm37LetteraD -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgDm37LetteraD" id="widg_cbImpresaDm37LetteraD"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaDm37LetteraD')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaDm37LetteraD')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgDm37LetteraD" id="__checkbox_widg_cbImpresaDm37LetteraD" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaDm37LetteraE')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaDm37LetteraE.label')}" labelFor="widg_cbImpresaDm37LetteraE" errorFor="appDatapersonaGiuridica.flgDm37LetteraE" labelId="cbImpresaDm37LetteraELbl"
	position="first"  >


<!-- widget cbImpresaDm37LetteraE -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgDm37LetteraE" id="widg_cbImpresaDm37LetteraE"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaDm37LetteraE')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaDm37LetteraE')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgDm37LetteraE" id="__checkbox_widg_cbImpresaDm37LetteraE" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAbilImpresa_2_2_fictitious_')" >

	
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
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaFGas')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaFGas.label')}" labelFor="widg_cbImpresaFGas" errorFor="appDatapersonaGiuridica.flgFGas" labelId="cbImpresaFGasLbl"
	position="first"  >


<!-- widget cbImpresaFGas -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgFGas" id="widg_cbImpresaFGas"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaFGas')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaFGas')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgFGas" id="__checkbox_widg_cbImpresaFGas" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaConduttore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaConduttore.label')}" labelFor="widg_cbImpresaConduttore" errorFor="appDatapersonaGiuridica.flgConduttore" labelId="cbImpresaConduttoreLbl"
	position="last"  >


<!-- widget cbImpresaConduttore -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgConduttore" id="widg_cbImpresaConduttore"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaConduttore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaConduttore')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgConduttore" id="__checkbox_widg_cbImpresaConduttore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaTerzoResponsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaTerzoResponsabile.label')}" labelFor="widg_cbImpresaTerzoResponsabile" errorFor="appDatapersonaGiuridica.flg3Responsabile" labelId="cbImpresaTerzoResponsabileLbl"
	position="first"  >


<!-- widget cbImpresaTerzoResponsabile -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flg3Responsabile" id="widg_cbImpresaTerzoResponsabile"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaTerzoResponsabile')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaTerzoResponsabile')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flg3Responsabile" id="__checkbox_widg_cbImpresaTerzoResponsabile" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaCat')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaCat.label')}" labelFor="widg_cbImpresaCat" errorFor="appDatapersonaGiuridica.flgCat" labelId="cbImpresaCatLbl"
	position="last"  >


<!-- widget cbImpresaCat -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgCat" id="widg_cbImpresaCat"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaCat')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaCat')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgCat" id="__checkbox_widg_cbImpresaCat" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaDistributore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaDistributore.label')}" labelFor="widg_cbImpresaDistributore" errorFor="appDatapersonaGiuridica.flgDistributore" labelId="cbImpresaDistributoreLbl"
	position="first"  >


<!-- widget cbImpresaDistributore -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgDistributore" id="widg_cbImpresaDistributore"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaDistributore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaDistributore')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgDistributore" id="__checkbox_widg_cbImpresaDistributore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAbilAltroImpresa_3_2_fictitious_')" >

	
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

			
	
	<div id="p_wpDichImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpDichImpresa -->
	
	
<h4 class="wpLabel">La presente dichiarazione &#233; resa in qualit&agrave; di: </h4>
<div class="widgetsPanel" id="wpDichImpresa">
	
	<customtag:widgetsPanel id="wpDichImpresaTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="50,25,25">
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','cbImpresaAmministratore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbImpresaAmministratore.label')}" labelFor="widg_cbImpresaAmministratore" errorFor="appDatapersonaGiuridica.flgAmministratore" labelId="cbImpresaAmministratoreLbl"
	position="first"  >


<!-- widget cbImpresaAmministratore -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgAmministratore" id="widg_cbImpresaAmministratore"
	disabled="isWidgetDisabled('cpAccreditamento','cbImpresaAmministratore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbImpresaAmministratore')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgAmministratore" id="__checkbox_widg_cbImpresaAmministratore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cpImpresaSoggDelegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cpImpresaSoggDelegato.label')}" labelFor="widg_cpImpresaSoggDelegato" errorFor="appDatapersonaGiuridica.flgSoggIncaricato" labelId="cpImpresaSoggDelegatoLbl"
	  >


<!-- widget cpImpresaSoggDelegato -->
<s:checkbox 
	
	
	name="appDatapersonaGiuridica.flgSoggIncaricato" id="widg_cpImpresaSoggDelegato"
	disabled="isWidgetDisabled('cpAccreditamento','cpImpresaSoggDelegato')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cpImpresaSoggDelegato')" >
	<s:hidden name="__checkbox_appDatapersonaGiuridica.flgSoggIncaricato" id="__checkbox_widg_cpImpresaSoggDelegato" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfImpresaSoggDelegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfImpresaSoggDelegato" errorFor="appDatapersonaGiuridica.delegaSoggIncaricato" labelId="tfImpresaSoggDelegatoLbl"
	position="last"  >


<!-- widget tfImpresaSoggDelegato -->
<s:textfield 
	
	
	name="appDatapersonaGiuridica.delegaSoggIncaricato" id="widg_tfImpresaSoggDelegato"
maxlength="200"	disabled="isWidgetDisabled('cpAccreditamento','tfImpresaSoggDelegato')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDichImpresa --></div>

			
	
	<div id="p_cpNuovaImpresa" class="commandPanelBlock"><!-- startFragment:p_cpNuovaImpresa -->
	
	
<div class="commandPanel functional" id="cpNuovaImpresa">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAccreditamento','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpAccreditamento.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAccreditamento','btSalvaImpresa')" >

	



<!-- widget btSalvaImpresa -->
<s:submit name="widg_btSalvaImpresa" id="widg_btSalvaImpresa" method="handleBtSalvaImpresa_CLICKED"
	key="cpAccreditamento.btSalvaImpresa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btSalvaImpresa')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNuovaImpresa --></div>

	

		
	
</div>

	<!-- endFragment:p_fmNuovaImpresa --></div>
