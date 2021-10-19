package オトコチェック.business.service;

import オトコチェック.domain.model.OujiSama;
import オトコチェック.domain.model.WeightComparator;
import オトコチェック.domain.model.HeightThreeComparator;

//比較サービス
public class ComparatorService {
    public String weight(OujiSama o1, OujiSama o2){

        return new WeightComparator().compare(o1,o2);
    }
    public String height(OujiSama o1, OujiSama o2, OujiSama o3){

        return new HeightThreeComparator().threeCompare(o1,o2,o3);
    }
}