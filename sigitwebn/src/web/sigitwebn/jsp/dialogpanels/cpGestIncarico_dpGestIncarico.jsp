<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpGestIncaricoForm" action="cpGestIncarico" namespace="/base/gestisci_incarico" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpGestIncarico">

		
		
<div id="p_mbConfCessaIncarico" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfCessaIncarico -->

	
<div class="msgBoxPanel info" id="mbConfCessaIncarico">


		
<s:if test="isWidgetVisible('cpGestIncarico','ptMsg')" >

	
<p>


<!-- widget ptMsg -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfCessaIncarico --></div>

	
	<div id="p_cpConfCessaIncarico" class="commandPanelBlock"><!-- startFragment:p_cpConfCessaIncarico -->
	
	
<div class="commandPanel functional" id="cpConfCessaIncarico">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestIncarico','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpGestIncarico.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestIncarico','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpGestIncarico.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestIncarico','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfCessaIncarico --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
