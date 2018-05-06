package me.chenjr.eventhandling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*四个按键的回调方法,用于跳转到四个activity*/
    public void ToListener(View view) {
        startActivity(new Intent(this,ListenerActivity.class));
    }

    public void ToCallback(View view) {
        startActivity(new Intent(this,CallbackActivity.class));
    }

    public void ToGetConfiguration(View view) {
        startActivity(new Intent(this,GetConfigurationActivity.class));
    }

    public void ToHandlerTest(View view) {
        startActivity(new Intent(this,HandlerTestActivity.class));
    }
}
