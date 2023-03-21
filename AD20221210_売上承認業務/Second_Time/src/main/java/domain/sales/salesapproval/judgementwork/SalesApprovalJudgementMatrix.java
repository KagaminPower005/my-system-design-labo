package domain.sales.salesapproval.judgementwork;

import java.util.*;

public class SalesApprovalJudgementMatrix {

    private final Map<String, SalesApproval> JudgementMatrix
            = Collections.unmodifiableSortedMap(new SortedMap<>() {
        @Override
        public Comparator<? super String> comparator() {
            return null;
        }

        @Override
        public SortedMap<String, SalesApproval> subMap(String fromKey, String toKey) {
            return null;
        }

        @Override
        public SortedMap<String, SalesApproval> headMap(String toKey) {
            return null;
        }

        @Override
        public SortedMap<String, SalesApproval> tailMap(String fromKey) {
            return null;
        }

        @Override
        public String firstKey() {
            return "000:";
        }

        @Override
        public String lastKey() {
            return "999:";
        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<SalesApproval> values() {
            return null;
        }

        @Override
        public Set<Entry<String, SalesApproval>> entrySet() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public SalesApproval get(Object key) {
            return null;
        }

        @Override
        public SalesApproval put(String key, SalesApproval value) {
            return null;
        }

        @Override
        public SalesApproval remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ? extends SalesApproval> m) {

        }

        @Override
        public void clear() {

        }
    });

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

    public static Integer myStartPosition(){ return 5; }

}