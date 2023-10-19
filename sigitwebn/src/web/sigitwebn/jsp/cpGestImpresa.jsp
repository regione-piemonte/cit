<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_impresa/CpGestImpresaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_impresa -->
<!-- pageId:cpGestImpresa -->

<s:form id="cpGestImpresa" action="cpGestImpresa" namespace="/base/gestisci_impresa" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestImpresa_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestImpresa','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestImpresa" class="formPanelBlock"><!-- startFragment:p_fpGestImpresa -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPGestImpresa" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestImpresa -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestImpresa">
	<customtag:stdMessagePanel id="stdMsgPGestImpresa" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestImpresa --></div>

			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpresa','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDataricercaImprese.siglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:select name="appDataricercaImprese.siglaRea" id="widg_cbImpSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestImpresa','cbImpSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDataricercaImprese.numeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDataricercaImprese.numeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestImpresa','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpCf.label')}" labelFor="widg_tfImpCf" errorFor="appDataricercaImprese.codiceFiscale" labelId="tfImpCfLbl"
	position="first"  >


<!-- widget tfImpCf -->
<s:textfield 
	
	
	name="appDataricercaImprese.codiceFiscale" id="widg_tfImpCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestImpresa','tfImpCf')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpImpresa_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','tfImpImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.tfImpImpresa.label')}" labelFor="widg_tfImpImpresa" errorFor="appDataricercaImprese.denominazione" labelId="tfImpImpresaLbl"
	position="first"  >


<!-- widget tfImpImpresa -->
<s:textfield 
	
	
	name="appDataricercaImprese.denominazione" id="widg_tfImpImpresa"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpresa','tfImpImpresa')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpImpresa_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbRuolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbRuolo.label')}" labelFor="widg_cbRuolo" errorFor="appDataricercaImprese.descRuolo" labelId="cbRuoloLbl"
	position="first"  >


<!-- widget cbRuolo -->
<s:select name="appDataricercaImprese.descRuolo" id="widg_cbRuolo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataruoliImpresa"
	  disabled="isWidgetDisabled('cpGestImpresa','cbRuolo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpImpresa_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','cbStatoImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpresa.cbStatoImp.label')}" labelFor="widg_cbStatoImp" errorFor="appDataricercaImprese.idStatoPg" labelId="cbStatoImpLbl"
	position="first"  >


<!-- widget cbStatoImp -->
<s:select name="appDataricercaImprese.idStatoPg" id="widg_cbStatoImp"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoImp"
	  disabled="isWidgetDisabled('cpGestImpresa','cbStatoImp')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpImpresa_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','btnImpCerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnImpCerca -->
<s:submit name="widg_btnImpCerca" id="widg_btnImpCerca" method="handleBtnImpCerca_CLICKED"
	key="cpGestImpresa.btnImpCerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btnImpCerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpresa','wpImpresa_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpresa --></div>

			
	
	
	<div id="p_mpImTrovate" class="panelBlock"><!-- startFragment:p_mpImTrovate -->
		

		
<s:if test="#session.cpGestImpresa_mpImTrovate_selectedMultiPanel == 'cpGestImpresa_mpImTrovate_fpImpTrovate'">
	<s:include value="/jsp/multipanels/cpGestImpresa_mpImTrovate_fpImpTrovate.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpImTrovate --></div>

			
	
	
	<div id="p_mpImpresa" class="panelBlock"><!-- startFragment:p_mpImpresa -->
		

		
<s:if test="#session.cpGestImpresa_mpImpresa_selectedMultiPanel == 'cpGestImpresa_mpImpresa_fmDettImpresa'">
	<s:include value="/jsp/multipanels/cpGestImpresa_mpImpresa_fmDettImpresa.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpImpresa --></div>

			
	
	
	<div id="p_mpVisuraImpresa" class="panelBlock"><!-- startFragment:p_mpVisuraImpresa -->
		

		
<s:if test="#session.cpGestImpresa_mpVisuraImpresa_selectedMultiPanel == 'cpGestImpresa_mpVisuraImpresa_fmVisuraImpresa'">
	<s:include value="/jsp/multipanels/cpGestImpresa_mpVisuraImpresa_fmVisuraImpresa.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpVisuraImpresa --></div>

			
	
	
	<div id="p_mpDatiCat" class="panelBlock"><!-- startFragment:p_mpDatiCat -->
		

		
<s:if test="#session.cpGestImpresa_mpDatiCat_selectedMultiPanel == 'cpGestImpresa_mpDatiCat_fmDatiCat'">
	<s:include value="/jsp/multipanels/cpGestImpresa_mpDatiCat_fmDatiCat.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiCat --></div>

			
	
	<div id="p_cpNavImpresa" class="commandPanelBlock"><!-- startFragment:p_cpNavImpresa -->
	
	
<div class="commandPanel navigation" id="cpNavImpresa">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpresa','btnImpIndietro')" >

	



<!-- widget btnImpIndietro -->
<s:submit name="widg_btnImpIndietro" id="widg_btnImpIndietro" method="handleBtnImpIndietro_CLICKED"
	key="cpGestImpresa.btnImpIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpresa','btnImpIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavImpresa --></div>

	

		
	

	<!-- endFragment:p_fpGestImpresa --></div>

	

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
