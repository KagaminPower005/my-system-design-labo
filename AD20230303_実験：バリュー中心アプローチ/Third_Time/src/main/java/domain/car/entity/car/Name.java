package domain.car.entity.car;

import support.NotMatch;

public record Name(String name) {

    //※↓↓『ドメイン固有の値』のチェック↓↓
    public static final int MAX_VALUE = 50;
    public static final int MIN_VALUE = 0;
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