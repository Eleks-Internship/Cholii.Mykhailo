package com.torridion.personaltrainer;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.torridion.personaltrainer.helper.NotificationHelper;
import com.torridion.personaltrainer.model.Notification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import io.realm.Realm;

public class NotificationCreatorActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar ab;
    private Context context;
    private Realm realm;
    private TextView time, date;

    private static int year, month, day, hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_creator);
        context = this;
        time = (TextView) findViewById(R.id.notificationResultTime);
        date = (TextView) findViewById(R.id.notificationResultDate);
        initToolbar();
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
                String tmp = date.getText().toString() +" "+time.getText().toString();
                writeIntoRealm(tmp);
                createNotification();
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.notificationCreatorToolbar);
        toolbar.setTitle(this.getString(R.string.add_notification));
        setSupportActionBar(toolbar);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void writeIntoRealm(String tmp) {
        realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        Notification notification = realm.createObject(Notification.class);
        notification.setCreationDate(new Date());
        notification.setNotificationDate(parseDate(tmp));
        notification.setTxt("Notification time is: "+tmp);

        realm.commitTransaction();
        realm.close();
        Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show();
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    private Date parseDate(String tmp){
        Date date = new Date();
        java.text.DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            date = format.parse(tmp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            TextView tv = (TextView)getActivity().findViewById(R.id.notificationResultTime);
            tv.setText(hourOfDay+":"+minute);
            hour = hourOfDay;
            NotificationCreatorActivity.minute = minute;
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            TextView tv = (TextView)getActivity().findViewById(R.id.notificationResultDate);
            tv.setText(day+"/"+month+"/"+year);
            NotificationCreatorActivity.year = year;
            NotificationCreatorActivity.month = month;
            NotificationCreatorActivity.day = day;
        }
    }


    private void createNotification(){

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, NotificationHelper.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_CANCEL_CURRENT );
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

    }
}
