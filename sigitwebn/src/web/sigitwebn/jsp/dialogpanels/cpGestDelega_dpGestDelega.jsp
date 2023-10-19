<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpGestDelegaForm" action="cpGestDelega" namespace="/base/gestisci_delega" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpGestDelega">

		
		
<div id="p_mbConfCessaDelega" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfCessaDelega -->

	
<div class="msgBoxPanel info" id="mbConfCessaDelega">


		
<s:if test="isWidgetVisible('cpGestDelega','ptMsg')" >

	
<p>


<!-- widget ptMsg -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfCessaDelega --></div>

	
	<div id="p_cpConfCessaDelega" class="commandPanelBlock"><!-- startFragment:p_cpConfCessaDelega -->
	
	
<div class="commandPanel functional" id="cpConfCessaDelega">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestDelega','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpGestDelega.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestDelega','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpGestDelega.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestDelega','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfCessaDelega --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
