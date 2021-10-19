package 社員勤務表.business.service;

import 社員勤務表.domain.model.勤務状況;
import 社員勤務表.domain.model.場所区分;
import 社員勤務表.domain.model.状態区分;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 勤務状況サブステータス区分問合せサービス {

    private String my勤務状況 = "";
    private List<String> my勤務状況サブステータス区分list = new ArrayList<>();

    public 勤務状況サブステータス区分問合せサービス(String my勤務状況){
        try {
            勤務状況.valueOf(my勤務状況);
            //テレワーク休止
            if(my勤務状況.equals(勤務状況.テレワーク.name())){
                throw new IllegalArgumentException();
            }
            this.my勤務状況 = my勤務状況;
        }
        catch (IllegalArgumentException e) {
            System.out.println("その値は勤務状況には存在しません");
        }
    }
    public List<String> 勤務状況サブステータス区分List(){
        if(my勤務状況.equals(勤務状況.テレワーク.name())) { return テレワーク設定(); }
        if(my勤務状況.equals(勤務状況.出社.name()))      { return 出社設定(); }
        if(my勤務状況.equals(勤務状況.非出社.name()))     { return 非出社設定(); }
        else{ my勤務状況サブステータス区分list.clear(); }

        return Collections.unmodifiableList(my勤務状況サブステータス区分list);
    }
    private List<String> テレワーク設定(){
        my勤務状況サブステータス区分list.add(場所区分.社外.name());

        return Collections.unmodifiableList(my勤務状況サブステータス区分list);
    }
    private List<String> 出社設定() {
        my勤務状況サブステータス区分list.add(場所区分.社内.name());

        return Collections.unmodifiableList(my勤務状況サブステータス区分list);
    }
    private List<String> 非出社設定() {
        my勤務状況サブステータス区分list.add(状態区分.非稼働.name());

        return Collections.unmodifiableList(my勤務状況サブステータス区分list);
    }
}