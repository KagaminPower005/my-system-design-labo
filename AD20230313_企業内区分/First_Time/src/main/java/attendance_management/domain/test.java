package attendance_management.domain;

import java.util.HashMap;
import java.util.Map;

//※あれ？名前違くね!?発注だのにてきとうすぎね？
class SalesApprovalJudgementMatrix {

    private final Map<String, Integer> JudgementMatrix = new HashMap<>();

    public SalesApprovalJudgementMatrix() { }

    public Map<String, Integer> make() {

        //承認業務のポリシーパターン結果の組み合わせをキーに判定するぉ♪
        //※『Enum』作るのめんどいんで今回は『Integer』で(;^_^A
        JudgementMatrix.put("OK△NG△OK△OK△NG", 1);
        JudgementMatrix.put("OK△NG△NG△OK△NG", 0);
        JudgementMatrix.put("NG△NG△NG△NG△OK", 1);
        JudgementMatrix.put("--△OK△--△NG△--", 3);
        JudgementMatrix.put("--△OK△--△OK△NG", 4);
        JudgementMatrix.put("--△OK△--△--△OK", 5);

        return JudgementMatrix;
    }

    public final static Character mySingleWildChar(){ return '-'; }
}

class MapStringKeySearch {

    Map<String,Object> targetMap;

    MapStringKeySearch(Map<String,Object> targetMap){
        this.targetMap = targetMap;
    }

    public Object likeGet(String key,Character singleLikeChar) {
        final String SingleLikeString = singleLikeChar.toString();

        for (String LikeKey : this.targetMap.keySet()) {
            //あいまいチェック♡
            if (LikeKey.contains(SingleLikeString)) {
                //ここであいまい検索するぉ♡♡(※「.」→正規表現で任意の一文字の意)
                final String findKey = LikeKey.replace(SingleLikeString, ".");
                if (key.matches(findKey)) { return targetMap.get(LikeKey); }
            }
        }
        return targetMap.get(key);
    }
}

//ドゥーサ・カクニンをするぉ!!
class Main{
    public static void main(String[] arg) {

        Map myMap = new SalesApprovalJudgementMatrix().make();
        Character mySingleWildChar = SalesApprovalJudgementMatrix.mySingleWildChar();

        System.out.println(
                //※JudgementMatrix.put("--△OK△--△--△OK", 5);
                new MapStringKeySearch(myMap).likeGet("OK△OK△NG△OK△OK",mySingleWildChar)
        );

        System.out.println(
                //※JudgementMatrix.put("--△OK△--△--△OK", 5);→※『NULL』になるケース。
                new MapStringKeySearch(myMap).likeGet("NG△OK△NG△NG△OK",mySingleWildChar)
        );

        System.out.println(
                //※JudgementMatrix.put("--△OK△--△--△OK", 5);
                new MapStringKeySearch(myMap).likeGet("NG△NG△NG△NG△NG",mySingleWildChar)
        );

        System.out.println(
                //※JudgementMatrix.put("--△OK△--△NG△--", 3);
                new MapStringKeySearch(myMap).likeGet("OK△OK△NG△NG△NG",mySingleWildChar)
        );

        System.out.println(
                //※JudgementMatrix.put("--△OK△--△OK△NG", 4);
                new MapStringKeySearch(myMap).likeGet("OK△OK△NG△OK△NG",mySingleWildChar)
        );

        System.out.println(
                //※JudgementMatrix.put("OK△NG△OK△OK△NG", 1);
                new MapStringKeySearch(myMap).likeGet("OK△NG△OK△OK△NG",mySingleWildChar)
        );

        System.out.println(
                //※JudgementMatrix.put("OK△NG△NG△OK△NG", 0);
                new MapStringKeySearch(myMap).likeGet("OK△NG△NG△OK△NG",mySingleWildChar)
        );

        System.out.println(
                //※JudgementMatrix.put("NG△NG△NG△NG△OK", 1);
                new MapStringKeySearch(myMap).likeGet("NG△NG△NG△NG△OK",mySingleWildChar)
        );
    }
}