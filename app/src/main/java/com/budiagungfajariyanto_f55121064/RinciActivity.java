package com.budiagungfajariyanto_f55121064;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.budiagungfajariyanto_f55121064.aplikasi_uts_budi064.R;

public class RinciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rinci);

        ImageView poster = findViewById(R.id.imgDetail);
        TextView title = findViewById(R.id.DetailTitle);
        TextView desc = findViewById(R.id.detailDesc);

        Bundle bundle = getIntent().getExtras();
        poster.setImageResource(bundle.getInt("Name"));
        title.setText(bundle.getString("posisi"));
        desc.setText(bundle.getString("desc"));
    }
}