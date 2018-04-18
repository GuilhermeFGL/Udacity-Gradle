package com.example.android.frontend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String BUNDLE_JOKE = JokeActivity.class.getName().concat("BUNDLE_JOKE");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if (getIntent().hasExtra(BUNDLE_JOKE)) {
            ((TextView) findViewById(R.id.joke_content))
                    .setText(getIntent().getStringExtra(BUNDLE_JOKE));
        }
    }
}
