package オトコチェック.business.Adapter;

//比較インターフェース
public interface ComparatorStrategy {
    String compare(比較対象殿方 o1 , 比較対象殿方 o2);
}