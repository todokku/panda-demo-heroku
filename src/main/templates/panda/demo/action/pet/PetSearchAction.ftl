<@p.head maxAge="0"/>
<html>
<head>
<title><#if params.k?has_content><@p.text name="lbl-search-result" escape="html"><@p.param name="key" value="%{p.k}"/></@p.text></#if></title>
</head>

<body>

<div class="p-section" id="a_search">
	<div class="p-header">
		<h3><@p.i icon="icon"/> <@p.text name="title"/></h3>
	</div>

	<form id="petsearch" action="${base}/petquery" method="GET" loadmask="false" role="search">
		<div class="input-group">
			<@p.textfield cssClass="form-control" name="key" maxlength="80" placeholder="#(placeholder-search)"/>
			<span class="input-group-btn">
				<@p.submit icon="search"/>
			</span>
		</div>
	</form>

	<#include "/action-alert.ftl"/>

<#if result?has_content>
	<#include "/panda/app/view/index-link.ftl"/>

	<#include "/panda/app/view/index-topbar.ftl"/>

	<div class="table-responsive petsearch">
	<table class="table">
	<tbody>
	<#list result as t>
		<tr>
			<th>${params.p.s + t_index + 1}</th>
			<th><img class='pi-icon' src='${base}/petimage/pimage?id=${t.id}'></th>
			<td>${t.name?html}
				| (${(consts.petGenderMap[t.gender])!""}) | <@p.date value=t.birthday format="date"/>
			</td>
		</tr>
	</#list>
	</tbody>
	</table>
	</div>

	<#include "/panda/app/view/index-bombar.ftl"/>
</#if>
</div>

</body>
</html>
