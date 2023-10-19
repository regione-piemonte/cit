<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_impianto/CpGestImpiantoRespPropAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_impianto -->
<!-- pageId:cpGestImpiantoRespProp -->

<s:form id="cpGestImpiantoRespProp" action="cpGestImpiantoRespProp" namespace="/base/gestisci_impianto" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestImpiantoRespProp_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','menu')" >

	


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

	
	

	
	
			
	
	
	<div id="p_mpRespProp" class="panelBlock"><!-- startFragment:p_mpRespProp -->
		

		
<s:if test="#session.cpGestImpiantoRespProp_mpRespProp_selectedMultiPanel == 'cpGestImpiantoRespProp_mpRespProp_fpGestImpiantoResponsabileTitolo'">
	<s:include value="/jsp/multipanels/cpGestImpiantoRespProp_mpRespProp_fpGestImpiantoResponsabileTitolo.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpGestImpiantoRespProp_mpRespProp_selectedMultiPanel == 'cpGestImpiantoRespProp_mpRespProp_fpGestImpiantoProprietarioTitolo'">
	<s:include value="/jsp/multipanels/cpGestImpiantoRespProp_mpRespProp_fpGestImpiantoProprietarioTitolo.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpRespProp --></div>

			
	
	<div id="p_fpGestImpianto" class="formPanelBlock"><!-- startFragment:p_fpGestImpianto -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPGestImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestImp">
	<customtag:stdMessagePanel id="stdMsgPGestImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestImp --></div>

			
	
	
	<div id="p_mpResponsabile" class="panelBlock"><!-- startFragment:p_mpResponsabile -->
		

		
<s:if test="#session.cpGestImpiantoRespProp_mpResponsabile_selectedMultiPanel == 'cpGestImpiantoRespProp_mpResponsabile_fpRespProp'">
	<s:include value="/jsp/multipanels/cpGestImpiantoRespProp_mpResponsabile_fpRespProp.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpResponsabile --></div>

			
	
	
	<div id="p_mpresponsabiliTrovatiTemp" class="panelBlock"><!-- startFragment:p_mpresponsabiliTrovatiTemp -->
		

		
<s:if test="#session.cpGestImpiantoRespProp_mpresponsabiliTrovatiTemp_selectedMultiPanel == 'cpGestImpiantoRespProp_mpresponsabiliTrovatiTemp_FunResponsabiliTemp'">
	<s:include value="/jsp/multipanels/cpGestImpiantoRespProp_mpresponsabiliTrovatiTemp_FunResponsabiliTemp.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpresponsabiliTrovatiTemp --></div>

			
	
	<div id="p_cpNavImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpiantoRespProp','btnImpIndietro')" >

	



<!-- widget btnImpIndietro -->
<s:submit name="widg_btnImpIndietro" id="widg_btnImpIndietro" method="handleBtnImpIndietro_CLICKED"
	key="cpGestImpiantoRespProp.btnImpIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoRespProp','btnImpIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavImpianto --></div>

	

		
	

	<!-- endFragment:p_fpGestImpianto --></div>

	

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
