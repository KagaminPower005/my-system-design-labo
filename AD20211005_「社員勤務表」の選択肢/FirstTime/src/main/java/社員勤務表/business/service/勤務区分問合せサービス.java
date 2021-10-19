package 社員勤務表.business.service;

import 社員勤務表.domain.model.勤務状況;
import 社員勤務表.domain.model.勤務区分;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class 勤務区分問合せサービス {

    private String my勤務状況;
    private List<String> my勤務区分list = new ArrayList<>();

    public 勤務区分問合せサービス(String my勤務状況){
        try {  勤務状況.valueOf(my勤務状況);  }
        catch (IllegalArgumentException e) {
            System.out.println("その値は勤務状況には存在しません");
        }
        this.my勤務状況 = my勤務状況;
    }
    public List<String> 勤務区分List(){
        if(my勤務状況.equals(勤務状況.テレワーク.name())) { テレワーク設定(); }
        if(my勤務状況.equals(勤務状況.出社.name()))      { 出社設定(); }
        if(my勤務状況.equals(勤務状況.非出社.name()))    { 非出社設定(); }
        return  Collections.unmodifiableList(my勤務区分list);
    }
    private void テレワーク設定(){
        my勤務区分list.add(勤務区分.フル出勤.toString());
        my勤務区分list.add(勤務区分.午前休.toString());
        my勤務区分list.add(勤務区分.午後休.toString());
    }
    private void 出社設定(){
        my勤務区分list.add(勤務区分.フル出勤.toString());
        my勤務区分list.add(勤務区分.午前休.toString());
        my勤務区分list.add(勤務区分.午後休.toString());
    }
    private void 非出社設定(){
        my勤務区分list.add(勤務区分.週休日.toString());
        my勤務区分list.add(勤務区分.休暇.toString());
        my勤務区分list.add(勤務区分.欠勤.toString());
    }
}