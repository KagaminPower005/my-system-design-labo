package domain.sales.salesapproval.checkwork;

import java.util.ArrayList;
import java.util.List;
import domain.sales.salesapproval.judgementwork.SalesApprovalMatchMatrix;

public class ApprovalCheckResultsChain {
    private final List<CheckResult>
            myList = new ArrayList<>();

    public void add(CheckResult myCheckResult){
        myList.add(myCheckResult);
    }

    private StringBuilder execute() {
        final Character myResultsSeparator
                = SalesApprovalMatchMatrix.mySeparatorChar();
        StringBuilder myCheckResultsChain = new StringBuilder();
        for (CheckResult checkResult : myList) {
            myCheckResultsChain
                    .append(checkResult.name())
                    .append(myResultsSeparator);
        }

        return myCheckResultsChain
                .replace(myCheckResultsChain.length() - 1
                        ,myCheckResultsChain.length()
                        ,"");
    }

    @Override
    public final String toString() {
        return this.execute().toString();
    }
}