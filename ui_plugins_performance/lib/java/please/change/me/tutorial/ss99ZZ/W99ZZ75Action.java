package please.change.me.tutorial.ss99ZZ;

import please.change.me.tutorial.ss99ZZ.W99ZZ75Form.ValueHolder;

import nablarch.core.message.ApplicationException;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * 変更不可項目性能テスト用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ75Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7501(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("W99ZZ75", createInitialForm());
        return new HttpResponse("/ss99ZZ/W99ZZ7501.jsp");
    }

    /**
     * 入力画面の確認処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ7501.jsp")
    public HttpResponse doRW99ZZ7502(HttpRequest req, ExecutionContext ctx) {
        validateForRegister(req);
        return new HttpResponse("/ss99ZZ/W99ZZ7502.jsp");
    }

    /**
     * 確認画面のキャンセル処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7504(HttpRequest req, ExecutionContext ctx) {
        return new HttpResponse("/ss99ZZ/W99ZZ7501.jsp");
    }

    /**
     * 初期値を設定したフォームを作成する。
     * @return 初期値を設定したフォーム
     */
    private W99ZZ75Form createInitialForm() {
        W99ZZ75Form form = new W99ZZ75Form();
        ValueHolder[] roValues = new ValueHolder[100];
        for (int i = 0; i < roValues.length; i++) {
            roValues[i] = new ValueHolder();
            roValues[i].setValue("テストテキスト" + (i + 1));
        }
        form.setRoValues(roValues);
        return form;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * 
     * @param req HTTPリクエストオブジェクト
     * @return Bean
     */
    private W99ZZ75Form validateForRegister(HttpRequest req) {
        ValidationContext<W99ZZ75Form> vc
            = ValidationUtil.validateAndConvertRequest("W99ZZ75", W99ZZ75Form.class, req, "register");
        vc.abortIfInvalid();

        return vc.createObject();
    }
}
