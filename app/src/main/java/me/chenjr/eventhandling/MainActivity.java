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


    public void ToListener(View view) {
        startActivity(new Intent(this,ListenerActivity.class));
    }

    public void ToCallback(View view) {
        startActivity(new Intent(this,CallbackActivity.class));
    }
}
