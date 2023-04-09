package support;

public record Message(String myMessage) {
    //※↓↓『ドメイン固有の値』のチェック↓↓
    public static final double MAX_VALUE = 2000;
    public static final double MIN_VALUE = 0;
    //※↑↑『ドメイン固有の値』のチェック↑↑

    public Boolean isNotMatch(){
        NotMatch myNotMatch
                = new NotMatch(MAX_VALUE, MIN_VALUE
                                , (double) this.myMessage.length());

        return myNotMatch.isNotMatch();
    }

    public String myMessage(){
        // 『ドメイン固有の値』のチェック
        if(this.isNotMatch()){
            throw new RuntimeException(
                    this.getClass().getSimpleName()
                  + ":最大値または最小値の範囲外の値です。"
            );
        }

        return this.myMessage;
    }
}