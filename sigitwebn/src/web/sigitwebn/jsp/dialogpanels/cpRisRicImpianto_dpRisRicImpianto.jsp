<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpRisRicImpiantoForm" action="cpRisRicImpianto" namespace="/base/risultato_ricerca_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpRisRicImpianto">

		
		
<div id="p_mbConfElimImpianto" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfElimImpianto -->

	
<div class="msgBoxPanel info" id="mbConfElimImpianto">


		
<s:if test="isWidgetVisible('cpRisRicImpianto','ptMsg')" >

	
<p>


<!-- widget ptMsg -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfElimImpianto --></div>

	
	<div id="p_cpConfElimImpianto" class="commandPanelBlock"><!-- startFragment:p_cpConfElimImpianto -->
	
	
<div class="commandPanel functional" id="cpConfElimImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpRisRicImpianto.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpRisRicImpianto.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfElimImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
