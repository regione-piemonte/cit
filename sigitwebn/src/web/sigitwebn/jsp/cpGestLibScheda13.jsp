<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda13/CpGestLibScheda13Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda13 -->
<!-- pageId:cpGestLibScheda13 -->

<s:form id="cpGestLibScheda13" action="cpGestLibScheda13" namespace="/base/gestisci_libretto_scheda13" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda13_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda13','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda13_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda13','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda13"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda13/cpGestLibScheda13!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda13"
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

	
	

	
	
			
	
	<div id="p_fpScheda13" class="formPanelBlock"><!-- startFragment:p_fpScheda13 -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda13.fpScheda13.label" /></h4>
<div class="formPanel" id="fpScheda13">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpScheda13 --></div>

			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda13','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda13.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda13','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda13.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda13','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda13.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda13','wpInfoImpianto_2_2_fictitious_')" >

	
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

			
	
	<div id="p_wpScheda13" class="widgetsPanelBlock"><!-- startFragment:p_wpScheda13 -->
	
	
<h4 class="wpLabel">ispezioni </h4>
<div class="widgetsPanel" id="wpScheda13">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda13','tbRisultatiRicerca')" >

	
<div class="tableWidget">


<!-- widget tbRisultatiRicerca -->
<s:set name="cpGestLibScheda13_tbRisultatiRicerca_clearStatus" value="isTableClearStatus('cpGestLibScheda13_tbRisultatiRicerca')" />
<s:url id="cpGestLibScheda13ViewUrl"						   
					   action="cpGestLibScheda13"
					   namespace="/base/gestisci_libretto_scheda13"/>
<display:table name="appDataElencoIspezioni2018"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatiRicerca"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda13ViewUrl}"  
               clearStatus="${cpGestLibScheda13_tbRisultatiRicerca_clearStatus}"
               uid="row_tbRisultatiRicerca"
               summary="" 
decorator="it.csi.sigit.sigitwebn.presentation.decorator.gestisci_libretto_scheda13.CpGestLibScheda13TbRisultatiRicercaCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatiRicerca.identificativoIspezione}" name="appDataidIspezioneSelezionato" id="%{'tbRisultatiRicerca-editcell-'+ (#attr.row_tbRisultatiRicerca_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="dataCreazione" titleKey="cpGestLibScheda13.tbRisultatiRicerca.dataCreazione.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="enteCompetente" titleKey="cpGestLibScheda13.tbRisultatiRicerca.enteCompetente.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="note" titleKey="cpGestLibScheda13.tbRisultatiRicerca.note.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="esito" titleKey="cpGestLibScheda13.tbRisultatiRicerca.esito.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="rapportoLinkable" titleKey="cpGestLibScheda13.tbRisultatiRicerca.rapportoLinkable.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpScheda13 --></div>

			
	
	<div id="p_cpFunGestScheda13" class="commandPanelBlock"><!-- startFragment:p_cpFunGestScheda13 -->
	
	
<div class="commandPanel functional" id="cpFunGestScheda13">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda13','btnDettaglio')" >

	



<!-- widget btnDettaglio -->
<s:submit name="widg_btnDettaglio" id="widg_btnDettaglio" method="handleBtnDettaglio_CLICKED"
	key="cpGestLibScheda13.btnDettaglio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda13','btnDettaglio')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpGestLibScheda13','btnHidden')" >

	



<!-- widget btnHidden -->
<s:submit name="widg_btnHidden" id="widg_btnHidden" method="handleBtnHidden_CLICKED"
	key="cpGestLibScheda13.btnHidden.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpGestLibScheda13','btnHidden')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGestScheda13 --></div>

			
	
	<div id="p_cpNavGestScheda13" class="commandPanelBlock"><!-- startFragment:p_cpNavGestScheda13 -->
	
	
<div class="commandPanel navigation" id="cpNavGestScheda13">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda13','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestLibScheda13.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda13','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestScheda13 --></div>

	

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
