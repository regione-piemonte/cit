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
	

	
	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','fuUploadDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestisciReeDocumenti.fuUploadDoc.label')}" labelFor="widg_fuUploadDoc" errorFor="widg_fuUploadDoc" labelId="fuUploadDocLbl"
	  >


<s:file 
	
	
	name="widg_fuUploadDoc" id="widg_fuUploadDoc"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','fuUploadDoc')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpFileDocumento --></div>

			
	
	<div id="p_wpDatiDocumento" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiDocumento -->
	
	

<div class="widgetsPanel" id="wpDatiDocumento">
	
	<customtag:widgetsPanel id="wpDatiDocumentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','tfDescDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestisciReeDocumenti.tfDescDoc.label')}" labelFor="widg_tfDescDoc" errorFor="appDatadocumento.descAltroDoc" labelId="tfDescDocLbl"
	  >


<!-- widget tfDescDoc -->
<s:textfield 
	
	
	name="appDatadocumento.descAltroDoc" id="widg_tfDescDoc"
maxlength="100"	disabled="isWidgetDisabled('cpGestisciReeDocumenti','tfDescDoc')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiDocumento --></div>

			
	
	<div id="p_cpNavDatiDocumento" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiDocumento -->
	
	
<div class="commandPanel navigation" id="cpNavDatiDocumento">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btnChiudiDatiDocumento')" >

	



<!-- widget btnChiudiDatiDocumento -->
<s:submit name="widg_btnChiudiDatiDocumento" id="widg_btnChiudiDatiDocumento" method="handleBtnChiudiDatiDocumento_CLICKED"
	key="cpGestisciReeDocumenti.btnChiudiDatiDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btnChiudiDatiDocumento')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btnCaricaDocumento')" >

	



<!-- widget btnCaricaDocumento -->
<s:submit name="widg_btnCaricaDocumento" id="widg_btnCaricaDocumento" method="handleBtnCaricaDocumento_CLICKED"
	key="cpGestisciReeDocumenti.btnCaricaDocumento.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btnCaricaDocumento')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiDocumento --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiDocumento --></div>
