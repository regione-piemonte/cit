<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpUploadRappProvaFirmato" class="formPanelBlock"><!-- startFragment:p_fpUploadRappProvaFirmato -->
		
	
<div class="formPanel" id="fpUploadRappProvaFirmato">


	
	

	
	
			
	
	<div id="p_wpUploadRappProvaFirmato" class="widgetsPanelBlock"><!-- startFragment:p_wpUploadRappProvaFirmato -->
	
	

<div class="widgetsPanel" id="wpUploadRappProvaFirmato">
	
	<customtag:widgetsPanel id="wpUploadRappProvaFirmatoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','tpDataControlloUploadRappProvaFirmato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.tpDataControlloUploadRappProvaFirmato.label')}" labelFor="widg_tpDataControlloUploadRappProvaFirmato" errorFor="appDataallegatoIsp.dataControllo" labelId="tpDataControlloUploadRappProvaFirmatoLbl"  position="first" >


<!-- widget tpDataControlloUploadRappProvaFirmato -->
<s:property value="appDataallegatoIsp.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','tpComponentiUploadRappProvaFirmato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.tpComponentiUploadRappProvaFirmato.label')}" labelFor="widg_tpComponentiUploadRappProvaFirmato" errorFor="appDataallegatoIsp.elencoApparecchiature" labelId="tpComponentiUploadRappProvaFirmatoLbl"  position="last" >


<!-- widget tpComponentiUploadRappProvaFirmato -->
<s:property value="appDataallegatoIsp.elencoApparecchiature" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','fuUploadRappProvaFirmato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.fuUploadRappProvaFirmato.label')}" labelFor="widg_fuUploadRappProvaFirmato" errorFor="widg_fuUploadRappProvaFirmato" labelId="fuUploadRappProvaFirmatoLbl"
	position="first"  >


<s:file 
	
	
	name="widg_fuUploadRappProvaFirmato" id="widg_fuUploadRappProvaFirmato"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','fuUploadRappProvaFirmato')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btnUploadRappProvaFirmato')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnUploadRappProvaFirmato -->
<s:submit name="widg_btnUploadRappProvaFirmato" id="widg_btnUploadRappProvaFirmato" method="handleBtnUploadRappProvaFirmato_CLICKED"
	key="cpDettaglioIspezione2018.btnUploadRappProvaFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btnUploadRappProvaFirmato')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpUploadRappProvaFirmato --></div>

			
	
	<div id="p_cpUploadRappProvaFirmato" class="commandPanelBlock"><!-- startFragment:p_cpUploadRappProvaFirmato -->
	
	
<div class="commandPanel navigation" id="cpUploadRappProvaFirmato">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btnCloseUploadRappProvaFirmato')" >

	



<!-- widget btnCloseUploadRappProvaFirmato -->
<s:submit name="widg_btnCloseUploadRappProvaFirmato" id="widg_btnCloseUploadRappProvaFirmato" method="handleBtnCloseUploadRappProvaFirmato_CLICKED"
	key="cpDettaglioIspezione2018.btnCloseUploadRappProvaFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btnCloseUploadRappProvaFirmato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpUploadRappProvaFirmato --></div>

	

		
	
</div>

	<!-- endFragment:p_fpUploadRappProvaFirmato --></div>
