package edu.urv.gamifyyourlife;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import edu.urv.gamifyyourlife.model.DataSource;

public class SectionsActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == RESULT_OK) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        SectionsFragment myFragment = (SectionsFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);
                        if (myFragment != null && myFragment.getAdapter() != null) {
                            myFragment.getAdapter().notifyDataSetChanged();
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);
    }
    public void openObjectives(String sectionId) {
        Intent intent = new Intent(this, ObjectivesActivity.class);
        intent.putExtra("id", sectionId);

        activityResultLauncher.launch(intent);
    }
}