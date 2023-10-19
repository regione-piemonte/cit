<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpRespProp" class="formPanelBlock"><!-- startFragment:p_fpRespProp -->
		
	
<div class="formPanel" id="fpRespProp">


	
	

	
	
			
	
	<div id="p_wpRespProp" class="widgetsPanelBlock"><!-- startFragment:p_wpRespProp -->
	
	
<h4 class="wpLabel">dati da gestire </h4>
<div class="widgetsPanel" id="wpRespProp">
	
	<customtag:widgetsPanel id="wpRespPropTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cbRespTitolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cbRespTitolo.label')}" labelFor="widg_cbRespTitolo" errorFor="appDataresponsabile.idTitolo" labelId="cbRespTitoloLbl"
	position="first"  >


<!-- widget cbRespTitolo -->
<s:select name="appDataresponsabile.idTitolo" id="widg_cbRespTitolo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTitoli"
	  disabled="isWidgetDisabled('cpGestImpiantoRespProp','cbRespTitolo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','rbRespIsImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.rbRespIsImpresa.label')}" labelFor="widg_rbRespIsImpresa" errorFor="appDataresponsabile.flgImpresa" labelId="rbRespIsImpresaLbl"
	position="first"  >


<!-- widget rbRespIsImpresa -->

	
<div id="appDataresponsabile.flgImpresa" class="radiobuttons ">







<s:url id="widg_rbRespIsImpresaurlRadioButtonValueChange"
   action="/sigitwebn/cpGestImpiantoRespProp!handleRbRespIsImpresa_VALUE_CHANGED" namespace="/base/gestisci_impianto"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbRespIsImpresaSI" name="appDataresponsabile.flgImpresa"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','rbRespIsImpresa')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbRespIsImpresaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbRespIsImpresaSItrue"><s:text name="cpGestImpiantoRespProp.rbRespIsImpresa.rbRespIsImpresaSI.label" /></label>








<s:radio
	
	
	id="widg_rbRespIsImpresaNO" name="appDataresponsabile.flgImpresa"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','rbRespIsImpresa')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbRespIsImpresaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbRespIsImpresaNOfalse"><s:text name="cpGestImpiantoRespProp.rbRespIsImpresa.rbRespIsImpresaNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cbRespSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cbRespSiglaRea.label')}" labelFor="widg_cbRespSiglaRea" errorFor="appDataresponsabile.idSiglaRea" labelId="cbRespSiglaReaLbl"
	position="first"  >


<!-- widget cbRespSiglaRea -->
<s:select name="appDataresponsabile.idSiglaRea" id="widg_cbRespSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestImpiantoRespProp','cbRespSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespNumRea.label')}" labelFor="widg_tfRespNumRea" errorFor="appDataresponsabile.numeroRea" labelId="tfRespNumReaLbl"
	position="last"  >


<!-- widget tfRespNumRea -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.numeroRea" id="widg_tfRespNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespCf.label')}" labelFor="widg_tfRespCf" errorFor="appDataresponsabile.codiceFiscale" labelId="tfRespCfLbl"
	position="first"  >


<!-- widget tfRespCf -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.codiceFiscale" id="widg_tfRespCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','btnRespCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespCercaCF -->
<s:submit name="widg_btnRespCercaCF" id="widg_btnRespCercaCF" method="handleBtnRespCercaCF_CLICKED"
	key="cpGestImpiantoRespProp.btnRespCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','btnRespCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespCognome.label')}" labelFor="widg_tfRespCognome" errorFor="appDataresponsabile.cognome" labelId="tfRespCognomeLbl"
	position="first"  >


<!-- widget tfRespCognome -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.cognome" id="widg_tfRespCognome"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespCognome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','btnRespNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespNuovaRicercaCF -->
<s:submit name="widg_btnRespNuovaRicercaCF" id="widg_btnRespNuovaRicercaCF" method="handleBtnRespNuovaRicercaCF_CLICKED"
	key="cpGestImpiantoRespProp.btnRespNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','btnRespNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespNome.label')}" labelFor="widg_tfRespNome" errorFor="appDataresponsabile.nome" labelId="tfRespNomeLbl"
	position="first"  >


<!-- widget tfRespNome -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.nome" id="widg_tfRespNome"
maxlength="20"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespNome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cbRespIndirizzoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cbRespIndirizzoEst.label')}" labelFor="widg_cbRespIndirizzoEst" errorFor="appDataresponsabile.flgIndirizzoEst" labelId="cbRespIndirizzoEstLbl"
	position="first"  >


<!-- widget cbRespIndirizzoEst -->
<s:checkbox 
	
	
	name="appDataresponsabile.flgIndirizzoEst" id="widg_cbRespIndirizzoEst"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','cbRespIndirizzoEst')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitwebn/base/gestisci_impianto/cpGestImpiantoRespProp!handleCbRespIndirizzoEst_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpGestImpiantoRespProp','cbRespIndirizzoEst')" >
	<s:hidden name="__checkbox_appDataresponsabile.flgIndirizzoEst" id="__checkbox_widg_cbRespIndirizzoEst" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cbRespProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cbRespProvincia.label')}" labelFor="widg_cbRespProvincia" errorFor="appDataresponsabile.idProvincia" labelId="cbRespProvinciaLbl"
	position="first"  >


<!-- widget cbRespProvincia -->
	<csiuicore:ajaxify id="p_wpRespProp" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impianto/cpGestImpiantoRespProp!handleCbRespProvincia_VALUE_CHANGED.do"
		pageId="cpGestImpiantoRespProp"
		formName="cpGestImpiantoRespProp"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impianto">

<s:url id="widg_cbRespProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpiantoRespProp!handleCbRespProvincia_VALUE_CHANGED" namespace="/base/gestisci_impianto"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataresponsabile.idProvincia" id="widg_cbRespProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvince"
	  disabled="isWidgetDisabled('cpGestImpiantoRespProp','cbRespProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbRespProvincia','conferma','%{widg_cbRespProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRespProvincia','conferma','%{widg_cbRespProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cbRespComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cbRespComune.label')}" labelFor="widg_cbRespComune" errorFor="appDataresponsabile.idComune" labelId="cbRespComuneLbl"
	position="first"  >


<!-- widget cbRespComune -->
<s:select name="appDataresponsabile.idComune" id="widg_cbRespComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniResp"
	  disabled="isWidgetDisabled('cpGestImpiantoRespProp','cbRespComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespIndirizzo.label')}" labelFor="widg_tfRespIndirizzo" errorFor="appDataresponsabile.indirizzo" labelId="tfRespIndirizzoLbl"
	position="first"  >


<!-- widget tfRespIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.indirizzo" id="widg_tfRespIndirizzo"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','btnRespCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespCercaIndirizzo -->
<s:submit name="widg_btnRespCercaIndirizzo" id="widg_btnRespCercaIndirizzo" method="handleBtnRespCercaIndirizzo_CLICKED"
	key="cpGestImpiantoRespProp.btnRespCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','btnRespCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cbRespIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cbRespIndirizzo.label')}" labelFor="widg_cbRespIndirizzo" errorFor="appDataresponsabile.idIndirizzo" labelId="cbRespIndirizzoLbl"
	position="first"  >


<!-- widget cbRespIndirizzo -->
<s:select name="appDataresponsabile.idIndirizzo" id="widg_cbRespIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziResp"
	  disabled="isWidgetDisabled('cpGestImpiantoRespProp','cbRespIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','btnRespNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespNuovaRicercaIndirizzo -->
<s:submit name="widg_btnRespNuovaRicercaIndirizzo" id="widg_btnRespNuovaRicercaIndirizzo" method="handleBtnRespNuovaRicercaIndirizzo_CLICKED"
	key="cpGestImpiantoRespProp.btnRespNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','btnRespNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfIRespNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfIRespNoStrad.label')}" labelFor="widg_tfIRespNoStrad" errorFor="appDataresponsabile.indirizzoNoStrad" labelId="tfIRespNoStradLbl"
	position="first"  >


<!-- widget tfIRespNoStrad -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.indirizzoNoStrad" id="widg_tfIRespNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfIRespNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespCivico.label')}" labelFor="widg_tfRespCivico" errorFor="appDataresponsabile.civico" labelId="tfRespCivicoLbl"
	position="first"  >


<!-- widget tfRespCivico -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.civico" id="widg_tfRespCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespCap.label')}" labelFor="widg_tfRespCap" errorFor="appDataresponsabile.cap" labelId="tfRespCapLbl"
	position="first"  >


<!-- widget tfRespCap -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.cap" id="widg_tfRespCap"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespCap')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_14_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_14_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespEstStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespEstStato.label')}" labelFor="widg_tfRespEstStato" errorFor="appDataresponsabile.estStato" labelId="tfRespEstStatoLbl"
	position="first"  >


<!-- widget tfRespEstStato -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estStato" id="widg_tfRespEstStato"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespEstStato')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_15_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_15_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespEstCitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespEstCitta.label')}" labelFor="widg_tfRespEstCitta" errorFor="appDataresponsabile.estCitta" labelId="tfRespEstCittaLbl"
	position="first"  >


<!-- widget tfRespEstCitta -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estCitta" id="widg_tfRespEstCitta"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespEstCitta')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_16_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_16_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespEstIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespEstIndirizzo.label')}" labelFor="widg_tfRespEstIndirizzo" errorFor="appDataresponsabile.estIndirizzo" labelId="tfRespEstIndirizzoLbl"
	position="first"  >


<!-- widget tfRespEstIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estIndirizzo" id="widg_tfRespEstIndirizzo"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespEstIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_17_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_17_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespEstCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespEstCivico.label')}" labelFor="widg_tfRespEstCivico" errorFor="appDataresponsabile.civico" labelId="tfRespEstCivicoLbl"
	position="first"  >


<!-- widget tfRespEstCivico -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.civico" id="widg_tfRespEstCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespEstCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_18_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_18_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespEstCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespEstCap.label')}" labelFor="widg_tfRespEstCap" errorFor="appDataresponsabile.estCap" labelId="tfRespEstCapLbl"
	position="first"  >


<!-- widget tfRespEstCap -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estCap" id="widg_tfRespEstCap"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespEstCap')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_19_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_19_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cRespDataInizioResp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cRespDataInizioResp.label')}" labelFor="widg_cRespDataInizioResp" errorFor="appDataresponsabile.dataInizioResp" labelId="cRespDataInizioRespLbl"
	position="first"  >


<!-- widget cRespDataInizioResp -->
<s:textfield 
	
	
	name="appDataresponsabile.dataInizioResp" id="widg_cRespDataInizioResp"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','cRespDataInizioResp')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_20_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_20_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','cRespDataFineResp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.cRespDataFineResp.label')}" labelFor="widg_cRespDataFineResp" errorFor="appDataresponsabile.dataFineResp" labelId="cRespDataFineRespLbl"
	position="first"  >


<!-- widget cRespDataFineResp -->
<s:textfield 
	
	
	name="appDataresponsabile.dataFineResp" id="widg_cRespDataFineResp"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','cRespDataFineResp')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_21_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_21_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespEmail.label')}" labelFor="widg_tfRespEmail" errorFor="appDataresponsabile.email" labelId="tfRespEmailLbl"
	position="first"  >


<!-- widget tfRespEmail -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.email" id="widg_tfRespEmail"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespEmail')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_22_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_22_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespPec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespPec.label')}" labelFor="widg_tfRespPec" errorFor="appDataresponsabile.pec" labelId="tfRespPecLbl"
	position="first"  >


<!-- widget tfRespPec -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.pec" id="widg_tfRespPec"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespPec')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_23_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_23_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','tfRespTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoRespProp.tfRespTelefono.label')}" labelFor="widg_tfRespTelefono" errorFor="appDataresponsabile.telefono" labelId="tfRespTelefonoLbl"
	position="first"  >


<!-- widget tfRespTelefono -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.telefono" id="widg_tfRespTelefono"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpiantoRespProp','tfRespTelefono')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_24_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_24_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_25_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpRespProp_25_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','btnRespSalva')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespSalva -->
<s:submit name="widg_btnRespSalva" id="widg_btnRespSalva" method="handleBtnRespSalva_CLICKED"
	key="cpGestImpiantoRespProp.btnRespSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','btnRespSalva')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_26_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpRespProp_26_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','wpRespProp_26_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRespProp_26_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRespProp --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRespProp --></div>
