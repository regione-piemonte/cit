<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpImport" class="formPanelBlock"><!-- startFragment:p_fpImport -->
		
	
<div class="formPanel" id="fpImport">


	
	

	
	
			
	
	<div id="p_wpImport" class="widgetsPanelBlock"><!-- startFragment:p_wpImport -->
	
	
<h4 class="wpLabel">import massivo </h4>
<div class="widgetsPanel" id="wpImport">
	
	<customtag:widgetsPanel id="wpImportTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestDistributori','fuImport')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDistributori.fuImport.label')}" labelFor="widg_fuImport" errorFor="widg_fuImport" labelId="fuImportLbl"
	  >


<s:file 
	
	
	name="widg_fuImport" id="widg_fuImport"
	disabled="isWidgetDisabled('cpGestDistributori','fuImport')"
	
	multiple="multiple"/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImport --></div>

			
	
	<div id="p_cpFunImport" class="commandPanelBlock"><!-- startFragment:p_cpFunImport -->
	
	
<div class="commandPanel functional" id="cpFunImport">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestDistributori','btnAvviaImport')" >

	



<!-- widget btnAvviaImport -->
<s:submit name="widg_btnAvviaImport" id="widg_btnAvviaImport" method="handleBtnAvviaImport_CLICKED"
	key="cpGestDistributori.btnAvviaImport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnAvviaImport')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunImport --></div>

			
	
	<div id="p_cpNavImport" class="commandPanelBlock"><!-- startFragment:p_cpNavImport -->
	
	
<div class="commandPanel navigation" id="cpNavImport">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDistributori','btnChiudiImport')" >

	



<!-- widget btnChiudiImport -->
<s:submit name="widg_btnChiudiImport" id="widg_btnChiudiImport" method="handleBtnChiudiImport_CLICKED"
	key="cpGestDistributori.btnChiudiImport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDistributori','btnChiudiImport')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavImport --></div>

	

		
	
</div>

	<!-- endFragment:p_fpImport --></div>
