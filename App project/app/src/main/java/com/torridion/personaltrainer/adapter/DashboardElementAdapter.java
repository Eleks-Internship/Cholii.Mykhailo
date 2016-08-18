package com.torridion.personaltrainer.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.torridion.personaltrainer.Constants;
import com.torridion.personaltrainer.R;
import com.torridion.personaltrainer.helper.ArrayTranslateHelper;
import com.torridion.personaltrainer.helper.RealmHelper;
import com.torridion.personaltrainer.model.Exercise;

import java.util.List;

public class DashboardElementAdapter extends ArrayAdapter<Exercise> {

    private final Activity context;
    private final List<Exercise> exercises;

    public DashboardElementAdapter(Context context, List<Exercise> exercises) {
        super(context, R.layout.dashboard_element_layout, exercises);
        this.context = (Activity) context;
        this.exercises = exercises;
    }

    static class ViewHolder {
        public ImageView image;
        public TextView label;
        public TextView kilkist;
        public TextView kg;
        public TextView m;
        public TextView times;
        public TextView speed;
        public TextView date;
        public ImageButton btnDel;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        View rowView;
        LayoutInflater inflater = context.getLayoutInflater();
        rowView = inflater.inflate(R.layout.dashboard_element_layout, null, true);

        holder = new ViewHolder();
        holder.image = (ImageView) rowView.findViewById(R.id.de_image);
        holder.label = (TextView) rowView.findViewById(R.id.de_label_tv);
        holder.kilkist = (TextView) rowView.findViewById(R.id.de_kilkist_tv);
        holder.kg = (TextView) rowView.findViewById(R.id.de_kg_tv);
        holder.m = (TextView) rowView.findViewById(R.id.de_m_tv);
        holder.times = (TextView) rowView.findViewById(R.id.de_time_tv);
        holder.speed = (TextView) rowView.findViewById(R.id.de_speed_tv);
        holder.date = (TextView) rowView.findViewById(R.id.de_date_tv);
        holder.btnDel = (ImageButton) rowView.findViewById(R.id.de_btn_del);
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new AlertDialog.Builder(context)
                        .setTitle(R.string.delete)
                        .setMessage(R.string.delete_question)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                RealmHelper helper = new RealmHelper();
                                helper.deleteExerciseByListItemId(position);
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
        rowView.setTag(holder);

        holder.label.setText(new ArrayTranslateHelper(getContext()).getData()[exercises.get(position).getIdExerciseType()]);
        checkAndWrite(exercises.get(position).getKilkist(), holder.kilkist, context.getString(R.string.count)+": ");
        checkAndWrite(exercises.get(position).getKg(), holder.kg, context.getString(R.string.kg)+": ");
        checkAndWrite(exercises.get(position).getM(), holder.m, context.getString(R.string.m)+" ");
        checkAndWrite(exercises.get(position).getTime(), holder.times, context.getString(R.string.time)+": ");
        checkAndWrite(exercises.get(position).getSpeed(), holder.speed, context.getString(R.string.speed)+": ");
        holder.date.setText(exercises.get(position).getDate());

        return rowView;
    }

    private void checkAndWrite(int value, TextView textView, String typo) {

        if (value == 0) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setText(typo + value);
        }
    }
}
