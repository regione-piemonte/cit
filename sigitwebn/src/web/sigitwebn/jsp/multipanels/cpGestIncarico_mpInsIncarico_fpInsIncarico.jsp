<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpInsIncarico" class="formPanelBlock"><!-- startFragment:p_fpInsIncarico -->
		
	
<div class="formPanel" id="fpInsIncarico">


	
	

	
	
			
	
	<div id="p_wpInsIncarico" class="widgetsPanelBlock"><!-- startFragment:p_wpInsIncarico -->
	
	

<div class="widgetsPanel" id="wpInsIncarico">
	
	<customtag:widgetsPanel id="wpInsIncaricoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestIncarico','cbIncCat')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestIncarico.cbIncCat.label')}" labelFor="widg_cbIncCat" errorFor="appDataincaricato.idIncaricato" labelId="cbIncCatLbl"
	position="first"  >


<!-- widget cbIncCat -->
<s:select name="appDataincaricato.idIncaricato" id="widg_cbIncCat"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoCat"
	  disabled="isWidgetDisabled('cpGestIncarico','cbIncCat')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','wpInsIncarico_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInsIncarico_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','tfDelDataDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestIncarico.tfDelDataDal.label')}" labelFor="widg_tfDelDataDal" errorFor="appDataincaricato.dataIncaricoDal" labelId="tfDelDataDalLbl"
	position="first"  >


<!-- widget tfDelDataDal -->
<s:textfield 
	
	
	name="appDataincaricato.dataIncaricoDal" id="widg_tfDelDataDal"
maxlength="100"	disabled="isWidgetDisabled('cpGestIncarico','tfDelDataDal')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','wpInsIncarico_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInsIncarico_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','btnDelAnnulla')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnDelAnnulla -->
<s:submit name="widg_btnDelAnnulla" id="widg_btnDelAnnulla" method="handleBtnDelAnnulla_CLICKED"
	key="cpGestIncarico.btnDelAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btnDelAnnulla')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestIncarico','btnDelConferma')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnDelConferma -->
<s:submit name="widg_btnDelConferma" id="widg_btnDelConferma" method="handleBtnDelConferma_CLICKED"
	key="cpGestIncarico.btnDelConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btnDelConferma')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInsIncarico --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInsIncarico --></div>
