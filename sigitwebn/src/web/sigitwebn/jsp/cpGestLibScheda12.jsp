<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda12/CpGestLibScheda12Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda12 -->
<!-- pageId:cpGestLibScheda12 -->

<s:form id="cpGestLibScheda12" action="cpGestLibScheda12" namespace="/base/gestisci_libretto_scheda12" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda12_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda12','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda12_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda12','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda12"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda12/cpGestLibScheda12!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda12"
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

	
	

	
	
			
	
	<div id="p_fpScheda12" class="formPanelBlock"><!-- startFragment:p_fpScheda12 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda12.fpScheda12.label" /></h4>
<div class="formPanel" id="fpScheda12">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda12 --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda12','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda12.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda12','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda12.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda12','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda12.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda12','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda12" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda12 -->
	
	

<div class="widgetsPanel" id="wpScheda12">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda12','tbInterventi')" >

	
<div class="tableWidget">


<!-- widget tbInterventi -->
	<csiuicore:ajaxify id="p_wpScheda12" 
		widgetType="table"		
		pageId="cpGestLibScheda12"
		javascriptDetection="false">
<s:set name="cpGestLibScheda12_tbInterventi_clearStatus" value="isTableClearStatus('cpGestLibScheda12_tbInterventi')" />
<s:url id="cpGestLibScheda12ViewUrl"						   
					   action="cpGestLibScheda12"
					   namespace="/base/gestisci_libretto_scheda12"/>
<display:table name="appDatascheda12"  				
			   excludedParams="*"			   export="false"
               id="widg_tbInterventi"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpGestLibScheda12ViewUrl}"  
               clearStatus="${cpGestLibScheda12_tbInterventi_clearStatus}"
               uid="row_tbInterventi"
               summary="" 
decorator="it.csi.sigit.sigitwebn.presentation.decorator.gestisci_libretto_scheda12.CpGestLibScheda12TbInterventiCustomDecorator"               class="dataTable">
	
		<display:column property="dataControllo" titleKey="cpGestLibScheda12.tbInterventi.dataControllo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="ragSocManut" titleKey="cpGestLibScheda12.tbInterventi.ragSocManut.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="CCIAA" titleKey="cpGestLibScheda12.tbInterventi.CCIAA.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="desctipoAllegato" titleKey="cpGestLibScheda12.tbInterventi.desctipoAllegato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descFlgRaccomand" titleKey="cpGestLibScheda12.tbInterventi.descFlgRaccomand.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descFlgPrescrizioni" titleKey="cpGestLibScheda12.tbInterventi.descFlgPrescrizioni.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="elencoComponenti" titleKey="cpGestLibScheda12.tbInterventi.elencoComponenti.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpScheda12 --></div>

			
	
	<div id="p_cpNavGestScheda12" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda12 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda12">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda12','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda12.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda12','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda12 --></div>

	

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
