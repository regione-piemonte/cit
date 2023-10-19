<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpTipoSubentro" class="formPanelBlock"><!-- startFragment:p_fpTipoSubentro -->
		
	
<div class="formPanel" id="fpTipoSubentro">


	
	

	
	
			
	
	<div id="p_wpTipoSubentro" class="widgetsPanelBlock"><!-- startFragment:p_wpTipoSubentro -->
	
	
<h4 class="wpLabel">tipo subentro </h4>
<div class="widgetsPanel" id="wpTipoSubentro">
	
	<customtag:widgetsPanel id="wpTipoSubentroTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestSubentro','cbTipoSubentro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.cbTipoSubentro.label')}" labelFor="widg_cbTipoSubentro" errorFor="appDatasubentro.idTipoSubentro" labelId="cbTipoSubentroLbl"
	position="first"  >


<!-- widget cbTipoSubentro -->
	<csiuicore:ajaxify id="p_wpTipoSubentro" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_subentro/cpGestSubentro!handleCbTipoSubentro_VALUE_CHANGED.do"
		pageId="cpGestSubentro"
		formName="cpGestSubentro"
		javascriptDetection="false"
		nameSpace="/base/gestisci_subentro">

<s:url id="widg_cbTipoSubentrourlComboBoxValueChange"
   action="/sigitwebn/cpGestSubentro!handleCbTipoSubentro_VALUE_CHANGED" namespace="/base/gestisci_subentro"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasubentro.idTipoSubentro" id="widg_cbTipoSubentro"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoSubentro"
	  disabled="isWidgetDisabled('cpGestSubentro','cbTipoSubentro')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoSubentro','conferma','%{widg_cbTipoSubentrourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoSubentro','conferma','%{widg_cbTipoSubentrourlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','wpTipoSubentro_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTipoSubentro_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','cbTipoComponente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.cbTipoComponente.label')}" labelFor="widg_cbTipoComponente" errorFor="appDatasubentro.idApparecchiature" labelId="cbTipoComponenteLbl"
	position="first"  >


<!-- widget cbTipoComponente -->
<s:select name="appDatasubentro.idApparecchiature" id="widg_cbTipoComponente"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiatureSub"
	  disabled="isWidgetDisabled('cpGestSubentro','cbTipoComponente')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','wpTipoSubentro_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTipoSubentro_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpTipoSubentro --></div>

			
	
	<div id="p_cpFunGestSubentro" class="commandPanelBlock"><!-- startFragment:p_cpFunGestSubentro -->
	
	
<div class="commandPanel functional" id="cpFunGestSubentro">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestSubentro','btnSubentro')" >

	



<!-- widget btnSubentro -->
<s:submit name="widg_btnSubentro" id="widg_btnSubentro" method="handleBtnSubentro_CLICKED"
	key="cpGestSubentro.btnSubentro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnSubentro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestSubentro --></div>

	

		
	
</div>

	<!-- endFragment:p_fpTipoSubentro --></div>
