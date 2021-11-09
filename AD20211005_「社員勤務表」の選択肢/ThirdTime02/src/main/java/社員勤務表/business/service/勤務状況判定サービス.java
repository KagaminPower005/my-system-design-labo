package 社員勤務表.business.service;

import 社員勤務表.domain.model.勤務状況;

public class 勤務状況判定サービス {

    private final String my勤務状況;

    public 勤務状況判定サービス(String my勤務状況){
        this.my勤務状況 = my勤務状況;
    }

    public Boolean is非該当(){
        try {
            勤務状況.valueOf(my勤務状況);

            //緊急事態宣言長期休止によりテレワーク休止
            return this.isテレワーク();
        }
        catch (IllegalArgumentException e) {
            return true;
        }
    }

    public Boolean isテレワーク(){
        return my勤務状況.equals(勤務状況.テレワーク.name());
    }

    public Boolean is出社(){
        return my勤務状況.equals(勤務状況.出社.name());
    }

    public Boolean is非出社(){
        return my勤務状況.equals(勤務状況.非出社.name());
    }


}