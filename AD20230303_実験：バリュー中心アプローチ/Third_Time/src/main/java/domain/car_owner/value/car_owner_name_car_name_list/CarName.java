package domain.car_owner.value.car_owner_name_car_name_list;

import domain.car_owner.value.car.Name;
import domain.support.value.NotMatch;

public record CarName(String name) {

    //※↓↓『ドメイン固有の値』のチェック↓↓
    public static final int MAX_VALUE = Name.MAX_VALUE;
    public static final int MIN_VALUE = Name.MIN_VALUE;
    //※↑↑『ドメイン固有の値』のチェック↑↑

    public Boolean isNotMatch(){
        NotMatch myNotMatch
                = new NotMatch(MAX_VALUE, MIN_VALUE, this.name.length());

        return myNotMatch.isNotMatch();
    }

    public String value() {
        // 『ドメイン固有の値』のチェック
        if(this.isNotMatch()){
            throw new RuntimeException(
                    this.getClass().getSimpleName()
                            + ":最大値または最小値の範囲外の値です。"
            );
        }

        return this.name;
    }

}