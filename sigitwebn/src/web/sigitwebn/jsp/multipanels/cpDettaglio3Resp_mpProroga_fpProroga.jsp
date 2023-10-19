<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpProroga" class="formPanelBlock"><!-- startFragment:p_fpProroga -->
		
	
<div class="formPanel" id="fpProroga">


	
	

	
	
			
	
	<div id="p_wpProroga" class="widgetsPanelBlock"><!-- startFragment:p_wpProroga -->
	
	
<h4 class="wpLabel">dati proroga </h4>
<div class="widgetsPanel" id="wpProroga">
	
	<customtag:widgetsPanel id="wpProrogaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglio3Resp','calDataFineContratto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglio3Resp.calDataFineContratto.label')}" labelFor="widg_calDataFineContratto" errorFor="appDataprorogaTerzoResponsabile.dataFineContratto" labelId="calDataFineContrattoLbl"
	  >


<!-- widget calDataFineContratto -->
<s:textfield 
	
	
	name="appDataprorogaTerzoResponsabile.dataFineContratto" id="widg_calDataFineContratto"
	disabled="isWidgetDisabled('cpDettaglio3Resp','calDataFineContratto')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','cbTacitoRinnovo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglio3Resp.cbTacitoRinnovo.label')}" labelFor="widg_cbTacitoRinnovo" errorFor="appDataprorogaTerzoResponsabile.flgTacitoRinnovo" labelId="cbTacitoRinnovoLbl"
	  >


<!-- widget cbTacitoRinnovo -->
<s:checkbox 
	
	
	name="appDataprorogaTerzoResponsabile.flgTacitoRinnovo" id="widg_cbTacitoRinnovo"
	disabled="isWidgetDisabled('cpDettaglio3Resp','cbTacitoRinnovo')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpDettaglio3Resp','cbTacitoRinnovo')" >
	<s:hidden name="__checkbox_appDataprorogaTerzoResponsabile.flgTacitoRinnovo" id="__checkbox_widg_cbTacitoRinnovo" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpProroga --></div>

			
	
	<div id="p_cpPanelProrogaFun" class="commandPanelBlock"><!-- startFragment:p_cpPanelProrogaFun -->
	
	
<div class="commandPanel functional" id="cpPanelProrogaFun">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglio3Resp','btConfermaProroga')" >

	



<!-- widget btConfermaProroga -->
<s:submit name="widg_btConfermaProroga" id="widg_btConfermaProroga" method="handleBtConfermaProroga_CLICKED"
	key="cpDettaglio3Resp.btConfermaProroga.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglio3Resp','btConfermaProroga')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpPanelProrogaFun --></div>

			
	
	<div id="p_cpPanelProrogaNav" class="commandPanelBlock"><!-- startFragment:p_cpPanelProrogaNav -->
	
	
<div class="commandPanel navigation" id="cpPanelProrogaNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglio3Resp','btChiudiProroga')" >

	



<!-- widget btChiudiProroga -->
<s:submit name="widg_btChiudiProroga" id="widg_btChiudiProroga" method="handleBtChiudiProroga_CLICKED"
	key="cpDettaglio3Resp.btChiudiProroga.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglio3Resp','btChiudiProroga')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpPanelProrogaNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpProroga --></div>
