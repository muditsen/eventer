package muditse.observer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import muditse.eventbus.EventManager;

public class MainActivity extends AppCompatActivity {

    public static final String CLICK_EVENT ="click_event";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventManager.getInstance().createEvent(CLICK_EVENT);

        findViewById(R.id.btn_clickMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventManager.getInstance().fireEvent(CLICK_EVENT,null);
            }
        });
    }
}
