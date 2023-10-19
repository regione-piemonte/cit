<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpInviaIspezioniPerImpiantoForm" action="cpElencoIspezioniImpianti" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpInviaIspezioniPerImpianto">

		
		
<div id="p_mbpConfInviaIspezioni" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfInviaIspezioni -->

	
<div class="msgBoxPanel info" id="mbpConfInviaIspezioni">


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptMessaggioDinamicoInvia')" >

	
<p>


<!-- widget ptMessaggioDinamicoInvia -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfInviaIspezioni --></div>

	
	<div id="p_cpDialogPanelInviaIspezImpianto" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelInviaIspezImpianto -->
	
	
<div class="commandPanel functional" id="cpDialogPanelInviaIspezImpianto">

	
	
		

	
	
	
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

	<!-- endFragment:p_cpDialogPanelInviaIspezImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
