package me.chenjr.eventhandling;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class GetConfigurationActivity extends AppCompatActivity {

    EditText nav;
    EditText ori;
    EditText touch;
    EditText mnc;
    SparseIntArray nav_strings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_configuration);
        /*绑定EditText*/
        nav = findViewById(R.id.gc_edit_nav);
        ori = findViewById(R.id.gc_edit_ori);
        touch = findViewById(R.id.gc_edit_touch);
        mnc = findViewById(R.id.gc_edit_mnc);
        /*生成数组便于查找*/
        nav_strings = new SparseIntArray();
        nav_strings.put(Configuration.NAVIGATION_NONAV, R.string.GC_lable_nonav);
        nav_strings.put(Configuration.NAVIGATION_DPAD, R.string.GC_lable_dpad);
        nav_strings.put(Configuration.NAVIGATION_WHEEL, R.string.GC_lable_wheel);
        nav_strings.put(Configuration.NAVIGATION_TRACKBALL, R.string.GC_lable_trackball);


    }
    /*按钮的onClick事件*/
    public void getConfig(View view) {
        Configuration cfg = getResources().getConfiguration();

        nav.setText(nav_strings.get(cfg.navigation));

        ori.setText(cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ?
                R.string.GC_lable_landscape : R.string.GC_lable_portrait);

        touch.setText(cfg.touchscreen == Configuration.TOUCHSCREEN_FINGER ?
                R.string.GC_lable_touch : R.string.GC_lable_notouch);

        mnc.setText(" "+cfg.mnc);
    }
}
