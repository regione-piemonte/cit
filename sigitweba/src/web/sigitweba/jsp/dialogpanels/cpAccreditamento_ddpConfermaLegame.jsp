<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="ddpConfermaLegameForm" action="cpAccreditamento" namespace="/base/accreditamento_module" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpAccreditamento.ddpConfermaLegame.label" /></h3>
				<div class="dialogPanel" id="ddpConfermaLegame">

		
		
<div id="p_mbConfermaCessLegame" class="msgBoxPanelBlock"><!-- startFragment:p_mbConfermaCessLegame -->

	
<div class="msgBoxPanel info" id="mbConfermaCessLegame">


		
<s:if test="isWidgetVisible('cpAccreditamento','ptConfCessLegame')" >

	
<p>


<!-- widget ptConfCessLegame -->
<s:text name="cpAccreditamento.ptConfCessLegame.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_mbConfermaCessLegame --></div>

	
	<div id="p_cpConfermaCessLEgame" class="commandPanelBlock"><!-- startFragment:p_cpConfermaCessLEgame -->
	
	
<div class="commandPanel functional" id="cpConfermaCessLEgame">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAccreditamento','btAnnullaConferma')" >

	



<!-- widget btAnnullaConferma -->
<s:submit name="widg_btAnnullaConferma" id="widg_btAnnullaConferma" method="handleBtAnnullaConferma_CLICKED"
	key="cpAccreditamento.btAnnullaConferma.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btAnnullaConferma')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAccreditamento','btConfermaCessLegame')" >

	



<!-- widget btConfermaCessLegame -->
<s:submit name="widg_btConfermaCessLegame" id="widg_btConfermaCessLegame" method="handleBtConfermaCessLegame_CLICKED"
	key="cpAccreditamento.btConfermaCessLegame.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btConfermaCessLegame')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpConfermaCessLEgame --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
