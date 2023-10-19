<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpInsDocumento" class="formPanelBlock"><!-- startFragment:p_fpInsDocumento -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda3.fpInsDocumento.label" /></h4>
<div class="formPanel" id="fpInsDocumento">


	
	

	
	
			
	
	<div id="p_wpInsDocumento" class="widgetsPanelBlock"><!-- startFragment:p_wpInsDocumento -->
	
	

<div class="widgetsPanel" id="wpInsDocumento">
	
	<customtag:widgetsPanel id="wpInsDocumentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','fuUpload')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.fuUpload.label')}" labelFor="widg_fuUpload" errorFor="widg_fuUpload" labelId="fuUploadLbl"
	  >


<s:file 
	
	
	name="widg_fuUpload" id="widg_fuUpload"
	disabled="isWidgetDisabled('cpGestLibScheda3','fuUpload')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','tfDescrizioneDoc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.tfDescrizioneDoc.label')}" labelFor="widg_tfDescrizioneDoc" errorFor="appDatanuovoDocContratto.descrizione" labelId="tfDescrizioneDocLbl"
	  >


<!-- widget tfDescrizioneDoc -->
<s:textfield 
	
	
	name="appDatanuovoDocContratto.descrizione" id="widg_tfDescrizioneDoc"
maxlength="100"	disabled="isWidgetDisabled('cpGestLibScheda3','tfDescrizioneDoc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInsDocumento --></div>

			
	
	<div id="p_cpCaricaDoc" class="commandPanelBlock"><!-- startFragment:p_cpCaricaDoc -->
	
	
<div class="commandPanel functional" id="cpCaricaDoc">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btCaricaDoc')" >

	



<!-- widget btCaricaDoc -->
<s:submit name="widg_btCaricaDoc" id="widg_btCaricaDoc" method="handleBtCaricaDoc_CLICKED"
	key="cpGestLibScheda3.btCaricaDoc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btCaricaDoc')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpCaricaDoc --></div>

			
	
	<div id="p_cpChiudiDoc" class="commandPanelBlock"><!-- startFragment:p_cpChiudiDoc -->
	
	
<div class="commandPanel navigation" id="cpChiudiDoc">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btChiudiDoc')" >

	



<!-- widget btChiudiDoc -->
<s:submit name="widg_btChiudiDoc" id="widg_btChiudiDoc" method="handleBtChiudiDoc_CLICKED"
	key="cpGestLibScheda3.btChiudiDoc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btChiudiDoc')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpChiudiDoc --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInsDocumento --></div>
