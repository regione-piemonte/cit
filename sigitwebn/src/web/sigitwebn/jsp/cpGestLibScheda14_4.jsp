<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda14_4/CpGestLibScheda14_4Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda14_4 -->
<!-- pageId:cpGestLibScheda14_4 -->

<s:form id="cpGestLibScheda14_4" action="cpGestLibScheda14_4" namespace="/base/gestisci_libretto_scheda14_4" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda14_4_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda14_4','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda14_4_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda14_4','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda14_4"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda14_4/cpGestLibScheda14_4!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda14_4"
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

	
	

	
	
			
	
	<div id="p_fpScheda14_4" class="formPanelBlock"><!-- startFragment:p_fpScheda14_4 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda14_4.fpScheda14_4.label" /></h4>
<div class="formPanel" id="fpScheda14_4">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda14_4 --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda14_4','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda14_4.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda14_4','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda14_4.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda14_4','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda14_4.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda14_4','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda14_4" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda14_4 -->
	
	
<h4 class="wpLabel">14.4 Consumo di prodotti chimici per il trattamento acqua del circuito dell&apos;impianto termico </h4>
<div class="widgetsPanel" id="wpScheda14_4">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda14_4','tbConsumoProdottiChimici')" >

	
<div class="tableWidget">


<!-- widget tbConsumoProdottiChimici -->
<s:set name="cpGestLibScheda14_4_tbConsumoProdottiChimici_clearStatus" value="isTableClearStatus('cpGestLibScheda14_4_tbConsumoProdottiChimici')" />
<s:url id="cpGestLibScheda14_4ViewUrl"						   
					   action="cpGestLibScheda14_4"
					   namespace="/base/gestisci_libretto_scheda14_4"/>
<display:table name="appDatalistaConsumiTrovati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbConsumoProdottiChimici"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestLibScheda14_4ViewUrl}"  
               clearStatus="${cpGestLibScheda14_4_tbConsumoProdottiChimici_clearStatus}"
               uid="row_tbConsumoProdottiChimici"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbConsumoProdottiChimici.indice}" name="appDatarigheSelezionate" id="%{'tbConsumoProdottiChimici-editcell-'+ (#attr.row_tbConsumoProdottiChimici_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="indice" titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.indice.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.esercizioDa.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].esercizioDa'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.esercizioA.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].esercizioA'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="4" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.flgCircuitoImpTer.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:checkbox name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].flgCircuitoImpTer'}"   disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"  id="%{'widg_tbConsumoProdottiChimici_flgCircuitoImpTer_'+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)}"  theme="csi-tableinput-rem"/>
<s:if test="%{appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"><s:hidden name="%{'__checkbox_appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].flgCircuitoImpTer'}" id="%{'__checkbox_appDatarigheSelezionate_flgCircuitoImpTer_'+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)}" /></s:if>
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.flgCircuitoAcs.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:checkbox name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].flgCircuitoAcs'}"   disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"  id="%{'widg_tbConsumoProdottiChimici_flgCircuitoAcs_'+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)}"  theme="csi-tableinput-rem"/>
<s:if test="%{appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"><s:hidden name="%{'__checkbox_appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].flgCircuitoAcs'}" id="%{'__checkbox_appDatarigheSelezionate_flgCircuitoAcs_'+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)}" /></s:if>
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.flgCircuitoAltri.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:checkbox name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].flgCircuitoAltri'}"   disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"  id="%{'widg_tbConsumoProdottiChimici_flgCircuitoAltri_'+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)}"  theme="csi-tableinput-rem"/>
<s:if test="%{appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"><s:hidden name="%{'__checkbox_appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].flgCircuitoAltri'}" id="%{'__checkbox_appDatarigheSelezionate_flgCircuitoAltri_'+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)}" /></s:if>
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.nomeProdotto.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].nomeProdotto'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="35" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.consumo.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].consumo'}"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"   theme="csi-tableinput-rem" maxlength="16" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda14_4.tbConsumoProdottiChimici.unitaMisura.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDatalistaConsumiTrovati['+(#attr.row_tbConsumoProdottiChimici_rowNum - 1)+'].unitaMisura'}" headerKey="" headerValue=""  list="appDataelencoTipoUnitaMisura"  disabled="%{!appDatalistaConsumiTrovati[(#attr.row_tbConsumoProdottiChimici_rowNum - 1)].datoEditabile}"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
</display:table>

<s:hidden name="__tableselectionempty_appDatarigheSelezionate" id="__tableselectionempty_widg_tbConsumoProdottiChimici" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpScheda14_4 --></div>

			
	
	<div id="p_cpFunGestScheda14_4" class="commandPanelBlock"><!-- startFragment:p_cpFunGestScheda14_4 -->
	
	
<div class="commandPanel functional" id="cpFunGestScheda14_4">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda14_4','btRipristina')" >

	



<!-- widget btRipristina -->
<s:submit name="widg_btRipristina" id="widg_btRipristina" method="handleBtRipristina_CLICKED"
	key="cpGestLibScheda14_4.btRipristina.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_4','btRipristina')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda14_4','btRimuovi')" >

	



<!-- widget btRimuovi -->
<s:submit name="widg_btRimuovi" id="widg_btRimuovi" method="handleBtRimuovi_CLICKED"
	key="cpGestLibScheda14_4.btRimuovi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_4','btRimuovi')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda14_4','btAggiungiConsumo')" >

	



<!-- widget btAggiungiConsumo -->
<s:submit name="widg_btAggiungiConsumo" id="widg_btAggiungiConsumo" method="handleBtAggiungiConsumo_CLICKED"
	key="cpGestLibScheda14_4.btAggiungiConsumo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_4','btAggiungiConsumo')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda14_4','bSalvaScheda')" >

	



<!-- widget bSalvaScheda -->
<s:submit name="widg_bSalvaScheda" id="widg_bSalvaScheda" method="handleBSalvaScheda_CLICKED"
	key="cpGestLibScheda14_4.bSalvaScheda.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_4','bSalvaScheda')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestScheda14_4 --></div>

			
	
	<div id="p_cpNavGestScheda14_4" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda14_4 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda14_4">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda14_4','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda14_4.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda14_4','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda14_4 --></div>

	

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
