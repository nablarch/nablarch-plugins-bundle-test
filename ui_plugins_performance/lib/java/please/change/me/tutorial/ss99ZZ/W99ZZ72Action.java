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
 * ツリーリスト性能テスト用のアクション。
 * 
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ72Action {

    /**
     * 入力画面の初期表示処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7201(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("tlSearchResult", createSelectionDataForTreeList());
        return new HttpResponse("/ss99ZZ/W99ZZ7201.jsp");
    }

    /**
     * 入力画面の確認処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    @OnError(type = ApplicationException.class, path = "/ss99ZZ/W99ZZ7201.jsp")
    public HttpResponse doRW99ZZ7202(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("tlSearchResult", createSelectionDataForTreeList());
        validateForRegister(req);
        return new HttpResponse("/ss99ZZ/W99ZZ7202.jsp");
    }

    /**
     * 確認画面のキャンセル処理。
     *
     * @param req HTTPリクエストオブジェクト
     * @param ctx 実行コンテキストオブジェクト
     * @return HTTPレスポンスオブジェクト
     */
    public HttpResponse doRW99ZZ7204(HttpRequest req, ExecutionContext ctx) {
        ctx.setRequestScopedVar("tlSearchResult", createSelectionDataForTreeList());
        return new HttpResponse("/ss99ZZ/W99ZZ7201.jsp");
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * 
     * @param req HTTPリクエストオブジェクト
     * @return Bean
     */
    private W99ZZ72Form validateForRegister(HttpRequest req) {
        ValidationContext<W99ZZ72Form> vc
            = ValidationUtil.validateAndConvertRequest("W99ZZ72", W99ZZ72Form.class, req, "register");

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
                List<Map<String, String>> depth0 = new ArrayList<Map<String, String>>() {
                    {
                        add(createSelectionItem("", "unused", false));
                    }
                };
                List<Map<String, String>> depth1 = createSelectionNode(depth0, 2, 3, false);
                List<Map<String, String>> depth2 = createSelectionNode(depth1, 4, 3, false);
                List<Map<String, String>> depth3 = createSelectionNode(depth2, 6, 3, false);
                List<Map<String, String>> depth4 = createSelectionNode(depth3, 8, 3, false);
                List<Map<String, String>> depth5 = createSelectionNode(depth4, 10, 3, true);
                addAll(depth1);
                addAll(depth2);
                addAll(depth3);
                addAll(depth4);
                addAll(depth5);
            }
        };
    }

    /**
     * ツリーリスト用の選択ノードを作成する。
     * @param parentNodes 親ノード
     * @param valueLength 値の長さ
     * @param dataSize 選択ノードに含める子のサイズ
     * @param isLeaf 子がリーフの場合はtrue
     * @return ツリーリスト用の選択ノード
     */
    @SuppressWarnings("serial")
    private List<Map<String, String>> createSelectionNode(
            final List<Map<String, String>> parentNodes, final int valueLength, final int dataSize, final Boolean isLeaf) {
        return new ArrayList<Map<String, String>>() {
            {
                for (Map<String, String> parentNode : parentNodes) {
                    for (int i = 0; i < dataSize; i++) {
                        String baseValue = parentNode.get("value");
                        int paddingLength = valueLength - baseValue.length();
                        String value = baseValue + StringUtil.lpad(String.valueOf(i), paddingLength, '0');
                        add(createSelectionItem(value, "アイテム" + value, isLeaf));
                    }
                }
            }
        };
    }

    /**
     * ツリーリスト用の選択項目を作成する。
     * @param value 値
     * @param label ラベル
     * @param isLeaf リーフの場合はtrue
     * @return ツリーリスト用の選択項目
     */
    @SuppressWarnings("serial")
    private Map<String, String> createSelectionItem(final String value, final String label, final Boolean isLeaf) {
        return new HashMap<String, String>() {
            {
                put("value", value);
                put("label", label);
                put("isReaf", isLeaf.toString());
            }
        };
    }
}
