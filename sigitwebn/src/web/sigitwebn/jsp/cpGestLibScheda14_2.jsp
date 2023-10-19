<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda14_2/CpGestLibScheda14_2Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda14_2 -->
<!-- pageId:cpGestLibScheda14_2 -->

<s:form id="cpGestLibScheda14_2" action="cpGestLibScheda14_2" namespace="/base/gestisci_libretto_scheda14_2" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda14_2_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda14_2','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda14_2_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda14_2','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda14_2"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda14_2/cpGestLibScheda14_2!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda14_2"
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

	
	

	
	
			
	
	<div id="p_fpScheda14_2" class="formPanelBlock"><!-- startFragment:p_fpScheda14_2 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda14_2.fpScheda14_2.label" /></h4>
<div class="formPanel" id="fpScheda14_2">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda14_2 --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda14_2','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda14_2.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda14_2','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda14_2.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda14_2','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda14_2.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda14_2','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda14_2" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda14_2 -->
	
	
<h4 class="wpLabel">14.2 Consumo di energia elettrica </h4>
<div class="widgetsPanel" id="wpScheda14_2">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda14_2','tbConsumoCombustibile')" >

	
<div class="tableWidget">


<!-- widget tbConsumoCombustibile -->
<s:set name="cpGestLibScheda14_2_tbConsumoCombustibile_clearStatus" value="isTableClearStatus('cpGestLibScheda14_2_tbConsumoCombustibile')" />
<s:url id="cpGestLibScheda14_2ViewUrl"						   
					   action="cpGestLibScheda14_2"
					   namespace="/base/gestisci_libretto_scheda14_2"/>
<display:table name="appDatalistaConsumiTrovati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbConsumoCombustibile"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestLibScheda14_2ViewUrl}"  
               clearStatus="${cpGestLibScheda14_2_tbConsumoCombustibile_clearStatus}"
               uid="row_tbConsumoCombustibile"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbConsumoCombustibile.indice}" name="appDatarigheSelezionate" id="%{'tbConsumoCombustibile-editcell-'+ (#attr.row_tbConsumoCombustibile_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="indice" titleKey="cpGestLibScheda14_2.tbConsumoCombustibile.indice.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestLibScheda14_2.tbConsumoCombustibile.esercizioDa.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].esercizioDa'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoCombustibile_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_2.tbConsumoCombustibile.esercizioA.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].esercizioA'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoCombustibile_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_2.tbConsumoCombustibile.letturaIniziale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].letturaIniziale'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoCombustibile_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="16" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_2.tbConsumoCombustibile.letturaFinale.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].letturaFinale'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoCombustibile_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="16" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_2.tbConsumoCombustibile.consumo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoCombustibile_rowNum - 1)+'].consumo'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoCombustibile_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="16" />
		</display:column>
		
</display:table>

<s:hidden name="__tableselectionempty_appDatarigheSelezionate" id="__tableselectionempty_widg_tbConsumoCombustibile" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpScheda14_2 --></div>

			
	
	<div id="p_cpFunGestScheda14_2" class="commandPanelBlock"><!-- startFragment:p_cpFunGestScheda14_2 -->
	
	
<div class="commandPanel functional" id="cpFunGestScheda14_2">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda14_2','btRipristinaConsumo')" >

	



<!-- widget btRipristinaConsumo -->
<s:submit name="widg_btRipristinaConsumo" id="widg_btRipristinaConsumo" method="handleBtRipristinaConsumo_CLICKED"
	key="cpGestLibScheda14_2.btRipristinaConsumo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_2','btRipristinaConsumo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda14_2','btRimuoviConsumo')" >

	



<!-- widget btRimuoviConsumo -->
<s:submit name="widg_btRimuoviConsumo" id="widg_btRimuoviConsumo" method="handleBtRimuoviConsumo_CLICKED"
	key="cpGestLibScheda14_2.btRimuoviConsumo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_2','btRimuoviConsumo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda14_2','btAggiungiConsumo')" >

	



<!-- widget btAggiungiConsumo -->
<s:submit name="widg_btAggiungiConsumo" id="widg_btAggiungiConsumo" method="handleBtAggiungiConsumo_CLICKED"
	key="cpGestLibScheda14_2.btAggiungiConsumo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_2','btAggiungiConsumo')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda14_2','bSalvaScheda')" >

	



<!-- widget bSalvaScheda -->
<s:submit name="widg_bSalvaScheda" id="widg_bSalvaScheda" method="handleBSalvaScheda_CLICKED"
	key="cpGestLibScheda14_2.bSalvaScheda.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_2','bSalvaScheda')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestScheda14_2 --></div>

			
	
	<div id="p_cpNavGestScheda14_2" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda14_2 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda14_2">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda14_2','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda14_2.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_2','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda14_2 --></div>

	

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
