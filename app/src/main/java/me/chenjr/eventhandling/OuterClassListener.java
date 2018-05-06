package me.chenjr.eventhandling;

import android.view.View;
import android.widget.EditText;

/*外部监听器*/
public class OuterClassListener implements View.OnClickListener {
    private EditText edit_text;

    public OuterClassListener(EditText text) {
        edit_text = text;
    }

    @Override
    public void onClick(View view) {
        edit_text.setText(R.string.Listener_btn_outer);
    }
}
