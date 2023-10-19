<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/home_module -->
<!-- pageId:cpDialog -->

<s:form id="cpDialog" action="cpDialog" namespace="/base/home_module" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">



	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpMainD" class="formPanelBlock"><!-- startFragment:p_fpMainD -->

	
	

	
	
			
	
	<div id="p_fpMain2" class="formPanelBlock"><!-- startFragment:p_fpMain2 -->
		
	
<div class="formPanel" id="fpMain2">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpMain2 --></div>

			
	
	<div id="p_wpMain" class="widgetsPanelBlock"><!-- startFragment:p_wpMain -->
	
	

<div class="widgetsPanel" id="wpMain">
	
	<customtag:widgetsPanel id="wpMainTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDialog','hvIngressoWARN')" >

	
<div class="hidden">


<!-- widget hvIngressoWARN -->
<s:hidden name="widg_hvIngressoWARN" id="widg_hvIngressoWARN" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMain --></div>

	

	<!-- endFragment:p_fpMainD --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
