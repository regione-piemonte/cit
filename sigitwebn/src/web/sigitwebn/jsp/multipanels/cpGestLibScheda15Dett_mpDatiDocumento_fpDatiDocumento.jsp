<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiDocumento" class="formPanelBlock"><!-- startFragment:p_fpDatiDocumento -->
		
	
<div class="formPanel" id="fpDatiDocumento">


	
	

	
	
			
	
	<div id="p_wpFileDocumento" class="widgetsPanelBlock"><!-- startFragment:p_wpFileDocumento -->
	
	
<h4 class="wpLabel">dati documento </h4>
<div class="widgetsPanel" id="wpFileDocumento">
	
	<customtag:widgetsPanel id="wpFileDocumentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','fuUploadDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.fuUploadDoc.label')}" labelFor="widg_fuUploadDoc" errorFor="widg_fuUploadDoc" labelId="fuUploadDocLbl"
	  >


<s:file 
	
	
	name="widg_fuUploadDoc" id="widg_fuUploadDoc"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','fuUploadDoc')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','tfDescDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.tfDescDoc.label')}" labelFor="widg_tfDescDoc" errorFor="appDatadocumento.descAltroDoc" labelId="tfDescDocLbl"
	  >


<!-- widget tfDescDoc -->
<s:textfield 
	
	
	name="appDatadocumento.descAltroDoc" id="widg_tfDescDoc"
maxlength="100"	disabled="isWidgetDisabled('cpGestLibScheda15Dett','tfDescDoc')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpFileDocumento --></div>

			
	
	<div id="p_cpNavDatiDocumento" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiDocumento -->
	
	
<div class="commandPanel functional" id="cpNavDatiDocumento">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnChiudiDatiDocumento')" >

	



<!-- widget btnChiudiDatiDocumento -->
<s:submit name="widg_btnChiudiDatiDocumento" id="widg_btnChiudiDatiDocumento" method="handleBtnChiudiDatiDocumento_CLICKED"
	key="cpGestLibScheda15Dett.btnChiudiDatiDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnChiudiDatiDocumento')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnCaricaDocumento')" >

	



<!-- widget btnCaricaDocumento -->
<s:submit name="widg_btnCaricaDocumento" id="widg_btnCaricaDocumento" method="handleBtnCaricaDocumento_CLICKED"
	key="cpGestLibScheda15Dett.btnCaricaDocumento.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnCaricaDocumento')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiDocumento --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiDocumento --></div>
