package com.sample.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class UserProfileViewModel extends AndroidViewModel {
    public LiveData<List<UserProfile>> userProfileList;
    private UserProfileDao userProfileDao;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);

        UserProfileDatabase db = Room.databaseBuilder(application, UserProfileDatabase.class, "userprofile").build();
        userProfileDao = db.getUserProfileDao();
        userProfileList = userProfileDao.getAll();
    }

    public void insert(UserProfile userProfile) {
        new InsertUserProfileAsyncTask().execute(userProfile);
    }

    private class InsertUserProfileAsyncTask extends AsyncTask<UserProfile, Void, Void> {
        @Override
        protected Void doInBackground(UserProfile... userProfiles) {
            userProfileDao.insert(userProfiles[0]);
            return null;
        }
    }

    public void update(UserProfile userProfile) {
        new UpdateUserProfileAsyncTask().execute(userProfile);
    }

    private class UpdateUserProfileAsyncTask extends AsyncTask<UserProfile, Void, Void> {
        @Override
        protected Void doInBackground(UserProfile... userProfiles) {
            userProfileDao.update(userProfiles[0]);
            return null;
        }
    }

    public void delete(UserProfile userProfile) {
        new DeleteUserProfileAsyncTask().execute(userProfile);
    }

    private class DeleteUserProfileAsyncTask extends AsyncTask<UserProfile, Void, Void> {
        @Override
        protected Void doInBackground(UserProfile... userProfiles) {
            userProfileDao.delete(userProfiles[0]);
            return null;
        }
    }
}
