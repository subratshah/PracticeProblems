package sample.com.fragmentexample1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private boolean isFragmentDisplayed = false;
    static final String FRAGMENT_STATE = "fragment_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayed)
                    displayFragment();
                else closeFragment();
            }
        });
        if (savedInstanceState != null && savedInstanceState.getBoolean(FRAGMENT_STATE)) {
            button.setText(R.string.close);
        }
    }

    public void displayFragment() {
        SimpleFragment simpleFragment = SimpleFragment.newInstance();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, simpleFragment).commit();

        button.setText(R.string.close);
        isFragmentDisplayed = true;
    }

    public void closeFragment() {
        FragmentManager fm = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fm.findFragmentById(R.id.fragment_container);

        if (simpleFragment != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.remove(simpleFragment).commit();
        }

        button.setText(R.string.open);
        isFragmentDisplayed = false;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putBoolean(FRAGMENT_STATE, isFragmentDisplayed);
        super.onSaveInstanceState(savedInstanceState);
    }
}
