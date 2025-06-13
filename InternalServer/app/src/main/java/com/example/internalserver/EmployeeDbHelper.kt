package com.example.internalserver

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EmployeeDbHelper(context:Context) :
    SQLiteOpenHelper(context, "EmployeeDB",null,1) {

        override fun onCreate(db: SQLiteDatabase) {
            val createTable="""
                CREATE TABLE Emplotee(
                id INTEGER PRIMARY KEY ,
                name TEXT,
                email TEXT)
                """.trimIndent()
            db.execSQL(createTable)

        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS Emplotee")
            onCreate(db)
        }

    }