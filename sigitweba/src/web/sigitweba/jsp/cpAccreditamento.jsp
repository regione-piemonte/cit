<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitweba/presentation/sigitweba/action/accreditamento_module/CpAccreditamentoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/accreditamento_module -->
<!-- pageId:cpAccreditamento -->

<s:form id="cpAccreditamento" action="cpAccreditamento" namespace="/base/accreditamento_module" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpAccreditamento_udpTestalino.jsp"></s:include>

	



	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_fpLeft" class="formPanelBlock"><!-- startFragment:p_fpLeft -->

	
	

	
	
			
	
	<div id="p_menuPanel" class="menuPanelBlock scroll"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel vertical" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpAccreditamento','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpLeft --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpAccreditamento.fpAccreditamentoG.label" /></h3>

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpAccreditamento" class="formPanelBlock"><!-- startFragment:p_fpAccreditamento -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPHome -->
	
	
<div class="stdMessagePanel" id="stdMsgPHome">
	<customtag:stdMessagePanel id="stdMsgPHome" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPHome --></div>

			
	
	<div id="p_wpAccreditamento" class="widgetsPanelBlock"><!-- startFragment:p_wpAccreditamento -->
	
	

<div class="widgetsPanel" id="wpAccreditamento">
	
	<customtag:widgetsPanel id="wpAccreditamentoTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="30,30,40">
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredDenom')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredDenom.label')}" labelFor="widg_tfAccredDenom" errorFor="appDatapersonaFisica.denominazione" labelId="tfAccredDenomLbl"
	position="first"  >


<!-- widget tfAccredDenom -->
<s:textfield 
	
	
	name="appDatapersonaFisica.denominazione" id="widg_tfAccredDenom"
	disabled="isWidgetDisabled('cpAccreditamento','tfAccredDenom')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredCF')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredCF.label')}" labelFor="widg_tfAccredCF" errorFor="appDatapersonaFisica.codiceFiscale" labelId="tfAccredCFLbl"
	position="first"  >


<!-- widget tfAccredCF -->
<s:textfield 
	
title=""	
	name="appDatapersonaFisica.codiceFiscale" id="widg_tfAccredCF"
	disabled="isWidgetDisabled('cpAccreditamento','tfAccredCF')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbIndirizzoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbIndirizzoEst.label')}" labelFor="widg_cbIndirizzoEst" errorFor="appDatapersonaFisica.flgIndirizzoEst" labelId="cbIndirizzoEstLbl"
	position="first"  >


<!-- widget cbIndirizzoEst -->
<s:checkbox 
	
	
	name="appDatapersonaFisica.flgIndirizzoEst" id="widg_cbIndirizzoEst"
	disabled="isWidgetDisabled('cpAccreditamento','cbIndirizzoEst')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitweba/base/accreditamento_module/cpAccreditamento!handleCbIndirizzoEst_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbIndirizzoEst')" >
	<s:hidden name="__checkbox_appDatapersonaFisica.flgIndirizzoEst" id="__checkbox_widg_cbIndirizzoEst" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbAccredProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbAccredProvincia.label')}" labelFor="widg_cbAccredProvincia" errorFor="appDatapersonaFisica.idProvinciaSelez" labelId="cbAccredProvinciaLbl"
	position="first"  >


<!-- widget cbAccredProvincia -->
	<csiuicore:ajaxify id="p_wpAccreditamento" 
		widgetType="combo" 
		requestUri="/sigitweba/base/accreditamento_module/cpAccreditamento!handleCbAccredProvincia_VALUE_CHANGED.do"
		pageId="cpAccreditamento"
		formName="cpAccreditamento"
		javascriptDetection="false"
		nameSpace="/base/accreditamento_module">

<s:url id="widg_cbAccredProvinciaurlComboBoxValueChange"
   action="/sigitweba/cpAccreditamento!handleCbAccredProvincia_VALUE_CHANGED" namespace="/base/accreditamento_module"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatapersonaFisica.idProvinciaSelez" id="widg_cbAccredProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpAccreditamento','cbAccredProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbAccredProvincia','conferma','%{widg_cbAccredProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbAccredProvincia','conferma','%{widg_cbAccredProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbAccredComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbAccredComune.label')}" labelFor="widg_cbAccredComune" errorFor="appDatapersonaFisica.idComuneSelez" labelId="cbAccredComuneLbl"
	position="first"  >


<!-- widget cbAccredComune -->
<s:select name="appDatapersonaFisica.idComuneSelez" id="widg_cbAccredComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpAccreditamento','cbAccredComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_5_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_5_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfIndirizzo.label')}" labelFor="widg_tfIndirizzo" errorFor="appDatapersonaFisica.indirizzo" labelId="tfIndirizzoLbl"
	position="first"  >


<!-- widget tfIndirizzo -->
<s:textfield 
	
	
	name="appDatapersonaFisica.indirizzo" id="widg_tfIndirizzo"
maxlength="100"	disabled="isWidgetDisabled('cpAccreditamento','tfIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','bCerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget bCerca -->
<s:submit name="widg_bCerca" id="widg_bCerca" method="handleBCerca_CLICKED"
	key="cpAccreditamento.bCerca.label" cssClass="buttonWidget"
title="Ricerca l'indirizzo"	disabled="isWidgetDisabled('cpAccreditamento','bCerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_6_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_6_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbElencoIndirizzi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbElencoIndirizzi.label')}" labelFor="widg_cbElencoIndirizzi" errorFor="appDatapersonaFisica.idIndirizzoSel" labelId="cbElencoIndirizziLbl"
	position="first"  >


<!-- widget cbElencoIndirizzi -->
<s:select name="appDatapersonaFisica.idIndirizzoSel" id="widg_cbElencoIndirizzi"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziPF"
	  disabled="isWidgetDisabled('cpAccreditamento','cbElencoIndirizzi')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','bNuovaRic')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget bNuovaRic -->
<s:submit name="widg_bNuovaRic" id="widg_bNuovaRic" method="handleBNuovaRic_CLICKED"
	key="cpAccreditamento.bNuovaRic.label" cssClass="buttonWidget"
title="Nuova ricerca indirizzo"	disabled="isWidgetDisabled('cpAccreditamento','bNuovaRic')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_7_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_7_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfNonTrov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfNonTrov.label')}" labelFor="widg_tfNonTrov" errorFor="appDatapersonaFisica.indirizzoNonTrovato" labelId="tfNonTrovLbl"
	position="first"  >


<!-- widget tfNonTrov -->
<s:textfield 
	
	
	name="appDatapersonaFisica.indirizzoNonTrovato" id="widg_tfNonTrov"
maxlength="100"	disabled="isWidgetDisabled('cpAccreditamento','tfNonTrov')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_8_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_8_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfCivico.label')}" labelFor="widg_tfCivico" errorFor="appDatapersonaFisica.civico" labelId="tfCivicoLbl"
	position="first"  >


<!-- widget tfCivico -->
<s:textfield 
	
	
	name="appDatapersonaFisica.civico" id="widg_tfCivico"
maxlength="10"	disabled="isWidgetDisabled('cpAccreditamento','tfCivico')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_9_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_9_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredCap.label')}" labelFor="widg_tfAccredCap" errorFor="appDatapersonaFisica.cap" labelId="tfAccredCapLbl"
	position="first"  >


<!-- widget tfAccredCap -->
<s:textfield 
	
title=""	
	name="appDatapersonaFisica.cap" id="widg_tfAccredCap"
maxlength="5"	disabled="isWidgetDisabled('cpAccreditamento','tfAccredCap')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_10_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_10_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredEstStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredEstStato.label')}" labelFor="widg_tfAccredEstStato" errorFor="appDatapersonaFisica.estStato" labelId="tfAccredEstStatoLbl"
	position="first"  >


<!-- widget tfAccredEstStato -->
<s:textfield 
	
title=""	
	name="appDatapersonaFisica.estStato" id="widg_tfAccredEstStato"
maxlength="50"	disabled="isWidgetDisabled('cpAccreditamento','tfAccredEstStato')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_11_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_11_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_11_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_11_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredEstCitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredEstCitta.label')}" labelFor="widg_tfAccredEstCitta" errorFor="appDatapersonaFisica.estCitta" labelId="tfAccredEstCittaLbl"
	position="first"  >


<!-- widget tfAccredEstCitta -->
<s:textfield 
	
title=""	
	name="appDatapersonaFisica.estCitta" id="widg_tfAccredEstCitta"
maxlength="50"	disabled="isWidgetDisabled('cpAccreditamento','tfAccredEstCitta')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_12_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_12_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredEstIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredEstIndirizzo.label')}" labelFor="widg_tfAccredEstIndirizzo" errorFor="appDatapersonaFisica.estIndirizzo" labelId="tfAccredEstIndirizzoLbl"
	position="first"  >


<!-- widget tfAccredEstIndirizzo -->
<s:textfield 
	
title=""	
	name="appDatapersonaFisica.estIndirizzo" id="widg_tfAccredEstIndirizzo"
maxlength="100"	disabled="isWidgetDisabled('cpAccreditamento','tfAccredEstIndirizzo')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_13_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_13_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredEstCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredEstCivico.label')}" labelFor="widg_tfAccredEstCivico" errorFor="appDatapersonaFisica.civico" labelId="tfAccredEstCivicoLbl"
	position="first"  >


<!-- widget tfAccredEstCivico -->
<s:textfield 
	
	
	name="appDatapersonaFisica.civico" id="widg_tfAccredEstCivico"
maxlength="10"	disabled="isWidgetDisabled('cpAccreditamento','tfAccredEstCivico')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_14_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_14_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_14_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_14_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfAccredEstCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfAccredEstCap.label')}" labelFor="widg_tfAccredEstCap" errorFor="appDatapersonaFisica.estCap" labelId="tfAccredEstCapLbl"
	position="first"  >


<!-- widget tfAccredEstCap -->
<s:textfield 
	
title=""	
	name="appDatapersonaFisica.estCap" id="widg_tfAccredEstCap"
maxlength="10"	disabled="isWidgetDisabled('cpAccreditamento','tfAccredEstCap')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_15_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_15_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_15_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_15_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','tfEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.tfEmail.label')}" labelFor="widg_tfEmail" errorFor="appDatapersonaFisica.email" labelId="tfEmailLbl"
	position="first"  >


<!-- widget tfEmail -->
<s:textfield 
	
	
	name="appDatapersonaFisica.email" id="widg_tfEmail"
maxlength="100"	disabled="isWidgetDisabled('cpAccreditamento','tfEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','bVerifica')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget bVerifica -->
<s:submit name="widg_bVerifica" id="widg_bVerifica" method="handleBVerifica_CLICKED"
	key="cpAccreditamento.bVerifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','bVerifica')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_16_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_16_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbFlgNewsletter')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbFlgNewsletter.label')}" labelFor="widg_cbFlgNewsletter" errorFor="appDatapersonaFisica.flgMailNewsletter" labelId="cbFlgNewsletterLbl"
	position="first"  >


<!-- widget cbFlgNewsletter -->
<s:checkbox 
	
	
	name="appDatapersonaFisica.flgMailNewsletter" id="widg_cbFlgNewsletter"
	disabled="isWidgetDisabled('cpAccreditamento','cbFlgNewsletter')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbFlgNewsletter')" >
	<s:hidden name="__checkbox_appDatapersonaFisica.flgMailNewsletter" id="__checkbox_widg_cbFlgNewsletter" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_17_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_17_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_17_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_17_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','cbFlgGDPR')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAccreditamento.cbFlgGDPR.label')}" labelFor="widg_cbFlgGDPR" errorFor="appDatapersonaFisica.flgGDPR" labelId="cbFlgGDPRLbl"
	position="first"  >


<!-- widget cbFlgGDPR -->
<s:checkbox 
	
	
	name="appDatapersonaFisica.flgGDPR" id="widg_cbFlgGDPR"
	disabled="isWidgetDisabled('cpAccreditamento','cbFlgGDPR')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpAccreditamento','cbFlgGDPR')" >
	<s:hidden name="__checkbox_appDatapersonaFisica.flgGDPR" id="__checkbox_widg_cbFlgGDPR" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_18_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpAccreditamento_18_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpAccreditamento','wpAccreditamento_18_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpAccreditamento_18_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAccreditamento --></div>

			
	
	<div id="p_cpAccreditamentoNAV" class="commandPanelBlock"><!-- startFragment:p_cpAccreditamentoNAV -->
	
	
<div class="commandPanel functional" id="cpAccreditamentoNAV">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAccreditamento','cbotSalva')" >

	



<!-- widget cbotSalva -->
<s:submit name="widg_cbotSalva" id="widg_cbotSalva" method="handleCbotSalva_CLICKED"
	key="cpAccreditamento.cbotSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','cbotSalva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpAccreditamentoNAV --></div>

			
	
	<div id="p_wpFormazione" class="widgetsPanelBlock"><!-- startFragment:p_wpFormazione -->
	
	
<h4 class="wpLabel">Formazione <span id="toggle_wpFormazione"></span></h4>
<div class="widgetsPanel" id="wpFormazione">
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','tbFormazione')" >

	
<div class="tableWidget">


<!-- widget tbFormazione -->
	<csiuicore:ajaxify id="p_wpFormazione" 
		widgetType="table"		
		pageId="cpAccreditamento"
		javascriptDetection="false">
<s:set name="cpAccreditamento_tbFormazione_clearStatus" value="isTableClearStatus('cpAccreditamento_tbFormazione')" />
<s:url id="cpAccreditamentoViewUrl"						   
					   action="cpAccreditamento"
					   namespace="/base/accreditamento_module"/>
<display:table name="appDatalistFormazioni"  				
			   excludedParams="*"			   export="true"
               id="widg_tbFormazione"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpAccreditamentoViewUrl}"  
               clearStatus="${cpAccreditamento_tbFormazione_clearStatus}"
               uid="row_tbFormazione"
               summary="" 
               class="dataTable">
	
		<display:column property="dataCorso" titleKey="cpAccreditamento.tbFormazione.dataCorso.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitweba.presentation.sigitweba.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataCorso" titleKey="cpAccreditamento.tbFormazione.dataCorso.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitweba.presentation.sigitweba.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataCorso" titleKey="cpAccreditamento.tbFormazione.dataCorso.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitweba.presentation.sigitweba.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="descCorso" titleKey="cpAccreditamento.tbFormazione.descCorso.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descCorso" titleKey="cpAccreditamento.tbFormazione.descCorso.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descCorso" titleKey="cpAccreditamento.tbFormazione.descCorso.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpFormazione --></div>

			
	
	<div id="p_cpFormazione" class="commandPanelBlock"><!-- startFragment:p_cpFormazione -->
	
	
<div class="commandPanel functional" id="cpFormazione">

	
	
		
		
<s:if test="isWidgetVisible('cpAccreditamento','btInsertFormazione')" >

	



<!-- widget btInsertFormazione -->
<s:submit name="widg_btInsertFormazione" id="widg_btInsertFormazione" method="handleBtInsertFormazione_CLICKED"
	key="cpAccreditamento.btInsertFormazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btInsertFormazione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFormazione --></div>

			
	
	
	<div id="p_mpFormazione" class="panelBlock"><!-- startFragment:p_mpFormazione -->
		

		
<s:if test="#session.cpAccreditamento_mpFormazione_selectedMultiPanel == 'cpAccreditamento_mpFormazione_fpNuovaFormazione'">
	<s:include value="/jsp/multipanels/cpAccreditamento_mpFormazione_fpNuovaFormazione.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpFormazione --></div>

			
	
	<div id="p_wpImprese" class="widgetsPanelBlock"><!-- startFragment:p_wpImprese -->
	
	
<h4 class="wpLabel">Imprese associate <span id="toggle_wpImprese"></span></h4>
<div class="widgetsPanel" id="wpImprese">
	

	
	
<s:if test="isWidgetVisible('cpAccreditamento','tbImprese')" >

	
<div class="tableWidget">


<!-- widget tbImprese -->
	<csiuicore:ajaxify id="p_wpImprese" 
		widgetType="table"		
		pageId="cpAccreditamento"
		javascriptDetection="false">
<s:set name="cpAccreditamento_tbImprese_clearStatus" value="isTableClearStatus('cpAccreditamento_tbImprese')" />
<s:url id="cpAccreditamentoViewUrl"						   
					   action="cpAccreditamento"
					   namespace="/base/accreditamento_module"/>
<display:table name="appDataelencoImprese"  				
			   excludedParams="*"			   export="true"
               id="widg_tbImprese"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpAccreditamentoViewUrl}"  
               clearStatus="${cpAccreditamento_tbImprese_clearStatus}"
               uid="row_tbImprese"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbImprese.idPersonaGiuridica}" name="appDataimpresaSelezionata" id="%{'tbImprese-editcell-'+ (#attr.row_tbImprese_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="denominazione" titleKey="cpAccreditamento.tbImprese.denominazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="denominazione" titleKey="cpAccreditamento.tbImprese.denominazione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="denominazione" titleKey="cpAccreditamento.tbImprese.denominazione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="codiceFiscale" titleKey="cpAccreditamento.tbImprese.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceFiscale" titleKey="cpAccreditamento.tbImprese.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceFiscale" titleKey="cpAccreditamento.tbImprese.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="codiceRea" titleKey="cpAccreditamento.tbImprese.codiceRea.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceRea" titleKey="cpAccreditamento.tbImprese.codiceRea.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceRea" titleKey="cpAccreditamento.tbImprese.codiceRea.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgDm37LetteraC" titleKey="cpAccreditamento.tbImprese.descFlgDm37LetteraC.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgDm37LetteraC" titleKey="cpAccreditamento.tbImprese.descFlgDm37LetteraC.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgDm37LetteraC" titleKey="cpAccreditamento.tbImprese.descFlgDm37LetteraC.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlg3Responsabile" titleKey="cpAccreditamento.tbImprese.descFlg3Responsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlg3Responsabile" titleKey="cpAccreditamento.tbImprese.descFlg3Responsabile.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlg3Responsabile" titleKey="cpAccreditamento.tbImprese.descFlg3Responsabile.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgCat" titleKey="cpAccreditamento.tbImprese.descFlgCat.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgCat" titleKey="cpAccreditamento.tbImprese.descFlgCat.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgCat" titleKey="cpAccreditamento.tbImprese.descFlgCat.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgDistributore" titleKey="cpAccreditamento.tbImprese.descFlgDistributore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgDistributore" titleKey="cpAccreditamento.tbImprese.descFlgDistributore.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgDistributore" titleKey="cpAccreditamento.tbImprese.descFlgDistributore.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descFlgAltraImpresa" titleKey="cpAccreditamento.tbImprese.descFlgAltraImpresa.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgAltraImpresa" titleKey="cpAccreditamento.tbImprese.descFlgAltraImpresa.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgAltraImpresa" titleKey="cpAccreditamento.tbImprese.descFlgAltraImpresa.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dataFine" titleKey="cpAccreditamento.tbImprese.dataFine.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitweba.presentation.sigitweba.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataFine" titleKey="cpAccreditamento.tbImprese.dataFine.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitweba.presentation.sigitweba.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataFine" titleKey="cpAccreditamento.tbImprese.dataFine.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitweba.presentation.sigitweba.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="descFlgDelega" titleKey="cpAccreditamento.tbImprese.descFlgDelega.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descFlgDelega" titleKey="cpAccreditamento.tbImprese.descFlgDelega.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descFlgDelega" titleKey="cpAccreditamento.tbImprese.descFlgDelega.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpImprese --></div>

			
	
	<div id="p_cpImprese" class="commandPanelBlock"><!-- startFragment:p_cpImprese -->
	
	
<div class="commandPanel functional" id="cpImprese">

	
	
		
		
<s:if test="isWidgetVisible('cpAccreditamento','btInsertImpresa')" >

	



<!-- widget btInsertImpresa -->
<s:submit name="widg_btInsertImpresa" id="widg_btInsertImpresa" method="handleBtInsertImpresa_CLICKED"
	key="cpAccreditamento.btInsertImpresa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btInsertImpresa')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpAccreditamento','btModImpresa')" >

	



<!-- widget btModImpresa -->
<s:submit name="widg_btModImpresa" id="widg_btModImpresa" method="handleBtModImpresa_CLICKED"
	key="cpAccreditamento.btModImpresa.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btModImpresa')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpAccreditamento','btCessaLegame')" >

	



<!-- widget btCessaLegame -->
<s:submit name="widg_btCessaLegame" id="widg_btCessaLegame" method="handleBtCessaLegame_CLICKED"
	key="cpAccreditamento.btCessaLegame.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAccreditamento','btCessaLegame')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpImprese --></div>

			
	
	
	<div id="p_mpImpresa" class="panelBlock"><!-- startFragment:p_mpImpresa -->
		

		
<s:if test="#session.cpAccreditamento_mpImpresa_selectedMultiPanel == 'cpAccreditamento_mpImpresa_fmNuovaImpresa'">
	<s:include value="/jsp/multipanels/cpAccreditamento_mpImpresa_fmNuovaImpresa.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpImpresa --></div>

	

		
	

	<!-- endFragment:p_fpAccreditamento --></div>

	

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
