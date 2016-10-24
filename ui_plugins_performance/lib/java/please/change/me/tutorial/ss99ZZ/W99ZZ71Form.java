package please.change.me.tutorial.ss99ZZ;

import java.util.Map;

import nablarch.core.validation.ValidateFor;
import nablarch.core.validation.ValidationContext;
import nablarch.core.validation.ValidationUtil;
import nablarch.core.validation.validator.Length;
import nablarch.core.validation.validator.Required;

/**
 * 画面の入力項目
 * @author Iwauo Tajima
 * @since  1.2
 */
public class W99ZZ71Form {
    /**
     * コンストラクタ
     * @param data パラメータを格納するMap
     */
    public W99ZZ71Form(Map<String, Object> data) {
        this.permissionUnits = (String[]) data.get("permissionUnits");
    }
    
    /** 認可単位。 */
    private String[] permissionUnits;
    
    /**
     * 認可単位を取得する。
     * @return システムアカウントテーブルの情報
     */
    public String[] getPermissionUnits() {
        return this.permissionUnits;
    }
    
    /**
     * 認可単位を設定する。
     * @param units 認可単位
     */
    @Required
    @Length(max = 10)
    public void setPermissionUnits(String[] units) {
        this.permissionUnits = units;
    }

    /**
     * 登録処理を行うために必要な情報が入力されたことを精査する。
     *
     * @param context 精査処理コンテキスト
     */
    @ValidateFor("registerUser")
    public static void validateForRegister(ValidationContext<W99ZZ71Form> context) {
        ValidationUtil.validate(context, new String[] {"permissionUnits"});
    }
}
