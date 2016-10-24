package please.change.me.tutorial.ss99ZZ;

import java.util.Map;

import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationTarget;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.validator.Length;

/**
 * 変更不可項目性能テスト用のアクションで使用するフォーム。
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ75Form {

    private ValueHolder[] roValues;

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ75Form() {
    }

    /**
     * コンストラクタ。
     * @param data 初期化データ
     */
    public W99ZZ75Form(Map<String, ?> data) {
        roValues = (ValueHolder[]) data.get("roValues");
    }

    /**
     * プレースホルダ用の値を取得する。
     * @return プレースホルダ用の値
     */
    public ValueHolder[] getRoValues() {
        return roValues;
    }

    /**
     * プレースホルダ用の値を設定する。
     * @param roValues プレースホルダ用の値
     */
    @ValidationTarget(size = 100)
    public void setRoValues(ValueHolder[] roValues) {
        this.roValues = roValues;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("register")
    public static void validateForRegister(ValidationContext<W99ZZ75Form> context) {
        ValidationUtil.validateWithout(context, new String[0]);
    }

    /**
     * 値を保持するホルダ。
     * @author Kiyohito Itoh
     * @since 1.2
     */
    public static final class ValueHolder {

        private String value;

        /**
         * デフォルトコンストラクタ。
         */
        public ValueHolder() {
        }

        /**
         * コンストラクタ。
         * @param data 初期化データ
         */
        public ValueHolder(Map<String, ?> data) {
            value = (String) data.get("value");
        }

        /**
         * 値を取得する。
         * @return 値
         */
        public String getValue() {
            return value;
        }

        /**
         * 値を設定する。
         * @param value 値
         */
        @Length(max = 10)
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * 登録処理を行うために必要な情報が入力されたことを精査する。
         * @param context 精査処理コンテキスト
         */
        @ValidateFor("register")
        public static void validateForRegister(ValidationContext<ValueHolder> context) {
            ValidationUtil.validateWithout(context, new String[0]);
        }
    }
}
