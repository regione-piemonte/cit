<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/conferma_terzo_responsabile/CpConf3RespAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/conferma_terzo_responsabile -->
<!-- pageId:cpConf3Resp -->

<s:form id="cpConf3Resp" action="cpConf3Resp" namespace="/base/conferma_terzo_responsabile" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpConf3Resp_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpConf3Resp','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpConf3Responsabile" class="formPanelBlock"><!-- startFragment:p_fpConf3Responsabile -->
		
	
<h4 class="fpLabel"><s:text name="cpConf3Resp.fpConf3Responsabile.label" /></h4>
<div class="formPanel" id="fpConf3Responsabile">


	
	

	
	
			
	
	<div id="p_stdMsgPGest3Resp" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPGest3Resp -->
	
	
<div class="stdMessagePanel" id="stdMsgPGest3Resp">
	<customtag:stdMessagePanel id="stdMsgPGest3Resp" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPGest3Resp --></div>

			
	
	<div id="p_wp3Responsabile" class="widgetsPanelBlock"><!-- startFragment:p_wp3Responsabile -->
	
	
<h4 class="wpLabel">dati Terzo responsabile </h4>
<div class="widgetsPanel" id="wp3Responsabile">
	
	<customtag:widgetsPanel id="wp3ResponsabileTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpConf3Resp','cbCodRea')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.cbCodRea.label')}" labelFor="widg_cbCodRea" errorFor="appDatadettaglioTerzoResponsabile.codiceRea" labelId="cbCodReaLbl"   >


<!-- widget cbCodRea -->
<s:property value="appDatadettaglioTerzoResponsabile.codiceRea" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpConf3Resp','tfCf')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.tfCf.label')}" labelFor="widg_tfCf" errorFor="appDatadettaglioTerzoResponsabile.codiceFiscale" labelId="tfCfLbl"   >


<!-- widget tfCf -->
<s:property value="appDatadettaglioTerzoResponsabile.codiceFiscale" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpConf3Resp','tfImpresa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.tfImpresa.label')}" labelFor="widg_tfImpresa" errorFor="appDatadettaglioTerzoResponsabile.denominazioneImp" labelId="tfImpresaLbl"   >


<!-- widget tfImpresa -->
<s:property value="appDatadettaglioTerzoResponsabile.denominazioneImp" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wp3Responsabile --></div>

			
	
	<div id="p_wpContratto" class="widgetsPanelBlock"><!-- startFragment:p_wpContratto -->
	
	
<h4 class="wpLabel">dati contratto </h4>
<div class="widgetsPanel" id="wpContratto">
	
	<customtag:widgetsPanel id="wpContrattoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpConf3Resp','cbDataInizio')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.cbDataInizio.label')}" labelFor="widg_cbDataInizio" errorFor="appDatadettaglioTerzoResponsabile.dataInizioContratto" labelId="cbDataInizioLbl"   >


<!-- widget cbDataInizio -->
<s:property value="appDatadettaglioTerzoResponsabile.dataInizioContratto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpConf3Resp','cbDataFine')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.cbDataFine.label')}" labelFor="widg_cbDataFine" errorFor="appDatadettaglioTerzoResponsabile.dataFineContratto" labelId="cbDataFineLbl"   >


<!-- widget cbDataFine -->
<s:property value="appDatadettaglioTerzoResponsabile.dataFineContratto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpConf3Resp','tfTacitoRin')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.tfTacitoRin.label')}" labelFor="widg_tfTacitoRin" errorFor="appDatadettaglioTerzoResponsabile.descTacitoRinnovo" labelId="tfTacitoRinLbl"   >


<!-- widget tfTacitoRin -->
<s:property value="appDatadettaglioTerzoResponsabile.descTacitoRinnovo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpContratto --></div>

			
	
	<div id="p_wpImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpImpianto">
	
	<customtag:widgetsPanel id="wpImpiantoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpConf3Resp','cbCodImp')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.cbCodImp.label')}" labelFor="widg_cbCodImp" errorFor="appDatadettaglioTerzoResponsabile.codImpianto" labelId="cbCodImpLbl"   >


<!-- widget cbCodImp -->
<s:property value="appDatadettaglioTerzoResponsabile.codImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpConf3Resp','cbUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.cbUbicazione.label')}" labelFor="widg_cbUbicazione" errorFor="appDatadettaglioTerzoResponsabile.ubicazione" labelId="cbUbicazioneLbl"   >


<!-- widget cbUbicazione -->
<s:property value="appDatadettaglioTerzoResponsabile.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpConf3Resp','tfResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpConf3Resp.tfResponsabile.label')}" labelFor="widg_tfResponsabile" errorFor="appDatadettaglioTerzoResponsabile.responsabile" labelId="tfResponsabileLbl"   >


<!-- widget tfResponsabile -->
<s:property value="appDatadettaglioTerzoResponsabile.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpImpianto --></div>

			
	
	<div id="p_wpAutodichiarazioni" class="widgetsPanelBlock"><!-- startFragment:p_wpAutodichiarazioni -->
	
	
<h4 class="wpLabel">Autodichiarazione dei titoli e dello stato dell'impianto </h4>
<div class="widgetsPanel" id="wpAutodichiarazioni">
	

	
	
<s:if test="isWidgetVisible('cpConf3Resp','tbAutodichiarazioni')" >

	
<div class="tableWidget">


<!-- widget tbAutodichiarazioni -->
	<csiuicore:ajaxify id="p_wpAutodichiarazioni" 
		widgetType="table"		
		pageId="cpConf3Resp"
		javascriptDetection="false">
<s:set name="cpConf3Resp_tbAutodichiarazioni_clearStatus" value="isTableClearStatus('cpConf3Resp_tbAutodichiarazioni')" />
<s:url id="cpConf3RespViewUrl"						   
					   action="cpConf3Resp"
					   namespace="/base/conferma_terzo_responsabile"/>
<display:table name="appDataelencoAutodichiarazioni"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAutodichiarazioni"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpConf3RespViewUrl}"  
               clearStatus="${cpConf3Resp_tbAutodichiarazioni_clearStatus}"
               uid="row_tbAutodichiarazioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbAutodichiarazioni.id}" name="appDataelencoIdSelezionati" id="%{'tbAutodichiarazioni-editcell-'+ (#attr.row_tbAutodichiarazioni_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="description" titleKey="cpConf3Resp.tbAutodichiarazioni.description.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>

<s:hidden name="__tableselectionempty_appDataelencoIdSelezionati" id="__tableselectionempty_widg_tbAutodichiarazioni" />


	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAutodichiarazioni --></div>

			
	
	<div id="p_cpFunGest3Resp" class="commandPanelBlock"><!-- startFragment:p_cpFunGest3Resp -->
	
	
<div class="commandPanel functional" id="cpFunGest3Resp">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpConf3Resp','btnConfResp')" >

	



<!-- widget btnConfResp -->
<s:submit name="widg_btnConfResp" id="widg_btnConfResp" method="handleBtnConfResp_CLICKED"
	key="cpConf3Resp.btnConfResp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpConf3Resp','btnConfResp')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest3Resp --></div>

			
	
	<div id="p_cpNavGest3Resp" class="commandPanelBlock"><!-- startFragment:p_cpNavGest3Resp -->
	
	
<div class="commandPanel navigation" id="cpNavGest3Resp">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpConf3Resp','btn3RespIndietro')" >

	



<!-- widget btn3RespIndietro -->
<s:submit name="widg_btn3RespIndietro" id="widg_btn3RespIndietro" method="handleBtn3RespIndietro_CLICKED"
	key="cpConf3Resp.btn3RespIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpConf3Resp','btn3RespIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGest3Resp --></div>

	

		
	
</div>

	<!-- endFragment:p_fpConf3Responsabile --></div>

	

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
