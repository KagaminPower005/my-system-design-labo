package domain.sales.salesapproval.checkwork;

import domain.sales.value.salesamount.SalesAmount;

public record MinimumSalesAmountCheck(SalesAmount SalesAmount)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // xxx円以下は承認不可
        final String myMoney = "100";
//                            .replace(",","");
        SalesAmount myConditionsMoney = new SalesAmount( Double.parseDouble(myMoney) );
        if(this.SalesAmount.value() <= myConditionsMoney.value()) { return CheckResult.NG; }
        if(this.SalesAmount.value() >  myConditionsMoney.value()) { return CheckResult.OK; }

        return CheckResult.UNKNOWN;
    }
}