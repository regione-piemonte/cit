<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpFatturazione" class="formPanelBlock"><!-- startFragment:p_fpFatturazione -->
		
	
<div class="formPanel" id="fpFatturazione">


	
	

	
	
			
	
	<div id="p_wpDatiClienteFatt" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiClienteFatt -->
	
	
<h4 class="wpLabel">dati cliente fatturazione </h4>
<div class="widgetsPanel" id="wpDatiClienteFatt">
	
	<customtag:widgetsPanel id="wpDatiClienteFattTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciDistributore','rbDistribIsImpresaFatt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.rbDistribIsImpresaFatt.label')}" labelFor="widg_rbDistribIsImpresaFatt" errorFor="appDatadistributoreManuale.flgImpresaFatt" labelId="rbDistribIsImpresaFattLbl"
	position="first"  >


<!-- widget rbDistribIsImpresaFatt -->

	
<div id="appDatadistributoreManuale.flgImpresaFatt" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDistribIsImpresaFattSI" name="appDatadistributoreManuale.flgImpresaFatt"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpInserisciDistributore','rbDistribIsImpresaFatt')"
	cssClass="radio"
	
	/> <label  for="widg_rbDistribIsImpresaFattSItrue"><s:text name="cpInserisciDistributore.rbDistribIsImpresaFatt.rbDistribIsImpresaFattSI.label" /></label>








<s:radio
	
	
	id="widg_rbDistribIsImpresaFattNO" name="appDatadistributoreManuale.flgImpresaFatt"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpInserisciDistributore','rbDistribIsImpresaFatt')"
	cssClass="radio"
	
	/> <label  for="widg_rbDistribIsImpresaFattNOfalse"><s:text name="cpInserisciDistributore.rbDistribIsImpresaFatt.rbDistribIsImpresaFattNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteFatt_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteFatt_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfDistribCognomeFatt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfDistribCognomeFatt.label')}" labelFor="widg_tfDistribCognomeFatt" errorFor="appDatadistributoreManuale.cognomeFatt" labelId="tfDistribCognomeFattLbl"
	position="first"  >


<!-- widget tfDistribCognomeFatt -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.cognomeFatt" id="widg_tfDistribCognomeFatt"
maxlength="500"	disabled="isWidgetDisabled('cpInserisciDistributore','tfDistribCognomeFatt')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteFatt_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteFatt_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfDistribNomeFatt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfDistribNomeFatt.label')}" labelFor="widg_tfDistribNomeFatt" errorFor="appDatadistributoreManuale.nomeFatt" labelId="tfDistribNomeFattLbl"
	position="first"  >


<!-- widget tfDistribNomeFatt -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.nomeFatt" id="widg_tfDistribNomeFatt"
maxlength="100"	disabled="isWidgetDisabled('cpInserisciDistributore','tfDistribNomeFatt')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteFatt_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteFatt_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfDistribCfFatt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfDistribCfFatt.label')}" labelFor="widg_tfDistribCfFatt" errorFor="appDatadistributoreManuale.cfPivaFatt" labelId="tfDistribCfFattLbl"
	position="first"  >


<!-- widget tfDistribCfFatt -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.cfPivaFatt" id="widg_tfDistribCfFatt"
maxlength="16"	disabled="isWidgetDisabled('cpInserisciDistributore','tfDistribCfFatt')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteFatt_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteFatt_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiClienteFatt --></div>

			
	
	<div id="p_wpLocazioneFatt" class="widgetsPanelBlock"><!-- startFragment:p_wpLocazioneFatt -->
	
	
<h4 class="wpLabel">localizzazione fatturazione </h4>
<div class="widgetsPanel" id="wpLocazioneFatt">
	
	<customtag:widgetsPanel id="wpLocazioneFattTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbIndEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbIndEstero.label')}" labelFor="widg_cbIndEstero" errorFor="appDatadistributoreManuale.flgIndirizzoFattEstero" labelId="cbIndEsteroLbl"
	position="first"  >


<!-- widget cbIndEstero -->
<s:checkbox 
	
	
	name="appDatadistributoreManuale.flgIndirizzoFattEstero" id="widg_cbIndEstero"
	disabled="isWidgetDisabled('cpInserisciDistributore','cbIndEstero')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitwebn/base/gestisci_distributori/cpInserisciDistributore!handleCbIndEstero_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpInserisciDistributore','cbIndEstero')" >
	<s:hidden name="__checkbox_appDatadistributoreManuale.flgIndirizzoFattEstero" id="__checkbox_widg_cbIndEstero" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneFatt_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneFatt_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbFornProvinciaFatt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbFornProvinciaFatt.label')}" labelFor="widg_cbFornProvinciaFatt" errorFor="appDatadistributoreManuale.idProvinciaFatt" labelId="cbFornProvinciaFattLbl"
	position="first"  >


<!-- widget cbFornProvinciaFatt -->
	<csiuicore:ajaxify id="p_wpLocazioneFatt" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_distributori/cpInserisciDistributore!handleCbFornProvinciaFatt_VALUE_CHANGED.do"
		pageId="cpInserisciDistributore"
		formName="cpInserisciDistributore"
		javascriptDetection="false"
		nameSpace="/base/gestisci_distributori">

<s:url id="widg_cbFornProvinciaFatturlComboBoxValueChange"
   action="/sigitwebn/cpInserisciDistributore!handleCbFornProvinciaFatt_VALUE_CHANGED" namespace="/base/gestisci_distributori"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatadistributoreManuale.idProvinciaFatt" id="widg_cbFornProvinciaFatt"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvince"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbFornProvinciaFatt')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbFornProvinciaFatt','conferma','%{widg_cbFornProvinciaFatturlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbFornProvinciaFatt','conferma','%{widg_cbFornProvinciaFatturlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneFatt_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneFatt_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbFornComuneFatt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbFornComuneFatt.label')}" labelFor="widg_cbFornComuneFatt" errorFor="appDatadistributoreManuale.idComuneFatt" labelId="cbFornComuneFattLbl"
	position="first"  >


<!-- widget cbFornComuneFatt -->
<s:select name="appDatadistributoreManuale.idComuneFatt" id="widg_cbFornComuneFatt"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniFatturazione"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbFornComuneFatt')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneFatt_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneFatt_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIndirizzoFatt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIndirizzoFatt.label')}" labelFor="widg_tfIndirizzoFatt" errorFor="appDatadistributoreManuale.indirizzoFatt" labelId="tfIndirizzoFattLbl"
	position="first"  >


<!-- widget tfIndirizzoFatt -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoFatt" id="widg_tfIndirizzoFatt"
maxlength="200"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIndirizzoFatt')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','btnCercaIndirizzoFatt')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCercaIndirizzoFatt -->
<s:submit name="widg_btnCercaIndirizzoFatt" id="widg_btnCercaIndirizzoFatt" method="handleBtnCercaIndirizzoFatt_CLICKED"
	key="cpInserisciDistributore.btnCercaIndirizzoFatt.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciDistributore','btnCercaIndirizzoFatt')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbFattIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbFattIndirizzo.label')}" labelFor="widg_cbFattIndirizzo" errorFor="appDatadistributoreManuale.idIndirizzoFatt" labelId="cbFattIndirizzoLbl"
	position="first"  >


<!-- widget cbFattIndirizzo -->
<s:select name="appDatadistributoreManuale.idIndirizzoFatt" id="widg_cbFattIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziFatturazione"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbFattIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','btnNuovaRicercaIndFatt')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnNuovaRicercaIndFatt -->
<s:submit name="widg_btnNuovaRicercaIndFatt" id="widg_btnNuovaRicercaIndFatt" method="handleBtnNuovaRicercaIndFatt_CLICKED"
	key="cpInserisciDistributore.btnNuovaRicercaIndFatt.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciDistributore','btnNuovaRicercaIndFatt')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIFattNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIFattNoStrad.label')}" labelFor="widg_tfIFattNoStrad" errorFor="appDatadistributoreManuale.indirizzoNoStradFatt" labelId="tfIFattNoStradLbl"
	position="first"  >


<!-- widget tfIFattNoStrad -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoNoStradFatt" id="widg_tfIFattNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIFattNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneFatt_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneFatt_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIFattEstero')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIFattEstero.label')}" labelFor="widg_tfIFattEstero" errorFor="appDatadistributoreManuale.indirizzoNoStradFatt" labelId="tfIFattEsteroLbl"
	position="first"  >


<!-- widget tfIFattEstero -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoNoStradFatt" id="widg_tfIFattEstero"
maxlength="200"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIFattEstero')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneFatt_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneFatt_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIFattCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIFattCivico.label')}" labelFor="widg_tfIFattCivico" errorFor="appDatadistributoreManuale.indirizzoCivicoFatt" labelId="tfIFattCivicoLbl"
	position="first"  >


<!-- widget tfIFattCivico -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoCivicoFatt" id="widg_tfIFattCivico"
maxlength="10"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIFattCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneFatt_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneFatt_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIFattCAP')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIFattCAP.label')}" labelFor="widg_tfIFattCAP" errorFor="appDatadistributoreManuale.indirizzoCapFatt" labelId="tfIFattCAPLbl"
	position="first"  >


<!-- widget tfIFattCAP -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoCapFatt" id="widg_tfIFattCAP"
maxlength="5"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIFattCAP')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneFatt_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneFatt_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLocazioneFatt --></div>

	

		
	
</div>

	<!-- endFragment:p_fpFatturazione --></div>
