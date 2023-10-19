<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_rapprova -->
<!-- pageId:cpInitRapProva -->

<s:form id="cpInitRapProva" action="cpInitRapProva" namespace="/base/gestisci_rapprova" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpInitRapProva_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpInitRapProva','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestRapProvaDatiGen" class="formPanelBlock"><!-- startFragment:p_fpGestRapProvaDatiGen -->
		
	
<h4 class="fpLabel"><s:text name="cpInitRapProva.fpGestRapProvaDatiGen.label" /></h4>
<div class="formPanel" id="fpGestRapProvaDatiGen">


	
	

	
	
			
	
	<div id="p_stdMsgRapProva" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgRapProva -->
	
	
<div class="stdMessagePanel" id="stdMsgRapProva">
	<customtag:stdMessagePanel id="stdMsgRapProva" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgRapProva --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGestRapProvaDatiGen --></div>

			
	
	<div id="p_fpDatiRapporto" class="formPanelBlock"><!-- startFragment:p_fpDatiRapporto -->
		
	


	
	

	
	
			
	
	
	<div id="p_mpGestioneAllegato" class="panelBlock"><!-- startFragment:p_mpGestioneAllegato -->
		

		
<s:if test="#session.cpInitRapProva_mpGestioneAllegato_selectedMultiPanel == 'cpInitRapProva_mpGestioneAllegato_fpInserimento'">
	<s:include value="/jsp/multipanels/cpInitRapProva_mpGestioneAllegato_fpInserimento.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpInitRapProva_mpGestioneAllegato_selectedMultiPanel == 'cpInitRapProva_mpGestioneAllegato_fpModifica'">
	<s:include value="/jsp/multipanels/cpInitRapProva_mpGestioneAllegato_fpModifica.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpGestioneAllegato --></div>

			
	
	<div id="p_cpNavDatiRapporto" class="commandPanelBlock"><!-- startFragment:p_cpNavDatiRapporto -->
	
	
<div class="commandPanel navigation" id="cpNavDatiRapporto">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnUploadAllegato')" >

	



<!-- widget btnUploadAllegato -->
<s:submit name="widg_btnUploadAllegato" id="widg_btnUploadAllegato" method="handleBtnUploadAllegato_CLICKED"
	key="cpInitRapProva.btnUploadAllegato.label" cssClass="buttonWidget confirm"
	disabled="isWidgetDisabled('cpInitRapProva','btnUploadAllegato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpInitRapProva','btnCreaAllegato')" >

	



<!-- widget btnCreaAllegato -->
<s:submit name="widg_btnCreaAllegato" id="widg_btnCreaAllegato" method="handleBtnCreaAllegato_CLICKED"
	key="cpInitRapProva.btnCreaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnCreaAllegato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDatiRapporto --></div>

			
	
	
	<div id="p_mpUploadAllegato" class="panelBlock"><!-- startFragment:p_mpUploadAllegato -->
		

		
<s:if test="#session.cpInitRapProva_mpUploadAllegato_selectedMultiPanel == 'cpInitRapProva_mpUploadAllegato_fpUploadAllegato'">
	<s:include value="/jsp/multipanels/cpInitRapProva_mpUploadAllegato_fpUploadAllegato.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpUploadAllegato --></div>

	

		
	

	<!-- endFragment:p_fpDatiRapporto --></div>

			
	
	<div id="p_cpNavInitRapProva" class="commandPanelBlock"><!-- startFragment:p_cpNavInitRapProva -->
	
	
<div class="commandPanel navigation" id="cpNavInitRapProva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInitRapProva','btnIndietroInitRapProva')" >

	



<!-- widget btnIndietroInitRapProva -->
<s:submit name="widg_btnIndietroInitRapProva" id="widg_btnIndietroInitRapProva" method="handleBtnIndietroInitRapProva_CLICKED"
	key="cpInitRapProva.btnIndietroInitRapProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInitRapProva','btnIndietroInitRapProva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavInitRapProva --></div>

	

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
