<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/token -->
<!-- pageId:cpToken -->

<s:form id="cpToken" action="cpToken" namespace="/base/token" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpToken_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpToken','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGeneraTokenTitolo" class="formPanelBlock"><!-- startFragment:p_fpGeneraTokenTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpToken.fpGeneraTokenTitolo.label" /></h4>
<div class="formPanel" id="fpGeneraTokenTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGeneraTokenTitolo --></div>

			
	
	<div id="p_fpGenToken" class="formPanelBlock"><!-- startFragment:p_fpGenToken -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPGeneraToken" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGeneraToken -->
	
	
<div class="stdMessagePanel" id="stdMsgPGeneraToken">
	<customtag:stdMessagePanel id="stdMsgPGeneraToken" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGeneraToken --></div>

			
	
	
	<div id="p_mpFruitori" class="panelBlock"><!-- startFragment:p_mpFruitori -->
		

		
<s:if test="#session.cpToken_mpFruitori_selectedMultiPanel == 'cpToken_mpFruitori_fpGeneraTokenFruitori'">
	<s:include value="/jsp/multipanels/cpToken_mpFruitori_fpGeneraTokenFruitori.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpFruitori --></div>

			
	
	
	<div id="p_mpImpresa" class="panelBlock"><!-- startFragment:p_mpImpresa -->
		

		
<s:if test="#session.cpToken_mpImpresa_selectedMultiPanel == 'cpToken_mpImpresa_fpGeneraToken'">
	<s:include value="/jsp/multipanels/cpToken_mpImpresa_fpGeneraToken.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpImpresa --></div>

			
	
	<div id="p_cpNavImpresa" class="commandPanelBlock"><!-- startFragment:p_cpNavImpresa -->
	
	
<div class="commandPanel navigation" id="cpNavImpresa">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpToken','btnImpIndietro')" >

	



<!-- widget btnImpIndietro -->
<s:submit name="widg_btnImpIndietro" id="widg_btnImpIndietro" method="handleBtnImpIndietro_CLICKED"
	key="cpToken.btnImpIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpToken','btnImpIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavImpresa --></div>

	

		
	

	<!-- endFragment:p_fpGenToken --></div>

	

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
