<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/respingi_allegato -->
<!-- pageId:cpRespingiAllegato -->

<s:form id="cpRespingiAllegato" action="cpRespingiAllegato" namespace="/base/respingi_allegato" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRespingiAllegato_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRespingiAllegato','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpRespingiAllegato" class="formPanelBlock"><!-- startFragment:p_fpRespingiAllegato -->
		
	
<h4 class="fpLabel"><s:text name="cpRespingiAllegato.fpRespingiAllegato.label" /></h4>
<div class="formPanel" id="fpRespingiAllegato">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRespingiAllegato --></div>

			
	
	<div id="p_stdErrorMessageRespingiAllegato" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageRespingiAllegato -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageRespingiAllegato">
	<customtag:stdMessagePanel id="stdErrorMessageRespingiAllegato" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageRespingiAllegato --></div>

			
	
	<div id="p_wpRespingiAllegato" class="widgetsPanelBlock"><!-- startFragment:p_wpRespingiAllegato -->
	
	
<h4 class="wpLabel">respingi REE </h4>
<div class="widgetsPanel" id="wpRespingiAllegato">
	
	<customtag:widgetsPanel id="wpRespingiAllegatoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDatadettaglioElencoAllegati.codiceImpianto" labelId="ptCodiceImpiantoLbl"   >


<!-- widget ptCodiceImpianto -->
<s:property value="appDatadettaglioElencoAllegati.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptComune')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptComune.label')}" labelFor="widg_ptComune" errorFor="appDatadettaglioElencoAllegati.comune" labelId="ptComuneLbl"   >


<!-- widget ptComune -->
<s:property value="appDatadettaglioElencoAllegati.comune" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptIndirizzo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptIndirizzo.label')}" labelFor="widg_ptIndirizzo" errorFor="appDatadettaglioElencoAllegati.indirizzo" labelId="ptIndirizzoLbl"   >


<!-- widget ptIndirizzo -->
<s:property value="appDatadettaglioElencoAllegati.indirizzo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptManutentore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptManutentore.label')}" labelFor="widg_ptManutentore" errorFor="appDatadettaglioElencoAllegati.manutentore" labelId="ptManutentoreLbl"   >


<!-- widget ptManutentore -->
<s:property value="appDatadettaglioElencoAllegati.manutentore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptStatoAllegato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptStatoAllegato.label')}" labelFor="widg_ptStatoAllegato" errorFor="appDatadettaglioElencoAllegati.statoAllegato" labelId="ptStatoAllegatoLbl"   >


<!-- widget ptStatoAllegato -->
<s:property value="appDatadettaglioElencoAllegati.statoAllegato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptTipoAllegato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptTipoAllegato.label')}" labelFor="widg_ptTipoAllegato" errorFor="appDatadettaglioElencoAllegati.tipoAllegato" labelId="ptTipoAllegatoLbl"   >


<!-- widget ptTipoAllegato -->
<s:property value="appDatadettaglioElencoAllegati.tipoAllegato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDatadettaglioElencoAllegati.dataControllo" labelId="ptDataControlloLbl"   >


<!-- widget ptDataControllo -->
<s:property value="appDatadettaglioElencoAllegati.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptSiglaBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptSiglaBollino.label')}" labelFor="widg_ptSiglaBollino" errorFor="appDatadettaglioElencoAllegati.siglaBollino" labelId="ptSiglaBollinoLbl"   >


<!-- widget ptSiglaBollino -->
<s:property value="appDatadettaglioElencoAllegati.siglaBollino" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptNumeroBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptNumeroBollino.label')}" labelFor="widg_ptNumeroBollino" errorFor="appDatadettaglioElencoAllegati.numeroBollino" labelId="ptNumeroBollinoLbl"   >


<!-- widget ptNumeroBollino -->
<s:property value="appDatadettaglioElencoAllegati.numeroBollino" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','ptElencoApparecchiature')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRespingiAllegato.ptElencoApparecchiature.label')}" labelFor="widg_ptElencoApparecchiature" errorFor="appDatadettaglioElencoAllegati.elencoApparecchiature" labelId="ptElencoApparecchiatureLbl"   >


<!-- widget ptElencoApparecchiature -->
<s:property value="appDatadettaglioElencoAllegati.elencoApparecchiature" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRespingiAllegato','taMotivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRespingiAllegato.taMotivo.label')}" labelFor="widg_taMotivo" errorFor="appDatadettaglioElencoAllegati.motivo" labelId="taMotivoLbl"
	  >


<!-- widget taMotivo -->
<s:textarea 
	
	
	name="appDatadettaglioElencoAllegati.motivo" id="widg_taMotivo"
	disabled="isWidgetDisabled('cpRespingiAllegato','taMotivo')"
	rows="10"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRespingiAllegato --></div>

			
	
	<div id="p_cpFunzRespingiAllegato" class="commandPanelBlock"><!-- startFragment:p_cpFunzRespingiAllegato -->
	
	
<div class="commandPanel functional" id="cpFunzRespingiAllegato">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRespingiAllegato','btnConfermaRespingiAllegato')" >

	



<!-- widget btnConfermaRespingiAllegato -->
<s:submit name="widg_btnConfermaRespingiAllegato" id="widg_btnConfermaRespingiAllegato" method="handleBtnConfermaRespingiAllegato_CLICKED"
	key="cpRespingiAllegato.btnConfermaRespingiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRespingiAllegato','btnConfermaRespingiAllegato')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzRespingiAllegato --></div>

			
	
	<div id="p_cpNavRespingiAllegato" class="commandPanelBlock"><!-- startFragment:p_cpNavRespingiAllegato -->
	
	
<div class="commandPanel navigation" id="cpNavRespingiAllegato">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRespingiAllegato','btnIndietroElencoAllegati')" >

	



<!-- widget btnIndietroElencoAllegati -->
<s:submit name="widg_btnIndietroElencoAllegati" id="widg_btnIndietroElencoAllegati" method="handleBtnIndietroElencoAllegati_CLICKED"
	key="cpRespingiAllegato.btnIndietroElencoAllegati.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRespingiAllegato','btnIndietroElencoAllegati')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRespingiAllegato --></div>

	

	<!-- endFragment:p_fpCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
