package com.cbs.myapplication;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MyEditText extends LinearLayout implements View.OnClickListener {
    private ArrayList<EditText> array = new ArrayList<EditText>(6);
    private EditText mEdt_parking_one;
    private EditText mEdt_parking_two;
    private EditText mEdt_parking_three;
    private EditText mEdt_parking_four;
    private EditText mEdt_parking_five;
    private EditText mEdt_parking_six;
    private TextWatcher tw_pwd;
    private String inputnumber = "";
    private int count = 0;
    private Context context;


    private int focusableIndex = 0;

    private OnEditTextListener onEditTextListener;
    private KeyboardPopupWindow keyboardPopupWindow;

    public KeyboardPopupWindow getKeyboardPopupWindow() {
        return keyboardPopupWindow;
    }

    public OnEditTextListener getOnEditTextListener() {
        return onEditTextListener;
    }

    public void setOnEditTextListener(OnEditTextListener onEditTextListener) {
        this.onEditTextListener = onEditTextListener;
    }



    public interface OnEditTextListener {
        public void inputComplete(int state, String password);
    }

    public MyEditText(Context context) {
        this(context, null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        final View v = LayoutInflater.from(context).inflate(R.layout.cus_edit, this, true);
        this.context = context;
        setView(v);
        setListener(context);

        keyboardPopupWindow = new KeyboardPopupWindow((Activity) context, false, this);
        v.post(new Runnable() {
            @Override
            public void run() {
           keyboardPopupWindow.showPopupWindow(v);
            }
        });
    }

    private void setView(View v) {
        mEdt_parking_one = (EditText) v.findViewById(R.id.mEdt_parking_one);
        mEdt_parking_two = (EditText) v.findViewById(R.id.mEdt_parking_two);
        mEdt_parking_three = (EditText) v.findViewById(R.id.mEdt_parking_three);
        mEdt_parking_four = (EditText) v.findViewById(R.id.mEdt_parking_four);
        mEdt_parking_five = (EditText) v.findViewById(R.id.mEdt_parking_five);
        mEdt_parking_six = (EditText) v.findViewById(R.id.mEdt_parking_six);
        mEdt_parking_two.setFocusable(false);
        mEdt_parking_five.setFocusable(false);
        mEdt_parking_four.setFocusable(false);
        mEdt_parking_three.setFocusable(false);
        mEdt_parking_six.setFocusable(false);
        array.add(mEdt_parking_one);
        array.add(mEdt_parking_two);
        array.add(mEdt_parking_three);
        array.add(mEdt_parking_four);
        array.add(mEdt_parking_five);
        array.add(mEdt_parking_six);
    }

    private void setFocusToView(int target) {
        for (int i = 0; i < array.size(); i++) {
            array.get(i).setFocusable(true);
            array.get(i).setFocusableInTouchMode(true);
            if (i != target) {
                array.get(i).setFocusable(false);
            }
        }
    }

    public void setEditText(String text) {
        if (focusableIndex < array.size()) {
            array.get(focusableIndex).setText(text);
        }
    }

    public void delLastText() {
        focusableIndex--;
        if (focusableIndex == -1) {
            focusableIndex = 0;
            return;
        }
        if ((focusableIndex + 1) < array.size()) {
            array.get(focusableIndex + 1).setFocusable(false);
        }
        array.get(focusableIndex).getEditableText().clear();
        array.get(focusableIndex).setFocusable(true);
        array.get(focusableIndex).setFocusableInTouchMode(true);
        array.get(focusableIndex).requestFocus();
    }

    private void setListener(Context context) {
        editPwdWatcher(context);
        //设置点击监听
        mEdt_parking_one.setOnClickListener(this);
        mEdt_parking_two.setOnClickListener(this);
        mEdt_parking_three.setOnClickListener(this);
        mEdt_parking_four.setOnClickListener(this);
        mEdt_parking_five.setOnClickListener(this);
        mEdt_parking_six.setOnClickListener(this);
        //设置字符改变监听
        mEdt_parking_one.addTextChangedListener(tw_pwd);
        mEdt_parking_two.addTextChangedListener(tw_pwd);
        mEdt_parking_three.addTextChangedListener(tw_pwd);
        mEdt_parking_four.addTextChangedListener(tw_pwd);
        mEdt_parking_five.addTextChangedListener(tw_pwd);
        mEdt_parking_six.addTextChangedListener(tw_pwd);

    }

    /**
     * 字符改变监听
     *
     * @param context
     */
    private void editPwdWatcher(final Context context) {
        tw_pwd = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    if (mEdt_parking_one.isFocusable()) {
                        focusableIndex = 1;
                        mEdt_parking_two.setFocusable(true);
                        mEdt_parking_two.setFocusableInTouchMode(true);
                    } else if (mEdt_parking_two.isFocusable()) {
                        focusableIndex = 2;
                        mEdt_parking_three.setFocusable(true);
                        mEdt_parking_three.setFocusableInTouchMode(true);
                    } else if (mEdt_parking_three.isFocusable()) {
                        focusableIndex = 3;
                        mEdt_parking_four.setFocusable(true);
                        mEdt_parking_four.setFocusableInTouchMode(true);
                    } else if (mEdt_parking_four.isFocusable()) {
                        focusableIndex = 4;
                        mEdt_parking_five.setFocusable(true);
                        mEdt_parking_five.setFocusableInTouchMode(true);
                    } else if (mEdt_parking_five.isFocusable()) {
                        focusableIndex = 5;
                        mEdt_parking_six.setFocusable(true);
                        mEdt_parking_six.setFocusableInTouchMode(true);
                    } else {
                        focusableIndex = 6;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 1) {
                    if (mEdt_parking_one.isFocused()) {
                        mEdt_parking_one.setFocusable(false);
                        mEdt_parking_two.requestFocus();
                    } else if (mEdt_parking_two.isFocused()) {
                        mEdt_parking_two.setFocusable(false);
                        mEdt_parking_three.requestFocus();
                    } else if (mEdt_parking_three.isFocused()) {
                        mEdt_parking_three.setFocusable(false);
                        mEdt_parking_four.requestFocus();
                    } else if (mEdt_parking_four.isFocused()) {
                        mEdt_parking_four.setFocusable(false);
                        mEdt_parking_five.requestFocus();
                    } else if (mEdt_parking_five.isFocused()) {
                        mEdt_parking_five.setFocusable(false);
                        mEdt_parking_six.requestFocus();
                    } else if (mEdt_parking_six.isFocused()) {
                        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(mEdt_parking_six.getWindowToken(), 0);
                        inputnumber = getEditNumber();
                        Log.i("MainActivity", inputnumber.length() + "");
                        if (onEditTextListener != null) {
                            onEditTextListener.inputComplete(1, inputnumber);
                        }
                    }
                }
            }
        };

    }


    public String getEditNumber() {
        String number = mEdt_parking_one.getText().toString();
        number += mEdt_parking_two.getText().toString();
        number += mEdt_parking_three.getText().toString();
        number += mEdt_parking_four.getText().toString();
        number += mEdt_parking_five.getText().toString();
        number += mEdt_parking_six.getText().toString();
        return number;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mEdt_parking_one:
                keyboardPopupWindow.showPopupWindow(v);
                break;
            case R.id.mEdt_parking_two:
                keyboardPopupWindow.showPopupWindow(v);
                break;
            case R.id.mEdt_parking_three:
                keyboardPopupWindow.showPopupWindow(v);
                break;
            case R.id.mEdt_parking_four:
                keyboardPopupWindow.showPopupWindow(v);
                break;
            case R.id.mEdt_parking_five:
                keyboardPopupWindow.showPopupWindow(v);
                break;
            case R.id.mEdt_parking_six:
                keyboardPopupWindow.showPopupWindow(v);
                break;
            default:
                break;
        }
    }
}