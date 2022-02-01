package lt.codeacademy.exercise.menu;

import lt.codeacademy.exercise.bank.data.LumiData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class LumiForm {
    private ArrayList<String> headers = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();;
    private ArrayList<Date> date = new ArrayList<>();;
    private ArrayList<String> iban = new ArrayList<>();;
    private ArrayList<Float> amount = new ArrayList<>();;

    LumiForm(){

        for (int i = 0; i < LumiData.MOCK_DATA.length; i++) {
            if(i == 0){
                Collections.addAll(this.headers,LumiData.MOCK_DATA[0]);
            }else {
                this.name.add(LumiData.MOCK_DATA[i][0]);
                this.date.add(parseDate(LumiData.MOCK_DATA[i][1]));
                this.iban.add(LumiData.MOCK_DATA[i][2]);
                this.amount.add(parseAmount(LumiData.MOCK_DATA[i][3]));
            }

        }
    }



    public float parseAmount(String amount){
        amount = amount.replace(',','.');
        return Float.parseFloat(amount);
    }
}
