<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpInstallatore" class="formPanelBlock"><!-- startFragment:p_fpInstallatore -->
		
	
<div class="formPanel" id="fpInstallatore">


	
	

	
	
			
	
	<div id="p_wpInstallatore" class="widgetsPanelBlock"><!-- startFragment:p_wpInstallatore -->
	
	
<h4 class="wpLabel">Impresa o PF abilitata al libretto </h4>
<div class="widgetsPanel" id="wpInstallatore">
	
	<customtag:widgetsPanel id="wpInstallatoreTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','cbInstSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbInstSiglaRea.label')}" labelFor="widg_cbInstSiglaRea" errorFor="appDataimpianto.instIdSiglaRea" labelId="cbInstSiglaReaLbl"
	position="first"  >


<!-- widget cbInstSiglaRea -->
<s:select name="appDataimpianto.instIdSiglaRea" id="widg_cbInstSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestImpianto','cbInstSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfInstNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfInstNumRea.label')}" labelFor="widg_tfInstNumRea" errorFor="appDataimpianto.instNumeroRea" labelId="tfInstNumReaLbl"
	position="last"  >


<!-- widget tfInstNumRea -->
<s:textfield 
	
title=""	
	name="appDataimpianto.instNumeroRea" id="widg_tfInstNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestImpianto','tfInstNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfInstCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfInstCf.label')}" labelFor="widg_tfInstCf" errorFor="appDataimpianto.instCf" labelId="tfInstCfLbl"
	position="first"  >


<!-- widget tfInstCf -->
<s:textfield 
	
title=""	
	name="appDataimpianto.instCf" id="widg_tfInstCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestImpianto','tfInstCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpInstallatore_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInstallatore_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnInstCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnInstCercaCF -->
<s:submit name="widg_btnInstCercaCF" id="widg_btnInstCercaCF" method="handleBtnInstCercaCF_CLICKED"
	key="cpGestImpianto.btnInstCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnInstCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnInstNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnInstNuovaRicercaCF -->
<s:submit name="widg_btnInstNuovaRicercaCF" id="widg_btnInstNuovaRicercaCF" method="handleBtnInstNuovaRicercaCF_CLICKED"
	key="cpGestImpianto.btnInstNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnInstNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfInstImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfInstImpresa.label')}" labelFor="widg_tfInstImpresa" errorFor="appDataimpianto.instImpresa" labelId="tfInstImpresaLbl"
	position="first"  >


<!-- widget tfInstImpresa -->
<s:textfield 
	
title=""	
	name="appDataimpianto.instImpresa" id="widg_tfInstImpresa"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpianto','tfInstImpresa')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpInstallatore_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInstallatore_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbInstPrimoCaricatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbInstPrimoCaricatore.label')}" labelFor="widg_cbInstPrimoCaricatore" errorFor="appDataimpianto.instPrimoCaricatore" labelId="cbInstPrimoCaricatoreLbl"
	position="first"  >


<!-- widget cbInstPrimoCaricatore -->
<s:checkbox 
	
	
	name="appDataimpianto.instPrimoCaricatore" id="widg_cbInstPrimoCaricatore"
	disabled="isWidgetDisabled('cpGestImpianto','cbInstPrimoCaricatore')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpianto','cbInstPrimoCaricatore')" >
	<s:hidden name="__checkbox_appDataimpianto.instPrimoCaricatore" id="__checkbox_widg_cbInstPrimoCaricatore" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpInstallatore_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInstallatore_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInstallatore --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInstallatore --></div>
