<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpEliminaDocumentoForm" action="cpGestisciReeDocumenti" namespace="/base/gestisci_ree_documenti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpEliminaDocumento">

		
		
<div id="p_mbpConfEliminaDocumento" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfEliminaDocumento -->

	
<div class="msgBoxPanel info" id="mbpConfEliminaDocumento">


		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','ptMessaggioDinamicoElimina')" >

	
<p>


<!-- widget ptMessaggioDinamicoElimina -->
<s:text name="cpGestisciReeDocumenti.ptMessaggioDinamicoElimina.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfEliminaDocumento --></div>

	
	<div id="p_cpDialogPanelEliminaDocumento" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelEliminaDocumento -->
	
	
<div class="commandPanel functional" id="cpDialogPanelEliminaDocumento">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btAnnullaElim')" >

	



<!-- widget btAnnullaElim -->
<s:submit name="widg_btAnnullaElim" id="widg_btAnnullaElim" method="handleBtAnnullaElim_CLICKED"
	key="cpGestisciReeDocumenti.btAnnullaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btAnnullaElim')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btConfermaElim')" >

	



<!-- widget btConfermaElim -->
<s:submit name="widg_btConfermaElim" id="widg_btConfermaElim" method="handleBtConfermaElim_CLICKED"
	key="cpGestisciReeDocumenti.btConfermaElim.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btConfermaElim')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelEliminaDocumento --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
