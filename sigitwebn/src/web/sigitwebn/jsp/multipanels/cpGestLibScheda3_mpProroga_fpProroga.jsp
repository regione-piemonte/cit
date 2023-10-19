<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpProroga" class="formPanelBlock"><!-- startFragment:p_fpProroga -->
		
	
<div class="formPanel" id="fpProroga">


	
	

	
	
			
	
	<div id="p_wpProroga" class="widgetsPanelBlock"><!-- startFragment:p_wpProroga -->
	
	

<div class="widgetsPanel" id="wpProroga">
	
	<customtag:widgetsPanel id="wpProrogaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','calDataFineContratto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.calDataFineContratto.label')}" labelFor="widg_calDataFineContratto" errorFor="appDataprorogaTerzoResponsabile.dataFineContratto" labelId="calDataFineContrattoLbl"
	  >


<!-- widget calDataFineContratto -->
<s:textfield 
	
	
	name="appDataprorogaTerzoResponsabile.dataFineContratto" id="widg_calDataFineContratto"
	disabled="isWidgetDisabled('cpGestLibScheda3','calDataFineContratto')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','cbTacitoRinnovo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.cbTacitoRinnovo.label')}" labelFor="widg_cbTacitoRinnovo" errorFor="appDataprorogaTerzoResponsabile.flgTacitoRinnovo" labelId="cbTacitoRinnovoLbl"
	  >


<!-- widget cbTacitoRinnovo -->
<s:checkbox 
	
	
	name="appDataprorogaTerzoResponsabile.flgTacitoRinnovo" id="widg_cbTacitoRinnovo"
	disabled="isWidgetDisabled('cpGestLibScheda3','cbTacitoRinnovo')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda3','cbTacitoRinnovo')" >
	<s:hidden name="__checkbox_appDataprorogaTerzoResponsabile.flgTacitoRinnovo" id="__checkbox_widg_cbTacitoRinnovo" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpProroga --></div>

			
	
	<div id="p_cpPanelProroga" class="commandPanelBlock"><!-- startFragment:p_cpPanelProroga -->
	
	
<div class="commandPanel functional" id="cpPanelProroga">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btConfermaProroga')" >

	



<!-- widget btConfermaProroga -->
<s:submit name="widg_btConfermaProroga" id="widg_btConfermaProroga" method="handleBtConfermaProroga_CLICKED"
	key="cpGestLibScheda3.btConfermaProroga.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btConfermaProroga')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpPanelProroga --></div>

	

		
	
</div>

	<!-- endFragment:p_fpProroga --></div>
