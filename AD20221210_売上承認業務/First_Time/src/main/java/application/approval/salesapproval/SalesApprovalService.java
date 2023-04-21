package application.approval.salesapproval;

import domain.credit.value.blacklist.BlackListPersonRank;
import domain.credit.value.exceptionlist.ExceptionPerson;
import domain.sales.salesapproval.checkwork.*;
import domain.sales.salesapproval.judgementwork.SalesApproval;
import domain.sales.value.salesamount.SalesAmount;
import domain.credit.value.lineofcredit.LineOfCreditRank;
import domain.sales.salesapproval.judgementwork.SalesApprovalJudgement;
import domain.support.value.Message;

public class SalesApprovalService {

    private final SalesAmount myMoney;
    private final LineOfCreditRank myCreditRank;
    private final BlackListPersonRank myBlackListPersonRank;
    private final ExceptionPerson myExceptionPersonList;

    public SalesApprovalService(
            final SalesAmount myMoney
            , final LineOfCreditRank myCreditRank
            , final BlackListPersonRank myBlackListPersonRank
            , final ExceptionPerson myExceptionPersonList){
        this.myMoney = myMoney;
        this.myCreditRank = myCreditRank;
        this.myBlackListPersonRank = myBlackListPersonRank;
        this.myExceptionPersonList = myExceptionPersonList;
    }

    public Message run(){
        final PolicySalesApprovalChecksInvoker myPolicy
                = new PolicySalesApprovalChecksInvoker();

        //取引下限売上金額チェック
        myPolicy.addPolicy( new MinimumSalesAmountCheck(myMoney) );
        //取引上限売上金額チェック
        myPolicy.addPolicy( new MaximumSalesAmountCheck(myMoney) );
        //与信枠ランクSのチェック
        myPolicy.addPolicy( new LineOfCreditRank_S_Check(myCreditRank) );
        //与信枠ランクAのチェック
        myPolicy.addPolicy( new LineOfCreditRank_A_Check(myMoney, myCreditRank) );
        //与信枠ランクBのチェック
        myPolicy.addPolicy( new LineOfCreditRank_B_Check(myMoney, myCreditRank) );
        //与信枠ランクCのチェック
        myPolicy.addPolicy( new LineOfCreditRank_C_Check(myMoney, myCreditRank) );
        //与信枠ランクZのチェック
        myPolicy.addPolicy( new LineOfCreditRank_Z_Check(myMoney, myCreditRank) );
        // 相手先担当営業の人物チェック(※その(1)：非ブラックリスト者チェック)
        myPolicy.addPolicy( new UnBlackListPerson_Check(myBlackListPersonRank, myCreditRank) );
        // 相手先担当営業の人物チェック(※その(2)：ブラックリスト者の例外者リストチェック)
        myPolicy.addPolicy( new ExceptionPersonList_Check(myExceptionPersonList, myCreditRank) );

        // チェック処理の連続実行
        ApprovalCheckResultsChain myCheckResultsChain = myPolicy.execute();

        // 承認判定処理の実行
        SalesApproval mySalesApproval
                = new SalesApprovalJudgement(myCheckResultsChain).judge();

        return new Message(
                mySalesApproval.getClass().getSimpleName()
                        + ":"
                        + mySalesApproval
        );
    }
}