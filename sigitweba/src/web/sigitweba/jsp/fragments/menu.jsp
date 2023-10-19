<%@taglib prefix="s" uri="/struts-tags" %>

	
<div id="mainMenu">
	<h3>Menu di navigazione</h3>
	<ul>
		
<s:if test="isMenuVisible('menuHome')">
	<s:if test="isMenuEnabled('menuHome')">
		<s:url id="targetUrlMenuHome" action="goToMenuHomeFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('menuHome')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMenuHome}" id="menu_items_menuHome">
				<s:text name="menuHome.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="menuHome.label" /></li>
	</s:else>
	

</s:if>

		

		
<!-- STATIC LINKS -->

<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<s:set name="mddPortalCode" value="getPortalCode()" />	
<s:set name="staticLinksUrl" value="getStaticResource('/ris/utheme/{areaCode}/sigitweba/include/static_links.html')" />
<c:catch var="ex">
	<r:include url='${staticLinksUrl}' resourceProvider='${mddPortalCode}' />
</c:catch>
	</ul>
</div>


