<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpGeneraTokenForm" action="cpToken" namespace="/base/token" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpGeneraToken">


	
	<div id="p_cpGeneraToken" class="commandPanelBlock"><!-- startFragment:p_cpGeneraToken -->
	
	
<div class="commandPanel functional" id="cpGeneraToken">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpToken','btnGenera')" >

	



<!-- widget btnGenera -->
<s:submit name="widg_btnGenera" id="widg_btnGenera" method="handleBtnGenera_CLICKED"
	key="cpToken.btnGenera.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpToken','btnGenera')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpGeneraToken --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
