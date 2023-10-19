<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_ree_documenti/CpGestisciReeDocumentiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_ree_documenti -->
<!-- pageId:cpGestisciReeDocumenti -->

<s:form id="cpGestisciReeDocumenti" action="cpGestisciReeDocumenti" namespace="/base/gestisci_ree_documenti" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestisciReeDocumenti_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestisciReeDocumenti_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','menuRee')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuTree" 
		widgetType="tree" 
		pageId="cpGestisciReeDocumenti"
		javascriptDetection="false">
	<customtag:tree
		name="appDatareeMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRee"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_ree_documenti/cpGestisciReeDocumenti!handleMenuRee_CLICKED.do"
		nameSpace="/base/gestisci_ree_documenti"
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

	
	

	
	
			
	
	<div id="p_fpElencoDocumenti" class="formPanelBlock"><!-- startFragment:p_fpElencoDocumenti -->
		
	
<h4 class="fpLabel"><s:text name="cpGestisciReeDocumenti.fpElencoDocumenti.label" /></h4>
<div class="formPanel" id="fpElencoDocumenti">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpElencoDocumenti --></div>

			
	
	<div id="p_stdErrorMessageDocumenti" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageDocumenti -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageDocumenti">
	<customtag:stdMessagePanel id="stdErrorMessageDocumenti" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageDocumenti --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestisciReeDocumenti.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestisciReeDocumenti.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestisciReeDocumenti.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestisciReeDocumenti.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDataallegato.dataControllo" labelId="ptDataControlloLbl"  position="first" >


<!-- widget ptDataControllo -->
<s:property value="appDataallegato.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','ptBollino')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestisciReeDocumenti.ptBollino.label')}" labelFor="widg_ptBollino" errorFor="appDataallegato.codiceBollino" labelId="ptBollinoLbl"  position="last" >


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

			
	
	<div id="p_wpElencoDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoDocumenti -->
	
	
<h4 class="wpLabel">documenti associati al REE </h4>
<div class="widgetsPanel" id="wpElencoDocumenti">
	

	
	
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','tblElencoDocumenti')" >

	
<div class="tableWidget">


<!-- widget tblElencoDocumenti -->
	<csiuicore:ajaxify id="p_wpElencoDocumenti" 
		widgetType="table"		
		pageId="cpGestisciReeDocumenti"
		javascriptDetection="false">
<s:set name="cpGestisciReeDocumenti_tblElencoDocumenti_clearStatus" value="isTableClearStatus('cpGestisciReeDocumenti_tblElencoDocumenti')" />
<s:url id="cpGestisciReeDocumentiViewUrl"						   
					   action="cpGestisciReeDocumenti"
					   namespace="/base/gestisci_ree_documenti"/>
<display:table name="appDataelencoDocumenti"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoDocumenti"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestisciReeDocumentiViewUrl}"  
               clearStatus="${cpGestisciReeDocumenti_tblElencoDocumenti_clearStatus}"
               uid="row_tblElencoDocumenti"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoDocumenti.idDocumento}" name="appDataidDocumentoSelezionato" id="%{'tblElencoDocumenti-editcell-'+ (#attr.row_tblElencoDocumenti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="nomeDocOrig" titleKey="cpGestisciReeDocumenti.tblElencoDocumenti.nomeDocOrig.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descAltroDoc" titleKey="cpGestisciReeDocumenti.tblElencoDocumenti.descAltroDoc.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpGestisciReeDocumenti.tblElencoDocumenti.dataUpload.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descStatoDocumento" titleKey="cpGestisciReeDocumenti.tblElencoDocumenti.descStatoDocumento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoDocumenti --></div>

			
	
	<div id="p_cpFunzElencoDocumenti" class="commandPanelBlock"><!-- startFragment:p_cpFunzElencoDocumenti -->
	
	
<div class="commandPanel functional" id="cpFunzElencoDocumenti">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btnVisualizzaDoc')" >

	



<!-- widget btnVisualizzaDoc -->
<s:submit name="widg_btnVisualizzaDoc" id="widg_btnVisualizzaDoc" method="handleBtnVisualizzaDoc_CLICKED"
	key="cpGestisciReeDocumenti.btnVisualizzaDoc.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btnVisualizzaDoc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btnInserisciDocumento')" >

	



<!-- widget btnInserisciDocumento -->
<s:submit name="widg_btnInserisciDocumento" id="widg_btnInserisciDocumento" method="handleBtnInserisciDocumento_CLICKED"
	key="cpGestisciReeDocumenti.btnInserisciDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btnInserisciDocumento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btnEliminaDocumento')" >

	



<!-- widget btnEliminaDocumento -->
<s:submit name="widg_btnEliminaDocumento" id="widg_btnEliminaDocumento" method="handleBtnEliminaDocumento_CLICKED"
	key="cpGestisciReeDocumenti.btnEliminaDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btnEliminaDocumento')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzElencoDocumenti --></div>

			
	
	<div id="p_cpNavElencoAllegatiPerImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavElencoAllegatiPerImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavElencoAllegatiPerImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestisciReeDocumenti','btnIndietroElencoAllegatiImpianti')" >

	



<!-- widget btnIndietroElencoAllegatiImpianti -->
<s:submit name="widg_btnIndietroElencoAllegatiImpianti" id="widg_btnIndietroElencoAllegatiImpianti" method="handleBtnIndietroElencoAllegatiImpianti_CLICKED"
	key="cpGestisciReeDocumenti.btnIndietroElencoAllegatiImpianti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestisciReeDocumenti','btnIndietroElencoAllegatiImpianti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavElencoAllegatiPerImpianto --></div>

			
	
	
	<div id="p_mpDatiDocumento" class="panelBlock"><!-- startFragment:p_mpDatiDocumento -->
		

		
<s:if test="#session.cpGestisciReeDocumenti_mpDatiDocumento_selectedMultiPanel == 'cpGestisciReeDocumenti_mpDatiDocumento_fpDatiDocumento'">
	<s:include value="/jsp/multipanels/cpGestisciReeDocumenti_mpDatiDocumento_fpDatiDocumento.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiDocumento --></div>

	

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
