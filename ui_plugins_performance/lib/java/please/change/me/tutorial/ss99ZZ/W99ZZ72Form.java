package please.change.me.tutorial.ss99ZZ;

import java.util.Map;

import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;

/**
 * ツリーリスト性能テスト用のアクションで使用するフォーム。
 * @author Kiyohito Itoh
 * @since 1.2
 */
public class W99ZZ72Form {

    private String[] tlValues;

    /**
     * デフォルトコンストラクタ。
     */
    public W99ZZ72Form() {
    }

    /**
     * コンストラクタ。
     * @param data 初期化データ
     */
    public W99ZZ72Form(Map<String, ?> data) {
        tlValues = (String[]) data.get("tlValues");
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
    @Length(max = 300)
    public void setTlValues(String[] tlValues) {
        this.tlValues = tlValues;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("register")
    public static void validateForRegister(ValidationContext<W99ZZ72Form> context) {
        ValidationUtil.validateWithout(context, new String[0]);
    }
}
