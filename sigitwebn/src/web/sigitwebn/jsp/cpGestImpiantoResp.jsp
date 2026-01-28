<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_impianto_resp -->
<!-- pageId:cpGestImpiantoResp -->

<s:form id="cpGestImpiantoResp" action="cpGestImpiantoResp" namespace="/base/gestisci_impianto_resp" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestImpiantoResp_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestImpiantoResp','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestImpiantoRespTitolo" class="formPanelBlock"><!-- startFragment:p_fpGestImpiantoRespTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestImpiantoResp.fpGestImpiantoRespTitolo.label" /></h4>
<div class="formPanel" id="fpGestImpiantoRespTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestImpiantoRespTitolo --></div>

			
	
	<div id="p_fpGestImpiantoResp" class="formPanelBlock"><!-- startFragment:p_fpGestImpiantoResp -->
		
	
<div class="formPanel" id="fpGestImpiantoResp">


	
	

	
	
			
	
	<div id="p_stdMsgPGestRespImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestRespImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestRespImp">
	<customtag:stdMessagePanel id="stdMsgPGestRespImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestRespImp --></div>

			
	
	<div id="p_wpCodImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpCodImpianto -->
	
	
<h4 class="wpLabel">codice impianto </h4>
<div class="widgetsPanel" id="wpCodImpianto">
	
	<customtag:widgetsPanel id="wpCodImpiantoTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpCodImp.label')}" labelFor="widg_tfImpCodImp" errorFor="appDataimpianto.impCodImpianto" labelId="tfImpCodImpLbl"
	position="first"  >


<!-- widget tfImpCodImp -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impCodImpianto" id="widg_tfImpCodImp"
maxlength="11"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpCodImp')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnImpVerCodImp')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnImpVerCodImp -->
<s:submit name="widg_btnImpVerCodImp" id="widg_btnImpVerCodImp" method="handleBtnImpVerCodImp_CLICKED"
	key="cpGestImpiantoResp.btnImpVerCodImp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnImpVerCodImp')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnApprofondisciImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnApprofondisciImpianto -->
<s:submit name="widg_btnApprofondisciImpianto" id="widg_btnApprofondisciImpianto" method="handleBtnApprofondisciImpianto_CLICKED"
	key="cpGestImpiantoResp.btnApprofondisciImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnApprofondisciImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbImpStatoImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbImpStatoImp.label')}" labelFor="widg_cbImpStatoImp" errorFor="appDataimpianto.impIdStatoImp" labelId="cbImpStatoImpLbl"
	position="first"  >


<!-- widget cbImpStatoImp -->
	<csiuicore:ajaxify id="p_wpCodImpianto" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impianto_resp/cpGestImpiantoResp!handleCbImpStatoImp_VALUE_CHANGED.do"
		pageId="cpGestImpiantoResp"
		formName="cpGestImpiantoResp"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impianto_resp">

<s:url id="widg_cbImpStatoImpurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpiantoResp!handleCbImpStatoImp_VALUE_CHANGED" namespace="/base/gestisci_impianto_resp"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataimpianto.impIdStatoImp" id="widg_cbImpStatoImp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoImpianto"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbImpStatoImp')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbImpStatoImp','conferma','%{widg_cbImpStatoImpurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbImpStatoImp','conferma','%{widg_cbImpStatoImpurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpCodImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpCodImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpCodImpianto_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCodImpianto_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cImpDataDismiss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cImpDataDismiss.label')}" labelFor="widg_cImpDataDismiss" errorFor="appDataimpianto.impDataDismissione" labelId="cImpDataDismissLbl"
	position="first"  >


<!-- widget cImpDataDismiss -->
<s:textfield 
	
	
	name="appDataimpianto.impDataDismissione" id="widg_cImpDataDismiss"
	disabled="isWidgetDisabled('cpGestImpiantoResp','cImpDataDismiss')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','taImpMotivivazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.taImpMotivivazione.label')}" labelFor="widg_taImpMotivivazione" errorFor="appDataimpianto.impMotivazione" labelId="taImpMotivivazioneLbl"
	  >


<!-- widget taImpMotivivazione -->
<s:textarea 
	
	
	name="appDataimpianto.impMotivazione" id="widg_taImpMotivivazione"
	disabled="isWidgetDisabled('cpGestImpiantoResp','taImpMotivivazione')"
	rows="3"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpCodImpianto_3_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCodImpianto_3_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','rbImpTipo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.rbImpTipo.label')}" labelFor="widg_rbImpTipo" errorFor="appDataimpianto.impTipoImpianto" labelId="rbImpTipoLbl"
	position="first"  >


<!-- widget rbImpTipo -->

	
<div id="appDataimpianto.impTipoImpianto" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbImpTipoCentr" name="appDataimpianto.impTipoImpianto"
	list="#{'C':'centralizzato'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpTipo')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpTipoCentrC"><s:text name="cpGestImpiantoResp.rbImpTipo.rbImpTipoCentr.label" /></label>








<s:radio
	
	
	id="widg_rbImpTipoAuto" name="appDataimpianto.impTipoImpianto"
	list="#{'A':'autonomo'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpTipo')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpTipoAutoA"><s:text name="cpGestImpiantoResp.rbImpTipo.rbImpTipoAuto.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','rbImpUiExt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.rbImpUiExt.label')}" labelFor="widg_rbImpUiExt" errorFor="appDataimpianto.impFlgAppareccUiExt" labelId="rbImpUiExtLbl"
	  >


<!-- widget rbImpUiExt -->

	
<div id="appDataimpianto.impFlgAppareccUiExt" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbImpUiExtSI" name="appDataimpianto.impFlgAppareccUiExt"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpUiExt')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpUiExtSItrue"><s:text name="cpGestImpiantoResp.rbImpUiExt.rbImpUiExtSI.label" /></label>








<s:radio
	
	
	id="widg_rbImpUiExtNO" name="appDataimpianto.impFlgAppareccUiExt"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpUiExt')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpUiExtNOfalse"><s:text name="cpGestImpiantoResp.rbImpUiExt.rbImpUiExtNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpCodImpianto_4_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCodImpianto_4_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','rbImpCont')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.rbImpCont.label')}" labelFor="widg_rbImpCont" errorFor="appDataimpianto.impFlgContabilizzatore" labelId="rbImpContLbl"
	position="first"  >


<!-- widget rbImpCont -->

	
<div id="appDataimpianto.impFlgContabilizzatore" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbImpContSI" name="appDataimpianto.impFlgContabilizzatore"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpCont')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpContSItrue"><s:text name="cpGestImpiantoResp.rbImpCont.rbImpContSI.label" /></label>








<s:radio
	
	
	id="widg_rbImpContNO" name="appDataimpianto.impFlgContabilizzatore"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpCont')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpContNOfalse"><s:text name="cpGestImpiantoResp.rbImpCont.rbImpContNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','rbImpMedCiv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.rbImpMedCiv.label')}" labelFor="widg_rbImpMedCiv" errorFor="appDataimpianto.impIdStatoImp" labelId="rbImpMedCivLbl"
	  >


<!-- widget rbImpMedCiv -->

	
<div id="appDataimpianto.impIdStatoImp" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbImpMedCivSI" name="appDataimpianto.impIdStatoImp"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpMedCiv')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpMedCivSItrue"><s:text name="cpGestImpiantoResp.rbImpMedCiv.rbImpMedCivSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbImpMedCivNO" name="appDataimpianto.impIdStatoImp"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpiantoResp','rbImpMedCiv')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpMedCivNOfalse"><s:text name="cpGestImpiantoResp.rbImpMedCiv.rbImpMedCivNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpCodImpianto_5_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCodImpianto_5_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpCodImpianto --></div>

			
	
	<div id="p_wpLocalizzazione" class="widgetsPanelBlock"><!-- startFragment:p_wpLocalizzazione -->
	
	
<h4 class="wpLabel">localizzazione impianto </h4>
<div class="widgetsPanel" id="wpLocalizzazione">
	
	<customtag:widgetsPanel id="wpLocalizzazioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbImpLocProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbImpLocProvincia.label')}" labelFor="widg_cbImpLocProvincia" errorFor="appDataimpianto.impLocIdProvincia" labelId="cbImpLocProvinciaLbl"
	position="first"  >


<!-- widget cbImpLocProvincia -->
	<csiuicore:ajaxify id="p_wpLocalizzazione" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impianto_resp/cpGestImpiantoResp!handleCbImpLocProvincia_VALUE_CHANGED.do"
		pageId="cpGestImpiantoResp"
		formName="cpGestImpiantoResp"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impianto_resp">

<s:url id="widg_cbImpLocProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpiantoResp!handleCbImpLocProvincia_VALUE_CHANGED" namespace="/base/gestisci_impianto_resp"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataimpianto.impLocIdProvincia" id="widg_cbImpLocProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonte"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbImpLocProvincia')"
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


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbImpLocComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbImpLocComune.label')}" labelFor="widg_cbImpLocComune" errorFor="appDataimpianto.impLocIdComune" labelId="cbImpLocComuneLbl"
	position="last"  >


<!-- widget cbImpLocComune -->
<s:select name="appDataimpianto.impLocIdComune" id="widg_cbImpLocComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbImpLocComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocIndirizzo.label')}" labelFor="widg_tfImpLocIndirizzo" errorFor="appDataimpianto.impLocIndirizzo" labelId="tfImpLocIndirizzoLbl"
	position="first"  >


<!-- widget tfImpLocIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocIndirizzo" id="widg_tfImpLocIndirizzo"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnImpLocCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocCercaIndirizzo -->
<s:submit name="widg_btnImpLocCercaIndirizzo" id="widg_btnImpLocCercaIndirizzo" method="handleBtnImpLocCercaIndirizzo_CLICKED"
	key="cpGestImpiantoResp.btnImpLocCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnImpLocCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbImpLocIndirizzo.label')}" labelFor="widg_cbImpLocIndirizzo" errorFor="appDataimpianto.impLocIdIndirizzo" labelId="cbImpLocIndirizzoLbl"
	position="first"  >


<!-- widget cbImpLocIndirizzo -->
<s:select name="appDataimpianto.impLocIdIndirizzo" id="widg_cbImpLocIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizzi"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbImpLocIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnImpLocNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocNuovaRicercaIndirizzo -->
<s:submit name="widg_btnImpLocNuovaRicercaIndirizzo" id="widg_btnImpLocNuovaRicercaIndirizzo" method="handleBtnImpLocNuovaRicercaIndirizzo_CLICKED"
	key="cpGestImpiantoResp.btnImpLocNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnImpLocNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocNoStrad.label')}" labelFor="widg_tfImpLocNoStrad" errorFor="appDataimpianto.impLocIndirizzoNoStrad" labelId="tfImpLocNoStradLbl"
	position="first"  >


<!-- widget tfImpLocNoStrad -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocIndirizzoNoStrad" id="widg_tfImpLocNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpLocalizzazione_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocCivico.label')}" labelFor="widg_tfImpLocCivico" errorFor="appDataimpianto.impLocCivico" labelId="tfImpLocCivicoLbl"
	position="first"  >


<!-- widget tfImpLocCivico -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocCivico" id="widg_tfImpLocCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocCap.label')}" labelFor="widg_tfImpLocCap" errorFor="appDataimpianto.impLocCap" labelId="tfImpLocCapLbl"
	position="last"  >


<!-- widget tfImpLocCap -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocCap" id="widg_tfImpLocCap"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocCap')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocInterno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocInterno.label')}" labelFor="widg_tfImpLocInterno" errorFor="appDataimpianto.impLocInterno" labelId="tfImpLocInternoLbl"
	position="first"  >


<!-- widget tfImpLocInterno -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocInterno" id="widg_tfImpLocInterno"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocInterno')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocScala')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocScala.label')}" labelFor="widg_tfImpLocScala" errorFor="appDataimpianto.impLocScala" labelId="tfImpLocScalaLbl"
	position="last"  >


<!-- widget tfImpLocScala -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocScala" id="widg_tfImpLocScala"
maxlength="4"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocScala')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocPalazzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocPalazzo.label')}" labelFor="widg_tfImpLocPalazzo" errorFor="appDataimpianto.impLocPalazzo" labelId="tfImpLocPalazzoLbl"
	position="first"  >


<!-- widget tfImpLocPalazzo -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocPalazzo" id="widg_tfImpLocPalazzo"
maxlength="20"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocPalazzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpLocalizzazione_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocSezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocSezione.label')}" labelFor="widg_tfImpLocSezione" errorFor="appDataimpianto.impLocSezione" labelId="tfImpLocSezioneLbl"
	position="first"  >


<!-- widget tfImpLocSezione -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocSezione" id="widg_tfImpLocSezione"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocSezione')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocFoglio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocFoglio.label')}" labelFor="widg_tfImpLocFoglio" errorFor="appDataimpianto.impLocFoglio" labelId="tfImpLocFoglioLbl"
	position="last"  >


<!-- widget tfImpLocFoglio -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocFoglio" id="widg_tfImpLocFoglio"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocFoglio')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocParticella')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocParticella.label')}" labelFor="widg_tfImpLocParticella" errorFor="appDataimpianto.impLocParticella" labelId="tfImpLocParticellaLbl"
	position="first"  >


<!-- widget tfImpLocParticella -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocParticella" id="widg_tfImpLocParticella"
maxlength="9"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocParticella')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocSubalterno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocSubalterno.label')}" labelFor="widg_tfImpLocSubalterno" errorFor="appDataimpianto.impLocSubalterno" labelId="tfImpLocSubalternoLbl"
	position="last"  >


<!-- widget tfImpLocSubalterno -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocSubalterno" id="widg_tfImpLocSubalterno"
maxlength="4"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocSubalterno')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbImpLocEdifNonAcc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbImpLocEdifNonAcc.label')}" labelFor="widg_cbImpLocEdifNonAcc" errorFor="appDataimpianto.impLocEdifNonAcc" labelId="cbImpLocEdifNonAccLbl"
	position="first"  >


<!-- widget cbImpLocEdifNonAcc -->
<s:checkbox 
	
	
	name="appDataimpianto.impLocEdifNonAcc" id="widg_cbImpLocEdifNonAcc"
	disabled="isWidgetDisabled('cpGestImpiantoResp','cbImpLocEdifNonAcc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpiantoResp','cbImpLocEdifNonAcc')" >
	<s:hidden name="__checkbox_appDataimpianto.impLocEdifNonAcc" id="__checkbox_widg_cbImpLocEdifNonAcc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpLocalizzazione_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocPod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocPod.label')}" labelFor="widg_tfImpLocPod" errorFor="appDataimpianto.impLocPod" labelId="tfImpLocPodLbl"
	position="first"  >


<!-- widget tfImpLocPod -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocPod" id="widg_tfImpLocPod"
maxlength="15"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocPod')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpLocalizzazione_11_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_11_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocPdr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocPdr.label')}" labelFor="widg_tfImpLocPdr" errorFor="appDataimpianto.impLocPdr" labelId="tfImpLocPdrLbl"
	position="first"  >


<!-- widget tfImpLocPdr -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocPdr" id="widg_tfImpLocPdr"
maxlength="14"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocPdr')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbImpLocPdrNonPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbImpLocPdrNonPres.label')}" labelFor="widg_cbImpLocPdrNonPres" errorFor="appDataimpianto.impLocPdrNonPres" labelId="cbImpLocPdrNonPresLbl"
	position="last"  >


<!-- widget cbImpLocPdrNonPres -->
<s:checkbox 
	
	
	name="appDataimpianto.impLocPdrNonPres" id="widg_cbImpLocPdrNonPres"
	disabled="isWidgetDisabled('cpGestImpiantoResp','cbImpLocPdrNonPres')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpiantoResp','cbImpLocPdrNonPres')" >
	<s:hidden name="__checkbox_appDataimpianto.impLocPdrNonPres" id="__checkbox_widg_cbImpLocPdrNonPres" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbVisuProprietario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbVisuProprietario.label')}" labelFor="widg_cbVisuProprietario" errorFor="appDataimpianto.visuProprietario" labelId="cbVisuProprietarioLbl"
	position="first"  >


<!-- widget cbVisuProprietario -->
<s:checkbox 
	
	
	name="appDataimpianto.visuProprietario" id="widg_cbVisuProprietario"
	disabled="isWidgetDisabled('cpGestImpiantoResp','cbVisuProprietario')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpiantoResp','cbVisuProprietario')" >
	<s:hidden name="__checkbox_appDataimpianto.visuProprietario" id="__checkbox_widg_cbVisuProprietario" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','taImpLocNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.taImpLocNote.label')}" labelFor="widg_taImpLocNote" errorFor="appDataimpianto.impLocNote" labelId="taImpLocNoteLbl"
	position="last"  >


<!-- widget taImpLocNote -->
<s:textarea 
	
	
	name="appDataimpianto.impLocNote" id="widg_taImpLocNote"
	disabled="isWidgetDisabled('cpGestImpiantoResp','taImpLocNote')"
	rows="3"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLocalizzazione --></div>

			
	
	<div id="p_wpProprietario" class="widgetsPanelBlock"><!-- startFragment:p_wpProprietario -->
	
	
<h4 class="wpLabel">priprietario </h4>
<div class="widgetsPanel" id="wpProprietario">
	
	<customtag:widgetsPanel id="wpProprietarioTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocProprietario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocProprietario.label')}" labelFor="widg_tfImpLocProprietario" errorFor="appDataimpianto.proprietario.denomCompleta" labelId="tfImpLocProprietarioLbl"
	position="first"  >


<!-- widget tfImpLocProprietario -->
<s:textfield 
	
	
	name="appDataimpianto.proprietario.denomCompleta" id="widg_tfImpLocProprietario"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocProprietario')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocPropDataInizio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocPropDataInizio.label')}" labelFor="widg_tfImpLocPropDataInizio" errorFor="appDataimpianto.proprietario.dataInizio" labelId="tfImpLocPropDataInizioLbl"
	position="last"  >


<!-- widget tfImpLocPropDataInizio -->
<s:textfield 
	
	
	name="appDataimpianto.proprietario.dataInizio" id="widg_tfImpLocPropDataInizio"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocPropDataInizio')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfImpLocPropIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfImpLocPropIndirizzo.label')}" labelFor="widg_tfImpLocPropIndirizzo" errorFor="appDataimpianto.proprietario.indirizzo" labelId="tfImpLocPropIndirizzoLbl"
	position="first"  >


<!-- widget tfImpLocPropIndirizzo -->
<s:textfield 
	
	
	name="appDataimpianto.proprietario.indirizzo" id="widg_tfImpLocPropIndirizzo"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfImpLocPropIndirizzo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cImpDataCessazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cImpDataCessazione.label')}" labelFor="widg_cImpDataCessazione" errorFor="appDataimpianto.proprietario.dataFine" labelId="cImpDataCessazioneLbl"
	position="last"  >


<!-- widget cImpDataCessazione -->
<s:textfield 
	
	
	name="appDataimpianto.proprietario.dataFine" id="widg_cImpDataCessazione"
	disabled="isWidgetDisabled('cpGestImpiantoResp','cImpDataCessazione')"
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

	<!-- endFragment:p_wpProprietario --></div>

			
	
	<div id="p_cpFunProprietario" class="commandPanelBlock"><!-- startFragment:p_cpFunProprietario -->
	
	
<div class="commandPanel functional" id="cpFunProprietario">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnConfermaProp')" >

	



<!-- widget btnConfermaProp -->
<s:submit name="widg_btnConfermaProp" id="widg_btnConfermaProp" method="handleBtnConfermaProp_CLICKED"
	key="cpGestImpiantoResp.btnConfermaProp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnConfermaProp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnModificaProp')" >

	



<!-- widget btnModificaProp -->
<s:submit name="widg_btnModificaProp" id="widg_btnModificaProp" method="handleBtnModificaProp_CLICKED"
	key="cpGestImpiantoResp.btnModificaProp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnModificaProp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnCessaProp')" >

	



<!-- widget btnCessaProp -->
<s:submit name="widg_btnCessaProp" id="widg_btnCessaProp" method="handleBtnCessaProp_CLICKED"
	key="cpGestImpiantoResp.btnCessaProp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnCessaProp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunProprietario --></div>

			
	
	<div id="p_wpResponsabile" class="widgetsPanelBlock"><!-- startFragment:p_wpResponsabile -->
	
	
<h4 class="wpLabel">dati del responsabile </h4>
<div class="widgetsPanel" id="wpResponsabile">
	
	<customtag:widgetsPanel id="wpResponsabileTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbRespTitolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbRespTitolo.label')}" labelFor="widg_cbRespTitolo" errorFor="appDataresponsabile.idTitolo" labelId="cbRespTitoloLbl"
	position="first"  >


<!-- widget cbRespTitolo -->
<s:select name="appDataresponsabile.idTitolo" id="widg_cbRespTitolo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTitoli"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbRespTitolo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_2_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpResponsabile_2_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbRespSiglaRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbRespSiglaRea.label')}" labelFor="widg_cbRespSiglaRea" errorFor="appDataresponsabile.idSiglaRea" labelId="cbRespSiglaReaLbl"
	position="first"  >


<!-- widget cbRespSiglaRea -->
<s:select name="appDataresponsabile.idSiglaRea" id="widg_cbRespSiglaRea"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSiglaRea"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbRespSiglaRea')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespNumRea')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespNumRea.label')}" labelFor="widg_tfRespNumRea" errorFor="appDataresponsabile.numeroRea" labelId="tfRespNumReaLbl"
	position="last"  >


<!-- widget tfRespNumRea -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.numeroRea" id="widg_tfRespNumRea"
maxlength="9"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespNumRea')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespCf.label')}" labelFor="widg_tfRespCf" errorFor="appDataresponsabile.codiceFiscale" labelId="tfRespCfLbl"
	position="first"  >


<!-- widget tfRespCf -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.codiceFiscale" id="widg_tfRespCf"
maxlength="16"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespCf')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespCognome.label')}" labelFor="widg_tfRespCognome" errorFor="appDataresponsabile.cognome" labelId="tfRespCognomeLbl"
	position="first"  >


<!-- widget tfRespCognome -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.cognome" id="widg_tfRespCognome"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespCognome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_5_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_5_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespNome.label')}" labelFor="widg_tfRespNome" errorFor="appDataresponsabile.nome" labelId="tfRespNomeLbl"
	position="first"  >


<!-- widget tfRespNome -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.nome" id="widg_tfRespNome"
maxlength="20"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespNome')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_6_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_6_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbRespIndirizzoEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbRespIndirizzoEst.label')}" labelFor="widg_cbRespIndirizzoEst" errorFor="appDataresponsabile.flgIndirizzoEst" labelId="cbRespIndirizzoEstLbl"
	position="first"  >


<!-- widget cbRespIndirizzoEst -->
<s:checkbox 
	
	
	name="appDataresponsabile.flgIndirizzoEst" id="widg_cbRespIndirizzoEst"
	disabled="isWidgetDisabled('cpGestImpiantoResp','cbRespIndirizzoEst')"
	cssClass="checkbox"
	onclick="onRBClick('/sigitwebn/base/gestisci_impianto_resp/cpGestImpiantoResp!handleCbRespIndirizzoEst_VALUE_CHANGED.do')" 
	/> 
<s:if test="!isWidgetDisabled('cpGestImpiantoResp','cbRespIndirizzoEst')" >
	<s:hidden name="__checkbox_appDataresponsabile.flgIndirizzoEst" id="__checkbox_widg_cbRespIndirizzoEst" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbRespProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbRespProvincia.label')}" labelFor="widg_cbRespProvincia" errorFor="appDataresponsabile.idProvincia" labelId="cbRespProvinciaLbl"
	position="first"  >


<!-- widget cbRespProvincia -->
	<csiuicore:ajaxify id="p_wpResponsabile" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impianto_resp/cpGestImpiantoResp!handleCbRespProvincia_VALUE_CHANGED.do"
		pageId="cpGestImpiantoResp"
		formName="cpGestImpiantoResp"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impianto_resp">

<s:url id="widg_cbRespProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpiantoResp!handleCbRespProvincia_VALUE_CHANGED" namespace="/base/gestisci_impianto_resp"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataresponsabile.idProvincia" id="widg_cbRespProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvince"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbRespProvincia')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbRespProvincia','conferma','%{widg_cbRespProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRespProvincia','conferma','%{widg_cbRespProvinciaurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_8_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_8_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbRespComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbRespComune.label')}" labelFor="widg_cbRespComune" errorFor="appDataresponsabile.idComune" labelId="cbRespComuneLbl"
	position="first"  >


<!-- widget cbRespComune -->
<s:select name="appDataresponsabile.idComune" id="widg_cbRespComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuniResp"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbRespComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_9_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_9_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespIndirizzo.label')}" labelFor="widg_tfRespIndirizzo" errorFor="appDataresponsabile.indirizzo" labelId="tfRespIndirizzoLbl"
	position="first"  >


<!-- widget tfRespIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.indirizzo" id="widg_tfRespIndirizzo"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnRespCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespCercaIndirizzo -->
<s:submit name="widg_btnRespCercaIndirizzo" id="widg_btnRespCercaIndirizzo" method="handleBtnRespCercaIndirizzo_CLICKED"
	key="cpGestImpiantoResp.btnRespCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnRespCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cbRespIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cbRespIndirizzo.label')}" labelFor="widg_cbRespIndirizzo" errorFor="appDataresponsabile.idIndirizzo" labelId="cbRespIndirizzoLbl"
	position="first"  >


<!-- widget cbRespIndirizzo -->
<s:select name="appDataresponsabile.idIndirizzo" id="widg_cbRespIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizziResp"
	  disabled="isWidgetDisabled('cpGestImpiantoResp','cbRespIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnRespNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnRespNuovaRicercaIndirizzo -->
<s:submit name="widg_btnRespNuovaRicercaIndirizzo" id="widg_btnRespNuovaRicercaIndirizzo" method="handleBtnRespNuovaRicercaIndirizzo_CLICKED"
	key="cpGestImpiantoResp.btnRespNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnRespNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfIRespNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfIRespNoStrad.label')}" labelFor="widg_tfIRespNoStrad" errorFor="appDataresponsabile.indirizzoNoStrad" labelId="tfIRespNoStradLbl"
	position="first"  >


<!-- widget tfIRespNoStrad -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.indirizzoNoStrad" id="widg_tfIRespNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfIRespNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_12_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_12_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespCivico.label')}" labelFor="widg_tfRespCivico" errorFor="appDataresponsabile.civico" labelId="tfRespCivicoLbl"
	position="first"  >


<!-- widget tfRespCivico -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.civico" id="widg_tfRespCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_13_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_13_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespCap.label')}" labelFor="widg_tfRespCap" errorFor="appDataresponsabile.cap" labelId="tfRespCapLbl"
	position="first"  >


<!-- widget tfRespCap -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.cap" id="widg_tfRespCap"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespCap')"
	size="20" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_14_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_14_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespEstStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespEstStato.label')}" labelFor="widg_tfRespEstStato" errorFor="appDataresponsabile.estStato" labelId="tfRespEstStatoLbl"
	position="first"  >


<!-- widget tfRespEstStato -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estStato" id="widg_tfRespEstStato"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespEstStato')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_15_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_15_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespEstCitta')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespEstCitta.label')}" labelFor="widg_tfRespEstCitta" errorFor="appDataresponsabile.estCitta" labelId="tfRespEstCittaLbl"
	position="first"  >


<!-- widget tfRespEstCitta -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estCitta" id="widg_tfRespEstCitta"
maxlength="50"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespEstCitta')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_16_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_16_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespEstIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespEstIndirizzo.label')}" labelFor="widg_tfRespEstIndirizzo" errorFor="appDataresponsabile.estIndirizzo" labelId="tfRespEstIndirizzoLbl"
	position="first"  >


<!-- widget tfRespEstIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estIndirizzo" id="widg_tfRespEstIndirizzo"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespEstIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_17_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_17_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespEstCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespEstCivico.label')}" labelFor="widg_tfRespEstCivico" errorFor="appDataresponsabile.civico" labelId="tfRespEstCivicoLbl"
	position="first"  >


<!-- widget tfRespEstCivico -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.civico" id="widg_tfRespEstCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespEstCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_18_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_18_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespEstCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespEstCap.label')}" labelFor="widg_tfRespEstCap" errorFor="appDataresponsabile.estCap" labelId="tfRespEstCapLbl"
	position="first"  >


<!-- widget tfRespEstCap -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.estCap" id="widg_tfRespEstCap"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespEstCap')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_19_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_19_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','cRespDataInizioResp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.cRespDataInizioResp.label')}" labelFor="widg_cRespDataInizioResp" errorFor="appDataresponsabile.dataInizioResp" labelId="cRespDataInizioRespLbl"
	position="first"  >


<!-- widget cRespDataInizioResp -->
<s:textfield 
	
	
	name="appDataresponsabile.dataInizioResp" id="widg_cRespDataInizioResp"
	disabled="isWidgetDisabled('cpGestImpiantoResp','cRespDataInizioResp')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_20_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_20_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','tfRespEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpiantoResp.tfRespEmail.label')}" labelFor="widg_tfRespEmail" errorFor="appDataresponsabile.email" labelId="tfRespEmailLbl"
	position="first"  >


<!-- widget tfRespEmail -->
<s:textfield 
	
title=""	
	name="appDataresponsabile.email" id="widg_tfRespEmail"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpiantoResp','tfRespEmail')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpiantoResp','wpResponsabile_21_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpResponsabile_21_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpResponsabile --></div>

			
	
	<div id="p_cpFunGestImpiantoResp" class="commandPanelBlock"><!-- startFragment:p_cpFunGestImpiantoResp -->
	
	
<div class="commandPanel functional" id="cpFunGestImpiantoResp">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnImpiantoSalva')" >

	



<!-- widget btnImpiantoSalva -->
<s:submit name="widg_btnImpiantoSalva" id="widg_btnImpiantoSalva" method="handleBtnImpiantoSalva_CLICKED"
	key="cpGestImpiantoResp.btnImpiantoSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnImpiantoSalva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestImpiantoResp --></div>

			
	
	<div id="p_cpFunLibretto" class="commandPanelBlock"><!-- startFragment:p_cpFunLibretto -->
	
	
<div class="commandPanel functional" id="cpFunLibretto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnLibVisualizza')" >

	



<!-- widget btnLibVisualizza -->
<s:submit name="widg_btnLibVisualizza" id="widg_btnLibVisualizza" method="handleBtnLibVisualizza_CLICKED"
	key="cpGestImpiantoResp.btnLibVisualizza.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnLibVisualizza')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnLibRappControllo')" >

	



<!-- widget btnLibRappControllo -->
<s:submit name="widg_btnLibRappControllo" id="widg_btnLibRappControllo" method="handleBtnLibRappControllo_CLICKED"
	key="cpGestImpiantoResp.btnLibRappControllo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnLibRappControllo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnLibDocumentazione')" >

	



<!-- widget btnLibDocumentazione -->
<s:submit name="widg_btnLibDocumentazione" id="widg_btnLibDocumentazione" method="handleBtnLibDocumentazione_CLICKED"
	key="cpGestImpiantoResp.btnLibDocumentazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnLibDocumentazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnVisLibrettoWeb')" >

	



<!-- widget btnVisLibrettoWeb -->
<s:submit name="widg_btnVisLibrettoWeb" id="widg_btnVisLibrettoWeb" method="handleBtnVisLibrettoWeb_CLICKED"
	key="cpGestImpiantoResp.btnVisLibrettoWeb.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnVisLibrettoWeb')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnLibAggiornamenti')" >

	



<!-- widget btnLibAggiornamenti -->
<s:submit name="widg_btnLibAggiornamenti" id="widg_btnLibAggiornamenti" method="handleBtnLibAggiornamenti_CLICKED"
	key="cpGestImpiantoResp.btnLibAggiornamenti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnLibAggiornamenti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunLibretto --></div>

			
	
	<div id="p_cpNavImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpiantoResp','btnImpIndietro')" >

	



<!-- widget btnImpIndietro -->
<s:submit name="widg_btnImpIndietro" id="widg_btnImpIndietro" method="handleBtnImpIndietro_CLICKED"
	key="cpGestImpiantoResp.btnImpIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpiantoResp','btnImpIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavImpianto --></div>

	

		
	
</div>

	<!-- endFragment:p_fpGestImpiantoResp --></div>

	

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
