<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo4 -->
<!-- pageId:cpGestReeTipo4Dett -->

<s:form id="cpGestReeTipo4Dett" action="cpGestReeTipo4Dett" namespace="/base/gestisci_ree_tipo4" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo4Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo4Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo4Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo4/cpGestReeTipo4Dett!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_tipo4"
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

	
	

	
	
			
	
	<div id="p_fpGestRee" class="formPanelBlock"><!-- startFragment:p_fpGestRee -->
		
	
<h4 class="fpLabel"><s:text name="cpGestReeTipo4Dett.fpGestRee.label" /></h4>
<div class="formPanel" id="fpGestRee">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestRee --></div>

			
	
	<div id="p_stdMsgReeDett" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgReeDett -->
	
	
<div class="stdMessagePanel" id="stdMsgReeDett">
	<customtag:stdMessagePanel id="stdMsgReeDett" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgReeDett --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	

<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


<!-- widget ptBollino -->
<s:property value="appDataallegato.codiceBollino" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpE" class="widgetsPanelBlock"><!-- startFragment:p_wpE -->
	
	
<h4 class="wpLabel">E. controllo e verifica energetica del gruppo termico </h4>
<div class="widgetsPanel" id="wpE">
	
	<customtag:widgetsPanel id="wpETbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptComponente')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptComponente.label')}" labelFor="widg_ptComponente" errorFor="appDatareeTipo4Dett.descComponente" labelId="ptComponenteLbl"   >


<!-- widget ptComponente -->
<s:property value="appDatareeTipo4Dett.descComponente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptFabb')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptFabb.label')}" labelFor="widg_ptFabb" errorFor="appDatareeTipo4Dett.marca" labelId="ptFabbLbl"   >


<!-- widget ptFabb -->
<s:property value="appDatareeTipo4Dett.marca" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptModello')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptModello.label')}" labelFor="widg_ptModello" errorFor="appDatareeTipo4Dett.modello" labelId="ptModelloLbl"   >


<!-- widget ptModello -->
<s:property value="appDatareeTipo4Dett.modello" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptMatricola')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptMatricola.label')}" labelFor="widg_ptMatricola" errorFor="appDatareeTipo4Dett.matricola" labelId="ptMatricolaLbl"   >


<!-- widget ptMatricola -->
<s:property value="appDatareeTipo4Dett.matricola" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptTipologia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptTipologia.label')}" labelFor="widg_ptTipologia" errorFor="appDatareeTipo4Dett.tipologia" labelId="ptTipologiaLbl"   >


<!-- widget ptTipologia -->
<s:property value="appDatareeTipo4Dett.tipologia" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptAlimentazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptAlimentazione.label')}" labelFor="widg_ptAlimentazione" errorFor="appDatareeTipo4Dett.alimentazione" labelId="ptAlimentazioneLbl"   >


<!-- widget ptAlimentazione -->
<s:property value="appDatareeTipo4Dett.alimentazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','cbFluido')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.cbFluido.label')}" labelFor="widg_cbFluido" errorFor="appDatareeTipo4Dett.idFluido" labelId="cbFluidoLbl"
	  fieldRequired="true">


<!-- widget cbFluido -->
<s:select name="appDatareeTipo4Dett.idFluido" id="widg_cbFluido"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFluido"
	  disabled="isWidgetDisabled('cpGestReeTipo4Dett','cbFluido')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptPotUtile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptPotUtile.label')}" labelFor="widg_ptPotUtile" errorFor="appDatareeTipo4Dett.potenzaElettricaKw" labelId="ptPotUtileLbl"   >


<!-- widget ptPotUtile -->
<s:property value="appDatareeTipo4Dett.potenzaElettricaKw" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfPotAssorbCombKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfPotAssorbCombKw.label')}" labelFor="widg_tfPotAssorbCombKw" errorFor="appDatareeTipo4Dett.potenzaAssorbCombKw" labelId="tfPotAssorbCombKwLbl"
	  >


<!-- widget tfPotAssorbCombKw -->
<s:textfield 
	
title=""	
	name="appDatareeTipo4Dett.potenzaAssorbCombKw" id="widg_tfPotAssorbCombKw"
maxlength="9"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfPotAssorbCombKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptPotTermicaKw')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptPotTermicaKw.label')}" labelFor="widg_ptPotTermicaKw" errorFor="appDatareeTipo4Dett.potenzaTermicaKw" labelId="ptPotTermicaKwLbl"   >


<!-- widget ptPotTermicaKw -->
<s:property value="appDatareeTipo4Dett.potenzaTermicaKw" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfPotTermBypassKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfPotTermBypassKw.label')}" labelFor="widg_tfPotTermBypassKw" errorFor="appDatareeTipo4Dett.potenzaTermBypassKw" labelId="tfPotTermBypassKwLbl"
	  >


<!-- widget tfPotTermBypassKw -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.potenzaTermBypassKw" id="widg_tfPotTermBypassKw"
maxlength="9"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfPotTermBypassKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','ptCoMed')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.ptCoMed.label')}" labelFor="widg_ptCoMed" errorFor="appDatareeTipo4Dett.coMedio" labelId="ptCoMedLbl"   >


<!-- widget ptCoMed -->
<s:property value="appDatareeTipo4Dett.coMedio" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpE --></div>

			
	
	<div id="p_wpModulo" class="widgetsPanelBlock"><!-- startFragment:p_wpModulo -->
	
	
<h4 class="wpLabel">compila modulo </h4>
<div class="widgetsPanel" id="wpModulo">
	
	<customtag:widgetsPanel id="wpModuloTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfTempAriaC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfTempAriaC.label')}" labelFor="widg_tfTempAriaC" errorFor="appDatareeTipo4Dett.tempAriaC" labelId="tfTempAriaCLbl"
	  >


<!-- widget tfTempAriaC -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.tempAriaC" id="widg_tfTempAriaC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfTempAriaC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfTempH2oOutC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfTempH2oOutC.label')}" labelFor="widg_tfTempH2oOutC" errorFor="appDatareeTipo4Dett.tempH2oOutC" labelId="tfTempH2oOutCLbl"
	  >


<!-- widget tfTempH2oOutC -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.tempH2oOutC" id="widg_tfTempH2oOutC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfTempH2oOutC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfTempH2oInC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfTempH2oInC.label')}" labelFor="widg_tfTempH2oInC" errorFor="appDatareeTipo4Dett.tempH2oInC" labelId="tfTempH2oInCLbl"
	  >


<!-- widget tfTempH2oInC -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.tempH2oInC" id="widg_tfTempH2oInC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfTempH2oInC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfPotenzaMorsettiKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfPotenzaMorsettiKw.label')}" labelFor="widg_tfPotenzaMorsettiKw" errorFor="appDatareeTipo4Dett.potenzaMorsettiKw" labelId="tfPotenzaMorsettiKwLbl"
	  >


<!-- widget tfPotenzaMorsettiKw -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.potenzaMorsettiKw" id="widg_tfPotenzaMorsettiKw"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfPotenzaMorsettiKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfTempH2oMotoreC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfTempH2oMotoreC.label')}" labelFor="widg_tfTempH2oMotoreC" errorFor="appDatareeTipo4Dett.tempH2oMotoreC" labelId="tfTempH2oMotoreCLbl"
	  >


<!-- widget tfTempH2oMotoreC -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.tempH2oMotoreC" id="widg_tfTempH2oMotoreC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfTempH2oMotoreC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfTempFumiValleC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfTempFumiValleC.label')}" labelFor="widg_tfTempFumiValleC" errorFor="appDatareeTipo4Dett.tempFumiValleC" labelId="tfTempFumiValleCLbl"
	  >


<!-- widget tfTempFumiValleC -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.tempFumiValleC" id="widg_tfTempFumiValleC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfTempFumiValleC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfTempFumiMonteC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfTempFumiMonteC.label')}" labelFor="widg_tfTempFumiMonteC" errorFor="appDatareeTipo4Dett.tempFumiMonteC" labelId="tfTempFumiMonteCLbl"
	  >


<!-- widget tfTempFumiMonteC -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.tempFumiMonteC" id="widg_tfTempFumiMonteC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfTempFumiMonteC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovrafreqSogliaHzMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovrafreqSogliaHzMin.label')}" labelFor="widg_tfSovrafreqSogliaHzMin" errorFor="appDatareeTipo4Dett.sovrafreqSogliaHzMin" labelId="tfSovrafreqSogliaHzMinLbl"
	  >


<!-- widget tfSovrafreqSogliaHzMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovrafreqSogliaHzMin" id="widg_tfSovrafreqSogliaHzMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovrafreqSogliaHzMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovrafreqSogliaHzMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovrafreqSogliaHzMed.label')}" labelFor="widg_tfSovrafreqSogliaHzMed" errorFor="appDatareeTipo4Dett.sovrafreqSogliaHzMed" labelId="tfSovrafreqSogliaHzMedLbl"
	  >


<!-- widget tfSovrafreqSogliaHzMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovrafreqSogliaHzMed" id="widg_tfSovrafreqSogliaHzMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovrafreqSogliaHzMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovrafreqSogliaHzMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovrafreqSogliaHzMax.label')}" labelFor="widg_tfSovrafreqSogliaHzMax" errorFor="appDatareeTipo4Dett.sovrafreqSogliaHzMax" labelId="tfSovrafreqSogliaHzMaxLbl"
	  >


<!-- widget tfSovrafreqSogliaHzMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovrafreqSogliaHzMax" id="widg_tfSovrafreqSogliaHzMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovrafreqSogliaHzMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovrafreqTempoSMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovrafreqTempoSMin.label')}" labelFor="widg_tfSovrafreqTempoSMin" errorFor="appDatareeTipo4Dett.sovrafreqTempoSMin" labelId="tfSovrafreqTempoSMinLbl"
	  >


<!-- widget tfSovrafreqTempoSMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovrafreqTempoSMin" id="widg_tfSovrafreqTempoSMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovrafreqTempoSMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovrafreqTempoSMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovrafreqTempoSMed.label')}" labelFor="widg_tfSovrafreqTempoSMed" errorFor="appDatareeTipo4Dett.sovrafreqTempoSMed" labelId="tfSovrafreqTempoSMedLbl"
	  >


<!-- widget tfSovrafreqTempoSMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovrafreqTempoSMed" id="widg_tfSovrafreqTempoSMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovrafreqTempoSMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovrafreqTempoSMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovrafreqTempoSMax.label')}" labelFor="widg_tfSovrafreqTempoSMax" errorFor="appDatareeTipo4Dett.sovrafreqTempoSMax" labelId="tfSovrafreqTempoSMaxLbl"
	  >


<!-- widget tfSovrafreqTempoSMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovrafreqTempoSMax" id="widg_tfSovrafreqTempoSMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovrafreqTempoSMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottofreqSogliaHzMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottofreqSogliaHzMin.label')}" labelFor="widg_tfSottofreqSogliaHzMin" errorFor="appDatareeTipo4Dett.sottofreqSogliaHzMin" labelId="tfSottofreqSogliaHzMinLbl"
	  >


<!-- widget tfSottofreqSogliaHzMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottofreqSogliaHzMin" id="widg_tfSottofreqSogliaHzMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottofreqSogliaHzMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottofreqSogliaHzMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottofreqSogliaHzMed.label')}" labelFor="widg_tfSottofreqSogliaHzMed" errorFor="appDatareeTipo4Dett.sottofreqSogliaHzMed" labelId="tfSottofreqSogliaHzMedLbl"
	  >


<!-- widget tfSottofreqSogliaHzMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottofreqSogliaHzMed" id="widg_tfSottofreqSogliaHzMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottofreqSogliaHzMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottofreqSogliaHzMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottofreqSogliaHzMax.label')}" labelFor="widg_tfSottofreqSogliaHzMax" errorFor="appDatareeTipo4Dett.sottofreqSogliaHzMax" labelId="tfSottofreqSogliaHzMaxLbl"
	  >


<!-- widget tfSottofreqSogliaHzMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottofreqSogliaHzMax" id="widg_tfSottofreqSogliaHzMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottofreqSogliaHzMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottofreqTempoSMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottofreqTempoSMin.label')}" labelFor="widg_tfSottofreqTempoSMin" errorFor="appDatareeTipo4Dett.sottofreqTempoSMin" labelId="tfSottofreqTempoSMinLbl"
	  >


<!-- widget tfSottofreqTempoSMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottofreqTempoSMin" id="widg_tfSottofreqTempoSMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottofreqTempoSMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottofreqTempoSMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottofreqTempoSMed.label')}" labelFor="widg_tfSottofreqTempoSMed" errorFor="appDatareeTipo4Dett.sottofreqTempoSMed" labelId="tfSottofreqTempoSMedLbl"
	  >


<!-- widget tfSottofreqTempoSMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottofreqTempoSMed" id="widg_tfSottofreqTempoSMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottofreqTempoSMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottofreqTempoSMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottofreqTempoSMax.label')}" labelFor="widg_tfSottofreqTempoSMax" errorFor="appDatareeTipo4Dett.sottofreqTempoSMax" labelId="tfSottofreqTempoSMaxLbl"
	  >


<!-- widget tfSottofreqTempoSMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottofreqTempoSMax" id="widg_tfSottofreqTempoSMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottofreqTempoSMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovratensSogliaVMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovratensSogliaVMin.label')}" labelFor="widg_tfSovratensSogliaVMin" errorFor="appDatareeTipo4Dett.sovratensSogliaVMin" labelId="tfSovratensSogliaVMinLbl"
	  >


<!-- widget tfSovratensSogliaVMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovratensSogliaVMin" id="widg_tfSovratensSogliaVMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovratensSogliaVMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovratensSogliaVMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovratensSogliaVMed.label')}" labelFor="widg_tfSovratensSogliaVMed" errorFor="appDatareeTipo4Dett.sovratensSogliaVMed" labelId="tfSovratensSogliaVMedLbl"
	  >


<!-- widget tfSovratensSogliaVMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovratensSogliaVMed" id="widg_tfSovratensSogliaVMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovratensSogliaVMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovratensSogliaVMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovratensSogliaVMax.label')}" labelFor="widg_tfSovratensSogliaVMax" errorFor="appDatareeTipo4Dett.sovratensSogliaVMax" labelId="tfSovratensSogliaVMaxLbl"
	  >


<!-- widget tfSovratensSogliaVMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovratensSogliaVMax" id="widg_tfSovratensSogliaVMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovratensSogliaVMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovratensTempoSMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovratensTempoSMin.label')}" labelFor="widg_tfSovratensTempoSMin" errorFor="appDatareeTipo4Dett.sovratensTempoSMin" labelId="tfSovratensTempoSMinLbl"
	  >


<!-- widget tfSovratensTempoSMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovratensTempoSMin" id="widg_tfSovratensTempoSMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovratensTempoSMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovratensTempoSMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovratensTempoSMed.label')}" labelFor="widg_tfSovratensTempoSMed" errorFor="appDatareeTipo4Dett.sovratensTempoSMed" labelId="tfSovratensTempoSMedLbl"
	  >


<!-- widget tfSovratensTempoSMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovratensTempoSMed" id="widg_tfSovratensTempoSMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovratensTempoSMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSovratensTempoSMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSovratensTempoSMax.label')}" labelFor="widg_tfSovratensTempoSMax" errorFor="appDatareeTipo4Dett.sovratensTempoSMax" labelId="tfSovratensTempoSMaxLbl"
	  >


<!-- widget tfSovratensTempoSMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sovratensTempoSMax" id="widg_tfSovratensTempoSMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSovratensTempoSMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottotensSogliaVMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottotensSogliaVMin.label')}" labelFor="widg_tfSottotensSogliaVMin" errorFor="appDatareeTipo4Dett.sottotensSogliaVMin" labelId="tfSottotensSogliaVMinLbl"
	  >


<!-- widget tfSottotensSogliaVMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottotensSogliaVMin" id="widg_tfSottotensSogliaVMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottotensSogliaVMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottotensSogliaVMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottotensSogliaVMed.label')}" labelFor="widg_tfSottotensSogliaVMed" errorFor="appDatareeTipo4Dett.sottotensSogliaVMed" labelId="tfSottotensSogliaVMedLbl"
	  >


<!-- widget tfSottotensSogliaVMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottotensSogliaVMed" id="widg_tfSottotensSogliaVMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottotensSogliaVMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottotensSogliaVMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottotensSogliaVMax.label')}" labelFor="widg_tfSottotensSogliaVMax" errorFor="appDatareeTipo4Dett.sottotensSogliaVMax" labelId="tfSottotensSogliaVMaxLbl"
	  >


<!-- widget tfSottotensSogliaVMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottotensSogliaVMax" id="widg_tfSottotensSogliaVMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottotensSogliaVMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottotensTempoSMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottotensTempoSMin.label')}" labelFor="widg_tfSottotensTempoSMin" errorFor="appDatareeTipo4Dett.sottotensTempoSMin" labelId="tfSottotensTempoSMinLbl"
	  >


<!-- widget tfSottotensTempoSMin -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottotensTempoSMin" id="widg_tfSottotensTempoSMin"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottotensTempoSMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottotensTempoSMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottotensTempoSMed.label')}" labelFor="widg_tfSottotensTempoSMed" errorFor="appDatareeTipo4Dett.sottotensTempoSMed" labelId="tfSottotensTempoSMedLbl"
	  >


<!-- widget tfSottotensTempoSMed -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottotensTempoSMed" id="widg_tfSottotensTempoSMed"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottotensTempoSMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','tfSottotensTempoSMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo4Dett.tfSottotensTempoSMax.label')}" labelFor="widg_tfSottotensTempoSMax" errorFor="appDatareeTipo4Dett.sottotensTempoSMax" labelId="tfSottotensTempoSMaxLbl"
	  >


<!-- widget tfSottotensTempoSMax -->
<s:textfield 
	
	
	name="appDatareeTipo4Dett.sottotensTempoSMax" id="widg_tfSottotensTempoSMax"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo4Dett','tfSottotensTempoSMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpModulo --></div>

			
	
	<div id="p_cpFunGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpFunGestReeDett -->
	
	
<div class="commandPanel functional" id="cpFunGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','bSalvaReeDett')" >

	



<!-- widget bSalvaReeDett -->
<s:submit name="widg_bSalvaReeDett" id="widg_bSalvaReeDett" method="handleBSalvaReeDett_CLICKED"
	key="cpGestReeTipo4Dett.bSalvaReeDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo4Dett','bSalvaReeDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestReeDett --></div>

			
	
	<div id="p_cpNavGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestReeDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo4Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo4Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo4Dett','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestReeDett --></div>

	

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
