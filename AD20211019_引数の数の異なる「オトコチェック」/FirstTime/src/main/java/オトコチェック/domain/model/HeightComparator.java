package オトコチェック.domain.model;

//身長比較クラス
public class HeightComparator implements ComparatorStrategy {
    public String compare(Oujisama o1, Oujisama o2) {
        //背が高い人が好き♪
        if (o1.height() > o2.height()) { return o1.name(); }
        if (o1.height() < o2.height()) { return o2.name(); }
        else                           { return "両方とも"; }
    }

    public String tripleCompare(Oujisama o1, Oujisama o2, Oujisama o3) {
        //背が高い人が好き♪
        return compareRecursion(compareRecursion(o1, o2), o3).name();
    }

    private Oujisama compareRecursion(Oujisama o1, Oujisama o2) {
        //背が高い人が好き♪
        if (o1.height() > o2.height()) { return o1; }
        if (o1.height() < o2.height()) { return o2; }
        else {
            String name = o1.name() + ":" + o2.name();
            int weight = -1;
            int height = o1.height();
            int age = -1;
            return new Oujisama(name, weight, height, age);
        }
    }
}