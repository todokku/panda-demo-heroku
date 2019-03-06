<html>
<head>
	<title><@p.text name="navi-sample-multifileupload"/></title>
</head>
<body>

<div class="p-section a_multifileupload">
	<div class="p-header">
		<h3><i class="fa fa-cloud-upload"></i> <@p.text name="navi-sample-multifileupload"/></h3>
	</div>

	<#include "/action-alert.ftl"/>

	<@p.form id="mfup" method="post" cssClass="p-eform" focusme="true" theme="bs3h">
		<@p.uploader
			key="files"
			accept="image/*,video/*,audio/*"
			size="30"
			multiple="true"
			uploadAction="%{b['files_path'] + '/uploads'}"
			uploadName="files"
			dnloadAction="%{b['files_path'] + '/download'}"
			dnloadName="file"
		/>
		<@p.div cssClass="p-buttons">
			<@p.submit icon="icon-submit" label="#(btn-submit)"/>
		</@p.div>
	</@p.form>
</div>

</body>
</html>