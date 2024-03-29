package user;

import application.approval.salesapproval.SalesApprovalService;
import domain.credit.blacklist.BlackListPersonRank;
import domain.credit.exceptionlist.ExceptionPerson;
import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.value.salesamount.SalesAmount;

public class ApplicationOperator {

    private static SalesAmount         myMoney;
    private static LineOfCreditRank    myCreditRank;
    private static BlackListPersonRank myBlackListPersonRank;
    private static ExceptionPerson     myExceptionPersonList;

    private static SalesApprovalService myService;

    public static void main(String[] args) {
        // ～端末でパラメータを入力～
        System.out.println( "B社／ハザマ クロオさん:タラバガニ一式×６セット" );
        myMoney = new SalesAmount(900000);

        // ～DB呼び出し～データ取得～
        myCreditRank = LineOfCreditRank.valueOf("S");
        myBlackListPersonRank = BlackListPersonRank.valueOf("S");
        myExceptionPersonList = ExceptionPerson.valueOf("TRUE");

        run();
        sOut();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        // ～端末でパラメータを入力～
        System.out.println( "B社／ハザマ クロオさん:タラバガニ一式×６セット" );
        myMoney = new SalesAmount(900000);

        // ～DB呼び出し～データ取得～
        myCreditRank = LineOfCreditRank.A;
        myBlackListPersonRank = BlackListPersonRank.D;
        myExceptionPersonList = ExceptionPerson.TRUE;

        run();
        sOut();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        // ～端末でパラメータを入力～
        System.out.println( "B社／ハザマ クロオさん:タラバガニ一式×６セット" );
        myMoney = new SalesAmount(900000);

        // ～DB呼び出し～データ取得～
        myCreditRank = LineOfCreditRank.B;
        myBlackListPersonRank = BlackListPersonRank.A;
        myExceptionPersonList = ExceptionPerson.TRUE;

        run();
        sOut();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        // ～端末でパラメータを入力～
        System.out.println( "B社／ハザマ クロオさん:タラバガニ一式×６セット" );
        myMoney = new SalesAmount(900000);

        // ～DB呼び出し～データ取得～
        myCreditRank = LineOfCreditRank.C;
        myBlackListPersonRank = BlackListPersonRank.B;
        myExceptionPersonList = ExceptionPerson.TRUE;

        run();
        sOut();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        // ～端末でパラメータを入力～
        System.out.println( "B社／ハザマ クロオさん:タラバガニ一式×６セット" );
        myMoney = new SalesAmount(900000);

        // ～DB呼び出し～データ取得～
        myCreditRank = LineOfCreditRank.D;
        myBlackListPersonRank = BlackListPersonRank.A;
        myExceptionPersonList = ExceptionPerson.TRUE;

        run();
        sOut();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        // ～端末でパラメータを入力～
        System.out.println( "B社／ハザマ クロオさん:タラバガニ一式×６セット" );
        myMoney = new SalesAmount(900000);

        // ～DB呼び出し～データ取得～
        myCreditRank = LineOfCreditRank.Z;
        myBlackListPersonRank = BlackListPersonRank.C;
        myExceptionPersonList = ExceptionPerson.TRUE;

        run();
        sOut();

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        // ～端末でパラメータを入力～
        System.out.println( "A社／モリヤマ メーテルさん:ビックリマンチョコ×２個" );
        myMoney = new SalesAmount(100);

        // ～DB呼び出し～データ取得～
        myCreditRank = LineOfCreditRank.S;
        myBlackListPersonRank = BlackListPersonRank.N;
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
                + myMoney.formattedValue()
                + SalesAmount.CURRENCY.toJapanese());

        System.out.println( "与信枠ランク:"
                + myCreditRank.name() );

        System.out.println( "ブラックリスト者ランク:"
                + myBlackListPersonRank.name() );

        System.out.println( "例外者リスト:"
                + myExceptionPersonList.name() );

        System.out.println( myService.run().myMessage() );
    }
}