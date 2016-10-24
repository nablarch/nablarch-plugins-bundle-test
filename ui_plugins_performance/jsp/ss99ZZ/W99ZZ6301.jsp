<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/widget/table" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ taglib prefix="column" tagdir="/WEB-INF/tags/widget/column" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template
    title="変更不可項目連携テスト(入力画面)"
    confirmationPageTitle="変更不可項目連携テスト(確認画面)">
<jsp:attribute name="contentHtml">

  <p>
    入力フィールドが変更不可項目になることが想定されるUI部品を列挙しています。<br>
    通常遷移とポップアップにおいて各UI部品が正常に機能していることを打鍵で確認してください。
  </p>
  <ul>
    <li>変更不可の状態で入力値が正常に表示されること。</li>
    <li>変更不可の状態で入力値が正常に送信されること。</li>
  </ul>

  <n:form windowScopePrefixes="W99ZZ63">

    <n:plainHidden name="W99ZZ63.panelStatus" />

    <field:block title="リストビルダ">

      <field:listbuilder
          title="アイテム"
          required="true"
          name="W99ZZ63.lbValues"
          readonly="true"
          id="lb_from"
          size="10"
          listName="lbLabelValues"
          elementLabelProperty="label"
          elementValueProperty="value"
          elementLabelPattern="$LABEL$">
      </field:listbuilder>

    </field:block>

    <field:block title="日付入力">
      <field:calendar
          title="日付"
          name="W99ZZ63.ciValue"
          example="2013/10/17"
          readonly="true"
          hint="(入力例：2012/05/12)">
      </field:calendar>
    </field:block>

    <table:treelist
        title="ツリーリスト"
        resultSetName="tlSearchResult"
        key="value"
        name="W99ZZ63.panelStatus"
        hierarchy="chars:6|2|2">
      <column:label
          key="value"
          title="リクエストID"
          tree_toggler="true">
      </column:label>
      <column:label
          key="label"
          title="リクエスト名"
          tree_toggler="true">
      </column:label>
      <column:checkbox
          key="value"
          title="選択"
          name="W99ZZ63.tlValues">
      </column:checkbox>
    </table:treelist>

    <field:block title="自動集計">
      <field:text title="値１(+)" name="W99ZZ63.asValue1" cssClass="AutoSum_asTotal" maxlength="20">
      </field:text>
      <field:text title="値２(+)" name="W99ZZ63.asValue2" maxlength="20" cssClass="AutoSum_asTotal" readonly="true">
      </field:text>
      <field:text title="値３(-)" name="W99ZZ63.asValue3" maxlength="20" cssClass="AutoSum_asTotal_negative">
      </field:text>
      <field:label title="合計" name="asTotal" valueFormat="decimal{#,###.##}" cssClass="nablarch_AutoSum -target asTotal">
      </field:label>
    </field:block>

    <field:block title="プレースホルダ">
      <field:text title="テキスト" name="W99ZZ63.phValue" readonly="true" example="10文字まで入力できます。">
      </field:text>
    </field:block>

    <button:block>
      <n:forInputPage>
        <button:check uri="/action/ss99ZZ/W99ZZ63Action/RW99ZZ6302">
        </button:check>
        <button:popup label="ポップアップ" uri="/action/ss99ZZ/W99ZZ63Action/RW99ZZ6302">
        </button:popup>
      </n:forInputPage>
      <n:forConfirmationPage>
        <button:cancel uri="/action/ss99ZZ/W99ZZ63Action/RW99ZZ6304">
        </button:cancel>
        <button:confirm uri="/action/ss99ZZ/W99ZZ63Action/RW99ZZ6303">
        </button:confirm>
      </n:forConfirmationPage>
    </button:block>

  </n:form>

</jsp:attribute>
</t:page_template>
