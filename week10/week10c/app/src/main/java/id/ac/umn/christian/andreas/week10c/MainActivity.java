package id.ac.umn.christian.andreas.week10c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    id.ac.umn.christian.andreas.week10c.CustomBoundService customBoundService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent servIntent = new Intent(MainActivity.this,
                id.ac.umn.christian.andreas.week10c.SimpleIntentService.class);

        startService(servIntent);


        Button btnStartService = findViewById(R.id.main_button_startservice);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        id.ac.umn.christian.andreas.week10c.MyService.class);
                startService(intent);
            }
        });
        Intent intent2 = new Intent(this, id.ac.umn.christian.andreas.week10c.CustomBoundService.class);
        bindService(intent2, serviceConnection, Context.BIND_AUTO_CREATE);

        Button btnShowTime = findViewById(R.id.main_button_showtime);
        btnShowTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentTime = customBoundService.getCurrentTime();
                Toast.makeText(getApplicationContext(),
                        currentTime,Toast.LENGTH_LONG).show();
            }
        });

    }
    private ServiceConnection serviceConnection =
            new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name,
                                               IBinder service) {
                    id.ac.umn.christian.andreas.week10c.CustomBoundService.CustomLocalBinder binder =
                            (id.ac.umn.christian.andreas.week10c.CustomBoundService.CustomLocalBinder) service;
                    customBoundService = binder.getService();
                    isBound = true;
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    isBound = false;
                }
            };

}