package please.change.me.tutorial.ss99ZZ;

import java.math.BigDecimal;
import java.util.Map;

import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationTarget;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.convertor.Digits;

/**
 * 自動集計性能テスト用のアクションで使用するフォーム。
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ73Form {

    private ValueHolder[] asValues;

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ73Form() {
        asValues = new ValueHolder[0];
    }

    /**
     * コンストラクタ。
     * @param data 初期化データ
     */
    public W99ZZ73Form(Map<String, ?> data) {
        asValues = (ValueHolder[]) data.get("asValues");
    }

    /**
     * 自動計算用の値を取得する。
     * @return 自動計算用の値
     */
    public ValueHolder[] getAsValues() {
        return asValues;
    }

    /**
     * 自動計算用の値を設定する。
     * @param asValues 自動計算用の値
     */
    @ValidationTarget(size = 100)
    public void setAsValues(ValueHolder[] asValues) {
        this.asValues = asValues;
    }

    /**
     * 自動計算用の合計を取得する。
     * @return 自動計算用の合計
     */
    public BigDecimal getAsTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < asValues.length; i++) {
            BigDecimal value = nullToZero(asValues[i].getValue());
            int num = i + 1;
            if (num % 2 == 0) {
                total = total.subtract(value);
            } else {
                total = total.add(value);
            }
        }
        return total;
    }

    /**
     * nullの場合0にする。
     * @param value 値
     * @return nullの場合は0
     */
    private static BigDecimal nullToZero(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("register")
    public static void validateForRegister(ValidationContext<W99ZZ73Form> context) {
        ValidationUtil.validateWithout(context, new String[0]);
    }

    /**
     * 値を保持するホルダ。
     * @author Kiyohito Itoh
     * @since 1.2
     */
    public static final class ValueHolder {

        private BigDecimal value;

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
            value = (BigDecimal) data.get("value");
        }

        /**
         * 値を取得する。
         * @return 値
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * 値を設定する。
         * @param value 値
         */
        @Digits(integer = 10, fraction = 2)
        public void setValue(BigDecimal value) {
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
