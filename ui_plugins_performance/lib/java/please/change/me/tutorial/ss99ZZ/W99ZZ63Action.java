package please.change.me.tutorial.ss99ZZ;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nablarch.core.message.ApplicationException;
import nablarch.core.util.StringUtil;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * 変更不可項目連携テスト用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ63Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6301(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("lbLabelValues", createSelectionDataForListBuilder());
        ctx.setRequestScopedVar("tlSearchResult", createSelectionDataForTreeList());
        ctx.setRequestScopedVar("W99ZZ63", createInitialForm());
        return new HttpResponse("/ss99ZZ/W99ZZ6301.jsp");
    }

    /**
     * 入力画面の確認処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ6301.jsp")
    public HttpResponse doRW99ZZ6302(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("lbLabelValues", createSelectionDataForListBuilder());
        ctx.setRequestScopedVar("tlSearchResult", createSelectionDataForTreeList());
        W99ZZ63Form form = validateForRegister(req);
        ctx.setRequestScopedVar("asTotal", form.getAsTotal());
        return new HttpResponse("/ss99ZZ/W99ZZ6302.jsp");
    }

    /**
     * 確認画面のキャンセル処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6304(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("lbLabelValues", createSelectionDataForListBuilder());
        ctx.setRequestScopedVar("tlSearchResult", createSelectionDataForTreeList());
        return new HttpResponse("/ss99ZZ/W99ZZ6301.jsp");
    }

    /**
     * リストビルダ用の選択データを作成する。
     * @return リストビルダ用の選択データ
     */
    private List<Map<String, String>> createSelectionDataForListBuilder() {
        List<Map<String, String>> labelValues = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 10; i++) {
            Map<String, String> labelValue = new HashMap<String, String>();
            labelValue.put("label", "アイテム" + i);
            labelValue.put("value", StringUtil.lpad(String.valueOf(i), 10, '0'));
            labelValues.add(labelValue);
        }
        return labelValues;
    }

    /**
     * 初期値を設定したフォームを作成する。
     * @return 初期値を設定したフォーム
     */
    private W99ZZ63Form createInitialForm() {
        W99ZZ63Form form = new W99ZZ63Form();
        form.setLbValues(new String[] {"0000000002", "0000000004", "0000000006", "0000000008"});
        form.setCiValue("20121107");
        form.setTlValues(new String[] {"0000AA0001", "0000BB0002", "0000CC0001", "0000CC0003", "0000CC0005"});
        form.setAsValue1(BigDecimal.valueOf(100L));
        form.setAsValue2(BigDecimal.valueOf(50L));
        form.setAsValue3(BigDecimal.valueOf(30L));
        return form;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * 
     * @param req HTTPリクエストオブジェクト
     * @return Bean
     */
    private W99ZZ63Form validateForRegister(HttpRequest req) {
        ValidationContext<W99ZZ63Form> vc
            = ValidationUtil.validateAndConvertRequest("W99ZZ63", W99ZZ63Form.class, req, "register");

        vc.abortIfInvalid();

        return vc.createObject();
    }

    /**
     * ツリーリスト用の選択データを作成する。
     * @return ツリーリスト用の選択データ
     */
    @SuppressWarnings("serial")
    private List<Map<String, String>> createSelectionDataForTreeList() {
        return new ArrayList<Map<String, String>>() {
            {
                add(createSelectionItem("0000AA", "アイテムAA"));
                add(createSelectionItem("0000AA0001", "アイテムAA-0001"));
                add(createSelectionItem("0000BB", "アイテムBB"));
                add(createSelectionItem("0000BB0001", "アイテムBB-0001"));
                add(createSelectionItem("0000BB0002", "アイテムBB-0002"));
                add(createSelectionItem("0000BB0003", "アイテムBB-0003"));
                add(createSelectionItem("0000CC", "アイテムCC"));
                add(createSelectionItem("0000CC0001", "アイテムCC-0001"));
                add(createSelectionItem("0000CC0002", "アイテムCC-0002"));
                add(createSelectionItem("0000CC0003", "アイテムCC-0003"));
                add(createSelectionItem("0000CC0004", "アイテムCC-0004"));
                add(createSelectionItem("0000CC0005", "アイテムCC-0005"));
            }
        };
    }

    /**
     * ツリーリスト用の選択項目を作成する。
     * @param value 値
     * @param label ラベル
     * @return ツリーリスト用の選択項目
     */
    @SuppressWarnings("serial")
    private Map<String, String> createSelectionItem(final String value, final String label) {
        return new HashMap<String, String>() {
            {
                put("value", value);
                put("label", label);
            }
        };
    }
}
