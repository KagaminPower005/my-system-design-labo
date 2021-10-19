package オトコチェック.domain.model;

public class OujiSama {

    private String name   = "名無し";
    private int    weight =  -1;
    private int    height =  -1;
    private int    age    =  -1;

    public OujiSama(String name, int weight, int height, int age){
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public String name(){
        return name;
    }

    public int height(){
        return height;
    }

    public int weight(){
        return weight;
    }

    public int age(){
        return age;
    }
}