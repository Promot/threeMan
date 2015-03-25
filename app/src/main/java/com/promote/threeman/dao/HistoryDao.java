package com.promote.threeman.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.promote.threeman.bean.SearchHistory;
import com.promote.threeman.util.Constant;

import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by ACER on 2015/3/25.
 */
public class HistoryDao {

    private Context context;

    public HistoryDao(Context context) {
        this.context = context;
    }

    /**
     * 添加历史记录。
     *
     * @param history
     */
    public void addHistory(SearchHistory history) {
        SQLiteDatabase db = DbHelper.openDatabase(DbHelper.getDataBaseFile().getPath(),
                Constant.DB_PWD, null, 0);
        ContentValues values = new ContentValues();
        values.put("history", history.getName());
        values.put("search_type", history.getType());
        db.insert(DbHelper.HISTORY_TBL, null, values);
        db.close();
    }

    /**
     * 获取历史记录。
     *
     * @return
     */
    public ArrayList<SearchHistory> getHistorys() {

        SQLiteDatabase db = DbHelper.openDatabase(DbHelper.getDataBaseFile().getPath(),
                Constant.DB_PWD, null, 0);

        ArrayList<SearchHistory> histories = new ArrayList<>();
        Cursor cursor = db.query(DbHelper.HISTORY_TBL, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String historyStr = cursor.getString(cursor.getColumnIndex("history"));
            int type = cursor.getInt(cursor.getColumnIndex("search_type"));
            SearchHistory history = new SearchHistory();
            history.setName(historyStr);
            history.setType(type);
            histories.add(history);
        }
        cursor.close();
        db.close();

        return histories;
    }

    public ArrayList<SearchHistory> getHistorysBykey(String key) {

        SQLiteDatabase db = DbHelper.openDatabase(DbHelper.getDataBaseFile().getPath(),
                Constant.DB_PWD, null, 0);
        ArrayList<SearchHistory> histories = new ArrayList<>();
        Cursor cursor = db.query(DbHelper.HISTORY_TBL, null, "history=?", new String[]{key}, null,
                null, null);
        while (cursor.moveToNext()) {
            String historyStr = cursor.getString(cursor.getColumnIndex("history"));
            int type = cursor.getInt(cursor.getColumnIndex("search_type"));
            SearchHistory history = new SearchHistory();
            history.setName(historyStr);
            history.setType(type);
            histories.add(history);
        }

        cursor.close();
        db.close();
        return histories;

    }

    /**
     * 清空历史记录。
     *
     * @return
     */
    public boolean clearHistory() {

        SQLiteDatabase db = DbHelper.openDatabase(DbHelper.getDataBaseFile().getPath(),
                Constant.DB_PWD, null, 0);
        db.execSQL("delete from " + DbHelper.HISTORY_TBL);
        db.close();
        return true;
    }
}
