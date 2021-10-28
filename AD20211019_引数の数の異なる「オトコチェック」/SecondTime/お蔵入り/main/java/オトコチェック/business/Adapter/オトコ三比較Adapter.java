package オトコチェック.business.Adapter;

import オトコチェック.domain.model.item.otoko.白馬の王子様;

public class オトコ三比較Adapter {
    private ThreeComparatorStrategy myThreeComparatorStrategy;

    public オトコ三比較Adapter(ThreeComparatorStrategy myThreeComparatorStrategy){
        this.myThreeComparatorStrategy = myThreeComparatorStrategy;
    }

    public String compare(比較対象殿方 王子様1,比較対象殿方 王子様2,比較対象殿方 王子様3) {
        return myThreeComparatorStrategy.threeCompare(
                  (白馬の王子様) 王子様1
                , (白馬の王子様) 王子様2
                , (白馬の王子様) 王子様3
        );
    }
}