package domain.sales.salesapproval.checkwork;

import domain.credit.exceptionlist.ExceptionPersonList;
import domain.credit.lineofcredit.LineOfCreditRank;

public record ExceptionPersonList_Check(ExceptionPersonList ExceptionRank, LineOfCreditRank CreditRank)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // 与信枠ランクが'Z'は担当営業の人がどんな人だとしてもNG
        if(this.CreditRank == LineOfCreditRank.Z){ return CheckResult.NG; }

        // 上記以外は意外は例外リストがTRUEであればOK
        if(this.ExceptionRank == ExceptionPersonList.TRUE)  { return CheckResult.OK; }

        // 例外リストがFALSEであればNG
        if(this.ExceptionRank == ExceptionPersonList.FALSE)  { return CheckResult.NG; }

        // (※念のため、例外リストランクがUNKOWNであればUNKOWNとしておく。)
        if(this.ExceptionRank == ExceptionPersonList.UNKOWN){ return CheckResult.UNKNOWN; }

        return CheckResult.UNKNOWN;
    }
}