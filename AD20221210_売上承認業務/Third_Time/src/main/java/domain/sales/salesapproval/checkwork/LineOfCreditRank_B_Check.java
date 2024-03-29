package domain.sales.salesapproval.checkwork;

import domain.credit.lineofcredit.LineOfCreditRank;
import domain.sales.value.salesamount.SalesAmount;

public record LineOfCreditRank_B_Check(SalesAmount Amount, LineOfCreditRank Rank)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // 与信枠ランクが'B'のみ対応
        if(this.Rank != LineOfCreditRank.B){ return CheckResult.MISS_MATCH; }

        // ランクBの顧客は、xxx万円を超えるご購入は不可
        final String myMoney = "350,000"
                            .replace(",","");
        SalesAmount myConditionsMoney = new SalesAmount( Double.parseDouble(myMoney) );
        if(this.Amount.value() <= myConditionsMoney.value()) { return CheckResult.OK; }
        if(this.Amount.value() >  myConditionsMoney.value()) { return CheckResult.NG; }

        return CheckResult.UNKNOWN;
    }
}