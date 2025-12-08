package edu.urv.gamifyyourlife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import edu.urv.gamifyyourlife.model.DataSource;

public class ObjectivesActivity extends AppCompatActivity {

    public String section_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectives);

        if (getIntent().hasExtra("id")) {
            section_id = getIntent().getStringExtra("id");
        }

        ImageView back = findViewById(R.id.background_objectives);
        if(section_id.equals("1")) {
            back.setImageResource(R.drawable.sections_1); // Health фон
        } else if(section_id.equals("2")){
            back.setImageResource(R.drawable.sections_2); // Work фон
        } else{
            back.setImageResource(R.drawable.sections_3); // Social фон
        }

        back.setAlpha(0.3f);
        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DataSource.getInstance().Recalculate(section_id);

        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
        super.onBackPressed();
    }
}