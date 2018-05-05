package me.chenjr.eventhandling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ListenerActivity extends AppCompatActivity implements OnClickListener{

    EditText show;
    Button btn_inner;
    Button btn_outer;
    Button btn_inner_anonymous;
    Button btn_activity;
    /*Button btn_bind;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        /*绑定各个view*/
        show = findViewById(R.id.listener_tv);
        btn_inner = findViewById(R.id.listener_btn_inner);
        btn_outer = findViewById(R.id.listener_btn_outer);
        btn_inner_anonymous = findViewById(R.id.listener_btn_inner_anonymous);
        btn_activity = findViewById(R.id.listener_btn_activity);

        Log.d("BTN_OUTPUT", "onCreate:btn_inner "+btn_inner);
        Log.d("BTN_OUTPUT", "onCreate:findViewById(R.id.listener_btn_inner) "+
                (Button)findViewById(R.id.listener_btn_inner));
        /*设置内部类为监听器件*/
        btn_inner.setOnClickListener(new InnerListener());


        /*设置匿名内部类为按键监听器*/
        btn_inner_anonymous.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                show.setText(R.string.Listener_btn_inner_anonymous);
            }
        });
        /*设置外部类未监听器*/
        btn_outer.setOnClickListener(new OuterClassListener(show));

        /*设置activity自身为监听器*/
        btn_activity.setOnClickListener(this);



    }



    /*实现了OnClickListener接口的内部类*/
    class InnerListener implements OnClickListener{

        @Override
        public void onClick(View view) {
            show.setText(R.string.Listener_btn_inner);
        }
    }

    /*activity本身实现OnClickListener接口,重写onClick()方法作为监听器*/
    @Override
    public void onClick(View v){
        show.setText(R.string.Listener_btn_activity);

    }
    /*绑定到标签的监听器*/
    public void clickHandler(View view) {
        show.setText(R.string.Listener_btn_bind);
    }


}
