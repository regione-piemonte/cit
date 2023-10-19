<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricerca_impianti -->
<!-- pageId:cpRicImpianto -->

<s:form id="cpRicImpianto" action="cpRicImpianto" namespace="/base/ricerca_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicImpianto_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRicImpianto','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRicImpianto" class="formPanelBlock"><!-- startFragment:p_fpRicImpianto -->
		
	
<h4 class="fpLabel"><s:text name="cpRicImpianto.fpRicImpianto.label" /></h4>
<div class="formPanel" id="fpRicImpianto">


	
	

	
	
			
	
	<div id="p_stdMsgPRicImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRicImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPRicImp">
	<customtag:stdMessagePanel id="stdMsgPRicImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRicImp --></div>

			
	
	<div id="p_wpImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpImpianto">
	
	<customtag:widgetsPanel id="wpImpiantoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicImpianto','cbStatiImpianto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.cbStatiImpianto.label')}" labelFor="widg_cbStatiImpianto" errorFor="appDataricercaImpianti.idStatoImp" labelId="cbStatiImpiantoLbl"
	  fieldRequired="true">


<!-- widget cbStatiImpianto -->
<s:select name="appDataricercaImpianti.idStatoImp" id="widg_cbStatiImpianto"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoImpianto"
	  disabled="isWidgetDisabled('cpRicImpianto','cbStatiImpianto')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfCodImp.label')}" labelFor="widg_tfCodImp" errorFor="appDataricercaImpianti.codiceImpianto" labelId="tfCodImpLbl"
	  >


<!-- widget tfCodImp -->
<s:textfield 
	
	
	name="appDataricercaImpianti.codiceImpianto" id="widg_tfCodImp"
maxlength="11"	disabled="isWidgetDisabled('cpRicImpianto','tfCodImp')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDataricercaImpianti.idProvincia" labelId="cbProvinciaLbl"
	  fieldRequired="true">


<!-- widget cbProvincia -->
	<csiuicore:ajaxify id="p_wpImpianto" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/ricerca_impianti/cpRicImpianto!handleCbProvincia_VALUE_CHANGED.do"
		pageId="cpRicImpianto"
		formName="cpRicImpianto"
		javascriptDetection="false"
		nameSpace="/base/ricerca_impianti">

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpRicImpianto!handleCbProvincia_VALUE_CHANGED" namespace="/base/ricerca_impianti"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaImpianti.idProvincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonte"
	  disabled="isWidgetDisabled('cpRicImpianto','cbProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDataricercaImpianti.idComune" labelId="cbComuneLbl"
	  >


<!-- widget cbComune -->
<s:select name="appDataricercaImpianti.idComune" id="widg_cbComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpRicImpianto','cbComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfDescComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfDescComune.label')}" labelFor="widg_tfDescComune" errorFor="appDataricercaImpianti.descComune" labelId="tfDescComuneLbl"
	  >


<!-- widget tfDescComune -->
<s:textfield 
	
	
	name="appDataricercaImpianti.descComune" id="widg_tfDescComune"
maxlength="50"	disabled="isWidgetDisabled('cpRicImpianto','tfDescComune')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfIndirizzo.label')}" labelFor="widg_tfIndirizzo" errorFor="appDataricercaImpianti.indirizzo" labelId="tfIndirizzoLbl"
	  >


<!-- widget tfIndirizzo -->
<s:textfield 
	
	
	name="appDataricercaImpianti.indirizzo" id="widg_tfIndirizzo"
maxlength="50"	disabled="isWidgetDisabled('cpRicImpianto','tfIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfCivico.label')}" labelFor="widg_tfCivico" errorFor="appDataricercaImpianti.civico" labelId="tfCivicoLbl"
	  >


<!-- widget tfCivico -->
<s:textfield 
	
	
	name="appDataricercaImpianti.civico" id="widg_tfCivico"
maxlength="10"	disabled="isWidgetDisabled('cpRicImpianto','tfCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfCfResponsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfCfResponsabile.label')}" labelFor="widg_tfCfResponsabile" errorFor="appDataricercaImpianti.cfResponsabile" labelId="tfCfResponsabileLbl"
	  >


<!-- widget tfCfResponsabile -->
<s:textfield 
	
	
	name="appDataricercaImpianti.cfResponsabile" id="widg_tfCfResponsabile"
maxlength="16"	disabled="isWidgetDisabled('cpRicImpianto','tfCfResponsabile')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfCfProprietario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfCfProprietario.label')}" labelFor="widg_tfCfProprietario" errorFor="appDataricercaImpianti.cfProprietario" labelId="tfCfProprietarioLbl"
	  >


<!-- widget tfCfProprietario -->
<s:textfield 
	
	
	name="appDataricercaImpianti.cfProprietario" id="widg_tfCfProprietario"
maxlength="16"	disabled="isWidgetDisabled('cpRicImpianto','tfCfProprietario')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfCf3Responsabile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfCf3Responsabile.label')}" labelFor="widg_tfCf3Responsabile" errorFor="appDataricercaImpianti.cf3Responsabile" labelId="tfCf3ResponsabileLbl"
	  >


<!-- widget tfCf3Responsabile -->
<s:textfield 
	
	
	name="appDataricercaImpianti.cf3Responsabile" id="widg_tfCf3Responsabile"
maxlength="16"	disabled="isWidgetDisabled('cpRicImpianto','tfCf3Responsabile')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfMatricola.label')}" labelFor="widg_tfMatricola" errorFor="appDataricercaImpianti.matricolaApparecchiatura" labelId="tfMatricolaLbl"
	  >


<!-- widget tfMatricola -->
<s:textfield 
	
	
	name="appDataricercaImpianti.matricolaApparecchiatura" id="widg_tfMatricola"
maxlength="20"	disabled="isWidgetDisabled('cpRicImpianto','tfMatricola')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfPod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfPod.label')}" labelFor="widg_tfPod" errorFor="appDataricercaImpianti.pod" labelId="tfPodLbl"
	  >


<!-- widget tfPod -->
<s:textfield 
	
	
	name="appDataricercaImpianti.pod" id="widg_tfPod"
maxlength="20"	disabled="isWidgetDisabled('cpRicImpianto','tfPod')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfPdr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfPdr.label')}" labelFor="widg_tfPdr" errorFor="appDataricercaImpianti.pdr" labelId="tfPdrLbl"
	  >


<!-- widget tfPdr -->
<s:textfield 
	
	
	name="appDataricercaImpianti.pdr" id="widg_tfPdr"
maxlength="50"	disabled="isWidgetDisabled('cpRicImpianto','tfPdr')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpianto --></div>

			
	
	<div id="p_cpNavRicCompImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavRicCompImpianto -->
	
	
<div class="commandPanel functional" id="cpNavRicCompImpianto">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicImpianto','btRicComp')" >

	



<!-- widget btRicComp -->
<s:submit name="widg_btRicComp" id="widg_btRicComp" method="handleBtRicComp_CLICKED"
	key="cpRicImpianto.btRicComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpianto','btRicComp')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicCompImpianto --></div>

			
	
	<div id="p_wpImpresa" class="widgetsPanelBlock"><!-- startFragment:p_wpImpresa -->
	
	
<h4 class="wpLabel">impresa </h4>
<div class="widgetsPanel" id="wpImpresa">
	
	<customtag:widgetsPanel id="wpImpresaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicImpianto','cbSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.cbSiglaRea.label')}" labelFor="widg_cbSiglaRea" errorFor="appDataricercaImpianti.idSiglaRea" labelId="cbSiglaReaLbl"
	  >


<!-- widget cbSiglaRea -->
<s:select name="appDataricercaImpianti.idSiglaRea" id="widg_cbSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpRicImpianto','cbSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfNumeroRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfNumeroRea.label')}" labelFor="widg_tfNumeroRea" errorFor="appDataricercaImpianti.numeroRea" labelId="tfNumeroReaLbl"
	  >


<!-- widget tfNumeroRea -->
<s:textfield 
	
	
	name="appDataricercaImpianti.numeroRea" id="widg_tfNumeroRea"
maxlength="11"	disabled="isWidgetDisabled('cpRicImpianto','tfNumeroRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicImpianto','tfCfImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicImpianto.tfCfImpresa.label')}" labelFor="widg_tfCfImpresa" errorFor="appDataricercaImpianti.cfImpresa" labelId="tfCfImpresaLbl"
	  >


<!-- widget tfCfImpresa -->
<s:textfield 
	
	
	name="appDataricercaImpianti.cfImpresa" id="widg_tfCfImpresa"
maxlength="16"	disabled="isWidgetDisabled('cpRicImpianto','tfCfImpresa')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpresa --></div>

			
	
	<div id="p_cpFunRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunRicImpianto -->
	
	
<div class="commandPanel functional" id="cpFunRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicImpianto','btRicIns')" >

	



<!-- widget btRicIns -->
<s:submit name="widg_btRicIns" id="widg_btRicIns" method="handleBtRicIns_CLICKED"
	key="cpRicImpianto.btRicIns.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpianto','btRicIns')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicImpianto','btnAnnullaRicImpianto')" >

	



<!-- widget btnAnnullaRicImpianto -->
<s:submit name="widg_btnAnnullaRicImpianto" id="widg_btnAnnullaRicImpianto" method="handleBtnAnnullaRicImpianto_CLICKED"
	key="cpRicImpianto.btnAnnullaRicImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpianto','btnAnnullaRicImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicImpianto','btInserisci')" >

	



<!-- widget btInserisci -->
<s:submit name="widg_btInserisci" id="widg_btInserisci" method="handleBtInserisci_CLICKED"
	key="cpRicImpianto.btInserisci.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpianto','btInserisci')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRicImpianto','btInserisciResp')" >

	



<!-- widget btInserisciResp -->
<s:submit name="widg_btInserisciResp" id="widg_btInserisciResp" method="handleBtInserisciResp_CLICKED"
	key="cpRicImpianto.btInserisciResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpianto','btInserisciResp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRicImpianto --></div>

			
	
	<div id="p_cpNavRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavRicImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicImpianto','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpRicImpianto.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicImpianto','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRicImpianto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRicImpianto --></div>

	

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
