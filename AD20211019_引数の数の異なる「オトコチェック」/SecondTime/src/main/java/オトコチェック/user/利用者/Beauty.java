package オトコチェック.user.利用者;

import オトコチェック.domain.model.item.otoko.王子様;
import オトコチェック.domain.model.compare.otoko.比較区分;

public class Beauty {
    public static void main(String args[]) {
        王子様 Ouji1 = new 王子様("じぃじ",180,68,70);
        王子様 Ouji2 = new 王子様("ぱぁぱ",172,71,41);
        王子様 Ouji3 = new 王子様("チェホンマン",218,160,40);

        比較区分 my二人体重比較 = 比較区分.valueOf(比較区分.二人の体重.name());
        比較区分 my三人身長比較 = 比較区分.valueOf(比較区分.三人の身長.name());

        String type = args[0];
        String winner = "";
        //If文スッキリ(⋈◍＞◡＜◍)。✧♡
        if(type.equals("痩せてる")){ winner = my二人体重比較.Compare( Ouji1, Ouji2 ); }
        if(type.equals("背が高い")){ winner = my三人身長比較.threeCompare( Ouji1, Ouji2, Ouji3 ); }

        System.out.println(winner + "大好き♪");
    }
}