package com.ishwar.gatepass;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 1800;

    private ProgressBar progressBar;

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final Runnable navigateToLogin = () -> {
        Intent intent = new Intent(
                SplashActivity.this,
                LoginActivity.class
        );

        startActivity(intent);
        finish();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);

        startLoadingAnimation();
    }

    private void startLoadingAnimation() {

        final int[] progress = {0};

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                progress[0] += 5;
                progressBar.setProgress(progress[0]);

                if (progress[0] < 100) {
                    handler.postDelayed(this, SPLASH_DURATION / 20);
                } else {
                    navigateToLogin.run();
                }
            }

        }, SPLASH_DURATION / 20);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}