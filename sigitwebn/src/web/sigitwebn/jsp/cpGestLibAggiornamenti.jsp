<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_aggiornamenti/CpGestLibAggiornamentiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_aggiornamenti -->
<!-- pageId:cpGestLibAggiornamenti -->

<s:form id="cpGestLibAggiornamenti" action="cpGestLibAggiornamenti" namespace="/base/gestisci_libretto_aggiornamenti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibAggiornamenti_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibAggiornamenti_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibAggiornamenti"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_aggiornamenti/cpGestLibAggiornamenti!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_aggiornamenti"
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

	
	

	
	
			
	
	<div id="p_fpAggLibretti" class="formPanelBlock"><!-- startFragment:p_fpAggLibretti -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibAggiornamenti.fpAggLibretti.label" /></h4>
<div class="formPanel" id="fpAggLibretti">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpAggLibretti --></div>

			
	
	<div id="p_stdMsgAggLibretti" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgAggLibretti -->
	
	
<div class="stdMessagePanel" id="stdMsgAggLibretti">
	<customtag:stdMessagePanel id="stdMsgAggLibretti" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgAggLibretti --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpInfoControlli" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoControlli -->
	
	
<h4 class="wpLabel">controlli libretto WEB </h4>
<div class="widgetsPanel" id="wpInfoControlli">
	
	<customtag:widgetsPanel id="wpInfoControlliTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptDataAgg')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptDataAgg.label')}" labelFor="widg_ptDataAgg" errorFor="appDatacontrolloLibretto.dataAggiornamento" labelId="ptDataAggLbl"   >


<!-- widget ptDataAgg -->
<s:property value="appDatacontrolloLibretto.dataAggiornamento" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptScheda1')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptScheda1.label')}" labelFor="widg_ptScheda1" errorFor="appDatacontrolloLibretto.descControlloScheda1" labelId="ptScheda1Lbl"   >


<!-- widget ptScheda1 -->
<s:property value="appDatacontrolloLibretto.descControlloScheda1" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptScheda5')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptScheda5.label')}" labelFor="widg_ptScheda5" errorFor="appDatacontrolloLibretto.descControlloScheda5" labelId="ptScheda5Lbl"   >


<!-- widget ptScheda5 -->
<s:property value="appDatacontrolloLibretto.descControlloScheda5" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptScheda6')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptScheda6.label')}" labelFor="widg_ptScheda6" errorFor="appDatacontrolloLibretto.descControlloScheda6" labelId="ptScheda6Lbl"   >


<!-- widget ptScheda6 -->
<s:property value="appDatacontrolloLibretto.descControlloScheda6" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptScheda7')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptScheda7.label')}" labelFor="widg_ptScheda7" errorFor="appDatacontrolloLibretto.descControlloScheda7" labelId="ptScheda7Lbl"   >


<!-- widget ptScheda7 -->
<s:property value="appDatacontrolloLibretto.descControlloScheda7" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','ptCompNonContr')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibAggiornamenti.ptCompNonContr.label')}" labelFor="widg_ptCompNonContr" errorFor="appDatacontrolloLibretto.descCompNonContr" labelId="ptCompNonContrLbl"   >


<!-- widget ptCompNonContr -->
<s:property value="appDatacontrolloLibretto.descCompNonContr" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoControlli --></div>

			
	
	<div id="p_wpVerificheImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpVerificheImpianto -->
	
	
<h4 class="wpLabel">Verifiche sull'impianto </h4>
<div class="widgetsPanel" id="wpVerificheImpianto">
	

	
	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','tbVerifiche')" >

	
<div class="tableWidget">


<!-- widget tbVerifiche -->
	<csiuicore:ajaxify id="p_wpVerificheImpianto" 
		widgetType="table"		
		pageId="cpGestLibAggiornamenti"
		javascriptDetection="false">
<s:set name="cpGestLibAggiornamenti_tbVerifiche_clearStatus" value="isTableClearStatus('cpGestLibAggiornamenti_tbVerifiche')" />
<s:url id="cpGestLibAggiornamentiViewUrl"						   
					   action="cpGestLibAggiornamenti"
					   namespace="/base/gestisci_libretto_aggiornamenti"/>
<display:table name="appDataelencoVerifiche"  				
			   excludedParams="*"			   export="false"
               id="widg_tbVerifiche"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibAggiornamentiViewUrl}"  
               clearStatus="${cpGestLibAggiornamenti_tbVerifiche_clearStatus}"
               uid="row_tbVerifiche"
               summary="" 
               class="dataTable">
	
		<display:column property="identificativoExtended" titleKey="cpGestLibAggiornamenti.tbVerifiche.identificativoExtended.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCaricamento" titleKey="cpGestLibAggiornamenti.tbVerifiche.dataCaricamento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descrizioneTipoVerifica" titleKey="cpGestLibAggiornamenti.tbVerifiche.descrizioneTipoVerifica.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpVerificheImpianto --></div>

			
	
	<div id="p_wpAccertamentiImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpAccertamentiImpianto -->
	
	
<h4 class="wpLabel">Accertamenti sull'impianto </h4>
<div class="widgetsPanel" id="wpAccertamentiImpianto">
	

	
	
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','tbAccertamenti')" >

	
<div class="tableWidget">


<!-- widget tbAccertamenti -->
	<csiuicore:ajaxify id="p_wpAccertamentiImpianto" 
		widgetType="table"		
		pageId="cpGestLibAggiornamenti"
		javascriptDetection="false">
<s:set name="cpGestLibAggiornamenti_tbAccertamenti_clearStatus" value="isTableClearStatus('cpGestLibAggiornamenti_tbAccertamenti')" />
<s:url id="cpGestLibAggiornamentiViewUrl"						   
					   action="cpGestLibAggiornamenti"
					   namespace="/base/gestisci_libretto_aggiornamenti"/>
<display:table name="appDataelencoAccertamenti"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAccertamenti"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibAggiornamentiViewUrl}"  
               clearStatus="${cpGestLibAggiornamenti_tbAccertamenti_clearStatus}"
               uid="row_tbAccertamenti"
               summary="" 
               class="dataTable">
	
		<display:column property="identificativoExtended" titleKey="cpGestLibAggiornamenti.tbAccertamenti.identificativoExtended.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCreazione" titleKey="cpGestLibAggiornamenti.tbAccertamenti.dataCreazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataConclusione" titleKey="cpGestLibAggiornamenti.tbAccertamenti.dataConclusione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descTipoAnomalia" titleKey="cpGestLibAggiornamenti.tbAccertamenti.descTipoAnomalia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descStatoAccertamento" titleKey="cpGestLibAggiornamenti.tbAccertamenti.descStatoAccertamento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAccertamentiImpianto --></div>

			
	
	
	<div id="p_mpElencoLibretti" class="panelBlock"><!-- startFragment:p_mpElencoLibretti -->
		

		
<s:if test="#session.cpGestLibAggiornamenti_mpElencoLibretti_selectedMultiPanel == 'cpGestLibAggiornamenti_mpElencoLibretti_fpElencoLibretti'">
	<s:include value="/jsp/multipanels/cpGestLibAggiornamenti_mpElencoLibretti_fpElencoLibretti.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElencoLibretti --></div>

			
	
	<div id="p_cpNavGestAggiornamenti" class="commandPanelBlock"><!-- startFragment:p_cpNavGestAggiornamenti -->
	
	
<div class="commandPanel navigation" id="cpNavGestAggiornamenti">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibAggiornamenti','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibAggiornamenti.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibAggiornamenti','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestAggiornamenti --></div>

	

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
