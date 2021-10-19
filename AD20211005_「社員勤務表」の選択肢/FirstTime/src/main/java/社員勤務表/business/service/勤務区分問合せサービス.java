package 社員勤務表.business.service;

import 社員勤務表.domain.model.勤務区分;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class 勤務区分問合せサービス {

    private String my勤務状況 = "";
    private List<String> my勤務区分list = new ArrayList<>();

    public 勤務区分問合せサービス(String my勤務状況){
        勤務状況判定サービス my勤務状況判定 = new 勤務状況判定サービス(my勤務状況);

        if(my勤務状況判定.is非該当()){ System.out.println("その値は勤務状況には存在しません"); }
        else{ this.my勤務状況 = my勤務状況; }
    }
    public List<String> 勤務区分List(){
        勤務状況判定サービス my勤務状況判定 = new 勤務状況判定サービス(my勤務状況);

        if(my勤務状況判定.isテレワーク()) {return テレワーク設定(); }
        if(my勤務状況判定.is出社())      {return 出社設定(); }
        if(my勤務状況判定.is非出社())     {return 非出社設定(); }
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