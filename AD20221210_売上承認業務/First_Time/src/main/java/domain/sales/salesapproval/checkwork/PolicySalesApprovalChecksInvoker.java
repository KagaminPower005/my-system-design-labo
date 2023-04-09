package domain.sales.salesapproval.checkwork;

import java.util.Stack;

// ポリシーの追加・取消・実行を管理するクラス
public class PolicySalesApprovalChecksInvoker {

    private final Stack<SalesApprovalChecks> policyStack
            = new Stack<>();

    // ポリシーを追加する
    public void addPolicy(SalesApprovalChecks policy) {
        policyStack.push(policy);
        System.out.println
                (policyStack.size() + "個目のポリシーを登録しました。");
    }

    // ポリシーを順番に実行する
    public ApprovalCheckResultsChain execute() {
        System.out.println
                (policyStack.size() + "個のポリシーを実行します。");

        ApprovalCheckResultsChain myResultsChain
                = new ApprovalCheckResultsChain();

        for (SalesApprovalChecks salesApprovalChecks : policyStack) {
            //ここでチェック処理結果を蓄積
            myResultsChain.add( salesApprovalChecks.check());
            System.out.println(
                    // ex)「(ポリシー名)：(OK|NG)」
                      salesApprovalChecks.getClass().getSimpleName()
                    + ":"
                    + salesApprovalChecks.check().toString()
            );
        }
        System.out.println("ポリシーを実行しました。");
        return myResultsChain;
    }

}