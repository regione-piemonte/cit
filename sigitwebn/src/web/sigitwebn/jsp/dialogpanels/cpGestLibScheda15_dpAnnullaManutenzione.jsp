<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpAnnullaManutenzioneForm" action="cpGestLibScheda15" namespace="/base/gestisci_libretto_scheda15" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpAnnullaManutenzione">

		
		
<div id="p_mbpConfAnnullaManutenzione" class="msgBoxPanelBlock"><!-- startFragment:p_mbpConfAnnullaManutenzione -->

	
<div class="msgBoxPanel info" id="mbpConfAnnullaManutenzione">


		
<s:if test="isWidgetVisible('cpGestLibScheda15','ptMessaggio')" >

	
<p>


<!-- widget ptMessaggio -->
<s:text name="cpGestLibScheda15.ptMessaggio.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbpConfAnnullaManutenzione --></div>

	
	<div id="p_cpDialogPanelAnnullaManutenzione" class="commandPanelBlock"><!-- startFragment:p_cpDialogPanelAnnullaManutenzione -->
	
	
<div class="commandPanel functional" id="cpDialogPanelAnnullaManutenzione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda15','btAnnullaAnnul')" >

	



<!-- widget btAnnullaAnnul -->
<s:submit name="widg_btAnnullaAnnul" id="widg_btAnnullaAnnul" method="handleBtAnnullaAnnul_CLICKED"
	key="cpGestLibScheda15.btAnnullaAnnul.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15','btAnnullaAnnul')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda15','btConfermaAnnul')" >

	



<!-- widget btConfermaAnnul -->
<s:submit name="widg_btConfermaAnnul" id="widg_btConfermaAnnul" method="handleBtConfermaAnnul_CLICKED"
	key="cpGestLibScheda15.btConfermaAnnul.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15','btConfermaAnnul')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpDialogPanelAnnullaManutenzione --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
