package please.change.me.tutorial.ss99ZZ;

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
 * Nablarchカスタムイベント連携テスト用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ61Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6101(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("lbLabelValues", createSelectionDataForListBuilder());
        ctx.setRequestScopedVar("W99ZZ61", createInitialForm());
        return new HttpResponse("/ss99ZZ/W99ZZ6101.jsp");
    }

    /**
     * 入力画面の確認処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ6101.jsp")
    public HttpResponse doRW99ZZ6102(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("lbLabelValues", createSelectionDataForListBuilder());
        validateForRegister(req);
        return new HttpResponse("/ss99ZZ/W99ZZ6102.jsp");
    }

    /**
     * 確認画面のキャンセル処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6104(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("lbLabelValues", createSelectionDataForListBuilder());
        return new HttpResponse("/ss99ZZ/W99ZZ6101.jsp");
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
    private W99ZZ61Form createInitialForm() {
        W99ZZ61Form form = new W99ZZ61Form();
        form.setLbValues(new String[] {"0000000002", "0000000004", "0000000006", "0000000008"});
        form.setRoValue("変更不可データ");
        return form;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * 
     * @param req HTTPリクエストオブジェクト
     * @return Bean
     */
    private W99ZZ61Form validateForRegister(HttpRequest req) {
        ValidationContext<W99ZZ61Form> vc
            = ValidationUtil.validateAndConvertRequest("W99ZZ61", W99ZZ61Form.class, req, "register");

        vc.abortIfInvalid();

        return vc.createObject();
    }
}
