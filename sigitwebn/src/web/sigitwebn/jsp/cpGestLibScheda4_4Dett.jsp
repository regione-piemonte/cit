<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda4_4/CpGestLibScheda4_4DettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda4_4 -->
<!-- pageId:cpGestLibScheda4_4Dett -->

<s:form id="cpGestLibScheda4_4Dett" action="cpGestLibScheda4_4Dett" namespace="/base/gestisci_libretto_scheda4_4" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda4_4Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda4_4Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda4_4Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda4_4/cpGestLibScheda4_4Dett!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda4_4"
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

	
	

	
	
			
	
	<div id="p_fpTitolo" class="formPanelBlock"><!-- startFragment:p_fpTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda4_4Dett.fpTitolo.label" /></h4>
<div class="formPanel" id="fpTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitolo --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpComponente" class="widgetsPanelBlock"><!-- startFragment:p_wpComponente -->
	
	

<div class="widgetsPanel" id="wpComponente">
	
	<customtag:widgetsPanel id="wpComponenteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','ptGruppoFrigo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.ptGruppoFrigo.label')}" labelFor="widg_ptGruppoFrigo" errorFor="appDatacomponenteGF.componente" labelId="ptGruppoFrigoLbl"   >


<!-- widget ptGruppoFrigo -->
<s:property value="appDatacomponenteGF.componente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','cDataInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.cDataInstallazione.label')}" labelFor="widg_cDataInstallazione" errorFor="appDatacomponenteGF.dataInstallazione" labelId="cDataInstallazioneLbl"
	  fieldRequired="true">


<!-- widget cDataInstallazione -->
<s:textfield 
	
	
	name="appDatacomponenteGF.dataInstallazione" id="widg_cDataInstallazione"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','cDataInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','cDataDismissione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.cDataDismissione.label')}" labelFor="widg_cDataDismissione" errorFor="appDatacomponenteGF.dataDismissione" labelId="cDataDismissioneLbl"
	  >


<!-- widget cDataDismissione -->
<s:textfield 
	
	
	name="appDatacomponenteGF.dataDismissione" id="widg_cDataDismissione"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','cDataDismissione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','cbFabbricante')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.cbFabbricante.label')}" labelFor="widg_cbFabbricante" errorFor="appDatacomponenteGF.fabbricante" labelId="cbFabbricanteLbl"
	  fieldRequired="true">


<!-- widget cbFabbricante -->
<s:select name="appDatacomponenteGF.fabbricante" id="widg_cbFabbricante"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFabbricante"
	  disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','cbFabbricante')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfModello')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfModello.label')}" labelFor="widg_tfModello" errorFor="appDatacomponenteGF.modello" labelId="tfModelloLbl"
	  fieldRequired="true">


<!-- widget tfModello -->
<s:textfield 
	
	
	name="appDatacomponenteGF.modello" id="widg_tfModello"
maxlength="33"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfModello')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfMatricola.label')}" labelFor="widg_tfMatricola" errorFor="appDatacomponenteGF.matricola" labelId="tfMatricolaLbl"
	  fieldRequired="true">


<!-- widget tfMatricola -->
<s:textfield 
	
	
	name="appDatacomponenteGF.matricola" id="widg_tfMatricola"
maxlength="30"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfMatricola')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfFluidoFrigorigeno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfFluidoFrigorigeno.label')}" labelFor="widg_tfFluidoFrigorigeno" errorFor="appDatacomponenteGF.fluidoFrigorigeno" labelId="tfFluidoFrigorigenoLbl"
	  fieldRequired="true">


<!-- widget tfFluidoFrigorigeno -->
<s:textfield 
	
	
	name="appDatacomponenteGF.fluidoFrigorigeno" id="widg_tfFluidoFrigorigeno"
maxlength="30"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfFluidoFrigorigeno')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','cbFonteEnergiaSfruttata')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.cbFonteEnergiaSfruttata.label')}" labelFor="widg_cbFonteEnergiaSfruttata" errorFor="appDatacomponenteGF.fonteEnergiaSfruttata" labelId="cbFonteEnergiaSfruttataLbl"
	  fieldRequired="true">


<!-- widget cbFonteEnergiaSfruttata -->
<s:select name="appDatacomponenteGF.fonteEnergiaSfruttata" id="widg_cbFonteEnergiaSfruttata"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFonteEnergiaSfruttata"
	  disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','cbFonteEnergiaSfruttata')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','cbFluidoLatoUtenze')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.cbFluidoLatoUtenze.label')}" labelFor="widg_cbFluidoLatoUtenze" errorFor="appDatacomponenteGF.fluidoLatoUtenze" labelId="cbFluidoLatoUtenzeLbl"
	  fieldRequired="true">


<!-- widget cbFluidoLatoUtenze -->
<s:select name="appDatacomponenteGF.fluidoLatoUtenze" id="widg_cbFluidoLatoUtenze"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSorgenteFluido"
	  disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','cbFluidoLatoUtenze')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','cbTipologia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.cbTipologia.label')}" labelFor="widg_cbTipologia" errorFor="appDatacomponenteGF.tipologia" labelId="cbTipologiaLbl"
	  fieldRequired="true">


<!-- widget cbTipologia -->
<s:select name="appDatacomponenteGF.tipologia" id="widg_cbTipologia"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoDettaglioGF"
	  disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','cbTipologia')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','cbCombustibile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.cbCombustibile.label')}" labelFor="widg_cbCombustibile" errorFor="appDatacomponenteGF.combustibile" labelId="cbCombustibileLbl"
	  >


<!-- widget cbCombustibile -->
<s:select name="appDatacomponenteGF.combustibile" id="widg_cbCombustibile"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoCombustibili"
	  disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','cbCombustibile')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfNumCircuiti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfNumCircuiti.label')}" labelFor="widg_tfNumCircuiti" errorFor="appDatacomponenteGF.numCircuiti" labelId="tfNumCircuitiLbl"
	  fieldRequired="true">


<!-- widget tfNumCircuiti -->
<s:textfield 
	
	
	name="appDatacomponenteGF.numCircuiti" id="widg_tfNumCircuiti"
maxlength="3"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfNumCircuiti')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfManutenzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfManutenzione.label')}" labelFor="widg_tfManutenzione" errorFor="appDatacomponenteGF.tempoManutenzione" labelId="tfManutenzioneLbl"
	  fieldRequired="true">


<!-- widget tfManutenzione -->
<s:textfield 
	
	
	name="appDatacomponenteGF.tempoManutenzione" id="widg_tfManutenzione"
maxlength="3"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfManutenzione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.taNote.label')}" labelFor="widg_taNote" errorFor="appDatacomponenteGF.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDatacomponenteGF.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','taNote')"
	rows="2"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpComponente --></div>

			
	
	<div id="p_wpRaffrescamentoRiscaldamento" class="widgetsPanelBlock"><!-- startFragment:p_wpRaffrescamentoRiscaldamento -->
	
	

<div class="widgetsPanel" id="wpRaffrescamentoRiscaldamento">
	
	<customtag:widgetsPanel id="wpRaffrescamentoRiscaldamentoTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		percentCols="20,0,10,10,20,10,20,10">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','ptRaffrescamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.ptRaffrescamento.label')}" labelFor="widg_ptRaffrescamento" errorFor="widg_ptRaffrescamento" labelId="ptRaffrescamentoLbl"  position="first" >


<!-- widget ptRaffrescamento -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfEer')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfEer.label')}" labelFor="widg_tfEer" errorFor="appDatacomponenteGF.eer" labelId="tfEerLbl"
	  >


<!-- widget tfEer -->
<s:textfield 
	
	
	name="appDatacomponenteGF.eer" id="widg_tfEer"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfEer')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfPotenzaFrigo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfPotenzaFrigo.label')}" labelFor="widg_tfPotenzaFrigo" errorFor="appDatacomponenteGF.raffPotenzaKw" labelId="tfPotenzaFrigoLbl"
	  fieldRequired="true">


<!-- widget tfPotenzaFrigo -->
<s:textfield 
	
	
	name="appDatacomponenteGF.raffPotenzaKw" id="widg_tfPotenzaFrigo"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfPotenzaFrigo')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfPotenzaAssNom')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfPotenzaAssNom.label')}" labelFor="widg_tfPotenzaAssNom" errorFor="appDatacomponenteGF.raffPotenzaAssorbita" labelId="tfPotenzaAssNomLbl"
	position="last"  >


<!-- widget tfPotenzaAssNom -->
<s:textfield 
	
	
	name="appDatacomponenteGF.raffPotenzaAssorbita" id="widg_tfPotenzaAssNom"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfPotenzaAssNom')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','ptRiscaldamento')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.ptRiscaldamento.label')}" labelFor="widg_ptRiscaldamento" errorFor="widg_ptRiscaldamento" labelId="ptRiscaldamentoLbl"  position="first" >


<!-- widget ptRiscaldamento -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfCop')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfCop.label')}" labelFor="widg_tfCop" errorFor="appDatacomponenteGF.cop" labelId="tfCopLbl"
	  >


<!-- widget tfCop -->
<s:textfield 
	
	
	name="appDatacomponenteGF.cop" id="widg_tfCop"
maxlength="10"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfCop')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfPotenzaRisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfPotenzaRisc.label')}" labelFor="widg_tfPotenzaRisc" errorFor="appDatacomponenteGF.riscPotenzaKw" labelId="tfPotenzaRiscLbl"
	  >


<!-- widget tfPotenzaRisc -->
<s:textfield 
	
	
	name="appDatacomponenteGF.riscPotenzaKw" id="widg_tfPotenzaRisc"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfPotenzaRisc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tfPotenzaAssRiscNom')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_4Dett.tfPotenzaAssRiscNom.label')}" labelFor="widg_tfPotenzaAssRiscNom" errorFor="appDatacomponenteGF.riscPotenzaAssorbita" labelId="tfPotenzaAssRiscNomLbl"
	position="last"  >


<!-- widget tfPotenzaAssRiscNom -->
<s:textfield 
	
	
	name="appDatacomponenteGF.riscPotenzaAssorbita" id="widg_tfPotenzaAssRiscNom"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','tfPotenzaAssRiscNom')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRaffrescamentoRiscaldamento --></div>

			
	
	<div id="p_cpFunGestComponente" class="commandPanelBlock"><!-- startFragment:p_cpFunGestComponente -->
	
	
<div class="commandPanel functional" id="cpFunGestComponente">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','bSostituisciComponente')" >

	



<!-- widget bSostituisciComponente -->
<s:submit name="widg_bSostituisciComponente" id="widg_bSostituisciComponente" method="handleBSostituisciComponente_CLICKED"
	key="cpGestLibScheda4_4Dett.bSostituisciComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','bSostituisciComponente')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','bDismettiComponente')" >

	



<!-- widget bDismettiComponente -->
<s:submit name="widg_bDismettiComponente" id="widg_bDismettiComponente" method="handleBDismettiComponente_CLICKED"
	key="cpGestLibScheda4_4Dett.bDismettiComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','bDismettiComponente')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','bRiattivaComponente')" >

	



<!-- widget bRiattivaComponente -->
<s:submit name="widg_bRiattivaComponente" id="widg_bRiattivaComponente" method="handleBRiattivaComponente_CLICKED"
	key="cpGestLibScheda4_4Dett.bRiattivaComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','bRiattivaComponente')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestComponente --></div>

			
	
	<div id="p_wpComponentiSostituite" class="widgetsPanelBlock"><!-- startFragment:p_wpComponentiSostituite -->
	
	

<div class="widgetsPanel" id="wpComponentiSostituite">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','tbSostituzioni')" >

	
<div class="tableWidget">


<!-- widget tbSostituzioni -->
<s:set name="cpGestLibScheda4_4Dett_tbSostituzioni_clearStatus" value="isTableClearStatus('cpGestLibScheda4_4Dett_tbSostituzioni')" />
<s:url id="cpGestLibScheda4_4DettViewUrl"						   
					   action="cpGestLibScheda4_4Dett"
					   namespace="/base/gestisci_libretto_scheda4_4"/>
<display:table name="appDatalistaStoricoComponentiGF"  				
			   excludedParams="*"			   export="true"
               id="widg_tbSostituzioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda4_4DettViewUrl}"  
               clearStatus="${cpGestLibScheda4_4Dett_tbSostituzioni_clearStatus}"
               uid="row_tbSostituzioni"
               summary="" 
               class="dataTable">
	
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.dataInstallazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.dataInstallazione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.dataInstallazione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.dataDismissione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.dataDismissione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.dataDismissione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.fabbricanteLabel.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.fabbricanteLabel.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.fabbricanteLabel.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="modello" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.modello.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="modello" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.modello.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="modello" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.modello.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="matricola" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.matricola.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="matricola" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.matricola.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="matricola" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.matricola.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.azione.label"
						sortable="false" headerClass="nosort" media="html"
>
				<s:if test="%{#attr.row_tbSostituzioni.flgRipristina == true}">
					<s:url id="targetUrlLinkableCell"						   
						   action="cpGestLibScheda4_4Dett!handleTbSostituzioni_CLICKED"
						   namespace="/base/gestisci_libretto_scheda4_4"
						   includeParams="none">
						<s:param name="idRiga"  value="%{#attr.row_tbSostituzioni.componente}"/>
						<s:param name="idColonna">azione</s:param>
					</s:url>
					<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
						<s:property value="%{#attr.row_tbSostituzioni.azione}"/>
					</s:a>
				</s:if>
				<s:else>
					<s:property value="%{#attr.row_tbSostituzioni.azione}"/>
				</s:else>
		</display:column>

		<display:column property="azione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.azione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="azione" titleKey="cpGestLibScheda4_4Dett.tbSostituzioni.azione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpComponentiSostituite --></div>

			
	
	<div id="p_cpNavGestComponente" class="commandPanelBlock"><!-- startFragment:p_cpNavGestComponente -->
	
	
<div class="commandPanel functional" id="cpNavGestComponente">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','btRipristinaAttualeDett')" >

	



<!-- widget btRipristinaAttualeDett -->
<s:submit name="widg_btRipristinaAttualeDett" id="widg_btRipristinaAttualeDett" method="handleBtRipristinaAttualeDett_CLICKED"
	key="cpGestLibScheda4_4Dett.btRipristinaAttualeDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','btRipristinaAttualeDett')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','btSalvaDett')" >

	



<!-- widget btSalvaDett -->
<s:submit name="widg_btSalvaDett" id="widg_btSalvaDett" method="handleBtSalvaDett_CLICKED"
	key="cpGestLibScheda4_4Dett.btSalvaDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','btSalvaDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestComponente --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_4Dett','btIndietroDett')" >

	



<!-- widget btIndietroDett -->
<s:submit name="widg_btIndietroDett" id="widg_btIndietroDett" method="handleBtIndietroDett_CLICKED"
	key="cpGestLibScheda4_4Dett.btIndietroDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_4Dett','btIndietroDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGest --></div>

	

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
