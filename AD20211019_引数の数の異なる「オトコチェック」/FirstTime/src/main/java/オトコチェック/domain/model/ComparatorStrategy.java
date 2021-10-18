package オトコチェック.domain.model;

//比較インターフェース
public interface ComparatorStrategy {
    public String compare(Oujisama o1 , Oujisama o2);
}