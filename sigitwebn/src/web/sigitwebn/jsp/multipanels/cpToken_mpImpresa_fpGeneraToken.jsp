<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpGeneraToken" class="formPanelBlock"><!-- startFragment:p_fpGeneraToken -->
		
	
<div class="formPanel" id="fpGeneraToken">


	
	

	
	
			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpToken','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDataimpresa.siglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:textfield 
	
	
	name="appDataimpresa.siglaRea" id="widg_cbImpSiglaRea"
	disabled="isWidgetDisabled('cpToken','cbImpSiglaRea')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDataimpresa.numeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDataimpresa.numeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpToken','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','tfImpCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.tfImpCf.label')}" labelFor="widg_tfImpCf" errorFor="appDataimpresa.codiceFiscale" labelId="tfImpCfLbl"
	position="first"  >


<!-- widget tfImpCf -->
<s:textfield 
	
	
	name="appDataimpresa.codiceFiscale" id="widg_tfImpCf"
maxlength="16"	disabled="isWidgetDisabled('cpToken','tfImpCf')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpImpresa_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','tfImpImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.tfImpImpresa.label')}" labelFor="widg_tfImpImpresa" errorFor="appDataimpresa.denominazione" labelId="tfImpImpresaLbl"
	position="first"  >


<!-- widget tfImpImpresa -->
<s:textfield 
	
	
	name="appDataimpresa.denominazione" id="widg_tfImpImpresa"
maxlength="50"	disabled="isWidgetDisabled('cpToken','tfImpImpresa')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpImpresa_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','ptTokenImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpToken.ptTokenImp.label')}" labelFor="widg_ptTokenImp" errorFor="appDataimpresa.token" labelId="ptTokenImpLbl"  position="first" >


<!-- widget ptTokenImp -->
<s:property value="appDataimpresa.token" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpImpresa_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','tfTokenDataGen')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.tfTokenDataGen.label')}" labelFor="widg_tfTokenDataGen" errorFor="appDataimpresa.dtCreazioneToken" labelId="tfTokenDataGenLbl"
	position="first"  >


<!-- widget tfTokenDataGen -->
<s:textfield 
	
	
	name="appDataimpresa.dtCreazioneToken" id="widg_tfTokenDataGen"
	disabled="isWidgetDisabled('cpToken','tfTokenDataGen')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpImpresa_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','tfTokenDataScadenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpToken.tfTokenDataScadenza.label')}" labelFor="widg_tfTokenDataScadenza" errorFor="appDataimpresa.dtScadenzaToken" labelId="tfTokenDataScadenzaLbl"
	position="first"  >


<!-- widget tfTokenDataScadenza -->
<s:textfield 
	
	
	name="appDataimpresa.dtScadenzaToken" id="widg_tfTokenDataScadenza"
	disabled="isWidgetDisabled('cpToken','tfTokenDataScadenza')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpImpresa_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','btnGenera')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnGenera -->
<s:submit name="widg_btnGenera" id="widg_btnGenera" method="handleBtnGenera_CLICKED"
	key="cpToken.btnGenera.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpToken','btnGenera')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpImpresa_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','ptTokenImpMessage')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpToken.ptTokenImpMessage.label')}" labelFor="widg_ptTokenImpMessage" errorFor="widg_ptTokenImpMessage" labelId="ptTokenImpMessageLbl"  position="first" >


<!-- widget ptTokenImpMessage -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpToken','wpImpresa_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpresa --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGeneraToken --></div>
