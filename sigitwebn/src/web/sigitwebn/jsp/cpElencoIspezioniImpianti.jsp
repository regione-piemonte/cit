<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_ispezioni_impianti/CpElencoIspezioniImpiantiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/elenco_ispezioni_impianti -->
<!-- pageId:cpElencoIspezioniImpianti -->

<s:form id="cpElencoIspezioniImpianti" action="cpElencoIspezioniImpianti" namespace="/base/elenco_ispezioni_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpElencoIspezioniImpianti_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpElencoIspezioni" class="formPanelBlock"><!-- startFragment:p_fpElencoIspezioni -->
		
	
<h4 class="fpLabel"><s:text name="cpElencoIspezioniImpianti.fpElencoIspezioni.label" /></h4>
<div class="formPanel" id="fpElencoIspezioni">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpElencoIspezioni --></div>

			
	
	<div id="p_stdErrorMessageIspezioniImpianti" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageIspezioniImpianti -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageIspezioniImpianti">
	<customtag:stdMessagePanel id="stdErrorMessageIspezioniImpianti" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageIspezioniImpianti --></div>

			
	
	<div id="p_wpInfoIspezione" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoIspezione -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoIspezione">
	
	<customtag:widgetsPanel id="wpInfoIspezioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoIspezioniImpianti.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl" colSpan="3" position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoIspezione --></div>

			
	
	<div id="p_wpElencoIspezioniImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoIspezioniImpianto -->
	
	
<h4 class="wpLabel">ispezioni </h4>
<div class="widgetsPanel" id="wpElencoIspezioniImpianto">
	

	
	
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','tblElencoIspezioni')" >

	
<div class="tableWidget">


<!-- widget tblElencoIspezioni -->
	<csiuicore:ajaxify id="p_wpElencoIspezioniImpianto" 
		widgetType="table"		
		pageId="cpElencoIspezioniImpianti"
		javascriptDetection="false">
<s:set name="cpElencoIspezioniImpianti_tblElencoIspezioni_clearStatus" value="isTableClearStatus('cpElencoIspezioniImpianti_tblElencoIspezioni')" />
<s:url id="cpElencoIspezioniImpiantiViewUrl"						   
					   action="cpElencoIspezioniImpianti"
					   namespace="/base/elenco_ispezioni_impianti"/>
<display:table name="appDataelencoIspezioniPerImpianto"  				
			   excludedParams="*"			   export="true"
               id="widg_tblElencoIspezioni"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpElencoIspezioniImpiantiViewUrl}"  
               clearStatus="${cpElencoIspezioniImpianti_tblElencoIspezioni_clearStatus}"
               uid="row_tblElencoIspezioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoIspezioni.idIspezione}" name="appDataidIspezioneImpiantoSelezionato" id="%{'tblElencoIspezioni-editcell-'+ (#attr.row_tblElencoIspezioni_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="dataIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.dataIspezione.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.dataIspezione.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.dataIspezione.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="enteCompetente" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.enteCompetente.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="enteCompetente" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.enteCompetente.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="enteCompetente" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.enteCompetente.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="statoIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.statoIspezione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="statoIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.statoIspezione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="statoIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.statoIspezione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="note" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.note.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="note" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.note.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="note" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.note.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="esitoIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.esitoIspezione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="esitoIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.esitoIspezione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="esitoIspezione" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.esitoIspezione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="tipoAllegato" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.tipoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="tipoAllegato" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.tipoAllegato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="tipoAllegato" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.tipoAllegato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="statoAllegato" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.statoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="statoAllegato" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="statoAllegato" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="codiceBollino" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.codiceBollino.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceBollino" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.codiceBollino.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceBollino" titleKey="cpElencoIspezioniImpianti.tblElencoIspezioni.codiceBollino.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoIspezioniImpianto --></div>

			
	
	<div id="p_cpFunzElencoIspezioniPerImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunzElencoIspezioniPerImpianto -->
	
	
<div class="commandPanel functional" id="cpFunzElencoIspezioniPerImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnInserisciIspezionePerImpianto')" >

	



<!-- widget btnInserisciIspezionePerImpianto -->
<s:submit name="widg_btnInserisciIspezionePerImpianto" id="widg_btnInserisciIspezionePerImpianto" method="handleBtnInserisciIspezionePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnInserisciIspezionePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnInserisciIspezionePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnModificaIspezionePerImpianto')" >

	



<!-- widget btnModificaIspezionePerImpianto -->
<s:submit name="widg_btnModificaIspezionePerImpianto" id="widg_btnModificaIspezionePerImpianto" method="handleBtnModificaIspezionePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnModificaIspezionePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnModificaIspezionePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnConsolidaIspezionePerImpianto')" >

	



<!-- widget btnConsolidaIspezionePerImpianto -->
<s:submit name="widg_btnConsolidaIspezionePerImpianto" id="widg_btnConsolidaIspezionePerImpianto" method="handleBtnConsolidaIspezionePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnConsolidaIspezionePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnConsolidaIspezionePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnAnnullaIspezionePerImpianto')" >

	



<!-- widget btnAnnullaIspezionePerImpianto -->
<s:submit name="widg_btnAnnullaIspezionePerImpianto" id="widg_btnAnnullaIspezionePerImpianto" method="handleBtnAnnullaIspezionePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnAnnullaIspezionePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnAnnullaIspezionePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnDettaglioIspezionePerImpianto')" >

	



<!-- widget btnDettaglioIspezionePerImpianto -->
<s:submit name="widg_btnDettaglioIspezionePerImpianto" id="widg_btnDettaglioIspezionePerImpianto" method="handleBtnDettaglioIspezionePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnDettaglioIspezionePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnDettaglioIspezionePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnInserisciAllegatoIspePerImpianto')" >

	



<!-- widget btnInserisciAllegatoIspePerImpianto -->
<s:submit name="widg_btnInserisciAllegatoIspePerImpianto" id="widg_btnInserisciAllegatoIspePerImpianto" method="handleBtnInserisciAllegatoIspePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnInserisciAllegatoIspePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnInserisciAllegatoIspePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnModificaAllegatoIspePerImpianto')" >

	



<!-- widget btnModificaAllegatoIspePerImpianto -->
<s:submit name="widg_btnModificaAllegatoIspePerImpianto" id="widg_btnModificaAllegatoIspePerImpianto" method="handleBtnModificaAllegatoIspePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnModificaAllegatoIspePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnModificaAllegatoIspePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnDettaglioAllegatoIspePerImpianto')" >

	



<!-- widget btnDettaglioAllegatoIspePerImpianto -->
<s:submit name="widg_btnDettaglioAllegatoIspePerImpianto" id="widg_btnDettaglioAllegatoIspePerImpianto" method="handleBtnDettaglioAllegatoIspePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnDettaglioAllegatoIspePerImpianto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnDettaglioAllegatoIspePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnAnnullaAllegatoIspePerImpianto')" >

	



<!-- widget btnAnnullaAllegatoIspePerImpianto -->
<s:submit name="widg_btnAnnullaAllegatoIspePerImpianto" id="widg_btnAnnullaAllegatoIspePerImpianto" method="handleBtnAnnullaAllegatoIspePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnAnnullaAllegatoIspePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnAnnullaAllegatoIspePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnRicevutaAllegatoIspePerImpianto')" >

	



<!-- widget btnRicevutaAllegatoIspePerImpianto -->
<s:submit name="widg_btnRicevutaAllegatoIspePerImpianto" id="widg_btnRicevutaAllegatoIspePerImpianto" method="handleBtnRicevutaAllegatoIspePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnRicevutaAllegatoIspePerImpianto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnRicevutaAllegatoIspePerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnDocumentazioneAllegatoIspePerImpianto')" >

	



<!-- widget btnDocumentazioneAllegatoIspePerImpianto -->
<s:submit name="widg_btnDocumentazioneAllegatoIspePerImpianto" id="widg_btnDocumentazioneAllegatoIspePerImpianto" method="handleBtnDocumentazioneAllegatoIspePerImpianto_CLICKED"
	key="cpElencoIspezioniImpianti.btnDocumentazioneAllegatoIspePerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnDocumentazioneAllegatoIspePerImpianto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzElencoIspezioniPerImpianto --></div>

			
	
	<div id="p_cpNavElencoIspezioniPerImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavElencoIspezioniPerImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavElencoIspezioniPerImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoIspezioniImpianti','btnIndietroElencoIspezioniImpianti')" >

	



<!-- widget btnIndietroElencoIspezioniImpianti -->
<s:submit name="widg_btnIndietroElencoIspezioniImpianti" id="widg_btnIndietroElencoIspezioniImpianti" method="handleBtnIndietroElencoIspezioniImpianti_CLICKED"
	key="cpElencoIspezioniImpianti.btnIndietroElencoIspezioniImpianti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoIspezioniImpianti','btnIndietroElencoIspezioniImpianti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavElencoIspezioniPerImpianto --></div>

			
	
	
	<div id="p_mpDatiIspezione" class="panelBlock"><!-- startFragment:p_mpDatiIspezione -->
		

		
<s:if test="#session.cpElencoIspezioniImpianti_mpDatiIspezione_selectedMultiPanel == 'cpElencoIspezioniImpianti_mpDatiIspezione_fpDatiIspezioneIn'">
	<s:include value="/jsp/multipanels/cpElencoIspezioniImpianti_mpDatiIspezione_fpDatiIspezioneIn.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiIspezione --></div>

			
	
	
	<div id="p_mpDatiAllegato" class="panelBlock"><!-- startFragment:p_mpDatiAllegato -->
		

		
<s:if test="#session.cpElencoIspezioniImpianti_mpDatiAllegato_selectedMultiPanel == 'cpElencoIspezioniImpianti_mpDatiAllegato_fpDatiRapporto'">
	<s:include value="/jsp/multipanels/cpElencoIspezioniImpianti_mpDatiAllegato_fpDatiRapporto.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpDatiAllegato --></div>

	

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
