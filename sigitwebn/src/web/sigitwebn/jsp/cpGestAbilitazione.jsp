<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/back_office -->
<!-- pageId:cpGestAbilitazione -->

<s:form id="cpGestAbilitazione" action="cpGestAbilitazione" namespace="/base/back_office" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestAbilitazione_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestAbilitazione','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestAbilitazione_udpExpMass.jsp"></s:include>

	



			
	
	<div id="p_fpElencoAbil" class="formPanelBlock"><!-- startFragment:p_fpElencoAbil -->
		
	
<h4 class="fpLabel"><s:text name="cpGestAbilitazione.fpElencoAbil.label" /></h4>
<div class="formPanel" id="fpElencoAbil">


	
	

	
	
			
	
	<div id="p_stdMsgPHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPHome -->
	
	
<div class="stdMessagePanel" id="stdMsgPHome">
	<customtag:stdMessagePanel id="stdMsgPHome" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPHome --></div>

			
	
	<div id="p_fpAbilitazioni" class="formPanelBlock"><!-- startFragment:p_fpAbilitazioni -->
		
	
<div class="formPanel" id="fpAbilitazioni">


	
	

	
	
			
	
	<div id="p_wpGestAbilitazione" class="widgetsPanelBlock"><!-- startFragment:p_wpGestAbilitazione -->
	
	
<h4 class="wpLabel">nuova abilitazione </h4>
<div class="widgetsPanel" id="wpGestAbilitazione">
	
	<customtag:widgetsPanel id="wpGestAbilitazioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestAbilitazione','cbElencoRuoli')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAbilitazione.cbElencoRuoli.label')}" labelFor="widg_cbElencoRuoli" errorFor="appDataabilitazione.idRuoloPa" labelId="cbElencoRuoliLbl"
	  >


<!-- widget cbElencoRuoli -->
<s:select name="appDataabilitazione.idRuoloPa" id="widg_cbElencoRuoli"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoRuolo"
	  disabled="isWidgetDisabled('cpGestAbilitazione','cbElencoRuoli')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAbilitazione','tfCfUtente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAbilitazione.tfCfUtente.label')}" labelFor="widg_tfCfUtente" errorFor="appDataabilitazione.cfUtente" labelId="tfCfUtenteLbl"
	  >


<!-- widget tfCfUtente -->
<s:textfield 
	
	
	name="appDataabilitazione.cfUtente" id="widg_tfCfUtente"
maxlength="16"	disabled="isWidgetDisabled('cpGestAbilitazione','tfCfUtente')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAbilitazione','btnRicercaUtente')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnRicercaUtente -->
<s:submit name="widg_btnRicercaUtente" id="widg_btnRicercaUtente" method="handleBtnRicercaUtente_CLICKED"
	key="cpGestAbilitazione.btnRicercaUtente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestAbilitazione','btnRicercaUtente')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAbilitazione','cbElencoUtenti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAbilitazione.cbElencoUtenti.label')}" labelFor="widg_cbElencoUtenti" errorFor="appDataabilitazione.idPersonaFisica" labelId="cbElencoUtentiLbl"
	  fieldRequired="true">


<!-- widget cbElencoUtenti -->
<s:select name="appDataabilitazione.idPersonaFisica" id="widg_cbElencoUtenti"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUtentiPaTrovati"
	  disabled="isWidgetDisabled('cpGestAbilitazione','cbElencoUtenti')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAbilitazione','cbProvinciaAbilitazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAbilitazione.cbProvinciaAbilitazione.label')}" labelFor="widg_cbProvinciaAbilitazione" errorFor="appDataprovinciaAbilitazioneSelez" labelId="cbProvinciaAbilitazioneLbl"
	  fieldRequired="true">


<!-- widget cbProvinciaAbilitazione -->
	<csiuicore:ajaxify id="p_wpGestAbilitazione" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/back_office/cpGestAbilitazione!handleCbProvinciaAbilitazione_VALUE_CHANGED.do"
		pageId="cpGestAbilitazione"
		formName="cpGestAbilitazione"
		javascriptDetection="false"
		nameSpace="/base/back_office">

<s:url id="widg_cbProvinciaAbilitazioneurlComboBoxValueChange"
   action="/sigitwebn/cpGestAbilitazione!handleCbProvinciaAbilitazione_VALUE_CHANGED" namespace="/base/back_office"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataprovinciaAbilitazioneSelez" id="widg_cbProvinciaAbilitazione"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovinceAbilitazione"
	  disabled="isWidgetDisabled('cpGestAbilitazione','cbProvinciaAbilitazione')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvinciaAbilitazione','conferma','%{widg_cbProvinciaAbilitazioneurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvinciaAbilitazione','conferma','%{widg_cbProvinciaAbilitazioneurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAbilitazione','cbComuneAbilitazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAbilitazione.cbComuneAbilitazione.label')}" labelFor="widg_cbComuneAbilitazione" errorFor="appDataabilitazione.istatAbilitazione" labelId="cbComuneAbilitazioneLbl"
	  >


<!-- widget cbComuneAbilitazione -->
<s:select name="appDataabilitazione.istatAbilitazione" id="widg_cbComuneAbilitazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuniAbilitazione"
	  disabled="isWidgetDisabled('cpGestAbilitazione','cbComuneAbilitazione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestAbilitazione','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestAbilitazione.taNote.label')}" labelFor="widg_taNote" errorFor="appDataabilitazione.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDataabilitazione.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpGestAbilitazione','taNote')"
	rows="2"
	cols="100"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpGestAbilitazione --></div>

			
	
	<div id="p_cpAbilitazioni" class="commandPanelBlock"><!-- startFragment:p_cpAbilitazioni -->
	
	
<div class="commandPanel functional" id="cpAbilitazioni">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestAbilitazione','btnSalvaAbilitazione')" >

	



<!-- widget btnSalvaAbilitazione -->
<s:submit name="widg_btnSalvaAbilitazione" id="widg_btnSalvaAbilitazione" method="handleBtnSalvaAbilitazione_CLICKED"
	key="cpGestAbilitazione.btnSalvaAbilitazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestAbilitazione','btnSalvaAbilitazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestAbilitazione','btnAnnullaAbilitazione')" >

	



<!-- widget btnAnnullaAbilitazione -->
<s:submit name="widg_btnAnnullaAbilitazione" id="widg_btnAnnullaAbilitazione" method="handleBtnAnnullaAbilitazione_CLICKED"
	key="cpGestAbilitazione.btnAnnullaAbilitazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestAbilitazione','btnAnnullaAbilitazione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpAbilitazioni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAbilitazioni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoAbil --></div>

			
	
	<div id="p_cpElencoAbilBack" class="commandPanelBlock"><!-- startFragment:p_cpElencoAbilBack -->
	
	
<div class="commandPanel navigation" id="cpElencoAbilBack">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestAbilitazione','cbIndietro')" >

	



<!-- widget cbIndietro -->
<s:submit name="widg_cbIndietro" id="widg_cbIndietro" method="handleCbIndietro_CLICKED"
	key="cpGestAbilitazione.cbIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestAbilitazione','cbIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoAbilBack --></div>

	

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
