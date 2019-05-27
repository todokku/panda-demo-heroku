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
			"sortable": true,
			"tooltip": a.getFieldTooltip("name")
		}, {
			"name": "cid",
			"value": true,
			"header": a.getFieldLabel("cid"),
			"display": a.displayField("cid"),
			"filterable": a.filterField("cid"),
			"filter": {
				"type": "number"
			},
			"hidden": true,
			"tooltip": a.getFieldTooltip("cid")
		}, {
			"name": "cname",
			"value": true,
			"header": a.getFieldLabel("cname"),
			"display": a.displayField("cname"),
			"filterable": a.filterField("cname"),
			"filter": {
				"type": "string"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("cname")
		}, {
			"name": "gender",
			"value": true,
			"header": a.getFieldLabel("gender"),
			"display": a.displayField("gender"),
			"filterable": a.filterField("gender"),
			"format": {
				"codemap": consts.petGenderMap,
				"type": "code"
			},
			"filter": {
				"list": consts.petGenderMap,
				"type": "checklist"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("gender")
		}, {
			"name": "birthday",
			"value": true,
			"header": a.getFieldLabel("birthday"),
			"display": a.displayField("birthday"),
			"filterable": a.filterField("birthday"),
			"format": {
				"type": "date"
			},
			"filter": {
				"type": "date"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("birthday")
		}, {
			"name": "origin",
			"value": true,
			"header": a.getFieldLabel("origin"),
			"display": a.displayField("origin"),
			"filterable": a.filterField("origin"),
			"format": {
				"codemap": consts.petOriginMap,
				"type": "code"
			},
			"filter": {
				"list": consts.petOriginMap,
				"type": "select"
			},
			"sortable": true,
			"tooltip": a.getFieldTooltip("origin")
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
			"hidden": true,
			"sortable": false,
			"tooltip": a.getFieldTooltip("status")
		}] />


	<@p.listview id="pet_list_popup" action="./list.popup" 
		list=result columns=_columns_ cssColumn="status"
		headPager="true" singleSelect="true" untoggleSelect="true"
		cssClass="p-lv-clickable" cssTable="table-hover table-striped"
		onrowclick="$.popup().callback(plv_getRowData(this));"
	/>
</div>

</body>
</html>
