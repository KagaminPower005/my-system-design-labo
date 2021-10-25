package 社員勤務表.domain.model;

public enum 場所区分 {
    社外,
    社内;

    public final String 補足説明(場所区分 my場所区分){
        if(my場所区分.name()==場所区分.社外.name()){ return "テレワークに該当する働き方を行い、一日のうちなんらかの仕事をした状態を指します。";}
        if(my場所区分.name()==場所区分.社内.name()){ return "一日のうちなんらかの仕事をした状態を指します。ただし、テレワークは含みません。";}
        else{ return "その値は状態区分にはございません。";}
    }
}