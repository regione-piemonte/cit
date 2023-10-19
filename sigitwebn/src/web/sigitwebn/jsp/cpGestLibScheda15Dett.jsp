<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda15/CpGestLibScheda15DettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda15 -->
<!-- pageId:cpGestLibScheda15Dett -->

<s:form id="cpGestLibScheda15Dett" action="cpGestLibScheda15Dett" namespace="/base/gestisci_libretto_scheda15" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda15Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_fpLeftMenu" class="formPanelBlock"><!-- startFragment:p_fpLeftMenu -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda15Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda15Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda15/cpGestLibScheda15Dett!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda15"
		showChildNumber="false">
	</customtag:tree>

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMenuTree --></div>

	

	<!-- endFragment:p_fpLeftMenu --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpScheda15" class="formPanelBlock"><!-- startFragment:p_fpScheda15 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda15Dett.fpScheda15.label" /></h4>
<div class="formPanel" id="fpScheda15">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda15 --></div>

			
	
	<div id="p_stdMsgLibretto" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgLibretto -->
	
	
<div class="stdMessagePanel" id="stdMsgLibretto">
	<customtag:stdMessagePanel id="stdMsgLibretto" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgLibretto --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptManutentore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptManutentore.label')}" labelFor="widg_ptManutentore" errorFor="appDatadettaglioManutenzione.descManutentore" labelId="ptManutentoreLbl"  position="last" >


<!-- widget ptManutentore -->
<s:property value="appDatadettaglioManutenzione.descManutentore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpScheda15Dett" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda15Dett -->
	
	
<h4 class="wpLabel">dettaglio manutenzione </h4>
<div class="widgetsPanel" id="wpScheda15Dett">
	
	<customtag:widgetsPanel id="wpScheda15DettTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptStatoManut')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptStatoManut.label')}" labelFor="widg_ptStatoManut" errorFor="appDatadettaglioManutenzione.descStatoManut" labelId="ptStatoManutLbl"   >


<!-- widget ptStatoManut -->
<s:property value="appDatadettaglioManutenzione.descStatoManut" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','calDataManut')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.calDataManut.label')}" labelFor="widg_calDataManut" errorFor="appDatadettaglioManutenzione.dataManut" labelId="calDataManutLbl"
	  >


<!-- widget calDataManut -->
<s:textfield 
	
	
	name="appDatadettaglioManutenzione.dataManut" id="widg_calDataManut"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','calDataManut')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','cbTipoManut')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.cbTipoManut.label')}" labelFor="widg_cbTipoManut" errorFor="appDatadettaglioManutenzione.idTipoManut" labelId="cbTipoManutLbl"
	  >


<!-- widget cbTipoManut -->
<s:select name="appDatadettaglioManutenzione.idTipoManut" id="widg_cbTipoManut"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoManutenzione"
	  disabled="isWidgetDisabled('cpGestLibScheda15Dett','cbTipoManut')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptTipoManut')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptTipoManut.label')}" labelFor="widg_ptTipoManut" errorFor="appDatadettaglioManutenzione.descTipoManut" labelId="ptTipoManutLbl"   >


<!-- widget ptTipoManut -->
<s:property value="appDatadettaglioManutenzione.descTipoManut" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnCercaApparecchiature')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCercaApparecchiature -->
<s:submit name="widg_btnCercaApparecchiature" id="widg_btnCercaApparecchiature" method="handleBtnCercaApparecchiature_CLICKED"
	key="cpGestLibScheda15Dett.btnCercaApparecchiature.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnCercaApparecchiature')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnNuovaRicercaApparecchiature')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnNuovaRicercaApparecchiature -->
<s:submit name="widg_btnNuovaRicercaApparecchiature" id="widg_btnNuovaRicercaApparecchiature" method="handleBtnNuovaRicercaApparecchiature_CLICKED"
	key="cpGestLibScheda15Dett.btnNuovaRicercaApparecchiature.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnNuovaRicercaApparecchiature')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','cbApparecchiature')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.cbApparecchiature.label')}" labelFor="widg_cbApparecchiature" errorFor="appDatadettaglioManutenzione.idApparecchiature" labelId="cbApparecchiatureLbl"
	  >


<!-- widget cbApparecchiature -->
<s:select name="appDatadettaglioManutenzione.idApparecchiature" id="widg_cbApparecchiature"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoApparecchiatureManut"
	  disabled="isWidgetDisabled('cpGestLibScheda15Dett','cbApparecchiature')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="5"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptApparecchiature')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptApparecchiature.label')}" labelFor="widg_ptApparecchiature" errorFor="appDatadettaglioManutenzione.elencoApparecchiature" labelId="ptApparecchiatureLbl"   >


<!-- widget ptApparecchiature -->
<s:property value="appDatadettaglioManutenzione.elencoApparecchiature" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnVerificaApparecchiature')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnVerificaApparecchiature -->
<s:submit name="widg_btnVerificaApparecchiature" id="widg_btnVerificaApparecchiature" method="handleBtnVerificaApparecchiature_CLICKED"
	key="cpGestLibScheda15Dett.btnVerificaApparecchiature.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnVerificaApparecchiature')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','cbTipoIntervento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.cbTipoIntervento.label')}" labelFor="widg_cbTipoIntervento" errorFor="appDatadettaglioManutenzione.idTipoIntervento" labelId="cbTipoInterventoLbl"
	  >


<!-- widget cbTipoIntervento -->
	<csiuicore:ajaxify id="p_wpScheda15Dett" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_libretto_scheda15/cpGestLibScheda15Dett!handleCbTipoIntervento_VALUE_CHANGED.do"
		pageId="cpGestLibScheda15Dett"
		formName="cpGestLibScheda15Dett"
		javascriptDetection="false"
		nameSpace="/base/gestisci_libretto_scheda15">

<s:url id="widg_cbTipoInterventourlComboBoxValueChange"
   action="/sigitwebn/cpGestLibScheda15Dett!handleCbTipoIntervento_VALUE_CHANGED" namespace="/base/gestisci_libretto_scheda15"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatadettaglioManutenzione.idTipoIntervento" id="widg_cbTipoIntervento"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoIntervento"
	  disabled="isWidgetDisabled('cpGestLibScheda15Dett','cbTipoIntervento')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbTipoIntervento','conferma','%{widg_cbTipoInterventourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoIntervento','conferma','%{widg_cbTipoInterventourlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','ptTipoIntervento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.ptTipoIntervento.label')}" labelFor="widg_ptTipoIntervento" errorFor="appDatadettaglioManutenzione.descTipoIntervento" labelId="ptTipoInterventoLbl"   >


<!-- widget ptTipoIntervento -->
<s:property value="appDatadettaglioManutenzione.descTipoIntervento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','tfAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.tfAltro.label')}" labelFor="widg_tfAltro" errorFor="appDatadettaglioManutenzione.altro" labelId="tfAltroLbl"
	  >


<!-- widget tfAltro -->
<s:textfield 
	
	
	name="appDatadettaglioManutenzione.altro" id="widg_tfAltro"
maxlength="50"	disabled="isWidgetDisabled('cpGestLibScheda15Dett','tfAltro')"
	size="25" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','tfOraArrivo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.tfOraArrivo.label')}" labelFor="widg_tfOraArrivo" errorFor="appDatadettaglioManutenzione.oraArrivo" labelId="tfOraArrivoLbl"
	  >


<!-- widget tfOraArrivo -->
<s:textfield 
	
	
	name="appDatadettaglioManutenzione.oraArrivo" id="widg_tfOraArrivo"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda15Dett','tfOraArrivo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','tfOraPart')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.tfOraPart.label')}" labelFor="widg_tfOraPart" errorFor="appDatadettaglioManutenzione.oraPartenza" labelId="tfOraPartLbl"
	  >


<!-- widget tfOraPart -->
<s:textfield 
	
	
	name="appDatadettaglioManutenzione.oraPartenza" id="widg_tfOraPart"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda15Dett','tfOraPart')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','tfTec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.tfTec.label')}" labelFor="widg_tfTec" errorFor="appDatadettaglioManutenzione.denominazTecnico" labelId="tfTecLbl"
	  >


<!-- widget tfTec -->
<s:textfield 
	
	
	name="appDatadettaglioManutenzione.denominazTecnico" id="widg_tfTec"
maxlength="100"	disabled="isWidgetDisabled('cpGestLibScheda15Dett','tfTec')"
	size="60" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','taOss')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.taOss.label')}" labelFor="widg_taOss" errorFor="appDatadettaglioManutenzione.osservazioni" labelId="taOssLbl"
	  >


<!-- widget taOss -->
<s:textarea 
	
	
	name="appDatadettaglioManutenzione.osservazioni" id="widg_taOss"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','taOss')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','taRacc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.taRacc.label')}" labelFor="widg_taRacc" errorFor="appDatadettaglioManutenzione.raccomandazioni" labelId="taRaccLbl"
	  >


<!-- widget taRacc -->
<s:textarea 
	
	
	name="appDatadettaglioManutenzione.raccomandazioni" id="widg_taRacc"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','taRacc')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','taPre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.taPre.label')}" labelFor="widg_taPre" errorFor="appDatadettaglioManutenzione.prescrizioni" labelId="taPreLbl"
	  >


<!-- widget taPre -->
<s:textarea 
	
	
	name="appDatadettaglioManutenzione.prescrizioni" id="widg_taPre"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','taPre')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','cIntEntro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda15Dett.cIntEntro.label')}" labelFor="widg_cIntEntro" errorFor="appDatadettaglioManutenzione.interventoEntro" labelId="cIntEntroLbl"
	  >


<!-- widget cIntEntro -->
<s:textfield 
	
	
	name="appDatadettaglioManutenzione.interventoEntro" id="widg_cIntEntro"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','cIntEntro')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda15Dett --></div>

			
	
	<div id="p_cpFunGest" class="commandPanelBlock"><!-- startFragment:p_cpFunGest -->
	
	
<div class="commandPanel functional" id="cpFunGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','bSalvaManut')" >

	



<!-- widget bSalvaManut -->
<s:submit name="widg_bSalvaManut" id="widg_bSalvaManut" method="handleBSalvaManut_CLICKED"
	key="cpGestLibScheda15Dett.bSalvaManut.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','bSalvaManut')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	
	<div id="p_mpElencoDocumenti" class="panelBlock"><!-- startFragment:p_mpElencoDocumenti -->
		

		
<s:if test="#session.cpGestLibScheda15Dett_mpElencoDocumenti_selectedMultiPanel == 'cpGestLibScheda15Dett_mpElencoDocumenti_fpElencoDocumenti'">
	<s:include value="/jsp/multipanels/cpGestLibScheda15Dett_mpElencoDocumenti_fpElencoDocumenti.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElencoDocumenti --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda15Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda15Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda15Dett','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGest --></div>

			
	
	
	<div id="p_mpDatiDocumento" class="panelBlock"><!-- startFragment:p_mpDatiDocumento -->
		

		
<s:if test="#session.cpGestLibScheda15Dett_mpDatiDocumento_selectedMultiPanel == 'cpGestLibScheda15Dett_mpDatiDocumento_fpDatiDocumento'">
	<s:include value="/jsp/multipanels/cpGestLibScheda15Dett_mpDatiDocumento_fpDatiDocumento.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiDocumento --></div>

	

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
