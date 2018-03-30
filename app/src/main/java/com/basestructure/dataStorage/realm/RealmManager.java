package com.basestructure.dataStorage.realm;


import com.basestructure.modules.auth.model.Profile;

import java.util.List;

import io.realm.Realm;

public class RealmManager {

    private static RealmManager realmManager;
    private Realm realm;

    public RealmManager() {
        this.realm = getRealm();
    }

    public static RealmManager getInstance() {
        if (realmManager == null) {
            realmManager = new RealmManager();
        }
        return realmManager;
    }

    public Realm getRealm() {
        return Realm.getDefaultInstance();
    }

    public void clearRealmData() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public void saveDataItem(Profile profile,String email) {
        profile.setEmail(email);
        realm.beginTransaction();
        realm.insert(profile);
        realm.commitTransaction();
    }

    public void deleteItem(Realm realm, String email) {
            Profile profile = realm.where(Profile.class).equalTo("email", email).findFirst();
            if (profile != null) {
                profile.deleteFromRealm();
            }
    }

    public List<Profile> GetItemList(String email) {
        return realm.copyFromRealm(realm.where(Profile.class).equalTo("email", email).findAll());
    }

}
