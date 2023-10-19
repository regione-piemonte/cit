<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_distributori -->
<!-- pageId:cpInserisciDistributore -->

<s:form id="cpInserisciDistributore" action="cpInserisciDistributore" namespace="/base/gestisci_distributori" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpInserisciDistributore_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpInserisciDistributore','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestDistributoriTitolo" class="formPanelBlock"><!-- startFragment:p_fpGestDistributoriTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpInserisciDistributore.fpGestDistributoriTitolo.label" /></h4>
<div class="formPanel" id="fpGestDistributoriTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestDistributoriTitolo --></div>

			
	
	<div id="p_fpGestDistributori" class="formPanelBlock"><!-- startFragment:p_fpGestDistributori -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPGestDistr" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestDistr -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestDistr">
	<customtag:stdMessagePanel id="stdMsgPGestDistr" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestDistr --></div>

			
	
	<div id="p_wpDatiClienteForn" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiClienteForn -->
	
	
<h4 class="wpLabel">dati cliente fornitura </h4>
<div class="widgetsPanel" id="wpDatiClienteForn">
	
	<customtag:widgetsPanel id="wpDatiClienteFornTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciDistributore','rbDistribIsImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.rbDistribIsImpresa.label')}" labelFor="widg_rbDistribIsImpresa" errorFor="appDatadistributoreManuale.flgImpresaForn" labelId="rbDistribIsImpresaLbl"
	position="first"  >


<!-- widget rbDistribIsImpresa -->

	
<div id="appDatadistributoreManuale.flgImpresaForn" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDistribIsImpresaSI" name="appDatadistributoreManuale.flgImpresaForn"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpInserisciDistributore','rbDistribIsImpresa')"
	cssClass="radio"
	
	/> <label  for="widg_rbDistribIsImpresaSItrue"><s:text name="cpInserisciDistributore.rbDistribIsImpresa.rbDistribIsImpresaSI.label" /></label>








<s:radio
	
	
	id="widg_rbDistribIsImpresaNO" name="appDatadistributoreManuale.flgImpresaForn"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpInserisciDistributore','rbDistribIsImpresa')"
	cssClass="radio"
	
	/> <label  for="widg_rbDistribIsImpresaNOfalse"><s:text name="cpInserisciDistributore.rbDistribIsImpresa.rbDistribIsImpresaNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteForn_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteForn_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfDistribCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfDistribCognome.label')}" labelFor="widg_tfDistribCognome" errorFor="appDatadistributoreManuale.cognomeForn" labelId="tfDistribCognomeLbl"
	position="first"  >


<!-- widget tfDistribCognome -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.cognomeForn" id="widg_tfDistribCognome"
maxlength="500"	disabled="isWidgetDisabled('cpInserisciDistributore','tfDistribCognome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteForn_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteForn_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfDistribNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfDistribNome.label')}" labelFor="widg_tfDistribNome" errorFor="appDatadistributoreManuale.nomeForn" labelId="tfDistribNomeLbl"
	position="first"  >


<!-- widget tfDistribNome -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.nomeForn" id="widg_tfDistribNome"
maxlength="100"	disabled="isWidgetDisabled('cpInserisciDistributore','tfDistribNome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteForn_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteForn_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfDistribCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfDistribCf.label')}" labelFor="widg_tfDistribCf" errorFor="appDatadistributoreManuale.cfPivaForn" labelId="tfDistribCfLbl"
	position="first"  >


<!-- widget tfDistribCf -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.cfPivaForn" id="widg_tfDistribCf"
maxlength="16"	disabled="isWidgetDisabled('cpInserisciDistributore','tfDistribCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiClienteForn_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiClienteForn_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiClienteForn --></div>

			
	
	<div id="p_wpLocazioneForn" class="widgetsPanelBlock"><!-- startFragment:p_wpLocazioneForn -->
	
	
<h4 class="wpLabel">localizzazione fornitura </h4>
<div class="widgetsPanel" id="wpLocazioneForn">
	
	<customtag:widgetsPanel id="wpLocazioneFornTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbFornProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbFornProvincia.label')}" labelFor="widg_cbFornProvincia" errorFor="appDatadistributoreManuale.idProvinciaForn" labelId="cbFornProvinciaLbl"
	position="first"  >


<!-- widget cbFornProvincia -->
	<csiuicore:ajaxify id="p_wpLocazioneForn" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_distributori/cpInserisciDistributore!handleCbFornProvincia_VALUE_CHANGED.do"
		pageId="cpInserisciDistributore"
		formName="cpInserisciDistributore"
		javascriptDetection="false"
		nameSpace="/base/gestisci_distributori">

<s:url id="widg_cbFornProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpInserisciDistributore!handleCbFornProvincia_VALUE_CHANGED" namespace="/base/gestisci_distributori"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatadistributoreManuale.idProvinciaForn" id="widg_cbFornProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvince"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbFornProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbFornProvincia','conferma','%{widg_cbFornProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbFornProvincia','conferma','%{widg_cbFornProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneForn_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneForn_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbFornComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbFornComune.label')}" labelFor="widg_cbFornComune" errorFor="appDatadistributoreManuale.idComuneForn" labelId="cbFornComuneLbl"
	position="first"  >


<!-- widget cbFornComune -->
<s:select name="appDatadistributoreManuale.idComuneForn" id="widg_cbFornComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbFornComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneForn_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneForn_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIndirizzoForn')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIndirizzoForn.label')}" labelFor="widg_tfIndirizzoForn" errorFor="appDatadistributoreManuale.indirizzoForn" labelId="tfIndirizzoFornLbl"
	position="first"  >


<!-- widget tfIndirizzoForn -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoForn" id="widg_tfIndirizzoForn"
maxlength="200"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIndirizzoForn')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','btnCercaIndirizzoForn')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnCercaIndirizzoForn -->
<s:submit name="widg_btnCercaIndirizzoForn" id="widg_btnCercaIndirizzoForn" method="handleBtnCercaIndirizzoForn_CLICKED"
	key="cpInserisciDistributore.btnCercaIndirizzoForn.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciDistributore','btnCercaIndirizzoForn')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbFornIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbFornIndirizzo.label')}" labelFor="widg_cbFornIndirizzo" errorFor="appDatadistributoreManuale.idIndirizzoForn" labelId="cbFornIndirizzoLbl"
	position="first"  >


<!-- widget cbFornIndirizzo -->
<s:select name="appDatadistributoreManuale.idIndirizzoForn" id="widg_cbFornIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziFornitura"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbFornIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','btnNuovaRicercaIndForn')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnNuovaRicercaIndForn -->
<s:submit name="widg_btnNuovaRicercaIndForn" id="widg_btnNuovaRicercaIndForn" method="handleBtnNuovaRicercaIndForn_CLICKED"
	key="cpInserisciDistributore.btnNuovaRicercaIndForn.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciDistributore','btnNuovaRicercaIndForn')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIFornNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIFornNoStrad.label')}" labelFor="widg_tfIFornNoStrad" errorFor="appDatadistributoreManuale.indirizzoNoStradForn" labelId="tfIFornNoStradLbl"
	position="first"  >


<!-- widget tfIFornNoStrad -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoNoStradForn" id="widg_tfIFornNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIFornNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneForn_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneForn_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIFornCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIFornCivico.label')}" labelFor="widg_tfIFornCivico" errorFor="appDatadistributoreManuale.indirizzoCivicoForn" labelId="tfIFornCivicoLbl"
	position="first"  >


<!-- widget tfIFornCivico -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoCivicoForn" id="widg_tfIFornCivico"
maxlength="10"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIFornCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneForn_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneForn_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfIFornCAP')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfIFornCAP.label')}" labelFor="widg_tfIFornCAP" errorFor="appDatadistributoreManuale.indirizzoCapForn" labelId="tfIFornCAPLbl"
	position="first"  >


<!-- widget tfIFornCAP -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.indirizzoCapForn" id="widg_tfIFornCAP"
maxlength="5"	disabled="isWidgetDisabled('cpInserisciDistributore','tfIFornCAP')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpLocazioneForn_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocazioneForn_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLocazioneForn --></div>

			
	
	<div id="p_wpFornitura" class="widgetsPanelBlock"><!-- startFragment:p_wpFornitura -->
	
	
<h4 class="wpLabel">fornitura </h4>
<div class="widgetsPanel" id="wpFornitura">
	
	<customtag:widgetsPanel id="wpFornituraTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfAnnoRif')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfAnnoRif.label')}" labelFor="widg_tfAnnoRif" errorFor="appDatadistributoreManuale.annoRiferimento" labelId="tfAnnoRifLbl"
	position="first"  >


<!-- widget tfAnnoRif -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.annoRiferimento" id="widg_tfAnnoRif"
maxlength="4"	disabled="isWidgetDisabled('cpInserisciDistributore','tfAnnoRif')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfNumMesi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfNumMesi.label')}" labelFor="widg_tfNumMesi" errorFor="appDatadistributoreManuale.numMesiFatt" labelId="tfNumMesiLbl"
	position="first"  >


<!-- widget tfNumMesi -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.numMesiFatt" id="widg_tfNumMesi"
maxlength="2"	disabled="isWidgetDisabled('cpInserisciDistributore','tfNumMesi')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfPodPdr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfPodPdr.label')}" labelFor="widg_tfPodPdr" errorFor="appDatadistributoreManuale.codicePdrPod" labelId="tfPodPdrLbl"
	position="first"  >


<!-- widget tfPodPdr -->
<s:textfield 
	
	
	name="appDatadistributoreManuale.codicePdrPod" id="widg_tfPodPdr"
maxlength="20"	disabled="isWidgetDisabled('cpInserisciDistributore','tfPodPdr')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbTipoContratto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbTipoContratto.label')}" labelFor="widg_cbTipoContratto" errorFor="appDatadistributoreManuale.idTipoContratto" labelId="cbTipoContrattoLbl"
	position="first"  >


<!-- widget cbTipoContratto -->
<s:select name="appDatadistributoreManuale.idTipoContratto" id="widg_cbTipoContratto"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoContrattoDistrib"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbTipoContratto')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbTipoCategoria')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbTipoCategoria.label')}" labelFor="widg_cbTipoCategoria" errorFor="appDatadistributoreManuale.idCategoria" labelId="cbTipoCategoriaLbl"
	position="first"  >


<!-- widget cbTipoCategoria -->
<s:select name="appDatadistributoreManuale.idCategoria" id="widg_cbTipoCategoria"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoCategoria"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbTipoCategoria')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbTipoCombustibile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbTipoCombustibile.label')}" labelFor="widg_cbTipoCombustibile" errorFor="appDatadistributoreManuale.idCombustibile" labelId="cbTipoCombustibileLbl"
	position="first"  >


<!-- widget cbTipoCombustibile -->
<s:select name="appDatadistributoreManuale.idCombustibile" id="widg_cbTipoCombustibile"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoCombustibile"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbTipoCombustibile')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfConsumoAnno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfConsumoAnno.label')}" labelFor="widg_tfConsumoAnno" errorFor="appDatadistributoreManuale.consumoAnnuo" labelId="tfConsumoAnnoLbl"
	position="first"  >


<!-- widget tfConsumoAnno -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.consumoAnnuo" id="widg_tfConsumoAnno"
maxlength="12"	disabled="isWidgetDisabled('cpInserisciDistributore','tfConsumoAnno')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbTipoMisura')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbTipoMisura.label')}" labelFor="widg_cbTipoMisura" errorFor="appDatadistributoreManuale.idUnitaMisuraConsumo" labelId="cbTipoMisuraLbl"
	position="first"  >


<!-- widget cbTipoMisura -->
<s:select name="appDatadistributoreManuale.idUnitaMisuraConsumo" id="widg_cbTipoMisura"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUnitaMisura"
	  disabled="isWidgetDisabled('cpInserisciDistributore','cbTipoMisura')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','tfVolumeRiscaldato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.tfVolumeRiscaldato.label')}" labelFor="widg_tfVolumeRiscaldato" errorFor="appDatadistributoreManuale.volumetriaRiscaldata" labelId="tfVolumeRiscaldatoLbl"
	position="first"  >


<!-- widget tfVolumeRiscaldato -->
<s:textfield 
	
title=""	
	name="appDatadistributoreManuale.volumetriaRiscaldata" id="widg_tfVolumeRiscaldato"
maxlength="12"	disabled="isWidgetDisabled('cpInserisciDistributore','tfVolumeRiscaldato')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpFornitura_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpFornitura_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpFornitura --></div>

			
	
	<div id="p_wpDatiFattUguale" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiFattUguale -->
	
	
<h4 class="wpLabel">dati fatturazione </h4>
<div class="widgetsPanel" id="wpDatiFattUguale">
	
	<customtag:widgetsPanel id="wpDatiFattUgualeTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpInserisciDistributore','cbFattUguale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpInserisciDistributore.cbFattUguale.label')}" labelFor="widg_cbFattUguale" errorFor="appDatadistributoreManuale.flgFatturazioneUguale" labelId="cbFattUgualeLbl"
	position="first"  >


<!-- widget cbFattUguale -->
<s:checkbox 
	
	
	name="appDatadistributoreManuale.flgFatturazioneUguale" id="widg_cbFattUguale"
	disabled="isWidgetDisabled('cpInserisciDistributore','cbFattUguale')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitwebn/base/gestisci_distributori/cpInserisciDistributore!handleCbFattUguale_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpInserisciDistributore','cbFattUguale')" >
	<s:hidden name="__checkbox_appDatadistributoreManuale.flgFatturazioneUguale" id="__checkbox_widg_cbFattUguale" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpInserisciDistributore','wpDatiFattUguale_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiFattUguale_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiFattUguale --></div>

			
	
	
	<div id="p_mpFatturazione" class="panelBlock"><!-- startFragment:p_mpFatturazione -->
		

		
<s:if test="#session.cpInserisciDistributore_mpFatturazione_selectedMultiPanel == 'cpInserisciDistributore_mpFatturazione_fpFatturazione'">
	<s:include value="/jsp/multipanels/cpInserisciDistributore_mpFatturazione_fpFatturazione.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpFatturazione --></div>

	

		
	

	<!-- endFragment:p_fpGestDistributori --></div>

			
	
	<div id="p_cpFunGestDistributori" class="commandPanelBlock"><!-- startFragment:p_cpFunGestDistributori -->
	
	
<div class="commandPanel functional" id="cpFunGestDistributori">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInserisciDistributore','btnDistrSalva')" >

	



<!-- widget btnDistrSalva -->
<s:submit name="widg_btnDistrSalva" id="widg_btnDistrSalva" method="handleBtnDistrSalva_CLICKED"
	key="cpInserisciDistributore.btnDistrSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciDistributore','btnDistrSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestDistributori --></div>

			
	
	<div id="p_cpNavGestDistributori" class="commandPanelBlock"><!-- startFragment:p_cpNavGestDistributori -->
	
	
<div class="commandPanel navigation" id="cpNavGestDistributori">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpInserisciDistributore','btnDistrIndietro')" >

	



<!-- widget btnDistrIndietro -->
<s:submit name="widg_btnDistrIndietro" id="widg_btnDistrIndietro" method="handleBtnDistrIndietro_CLICKED"
	key="cpInserisciDistributore.btnDistrIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpInserisciDistributore','btnDistrIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestDistributori --></div>

	

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
