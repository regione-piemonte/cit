<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_delega/CpGestDelegaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_delega -->
<!-- pageId:cpGestDelega -->

<s:form id="cpGestDelega" action="cpGestDelega" namespace="/base/gestisci_delega" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestDelega_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestDelega','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestDelegaTitolo" class="formPanelBlock"><!-- startFragment:p_fpGestDelegaTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestDelega.fpGestDelegaTitolo.label" /></h4>
<div class="formPanel" id="fpGestDelegaTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestDelegaTitolo --></div>

			
	
	<div id="p_fpGestDelega" class="formPanelBlock"><!-- startFragment:p_fpGestDelega -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPGestDel" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestDel -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestDel">
	<customtag:stdMessagePanel id="stdMsgPGestDel" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestDel --></div>

			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestDelega','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDatadelega.impIdSiglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:select name="appDatadelega.impIdSiglaRea" id="widg_cbImpSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestDelega','cbImpSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDatadelega.impNumeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDatadelega.impNumeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestDelega','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','tfInstCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.tfInstCf.label')}" labelFor="widg_tfInstCf" errorFor="appDatadelega.impCf" labelId="tfInstCfLbl"
	position="first"  >


<!-- widget tfInstCf -->
<s:textfield 
	
title=""	
	name="appDatadelega.impCf" id="widg_tfInstCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestDelega','tfInstCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','wpImpresa_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','btnImpCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnImpCercaCF -->
<s:submit name="widg_btnImpCercaCF" id="widg_btnImpCercaCF" method="handleBtnImpCercaCF_CLICKED"
	key="cpGestDelega.btnImpCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnImpCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','btnImpNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpNuovaRicercaCF -->
<s:submit name="widg_btnImpNuovaRicercaCF" id="widg_btnImpNuovaRicercaCF" method="handleBtnImpNuovaRicercaCF_CLICKED"
	key="cpGestDelega.btnImpNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnImpNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','tfImpImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestDelega.tfImpImpresa.label')}" labelFor="widg_tfImpImpresa" errorFor="appDatadelega.impImpresa" labelId="tfImpImpresaLbl"
	position="first"  >


<!-- widget tfImpImpresa -->
<s:textfield 
	
	
	name="appDatadelega.impImpresa" id="widg_tfImpImpresa"
maxlength="50"	disabled="isWidgetDisabled('cpGestDelega','tfImpImpresa')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestDelega','wpImpresa_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpresa_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpresa --></div>

			
	
	
	<div id="p_mpDelegati" class="panelBlock"><!-- startFragment:p_mpDelegati -->
		

		
<s:if test="#session.cpGestDelega_mpDelegati_selectedMultiPanel == 'cpGestDelega_mpDelegati_fpDelegati'">
	<s:include value="/jsp/multipanels/cpGestDelega_mpDelegati_fpDelegati.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDelegati --></div>

			
	
	
	<div id="p_mpInsDelegato" class="panelBlock"><!-- startFragment:p_mpInsDelegato -->
		

		
<s:if test="#session.cpGestDelega_mpInsDelegato_selectedMultiPanel == 'cpGestDelega_mpInsDelegato_fpInsDelegato'">
	<s:include value="/jsp/multipanels/cpGestDelega_mpInsDelegato_fpInsDelegato.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpInsDelegato --></div>

			
	
	
	<div id="p_mpDelegatiPotenziali" class="panelBlock"><!-- startFragment:p_mpDelegatiPotenziali -->
		

		
<s:if test="#session.cpGestDelega_mpDelegatiPotenziali_selectedMultiPanel == 'cpGestDelega_mpDelegatiPotenziali_fpDelegatiPotenziali'">
	<s:include value="/jsp/multipanels/cpGestDelega_mpDelegatiPotenziali_fpDelegatiPotenziali.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDelegatiPotenziali --></div>

			
	
	<div id="p_cpNavGestDelega" class="commandPanelBlock"><!-- startFragment:p_cpNavGestDelega -->
	
	
<div class="commandPanel navigation" id="cpNavGestDelega">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDelega','btnDelIndietro')" >

	



<!-- widget btnDelIndietro -->
<s:submit name="widg_btnDelIndietro" id="widg_btnDelIndietro" method="handleBtnDelIndietro_CLICKED"
	key="cpGestDelega.btnDelIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btnDelIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestDelega --></div>

	

		
	

	<!-- endFragment:p_fpGestDelega --></div>

	

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
