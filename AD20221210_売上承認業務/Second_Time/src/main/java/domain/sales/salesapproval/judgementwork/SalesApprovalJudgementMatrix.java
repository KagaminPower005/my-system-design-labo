package domain.sales.salesapproval.judgementwork;

import java.util.HashMap;
import java.util.Map;

public class SalesApprovalJudgementMatrix {

    private final Map<String, SalesApproval> JudgementMatrix = new HashMap<>();

    public SalesApprovalJudgementMatrix(){ }

    final Map<String, SalesApproval> make() {

        //【!!ご注意!!】["--△--△--△--△--△--"]←なんでもアリになって他の仕様に影響を及ぼします。
        //            同様に、排他的条件以外の条件などの場合、
        //            ワイルドカードを含めたキーの値が
        //            重複するパターンがある場合挙動がおかしくなります。
        // ------------------------------------------------------------
        //売上承認のポリシーパターン結果の組み合わせをキーに判定するぉ♪
        //※『SalesApproval』は後から追記可能な『Enum』
        JudgementMatrix.put("001:NG△--"                     , SalesApproval.NG); //取引下限売上金額のNGチェック
        JudgementMatrix.put("002:OK△NG△--△--△--△--△--△--△--", SalesApproval.NG); //取引上限売上金額のNGチェック
        JudgementMatrix.put("003:OK△OK△OK△--△--△--△--△OK△--", SalesApproval.OK); //与信枠ランクSのOKチェック
        JudgementMatrix.put("004:OK△OK△--△OK△--△--△--△OK△--", SalesApproval.OK); //与信枠ランクAのOKチェック
        JudgementMatrix.put("005:OK△OK△--△--△OK△--△--△OK△--", SalesApproval.OK); //与信枠ランクBのOKチェック
        JudgementMatrix.put("006:OK△OK△--△--△--△OK△--△OK△--", SalesApproval.OK); //与信枠ランクCのOKチェック
        JudgementMatrix.put("007:OK△OK△--△--△--△--△OK△OK△--", SalesApproval.OK); //与信枠ランクZのOKチェック
        JudgementMatrix.put("008:OK△OK△NG△--△--△--△--△--△--", SalesApproval.NG); //与信枠ランクSのNGチェック
        JudgementMatrix.put("009:OK△OK△--△NG△--△--△--△--△--", SalesApproval.NG); //与信枠ランクAのNGチェック
        JudgementMatrix.put("010:OK△OK△--△--△NG△--△--△--△--", SalesApproval.NG); //与信枠ランクBのNGチェック
        JudgementMatrix.put("011:OK△OK△--△--△--△NG△--△--△--", SalesApproval.NG); //与信枠ランクCのNGチェック
        JudgementMatrix.put("012:OK△OK△--△--△--△--△NG△--△--", SalesApproval.NG); //与信枠ランクZのNGチェック
        JudgementMatrix.put("013:OK△OK△--△--△--△--△--△NG△NG", SalesApproval.NG); //非ブラックリストのNGチェック
        JudgementMatrix.put("014:OK△OK△--△--△--△--△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック

        return JudgementMatrix;
    }

    public static Character mySingleWildChar(){ return '-'; }
    public static Character mySeparatorChar(){ return '△'; }

}