package オトコチェック.business.service;

import オトコチェック.domain.model.item.otoko.白馬の王子様;
import オトコチェック.domain.model.compare.otoko.WeightComparator;
import オトコチェック.domain.model.compare.otoko.HeightThreeComparator;

//比較サービス
public class ComparatorService {
    public String weight(白馬の王子様 o1, 白馬の王子様 o2){

        return new WeightComparator().compare(o1,o2);
    }
    public String height(白馬の王子様 o1, 白馬の王子様 o2, 白馬の王子様 o3){

        return new HeightThreeComparator().threeCompare(o1,o2,o3);
    }
}