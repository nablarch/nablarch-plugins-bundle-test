package please.change.me.tutorial.ss99ZZ;

import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;

/**
 * UI部打鍵テストトップメニュー用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ60Action {

    /**
     * UI部品打鍵テストトップメニュー画面表示。
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ6001(HttpRequest req, ExecutionContext ctx) {
        return new HttpResponse("/ss99ZZ/W99ZZ6001.jsp");
    }
}
