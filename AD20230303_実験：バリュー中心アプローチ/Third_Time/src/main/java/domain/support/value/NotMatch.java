package domain.support.value;

public class NotMatch {
    private final int _max;
    private final int _minimum;
    private final int _value;

    public NotMatch(Integer _max, Integer _minimum, Integer _value){
        this._max = _max;
        this._minimum = _minimum;
        this._value = _value;
    }

    public Boolean isNotMatch(){
        if( this._value >= _max)     { return true; }
        if( this._value <  _minimum) { return true; }
        else                         { return false; }
    }
}