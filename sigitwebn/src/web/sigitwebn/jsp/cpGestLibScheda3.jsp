<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda3/CpGestLibScheda3Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda3 -->
<!-- pageId:cpGestLibScheda3 -->

<s:form id="cpGestLibScheda3" action="cpGestLibScheda3" namespace="/base/gestisci_libretto_scheda3" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda3_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda3','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda3_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda3"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda3/cpGestLibScheda3!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda3"
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

	
	

	
	
			
	
	<div id="p_fpScheda3" class="formPanelBlock"><!-- startFragment:p_fpScheda3 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda3.fpScheda3.label" /></h4>
<div class="formPanel" id="fpScheda3">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda3 --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','cbCodImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.cbCodImp.label')}" labelFor="widg_cbCodImp" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="cbCodImpLbl"  position="first" >


<!-- widget cbCodImp -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda3','cbIndirizzo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.cbIndirizzo.label')}" labelFor="widg_cbIndirizzo" errorFor="appDataidentificativoImpianto.ubicazione" labelId="cbIndirizzoLbl"  position="last" >


<!-- widget cbIndirizzo -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda3','cbDenomResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.cbDenomResponsabile.label')}" labelFor="widg_cbDenomResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="cbDenomResponsabileLbl"  position="first" >


<!-- widget cbDenomResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda3','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda -->
	
	
<h4 class="wpLabel">elenco terza responsabilita' </h4>
<div class="widgetsPanel" id="wpScheda">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','tbRespImpianto3Resp')" >

	
<div class="tableWidget">


<!-- widget tbRespImpianto3Resp -->
	<csiuicore:ajaxify id="p_wpScheda" 
		widgetType="table"		
		pageId="cpGestLibScheda3"
		javascriptDetection="false">
<s:set name="cpGestLibScheda3_tbRespImpianto3Resp_clearStatus" value="isTableClearStatus('cpGestLibScheda3_tbRespImpianto3Resp')" />
<s:url id="cpGestLibScheda3ViewUrl"						   
					   action="cpGestLibScheda3"
					   namespace="/base/gestisci_libretto_scheda3"/>
<display:table name="appDataelencoDettaglioTerzoResponsabile"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRespImpianto3Resp"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpGestLibScheda3ViewUrl}"  
               clearStatus="${cpGestLibScheda3_tbRespImpianto3Resp_clearStatus}"
               uid="row_tbRespImpianto3Resp"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRespImpianto3Resp.idContratto}" name="appDataidContrattoSelez" id="%{'tbRespImpianto3Resp-editcell-'+ (#attr.row_tbRespImpianto3Resp_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="denominazioneImp" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.denominazioneImp.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="responsabile" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.responsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataInizioContratto" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.dataInizioContratto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataFineContratto" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.dataFineContratto.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="descTacitoRinnovo" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.descTacitoRinnovo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataRevoca" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.dataRevoca.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCaricContratto" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.dataCaricContratto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCaricRevoca" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.dataCaricRevoca.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="desTipoCessazione" titleKey="cpGestLibScheda3.tbRespImpianto3Resp.desTipoCessazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpScheda --></div>

			
	
	<div id="p_cpFunGest" class="commandPanelBlock"><!-- startFragment:p_cpFunGest -->
	
	
<div class="commandPanel functional" id="cpFunGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btnVisRev3Resp')" >

	



<!-- widget btnVisRev3Resp -->
<s:submit name="widg_btnVisRev3Resp" id="widg_btnVisRev3Resp" method="handleBtnVisRev3Resp_CLICKED"
	key="cpGestLibScheda3.btnVisRev3Resp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btnVisRev3Resp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda3','btnDettRev3Resp')" >

	



<!-- widget btnDettRev3Resp -->
<s:submit name="widg_btnDettRev3Resp" id="widg_btnDettRev3Resp" method="handleBtnDettRev3Resp_CLICKED"
	key="cpGestLibScheda3.btnDettRev3Resp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btnDettRev3Resp')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	
	<div id="p_mpDataRevoca" class="panelBlock"><!-- startFragment:p_mpDataRevoca -->
		

		
<s:if test="#session.cpGestLibScheda3_mpDataRevoca_selectedMultiPanel == 'cpGestLibScheda3_mpDataRevoca_fpMpRevoca'">
	<s:include value="/jsp/multipanels/cpGestLibScheda3_mpDataRevoca_fpMpRevoca.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDataRevoca --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btnIndietroRoot')" >

	



<!-- widget btnIndietroRoot -->
<s:submit name="widg_btnIndietroRoot" id="widg_btnIndietroRoot" method="handleBtnIndietroRoot_CLICKED"
	key="cpGestLibScheda3.btnIndietroRoot.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btnIndietroRoot')" />

	


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
