package 社員勤務表.user.domainExpert;

import 社員勤務表.business.service.勤務区分問合せサービス;
import 社員勤務表.business.service.勤務状況サブステータス区分問合せサービス;
import java.util.ArrayList;
import java.util.List;

public class Pure {
    private static List<String> my勤務区分list = new ArrayList<>();
    private static List<String> my勤務状況サブステータス区分list = new ArrayList<>();

    public static void main(String args[]){
        final String my勤務状況 = args[0];

        勤務区分問合せ(my勤務状況);
        勤務状況サブステータス区分問合せ(my勤務状況);
    }

    private static void 勤務区分問合せ(String my勤務状況){
        System.out.println("『勤務状況』が" + my勤務状況 + "の場合、該当する『勤務区分』は");
        勤務区分問合せサービス my勤務区分問合せ = new 勤務区分問合せサービス(my勤務状況);

        my勤務区分list = my勤務区分問合せ.勤務区分List();
        for (String s : my勤務区分list) {
            System.out.println("  ●" + s);
        }
        System.out.println("です。");
    }

    private static void 勤務状況サブステータス区分問合せ(String my勤務状況){
        System.out.println("『勤務状況』が" + my勤務状況 + "の場合、該当する『勤務状況サブステータス区分』は");
        勤務状況サブステータス区分問合せサービス my勤務状況サブステータス区分問合せ
                = new 勤務状況サブステータス区分問合せサービス(my勤務状況);

        my勤務状況サブステータス区分list
                = my勤務状況サブステータス区分問合せ.勤務状況サブステータス区分List();
        for (String s : my勤務状況サブステータス区分list) {
            System.out.println("  ●" + s);
        }
        System.out.println("です。");
    }
}