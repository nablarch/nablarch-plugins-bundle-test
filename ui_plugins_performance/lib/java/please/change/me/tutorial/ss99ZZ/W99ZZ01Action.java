package please.change.me.tutorial.ss99ZZ;

import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;

/**
 * サンプル集メニュー画面のアクションクラス。
 * 
 * @author Naho Hiraoka
 * @since 1.1
 */
public class W99ZZ01Action {

    /**
     * サンプル集メニュー画面を表示する。
     * 
     * @param request リクエスト
     * @param context リクエストコンテキスト
     * @return HttpResponse HTTPレスポンス
     */
    public HttpResponse doRW99ZZ0101(HttpRequest request,
            ExecutionContext context) {
        return new HttpResponse("/ss99ZZ/W99ZZ0101.jsp");
    }
}
