<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpAnnullaRappProvaDaIspezioneForm" action="cpDettaglioIspezione2018" namespace="/base/elenco_ispezioni_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpAnnullaRappProvaDaIspezione">

		
		
<div id="p_mbpConfAnnullaAllegati" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfAnnullaAllegati -->

	
<div class="msgBoxPanel info" id="mbpConfAnnullaAllegati">


		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptMessaggioDinamicoAnnullaAll')" >

	
<p>


<!-- widget ptMessaggioDinamicoAnnullaAll -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfAnnullaAllegati --></div>

	
	<div id="p_cpDialogPanelAnnullaIspeAllImpianto" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelAnnullaIspeAllImpianto -->
	
	
<div class="commandPanel functional" id="cpDialogPanelAnnullaIspeAllImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btAnnullaAnnullaAll')" >

	



<!-- widget btAnnullaAnnullaAll -->
<s:submit name="widg_btAnnullaAnnullaAll" id="widg_btAnnullaAnnullaAll" method="handleBtAnnullaAnnullaAll_CLICKED"
	key="cpDettaglioIspezione2018.btAnnullaAnnullaAll.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btAnnullaAnnullaAll')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btConfermaAnnullaAll')" >

	



<!-- widget btConfermaAnnullaAll -->
<s:submit name="widg_btConfermaAnnullaAll" id="widg_btConfermaAnnullaAll" method="handleBtConfermaAnnullaAll_CLICKED"
	key="cpDettaglioIspezione2018.btConfermaAnnullaAll.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btConfermaAnnullaAll')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelAnnullaIspeAllImpianto --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
