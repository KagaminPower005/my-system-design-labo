package オトコチェック.domain.model.item.otoko.parts;

import オトコチェック.domain.tool.非該当判断;

public class 年齢 {
    private int 年齢 = 0;
    public static final int MAX_VALUE = 150;
    public static final int MIN_VALUE = 0;

    public 年齢(int age){
        this.年齢 = age;
    }

    public Boolean is非該当(){
        非該当判断 my非該当判断 = new 非該当判断(MAX_VALUE, MIN_VALUE, 年齢);
        return my非該当判断.is非該当();
    }

    public final int value(){
        return this.年齢;
    }
}