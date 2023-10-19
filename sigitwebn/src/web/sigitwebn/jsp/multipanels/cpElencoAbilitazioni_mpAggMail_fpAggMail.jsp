<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpAggMail" class="formPanelBlock"><!-- startFragment:p_fpAggMail -->
		
	
<div class="formPanel" id="fpAggMail">


	
	

	
	
			
	
	<div id="p_wpAggMail" class="widgetsPanelBlock"><!-- startFragment:p_wpAggMail -->
	
	

<div class="widgetsPanel" id="wpAggMail">
	
	<customtag:widgetsPanel id="wpAggMailTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoAbilitazioni','tfNewMail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAbilitazioni.tfNewMail.label')}" labelFor="widg_tfNewMail" errorFor="appDatanewMail" labelId="tfNewMailLbl"
	  >


<!-- widget tfNewMail -->
<s:textfield 
	
	
	name="appDatanewMail" id="widg_tfNewMail"
maxlength="100"	disabled="isWidgetDisabled('cpElencoAbilitazioni','tfNewMail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAggMail --></div>

			
	
	<div id="p_cpAggMail" class="commandPanelBlock"><!-- startFragment:p_cpAggMail -->
	
	
<div class="commandPanel functional" id="cpAggMail">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAbilitazioni','cbSalva')" >

	



<!-- widget cbSalva -->
<s:submit name="widg_cbSalva" id="widg_cbSalva" method="handleCbSalva_CLICKED"
	key="cpElencoAbilitazioni.cbSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAbilitazioni','cbSalva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpAggMail --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAggMail --></div>
