package com.torridion.personaltrainer.adapter;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.torridion.personaltrainer.R;
import com.torridion.personaltrainer.model.Notification;

import java.util.List;

public class NotificationElementAdapter extends ArrayAdapter<Notification>{

    private final Activity context;
    private final List<Notification> notifications;

    public NotificationElementAdapter(Context context, List<Notification> objects) {
        super(context, R.layout.notification_element_layout, objects);
        this.context = (Activity) context;
        notifications = objects;
    }

    private class ViewHolder{
        public TextView txt;
        public TextView date;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        ViewHolder holder;

        View rowView= inflater.inflate(R.layout.notification_element_layout, null, true);

        holder = new ViewHolder();
        holder.txt = (TextView) rowView.findViewById(R.id.ne_txt_tv);
        holder.date = (TextView) rowView.findViewById(R.id.ne_date_tv);

        holder.txt.setText(notifications.get(position).getTxt());
        holder.date.setText(notifications.get(position).getStringCreationDate());

        return rowView;
    }
}
