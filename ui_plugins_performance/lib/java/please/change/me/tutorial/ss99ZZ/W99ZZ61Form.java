package please.change.me.tutorial.ss99ZZ;

import java.util.Map;

import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;

/**
 * Nablarchカスタムイベント連携テスト用のアクションで使用するフォーム。
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ61Form {

    private String[] lbValues;
    private String phValue;
    private String roValue;

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ61Form() {
    }

    /**
     * コンストラクタ。
     * @param data 初期化データ
     */
    public W99ZZ61Form(Map<String, ?> data) {
        lbValues = (String[]) data.get("lbValues");
        phValue = (String) data.get("phValue");
        roValue = (String) data.get("roValue");
    }

    /**
     * リストビルダ用の値を取得する。
     * @return リストビルダ用の値
     */
    public String[] getLbValues() {
        return lbValues;
    }

    /**
     * リストビルダ用の値を設定する。
     * @param lbValues リストビルダ用の値
     */
    @Required
    @Length(max = 10)
    public void setLbValues(String[] lbValues) {
        this.lbValues = lbValues;
    }

    /**
     * プレースホルダ用の値を取得する。
     * @return プレースホルダ用の値
     */
    public String getPhValue() {
        return phValue;
    }

    /**
     * プレースホルダ用の値を設定する。
     * @param phValue プレースホルダ用の値
     */
    @Length(max = 10)
    public void setPhValue(String phValue) {
        this.phValue = phValue;
    }

    /**
     * 変更不可項目用の値を取得する。
     * @return 変更不可項目用の値
     */
    public String getRoValue() {
        return roValue;
    }

    /**
     * 変更不可項目用の値を設定する。
     * @param roValue 変更不可項目用の値
     */
    @Length(max = 10)
    public void setRoValue(String roValue) {
        this.roValue = roValue;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("register")
    public static void validateForRegister(ValidationContext<W99ZZ61Form> context) {
        ValidationUtil.validateWithout(context, new String[0]);
    }
}
