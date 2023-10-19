<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_accertamenti -->
<!-- pageId:cpRicercaAccertamenti -->

<s:form id="cpRicercaAccertamenti" action="cpRicercaAccertamenti" namespace="/base/ricerca_accertamenti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaAccertamenti_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicercaAccertamenti','menu')" >

	


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

					
	
	<div id="p_fpAccertamenti" class="formPanelBlock"><!-- startFragment:p_fpAccertamenti -->

	
	

	
	
			
	
	<div id="p_fpRicercaAccertamenti" class="formPanelBlock"><!-- startFragment:p_fpRicercaAccertamenti -->
		
	
<h4 class="fpLabel"><s:text name="cpRicercaAccertamenti.fpRicercaAccertamenti.label" /></h4>
<div class="formPanel" id="fpRicercaAccertamenti">


	
	

	
	
			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpAccertamento" class="widgetsPanelBlock"><!-- startFragment:p_wpAccertamento -->
	
	
<h4 class="wpLabel">accertamento </h4>
<div class="widgetsPanel" id="wpAccertamento">
	
	<customtag:widgetsPanel id="wpAccertamentoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','tfIdentificativo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.tfIdentificativo.label')}" labelFor="widg_tfIdentificativo" errorFor="appDataricercaAccertamento.identificativo" labelId="tfIdentificativoLbl"
	  >


<!-- widget tfIdentificativo -->
<s:textfield 
	
	
	name="appDataricercaAccertamento.identificativo" id="widg_tfIdentificativo"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','tfIdentificativo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cbElencoValidatori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cbElencoValidatori.label')}" labelFor="widg_cbElencoValidatori" errorFor="appDataricercaAccertamento.idValidatore" labelId="cbElencoValidatoriLbl"
	  >


<!-- widget cbElencoValidatori -->
<s:select name="appDataricercaAccertamento.idValidatore" id="widg_cbElencoValidatori"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoValidatori"
	  disabled="isWidgetDisabled('cpRicercaAccertamenti','cbElencoValidatori')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cDataCreazioneDA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cDataCreazioneDA.label')}" labelFor="widg_cDataCreazioneDA" errorFor="appDataricercaAccertamento.dataCreazioneDA" labelId="cDataCreazioneDALbl"
	  >


<!-- widget cDataCreazioneDA -->
<s:textfield 
	
	
	name="appDataricercaAccertamento.dataCreazioneDA" id="widg_cDataCreazioneDA"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','cDataCreazioneDA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cDataCreazioneA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cDataCreazioneA.label')}" labelFor="widg_cDataCreazioneA" errorFor="appDataricercaAccertamento.dataCreazioneA" labelId="cDataCreazioneALbl"
	  >


<!-- widget cDataCreazioneA -->
<s:textfield 
	
	
	name="appDataricercaAccertamento.dataCreazioneA" id="widg_cDataCreazioneA"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','cDataCreazioneA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cDataConclusioneDA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cDataConclusioneDA.label')}" labelFor="widg_cDataConclusioneDA" errorFor="appDataricercaAccertamento.dataConclusioneDA" labelId="cDataConclusioneDALbl"
	  >


<!-- widget cDataConclusioneDA -->
<s:textfield 
	
	
	name="appDataricercaAccertamento.dataConclusioneDA" id="widg_cDataConclusioneDA"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','cDataConclusioneDA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cDataConclusioneA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cDataConclusioneA.label')}" labelFor="widg_cDataConclusioneA" errorFor="appDataricercaAccertamento.dataConclusioneA" labelId="cDataConclusioneALbl"
	  >


<!-- widget cDataConclusioneA -->
<s:textfield 
	
	
	name="appDataricercaAccertamento.dataConclusioneA" id="widg_cDataConclusioneA"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','cDataConclusioneA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cbStatoAccertamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cbStatoAccertamento.label')}" labelFor="widg_cbStatoAccertamento" errorFor="appDataricercaAccertamento.idStatoAccertamento" labelId="cbStatoAccertamentoLbl"
	  >


<!-- widget cbStatoAccertamento -->
<s:select name="appDataricercaAccertamento.idStatoAccertamento" id="widg_cbStatoAccertamento"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoAccertamento"
	  disabled="isWidgetDisabled('cpRicercaAccertamenti','cbStatoAccertamento')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cbTipoAnomalia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cbTipoAnomalia.label')}" labelFor="widg_cbTipoAnomalia" errorFor="appDataricercaAccertamento.idTipoAnomalia" labelId="cbTipoAnomaliaLbl"
	  >


<!-- widget cbTipoAnomalia -->
<s:select name="appDataricercaAccertamento.idTipoAnomalia" id="widg_cbTipoAnomalia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoAnomalie"
	  disabled="isWidgetDisabled('cpRicercaAccertamenti','cbTipoAnomalia')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cbTipoConclusione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cbTipoConclusione.label')}" labelFor="widg_cbTipoConclusione" errorFor="appDataricercaAccertamento.idTipoConclusione" labelId="cbTipoConclusioneLbl"
	  >


<!-- widget cbTipoConclusione -->
<s:select name="appDataricercaAccertamento.idTipoConclusione" id="widg_cbTipoConclusione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoConclusione"
	  disabled="isWidgetDisabled('cpRicercaAccertamenti','cbTipoConclusione')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','tfCodiceImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.tfCodiceImpianto.label')}" labelFor="widg_tfCodiceImpianto" errorFor="appDataricercaAccertamento.codiceImpianto" labelId="tfCodiceImpiantoLbl"
	  >


<!-- widget tfCodiceImpianto -->
<s:textfield 
	
	
	name="appDataricercaAccertamento.codiceImpianto" id="widg_tfCodiceImpianto"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','tfCodiceImpianto')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cbNonAssegnato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cbNonAssegnato.label')}" labelFor="widg_cbNonAssegnato" errorFor="appDataricercaAccertamento.flgNonAssegnato" labelId="cbNonAssegnatoLbl"
	  >


<!-- widget cbNonAssegnato -->
<s:checkbox 
	
	
	name="appDataricercaAccertamento.flgNonAssegnato" id="widg_cbNonAssegnato"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','cbNonAssegnato')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaAccertamenti','cbNonAssegnato')" >
	<s:hidden name="__checkbox_appDataricercaAccertamento.flgNonAssegnato" id="__checkbox_widg_cbNonAssegnato" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cbProvComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cbProvComp.label')}" labelFor="widg_cbProvComp" errorFor="appDataricercaAccertamento.istatProvincia" labelId="cbProvCompLbl"
	  >


<!-- widget cbProvComp -->
	<csiuicore:ajaxify id="p_wpAccertamento" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/ricerca_accertamenti/cpRicercaAccertamenti!handleCbProvComp_VALUE_CHANGED.do"
		pageId="cpRicercaAccertamenti"
		formName="cpRicercaAccertamenti"
		javascriptDetection="false"
		nameSpace="/base/ricerca_accertamenti">

<s:url id="widg_cbProvCompurlComboBoxValueChange"
   action="/sigitwebn/cpRicercaAccertamenti!handleCbProvComp_VALUE_CHANGED" namespace="/base/ricerca_accertamenti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaAccertamento.istatProvincia" id="widg_cbProvComp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonteIstat"
	  disabled="isWidgetDisabled('cpRicercaAccertamenti','cbProvComp')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvComp','conferma','%{widg_cbProvCompurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvComp','conferma','%{widg_cbProvCompurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAccertamenti','cbComComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAccertamenti.cbComComp.label')}" labelFor="widg_cbComComp" errorFor="appDataricercaAccertamento.istatComune" labelId="cbComCompLbl"
	  >


<!-- widget cbComComp -->
<s:select name="appDataricercaAccertamento.istatComune" id="widg_cbComComp"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniPiemonteIstat"
	  disabled="isWidgetDisabled('cpRicercaAccertamenti','cbComComp')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAccertamento --></div>

			
	
	<div id="p_cpFunRicVerifiche" class="commandPanelBlock"><!-- startFragment:p_cpFunRicVerifiche -->
	
	
<div class="commandPanel functional" id="cpFunRicVerifiche">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAccertamenti','btRicerca')" >

	



<!-- widget btRicerca -->
<s:submit name="widg_btRicerca" id="widg_btRicerca" method="handleBtRicerca_CLICKED"
	key="cpRicercaAccertamenti.btRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','btRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaAccertamenti','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpRicercaAccertamenti.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','btAnnulla')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicVerifiche --></div>

			
	
	<div id="p_cpNavRicVerifiche" class="commandPanelBlock"><!-- startFragment:p_cpNavRicVerifiche -->
	
	
<div class="commandPanel navigation" id="cpNavRicVerifiche">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAccertamenti','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRicercaAccertamenti.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAccertamenti','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicVerifiche --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRicercaAccertamenti --></div>

	

	<!-- endFragment:p_fpAccertamenti --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
