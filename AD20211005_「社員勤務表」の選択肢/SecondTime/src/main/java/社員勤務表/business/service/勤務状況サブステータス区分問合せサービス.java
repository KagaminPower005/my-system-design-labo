package 社員勤務表.business.service;

import 社員勤務表.domain.model.勤務状況;
import 社員勤務表.domain.model.状態区分;
import 社員勤務表.domain.model.場所区分;

import java.util.ArrayList;

public class 勤務状況サブステータス区分問合せサービス {

    private String my勤務状況;
    private ArrayList<String> my勤務状況サブステータス区分list = new ArrayList<>();

    public 勤務状況サブステータス区分問合せサービス(String my勤務状況){
        try {  勤務状況.valueOf(my勤務状況);  }
        catch (IllegalArgumentException e) {
            System.out.println("その値は勤務状況には存在しません"); }
        this.my勤務状況 = my勤務状況;
    }
    public ArrayList<String> 勤務状況サブステータス区分List(){
        if(this.my勤務状況.equals(勤務状況.テレワーク.toString()))  { テレワーク設定(); }
        if(this.my勤務状況.equals(勤務状況.出社.toString()))       { 出社設定(); }
        if(this.my勤務状況.equals(勤務状況.非出社.toString()))      { 非出社設定(); }
        return my勤務状況サブステータス区分list;
    }
    private void テレワーク設定(){
        my勤務状況サブステータス区分list.add(場所区分.社外.toString());
    }
    private void 出社設定() { my勤務状況サブステータス区分list.add(場所区分.社内.toString()); }
    private void 非出社設定() {
        my勤務状況サブステータス区分list.add(状態区分.非稼働.toString());
    }
}