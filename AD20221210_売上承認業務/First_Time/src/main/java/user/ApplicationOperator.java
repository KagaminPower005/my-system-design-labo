package user;

import application.approval.salesapproval.SalesApprovalService;
import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.items.salesamount.SalesAmount;

public class ApplicationOperator {

    public static void main(String[] args){
        // 端末でパラメータを入力
        SalesAmount myMoney = new SalesAmount(180000);
        LineOfCreditRank myRank = LineOfCreditRank.D;

        // サービスが起動
        SalesApprovalService myService
                = new SalesApprovalService( myMoney ,myRank );

        // 結果をコンソールに出力
        System.out.println( "売上金額   :" + String.format("%,d",myMoney.value().intValue())  + "円" );
        System.out.println( "与信枠ランク:" + myRank.name() );
        System.out.println( myService.run().myMessage() );
    }
}