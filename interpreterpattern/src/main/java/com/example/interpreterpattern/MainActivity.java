package com.example.interpreterpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String strExp = "a*b";
        Calculater calculater = new Calculater();
        calculater.build(strExp);
        int compute = calculater.compute(rectangularArea(2,3));
        Log.d("test","compute = "+compute);
    }

    /**
     * 长方形面积
     * @param lenght
     * @param with
     * @return
     */
    public HashMap<String,Integer> rectangularArea(int lenght,int with){
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("a",lenght);
        hashMap.put("b",with);
        return hashMap;
    }
    public HashMap<String,Integer> getValue(String string){
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        char[] chars = string.toCharArray();
        Log.d("test","chars = "+chars);
        for (char aChar : chars) {
            switch (aChar){
                case '+':
                case '-':
                case '*':
                case '/':
                    break;
                default:
                    String s = "321";
                    hashMap.put(String.valueOf(aChar),Integer.valueOf(s));
            }
        }
        return hashMap;
    }
}
