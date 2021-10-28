package オトコチェック.domain.model.compare.otoko;

import オトコチェック.domain.model.item.otoko.白馬の王子様;
import オトコチェック.business.Adapter.ThreeComparatorStrategy;

public class HeightThreeComparator implements ThreeComparatorStrategy {
    public String threeCompare(白馬の王子様 o1, 白馬の王子様 o2, 白馬の王子様 o3) {
        //背が高い人が好き♪
        return compareRecursion(compareRecursion(o1, o2), o3)
                .name();
    }

    private 白馬の王子様 compareRecursion(白馬の王子様 o1, 白馬の王子様 o2) {
        //背が高い人が好き♪
        if (o1.height() > o2.height()) { return o1; }
        if (o1.height() < o2.height()) { return o2; }
        else {
            String name = o1.name() + "♪" + o2.name();
            int weight = -1;
            int height = o1.height();
            int age = -1;
            return new 白馬の王子様(name, weight, height, age);
        }
    }
}