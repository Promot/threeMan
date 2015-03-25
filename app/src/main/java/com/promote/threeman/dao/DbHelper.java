package com.promote.threeman.dao;

import android.content.Context;

import com.promote.threeman.util.Constant;

import net.sqlcipher.database.SQLiteDatabase;

import java.io.File;

/**
 * Created by ACER on 2015/3/25.
 */
public class DbHelper extends SQLiteDatabase {

    public static final String DB_NAME = "three_man.db";
    public static final String HISTORY_TBL = "history_tbl";
    public static Context mContext;
    private static File mDataBaseFile = null;

    public DbHelper(Context context) {
        super(context.getDatabasePath(DB_NAME).getPath(), Constant.DB_PWD.toCharArray(), null, 0);
//        this.context = context;

    }

    public static void init(Context context) {
        mContext = context;
        SQLiteDatabase.loadLibs(context);

        mDataBaseFile = context.getDatabasePath(DB_NAME);
        mDataBaseFile.mkdirs();
        mDataBaseFile.delete();
        createTbl();
    }

    public static File getDataBaseFile() {
        return mDataBaseFile;
    }

    private static void createTbl() {

        SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(DB_NAME, Constant.DB_PWD,
                null);
        database.execSQL("CREATE TABLE if not exists " + HISTORY_TBL + "(" + "'id' INTEGER PRIMARY KEY, " +
                "'history' TEXT, 'search_type' INTEGER)");
    }

}
