<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_ree_tipo1/CpGestReeTipo1DettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo1 -->
<!-- pageId:cpGestReeTipo1Dett -->

<s:form id="cpGestReeTipo1Dett" action="cpGestReeTipo1Dett" namespace="/base/gestisci_ree_tipo1" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo1Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo1Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo1Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo1/cpGestReeTipo1Dett!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_tipo1"
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

	
	

	
	
			
	
	
	<div id="p_mpReeTipo1Title" class="panelBlock"><!-- startFragment:p_mpReeTipo1Title -->
		

		
<s:if test="#session.cpGestReeTipo1Dett_mpReeTipo1Title_selectedMultiPanel == 'cpGestReeTipo1Dett_mpReeTipo1Title_fpGestReeTitleTipo1'">
	<s:include value="/jsp/multipanels/cpGestReeTipo1Dett_mpReeTipo1Title_fpGestReeTitleTipo1.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpReeTipo1Title --></div>

			
	
	
	<div id="p_mpReeTipo1BTitle" class="panelBlock"><!-- startFragment:p_mpReeTipo1BTitle -->
		

		
<s:if test="#session.cpGestReeTipo1Dett_mpReeTipo1BTitle_selectedMultiPanel == 'cpGestReeTipo1Dett_mpReeTipo1BTitle_fpGestReeTitleTipo1B'">
	<s:include value="/jsp/multipanels/cpGestReeTipo1Dett_mpReeTipo1BTitle_fpGestReeTitleTipo1B.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpReeTipo1BTitle --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


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
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptComponente')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptComponente.label')}" labelFor="widg_ptComponente" errorFor="appDatareeTipo1Dett.descComponente" labelId="ptComponenteLbl"   >


<!-- widget ptComponente -->
<s:property value="appDatareeTipo1Dett.descComponente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptDataInst')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptDataInst.label')}" labelFor="widg_ptDataInst" errorFor="appDatareeTipo1Dett.dataInstallazione" labelId="ptDataInstLbl"   >


<!-- widget ptDataInst -->
<s:property value="appDatareeTipo1Dett.dataInstallazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptFabb')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptFabb.label')}" labelFor="widg_ptFabb" errorFor="appDatareeTipo1Dett.marca" labelId="ptFabbLbl"   >


<!-- widget ptFabb -->
<s:property value="appDatareeTipo1Dett.marca" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptModello')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptModello.label')}" labelFor="widg_ptModello" errorFor="appDatareeTipo1Dett.modello" labelId="ptModelloLbl"   >


<!-- widget ptModello -->
<s:property value="appDatareeTipo1Dett.modello" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptMatricola')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptMatricola.label')}" labelFor="widg_ptMatricola" errorFor="appDatareeTipo1Dett.matricola" labelId="ptMatricolaLbl"   >


<!-- widget ptMatricola -->
<s:property value="appDatareeTipo1Dett.matricola" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptTipo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptTipo.label')}" labelFor="widg_ptTipo" errorFor="appDatareeTipo1Dett.descTipo" labelId="ptTipoLbl"   >


<!-- widget ptTipo -->
<s:property value="appDatareeTipo1Dett.descTipo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptPotUtile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptPotUtile.label')}" labelFor="widg_ptPotUtile" errorFor="appDatareeTipo1Dett.potenzaTermicaKw" labelId="ptPotUtileLbl"   >


<!-- widget ptPotUtile -->
<s:property value="appDatareeTipo1Dett.potenzaTermicaKw" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfPotMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfPotMax.label')}" labelFor="widg_tfPotMax" errorFor="appDatareeTipo1Dett.potTermFocolKw" labelId="tfPotMaxLbl"
	  >


<!-- widget tfPotMax -->
<s:textfield 
	
	
	name="appDatareeTipo1Dett.potTermFocolKw" id="widg_tfPotMax"
maxlength="9"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfPotMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbTipologiaTipo1B')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbTipologiaTipo1B.label')}" labelFor="widg_cbTipologiaTipo1B" errorFor="appDatareeTipo1Dett.tipologiaTipo1B" labelId="cbTipologiaTipo1BLbl"
	  >


<!-- widget cbTipologiaTipo1B -->
<s:select name="appDatareeTipo1Dett.tipologiaTipo1B" id="widg_cbTipologiaTipo1B"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipologiaTipo1B"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbTipologiaTipo1B')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbStelle')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbStelle.label')}" labelFor="widg_cbStelle" errorFor="appDatareeTipo1Dett.fkStelle" labelId="cbStelleLbl"
	  >


<!-- widget cbStelle -->
<s:select name="appDatareeTipo1Dett.fkStelle" id="widg_cbStelle"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoStelle"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbStelle')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbApparecchiatura')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbApparecchiatura.label')}" labelFor="widg_cbApparecchiatura" errorFor="appDatareeTipo1Dett.fkTipo1B" labelId="cbApparecchiaturaLbl"
	  >


<!-- widget cbApparecchiatura -->
<s:select name="appDatareeTipo1Dett.fkTipo1B" id="widg_cbApparecchiatura"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipo1B"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbApparecchiatura')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbClimaInv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbClimaInv.label')}" labelFor="widg_cbClimaInv" errorFor="appDatareeTipo1Dett.flgClimaInverno" labelId="cbClimaInvLbl"
	  >


<!-- widget cbClimaInv -->
<s:checkbox 
	
	
	name="appDatareeTipo1Dett.flgClimaInverno" id="widg_cbClimaInv"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbClimaInv')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo1Dett','cbClimaInv')" >
	<s:hidden name="__checkbox_appDatareeTipo1Dett.flgClimaInverno" id="__checkbox_widg_cbClimaInv" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbProdAcs')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbProdAcs.label')}" labelFor="widg_cbProdAcs" errorFor="appDatareeTipo1Dett.flgProduzAcs" labelId="cbProdAcsLbl"
	  >


<!-- widget cbProdAcs -->
<s:checkbox 
	
	
	name="appDatareeTipo1Dett.flgProduzAcs" id="widg_cbProdAcs"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbProdAcs')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo1Dett','cbProdAcs')" >
	<s:hidden name="__checkbox_appDatareeTipo1Dett.flgProduzAcs" id="__checkbox_widg_cbProdAcs" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbCucina')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbCucina.label')}" labelFor="widg_cbCucina" errorFor="appDatareeTipo1Dett.flgCucina" labelId="cbCucinaLbl"
	  >


<!-- widget cbCucina -->
<s:checkbox 
	
	
	name="appDatareeTipo1Dett.flgCucina" id="widg_cbCucina"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbCucina')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo1Dett','cbCucina')" >
	<s:hidden name="__checkbox_appDatareeTipo1Dett.flgCucina" id="__checkbox_widg_cbCucina" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfDepCan')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfDepCan.label')}" labelFor="widg_tfDepCan" errorFor="appDatareeTipo1Dett.deprCanaleFumoPa" labelId="tfDepCanLbl"
	  >


<!-- widget tfDepCan -->
<s:textfield 
	
	
	name="appDatareeTipo1Dett.deprCanaleFumoPa" id="widg_tfDepCan"
maxlength="8"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfDepCan')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbMarcaturaCE')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbMarcaturaCE.label')}" labelFor="widg_cbMarcaturaCE" errorFor="appDatareeTipo1Dett.flgMarcaturaCE" labelId="cbMarcaturaCELbl"
	  >


<!-- widget cbMarcaturaCE -->
<s:select name="appDatareeTipo1Dett.flgMarcaturaCE" id="widg_cbMarcaturaCE"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoREEPresenteAssente"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbMarcaturaCE')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbPlaccaCamino')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbPlaccaCamino.label')}" labelFor="widg_cbPlaccaCamino" errorFor="appDatareeTipo1Dett.flgPlaccaCamino" labelId="cbPlaccaCaminoLbl"
	  >


<!-- widget cbPlaccaCamino -->
<s:select name="appDatareeTipo1Dett.flgPlaccaCamino" id="widg_cbPlaccaCamino"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoREEPresenteAssente"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbPlaccaCamino')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbModalita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbModalita.label')}" labelFor="widg_cbModalita" errorFor="appDatareeTipo1Dett.flgEvacuFumi" labelId="cbModalitaLbl"
	  >


<!-- widget cbModalita -->
<s:select name="appDatareeTipo1Dett.flgEvacuFumi" id="widg_cbModalita"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoNaturaleForzata"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbModalita')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbAriaComburente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbAriaComburente.label')}" labelFor="widg_cbAriaComburente" errorFor="appDatareeTipo1Dett.fkAriaComburente" labelId="cbAriaComburenteLbl"
	  >


<!-- widget cbAriaComburente -->
<s:select name="appDatareeTipo1Dett.fkAriaComburente" id="widg_cbAriaComburente"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoAriaComburente"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbAriaComburente')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbControlloAriaComburente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbControlloAriaComburente.label')}" labelFor="widg_cbControlloAriaComburente" errorFor="appDatareeTipo1Dett.fkControlloAriaComburente" labelId="cbControlloAriaComburenteLbl"
	  >


<!-- widget cbControlloAriaComburente -->
<s:select name="appDatareeTipo1Dett.fkControlloAriaComburente" id="widg_cbControlloAriaComburente"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoControlloAriaComburente"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbControlloAriaComburente')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbCaricamentoCombustibile')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbCaricamentoCombustibile.label')}" labelFor="widg_cbCaricamentoCombustibile" errorFor="appDatareeTipo1Dett.fkCaricamentoCombustibile" labelId="cbCaricamentoCombustibileLbl"
	  >


<!-- widget cbCaricamentoCombustibile -->
<s:select name="appDatareeTipo1Dett.fkCaricamentoCombustibile" id="widg_cbCaricamentoCombustibile"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoCaricamentoCombustibile"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbCaricamentoCombustibile')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptCombustibile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptCombustibile.label')}" labelFor="widg_ptCombustibile" errorFor="appDatareeTipo1Dett.combustibile" labelId="ptCombustibileLbl"   >


<!-- widget ptCombustibile -->
<s:property value="appDatareeTipo1Dett.combustibile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbDisposCom')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbDisposCom.label')}" labelFor="widg_rbDisposCom" errorFor="appDatareeTipo1Dett.flgDisposComando" labelId="rbDisposComLbl"
	  >


<!-- widget rbDisposCom -->

	
<div id="appDatareeTipo1Dett.flgDisposComando" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbDisposComSI" name="appDatareeTipo1Dett.flgDisposComando"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbDisposCom')"
	cssClass="radio"
	
	/> <label  for="widg_rbDisposComSI1"><s:text name="cpGestReeTipo1Dett.rbDisposCom.rbDisposComSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDisposComNO" name="appDatareeTipo1Dett.flgDisposComando"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbDisposCom')"
	cssClass="radio"
	
	/> <label  for="widg_rbDisposComNO0"><s:text name="cpGestReeTipo1Dett.rbDisposCom.rbDisposComNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDisposComNC" name="appDatareeTipo1Dett.flgDisposComando"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbDisposCom')"
	cssClass="radio"
	
	/> <label  for="widg_rbDisposComNC2"><s:text name="cpGestReeTipo1Dett.rbDisposCom.rbDisposComNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbDisposSicur')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbDisposSicur.label')}" labelFor="widg_rbDisposSicur" errorFor="appDatareeTipo1Dett.flgDisposSicurezza" labelId="rbDisposSicurLbl"
	  >


<!-- widget rbDisposSicur -->

	
<div id="appDatareeTipo1Dett.flgDisposSicurezza" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbDisposSicurSI" name="appDatareeTipo1Dett.flgDisposSicurezza"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbDisposSicur')"
	cssClass="radio"
	
	/> <label  for="widg_rbDisposSicurSI1"><s:text name="cpGestReeTipo1Dett.rbDisposSicur.rbDisposSicurSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDisposSicurNO" name="appDatareeTipo1Dett.flgDisposSicurezza"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbDisposSicur')"
	cssClass="radio"
	
	/> <label  for="widg_rbDisposSicurNO0"><s:text name="cpGestReeTipo1Dett.rbDisposSicur.rbDisposSicurNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbDisposSicurNC" name="appDatareeTipo1Dett.flgDisposSicurezza"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbDisposSicur')"
	cssClass="radio"
	
	/> <label  for="widg_rbDisposSicurNC2"><s:text name="cpGestReeTipo1Dett.rbDisposSicur.rbDisposSicurNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbValvSicur')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbValvSicur.label')}" labelFor="widg_rbValvSicur" errorFor="appDatareeTipo1Dett.flgValvolaSicurezza" labelId="rbValvSicurLbl"
	  >


<!-- widget rbValvSicur -->

	
<div id="appDatareeTipo1Dett.flgValvolaSicurezza" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbValvSicurSI" name="appDatareeTipo1Dett.flgValvolaSicurezza"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbValvSicur')"
	cssClass="radio"
	
	/> <label  for="widg_rbValvSicurSI1"><s:text name="cpGestReeTipo1Dett.rbValvSicur.rbValvSicurSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbValvSicurNO" name="appDatareeTipo1Dett.flgValvolaSicurezza"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbValvSicur')"
	cssClass="radio"
	
	/> <label  for="widg_rbValvSicurNO0"><s:text name="cpGestReeTipo1Dett.rbValvSicur.rbValvSicurNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbValvSicurNC" name="appDatareeTipo1Dett.flgValvolaSicurezza"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbValvSicur')"
	cssClass="radio"
	
	/> <label  for="widg_rbValvSicurNC2"><s:text name="cpGestReeTipo1Dett.rbValvSicur.rbValvSicurNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbScambFumi')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbScambFumi.label')}" labelFor="widg_rbScambFumi" errorFor="appDatareeTipo1Dett.flgScambiatoreFumi" labelId="rbScambFumiLbl"
	  >


<!-- widget rbScambFumi -->

	
<div id="appDatareeTipo1Dett.flgScambiatoreFumi" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbScambFumiSI" name="appDatareeTipo1Dett.flgScambiatoreFumi"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbScambFumi')"
	cssClass="radio"
	
	/> <label  for="widg_rbScambFumiSI1"><s:text name="cpGestReeTipo1Dett.rbScambFumi.rbScambFumiSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbScambFumiNO" name="appDatareeTipo1Dett.flgScambiatoreFumi"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbScambFumi')"
	cssClass="radio"
	
	/> <label  for="widg_rbScambFumiNO0"><s:text name="cpGestReeTipo1Dett.rbScambFumi.rbScambFumiNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbScambFumiNC" name="appDatareeTipo1Dett.flgScambiatoreFumi"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbScambFumi')"
	cssClass="radio"
	
	/> <label  for="widg_rbScambFumiNC2"><s:text name="cpGestReeTipo1Dett.rbScambFumi.rbScambFumiNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbRiflusso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbRiflusso.label')}" labelFor="widg_rbRiflusso" errorFor="appDatareeTipo1Dett.flgRiflusso" labelId="rbRiflussoLbl"
	  >


<!-- widget rbRiflusso -->

	
<div id="appDatareeTipo1Dett.flgRiflusso" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbRiflussoSI" name="appDatareeTipo1Dett.flgRiflusso"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbRiflusso')"
	cssClass="radio"
	
	/> <label  for="widg_rbRiflussoSI1"><s:text name="cpGestReeTipo1Dett.rbRiflusso.rbRiflussoSI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbRiflussoNO" name="appDatareeTipo1Dett.flgRiflusso"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbRiflusso')"
	cssClass="radio"
	
	/> <label  for="widg_rbRiflussoNO0"><s:text name="cpGestReeTipo1Dett.rbRiflusso.rbRiflussoNO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbRiflussoNC" name="appDatareeTipo1Dett.flgRiflusso"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbRiflusso')"
	cssClass="radio"
	
	/> <label  for="widg_rbRiflussoNC2"><s:text name="cpGestReeTipo1Dett.rbRiflusso.rbRiflussoNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbUni10389')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbUni10389.label')}" labelFor="widg_rbUni10389" errorFor="appDatareeTipo1Dett.flgUni10389_1" labelId="rbUni10389Lbl"
	  >


<!-- widget rbUni10389 -->

	
<div id="appDatareeTipo1Dett.flgUni10389_1" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbUni10389SI" name="appDatareeTipo1Dett.flgUni10389_1"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbUni10389')"
	cssClass="radio"
	
	/> <label  for="widg_rbUni10389SI1"><s:text name="cpGestReeTipo1Dett.rbUni10389.rbUni10389SI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbUni10389NO" name="appDatareeTipo1Dett.flgUni10389_1"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbUni10389')"
	cssClass="radio"
	
	/> <label  for="widg_rbUni10389NO0"><s:text name="cpGestReeTipo1Dett.rbUni10389.rbUni10389NO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbUni10389NC" name="appDatareeTipo1Dett.flgUni10389_1"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbUni10389')"
	cssClass="radio"
	
	/> <label  for="widg_rbUni10389NC2"><s:text name="cpGestReeTipo1Dett.rbUni10389.rbUni10389NC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbUni10389_2')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbUni10389_2.label')}" labelFor="widg_rbUni10389_2" errorFor="appDatareeTipo1Dett.flgUni10389_2" labelId="rbUni10389_2Lbl"
	  >


<!-- widget rbUni10389_2 -->

	
<div id="appDatareeTipo1Dett.flgUni10389_2" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbUni10389_2SI" name="appDatareeTipo1Dett.flgUni10389_2"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbUni10389_2')"
	cssClass="radio"
	
	/> <label  for="widg_rbUni10389_2SI1"><s:text name="cpGestReeTipo1Dett.rbUni10389_2.rbUni10389_2SI.label" /></label>








<s:radio
	
title=""	
	id="widg_rbUni10389_2NO" name="appDatareeTipo1Dett.flgUni10389_2"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbUni10389_2')"
	cssClass="radio"
	
	/> <label  for="widg_rbUni10389_2NO0"><s:text name="cpGestReeTipo1Dett.rbUni10389_2.rbUni10389_2NO.label" /></label>








<s:radio
	
title=""	
	id="widg_rbUni10389_2NC" name="appDatareeTipo1Dett.flgUni10389_2"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbUni10389_2')"
	cssClass="radio"
	
	/> <label  for="widg_rbUni10389_2NC2"><s:text name="cpGestReeTipo1Dett.rbUni10389_2.rbUni10389_2NC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','taAltroRef')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.taAltroRef.label')}" labelFor="widg_taAltroRef" errorFor="appDatareeTipo1Dett.altroRiferimento" labelId="taAltroRefLbl"
	  >


<!-- widget taAltroRef -->
<s:textarea 
	
	
	name="appDatareeTipo1Dett.altroRiferimento" id="widg_taAltroRef"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','taAltroRef')"
	rows="3"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpE --></div>

			
	
	
	<div id="p_mpConsumoCombustibile" class="panelBlock"><!-- startFragment:p_mpConsumoCombustibile -->
		

		
<s:if test="#session.cpGestReeTipo1Dett_mpConsumoCombustibile_selectedMultiPanel == 'cpGestReeTipo1Dett_mpConsumoCombustibile_fpConsumoCombustibile'">
	<s:include value="/jsp/multipanels/cpGestReeTipo1Dett_mpConsumoCombustibile_fpConsumoCombustibile.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpConsumoCombustibile --></div>

			
	
	<div id="p_wpElencoNonCompilati" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoNonCompilati -->
	
	
<h4 class="wpLabel">elenco moduli da compilare per procedere </h4>
<div class="widgetsPanel" id="wpElencoNonCompilati">
	
	<customtag:widgetsPanel id="wpElencoNonCompilatiTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptElencoModuli')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptElencoModuli.label')}" labelFor="widg_ptElencoModuli" errorFor="appDatareeTipo1Dett.elencoModuliNonComp" labelId="ptElencoModuliLbl"   >


<!-- widget ptElencoModuli -->
<s:property value="appDatareeTipo1Dett.elencoModuliNonComp" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbModuli')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbModuli.label')}" labelFor="widg_cbModuli" errorFor="appDatamoduloSelezionato" labelId="cbModuliLbl"
	  >


<!-- widget cbModuli -->
	<csiuicore:ajaxify id="p_wpModulo,p_stdMsgReeDett" 
		widgetType="combo" 
		requestUri="/sigitwebn/base/gestisci_ree_tipo1/cpGestReeTipo1Dett!handleCbModuli_VALUE_CHANGED.do"
		pageId="cpGestReeTipo1Dett"
		formName="cpGestReeTipo1Dett"
		javascriptDetection="false"
		nameSpace="/base/gestisci_ree_tipo1">

<s:url id="widg_cbModuliurlComboBoxValueChange"
   action="/sigitwebn/cpGestReeTipo1Dett!handleCbModuli_VALUE_CHANGED" namespace="/base/gestisci_ree_tipo1"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatamoduloSelezionato" id="widg_cbModuli"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoModuli"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbModuli')"
	  listKey="code"
	  listValue="description"
	  onclick="onCBClick(this,'confermacbModuli','conferma','%{widg_cbModuliurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbModuli','conferma','%{widg_cbModuliurlComboBoxValueChange}')" 
	  />

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpElencoNonCompilati --></div>

			
	
	<div id="p_wpModulo" class="widgetsPanelBlock"><!-- startFragment:p_wpModulo -->
	
	
<h4 class="wpLabel">compila modulo </h4>
<div class="widgetsPanel" id="wpModulo">
	
	<customtag:widgetsPanel id="wpModuloTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','ptNModuloTermico')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.ptNModuloTermico.label')}" labelFor="widg_ptNModuloTermico" errorFor="appDatareeTipo1DettModulo.numModuloTermico" labelId="ptNModuloTermicoLbl"   tdStyleClass="numbers">


<!-- widget ptNModuloTermico -->
<s:property value="appDatareeTipo1DettModulo.numModuloTermico" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfTempFumiC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfTempFumiC.label')}" labelFor="widg_tfTempFumiC" errorFor="appDatareeTipo1DettModulo.tempFumiC" labelId="tfTempFumiCLbl"
	  >


<!-- widget tfTempFumiC -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.tempFumiC" id="widg_tfTempFumiC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfTempFumiC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfTempAriaC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfTempAriaC.label')}" labelFor="widg_tfTempAriaC" errorFor="appDatareeTipo1DettModulo.tempAriaC" labelId="tfTempAriaCLbl"
	  >


<!-- widget tfTempAriaC -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.tempAriaC" id="widg_tfTempAriaC"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfTempAriaC')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfO2Perc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfO2Perc.label')}" labelFor="widg_tfO2Perc" errorFor="appDatareeTipo1DettModulo.o2Perc" labelId="tfO2PercLbl"
	  >


<!-- widget tfO2Perc -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.o2Perc" id="widg_tfO2Perc"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfO2Perc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfCo2Perc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfCo2Perc.label')}" labelFor="widg_tfCo2Perc" errorFor="appDatareeTipo1DettModulo.co2Perc" labelId="tfCo2PercLbl"
	  >


<!-- widget tfCo2Perc -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.co2Perc" id="widg_tfCo2Perc"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfCo2Perc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfParticolatoPrimarioMgM3')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfParticolatoPrimarioMgM3.label')}" labelFor="widg_tfParticolatoPrimarioMgM3" errorFor="appDatareeTipo1DettModulo.particolatoPrimarioMgM3" labelId="tfParticolatoPrimarioMgM3Lbl"
	  >


<!-- widget tfParticolatoPrimarioMgM3 -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.particolatoPrimarioMgM3" id="widg_tfParticolatoPrimarioMgM3"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfParticolatoPrimarioMgM3')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfBacharachMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfBacharachMin.label')}" labelFor="widg_tfBacharachMin" errorFor="appDatareeTipo1DettModulo.bacharachMin" labelId="tfBacharachMinLbl"
	  >


<!-- widget tfBacharachMin -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.bacharachMin" id="widg_tfBacharachMin"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfBacharachMin')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfBacharachMed')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfBacharachMed.label')}" labelFor="widg_tfBacharachMed" errorFor="appDatareeTipo1DettModulo.bacharachMed" labelId="tfBacharachMedLbl"
	  >


<!-- widget tfBacharachMed -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.bacharachMed" id="widg_tfBacharachMed"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfBacharachMed')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfBacharachMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfBacharachMax.label')}" labelFor="widg_tfBacharachMax" errorFor="appDatareeTipo1DettModulo.bacharachMax" labelId="tfBacharachMaxLbl"
	  >


<!-- widget tfBacharachMax -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.bacharachMax" id="widg_tfBacharachMax"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfBacharachMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfCoCorrettoPpm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfCoCorrettoPpm.label')}" labelFor="widg_tfCoCorrettoPpm" errorFor="appDatareeTipo1DettModulo.coCorrettoPpm" labelId="tfCoCorrettoPpmLbl"
	  >


<!-- widget tfCoCorrettoPpm -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.coCorrettoPpm" id="widg_tfCoCorrettoPpm"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfCoCorrettoPpm')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfCoCorrettoPpmTipo1B')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfCoCorrettoPpmTipo1B.label')}" labelFor="widg_tfCoCorrettoPpmTipo1B" errorFor="appDatareeTipo1DettModulo.coCorrettoPpm" labelId="tfCoCorrettoPpmTipo1BLbl"
	  >


<!-- widget tfCoCorrettoPpmTipo1B -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.coCorrettoPpm" id="widg_tfCoCorrettoPpmTipo1B"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfCoCorrettoPpmTipo1B')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfRendCombPerc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfRendCombPerc.label')}" labelFor="widg_tfRendCombPerc" errorFor="appDatareeTipo1DettModulo.rendCombPerc" labelId="tfRendCombPercLbl"
	  >


<!-- widget tfRendCombPerc -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.rendCombPerc" id="widg_tfRendCombPerc"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfRendCombPerc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfRendCombPercTipo1B')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfRendCombPercTipo1B.label')}" labelFor="widg_tfRendCombPercTipo1B" errorFor="appDatareeTipo1DettModulo.rendCombPerc" labelId="tfRendCombPercTipo1BLbl"
	  >


<!-- widget tfRendCombPercTipo1B -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.rendCombPerc" id="widg_tfRendCombPercTipo1B"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfRendCombPercTipo1B')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfRendMInLeggePerc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfRendMInLeggePerc.label')}" labelFor="widg_tfRendMInLeggePerc" errorFor="appDatareeTipo1DettModulo.rendMinLeggePerc" labelId="tfRendMInLeggePercLbl"
	  >


<!-- widget tfRendMInLeggePerc -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.rendMinLeggePerc" id="widg_tfRendMInLeggePerc"
maxlength="6"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfRendMInLeggePerc')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfNoxPpm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfNoxPpm.label')}" labelFor="widg_tfNoxPpm" errorFor="appDatareeTipo1DettModulo.noxPpm" labelId="tfNoxPpmLbl"
	  >


<!-- widget tfNoxPpm -->
<s:textfield 
	
title=""	
	name="appDatareeTipo1DettModulo.noxPpm" id="widg_tfNoxPpm"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfNoxPpm')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfNoxPpmTipo1B')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfNoxPpmTipo1B.label')}" labelFor="widg_tfNoxPpmTipo1B" errorFor="appDatareeTipo1DettModulo.noxPpm" labelId="tfNoxPpmTipo1BLbl"
	  >


<!-- widget tfNoxPpmTipo1B -->
<s:textfield 
	
title=""	
	name="appDatareeTipo1DettModulo.noxPpm" id="widg_tfNoxPpmTipo1B"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfNoxPpmTipo1B')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfNoxNm3Tipo1B')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfNoxNm3Tipo1B.label')}" labelFor="widg_tfNoxNm3Tipo1B" errorFor="appDatareeTipo1DettModulo.noxMgNm3" labelId="tfNoxNm3Tipo1BLbl"
	  >


<!-- widget tfNoxNm3Tipo1B -->
<s:textfield 
	
title=""	
	name="appDatareeTipo1DettModulo.noxMgNm3" id="widg_tfNoxNm3Tipo1B"
maxlength="10"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfNoxNm3Tipo1B')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','cbPortataCombUm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.cbPortataCombUm.label')}" labelFor="widg_cbPortataCombUm" errorFor="appDatareeTipo1DettModulo.portataCombUm" labelId="cbPortataCombUmLbl"
	  >


<!-- widget cbPortataCombUm -->
<s:select name="appDatareeTipo1DettModulo.portataCombUm" id="widg_cbPortataCombUm"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataportataCombustibile"
	  disabled="isWidgetDisabled('cpGestReeTipo1Dett','cbPortataCombUm')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfPortataComb')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfPortataComb.label')}" labelFor="widg_tfPortataComb" errorFor="appDatareeTipo1DettModulo.portataComb" labelId="tfPortataCombLbl"
	  >


<!-- widget tfPortataComb -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.portataComb" id="widg_tfPortataComb"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfPortataComb')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','tfCoNoAriaPpm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.tfCoNoAriaPpm.label')}" labelFor="widg_tfCoNoAriaPpm" errorFor="appDatareeTipo1DettModulo.coNoAriaPpm" labelId="tfCoNoAriaPpmLbl"
	  >


<!-- widget tfCoNoAriaPpm -->
<s:textfield 
	
	
	name="appDatareeTipo1DettModulo.coNoAriaPpm" id="widg_tfCoNoAriaPpm"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo1Dett','tfCoNoAriaPpm')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbRispettaBacharac')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbRispettaBacharac.label')}" labelFor="widg_rbRispettaBacharac" errorFor="appDatareeTipo1DettModulo.flgRispettaBacharac" labelId="rbRispettaBacharacLbl"
	  >


<!-- widget rbRispettaBacharac -->

	
<div id="appDatareeTipo1DettModulo.flgRispettaBacharac" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRispettaBacharacSI" name="appDatareeTipo1DettModulo.flgRispettaBacharac"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbRispettaBacharac')"
	cssClass="radio"
	
	/> <label  for="widg_rbRispettaBacharacSI1"><s:text name="cpGestReeTipo1Dett.rbRispettaBacharac.rbRispettaBacharacSI.label" /></label>








<s:radio
	
	
	id="widg_rbRispettaBacharacNO" name="appDatareeTipo1DettModulo.flgRispettaBacharac"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbRispettaBacharac')"
	cssClass="radio"
	
	/> <label  for="widg_rbRispettaBacharacNO0"><s:text name="cpGestReeTipo1Dett.rbRispettaBacharac.rbRispettaBacharacNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','rbRendMagRendMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo1Dett.rbRendMagRendMin.label')}" labelFor="widg_rbRendMagRendMin" errorFor="appDatareeTipo1DettModulo.flgRendMagRendMin" labelId="rbRendMagRendMinLbl"
	  >


<!-- widget rbRendMagRendMin -->

	
<div id="appDatareeTipo1DettModulo.flgRendMagRendMin" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbRendMagRendMinSI" name="appDatareeTipo1DettModulo.flgRendMagRendMin"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbRendMagRendMin')"
	cssClass="radio"
	
	/> <label  for="widg_rbRendMagRendMinSI1"><s:text name="cpGestReeTipo1Dett.rbRendMagRendMin.rbRendMagRendMinSI.label" /></label>








<s:radio
	
	
	id="widg_rbRendMagRendMinNO" name="appDatareeTipo1DettModulo.flgRendMagRendMin"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','rbRendMagRendMin')"
	cssClass="radio"
	
	/> <label  for="widg_rbRendMagRendMinNO0"><s:text name="cpGestReeTipo1Dett.rbRendMagRendMin.rbRendMagRendMinNO.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpModulo --></div>

			
	
	<div id="p_cpFunGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpFunGestReeDett -->
	
	
<div class="commandPanel functional" id="cpFunGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','bSalvaReeDett')" >

	



<!-- widget bSalvaReeDett -->
<s:submit name="widg_bSalvaReeDett" id="widg_bSalvaReeDett" method="handleBSalvaReeDett_CLICKED"
	key="cpGestReeTipo1Dett.bSalvaReeDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','bSalvaReeDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestReeDett --></div>

			
	
	<div id="p_cpNavGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestReeDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo1Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo1Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo1Dett','btnIndietro')" />

	


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
