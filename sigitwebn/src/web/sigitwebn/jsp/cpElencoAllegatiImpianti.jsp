<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_allegati_impianti/CpElencoAllegatiImpiantiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/elenco_allegati_impianti -->
<!-- pageId:cpElencoAllegatiImpianti -->

<s:form id="cpElencoAllegatiImpianti" action="cpElencoAllegatiImpianti" namespace="/base/elenco_allegati_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpElencoAllegatiImpianti_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','menu')" >

	


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
		
	
<h4 class="fpLabel"><s:text name="cpElencoAllegatiImpianti.fpElencoAllegati.label" /></h4>
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
	

	
	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoAllegatiImpianti.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl" colSpan="3" position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpElencoAllegatiImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAllegatiImpianto -->
	
	
<h4 class="wpLabel">REE </h4>
<div class="widgetsPanel" id="wpElencoAllegatiImpianto">
	

	
	
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','tblElencoAllegati')" >

	
<div class="tableWidget">


<!-- widget tblElencoAllegati -->
	<csiuicore:ajaxify id="p_wpElencoAllegatiImpianto" 
		widgetType="table"		
		pageId="cpElencoAllegatiImpianti"
		javascriptDetection="false">
<s:set name="cpElencoAllegatiImpianti_tblElencoAllegati_clearStatus" value="isTableClearStatus('cpElencoAllegatiImpianti_tblElencoAllegati')" />
<s:url id="cpElencoAllegatiImpiantiViewUrl"						   
					   action="cpElencoAllegatiImpianti"
					   namespace="/base/elenco_allegati_impianti"/>
<display:table name="appDataelencoAllegatiPerImpianto"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoAllegati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpElencoAllegatiImpiantiViewUrl}"  
               clearStatus="${cpElencoAllegatiImpianti_tblElencoAllegati_clearStatus}"
               uid="row_tblElencoAllegati"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoAllegati.idAllegato}" name="appDataidAllegatoImpiantoSelezionato" id="%{'tblElencoAllegati-editcell-'+ (#attr.row_tblElencoAllegati_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="dataControllo" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.dataControllo.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="tipoAllegato" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.tipoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="statoAllegato" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.statoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="osservazioni" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.osservazioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="raccomandazioni" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.raccomandazioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="prescrizioni" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.prescrizioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="interventoRaccomandato" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.interventoRaccomandato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="elencoApparecchiature" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.elencoApparecchiature.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="presenzaVerifica" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.presenzaVerifica.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgFirmato" titleKey="cpElencoAllegatiImpianti.tblElencoAllegati.flgFirmato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAllegatiImpianto --></div>

			
	
	<div id="p_cpExportExcel" class="commandPanelBlock"><!-- startFragment:p_cpExportExcel -->
	
	
<div class="commandPanel functional" id="cpExportExcel">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btExportExcel')" >

	



<!-- widget btExportExcel -->
<s:submit name="widg_btExportExcel" id="widg_btExportExcel" method="handleBtExportExcel_CLICKED"
	key="cpElencoAllegatiImpianti.btExportExcel.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btExportExcel')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpExportExcel --></div>

			
	
	<div id="p_cpFunzElencoAllegatiPerImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunzElencoAllegatiPerImpianto -->
	
	
<div class="commandPanel functional" id="cpFunzElencoAllegatiPerImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnInserisciAllegatoPerImpianto')" >

	



<!-- widget btnInserisciAllegatoPerImpianto -->
<s:submit name="widg_btnInserisciAllegatoPerImpianto" id="widg_btnInserisciAllegatoPerImpianto" method="handleBtnInserisciAllegatoPerImpianto_CLICKED"
	key="cpElencoAllegatiImpianti.btnInserisciAllegatoPerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnInserisciAllegatoPerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnModificaAllegatoPerImpianto')" >

	



<!-- widget btnModificaAllegatoPerImpianto -->
<s:submit name="widg_btnModificaAllegatoPerImpianto" id="widg_btnModificaAllegatoPerImpianto" method="handleBtnModificaAllegatoPerImpianto_CLICKED"
	key="cpElencoAllegatiImpianti.btnModificaAllegatoPerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnModificaAllegatoPerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnDettaglioAllegatoPerImpianto')" >

	



<!-- widget btnDettaglioAllegatoPerImpianto -->
<s:submit name="widg_btnDettaglioAllegatoPerImpianto" id="widg_btnDettaglioAllegatoPerImpianto" method="handleBtnDettaglioAllegatoPerImpianto_CLICKED"
	key="cpElencoAllegatiImpianti.btnDettaglioAllegatoPerImpianto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnDettaglioAllegatoPerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnInviaAllegatoPerImpianto')" >

	



<!-- widget btnInviaAllegatoPerImpianto -->
<s:submit name="widg_btnInviaAllegatoPerImpianto" id="widg_btnInviaAllegatoPerImpianto" method="handleBtnInviaAllegatoPerImpianto_CLICKED"
	key="cpElencoAllegatiImpianti.btnInviaAllegatoPerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnInviaAllegatoPerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnRespingiAllegatoPerImpianto')" >

	



<!-- widget btnRespingiAllegatoPerImpianto -->
<s:submit name="widg_btnRespingiAllegatoPerImpianto" id="widg_btnRespingiAllegatoPerImpianto" method="handleBtnRespingiAllegatoPerImpianto_CLICKED"
	key="cpElencoAllegatiImpianti.btnRespingiAllegatoPerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnRespingiAllegatoPerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnEliminaAllegatoPerImpianto')" >

	



<!-- widget btnEliminaAllegatoPerImpianto -->
<s:submit name="widg_btnEliminaAllegatoPerImpianto" id="widg_btnEliminaAllegatoPerImpianto" method="handleBtnEliminaAllegatoPerImpianto_CLICKED"
	key="cpElencoAllegatiImpianti.btnEliminaAllegatoPerImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnEliminaAllegatoPerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnInsVerifica')" >

	



<!-- widget btnInsVerifica -->
<s:submit name="widg_btnInsVerifica" id="widg_btnInsVerifica" method="handleBtnInsVerifica_CLICKED"
	key="cpElencoAllegatiImpianti.btnInsVerifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnInsVerifica')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnRicevutaPerImpianto')" >

	



<!-- widget btnRicevutaPerImpianto -->
<s:submit name="widg_btnRicevutaPerImpianto" id="widg_btnRicevutaPerImpianto" method="handleBtnRicevutaPerImpianto_CLICKED"
	key="cpElencoAllegatiImpianti.btnRicevutaPerImpianto.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnRicevutaPerImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnDocumentazione')" >

	



<!-- widget btnDocumentazione -->
<s:submit name="widg_btnDocumentazione" id="widg_btnDocumentazione" method="handleBtnDocumentazione_CLICKED"
	key="cpElencoAllegatiImpianti.btnDocumentazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnDocumentazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnReeFirmato')" >

	



<!-- widget btnReeFirmato -->
<s:submit name="widg_btnReeFirmato" id="widg_btnReeFirmato" method="handleBtnReeFirmato_CLICKED"
	key="cpElencoAllegatiImpianti.btnReeFirmato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnReeFirmato')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzElencoAllegatiPerImpianto --></div>

			
	
	<div id="p_cpNavElencoAllegatiPerImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavElencoAllegatiPerImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavElencoAllegatiPerImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAllegatiImpianti','btnIndietroElencoAllegatiImpianti')" >

	



<!-- widget btnIndietroElencoAllegatiImpianti -->
<s:submit name="widg_btnIndietroElencoAllegatiImpianti" id="widg_btnIndietroElencoAllegatiImpianti" method="handleBtnIndietroElencoAllegatiImpianti_CLICKED"
	key="cpElencoAllegatiImpianti.btnIndietroElencoAllegatiImpianti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAllegatiImpianti','btnIndietroElencoAllegatiImpianti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavElencoAllegatiPerImpianto --></div>

			
	
	
	<div id="p_mpDatiAllegato" class="panelBlock"><!-- startFragment:p_mpDatiAllegato -->
		

		
<s:if test="#session.cpElencoAllegatiImpianti_mpDatiAllegato_selectedMultiPanel == 'cpElencoAllegatiImpianti_mpDatiAllegato_fpDatiAllegato'">
	<s:include value="/jsp/multipanels/cpElencoAllegatiImpianti_mpDatiAllegato_fpDatiAllegato.jsp" ></s:include>
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
