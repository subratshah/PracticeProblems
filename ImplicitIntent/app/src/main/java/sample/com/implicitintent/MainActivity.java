package sample.com.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText webEditText;
    private EditText locEditText;
    private EditText shareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webEditText = findViewById(R.id.web_edittext);
        locEditText = findViewById(R.id.loc_edittext);
        shareEditText = findViewById(R.id.share_edittext);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null) {
            String uri_string = "URI: " + uri.toString();
            TextView textView = findViewById(R.id.web_edittext);
            textView.setText(uri_string);
        }
    }

    public void openWebsite(View view) {
        String url = webEditText.getText().toString();

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void openLocation(View view) {
        String loc = locEditText.getText().toString();

        Uri address = Uri.parse("geo:0,0?q=" +loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = shareEditText.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.edittext_share)
                .setText(txt)
                .startChooser();
    }
}
