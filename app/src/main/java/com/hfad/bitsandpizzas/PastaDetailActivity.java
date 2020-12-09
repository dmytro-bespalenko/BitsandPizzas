package com.hfad.bitsandpizzas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PastaDetailActivity extends AppCompatActivity {

    public static final String EXTRA_PASTA_ID = "pastaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        int pastaId = (int) getIntent().getExtras().get(EXTRA_PASTA_ID);
        String pastaName = Pasta.pastas[pastaId].getName();

        TextView textView = findViewById(R.id.pasta_text);
        textView.setText(pastaName);

        int pastaImage = Pasta.pastas[pastaId].getImageRecourseId();
        ImageView imageView = findViewById(R.id.pasta_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pastaImage));
        imageView.setContentDescription(pastaName);

    }

}