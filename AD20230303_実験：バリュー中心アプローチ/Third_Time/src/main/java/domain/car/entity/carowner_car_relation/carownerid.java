package domain.car.entity.carowner_car_relation;

import support.NotMatch;

public record carownerid(int id) {

    //※↓↓『ドメイン固有の値』のチェック↓↓
    public static final int MAX_VALUE = domain.car.entity.carowner.id.MAX_VALUE;
    public static final int MIN_VALUE = domain.car.entity.carowner.id.MIN_VALUE;
    //※↑↑『ドメイン固有の値』のチェック↑↑

    public Boolean isNotMatch(){
        NotMatch myNotMatch
                = new NotMatch(MAX_VALUE, MIN_VALUE, this.id);

        return myNotMatch.isNotMatch();
    }

    public Integer value() {
        // 『ドメイン固有の値』のチェック
        if(this.isNotMatch()){
            throw new RuntimeException(
                    this.getClass().getSimpleName()
                            + ":最大値または最小値の範囲外の値です。"
            );
        }

        return this.id;
    }
}