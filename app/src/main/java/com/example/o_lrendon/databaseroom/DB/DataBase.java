package com.example.o_lrendon.databaseroom.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.o_lrendon.databaseroom.DAO.DAOUser;
import com.example.o_lrendon.databaseroom.Model.User;

@Database(entities = {User.class}, version = 111111, exportSchema = false)
public abstract class DataBase extends RoomDatabase
{
    public abstract DAOUser daoUser() ;

    private static DataBase INSTANCE;

    public static DataBase getDataBase(Context context)
    {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "userDataBase").allowMainThreadQueries().build();
        }

        return INSTANCE;
    }

    public static void  destroyInstance()
    {
        INSTANCE = null;
    }
}
