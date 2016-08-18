package com.torridion.personaltrainer.helper;

import com.torridion.personaltrainer.model.Exercise;

import io.realm.Realm;
import io.realm.RealmResults;


public class RealmHelper {

    private Realm realm;

    public RealmHelper(){
        realm = Realm.getDefaultInstance();
    }

    public void deleteExerciseByListItemId(final int id){
        final RealmResults<Exercise> results = realm.where(Exercise.class).findAll();


        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Exercise tmp = results.get(id);
                tmp.deleteFromRealm();
            }
        });

    }
}
