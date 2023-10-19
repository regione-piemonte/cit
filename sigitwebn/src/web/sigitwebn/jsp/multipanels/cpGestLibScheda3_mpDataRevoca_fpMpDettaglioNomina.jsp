<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda3/CpGestLibScheda3Action" />

	
	<div id="p_fpMpDettaglioNomina" class="formPanelBlock"><!-- startFragment:p_fpMpDettaglioNomina -->
		
	


	
	

	
	
			
	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptRea')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptRea.label')}" labelFor="widg_ptRea" errorFor="appDatadettaglioTerzoResponsabile.codiceRea" labelId="ptReaLbl"   >


<!-- widget ptRea -->
<s:property value="appDatadettaglioTerzoResponsabile.codiceRea" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptCF')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptCF.label')}" labelFor="widg_ptCF" errorFor="appDatadettaglioTerzoResponsabile.codiceFiscale" labelId="ptCFLbl"   >


<!-- widget ptCF -->
<s:property value="appDatadettaglioTerzoResponsabile.codiceFiscale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptDenominazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptDenominazione.label')}" labelFor="widg_ptDenominazione" errorFor="appDatadettaglioTerzoResponsabile.denominazioneImp" labelId="ptDenominazioneLbl"   >


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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptDtInizioContr')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptDtInizioContr.label')}" labelFor="widg_ptDtInizioContr" errorFor="appDatadettaglioTerzoResponsabile.dataInizioContratto" labelId="ptDtInizioContrLbl"   >


<!-- widget ptDtInizioContr -->
<s:property value="appDatadettaglioTerzoResponsabile.dataInizioContratto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptDataFineContratto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptDataFineContratto.label')}" labelFor="widg_ptDataFineContratto" errorFor="appDatadettaglioTerzoResponsabile.dataFineContratto" labelId="ptDataFineContrattoLbl"   >


<!-- widget ptDataFineContratto -->
<s:property value="appDatadettaglioTerzoResponsabile.dataFineContratto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptTacitoRinnovo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptTacitoRinnovo.label')}" labelFor="widg_ptTacitoRinnovo" errorFor="appDatadettaglioTerzoResponsabile.descTacitoRinnovo" labelId="ptTacitoRinnovoLbl"   >


<!-- widget ptTacitoRinnovo -->
<s:property value="appDatadettaglioTerzoResponsabile.descTacitoRinnovo" escape="false" />

	
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
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptCodiceImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptCodiceImp.label')}" labelFor="widg_ptCodiceImp" errorFor="appDatadettaglioTerzoResponsabile.codImpianto" labelId="ptCodiceImpLbl"   >


<!-- widget ptCodiceImp -->
<s:property value="appDatadettaglioTerzoResponsabile.codImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDatadettaglioTerzoResponsabile.ubicazione" labelId="ptUbicazioneLbl"   >


<!-- widget ptUbicazione -->
<s:property value="appDatadettaglioTerzoResponsabile.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','ptResponsabileImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda3.ptResponsabileImpianto.label')}" labelFor="widg_ptResponsabileImpianto" errorFor="appDatadettaglioTerzoResponsabile.responsabile" labelId="ptResponsabileImpiantoLbl"   >


<!-- widget ptResponsabileImpianto -->
<s:property value="appDatadettaglioTerzoResponsabile.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpGestLibScheda3','taAutodichiarazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda3.taAutodichiarazione.label')}" labelFor="widg_taAutodichiarazione" errorFor="appDatadettaglioTerzoResponsabile.elencoAutodichiarazioni" labelId="taAutodichiarazioneLbl"
	  >


<!-- widget taAutodichiarazione -->
<s:textarea 
	
	
	name="appDatadettaglioTerzoResponsabile.elencoAutodichiarazioni" id="widg_taAutodichiarazione"
	disabled="isWidgetDisabled('cpGestLibScheda3','taAutodichiarazione')"
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
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btProroga')" >

	



<!-- widget btProroga -->
<s:submit name="widg_btProroga" id="widg_btProroga" method="handleBtProroga_CLICKED"
	key="cpGestLibScheda3.btProroga.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btProroga')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpProroga --></div>

			
	
	<div id="p_wpDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_wpDocumenti -->
	
	
<h4 class="wpLabel">documenti associati </h4>
<div class="widgetsPanel" id="wpDocumenti">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda3','tbDocContratti')" >

	
<div class="tableWidget">


<!-- widget tbDocContratti -->
<s:set name="cpGestLibScheda3_tbDocContratti_clearStatus" value="isTableClearStatus('cpGestLibScheda3_tbDocContratti')" />
<s:url id="cpGestLibScheda3ViewUrl"						   
					   action="cpGestLibScheda3"
					   namespace="/base/gestisci_libretto_scheda3"/>
<display:table name="appDataelencoDocContratti"  				
			   excludedParams="*"			   export="true"
               id="widg_tbDocContratti"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpGestLibScheda3ViewUrl}"  
               clearStatus="${cpGestLibScheda3_tbDocContratti_clearStatus}"
               uid="row_tbDocContratti"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbDocContratti.idDocContratto}" name="appDataidDocContrattoSelez" id="%{'tbDocContratti-editcell-'+ (#attr.row_tbDocContratti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="nomeDocumento" titleKey="cpGestLibScheda3.tbDocContratti.nomeDocumento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nomeDocumento" titleKey="cpGestLibScheda3.tbDocContratti.nomeDocumento.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="nomeDocumento" titleKey="cpGestLibScheda3.tbDocContratti.nomeDocumento.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descrizione" titleKey="cpGestLibScheda3.tbDocContratti.descrizione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrizione" titleKey="cpGestLibScheda3.tbDocContratti.descrizione.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="descrizione" titleKey="cpGestLibScheda3.tbDocContratti.descrizione.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataUpload" titleKey="cpGestLibScheda3.tbDocContratti.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataUpload" titleKey="cpGestLibScheda3.tbDocContratti.dataUpload.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataUpload" titleKey="cpGestLibScheda3.tbDocContratti.dataUpload.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="statoDocumento" titleKey="cpGestLibScheda3.tbDocContratti.statoDocumento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="statoDocumento" titleKey="cpGestLibScheda3.tbDocContratti.statoDocumento.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="statoDocumento" titleKey="cpGestLibScheda3.tbDocContratti.statoDocumento.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDocumenti --></div>

			
	
	<div id="p_cpAzioniDoc" class="commandPanelBlock"><!-- startFragment:p_cpAzioniDoc -->
	
	
<div class="commandPanel functional" id="cpAzioniDoc">

	
	
		
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btVisDOc')" >

	



<!-- widget btVisDOc -->
<s:submit name="widg_btVisDOc" id="widg_btVisDOc" method="handleBtVisDOc_CLICKED"
	key="cpGestLibScheda3.btVisDOc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btVisDOc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda3','btInsDOc')" >

	



<!-- widget btInsDOc -->
<s:submit name="widg_btInsDOc" id="widg_btInsDOc" method="handleBtInsDOc_CLICKED"
	key="cpGestLibScheda3.btInsDOc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btInsDOc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda3','btElimDOc')" >

	



<!-- widget btElimDOc -->
<s:submit name="widg_btElimDOc" id="widg_btElimDOc" method="handleBtElimDOc_CLICKED"
	key="cpGestLibScheda3.btElimDOc.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btElimDOc')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpAzioniDoc --></div>

			
	
	<div id="p_cpIndietroConfTerzResp" class="commandPanelBlock"><!-- startFragment:p_cpIndietroConfTerzResp -->
	
	
<div class="commandPanel navigation" id="cpIndietroConfTerzResp">

	
	
		
		
<s:if test="isWidgetVisible('cpGestLibScheda3','btIndConfTerzResp')" >

	



<!-- widget btIndConfTerzResp -->
<s:submit name="widg_btIndConfTerzResp" id="widg_btIndConfTerzResp" method="handleBtIndConfTerzResp_CLICKED"
	key="cpGestLibScheda3.btIndConfTerzResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda3','btIndConfTerzResp')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpIndietroConfTerzResp --></div>

			
	
	
	<div id="p_mpInserimentoDocumento" class="panelBlock"><!-- startFragment:p_mpInserimentoDocumento -->
		

		
<s:if test="#session.cpGestLibScheda3_mpInserimentoDocumento_selectedMultiPanel == 'cpGestLibScheda3_mpInserimentoDocumento_fpInsDocumento'">
	<s:include value="/jsp/multipanels/cpGestLibScheda3_mpInserimentoDocumento_fpInsDocumento.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpInserimentoDocumento --></div>

			
	
	
	<div id="p_mpProroga" class="panelBlock"><!-- startFragment:p_mpProroga -->
		

		
<s:if test="#session.cpGestLibScheda3_mpProroga_selectedMultiPanel == 'cpGestLibScheda3_mpProroga_fpProroga'">
	<s:include value="/jsp/multipanels/cpGestLibScheda3_mpProroga_fpProroga.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpProroga --></div>

	

		
	

	<!-- endFragment:p_fpMpDettaglioNomina --></div>
