<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_terzo_responsabile/CpGest3RespAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_terzo_responsabile -->
<!-- pageId:cpGest3Resp -->

<s:form id="cpGest3Resp" action="cpGest3Resp" namespace="/base/gestisci_terzo_responsabile" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGest3Resp_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGest3Resp','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGest3Responsabile" class="formPanelBlock"><!-- startFragment:p_fpGest3Responsabile -->
		
	


	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpGest3Resp.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdMsgPGest3Resp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGest3Resp -->
	
	
<div class="stdMessagePanel" id="stdMsgPGest3Resp">
	<customtag:stdMessagePanel id="stdMsgPGest3Resp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGest3Resp --></div>

			
	
	<div id="p_wpImpResp" class="widgetsPanelBlock"><!-- startFragment:p_wpImpResp -->
	
	
<h4 class="wpLabel">dati terzo responsabile </h4>
<div class="widgetsPanel" id="wpImpResp">
	
	<customtag:widgetsPanel id="wpImpRespTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGest3Resp','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDataterzoResponsabile.respImpIdSiglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:select name="appDataterzoResponsabile.respImpIdSiglaRea" id="widg_cbImpSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGest3Resp','cbImpSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDataterzoResponsabile.respImpNumeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.respImpNumeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGest3Resp','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','tfImpCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.tfImpCf.label')}" labelFor="widg_tfImpCf" errorFor="appDataterzoResponsabile.respImpCf" labelId="tfImpCfLbl"
	position="first"  >


<!-- widget tfImpCf -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.respImpCf" id="widg_tfImpCf"
maxlength="16"	disabled="isWidgetDisabled('cpGest3Resp','tfImpCf')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpImpResp_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpResp_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','btnImpCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnImpCercaCF -->
<s:submit name="widg_btnImpCercaCF" id="widg_btnImpCercaCF" method="handleBtnImpCercaCF_CLICKED"
	key="cpGest3Resp.btnImpCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btnImpCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','btnImpNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpNuovaRicercaCF -->
<s:submit name="widg_btnImpNuovaRicercaCF" id="widg_btnImpNuovaRicercaCF" method="handleBtnImpNuovaRicercaCF_CLICKED"
	key="cpGest3Resp.btnImpNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btnImpNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','tfImpImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.tfImpImpresa.label')}" labelFor="widg_tfImpImpresa" errorFor="appDataterzoResponsabile.respImpImpresa" labelId="tfImpImpresaLbl"
	position="first" colSpan="3" >


<!-- widget tfImpImpresa -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.respImpImpresa" id="widg_tfImpImpresa"
maxlength="100"	disabled="isWidgetDisabled('cpGest3Resp','tfImpImpresa')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpResp --></div>

			
	
	<div id="p_wpLocalizzazione" class="widgetsPanelBlock"><!-- startFragment:p_wpLocalizzazione -->
	
	
<h4 class="wpLabel">ricerca impianto </h4>
<div class="widgetsPanel" id="wpLocalizzazione">
	
	<customtag:widgetsPanel id="wpLocalizzazioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGest3Resp','cbImpLocProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.cbImpLocProvincia.label')}" labelFor="widg_cbImpLocProvincia" errorFor="appDataterzoResponsabile.impLocIdProvincia" labelId="cbImpLocProvinciaLbl"
	position="first"  >


<!-- widget cbImpLocProvincia -->
	<csiuicore:ajaxify id="p_wpLocalizzazione" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_terzo_responsabile/cpGest3Resp!handleCbImpLocProvincia_VALUE_CHANGED.do"
		pageId="cpGest3Resp"
		formName="cpGest3Resp"
		javascriptDetection="false"
		nameSpace="/base/gestisci_terzo_responsabile">

<s:url id="widg_cbImpLocProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGest3Resp!handleCbImpLocProvincia_VALUE_CHANGED" namespace="/base/gestisci_terzo_responsabile"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataterzoResponsabile.impLocIdProvincia" id="widg_cbImpLocProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonte"
	  disabled="isWidgetDisabled('cpGest3Resp','cbImpLocProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbImpLocProvincia','conferma','%{widg_cbImpLocProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbImpLocProvincia','conferma','%{widg_cbImpLocProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','cbImpLocComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.cbImpLocComune.label')}" labelFor="widg_cbImpLocComune" errorFor="appDataterzoResponsabile.impLocIdComune" labelId="cbImpLocComuneLbl"
	position="last"  >


<!-- widget cbImpLocComune -->
<s:select name="appDataterzoResponsabile.impLocIdComune" id="widg_cbImpLocComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpGest3Resp','cbImpLocComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','tfImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.tfImpLocIndirizzo.label')}" labelFor="widg_tfImpLocIndirizzo" errorFor="appDataterzoResponsabile.impLocIndirizzo" labelId="tfImpLocIndirizzoLbl"
	position="first"  >


<!-- widget tfImpLocIndirizzo -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.impLocIndirizzo" id="widg_tfImpLocIndirizzo"
maxlength="200"	disabled="isWidgetDisabled('cpGest3Resp','tfImpLocIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','btnImpLocCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocCercaIndirizzo -->
<s:submit name="widg_btnImpLocCercaIndirizzo" id="widg_btnImpLocCercaIndirizzo" method="handleBtnImpLocCercaIndirizzo_CLICKED"
	key="cpGest3Resp.btnImpLocCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btnImpLocCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','cbImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.cbImpLocIndirizzo.label')}" labelFor="widg_cbImpLocIndirizzo" errorFor="appDataterzoResponsabile.impLocIdIndirizzo" labelId="cbImpLocIndirizzoLbl"
	position="first"  >


<!-- widget cbImpLocIndirizzo -->
<s:select name="appDataterzoResponsabile.impLocIdIndirizzo" id="widg_cbImpLocIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizzi3Resp"
	  disabled="isWidgetDisabled('cpGest3Resp','cbImpLocIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','btnImpLocNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocNuovaRicercaIndirizzo -->
<s:submit name="widg_btnImpLocNuovaRicercaIndirizzo" id="widg_btnImpLocNuovaRicercaIndirizzo" method="handleBtnImpLocNuovaRicercaIndirizzo_CLICKED"
	key="cpGest3Resp.btnImpLocNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btnImpLocNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','tfImpLocNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.tfImpLocNoStrad.label')}" labelFor="widg_tfImpLocNoStrad" errorFor="appDataterzoResponsabile.impLocIndirizzoNoStrad" labelId="tfImpLocNoStradLbl"
	position="first"  >


<!-- widget tfImpLocNoStrad -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.impLocIndirizzoNoStrad" id="widg_tfImpLocNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpGest3Resp','tfImpLocNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpLocalizzazione_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','tfImpLocCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.tfImpLocCivico.label')}" labelFor="widg_tfImpLocCivico" errorFor="appDataterzoResponsabile.impLocCivico" labelId="tfImpLocCivicoLbl"
	position="first"  >


<!-- widget tfImpLocCivico -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.impLocCivico" id="widg_tfImpLocCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGest3Resp','tfImpLocCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpLocalizzazione_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','tfImpCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.tfImpCodImp.label')}" labelFor="widg_tfImpCodImp" errorFor="appDataterzoResponsabile.impCodImpianto" labelId="tfImpCodImpLbl"
	position="first"  >


<!-- widget tfImpCodImp -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.impCodImpianto" id="widg_tfImpCodImp"
maxlength="10"	disabled="isWidgetDisabled('cpGest3Resp','tfImpCodImp')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpLocalizzazione_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','btnVerificaImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnVerificaImpianto -->
<s:submit name="widg_btnVerificaImpianto" id="widg_btnVerificaImpianto" method="handleBtnVerificaImpianto_CLICKED"
	key="cpGest3Resp.btnVerificaImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btnVerificaImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','btnNewRicImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnNewRicImpianto -->
<s:submit name="widg_btnNewRicImpianto" id="widg_btnNewRicImpianto" method="handleBtnNewRicImpianto_CLICKED"
	key="cpGest3Resp.btnNewRicImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btnNewRicImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLocalizzazione --></div>

			
	
	
	<div id="p_mpResponsabiliImp" class="panelBlock"><!-- startFragment:p_mpResponsabiliImp -->
		

		
<s:if test="#session.cpGest3Resp_mpResponsabiliImp_selectedMultiPanel == 'cpGest3Resp_mpResponsabiliImp_fpRespImp2'">
	<s:include value="/jsp/multipanels/cpGest3Resp_mpResponsabiliImp_fpRespImp2.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpResponsabiliImp --></div>

			
	
	<div id="p_wpDatiContratto" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiContratto -->
	
	
<h4 class="wpLabel">dati contratto </h4>
<div class="widgetsPanel" id="wpDatiContratto">
	
	<customtag:widgetsPanel id="wpDatiContrattoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGest3Resp','clDataInizio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.clDataInizio.label')}" labelFor="widg_clDataInizio" errorFor="appDataterzoResponsabile.dataInizioContratto" labelId="clDataInizioLbl"
	position="first"  >


<!-- widget clDataInizio -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.dataInizioContratto" id="widg_clDataInizio"
	disabled="isWidgetDisabled('cpGest3Resp','clDataInizio')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpDatiContratto_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiContratto_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','clDataFine')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.clDataFine.label')}" labelFor="widg_clDataFine" errorFor="appDataterzoResponsabile.dataFineContratto" labelId="clDataFineLbl"
	position="first"  >


<!-- widget clDataFine -->
<s:textfield 
	
	
	name="appDataterzoResponsabile.dataFineContratto" id="widg_clDataFine"
	disabled="isWidgetDisabled('cpGest3Resp','clDataFine')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpDatiContratto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiContratto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','cbTacitoRinnovo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.cbTacitoRinnovo.label')}" labelFor="widg_cbTacitoRinnovo" errorFor="appDataterzoResponsabile.flgTacitoRinnovo" labelId="cbTacitoRinnovoLbl"
	position="first"  >


<!-- widget cbTacitoRinnovo -->
<s:checkbox 
	
	
	name="appDataterzoResponsabile.flgTacitoRinnovo" id="widg_cbTacitoRinnovo"
	disabled="isWidgetDisabled('cpGest3Resp','cbTacitoRinnovo')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGest3Resp','cbTacitoRinnovo')" >
	<s:hidden name="__checkbox_appDataterzoResponsabile.flgTacitoRinnovo" id="__checkbox_widg_cbTacitoRinnovo" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpDatiContratto_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiContratto_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGest3Resp.taNote.label')}" labelFor="widg_taNote" errorFor="appDataterzoResponsabile.note" labelId="taNoteLbl"
	position="first"  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDataterzoResponsabile.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpGest3Resp','taNote')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGest3Resp','wpDatiContratto_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpDatiContratto_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiContratto --></div>

			
	
	<div id="p_cpFunGest3Resp" class="commandPanelBlock"><!-- startFragment:p_cpFunGest3Resp -->
	
	
<div class="commandPanel functional" id="cpFunGest3Resp">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGest3Resp','btnConfResp')" >

	



<!-- widget btnConfResp -->
<s:submit name="widg_btnConfResp" id="widg_btnConfResp" method="handleBtnConfResp_CLICKED"
	key="cpGest3Resp.btnConfResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btnConfResp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest3Resp --></div>

			
	
	<div id="p_cpNavGest3Resp" class="commandPanelBlock"><!-- startFragment:p_cpNavGest3Resp -->
	
	
<div class="commandPanel navigation" id="cpNavGest3Resp">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGest3Resp','btn3RespIndietro')" >

	



<!-- widget btn3RespIndietro -->
<s:submit name="widg_btn3RespIndietro" id="widg_btn3RespIndietro" method="handleBtn3RespIndietro_CLICKED"
	key="cpGest3Resp.btn3RespIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGest3Resp','btn3RespIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGest3Resp --></div>

	

		
	

	<!-- endFragment:p_fpGest3Responsabile --></div>

	

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
