package sample.com.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.EditText2);
        textView = findViewById(R.id.TextView2);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message != "") {
            textView.setText(message);
            textView.setVisibility(View.VISIBLE);
        }
    }

    public void onClickButton2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("reply", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
