package please.change.me.tutorial.ss99ZZ;

import java.math.BigDecimal;
import java.util.Map;

import nablarch.common.date.YYYYMMDD;
import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.convertor.Digits;

/**
 * プレースホルダ連携テスト用のアクションで使用するフォーム。
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ64Form {

    private String ciValue1;
    private String ciValue2;
    private BigDecimal asValue1;
    private BigDecimal asValue2;
    private BigDecimal asValue3;

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ64Form() {
    }

    /**
     * コンストラクタ。
     * @param data 初期化データ
     */
    public W99ZZ64Form(Map<String, ?> data) {
        ciValue1 = (String) data.get("ciValue1");
        ciValue2 = (String) data.get("ciValue2");
        asValue1 = (BigDecimal) data.get("asValue1");
        asValue2 = (BigDecimal) data.get("asValue2");
        asValue3 = (BigDecimal) data.get("asValue3");
    }

    /**
     * 日付入力用の値1を取得する。
     * @return 日付入力用の値1
     */
    public String getCiValue1() {
        return ciValue1;
    }

    /**
     * 日付入力用の値1を設定する。
     * @param ciValue1 日付入力用の値1
     */
    @YYYYMMDD(allowFormat = "yyyy/MM/dd")
    public void setCiValue1(String ciValue1) {
        this.ciValue1 = ciValue1;
    }

    /**
     * 日付入力用の値2を取得する。
     * @return 日付入力用の値2
     */
    public String getCiValue2() {
        return ciValue2;
    }

    /**
     * 日付入力用の値2を設定する。
     * @param ciValue2 日付入力用の値2
     */
    @YYYYMMDD(allowFormat = "yyyy/MM/dd")
    public void setCiValue2(String ciValue2) {
        this.ciValue2 = ciValue2;
    }

    /**
     * 自動計算用の値1を取得する。
     * @return 自動計算用の値1
     */
    public BigDecimal getAsValue1() {
        return asValue1;
    }

    /**
     * 自動計算用の値1を設定する。
     * @param asValue1 自動計算用の値1
     */
    @Digits(integer = 10, fraction = 2)
    public void setAsValue1(BigDecimal asValue1) {
        this.asValue1 = asValue1;
    }

    /**
     * 自動計算用の値2を取得する。
     * @return 自動計算用の値2
     */
    public BigDecimal getAsValue2() {
        return asValue2;
    }

    /**
     * 自動計算用の値2を設定する。
     * @param asValue2 自動計算用の値2
     */
    @Digits(integer = 10, fraction = 2)
    public void setAsValue2(BigDecimal asValue2) {
        this.asValue2 = asValue2;
    }

    /**
     * 自動計算用の値3を取得する。
     * @return 自動計算用の値3
     */
    public BigDecimal getAsValue3() {
        return asValue3;
    }

    /**
     * 自動計算用の値3を設定する。
     * @param asValue3 自動計算用の値3
     */
    @Digits(integer = 10, fraction = 2)
    public void setAsValue3(BigDecimal asValue3) {
        this.asValue3 = asValue3;
    }

    /**
     * 自動計算用の合計を取得する。
     * @return 自動計算用の合計
     */
    public BigDecimal getAsTotal() {
        return nullToZero(asValue1)
                    .add(nullToZero(asValue2))
                    .subtract(nullToZero(asValue3));
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
    public static void validateForRegister(ValidationContext<W99ZZ64Form> context) {
        ValidationUtil.validateWithout(context, new String[0]);
    }
}
