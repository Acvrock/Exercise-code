package com.cbs.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity implements KeyboardPopupWindow.OnKeyboardListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyEditText myEditText = (MyEditText) findViewById(R.id.mEdt_num);
        myEditText.getKeyboardPopupWindow().setOnKeyboardListener(this);
    }


    @Override
    public void onConf(String confNum) {
        Toast.makeText(MainActivity.this, "is " + confNum, Toast.LENGTH_SHORT).show();
    }
}
