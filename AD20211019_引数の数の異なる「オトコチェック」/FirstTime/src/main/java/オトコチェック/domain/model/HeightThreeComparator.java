package オトコチェック.domain.model;

public class HeightThreeComparator implements ThreeComparatorStrategy {
    public String threeCompare(OujiSama o1, OujiSama o2, OujiSama o3) {
        //背が高い人が好き♪
        return compareRecursion(compareRecursion(o1, o2), o3).name();
    }

    private OujiSama compareRecursion(OujiSama o1, OujiSama o2) {
        //背が高い人が好き♪
        if (o1.height() > o2.height()) { return o1; }
        if (o1.height() < o2.height()) { return o2; }
        else {
            String name = o1.name() + "♪" + o2.name();
            int height = o1.height();
            int weight = -1;
            int age = -1;
            return new OujiSama(name, height, weight, age);
        }
    }
}