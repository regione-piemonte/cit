<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpDialogWarnForm" action="cpDialog" namespace="/base/home_module" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpDialogWarn">

		
		
<div id="p_mbpWarn" class="msgBoxPanelBlock"><!-- startFragment:p_mbpWarn -->

	
<div class="msgBoxPanel warning" id="mbpWarn">


		
<s:if test="isWidgetVisible('cpDialog','ptWarn')" >

	
<p>


<!-- widget ptWarn -->
<s:property value="appDatamessaggioErrore" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpWarn --></div>

	
	<div id="p_cpDialogWarn" class="commandPanelBlock"><!-- startFragment:p_cpDialogWarn -->
	
	
<div class="commandPanel functional" id="cpDialogWarn">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDialog','btDialogWarn')" >

	



<!-- widget btDialogWarn -->
<s:submit name="widg_btDialogWarn" id="widg_btDialogWarn" method="handleBtDialogWarn_CLICKED"
	key="cpDialog.btDialogWarn.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDialog','btDialogWarn')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogWarn --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
