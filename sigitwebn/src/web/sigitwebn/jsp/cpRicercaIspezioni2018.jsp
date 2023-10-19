<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/elenco_ispezioni_impianti -->
<!-- pageId:cpRicercaIspezioni2018 -->

<s:form id="cpRicercaIspezioni2018" action="cpRicercaIspezioni2018" namespace="/base/elenco_ispezioni_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaIspezioni2018_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','menu')" >

	


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
		
	
<h4 class="fpLabel"><s:text name="cpRicercaIspezioni2018.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdErrorMessageRicercaIspezione" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageRicercaIspezione -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageRicercaIspezione">
	<customtag:stdMessagePanel id="stdErrorMessageRicercaIspezione" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageRicercaIspezione --></div>

			
	
	<div id="p_wpRicercaIspezioni" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaIspezioni -->
	
	
<h4 class="wpLabel">ispezione </h4>
<div class="widgetsPanel" id="wpRicercaIspezioni">
	
	<customtag:widgetsPanel id="wpRicercaIspezioniTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','tfIdentificativo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.tfIdentificativo.label')}" labelFor="widg_tfIdentificativo" errorFor="appDataRicercaIspezioni2018.identificativoIspezione" labelId="tfIdentificativoLbl"
	  >


<!-- widget tfIdentificativo -->
<s:textfield 
	
	
	name="appDataRicercaIspezioni2018.identificativoIspezione" id="widg_tfIdentificativo"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','tfIdentificativo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','cbCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.cbCodiceFiscale.label')}" labelFor="widg_cbCodiceFiscale" errorFor="appDataRicercaIspezioni2018.idIspettore" labelId="cbCodiceFiscaleLbl"
	  >


<!-- widget cbCodiceFiscale -->
<s:select name="appDataRicercaIspezioni2018.idIspettore" id="widg_cbCodiceFiscale"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIspettori"
	  disabled="isWidgetDisabled('cpRicercaIspezioni2018','cbCodiceFiscale')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','clDataCreazioneDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.clDataCreazioneDa.label')}" labelFor="widg_clDataCreazioneDa" errorFor="appDataRicercaIspezioni2018.dataCreazioneDa" labelId="clDataCreazioneDaLbl"
	  >


<!-- widget clDataCreazioneDa -->
<s:textfield 
	
	
	name="appDataRicercaIspezioni2018.dataCreazioneDa" id="widg_clDataCreazioneDa"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','clDataCreazioneDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','clDataCreazioneA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.clDataCreazioneA.label')}" labelFor="widg_clDataCreazioneA" errorFor="appDataRicercaIspezioni2018.dataCreazioneA" labelId="clDataCreazioneALbl"
	  >


<!-- widget clDataCreazioneA -->
<s:textfield 
	
	
	name="appDataRicercaIspezioni2018.dataCreazioneA" id="widg_clDataCreazioneA"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','clDataCreazioneA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','clDataConclusioneDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.clDataConclusioneDa.label')}" labelFor="widg_clDataConclusioneDa" errorFor="appDataRicercaIspezioni2018.dataConclusioneDa" labelId="clDataConclusioneDaLbl"
	  >


<!-- widget clDataConclusioneDa -->
<s:textfield 
	
	
	name="appDataRicercaIspezioni2018.dataConclusioneDa" id="widg_clDataConclusioneDa"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','clDataConclusioneDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','clDataConclusioneA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.clDataConclusioneA.label')}" labelFor="widg_clDataConclusioneA" errorFor="appDataRicercaIspezioni2018.dataConclusioneA" labelId="clDataConclusioneALbl"
	  >


<!-- widget clDataConclusioneA -->
<s:textfield 
	
	
	name="appDataRicercaIspezioni2018.dataConclusioneA" id="widg_clDataConclusioneA"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','clDataConclusioneA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','cbStatoIspezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.cbStatoIspezione.label')}" labelFor="widg_cbStatoIspezione" errorFor="appDataRicercaIspezioni2018.idStatoIspezione" labelId="cbStatoIspezioneLbl"
	  >


<!-- widget cbStatoIspezione -->
<s:select name="appDataRicercaIspezioni2018.idStatoIspezione" id="widg_cbStatoIspezione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatiIspezione"
	  disabled="isWidgetDisabled('cpRicercaIspezioni2018','cbStatoIspezione')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','cbEsitoIspezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.cbEsitoIspezione.label')}" labelFor="widg_cbEsitoIspezione" errorFor="appDataRicercaIspezioni2018.flgEsitoIspezione" labelId="cbEsitoIspezioneLbl"
	  >


<!-- widget cbEsitoIspezione -->
<s:select name="appDataRicercaIspezioni2018.flgEsitoIspezione" id="widg_cbEsitoIspezione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPositivoNegativo"
	  disabled="isWidgetDisabled('cpRicercaIspezioni2018','cbEsitoIspezione')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','tfCodiceImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.tfCodiceImpianto.label')}" labelFor="widg_tfCodiceImpianto" errorFor="appDataRicercaIspezioni2018.codiceImpianto" labelId="tfCodiceImpiantoLbl"
	  >


<!-- widget tfCodiceImpianto -->
<s:textfield 
	
	
	name="appDataRicercaIspezioni2018.codiceImpianto" id="widg_tfCodiceImpianto"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','tfCodiceImpianto')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','cbNonAssegnato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.cbNonAssegnato.label')}" labelFor="widg_cbNonAssegnato" errorFor="appDataRicercaIspezioni2018.flgNonAssegnato" labelId="cbNonAssegnatoLbl"
	  >


<!-- widget cbNonAssegnato -->
<s:checkbox 
	
	
	name="appDataRicercaIspezioni2018.flgNonAssegnato" id="widg_cbNonAssegnato"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','cbNonAssegnato')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaIspezioni2018','cbNonAssegnato')" >
	<s:hidden name="__checkbox_appDataRicercaIspezioni2018.flgNonAssegnato" id="__checkbox_widg_cbNonAssegnato" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','cbProvComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.cbProvComp.label')}" labelFor="widg_cbProvComp" errorFor="appDataRicercaIspezioni2018.istatProvincia" labelId="cbProvCompLbl"
	  >


<!-- widget cbProvComp -->
	<csiuicore:ajaxify id="p_wpRicercaIspezioni" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/elenco_ispezioni_impianti/cpRicercaIspezioni2018!handleCbProvComp_VALUE_CHANGED.do"
		pageId="cpRicercaIspezioni2018"
		formName="cpRicercaIspezioni2018"
		javascriptDetection="false"
		nameSpace="/base/elenco_ispezioni_impianti">

<s:url id="widg_cbProvCompurlComboBoxValueChange"
   action="/sigitwebn/cpRicercaIspezioni2018!handleCbProvComp_VALUE_CHANGED" namespace="/base/elenco_ispezioni_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataRicercaIspezioni2018.istatProvincia" id="widg_cbProvComp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonteIstat"
	  disabled="isWidgetDisabled('cpRicercaIspezioni2018','cbProvComp')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvComp','conferma','%{widg_cbProvCompurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvComp','conferma','%{widg_cbProvCompurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','cbComComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.cbComComp.label')}" labelFor="widg_cbComComp" errorFor="appDataRicercaIspezioni2018.istatComune" labelId="cbComCompLbl"
	  >


<!-- widget cbComComp -->
<s:select name="appDataRicercaIspezioni2018.istatComune" id="widg_cbComComp"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniPiemonteIstat"
	  disabled="isWidgetDisabled('cpRicercaIspezioni2018','cbComComp')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','cbUspPagamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaIspezioni2018.cbUspPagamento.label')}" labelFor="widg_cbUspPagamento" errorFor="appDataRicercaIspezioni2018.flgIspPagamento" labelId="cbUspPagamentoLbl"
	  >


<!-- widget cbUspPagamento -->
<s:checkbox 
	
	
	name="appDataRicercaIspezioni2018.flgIspPagamento" id="widg_cbUspPagamento"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','cbUspPagamento')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaIspezioni2018','cbUspPagamento')" >
	<s:hidden name="__checkbox_appDataRicercaIspezioni2018.flgIspPagamento" id="__checkbox_widg_cbUspPagamento" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaIspezioni --></div>

			
	
	<div id="p_cpFunRicercaIspezioni" class="commandPanelBlock"><!-- startFragment:p_cpFunRicercaIspezioni -->
	
	
<div class="commandPanel functional" id="cpFunRicercaIspezioni">

	
	
		
		
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','btRicercaInserimento')" >

	



<!-- widget btRicercaInserimento -->
<s:submit name="widg_btRicercaInserimento" id="widg_btRicercaInserimento" method="handleBtRicercaInserimento_CLICKED"
	key="cpRicercaIspezioni2018.btRicercaInserimento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','btRicercaInserimento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','btAnnullaRicercaIspezioni')" >

	



<!-- widget btAnnullaRicercaIspezioni -->
<s:submit name="widg_btAnnullaRicercaIspezioni" id="widg_btAnnullaRicercaIspezioni" method="handleBtAnnullaRicercaIspezioni_CLICKED"
	key="cpRicercaIspezioni2018.btAnnullaRicercaIspezioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','btAnnullaRicercaIspezioni')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunRicercaIspezioni --></div>

			
	
	<div id="p_cpNavRicercaIspezioni" class="commandPanelBlock"><!-- startFragment:p_cpNavRicercaIspezioni -->
	
	
<div class="commandPanel navigation" id="cpNavRicercaIspezioni">

	
	
		
		
<s:if test="isWidgetVisible('cpRicercaIspezioni2018','btIndietroRicercaIspezioni')" >

	



<!-- widget btIndietroRicercaIspezioni -->
<s:submit name="widg_btIndietroRicercaIspezioni" id="widg_btIndietroRicercaIspezioni" method="handleBtIndietroRicercaIspezioni_CLICKED"
	key="cpRicercaIspezioni2018.btIndietroRicercaIspezioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaIspezioni2018','btIndietroRicercaIspezioni')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNavRicercaIspezioni --></div>

	

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
