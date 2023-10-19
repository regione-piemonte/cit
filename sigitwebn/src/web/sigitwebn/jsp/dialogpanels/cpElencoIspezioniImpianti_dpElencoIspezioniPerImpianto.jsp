<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpElencoIspezioniPerImpiantoForm" action="cpElencoIspezioniImpianti" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpElencoIspezioniPerImpianto">

		
		
<div id="p_mbpConfInviaAllegati" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfInviaAllegati -->

	
<div class="msgBoxPanel info" id="mbpConfInviaAllegati">


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptMessaggioDinamicoInvia')" >

	
<p>


<!-- widget ptMessaggioDinamicoInvia -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfInviaAllegati --></div>

	
	<div id="p_cpDialogPanelElenIspezImpianto" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelElenIspezImpianto -->
	
	
<div class="commandPanel functional" id="cpDialogPanelElenIspezImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpElencoIspezioniImpianti.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btConferma')" >

	



<!-- widget btConferma -->
<s:submit name="widg_btConferma" id="widg_btConferma" method="handleBtConferma_CLICKED"
	key="cpElencoIspezioniImpianti.btConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelElenIspezImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
