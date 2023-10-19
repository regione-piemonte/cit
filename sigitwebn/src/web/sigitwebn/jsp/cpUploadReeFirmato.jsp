<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/upload_ree_firmato -->
<!-- pageId:cpUploadReeFirmato -->

<s:form id="cpUploadReeFirmato" action="cpUploadReeFirmato" namespace="/base/upload_ree_firmato" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpUploadReeFirmato_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpUploadReeFirmato','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpReeFirmato" class="formPanelBlock"><!-- startFragment:p_fpReeFirmato -->
		
	
<h4 class="fpLabel"><s:text name="cpUploadReeFirmato.fpReeFirmato.label" /></h4>
<div class="formPanel" id="fpReeFirmato">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpReeFirmato --></div>

			
	
	<div id="p_stdErrorMessageRespingiAllegato" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageRespingiAllegato -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageRespingiAllegato">
	<customtag:stdMessagePanel id="stdErrorMessageRespingiAllegato" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageRespingiAllegato --></div>

			
	
	<div id="p_wpReeFirmato" class="widgetsPanelBlock"><!-- startFragment:p_wpReeFirmato -->
	
	
<h4 class="wpLabel">Upload documento </h4>
<div class="widgetsPanel" id="wpReeFirmato">
	
	<customtag:widgetsPanel id="wpReeFirmatoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpUploadReeFirmato','fupReeFirmato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpUploadReeFirmato.fupReeFirmato.label')}" labelFor="widg_fupReeFirmato" errorFor="widg_fupReeFirmato" labelId="fupReeFirmatoLbl"
	  >


<s:file 
	
	
	name="widg_fupReeFirmato" id="widg_fupReeFirmato"
	disabled="isWidgetDisabled('cpUploadReeFirmato','fupReeFirmato')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpReeFirmato --></div>

			
	
	<div id="p_cpFunzRespingiAllegato" class="commandPanelBlock"><!-- startFragment:p_cpFunzRespingiAllegato -->
	
	
<div class="commandPanel functional" id="cpFunzRespingiAllegato">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpUploadReeFirmato','btnUploadReeFirmato')" >

	



<!-- widget btnUploadReeFirmato -->
<s:submit name="widg_btnUploadReeFirmato" id="widg_btnUploadReeFirmato" method="handleBtnUploadReeFirmato_CLICKED"
	key="cpUploadReeFirmato.btnUploadReeFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpUploadReeFirmato','btnUploadReeFirmato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzRespingiAllegato --></div>

			
	
	<div id="p_cpNavRespingiAllegato" class="commandPanelBlock"><!-- startFragment:p_cpNavRespingiAllegato -->
	
	
<div class="commandPanel navigation" id="cpNavRespingiAllegato">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpUploadReeFirmato','btnIndietroReeFirmato')" >

	



<!-- widget btnIndietroReeFirmato -->
<s:submit name="widg_btnIndietroReeFirmato" id="widg_btnIndietroReeFirmato" method="handleBtnIndietroReeFirmato_CLICKED"
	key="cpUploadReeFirmato.btnIndietroReeFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpUploadReeFirmato','btnIndietroReeFirmato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRespingiAllegato --></div>

	

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
