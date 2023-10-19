<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_module -->
<!-- pageId:cpDettWMS -->

<s:form id="cpDettWMS" action="cpDettWMS" namespace="/base/ricerca_module" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpDettWMS.pDettWMS.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	
	<div id="p_multiDataPanel" class="panelBlock"><!-- startFragment:p_multiDataPanel -->
		

		
<s:if test="#session.cpDettWMS_multiDataPanel_selectedMultiPanel == 'cpDettWMS_multiDataPanel_fpDati'">
	<s:include value="/jsp/multipanels/cpDettWMS_multiDataPanel_fpDati.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettWMS_multiDataPanel_selectedMultiPanel == 'cpDettWMS_multiDataPanel_fpMessaggio'">
	<s:include value="/jsp/multipanels/cpDettWMS_multiDataPanel_fpMessaggio.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_multiDataPanel --></div>

	

	<!-- endFragment:p_pCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
