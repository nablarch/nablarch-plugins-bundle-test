<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template
    title="プレースホルダ連携テスト(入力画面)"
    confirmationPageTitle="プレースホルダ連携テスト(確認画面)">

  <jsp:attribute name="contentHtml">

    <p>
      プレースホルダが表示されることが想定されるUI部品を列挙しています。<br>
      通常遷移とポップアップにおいて各UI部品が正常に機能していることを打鍵で確認してください。
    </p>
    <p>
      ブラウザがIEの場合のみ、JavaScriptによりプレースホルダを制御します。<br>
      ブラウザがIE以外の場合は、ブラウザがネイティブで提供するプレースホルダ機能が動作します。
    </p>
    <ul>
      <li>プレースホルダが表示された状態で各UI部品が正常に動作すること。</li>
      <li>プレースホルダが表示されない状態で各UI部品が正常に動作すること。</li>
    </ul>

    <n:form windowScopePrefixes="W99ZZ64">

      <n:plainHidden name="W99ZZ64.panelStatus" />

      <field:hint>*は必ず入力してください</field:hint>

      <field:block title="日付入力">
        <field:calendar
            title="日付"
            name="W99ZZ64.ciValue1"
            id="ciValue1"
            required="true"
            hint="(入力例 ： 2012/05/12)">
        </field:calendar>

        <field:calendar
            title="日付"
            name="W99ZZ64.ciValue2"
            id="ciValue2"
            required="true"
            hint="(入力例 ： 2012/05/12)">
        </field:calendar>
      </field:block>

      <field:block title="自動集計">
        <field:text title="+値1" name="W99ZZ64.asValue1" cssClass="AutoSum_asTotal" maxlength="10" example="10桁まで入力可">
        </field:text>
        <field:text title="+値2" name="W99ZZ64.asValue2" cssClass="AutoSum_asTotal" maxlength="10" example="10桁まで入力可">
        </field:text>
        <field:text title="-値3" name="W99ZZ64.asValue3" cssClass="AutoSum_asTotal_negative" maxlength="10" example="10桁まで入力可">
        </field:text>
        <field:label title="合計" name="asTotal" cssClass="nablarch_AutoSum -target asTotal" valueFormat="decimal{#,###.##}">
        </field:label>
      </field:block>

      <button:block>
        <n:forInputPage>
          <button:check uri="/action/ss99ZZ/W99ZZ64Action/RW99ZZ6402" label="通常遷移">
          </button:check>
          <button:popup
              uri="/action/ss99ZZ/W99ZZ64Action/RW99ZZ6402"
              popupWindowName="RW99ZZ6402"
              label="ポップアップ">
          </button:popup>
        </n:forInputPage>
        <n:forConfirmationPage>
          <button:cancel uri="/action/ss99ZZ/W99ZZ64Action/RW99ZZ6404">
          </button:cancel>
          <button:confirm uri="/action/ss99ZZ/W99ZZ64Action/RW99ZZ6403">
          </button:confirm>
        </n:forConfirmationPage>
      </button:block>
    </n:form>
  </jsp:attribute>
</t:page_template>
