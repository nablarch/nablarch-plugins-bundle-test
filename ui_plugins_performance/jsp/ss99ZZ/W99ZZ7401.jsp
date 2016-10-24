<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template title="プレースホルダ性能テスト(入力画面)" confirmationPageTitle="プレースホルダ性能テスト(確認画面)">
  <jsp:attribute name="contentHtml">
    <p>
      プレースホルダの性能テスト。<br>
      通常遷移とポップアップにおいてユーザがストレスなく使用できることを打鍵で確認してください。
    </p>

    <n:form windowScopePrefixes="W99ZZ74">

      <n:plainHidden name="W99ZZ74.panelStatus" />

      <field:hint>*は必ず入力してください</field:hint>

      <field:block title="プレースホルダ">
        <c:forEach begin="0" end="99" step="1" varStatus="status">
          <n:set var="number" value="${status.count}" />
          <field:text name="W99ZZ74.phValues[${status.index}].value" title="テキスト(${number})" example="10文字まで入力できます。" maxlength="10"/>
        </c:forEach>
      </field:block>

      <button:block>
        <n:forInputPage>
          <button:check uri="/action/ss99ZZ/W99ZZ74Action/RW99ZZ7402" label="通常遷移">
          </button:check>
          <button:popup
              uri="/action/ss99ZZ/W99ZZ74Action/RW99ZZ7402"
              popupWindowName="placeholder"
              label="ポップアップ">
          </button:popup>
        </n:forInputPage>

        <n:forConfirmationPage>
          <button:cancel uri="/action/ss99ZZ/W99ZZ74Action/RW99ZZ7404">
          </button:cancel>
          <button:confirm uri="/action/ss99ZZ/W99ZZ74Action/RW99ZZ7403">
          </button:confirm>
        </n:forConfirmationPage>
      </button:block>

    </n:form>
  </jsp:attribute>
</t:page_template>

