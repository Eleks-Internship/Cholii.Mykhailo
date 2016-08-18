package com.torridion.personaltrainer.helper;


import android.content.Context;

import com.torridion.personaltrainer.R;

public class ArrayTranslateHelper {

    private String[] data;

    private String[] params;

    public ArrayTranslateHelper(Context context){
        data = new String[]{context.getString(R.string.prusiad), context.getString(R.string.vidjum),
                context.getString(R.string.pidtiag), context.getString(R.string.pres),
                context.getString(R.string.big), context.getString(R.string.guria),
                context.getString(R.string.strub_n_s), context.getString(R.string.jum),
                context.getString(R.string.prusiad_z_sht), context.getString(R.string.ganteli),
                context.getString(R.string.stanova), context.getString(R.string.t_velo),
                context.getString(R.string.t_pid_vagu), context.getString(R.string.t_big_dor)};
        params = new String[]{context.getString(R.string.kg), context.getString(R.string.m),
                context.getString(R.string.time),context.getString(R.string.speed)};
    }

    public String[] getData(){
        return data;
    }

    public String[] getParams(){
        return params;
    }
}
