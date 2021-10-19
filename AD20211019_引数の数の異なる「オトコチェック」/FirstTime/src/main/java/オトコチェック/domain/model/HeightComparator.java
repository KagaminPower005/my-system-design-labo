package オトコチェック.domain.model;

//身長比較クラス
public class HeightComparator implements ComparatorStrategy {
    public String compare(OujiSama o1, OujiSama o2) {
        //背が高い人が好き♪
        if (o1.height() > o2.height()) { return o1.name(); }
        if (o1.height() < o2.height()) { return o2.name(); }
        else { return "両方とも"; }
    }
}