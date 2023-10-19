<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpReplaceReeFirmatoForm" action="cpElencoAllegatiImpianti" namespace="/base/elenco_allegati_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpReplaceReeFirmato">

		
		
<div id="p_pMsgReplaceReeFirmato" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgReplaceReeFirmato -->

	
<div class="msgBoxPanel info" id="pMsgReplaceReeFirmato">


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','txtMsgReplaceReeFirmato')" >

	
<p>


<!-- widget txtMsgReplaceReeFirmato -->
<s:text name="cpElencoAllegatiImpianti.txtMsgReplaceReeFirmato.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgReplaceReeFirmato --></div>

	
	<div id="p_pCmdReplaceReeFirmato" class="commandPanelBlock"><!-- startFragment:p_pCmdReplaceReeFirmato -->
	
	
<div class="commandPanel functional" id="pCmdReplaceReeFirmato">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btISiReplaceReeFirmato')" >

	



<!-- widget btISiReplaceReeFirmato -->
<s:submit name="widg_btISiReplaceReeFirmato" id="widg_btISiReplaceReeFirmato" method="handleBtISiReplaceReeFirmato_CLICKED"
	key="cpElencoAllegatiImpianti.btISiReplaceReeFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btISiReplaceReeFirmato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btIndietroNoReplaceReeFirmato')" >

	



<!-- widget btIndietroNoReplaceReeFirmato -->
<s:submit name="widg_btIndietroNoReplaceReeFirmato" id="widg_btIndietroNoReplaceReeFirmato" method="handleBtIndietroNoReplaceReeFirmato_CLICKED"
	key="cpElencoAllegatiImpianti.btIndietroNoReplaceReeFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btIndietroNoReplaceReeFirmato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdReplaceReeFirmato --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
