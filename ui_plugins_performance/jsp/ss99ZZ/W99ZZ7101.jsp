<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template title="リストビルダーサンプル(登録画面)" confirmationPageTitle="リストビルダーサンプル(確認画面)">
  <jsp:attribute name="contentHtml">
    <n:form windowScopePrefixes="formdata">

      <field:hint>*は必ず入力してください</field:hint>

      <field:block title="権限情報">
        <field:listbuilder
            title="認可単位"
            name="formdata.permissionUnits"
            id="permissionUnit_from"
            listName="allPermissionUnit"
            elementLabelProperty="permissionUnitName"
            elementValueProperty="permissionUnitId"
            required="true">
        </field:listbuilder>
      </field:block>


      <field:listbuilder
          title="所属部署"
          name="formdata.groups"
          id="groups_from"
          listName="allGroup"
          elementLabelProperty="ugroupName"
          elementValueProperty="ugroupId"
          required="true">
      </field:listbuilder>

      <button:block>
        <n:forInputPage>
          <button:check uri  = "/action/ss99ZZ/W99ZZ71Action/RW99ZZ7102">
          </button:check>
        </n:forInputPage>

        <n:forConfirmationPage>
          <button:cancel uri  = "/action/ss99ZZ/W99ZZ71Action/RW99ZZ7101">
          </button:cancel>
          <button:confirm uri  = "/action/ss99ZZ/W99ZZ71Action/RW99ZZ7103">
          </button:confirm>
        </n:forConfirmationPage>
      </button:block>
    </n:form>
  </jsp:attribute>
</t:page_template>

