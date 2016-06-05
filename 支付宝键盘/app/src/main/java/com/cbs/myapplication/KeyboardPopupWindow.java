package com.cbs.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import java.util.Random;

/**
 * Created by Administrator on 2015/9/1.
 */

public class KeyboardPopupWindow extends PopupWindow implements View.OnClickListener {
    private View conentView;

    private MyEditText editText;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btn_conf;
    private ImageButton btn_del;

    private boolean isRandom;

    private OnKeyboardListener onKeyboardListener;

    public  interface  OnKeyboardListener{
        public void onConf(String confNum);
    }

    public void setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        this.onKeyboardListener = onKeyboardListener;
    }

    public KeyboardPopupWindow(final Activity context, boolean random, MyEditText editText) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.keyboard, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        this.setContentView(conentView);
        this.setWidth(w);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        ColorDrawable dw = new ColorDrawable(0000000000);
        this.setBackgroundDrawable(dw);
        this.setAnimationStyle(R.style.popupAnimation);

        this.isRandom = random;
        this.editText = editText;
        findView(conentView);
    }


    private void findView(View keyboardView) {

        btn0 = (Button) keyboardView.findViewById(R.id.keyboard_btn0);
        btn1 = (Button) keyboardView.findViewById(R.id.keyboard_btn1);
        btn2 = (Button) keyboardView.findViewById(R.id.keyboard_btn2);
        btn3 = (Button) keyboardView.findViewById(R.id.keyboard_btn3);
        btn4 = (Button) keyboardView.findViewById(R.id.keyboard_btn4);
        btn5 = (Button) keyboardView.findViewById(R.id.keyboard_btn5);
        btn6 = (Button) keyboardView.findViewById(R.id.keyboard_btn6);
        btn7 = (Button) keyboardView.findViewById(R.id.keyboard_btn7);
        btn8 = (Button) keyboardView.findViewById(R.id.keyboard_btn8);
        btn9 = (Button) keyboardView.findViewById(R.id.keyboard_btn9);
        btn_del = (ImageButton) keyboardView.findViewById(R.id.keyboard_btn_del);
//        btn_clear = (Button) keyboardView.findViewById(R.id.keyboard_btn_clear);
        btn_conf = (Button) keyboardView.findViewById(R.id.keyboard_btn_conf);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.delLastText();
            }
        });
        btn_conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(null!=  onKeyboardListener){
                  onKeyboardListener.onConf(editText.getEditNumber());
              }
            }
        });

    }


    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            if(isRandom) {
                updateKeyBoard();
            }
            this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
        } else {
            this.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        Button button = (Button)view;
                editText.setEditText(button.getText().toString());
    }


    private void updateKeyBoard() {
        int[] randomNum = getRandomNum();
        btn0.setText(randomNum[0] + "");
        btn1.setText(randomNum[1] + "");
        btn2.setText(randomNum[2] + "");
        btn3.setText(randomNum[3] + "");
        btn4.setText(randomNum[4] + "");
        btn5.setText(randomNum[5] + "");
        btn6.setText(randomNum[6] + "");
        btn7.setText(randomNum[7] + "");
        btn8.setText(randomNum[8] + "");
        btn9.setText(randomNum[9] + "");
    }

    private int[] getRandomNum() {
        Random random = new Random();
        int[] data = new int[10];
        boolean b;
        boolean b2 = false;
        boolean b3 = true;
        int x;
        for (int i = 0; i < 10; i++) {
            b = true;
            while (b) {
                x = random.nextInt(10);
                if (x == 0 && b3) {
                    b3 = false;
                    b = false;
                }
                for (int y : data) {
                    if (x == y) {
                        b2 = false;
                        break;
                    } else {
                        b2 = true;
                    }
                }
                if (b2) {
                    data[i] = x;
                    b = false;
                    break;
                }
            }

        }
        return data;
    }
}
