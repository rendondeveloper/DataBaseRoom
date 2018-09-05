package com.example.o_lrendon.databaseroom.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.o_lrendon.databaseroom.Model.User;

import java.util.List;

@Dao
public interface DAOUser
{
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    long inserrUser(User user);

    @Update(onConflict = OnConflictStrategy.ROLLBACK)
    int updateUser(User user);

    @Delete
    int deleteUser(User user);

    @Query("SELECT * FROM User")
    List<User> getAllUser();

    @Query("SELECT * FROM User WHERE email LIKE :email")
    List<User> getAllUserbyId(final String email);
}
