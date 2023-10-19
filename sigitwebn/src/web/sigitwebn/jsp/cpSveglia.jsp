<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/gestisci_azioni -->
<!-- pageId:cpSveglia -->

<s:form id="cpSveglia" action="cpSveglia" namespace="/base/gestisci_azioni" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpSveglia_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpSveglia','menu')" >

	


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

	
	

	
	
			
	
	<div id="p_fpImpostaSveglia" class="formPanelBlock"><!-- startFragment:p_fpImpostaSveglia -->
		
	
<h4 class="fpLabel"><s:text name="cpSveglia.fpImpostaSveglia.label" /></h4>
<div class="formPanel" id="fpImpostaSveglia">


	
	

	
	
			
	
	<div id="p_stdMsgSveglia" class="stdMessagePanelBlock"><!-- startFragment:p_stdMsgSveglia -->
	
	
<div class="stdMessagePanel" id="stdMsgSveglia">
	<customtag:stdMessagePanel id="stdMsgSveglia" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_stdMsgSveglia --></div>

			
	
	<div id="p_wpAzione" class="widgetsPanelBlock"><!-- startFragment:p_wpAzione -->
	
	
<h4 class="wpLabel">imposta sveglia </h4>
<div class="widgetsPanel" id="wpAzione">
	
	<customtag:widgetsPanel id="wpAzioneTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpSveglia','ptAttivia')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpSveglia.ptAttivia.label')}" labelFor="widg_ptAttivia" errorFor="appDatasveglia.identificativoExtended" labelId="ptAttiviaLbl"   >


<!-- widget ptAttivia -->
<s:property value="appDatasveglia.identificativoExtended" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpSveglia','cSvegliaAttuale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpSveglia.cSvegliaAttuale.label')}" labelFor="widg_cSvegliaAttuale" errorFor="appDatasveglia.dataSveglia" labelId="cSvegliaAttualeLbl"
	  fieldRequired="true">


<!-- widget cSvegliaAttuale -->
<s:textfield 
	
	
	name="appDatasveglia.dataSveglia" id="widg_cSvegliaAttuale"
	disabled="isWidgetDisabled('cpSveglia','cSvegliaAttuale')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpSveglia','taDes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpSveglia.taDes.label')}" labelFor="widg_taDes" errorFor="appDatasveglia.noteSveglia" labelId="taDesLbl"
	  fieldRequired="true">


<!-- widget taDes -->
<s:textarea 
	
	
	name="appDatasveglia.noteSveglia" id="widg_taDes"
	disabled="isWidgetDisabled('cpSveglia','taDes')"
	rows="2"
	cols="30"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAzione --></div>

			
	
	<div id="p_cpFun" class="commandPanelBlock"><!-- startFragment:p_cpFun -->
	
	
<div class="commandPanel functional" id="cpFun">

	
	
		
		
<s:if test="isWidgetVisible('cpSveglia','btSalva')" >

	



<!-- widget btSalva -->
<s:submit name="widg_btSalva" id="widg_btSalva" method="handleBtSalva_CLICKED"
	key="cpSveglia.btSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSveglia','btSalva')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpSveglia','btElimina')" >

	



<!-- widget btElimina -->
<s:submit name="widg_btElimina" id="widg_btElimina" method="handleBtElimina_CLICKED"
	key="cpSveglia.btElimina.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSveglia','btElimina')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpFun --></div>

			
	
	<div id="p_cpNav" class="commandPanelBlock"><!-- startFragment:p_cpNav -->
	
	
<div class="commandPanel navigation" id="cpNav">

	
	
		
		
<s:if test="isWidgetVisible('cpSveglia','btIndietro')" >

	



<!-- widget btIndietro -->
<s:submit name="widg_btIndietro" id="widg_btIndietro" method="handleBtIndietro_CLICKED"
	key="cpSveglia.btIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSveglia','btIndietro')" />

	


</s:if>

	




	
	
</div>

	<!-- endFragment:p_cpNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpImpostaSveglia --></div>

	

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
