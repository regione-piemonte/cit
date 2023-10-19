<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_sanzioni -->
<!-- pageId:cpRicercaSanzione -->

<s:form id="cpRicercaSanzione" action="cpRicercaSanzione" namespace="/base/gestisci_sanzioni" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaSanzione_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicercaSanzione','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpRicercaSanzione.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdErrorMessageRicercaSanzioni" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageRicercaSanzioni -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageRicercaSanzioni">
	<customtag:stdMessagePanel id="stdErrorMessageRicercaSanzioni" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageRicercaSanzioni --></div>

			
	
	<div id="p_wpRicercaSanzioni" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaSanzioni -->
	
	
<h4 class="wpLabel">sanzione </h4>
<div class="widgetsPanel" id="wpRicercaSanzioni">
	
	<customtag:widgetsPanel id="wpRicercaSanzioniTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaSanzione','tfIdentificativo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.tfIdentificativo.label')}" labelFor="widg_tfIdentificativo" errorFor="appDataricercaSanzioni.identificativo" labelId="tfIdentificativoLbl"
	  >


<!-- widget tfIdentificativo -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.identificativo" id="widg_tfIdentificativo"
	disabled="isWidgetDisabled('cpRicercaSanzione','tfIdentificativo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cbResponsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cbResponsabile.label')}" labelFor="widg_cbResponsabile" errorFor="appDataricercaSanzioni.cfUtenteResponsabile" labelId="cbResponsabileLbl"
	  >


<!-- widget cbResponsabile -->
<s:select name="appDataricercaSanzioni.cfUtenteResponsabile" id="widg_cbResponsabile"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoRespSanzione"
	  disabled="isWidgetDisabled('cpRicercaSanzione','cbResponsabile')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataCreazioneDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataCreazioneDa.label')}" labelFor="widg_cldataCreazioneDa" errorFor="appDataricercaSanzioni.dataCreazioneDa" labelId="cldataCreazioneDaLbl"
	  >


<!-- widget cldataCreazioneDa -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataCreazioneDa" id="widg_cldataCreazioneDa"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataCreazioneDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataCreazioneA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataCreazioneA.label')}" labelFor="widg_cldataCreazioneA" errorFor="appDataricercaSanzioni.dataCreazioneA" labelId="cldataCreazioneALbl"
	  >


<!-- widget cldataCreazioneA -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataCreazioneA" id="widg_cldataCreazioneA"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataCreazioneA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataComunicazioneDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataComunicazioneDa.label')}" labelFor="widg_cldataComunicazioneDa" errorFor="appDataricercaSanzioni.dataComunicazioneDa" labelId="cldataComunicazioneDaLbl"
	  >


<!-- widget cldataComunicazioneDa -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataComunicazioneDa" id="widg_cldataComunicazioneDa"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataComunicazioneDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataComunicazioneA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataComunicazioneA.label')}" labelFor="widg_cldataComunicazioneA" errorFor="appDataricercaSanzioni.dataComunicazioneA" labelId="cldataComunicazioneALbl"
	  >


<!-- widget cldataComunicazioneA -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataComunicazioneA" id="widg_cldataComunicazioneA"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataComunicazioneA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataPagamentoDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataPagamentoDa.label')}" labelFor="widg_cldataPagamentoDa" errorFor="appDataricercaSanzioni.dataPagamentoDa" labelId="cldataPagamentoDaLbl"
	  >


<!-- widget cldataPagamentoDa -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataPagamentoDa" id="widg_cldataPagamentoDa"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataPagamentoDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataPagamentoA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataPagamentoA.label')}" labelFor="widg_cldataPagamentoA" errorFor="appDataricercaSanzioni.dataPagamentoA" labelId="cldataPagamentoALbl"
	  >


<!-- widget cldataPagamentoA -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataPagamentoA" id="widg_cldataPagamentoA"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataPagamentoA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataAnnullamentoDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataAnnullamentoDa.label')}" labelFor="widg_cldataAnnullamentoDa" errorFor="appDataricercaSanzioni.dataAnnullamentoDa" labelId="cldataAnnullamentoDaLbl"
	  >


<!-- widget cldataAnnullamentoDa -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataAnnullamentoDa" id="widg_cldataAnnullamentoDa"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataAnnullamentoDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cldataAnnullamentoA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cldataAnnullamentoA.label')}" labelFor="widg_cldataAnnullamentoA" errorFor="appDataricercaSanzioni.dataAnnullamentoA" labelId="cldataAnnullamentoALbl"
	  >


<!-- widget cldataAnnullamentoA -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.dataAnnullamentoA" id="widg_cldataAnnullamentoA"
	disabled="isWidgetDisabled('cpRicercaSanzione','cldataAnnullamentoA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','tfValoreDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.tfValoreDa.label')}" labelFor="widg_tfValoreDa" errorFor="appDataricercaSanzioni.valoreDa" labelId="tfValoreDaLbl"
	  >


<!-- widget tfValoreDa -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.valoreDa" id="widg_tfValoreDa"
	disabled="isWidgetDisabled('cpRicercaSanzione','tfValoreDa')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','tfValoreA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.tfValoreA.label')}" labelFor="widg_tfValoreA" errorFor="appDataricercaSanzioni.valoreA" labelId="tfValoreALbl"
	  >


<!-- widget tfValoreA -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.valoreA" id="widg_tfValoreA"
	disabled="isWidgetDisabled('cpRicercaSanzione','tfValoreA')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cbStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cbStato.label')}" labelFor="widg_cbStato" errorFor="appDataricercaSanzioni.stato" labelId="cbStatoLbl"
	  >


<!-- widget cbStato -->
<s:select name="appDataricercaSanzioni.stato" id="widg_cbStato"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatiSanzione"
	  disabled="isWidgetDisabled('cpRicercaSanzione','cbStato')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cbAssAccert')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cbAssAccert.label')}" labelFor="widg_cbAssAccert" errorFor="appDataricercaSanzioni.associataAccertamento" labelId="cbAssAccertLbl"
	  >


<!-- widget cbAssAccert -->
<s:select name="appDataricercaSanzioni.associataAccertamento" id="widg_cbAssAccert"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpRicercaSanzione','cbAssAccert')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','cbAssIspez')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.cbAssIspez.label')}" labelFor="widg_cbAssIspez" errorFor="appDataricercaSanzioni.associataIspezione" labelId="cbAssIspezLbl"
	  >


<!-- widget cbAssIspez -->
<s:select name="appDataricercaSanzioni.associataIspezione" id="widg_cbAssIspez"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpRicercaSanzione','cbAssIspez')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','tfcfFisicoSanzionato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.tfcfFisicoSanzionato.label')}" labelFor="widg_tfcfFisicoSanzionato" errorFor="appDataricercaSanzioni.cfFisicaSanzionato" labelId="tfcfFisicoSanzionatoLbl"
	  >


<!-- widget tfcfFisicoSanzionato -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.cfFisicaSanzionato" id="widg_tfcfFisicoSanzionato"
	disabled="isWidgetDisabled('cpRicercaSanzione','tfcfFisicoSanzionato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','tfcfGiuridicoSanzionato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.tfcfGiuridicoSanzionato.label')}" labelFor="widg_tfcfGiuridicoSanzionato" errorFor="appDataricercaSanzioni.cfGiuridicaSanzionato" labelId="tfcfGiuridicoSanzionatoLbl"
	  >


<!-- widget tfcfGiuridicoSanzionato -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.cfGiuridicaSanzionato" id="widg_tfcfGiuridicoSanzionato"
	disabled="isWidgetDisabled('cpRicercaSanzione','tfcfGiuridicoSanzionato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaSanzione','tfmotivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaSanzione.tfmotivo.label')}" labelFor="widg_tfmotivo" errorFor="appDataricercaSanzioni.motivo" labelId="tfmotivoLbl"
	  fieldRequired="true">


<!-- widget tfmotivo -->
<s:textfield 
	
	
	name="appDataricercaSanzioni.motivo" id="widg_tfmotivo"
	disabled="isWidgetDisabled('cpRicercaSanzione','tfmotivo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaSanzioni --></div>

			
	
	<div id="p_cpFunRicercaSanzioni" class="commandPanelBlock"><!-- startFragment:p_cpFunRicercaSanzioni -->
	
	
<div class="commandPanel functional" id="cpFunRicercaSanzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpRicercaSanzione','btnRicerca')" >

	



<!-- widget btnRicerca -->
<s:submit name="widg_btnRicerca" id="widg_btnRicerca" method="handleBtnRicerca_CLICKED"
	key="cpRicercaSanzione.btnRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaSanzione','btnRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaSanzione','btnAnnulla')" >

	



<!-- widget btnAnnulla -->
<s:submit name="widg_btnAnnulla" id="widg_btnAnnulla" method="handleBtnAnnulla_CLICKED"
	key="cpRicercaSanzione.btnAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaSanzione','btnAnnulla')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunRicercaSanzioni --></div>

			
	
	<div id="p_cpNavRicercaSanzioni" class="commandPanelBlock"><!-- startFragment:p_cpNavRicercaSanzioni -->
	
	
<div class="commandPanel navigation" id="cpNavRicercaSanzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpRicercaSanzione','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRicercaSanzione.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaSanzione','btnIndietro')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNavRicercaSanzioni --></div>

	

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
