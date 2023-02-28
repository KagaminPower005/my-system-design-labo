package domain.sales.salesapproval.checkwork;

import domain.credit.lineofcredit.LineOfCreditRank;

public record LineOfCreditRank_S_Check(LineOfCreditRank Rank)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // 与信枠ランクが'S'の場合、すべて承認可
        if(this.Rank == LineOfCreditRank.S) { return CheckResult.OK; }

        return CheckResult.IGNORE;
    }
}