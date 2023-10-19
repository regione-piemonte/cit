<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_documenti_impianti/CpElencoDocumentiImpiantiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/elenco_documenti_impianti -->
<!-- pageId:cpElencoDocumentiImpianti -->

<s:form id="cpElencoDocumentiImpianti" action="cpElencoDocumentiImpianti" namespace="/base/elenco_documenti_impianti" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpElencoDocumentiImpianti_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="centerWrapper" class="floatWrapper">


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpElencoAllegati" class="formPanelBlock"><!-- startFragment:p_fpElencoAllegati -->
		
	
<h4 class="fpLabel"><s:text name="cpElencoDocumentiImpianti.fpElencoAllegati.label" /></h4>
<div class="formPanel" id="fpElencoAllegati">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpElencoAllegati --></div>

			
	
	<div id="p_stdErrorMessageAllegatiImpianti" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageAllegatiImpianti -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageAllegatiImpianti">
	<customtag:stdMessagePanel id="stdErrorMessageAllegatiImpianti" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageAllegatiImpianti --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoDocumentiImpianti.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl" colSpan="3" position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	
	<div id="p_mpDatiIspezione" class="panelBlock"><!-- startFragment:p_mpDatiIspezione -->
		

		
<s:if test="#session.cpElencoDocumentiImpianti_mpDatiIspezione_selectedMultiPanel == 'cpElencoDocumentiImpianti_mpDatiIspezione_fpDatiIspezione'">
	<s:include value="/jsp/multipanels/cpElencoDocumentiImpianti_mpDatiIspezione_fpDatiIspezione.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiIspezione --></div>

			
	
	<div id="p_wpElencoDocumenti" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoDocumenti -->
	
	
<h4 class="wpLabel">documenti </h4>
<div class="widgetsPanel" id="wpElencoDocumenti">
	

	
	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','tblElencoDocumenti')" >

	
<div class="tableWidget">


<!-- widget tblElencoDocumenti -->
	<csiuicore:ajaxify id="p_wpElencoDocumenti" 
		widgetType="table"		
		pageId="cpElencoDocumentiImpianti"
		javascriptDetection="false">
<s:set name="cpElencoDocumentiImpianti_tblElencoDocumenti_clearStatus" value="isTableClearStatus('cpElencoDocumentiImpianti_tblElencoDocumenti')" />
<s:url id="cpElencoDocumentiImpiantiViewUrl"						   
					   action="cpElencoDocumentiImpianti"
					   namespace="/base/elenco_documenti_impianti"/>
<display:table name="appDataelencoDocumenti"  				
			   excludedParams="*"			   export="true"
               id="widg_tblElencoDocumenti"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpElencoDocumentiImpiantiViewUrl}"  
               clearStatus="${cpElencoDocumentiImpianti_tblElencoDocumenti_clearStatus}"
               uid="row_tblElencoDocumenti"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoDocumenti.idDocumento}" name="appDataidDocumentoSelezionato" id="%{'tblElencoDocumenti-editcell-'+ (#attr.row_tblElencoDocumenti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="nomeDocOrig" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.nomeDocOrig.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nomeDocOrig" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.nomeDocOrig.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="nomeDocOrig" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.nomeDocOrig.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descTipoDocumento" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.descTipoDocumento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descTipoDocumento" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.descTipoDocumento.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descTipoDocumento" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.descTipoDocumento.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dataUpload" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.dataUpload.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataUpload" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.dataUpload.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="dataUpload" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.dataUpload.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descStatoDocumento" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.descStatoDocumento.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStatoDocumento" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.descStatoDocumento.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descStatoDocumento" titleKey="cpElencoDocumentiImpianti.tblElencoDocumenti.descStatoDocumento.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoDocumenti --></div>

			
	
	<div id="p_cpFunzElencoDocumenti" class="commandPanelBlock"><!-- startFragment:p_cpFunzElencoDocumenti -->
	
	
<div class="commandPanel functional" id="cpFunzElencoDocumenti">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btnVisualizzaDoc')" >

	



<!-- widget btnVisualizzaDoc -->
<s:submit name="widg_btnVisualizzaDoc" id="widg_btnVisualizzaDoc" method="handleBtnVisualizzaDoc_CLICKED"
	key="cpElencoDocumentiImpianti.btnVisualizzaDoc.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btnVisualizzaDoc')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btnInserisciDocumento')" >

	



<!-- widget btnInserisciDocumento -->
<s:submit name="widg_btnInserisciDocumento" id="widg_btnInserisciDocumento" method="handleBtnInserisciDocumento_CLICKED"
	key="cpElencoDocumentiImpianti.btnInserisciDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btnInserisciDocumento')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btnEliminaDocumento')" >

	



<!-- widget btnEliminaDocumento -->
<s:submit name="widg_btnEliminaDocumento" id="widg_btnEliminaDocumento" method="handleBtnEliminaDocumento_CLICKED"
	key="cpElencoDocumentiImpianti.btnEliminaDocumento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btnEliminaDocumento')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzElencoDocumenti --></div>

			
	
	
	<div id="p_mpDatiDocumento" class="panelBlock"><!-- startFragment:p_mpDatiDocumento -->
		

		
<s:if test="#session.cpElencoDocumentiImpianti_mpDatiDocumento_selectedMultiPanel == 'cpElencoDocumentiImpianti_mpDatiDocumento_fpDatiDocumento'">
	<s:include value="/jsp/multipanels/cpElencoDocumentiImpianti_mpDatiDocumento_fpDatiDocumento.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiDocumento --></div>

			
	
	
	<div id="p_mpElencoLibrettiCons" class="panelBlock"><!-- startFragment:p_mpElencoLibrettiCons -->
		

		
<s:if test="#session.cpElencoDocumentiImpianti_mpElencoLibrettiCons_selectedMultiPanel == 'cpElencoDocumentiImpianti_mpElencoLibrettiCons_fpElencoLibrettiConsolidato'">
	<s:include value="/jsp/multipanels/cpElencoDocumentiImpianti_mpElencoLibrettiCons_fpElencoLibrettiConsolidato.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpElencoLibrettiCons --></div>

			
	
	<div id="p_wpStoricoREE" class="widgetsPanelBlock"><!-- startFragment:p_wpStoricoREE -->
	
	
<h4 class="wpLabel">REE (Storico) </h4>
<div class="widgetsPanel" id="wpStoricoREE">
	

	
	
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','tblStoricoREE')" >

	
<div class="tableWidget">


<!-- widget tblStoricoREE -->
	<csiuicore:ajaxify id="p_wpStoricoREE" 
		widgetType="table"		
		pageId="cpElencoDocumentiImpianti"
		javascriptDetection="false">
<s:set name="cpElencoDocumentiImpianti_tblStoricoREE_clearStatus" value="isTableClearStatus('cpElencoDocumentiImpianti_tblStoricoREE')" />
<s:url id="cpElencoDocumentiImpiantiViewUrl"						   
					   action="cpElencoDocumentiImpianti"
					   namespace="/base/elenco_documenti_impianti"/>
<display:table name="appDataelencoAllegatiPerImpianto"  				
			   excludedParams="*"			   export="true"
               id="widg_tblStoricoREE"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpElencoDocumentiImpiantiViewUrl}"  
               clearStatus="${cpElencoDocumentiImpianti_tblStoricoREE_clearStatus}"
               uid="row_tblStoricoREE"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblStoricoREE.idAllegato}" name="appDataidAllegatoImpiantoSelezionato" id="%{'tblStoricoREE-editcell-'+ (#attr.row_tblStoricoREE_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="dataControllo" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.dataControllo.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataControllo" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.dataControllo.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataControllo" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.dataControllo.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="tipoAllegato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.tipoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="tipoAllegato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.tipoAllegato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="tipoAllegato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.tipoAllegato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="statoAllegato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.statoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="statoAllegato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="statoAllegato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="osservazioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.osservazioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="osservazioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.osservazioni.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="osservazioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.osservazioni.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="raccomandazioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.raccomandazioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="raccomandazioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.raccomandazioni.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="raccomandazioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.raccomandazioni.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="prescrizioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.prescrizioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="prescrizioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.prescrizioni.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="prescrizioni" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.prescrizioni.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="interventoRaccomandato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.interventoRaccomandato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="interventoRaccomandato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.interventoRaccomandato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="interventoRaccomandato" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.interventoRaccomandato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="elencoApparecchiature" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.elencoApparecchiature.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="elencoApparecchiature" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.elencoApparecchiature.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="elencoApparecchiature" titleKey="cpElencoDocumentiImpianti.tblStoricoREE.elencoApparecchiature.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpStoricoREE --></div>

			
	
	<div id="p_cpFunzElencoAllegatiPerImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunzElencoAllegatiPerImpianto -->
	
	
<div class="commandPanel functional" id="cpFunzElencoAllegatiPerImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btnDettaglioAllegatoPerImpianto')" >

	



<!-- widget btnDettaglioAllegatoPerImpianto -->
<s:submit name="widg_btnDettaglioAllegatoPerImpianto" id="widg_btnDettaglioAllegatoPerImpianto" method="handleBtnDettaglioAllegatoPerImpianto_CLICKED"
	key="cpElencoDocumentiImpianti.btnDettaglioAllegatoPerImpianto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btnDettaglioAllegatoPerImpianto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzElencoAllegatiPerImpianto --></div>

			
	
	<div id="p_cpNavElencoAllegatiPerImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavElencoAllegatiPerImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavElencoAllegatiPerImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoDocumentiImpianti','btnIndietroElencoAllegatiImpianti')" >

	



<!-- widget btnIndietroElencoAllegatiImpianti -->
<s:submit name="widg_btnIndietroElencoAllegatiImpianti" id="widg_btnIndietroElencoAllegatiImpianti" method="handleBtnIndietroElencoAllegatiImpianti_CLICKED"
	key="cpElencoDocumentiImpianti.btnIndietroElencoAllegatiImpianti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoDocumentiImpianti','btnIndietroElencoAllegatiImpianti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavElencoAllegatiPerImpianto --></div>

	

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
