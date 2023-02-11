package domain.sales.salesapproval.judgementwork;

import java.util.HashMap;
import java.util.Map;

public class SalesApprovalJudgementMatrix {

    private final Map<String, SalesApproval> JudgementMatrix = new HashMap<>();

    public SalesApprovalJudgementMatrix(){ }

    final Map<String, SalesApproval> make() {

        //【!!ご注意!!】["--△--△--△--△--△--"]←なんでもアリになって他の仕様に影響を及ぼします。
        //売上承認のポリシーパターン結果の組み合わせをキーに判定するぉ♪
        //※『SalesApproval』は後から追記可能な『Enum』
        JudgementMatrix.put("NG△--△--△--△--△--", SalesApproval.NG); //取引下限売上金額チェック
        JudgementMatrix.put("OK△NG△--△--△--△--", SalesApproval.NG); //取引上限売上金額チェック
        JudgementMatrix.put("OK△OK△OK△--△--△--", SalesApproval.OK); //与信枠ランクSのチェック
        JudgementMatrix.put("OK△OK△--△OK△--△--", SalesApproval.OK); //与信枠ランクAのチェック
        JudgementMatrix.put("OK△OK△--△--△OK△--", SalesApproval.OK); //与信枠ランクBのチェック
        JudgementMatrix.put("OK△OK△--△--△--△OK", SalesApproval.OK); //与信枠ランクZのチェック
        JudgementMatrix.put("OK△OK△--△--△--△--", SalesApproval.NG); //与信枠ランクすべて非該当

        return JudgementMatrix;
    }

    public static Character mySingleWildChar(){ return '-'; }
    public static Character mySeparatorChar(){ return '△'; }

}
