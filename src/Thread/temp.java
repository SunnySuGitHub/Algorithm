package Thread;

import java.util.*;

/**
 * Description:Algorithm
 * Created by Administrator on 2019/3/6
 */
public abstract class temp {
    private void doJob(){
        System.out.println("doJob");
    }
    public temp(){//could have a constructor method

    }
    protected/*public*/ abstract void dodo();//couldn't have a method body
}

class son extends temp{

    @Override
    public void dodo(){

    }
}
