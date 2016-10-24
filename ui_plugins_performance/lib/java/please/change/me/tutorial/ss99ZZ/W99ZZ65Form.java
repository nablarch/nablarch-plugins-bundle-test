package please.change.me.tutorial.ss99ZZ;

import java.math.BigDecimal;
import java.util.Map;

import nablarch.common.date.YYYYMMDD;
import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.convertor.Digits;


/**
 * ダイアログ連携テスト用のアクションで使用するフォーム。
 * @author tani takanori
 * @since 1.4
 */
public class W99ZZ65Form {

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ65Form() {
    }

    /**
     * コンストラクタ。
     *
     * @param param パラメータ
     */
    public W99ZZ65Form(Map<String, Object> param) {

    }

    private String date1;
    private String date2;

    private String placeholder;

    private BigDecimal autoSum1;
    private BigDecimal autoSum2;
    private BigDecimal autoSum3;

    private String accountType;
    private String accountName;

    /**
     * Date1を取得する。
     *
     * @return Date1
     */
    public String getDate1() {
        return date1;
    }

    /**
     * Date1を設定する。
     *
     * @param date1 日付
     */
    @YYYYMMDD(allowFormat = "yyyy/MM/dd")
    public void setDate1(String date1) {
        this.date1 = date1;
    }

    /**
     * Date2を取得する。
     *
     * @return Date2
     */
    public String getDate2() {
        return date2;
    }

    /**
     * Date2を設定する。
     *
     * @param date2 日付
     */
    @YYYYMMDD(allowFormat = "yyyy/MM/dd")
    public void setDate2(String date2) {
        this.date2 = date2;
    }

    /**
     * placeholderを取得する。
     *
     * @return placeholder
     */
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * placeholderを設定する。
     *
     * @param placeholder 値
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    /**
     * 自動計算項目1を取得する。
     *
     * @return 自動計算項目1
     */
    public BigDecimal getAutoSum1() {
        return autoSum1;
    }

    /**
     * 自動計算項目1を設定する。
     *
     * @param autoSum1 自動計算項目1
     */
    @Digits(integer = 10)
    public void setAutoSum1(BigDecimal autoSum1) {
        this.autoSum1 = autoSum1;
    }

    /**
     * 自動計算項目2を取得する。
     *
     * @return 自動計算項目2
     */
    public BigDecimal getAutoSum2() {
        return autoSum2;
    }

    /**
     * 自動計算項目2を設定する。
     *
     * @param autoSum2 自動計算項目2
     */
    @Digits(integer = 10)
    public void setAutoSum2(BigDecimal autoSum2) {
        this.autoSum2 = autoSum2;
    }

    /**
     * 自動計算項目3を取得する。
     *
     * @return 自動計算項目3
     */
    public BigDecimal getAutoSum3() {
        return autoSum3;
    }

    /**
     * 自動計算項目3を設定する。
     *
     * @param autoSum3 自動計算項目3
     */
    @Digits(integer = 10)
    public void setAutoSum3(BigDecimal autoSum3) {
        this.autoSum3 = autoSum3;
    }

    /**
     * アカウント種別を取得する。
     *
     * @return アカウント種別
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * アカウント種別を設定する。
     *
     * @param accountType アカウント種別
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * アカウント名を取得する。
     *
     * @return アカウント名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * アカウント名を設定する。
     *
     * @param accountName アカウント名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    /**
     * 確認処理を行うために必要な情報が入力されたことを精査する。
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("confirm")
    public static void validateForConfirm(ValidationContext<W99ZZ64Form> context) {
        ValidationUtil.validateWithout(context, new String[0]);
    }
}
