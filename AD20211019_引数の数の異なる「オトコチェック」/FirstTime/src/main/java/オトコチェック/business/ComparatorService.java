package オトコチェック.business;

import オトコチェック.domain.model.Oujisama;
import オトコチェック.domain.model.WeightComparator;

//比較サービス
class ComparatorService {
    public String weight(Oujisama o1,Oujisama o2){
        return new WeightComparator().compare(o1,o2);
    }
    public String height(Oujisama o1,Oujisama o2,Oujisama o3){
        return new HeightComparator().tripleCompare(o1,o2,o3);
    }
}