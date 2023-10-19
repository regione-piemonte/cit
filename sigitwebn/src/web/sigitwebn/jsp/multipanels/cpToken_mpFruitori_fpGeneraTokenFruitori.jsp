<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpGeneraTokenFruitori" class="formPanelBlock"><!-- startFragment:p_fpGeneraTokenFruitori -->
		
	
<div class="formPanel" id="fpGeneraTokenFruitori">


	
	

	
	
			
	
	<div id="p_wpFruitore" class="widgetsPanelBlock"><!-- startFragment:p_wpFruitore -->
	
	
<h4 class="wpLabel">Fruitore interno </h4>
<div class="widgetsPanel" id="wpFruitore">
	
	<customtag:widgetsPanel id="wpFruitoreTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpToken','cbFruitore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.cbFruitore.label')}" labelFor="widg_cbFruitore" errorFor="appDataidUserWsSelected" labelId="cbFruitoreLbl"
	position="first"  >


<!-- widget cbFruitore -->
	<csiuicore:ajaxify id="p_wpFruitore" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/token/cpToken!handleCbFruitore_VALUE_CHANGED.do"
		pageId="cpToken"
		formName="cpToken"
		javascriptDetection="false"
		nameSpace="/base/token">

<s:url id="widg_cbFruitoreurlComboBoxValueChange"
   action="/sigitwebn/cpToken!handleCbFruitore_VALUE_CHANGED" namespace="/base/token"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidUserWsSelected" id="widg_cbFruitore"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUserWs"
	  disabled="isWidgetDisabled('cpToken','cbFruitore')"
	  listKey="idUserWs"
	  listValue="userWs"
	  onclick="onCBClick(this,'confermacbFruitore','conferma','%{widg_cbFruitoreurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbFruitore','conferma','%{widg_cbFruitoreurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpFruitore_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFruitore_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','ptTokenFruitore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpToken.ptTokenFruitore.label')}" labelFor="widg_ptTokenFruitore" errorFor="appDatauserWs.token" labelId="ptTokenFruitoreLbl"  position="first" >


<!-- widget ptTokenFruitore -->
<s:property value="appDatauserWs.token" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpFruitore_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFruitore_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','tfTokenDataGenFruitore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.tfTokenDataGenFruitore.label')}" labelFor="widg_tfTokenDataGenFruitore" errorFor="appDatauserWs.dtCreazioneToken" labelId="tfTokenDataGenFruitoreLbl"
	position="first"  >


<!-- widget tfTokenDataGenFruitore -->
<s:textfield 
	
	
	name="appDatauserWs.dtCreazioneToken" id="widg_tfTokenDataGenFruitore"
	disabled="isWidgetDisabled('cpToken','tfTokenDataGenFruitore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpFruitore_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFruitore_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','calTokenDataScadenzaFruitore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.calTokenDataScadenzaFruitore.label')}" labelFor="widg_calTokenDataScadenzaFruitore" errorFor="appDatauserWs.dtScadenzaToken" labelId="calTokenDataScadenzaFruitoreLbl"
	position="first"  >


<!-- widget calTokenDataScadenzaFruitore -->
<s:textfield 
	
	
	name="appDatauserWs.dtScadenzaToken" id="widg_calTokenDataScadenzaFruitore"
	disabled="isWidgetDisabled('cpToken','calTokenDataScadenzaFruitore')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpFruitore_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFruitore_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','btnGeneraFruitore')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnGeneraFruitore -->
<s:submit name="widg_btnGeneraFruitore" id="widg_btnGeneraFruitore" method="handleBtnGeneraFruitore_CLICKED"
	key="cpToken.btnGeneraFruitore.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpToken','btnGeneraFruitore')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpFruitore_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFruitore_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','ptTokenFruitoreMessage')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpToken.ptTokenFruitoreMessage.label')}" labelFor="widg_ptTokenFruitoreMessage" errorFor="widg_ptTokenFruitoreMessage" labelId="ptTokenFruitoreMessageLbl"  position="first" >


<!-- widget ptTokenFruitoreMessage -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpFruitore_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFruitore_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpFruitore --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGeneraTokenFruitori --></div>
