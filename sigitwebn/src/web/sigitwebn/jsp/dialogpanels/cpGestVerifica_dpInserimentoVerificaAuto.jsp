<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpInserimentoVerificaAutoForm" action="cpGestVerifica" namespace="/base/gestisci_verifica" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpInserimentoVerificaAuto">

		
		
<div id="p_mbConfInsVerifica" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfInsVerifica -->

	
<div class="msgBoxPanel info" id="mbConfInsVerifica">


		
<s:if test="isWidgetVisible('cpGestVerifica','ptMsg')" >

	
<p>


<!-- widget ptMsg -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfInsVerifica --></div>

	
	<div id="p_cpConfInsVerifica" class="commandPanelBlock"><!-- startFragment:p_cpConfInsVerifica -->
	
	
<div class="commandPanel functional" id="cpConfInsVerifica">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestVerifica','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpGestVerifica.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestVerifica','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpGestVerifica.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestVerifica','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfInsVerifica --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
