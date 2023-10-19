<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpDialogErrorForm" action="cpDialog" namespace="/base/main" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpDialogError">

		
		
<div id="p_mbpError" class="msgBoxPanelBlock"><!-- startFragment:p_mbpError -->

	
<div class="msgBoxPanel warning" id="mbpError">


		
<s:if test="isWidgetVisible('cpDialog','ptError')" >

	
<p>


<!-- widget ptError -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpError --></div>

	
	<div id="p_cpDialogError" class="commandPanelBlock"><!-- startFragment:p_cpDialogError -->
	
	
<div class="commandPanel functional" id="cpDialogError">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDialog','btDialogError')" >

	



<!-- widget btDialogError -->
<s:submit name="widg_btDialogError" id="widg_btDialogError" method="handleBtDialogError_CLICKED"
	key="cpDialog.btDialogError.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDialog','btDialogError')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogError --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
