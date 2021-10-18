package オトコチェック.domain.model;

//体重比較クラス
public class WeightComparator implements ComparatorStrategy{
    public String compare(Oujisama o1 , Oujisama o2){
        //痩せてる人が好き♪
        if (o1.weight() > o2.weight()) { return o1.name(); }
        if (o1.weight() < o2.weight()) { return o2.name(); }
        else                           { return "両方とも"; }
    }
}