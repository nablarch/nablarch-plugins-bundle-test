package please.change.me.tutorial.ss99ZZ;

import java.math.BigDecimal;

import please.change.me.tutorial.ss99ZZ.W99ZZ73Form.ValueHolder;

import nablarch.core.message.ApplicationException;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * 自動集計性能テスト用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ73Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7301(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("W99ZZ73", createInitialForm());
        return new HttpResponse("/ss99ZZ/W99ZZ7301.jsp");
    }

    /**
     * 入力画面の確認処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ7301.jsp")
    public HttpResponse doRW99ZZ7302(HttpRequest req, ExecutionContext ctx) {
        W99ZZ73Form form = validateForRegister(req);
        ctx.setRequestScopedVar("asTotal", form.getAsTotal());
        return new HttpResponse("/ss99ZZ/W99ZZ7302.jsp");
    }

    /**
     * 確認画面のキャンセル処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7304(HttpRequest req, ExecutionContext ctx) {
        return new HttpResponse("/ss99ZZ/W99ZZ7301.jsp");
    }

    /**
     * 初期値を設定したフォームを作成する。
     * @return 初期値を設定したフォーム
     */
    private W99ZZ73Form createInitialForm() {
        W99ZZ73Form form = new W99ZZ73Form();
        ValueHolder[] asValues = new ValueHolder[100];
        for (int i = 0; i < asValues.length; i++) {
            asValues[i] = new ValueHolder();
            asValues[i].setValue(BigDecimal.valueOf(i + 1));
        }
        form.setAsValues(asValues);
        return form;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * 
     * @param req HTTPリクエストオブジェクト
     * @return Bean
     */
    private W99ZZ73Form validateForRegister(HttpRequest req) {
        ValidationContext<W99ZZ73Form> vc
            = ValidationUtil.validateAndConvertRequest("W99ZZ73", W99ZZ73Form.class, req, "register");

        vc.abortIfInvalid();

        return vc.createObject();
    }
}
