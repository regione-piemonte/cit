<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_allegati_module/CpRisultatoRicercaAllegatiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_allegati_module -->
<!-- pageId:cpRisultatoRicercaAllegati -->

<s:form id="cpRisultatoRicercaAllegati" action="cpRisultatoRicercaAllegati" namespace="/base/risultato_ricerca_allegati_module" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisultatoRicercaAllegati_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRisRicercaAllegati" class="formPanelBlock"><!-- startFragment:p_fpRisRicercaAllegati -->
		
	
<h4 class="fpLabel"><s:text name="cpRisultatoRicercaAllegati.fpRisRicercaAllegati.label" /></h4>
<div class="formPanel" id="fpRisRicercaAllegati">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRisRicercaAllegati --></div>

			
	
	<div id="p_stdMsgElencoAllegati" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgElencoAllegati -->
	
	
<div class="stdMessagePanel" id="stdMsgElencoAllegati">
	<customtag:stdMessagePanel id="stdMsgElencoAllegati" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgElencoAllegati --></div>

			
	
	<div id="p_wpRisRicercaAllegati" class="widgetsPanelBlock"><!-- startFragment:p_wpRisRicercaAllegati -->
	
	
<h4 class="wpLabel">Elementi trovati </h4>
<div class="widgetsPanel" id="wpRisRicercaAllegati">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','tbRisRicercaAllegati')" >

	
<div class="tableWidget">


<!-- widget tbRisRicercaAllegati -->
	<csiuicore:ajaxify id="p_wpRisRicercaAllegati" 
		widgetType="table"		
		pageId="cpRisultatoRicercaAllegati"
		javascriptDetection="false">
<s:set name="cpRisultatoRicercaAllegati_tbRisRicercaAllegati_clearStatus" value="isTableClearStatus('cpRisultatoRicercaAllegati_tbRisRicercaAllegati')" />
<s:url id="cpRisultatoRicercaAllegatiViewUrl"						   
					   action="cpRisultatoRicercaAllegati"
					   namespace="/base/risultato_ricerca_allegati_module"/>
<display:table name="appDataelencoAllegati"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisRicercaAllegati"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoRicercaAllegatiViewUrl}"  
               clearStatus="${cpRisultatoRicercaAllegati_tbRisRicercaAllegati_clearStatus}"
               uid="row_tbRisRicercaAllegati"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisRicercaAllegati.id}" name="appDataidAllegatoSelezionato" id="%{'tbRisRicercaAllegati-editcell-'+ (#attr.row_tbRisRicercaAllegati_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="comune" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.comune.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.indirizzo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="manutentore" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.manutentore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="statoAllegato" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.statoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipoAllegato" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.tipoAllegato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataControllo" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.dataControllo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="siglaBollino" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.siglaBollino.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="numeroBollino" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.numeroBollino.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="elencoApparecchiature" titleKey="cpRisultatoRicercaAllegati.tbRisRicercaAllegati.elencoApparecchiature.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisRicercaAllegati --></div>

			
	
	<div id="p_cpExportExcel" class="commandPanelBlock"><!-- startFragment:p_cpExportExcel -->
	
	
<div class="commandPanel functional" id="cpExportExcel">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btExportExcel')" >

	



<!-- widget btExportExcel -->
<s:submit name="widg_btExportExcel" id="widg_btExportExcel" method="handleBtExportExcel_CLICKED"
	key="cpRisultatoRicercaAllegati.btExportExcel.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btExportExcel')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpExportExcel --></div>

			
	
	<div id="p_cpFunRisultatoRicercaAllegati" class="commandPanelBlock"><!-- startFragment:p_cpFunRisultatoRicercaAllegati -->
	
	
<div class="commandPanel functional" id="cpFunRisultatoRicercaAllegati">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnModificaAllegato')" >

	



<!-- widget btnModificaAllegato -->
<s:submit name="widg_btnModificaAllegato" id="widg_btnModificaAllegato" method="handleBtnModificaAllegato_CLICKED"
	key="cpRisultatoRicercaAllegati.btnModificaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnModificaAllegato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnDettaglioAllegato')" >

	



<!-- widget btnDettaglioAllegato -->
<s:submit name="widg_btnDettaglioAllegato" id="widg_btnDettaglioAllegato" method="handleBtnDettaglioAllegato_CLICKED"
	key="cpRisultatoRicercaAllegati.btnDettaglioAllegato.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnDettaglioAllegato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnInviaAllegato')" >

	



<!-- widget btnInviaAllegato -->
<s:submit name="widg_btnInviaAllegato" id="widg_btnInviaAllegato" method="handleBtnInviaAllegato_CLICKED"
	key="cpRisultatoRicercaAllegati.btnInviaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnInviaAllegato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnRespingiAllegato')" >

	



<!-- widget btnRespingiAllegato -->
<s:submit name="widg_btnRespingiAllegato" id="widg_btnRespingiAllegato" method="handleBtnRespingiAllegato_CLICKED"
	key="cpRisultatoRicercaAllegati.btnRespingiAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnRespingiAllegato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnEliminaAllegato')" >

	



<!-- widget btnEliminaAllegato -->
<s:submit name="widg_btnEliminaAllegato" id="widg_btnEliminaAllegato" method="handleBtnEliminaAllegato_CLICKED"
	key="cpRisultatoRicercaAllegati.btnEliminaAllegato.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnEliminaAllegato')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','bntnRicevuta')" >

	



<!-- widget bntnRicevuta -->
<s:submit name="widg_bntnRicevuta" id="widg_bntnRicevuta" method="handleBntnRicevuta_CLICKED"
	key="cpRisultatoRicercaAllegati.bntnRicevuta.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','bntnRicevuta')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnDocumentazione')" >

	



<!-- widget btnDocumentazione -->
<s:submit name="widg_btnDocumentazione" id="widg_btnDocumentazione" method="handleBtnDocumentazione_CLICKED"
	key="cpRisultatoRicercaAllegati.btnDocumentazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnDocumentazione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRisultatoRicercaAllegati --></div>

			
	
	<div id="p_cpNavRisultatoRicercaAllegati" class="commandPanelBlock"><!-- startFragment:p_cpNavRisultatoRicercaAllegati -->
	
	
<div class="commandPanel navigation" id="cpNavRisultatoRicercaAllegati">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoRicercaAllegati','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRisultatoRicercaAllegati.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaAllegati','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRisultatoRicercaAllegati --></div>

	

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
