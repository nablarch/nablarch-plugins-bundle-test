<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ taglib prefix="event" tagdir="/WEB-INF/tags/widget/event" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template
    title="ダイアログ連携テスト(入力画面)"
    confirmationPageTitle="ダイアログ連携テスト(確認画面)">

  <jsp:attribute name="contentHtml">

    <p>
      ダイアログ機能と他のUI部品を組み合わせを確認します。<br>
      ダイアログ表示において各UI部品が正常に機能していることを打鍵で確認してください。
    </p>
    <p class="palceholder_test">
      ブラウザがIE8,9の場合のみ、JavaScriptによりプレースホルダを制御します。<br>
      機能間の干渉で動作が不正にならないことを確認してください。
    </p>
    <p class="no_palceholder_test">
    利用ブラウザはplaceholderをサポートしています。
    </p>

    <n:form windowScopePrefixes="W99ZZ65">

      <field:hint>*は必ず入力してください</field:hint>

      <field:block title="日付入力">
        <event:listen event="input:text change">
          <event:confirm message="ok=>変更。cancel=>戻す。 "></event:confirm>
        </event:listen>
        <field:calendar
            title="日付"
            name="W99ZZ65.date1"
            id="ciValue1"
            required="true"
            hint="(入力例 ： 2012/05/12)">
        </field:calendar>

        <field:calendar
            title="日付"
            name="W99ZZ65.date2"
            id="ciValue2"
            required="true"
            hint="(入力例 ： 2012/05/12)">
        </field:calendar>
      </field:block>

      <field:block title="プレースホルダー">
        <event:listen event='input[name="W99ZZ65.placeholder"] change'>
          <event:confirm message="ok=>変更。cancel=>戻す。 "></event:confirm>
        </event:listen>
        <field:text
                 name="W99ZZ65.placeholder"
                 title="プレースホルダー"
                 example="これはプレースホルダーです。">
        </field:text>
      </field:block>

      <field:block title="自動集計">
        <event:listen event="input:text change">
          <event:confirm message="ok=>変更。cancel=>戻す。 "></event:confirm>
        </event:listen>

        <field:text title="+値1" name="W99ZZ65.autoSum1" cssClass="AutoSum_asTotal" maxlength="10" example="10桁まで入力可">
        </field:text>
        <field:text title="+値2" name="W99ZZ65.autoSum2" cssClass="AutoSum_asTotal" maxlength="10" example="10桁まで入力可">
        </field:text>
        <field:text title="-値3" name="W99ZZ65.autoSum3" cssClass="AutoSum_asTotal_negative" maxlength="10" example="10桁まで入力可">
        </field:text>
        <field:label title="合計" name="asTotal" cssClass="nablarch_AutoSum -target asTotal" valueFormat="decimal{#,###.##}">
        </field:label>
      </field:block>

      <field:block title="他のイベント監視系の機能">
        <event:listen event=":radio change">
          <event:confirm message="切替えます。">
          </event:confirm>
          <event:toggle_readonly
             target="#toggle_prop"
             condition=":is-value(管理者)">
          </event:toggle_readonly>
        </event:listen>
        <field:radio name="W99ZZ65.accountType"
                     elementValueProperty="value"
                     elementLabelProperty="value"
                     listName="accountTypeList"
                     title="ユーザー種別">
        </field:radio>
        <field:text name="W99ZZ65.accountName" title="ユーザー名称" id="toggle_prop"></field:text>


      </field:block>

      <button:block>
        <n:forInputPage>
          <button:check uri="/action/ss99ZZ/W99ZZ65Action/RW99ZZ6502">
          </button:check>
        </n:forInputPage>
        <n:forConfirmationPage>
          <button:cancel uri="/action/ss99ZZ/W99ZZ65Action/RW99ZZ6503">
          </button:cancel>
        </n:forConfirmationPage>
      </button:block>
    </n:form>
  </jsp:attribute>
  <jsp:attribute name="localJs">
    $(function() {
      var $placeholderTest = $('.palceholder_test')
        , $placeholderNoTest = $('.no_placeholder_test');
      hasPlaceholder() ? $placeholderNoTest.show()
                       : $placeholderTest.show();

      function hasPlaceholder() {
        return ("placeholder" in document.createElement("input"));
      }
    });
  </jsp:attribute>
  <jsp:attribute name="localCss">
    .palceholder_test {
      display: none;
    }
    .no_palceholder_test {
      display: none;
    }
  </jsp:attribute>
</t:page_template>
