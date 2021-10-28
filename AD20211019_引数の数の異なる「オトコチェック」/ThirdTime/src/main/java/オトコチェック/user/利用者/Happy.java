package オトコチェック.user.利用者;

import オトコチェック.business.service.オトコ比較サービス;
import オトコチェック.domain.model.item.message.回答;
import オトコチェック.domain.model.item.otoko.王子様;

public class Happy {
    public static void main(String args[]) {
        王子様 候補1 = new 王子様("じぃじ",180,68,70);
        王子様 候補2 = new 王子様("ぱぁぱ",172,71,41);
        王子様 候補3 = new 王子様("チェホンマン",218,160,40);

        オトコ比較サービス my体重比較 = new オトコ比較サービス(2,"体重");
        オトコ比較サービス my身長比較 = new オトコ比較サービス(3,"身長");

        String type = args[0];
        回答 winner;
        //If文スッキリ(⋈◍＞◡＜◍)。✧♡
        if     (type.equals("痩せてる")){ winner = my体重比較.二人比較( 候補1, 候補2 ); }
        else if(type.equals("背が高い")){ winner = my身長比較.三人比較( 候補1, 候補2, 候補3 ); }
        else   { winner = null; new Exception("候補は誰もおりません。"); }

        System.out.println( winner.回答() + "大好き♪");

    }
}