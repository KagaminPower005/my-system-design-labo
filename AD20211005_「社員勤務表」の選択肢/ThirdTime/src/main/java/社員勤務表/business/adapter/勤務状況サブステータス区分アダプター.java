package 社員勤務表.business.adapter;

import 社員勤務表.domain.model.状態区分;
import 社員勤務表.domain.model.場所区分;

public class 勤務状況サブステータス区分アダプター {
    private 状態区分 my状態区分;
    private 場所区分 my場所区分;

    public 勤務状況サブステータス区分アダプター(状態区分 my状態区分){
        this.my状態区分 = my状態区分;
    }

    public 勤務状況サブステータス区分アダプター(場所区分 my場所区分){
        this.my場所区分 = my場所区分;
    }

    public final String name(){
        if( my状態区分 != null ){ return my状態区分.name(); }
        else{ return my場所区分.name(); }
    }

    public final String 補足説明(){
        if( my状態区分 != null ){ return my状態区分.補足説明(); }
        else{ return my場所区分.補足説明(); }
    }
}