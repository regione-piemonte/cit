<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_FunImportLibretto" class="formPanelBlock"><!-- startFragment:p_FunImportLibretto -->
		
	
<div class="formPanel" id="FunImportLibretto">


	
	

	
	
			
	
	<div id="p_wpImportDatiLibretto" class="widgetsPanelBlock"><!-- startFragment:p_wpImportDatiLibretto -->
	
	
<h4 class="wpLabel">import dati libretto </h4>
<div class="widgetsPanel" id="wpImportDatiLibretto">
	
	<customtag:widgetsPanel id="wpImportDatiLibrettoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','fuImpLib')" >

	
<customtag:widgetsPanelColumn  tooltip="selezionare il file xml da inviare" labelField="true" textLabel="%{getText('cpGestImpianto.fuImpLib.label')}" labelFor="widg_fuImpLib" errorFor="widg_fuImpLib" labelId="fuImpLibLbl"
	  >


<s:file 
	
title="selezionare il file xml da inviare"	
	name="widg_fuImpLib" id="widg_fuImpLib"
	disabled="isWidgetDisabled('cpGestImpianto','fuImpLib')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImportDatiLibretto --></div>

			
	
	<div id="p_cpFunImportLibretto" class="commandPanelBlock"><!-- startFragment:p_cpFunImportLibretto -->
	
	
<div class="commandPanel functional" id="cpFunImportLibretto">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestImpianto','btAvviaImport')" >

	



<!-- widget btAvviaImport -->
<s:submit name="widg_btAvviaImport" id="widg_btAvviaImport" method="handleBtAvviaImport_CLICKED"
	key="cpGestImpianto.btAvviaImport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btAvviaImport')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunImportLibretto --></div>

	

		
	
</div>

	<!-- endFragment:p_FunImportLibretto --></div>
