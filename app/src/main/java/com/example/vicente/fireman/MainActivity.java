package com.example.vicente.fireman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private android.widget.TextView textView;
    private android.widget.TextView tvScore;
    private android.widget.Button btClose;
    private android.widget.Button btReset;

    private void init() {
        this.btReset = (Button) findViewById(R.id.btReset);
        this.btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JuegoNuevo.class);
                JuegoNuevo.contextJuegoNuevo.finish();
                MainActivity.this.finish();
                startActivity(intent);
            }
        });

        this.btClose = (Button) findViewById(R.id.btClose);
        this.btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JuegoNuevo.contextJuegoNuevo.finish();
                MainActivity.this.finish();
            }
        });

        this.tvScore = (TextView) findViewById(R.id.tvScore);
        this.textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Bundle bundle = getIntent().getExtras();
        String score = bundle.getString("score");
        tvScore.setText(score);
    }
}
