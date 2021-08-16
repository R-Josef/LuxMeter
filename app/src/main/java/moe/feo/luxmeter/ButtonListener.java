package moe.feo.luxmeter;

import android.view.View;

public class ButtonListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        MainActivity instance = MainActivity.getInstance();
        boolean hold = instance.isHold();
        if (hold) {
            instance.setHold(false);
            instance.getButton().setText(R.string.hold);
        } else {
            instance.setHold(true);
            instance.getButton().setText(R.string.release);
        }
    }
}
