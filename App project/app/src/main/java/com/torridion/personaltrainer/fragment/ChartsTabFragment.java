package com.torridion.personaltrainer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.torridion.personaltrainer.Constants;
import com.torridion.personaltrainer.R;
import com.torridion.personaltrainer.helper.ArrayTranslateHelper;
import com.torridion.personaltrainer.model.Exercise;

import io.realm.Realm;
import io.realm.RealmResults;

public class ChartsTabFragment extends ATabFragment{

    private static int LAYOUT = R.layout.fragment_charts;

    private Context context;

    private Spinner choseEx, chosePar;
    private Button buildButton;
    private GraphView graphView;



    public static ChartsTabFragment getInstance(Context context){
        Bundle args = new Bundle();
        ChartsTabFragment fragment = new ChartsTabFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.string_charts));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        initSpinners();
        initButton();
        return view;
    }

    private void initSpinners(){
        choseEx = (Spinner) view.findViewById(R.id.cf_spinner_chose_ex);
        chosePar = (Spinner) view.findViewById(R.id.cf_spinner_chose_ch);

        ArrayTranslateHelper arrayTranslateHelper = new ArrayTranslateHelper(getContext());

        ArrayAdapter<String> exAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, arrayTranslateHelper.getData());
        choseEx.setAdapter(exAdapter);

        ArrayAdapter<String> parAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item, arrayTranslateHelper.getParams());
        chosePar.setAdapter(parAdapter);
    }

    private void initButton() {
        buildButton = (Button) view.findViewById(R.id.btn_build_chart);
        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = Realm.getDefaultInstance();
                RealmResults<Exercise> results = realm.where(Exercise.class).equalTo("idExerciseType", choseEx.getSelectedItemId()).findAll();
                initGraph(results);
            }
        });
    }

    private void initGraph(RealmResults<Exercise> realmResults){
        graphView = (GraphView) view.findViewById(R.id.graph);

        graphView.removeAllSeries();

        int count;
        if(realmResults.size()>10) count=10;
        else count = realmResults.size();

        DataPoint[] array = new DataPoint[count];

        switch ((int)chosePar.getSelectedItemId()){
            case 0:
                for (int i = 0; i < count; i++) {
                    array[i] = new DataPoint(i, realmResults.get(i).getKilkist());
                }
                break;
            case 1:
                for (int i = 0; i < count; i++) {
                    array[i] =new DataPoint(i, realmResults.get(i).getKg());
                }
                break;
            case 2:
                for (int i = 0; i < count; i++) {
                    array[i] =new DataPoint(i, realmResults.get(i).getM());
                }
                break;
            case 3:
                for (int i = 0; i < count; i++) {
                    array[i] =new DataPoint(i, realmResults.get(i).getTime());
                }
                break;
            case 4:
                for (int i = 0; i < count; i++) {
                    array[i] =new DataPoint(i, realmResults.get(i).getSpeed());
                }
                break;
        }

        LineGraphSeries<DataPoint> graphSeries = new LineGraphSeries<>(array);
        graphView.addSeries(graphSeries);
    }



}
