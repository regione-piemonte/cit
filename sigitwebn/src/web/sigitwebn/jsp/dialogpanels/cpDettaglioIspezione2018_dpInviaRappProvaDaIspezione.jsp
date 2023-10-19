<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpInviaRappProvaDaIspezioneForm" action="cpDettaglioIspezione2018" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpInviaRappProvaDaIspezione">

		
		
<div id="p_mbpConfInviaAllegati" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfInviaAllegati -->

	
<div class="msgBoxPanel info" id="mbpConfInviaAllegati">


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptMessaggioDinamicoInviaAll')" >

	
<p>


<!-- widget ptMessaggioDinamicoInviaAll -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfInviaAllegati --></div>

	
	<div id="p_cpDialogPanelInviaRappProva" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelInviaRappProva -->
	
	
<div class="commandPanel functional" id="cpDialogPanelInviaRappProva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaInvio')" >

	



<!-- widget btAnnullaInvio -->
<s:submit name="widg_btAnnullaInvio" id="widg_btAnnullaInvio" method="handleBtAnnullaInvio_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaInvio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaInvio')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConfermaInvio')" >

	



<!-- widget btConfermaInvio -->
<s:submit name="widg_btConfermaInvio" id="widg_btConfermaInvio" method="handleBtConfermaInvio_CLICKED"
	key="cpDettaglioIspezione2018.btConfermaInvio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConfermaInvio')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelInviaRappProva --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
