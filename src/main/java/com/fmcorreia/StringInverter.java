package com.fmcorreia;

public class StringInverter implements StringTransformer {


    @Override
    public void execute(StringDrink drink) {
        StringBuilder result = new StringBuilder(drink.getText());
        String res = (result.reverse()).toString();
        drink.setText(res);
    }
}
