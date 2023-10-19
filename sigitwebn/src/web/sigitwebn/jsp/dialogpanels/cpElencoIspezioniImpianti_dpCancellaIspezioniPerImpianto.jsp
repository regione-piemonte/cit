<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpCancellaIspezioniPerImpiantoForm" action="cpElencoIspezioniImpianti" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpCancellaIspezioniPerImpianto">

		
		
<div id="p_mbpConfCancellaIspezioni" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfCancellaIspezioni -->

	
<div class="msgBoxPanel info" id="mbpConfCancellaIspezioni">


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptMessaggioDinamicoCancella')" >

	
<p>


<!-- widget ptMessaggioDinamicoCancella -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfCancellaIspezioni --></div>

	
	<div id="p_cpDialogPanelCancellaIspeImpianto" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelCancellaIspeImpianto -->
	
	
<div class="commandPanel functional" id="cpDialogPanelCancellaIspeImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btAnnullaCancella')" >

	



<!-- widget btAnnullaCancella -->
<s:submit name="widg_btAnnullaCancella" id="widg_btAnnullaCancella" method="handleBtAnnullaCancella_CLICKED"
	key="cpElencoIspezioniImpianti.btAnnullaCancella.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btAnnullaCancella')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btConfermaCancella')" >

	



<!-- widget btConfermaCancella -->
<s:submit name="widg_btConfermaCancella" id="widg_btConfermaCancella" method="handleBtConfermaCancella_CLICKED"
	key="cpElencoIspezioniImpianti.btConfermaCancella.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btConfermaCancella')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelCancellaIspeImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
