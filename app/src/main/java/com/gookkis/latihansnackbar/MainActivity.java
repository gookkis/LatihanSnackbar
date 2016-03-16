package com.gookkis.latihansnackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout coordinatorLayout;

    // Button variables
    private Button buttonSimpleSnackbar;
    private Button buttonCustomSnackbar;
    private Button buttonMultiColorSnackbar;
    private Button buttonActionCallbackSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        initListeners();

    }

    /**
     * method initialize views dari activity_main.xml
     */
    private void initViews() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        buttonSimpleSnackbar = (Button) findViewById(R.id.buttonSimpleSnackbar);
        buttonCustomSnackbar = (Button) findViewById(R.id.buttonCustomSnackbar);
        buttonMultiColorSnackbar = (Button) findViewById(R.id.buttonMultiColorSnackbar);
        buttonActionCallbackSnackbar = (Button) findViewById(R.id.buttonActionCallbackSnackbar);

    }

    /**
     * method initialize listeners untuk on click masing2 button
     */
    private void initListeners() {

        buttonSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Gookis.com Latihan Snackbar", Snackbar.LENGTH_LONG);

                snackbar.show();

            }
        });

        buttonCustomSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Server Not Responding!", Snackbar.LENGTH_LONG)
                        .setAction("TRY AGAIN", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });

                // Action text color
                snackbar.setActionTextColor(Color.WHITE);

                // Action button (warna teks)
                View snackBarView = snackbar.getView();
                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);

                snackbar.show();
            }
        });

        buttonMultiColorSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat MultiColor Text
                SpannableStringBuilder snackbarText = new SpannableStringBuilder();
                snackbarText.append("Selamat datang di ");
                int boldStart = snackbarText.length();
                snackbarText.append("Gookkis.com");
                snackbarText.setSpan(new ForegroundColorSpan(Color.CYAN), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.append(".");

                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, snackbarText, Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });

        buttonActionCallbackSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Pesan telah dihapus.", Snackbar.LENGTH_LONG)
                        .setAction("BATAL", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbarUndo = Snackbar.make(coordinatorLayout, "Pesan telah dikembalikan!", Snackbar.LENGTH_SHORT);
                                snackbarUndo.show();
                            }
                        });

                snackbar.show();
            }
        });
    }


}