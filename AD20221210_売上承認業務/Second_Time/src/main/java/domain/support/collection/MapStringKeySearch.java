package domain.support.collection;

import java.util.Map;

public class MapStringKeySearch {

    private final Map<String,?> targetMap;
    private String myStartPosition;

    public MapStringKeySearch(Map<String,?> targetMap){
        this.targetMap = targetMap;
    }

    public MapStringKeySearch startPosition(Integer myStartPosition){
        this.myStartPosition = "^" + ".".repeat(myStartPosition -1);
        return this;
    }

    public Object likeGet(String key,Character LikeChar) {
        final String LikeString = LikeChar.toString();

        for (String LikeKey : this.targetMap.keySet().stream().sorted().toList()) {
            //あいまいチェック♡
            if (LikeKey.contains(LikeString)) {
                //ここであいまい検索するぉ♡♡
                // ※「.」→正規表現で"任意の一文字"の意
                // ※「*」→正規表現で"直前の文字が0回以上繰り返す"の意

                final String findKey = LikeKey
                                    .replace(LikeString, ".*")
                                    .replaceFirst(this.myStartPosition,"");

                if (key.matches(findKey)) { return targetMap.get(LikeKey); }
            }
        }
        return targetMap.get(key);
    }
}