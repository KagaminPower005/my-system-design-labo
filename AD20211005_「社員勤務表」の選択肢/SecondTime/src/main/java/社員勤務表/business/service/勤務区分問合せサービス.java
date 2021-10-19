package 社員勤務表.business.service;

import 社員勤務表.domain.model.勤務区分;
import 社員勤務表.domain.model.勤務状況;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 勤務区分問合せサービス {

    private String my勤務状況 = "";
    private List<String> my勤務区分list = new ArrayList<>();

    public 勤務区分問合せサービス(String my勤務状況){
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
    public List<String> 勤務区分List(){
        if(my勤務状況.equals(勤務状況.テレワーク.name())) { return テレワーク設定(); }
        if(my勤務状況.equals(勤務状況.出社.name()))      { return 出社設定(); }
        if(my勤務状況.equals(勤務状況.非出社.name()))     { return 非出社設定(); }
        else{ my勤務区分list.clear(); }

        return  Collections.unmodifiableList(my勤務区分list);
    }
    private List<String> テレワーク設定(){
        my勤務区分list.add(勤務区分.フル出勤.name());
        my勤務区分list.add(勤務区分.午前休.name());
        my勤務区分list.add(勤務区分.午後休.name());

        return  Collections.unmodifiableList(my勤務区分list);
    }
    private List<String> 出社設定(){
        my勤務区分list.add(勤務区分.フル出勤.name());
        my勤務区分list.add(勤務区分.午前休.name());
        my勤務区分list.add(勤務区分.午後休.name());

        return  Collections.unmodifiableList(my勤務区分list);
    }
    private List<String> 非出社設定(){
        my勤務区分list.add(勤務区分.週休日.name());
        my勤務区分list.add(勤務区分.休暇.name());
        my勤務区分list.add(勤務区分.欠勤.name());

        return  Collections.unmodifiableList(my勤務区分list);
    }
}