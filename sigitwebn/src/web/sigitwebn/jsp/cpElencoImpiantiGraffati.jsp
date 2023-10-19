<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sigit/sigitwebn/presentation/sigitwebn/action/elenco_impianti_graffati/CpElencoImpiantiGraffatiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/elenco_impianti_graffati -->
<!-- pageId:cpElencoImpiantiGraffati -->

<s:form id="cpElencoImpiantiGraffati" action="cpElencoImpiantiGraffati" namespace="/base/elenco_impianti_graffati" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_fpUpUserInfo" class="formPanelBlock"><!-- startFragment:p_fpUpUserInfo -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpElencoImpiantiGraffati_udpTestalino.jsp"></s:include>

	



			
	
	<div id="p_menuPanel" class="menuPanelBlock"><!-- startFragment:p_menuPanel -->
	
	
<div class="menuPanel horizontal" id="menuPanel">

	
		
			
<s:if test="isWidgetVisible('cpElencoImpiantiGraffati','menu')" >

	


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

	
	

	
	
			
	
	
	<div class="tabSetPanelContent">
	<div id="p_tsGraffatura" class="tabSetPanelBlock"><!-- startFragment:p_tsGraffatura -->
	
	
<div class="tabSetPanel" id="tsGraffatura">
	<ul>
		<s:url id="cpElencoImpiantiGraffati_tsGraffatura_fpImpiantiGraffati_URL" action="cpElencoImpiantiGraffati" namespace="/base/elenco_impianti_graffati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpElencoImpiantiGraffati_tsGraffatura_fpImpiantiGraffati'}" />
		</s:url>
		<s:if test="%{#session.cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel == 'cpElencoImpiantiGraffati_tsGraffatura_fpImpiantiGraffati' || #session.cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel == null}">
			<li class="item-1 active"
			title="impianti Graffati"
			>
			<span class="activeItem"><s:text name="cpElencoImpiantiGraffati.fpImpiantiGraffati.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-1" title="impianti Graffati" ><s:a href="%{cpElencoImpiantiGraffati_tsGraffatura_fpImpiantiGraffati_URL}"><s:text name="cpElencoImpiantiGraffati.fpImpiantiGraffati.label" /></s:a></li>
		</s:else>
		<s:url id="cpElencoImpiantiGraffati_tsGraffatura_fpStoricoVariazione_URL" action="cpElencoImpiantiGraffati" namespace="/base/elenco_impianti_graffati" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpElencoImpiantiGraffati_tsGraffatura_fpStoricoVariazione'}" />
		</s:url>
		<s:if test="%{#session.cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel == 'cpElencoImpiantiGraffati_tsGraffatura_fpStoricoVariazione'}">
			<li class="item-2 active"
			title="Storico Variazioni"
			>
			<span class="activeItem"><s:text name="cpElencoImpiantiGraffati.fpStoricoVariazione.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-2" title="Storico Variazioni" ><s:a href="%{cpElencoImpiantiGraffati_tsGraffatura_fpStoricoVariazione_URL}"><s:text name="cpElencoImpiantiGraffati.fpStoricoVariazione.label" /></s:a></li>
		</s:else>
	</ul>
</div>


	
		

		
<s:if test="#session.cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel == 'cpElencoImpiantiGraffati_tsGraffatura_fpImpiantiGraffati' || #session.cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel == null">
	<s:include value="/jsp/tabs/cpElencoImpiantiGraffati_tsGraffatura_fpImpiantiGraffati.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpElencoImpiantiGraffati_tsGraffatura_selectedMultiPanel == 'cpElencoImpiantiGraffati_tsGraffatura_fpStoricoVariazione'">
	<s:include value="/jsp/tabs/cpElencoImpiantiGraffati_tsGraffatura_fpStoricoVariazione.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_tsGraffatura --></div>
	</div>

	

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
