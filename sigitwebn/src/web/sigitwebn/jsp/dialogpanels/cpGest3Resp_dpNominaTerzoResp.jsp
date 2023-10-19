<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpNominaTerzoRespForm" action="cpGest3Resp" namespace="/base/gestisci_terzo_responsabile" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpNominaTerzoResp">

		
		
<div id="p_mbConfermaNomina" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfermaNomina -->

	
<div class="msgBoxPanel info" id="mbConfermaNomina">


		
<s:if test="isWidgetVisible('cpGest3Resp','ptMsgDinamResp')" >

	
<p>


<!-- widget ptMsgDinamResp -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfermaNomina --></div>

	
	<div id="p_cpMsgNomina" class="commandPanelBlock"><!-- startFragment:p_cpMsgNomina -->
	
	
<div class="commandPanel functional" id="cpMsgNomina">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGest3Resp','btDlgAnnulla')" >

	



<!-- widget btDlgAnnulla -->
<s:submit name="widg_btDlgAnnulla" id="widg_btDlgAnnulla" method="handleBtDlgAnnulla_CLICKED"
	key="cpGest3Resp.btDlgAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btDlgAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGest3Resp','btDlgConferma')" >

	



<!-- widget btDlgConferma -->
<s:submit name="widg_btDlgConferma" id="widg_btDlgConferma" method="handleBtDlgConferma_CLICKED"
	key="cpGest3Resp.btDlgConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btDlgConferma')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpMsgNomina --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
