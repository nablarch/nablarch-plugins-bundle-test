package please.change.me.tutorial.ss99ZZ;

import java.math.BigDecimal;
import java.util.Map;

import nablarch.common.date.YYYYMMDD;
import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.convertor.Digits;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;

/**
 * 変更不可項目連携テスト用のアクションで使用するフォーム。
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ63Form {

    private String[] lbValues;
    private String ciValue;
    private String[] tlValues;
    private BigDecimal asValue1;
    private BigDecimal asValue2;
    private BigDecimal asValue3;
    private String phValue;

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ63Form() {
    }

    /**
     * コンストラクタ。
     * @param data 初期化データ
     */
    public W99ZZ63Form(Map<String, ?> data) {
        lbValues = (String[]) data.get("lbValues");
        ciValue = (String) data.get("ciValue");
        tlValues = (String[]) data.get("tlValues");
        asValue1 = (BigDecimal) data.get("asValue1");
        asValue2 = (BigDecimal) data.get("asValue2");
        asValue3 = (BigDecimal) data.get("asValue3");
        phValue = (String) data.get("phValue");
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
     * 日付入力用の値を取得する。
     * @return 日付入力用の値
     */
    public String getCiValue() {
        return ciValue;
    }

    /**
     * 日付入力用の値を設定する。
     * @param ciValue 日付入力用の値
     */
    @YYYYMMDD(allowFormat = "yyyy/MM/dd")
    public void setCiValue(String ciValue) {
        this.ciValue = ciValue;
    }

    /**
     * ツリーリスト用の値を取得する。
     * @return ツリーリスト用の値
     */
    public String[] getTlValues() {
        return tlValues;
    }

    /**
     * ツリーリスト用の値を設定する。
     * @param tlValues ツリーリスト用の値
     */
    @Required
    @Length(max = 10)
    public void setTlValues(String[] tlValues) {
        this.tlValues = tlValues;
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
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("register")
    public static void validateForRegister(ValidationContext<W99ZZ63Form> context) {
        ValidationUtil.validateWithout(context, new String[0]);
    }
}
