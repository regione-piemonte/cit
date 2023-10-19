<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_allegati_module -->
<!-- pageId:cpRicercaAllegati -->

<s:form id="cpRicercaAllegati" action="cpRicercaAllegati" namespace="/base/ricerca_allegati_module" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaAllegati_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicercaAllegati','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRicercaAllegati" class="formPanelBlock"><!-- startFragment:p_fpRicercaAllegati -->
		
	
<h4 class="fpLabel"><s:text name="cpRicercaAllegati.fpRicercaAllegati.label" /></h4>
<div class="formPanel" id="fpRicercaAllegati">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRicercaAllegati --></div>

			
	
	<div id="p_stdMessageRicercaAllegati" class="stdMessagePanelBlock"><!-- startFragment:p_stdMessageRicercaAllegati -->
	
	
<div class="stdMessagePanel" id="stdMessageRicercaAllegati">
	<customtag:stdMessagePanel id="stdMessageRicercaAllegati" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMessageRicercaAllegati --></div>

			
	
	<div id="p_wpRicercaAllegati" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAllegati -->
	
	
<h4 class="wpLabel">REE, Manutenzioni e RapProva </h4>
<div class="widgetsPanel" id="wpRicercaAllegati">
	
	<customtag:widgetsPanel id="wpRicercaAllegatiTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbStatoAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbStatoAllegato.label')}" labelFor="widg_cbStatoAllegato" errorFor="appDataricercaAllegati.idStatoAllegato" labelId="cbStatoAllegatoLbl"
	position="first"  >


<!-- widget cbStatoAllegato -->
<s:select name="appDataricercaAllegati.idStatoAllegato" id="widg_cbStatoAllegato"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatiAllegato"
	  disabled="isWidgetDisabled('cpRicercaAllegati','cbStatoAllegato')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','wpRicercaAllegati_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaAllegati_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbTipoAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbTipoAllegato.label')}" labelFor="widg_cbTipoAllegato" errorFor="appDataricercaAllegati.idTipoDocumento" labelId="cbTipoAllegatoLbl"
	position="first"  >


<!-- widget cbTipoAllegato -->
<s:select name="appDataricercaAllegati.idTipoDocumento" id="widg_cbTipoAllegato"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipiDocumento"
	  disabled="isWidgetDisabled('cpRicercaAllegati','cbTipoAllegato')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','wpRicercaAllegati_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpRicercaAllegati_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cDataControlloDaAllegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cDataControlloDaAllegati.label')}" labelFor="widg_cDataControlloDaAllegati" errorFor="appDataricercaAllegati.dataControlloDa" labelId="cDataControlloDaAllegatiLbl"
	position="first"  >


<!-- widget cDataControlloDaAllegati -->
<s:textfield 
	
	
	name="appDataricercaAllegati.dataControlloDa" id="widg_cDataControlloDaAllegati"
	disabled="isWidgetDisabled('cpRicercaAllegati','cDataControlloDaAllegati')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cDataControlloAAllegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cDataControlloAAllegati.label')}" labelFor="widg_cDataControlloAAllegati" errorFor="appDataricercaAllegati.dataControlloA" labelId="cDataControlloAAllegatiLbl"
	position="last"  >


<!-- widget cDataControlloAAllegati -->
<s:textfield 
	
	
	name="appDataricercaAllegati.dataControlloA" id="widg_cDataControlloAAllegati"
	disabled="isWidgetDisabled('cpRicercaAllegati','cDataControlloAAllegati')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbSic')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbSic.label')}" labelFor="widg_cbSic" errorFor="appDataricercaAllegati.sicurezzaImpianti" labelId="cbSicLbl"
	position="first"  >


<!-- widget cbSic -->
<s:select name="appDataricercaAllegati.sicurezzaImpianti" id="widg_cbSic"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiNo"
	  disabled="isWidgetDisabled('cpRicercaAllegati','cbSic')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbConPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbConPre.label')}" labelFor="widg_cbConPre" errorFor="appDataricercaAllegati.conPrescrizioni" labelId="cbConPreLbl"
	position="last"  >


<!-- widget cbConPre -->
<s:checkbox 
	
	
	name="appDataricercaAllegati.conPrescrizioni" id="widg_cbConPre"
	disabled="isWidgetDisabled('cpRicercaAllegati','cbConPre')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaAllegati','cbConPre')" >
	<s:hidden name="__checkbox_appDataricercaAllegati.conPrescrizioni" id="__checkbox_widg_cbConPre" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbConRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbConRacc.label')}" labelFor="widg_cbConRacc" errorFor="appDataricercaAllegati.conRaccomandazioni" labelId="cbConRaccLbl"
	position="first"  >


<!-- widget cbConRacc -->
<s:checkbox 
	
	
	name="appDataricercaAllegati.conRaccomandazioni" id="widg_cbConRacc"
	disabled="isWidgetDisabled('cpRicercaAllegati','cbConRacc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaAllegati','cbConRacc')" >
	<s:hidden name="__checkbox_appDataricercaAllegati.conRaccomandazioni" id="__checkbox_widg_cbConRacc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbConOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbConOss.label')}" labelFor="widg_cbConOss" errorFor="appDataricercaAllegati.conOsservazioni" labelId="cbConOssLbl"
	position="last"  >


<!-- widget cbConOss -->
<s:checkbox 
	
	
	name="appDataricercaAllegati.conOsservazioni" id="widg_cbConOss"
	disabled="isWidgetDisabled('cpRicercaAllegati','cbConOss')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaAllegati','cbConOss')" >
	<s:hidden name="__checkbox_appDataricercaAllegati.conOsservazioni" id="__checkbox_widg_cbConOss" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cInterventoAllegatiDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cInterventoAllegatiDa.label')}" labelFor="widg_cInterventoAllegatiDa" errorFor="appDataricercaAllegati.interventoDa" labelId="cInterventoAllegatiDaLbl"
	position="first"  >


<!-- widget cInterventoAllegatiDa -->
<s:textfield 
	
	
	name="appDataricercaAllegati.interventoDa" id="widg_cInterventoAllegatiDa"
	disabled="isWidgetDisabled('cpRicercaAllegati','cInterventoAllegatiDa')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAllegati','cInterventoAallegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cInterventoAallegati.label')}" labelFor="widg_cInterventoAallegati" errorFor="appDataricercaAllegati.interventoA" labelId="cInterventoAallegatiLbl"
	position="last"  >


<!-- widget cInterventoAallegati -->
<s:textfield 
	
	
	name="appDataricercaAllegati.interventoA" id="widg_cInterventoAallegati"
	disabled="isWidgetDisabled('cpRicercaAllegati','cInterventoAallegati')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAllegati --></div>

			
	
	<div id="p_wpBollinoVerdeAllegati" class="widgetsPanelBlock"><!-- startFragment:p_wpBollinoVerdeAllegati -->
	
	
<h4 class="wpLabel">codice REE </h4>
<div class="widgetsPanel" id="wpBollinoVerdeAllegati">
	
	<customtag:widgetsPanel id="wpBollinoVerdeAllegatiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbSiglaBollinoVerdeAllegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbSiglaBollinoVerdeAllegati.label')}" labelFor="widg_cbSiglaBollinoVerdeAllegati" errorFor="appDataricercaAllegati.idBollinoSigla" labelId="cbSiglaBollinoVerdeAllegatiLbl"
	  >


<!-- widget cbSiglaBollinoVerdeAllegati -->
<s:select name="appDataricercaAllegati.idBollinoSigla" id="widg_cbSiglaBollinoVerdeAllegati"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSigleBollino"
	  disabled="isWidgetDisabled('cpRicercaAllegati','cbSiglaBollinoVerdeAllegati')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAllegati','tfNumeroBollinoVerdeAllegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.tfNumeroBollinoVerdeAllegati.label')}" labelFor="widg_tfNumeroBollinoVerdeAllegati" errorFor="appDataricercaAllegati.numeroBollino" labelId="tfNumeroBollinoVerdeAllegatiLbl"
	  >


<!-- widget tfNumeroBollinoVerdeAllegati -->
<s:textfield 
	
	
	name="appDataricercaAllegati.numeroBollino" id="widg_tfNumeroBollinoVerdeAllegati"
maxlength="11"	disabled="isWidgetDisabled('cpRicercaAllegati','tfNumeroBollinoVerdeAllegati')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpBollinoVerdeAllegati --></div>

			
	
	<div id="p_wpManutentoreAllegati" class="widgetsPanelBlock"><!-- startFragment:p_wpManutentoreAllegati -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpManutentoreAllegati">
	
	<customtag:widgetsPanel id="wpManutentoreAllegatiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAllegati','cbSiglaReaAllegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.cbSiglaReaAllegati.label')}" labelFor="widg_cbSiglaReaAllegati" errorFor="appDataricercaAllegati.idReaSigla" labelId="cbSiglaReaAllegatiLbl"
	  >


<!-- widget cbSiglaReaAllegati -->
<s:select name="appDataricercaAllegati.idReaSigla" id="widg_cbSiglaReaAllegati"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSigleRea"
	  disabled="isWidgetDisabled('cpRicercaAllegati','cbSiglaReaAllegati')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAllegati','tfNumeroReaAllegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.tfNumeroReaAllegati.label')}" labelFor="widg_tfNumeroReaAllegati" errorFor="appDataricercaAllegati.numeroRea" labelId="tfNumeroReaAllegatiLbl"
	  >


<!-- widget tfNumeroReaAllegati -->
<s:textfield 
	
	
	name="appDataricercaAllegati.numeroRea" id="widg_tfNumeroReaAllegati"
maxlength="9"	disabled="isWidgetDisabled('cpRicercaAllegati','tfNumeroReaAllegati')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAllegati','tfCodiceFiscaleAllegati')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAllegati.tfCodiceFiscaleAllegati.label')}" labelFor="widg_tfCodiceFiscaleAllegati" errorFor="appDataricercaAllegati.codiceFiscale" labelId="tfCodiceFiscaleAllegatiLbl"
	  >


<!-- widget tfCodiceFiscaleAllegati -->
<s:textfield 
	
	
	name="appDataricercaAllegati.codiceFiscale" id="widg_tfCodiceFiscaleAllegati"
maxlength="16"	disabled="isWidgetDisabled('cpRicercaAllegati','tfCodiceFiscaleAllegati')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpManutentoreAllegati --></div>

			
	
	<div id="p_cpAnnullaRicercaImpianti" class="commandPanelBlock"><!-- startFragment:p_cpAnnullaRicercaImpianti -->
	
	
<div class="commandPanel functional" id="cpAnnullaRicercaImpianti">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAllegati','btnEseguiRicercaAllegati')" >

	



<!-- widget btnEseguiRicercaAllegati -->
<s:submit name="widg_btnEseguiRicercaAllegati" id="widg_btnEseguiRicercaAllegati" method="handleBtnEseguiRicercaAllegati_CLICKED"
	key="cpRicercaAllegati.btnEseguiRicercaAllegati.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAllegati','btnEseguiRicercaAllegati')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicercaAllegati','btnAnnullaRicercaAllegati')" >

	



<!-- widget btnAnnullaRicercaAllegati -->
<s:submit name="widg_btnAnnullaRicercaAllegati" id="widg_btnAnnullaRicercaAllegati" method="handleBtnAnnullaRicercaAllegati_CLICKED"
	key="cpRicercaAllegati.btnAnnullaRicercaAllegati.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAllegati','btnAnnullaRicercaAllegati')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpAnnullaRicercaImpianti --></div>

			
	
	<div id="p_cpRicercaAllegati" class="commandPanelBlock"><!-- startFragment:p_cpRicercaAllegati -->
	
	
<div class="commandPanel navigation" id="cpRicercaAllegati">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaAllegati','btnIndietroRicercaAllegati')" >

	



<!-- widget btnIndietroRicercaAllegati -->
<s:submit name="widg_btnIndietroRicercaAllegati" id="widg_btnIndietroRicercaAllegati" method="handleBtnIndietroRicercaAllegati_CLICKED"
	key="cpRicercaAllegati.btnIndietroRicercaAllegati.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAllegati','btnIndietroRicercaAllegati')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpRicercaAllegati --></div>

	

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
