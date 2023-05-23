package com.example.projetdveloppementmobile;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

    public class DBHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "mini_blog.db";
        private static final String TABLE_ARTICLES = "articles";
        private static final String COLUMN_ID = "id";
        private static final String COLUMN_TITLE = "title";
        private static final String COLUMN_CONTENT = "content";

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_ARTICLES +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_TITLE + " TEXT," +
                    COLUMN_CONTENT + " TEXT" + ")";
            db.execSQL(CREATE_ARTICLES_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);
            onCreate(db);
        }

        public void addArticle(Article article) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_TITLE, article.getTitle());
            values.put(COLUMN_CONTENT, article.getContent());
            db.insert(TABLE_ARTICLES, null, values);
            db.close();
        }

        public List<Article> getAllArticles() {
            List<Article> articleList = new ArrayList<>();
            String selectQuery = "SELECT * FROM " + TABLE_ARTICLES;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    Article article = new Article();
                    article.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                    article.setTitle(cursor.getString(cursor.getColumnIndex(COLUMN_TITLE)));
                    article.setContent(cursor.getString(cursor.getColumnIndex(COLUMN_CONTENT)));
                    articleList.add(article);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
            return articleList;
        }
    }
