package 社員勤務表.domain.model;

import 社員勤務表.business.service.勤務状況サブステータス区分;

public enum 場所区分 implements 勤務状況サブステータス区分 {
    社外,
    社内;

    public final String 補足説明(){
        if(this.name().equals(場所区分.社外.name())){ return "テレワークに該当する働き方を行い、一日のうちなんらかの仕事をした状態を指します。";}
        if(this.name().equals(場所区分.社内.name())){ return "一日のうちなんらかの仕事をした状態を指します。ただし、テレワークは含みません。";}
        else{ return "その値は場所区分にはございません。";}
    }
}