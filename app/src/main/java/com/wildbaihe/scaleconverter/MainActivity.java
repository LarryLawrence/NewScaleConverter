package com.wildbaihe.scaleconverter;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static String inputSpinner ="";
    static String outputSpinner = "";
    TextView resultView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    /*    //Spinner
        Spinner inputSpinner = (Spinner)findViewById(R.id.input_spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.scale_array,android.R.layout.simple_spinner_dropdown_item);
        inputSpinner.setAdapter(adapter1);*/

        //spinner begins

        Spinner inputSpinner = (Spinner)findViewById(R.id.input_spinner);
        String [] arr = {"Binary","Octal","Decimal","Hex","<Other>"};

        ArrayAdapter<String> inputAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, arr)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                return setCentered(super.getView(position, convertView, parent));
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                return setCentered(super.getDropDownView(position, convertView, parent));
            }

            private View setCentered(View view)
            {
                TextView textView = (TextView)view.findViewById(android.R.id.text1);
                textView.setGravity(Gravity.CENTER);
                return view;
            }
        };
        inputSpinner.setAdapter(inputAdapter);
        //spinner ends

        inputSpinner.setOnItemSelectedListener(new InputSpinnerOnItemSelectedListener());

        Spinner outputSpinner = (Spinner)findViewById(R.id.output_spinner);
//        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.scale_array,android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> outputAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout, arr)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                return setCentered(super.getView(position, convertView, parent));
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent)
            {
                return setCentered(super.getDropDownView(position, convertView, parent));
            }

            private View setCentered(View view)
            {
                TextView textView = (TextView)view.findViewById(android.R.id.text1);
                textView.setGravity(Gravity.CENTER);
                return view;
            }
        };

        outputSpinner.setAdapter(outputAdapter);
        outputSpinner.setOnItemSelectedListener(new OutputSpinnerOnItemSelectedListener());



//        String s = "abcdefghijk";
//        String x = s.substring(3);
//        Toast.makeText(MainActivity.this,x,Toast.LENGTH_LONG).show();

        resultView = (TextView)findViewById(R.id.resultView);
        if(inputSpinner.equals("Binary") && outputSpinner.equals("Octal"))
        {
//            resultView.setText();
        }



    }
    private class InputSpinnerOnItemSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            inputSpinner = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),inputSpinner,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            inputSpinner = "nothing selected";
            Toast.makeText(getApplicationContext(),inputSpinner,Toast.LENGTH_SHORT).show();

        }
    }
    private class OutputSpinnerOnItemSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            outputSpinner = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),outputSpinner,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            outputSpinner = "nothing selected";
            Toast.makeText(getApplicationContext(),outputSpinner,Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_how_to_use) {
        } else if (id == R.id.nav_about) {

        }
        else if(id == R.id.nav_quit) {
            System.exit(0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
