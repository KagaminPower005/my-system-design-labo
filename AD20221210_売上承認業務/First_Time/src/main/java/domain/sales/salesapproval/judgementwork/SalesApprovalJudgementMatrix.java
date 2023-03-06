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
        JudgementMatrix.put("NG△--△--△--△--△--△--△--△--", SalesApproval.NG); //取引下限売上金額チェック
        JudgementMatrix.put("OK△NG△--△--△--△--△--△--△--", SalesApproval.NG); //取引上限売上金額チェック
        JudgementMatrix.put("OK△OK△OK△--△--△--△--△OK△--", SalesApproval.OK); //与信枠ランクSのOKチェック
        JudgementMatrix.put("OK△OK△--△OK△--△--△--△OK△--", SalesApproval.OK); //与信枠ランクAのOKチェック
        JudgementMatrix.put("OK△OK△--△--△OK△--△--△OK△--", SalesApproval.OK); //与信枠ランクBのOKチェック
        JudgementMatrix.put("OK△OK△--△--△--△OK△--△OK△--", SalesApproval.OK); //与信枠ランクCのOKチェック
        JudgementMatrix.put("OK△OK△--△--△--△--△OK△OK△--", SalesApproval.OK); //与信枠ランクZのOKチェック
        JudgementMatrix.put("OK△OK△NG△--△--△--△--△--△--", SalesApproval.NG); //与信枠ランクSのNGチェック
        JudgementMatrix.put("OK△OK△--△NG△--△--△--△--△--", SalesApproval.NG); //与信枠ランクAのNGチェック
        JudgementMatrix.put("OK△OK△--△--△NG△--△--△--△--", SalesApproval.NG); //与信枠ランクBのNGチェック
        JudgementMatrix.put("OK△OK△--△--△--△NG△--△--△--", SalesApproval.NG); //与信枠ランクCのNGチェック
        JudgementMatrix.put("OK△OK△--△--△--△--△NG△--△--", SalesApproval.NG); //与信枠ランクZのNGチェック
        JudgementMatrix.put("OK△OK△--△--△--△--△--△NG△NG", SalesApproval.NG); //非ブラックリストのNGチェック
        JudgementMatrix.put("OK△OK△OK△--△--△--△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック
        JudgementMatrix.put("OK△OK△--△OK△--△--△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック
        JudgementMatrix.put("OK△OK△--△--△OK△--△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック
        JudgementMatrix.put("OK△OK△--△--△--△OK△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック
        JudgementMatrix.put("OK△OK△--△--△--△--△OK△NG△OK", SalesApproval.OK); //例外者リストのOKチェック

        return JudgementMatrix;
    }

    public static Character mySingleWildChar(){ return '-'; }
    public static Character mySeparatorChar(){ return '△'; }

}