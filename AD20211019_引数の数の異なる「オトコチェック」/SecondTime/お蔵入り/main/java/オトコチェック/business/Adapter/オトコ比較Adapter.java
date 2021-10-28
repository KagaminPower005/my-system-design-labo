package オトコチェック.business.Adapter;

import オトコチェック.domain.model.item.otoko.白馬の王子様;

public class オトコ比較Adapter {
    private ComparatorStrategy myComparatorStrategy;

    public オトコ比較Adapter(ComparatorStrategy myComparatorStrategy){
        this.myComparatorStrategy = myComparatorStrategy;
    }

    public String compare(比較対象殿方 王子様1,比較対象殿方 王子様2) {

        return myComparatorStrategy.compare(
                  王子様1
                , 王子様2
        );
    }
}