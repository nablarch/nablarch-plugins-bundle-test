package please.change.me.tutorial.ss99ZZ;

import java.math.BigDecimal;

import nablarch.core.message.ApplicationException;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * プレースホルダ連携テスト用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ64Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6401(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("W99ZZ64", createInitialForm());
        return new HttpResponse("/ss99ZZ/W99ZZ6401.jsp");
    }

    /**
     * 入力画面の確認処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ6401.jsp")
    public HttpResponse doRW99ZZ6402(HttpRequest req, ExecutionContext ctx) {
        W99ZZ64Form form = validateForRegister(req);
        ctx.setRequestScopedVar("asTotal", form.getAsTotal());
        return new HttpResponse("/ss99ZZ/W99ZZ6402.jsp");
    }

    /**
     * 確認画面のキャンセル処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6404(HttpRequest req, ExecutionContext ctx) {
        return new HttpResponse("/ss99ZZ/W99ZZ6401.jsp");
    }

    /**
     * 初期値を設定したフォームを作成する。
     * @return 初期値を設定したフォーム
     */
    private W99ZZ64Form createInitialForm() {
        W99ZZ64Form form = new W99ZZ64Form();
        form.setCiValue2("20121107");
        form.setAsValue1(BigDecimal.valueOf(100L));
        form.setAsValue3(BigDecimal.valueOf(30L));
        return form;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * 
     * @param req HTTPリクエストオブジェクト
     * @return Bean
     */
    private W99ZZ64Form validateForRegister(HttpRequest req) {
        ValidationContext<W99ZZ64Form> vc
            = ValidationUtil.validateAndConvertRequest("W99ZZ64", W99ZZ64Form.class, req, "register");

        vc.abortIfInvalid();

        return vc.createObject();
    }
}
