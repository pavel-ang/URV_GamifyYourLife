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
            back.setImageResource(R.drawable.sections_1);
        } else if(section_id.equals("2")){
            back.setImageResource(R.drawable.sections_2);
        } else{
            back.setImageResource(R.drawable.sections_3);
        }

        back.setAlpha(0.3f);

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