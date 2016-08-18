package com.torridion.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.torridion.personaltrainer.helper.ArrayTranslateHelper;
import com.torridion.personaltrainer.model.Exercise;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class ExercisesCreatorActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar ab;
    private Spinner spinner;
    private Context context;
    private Realm realm;

    private EditText kilkist;
    private EditText kg;
    private EditText metru;
    private EditText time;
    private EditText speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_creator);
        context = this;
        initToolbar();
        initSpinner();
        initEditTexts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_confirm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent .FLAG_ACTIVITY_CLEAR_TOP);

        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(intent);
                return true;
            case R.id.btn_confirm:
                writeIntoRealm();
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.exercisesCreatorToolbar);
        toolbar.setTitle(this.getString(R.string.add_exercise));
        setSupportActionBar(toolbar);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }

    private void initSpinner() {
        spinner = (Spinner) findViewById(R.id.exercisesCreatorSpinner);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,
                new ArrayTranslateHelper(getApplicationContext()).getData());
        spinner.setAdapter(adapter);

        spinner.setPrompt("Select a type");

    }

    private void initEditTexts() {
        kilkist = (EditText) findViewById(R.id.editText_kilkist);
        kilkist.setText("0");
        kg = (EditText) findViewById(R.id.editText_kg);
        kg.setText("0");
        metru = (EditText) findViewById(R.id.editText_metru);
        metru.setText("0");
        time = (EditText) findViewById(R.id.editText_time);
        time.setText("0");
        speed = (EditText) findViewById(R.id.editText_speed);
        speed.setText("0");
    }

    private void writeIntoRealm(){
        RealmConfiguration config = new RealmConfiguration.Builder(context).build();
        realm = Realm.getInstance(config);

        realm.beginTransaction();
        Exercise exercise = realm.createObject(Exercise.class);
        exercise.setIdExerciseType(spinner.getSelectedItemPosition());
        exercise.setKilkist(Integer.parseInt(kilkist.getText().toString()));
        exercise.setKg(Integer.parseInt(kg.getText().toString()));
        exercise.setM(Integer.parseInt(metru.getText().toString()));
        exercise.setTime(Integer.parseInt(time.getText().toString()));
        exercise.setSpeed(Integer.parseInt(speed.getText().toString()));
        exercise.setDate(new Date());

        realm.commitTransaction();
        if(!realm.isClosed()) realm.close();
        Toast.makeText(getApplicationContext(), "Writed", Toast.LENGTH_SHORT).show();
    }
}
