<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda4_3/CpGestLibScheda4_3DettAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda4_3 -->
<!-- pageId:cpGestLibScheda4_3Dett -->

<s:form id="cpGestLibScheda4_3Dett" action="cpGestLibScheda4_3Dett" namespace="/base/gestisci_libretto_scheda4_3" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda4_3Dett_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda4_3Dett_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda4_3Dett"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda4_3/cpGestLibScheda4_3Dett!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda4_3"
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

	
	

	
	
			
	
	<div id="p_fpTitolo" class="formPanelBlock"><!-- startFragment:p_fpTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda4_3Dett.fpTitolo.label" /></h4>
<div class="formPanel" id="fpTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitolo --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpComponente" class="widgetsPanelBlock"><!-- startFragment:p_wpComponente -->
	
	

<div class="widgetsPanel" id="wpComponente">
	
	<customtag:widgetsPanel id="wpComponenteTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','ptRecuperatore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.ptRecuperatore.label')}" labelFor="widg_ptRecuperatore" errorFor="appDatacomponenteBRRC.componente" labelId="ptRecuperatoreLbl"   >


<!-- widget ptRecuperatore -->
<s:property value="appDatacomponenteBRRC.componente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','cbGruppoTermico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.cbGruppoTermico.label')}" labelFor="widg_cbGruppoTermico" errorFor="appDatacomponenteBRRC.gtCollegato" labelId="cbGruppoTermicoLbl"
	  fieldRequired="true">


<!-- widget cbGruppoTermico -->
<s:select name="appDatacomponenteBRRC.gtCollegato" id="widg_cbGruppoTermico"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoComponentiGT"
	  disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','cbGruppoTermico')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','cDataInstallazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.cDataInstallazione.label')}" labelFor="widg_cDataInstallazione" errorFor="appDatacomponenteBRRC.dataInstallazione" labelId="cDataInstallazioneLbl"
	  fieldRequired="true">


<!-- widget cDataInstallazione -->
<s:textfield 
	
	
	name="appDatacomponenteBRRC.dataInstallazione" id="widg_cDataInstallazione"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','cDataInstallazione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','cDataDismissione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.cDataDismissione.label')}" labelFor="widg_cDataDismissione" errorFor="appDatacomponenteBRRC.dataDismissione" labelId="cDataDismissioneLbl"
	  >


<!-- widget cDataDismissione -->
<s:textfield 
	
	
	name="appDatacomponenteBRRC.dataDismissione" id="widg_cDataDismissione"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','cDataDismissione')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','cbFabbricante')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.cbFabbricante.label')}" labelFor="widg_cbFabbricante" errorFor="appDatacomponenteBRRC.fabbricante" labelId="cbFabbricanteLbl"
	  fieldRequired="true">


<!-- widget cbFabbricante -->
<s:select name="appDatacomponenteBRRC.fabbricante" id="widg_cbFabbricante"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoFabbricante"
	  disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','cbFabbricante')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','tfModello')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.tfModello.label')}" labelFor="widg_tfModello" errorFor="appDatacomponenteBRRC.modello" labelId="tfModelloLbl"
	  fieldRequired="true">


<!-- widget tfModello -->
<s:textfield 
	
	
	name="appDatacomponenteBRRC.modello" id="widg_tfModello"
maxlength="33"	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','tfModello')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','tfMatricola')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.tfMatricola.label')}" labelFor="widg_tfMatricola" errorFor="appDatacomponenteBRRC.matricola" labelId="tfMatricolaLbl"
	  fieldRequired="true">


<!-- widget tfMatricola -->
<s:textfield 
	
	
	name="appDatacomponenteBRRC.matricola" id="widg_tfMatricola"
maxlength="30"	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','tfMatricola')"
	size="23" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','tfPortataMax')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda4_3Dett.tfPortataMax.label')}" labelFor="widg_tfPortataMax" errorFor="appDatacomponenteBRRC.portataMax" labelId="tfPortataMaxLbl"
	  fieldRequired="true">


<!-- widget tfPortataMax -->
<s:textfield 
	
	
	name="appDatacomponenteBRRC.portataMax" id="widg_tfPortataMax"
maxlength="9"	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','tfPortataMax')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpComponente --></div>

			
	
	<div id="p_cpFunGestComponente" class="commandPanelBlock"><!-- startFragment:p_cpFunGestComponente -->
	
	
<div class="commandPanel functional" id="cpFunGestComponente">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','bSostituisciComponente')" >

	



<!-- widget bSostituisciComponente -->
<s:submit name="widg_bSostituisciComponente" id="widg_bSostituisciComponente" method="handleBSostituisciComponente_CLICKED"
	key="cpGestLibScheda4_3Dett.bSostituisciComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','bSostituisciComponente')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','bDismettiComponente')" >

	



<!-- widget bDismettiComponente -->
<s:submit name="widg_bDismettiComponente" id="widg_bDismettiComponente" method="handleBDismettiComponente_CLICKED"
	key="cpGestLibScheda4_3Dett.bDismettiComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','bDismettiComponente')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','bRiattivaComponente')" >

	



<!-- widget bRiattivaComponente -->
<s:submit name="widg_bRiattivaComponente" id="widg_bRiattivaComponente" method="handleBRiattivaComponente_CLICKED"
	key="cpGestLibScheda4_3Dett.bRiattivaComponente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','bRiattivaComponente')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestComponente --></div>

			
	
	<div id="p_wpComponentiSostituite" class="widgetsPanelBlock"><!-- startFragment:p_wpComponentiSostituite -->
	
	

<div class="widgetsPanel" id="wpComponentiSostituite">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','tbSostituzioni')" >

	
<div class="tableWidget">


<!-- widget tbSostituzioni -->
<s:set name="cpGestLibScheda4_3Dett_tbSostituzioni_clearStatus" value="isTableClearStatus('cpGestLibScheda4_3Dett_tbSostituzioni')" />
<s:url id="cpGestLibScheda4_3DettViewUrl"						   
					   action="cpGestLibScheda4_3Dett"
					   namespace="/base/gestisci_libretto_scheda4_3"/>
<display:table name="appDatalistaStoricoComponentiBRRC"  				
			   excludedParams="*"			   export="true"
               id="widg_tbSostituzioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda4_3DettViewUrl}"  
               clearStatus="${cpGestLibScheda4_3Dett_tbSostituzioni_clearStatus}"
               uid="row_tbSostituzioni"
               summary="" 
               class="dataTable">
	
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.dataInstallazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.dataInstallazione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataInstallazione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.dataInstallazione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.dataDismissione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.dataDismissione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataDismissione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.dataDismissione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.fabbricanteLabel.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.fabbricanteLabel.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="fabbricanteLabel" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.fabbricanteLabel.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="modello" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.modello.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="modello" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.modello.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="modello" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.modello.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.azione.label"
						sortable="false" headerClass="nosort" media="html"
>
				<s:if test="%{#attr.row_tbSostituzioni.flgRipristina == true}">
					<s:url id="targetUrlLinkableCell"						   
						   action="cpGestLibScheda4_3Dett!handleTbSostituzioni_CLICKED"
						   namespace="/base/gestisci_libretto_scheda4_3"
						   includeParams="none">
						<s:param name="idRiga"  value="%{#attr.row_tbSostituzioni.componente}"/>
						<s:param name="idColonna">azione</s:param>
					</s:url>
					<s:a href="%{targetUrlLinkableCell}" id="id_linkable_cell">
						<s:property value="%{#attr.row_tbSostituzioni.azione}"/>
					</s:a>
				</s:if>
				<s:else>
					<s:property value="%{#attr.row_tbSostituzioni.azione}"/>
				</s:else>
		</display:column>

		<display:column property="azione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.azione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="azione" titleKey="cpGestLibScheda4_3Dett.tbSostituzioni.azione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpComponentiSostituite --></div>

			
	
	<div id="p_cpNavGestComponente" class="commandPanelBlock"><!-- startFragment:p_cpNavGestComponente -->
	
	
<div class="commandPanel functional" id="cpNavGestComponente">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','btRipristinaAttualeDett')" >

	



<!-- widget btRipristinaAttualeDett -->
<s:submit name="widg_btRipristinaAttualeDett" id="widg_btRipristinaAttualeDett" method="handleBtRipristinaAttualeDett_CLICKED"
	key="cpGestLibScheda4_3Dett.btRipristinaAttualeDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','btRipristinaAttualeDett')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','btSalvaDett')" >

	



<!-- widget btSalvaDett -->
<s:submit name="widg_btSalvaDett" id="widg_btSalvaDett" method="handleBtSalvaDett_CLICKED"
	key="cpGestLibScheda4_3Dett.btSalvaDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','btSalvaDett')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestComponente --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda4_3Dett','btIndietroDett')" >

	



<!-- widget btIndietroDett -->
<s:submit name="widg_btIndietroDett" id="widg_btIndietroDett" method="handleBtIndietroDett_CLICKED"
	key="cpGestLibScheda4_3Dett.btIndietroDett.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda4_3Dett','btIndietroDett')" />

	


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
