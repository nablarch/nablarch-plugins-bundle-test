package please.change.me.tutorial.ss99ZZ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nablarch.core.db.support.DbAccessSupport;
import nablarch.core.message.ApplicationException;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.interceptor.OnError;

/**
 * リストビルダーの性能試験用画面。
 * 
 * @author Iwauo Tajima
 * @since  1.2
 */
public class W99ZZ71Action extends DbAccessSupport {
    /**
     * 登録画面に遷移する。
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */    
    public HttpResponse doRW99ZZ7101(HttpRequest req, ExecutionContext ctx) {
        setUpViewData(ctx);
        return new HttpResponse("servlet:///ss99ZZ/W99ZZ7101.jsp");
    }
    
    /**
     * 登録内容を精査し、問題が無ければ確認画面に遷移する。
     * 登録内容に不備があった場合は確認画面に戻る。
     * @param req リクエストコンテキスト
     * @param ctx HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    @OnError(type = ApplicationException.class, path = "forward://RW99ZZ7101")
    public HttpResponse doRW99ZZ7102(HttpRequest req, ExecutionContext ctx) {
        validate(req);
        setUpViewData(ctx);
        return new HttpResponse("/ss99ZZ/W99ZZ7102.jsp");
    }
    
    /**
     * 登録内容を精査し、問題が無ければ登録処理を実行する。(ダミー)
     * 登録内容に不備があった場合は確認画面に戻る。
     * 
     * @param req リクエストコンテキスト
     * @param ctx HTTPリクエストの処理に関連するサーバ側の情報
     * @return HTTPレスポンス
     */
    @OnError(type = ApplicationException.class, path = "forward://RW99ZZ7101")
    public HttpResponse doRW99ZZ7103(HttpRequest req, ExecutionContext ctx) {
        validate(req);
        setUpViewData(ctx);

        return new HttpResponse("/ss99ZZ/W99ZZ7103.jsp");
    }
    
    /**
     * 表示に必要なグループの情報、認可単位の情報をリクエストスコープに格納する。
     * 
     * @param ctx HTTPリクエストの処理に関連するサーバ側の情報
     */
    @SuppressWarnings({ "rawtypes", "unchecked", "serial" })
    private void setUpViewData(ExecutionContext ctx) {
        ctx.setRequestScopedVar("allPermissionUnit", new Map[] {
            new HashMap() {
                {
                    put("permissionUnitName", "ユーザ一覧照会");
                    put("permissionUnitId",   "0000000001");
                }
            },
            new HashMap() {
                {
                    put("permissionUnitName", "テスト用");
                    put("permissionUnitId",   "0000000002");
                }
            },
            new HashMap() {
                {
                    put("permissionUnitName", "ユーザ情報登録");
                    put("permissionUnitId",   "0000000003");
                }
            },
        });
        ctx.setRequestScopedVar("allGroup", new ArrayList<Map>() {
            {
                for (int i = 0; i < 100; i++) {
                    final String ind = String.valueOf(i);
                    add(new HashMap() {
                        {
                            put("ugroupName", "テスト用" + ind );
                            put("ugroupId",   "000000000" + ind);
                        }
                    });
                }
            }
        });
    }
    
    /**
     * 入力データの精査と生成を行う。<br>
     * <br>
     * 精査エラーの場合はApplicationExceptionを送出する。
     * 
     * @param req リクエスト
     * @return 精査済みの入力データから生成したフォーム
     */
    private W99ZZ71Form validate(HttpRequest req) {
        ValidationContext<W99ZZ71Form>
        context = ValidationUtil.validateAndConvertRequest(
            "formdata", W99ZZ71Form.class, req, "registerUser"
        );
        context.abortIfInvalid();

        W99ZZ71Form form = context.createObject();
        return form;
    }
}
