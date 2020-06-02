package eee.tju.impl;

import org.springframework.stereotype.Service;

//@Service
public class Calculatorimpl /*implements ICalculator*/ {

    //@Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    //@Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    //@Override
    public int mul(int i, int j) {
        //方法的兼容性；
        int result = i * j;
        return result;
    }

    //@Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
