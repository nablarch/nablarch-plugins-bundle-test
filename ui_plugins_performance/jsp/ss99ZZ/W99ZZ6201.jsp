<%@ taglib prefix="n" uri="http://tis.co.jp/nablarch" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="box" tagdir="/WEB-INF/tags/widget/box" %>
<%@ taglib prefix="field" tagdir="/WEB-INF/tags/widget/field" %>
<%@ taglib prefix="button" tagdir="/WEB-INF/tags/widget/button" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<t:page_template
    title="開閉可能パネル連携テスト(入力画面)"
    confirmationPageTitle="開閉可能パネル連携テスト(確認画面)">
  <jsp:attribute name="contentHtml">

    <box:content>
      開閉可能パネルに含めて使用することが想定されるUI部品を列挙しています。<br>
      通常遷移とポップアップにおいて各UI部品が正常に機能していることを打鍵で確認してください。
      <ul>
        <li>パネルを開いた状態で入力値が正常に表示されること。</li>
        <li>パネルを開いた状態で入力値が正常に送信されること。</li>
        <li>パネルを閉じた状態で入力値が正常に表示されること。</li>
        <li>パネルを閉じた状態で入力値が正常に送信されること。</li>
      </ul>
    </box:content>

    <n:form windowScopePrefixes="W99ZZ62">

      <n:plainHidden name="W99ZZ62.panelStatus" />

      <n:forInputPage>
        <p class="attention">*は必ず入力してください。</p>
      </n:forInputPage>

      <field:block title="リルトビルダ" collapsible="true" value="list">
        <field:listbuilder
            title="アイテム"
            required="true"
            name="W99ZZ62.lbValues"
            id="lb_from"
            size="10"
            listName="lbLabelValues"
            elementLabelProperty="label"
            elementValueProperty="value"
            elementLabelPattern="$LABEL$">
        </field:listbuilder>
      </field:block>

      <field:block title="日付入力" collapsible="true" value="date">
        <field:calendar
            title="日付"
            id="ciValue"
            name="W99ZZ62.ciValue"
            format="yyyy/MM/dd"
            hint="(入力例 ： 2012/05/12 )">
        </field:calendar>
      </field:block>

      <field:block title="自動集計" collapsible="true" value="autsum">
        <field:text title="+値1" name="W99ZZ62.asValue1" maxlength="20" cssClass="AutoSum_asTotal">
        </field:text>
        <field:text title="+値2" maxlength="20" name="W99ZZ62.asValue2" cssClass="AutoSum_asTotal">
        </field:text>
        <field:text title="-値3" maxlength="20" name="W99ZZ62.asValue3" cssClass="AutoSum_asTotal_negative">
        </field:text>
        <field:label title="合計" name="asTotal" cssClass="nablarch_AutoSum -target asTotal" valueFormat="decimal{#,###.##}">
        </field:label>
      </field:block>

      <field:block title="プレースホルダ" collapsible="true" value="ph">
        <field:text title="テキスト" name="W99ZZ62.phValue" example="10文字まで入力できます">
        </field:text>
      </field:block>

      <field:block title="変更不可項目" collapsible="true" name="readonly">
        <field:text title="テキスト" name="W99ZZ62.roValue" readonly="true">
        </field:text>
      </field:block>

      <button:block>
        <n:forInputPage>
          <button:check label="通常遷移" uri="/action/ss99ZZ/W99ZZ62Action/RW99ZZ6202">
          </button:check>
          <button:popup label="ポップアップ" uri="/action/ss99ZZ/W99ZZ62Action/RW99ZZ6202">
          </button:popup>
        </n:forInputPage>
        <n:forConfirmationPage>
          <button:cancel uri="/action/ss99ZZ/W99ZZ62Action/RW99ZZ6204">
          </button:cancel>
          <button:confirm uri="/action/ss99ZZ/W99ZZ62Action/RW99ZZ6203">
          </button:confirm>
        </n:forConfirmationPage>
      </button:block>
    </n:form>
  </jsp:attribute>
</t:page_template>
