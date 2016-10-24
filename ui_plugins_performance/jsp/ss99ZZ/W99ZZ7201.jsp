<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template title="ツリーリスト性能テスト(入力画面)" confirmationPageTitle="ツリーリスト性能テスト(確認画面)">
  <jsp:attribute name="contentHtml">

    <p>
      ツリーリストの性能テスト。<br>
      通常遷移とポップアップにおいてユーザがストレスなく使用できることを打鍵で確認してください。
    </p>

    <n:form windowScopePrefixes="W99ZZ72">

      <n:plainHidden name="W99ZZ72.panelStatus" />

      <div class="grid-row">
      <n:forInputPage>
        <p class="attention gird-col-15">*は必ず入力してください</p>
      </n:forInputPage>
      </div>

      <div class="title">
      <h2>ツリーリスト</h2>
      </div>

      <n:forInputPage>
        <n:table
            startPosition="1"
            resultSetName="tlSearchResult"
            resultSetCss="nablarch_TreeList
                        -name       W99ZZ72.panelStatus
                        -hierarchy  chars:2|2|2|2|2
                        -depth      5
                        -items      tr:has(td)
                        -navigation td:first
                      grid-col-18">
        <jsp:attribute name="headerRowFragment">
          <colgroup>
            <col style="width:10%" />
            <col style="width:25%" />
            <col style="width:5%" />
          </colgroup>
          <tr>
            <th>リクエストID</th>
            <th>リクエスト名</th>
            <th>閉局</th>
          </tr>
        </jsp:attribute>
        <jsp:attribute name="bodyRowFragment">
          <tr id="<n:write name='row.value' />" data-hierarchy="<n:write name='row.value' />">
            <c:if test="${row.isReaf == 'true'}">
              <td style="padding-left: 75px;">
                <n:write name="row.value" />
              </td>
              <td><n:write name="count"/>:<n:write name="row.label"/></td>
              <td class="check">
                <n:checkbox
                    name="W99ZZ72.tlValues"
                    value="${row.value}"
                    useOffValue="false"
                    />
              </td>
            </c:if>
            <c:if test="${row.isReaf == 'false'}">
              <td colspan="2">
                <n:write name="count"/>:<n:write name="row.label" />
              </td>
              <td>
                <a class="checkAll
                            -name  W99ZZ72.tlValues
                            -value <n:write name='row.value' />">
                  全選択
                </a>
                <span style="padding: 0 2px 0 2px">/</span>
                <a class="uncheckAll
                            -name  W99ZZ72.tlValues
                            -value <n:write name='row.value' />">
                  全解除
                </a>
              </td>
            </c:if>
          </tr>
        </jsp:attribute>
        </n:table>
      </n:forInputPage>

      <n:forConfirmationPage>
        <n:checkboxes
            name="W99ZZ72.tlValues"
            listName="tlSearchResult"
            elementLabelProperty="label"
            elementValueProperty="value" />
      </n:forConfirmationPage>


      <button:block>
        <n:forInputPage>
          <button:check uri="/action/ss99ZZ/W99ZZ72Action/RW99ZZ7202" label="通常遷移">
          </button:check>
          <button:popup uri="/action/ss99ZZ/W99ZZ72Action/RW99ZZ7202" label="ポップアップ" popupWindowName="treelist">
          </button:popup>
        </n:forInputPage>

        <n:forConfirmationPage>
          <button:cancel uri="/action/ss99ZZ/W99ZZ72Action/RW99ZZ7204">
          </button:cancel>
          <button:confirm uri="/action/ss99ZZ/W99ZZ72Action/RW99ZZ7203">
          </button:confirm>
        </n:forConfirmationPage>
      </button:block>

    </n:form>

  </jsp:attribute>
</t:page_template>

