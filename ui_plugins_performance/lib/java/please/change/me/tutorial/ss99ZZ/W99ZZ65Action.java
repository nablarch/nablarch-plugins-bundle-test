package please.change.me.tutorial.ss99ZZ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nablarch.core.message.ApplicationException;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * ダイアログ連携テスト用のアクション。
 *
 * @author tani takanori
 * @since 1.4
 */
public class W99ZZ65Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6501(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("accountTypeList", getAccountTypeList());
        ctx.setRequestScopedVar("W99ZZ65", createInitialForm());
        return new HttpResponse("/ss99ZZ/W99ZZ6501.jsp");
    }

    /**
     * 入力画面の確認表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ6501.jsp")
    public HttpResponse doRW99ZZ6502(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("accountTypeList", getAccountTypeList());
        ValidationContext<W99ZZ65Form> vc = ValidationUtil.validateAndConvertRequest("W99ZZ65", W99ZZ65Form.class, req, "confirm");
        if (!vc.isValid()) {
            throw new ApplicationException(vc.getMessages());
        }
        return new HttpResponse("/ss99ZZ/W99ZZ6502.jsp");
    }

    /**
     * 入力画面ヘ戻る処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6503(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("accountTypeList", getAccountTypeList());
        return new HttpResponse("/ss99ZZ/W99ZZ6501.jsp");
    }

    /**
     * 初期値を設定したフォームを作成する。
     * @return 初期値を設定したフォーム
     */
    private W99ZZ65Form createInitialForm() {
        W99ZZ65Form form = new W99ZZ65Form();
        return form;
    }

    /**
     * アカウント種別の一覧を取得する。
     *
     * @return アカウント種別の一覧
     */
    @SuppressWarnings("serial")
    private List<Map<String, String>> getAccountTypeList() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String data = "管理者|利用者|サポート";
        for (final String entry : data.split("\\|")) {
            Map<String, String> row = new HashMap<String, String>();
            row.put("value", entry);
            list.add(row);
        }
        return list;
    }

}
