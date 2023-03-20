package domain.sales.salesapproval.checkwork;

import domain.sales.items.salesamount.SalesAmount;

public record MaximumSalesAmountCheck(SalesAmount SalesAmount)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // xxx円を超えた場合、承認不可
        final String myMoney = "1,000,000"
                                .replace(",","");
        SalesAmount myConditionsMoney = new SalesAmount( Double.parseDouble(myMoney) );
        if(this.SalesAmount.value() <= myConditionsMoney.value())  { return CheckResult.OK; }
        if(this.SalesAmount.value() >  myConditionsMoney.value())  { return CheckResult.NG; }

        return CheckResult.UNKNOWN;
    }
}
