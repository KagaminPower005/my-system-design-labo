package オトコチェック.business.Adapter;

import オトコチェック.domain.model.item.otoko.白馬の王子様;

public class オトコFactory {

    public 比較対象殿方 create(String お名前, int 身長, int 体重, int 年齢){
        return new 白馬の王子様(お名前, 身長, 体重, 年齢);
    }
}