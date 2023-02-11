package 社員勤務表.business.adapter;

import 社員勤務表.business.service.勤務区分インターフェース;
import 社員勤務表.domain.model.勤務区分;

//※これは、ドメイン層の「勤務区分」とまったく同じ内容かつ振る舞いをするクラス。
// ので、DRY的にいけてないかなと思われる。
//唯一の利点は、ドメイン層を傷つけずに「勤務区分インターフェース」を実装できるところ。
public enum 勤務区分アダプター implements 勤務区分インターフェース {
     フル出勤 ( 勤務区分.フル出勤  )
    ,午前休   ( 勤務区分.午前休   )
    ,午後休   ( 勤務区分.午後休   )
    ,休暇     ( 勤務区分.休暇    )
    ,週休日   ( 勤務区分.週休日   )
    ,欠勤     ( 勤務区分.欠勤    )
    ;

    private 勤務区分 my勤務区分;

    勤務区分アダプター( 勤務区分 my勤務区分 ){
        this.my勤務区分 = my勤務区分;
    }
}