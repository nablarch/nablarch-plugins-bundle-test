package please.change.me.tutorial.ss99ZZ;

import nablarch.core.message.ApplicationException;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * プレースホルダ性能テスト用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ74Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7401(HttpRequest req, ExecutionContext ctx) {
        return new HttpResponse("/ss99ZZ/W99ZZ7401.jsp");
    }

    /**
     * 入力画面の確認処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ7401.jsp")
    public HttpResponse doRW99ZZ7402(HttpRequest req, ExecutionContext ctx) {
        validateForRegister(req);
        return new HttpResponse("/ss99ZZ/W99ZZ7402.jsp");
    }

    /**
     * 確認画面のキャンセル処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7404(HttpRequest req, ExecutionContext ctx) {
        return new HttpResponse("/ss99ZZ/W99ZZ7401.jsp");
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * 
     * @param req HTTPリクエストオブジェクト
     * @return Bean
     */
    private W99ZZ74Form validateForRegister(HttpRequest req) {
        ValidationContext<W99ZZ74Form> vc
            = ValidationUtil.validateAndConvertRequest("W99ZZ74", W99ZZ74Form.class, req, "register");
        vc.abortIfInvalid();

        return vc.createObject();
    }
}
