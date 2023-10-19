<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/gestisci_libretto_scheda6/CpGestLibScheda6Action" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_libretto_scheda6 -->
<!-- pageId:cpGestLibScheda6 -->

<s:form id="cpGestLibScheda6" action="cpGestLibScheda6" namespace="/base/gestisci_libretto_scheda6" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda6_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpGestLibScheda6','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_menuPanel --></div>

	

	<!-- endFragment:p_fpUpUserInfo --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_fpLeftMenu" class="formPanelBlock"><!-- startFragment:p_fpLeftMenu -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpGestLibScheda6_udpFunzionalita.jsp"></s:include>

	



			
	
	<div id="p_wpMenuTree" class="widgetsPanelBlock"><!-- startFragment:p_wpMenuTree -->
	
	

<div class="widgetsPanel" id="wpMenuTree">
	
	<customtag:widgetsPanel id="wpMenuTreeTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda6','menuLibretto')" >

	
<customtag:widgetsPanelColumn 
	 colSpan="2" >



	<csiuicore:ajaxify id="p_fpLeftMenu" 
		widgetType="tree" 
		pageId="cpGestLibScheda6"
		javascriptDetection="false">
	<customtag:tree
		name="appDatalibrettoMenuTree"
		cssUlClass="tree"
        cssRootClass="treeRoot" cssFolderOpenClass="treeFolderOpen"
        cssFolderClosedClass="treeFolderClosed" cssDotClass="treeDot"
		linkOnTree="true" id="menuLibretto"
		selectionMultiplicity="none"
		requestURI="/sigitwebn/base/gestisci_libretto_scheda6/cpGestLibScheda6!handleMenuLibretto_CLICKED.do"
		nameSpace="/base/gestisci_libretto_scheda6"
		showChildNumber="false">
	</customtag:tree>

	</csiuicore:ajaxify>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMenuTree --></div>

	

	<!-- endFragment:p_fpLeftMenu --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">

					
	
	<div id="p_fpCenter" class="formPanelBlock"><!-- startFragment:p_fpCenter -->

	
	

	
	
			
	
	<div id="p_fpTitolo" class="formPanelBlock"><!-- startFragment:p_fpTitolo -->
		
	
<h4 class="fpLabel"><s:text name="cpGestLibScheda6.fpTitolo.label" /></h4>
<div class="formPanel" id="fpTitolo">


	
	

	
	
	

		
	
</div>

	<!-- endFragment:p_fpTitolo --></div>

			
	
	<div id="p_stdMsgLibretto" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgLibretto -->
	
	
<div class="stdMessagePanel" id="stdMsgLibretto">
	<customtag:stdMessagePanel id="stdMsgLibretto" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgLibretto --></div>

			
	
	<div id="p_wpInfoImpianto" class="widgetsPanelBlock"><!-- startFragment:p_wpInfoImpianto -->
	
	
<h4 class="wpLabel">impianto </h4>
<div class="widgetsPanel" id="wpInfoImpianto">
	
	<customtag:widgetsPanel id="wpInfoImpiantoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda6','ptCodiceImpianto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda6.ptCodiceImpianto.label')}" labelFor="widg_ptCodiceImpianto" errorFor="appDataidentificativoImpianto.codiceImpianto" labelId="ptCodiceImpiantoLbl"  position="first" >


<!-- widget ptCodiceImpianto -->
<s:property value="appDataidentificativoImpianto.codiceImpianto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','ptUbicazione')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda6.ptUbicazione.label')}" labelFor="widg_ptUbicazione" errorFor="appDataidentificativoImpianto.ubicazione" labelId="ptUbicazioneLbl"  position="last" >


<!-- widget ptUbicazione -->
<s:property value="appDataidentificativoImpianto.ubicazione" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','ptResponsabile')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpGestLibScheda6.ptResponsabile.label')}" labelFor="widg_ptResponsabile" errorFor="appDataidentificativoImpianto.responsabile" labelId="ptResponsabileLbl"  position="first" >


<!-- widget ptResponsabile -->
<s:property value="appDataidentificativoImpianto.responsabile" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','wpInfoImpianto_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpInfoImpianto_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfoImpianto --></div>

			
	
	<div id="p_wpTipoDistribuzione" class="widgetsPanelBlock"><!-- startFragment:p_wpTipoDistribuzione -->
	
	
<h4 class="wpLabel">6.1 Tipo di distribuzione </h4>
<div class="widgetsPanel" id="wpTipoDistribuzione">
	
	<customtag:widgetsPanel id="wpTipoDistribuzioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda6','cbTipoVerticale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda6.cbTipoVerticale.label')}" labelFor="widg_cbTipoVerticale" errorFor="appDatasistemaDistribuzione.l6_1flagTipoVerticale" labelId="cbTipoVerticaleLbl"
	position="first"  >


<!-- widget cbTipoVerticale -->
<s:checkbox 
	
	
	name="appDatasistemaDistribuzione.l6_1flagTipoVerticale" id="widg_cbTipoVerticale"
	disabled="isWidgetDisabled('cpGestLibScheda6','cbTipoVerticale')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda6','cbTipoVerticale')" >
	<s:hidden name="__checkbox_appDatasistemaDistribuzione.l6_1flagTipoVerticale" id="__checkbox_widg_cbTipoVerticale" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','wpTipoDistribuzione_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTipoDistribuzione_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','cbTipoOrizzontale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda6.cbTipoOrizzontale.label')}" labelFor="widg_cbTipoOrizzontale" errorFor="appDatasistemaDistribuzione.l6_1flagTipoOrizzontale" labelId="cbTipoOrizzontaleLbl"
	position="first"  >


<!-- widget cbTipoOrizzontale -->
<s:checkbox 
	
	
	name="appDatasistemaDistribuzione.l6_1flagTipoOrizzontale" id="widg_cbTipoOrizzontale"
	disabled="isWidgetDisabled('cpGestLibScheda6','cbTipoOrizzontale')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda6','cbTipoOrizzontale')" >
	<s:hidden name="__checkbox_appDatasistemaDistribuzione.l6_1flagTipoOrizzontale" id="__checkbox_widg_cbTipoOrizzontale" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','wpTipoDistribuzione_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTipoDistribuzione_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','cbTipoCanali')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda6.cbTipoCanali.label')}" labelFor="widg_cbTipoCanali" errorFor="appDatasistemaDistribuzione.l6_1flagTipoCanali" labelId="cbTipoCanaliLbl"
	position="first"  >


<!-- widget cbTipoCanali -->
<s:checkbox 
	
	
	name="appDatasistemaDistribuzione.l6_1flagTipoCanali" id="widg_cbTipoCanali"
	disabled="isWidgetDisabled('cpGestLibScheda6','cbTipoCanali')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda6','cbTipoCanali')" >
	<s:hidden name="__checkbox_appDatasistemaDistribuzione.l6_1flagTipoCanali" id="__checkbox_widg_cbTipoCanali" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','wpTipoDistribuzione_3_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpTipoDistribuzione_3_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','cbTipoAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda6.cbTipoAltro.label')}" labelFor="widg_cbTipoAltro" errorFor="appDatasistemaDistribuzione.l6_1flagAltro" labelId="cbTipoAltroLbl"
	position="first"  >


<!-- widget cbTipoAltro -->
<s:checkbox 
	
	
	name="appDatasistemaDistribuzione.l6_1flagAltro" id="widg_cbTipoAltro"
	disabled="isWidgetDisabled('cpGestLibScheda6','cbTipoAltro')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpGestLibScheda6','cbTipoAltro')" >
	<s:hidden name="__checkbox_appDatasistemaDistribuzione.l6_1flagAltro" id="__checkbox_widg_cbTipoAltro" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','tfAltro')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda6.tfAltro.label')}" labelFor="widg_tfAltro" errorFor="appDatasistemaDistribuzione.l6_1Altro" labelId="tfAltroLbl"
	position="last"  >


<!-- widget tfAltro -->
<s:textarea 
	
	
	name="appDatasistemaDistribuzione.l6_1Altro" id="widg_tfAltro"
	disabled="isWidgetDisabled('cpGestLibScheda6','tfAltro')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpTipoDistribuzione --></div>

			
	
	<div id="p_wpCoibentazioneReteDistribuzione" class="widgetsPanelBlock"><!-- startFragment:p_wpCoibentazioneReteDistribuzione -->
	
	
<h4 class="wpLabel">6.2 Coibentazione rete di distribuzione </h4>
<div class="widgetsPanel" id="wpCoibentazioneReteDistribuzione">
	
	<customtag:widgetsPanel id="wpCoibentazioneReteDistribuzioneTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda6','cbCoibentazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda6.cbCoibentazione.label')}" labelFor="widg_cbCoibentazione" errorFor="appDatasistemaDistribuzione.l6_2Coibent" labelId="cbCoibentazioneLbl"
	position="first"  >


<!-- widget cbCoibentazione -->
<s:select name="appDatasistemaDistribuzione.l6_2Coibent" id="widg_cbCoibentazione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoPresenteAssente"
	  disabled="isWidgetDisabled('cpGestLibScheda6','cbCoibentazione')"
	  listKey="code"
	  listValue="description"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','wpCoibentazioneReteDistribuzione_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCoibentazioneReteDistribuzione_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','tfNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpGestLibScheda6.tfNote.label')}" labelFor="widg_tfNote" errorFor="appDatasistemaDistribuzione.l6_2Note" labelId="tfNoteLbl"
	position="first"  >


<!-- widget tfNote -->
<s:textarea 
	
	
	name="appDatasistemaDistribuzione.l6_2Note" id="widg_tfNote"
	disabled="isWidgetDisabled('cpGestLibScheda6','tfNote')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpGestLibScheda6','wpCoibentazioneReteDistribuzione_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpCoibentazioneReteDistribuzione_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpCoibentazioneReteDistribuzione --></div>

			
	
	<div id="p_wpVasiEspansione" class="widgetsPanelBlock"><!-- startFragment:p_wpVasiEspansione -->
	
	
<h4 class="wpLabel">6.3 Vasi di espansione </h4>
<div class="widgetsPanel" id="wpVasiEspansione">
	

	
	
<s:if test="isWidgetVisible('cpGestLibScheda6','tbVasiEspansione')" >

	
<div class="tableWidget">


<!-- widget tbVasiEspansione -->
<s:set name="cpGestLibScheda6_tbVasiEspansione_clearStatus" value="isTableClearStatus('cpGestLibScheda6_tbVasiEspansione')" />
<s:url id="cpGestLibScheda6ViewUrl"						   
					   action="cpGestLibScheda6"
					   namespace="/base/gestisci_libretto_scheda6"/>
<display:table name="appDatalistaComponentiVX"  				
			   excludedParams="*"			   export="false"
               id="widg_tbVasiEspansione"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpGestLibScheda6ViewUrl}"  
               clearStatus="${cpGestLibScheda6_tbVasiEspansione_clearStatus}"
               uid="row_tbVasiEspansione"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tbVasiEspansione.indice}" name="appDatarigheSelezionate" id="%{'tbVasiEspansione-editcell-'+ (#attr.row_tbVasiEspansione_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>
		<display:column property="indice" titleKey="cpGestLibScheda6.tbVasiEspansione.indice.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>
		<display:column titleKey="cpGestLibScheda6.tbVasiEspansione.capacita.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaComponentiVX['+(#attr.row_tbVasiEspansione_rowNum - 1)+'].capacita'}"  disabled="%{!appDatalistaComponentiVX[(#attr.row_tbVasiEspansione_rowNum - 1)].rigaEditabile}"   theme="csi-tableinput-rem" maxlength="9" size="15" />
		</display:column>
		
		<display:column titleKey="cpGestLibScheda6.tbVasiEspansione.vaso.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:select name="%{'appDatalistaComponentiVX['+(#attr.row_tbVasiEspansione_rowNum - 1)+'].vaso'}" headerKey="" headerValue=""  list="appDataelencoApertoChiuso"  disabled="%{!appDatalistaComponentiVX[(#attr.row_tbVasiEspansione_rowNum - 1)].rigaEditabile}"  listKey="code" listValue="description" theme="csi-tableinput-rem"/>
		</display:column>
		
		<display:column titleKey="cpGestLibScheda6.tbVasiEspansione.pressioneBar.label" 
			sortable="false" headerClass="nosort" media="html"
>
				<s:textfield name="%{'appDatalistaComponentiVX['+(#attr.row_tbVasiEspansione_rowNum - 1)+'].pressioneBar'}"  disabled="%{!appDatalistaComponentiVX[(#attr.row_tbVasiEspansione_rowNum - 1)].rigaEditabile}"   theme="csi-tableinput-rem" maxlength="8" size="15" />
		</display:column>
		
</display:table>

<s:hidden name="__tableselectionempty_appDatarigheSelezionate" id="__tableselectionempty_widg_tbVasiEspansione" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpVasiEspansione --></div>

			
	
	<div id="p_cpFunGestTable" class="commandPanelBlock"><!-- startFragment:p_cpFunGestTable -->
	
	
<div class="commandPanel functional" id="cpFunGestTable">

	
	
		
		
<s:if test="isWidgetVisible('cpGestLibScheda6','bRipristinaAttuale')" >

	



<!-- widget bRipristinaAttuale -->
<s:submit name="widg_bRipristinaAttuale" id="widg_bRipristinaAttuale" method="handleBRipristinaAttuale_CLICKED"
	key="cpGestLibScheda6.bRipristinaAttuale.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda6','bRipristinaAttuale')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda6','bRimuoviRiga')" >

	



<!-- widget bRimuoviRiga -->
<s:submit name="widg_bRimuoviRiga" id="widg_bRimuoviRiga" method="handleBRimuoviRiga_CLICKED"
	key="cpGestLibScheda6.bRimuoviRiga.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda6','bRimuoviRiga')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpGestLibScheda6','bAggiungiRiga')" >

	



<!-- widget bAggiungiRiga -->
<s:submit name="widg_bAggiungiRiga" id="widg_bAggiungiRiga" method="handleBAggiungiRiga_CLICKED"
	key="cpGestLibScheda6.bAggiungiRiga.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda6','bAggiungiRiga')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFunGestTable --></div>

			
	
	<div id="p_cpFunGest" class="commandPanelBlock"><!-- startFragment:p_cpFunGest -->
	
	
<div class="commandPanel functional" id="cpFunGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda6','bSalvaScheda6')" >

	



<!-- widget bSalvaScheda6 -->
<s:submit name="widg_bSalvaScheda6" id="widg_bSalvaScheda6" method="handleBSalvaScheda6_CLICKED"
	key="cpGestLibScheda6.bSalvaScheda6.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda6','bSalvaScheda6')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpFunGest --></div>

			
	
	<div id="p_cpNavGest" class="commandPanelBlock"><!-- startFragment:p_cpNavGest -->
	
	
<div class="commandPanel navigation" id="cpNavGest">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpGestLibScheda6','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpGestLibScheda6.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpGestLibScheda6','btIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpNavGest --></div>

	

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
