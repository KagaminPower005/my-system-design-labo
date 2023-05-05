package domain.sales.salesapproval.checkwork;

import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.value.salesamount.SalesAmount;

public record LineOfCreditRank_A_Check(SalesAmount Amount, LineOfCreditRank Rank)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // 与信枠ランクが'A'のみ対応
        if(this.Rank != LineOfCreditRank.A){ return CheckResult.MISS_MATCH; }

        // ランクAの顧客は、xxx万円を超えるご購入は不可
        final String myMoney = "500,000"
                            .replace(",","");
        SalesAmount myConditionsMoney = new SalesAmount( Double.parseDouble(myMoney) );
        if(this.Amount.value() <= myConditionsMoney.value()) { return CheckResult.OK; }
        if(this.Amount.value() >  myConditionsMoney.value()) { return CheckResult.NG; }

        return CheckResult.UNKNOWN;
    }
}