<html>
<head>
	<title><@p.text name="title-list_popup"><@p.param name="title" value="#(title)"/></@p.text></title>
</head>
<body>

<div class="p-section">
	<div class="p-header">
		<ol class="breadcrumb">
			<li><@p.i icon="icon"/> <@p.text name="title"/></li>
			<li class="active"><@p.text name="step-list_popup"/></li>
		</ol>
	</div>
<#assign _well = a.getText("well-list_popup", "")/>
<#if _well?has_content>
	<div class="p-well">${_well}</div>
</#if>

	<#include "/action-alert.ftl"/>

	<#assign _columns_ = [{
			"name": "_number_",
			"type": "number",
			"header": a.getText("listview-th-number", ""),
			"fixed": true
		}, {
			"name": "id",
			"value": true,
			"header": a.getFieldLabel("id"),
			"display": a.displayField("id"),
			"filterable": a.filterField("id"),
			"filter": {
				"type": "number"
			},
			"hidden": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("id")
		}, {
			"name": "name",
			"value": true,
			"header": a.getFieldLabel("name"),
			"display": a.displayField("name"),
			"filterable": a.filterField("name"),
			"filter": {
				"fixed": true,
				"type": "string"
			},
			"hidden": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("name")
		}, {
			"name": "status",
			"value": true,
			"header": a.getFieldLabel("status"),
			"display": a.displayField("status"),
			"filterable": a.filterField("status"),
			"format": {
				"codemap": consts.dataStatusMap,
				"type": "code"
			},
			"filter": {
				"list": consts.dataStatusMap,
				"type": "radio"
			},
			"hidden": false,
			"sortable": true,
			"tooltip": a.getFieldTooltip("status")
		}] />


	<@p.listview id="petcategory_list_popup" action="./list.popup" 
		list=result columns=_columns_ cssColumn="status"
		headPager="true" singleSelect="true" toggleSelect="false"
		cssClass="p-lv-clickable" cssTable="table-hover table-striped"
		onrowclick="$.popup().callback(plv_getRowData(this));"
	/>
</div>

</body>
</html>
