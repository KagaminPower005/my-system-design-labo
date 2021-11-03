package オトコチェック.domain.model.compare.otoko;

import オトコチェック.domain.model.compare.otoko.parts.HeightComparator;
import オトコチェック.domain.model.compare.otoko.parts.HeightThreeComparator;
import オトコチェック.domain.model.compare.otoko.parts.WeightComparator;
import オトコチェック.domain.model.item.otoko.王子様;

public enum 比較区分 {
     三人の身長( new HeightThreeComparator())
    ,二人の身長( new HeightComparator())
    ,二人の体重( new WeightComparator());

     private ThreeComparatorStrategy myThreeComparatorStrategy;
     private ComparatorStrategy myComparatorStrategy;

     比較区分(ThreeComparatorStrategy myThreeComparatorStrategy){
         this.myThreeComparatorStrategy = myThreeComparatorStrategy;
     }

     比較区分(ComparatorStrategy myComparatorStrategy){
         this.myComparatorStrategy = myComparatorStrategy;
     }

     public String threeCompare( 王子様 o1, 王子様 o2, 王子様 o3 ){
         if(myThreeComparatorStrategy == null){ return  "設定した人数が異なっております"; }
         return myThreeComparatorStrategy.threeCompare( o1, o2, o3 );
     }

    public String Compare( 王子様 o1, 王子様 o2 ){
        if(myComparatorStrategy == null){ return  "設定した人数が異なっております"; }
         return myComparatorStrategy.compare( o1, o2 );
    }
}