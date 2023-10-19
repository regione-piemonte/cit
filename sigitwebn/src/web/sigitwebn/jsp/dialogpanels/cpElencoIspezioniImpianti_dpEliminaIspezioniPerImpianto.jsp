<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaIspezioniPerImpiantoForm" action="cpElencoIspezioniImpianti" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpEliminaIspezioniPerImpianto">

		
		
<div id="p_mbpConfEliminaAllegati" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfEliminaAllegati -->

	
<div class="msgBoxPanel info" id="mbpConfEliminaAllegati">


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptMessaggioDinamicoElimina')" >

	
<p>


<!-- widget ptMessaggioDinamicoElimina -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfEliminaAllegati --></div>

	
	<div id="p_cpDialogPanelEliminaAllegImpianto" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelEliminaAllegImpianto -->
	
	
<div class="commandPanel functional" id="cpDialogPanelEliminaAllegImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btAnnullaElim')" >

	



<!-- widget btAnnullaElim -->
<s:submit name="widg_btAnnullaElim" id="widg_btAnnullaElim" method="handleBtAnnullaElim_CLICKED"
	key="cpElencoIspezioniImpianti.btAnnullaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btAnnullaElim')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btConfermaElim')" >

	



<!-- widget btConfermaElim -->
<s:submit name="widg_btConfermaElim" id="widg_btConfermaElim" method="handleBtConfermaElim_CLICKED"
	key="cpElencoIspezioniImpianti.btConfermaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btConfermaElim')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelEliminaAllegImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
