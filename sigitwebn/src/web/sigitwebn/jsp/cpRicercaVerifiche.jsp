<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_verifiche -->
<!-- pageId:cpRicercaVerifiche -->

<s:form id="cpRicercaVerifiche" action="cpRicercaVerifiche" namespace="/base/ricerca_verifiche" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaVerifiche_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicercaVerifiche','menu')" >

	


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

					
	
	<div id="p_fpVerifica" class="formPanelBlock"><!-- startFragment:p_fpVerifica -->

	
	

	
	
			
	
	<div id="p_fpRicercaVerifiche" class="formPanelBlock"><!-- startFragment:p_fpRicercaVerifiche -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsg" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsg -->
	
	
<div class="stdMessagePanel" id="stdMsg">
	<customtag:stdMessagePanel id="stdMsg" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsg --></div>

			
	
	<div id="p_wpVerifica" class="widgetsPanelBlock"><!-- startFragment:p_wpVerifica -->
	
	
<h4 class="wpLabel">verifica </h4>
<div class="widgetsPanel" id="wpVerifica">
	
	<customtag:widgetsPanel id="wpVerificaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaVerifiche','tfIdentificativo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.tfIdentificativo.label')}" labelFor="widg_tfIdentificativo" errorFor="appDataricercaVerifica.identificativo" labelId="tfIdentificativoLbl"
	  >


<!-- widget tfIdentificativo -->
<s:textfield 
	
	
	name="appDataricercaVerifica.identificativo" id="widg_tfIdentificativo"
	disabled="isWidgetDisabled('cpRicercaVerifiche','tfIdentificativo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cbElencoValidatori')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cbElencoValidatori.label')}" labelFor="widg_cbElencoValidatori" errorFor="appDataricercaVerifica.idValidatore" labelId="cbElencoValidatoriLbl"
	  >


<!-- widget cbElencoValidatori -->
<s:select name="appDataricercaVerifica.idValidatore" id="widg_cbElencoValidatori"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoValidatoriVerifica"
	  disabled="isWidgetDisabled('cpRicercaVerifiche','cbElencoValidatori')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cDataCreazioneDA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cDataCreazioneDA.label')}" labelFor="widg_cDataCreazioneDA" errorFor="appDataricercaVerifica.dataCreazioneDA" labelId="cDataCreazioneDALbl"
	  >


<!-- widget cDataCreazioneDA -->
<s:textfield 
	
	
	name="appDataricercaVerifica.dataCreazioneDA" id="widg_cDataCreazioneDA"
	disabled="isWidgetDisabled('cpRicercaVerifiche','cDataCreazioneDA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cDataCreazioneA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cDataCreazioneA.label')}" labelFor="widg_cDataCreazioneA" errorFor="appDataricercaVerifica.dataCreazioneA" labelId="cDataCreazioneALbl"
	  >


<!-- widget cDataCreazioneA -->
<s:textfield 
	
	
	name="appDataricercaVerifica.dataCreazioneA" id="widg_cDataCreazioneA"
	disabled="isWidgetDisabled('cpRicercaVerifiche','cDataCreazioneA')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cbTipoVerifica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cbTipoVerifica.label')}" labelFor="widg_cbTipoVerifica" errorFor="appDataricercaVerifica.tipoVerifica" labelId="cbTipoVerificaLbl"
	  >


<!-- widget cbTipoVerifica -->
<s:select name="appDataricercaVerifica.tipoVerifica" id="widg_cbTipoVerifica"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiVerifica"
	  disabled="isWidgetDisabled('cpRicercaVerifiche','cbTipoVerifica')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','tfCodiceImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.tfCodiceImpianto.label')}" labelFor="widg_tfCodiceImpianto" errorFor="appDataricercaVerifica.codiceImpianto" labelId="tfCodiceImpiantoLbl"
	  >


<!-- widget tfCodiceImpianto -->
<s:textfield 
	
	
	name="appDataricercaVerifica.codiceImpianto" id="widg_tfCodiceImpianto"
	disabled="isWidgetDisabled('cpRicercaVerifiche','tfCodiceImpianto')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cbSiglaBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cbSiglaBollino.label')}" labelFor="widg_cbSiglaBollino" errorFor="appDataricercaVerifica.siglaBollino" labelId="cbSiglaBollinoLbl"
	  >


<!-- widget cbSiglaBollino -->
<s:select name="appDataricercaVerifica.siglaBollino" id="widg_cbSiglaBollino"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaBollini"
	  disabled="isWidgetDisabled('cpRicercaVerifiche','cbSiglaBollino')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','tfNumeroBollino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.tfNumeroBollino.label')}" labelFor="widg_tfNumeroBollino" errorFor="appDataricercaVerifica.numeroBollino" labelId="tfNumeroBollinoLbl"
	  >


<!-- widget tfNumeroBollino -->
<s:textfield 
	
	
	name="appDataricercaVerifica.numeroBollino" id="widg_tfNumeroBollino"
	disabled="isWidgetDisabled('cpRicercaVerifiche','tfNumeroBollino')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','tfDatoDistrib')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.tfDatoDistrib.label')}" labelFor="widg_tfDatoDistrib" errorFor="appDataricercaVerifica.idDatoDistributore" labelId="tfDatoDistribLbl"
	  >


<!-- widget tfDatoDistrib -->
<s:textfield 
	
	
	name="appDataricercaVerifica.idDatoDistributore" id="widg_tfDatoDistrib"
	disabled="isWidgetDisabled('cpRicercaVerifiche','tfDatoDistrib')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaVerifiche','cbRicercaAutomatiche')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaVerifiche.cbRicercaAutomatiche.label')}" labelFor="widg_cbRicercaAutomatiche" errorFor="appDataricercaVerifica.checkRicercaAutomatiche" labelId="cbRicercaAutomaticheLbl"
	  >


<!-- widget cbRicercaAutomatiche -->
<s:checkbox 
	
	
	name="appDataricercaVerifica.checkRicercaAutomatiche" id="widg_cbRicercaAutomatiche"
	disabled="isWidgetDisabled('cpRicercaVerifiche','cbRicercaAutomatiche')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaVerifiche','cbRicercaAutomatiche')" >
	<s:hidden name="__checkbox_appDataricercaVerifica.checkRicercaAutomatiche" id="__checkbox_widg_cbRicercaAutomatiche" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpVerifica --></div>

			
	
	<div id="p_cpFunRicVerifiche" class="commandPanelBlock"><!-- startFragment:p_cpFunRicVerifiche -->
	
	
<div class="commandPanel functional" id="cpFunRicVerifiche">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaVerifiche','btRicerca')" >

	



<!-- widget btRicerca -->
<s:submit name="widg_btRicerca" id="widg_btRicerca" method="handleBtRicerca_CLICKED"
	key="cpRicercaVerifiche.btRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaVerifiche','btRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaVerifiche','btAnnulla')" >

	



<!-- widget btAnnulla -->
<s:submit name="widg_btAnnulla" id="widg_btAnnulla" method="handleBtAnnulla_CLICKED"
	key="cpRicercaVerifiche.btAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaVerifiche','btAnnulla')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaVerifiche','btInserisci')" >

	



<!-- widget btInserisci -->
<s:submit name="widg_btInserisci" id="widg_btInserisci" method="handleBtInserisci_CLICKED"
	key="cpRicercaVerifiche.btInserisci.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaVerifiche','btInserisci')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaVerifiche','btInserisciIspezioniMassive')" >

	



<!-- widget btInserisciIspezioniMassive -->
<s:submit name="widg_btInserisciIspezioniMassive" id="widg_btInserisciIspezioniMassive" method="handleBtInserisciIspezioniMassive_CLICKED"
	key="cpRicercaVerifiche.btInserisciIspezioniMassive.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaVerifiche','btInserisciIspezioniMassive')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicVerifiche --></div>

			
	
	<div id="p_cpNavRicVerifiche" class="commandPanelBlock"><!-- startFragment:p_cpNavRicVerifiche -->
	
	
<div class="commandPanel navigation" id="cpNavRicVerifiche">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaVerifiche','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRicercaVerifiche.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaVerifiche','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicVerifiche --></div>

			
	
	
	<div id="p_mpInserimentoIspezioniMassive" class="panelBlock"><!-- startFragment:p_mpInserimentoIspezioniMassive -->
		

		
<s:if test="#session.cpRicercaVerifiche_mpInserimentoIspezioniMassive_selectedMultiPanel == 'cpRicercaVerifiche_mpInserimentoIspezioniMassive_fpInserimentoIspezioniMassive'">
	<s:include value="/jsp/multipanels/cpRicercaVerifiche_mpInserimentoIspezioniMassive_fpInserimentoIspezioniMassive.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpInserimentoIspezioniMassive --></div>

	

		
	

	<!-- endFragment:p_fpRicercaVerifiche --></div>

	

	<!-- endFragment:p_fpVerifica --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
