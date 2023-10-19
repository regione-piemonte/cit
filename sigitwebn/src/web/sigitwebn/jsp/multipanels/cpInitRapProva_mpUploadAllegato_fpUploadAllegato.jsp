<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpUploadAllegato" class="formPanelBlock"><!-- startFragment:p_fpUploadAllegato -->
		
	
<div class="formPanel" id="fpUploadAllegato">


	
	

	
	
			
	
	<div id="p_wpUploadAllegato" class="widgetsPanelBlock"><!-- startFragment:p_wpUploadAllegato -->
	
	

<div class="widgetsPanel" id="wpUploadAllegato">
	
	<customtag:widgetsPanel id="wpUploadAllegatoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInitRapProva','fuUploadAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInitRapProva.fuUploadAllegato.label')}" labelFor="widg_fuUploadAllegato" errorFor="widg_fuUploadAllegato" labelId="fuUploadAllegatoLbl"
	position="first"  >


<s:file 
	
	
	name="widg_fuUploadAllegato" id="widg_fuUploadAllegato"
	disabled="isWidgetDisabled('cpInitRapProva','fuUploadAllegato')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInitRapProva','btnCaricaUploadAllegato')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCaricaUploadAllegato -->
<s:submit name="widg_btnCaricaUploadAllegato" id="widg_btnCaricaUploadAllegato" method="handleBtnCaricaUploadAllegato_CLICKED"
	key="cpInitRapProva.btnCaricaUploadAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnCaricaUploadAllegato')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpUploadAllegato --></div>

	

		
	
</div>

	<!-- endFragment:p_fpUploadAllegato --></div>
