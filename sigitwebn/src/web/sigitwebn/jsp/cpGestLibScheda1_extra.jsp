<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda1_extra/CpGestLibScheda1_extraAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda1_extra -->
<!-- pageId:cpGestLibScheda1_extra -->

<s:form id="cpGestLibScheda1_extra" action="cpGestLibScheda1_extra" namespace="/base/gestisci_libretto_scheda1_extra" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda1_extra_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda1_extra_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda1_extra"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda1_extra/cpGestLibScheda1_extra!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda1_extra"
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

	
	

	
	
			
	
	<div id="p_fpScheda1_extra" class="formPanelBlock"><!-- startFragment:p_fpScheda1_extra -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda1_extra.fpScheda1_extra.label" /></h4>
<div class="formPanel" id="fpScheda1_extra">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda1_extra --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1_extra.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1_extra.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda1_extra.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda1_extra" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda1_extra -->
	
	
<h4 class="wpLabel">Dati aggiuntivi </h4>
<div class="widgetsPanel" id="wpScheda1_extra">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','tbPodPdr')" >

	
<div class="tableWidget">


<!-- widget tbPodPdr -->
<s:set name="cpGestLibScheda1_extra_tbPodPdr_clearStatus" value="isTableClearStatus('cpGestLibScheda1_extra_tbPodPdr')" />
<s:url id="cpGestLibScheda1_extraViewUrl"						   
					   action="cpGestLibScheda1_extra"
					   namespace="/base/gestisci_libretto_scheda1_extra"/>
<display:table name="appDatalistaDatiExtra"  				
			   excludedParams="*"			   export="false"
               id="widg_tbPodPdr"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpGestLibScheda1_extraViewUrl}"  
               clearStatus="${cpGestLibScheda1_extra_tbPodPdr_clearStatus}"
               uid="row_tbPodPdr"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbPodPdr.indice}" name="appDatarigheSelezionate" id="%{'tbPodPdr-editcell-'+ (#attr.row_tbPodPdr_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="indice" titleKey="cpGestLibScheda1_extra.tbPodPdr.indice.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestLibScheda1_extra.tbPodPdr.sezione.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaDatiExtra['+(#attr.row_tbPodPdr_rowNum - 1)+'].sezione'}"  disabled="%{!appDatalistaDatiExtra[(#attr.row_tbPodPdr_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="5" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda1_extra.tbPodPdr.foglio.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaDatiExtra['+(#attr.row_tbPodPdr_rowNum - 1)+'].foglio'}"  disabled="%{!appDatalistaDatiExtra[(#attr.row_tbPodPdr_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="5" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda1_extra.tbPodPdr.particella.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaDatiExtra['+(#attr.row_tbPodPdr_rowNum - 1)+'].particella'}"  disabled="%{!appDatalistaDatiExtra[(#attr.row_tbPodPdr_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="9" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda1_extra.tbPodPdr.subalterno.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaDatiExtra['+(#attr.row_tbPodPdr_rowNum - 1)+'].subalterno'}"  disabled="%{!appDatalistaDatiExtra[(#attr.row_tbPodPdr_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda1_extra.tbPodPdr.pod.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaDatiExtra['+(#attr.row_tbPodPdr_rowNum - 1)+'].pod'}"  disabled="%{!appDatalistaDatiExtra[(#attr.row_tbPodPdr_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="15" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda1_extra.tbPodPdr.pdr.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaDatiExtra['+(#attr.row_tbPodPdr_rowNum - 1)+'].pdr'}"  disabled="%{!appDatalistaDatiExtra[(#attr.row_tbPodPdr_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="14" />
		</display:column>
		
</display:table>

<s:hidden name="__tableselectionempty_appDatarigheSelezionate" id="__tableselectionempty_widg_tbPodPdr" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpScheda1_extra --></div>

			
	
	<div id="p_cpFunGestScheda1_extra" class="commandPanelBlock"><!-- startFragment:p_cpFunGestScheda1_extra -->
	
	
<div class="commandPanel functional" id="cpFunGestScheda1_extra">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','btRipristinaConsumo')" >

	



<!-- widget btRipristinaConsumo -->
<s:submit name="widg_btRipristinaConsumo" id="widg_btRipristinaConsumo" method="handleBtRipristinaConsumo_CLICKED"
	key="cpGestLibScheda1_extra.btRipristinaConsumo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda1_extra','btRipristinaConsumo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','btRimuovi')" >

	



<!-- widget btRimuovi -->
<s:submit name="widg_btRimuovi" id="widg_btRimuovi" method="handleBtRimuovi_CLICKED"
	key="cpGestLibScheda1_extra.btRimuovi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda1_extra','btRimuovi')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','btAggiungi')" >

	



<!-- widget btAggiungi -->
<s:submit name="widg_btAggiungi" id="widg_btAggiungi" method="handleBtAggiungi_CLICKED"
	key="cpGestLibScheda1_extra.btAggiungi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda1_extra','btAggiungi')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','bSalvaScheda1_extra')" >

	



<!-- widget bSalvaScheda1_extra -->
<s:submit name="widg_bSalvaScheda1_extra" id="widg_bSalvaScheda1_extra" method="handleBSalvaScheda1_extra_CLICKED"
	key="cpGestLibScheda1_extra.bSalvaScheda1_extra.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda1_extra','bSalvaScheda1_extra')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestScheda1_extra --></div>

			
	
	<div id="p_cpNavGestScheda1_extra" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda1_extra -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda1_extra">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda1_extra','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda1_extra.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda1_extra','btnIndietro')" />

	


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
