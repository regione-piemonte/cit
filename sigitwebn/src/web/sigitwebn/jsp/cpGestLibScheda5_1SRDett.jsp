<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda5_1sr/CpGestLibScheda5_1SRDettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda5_1SR -->
<!-- pageId:cpGestLibScheda5_1SRDett -->

<s:form id="cpGestLibScheda5_1SRDett" action="cpGestLibScheda5_1SRDett" namespace="/base/gestisci_libretto_scheda5_1SR" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda5_1SRDett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda5_1SRDett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda5_1SRDett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda5_1SR/cpGestLibScheda5_1SRDett!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda5_1SR"
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

	
	

	
	
			
	
	<div id="p_fpScheda8Dett" class="formPanelBlock"><!-- startFragment:p_fpScheda8Dett -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda5_1SRDett.fpScheda8Dett.label" /></h4>
<div class="formPanel" id="fpScheda8Dett">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda8Dett --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','wpInfoImpianto_2_2_fictitious_')" >

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','ptTipoComp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.ptTipoComp.label')}" labelFor="widg_ptTipoComp" errorFor="appDatacomponenteSR.idComponente" labelId="ptTipoCompLbl"   >


<!-- widget ptTipoComp -->
<s:property value="appDatacomponenteSR.idComponente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','cDataInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.cDataInstallazione.label')}" labelFor="widg_cDataInstallazione" errorFor="appDatacomponenteSR.dataInstallazione" labelId="cDataInstallazioneLbl"
	  fieldRequired="true">


<!-- widget cDataInstallazione -->
<s:textfield 
	
	
	name="appDatacomponenteSR.dataInstallazione" id="widg_cDataInstallazione"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','cDataInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','cDataDismissione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.cDataDismissione.label')}" labelFor="widg_cDataDismissione" errorFor="appDatacomponenteSR.dataDismissione" labelId="cDataDismissioneLbl"
	  >


<!-- widget cDataDismissione -->
<s:textfield 
	
	
	name="appDatacomponenteSR.dataDismissione" id="widg_cDataDismissione"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','cDataDismissione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','cbFabbricante')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.cbFabbricante.label')}" labelFor="widg_cbFabbricante" errorFor="appDatacomponenteSR.idFabbricante" labelId="cbFabbricanteLbl"
	  fieldRequired="true">


<!-- widget cbFabbricante -->
<s:select name="appDatacomponenteSR.idFabbricante" id="widg_cbFabbricante"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFabbricante"
	  disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','cbFabbricante')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','tModello')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.tModello.label')}" labelFor="widg_tModello" errorFor="appDatacomponenteSR.modello" labelId="tModelloLbl"
	  fieldRequired="true">


<!-- widget tModello -->
<s:textfield 
	
	
	name="appDatacomponenteSR.modello" id="widg_tModello"
maxlength="33"	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','tModello')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','tNumPunti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.tNumPunti.label')}" labelFor="widg_tNumPunti" errorFor="appDatacomponenteSR.numPunti" labelId="tNumPuntiLbl"
	  fieldRequired="true">


<!-- widget tNumPunti -->
<s:textfield 
	
	
	name="appDatacomponenteSR.numPunti" id="widg_tNumPunti"
maxlength="4"	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','tNumPunti')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','tNumLivelli')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda5_1SRDett.tNumLivelli.label')}" labelFor="widg_tNumLivelli" errorFor="appDatacomponenteSR.numLivelli" labelId="tNumLivelliLbl"
	  fieldRequired="true">


<!-- widget tNumLivelli -->
<s:textfield 
	
	
	name="appDatacomponenteSR.numLivelli" id="widg_tNumLivelli"
maxlength="3"	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','tNumLivelli')"
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
		
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','btSostComp')" >

	



<!-- widget btSostComp -->
<s:submit name="widg_btSostComp" id="widg_btSostComp" method="handleBtSostComp_CLICKED"
	key="cpGestLibScheda5_1SRDett.btSostComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','btSostComp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','btDismettiComp')" >

	



<!-- widget btDismettiComp -->
<s:submit name="widg_btDismettiComp" id="widg_btDismettiComp" method="handleBtDismettiComp_CLICKED"
	key="cpGestLibScheda5_1SRDett.btDismettiComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','btDismettiComp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','btRiattivaComp')" >

	



<!-- widget btRiattivaComp -->
<s:submit name="widg_btRiattivaComp" id="widg_btRiattivaComp" method="handleBtRiattivaComp_CLICKED"
	key="cpGestLibScheda5_1SRDett.btRiattivaComp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','btRiattivaComp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestDett --></div>

			
	
	<div id="p_wpSostComp" class="widgetsPanelBlock"><!-- startFragment:p_wpSostComp -->
	
	
<h4 class="wpLabel">Sostituzioni del componente </h4>
<div class="widgetsPanel" id="wpSostComp">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','tbComponenti')" >

	
<div class="tableWidget">


<!-- widget tbComponenti -->
	<csiuicore:ajaxify id="p_fpScheda8Dett,p_stdMsgLibretto,p_wpComp,p_wpSostComp" 
		widgetType="table"		
		pageId="cpGestLibScheda5_1SRDett"
		javascriptDetection="false">
<s:set name="cpGestLibScheda5_1SRDett_tbComponenti_clearStatus" value="isTableClearStatus('cpGestLibScheda5_1SRDett_tbComponenti')" />
<s:url id="cpGestLibScheda5_1SRDettViewUrl"						   
					   action="cpGestLibScheda5_1SRDett"
					   namespace="/base/gestisci_libretto_scheda5_1SR"/>
<display:table name="appDatalistaComponentiSR"  				
			   excludedParams="*"			   export="false"
               id="widg_tbComponenti"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpGestLibScheda5_1SRDettViewUrl}"  
               clearStatus="${cpGestLibScheda5_1SRDett_tbComponenti_clearStatus}"
               uid="row_tbComponenti"
               summary="" 
               class="dataTable">
	
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda5_1SRDett.tbComponenti.dataInstallazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataDismissione" titleKey="cpGestLibScheda5_1SRDett.tbComponenti.dataDismissione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descFabbricante" titleKey="cpGestLibScheda5_1SRDett.tbComponenti.descFabbricante.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="modello" titleKey="cpGestLibScheda5_1SRDett.tbComponenti.modello.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestLibScheda5_1SRDett.tbComponenti.ripristina.label"
						sortable="false" headerClass="nosort" media="html"
>
				<s:if test="%{#attr.row_tbComponenti.ripristinaAttivabile == true}">
					<s:url id="targetUrlLinkableCell"						   
						   action="cpGestLibScheda5_1SRDett!handleTbComponenti_CLICKED"
						   namespace="/base/gestisci_libretto_scheda5_1SR"
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
		
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','btRipristina')" >

	



<!-- widget btRipristina -->
<s:submit name="widg_btRipristina" id="widg_btRipristina" method="handleBtRipristina_CLICKED"
	key="cpGestLibScheda5_1SRDett.btRipristina.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','btRipristina')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpGestLibScheda5_1SRDett.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','btSalva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	<div id="p_cpNavGestScheda1_extra" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda1_extra -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda1_extra">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda5_1SRDett','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda5_1SRDett.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda5_1SRDett','btnIndietro')" />

	


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
