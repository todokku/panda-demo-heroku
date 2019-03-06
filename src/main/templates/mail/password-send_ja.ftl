パスワード再設定 - <${action.getText('site-name')}>
<p>${name?html}様</p>

<p>&lt;<@p.text name="site-name"/>&gt;をご利用いただき、ありがとうございます。</p>

<pre>
${name?html}様は下記アカウントのパスワード再設定を要請しました。
メールアドレス: ${name?html}
(要請時間: <@p.date value=assist.systemDate format="datetime"/>)

パスワードを再設定する場合は、以下のリンクをタップしてください。
<@p.url var="url" action="./reset" forceAddSchemeHostAndPort="true"><@p.param name="token" value=token/></@p.url>
<a href="${vars.url}">${vars.url}</a>
</pre>
<br>

<p>The <@p.text name="site-name"/> Team</p>
<br>

