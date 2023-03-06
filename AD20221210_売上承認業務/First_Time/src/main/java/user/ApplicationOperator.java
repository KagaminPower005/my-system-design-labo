package user;

import application.approval.salesapproval.SalesApprovalService;
import domain.credit.blacklist.BlackListPersonRank;
import domain.credit.exceptionlist.ExceptionPerson;
import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.items.salesamount.SalesAmount;

public class ApplicationOperator {

    public static void main(String[] args){
        // 端末でパラメータを入力
        SalesAmount myMoney = new SalesAmount(90000);
        LineOfCreditRank myCreditRank = LineOfCreditRank.C;
        BlackListPersonRank myBlackListPersonRank = BlackListPersonRank.B;
        ExceptionPerson myExceptionPersonList =  ExceptionPerson.FALSE;

        // サービスが起動
        SalesApprovalService myService
                = new SalesApprovalService
                (
                        myMoney
                        ,myCreditRank
                        ,myBlackListPersonRank
                        ,myExceptionPersonList
                );

        // 結果をコンソールに出力
        System.out.println( "売上金額   :"
                + String.format("%,d",myMoney.value().intValue()) + "円" );

        System.out.println( "与信枠ランク:"
                + myCreditRank.name() );

        System.out.println( "ブラックリスト者ランク:"
                + myBlackListPersonRank.name() );

        System.out.println( "例外者リスト:"
                + myExceptionPersonList.name() );

        System.out.println( myService.run().myMessage() );
    }
}