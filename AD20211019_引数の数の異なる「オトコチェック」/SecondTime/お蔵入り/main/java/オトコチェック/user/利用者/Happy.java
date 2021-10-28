package オトコチェック.user.利用者;

import オトコチェック.business.service.ComparatorService;
import オトコチェック.domain.model.item.otoko.白馬の王子様;

public class Happy {
    public static void main(String args[]) {
        白馬の王子様 Ouji1 = new 白馬の王子様("じぃじ",68,180,70);
        白馬の王子様 Ouji2 = new 白馬の王子様("ぱぁぱ",71,172,41);
        白馬の王子様 Ouji3 = new 白馬の王子様("チェホンマン",160,218,40);

        ComparatorService OtokoChk = new ComparatorService();

        String type = args[0];
        String winner = "";
        //If文スッキリ(⋈◍＞◡＜◍)。✧♡
        if(type.equals("痩せてる")){ winner = OtokoChk.weight(Ouji1, Ouji2); }
        if(type.equals("背が高い")){ winner = OtokoChk.height(Ouji1, Ouji2, Ouji3); }

        System.out.println(winner + "大好き♪");

    }
}