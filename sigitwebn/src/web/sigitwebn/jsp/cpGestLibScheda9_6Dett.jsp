<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda9_6/CpGestLibScheda9_6DettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda9_6 -->
<!-- pageId:cpGestLibScheda9_6Dett -->

<s:form id="cpGestLibScheda9_6Dett" action="cpGestLibScheda9_6Dett" namespace="/base/gestisci_libretto_scheda9_6" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda9_6Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda9_6Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda9_6Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda9_6/cpGestLibScheda9_6Dett!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda9_6"
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

	
	

	
	
			
	
	<div id="p_fpScheda9Dett" class="formPanelBlock"><!-- startFragment:p_fpScheda9Dett -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda9_6Dett.fpScheda9Dett.label" /></h4>
<div class="formPanel" id="fpScheda9Dett">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda9Dett --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpComp" class="widgetsPanelBlock"><!-- startFragment:p_wpComp -->
	
	
<h4 class="wpLabel">Componente attiva </h4>
<div class="widgetsPanel" id="wpComp">
	
	<customtag:widgetsPanel id="wpCompTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','ptTipoComp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.ptTipoComp.label')}" labelFor="widg_ptTipoComp" errorFor="appDatacomponenteRC.idComponente" labelId="ptTipoCompLbl"   >


<!-- widget ptTipoComp -->
<s:property value="appDatacomponenteRC.idComponente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','cDataInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.cDataInstallazione.label')}" labelFor="widg_cDataInstallazione" errorFor="appDatacomponenteRC.dataInstallazione" labelId="cDataInstallazioneLbl"
	  >


<!-- widget cDataInstallazione -->
<s:textfield 
	
	
	name="appDatacomponenteRC.dataInstallazione" id="widg_cDataInstallazione"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','cDataInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','cDataDismissione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.cDataDismissione.label')}" labelFor="widg_cDataDismissione" errorFor="appDatacomponenteRC.dataDismissione" labelId="cDataDismissioneLbl"
	  >


<!-- widget cDataDismissione -->
<s:textfield 
	
	
	name="appDatacomponenteRC.dataDismissione" id="widg_cDataDismissione"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','cDataDismissione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','tTipologia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.tTipologia.label')}" labelFor="widg_tTipologia" errorFor="appDatacomponenteRC.tipologia" labelId="tTipologiaLbl"
	  fieldRequired="true">


<!-- widget tTipologia -->
<s:textfield 
	
	
	name="appDatacomponenteRC.tipologia" id="widg_tTipologia"
maxlength="33"	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','tTipologia')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','cbTipoInst')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.cbTipoInst.label')}" labelFor="widg_cbTipoInst" errorFor="appDatacomponenteRC.tipoInstall" labelId="cbTipoInstLbl"
	  fieldRequired="true">


<!-- widget cbTipoInst -->
<s:select name="appDatacomponenteRC.tipoInstall" id="widg_cbTipoInst"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoInstallazione"
	  disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','cbTipoInst')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','tPortVentMandLs')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.tPortVentMandLs.label')}" labelFor="widg_tPortVentMandLs" errorFor="appDatacomponenteRC.portVentMandLs" labelId="tPortVentMandLsLbl"
	  >


<!-- widget tPortVentMandLs -->
<s:textfield 
	
	
	name="appDatacomponenteRC.portVentMandLs" id="widg_tPortVentMandLs"
maxlength="8"	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','tPortVentMandLs')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','tPortVentMandKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.tPortVentMandKw.label')}" labelFor="widg_tPortVentMandKw" errorFor="appDatacomponenteRC.portVentMandKw" labelId="tPortVentMandKwLbl"
	  >


<!-- widget tPortVentMandKw -->
<s:textfield 
	
	
	name="appDatacomponenteRC.portVentMandKw" id="widg_tPortVentMandKw"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','tPortVentMandKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','tPortVentRipresaLs')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.tPortVentRipresaLs.label')}" labelFor="widg_tPortVentRipresaLs" errorFor="appDatacomponenteRC.portVentRipresaLs" labelId="tPortVentRipresaLsLbl"
	  >


<!-- widget tPortVentRipresaLs -->
<s:textfield 
	
	
	name="appDatacomponenteRC.portVentRipresaLs" id="widg_tPortVentRipresaLs"
maxlength="8"	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','tPortVentRipresaLs')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','tPortVentRipresaKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_6Dett.tPortVentRipresaKw.label')}" labelFor="widg_tPortVentRipresaKw" errorFor="appDatacomponenteRC.portVentRipresaKw" labelId="tPortVentRipresaKwLbl"
	  >


<!-- widget tPortVentRipresaKw -->
<s:textfield 
	
	
	name="appDatacomponenteRC.portVentRipresaKw" id="widg_tPortVentRipresaKw"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','tPortVentRipresaKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpComp --></div>

			
	
	<div id="p_cpFunGestDett" class="commandPanelBlock"><!-- startFragment:p_cpFunGestDett -->
	
	
<div class="commandPanel functional" id="cpFunGestDett">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','btSostComp')" >

	



<!-- widget btSostComp -->
<s:submit name="widg_btSostComp" id="widg_btSostComp" method="handleBtSostComp_CLICKED"
	key="cpGestLibScheda9_6Dett.btSostComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','btSostComp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','btDismettiComp')" >

	



<!-- widget btDismettiComp -->
<s:submit name="widg_btDismettiComp" id="widg_btDismettiComp" method="handleBtDismettiComp_CLICKED"
	key="cpGestLibScheda9_6Dett.btDismettiComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','btDismettiComp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','btRiattivaComp')" >

	



<!-- widget btRiattivaComp -->
<s:submit name="widg_btRiattivaComp" id="widg_btRiattivaComp" method="handleBtRiattivaComp_CLICKED"
	key="cpGestLibScheda9_6Dett.btRiattivaComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','btRiattivaComp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestDett --></div>

			
	
	<div id="p_wpSostComp" class="widgetsPanelBlock"><!-- startFragment:p_wpSostComp -->
	
	
<h4 class="wpLabel">Sostituzioni del componente </h4>
<div class="widgetsPanel" id="wpSostComp">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','tbComponenti')" >

	
<div class="tableWidget">


<!-- widget tbComponenti -->
	<csiuicore:ajaxify id="p_fpScheda9Dett,p_stdMsgLibretto,p_wpComp,p_wpSostComp" 
		widgetType="table"		
		pageId="cpGestLibScheda9_6Dett"
		javascriptDetection="false">
<s:set name="cpGestLibScheda9_6Dett_tbComponenti_clearStatus" value="isTableClearStatus('cpGestLibScheda9_6Dett_tbComponenti')" />
<s:url id="cpGestLibScheda9_6DettViewUrl"						   
					   action="cpGestLibScheda9_6Dett"
					   namespace="/base/gestisci_libretto_scheda9_6"/>
<display:table name="appDatalistaComponentiRC"  				
			   excludedParams="*"			   export="false"
               id="widg_tbComponenti"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpGestLibScheda9_6DettViewUrl}"  
               clearStatus="${cpGestLibScheda9_6Dett_tbComponenti_clearStatus}"
               uid="row_tbComponenti"
               summary="" 
               class="dataTable">
	
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda9_6Dett.tbComponenti.dataInstallazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataDismissione" titleKey="cpGestLibScheda9_6Dett.tbComponenti.dataDismissione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipologia" titleKey="cpGestLibScheda9_6Dett.tbComponenti.tipologia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestLibScheda9_6Dett.tbComponenti.ripristina.label"
						sortable="false" headerClass="nosort" media="html"
>
				<s:if test="%{#attr.row_tbComponenti.ripristinaAttivabile == true}">
					<s:url id="targetUrlLinkableCell"						   
						   action="cpGestLibScheda9_6Dett!handleTbComponenti_CLICKED"
						   namespace="/base/gestisci_libretto_scheda9_6"
						   includeParams="none">
						<s:param name="idRiga"  value="%{#attr.row_tbComponenti.idComponente}"/>
						<s:param name="idColonna">ripristina</s:param>
					</s:url>
					<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
						<s:property value="%{#attr.row_tbComponenti.ripristina}"/>
					</s:a>
				</s:if>
				<s:else>
					<s:property value="%{#attr.row_tbComponenti.ripristina}"/>
				</s:else>
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpSostComp --></div>

			
	
	<div id="p_cpFunGest" class="commandPanelBlock"><!-- startFragment:p_cpFunGest -->
	
	
<div class="commandPanel functional" id="cpFunGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','btRipristina')" >

	



<!-- widget btRipristina -->
<s:submit name="widg_btRipristina" id="widg_btRipristina" method="handleBtRipristina_CLICKED"
	key="cpGestLibScheda9_6Dett.btRipristina.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','btRipristina')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpGestLibScheda9_6Dett.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','btSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	<div id="p_cpNavGestScheda1_extra" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda1_extra -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda1_extra">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda9_6Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda9_6Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_6Dett','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda1_extra --></div>

	

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
