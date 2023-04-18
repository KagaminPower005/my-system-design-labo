package domain.support.value;

public class NotMatch {
    private final Double _max;
    private final Double _minimum;
    private final Double _value;

    public NotMatch(Double _max, Double _minimum, Double _value){
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