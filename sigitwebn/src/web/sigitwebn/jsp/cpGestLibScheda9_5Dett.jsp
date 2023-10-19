<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda9_5/CpGestLibScheda9_5DettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda9_5 -->
<!-- pageId:cpGestLibScheda9_5Dett -->

<s:form id="cpGestLibScheda9_5Dett" action="cpGestLibScheda9_5Dett" namespace="/base/gestisci_libretto_scheda9_5" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda9_5Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda9_5Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda9_5Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda9_5/cpGestLibScheda9_5Dett!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda9_5"
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
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda9_5Dett.fpScheda9Dett.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','wpInfoImpianto_2_2_fictitious_')" >

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','ptTipoComp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.ptTipoComp.label')}" labelFor="widg_ptTipoComp" errorFor="appDatacomponenteUT.idComponente" labelId="ptTipoCompLbl"   >


<!-- widget ptTipoComp -->
<s:property value="appDatacomponenteUT.idComponente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','cDataInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.cDataInstallazione.label')}" labelFor="widg_cDataInstallazione" errorFor="appDatacomponenteUT.dataInstallazione" labelId="cDataInstallazioneLbl"
	  >


<!-- widget cDataInstallazione -->
<s:textfield 
	
	
	name="appDatacomponenteUT.dataInstallazione" id="widg_cDataInstallazione"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','cDataInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','cDataDismissione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.cDataDismissione.label')}" labelFor="widg_cDataDismissione" errorFor="appDatacomponenteUT.dataDismissione" labelId="cDataDismissioneLbl"
	  >


<!-- widget cDataDismissione -->
<s:textfield 
	
	
	name="appDatacomponenteUT.dataDismissione" id="widg_cDataDismissione"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','cDataDismissione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','cbFabbricante')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.cbFabbricante.label')}" labelFor="widg_cbFabbricante" errorFor="appDatacomponenteUT.idFabbricante" labelId="cbFabbricanteLbl"
	  fieldRequired="true">


<!-- widget cbFabbricante -->
<s:select name="appDatacomponenteUT.idFabbricante" id="widg_cbFabbricante"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFabbricante"
	  disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','cbFabbricante')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','tModello')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.tModello.label')}" labelFor="widg_tModello" errorFor="appDatacomponenteUT.modello" labelId="tModelloLbl"
	  fieldRequired="true">


<!-- widget tModello -->
<s:textfield 
	
	
	name="appDatacomponenteUT.modello" id="widg_tModello"
maxlength="33"	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','tModello')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','tMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.tMatricola.label')}" labelFor="widg_tMatricola" errorFor="appDatacomponenteUT.matricola" labelId="tMatricolaLbl"
	  fieldRequired="true">


<!-- widget tMatricola -->
<s:textfield 
	
	
	name="appDatacomponenteUT.matricola" id="widg_tMatricola"
maxlength="30"	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','tMatricola')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','tPortVentMandLs')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.tPortVentMandLs.label')}" labelFor="widg_tPortVentMandLs" errorFor="appDatacomponenteUT.portVentMandLs" labelId="tPortVentMandLsLbl"
	  fieldRequired="true">


<!-- widget tPortVentMandLs -->
<s:textfield 
	
	
	name="appDatacomponenteUT.portVentMandLs" id="widg_tPortVentMandLs"
maxlength="8"	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','tPortVentMandLs')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','tPortVentMandKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.tPortVentMandKw.label')}" labelFor="widg_tPortVentMandKw" errorFor="appDatacomponenteUT.portVentMandKw" labelId="tPortVentMandKwLbl"
	  fieldRequired="true">


<!-- widget tPortVentMandKw -->
<s:textfield 
	
	
	name="appDatacomponenteUT.portVentMandKw" id="widg_tPortVentMandKw"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','tPortVentMandKw')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','tPortVentRipresaLs')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.tPortVentRipresaLs.label')}" labelFor="widg_tPortVentRipresaLs" errorFor="appDatacomponenteUT.portVentRipresaLs" labelId="tPortVentRipresaLsLbl"
	  fieldRequired="true">


<!-- widget tPortVentRipresaLs -->
<s:textfield 
	
	
	name="appDatacomponenteUT.portVentRipresaLs" id="widg_tPortVentRipresaLs"
maxlength="8"	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','tPortVentRipresaLs')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','tPortVentRipresaKw')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda9_5Dett.tPortVentRipresaKw.label')}" labelFor="widg_tPortVentRipresaKw" errorFor="appDatacomponenteUT.portVentRipresaKw" labelId="tPortVentRipresaKwLbl"
	  fieldRequired="true">


<!-- widget tPortVentRipresaKw -->
<s:textfield 
	
	
	name="appDatacomponenteUT.portVentRipresaKw" id="widg_tPortVentRipresaKw"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','tPortVentRipresaKw')"
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
		
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','btSostComp')" >

	



<!-- widget btSostComp -->
<s:submit name="widg_btSostComp" id="widg_btSostComp" method="handleBtSostComp_CLICKED"
	key="cpGestLibScheda9_5Dett.btSostComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','btSostComp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','btDismettiComp')" >

	



<!-- widget btDismettiComp -->
<s:submit name="widg_btDismettiComp" id="widg_btDismettiComp" method="handleBtDismettiComp_CLICKED"
	key="cpGestLibScheda9_5Dett.btDismettiComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','btDismettiComp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','btRiattivaComp')" >

	



<!-- widget btRiattivaComp -->
<s:submit name="widg_btRiattivaComp" id="widg_btRiattivaComp" method="handleBtRiattivaComp_CLICKED"
	key="cpGestLibScheda9_5Dett.btRiattivaComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','btRiattivaComp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestDett --></div>

			
	
	<div id="p_wpSostComp" class="widgetsPanelBlock"><!-- startFragment:p_wpSostComp -->
	
	
<h4 class="wpLabel">Sostituzioni del componente </h4>
<div class="widgetsPanel" id="wpSostComp">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','tbComponenti')" >

	
<div class="tableWidget">


<!-- widget tbComponenti -->
	<csiuicore:ajaxify id="p_fpScheda9Dett,p_stdMsgLibretto,p_wpComp,p_wpSostComp" 
		widgetType="table"		
		pageId="cpGestLibScheda9_5Dett"
		javascriptDetection="false">
<s:set name="cpGestLibScheda9_5Dett_tbComponenti_clearStatus" value="isTableClearStatus('cpGestLibScheda9_5Dett_tbComponenti')" />
<s:url id="cpGestLibScheda9_5DettViewUrl"						   
					   action="cpGestLibScheda9_5Dett"
					   namespace="/base/gestisci_libretto_scheda9_5"/>
<display:table name="appDatalistaComponentiUT"  				
			   excludedParams="*"			   export="false"
               id="widg_tbComponenti"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpGestLibScheda9_5DettViewUrl}"  
               clearStatus="${cpGestLibScheda9_5Dett_tbComponenti_clearStatus}"
               uid="row_tbComponenti"
               summary="" 
               class="dataTable">
	
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda9_5Dett.tbComponenti.dataInstallazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataDismissione" titleKey="cpGestLibScheda9_5Dett.tbComponenti.dataDismissione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descFabbricante" titleKey="cpGestLibScheda9_5Dett.tbComponenti.descFabbricante.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="modello" titleKey="cpGestLibScheda9_5Dett.tbComponenti.modello.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestLibScheda9_5Dett.tbComponenti.ripristina.label"
						sortable="false" headerClass="nosort" media="html"
>
				<s:if test="%{#attr.row_tbComponenti.ripristinaAttivabile == true}">
					<s:url id="targetUrlLinkableCell"						   
						   action="cpGestLibScheda9_5Dett!handleTbComponenti_CLICKED"
						   namespace="/base/gestisci_libretto_scheda9_5"
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
		
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','btRipristina')" >

	



<!-- widget btRipristina -->
<s:submit name="widg_btRipristina" id="widg_btRipristina" method="handleBtRipristina_CLICKED"
	key="cpGestLibScheda9_5Dett.btRipristina.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','btRipristina')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpGestLibScheda9_5Dett.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','btSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	<div id="p_cpNavGestScheda1_extra" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda1_extra -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda1_extra">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda9_5Dett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda9_5Dett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda9_5Dett','btnIndietro')" />

	


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
