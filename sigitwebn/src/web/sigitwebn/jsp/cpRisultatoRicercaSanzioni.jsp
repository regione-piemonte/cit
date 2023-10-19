<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_sanzioni/CpRisultatoRicercaSanzioniAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_sanzioni -->
<!-- pageId:cpRisultatoRicercaSanzioni -->

<s:form id="cpRisultatoRicercaSanzioni" action="cpRisultatoRicercaSanzioni" namespace="/base/gestisci_sanzioni" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisultatoRicercaSanzioni_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisultatoRicercaSanzioni','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpTitle" class="formPanelBlock"><!-- startFragment:p_fpTitle -->
		
	
<h4 class="fpLabel"><s:text name="cpRisultatoRicercaSanzioni.fpTitle.label" /></h4>
<div class="formPanel" id="fpTitle">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitle --></div>

			
	
	<div id="p_stdErrorMessageRisultatoRicercaSanzioni" class="stdMessagePanelBlock"><!-- startFragment:p_stdErrorMessageRisultatoRicercaSanzioni -->
	
	
<div class="stdMessagePanel" id="stdErrorMessageRisultatoRicercaSanzioni">
	<customtag:stdMessagePanel id="stdErrorMessageRisultatoRicercaSanzioni" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdErrorMessageRisultatoRicercaSanzioni --></div>

			
	
	<div id="p_wpRisultato" class="widgetsPanelBlock"><!-- startFragment:p_wpRisultato -->
	
	
<h4 class="wpLabel">sanzioni trovate </h4>
<div class="widgetsPanel" id="wpRisultato">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoRicercaSanzioni','tbRisultatiRicerca')" >

	
<div class="tableWidget">


<!-- widget tbRisultatiRicerca -->
	<csiuicore:ajaxify id="p_wpRisultato" 
		widgetType="table"		
		pageId="cpRisultatoRicercaSanzioni"
		javascriptDetection="false">
<s:set name="cpRisultatoRicercaSanzioni_tbRisultatiRicerca_clearStatus" value="isTableClearStatus('cpRisultatoRicercaSanzioni_tbRisultatiRicerca')" />
<s:url id="cpRisultatoRicercaSanzioniViewUrl"						   
					   action="cpRisultatoRicercaSanzioni"
					   namespace="/base/gestisci_sanzioni"/>
<display:table name="appDataelencoRisultatiRicercaSanzioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatiRicerca"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpRisultatoRicercaSanzioniViewUrl}"  
               clearStatus="${cpRisultatoRicercaSanzioni_tbRisultatiRicerca_clearStatus}"
               uid="row_tbRisultatiRicerca"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatiRicerca.idSanzione}" name="appDataidSanzioneSelezionata" id="%{'tbRisultatiRicerca-editcell-'+ (#attr.row_tbRisultatiRicerca_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="idSanzione" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.idSanzione.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="assegnatario" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.assegnatario.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="stato" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.stato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataCreazione" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.dataCreazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataComunicazione" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.dataComunicazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataPagamento" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.dataPagamento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataAnnullamento" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.dataAnnullamento.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="sanzionato" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.sanzionato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="importo" titleKey="cpRisultatoRicercaSanzioni.tbRisultatiRicerca.importo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisultato --></div>

			
	
	<div id="p_cpFunRisultatoRicercaSanzioni" class="commandPanelBlock"><!-- startFragment:p_cpFunRisultatoRicercaSanzioni -->
	
	
<div class="commandPanel functional" id="cpFunRisultatoRicercaSanzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpRisultatoRicercaSanzioni','btnDettaglioSanzione')" >

	



<!-- widget btnDettaglioSanzione -->
<s:submit name="widg_btnDettaglioSanzione" id="widg_btnDettaglioSanzione" method="handleBtnDettaglioSanzione_CLICKED"
	key="cpRisultatoRicercaSanzioni.btnDettaglioSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaSanzioni','btnDettaglioSanzione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunRisultatoRicercaSanzioni --></div>

			
	
	<div id="p_cpNavRisultatoRicercaSanzioni" class="commandPanelBlock"><!-- startFragment:p_cpNavRisultatoRicercaSanzioni -->
	
	
<div class="commandPanel navigation" id="cpNavRisultatoRicercaSanzioni">

	
	
		
		
<s:if test="isWidgetVisible('cpRisultatoRicercaSanzioni','btnIndietroRisultatoRicercaSanzioni')" >

	



<!-- widget btnIndietroRisultatoRicercaSanzioni -->
<s:submit name="widg_btnIndietroRisultatoRicercaSanzioni" id="widg_btnIndietroRisultatoRicercaSanzioni" method="handleBtnIndietroRisultatoRicercaSanzioni_CLICKED"
	key="cpRisultatoRicercaSanzioni.btnIndietroRisultatoRicercaSanzioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoRicercaSanzioni','btnIndietroRisultatoRicercaSanzioni')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNavRisultatoRicercaSanzioni --></div>

	

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
