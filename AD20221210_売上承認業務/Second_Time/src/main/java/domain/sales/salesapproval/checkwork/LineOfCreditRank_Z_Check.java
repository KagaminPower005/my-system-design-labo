package domain.sales.salesapproval.checkwork;

import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.items.salesamount.SalesAmount;

public record LineOfCreditRank_Z_Check(SalesAmount Amount, LineOfCreditRank Rank)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // 与信枠ランクが'Z'のみ対応
        if(this.Rank != LineOfCreditRank.Z){ return CheckResult.MISS_MATCH; }

        // ランクZの顧客は、0円を超えるご購入は不可
        final String myMoney = "0";
//                .replace(",","");
        SalesAmount myConditionsMoney = new SalesAmount( Double.parseDouble(myMoney) );
        if(this.Amount.value() <= myConditionsMoney.value()) { return CheckResult.OK; }
        if(this.Amount.value() >  myConditionsMoney.value()) { return CheckResult.NG; }

        return CheckResult.UNKNOWN;
    }
}