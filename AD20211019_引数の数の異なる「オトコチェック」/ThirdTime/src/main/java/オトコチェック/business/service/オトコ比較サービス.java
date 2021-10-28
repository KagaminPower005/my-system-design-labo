package オトコチェック.business.service;

import オトコチェック.domain.model.compare.otoko.オトコ二人比較区分;
import オトコチェック.domain.model.compare.otoko.オトコ三人比較区分;
import オトコチェック.domain.model.item.otoko.王子様;
import オトコチェック.domain.model.item.message.回答;

//比較サービス
public class オトコ比較サービス {

    private オトコ二人比較区分 myオトコ二人比較区分;
    private オトコ三人比較区分 myオトコ三人比較区分;

    public オトコ比較サービス(int 人数, String 比較内容 ){
        try{
            if(人数 == 2){
                this.myオトコ二人比較区分 = オトコ二人比較区分.valueOf(比較内容);
            }
            if(人数 == 3){
                this.myオトコ三人比較区分 = オトコ三人比較区分.valueOf(比較内容);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println("そのオトコ比較には対応できません");
        }
    }

    public final 回答 二人比較(王子様 o1, 王子様 o2){
        if(myオトコ二人比較区分 == null){ return new 回答("設定した人数が異なっております"); }
        return myオトコ二人比較区分.compare(o1, o2);
    }

    public final 回答 三人比較(王子様 o1, 王子様 o2, 王子様 o3){
        if(myオトコ三人比較区分 == null){ return new 回答("設定した人数が異なっております"); }
        return myオトコ三人比較区分.threeCompare(o1,o2,o3);
    }
}