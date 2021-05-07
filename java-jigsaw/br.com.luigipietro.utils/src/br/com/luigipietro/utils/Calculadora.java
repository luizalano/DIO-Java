package br.com.luigipietro.utils;

import br.com.luigipietro.utils.interno.DiminiuHeper;
import br.com.luigipietro.utils.interno.DivideHelper;
import br.com.luigipietro.utils.interno.MultiHelper;
import br.com.luigipietro.utils.interno.SomaHelper;

public class Calculadora {

    private SomaHelper somaHelper;
    private DiminiuHeper diminuiHelper;
    private MultiHelper multiHelper;
    private DivideHelper divideHelper;

    public Calculadora(){
        somaHelper = new SomaHelper();
        diminuiHelper = new DiminiuHeper();
        multiHelper = new MultiHelper();
        divideHelper = new DivideHelper();
    }

    public int soma (int a, int b){
        return somaHelper.execute(a,b);
    }

    public int diminui (int a, int b){
        return diminuiHelper.execute(a,b);
    }

    public int multiplica (int a, int b){
        return multiHelper.execute(a,b);
    }

    public int divide (int a, int b) {
        return divideHelper.execute(a,b);
    }
}
