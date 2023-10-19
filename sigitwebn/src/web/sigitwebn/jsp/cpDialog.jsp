<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/main -->
<!-- pageId:cpDialog -->

<s:form id="cpDialog" action="cpDialog" namespace="/base/main" method="post">


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
				<h3><s:text name="cpDialog.fpMainG.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpMain" class="formPanelBlock"><!-- startFragment:p_fpMain -->
		
	
<div class="formPanel" id="fpMain">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpMain --></div>

			
	
	<div id="p_wpMain" class="widgetsPanelBlock"><!-- startFragment:p_wpMain -->
	
	

<div class="widgetsPanel" id="wpMain">
	
	<customtag:widgetsPanel id="wpMainTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDialog','hvIngressoKO')" >

	
<div class="hidden">


<!-- widget hvIngressoKO -->
<s:hidden name="widg_hvIngressoKO" id="widg_hvIngressoKO" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMain --></div>

	

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
