<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda11_2/CpGestLibScheda11_2Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda11_2 -->
<!-- pageId:cpGestLibScheda11_2 -->

<s:form id="cpGestLibScheda11_2" action="cpGestLibScheda11_2" namespace="/base/gestisci_libretto_scheda11_2" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda11_2_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda11_2','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda11_2_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda11_2"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda11_2/cpGestLibScheda11_2!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda11_2"
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

	
	

	
	
			
	
	<div id="p_fpScheda11_2" class="formPanelBlock"><!-- startFragment:p_fpScheda11_2 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda11_2.fpScheda11_2.label" /></h4>
<div class="formPanel" id="fpScheda11_2">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda11_2 --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda11_2.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda11_2.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda11_2.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda11Intest" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda11Intest -->
	
	
<h4 class="wpLabel">11.2 Macchine frigo / Pompe di calore </h4>
<div class="widgetsPanel" id="wpScheda11Intest">
	
	<customtag:widgetsPanel id="wpScheda11IntestTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','ptComponente')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda11_2.ptComponente.label')}" labelFor="widg_ptComponente" errorFor="appDatascheda11Intest.componente" labelId="ptComponenteLbl"  position="first" >


<!-- widget ptComponente -->
<s:property value="appDatascheda11Intest.componente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','ptDataContr')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda11_2.ptDataContr.label')}" labelFor="widg_ptDataContr" errorFor="appDatascheda11Intest.dataControllo" labelId="ptDataContrLbl"  position="last" >


<!-- widget ptDataContr -->
<s:property value="appDatascheda11Intest.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpScheda11Intest --></div>

			
	
	<div id="p_wpScheda11_2" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda11_2 -->
	
	

<div class="widgetsPanel" id="wpScheda11_2">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','tbModuli')" >

	
<div class="tableWidget">


<!-- widget tbModuli -->
	<csiuicore:ajaxify id="p_wpScheda11_2" 
		widgetType="table"		
		pageId="cpGestLibScheda11_2"
		javascriptDetection="false">
<s:set name="cpGestLibScheda11_2_tbModuli_clearStatus" value="isTableClearStatus('cpGestLibScheda11_2_tbModuli')" />
<s:url id="cpGestLibScheda11_2ViewUrl"						   
					   action="cpGestLibScheda11_2"
					   namespace="/base/gestisci_libretto_scheda11_2"/>
<display:table name="appDatalistScheda11"  				
			   excludedParams="*"			   export="false"
               id="widg_tbModuli"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda11_2ViewUrl}"  
               clearStatus="${cpGestLibScheda11_2_tbModuli_clearStatus}"
               uid="row_tbModuli"
               summary="" 
               class="dataTable">
	
		<display:column property="intestazione" titleKey="cpGestLibScheda11_2.tbModuli.intestazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col1" titleKey="cpGestLibScheda11_2.tbModuli.col1.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col2" titleKey="cpGestLibScheda11_2.tbModuli.col2.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col3" titleKey="cpGestLibScheda11_2.tbModuli.col3.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col4" titleKey="cpGestLibScheda11_2.tbModuli.col4.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda11_2','tbModuliPag')" >

	
<div class="tableWidget">


<!-- widget tbModuliPag -->
	<csiuicore:ajaxify id="p_wpScheda11_2" 
		widgetType="table"		
		pageId="cpGestLibScheda11_2"
		javascriptDetection="false">
<s:set name="cpGestLibScheda11_2_tbModuliPag_clearStatus" value="isTableClearStatus('cpGestLibScheda11_2_tbModuliPag')" />
<s:url id="cpGestLibScheda11_2ViewUrl"						   
					   action="cpGestLibScheda11_2"
					   namespace="/base/gestisci_libretto_scheda11_2"/>
<display:table name="appDatalistScheda11"  				
			   excludedParams="*"			   export="false"
               id="widg_tbModuliPag"
               pagesize="25"
               keepStatus="true"
               requestURI="${cpGestLibScheda11_2ViewUrl}"  
               clearStatus="${cpGestLibScheda11_2_tbModuliPag_clearStatus}"
               uid="row_tbModuliPag"
               summary="" 
               class="dataTable">
	
		<display:column property="intestazione" titleKey="cpGestLibScheda11_2.tbModuliPag.intestazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col1" titleKey="cpGestLibScheda11_2.tbModuliPag.col1.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col2" titleKey="cpGestLibScheda11_2.tbModuliPag.col2.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col3" titleKey="cpGestLibScheda11_2.tbModuliPag.col3.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="col4" titleKey="cpGestLibScheda11_2.tbModuliPag.col4.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpScheda11_2 --></div>

			
	
	<div id="p_cpNavGestScheda11_2" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda11_2 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda11_2">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda11_2','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda11_2.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda11_2','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda11_2 --></div>

	

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
