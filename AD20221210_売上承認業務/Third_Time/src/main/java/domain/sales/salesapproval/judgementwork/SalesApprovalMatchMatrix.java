package domain.sales.salesapproval.judgementwork;

import java.util.HashMap;
import java.util.Map;

public class SalesApprovalMatchMatrix {

    private final Map<String, SalesApproval> MatchMatrix = new HashMap<>();

    SalesApprovalMatchMatrix(){ }

    final Map<String, SalesApproval> make() {

        //【!!ご注意!!】["--△--△--△--△--△--"]←なんでもアリになって他の仕様に影響を及ぼします。
        //            同様に、排他的条件以外の条件などの場合、
        //            ワイルドカードを含めたキーの値が
        //            重複するパターンがある場合挙動がおかしくなります。
        // ------------------------------------------------------------
        //売上承認のポリシーパターン結果の組み合わせをキーに判定するぉ♪
        //※『SalesApproval』は後から追記可能な『Enum』
        MatchMatrix.put("OK△OK△OK△--△--△--△--△OK△--", SalesApproval.OK); //与信枠ランクSのOKチェック
        MatchMatrix.put("OK△OK△--△OK△--△--△--△OK△--", SalesApproval.OK); //与信枠ランクAのOKチェック
        MatchMatrix.put("OK△OK△--△--△OK△--△--△OK△--", SalesApproval.OK); //与信枠ランクBのOKチェック
        MatchMatrix.put("OK△OK△--△--△--△OK△--△OK△--", SalesApproval.OK); //与信枠ランクCのOKチェック
        MatchMatrix.put("OK△OK△--△--△--△--△OK△OK△--", SalesApproval.OK); //与信枠ランクZのOKチェック
        MatchMatrix.put("OK△OK△OK△--△--△--△--△NG△OK", SalesApproval.GM_CHECK); //例外者リストのGMチェック
        MatchMatrix.put("OK△OK△--△OK△--△--△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック
        MatchMatrix.put("OK△OK△--△--△OK△--△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック
        MatchMatrix.put("OK△OK△--△--△--△OK△--△NG△OK", SalesApproval.OK); //例外者リストのOKチェック
        MatchMatrix.put("OK△OK△--△--△--△--△OK△NG△OK", SalesApproval.OK); //例外者リストのOKチェック

        return MatchMatrix;
    }

    public static Character mySingleWildChar(){ return '-'; }
    public static Character mySeparatorChar(){ return '△'; }

}