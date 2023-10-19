<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/back_office/CpElencoAbilitazioniAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/back_office -->
<!-- pageId:cpElencoAbilitazioni -->

<s:form id="cpElencoAbilitazioni" action="cpElencoAbilitazioni" namespace="/base/back_office" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpElencoAbilitazioni_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpElencoAbilitazioni','menu')" >

	


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

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpElencoAbilitazioni_udpExpMass.jsp"></s:include>

	



			
	
	<div id="p_fpElencoAbil" class="formPanelBlock"><!-- startFragment:p_fpElencoAbil -->
		
	
<h4 class="fpLabel"><s:text name="cpElencoAbilitazioni.fpElencoAbil.label" /></h4>
<div class="formPanel" id="fpElencoAbil">


	
	

	
	
			
	
	<div id="p_stdMsgPHome" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgPHome -->
	
	
<div class="stdMessagePanel" id="stdMsgPHome">
	<customtag:stdMessagePanel id="stdMsgPHome" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgPHome --></div>

			
	
	<div id="p_fpAbilitazioni" class="formPanelBlock"><!-- startFragment:p_fpAbilitazioni -->
		
	


	
	

	
	
			
	
	<div id="p_wpRicercaAbilitazioni" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAbilitazioni -->
	
	
<h4 class="wpLabel">ricerca abilitazioni </h4>
<div class="widgetsPanel" id="wpRicercaAbilitazioni">
	
	<customtag:widgetsPanel id="wpRicercaAbilitazioniTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoAbilitazioni','cbElencoRuoli')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAbilitazioni.cbElencoRuoli.label')}" labelFor="widg_cbElencoRuoli" errorFor="appDataricercaAbilitazione.idRuoloPa" labelId="cbElencoRuoliLbl"
	  >


<!-- widget cbElencoRuoli -->
<s:select name="appDataricercaAbilitazione.idRuoloPa" id="widg_cbElencoRuoli"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoRuolo"
	  disabled="isWidgetDisabled('cpElencoAbilitazioni','cbElencoRuoli')"
	  listKey="id"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAbilitazioni','cbElencoUtenti')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAbilitazioni.cbElencoUtenti.label')}" labelFor="widg_cbElencoUtenti" errorFor="appDataricercaAbilitazione.idPersonaFisica" labelId="cbElencoUtentiLbl"
	  >


<!-- widget cbElencoUtenti -->
<s:select name="appDataricercaAbilitazione.idPersonaFisica" id="widg_cbElencoUtenti"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoUtentiPa"
	  disabled="isWidgetDisabled('cpElencoAbilitazioni','cbElencoUtenti')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpElencoAbilitazioni','cbElencoIstat')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoAbilitazioni.cbElencoIstat.label')}" labelFor="widg_cbElencoIstat" errorFor="appDataricercaAbilitazione.istatAbilitazione" labelId="cbElencoIstatLbl"
	  >


<!-- widget cbElencoIstat -->
<s:select name="appDataricercaAbilitazione.istatAbilitazione" id="widg_cbElencoIstat"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoIstatAbilitazioni"
	  disabled="isWidgetDisabled('cpElencoAbilitazioni','cbElencoIstat')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAbilitazioni --></div>

			
	
	<div id="p_cpAbilitazioni" class="commandPanelBlock"><!-- startFragment:p_cpAbilitazioni -->
	
	
<div class="commandPanel functional" id="cpAbilitazioni">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpElencoAbilitazioni','btnRicercaAbilitazioni')" >

	



<!-- widget btnRicercaAbilitazioni -->
<s:submit name="widg_btnRicercaAbilitazioni" id="widg_btnRicercaAbilitazioni" method="handleBtnRicercaAbilitazioni_CLICKED"
	key="cpElencoAbilitazioni.btnRicercaAbilitazioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAbilitazioni','btnRicercaAbilitazioni')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpAbilitazioni --></div>

			
	
	<div id="p_wpElencoAbilitazioni" class="widgetsPanelBlock"><!-- startFragment:p_wpElencoAbilitazioni -->
	
	
<h4 class="wpLabel">elenco abilitazioni </h4>
<div class="widgetsPanel" id="wpElencoAbilitazioni">
	

	
	
<s:if test="isWidgetVisible('cpElencoAbilitazioni','tbElencoAbilitazioni')" >

	
<div class="tableWidget">


<!-- widget tbElencoAbilitazioni -->
	<csiuicore:ajaxify id="p_wpElencoAbilitazioni" 
		widgetType="table"		
		pageId="cpElencoAbilitazioni"
		javascriptDetection="false">
<s:set name="cpElencoAbilitazioni_tbElencoAbilitazioni_clearStatus" value="isTableClearStatus('cpElencoAbilitazioni_tbElencoAbilitazioni')" />
<s:url id="cpElencoAbilitazioniViewUrl"						   
					   action="cpElencoAbilitazioni"
					   namespace="/base/back_office"/>
<display:table name="appDatalistaAbilitazioni"  				
			   excludedParams="*"			   export="true"
               id="widg_tbElencoAbilitazioni"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpElencoAbilitazioniViewUrl}"  
               clearStatus="${cpElencoAbilitazioni_tbElencoAbilitazioni_clearStatus}"
               uid="row_tbElencoAbilitazioni"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbElencoAbilitazioni.idAbilitazione}" name="appDataidAbilitazioneSelez" id="%{'tbElencoAbilitazioni-editcell-'+ (#attr.row_tbElencoAbilitazioni_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="descRuoloPa" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descRuoloPa.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descRuoloPa" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descRuoloPa.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descRuoloPa" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descRuoloPa.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="istatAbilitazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.istatAbilitazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="istatAbilitazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.istatAbilitazione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="istatAbilitazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.istatAbilitazione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descrAbilitazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descrAbilitazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descrAbilitazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descrAbilitazione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descrAbilitazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descrAbilitazione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="mailComunicazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.mailComunicazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="mailComunicazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.mailComunicazione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="mailComunicazione" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.mailComunicazione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descUtente" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descUtente.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descUtente" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descUtente.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descUtente" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.descUtente.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dataInizio" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.dataInizio.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataInizio" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.dataInizio.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataInizio" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.dataInizio.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="dataFine" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.dataFine.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataFine" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.dataFine.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataFine" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.dataFine.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="note" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.note.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="note" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.note.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="note" titleKey="cpElencoAbilitazioni.tbElencoAbilitazioni.note.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpElencoAbilitazioni --></div>

			
	
	<div id="p_cpGestAbilitazioni" class="commandPanelBlock"><!-- startFragment:p_cpGestAbilitazioni -->
	
	
<div class="commandPanel functional" id="cpGestAbilitazioni">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAbilitazioni','btnNuovaAbilitazioni')" >

	



<!-- widget btnNuovaAbilitazioni -->
<s:submit name="widg_btnNuovaAbilitazioni" id="widg_btnNuovaAbilitazioni" method="handleBtnNuovaAbilitazioni_CLICKED"
	key="cpElencoAbilitazioni.btnNuovaAbilitazioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAbilitazioni','btnNuovaAbilitazioni')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAbilitazioni','btnCessaAbilitazione')" >

	



<!-- widget btnCessaAbilitazione -->
<s:submit name="widg_btnCessaAbilitazione" id="widg_btnCessaAbilitazione" method="handleBtnCessaAbilitazione_CLICKED"
	key="cpElencoAbilitazioni.btnCessaAbilitazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAbilitazioni','btnCessaAbilitazione')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpElencoAbilitazioni','btnAggMailAbilitazione')" >

	



<!-- widget btnAggMailAbilitazione -->
<s:submit name="widg_btnAggMailAbilitazione" id="widg_btnAggMailAbilitazione" method="handleBtnAggMailAbilitazione_CLICKED"
	key="cpElencoAbilitazioni.btnAggMailAbilitazione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAbilitazioni','btnAggMailAbilitazione')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpGestAbilitazioni --></div>

			
	
	
	<div id="p_mpAggMail" class="panelBlock"><!-- startFragment:p_mpAggMail -->
		

		
<s:if test="#session.cpElencoAbilitazioni_mpAggMail_selectedMultiPanel == 'cpElencoAbilitazioni_mpAggMail_fpAggMail'">
	<s:include value="/jsp/multipanels/cpElencoAbilitazioni_mpAggMail_fpAggMail.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpAggMail --></div>

	

		
	

	<!-- endFragment:p_fpAbilitazioni --></div>

	

		
	
</div>

	<!-- endFragment:p_fpElencoAbil --></div>

			
	
	<div id="p_cpElencoAbilBack" class="commandPanelBlock"><!-- startFragment:p_cpElencoAbilBack -->
	
	
<div class="commandPanel navigation" id="cpElencoAbilBack">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpElencoAbilitazioni','cbIndietro')" >

	



<!-- widget cbIndietro -->
<s:submit name="widg_cbIndietro" id="widg_cbIndietro" method="handleCbIndietro_CLICKED"
	key="cpElencoAbilitazioni.cbIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoAbilitazioni','cbIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpElencoAbilBack --></div>

	

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
