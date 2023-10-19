<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpInsDelegato" class="formPanelBlock"><!-- startFragment:p_fpInsDelegato -->
		
	
<div class="formPanel" id="fpInsDelegato">


	
	

	
	
			
	
	<div id="p_wpInsDelegato" class="widgetsPanelBlock"><!-- startFragment:p_wpInsDelegato -->
	
	

<div class="widgetsPanel" id="wpInsDelegato">
	
	<customtag:widgetsPanel id="wpInsDelegatoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestDelega','tfDelCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.tfDelCf.label')}" labelFor="widg_tfDelCf" errorFor="appDatadelegato.codiceFiscale" labelId="tfDelCfLbl"
	position="first"  >


<!-- widget tfDelCf -->
<s:textfield 
	
	
	name="appDatadelegato.codiceFiscale" id="widg_tfDelCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestDelega','tfDelCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','btnDelegatoCercaCf')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnDelegatoCercaCf -->
<s:submit name="widg_btnDelegatoCercaCf" id="widg_btnDelegatoCercaCf" method="handleBtnDelegatoCercaCf_CLICKED"
	key="cpGestDelega.btnDelegatoCercaCf.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnDelegatoCercaCf')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','tfDelCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.tfDelCognome.label')}" labelFor="widg_tfDelCognome" errorFor="appDatadelegato.cognome" labelId="tfDelCognomeLbl"
	position="first"  >


<!-- widget tfDelCognome -->
<s:textfield 
	
	
	name="appDatadelegato.cognome" id="widg_tfDelCognome"
maxlength="100"	disabled="isWidgetDisabled('cpGestDelega','tfDelCognome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','btnDelegatoNuovaRicercaCf')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnDelegatoNuovaRicercaCf -->
<s:submit name="widg_btnDelegatoNuovaRicercaCf" id="widg_btnDelegatoNuovaRicercaCf" method="handleBtnDelegatoNuovaRicercaCf_CLICKED"
	key="cpGestDelega.btnDelegatoNuovaRicercaCf.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnDelegatoNuovaRicercaCf')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','tfDelNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.tfDelNome.label')}" labelFor="widg_tfDelNome" errorFor="appDatadelegato.nome" labelId="tfDelNomeLbl"
	position="first"  >


<!-- widget tfDelNome -->
<s:textfield 
	
	
	name="appDatadelegato.nome" id="widg_tfDelNome"
maxlength="100"	disabled="isWidgetDisabled('cpGestDelega','tfDelNome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','wpInsDelegato_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInsDelegato_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','tfDelDataDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.tfDelDataDal.label')}" labelFor="widg_tfDelDataDal" errorFor="appDatadelegato.dataDelegaDal" labelId="tfDelDataDalLbl"
	position="first"  >


<!-- widget tfDelDataDal -->
<s:textfield 
	
	
	name="appDatadelegato.dataDelegaDal" id="widg_tfDelDataDal"
maxlength="100"	disabled="isWidgetDisabled('cpGestDelega','tfDelDataDal')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','wpInsDelegato_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInsDelegato_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','btnDelAnnulla')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnDelAnnulla -->
<s:submit name="widg_btnDelAnnulla" id="widg_btnDelAnnulla" method="handleBtnDelAnnulla_CLICKED"
	key="cpGestDelega.btnDelAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnDelAnnulla')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','btnDelConferma')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnDelConferma -->
<s:submit name="widg_btnDelConferma" id="widg_btnDelConferma" method="handleBtnDelConferma_CLICKED"
	key="cpGestDelega.btnDelConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnDelConferma')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInsDelegato --></div>

	

		
	
</div>

	<!-- endFragment:p_fpInsDelegato --></div>
