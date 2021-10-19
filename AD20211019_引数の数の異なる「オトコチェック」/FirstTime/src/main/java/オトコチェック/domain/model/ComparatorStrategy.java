package オトコチェック.domain.model;

//比較インターフェース
public interface ComparatorStrategy {
    String compare(OujiSama o1 , OujiSama o2);
}