<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_ispezioni_impianti/CpDettaglioIspezioneAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/elenco_ispezioni_impianti -->
<!-- pageId:cpDettaglioIspezione -->

<s:form id="cpDettaglioIspezione" action="cpDettaglioIspezione" namespace="/base/elenco_ispezioni_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioIspezione_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpDettaglioIspezione','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpDettIspezione" class="formPanelBlock"><!-- startFragment:p_fpDettIspezione -->
		
	
<h4 class="fpLabel"><s:text name="cpDettaglioIspezione.fpDettIspezione.label" /></h4>
<div class="formPanel" id="fpDettIspezione">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpDettIspezione --></div>

			
	
	<div id="p_stdErrorMessageDettIspezione" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageDettIspezione -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageDettIspezione">
	<customtag:stdMessagePanel id="stdErrorMessageDettIspezione" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageDettIspezione --></div>

			
	
	<div id="p_wpDettIspezione" class="widgetsPanelBlock"><!-- startFragment:p_wpDettIspezione -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpDettIspezione">
	
	<customtag:widgetsPanel id="wpDettIspezioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl" colSpan="3" position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettIspezione --></div>

			
	
	<div id="p_wpDettIspezione2" class="widgetsPanelBlock"><!-- startFragment:p_wpDettIspezione2 -->
	
	
<h4 class="wpLabel">ispezione </h4>
<div class="widgetsPanel" id="wpDettIspezione2">
	
	<customtag:widgetsPanel id="wpDettIspezione2Tbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptDataAvvioIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptDataAvvioIspezione.label')}" labelFor="widg_ptDataAvvioIspezione" errorFor="appDataispezione.dataIspezione" labelId="ptDataAvvioIspezioneLbl"  position="first" >


<!-- widget ptDataAvvioIspezione -->
<s:property value="appDataispezione.dataIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptEnte')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptEnte.label')}" labelFor="widg_ptEnte" errorFor="appDataispezione.enteCompetente" labelId="ptEnteLbl"  position="last" >


<!-- widget ptEnte -->
<s:property value="appDataispezione.enteCompetente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptStatoIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptStatoIspezione.label')}" labelFor="widg_ptStatoIspezione" errorFor="appDataispezione.statoIspezione" labelId="ptStatoIspezioneLbl"  position="first" >


<!-- widget ptStatoIspezione -->
<s:property value="appDataispezione.statoIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptNote')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptNote.label')}" labelFor="widg_ptNote" errorFor="appDataispezione.note" labelId="ptNoteLbl"  position="last" >


<!-- widget ptNote -->
<s:property value="appDataispezione.note" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioIspezione','ptEsitoIspezione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioIspezione.ptEsitoIspezione.label')}" labelFor="widg_ptEsitoIspezione" errorFor="appDataispezione.esitoIspezione" labelId="ptEsitoIspezioneLbl" colSpan="3" position="first" >


<!-- widget ptEsitoIspezione -->
<s:property value="appDataispezione.esitoIspezione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettIspezione2 --></div>

			
	
	<div id="p_wpElencoRappProva" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoRappProva -->
	
	
<h4 class="wpLabel">Rapporti di prova </h4>
<div class="widgetsPanel" id="wpElencoRappProva">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioIspezione','tblElencoRappProva')" >

	
<div class="tableWidget">


<!-- widget tblElencoRappProva -->
	<csiuicore:ajaxify id="p_wpElencoRappProva" 
		widgetType="table"		
		pageId="cpDettaglioIspezione"
		javascriptDetection="false">
<s:set name="cpDettaglioIspezione_tblElencoRappProva_clearStatus" value="isTableClearStatus('cpDettaglioIspezione_tblElencoRappProva')" />
<s:url id="cpDettaglioIspezioneViewUrl"						   
					   action="cpDettaglioIspezione"
					   namespace="/base/elenco_ispezioni_impianti"/>
<display:table name="appDataelencoAllegatiIsp"  				
			   excludedParams="*"			   export="true"
               id="widg_tblElencoRappProva"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpDettaglioIspezioneViewUrl}"  
               clearStatus="${cpDettaglioIspezione_tblElencoRappProva_clearStatus}"
               uid="row_tblElencoRappProva"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoRappProva.idIspezione}" name="appDataidAllegatoIspSelezionato" id="%{'tblElencoRappProva-editcell-'+ (#attr.row_tblElencoRappProva_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="dataControllo" titleKey="cpDettaglioIspezione.tblElencoRappProva.dataControllo.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataControllo" titleKey="cpDettaglioIspezione.tblElencoRappProva.dataControllo.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataControllo" titleKey="cpDettaglioIspezione.tblElencoRappProva.dataControllo.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="tipoAllegato" titleKey="cpDettaglioIspezione.tblElencoRappProva.tipoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="tipoAllegato" titleKey="cpDettaglioIspezione.tblElencoRappProva.tipoAllegato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="tipoAllegato" titleKey="cpDettaglioIspezione.tblElencoRappProva.tipoAllegato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="statoAllegato" titleKey="cpDettaglioIspezione.tblElencoRappProva.statoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="statoAllegato" titleKey="cpDettaglioIspezione.tblElencoRappProva.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="statoAllegato" titleKey="cpDettaglioIspezione.tblElencoRappProva.statoAllegato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="osservazioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.osservazioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="osservazioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.osservazioni.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="osservazioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.osservazioni.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="raccomandazioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.raccomandazioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="raccomandazioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.raccomandazioni.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="raccomandazioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.raccomandazioni.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="prescrizioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.prescrizioni.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="prescrizioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.prescrizioni.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="prescrizioni" titleKey="cpDettaglioIspezione.tblElencoRappProva.prescrizioni.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="elencoApparecchiature" titleKey="cpDettaglioIspezione.tblElencoRappProva.elencoApparecchiature.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="elencoApparecchiature" titleKey="cpDettaglioIspezione.tblElencoRappProva.elencoApparecchiature.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="elencoApparecchiature" titleKey="cpDettaglioIspezione.tblElencoRappProva.elencoApparecchiature.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoRappProva --></div>

			
	
	<div id="p_cpFunzDettIspezione" class="commandPanelBlock"><!-- startFragment:p_cpFunzDettIspezione -->
	
	
<div class="commandPanel functional" id="cpFunzDettIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnInserisciRappProva')" >

	



<!-- widget btnInserisciRappProva -->
<s:submit name="widg_btnInserisciRappProva" id="widg_btnInserisciRappProva" method="handleBtnInserisciRappProva_CLICKED"
	key="cpDettaglioIspezione.btnInserisciRappProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnInserisciRappProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnModificaRappProva')" >

	



<!-- widget btnModificaRappProva -->
<s:submit name="widg_btnModificaRappProva" id="widg_btnModificaRappProva" method="handleBtnModificaRappProva_CLICKED"
	key="cpDettaglioIspezione.btnModificaRappProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnModificaRappProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnDettaglioRappProva')" >

	



<!-- widget btnDettaglioRappProva -->
<s:submit name="widg_btnDettaglioRappProva" id="widg_btnDettaglioRappProva" method="handleBtnDettaglioRappProva_CLICKED"
	key="cpDettaglioIspezione.btnDettaglioRappProva.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnDettaglioRappProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnAnnullaRappProva')" >

	



<!-- widget btnAnnullaRappProva -->
<s:submit name="widg_btnAnnullaRappProva" id="widg_btnAnnullaRappProva" method="handleBtnAnnullaRappProva_CLICKED"
	key="cpDettaglioIspezione.btnAnnullaRappProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnAnnullaRappProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnRicevutaRappProva')" >

	



<!-- widget btnRicevutaRappProva -->
<s:submit name="widg_btnRicevutaRappProva" id="widg_btnRicevutaRappProva" method="handleBtnRicevutaRappProva_CLICKED"
	key="cpDettaglioIspezione.btnRicevutaRappProva.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnRicevutaRappProva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnDocumentazioneRappProva')" >

	



<!-- widget btnDocumentazioneRappProva -->
<s:submit name="widg_btnDocumentazioneRappProva" id="widg_btnDocumentazioneRappProva" method="handleBtnDocumentazioneRappProva_CLICKED"
	key="cpDettaglioIspezione.btnDocumentazioneRappProva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnDocumentazioneRappProva')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunzDettIspezione --></div>

			
	
	<div id="p_cpNavDettIspezione" class="commandPanelBlock"><!-- startFragment:p_cpNavDettIspezione -->
	
	
<div class="commandPanel navigation" id="cpNavDettIspezione">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioIspezione','btnIndietroElencoIspezioniImpianti')" >

	



<!-- widget btnIndietroElencoIspezioniImpianti -->
<s:submit name="widg_btnIndietroElencoIspezioniImpianti" id="widg_btnIndietroElencoIspezioniImpianti" method="handleBtnIndietroElencoIspezioniImpianti_CLICKED"
	key="cpDettaglioIspezione.btnIndietroElencoIspezioniImpianti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioIspezione','btnIndietroElencoIspezioniImpianti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavDettIspezione --></div>

			
	
	
	<div id="p_mpDatiAllegato" class="panelBlock"><!-- startFragment:p_mpDatiAllegato -->
		

		
<s:if test="#session.cpDettaglioIspezione_mpDatiAllegato_selectedMultiPanel == 'cpDettaglioIspezione_mpDatiAllegato_fpDatiRapporto'">
	<s:include value="/jsp/multipanels/cpDettaglioIspezione_mpDatiAllegato_fpDatiRapporto.jsp" ></s:include>
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
