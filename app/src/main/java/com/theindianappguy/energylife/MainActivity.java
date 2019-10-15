package com.theindianappguy.energylife;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout card;
    TextView titletv, desctv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card = findViewById(R.id.card);
        titletv = findViewById(R.id.titletv);
        desctv = findViewById(R.id.desctv);

        card.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MoreInfo.class);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(card, "card");
                pairs[1] = new Pair<View, String>(titletv, "title");
                pairs[2] = new Pair<View, String>(desctv, "desc");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(intent, options.toBundle());
            }
        });

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}
