<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda3/CpDettaglio3RespAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda3 -->
<!-- pageId:cpDettaglio3Resp -->

<s:form id="cpDettaglio3Resp" action="cpDettaglio3Resp" namespace="/base/gestisci_libretto_scheda3" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglio3Resp_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpDettaglio3Resp','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglio3Resp_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglio3Resp','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpDettaglio3Resp"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda3/cpDettaglio3Resp!handleMenuLibretto_CLICKED.do"
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

	
	

	
	
			
	
	<div id="p_fpDettaglioNomina" class="formPanelBlock"><!-- startFragment:p_fpDettaglioNomina -->
		
	
<h4 class="fpLabel"><s:text name="cpDettaglio3Resp.fpDettaglioNomina.label" /></h4>
<div class="formPanel" id="fpDettaglioNomina">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpDettaglioNomina --></div>

			
	
	<div id="p_stdMsgProroga" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgProroga -->
	
	
<div class="stdMessagePanel" id="stdMsgProroga">
	<customtag:stdMessagePanel id="stdMsgProroga" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgProroga --></div>

			
	
	<div id="p_wpDatiTerzoResp" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiTerzoResp -->
	
	
<h4 class="wpLabel">dati Terzo responsabile </h4>
<div class="widgetsPanel" id="wpDatiTerzoResp">
	
	<customtag:widgetsPanel id="wpDatiTerzoRespTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptRea')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptRea.label')}" labelFor="widg_ptRea" errorFor="appDatadettaglioTerzoResponsabile.codiceRea" labelId="ptReaLbl"   >


<!-- widget ptRea -->
<s:property value="appDatadettaglioTerzoResponsabile.codiceRea" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptCF')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptCF.label')}" labelFor="widg_ptCF" errorFor="appDatadettaglioTerzoResponsabile.codiceFiscale" labelId="ptCFLbl"   >


<!-- widget ptCF -->
<s:property value="appDatadettaglioTerzoResponsabile.codiceFiscale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptDenominazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptDenominazione.label')}" labelFor="widg_ptDenominazione" errorFor="appDatadettaglioTerzoResponsabile.denominazioneImp" labelId="ptDenominazioneLbl"   >


<!-- widget ptDenominazione -->
<s:property value="appDatadettaglioTerzoResponsabile.denominazioneImp" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiTerzoResp --></div>

			
	
	<div id="p_wpDatiContratto" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiContratto -->
	
	
<h4 class="wpLabel">dati contratto </h4>
<div class="widgetsPanel" id="wpDatiContratto">
	
	<customtag:widgetsPanel id="wpDatiContrattoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptDtInizioContr')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptDtInizioContr.label')}" labelFor="widg_ptDtInizioContr" errorFor="appDatadettaglioTerzoResponsabile.dataInizioContratto" labelId="ptDtInizioContrLbl"   >


<!-- widget ptDtInizioContr -->
<s:property value="appDatadettaglioTerzoResponsabile.dataInizioContratto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptDataFineContratto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptDataFineContratto.label')}" labelFor="widg_ptDataFineContratto" errorFor="appDatadettaglioTerzoResponsabile.dataFineContratto" labelId="ptDataFineContrattoLbl"   >


<!-- widget ptDataFineContratto -->
<s:property value="appDatadettaglioTerzoResponsabile.dataFineContratto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptTacitoRinnovo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptTacitoRinnovo.label')}" labelFor="widg_ptTacitoRinnovo" errorFor="appDatadettaglioTerzoResponsabile.descTacitoRinnovo" labelId="ptTacitoRinnovoLbl"   >


<!-- widget ptTacitoRinnovo -->
<s:property value="appDatadettaglioTerzoResponsabile.descTacitoRinnovo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptDataCessazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptDataCessazione.label')}" labelFor="widg_ptDataCessazione" errorFor="appDatadettaglioTerzoResponsabile.dataRevoca" labelId="ptDataCessazioneLbl"   >


<!-- widget ptDataCessazione -->
<s:property value="appDatadettaglioTerzoResponsabile.dataRevoca" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptTipoCessazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptTipoCessazione.label')}" labelFor="widg_ptTipoCessazione" errorFor="appDatadettaglioTerzoResponsabile.desTipoCessazione" labelId="ptTipoCessazioneLbl"   >


<!-- widget ptTipoCessazione -->
<s:property value="appDatadettaglioTerzoResponsabile.desTipoCessazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptMotivoCessazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptMotivoCessazione.label')}" labelFor="widg_ptMotivoCessazione" errorFor="appDatadettaglioTerzoResponsabile.motivoCessazione" labelId="ptMotivoCessazioneLbl"   >


<!-- widget ptMotivoCessazione -->
<s:property value="appDatadettaglioTerzoResponsabile.motivoCessazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptNote')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptNote.label')}" labelFor="widg_ptNote" errorFor="appDatadettaglioTerzoResponsabile.note" labelId="ptNoteLbl"   >


<!-- widget ptNote -->
<s:property value="appDatadettaglioTerzoResponsabile.note" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiContratto --></div>

			
	
	<div id="p_wpImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpImpianto">
	
	<customtag:widgetsPanel id="wpImpiantoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptCodiceImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptCodiceImp.label')}" labelFor="widg_ptCodiceImp" errorFor="appDatadettaglioTerzoResponsabile.codImpianto" labelId="ptCodiceImpLbl"   >


<!-- widget ptCodiceImp -->
<s:property value="appDatadettaglioTerzoResponsabile.codImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDatadettaglioTerzoResponsabile.ubicazione" labelId="ptUbicazioneLbl"   >


<!-- widget ptUbicazione -->
<s:property value="appDatadettaglioTerzoResponsabile.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglio3Resp.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDatadettaglioTerzoResponsabile.responsabile" labelId="ptResponsabileImpiantoLbl"   >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDatadettaglioTerzoResponsabile.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','taAutodichiarazioneNomina')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglio3Resp.taAutodichiarazioneNomina.label')}" labelFor="widg_taAutodichiarazioneNomina" errorFor="appDatadettaglioTerzoResponsabile.elencoAutodichiarazioni" labelId="taAutodichiarazioneNominaLbl"
	  >


<!-- widget taAutodichiarazioneNomina -->
<s:textarea 
	
	
	name="appDatadettaglioTerzoResponsabile.elencoAutodichiarazioni" id="widg_taAutodichiarazioneNomina"
	disabled="isWidgetDisabled('cpDettaglio3Resp','taAutodichiarazioneNomina')"
	rows="10"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglio3Resp','taAutodichiarazioneDecadenza')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglio3Resp.taAutodichiarazioneDecadenza.label')}" labelFor="widg_taAutodichiarazioneDecadenza" errorFor="appDatadettaglioTerzoResponsabile.elencoAutodichiarazioniDecadenza" labelId="taAutodichiarazioneDecadenzaLbl"
	  >


<!-- widget taAutodichiarazioneDecadenza -->
<s:textarea 
	
title=""	
	name="appDatadettaglioTerzoResponsabile.elencoAutodichiarazioniDecadenza" id="widg_taAutodichiarazioneDecadenza"
	disabled="isWidgetDisabled('cpDettaglio3Resp','taAutodichiarazioneDecadenza')"
	rows="10"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpianto --></div>

			
	
	<div id="p_cpProroga" class="commandPanelBlock"><!-- startFragment:p_cpProroga -->
	
	
<div class="commandPanel functional" id="cpProroga">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglio3Resp','btProroga')" >

	



<!-- widget btProroga -->
<s:submit name="widg_btProroga" id="widg_btProroga" method="handleBtProroga_CLICKED"
	key="cpDettaglio3Resp.btProroga.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglio3Resp','btProroga')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpProroga --></div>

			
	
	
	<div id="p_mpProroga" class="panelBlock"><!-- startFragment:p_mpProroga -->
		

		
<s:if test="#session.cpDettaglio3Resp_mpProroga_selectedMultiPanel == 'cpDettaglio3Resp_mpProroga_fpProroga'">
	<s:include value="/jsp/multipanels/cpDettaglio3Resp_mpProroga_fpProroga.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpProroga --></div>

			
	
	<div id="p_wpDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_wpDocumenti -->
	
	
<h4 class="wpLabel">documenti associati </h4>
<div class="widgetsPanel" id="wpDocumenti">
	

	
	
<s:if test="isWidgetVisible('cpDettaglio3Resp','tbDocContratti')" >

	
<div class="tableWidget">


<!-- widget tbDocContratti -->
<s:set name="cpDettaglio3Resp_tbDocContratti_clearStatus" value="isTableClearStatus('cpDettaglio3Resp_tbDocContratti')" />
<s:url id="cpDettaglio3RespViewUrl"						   
					   action="cpDettaglio3Resp"
					   namespace="/base/gestisci_libretto_scheda3"/>
<display:table name="appDataelencoDocContratti"  				
			   excludedParams="*"			   export="true"
               id="widg_tbDocContratti"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglio3RespViewUrl}"  
               clearStatus="${cpDettaglio3Resp_tbDocContratti_clearStatus}"
               uid="row_tbDocContratti"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbDocContratti.idDocContratto}" name="appDataidDocContrattoSelez" id="%{'tbDocContratti-editcell-'+ (#attr.row_tbDocContratti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="nomeDocumento" titleKey="cpDettaglio3Resp.tbDocContratti.nomeDocumento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nomeDocumento" titleKey="cpDettaglio3Resp.tbDocContratti.nomeDocumento.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="nomeDocumento" titleKey="cpDettaglio3Resp.tbDocContratti.nomeDocumento.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descrizione" titleKey="cpDettaglio3Resp.tbDocContratti.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrizione" titleKey="cpDettaglio3Resp.tbDocContratti.descrizione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descrizione" titleKey="cpDettaglio3Resp.tbDocContratti.descrizione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataUpload" titleKey="cpDettaglio3Resp.tbDocContratti.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataUpload" titleKey="cpDettaglio3Resp.tbDocContratti.dataUpload.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataUpload" titleKey="cpDettaglio3Resp.tbDocContratti.dataUpload.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="statoDocumento" titleKey="cpDettaglio3Resp.tbDocContratti.statoDocumento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="statoDocumento" titleKey="cpDettaglio3Resp.tbDocContratti.statoDocumento.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="statoDocumento" titleKey="cpDettaglio3Resp.tbDocContratti.statoDocumento.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDocumenti --></div>

			
	
	<div id="p_cpAzioniDoc" class="commandPanelBlock"><!-- startFragment:p_cpAzioniDoc -->
	
	
<div class="commandPanel functional" id="cpAzioniDoc">

	
	
		
		
<s:if test="isWidgetVisible('cpDettaglio3Resp','btVisDOc')" >

	



<!-- widget btVisDOc -->
<s:submit name="widg_btVisDOc" id="widg_btVisDOc" method="handleBtVisDOc_CLICKED"
	key="cpDettaglio3Resp.btVisDOc.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDettaglio3Resp','btVisDOc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglio3Resp','btInsDOc')" >

	



<!-- widget btInsDOc -->
<s:submit name="widg_btInsDOc" id="widg_btInsDOc" method="handleBtInsDOc_CLICKED"
	key="cpDettaglio3Resp.btInsDOc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglio3Resp','btInsDOc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglio3Resp','btElimDOc')" >

	



<!-- widget btElimDOc -->
<s:submit name="widg_btElimDOc" id="widg_btElimDOc" method="handleBtElimDOc_CLICKED"
	key="cpDettaglio3Resp.btElimDOc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglio3Resp','btElimDOc')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpAzioniDoc --></div>

			
	
	
	<div id="p_mpInserimentoDocumento" class="panelBlock"><!-- startFragment:p_mpInserimentoDocumento -->
		

		
<s:if test="#session.cpDettaglio3Resp_mpInserimentoDocumento_selectedMultiPanel == 'cpDettaglio3Resp_mpInserimentoDocumento_fpInsDocumento'">
	<s:include value="/jsp/multipanels/cpDettaglio3Resp_mpInserimentoDocumento_fpInsDocumento.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpInserimentoDocumento --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglio3Resp','btIndConfTerzResp')" >

	



<!-- widget btIndConfTerzResp -->
<s:submit name="widg_btIndConfTerzResp" id="widg_btIndConfTerzResp" method="handleBtIndConfTerzResp_CLICKED"
	key="cpDettaglio3Resp.btIndConfTerzResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglio3Resp','btIndConfTerzResp')" />

	


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
