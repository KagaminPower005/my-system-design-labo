package application.approval.salesapproval;

import domain.credit.blacklist.BlackListPersonRank;
import domain.credit.exceptionlist.ExceptionPersonList;
import domain.sales.salesapproval.checkwork.*;
import domain.sales.salesapproval.judgementwork.SalesApproval;
import domain.sales.items.salesamount.SalesAmount;
import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.salesapproval.judgementwork.SalesApprovalJudgement;
import support.Message;

public class SalesApprovalService {

    private final SalesAmount myMoney;
    private final LineOfCreditRank mylineOfCreditRank;
    private final BlackListPersonRank myBlackListRank;

    private final ExceptionPersonList myExceptionListRank;


    public SalesApprovalService(
            final SalesAmount myMoney
            , final LineOfCreditRank mylineOfCreditRank
            , final BlackListPersonRank myBlackListRank
            , final ExceptionPersonList myExceptionListRank){
        this.myMoney = myMoney;
        this.mylineOfCreditRank = mylineOfCreditRank;
        this.myBlackListRank = myBlackListRank;
        this.myExceptionListRank = myExceptionListRank;
    }

    public Message run(){
        final PolicySalesApprovalChecksInvoker myPolicy
                = new PolicySalesApprovalChecksInvoker();

        //取引下限売上金額チェック
        myPolicy.addPolicy( new MinimumSalesAmountCheck(myMoney) );
        //取引上限売上金額チェック
        myPolicy.addPolicy( new MaximumSalesAmountCheck(myMoney) );
        //与信枠ランクSのチェック
        myPolicy.addPolicy( new LineOfCreditRank_S_Check(mylineOfCreditRank) );
        //与信枠ランクAのチェック
        myPolicy.addPolicy( new LineOfCreditRank_A_Check(myMoney, mylineOfCreditRank) );
        //与信枠ランクBのチェック
        myPolicy.addPolicy( new LineOfCreditRank_B_Check(myMoney, mylineOfCreditRank) );
        //与信枠ランクCのチェック
        myPolicy.addPolicy( new LineOfCreditRank_C_Check(myMoney, mylineOfCreditRank) );
        //与信枠ランクZのチェック
        myPolicy.addPolicy( new LineOfCreditRank_Z_Check(myMoney, mylineOfCreditRank) );
        // 相手先担当営業の人物チェック(※その⑴：ブラックリストチェック)
        myPolicy.addPolicy( new UnBlackListPerson_Check(myBlackListRank, mylineOfCreditRank) );
        // 相手先担当営業の人物チェック(※その⑴：ブラックリストチェック)
        myPolicy.addPolicy( new ExceptionPersonList_Check(myExceptionListRank, mylineOfCreditRank) );

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