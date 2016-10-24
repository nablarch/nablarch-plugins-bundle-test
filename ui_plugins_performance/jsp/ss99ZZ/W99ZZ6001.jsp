<%@taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="link" tagdir="/WEB-INF/tags/widget/link" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<t:page_template title="UI部品打鍵テスト">
  <jsp:attribute name="contentHtml">
    <n:form>
      <field:block title="UI部品連携テスト">
        <div class="grid-col-18">
        部品連携のテストを行うための画面
        <ul>
          <li>
            <link:submit label="Nablarchカスタムイベント連携テスト" uri="/action/ss99ZZ/W99ZZ61Action/RW99ZZ6101">
            </link:submit>
          </li>
          <li>
            <link:submit label="開閉可能パネル連携テスト" uri="/action/ss99ZZ/W99ZZ62Action/RW99ZZ6201">
            </link:submit>
          </li>
          <li>
            <link:submit label="変更不可項目連携テスト" uri="/action/ss99ZZ/W99ZZ63Action/RW99ZZ6301">
            </link:submit>
          </li>
          <li>
            <link:submit label="プレースホルダ連携テスト" uri="/action/ss99ZZ/W99ZZ64Action/RW99ZZ6401">
            </link:submit>
          </li>
          <li>
            <link:submit label="ダイアログ連携テスト" uri="/action/ss99ZZ/W99ZZ65Action/RW99ZZ6501">
            </link:submit>
          </li>
        </ul>
        </div>
      </field:block>

      <field:block title="性能テスト">
        <div class="grid-col-18">
        性能テストを行うための画面
        <ul>
          <li>
            <link:submit label="リストビルダー性能テスト" uri="/action/ss99ZZ/W99ZZ71Action/RW99ZZ7101">
            </link:submit>
          </li>
          <li>
            <link:submit label="ツリーリスト性能テスト" uri="/action/ss99ZZ/W99ZZ72Action/RW99ZZ7201">
            </link:submit>
          </li>
          <li>
            <link:submit label="自動集計性能テスト" uri="/action/ss99ZZ/W99ZZ73Action/RW99ZZ7301">
            </link:submit>
          </li>
          <li>
            <link:submit label="プレースホルダ性能テスト" uri="/action/ss99ZZ/W99ZZ74Action/RW99ZZ7401">
            </link:submit>
          </li>
          <li>
            <link:submit label="変更不可項目性能テスト" uri="/action/ss99ZZ/W99ZZ75Action/RW99ZZ7501">
            </link:submit>
          </li>
        </ul>
        </div>
      </field:block>
    </n:form>
  </jsp:attribute>
</t:page_template>
