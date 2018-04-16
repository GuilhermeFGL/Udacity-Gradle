package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.frontend.JokeActivity;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointCallBack {

    private ProgressBar jokeProgressBar;
    private Button jokeAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokeAction = findViewById(R.id.joke_action);
        jokeProgressBar = findViewById(R.id.joke_progress_bar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        jokeProgressBar.setVisibility(View.VISIBLE);
        jokeAction.setEnabled(false);
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onResult(String result) {
        jokeProgressBar.setVisibility(View.GONE);
        jokeAction.setEnabled(true);
        if (result != null) {
            startActivity(new Intent(this, JokeActivity.class)
                    .putExtra(JokeActivity.BUNDLE_JOKE, result));
        } else {
            Toast.makeText(this,"Unnable to load toast", Toast.LENGTH_LONG).show();
        }
    }
}
