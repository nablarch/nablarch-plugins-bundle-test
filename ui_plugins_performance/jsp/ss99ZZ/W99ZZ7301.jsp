<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template title="自動集計性能テスト(入力画面)" confirmationPageTitle="自動集計性能テスト(確認画面)">
  <jsp:attribute name="contentHtml">

    <p>
      自動計算の性能テスト。<br>
      通常遷移とポップアップにおいてユーザがストレスなく使用できることを打鍵で確認してください。
    </p>

    <n:form windowScopePrefixes="W99ZZ73">

      <n:plainHidden name="W99ZZ73.panelStatus" />

      <field:hint>*は必ず入力してください</field:hint>

      <field:block title="自動集計">
        <c:forEach begin="0" end="99" step="1" varStatus="status">
          <n:set var="number" value="${status.count}" />
          <n:set var="isEven" value="${(number mod 2) == 0}" />
          <n:set var="expression" value="${isEven ? '-' : '+'}" />
          <n:set var="cssSufix" value="${isEven ? '_negative' : ''}" />

          <field:text title="${expression} 値（${number})" name="W99ZZ73.asValues[${status.index}].value"
              cssClass="AutoSum_asTotal${cssSufix}" maxlength="10" />

        </c:forEach>

        <field:text title="合計" name="asTotal" valueFormat="decimal{#,###.##}" cssClass="nablarch_AutoSum -target asTotal"/>
      </field:block>

      <button:block>
        <n:forInputPage>
          <button:check uri="/action/ss99ZZ/W99ZZ73Action/RW99ZZ7302" label="通常遷移">
          </button:check>
          <button:popup uri="/action/ss99ZZ/W99ZZ73Action/RW99ZZ7302" label="ポップアップ" popupWindowName="autosum">
          </button:popup>
        </n:forInputPage>

        <n:forConfirmationPage>
          <button:cancel uri="/action/ss99ZZ/W99ZZ73Action/RW99ZZ7304">
          </button:cancel>
          <button:confirm uri="/action/ss99ZZ/W99ZZ73Action/RW99ZZ7303">
          </button:confirm>
        </n:forConfirmationPage>
      </button:block>
    </n:form>
  </jsp:attribute>
</t:page_template>

