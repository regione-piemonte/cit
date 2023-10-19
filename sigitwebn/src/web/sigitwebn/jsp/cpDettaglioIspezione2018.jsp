<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_ispezioni_impianti/CpDettaglioIspezione2018Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/elenco_ispezioni_impianti -->
<!-- pageId:cpDettaglioIspezione2018 -->

<s:form id="cpDettaglioIspezione2018" action="cpDettaglioIspezione2018" namespace="/base/elenco_ispezioni_impianti" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioIspezione2018_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','menu')" >

	


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
		
	
<h4 class="fpLabel"><s:text name="cpDettaglioIspezione2018.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdErrorMessageDettaglioIspezione" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageDettaglioIspezione -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageDettaglioIspezione">
	<customtag:stdMessagePanel id="stdErrorMessageDettaglioIspezione" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageDettaglioIspezione --></div>

			
	
	<div id="p_wpDettaglioIspezione" class="widgetsPanelBlock"><!-- startFragment:p_wpDettaglioIspezione -->
	
	
<h4 class="wpLabel">dettaglio ispezione </h4>
<div class="widgetsPanel" id="wpDettaglioIspezione">
	
	<customtag:widgetsPanel id="wpDettaglioIspezioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptNumeroIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptNumeroIspezione.label')}" labelFor="widg_ptNumeroIspezione" errorFor="appDataIspezione2018.identificativoIspezione" labelId="ptNumeroIspezioneLbl"   >


<!-- widget ptNumeroIspezione -->
<s:property value="appDataIspezione2018.identificativoIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','calDataCreazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.calDataCreazione.label')}" labelFor="widg_calDataCreazione" errorFor="appDataIspezione2018.dataCreazione" labelId="calDataCreazioneLbl"   >


<!-- widget calDataCreazione -->
<s:property value="appDataIspezione2018.dataCreazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptAssegnatario')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptAssegnatario.label')}" labelFor="widg_ptAssegnatario" errorFor="appDataIspezione2018.descrizioneIspettore" labelId="ptAssegnatarioLbl"   >


<!-- widget ptAssegnatario -->
<s:property value="appDataIspezione2018.descrizioneIspettore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','cbSecondoIspettore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.cbSecondoIspettore.label')}" labelFor="widg_cbSecondoIspettore" errorFor="appDataIspezione2018.cfSecondoIspettore" labelId="cbSecondoIspettoreLbl"
	  >


<!-- widget cbSecondoIspettore -->
<s:select name="appDataIspezione2018.cfSecondoIspettore" id="widg_cbSecondoIspettore"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSecondiIspettori"
	  disabled="isWidgetDisabled('cpDettaglioIspezione2018','cbSecondoIspettore')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptSecondoIspettore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptSecondoIspettore.label')}" labelFor="widg_ptSecondoIspettore" errorFor="appDataIspezione2018.cfSecondoIspettore" labelId="ptSecondoIspettoreLbl"   >


<!-- widget ptSecondoIspettore -->
<s:property value="appDataIspezione2018.cfSecondoIspettore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptStato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptStato.label')}" labelFor="widg_ptStato" errorFor="appDataIspezione2018.descrizioneStato" labelId="ptStatoLbl"   >


<!-- widget ptStato -->
<s:property value="appDataIspezione2018.descrizioneStato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataIspezione2018.codiceImpianto" labelId="ptCodiceImpiantoLbl"   >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataIspezione2018.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptDescrizioneImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_ptDescrizioneImpianto" errorFor="appDataIspezione2018.localizzazioneImpianto" labelId="ptDescrizioneImpiantoLbl"   >


<!-- widget ptDescrizioneImpianto -->
<s:property value="appDataIspezione2018.localizzazioneImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','provComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.provComp.label')}" labelFor="widg_provComp" errorFor="appDataIspezione2018.codIstatProv" labelId="provCompLbl"
	  fieldRequired="true">


<!-- widget provComp -->
	<csiuicore:ajaxify id="p_wpDettaglioIspezione" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/elenco_ispezioni_impianti/cpDettaglioIspezione2018!handleProvComp_VALUE_CHANGED.do"
		pageId="cpDettaglioIspezione2018"
		formName="cpDettaglioIspezione2018"
		javascriptDetection="false"
		nameSpace="/base/elenco_ispezioni_impianti">

<s:url id="widg_provCompurlComboBoxValueChange"
   action="/sigitwebn/cpDettaglioIspezione2018!handleProvComp_VALUE_CHANGED" namespace="/base/elenco_ispezioni_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataIspezione2018.codIstatProv" id="widg_provComp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonteIstat"
	  disabled="isWidgetDisabled('cpDettaglioIspezione2018','provComp')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermaprovComp','conferma','%{widg_provCompurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermaprovComp','conferma','%{widg_provCompurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','comComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.comComp.label')}" labelFor="widg_comComp" errorFor="appDataIspezione2018.codIstatCom" labelId="comCompLbl"
	  fieldRequired="true">


<!-- widget comComp -->
<s:select name="appDataIspezione2018.codIstatCom" id="widg_comComp"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniPiemonteIstat"
	  disabled="isWidgetDisabled('cpDettaglioIspezione2018','comComp')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','cbIspPagemento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.cbIspPagemento.label')}" labelFor="widg_cbIspPagemento" errorFor="appDataIspezione2018.flgIspPagamento" labelId="cbIspPagementoLbl"
	  >


<!-- widget cbIspPagemento -->
<s:checkbox 
	
	
	name="appDataIspezione2018.flgIspPagamento" id="widg_cbIspPagemento"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','cbIspPagemento')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpDettaglioIspezione2018','cbIspPagemento')" >
	<s:hidden name="__checkbox_appDataIspezione2018.flgIspPagamento" id="__checkbox_widg_cbIspPagemento" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptDataConclusione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptDataConclusione.label')}" labelFor="widg_ptDataConclusione" errorFor="appDataIspezione2018.dataConclusione" labelId="ptDataConclusioneLbl"   >


<!-- widget ptDataConclusione -->
<s:property value="appDataIspezione2018.dataConclusione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptEsitoIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptEsitoIspezione.label')}" labelFor="widg_ptEsitoIspezione" errorFor="appDataIspezione2018.esito" labelId="ptEsitoIspezioneLbl"   >


<!-- widget ptEsitoIspezione -->
<s:property value="appDataIspezione2018.esito" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptEnteCompetente')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptEnteCompetente.label')}" labelFor="widg_ptEnteCompetente" errorFor="appDataIspezione2018.enteCompetente" labelId="ptEnteCompetenteLbl"   >


<!-- widget ptEnteCompetente -->
<s:property value="appDataIspezione2018.enteCompetente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','ptSveglia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.ptSveglia.label')}" labelFor="widg_ptSveglia" errorFor="appDataIspezione2018.descrizioneSveglia" labelId="ptSvegliaLbl"   >


<!-- widget ptSveglia -->
<s:property value="appDataIspezione2018.descrizioneSveglia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioIspezione2018.taNote.label')}" labelFor="widg_taNote" errorFor="appDataIspezione2018.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDataIspezione2018.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','taNote')"
	rows="3"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettaglioIspezione --></div>

			
	
	<div id="p_cpFunIspezione" class="commandPanelBlock"><!-- startFragment:p_cpFunIspezione -->
	
	
<div class="commandPanel functional" id="cpFunIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btSalvaIspezione')" >

	



<!-- widget btSalvaIspezione -->
<s:submit name="widg_btSalvaIspezione" id="widg_btSalvaIspezione" method="handleBtSalvaIspezione_CLICKED"
	key="cpDettaglioIspezione2018.btSalvaIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btSalvaIspezione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunIspezione --></div>

			
	
	
	<div id="p_mpElenchi" class="panelBlock"><!-- startFragment:p_mpElenchi -->
		

		
<s:if test="#session.cpDettaglioIspezione2018_mpElenchi_selectedMultiPanel == 'cpDettaglioIspezione2018_mpElenchi_fpElenchi'">
	<s:include value="/jsp/multipanels/cpDettaglioIspezione2018_mpElenchi_fpElenchi.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElenchi --></div>

			
	
	<div id="p_cpNavIspezione" class="commandPanelBlock"><!-- startFragment:p_cpNavIspezione -->
	
	
<div class="commandPanel navigation" id="cpNavIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione2018','btSalvaIndietro')" >

	



<!-- widget btSalvaIndietro -->
<s:submit name="widg_btSalvaIndietro" id="widg_btSalvaIndietro" method="handleBtSalvaIndietro_CLICKED"
	key="cpDettaglioIspezione2018.btSalvaIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione2018','btSalvaIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavIspezione --></div>

	

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
