<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda4_6/CpGestLibScheda4_6DettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda4_6 -->
<!-- pageId:cpGestLibScheda4_6Dett -->

<s:form id="cpGestLibScheda4_6Dett" action="cpGestLibScheda4_6Dett" namespace="/base/gestisci_libretto_scheda4_6" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda4_6Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda4_6Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda4_6Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda4_6/cpGestLibScheda4_6Dett!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda4_6"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda4_6Dett.fpTitolo.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','wpInfoImpianto_2_2_fictitious_')" >

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptCongelatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptCongelatore.label')}" labelFor="widg_ptCongelatore" errorFor="appDatacomponenteCG.componente" labelId="ptCongelatoreLbl"   >


<!-- widget ptCongelatore -->
<s:property value="appDatacomponenteCG.componente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','cDataInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.cDataInstallazione.label')}" labelFor="widg_cDataInstallazione" errorFor="appDatacomponenteCG.dataInstallazione" labelId="cDataInstallazioneLbl"
	  fieldRequired="true">


<!-- widget cDataInstallazione -->
<s:textfield 
	
	
	name="appDatacomponenteCG.dataInstallazione" id="widg_cDataInstallazione"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','cDataInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','cDataDismissione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.cDataDismissione.label')}" labelFor="widg_cDataDismissione" errorFor="appDatacomponenteCG.dataDismissione" labelId="cDataDismissioneLbl"
	  >


<!-- widget cDataDismissione -->
<s:textfield 
	
	
	name="appDatacomponenteCG.dataDismissione" id="widg_cDataDismissione"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','cDataDismissione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','cbFabbricante')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.cbFabbricante.label')}" labelFor="widg_cbFabbricante" errorFor="appDatacomponenteCG.fabbricante" labelId="cbFabbricanteLbl"
	  fieldRequired="true">


<!-- widget cbFabbricante -->
<s:select name="appDatacomponenteCG.fabbricante" id="widg_cbFabbricante"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFabbricante"
	  disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','cbFabbricante')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tfModello')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.tfModello.label')}" labelFor="widg_tfModello" errorFor="appDatacomponenteCG.modello" labelId="tfModelloLbl"
	  fieldRequired="true">


<!-- widget tfModello -->
<s:textfield 
	
	
	name="appDatacomponenteCG.modello" id="widg_tfModello"
maxlength="33"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tfModello')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tfMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.tfMatricola.label')}" labelFor="widg_tfMatricola" errorFor="appDatacomponenteCG.matricola" labelId="tfMatricolaLbl"
	  fieldRequired="true">


<!-- widget tfMatricola -->
<s:textfield 
	
	
	name="appDatacomponenteCG.matricola" id="widg_tfMatricola"
maxlength="30"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tfMatricola')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tfTipologia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.tfTipologia.label')}" labelFor="widg_tfTipologia" errorFor="appDatacomponenteCG.tipologia" labelId="tfTipologiaLbl"
	  fieldRequired="true">


<!-- widget tfTipologia -->
<s:textfield 
	
	
	name="appDatacomponenteCG.tipologia" id="widg_tfTipologia"
maxlength="33"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tfTipologia')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','cbAlimentazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.cbAlimentazione.label')}" labelFor="widg_cbAlimentazione" errorFor="appDatacomponenteCG.alimentazione" labelId="cbAlimentazioneLbl"
	  fieldRequired="true">


<!-- widget cbAlimentazione -->
<s:select name="appDatacomponenteCG.alimentazione" id="widg_cbAlimentazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoCombustibili"
	  disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','cbAlimentazione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tfPotenzaTermica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.tfPotenzaTermica.label')}" labelFor="widg_tfPotenzaTermica" errorFor="appDatacomponenteCG.potenzaTermicaKw" labelId="tfPotenzaTermicaLbl"
	  fieldRequired="true">


<!-- widget tfPotenzaTermica -->
<s:textfield 
	
	
	name="appDatacomponenteCG.potenzaTermicaKw" id="widg_tfPotenzaTermica"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tfPotenzaTermica')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tfPotenzaElettrica')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.tfPotenzaElettrica.label')}" labelFor="widg_tfPotenzaElettrica" errorFor="appDatacomponenteCG.potenzaElettricaKw" labelId="tfPotenzaElettricaLbl"
	  fieldRequired="true">


<!-- widget tfPotenzaElettrica -->
<s:textfield 
	
	
	name="appDatacomponenteCG.potenzaElettricaKw" id="widg_tfPotenzaElettrica"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tfPotenzaElettrica')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpComponente --></div>

			
	
	<div id="p_wpComponenteIntestazione" class="widgetsPanelBlock"><!-- startFragment:p_wpComponenteIntestazione -->
	
	

<div class="widgetsPanel" id="wpComponenteIntestazione">
	
	<customtag:widgetsPanel id="wpComponenteIntestazioneTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="50,0,5,2,5,38">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptlabel1')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptlabel1.label')}" labelFor="widg_ptlabel1" errorFor="widg_ptlabel1" labelId="ptlabel1Lbl"  position="first" >


<!-- widget ptlabel1 -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptlabel2')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptlabel2.label')}" labelFor="widg_ptlabel2" errorFor="widg_ptlabel2" labelId="ptlabel2Lbl"   >


<!-- widget ptlabel2 -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptlabel3')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptlabel3.label')}" labelFor="widg_ptlabel3" errorFor="widg_ptlabel3" labelId="ptlabel3Lbl"  position="last" >


<!-- widget ptlabel3 -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpComponenteIntestazione --></div>

			
	
	<div id="p_wpComponente2" class="widgetsPanelBlock"><!-- startFragment:p_wpComponente2 -->
	
	

<div class="widgetsPanel" id="wpComponente2">
	
	<customtag:widgetsPanel id="wpComponente2Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		percentCols="50,0,5,2,5,38">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptTempUscita')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptTempUscita.label')}" labelFor="widg_ptTempUscita" errorFor="widg_ptTempUscita" labelId="ptTempUscitaLbl"  position="first" >


<!-- widget ptTempUscita -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaH2OUscitaMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaH2OUscitaMin" errorFor="appDatacomponenteCG.temperaturaH2OUscitaMin" labelId="tftemperaturaH2OUscitaMinLbl"
	  >


<!-- widget tftemperaturaH2OUscitaMin -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaH2OUscitaMin" id="widg_tftemperaturaH2OUscitaMin"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaH2OUscitaMin')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaH2OUscitaMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaH2OUscitaMax" errorFor="appDatacomponenteCG.temperaturaH2OUscitaMax" labelId="tftemperaturaH2OUscitaMaxLbl"
	position="last"  >


<!-- widget tftemperaturaH2OUscitaMax -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaH2OUscitaMax" id="widg_tftemperaturaH2OUscitaMax"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaH2OUscitaMax')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptTempIngresso')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptTempIngresso.label')}" labelFor="widg_ptTempIngresso" errorFor="widg_ptTempIngresso" labelId="ptTempIngressoLbl"  position="first" >


<!-- widget ptTempIngresso -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaH2OIngressoMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaH2OIngressoMin" errorFor="appDatacomponenteCG.temperaturaH2OIngressoMin" labelId="tftemperaturaH2OIngressoMinLbl"
	  >


<!-- widget tftemperaturaH2OIngressoMin -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaH2OIngressoMin" id="widg_tftemperaturaH2OIngressoMin"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaH2OIngressoMin')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaH2OIngressoMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaH2OIngressoMax" errorFor="appDatacomponenteCG.temperaturaH2OIngressoMax" labelId="tftemperaturaH2OIngressoMaxLbl"
	position="last"  >


<!-- widget tftemperaturaH2OIngressoMax -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaH2OIngressoMax" id="widg_tftemperaturaH2OIngressoMax"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaH2OIngressoMax')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptTemperaturaMotore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptTemperaturaMotore.label')}" labelFor="widg_ptTemperaturaMotore" errorFor="widg_ptTemperaturaMotore" labelId="ptTemperaturaMotoreLbl"  position="first" >


<!-- widget ptTemperaturaMotore -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaH2OMotoreMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaH2OMotoreMin" errorFor="appDatacomponenteCG.temperaturaH2OMotoreMin" labelId="tftemperaturaH2OMotoreMinLbl"
	  >


<!-- widget tftemperaturaH2OMotoreMin -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaH2OMotoreMin" id="widg_tftemperaturaH2OMotoreMin"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaH2OMotoreMin')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaH2OMotoreMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaH2OMotoreMax" errorFor="appDatacomponenteCG.temperaturaH2OMotoreMax" labelId="tftemperaturaH2OMotoreMaxLbl"
	position="last"  >


<!-- widget tftemperaturaH2OMotoreMax -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaH2OMotoreMax" id="widg_tftemperaturaH2OMotoreMax"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaH2OMotoreMax')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptTempFumiValle')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptTempFumiValle.label')}" labelFor="widg_ptTempFumiValle" errorFor="widg_ptTempFumiValle" labelId="ptTempFumiValleLbl"  position="first" >


<!-- widget ptTempFumiValle -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaFumiValleMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaFumiValleMin" errorFor="appDatacomponenteCG.temperaturaFumiValleMin" labelId="tftemperaturaFumiValleMinLbl"
	  >


<!-- widget tftemperaturaFumiValleMin -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaFumiValleMin" id="widg_tftemperaturaFumiValleMin"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaFumiValleMin')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaFumiValleMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaFumiValleMax" errorFor="appDatacomponenteCG.temperaturaFumiValleMax" labelId="tftemperaturaFumiValleMaxLbl"
	position="last"  >


<!-- widget tftemperaturaFumiValleMax -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaFumiValleMax" id="widg_tftemperaturaFumiValleMax"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaFumiValleMax')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptTemFumiMonte')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptTemFumiMonte.label')}" labelFor="widg_ptTemFumiMonte" errorFor="widg_ptTemFumiMonte" labelId="ptTemFumiMonteLbl"  position="first" >


<!-- widget ptTemFumiMonte -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaFumiMonteMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaFumiMonteMin" errorFor="appDatacomponenteCG.temperaturaFumiMonteMin" labelId="tftemperaturaFumiMonteMinLbl"
	  >


<!-- widget tftemperaturaFumiMonteMin -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaFumiMonteMin" id="widg_tftemperaturaFumiMonteMin"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaFumiMonteMin')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tftemperaturaFumiMonteMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tftemperaturaFumiMonteMax" errorFor="appDatacomponenteCG.temperaturaFumiMonteMax" labelId="tftemperaturaFumiMonteMaxLbl"
	position="last"  >


<!-- widget tftemperaturaFumiMonteMax -->
<s:textfield 
	
	
	name="appDatacomponenteCG.temperaturaFumiMonteMax" id="widg_tftemperaturaFumiMonteMax"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tftemperaturaFumiMonteMax')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','ptEmissioniCO')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.ptEmissioniCO.label')}" labelFor="widg_ptEmissioniCO" errorFor="widg_ptEmissioniCO" labelId="ptEmissioniCOLbl"  position="first" >


<!-- widget ptEmissioniCO -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tfcoMin')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_tfcoMin" errorFor="appDatacomponenteCG.coMin" labelId="tfcoMinLbl"
	  >


<!-- widget tfcoMin -->
<s:textfield 
	
	
	name="appDatacomponenteCG.coMin" id="widg_tfcoMin"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tfcoMin')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','coMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_coMax" errorFor="appDatacomponenteCG.coMax" labelId="coMaxLbl"
	position="last"  >


<!-- widget coMax -->
<s:textfield 
	
	
	name="appDatacomponenteCG.coMax" id="widg_coMax"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','coMax')"
	size="4" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpComponente2 --></div>

			
	
	<div id="p_wpComponente3" class="widgetsPanelBlock"><!-- startFragment:p_wpComponente3 -->
	
	

<div class="widgetsPanel" id="wpComponente3">
	
	<customtag:widgetsPanel id="wpComponente3Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tfManutenzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.tfManutenzione.label')}" labelFor="widg_tfManutenzione" errorFor="appDatacomponenteCG.tempoManutenzione" labelId="tfManutenzioneLbl"
	  fieldRequired="true">


<!-- widget tfManutenzione -->
<s:textfield 
	
	
	name="appDatacomponenteCG.tempoManutenzione" id="widg_tfManutenzione"
maxlength="3"	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','tfManutenzione')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_6Dett.taNote.label')}" labelFor="widg_taNote" errorFor="appDatacomponenteCG.note" labelId="taNoteLbl"
	  >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDatacomponenteCG.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','taNote')"
	rows="2"
	cols="25"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpComponente3 --></div>

			
	
	<div id="p_cpFunGestComponente" class="commandPanelBlock"><!-- startFragment:p_cpFunGestComponente -->
	
	
<div class="commandPanel functional" id="cpFunGestComponente">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','bSostituisciComponente')" >

	



<!-- widget bSostituisciComponente -->
<s:submit name="widg_bSostituisciComponente" id="widg_bSostituisciComponente" method="handleBSostituisciComponente_CLICKED"
	key="cpGestLibScheda4_6Dett.bSostituisciComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','bSostituisciComponente')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','bDismettiComponente')" >

	



<!-- widget bDismettiComponente -->
<s:submit name="widg_bDismettiComponente" id="widg_bDismettiComponente" method="handleBDismettiComponente_CLICKED"
	key="cpGestLibScheda4_6Dett.bDismettiComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','bDismettiComponente')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','bRiattivaComponente')" >

	



<!-- widget bRiattivaComponente -->
<s:submit name="widg_bRiattivaComponente" id="widg_bRiattivaComponente" method="handleBRiattivaComponente_CLICKED"
	key="cpGestLibScheda4_6Dett.bRiattivaComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','bRiattivaComponente')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestComponente --></div>

			
	
	<div id="p_wpComponentiSostituite" class="widgetsPanelBlock"><!-- startFragment:p_wpComponentiSostituite -->
	
	

<div class="widgetsPanel" id="wpComponentiSostituite">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','tbSostituzioni')" >

	
<div class="tableWidget">


<!-- widget tbSostituzioni -->
<s:set name="cpGestLibScheda4_6Dett_tbSostituzioni_clearStatus" value="isTableClearStatus('cpGestLibScheda4_6Dett_tbSostituzioni')" />
<s:url id="cpGestLibScheda4_6DettViewUrl"						   
					   action="cpGestLibScheda4_6Dett"
					   namespace="/base/gestisci_libretto_scheda4_6"/>
<display:table name="appDatalistaStoricoComponentiCG"  				
			   excludedParams="*"			   export="true"
               id="widg_tbSostituzioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda4_6DettViewUrl}"  
               clearStatus="${cpGestLibScheda4_6Dett_tbSostituzioni_clearStatus}"
               uid="row_tbSostituzioni"
               summary="" 
               class="dataTable">
	
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.dataInstallazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.dataInstallazione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.dataInstallazione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.dataDismissione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.dataDismissione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.dataDismissione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.fabbricanteLabel.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.fabbricanteLabel.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.fabbricanteLabel.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="modello" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.modello.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="modello" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.modello.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="modello" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.modello.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="matricola" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.matricola.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="matricola" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.matricola.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="matricola" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.matricola.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.azione.label"
						sortable="false" headerClass="nosort" media="html"
>
				<s:if test="%{#attr.row_tbSostituzioni.flgRipristina == true}">
					<s:url id="targetUrlLinkableCell"						   
						   action="cpGestLibScheda4_6Dett!handleTbSostituzioni_CLICKED"
						   namespace="/base/gestisci_libretto_scheda4_6"
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

		<display:column property="azione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.azione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="azione" titleKey="cpGestLibScheda4_6Dett.tbSostituzioni.azione.export.label"
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
		
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','btRipristinaAttualeDett')" >

	



<!-- widget btRipristinaAttualeDett -->
<s:submit name="widg_btRipristinaAttualeDett" id="widg_btRipristinaAttualeDett" method="handleBtRipristinaAttualeDett_CLICKED"
	key="cpGestLibScheda4_6Dett.btRipristinaAttualeDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','btRipristinaAttualeDett')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','btSalvaDett')" >

	



<!-- widget btSalvaDett -->
<s:submit name="widg_btSalvaDett" id="widg_btSalvaDett" method="handleBtSalvaDett_CLICKED"
	key="cpGestLibScheda4_6Dett.btSalvaDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','btSalvaDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestComponente --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_6Dett','btIndietroDett')" >

	



<!-- widget btIndietroDett -->
<s:submit name="widg_btIndietroDett" id="widg_btIndietroDett" method="handleBtIndietroDett_CLICKED"
	key="cpGestLibScheda4_6Dett.btIndietroDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_6Dett','btIndietroDett')" />

	


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
