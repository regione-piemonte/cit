<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiIspezione" class="formPanelBlock"><!-- startFragment:p_fpDatiIspezione -->
		
	
<div class="formPanel" id="fpDatiIspezione">


	
	

	
	
			
	
	<div id="p_wpInfoIspezione" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoIspezione -->
	
	
<h4 class="wpLabel">ispezione </h4>
<div class="widgetsPanel" id="wpInfoIspezione">
	
	<customtag:widgetsPanel id="wpInfoIspezioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','ptDataIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.ptDataIspezione.label')}" labelFor="widg_ptDataIspezione" errorFor="appDataidentificativoIspezione.dataIspezione" labelId="ptDataIspezioneLbl"  position="first" >


<!-- widget ptDataIspezione -->
<s:property value="appDataidentificativoIspezione.dataIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','ptEnteComp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.ptEnteComp.label')}" labelFor="widg_ptEnteComp" errorFor="appDataidentificativoIspezione.enteCompetente" labelId="ptEnteCompLbl"  position="last" >


<!-- widget ptEnteComp -->
<s:property value="appDataidentificativoIspezione.enteCompetente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','ptStatoIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.ptStatoIspezione.label')}" labelFor="widg_ptStatoIspezione" errorFor="appDataidentificativoIspezione.statoIspezione" labelId="ptStatoIspezioneLbl"  position="first" >


<!-- widget ptStatoIspezione -->
<s:property value="appDataidentificativoIspezione.statoIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','ptEsitoIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.ptEsitoIspezione.label')}" labelFor="widg_ptEsitoIspezione" errorFor="appDataidentificativoIspezione.esitoIspezione" labelId="ptEsitoIspezioneLbl"  position="last" >


<!-- widget ptEsitoIspezione -->
<s:property value="appDataidentificativoIspezione.esitoIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoIspezione --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiIspezione --></div>
