package domain.sales.salesapproval.judgementwork;

import domain.sales.salesapproval.checkwork.ApprovalCheckResultsChain;
import domain.support.MapStringKeySearch;
import java.util.Map;
import java.util.Objects;

public class SalesApprovalJudgement {

    //※う～ん、なんだろこれ？中でArrayListかな？まいっか、任せる(;^_^A
    private final ApprovalCheckResultsChain checkResultsChain;

    public SalesApprovalJudgement(
            ApprovalCheckResultsChain checkResultsChain ){
        this.checkResultsChain = checkResultsChain;
    }

    //※『SalesApproval』は『Enum』による『判定結果値』
    public final SalesApproval judge() {
        // パラメータの準備
        Map<String, SalesApproval> myMap = new SalesApprovalJudgementMatrix().make();
        String myMapKey                  = this.checkResultsChain.toString();
        Character mySingleLikeChar       = SalesApprovalJudgementMatrix.mySingleWildChar();
        Integer myStartPosition          = SalesApprovalJudgementMatrix.myStartPosition();

        SalesApproval mySalesApproval
                = (SalesApproval)
                    new MapStringKeySearch(myMap)
                            .startPosition(myStartPosition)
                            .likeGet(myMapKey,mySingleLikeChar);

        //すべてアンマッチの場合は"売上承認.わからない"を設定
        return Objects.requireNonNullElse(mySalesApproval, SalesApproval.UNKNOWN);
    }
}