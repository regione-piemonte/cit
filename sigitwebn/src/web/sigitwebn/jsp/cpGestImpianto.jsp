<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_impianto/CpGestImpiantoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_impianto -->
<!-- pageId:cpGestImpianto -->

<s:form id="cpGestImpianto" action="cpGestImpianto" namespace="/base/gestisci_impianto" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestImpianto_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestImpianto','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpGestImpiantoTitolo" class="formPanelBlock"><!-- startFragment:p_fpGestImpiantoTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestImpianto.fpGestImpiantoTitolo.label" /></h4>
<div class="formPanel" id="fpGestImpiantoTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestImpiantoTitolo --></div>

			
	
	<div id="p_fpGestImpianto" class="formPanelBlock"><!-- startFragment:p_fpGestImpianto -->
		
	


	
	

	
	
			
	
	<div id="p_stdMsgPGestImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGestImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPGestImp">
	<customtag:stdMessagePanel id="stdMsgPGestImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGestImp --></div>

			
	
	
	<div id="p_mpInstallatoreOLD" class="panelBlock"><!-- startFragment:p_mpInstallatoreOLD -->
		

		
<s:if test="#session.cpGestImpianto_mpInstallatoreOLD_selectedMultiPanel == 'cpGestImpianto_mpInstallatoreOLD_fpInstallatore'">
	<s:include value="/jsp/multipanels/cpGestImpianto_mpInstallatoreOLD_fpInstallatore.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpInstallatoreOLD --></div>

			
	
	<div id="p_wpManutentori" class="widgetsPanelBlock"><!-- startFragment:p_wpManutentori -->
	
	
<h4 class="wpLabel">elenco gestori impianto </h4>
<div class="widgetsPanel" id="wpManutentori">
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','tbManutentori')" >

	
<div class="tableWidget">


<!-- widget tbManutentori -->
	<csiuicore:ajaxify id="p_wpManutentori" 
		widgetType="table"		
		pageId="cpGestImpianto"
		javascriptDetection="false">
<s:set name="cpGestImpianto_tbManutentori_clearStatus" value="isTableClearStatus('cpGestImpianto_tbManutentori')" />
<s:url id="cpGestImpiantoViewUrl"						   
					   action="cpGestImpianto"
					   namespace="/base/gestisci_impianto"/>
<display:table name="appDataelencoManutentori"  				
			   excludedParams="*"			   export="false"
               id="widg_tbManutentori"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestImpiantoViewUrl}"  
               clearStatus="${cpGestImpianto_tbManutentori_clearStatus}"
               uid="row_tbManutentori"
               summary="" 
               class="dataTable">
	
		<display:column property="denomDitta" titleKey="cpGestImpianto.tbManutentori.denomDitta.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceRea" titleKey="cpGestImpianto.tbManutentori.codiceRea.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="codiceFiscale" titleKey="cpGestImpianto.tbManutentori.codiceFiscale.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipoAllegato" titleKey="cpGestImpianto.tbManutentori.tipoAllegato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="componente" titleKey="cpGestImpianto.tbManutentori.componente.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpManutentori --></div>

			
	
	<div id="p_wpCodImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpCodImpianto -->
	
	
<h4 class="wpLabel">codice impianto </h4>
<div class="widgetsPanel" id="wpCodImpianto">
	
	<customtag:widgetsPanel id="wpCodImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpCodImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpCodImp.label')}" labelFor="widg_tfImpCodImp" errorFor="appDataimpianto.impCodImpianto" labelId="tfImpCodImpLbl"
	position="first"  >


<!-- widget tfImpCodImp -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impCodImpianto" id="widg_tfImpCodImp"
maxlength="11"	disabled="isWidgetDisabled('cpGestImpianto','tfImpCodImp')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnApprofondisciImpianto')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnApprofondisciImpianto -->
<s:submit name="widg_btnApprofondisciImpianto" id="widg_btnApprofondisciImpianto" method="handleBtnApprofondisciImpianto_CLICKED"
	key="cpGestImpianto.btnApprofondisciImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnApprofondisciImpianto')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbImpStatoImp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbImpStatoImp.label')}" labelFor="widg_cbImpStatoImp" errorFor="appDataimpianto.impIdStatoImp" labelId="cbImpStatoImpLbl"
	position="first"  >


<!-- widget cbImpStatoImp -->
	<csiuicore:ajaxify id="p_wpCodImpianto" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impianto/cpGestImpianto!handleCbImpStatoImp_VALUE_CHANGED.do"
		pageId="cpGestImpianto"
		formName="cpGestImpianto"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impianto">

<s:url id="widg_cbImpStatoImpurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpianto!handleCbImpStatoImp_VALUE_CHANGED" namespace="/base/gestisci_impianto"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataimpianto.impIdStatoImp" id="widg_cbImpStatoImp"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStatoImpianto"
	  disabled="isWidgetDisabled('cpGestImpianto','cbImpStatoImp')"
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


	
<s:if test="isWidgetVisible('cpGestImpianto','wpCodImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCodImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cImpDataDismiss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cImpDataDismiss.label')}" labelFor="widg_cImpDataDismiss" errorFor="appDataimpianto.impDataDismissione" labelId="cImpDataDismissLbl"
	position="first"  >


<!-- widget cImpDataDismiss -->
<s:textfield 
	
	
	name="appDataimpianto.impDataDismissione" id="widg_cImpDataDismiss"
	disabled="isWidgetDisabled('cpGestImpianto','cImpDataDismiss')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','taImpMotivazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.taImpMotivazione.label')}" labelFor="widg_taImpMotivazione" errorFor="appDataimpianto.impMotivazione" labelId="taImpMotivazioneLbl"
	position="last"  >


<!-- widget taImpMotivazione -->
<s:textarea 
	
	
	name="appDataimpianto.impMotivazione" id="widg_taImpMotivazione"
	disabled="isWidgetDisabled('cpGestImpianto','taImpMotivazione')"
	rows="3"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','rbImpTipo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.rbImpTipo.label')}" labelFor="widg_rbImpTipo" errorFor="appDataimpianto.impTipoImpianto" labelId="rbImpTipoLbl"
	position="first"  >


<!-- widget rbImpTipo -->

	
<div id="appDataimpianto.impTipoImpianto" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbImpTipoCentr" name="appDataimpianto.impTipoImpianto"
	list="#{'C':'centralizzato'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpTipo')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpTipoCentrC"><s:text name="cpGestImpianto.rbImpTipo.rbImpTipoCentr.label" /></label>








<s:radio
	
	
	id="widg_rbImpTipoAuto" name="appDataimpianto.impTipoImpianto"
	list="#{'A':'autonomo'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpTipo')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpTipoAutoA"><s:text name="cpGestImpianto.rbImpTipo.rbImpTipoAuto.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','rbImpUiExt')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.rbImpUiExt.label')}" labelFor="widg_rbImpUiExt" errorFor="appDataimpianto.impFlgAppareccUiExt" labelId="rbImpUiExtLbl"
	position="last"  >


<!-- widget rbImpUiExt -->

	
<div id="appDataimpianto.impFlgAppareccUiExt" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbImpUiExtSI" name="appDataimpianto.impFlgAppareccUiExt"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpUiExt')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpUiExtSItrue"><s:text name="cpGestImpianto.rbImpUiExt.rbImpUiExtSI.label" /></label>








<s:radio
	
	
	id="widg_rbImpUiExtNO" name="appDataimpianto.impFlgAppareccUiExt"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpUiExt')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpUiExtNOfalse"><s:text name="cpGestImpianto.rbImpUiExt.rbImpUiExtNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','rbImpCont')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.rbImpCont.label')}" labelFor="widg_rbImpCont" errorFor="appDataimpianto.impFlgContabilizzatore" labelId="rbImpContLbl"
	position="first"  >


<!-- widget rbImpCont -->

	
<div id="appDataimpianto.impFlgContabilizzatore" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbImpContSI" name="appDataimpianto.impFlgContabilizzatore"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpCont')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpContSItrue"><s:text name="cpGestImpianto.rbImpCont.rbImpContSI.label" /></label>








<s:radio
	
	
	id="widg_rbImpContNO" name="appDataimpianto.impFlgContabilizzatore"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpCont')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpContNOfalse"><s:text name="cpGestImpianto.rbImpCont.rbImpContNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','rbImpMedCiv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.rbImpMedCiv.label')}" labelFor="widg_rbImpMedCiv" errorFor="appDataimpianto.impFlgMedioCivile" labelId="rbImpMedCivLbl"
	position="last"  >


<!-- widget rbImpMedCiv -->

	
<div id="appDataimpianto.impFlgMedioCivile" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbImpMedCivSI" name="appDataimpianto.impFlgMedioCivile"
	list="#{'true':'SI'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpMedCiv')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpMedCivSItrue"><s:text name="cpGestImpianto.rbImpMedCiv.rbImpMedCivSI.label" /></label>








<s:radio
	
	
	id="widg_rbImpMedCivNO" name="appDataimpianto.impFlgMedioCivile"
	list="#{'false':'NO'}"
	disabled="isWidgetDisabled('cpGestImpianto','rbImpMedCiv')"
	cssClass="radio"
	
	/> <label  for="widg_rbImpMedCivNOfalse"><s:text name="cpGestImpianto.rbImpMedCiv.rbImpMedCivNO.label" /></label>





	
</div>



	
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
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','cbImpLocProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbImpLocProvincia.label')}" labelFor="widg_cbImpLocProvincia" errorFor="appDataimpianto.impLocIdProvincia" labelId="cbImpLocProvinciaLbl"
	position="first"  >


<!-- widget cbImpLocProvincia -->
	<csiuicore:ajaxify id="p_wpLocalizzazione" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_impianto/cpGestImpianto!handleCbImpLocProvincia_VALUE_CHANGED.do"
		pageId="cpGestImpianto"
		formName="cpGestImpianto"
		javascriptDetection="false"
		nameSpace="/base/gestisci_impianto">

<s:url id="widg_cbImpLocProvinciaurlComboBoxValueChange"
   action="/sigitwebn/cpGestImpianto!handleCbImpLocProvincia_VALUE_CHANGED" namespace="/base/gestisci_impianto"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataimpianto.impLocIdProvincia" id="widg_cbImpLocProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoProvincePiemonte"
	  disabled="isWidgetDisabled('cpGestImpianto','cbImpLocProvincia')"
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


	
<s:if test="isWidgetVisible('cpGestImpianto','cbImpLocComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbImpLocComune.label')}" labelFor="widg_cbImpLocComune" errorFor="appDataimpianto.impLocIdComune" labelId="cbImpLocComuneLbl"
	position="last"  >


<!-- widget cbImpLocComune -->
<s:select name="appDataimpianto.impLocIdComune" id="widg_cbImpLocComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComuni"
	  disabled="isWidgetDisabled('cpGestImpianto','cbImpLocComune')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocIndirizzo.label')}" labelFor="widg_tfImpLocIndirizzo" errorFor="appDataimpianto.impLocIndirizzo" labelId="tfImpLocIndirizzoLbl"
	position="first"  >


<!-- widget tfImpLocIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocIndirizzo" id="widg_tfImpLocIndirizzo"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocIndirizzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnImpLocCercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocCercaIndirizzo -->
<s:submit name="widg_btnImpLocCercaIndirizzo" id="widg_btnImpLocCercaIndirizzo" method="handleBtnImpLocCercaIndirizzo_CLICKED"
	key="cpGestImpianto.btnImpLocCercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnImpLocCercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbImpLocIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbImpLocIndirizzo.label')}" labelFor="widg_cbImpLocIndirizzo" errorFor="appDataimpianto.impLocIdIndirizzo" labelId="cbImpLocIndirizzoLbl"
	position="first"  >


<!-- widget cbImpLocIndirizzo -->
<s:select name="appDataimpianto.impLocIdIndirizzo" id="widg_cbImpLocIndirizzo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIndirizzi"
	  disabled="isWidgetDisabled('cpGestImpianto','cbImpLocIndirizzo')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','btnImpLocNuovaRicercaIndirizzo')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnImpLocNuovaRicercaIndirizzo -->
<s:submit name="widg_btnImpLocNuovaRicercaIndirizzo" id="widg_btnImpLocNuovaRicercaIndirizzo" method="handleBtnImpLocNuovaRicercaIndirizzo_CLICKED"
	key="cpGestImpianto.btnImpLocNuovaRicercaIndirizzo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnImpLocNuovaRicercaIndirizzo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocNoStrad')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocNoStrad.label')}" labelFor="widg_tfImpLocNoStrad" errorFor="appDataimpianto.impLocIndirizzoNoStrad" labelId="tfImpLocNoStradLbl"
	position="first"  >


<!-- widget tfImpLocNoStrad -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocIndirizzoNoStrad" id="widg_tfImpLocNoStrad"
maxlength="200"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocNoStrad')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpLocalizzazione_4_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_4_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocCivico.label')}" labelFor="widg_tfImpLocCivico" errorFor="appDataimpianto.impLocCivico" labelId="tfImpLocCivicoLbl"
	position="first"  >


<!-- widget tfImpLocCivico -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocCivico" id="widg_tfImpLocCivico"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocCap.label')}" labelFor="widg_tfImpLocCap" errorFor="appDataimpianto.impLocCap" labelId="tfImpLocCapLbl"
	position="last"  >


<!-- widget tfImpLocCap -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocCap" id="widg_tfImpLocCap"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocCap')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocInterno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocInterno.label')}" labelFor="widg_tfImpLocInterno" errorFor="appDataimpianto.impLocInterno" labelId="tfImpLocInternoLbl"
	position="first"  >


<!-- widget tfImpLocInterno -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocInterno" id="widg_tfImpLocInterno"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocInterno')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocScala')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocScala.label')}" labelFor="widg_tfImpLocScala" errorFor="appDataimpianto.impLocScala" labelId="tfImpLocScalaLbl"
	position="last"  >


<!-- widget tfImpLocScala -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocScala" id="widg_tfImpLocScala"
maxlength="4"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocScala')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocPalazzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocPalazzo.label')}" labelFor="widg_tfImpLocPalazzo" errorFor="appDataimpianto.impLocPalazzo" labelId="tfImpLocPalazzoLbl"
	position="first"  >


<!-- widget tfImpLocPalazzo -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocPalazzo" id="widg_tfImpLocPalazzo"
maxlength="20"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocPalazzo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpLocalizzazione_7_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_7_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocSezione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocSezione.label')}" labelFor="widg_tfImpLocSezione" errorFor="appDataimpianto.impLocSezione" labelId="tfImpLocSezioneLbl"
	position="first"  >


<!-- widget tfImpLocSezione -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocSezione" id="widg_tfImpLocSezione"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocSezione')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocFoglio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocFoglio.label')}" labelFor="widg_tfImpLocFoglio" errorFor="appDataimpianto.impLocFoglio" labelId="tfImpLocFoglioLbl"
	position="last"  >


<!-- widget tfImpLocFoglio -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocFoglio" id="widg_tfImpLocFoglio"
maxlength="5"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocFoglio')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocParticella')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocParticella.label')}" labelFor="widg_tfImpLocParticella" errorFor="appDataimpianto.impLocParticella" labelId="tfImpLocParticellaLbl"
	position="first"  >


<!-- widget tfImpLocParticella -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocParticella" id="widg_tfImpLocParticella"
maxlength="9"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocParticella')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocSubalterno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocSubalterno.label')}" labelFor="widg_tfImpLocSubalterno" errorFor="appDataimpianto.impLocSubalterno" labelId="tfImpLocSubalternoLbl"
	position="last"  >


<!-- widget tfImpLocSubalterno -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocSubalterno" id="widg_tfImpLocSubalterno"
maxlength="4"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocSubalterno')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbImpLocEdifNonAcc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbImpLocEdifNonAcc.label')}" labelFor="widg_cbImpLocEdifNonAcc" errorFor="appDataimpianto.impLocEdifNonAcc" labelId="cbImpLocEdifNonAccLbl"
	position="first"  >


<!-- widget cbImpLocEdifNonAcc -->
<s:checkbox 
	
	
	name="appDataimpianto.impLocEdifNonAcc" id="widg_cbImpLocEdifNonAcc"
	disabled="isWidgetDisabled('cpGestImpianto','cbImpLocEdifNonAcc')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpianto','cbImpLocEdifNonAcc')" >
	<s:hidden name="__checkbox_appDataimpianto.impLocEdifNonAcc" id="__checkbox_widg_cbImpLocEdifNonAcc" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpLocalizzazione_10_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_10_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocPod')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocPod.label')}" labelFor="widg_tfImpLocPod" errorFor="appDataimpianto.impLocPod" labelId="tfImpLocPodLbl"
	position="first"  >


<!-- widget tfImpLocPod -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocPod" id="widg_tfImpLocPod"
maxlength="15"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocPod')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','wpLocalizzazione_11_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLocalizzazione_11_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocPdr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocPdr.label')}" labelFor="widg_tfImpLocPdr" errorFor="appDataimpianto.impLocPdr" labelId="tfImpLocPdrLbl"
	position="first"  >


<!-- widget tfImpLocPdr -->
<s:textfield 
	
title=""	
	name="appDataimpianto.impLocPdr" id="widg_tfImpLocPdr"
maxlength="14"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocPdr')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbImpLocPdrNonPres')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbImpLocPdrNonPres.label')}" labelFor="widg_cbImpLocPdrNonPres" errorFor="appDataimpianto.impLocPdrNonPres" labelId="cbImpLocPdrNonPresLbl"
	position="last"  >


<!-- widget cbImpLocPdrNonPres -->
<s:checkbox 
	
	
	name="appDataimpianto.impLocPdrNonPres" id="widg_cbImpLocPdrNonPres"
	disabled="isWidgetDisabled('cpGestImpianto','cbImpLocPdrNonPres')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpianto','cbImpLocPdrNonPres')" >
	<s:hidden name="__checkbox_appDataimpianto.impLocPdrNonPres" id="__checkbox_widg_cbImpLocPdrNonPres" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cbVisuProprietario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cbVisuProprietario.label')}" labelFor="widg_cbVisuProprietario" errorFor="appDataimpianto.visuProprietario" labelId="cbVisuProprietarioLbl"
	position="first"  >


<!-- widget cbVisuProprietario -->
<s:checkbox 
	
title=""	
	name="appDataimpianto.visuProprietario" id="widg_cbVisuProprietario"
	disabled="isWidgetDisabled('cpGestImpianto','cbVisuProprietario')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestImpianto','cbVisuProprietario')" >
	<s:hidden name="__checkbox_appDataimpianto.visuProprietario" id="__checkbox_widg_cbVisuProprietario" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','taImpLocNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.taImpLocNote.label')}" labelFor="widg_taImpLocNote" errorFor="appDataimpianto.impLocNote" labelId="taImpLocNoteLbl"
	position="last"  >


<!-- widget taImpLocNote -->
<s:textarea 
	
	
	name="appDataimpianto.impLocNote" id="widg_taImpLocNote"
	disabled="isWidgetDisabled('cpGestImpianto','taImpLocNote')"
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

			
	
	<div id="p_cpFunGestImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunGestImpianto -->
	
	
<div class="commandPanel functional" id="cpFunGestImpianto">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestImpianto','btnImpiantoSalva')" >

	



<!-- widget btnImpiantoSalva -->
<s:submit name="widg_btnImpiantoSalva" id="widg_btnImpiantoSalva" method="handleBtnImpiantoSalva_CLICKED"
	key="cpGestImpianto.btnImpiantoSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnImpiantoSalva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestImpianto --></div>

			
	
	<div id="p_wpProprietario" class="widgetsPanelBlock"><!-- startFragment:p_wpProprietario -->
	
	
<h4 class="wpLabel">proprietario </h4>
<div class="widgetsPanel" id="wpProprietario">
	
	<customtag:widgetsPanel id="wpProprietarioTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocProprietario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocProprietario.label')}" labelFor="widg_tfImpLocProprietario" errorFor="appDataimpianto.proprietario.denomCompleta" labelId="tfImpLocProprietarioLbl"
	position="first"  >


<!-- widget tfImpLocProprietario -->
<s:textfield 
	
title=""	
	name="appDataimpianto.proprietario.denomCompleta" id="widg_tfImpLocProprietario"
maxlength="100"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocProprietario')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocPropDataInizio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocPropDataInizio.label')}" labelFor="widg_tfImpLocPropDataInizio" errorFor="appDataimpianto.proprietario.dataInizio" labelId="tfImpLocPropDataInizioLbl"
	position="last"  >


<!-- widget tfImpLocPropDataInizio -->
<s:textfield 
	
title=""	
	name="appDataimpianto.proprietario.dataInizio" id="widg_tfImpLocPropDataInizio"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocPropDataInizio')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','tfImpLocPropIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.tfImpLocPropIndirizzo.label')}" labelFor="widg_tfImpLocPropIndirizzo" errorFor="appDataimpianto.proprietario.indirizzo" labelId="tfImpLocPropIndirizzoLbl"
	position="first"  >


<!-- widget tfImpLocPropIndirizzo -->
<s:textfield 
	
	
	name="appDataimpianto.proprietario.indirizzo" id="widg_tfImpLocPropIndirizzo"
maxlength="10"	disabled="isWidgetDisabled('cpGestImpianto','tfImpLocPropIndirizzo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestImpianto','cImpDataCessazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestImpianto.cImpDataCessazione.label')}" labelFor="widg_cImpDataCessazione" errorFor="appDataimpianto.proprietario.dataFine" labelId="cImpDataCessazioneLbl"
	position="last"  >


<!-- widget cImpDataCessazione -->
<s:textfield 
	
	
	name="appDataimpianto.proprietario.dataFine" id="widg_cImpDataCessazione"
	disabled="isWidgetDisabled('cpGestImpianto','cImpDataCessazione')"
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
		
<s:if test="isWidgetVisible('cpGestImpianto','btnConfermaProp')" >

	



<!-- widget btnConfermaProp -->
<s:submit name="widg_btnConfermaProp" id="widg_btnConfermaProp" method="handleBtnConfermaProp_CLICKED"
	key="cpGestImpianto.btnConfermaProp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnConfermaProp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpianto','btnModificaProp')" >

	



<!-- widget btnModificaProp -->
<s:submit name="widg_btnModificaProp" id="widg_btnModificaProp" method="handleBtnModificaProp_CLICKED"
	key="cpGestImpianto.btnModificaProp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnModificaProp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpianto','btnCessaProp')" >

	



<!-- widget btnCessaProp -->
<s:submit name="widg_btnCessaProp" id="widg_btnCessaProp" method="handleBtnCessaProp_CLICKED"
	key="cpGestImpianto.btnCessaProp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnCessaProp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunProprietario --></div>

			
	
	<div id="p_wpResponsabili" class="widgetsPanelBlock"><!-- startFragment:p_wpResponsabili -->
	
	
<h4 class="wpLabel">elenco responsabili </h4>
<div class="widgetsPanel" id="wpResponsabili">
	

	
	
<s:if test="isWidgetVisible('cpGestImpianto','tbResponsabili')" >

	
<div class="tableWidget">


<!-- widget tbResponsabili -->
	<csiuicore:ajaxify id="p_wpResponsabili" 
		widgetType="table"		
		pageId="cpGestImpianto"
		javascriptDetection="false">
<s:set name="cpGestImpianto_tbResponsabili_clearStatus" value="isTableClearStatus('cpGestImpianto_tbResponsabili')" />
<s:url id="cpGestImpiantoViewUrl"						   
					   action="cpGestImpianto"
					   namespace="/base/gestisci_impianto"/>
<display:table name="appDataelencoResponsabili"  				
			   excludedParams="*"			   export="false"
               id="widg_tbResponsabili"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestImpiantoViewUrl}"  
               clearStatus="${cpGestImpianto_tbResponsabili_clearStatus}"
               uid="row_tbResponsabili"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbResponsabili.idImpResp}" name="appDataidResponsabileSelez" id="%{'tbResponsabili-editcell-'+ (#attr.row_tbResponsabili_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="denominazione" titleKey="cpGestImpianto.tbResponsabili.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descTitolo" titleKey="cpGestImpianto.tbResponsabili.descTitolo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataRespDal" titleKey="cpGestImpianto.tbResponsabili.dataRespDal.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataRespAl" titleKey="cpGestImpianto.tbResponsabili.dataRespAl.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpResponsabili --></div>

			
	
	<div id="p_cpFunResponsabile" class="commandPanelBlock"><!-- startFragment:p_cpFunResponsabile -->
	
	
<div class="commandPanel functional" id="cpFunResponsabile">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpianto','btnRespInserisci')" >

	



<!-- widget btnRespInserisci -->
<s:submit name="widg_btnRespInserisci" id="widg_btnRespInserisci" method="handleBtnRespInserisci_CLICKED"
	key="cpGestImpianto.btnRespInserisci.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespInserisci')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpianto','btnRespModifica')" >

	



<!-- widget btnRespModifica -->
<s:submit name="widg_btnRespModifica" id="widg_btnRespModifica" method="handleBtnRespModifica_CLICKED"
	key="cpGestImpianto.btnRespModifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnRespModifica')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunResponsabile --></div>

			
	
	
	<div id="p_mpImportLibretto" class="panelBlock"><!-- startFragment:p_mpImportLibretto -->
		

		
<s:if test="#session.cpGestImpianto_mpImportLibretto_selectedMultiPanel == 'cpGestImpianto_mpImportLibretto_FunImportLibretto'">
	<s:include value="/jsp/multipanels/cpGestImpianto_mpImportLibretto_FunImportLibretto.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpImportLibretto --></div>

			
	
	<div id="p_cpFunLibretto" class="commandPanelBlock"><!-- startFragment:p_cpFunLibretto -->
	
	
<div class="commandPanel functional" id="cpFunLibretto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpianto','btnLibVisualizza')" >

	



<!-- widget btnLibVisualizza -->
<s:submit name="widg_btnLibVisualizza" id="widg_btnLibVisualizza" method="handleBtnLibVisualizza_CLICKED"
	key="cpGestImpianto.btnLibVisualizza.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestImpianto','btnLibVisualizza')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpianto','btnLibRappControllo')" >

	



<!-- widget btnLibRappControllo -->
<s:submit name="widg_btnLibRappControllo" id="widg_btnLibRappControllo" method="handleBtnLibRappControllo_CLICKED"
	key="cpGestImpianto.btnLibRappControllo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnLibRappControllo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpianto','btnLibDocumentazione')" >

	



<!-- widget btnLibDocumentazione -->
<s:submit name="widg_btnLibDocumentazione" id="widg_btnLibDocumentazione" method="handleBtnLibDocumentazione_CLICKED"
	key="cpGestImpianto.btnLibDocumentazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnLibDocumentazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpianto','btnVisLibrettoWeb')" >

	



<!-- widget btnVisLibrettoWeb -->
<s:submit name="widg_btnVisLibrettoWeb" id="widg_btnVisLibrettoWeb" method="handleBtnVisLibrettoWeb_CLICKED"
	key="cpGestImpianto.btnVisLibrettoWeb.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnVisLibrettoWeb')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestImpianto','btnLibAggiornamenti')" >

	



<!-- widget btnLibAggiornamenti -->
<s:submit name="widg_btnLibAggiornamenti" id="widg_btnLibAggiornamenti" method="handleBtnLibAggiornamenti_CLICKED"
	key="cpGestImpianto.btnLibAggiornamenti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnLibAggiornamenti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunLibretto --></div>

			
	
	<div id="p_cpNavImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestImpianto','btnImpIndietro')" >

	



<!-- widget btnImpIndietro -->
<s:submit name="widg_btnImpIndietro" id="widg_btnImpIndietro" method="handleBtnImpIndietro_CLICKED"
	key="cpGestImpianto.btnImpIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestImpianto','btnImpIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavImpianto --></div>

	

		
	

	<!-- endFragment:p_fpGestImpianto --></div>

	

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
