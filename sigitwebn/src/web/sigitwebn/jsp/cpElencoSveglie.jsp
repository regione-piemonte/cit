<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_azioni/CpElencoSveglieAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_azioni -->
<!-- pageId:cpElencoSveglie -->

<s:form id="cpElencoSveglie" action="cpElencoSveglie" namespace="/base/gestisci_azioni" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpElencoSveglie_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpElencoSveglie','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpSveglie" class="formPanelBlock"><!-- startFragment:p_fpSveglie -->
		
	
<h4 class="fpLabel"><s:text name="cpElencoSveglie.fpSveglie.label" /></h4>
<div class="formPanel" id="fpSveglie">


	
	

	
	
			
	
	<div id="p_stdMsgSveglia" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgSveglia -->
	
	
<div class="stdMessagePanel" id="stdMsgSveglia">
	<customtag:stdMessagePanel id="stdMsgSveglia" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgSveglia --></div>

			
	
	<div id="p_wpUtente" class="widgetsPanelBlock"><!-- startFragment:p_wpUtente -->
	
	
<h4 class="wpLabel">utente </h4>
<div class="widgetsPanel" id="wpUtente">
	
	<customtag:widgetsPanel id="wpUtenteTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpElencoSveglie','cfUtente')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpElencoSveglie.cfUtente.label')}" labelFor="widg_cfUtente" errorFor="appDataricercaSveglie.cfUtente" labelId="cfUtenteLbl"
	position="first"  >


<!-- widget cfUtente -->
<s:textfield 
	
title=""	
	name="appDataricercaSveglie.cfUtente" id="widg_cfUtente"
maxlength="16"	disabled="isWidgetDisabled('cpElencoSveglie','cfUtente')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoSveglie','btCercaUtente')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btCercaUtente -->
<s:submit name="widg_btCercaUtente" id="widg_btCercaUtente" method="handleBtCercaUtente_CLICKED"
	key="cpElencoSveglie.btCercaUtente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btCercaUtente')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoSveglie','ptDenominazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpElencoSveglie.ptDenominazione.label')}" labelFor="widg_ptDenominazione" errorFor="appDataricercaSveglie.denomUtente" labelId="ptDenominazioneLbl"  position="first" >


<!-- widget ptDenominazione -->
<s:property value="appDataricercaSveglie.denomUtente" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpElencoSveglie','btNuovaRicercaUtente')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btNuovaRicercaUtente -->
<s:submit name="widg_btNuovaRicercaUtente" id="widg_btNuovaRicercaUtente" method="handleBtNuovaRicercaUtente_CLICKED"
	key="cpElencoSveglie.btNuovaRicercaUtente.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btNuovaRicercaUtente')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpUtente --></div>

			
	
	<div id="p_wpVerifiche" class="widgetsPanelBlock"><!-- startFragment:p_wpVerifiche -->
	
	
<h4 class="wpLabel">verifica </h4>
<div class="widgetsPanel" id="wpVerifiche">
	

	
	
<s:if test="isWidgetVisible('cpElencoSveglie','tbVerifiche')" >

	
<div class="tableWidget">


<!-- widget tbVerifiche -->
	<csiuicore:ajaxify id="p_wpVerifiche" 
		widgetType="table"		
		pageId="cpElencoSveglie"
		javascriptDetection="false">
<s:set name="cpElencoSveglie_tbVerifiche_clearStatus" value="isTableClearStatus('cpElencoSveglie_tbVerifiche')" />
<s:url id="cpElencoSveglieViewUrl"						   
					   action="cpElencoSveglie"
					   namespace="/base/gestisci_azioni"/>
<display:table name="appDataelencoSveglieVerifica"  				
			   excludedParams="*"			   export="false"
               id="widg_tbVerifiche"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpElencoSveglieViewUrl}"  
               clearStatus="${cpElencoSveglie_tbVerifiche_clearStatus}"
               uid="row_tbVerifiche"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbVerifiche.identificativo}" name="appDataidVerificaSelezionata" id="%{'tbVerifiche-editcell-'+ (#attr.row_tbVerifiche_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpElencoSveglie.tbVerifiche.identificativo.label" 
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="dataSveglia" titleKey="cpElencoSveglie.tbVerifiche.dataSveglia.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="noteSveglia" titleKey="cpElencoSveglie.tbVerifiche.noteSveglia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpVerifiche --></div>

			
	
	<div id="p_cpFunVerifiche" class="commandPanelBlock"><!-- startFragment:p_cpFunVerifiche -->
	
	
<div class="commandPanel functional" id="cpFunVerifiche">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoSveglie','btVisVerifica')" >

	



<!-- widget btVisVerifica -->
<s:submit name="widg_btVisVerifica" id="widg_btVisVerifica" method="handleBtVisVerifica_CLICKED"
	key="cpElencoSveglie.btVisVerifica.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btVisVerifica')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunVerifiche --></div>

			
	
	<div id="p_wpAccertamento" class="widgetsPanelBlock"><!-- startFragment:p_wpAccertamento -->
	
	
<h4 class="wpLabel">accertamento </h4>
<div class="widgetsPanel" id="wpAccertamento">
	

	
	
<s:if test="isWidgetVisible('cpElencoSveglie','tbAccertamento')" >

	
<div class="tableWidget">


<!-- widget tbAccertamento -->
	<csiuicore:ajaxify id="p_wpAccertamento" 
		widgetType="table"		
		pageId="cpElencoSveglie"
		javascriptDetection="false">
<s:set name="cpElencoSveglie_tbAccertamento_clearStatus" value="isTableClearStatus('cpElencoSveglie_tbAccertamento')" />
<s:url id="cpElencoSveglieViewUrl"						   
					   action="cpElencoSveglie"
					   namespace="/base/gestisci_azioni"/>
<display:table name="appDataelencoSveglieAccertamento"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAccertamento"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpElencoSveglieViewUrl}"  
               clearStatus="${cpElencoSveglie_tbAccertamento_clearStatus}"
               uid="row_tbAccertamento"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbAccertamento.identificativo}" name="appDataidAccertamentoAssSelezionato" id="%{'tbAccertamento-editcell-'+ (#attr.row_tbAccertamento_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpElencoSveglie.tbAccertamento.identificativo.label" 
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="dataSveglia" titleKey="cpElencoSveglie.tbAccertamento.dataSveglia.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="noteSveglia" titleKey="cpElencoSveglie.tbAccertamento.noteSveglia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAccertamento --></div>

			
	
	<div id="p_cpFunAccertamento" class="commandPanelBlock"><!-- startFragment:p_cpFunAccertamento -->
	
	
<div class="commandPanel functional" id="cpFunAccertamento">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoSveglie','btVisAccertamento')" >

	



<!-- widget btVisAccertamento -->
<s:submit name="widg_btVisAccertamento" id="widg_btVisAccertamento" method="handleBtVisAccertamento_CLICKED"
	key="cpElencoSveglie.btVisAccertamento.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btVisAccertamento')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunAccertamento --></div>

			
	
	<div id="p_wpIspezione" class="widgetsPanelBlock"><!-- startFragment:p_wpIspezione -->
	
	
<h4 class="wpLabel">ispezione </h4>
<div class="widgetsPanel" id="wpIspezione">
	

	
	
<s:if test="isWidgetVisible('cpElencoSveglie','tbIspezione')" >

	
<div class="tableWidget">


<!-- widget tbIspezione -->
	<csiuicore:ajaxify id="p_wpIspezione" 
		widgetType="table"		
		pageId="cpElencoSveglie"
		javascriptDetection="false">
<s:set name="cpElencoSveglie_tbIspezione_clearStatus" value="isTableClearStatus('cpElencoSveglie_tbIspezione')" />
<s:url id="cpElencoSveglieViewUrl"						   
					   action="cpElencoSveglie"
					   namespace="/base/gestisci_azioni"/>
<display:table name="appDataelencoSveglieIspezione"  				
			   excludedParams="*"			   export="false"
               id="widg_tbIspezione"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpElencoSveglieViewUrl}"  
               clearStatus="${cpElencoSveglie_tbIspezione_clearStatus}"
               uid="row_tbIspezione"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbIspezione.identificativo}" name="appDataidIspezioneSelezionato" id="%{'tbIspezione-editcell-'+ (#attr.row_tbIspezione_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpElencoSveglie.tbIspezione.identificativo.label" 
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="dataSveglia" titleKey="cpElencoSveglie.tbIspezione.dataSveglia.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="noteSveglia" titleKey="cpElencoSveglie.tbIspezione.noteSveglia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpIspezione --></div>

			
	
	<div id="p_cpFunIspezione" class="commandPanelBlock"><!-- startFragment:p_cpFunIspezione -->
	
	
<div class="commandPanel functional" id="cpFunIspezione">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoSveglie','btVisIspezione')" >

	



<!-- widget btVisIspezione -->
<s:submit name="widg_btVisIspezione" id="widg_btVisIspezione" method="handleBtVisIspezione_CLICKED"
	key="cpElencoSveglie.btVisIspezione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btVisIspezione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunIspezione --></div>

			
	
	<div id="p_wpSanzione" class="widgetsPanelBlock"><!-- startFragment:p_wpSanzione -->
	
	
<h4 class="wpLabel">sanzione </h4>
<div class="widgetsPanel" id="wpSanzione">
	

	
	
<s:if test="isWidgetVisible('cpElencoSveglie','tbSanzione')" >

	
<div class="tableWidget">


<!-- widget tbSanzione -->
	<csiuicore:ajaxify id="p_wpSanzione" 
		widgetType="table"		
		pageId="cpElencoSveglie"
		javascriptDetection="false">
<s:set name="cpElencoSveglie_tbSanzione_clearStatus" value="isTableClearStatus('cpElencoSveglie_tbSanzione')" />
<s:url id="cpElencoSveglieViewUrl"						   
					   action="cpElencoSveglie"
					   namespace="/base/gestisci_azioni"/>
<display:table name="appDataelencoSveglieSanzione"  				
			   excludedParams="*"			   export="false"
               id="widg_tbSanzione"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpElencoSveglieViewUrl}"  
               clearStatus="${cpElencoSveglie_tbSanzione_clearStatus}"
               uid="row_tbSanzione"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbSanzione.identificativo}" name="appDataidSanzioneSelezionata" id="%{'tbSanzione-editcell-'+ (#attr.row_tbSanzione_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpElencoSveglie.tbSanzione.identificativo.label" 
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="dataSveglia" titleKey="cpElencoSveglie.tbSanzione.dataSveglia.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sigit.sigitwebn.presentation.sigitwebn.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="noteSveglia" titleKey="cpElencoSveglie.tbSanzione.noteSveglia.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpSanzione --></div>

			
	
	<div id="p_cpFunSanzione" class="commandPanelBlock"><!-- startFragment:p_cpFunSanzione -->
	
	
<div class="commandPanel functional" id="cpFunSanzione">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoSveglie','btVisSanzione')" >

	



<!-- widget btVisSanzione -->
<s:submit name="widg_btVisSanzione" id="widg_btVisSanzione" method="handleBtVisSanzione_CLICKED"
	key="cpElencoSveglie.btVisSanzione.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btVisSanzione')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunSanzione --></div>

			
	
	<div id="p_wpAccertamentoNonAss" class="widgetsPanelBlock"><!-- startFragment:p_wpAccertamentoNonAss -->
	
	
<h4 class="wpLabel">accertamento non associati </h4>
<div class="widgetsPanel" id="wpAccertamentoNonAss">
	

	
	
<s:if test="isWidgetVisible('cpElencoSveglie','tbAccertamentoNonAss')" >

	
<div class="tableWidget">


<!-- widget tbAccertamentoNonAss -->
	<csiuicore:ajaxify id="p_wpAccertamentoNonAss" 
		widgetType="table"		
		pageId="cpElencoSveglie"
		javascriptDetection="false">
<s:set name="cpElencoSveglie_tbAccertamentoNonAss_clearStatus" value="isTableClearStatus('cpElencoSveglie_tbAccertamentoNonAss')" />
<s:url id="cpElencoSveglieViewUrl"						   
					   action="cpElencoSveglie"
					   namespace="/base/gestisci_azioni"/>
<display:table name="appDataelencoSveglieAccertamentoNonAss"  				
			   excludedParams="*"			   export="false"
               id="widg_tbAccertamentoNonAss"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpElencoSveglieViewUrl}"  
               clearStatus="${cpElencoSveglie_tbAccertamentoNonAss_clearStatus}"
               uid="row_tbAccertamentoNonAss"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbAccertamentoNonAss.identificativo}" name="appDataidAccertamentoNonAssSelezionato" id="%{'tbAccertamentoNonAss-editcell-'+ (#attr.row_tbAccertamentoNonAss_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpElencoSveglie.tbAccertamentoNonAss.identificativo.label" 
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpElencoSveglie.tbAccertamentoNonAss.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzoImpianto" titleKey="cpElencoSveglie.tbAccertamentoNonAss.indirizzoImpianto.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAccertamentoNonAss --></div>

			
	
	<div id="p_cpFunAccertamentoNonAss" class="commandPanelBlock"><!-- startFragment:p_cpFunAccertamentoNonAss -->
	
	
<div class="commandPanel functional" id="cpFunAccertamentoNonAss">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoSveglie','btVisAccertamentoNonAss')" >

	



<!-- widget btVisAccertamentoNonAss -->
<s:submit name="widg_btVisAccertamentoNonAss" id="widg_btVisAccertamentoNonAss" method="handleBtVisAccertamentoNonAss_CLICKED"
	key="cpElencoSveglie.btVisAccertamentoNonAss.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btVisAccertamentoNonAss')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunAccertamentoNonAss --></div>

			
	
	<div id="p_wpIspezioneNonAss" class="widgetsPanelBlock"><!-- startFragment:p_wpIspezioneNonAss -->
	
	
<h4 class="wpLabel">ispezione non associate </h4>
<div class="widgetsPanel" id="wpIspezioneNonAss">
	

	
	
<s:if test="isWidgetVisible('cpElencoSveglie','tbIspezioneNonAss')" >

	
<div class="tableWidget">


<!-- widget tbIspezioneNonAss -->
	<csiuicore:ajaxify id="p_wpIspezioneNonAss" 
		widgetType="table"		
		pageId="cpElencoSveglie"
		javascriptDetection="false">
<s:set name="cpElencoSveglie_tbIspezioneNonAss_clearStatus" value="isTableClearStatus('cpElencoSveglie_tbIspezioneNonAss')" />
<s:url id="cpElencoSveglieViewUrl"						   
					   action="cpElencoSveglie"
					   namespace="/base/gestisci_azioni"/>
<display:table name="appDataelencoSveglieIspezioneNonAss"  				
			   excludedParams="*"			   export="false"
               id="widg_tbIspezioneNonAss"
               pagesize="5"
               keepStatus="true"
               requestURI="${cpElencoSveglieViewUrl}"  
               clearStatus="${cpElencoSveglie_tbIspezioneNonAss_clearStatus}"
               uid="row_tbIspezioneNonAss"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tbIspezioneNonAss.identificativo}" name="appDataidIspezioneNonAssSelezionato" id="%{'tbIspezioneNonAss-editcell-'+ (#attr.row_tbIspezioneNonAss_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="identificativo" titleKey="cpElencoSveglie.tbIspezioneNonAss.identificativo.label" 
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column property="codiceImpianto" titleKey="cpElencoSveglie.tbIspezioneNonAss.codiceImpianto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzoImpianto" titleKey="cpElencoSveglie.tbIspezioneNonAss.indirizzoImpianto.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>



	</csiuicore:ajaxify>


	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpIspezioneNonAss --></div>

			
	
	<div id="p_cpFunIspezioneNonAss" class="commandPanelBlock"><!-- startFragment:p_cpFunIspezioneNonAss -->
	
	
<div class="commandPanel functional" id="cpFunIspezioneNonAss">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoSveglie','btVisIspezioneNonAss')" >

	



<!-- widget btVisIspezioneNonAss -->
<s:submit name="widg_btVisIspezioneNonAss" id="widg_btVisIspezioneNonAss" method="handleBtVisIspezioneNonAss_CLICKED"
	key="cpElencoSveglie.btVisIspezioneNonAss.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btVisIspezioneNonAss')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunIspezioneNonAss --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		
		
<s:if test="isWidgetVisible('cpElencoSveglie','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpElencoSveglie.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpElencoSveglie','btIndietro')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpSveglie --></div>

	

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
