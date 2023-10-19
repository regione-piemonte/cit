<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_tipo3 -->
<!-- pageId:cpGestReeTipo3Dett -->

<s:form id="cpGestReeTipo3Dett" action="cpGestReeTipo3Dett" namespace="/base/gestisci_ree_tipo3" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo3Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestReeTipo3Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestReeTipo3Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_tipo3/cpGestReeTipo3Dett!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_tipo3"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestReeTipo3Dett.fpGestRee.label" /></h4>
<div class="formPanel" id="fpGestRee">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestRee --></div>

			
	
	<div id="p_stdMsgRee" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgRee -->
	
	
<div class="stdMessagePanel" id="stdMsgRee">
	<customtag:stdMessagePanel id="stdMsgRee" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgRee --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


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
	
	
<h4 class="wpLabel">E. controllo e verifica energetica del scambiatore </h4>
<div class="widgetsPanel" id="wpE">
	
	<customtag:widgetsPanel id="wpETbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptComponente')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptComponente.label')}" labelFor="widg_ptComponente" errorFor="appDatareeTipo3Dett.descComponente" labelId="ptComponenteLbl"   >


<!-- widget ptComponente -->
<s:property value="appDatareeTipo3Dett.descComponente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptFabb')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptFabb.label')}" labelFor="widg_ptFabb" errorFor="appDatareeTipo3Dett.marca" labelId="ptFabbLbl"   >


<!-- widget ptFabb -->
<s:property value="appDatareeTipo3Dett.marca" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptModello')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptModello.label')}" labelFor="widg_ptModello" errorFor="appDatareeTipo3Dett.modello" labelId="ptModelloLbl"   >


<!-- widget ptModello -->
<s:property value="appDatareeTipo3Dett.modello" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptMatricola')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptMatricola.label')}" labelFor="widg_ptMatricola" errorFor="appDatareeTipo3Dett.matricola" labelId="ptMatricolaLbl"   >


<!-- widget ptMatricola -->
<s:property value="appDatareeTipo3Dett.matricola" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','cbAlimentazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.cbAlimentazione.label')}" labelFor="widg_cbAlimentazione" errorFor="appDatareeTipo3Dett.fluidoAlimentazione" labelId="cbAlimentazioneLbl"
	  fieldRequired="true">


<!-- widget cbAlimentazione -->
<s:select name="appDatareeTipo3Dett.fluidoAlimentazione" id="widg_cbAlimentazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFluido"
	  disabled="isWidgetDisabled('cpGestReeTipo3Dett','cbAlimentazione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','cbFluido')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.cbFluido.label')}" labelFor="widg_cbFluido" errorFor="appDatareeTipo3Dett.idFluido" labelId="cbFluidoLbl"
	  fieldRequired="true">


<!-- widget cbFluido -->
<s:select name="appDatareeTipo3Dett.idFluido" id="widg_cbFluido"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFluido"
	  disabled="isWidgetDisabled('cpGestReeTipo3Dett','cbFluido')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','cbAlimInv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.cbAlimInv.label')}" labelFor="widg_cbAlimInv" errorFor="appDatareeTipo3Dett.flgClimaInverno" labelId="cbAlimInvLbl"
	  fieldRequired="true">


<!-- widget cbAlimInv -->
<s:checkbox 
	
	
	name="appDatareeTipo3Dett.flgClimaInverno" id="widg_cbAlimInv"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','cbAlimInv')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo3Dett','cbAlimInv')" >
	<s:hidden name="__checkbox_appDatareeTipo3Dett.flgClimaInverno" id="__checkbox_widg_cbAlimInv" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','cbProdAcs')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.cbProdAcs.label')}" labelFor="widg_cbProdAcs" errorFor="appDatareeTipo3Dett.flgProduzAcs" labelId="cbProdAcsLbl"
	  fieldRequired="true">


<!-- widget cbProdAcs -->
<s:checkbox 
	
	
	name="appDatareeTipo3Dett.flgProduzAcs" id="widg_cbProdAcs"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','cbProdAcs')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestReeTipo3Dett','cbProdAcs')" >
	<s:hidden name="__checkbox_appDatareeTipo3Dett.flgProduzAcs" id="__checkbox_widg_cbProdAcs" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptPotenzaTermNom')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptPotenzaTermNom.label')}" labelFor="widg_ptPotenzaTermNom" errorFor="appDatareeTipo3Dett.potenzaTermicaKw" labelId="ptPotenzaTermNomLbl"   >


<!-- widget ptPotenzaTermNom -->
<s:property value="appDatareeTipo3Dett.potenzaTermicaKw" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','rbPotComp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.rbPotComp.label')}" labelFor="widg_rbPotComp" errorFor="appDatareeTipo3Dett.flgPotenzaCompatibile" labelId="rbPotCompLbl"
	  fieldRequired="true">


<!-- widget rbPotComp -->

	
<div id="appDatareeTipo3Dett.flgPotenzaCompatibile" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbFlgPotCompSI" name="appDatareeTipo3Dett.flgPotenzaCompatibile"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbPotComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgPotCompSI1"><s:text name="cpGestReeTipo3Dett.rbPotComp.rbFlgPotCompSI.label" /></label>








<s:radio
	
	
	id="widg_rbFlgPotCompNO" name="appDatareeTipo3Dett.flgPotenzaCompatibile"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbPotComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgPotCompNO0"><s:text name="cpGestReeTipo3Dett.rbPotComp.rbFlgPotCompNO.label" /></label>








<s:radio
	
	
	id="widg_rbFlgPotCompNC" name="appDatareeTipo3Dett.flgPotenzaCompatibile"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbPotComp')"
	cssClass="radio"
	
	/> <label  for="widg_rbFlgPotCompNC2"><s:text name="cpGestReeTipo3Dett.rbPotComp.rbFlgPotCompNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','rbCoibIdon')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.rbCoibIdon.label')}" labelFor="widg_rbCoibIdon" errorFor="appDatareeTipo3Dett.flgCoibIdonea" labelId="rbCoibIdonLbl"
	  fieldRequired="true">


<!-- widget rbCoibIdon -->

	
<div id="appDatareeTipo3Dett.flgCoibIdonea" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbCoibIdonSI" name="appDatareeTipo3Dett.flgCoibIdonea"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbCoibIdon')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibIdonSI1"><s:text name="cpGestReeTipo3Dett.rbCoibIdon.rbCoibIdonSI.label" /></label>








<s:radio
	
	
	id="widg_rbCoibIdonNO" name="appDatareeTipo3Dett.flgCoibIdonea"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbCoibIdon')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibIdonNO0"><s:text name="cpGestReeTipo3Dett.rbCoibIdon.rbCoibIdonNO.label" /></label>








<s:radio
	
	
	id="widg_rbCoibIdonNC" name="appDatareeTipo3Dett.flgCoibIdonea"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbCoibIdon')"
	cssClass="radio"
	
	/> <label  for="widg_rbCoibIdonNC2"><s:text name="cpGestReeTipo3Dett.rbCoibIdon.rbCoibIdonNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','rbDispFunzionanti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.rbDispFunzionanti.label')}" labelFor="widg_rbDispFunzionanti" errorFor="appDatareeTipo3Dett.flgDispFunzionanti" labelId="rbDispFunzionantiLbl"
	  fieldRequired="true">


<!-- widget rbDispFunzionanti -->

	
<div id="appDatareeTipo3Dett.flgDispFunzionanti" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbDispFunzionantiSI" name="appDatareeTipo3Dett.flgDispFunzionanti"
	list="#{'1':'SI'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbDispFunzionanti')"
	cssClass="radio"
	
	/> <label  for="widg_rbDispFunzionantiSI1"><s:text name="cpGestReeTipo3Dett.rbDispFunzionanti.rbDispFunzionantiSI.label" /></label>








<s:radio
	
	
	id="widg_rbDispFunzionantiNO" name="appDatareeTipo3Dett.flgDispFunzionanti"
	list="#{'0':'NO'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbDispFunzionanti')"
	cssClass="radio"
	
	/> <label  for="widg_rbDispFunzionantiNO0"><s:text name="cpGestReeTipo3Dett.rbDispFunzionanti.rbDispFunzionantiNO.label" /></label>








<s:radio
	
	
	id="widg_rbDispFunzionantiNC" name="appDatareeTipo3Dett.flgDispFunzionanti"
	list="#{'2':'NC'}"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','rbDispFunzionanti')"
	cssClass="radio"
	
	/> <label  for="widg_rbDispFunzionantiNC2"><s:text name="cpGestReeTipo3Dett.rbDispFunzionanti.rbDispFunzionantiNC.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','ptProvaFumi')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.ptProvaFumi.label')}" labelFor="widg_ptProvaFumi" errorFor="widg_ptProvaFumi" labelId="ptProvaFumiLbl"   >


<!-- widget ptProvaFumi -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','tfTempEst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.tfTempEst.label')}" labelFor="widg_tfTempEst" errorFor="appDatareeTipo3Dett.tempExt" labelId="tfTempEstLbl"
	  fieldRequired="true">


<!-- widget tfTempEst -->
<s:textfield 
	
title=""	
	name="appDatareeTipo3Dett.tempExt" id="widg_tfTempEst"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo3Dett','tfTempEst')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','tfTempMandPrimario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.tfTempMandPrimario.label')}" labelFor="widg_tfTempMandPrimario" errorFor="appDatareeTipo3Dett.tempMandPrimario" labelId="tfTempMandPrimarioLbl"
	  fieldRequired="true">


<!-- widget tfTempMandPrimario -->
<s:textfield 
	
	
	name="appDatareeTipo3Dett.tempMandPrimario" id="widg_tfTempMandPrimario"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo3Dett','tfTempMandPrimario')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','tfTempRitPrimario')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.tfTempRitPrimario.label')}" labelFor="widg_tfTempRitPrimario" errorFor="appDatareeTipo3Dett.tempRitorPrimario" labelId="tfTempRitPrimarioLbl"
	  fieldRequired="true">


<!-- widget tfTempRitPrimario -->
<s:textfield 
	
	
	name="appDatareeTipo3Dett.tempRitorPrimario" id="widg_tfTempRitPrimario"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo3Dett','tfTempRitPrimario')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','tfPotTerm')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.tfPotTerm.label')}" labelFor="widg_tfPotTerm" errorFor="appDatareeTipo3Dett.potenzaTermKw" labelId="tfPotTermLbl"
	  fieldRequired="true">


<!-- widget tfPotTerm -->
<s:textfield 
	
	
	name="appDatareeTipo3Dett.potenzaTermKw" id="widg_tfPotTerm"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo3Dett','tfPotTerm')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','tfPotFlu')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.tfPotFlu.label')}" labelFor="widg_tfPotFlu" errorFor="appDatareeTipo3Dett.portFluidoM3" labelId="tfPotFluLbl"
	  fieldRequired="true">


<!-- widget tfPotFlu -->
<s:textfield 
	
	
	name="appDatareeTipo3Dett.portFluidoM3" id="widg_tfPotFlu"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo3Dett','tfPotFlu')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','tfTempMandSecond')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.tfTempMandSecond.label')}" labelFor="widg_tfTempMandSecond" errorFor="appDatareeTipo3Dett.tempMandSecondario" labelId="tfTempMandSecondLbl"
	  fieldRequired="true">


<!-- widget tfTempMandSecond -->
<s:textfield 
	
	
	name="appDatareeTipo3Dett.tempMandSecondario" id="widg_tfTempMandSecond"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo3Dett','tfTempMandSecond')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','tfTempRitSecond')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestReeTipo3Dett.tfTempRitSecond.label')}" labelFor="widg_tfTempRitSecond" errorFor="appDatareeTipo3Dett.tempRitSecondario" labelId="tfTempRitSecondLbl"
	  fieldRequired="true">


<!-- widget tfTempRitSecond -->
<s:textfield 
	
	
	name="appDatareeTipo3Dett.tempRitSecondario" id="widg_tfTempRitSecond"
maxlength="7"	disabled="isWidgetDisabled('cpGestReeTipo3Dett','tfTempRitSecond')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpE --></div>

			
	
	<div id="p_cpFunGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpFunGestReeDett -->
	
	
<div class="commandPanel functional" id="cpFunGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','bSalvaReeDett')" >

	



<!-- widget bSalvaReeDett -->
<s:submit name="widg_bSalvaReeDett" id="widg_bSalvaReeDett" method="handleBSalvaReeDett_CLICKED"
	key="cpGestReeTipo3Dett.bSalvaReeDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','bSalvaReeDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestReeDett --></div>

			
	
	<div id="p_cpNavGestReeDett" class="commandPanelBlock"><!-- startFragment:p_cpNavGestReeDett -->
	
	
<div class="commandPanel navigation" id="cpNavGestReeDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestReeTipo3Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestReeTipo3Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestReeTipo3Dett','btnIndietro')" />

	


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
