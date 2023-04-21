package domain.support.value;

public enum Currency {
    Yen("円"),
    ;

    private final String Japanese;
    Currency(String Japanese){ this.Japanese = Japanese; }

    public String toJapanese(){ return Japanese; }
}