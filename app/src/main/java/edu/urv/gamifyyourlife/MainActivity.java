package edu.urv.gamifyyourlife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import edu.urv.gamifyyourlife.model.DataSource;
import edu.urv.gamifyyourlife.model.DataSourceFactory;
import edu.urv.gamifyyourlife.model.SectionsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            DataSource data = DataSourceFactory.getDataSource(DataSource.DataSourceType.HARDCODED);
            data.loadModel();
        } catch (Exception e) {
            e.printStackTrace();
        }

        EditText edUser = findViewById(R.id.edUserName);
        EditText edPass = findViewById(R.id.edPasswd);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edUser.getText().toString();
                String pass = edPass.getText().toString();

                if(user.equals("admin") && pass.equals("1234")) {
                    Intent intent = new Intent(MainActivity.this, SectionsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Wrong credentials try admin/1234", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}