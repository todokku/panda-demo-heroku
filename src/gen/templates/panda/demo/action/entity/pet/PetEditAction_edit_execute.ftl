<html>
<head>
	<title><@p.text name="title-edit"><@p.param name="title" value="#(title)"/></@p.text></title>
</head>
<body>

<div class="p-section">
	<div class="p-header">
		<ol class="breadcrumb">
			<li><@p.i icon="icon"/> <@p.text name="title"/></li>
			<li><@p.text name="step-edit"/></li>
			<li class="active"><@p.text name="step-edit-success"/></li>
		</ol>
	</div>
<#assign _well = a.getText("well-edit-success", "")/>
<#if _well?has_content>
	<div class="p-well">${_well}</div>
</#if>


	<div class="p-toolbar-wrap"><ul class="p-toolbar">
<#if r?? && a.canAccessData("./print", r)><li><@p.a action="./print" icon="icon-print" label="#(btn-print)" target="_blank"><@p.param name="id" value="%{r.id}"/></@p.a>
</li></#if><#if r?? && a.canAccessData("./print", r)><li><@p.a action="./print?__redir=/pdf&__query=url" icon="icon-pdf" label="#(btn-pdf)" target="_blank"><@p.param name="id" value="%{r.id}"/></@p.a>
</li></#if><#if a.canAccess("./add")><li><@p.a action="./add" icon="icon-new" label="#(btn-new)"/>
</li></#if><#if a.canAccess("./list")><li><@p.a action="./list" icon="icon-list" label="#(btn-list)"/>
</li></#if>	</ul><div class="clearfix"></div></div>

	<#include "/action-alert.ftl"/>

<#if r??>
	<@p.form cssClass="p-sform" id="pet" focusme="true" method="post" theme="bs3h">
	<#if a.displayField("id")>
			<@p.viewfield
				key="id"
				value="%{r.id}"
			/>
	</#if>
	<#if a.displayField("name")>
			<@p.viewfield
				key="name"
				value="%{r.name}"
			/>
	</#if>
	<#if a.displayField("cid")>
			<@p.hidden
				name="cid"
				value="%{r.cid}"
			/>
	</#if>
	<#if a.displayField("cname")>
			<@p.viewfield
				key="cname"
				value="%{r.cname}"
			/>
	</#if>
	<#if a.displayField("gender")>
			<@p.viewfield
				key="gender"
				value="%{r.gender}"
				list="%{consts.petGenderMap}"
			/>
	</#if>
	<#if a.displayField("birthday")>
			<@p.viewfield
				key="birthday"
				value="%{r.birthday}"
				format="date"
			/>
	</#if>
	<#if a.displayField("origin")>
			<@p.viewfield
				key="origin"
				value="%{r.origin}"
				list="%{consts.petOriginMap}"
			/>
	</#if>
	<#if a.displayField("temper")>
			<@p.viewfield
				key="temper"
				value="%{r.temper}"
				list="%{consts.petTemperMap}"
			/>
	</#if>
	<#if a.displayField("habits")>
			<@p.viewfield
				key="habits"
				value="%{r.habits}"
				list="%{consts.petHabitMap}"
			/>
	</#if>
	<#if a.displayField("amount")>
			<@p.viewfield
				key="amount"
				value="%{r.amount}"
			/>
	</#if>
	<#if a.displayField("price")>
			<@p.viewfield
				key="price"
				value="%{r.price}"
			/>
	</#if>
	<#if a.displayField("shopName")>
			<@p.viewfield
				key="shopName"
				value="%{r.shopName}"
			/>
	</#if>
	<#if a.displayField("shopAddress")>
			<@p.viewfield
				key="shopAddress"
				value="%{r.shopAddress}"
			/>
	</#if>
	<#if a.displayField("shopTelephone")>
			<@p.viewfield
				key="shopTelephone"
				value="%{r.shopTelephone}"
			/>
	</#if>
	<#if a.displayField("shopCloseTime")>
			<@p.viewfield
				key="shopCloseTime"
				value="%{r.shopCloseTime}"
				format="time"
			/>
	</#if>
	<#if a.displayField("shopLink")>
			<@p.viewfield
				key="shopLink"
				value="%{r.shopLink}"
			/>
	</#if>
	<#if a.displayField("description")>
			<@p.viewfield
				key="description"
				value="%{r.description}"
				format="html"
			/>
	</#if>
	<#if a.displayField("imageFile")>
			<@p.uploader
				key="imageFile"
				value="%{r.imageFile}"
				readonly="true"
				accept="image/*"
				size="30"
				uploadAction="%{b.files_path + '/upload'}"
				uploadName="file"
				dnloadAction="%{b.files_path + '/download'}"
				dnloadName="file"
				defaultAction="/petimage/pimage"
				defaultParams="!{'pid': '%{r.id}'}"
				defaultEnable="%{r.id != null}"
			/>
	</#if>
	<#if a.displayField("status")>
			<@p.viewfield
				key="status"
				value="%{r.status}"
				list="%{consts.dataStatusMap}"
			/>
	</#if>
	<#if a.displayField("updatedAt")>
			<@p.viewfield
				key="updatedAt"
				value="%{r.updatedAt}"
				format="datetime"
			/>
	</#if>
	<#if a.displayField("updatedBy")>
			<@p.hidden
				name="updatedBy"
				value="%{r.updatedBy}"
			/>
	</#if>
	<#if a.displayField("updatedByUser")>
			<@p.viewfield
				key="updatedByUser"
				value="%{r.updatedByUser}"
			/>
	</#if>
			<#assign _buttons_ = [] />
			<#if r?? && a.canAccessData('./edit', r)>
				<@p.url var="_u_" action="./edit" escapeAmp="false">
					<@p.param name="id" value="%{r.id}"/>
				</@p.url>
				<#assign _buttons_ = _buttons_ + [{
					"icon": "icon-edit",
					"text": "btn-edit",
					"onclick": "location.href='${vars._u_?js_string}'; return false;"
				}]/>
			</#if>
			<#if r?? && a.canAccessData('./copy', r)>
				<@p.url var="_u_" action="./copy" escapeAmp="false">
					<@p.param name="id" value="%{r.id}"/>
				</@p.url>
				<#assign _buttons_ = _buttons_ + [{
					"icon": "icon-copy",
					"text": "btn-copy",
					"onclick": "location.href='${vars._u_?js_string}'; return false;"
				}]/>
			</#if>
			<#if r?? && a.canAccessData('./delete', r)>
				<@p.url var="_u_" action="./delete" escapeAmp="false">
					<@p.param name="id" value="%{r.id}"/>
				</@p.url>
				<#assign _buttons_ = _buttons_ + [{
					"icon": "icon-delete",
					"text": "btn-delete",
					"onclick": "location.href='${vars._u_?js_string}'; return false;"
				}]/>
			</#if>
			<#if a.canAccess('./list')>
				<@p.url var="_u_" action="./list"/>
				<#assign _buttons_ = _buttons_ + [{
					"icon": "icon-list",
					"text": "btn-list",
					"onclick": "location.href='${vars._u_?js_string}'; return false;"
				}]/>
			</#if>
			<#include "/panda/mvc/view/form-buttons.ftl"/>
			<@form_buttons buttons=_buttons_/>
	</@p.form>
</#if>
</div>

</body>
</html>
