<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/back_office -->
<!-- pageId:cpGestSubentroMassivo -->

<s:form id="cpGestSubentroMassivo" action="cpGestSubentroMassivo" namespace="/base/back_office" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestSubentroMassivo_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestSubentroMassivo','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestSubentroMassivo_udpSubMass.jsp"></s:include>

	



			
	
	<div id="p_fpSubentroMass" class="formPanelBlock"><!-- startFragment:p_fpSubentroMass -->
		
	
<h4 class="fpLabel"><s:text name="cpGestSubentroMassivo.fpSubentroMass.label" /></h4>
<div class="formPanel" id="fpSubentroMass">


	
	

	
	
			
	
	<div id="p_stdMsgPHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPHome -->
	
	
<div class="stdMessagePanel" id="stdMsgPHome">
	<customtag:stdMessagePanel id="stdMsgPHome" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPHome --></div>

			
	
	<div id="p_fpAbilitazioni" class="formPanelBlock"><!-- startFragment:p_fpAbilitazioni -->
		
	
<div class="formPanel" id="fpAbilitazioni">


	
	

	
	
			
	
	<div id="p_wpGestSubImpAtt" class="widgetsPanelBlock"><!-- startFragment:p_wpGestSubImpAtt -->
	
	
<h4 class="wpLabel">impresa attuale </h4>
<div class="widgetsPanel" id="wpGestSubImpAtt">
	
	<customtag:widgetsPanel id="wpGestSubImpAttTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','cbImpAttSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.cbImpAttSiglaRea.label')}" labelFor="widg_cbImpAttSiglaRea" errorFor="appDataimpresaAttuale.siglaRea" labelId="cbImpAttSiglaReaLbl"
	position="first"  >


<!-- widget cbImpAttSiglaRea -->
<s:select name="appDataimpresaAttuale.siglaRea" id="widg_cbImpAttSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestSubentroMassivo','cbImpAttSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','tfImpAttNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.tfImpAttNumRea.label')}" labelFor="widg_tfImpAttNumRea" errorFor="appDataimpresaAttuale.numeroRea" labelId="tfImpAttNumReaLbl"
	position="last"  >


<!-- widget tfImpAttNumRea -->
<s:textfield 
	
	
	name="appDataimpresaAttuale.numeroRea" id="widg_tfImpAttNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestSubentroMassivo','tfImpAttNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','tfImpAttCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.tfImpAttCf.label')}" labelFor="widg_tfImpAttCf" errorFor="appDataimpresaAttuale.codiceFiscale" labelId="tfImpAttCfLbl"
	position="first" colSpan="3" >


<!-- widget tfImpAttCf -->
<s:textfield 
	
	
	name="appDataimpresaAttuale.codiceFiscale" id="widg_tfImpAttCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestSubentroMassivo','tfImpAttCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','btnCercaImpresaAttuale')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCercaImpresaAttuale -->
<s:submit name="widg_btnCercaImpresaAttuale" id="widg_btnCercaImpresaAttuale" method="handleBtnCercaImpresaAttuale_CLICKED"
	key="cpGestSubentroMassivo.btnCercaImpresaAttuale.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentroMassivo','btnCercaImpresaAttuale')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','cbImpreseAttuali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.cbImpreseAttuali.label')}" labelFor="widg_cbImpreseAttuali" errorFor="appDataimpresaAttuale.idPersonaGiuridica" labelId="cbImpreseAttualiLbl"
	position="first" colSpan="3" >


<!-- widget cbImpreseAttuali -->
<s:select name="appDataimpresaAttuale.idPersonaGiuridica" id="widg_cbImpreseAttuali"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoImpreseAttuali"
	  disabled="isWidgetDisabled('cpGestSubentroMassivo','cbImpreseAttuali')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestSubImpAtt --></div>

			
	
	<div id="p_wpGestSubImpSub" class="widgetsPanelBlock"><!-- startFragment:p_wpGestSubImpSub -->
	
	
<h4 class="wpLabel">impresa che subentra </h4>
<div class="widgetsPanel" id="wpGestSubImpSub">
	
	<customtag:widgetsPanel id="wpGestSubImpSubTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','cbImpSubSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.cbImpSubSiglaRea.label')}" labelFor="widg_cbImpSubSiglaRea" errorFor="appDataimpresaSubentro.siglaRea" labelId="cbImpSubSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSubSiglaRea -->
<s:select name="appDataimpresaSubentro.siglaRea" id="widg_cbImpSubSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestSubentroMassivo','cbImpSubSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','tfImpSubNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.tfImpSubNumRea.label')}" labelFor="widg_tfImpSubNumRea" errorFor="appDataimpresaSubentro.numeroRea" labelId="tfImpSubNumReaLbl"
	position="last"  >


<!-- widget tfImpSubNumRea -->
<s:textfield 
	
	
	name="appDataimpresaSubentro.numeroRea" id="widg_tfImpSubNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestSubentroMassivo','tfImpSubNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','tfImpSubCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.tfImpSubCf.label')}" labelFor="widg_tfImpSubCf" errorFor="appDataimpresaSubentro.codiceFiscale" labelId="tfImpSubCfLbl"
	position="first" colSpan="3" >


<!-- widget tfImpSubCf -->
<s:textfield 
	
	
	name="appDataimpresaSubentro.codiceFiscale" id="widg_tfImpSubCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestSubentroMassivo','tfImpSubCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','btnCercaImpresaSubentro')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCercaImpresaSubentro -->
<s:submit name="widg_btnCercaImpresaSubentro" id="widg_btnCercaImpresaSubentro" method="handleBtnCercaImpresaSubentro_CLICKED"
	key="cpGestSubentroMassivo.btnCercaImpresaSubentro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentroMassivo','btnCercaImpresaSubentro')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','cbImpreseSubentro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.cbImpreseSubentro.label')}" labelFor="widg_cbImpreseSubentro" errorFor="appDataimpresaSubentro.idPersonaGiuridica" labelId="cbImpreseSubentroLbl"
	position="first" colSpan="3" >


<!-- widget cbImpreseSubentro -->
<s:select name="appDataimpresaSubentro.idPersonaGiuridica" id="widg_cbImpreseSubentro"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoImpreseSubentro"
	  disabled="isWidgetDisabled('cpGestSubentroMassivo','cbImpreseSubentro')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestSubImpSub --></div>

			
	
	<div id="p_wpGestTipoSub" class="widgetsPanelBlock"><!-- startFragment:p_wpGestTipoSub -->
	
	
<h4 class="wpLabel">tipo subentro </h4>
<div class="widgetsPanel" id="wpGestTipoSub">
	
	<customtag:widgetsPanel id="wpGestTipoSubTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','cbTipoSubentro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentroMassivo.cbTipoSubentro.label')}" labelFor="widg_cbTipoSubentro" errorFor="appDataidTipoSubentro" labelId="cbTipoSubentroLbl"
	position="first"  >


<!-- widget cbTipoSubentro -->
<s:select name="appDataidTipoSubentro" id="widg_cbTipoSubentro"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoRuolo"
	  disabled="isWidgetDisabled('cpGestSubentroMassivo','cbTipoSubentro')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','wpGestTipoSub_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpGestTipoSub_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','wpGestTipoSub_2_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpGestTipoSub_2_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','wpGestTipoSub_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpGestTipoSub_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','wpGestTipoSub_3_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpGestTipoSub_3_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','wpGestTipoSub_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpGestTipoSub_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','wpGestTipoSub_4_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpGestTipoSub_4_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentroMassivo','wpGestTipoSub_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpGestTipoSub_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestTipoSub --></div>

			
	
	<div id="p_cpSibentro" class="commandPanelBlock"><!-- startFragment:p_cpSibentro -->
	
	
<div class="commandPanel functional" id="cpSibentro">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestSubentroMassivo','btnEseguiSubentro')" >

	



<!-- widget btnEseguiSubentro -->
<s:submit name="widg_btnEseguiSubentro" id="widg_btnEseguiSubentro" method="handleBtnEseguiSubentro_CLICKED"
	key="cpGestSubentroMassivo.btnEseguiSubentro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentroMassivo','btnEseguiSubentro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpSibentro --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAbilitazioni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpSubentroMass --></div>

			
	
	<div id="p_cpElencoAbilBack" class="commandPanelBlock"><!-- startFragment:p_cpElencoAbilBack -->
	
	
<div class="commandPanel navigation" id="cpElencoAbilBack">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestSubentroMassivo','cbIndietro')" >

	



<!-- widget cbIndietro -->
<s:submit name="widg_cbIndietro" id="widg_cbIndietro" method="handleCbIndietro_CLICKED"
	key="cpGestSubentroMassivo.cbIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentroMassivo','cbIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoAbilBack --></div>

	

	<!-- endFragment:p_fpCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
