<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpresponsabile" class="formPanelBlock"><!-- startFragment:p_fpresponsabile -->
		
	
<h4 class="fpLabel"><s:text name="cpGestImpianto.fpresponsabile.label" /></h4>
<div class="formPanel" id="fpresponsabile">


	
	

	
	
			
	
	<div id="p_wpResponsabile" class="widgetsPanelBlock"><!-- startFragment:p_wpResponsabile -->
	
	
<h4 class="wpLabel">dati del responsabile </h4>
<div class="widgetsPanel" id="wpResponsabile">
	
	<customtag:widgetsPanel id="wpResponsabileTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','cbRespTitolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbRespTitolo.label')}" labelFor="widg_cbRespTitolo" errorFor="appDataresponsabile.idTitolo" labelId="cbRespTitoloLbl"
	position="first"  >


<!-- widget cbRespTitolo -->
<s:select name="appDataresponsabile.idTitolo" id="widg_cbRespTitolo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTitoli"
	  disabled="isWidgetDisabled('cpGestImpianto','cbRespTitolo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','rbRespIsImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.rbRespIsImpresa.label')}" labelFor="widg_rbRespIsImpresa" errorFor="appDataresponsabile.flgImpresa" labelId="rbRespIsImpresaLbl"
	position="first"  >


<!-- widget rbRespIsImpresa -->

	
<div id="appDataresponsabile.flgImpresa" class="radiobuttons ">







<s:url id="widg_rbRespIsImpresaurlRadioButtonValueChange"
   action="/sigitwebn/cpGestImpianto!handleRbRespIsImpresa_VALUE_CHANGED" namespace="/base/gestisci_impianto"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbRespIsImpresaSI" name="appDataresponsabile.flgImpresa"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbRespIsImpresa')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbRespIsImpresaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbRespIsImpresaSItrue"><s:text name="cpGestImpianto.rbRespIsImpresa.rbRespIsImpresaSI.label" /></label>








<s:radio
	
	
	id="widg_rbRespIsImpresaNO" name="appDataresponsabile.flgImpresa"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbRespIsImpresa')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbRespIsImpresaurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbRespIsImpresaNOfalse"><s:text name="cpGestImpianto.rbRespIsImpresa.rbRespIsImpresaNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbRespSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbRespSiglaRea.label')}" labelFor="widg_cbRespSiglaRea" errorFor="appDataresponsabile.idSiglaRea" labelId="cbRespSiglaReaLbl"
	position="first"  >


<!-- widget cbRespSiglaRea -->
<s:select name="appDataresponsabile.idSiglaRea" id="widg_cbRespSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestImpianto','cbRespSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespNumRea.label')}" labelFor="widg_tfRespNumRea" errorFor="appDataresponsabile.numeroRea" labelId="tfRespNumReaLbl"
	position="last"  >


<!-- widget tfRespNumRea -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.numeroRea" id="widg_tfRespNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestImpianto','tfRespNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespCf.label')}" labelFor="widg_tfRespCf" errorFor="appDataresponsabile.codiceFiscale" labelId="tfRespCfLbl"
	position="first"  >


<!-- widget tfRespCf -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.codiceFiscale" id="widg_tfRespCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestImpianto','tfRespCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnRespCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespCercaCF -->
<s:submit name="widg_btnRespCercaCF" id="widg_btnRespCercaCF" method="handleBtnRespCercaCF_CLICKED"
	key="cpGestImpianto.btnRespCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespCognome.label')}" labelFor="widg_tfRespCognome" errorFor="appDataresponsabile.cognome" labelId="tfRespCognomeLbl"
	position="first"  >


<!-- widget tfRespCognome -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.cognome" id="widg_tfRespCognome"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpianto','tfRespCognome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnRespNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespNuovaRicercaCF -->
<s:submit name="widg_btnRespNuovaRicercaCF" id="widg_btnRespNuovaRicercaCF" method="handleBtnRespNuovaRicercaCF_CLICKED"
	key="cpGestImpianto.btnRespNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespNome.label')}" labelFor="widg_tfRespNome" errorFor="appDataresponsabile.nome" labelId="tfRespNomeLbl"
	position="first"  >


<!-- widget tfRespNome -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.nome" id="widg_tfRespNome"
maxlength="20"	disabled="isWidgetDisabled('cpGestImpianto','tfRespNome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbRespIndirizzoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbRespIndirizzoEst.label')}" labelFor="widg_cbRespIndirizzoEst" errorFor="appDataresponsabile.flgIndirizzoEst" labelId="cbRespIndirizzoEstLbl"
	position="first"  >


<!-- widget cbRespIndirizzoEst -->
<s:checkbox 
	
	
	name="appDataresponsabile.flgIndirizzoEst" id="widg_cbRespIndirizzoEst"
	disabled="isWidgetDisabled('cpGestImpianto','cbRespIndirizzoEst')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitwebn/base/gestisci_impianto/cpGestImpianto!handleCbRespIndirizzoEst_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpGestImpianto','cbRespIndirizzoEst')" >
	<s:hidden name="__checkbox_appDataresponsabile.flgIndirizzoEst" id="__checkbox_widg_cbRespIndirizzoEst" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbRespProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbRespProvincia.label')}" labelFor="widg_cbRespProvincia" errorFor="appDataresponsabile.idProvincia" labelId="cbRespProvinciaLbl"
	position="first"  >


<!-- widget cbRespProvincia -->
	<csiuicore:ajaxify id="p_wpResponsabile" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impianto/cpGestImpianto!handleCbRespProvincia_VALUE_CHANGED.do"
		pageId="cpGestImpianto"
		formName="cpGestImpianto"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impianto">

<s:url id="widg_cbRespProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpianto!handleCbRespProvincia_VALUE_CHANGED" namespace="/base/gestisci_impianto"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataresponsabile.idProvincia" id="widg_cbRespProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvince"
	  disabled="isWidgetDisabled('cpGestImpianto','cbRespProvincia')"
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


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbRespComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbRespComune.label')}" labelFor="widg_cbRespComune" errorFor="appDataresponsabile.idComune" labelId="cbRespComuneLbl"
	position="first"  >


<!-- widget cbRespComune -->
<s:select name="appDataresponsabile.idComune" id="widg_cbRespComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniResp"
	  disabled="isWidgetDisabled('cpGestImpianto','cbRespComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespIndirizzo.label')}" labelFor="widg_tfRespIndirizzo" errorFor="appDataresponsabile.indirizzo" labelId="tfRespIndirizzoLbl"
	position="first"  >


<!-- widget tfRespIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.indirizzo" id="widg_tfRespIndirizzo"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpianto','tfRespIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnRespCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespCercaIndirizzo -->
<s:submit name="widg_btnRespCercaIndirizzo" id="widg_btnRespCercaIndirizzo" method="handleBtnRespCercaIndirizzo_CLICKED"
	key="cpGestImpianto.btnRespCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbRespIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbRespIndirizzo.label')}" labelFor="widg_cbRespIndirizzo" errorFor="appDataresponsabile.idIndirizzo" labelId="cbRespIndirizzoLbl"
	position="first"  >


<!-- widget cbRespIndirizzo -->
<s:select name="appDataresponsabile.idIndirizzo" id="widg_cbRespIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziResp"
	  disabled="isWidgetDisabled('cpGestImpianto','cbRespIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnRespNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespNuovaRicercaIndirizzo -->
<s:submit name="widg_btnRespNuovaRicercaIndirizzo" id="widg_btnRespNuovaRicercaIndirizzo" method="handleBtnRespNuovaRicercaIndirizzo_CLICKED"
	key="cpGestImpianto.btnRespNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfIRespNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfIRespNoStrad.label')}" labelFor="widg_tfIRespNoStrad" errorFor="appDataresponsabile.indirizzoNoStrad" labelId="tfIRespNoStradLbl"
	position="first"  >


<!-- widget tfIRespNoStrad -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.indirizzoNoStrad" id="widg_tfIRespNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpianto','tfIRespNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespCivico.label')}" labelFor="widg_tfRespCivico" errorFor="appDataresponsabile.civico" labelId="tfRespCivicoLbl"
	position="first"  >


<!-- widget tfRespCivico -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.civico" id="widg_tfRespCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpianto','tfRespCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespCap.label')}" labelFor="widg_tfRespCap" errorFor="appDataresponsabile.cap" labelId="tfRespCapLbl"
	position="first"  >


<!-- widget tfRespCap -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.cap" id="widg_tfRespCap"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpianto','tfRespCap')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_14_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_14_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespEstStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespEstStato.label')}" labelFor="widg_tfRespEstStato" errorFor="appDataresponsabile.estStato" labelId="tfRespEstStatoLbl"
	position="first"  >


<!-- widget tfRespEstStato -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estStato" id="widg_tfRespEstStato"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpianto','tfRespEstStato')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_15_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_15_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespEstCitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespEstCitta.label')}" labelFor="widg_tfRespEstCitta" errorFor="appDataresponsabile.estCitta" labelId="tfRespEstCittaLbl"
	position="first"  >


<!-- widget tfRespEstCitta -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estCitta" id="widg_tfRespEstCitta"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpianto','tfRespEstCitta')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_16_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_16_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespEstIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespEstIndirizzo.label')}" labelFor="widg_tfRespEstIndirizzo" errorFor="appDataresponsabile.estIndirizzo" labelId="tfRespEstIndirizzoLbl"
	position="first"  >


<!-- widget tfRespEstIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estIndirizzo" id="widg_tfRespEstIndirizzo"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpianto','tfRespEstIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_17_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_17_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespEstCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespEstCivico.label')}" labelFor="widg_tfRespEstCivico" errorFor="appDataresponsabile.civico" labelId="tfRespEstCivicoLbl"
	position="first"  >


<!-- widget tfRespEstCivico -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.civico" id="widg_tfRespEstCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpianto','tfRespEstCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_18_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_18_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespEstCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespEstCap.label')}" labelFor="widg_tfRespEstCap" errorFor="appDataresponsabile.estCap" labelId="tfRespEstCapLbl"
	position="first"  >


<!-- widget tfRespEstCap -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estCap" id="widg_tfRespEstCap"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpianto','tfRespEstCap')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_19_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_19_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cRespDataInizioResp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cRespDataInizioResp.label')}" labelFor="widg_cRespDataInizioResp" errorFor="appDataresponsabile.dataInizioResp" labelId="cRespDataInizioRespLbl"
	position="first"  >


<!-- widget cRespDataInizioResp -->
<s:textfield 
	
	
	name="appDataresponsabile.dataInizioResp" id="widg_cRespDataInizioResp"
	disabled="isWidgetDisabled('cpGestImpianto','cRespDataInizioResp')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_20_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_20_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cRespDataFineResp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cRespDataFineResp.label')}" labelFor="widg_cRespDataFineResp" errorFor="appDataresponsabile.dataFineResp" labelId="cRespDataFineRespLbl"
	position="first"  >


<!-- widget cRespDataFineResp -->
<s:textfield 
	
	
	name="appDataresponsabile.dataFineResp" id="widg_cRespDataFineResp"
	disabled="isWidgetDisabled('cpGestImpianto','cRespDataFineResp')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_21_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_21_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfRespEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfRespEmail.label')}" labelFor="widg_tfRespEmail" errorFor="appDataresponsabile.email" labelId="tfRespEmailLbl"
	position="first"  >


<!-- widget tfRespEmail -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.email" id="widg_tfRespEmail"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpianto','tfRespEmail')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpResponsabile_22_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_22_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnRespAnnulla')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnRespAnnulla -->
<s:submit name="widg_btnRespAnnulla" id="widg_btnRespAnnulla" method="handleBtnRespAnnulla_CLICKED"
	key="cpGestImpianto.btnRespAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespAnnulla')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnRespSalva')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespSalva -->
<s:submit name="widg_btnRespSalva" id="widg_btnRespSalva" method="handleBtnRespSalva_CLICKED"
	key="cpGestImpianto.btnRespSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespSalva')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpResponsabile --></div>

	

		
	
</div>

	<!-- endFragment:p_fpresponsabile --></div>
