package com.kassandra.apps.flutter.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class WebViewExampleActivity extends AppCompatActivity {

    WebView wvMain;
    EditText etUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example);

        wvMain = findViewById(R.id.wvMain);
        etUrl = findViewById(R.id.etUrl);


        wvMain.loadUrl("https://www.google.com/");
    }

    public void startBrowsing(View view) {
        String url = etUrl.getText().toString();
        if (url.isEmpty()) {
            Toast.makeText(this, "Please enter URL", Toast.LENGTH_SHORT).show();
            return;
        }
        if (url.contains("http://") || url.contains("https://")) {
            wvMain.loadUrl(url);
        } else {
            Toast.makeText(this, "Invalid URL", Toast.LENGTH_SHORT).show();
        }
    }

    public void goBack(View view) {
        if (wvMain.canGoBack()) {
            wvMain.goBack();
        }
    }

    public void goForward(View view) {
        if (wvMain.canGoForward()) {
            wvMain.goForward();
        }
    }

    public void refresh(View view) {
        wvMain.reload();
    }
}