<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaAllegatiPerImpiantoForm" action="cpElencoAllegatiImpianti" namespace="/base/elenco_allegati_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpEliminaAllegatiPerImpianto">

		
		
<div id="p_mbpConfEliminaAllegati" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfEliminaAllegati -->

	
<div class="msgBoxPanel info" id="mbpConfEliminaAllegati">


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','ptMessaggioDinamicoElimina')" >

	
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
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btAnnullaElim')" >

	



<!-- widget btAnnullaElim -->
<s:submit name="widg_btAnnullaElim" id="widg_btAnnullaElim" method="handleBtAnnullaElim_CLICKED"
	key="cpElencoAllegatiImpianti.btAnnullaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btAnnullaElim')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btConfermaElim')" >

	



<!-- widget btConfermaElim -->
<s:submit name="widg_btConfermaElim" id="widg_btConfermaElim" method="handleBtConfermaElim_CLICKED"
	key="cpElencoAllegatiImpianti.btConfermaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btConfermaElim')" />

	


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
