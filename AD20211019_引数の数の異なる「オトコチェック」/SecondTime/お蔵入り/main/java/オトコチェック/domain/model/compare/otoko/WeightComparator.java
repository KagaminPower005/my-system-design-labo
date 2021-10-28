package オトコチェック.domain.model.compare.otoko;

import オトコチェック.business.Adapter.ComparatorStrategy;
import オトコチェック.domain.model.item.otoko.白馬の王子様;

//体重比較クラス
public class WeightComparator implements ComparatorStrategy {
    public String compare(白馬の王子様 o1 , 白馬の王子様 o2){
        //痩せてる人が好き♪
        if (o1.weight() > o2.weight()) { return o2.name(); }
        if (o1.weight() < o2.weight()) { return o1.name(); }
        else { return "両方とも"; }
    }
}