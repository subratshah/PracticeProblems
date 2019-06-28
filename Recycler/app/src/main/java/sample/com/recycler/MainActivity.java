package sample.com.recycler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final LinkedList<String> mWordList = new LinkedList<>();

        for (int i = 1; i <= 20; i++) {
            mWordList.addLast("Line No." + i);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                mWordList.addLast("+ADDED+ Line No." + ++wordListSize);
                Objects.requireNonNull(mRecyclerView.getAdapter()).notifyItemInserted(wordListSize);
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        mRecyclerView = findViewById(R.id.recyclerview);                        // Get a handle to the RecyclerView.
        mAdapter = new WordListAdapter(this, mWordList);                // Create an adapter and supply the data to be displayed.
        mRecyclerView.setAdapter(mAdapter);                                     // Connect the adapter with the RecyclerView.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));  // Give the RecyclerView a default layout manager.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
