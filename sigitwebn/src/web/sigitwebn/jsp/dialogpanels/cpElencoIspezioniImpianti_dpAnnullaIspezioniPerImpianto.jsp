<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpAnnullaIspezioniPerImpiantoForm" action="cpElencoIspezioniImpianti" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpAnnullaIspezioniPerImpianto">

		
		
<div id="p_mbpConfAnnullaIspezioni" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfAnnullaIspezioni -->

	
<div class="msgBoxPanel info" id="mbpConfAnnullaIspezioni">


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptMessaggioDinamicoAnnulla')" >

	
<p>


<!-- widget ptMessaggioDinamicoAnnulla -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfAnnullaIspezioni --></div>

	
	<div id="p_cpDialogPanelAnnullaIspeImpianto" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelAnnullaIspeImpianto -->
	
	
<div class="commandPanel functional" id="cpDialogPanelAnnullaIspeImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btAnnullaAnnulla')" >

	



<!-- widget btAnnullaAnnulla -->
<s:submit name="widg_btAnnullaAnnulla" id="widg_btAnnullaAnnulla" method="handleBtAnnullaAnnulla_CLICKED"
	key="cpElencoIspezioniImpianti.btAnnullaAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btAnnullaAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btConfermaAnnulla')" >

	



<!-- widget btConfermaAnnulla -->
<s:submit name="widg_btConfermaAnnulla" id="widg_btConfermaAnnulla" method="handleBtConfermaAnnulla_CLICKED"
	key="cpElencoIspezioniImpianti.btConfermaAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btConfermaAnnulla')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelAnnullaIspeImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
