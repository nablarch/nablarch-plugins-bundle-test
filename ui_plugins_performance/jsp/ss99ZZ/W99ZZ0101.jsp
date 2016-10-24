<%@taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/widget/link" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template title="トップメニュー">
  <jsp:attribute name="contentHtml">
    <n:form>
      <ul>
        <li><link:submit label="UI部品打鍵テスト" uri="/action/ss99ZZ/W99ZZ60Action/RW99ZZ6001"></link:submit></li>
      </ul>
    </n:form>
  </jsp:attribute>
</t:page_template>
