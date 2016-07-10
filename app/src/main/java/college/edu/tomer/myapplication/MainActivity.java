package college.edu.tomer.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DateFragment.OnDateSelected, TimeFragment.OnTimePickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setDate(View view) {
        DateFragment dateFragment = new DateFragment();

        dateFragment.setOnDateSelectedListener(this);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.container,dateFragment).
                commit();
    }

    public void setTime(View view) {
        TimeFragment timeFragment = new TimeFragment();
        timeFragment.setListener(this);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.container, timeFragment).
                commit();
    }

    public void setMessage(View view) {
    }

    @Override
    public void onDateSelected(int day, int month, int year) {
        Toast.makeText(this, day + " " + month + " " + year, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTimePicked(int hour, int minute) {
        Toast.makeText(this, hour + " " + minute , Toast.LENGTH_SHORT).show();

    }
}
