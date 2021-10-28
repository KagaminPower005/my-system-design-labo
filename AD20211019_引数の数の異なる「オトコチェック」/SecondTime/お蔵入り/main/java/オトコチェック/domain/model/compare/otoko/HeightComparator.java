package オトコチェック.domain.model.compare.otoko;

import オトコチェック.business.Adapter.ComparatorStrategy;
import オトコチェック.business.Adapter.比較対象殿方;

//身長比較クラス
public class HeightComparator implements ComparatorStrategy {
    public String compare(比較対象殿方 o1, 比較対象殿方 o2) {
        //背が高い人が好き♪
        if (o1.身長() > o2.身長()) { return o1.お名前(); }
        if (o1.身長() < o2.身長()) { return o2.お名前(); }
        else { return "両方とも"; }
    }
}