package support;

import java.util.Map;

public class MapStringKeySearch {

    Map<String,Object> targetMap;

    public MapStringKeySearch(Map<String,Object> targetMap){
        this.targetMap = targetMap;
    }

    public Object likeGet(String key,Character LikeChar) {
        final String LikeString = LikeChar.toString();

        for (String LikeKey : this.targetMap.keySet()) {
            //あいまいチェック♡
            if (LikeKey.contains(LikeString)) {
                //ここであいまい検索するぉ♡♡
                // ※「.」→正規表現で"任意の一文字"の意
                // ※「*」→正規表現で"直前の文字が0回以上繰り返す"の意

                final String findKey = LikeKey
                                    .replace(LikeString, ".*")
                                    .replaceFirst("^....","");

                if (key.matches(findKey)) { return targetMap.get(LikeKey); }
            }
        }
        return targetMap.get(key);
    }
}