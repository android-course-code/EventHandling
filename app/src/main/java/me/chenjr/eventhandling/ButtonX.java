package me.chenjr.eventhandling;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;


public class ButtonX extends android.support.v7.widget.AppCompatButton {

    public ButtonX(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*重写触摸事件回调, 便于观察*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.i("{TouchEvent}", "onTouchEvent!"+event);
        this.setText("YES!");
        return true;
    }
}


