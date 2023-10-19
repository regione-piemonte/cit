<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dpRisRicImpRev3Form" action="cpRisRicImpianto" namespace="/base/risultato_ricerca_impianti" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<div class="dialogPanel" id="dpRisRicImpRev3">

		
		
<div id="p_mbConfRev3Resp" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfRev3Resp -->

	
<div class="msgBoxPanel info" id="mbConfRev3Resp">


		
<s:if test="isWidgetVisible('cpRisRicImpianto','ptMsgRev')" >

	
<p>


<!-- widget ptMsgRev -->
<s:property value="appDatamessaggioDinamico" escape="false" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfRev3Resp --></div>

	
	<div id="p_cpConfRevoca3" class="commandPanelBlock"><!-- startFragment:p_cpConfRevoca3 -->
	
	
<div class="commandPanel functional" id="cpConfRevoca3">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btAnnullaRevoca')" >

	



<!-- widget btAnnullaRevoca -->
<s:submit name="widg_btAnnullaRevoca" id="widg_btAnnullaRevoca" method="handleBtAnnullaRevoca_CLICKED"
	key="cpRisRicImpianto.btAnnullaRevoca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btAnnullaRevoca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisRicImpianto','btConfermaRevoca')" >

	



<!-- widget btConfermaRevoca -->
<s:submit name="widg_btConfermaRevoca" id="widg_btConfermaRevoca" method="handleBtConfermaRevoca_CLICKED"
	key="cpRisRicImpianto.btConfermaRevoca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicImpianto','btConfermaRevoca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfRevoca3 --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
