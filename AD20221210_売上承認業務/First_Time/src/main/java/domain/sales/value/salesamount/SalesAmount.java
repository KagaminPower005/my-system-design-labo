package domain.sales.value.salesamount;

import domain.support.value.Currency;
import domain.support.value.NotMatch;

public record SalesAmount(double SalesAmount) {
    //※↓↓『ドメイン固有の値』のチェック↓↓
    public static final double MAX_VALUE = 60000000;
    public static final double MIN_VALUE = 0;
    public static final Currency CURRENCY = Currency.Yen;
    //※↑↑『ドメイン固有の値』のチェック↑↑

    private void errorCheck(){
        // 『ドメイン固有の値』のチェック
        if(this.isNotMatch()){
            throw new RuntimeException(
                    this.getClass().getSimpleName()
                            + ":最大値または最小値の範囲外の値です。"
            );
        }
    }

    public Boolean isNotMatch(){
        NotMatch myNotMatch
                = new NotMatch(MAX_VALUE, MIN_VALUE, this.SalesAmount());

        return myNotMatch.isNotMatch();
    }

    public Double value() {
        // 『ドメイン固有の値』のチェック
        this.errorCheck();

        return this.SalesAmount;
    }

    public String formattedValue(){
        // 『ドメイン固有の値』のチェック
        this.errorCheck();

        return String.format("%,d",this.value().intValue());
    }
}