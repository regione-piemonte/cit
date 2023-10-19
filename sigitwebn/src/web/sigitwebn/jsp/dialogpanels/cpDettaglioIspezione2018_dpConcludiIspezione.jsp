<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpConcludiIspezioneForm" action="cpDettaglioIspezione2018" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpConcludiIspezione">

		
		
<div id="p_mbpConfConclusioneIspezione" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfConclusioneIspezione -->

	
<div class="msgBoxPanel info" id="mbpConfConclusioneIspezione">


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptMessaggioDinamicoConcludiIspezione')" >

	
<p>


<!-- widget ptMessaggioDinamicoConcludiIspezione -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfConclusioneIspezione --></div>

	
	<div id="p_cpDialogPanelConcludiIspezione" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelConcludiIspezione -->
	
	
<div class="commandPanel functional" id="cpDialogPanelConcludiIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaConclusione')" >

	



<!-- widget btAnnullaConclusione -->
<s:submit name="widg_btAnnullaConclusione" id="widg_btAnnullaConclusione" method="handleBtAnnullaConclusione_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaConclusione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaConclusione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConfermaConclusione')" >

	



<!-- widget btConfermaConclusione -->
<s:submit name="widg_btConfermaConclusione" id="widg_btConfermaConclusione" method="handleBtConfermaConclusione_CLICKED"
	key="cpDettaglioIspezione2018.btConfermaConclusione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConfermaConclusione')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelConcludiIspezione --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
