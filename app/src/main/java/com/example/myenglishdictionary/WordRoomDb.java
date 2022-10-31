package com.example.myenglishdictionary;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/*
@Database(entities = {student.class, version = 1}, {organization.class, version = 1})
 */

@Database(entities = Words.class, version = 1)
public abstract class WordRoomDb extends RoomDatabase {

    // we created this class to transform this class into Singleton
    // We can't create copy or more than a copy/instance from the same database
    private static WordRoomDb instance;

    // for accessing the Room operations (CRUD)
    public abstract WordsDao wordDao();

    // Singleton - Only one thread can access to this function and interact with the database
    public static synchronized WordRoomDb getInstance(Context context) {
        if(instance == null) {
            // return to me for a copy from database
            instance = Room.databaseBuilder(context.getApplicationContext(), WordRoomDb.class, "word-database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

//    @NonNull
//    @Override
//    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
//        return null;
//    }
//
//    @NonNull
//    @Override
//    protected InvalidationTracker createInvalidationTracker() {
//        return null;
//    }
//
//    @Override
//    public void clearAllTables() {
//
//    }
}
