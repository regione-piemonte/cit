<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_subentro -->
<!-- pageId:cpGestSubentro -->

<s:form id="cpGestSubentro" action="cpGestSubentro" namespace="/base/gestisci_subentro" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestSubentro_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestSubentro','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestSubentro" class="formPanelBlock"><!-- startFragment:p_fpGestSubentro -->
		
	


	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpGestSubentro.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdMsgPGestSub" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestSub -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestSub">
	<customtag:stdMessagePanel id="stdMsgPGestSub" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestSub --></div>

			
	
	<div id="p_wpImpResp" class="widgetsPanelBlock"><!-- startFragment:p_wpImpResp -->
	
	
<h4 class="wpLabel">impresa/responsabile </h4>
<div class="widgetsPanel" id="wpImpResp">
	
	<customtag:widgetsPanel id="wpImpRespTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestSubentro','cbImpSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.cbImpSiglaRea.label')}" labelFor="widg_cbImpSiglaRea" errorFor="appDatasubentro.respImpIdSiglaRea" labelId="cbImpSiglaReaLbl"
	position="first"  >


<!-- widget cbImpSiglaRea -->
<s:select name="appDatasubentro.respImpIdSiglaRea" id="widg_cbImpSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestSubentro','cbImpSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','tfImpNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.tfImpNumRea.label')}" labelFor="widg_tfImpNumRea" errorFor="appDatasubentro.respImpNumeroRea" labelId="tfImpNumReaLbl"
	position="last"  >


<!-- widget tfImpNumRea -->
<s:textfield 
	
	
	name="appDatasubentro.respImpNumeroRea" id="widg_tfImpNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestSubentro','tfImpNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','tfImpCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.tfImpCf.label')}" labelFor="widg_tfImpCf" errorFor="appDatasubentro.respImpCf" labelId="tfImpCfLbl"
	position="first"  >


<!-- widget tfImpCf -->
<s:textfield 
	
	
	name="appDatasubentro.respImpCf" id="widg_tfImpCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestSubentro','tfImpCf')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','wpImpResp_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpResp_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','btnImpCercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnImpCercaCF -->
<s:submit name="widg_btnImpCercaCF" id="widg_btnImpCercaCF" method="handleBtnImpCercaCF_CLICKED"
	key="cpGestSubentro.btnImpCercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnImpCercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','btnImpNuovaRicercaCF')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpNuovaRicercaCF -->
<s:submit name="widg_btnImpNuovaRicercaCF" id="widg_btnImpNuovaRicercaCF" method="handleBtnImpNuovaRicercaCF_CLICKED"
	key="cpGestSubentro.btnImpNuovaRicercaCF.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnImpNuovaRicercaCF')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','tfImpImpresa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.tfImpImpresa.label')}" labelFor="widg_tfImpImpresa" errorFor="appDatasubentro.respImpImpresa" labelId="tfImpImpresaLbl"
	position="first"  >


<!-- widget tfImpImpresa -->
<s:textfield 
	
	
	name="appDatasubentro.respImpImpresa" id="widg_tfImpImpresa"
maxlength="50"	disabled="isWidgetDisabled('cpGestSubentro','tfImpImpresa')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','wpImpResp_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpImpResp_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpResp --></div>

			
	
	<div id="p_wpLocalizzazione" class="widgetsPanelBlock"><!-- startFragment:p_wpLocalizzazione -->
	
	
<h4 class="wpLabel">ricerca impianto per subentro </h4>
<div class="widgetsPanel" id="wpLocalizzazione">
	
	<customtag:widgetsPanel id="wpLocalizzazioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestSubentro','cbImpLocProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.cbImpLocProvincia.label')}" labelFor="widg_cbImpLocProvincia" errorFor="appDatasubentro.impLocIdProvincia" labelId="cbImpLocProvinciaLbl"
	position="first"  >


<!-- widget cbImpLocProvincia -->
	<csiuicore:ajaxify id="p_wpLocalizzazione" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_subentro/cpGestSubentro!handleCbImpLocProvincia_VALUE_CHANGED.do"
		pageId="cpGestSubentro"
		formName="cpGestSubentro"
		javascriptDetection="false"
		nameSpace="/base/gestisci_subentro">

<s:url id="widg_cbImpLocProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGestSubentro!handleCbImpLocProvincia_VALUE_CHANGED" namespace="/base/gestisci_subentro"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasubentro.impLocIdProvincia" id="widg_cbImpLocProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonte"
	  disabled="isWidgetDisabled('cpGestSubentro','cbImpLocProvincia')"
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


	
<s:if test="isWidgetVisible('cpGestSubentro','cbImpLocComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.cbImpLocComune.label')}" labelFor="widg_cbImpLocComune" errorFor="appDatasubentro.impLocIdComune" labelId="cbImpLocComuneLbl"
	position="last"  >


<!-- widget cbImpLocComune -->
<s:select name="appDatasubentro.impLocIdComune" id="widg_cbImpLocComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpGestSubentro','cbImpLocComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','tfImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.tfImpLocIndirizzo.label')}" labelFor="widg_tfImpLocIndirizzo" errorFor="appDatasubentro.impLocIndirizzo" labelId="tfImpLocIndirizzoLbl"
	position="first"  >


<!-- widget tfImpLocIndirizzo -->
<s:textfield 
	
	
	name="appDatasubentro.impLocIndirizzo" id="widg_tfImpLocIndirizzo"
maxlength="200"	disabled="isWidgetDisabled('cpGestSubentro','tfImpLocIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','btnImpLocCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocCercaIndirizzo -->
<s:submit name="widg_btnImpLocCercaIndirizzo" id="widg_btnImpLocCercaIndirizzo" method="handleBtnImpLocCercaIndirizzo_CLICKED"
	key="cpGestSubentro.btnImpLocCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnImpLocCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','cbImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.cbImpLocIndirizzo.label')}" labelFor="widg_cbImpLocIndirizzo" errorFor="appDatasubentro.impLocIdIndirizzo" labelId="cbImpLocIndirizzoLbl"
	position="first"  >


<!-- widget cbImpLocIndirizzo -->
<s:select name="appDatasubentro.impLocIdIndirizzo" id="widg_cbImpLocIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziSub"
	  disabled="isWidgetDisabled('cpGestSubentro','cbImpLocIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','btnImpLocNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocNuovaRicercaIndirizzo -->
<s:submit name="widg_btnImpLocNuovaRicercaIndirizzo" id="widg_btnImpLocNuovaRicercaIndirizzo" method="handleBtnImpLocNuovaRicercaIndirizzo_CLICKED"
	key="cpGestSubentro.btnImpLocNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnImpLocNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','tfImpLocNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.tfImpLocNoStrad.label')}" labelFor="widg_tfImpLocNoStrad" errorFor="appDatasubentro.impLocIndirizzoNoStrad" labelId="tfImpLocNoStradLbl"
	position="first"  >


<!-- widget tfImpLocNoStrad -->
<s:textfield 
	
	
	name="appDatasubentro.impLocIndirizzoNoStrad" id="widg_tfImpLocNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpGestSubentro','tfImpLocNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','wpLocalizzazione_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','tfImpLocCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.tfImpLocCivico.label')}" labelFor="widg_tfImpLocCivico" errorFor="appDatasubentro.impLocCivico" labelId="tfImpLocCivicoLbl"
	position="first"  >


<!-- widget tfImpLocCivico -->
<s:textfield 
	
	
	name="appDatasubentro.impLocCivico" id="widg_tfImpLocCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestSubentro','tfImpLocCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','wpLocalizzazione_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','tfImpCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestSubentro.tfImpCodImp.label')}" labelFor="widg_tfImpCodImp" errorFor="appDatasubentro.impCodImpianto" labelId="tfImpCodImpLbl"
	position="first"  >


<!-- widget tfImpCodImp -->
<s:textfield 
	
	
	name="appDatasubentro.impCodImpianto" id="widg_tfImpCodImp"
maxlength="10"	disabled="isWidgetDisabled('cpGestSubentro','tfImpCodImp')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','btnVerificaImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnVerificaImpianto -->
<s:submit name="widg_btnVerificaImpianto" id="widg_btnVerificaImpianto" method="handleBtnVerificaImpianto_CLICKED"
	key="cpGestSubentro.btnVerificaImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnVerificaImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','wpLocalizzazione_7_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpLocalizzazione_7_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestSubentro','btnNuovaRicercaImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnNuovaRicercaImpianto -->
<s:submit name="widg_btnNuovaRicercaImpianto" id="widg_btnNuovaRicercaImpianto" method="handleBtnNuovaRicercaImpianto_CLICKED"
	key="cpGestSubentro.btnNuovaRicercaImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnNuovaRicercaImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLocalizzazione --></div>

			
	
	
	<div id="p_mpTipoSubentro" class="panelBlock"><!-- startFragment:p_mpTipoSubentro -->
		

		
<s:if test="#session.cpGestSubentro_mpTipoSubentro_selectedMultiPanel == 'cpGestSubentro_mpTipoSubentro_fpTipoSubentro'">
	<s:include value="/jsp/multipanels/cpGestSubentro_mpTipoSubentro_fpTipoSubentro.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpTipoSubentro --></div>

			
	
	<div id="p_cpNavGestSubentro" class="commandPanelBlock"><!-- startFragment:p_cpNavGestSubentro -->
	
	
<div class="commandPanel navigation" id="cpNavGestSubentro">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestSubentro','btnSubIndietro')" >

	



<!-- widget btnSubIndietro -->
<s:submit name="widg_btnSubIndietro" id="widg_btnSubIndietro" method="handleBtnSubIndietro_CLICKED"
	key="cpGestSubentro.btnSubIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestSubentro','btnSubIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestSubentro --></div>

	

		
	

	<!-- endFragment:p_fpGestSubentro --></div>

	

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
