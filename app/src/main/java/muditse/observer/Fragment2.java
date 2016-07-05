package muditse.observer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import muditse.eventbus.EventManager;
import muditse.eventbus.Observer;

/**
 * Created by mudit sen on 7/5/16.
 * Test Fragment
 */
public class Fragment2 extends Fragment {

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        textView = new TextView(getContext());
        textView.setText("Fragment 2");
        return textView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventManager.getInstance().addObserver(MainActivity.CLICK_EVENT, new Observer() {
            @Override
            protected void update(Object obj) {
                textView.setText("Activity Click Event Fragment 2 :O :O");
            }
        });
    }
}
