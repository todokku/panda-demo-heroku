<@p.head maxAge="0"/>
<html>
<head>
<title><#if params.k?has_content><@p.text name="lbl-search-result" escape="html"><@p.param name="key" value="%{p.k}"/></@p.text></#if></title>
<style>
#petsearch .form-group {
	display: inline-block;
	margin-bottom: 10px;
	vertical-align: middle;
}
</style>
</head>
<body>

<div class="p-section" id="a_search">
	<div class="p-header">
		<h3><@p.i icon="icon"/> <@p.text name="title"/></h3>
	</div>

	<@p.form id="petsearch" action="/petquery" theme="bs3">
		<@p.datepicker
			name="ds"
			maxlength="10"
			size="10"
			placeholder="#(lbl-date)"
		/>
		 ~ 
		<@p.datepicker
			name="de"
			maxlength="10"
			size="10"
			/>
		
		<@p.textfield
			name="key"
			size="30"
			ricon="search"
			onrclick="$('#petsearch').submit()"
			placeholder="#(placeholder-search)"
			/>
		<@p.submit cssStyle="display: none;"/>
	</@p.form>

	<br>

	<#include "/action-alert.ftl"/>

<#if result?has_content>
	<#include "/panda/app/view/index-link.ftl"/>

<#if result?size gt 10>
	<#include "/panda/app/view/index-topbar.ftl"/>
</#if>

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
