<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpReeFirmatoForm" action="cpElencoAllegatiImpianti" namespace="/base/elenco_allegati_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpReeFirmato">

		
		
<div id="p_pMsgReeFirmato" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgReeFirmato -->

	
<div class="msgBoxPanel info" id="pMsgReeFirmato">


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','txtMsgReeFirmato')" >

	
<p>


<!-- widget txtMsgReeFirmato -->
<s:text name="cpElencoAllegatiImpianti.txtMsgReeFirmato.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgReeFirmato --></div>

	
	<div id="p_pCmdReeFirmato" class="commandPanelBlock"><!-- startFragment:p_pCmdReeFirmato -->
	
	
<div class="commandPanel functional" id="pCmdReeFirmato">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btIndietroNoReeFirmato')" >

	



<!-- widget btIndietroNoReeFirmato -->
<s:submit name="widg_btIndietroNoReeFirmato" id="widg_btIndietroNoReeFirmato" method="handleBtIndietroNoReeFirmato_CLICKED"
	key="cpElencoAllegatiImpianti.btIndietroNoReeFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btIndietroNoReeFirmato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btISiReeFirmato')" >

	



<!-- widget btISiReeFirmato -->
<s:submit name="widg_btISiReeFirmato" id="widg_btISiReeFirmato" method="handleBtISiReeFirmato_CLICKED"
	key="cpElencoAllegatiImpianti.btISiReeFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btISiReeFirmato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','indietrobtndialog')" >

	



<!-- widget indietrobtndialog -->
<s:submit name="widg_indietrobtndialog" id="widg_indietrobtndialog" method="handleIndietrobtndialog_CLICKED"
	key="cpElencoAllegatiImpianti.indietrobtndialog.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','indietrobtndialog')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdReeFirmato --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
