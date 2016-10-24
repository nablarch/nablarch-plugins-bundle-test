package please.change.me.tutorial.ss99ZZ;

import java.util.Map;

import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationTarget;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.validator.Length;

/**
 * プレースホルダ性能テスト用のアクションで使用するフォーム。
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ74Form {

    private ValueHolder[] phValues;

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ74Form() {
    }

    /**
     * コンストラクタ。
     * @param data 初期化データ
     */
    public W99ZZ74Form(Map<String, ?> data) {
        phValues = (ValueHolder[]) data.get("phValues");
    }

    /**
     * プレースホルダ用の値を取得する。
     * @return プレースホルダ用の値
     */
    public ValueHolder[] getPhValues() {
        return phValues;
    }

    /**
     * プレースホルダ用の値を設定する。
     * @param phValues プレースホルダ用の値
     */
    @ValidationTarget(size = 100)
    public void setPhValues(ValueHolder[] phValues) {
        this.phValues = phValues;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("register")
    public static void validateForRegister(ValidationContext<W99ZZ74Form> context) {
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
