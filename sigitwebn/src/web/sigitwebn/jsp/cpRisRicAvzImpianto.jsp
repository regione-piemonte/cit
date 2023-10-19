<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/risultato_ricerca_avanzata_impianti/CpRisRicAvzImpiantoAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/risultato_ricerca_avanzata_impianti -->
<!-- pageId:cpRisRicAvzImpianto -->

<s:form id="cpRisRicAvzImpianto" action="cpRisRicAvzImpianto" namespace="/base/risultato_ricerca_avanzata_impianti" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisRicAvzImpianto_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpRisRicAvzImpianto" class="formPanelBlock"><!-- startFragment:p_fpRisRicAvzImpianto -->
		
	
<h4 class="fpLabel"><s:text name="cpRisRicAvzImpianto.fpRisRicAvzImpianto.label" /></h4>
<div class="formPanel" id="fpRisRicAvzImpianto">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpRisRicAvzImpianto --></div>

			
	
	<div id="p_stdMsgPRisRicImp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPRisRicImp -->
	
	
<div class="stdMessagePanel" id="stdMsgPRisRicImp">
	<customtag:stdMessagePanel id="stdMsgPRisRicImp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPRisRicImp --></div>

			
	
	<div id="p_wpRisImp" class="widgetsPanelBlock"><!-- startFragment:p_wpRisImp -->
	
	
<h4 class="wpLabel">impianti trovati </h4>
<div class="widgetsPanel" id="wpRisImp">
	

	
	
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','tbRisultatoRicImp')" >

	
<div class="tableWidget">


<!-- widget tbRisultatoRicImp -->
	<csiuicore:ajaxify id="p_wpRisImp" 
		widgetType="table"		
		pageId="cpRisRicAvzImpianto"
		javascriptDetection="false">
<s:set name="cpRisRicAvzImpianto_tbRisultatoRicImp_clearStatus" value="isTableClearStatus('cpRisRicAvzImpianto_tbRisultatoRicImp')" />
<s:url id="cpRisRicAvzImpiantoViewUrl"						   
					   action="cpRisRicAvzImpianto"
					   namespace="/base/risultato_ricerca_avanzata_impianti"/>
<display:table name="appDatarisultatoRicercaImpianti"  				
			   excludedParams="*"			   export="false"
               id="widg_tbRisultatoRicImp"
               pagesize="20"
               keepStatus="true"
               requestURI="${cpRisRicAvzImpiantoViewUrl}"  
               clearStatus="${cpRisRicAvzImpianto_tbRisultatoRicImp_clearStatus}"
               uid="row_tbRisultatoRicImp"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbRisultatoRicImp.codiceImpianto}" name="appDataidImpiantoSelez" id="%{'tbRisultatoRicImp-editcell-'+ (#attr.row_tbRisultatoRicImp_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descComune" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.descComune.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.indirizzo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denomResponsabile" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.denomResponsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denom3Responsabile" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.denom3Responsabile.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="sezione" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.sezione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="foglio" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.foglio.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="particella" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.particella.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="subalterno" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.subalterno.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="pod" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.pod.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="pdr" titleKey="cpRisRicAvzImpianto.tbRisultatoRicImp.pdr.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisImp --></div>

			
	
	<div id="p_exportTable" class="commandPanelBlock"><!-- startFragment:p_exportTable -->
	
	
<div class="commandPanel functional" id="exportTable">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','exportExcel')" >

	



<!-- widget exportExcel -->
<s:submit name="widg_exportExcel" id="widg_exportExcel" method="handleExportExcel_CLICKED"
	key="cpRisRicAvzImpianto.exportExcel.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','exportExcel')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_exportTable --></div>

			
	
	<div id="p_cpFunRisRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpFunRisRicImpianto -->
	
	
<div class="commandPanel functional" id="cpFunRisRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnVisRappControllo')" >

	



<!-- widget btnVisRappControllo -->
<s:submit name="widg_btnVisRappControllo" id="widg_btnVisRappControllo" method="handleBtnVisRappControllo_CLICKED"
	key="cpRisRicAvzImpianto.btnVisRappControllo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnVisRappControllo')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnModImpianto')" >

	



<!-- widget btnModImpianto -->
<s:submit name="widg_btnModImpianto" id="widg_btnModImpianto" method="handleBtnModImpianto_CLICKED"
	key="cpRisRicAvzImpianto.btnModImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnModImpianto')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnInsVerifica')" >

	



<!-- widget btnInsVerifica -->
<s:submit name="widg_btnInsVerifica" id="widg_btnInsVerifica" method="handleBtnInsVerifica_CLICKED"
	key="cpRisRicAvzImpianto.btnInsVerifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnInsVerifica')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnVisIspezioniOLD')" >

	



<!-- widget btnVisIspezioniOLD -->
<s:submit name="widg_btnVisIspezioniOLD" id="widg_btnVisIspezioniOLD" method="handleBtnVisIspezioniOLD_CLICKED"
	key="cpRisRicAvzImpianto.btnVisIspezioniOLD.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnVisIspezioniOLD')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnVisDocumentazione')" >

	



<!-- widget btnVisDocumentazione -->
<s:submit name="widg_btnVisDocumentazione" id="widg_btnVisDocumentazione" method="handleBtnVisDocumentazione_CLICKED"
	key="cpRisRicAvzImpianto.btnVisDocumentazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnVisDocumentazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnVisLibrettoWeb')" >

	



<!-- widget btnVisLibrettoWeb -->
<s:submit name="widg_btnVisLibrettoWeb" id="widg_btnVisLibrettoWeb" method="handleBtnVisLibrettoWeb_CLICKED"
	key="cpRisRicAvzImpianto.btnVisLibrettoWeb.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnVisLibrettoWeb')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnVisImpianto')" >

	



<!-- widget btnVisImpianto -->
<s:submit name="widg_btnVisImpianto" id="widg_btnVisImpianto" method="handleBtnVisImpianto_CLICKED"
	key="cpRisRicAvzImpianto.btnVisImpianto.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnVisImpianto')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunRisRicImpianto --></div>

			
	
	<div id="p_cpNavRisRicImpianto" class="commandPanelBlock"><!-- startFragment:p_cpNavRisRicImpianto -->
	
	
<div class="commandPanel navigation" id="cpNavRisRicImpianto">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisRicAvzImpianto','btnIndietro')" >

	



<!-- widget btnIndietro -->
<s:submit name="widg_btnIndietro" id="widg_btnIndietro" method="handleBtnIndietro_CLICKED"
	key="cpRisRicAvzImpianto.btnIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisRicAvzImpianto','btnIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavRisRicImpianto --></div>

	

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
