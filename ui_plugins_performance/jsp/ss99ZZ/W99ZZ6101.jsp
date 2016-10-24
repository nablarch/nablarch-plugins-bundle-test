<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template
    title="Nablarchカスタムイベント連携テスト(入力画面)"
    confirmationPageTitle="Nablarchカスタムイベント連携テスト(確認画面)">

  <jsp:attribute name="contentHtml">
    <p>
      Nablarchカスタムイベントを使用しているUI部品を列挙しています。<br>
      通常遷移とポップアップにおいて各UI部品が正常に機能していることを打鍵で確認してください。
    </p>
    <ul>
      <li>通常遷移ボタン &gt; キャンセルボタン後に入力値が正常に表示されること。</li>
      <li>ポップアップ後に元画面の入力値が正常に表示されること。</li>
    </ul>

    <n:form windowScopePrefixes="W99ZZ61">
      <field:block title="リストビルダ">
        <field:listbuilder
            title="アイテム"
            name="W99ZZ61.lbValues"
            id="lb_from"
            listName="lbLabelValues"
            elementLabelProperty="label"
            elementValueProperty="value"
            required="true">
        </field:listbuilder>
      </field:block>

      <field:block title="プレースフホルダ">
        <field:text
            title="テキスト"
            name="W99ZZ61.phValue"
            example="10文字まで入力できます。"
            maxlength="10"/>
      </field:block>

      <field:block title="変更不可項目">
        <field:text title="テキスト" name="W99ZZ61.roValue" cssClass="nablarch_readonly" />
      </field:block>

      <button:block>
        <n:forInputPage>
          <button:check
              uri="/action/ss99ZZ/W99ZZ61Action/RW99ZZ6102"
              label="通常遷移">
          </button:check>
          <button:popup
              uri="/action/ss99ZZ/W99ZZ61Action/RW99ZZ6102"
              popupWindowName="W99ZZ6101"
              label="ポップアップ">
          </button:popup>
        </n:forInputPage>
        <n:forConfirmationPage>
          <button:cancel
              uri="/action/ss99ZZ/W99ZZ61Action/RW99ZZ6104">
          </button:cancel>
          <button:confirm
              uri="/action/ss99ZZ/W99ZZ61Action/RW99ZZ6103">
          </button:confirm>
        </n:forConfirmationPage>
      </button:block>

    </n:form>

  </jsp:attribute>

</t:page_template>

