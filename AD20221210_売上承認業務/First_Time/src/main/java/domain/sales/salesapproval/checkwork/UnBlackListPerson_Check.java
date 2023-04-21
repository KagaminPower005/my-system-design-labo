package domain.sales.salesapproval.checkwork;

import domain.credit.value.blacklist.BlackListPersonRank;
import domain.credit.value.lineofcredit.LineOfCreditRank;

public record UnBlackListPerson_Check(BlackListPersonRank BlackRank, LineOfCreditRank CreditRank)
        implements SalesApprovalChecks {
    public CheckResult check(){
        // 与信枠ランクが'Z'は担当営業の人がどんな人だとしてもNG
        if(this.CreditRank == LineOfCreditRank.Z){ return CheckResult.NG; }

        // 与信枠ランクが'S'の場合は、ブラックリストランクが'N'意外の人はNG
        if(this.CreditRank == LineOfCreditRank.S){
            if(this.BlackRank == BlackListPersonRank.N){ return CheckResult.OK; }
            else                                       { return CheckResult.NG; }
        }

        // 上記以外は意外はブラックリストランクがA以上であればすべてNG
        if(this.BlackRank == BlackListPersonRank.S){ return CheckResult.NG; }
        if(this.BlackRank == BlackListPersonRank.A){ return CheckResult.NG; }
        if(this.CreditRank != null)                { return CheckResult.OK; }

        return CheckResult.UNKNOWN;
    }
}