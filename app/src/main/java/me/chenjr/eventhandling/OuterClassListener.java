package me.chenjr.eventhandling;

import android.view.View;
import android.widget.EditText;

/*外部监听器*/
public class OuterClassListener implements View.OnClickListener {
    EditText show;

    public OuterClassListener(EditText text) {
        show= text;
    }

    @Override
    public void onClick(View view) {
        show.setText(R.string.Listener_btn_outer);
    }
}
