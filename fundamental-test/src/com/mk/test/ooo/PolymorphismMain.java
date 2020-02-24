package com.mk.test.ooo;

import java.io.IOException;

class parent {
    public void methd1(){

    }
    int methd2(){
        return 1;
    }
    public int methd3() throws Exception {
        return 1;
    }


}
public class PolymorphismMain extends  parent{
    public void methd1(){

    }
    int methd2(){
        return 1;
    }
    public int methd3() throws IOException {
        return 1;
    }

}
