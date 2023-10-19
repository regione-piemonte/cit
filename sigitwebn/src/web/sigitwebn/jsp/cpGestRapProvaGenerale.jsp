<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_rapprova/CpGestRapProvaGeneraleAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_rapprova -->
<!-- pageId:cpGestRapProvaGenerale -->

<s:form id="cpGestRapProvaGenerale" action="cpGestRapProvaGenerale" namespace="/base/gestisci_rapprova" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaGenerale_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestRapProvaGenerale_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuRapProva" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuRapProva -->
	
	

<div class="widgetsPanel" id="wpMenuRapProva">
	
	<customtag:widgetsPanel id="wpMenuRapProvaTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','menuRapProva')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_wpMenuRapProva" 
		widgetType="tree" 
		pageId="cpGestRapProvaGenerale"
		javascriptDetection="false">
	<customtag:tree
		name="appDatarapProvaMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuRapProva"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_rapprova/cpGestRapProvaGenerale!handleMenuRapProva_CLICKED.do"
		nameSpace="/base/gestisci_rapprova"
		showChildNumber="false">
	</customtag:tree>

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMenuRapProva --></div>

	

	<!-- endFragment:p_fpLeftMenu --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpGestRapProvaDatiGen" class="formPanelBlock"><!-- startFragment:p_fpGestRapProvaDatiGen -->
		
	
<h4 class="fpLabel"><s:text name="cpGestRapProvaGenerale.fpGestRapProvaDatiGen.label" /></h4>
<div class="formPanel" id="fpGestRapProvaDatiGen">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpGestRapProvaDatiGen --></div>

			
	
	<div id="p_stdMsgRapProva" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgRapProva -->
	
	
<div class="stdMessagePanel" id="stdMsgRapProva">
	<customtag:stdMessagePanel id="stdMsgRapProva" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgRapProva --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">dati impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptImpCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptImpCodiceImpianto.label')}" labelFor="widg_ptImpCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptImpCodiceImpiantoLbl"   >


<!-- widget ptImpCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptImpUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptImpUbicazione.label')}" labelFor="widg_ptImpUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptImpUbicazioneLbl"   >


<!-- widget ptImpUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptImpResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptImpResponsabile.label')}" labelFor="widg_ptImpResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptImpResponsabileLbl"   >


<!-- widget ptImpResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpDatiGenerali1" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiGenerali1 -->
	
	
<h4 class="wpLabel">1. dati generali </h4>
<div class="widgetsPanel" id="wpDatiGenerali1">
	
	<customtag:widgetsPanel id="wpDatiGenerali1Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptCodImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptCodImp.label')}" labelFor="widg_ptCodImp" errorFor="appDatarapProvaDatiGenerali.codiceImpianto" labelId="ptCodImpLbl"   >


<!-- widget ptCodImp -->
<s:property value="appDatarapProvaDatiGenerali.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptIspezione.label')}" labelFor="widg_ptIspezione" errorFor="widg_ptIspezione" labelId="ptIspezioneLbl"   >


<!-- widget ptIspezione -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptDataControllo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptDataControllo.label')}" labelFor="widg_ptDataControllo" errorFor="appDatarapProvaDatiGenerali.dataControllo" labelId="ptDataControlloLbl"   >


<!-- widget ptDataControllo -->
<s:property value="appDatarapProvaDatiGenerali.dataControllo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptOraArrivo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptOraArrivo.label')}" labelFor="widg_ptOraArrivo" errorFor="appDatarapProvaDatiGenerali.oraArrivo" labelId="ptOraArrivoLbl"   >


<!-- widget ptOraArrivo -->
<s:property value="appDatarapProvaDatiGenerali.oraArrivo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptIdIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptIdIspezione.label')}" labelFor="widg_ptIdIspezione" errorFor="appDatarapProvaDatiGenerali.idIspezione" labelId="ptIdIspezioneLbl"   tdStyleClass="numbers">


<!-- widget ptIdIspezione -->
<s:property value="appDatarapProvaDatiGenerali.idIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptIspettore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptIspettore.label')}" labelFor="widg_ptIspettore" errorFor="widg_ptIspettore" labelId="ptIspettoreLbl"   >


<!-- widget ptIspettore -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptGenIspettore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptGenIspettore.label')}" labelFor="widg_ptGenIspettore" errorFor="appDatarapProvaDatiGenerali.ispettore" labelId="ptGenIspettoreLbl"   >


<!-- widget ptGenIspettore -->
<s:property value="appDatarapProvaDatiGenerali.ispettore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptQualIspettore')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptQualIspettore.label')}" labelFor="widg_ptQualIspettore" errorFor="appDatarapProvaDatiGenerali.qualificaIspettore" labelId="ptQualIspettoreLbl"   >


<!-- widget ptQualIspettore -->
<s:property value="appDatarapProvaDatiGenerali.qualificaIspettore" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="widg_ptUbicazione" labelId="ptUbicazioneLbl"   >


<!-- widget ptUbicazione -->


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptComune')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptComune.label')}" labelFor="widg_ptComune" errorFor="appDatarapProvaDatiGenerali.comune" labelId="ptComuneLbl"   >


<!-- widget ptComune -->
<s:property value="appDatarapProvaDatiGenerali.comune" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptIndirizzo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptIndirizzo.label')}" labelFor="widg_ptIndirizzo" errorFor="appDatarapProvaDatiGenerali.indirizzo" labelId="ptIndirizzoLbl"   >


<!-- widget ptIndirizzo -->
<s:property value="appDatarapProvaDatiGenerali.indirizzo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptDatiCat')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptDatiCat.label')}" labelFor="widg_ptDatiCat" errorFor="widg_ptDatiCat" labelId="ptDatiCatLbl"   >


<!-- widget ptDatiCat -->


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiGenerali1 --></div>

			
	
	<div id="p_wpTabellaLocalizzazioni" class="widgetsPanelBlock"><!-- startFragment:p_wpTabellaLocalizzazioni -->
	
	

<div class="widgetsPanel" id="wpTabellaLocalizzazioni">
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','tbLocalizzazioni')" >

	
<div class="tableWidget">


<!-- widget tbLocalizzazioni -->
	<csiuicore:ajaxify id="p_wpTabellaLocalizzazioni" 
		widgetType="table"		
		pageId="cpGestRapProvaGenerale"
		javascriptDetection="false">
<s:set name="cpGestRapProvaGenerale_tbLocalizzazioni_clearStatus" value="isTableClearStatus('cpGestRapProvaGenerale_tbLocalizzazioni')" />
<s:url id="cpGestRapProvaGeneraleViewUrl"						   
					   action="cpGestRapProvaGenerale"
					   namespace="/base/gestisci_rapprova"/>
<display:table name="appDatalistaDatiExtra"  				
			   excludedParams="*"			   export="false"
               id="widg_tbLocalizzazioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestRapProvaGeneraleViewUrl}"  
               clearStatus="${cpGestRapProvaGenerale_tbLocalizzazioni_clearStatus}"
               uid="row_tbLocalizzazioni"
               summary="" 
               class="dataTable">
	
		<display:column property="sezione" titleKey="cpGestRapProvaGenerale.tbLocalizzazioni.sezione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="foglio" titleKey="cpGestRapProvaGenerale.tbLocalizzazioni.foglio.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="particella" titleKey="cpGestRapProvaGenerale.tbLocalizzazioni.particella.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="subalterno" titleKey="cpGestRapProvaGenerale.tbLocalizzazioni.subalterno.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="pod" titleKey="cpGestRapProvaGenerale.tbLocalizzazioni.pod.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="pdr" titleKey="cpGestRapProvaGenerale.tbLocalizzazioni.pdr.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpTabellaLocalizzazioni --></div>

			
	
	<div id="p_wpDatiGenerali2" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiGenerali2 -->
	
	

<div class="widgetsPanel" id="wpDatiGenerali2">
	
	<customtag:widgetsPanel id="wpDatiGenerali2Tbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptGenResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptGenResponsabile.label')}" labelFor="widg_ptGenResponsabile" errorFor="appDatarapProvaDatiGenerali.responsabile" labelId="ptGenResponsabileLbl"   >


<!-- widget ptGenResponsabile -->
<s:property value="appDatarapProvaDatiGenerali.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiGenerali2 --></div>

			
	
	<div id="p_wpDestinazione" class="widgetsPanelBlock"><!-- startFragment:p_wpDestinazione -->
	
	
<h4 class="wpLabel">2. destinazione </h4>
<div class="widgetsPanel" id="wpDestinazione">
	
	<customtag:widgetsPanel id="wpDestinazioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptDescCatEdificio')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptDescCatEdificio.label')}" labelFor="widg_ptDescCatEdificio" errorFor="appDatarapProvaDatiGenerali.descCatEdificio" labelId="ptDescCatEdificioLbl"   >


<!-- widget ptDescCatEdificio -->
<s:property value="appDatarapProvaDatiGenerali.descCatEdificio" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptDescUnitaImmServite')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptDescUnitaImmServite.label')}" labelFor="widg_ptDescUnitaImmServite" errorFor="appDatarapProvaDatiGenerali.descUnitaImmServite" labelId="ptDescUnitaImmServiteLbl"   >


<!-- widget ptDescUnitaImmServite -->
<s:property value="appDatarapProvaDatiGenerali.descUnitaImmServite" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptUsoImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptUsoImpianto.label')}" labelFor="widg_ptUsoImpianto" errorFor="appDatarapProvaDatiGenerali.usoImpianto" labelId="ptUsoImpiantoLbl"   >


<!-- widget ptUsoImpianto -->
<s:property value="appDatarapProvaDatiGenerali.usoImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','ptVolRiscM3')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestRapProvaGenerale.ptVolRiscM3.label')}" labelFor="widg_ptVolRiscM3" errorFor="appDatarapProvaDatiGenerali.volRiscM3" labelId="ptVolRiscM3Lbl"   >


<!-- widget ptVolRiscM3 -->
<s:property value="appDatarapProvaDatiGenerali.volRiscM3" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDestinazione --></div>

			
	
	<div id="p_cpNavGestRapProva" class="commandPanelBlock"><!-- startFragment:p_cpNavGestRapProva -->
	
	
<div class="commandPanel navigation" id="cpNavGestRapProva">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestRapProvaGenerale','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpGestRapProvaGenerale.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestRapProvaGenerale','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGestRapProva --></div>

	

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
