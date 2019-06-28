package sample.com.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.EditText1);
        textView = findViewById(R.id.TextView1);

        if (savedInstanceState != null && savedInstanceState.getBoolean("reply_visibility")) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(savedInstanceState.getString("reply"));
        }
    }

    public void onClickButton1(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message", editText.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == -1) {
                textView.setText(data.getStringExtra("reply"));
                textView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (textView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visibility", true);
            outState.putString("reply", textView.getText().toString());
        }
    }
}
