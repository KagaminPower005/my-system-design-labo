package user;

import application.approval.salesapproval.SalesApprovalService;
import domain.credit.blacklist.BlackListPersonRank;
import domain.credit.exceptionlist.ExceptionPerson;
import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.items.salesamount.SalesAmount;

public class ApplicationOperator {

    private static SalesAmount         myMoney;
    private static LineOfCreditRank    myCreditRank;
    private static BlackListPersonRank myBlackListPersonRank;
    private static ExceptionPerson     myExceptionPersonList;

    private static SalesApprovalService myService;

    public static void main(String[] args) {
        // 端末でパラメータを入力
        myMoney = new SalesAmount(900000);
        myCreditRank = LineOfCreditRank.B;
        myBlackListPersonRank = BlackListPersonRank.S;
        myExceptionPersonList = ExceptionPerson.TRUE;

        run();
        sOut();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        myMoney = new SalesAmount(100);
        myCreditRank = LineOfCreditRank.B;
        myBlackListPersonRank = BlackListPersonRank.S;
        myExceptionPersonList = ExceptionPerson.TRUE;

        run();
        sOut();


    }
        private static void run(){
            // サービスが起動
            myService
                    = new SalesApprovalService
                    (
                            myMoney
                            ,myCreditRank
                            ,myBlackListPersonRank
                            ,myExceptionPersonList
                    );

        }

        private static void sOut(){

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