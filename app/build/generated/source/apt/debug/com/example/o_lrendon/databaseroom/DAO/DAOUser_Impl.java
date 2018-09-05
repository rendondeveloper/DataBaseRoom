package com.example.o_lrendon.databaseroom.DAO;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import com.example.o_lrendon.databaseroom.Model.User;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class DAOUser_Impl implements DAOUser {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfUser;

  public DAOUser_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ROLLBACK INTO `User`(`uid`,`email`,`nameAndLastName`,`Address`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUid());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getNameAndLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNameAndLastName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `User` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUid());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ROLLBACK `User` SET `uid` = ?,`email` = ?,`nameAndLastName` = ?,`Address` = ? WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUid());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getNameAndLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNameAndLastName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        stmt.bindLong(5, value.getUid());
      }
    };
  }

  @Override
  public long inserrUser(User user) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUser.insertAndReturnId(user);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteUser(User user) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateUser(User user) {
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> getAllUser() {
    final String _sql = "SELECT * FROM User";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfNameAndLastName = _cursor.getColumnIndexOrThrow("nameAndLastName");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Address");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpNameAndLastName;
        _tmpNameAndLastName = _cursor.getString(_cursorIndexOfNameAndLastName);
        _item.setNameAndLastName(_tmpNameAndLastName);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<User> getAllUserbyId(final String email) {
    final String _sql = "SELECT * FROM User WHERE email LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final int _cursorIndexOfNameAndLastName = _cursor.getColumnIndexOrThrow("nameAndLastName");
      final int _cursorIndexOfAddress = _cursor.getColumnIndexOrThrow("Address");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        _item = new User();
        final int _tmpUid;
        _tmpUid = _cursor.getInt(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        final String _tmpNameAndLastName;
        _tmpNameAndLastName = _cursor.getString(_cursorIndexOfNameAndLastName);
        _item.setNameAndLastName(_tmpNameAndLastName);
        final String _tmpAddress;
        _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        _item.setAddress(_tmpAddress);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
