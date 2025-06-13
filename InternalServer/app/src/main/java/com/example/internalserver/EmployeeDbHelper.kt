package com.example.internalserver

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EmployeeDbHelper(context:Context) :
    SQLiteOpenHelper(context, "EmployeeDB",null,1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
                CREATE TABLE Employee(
                id INTEGER PRIMARY KEY ,
                name TEXT,
                email TEXT)
                """.trimIndent()
        db.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Employee")
        onCreate(db)
    }

    fun insertEmployee(id: Int, name: String, email: String): Boolean {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("id", id)
            put("name", name)
            put("email", email)
        }
        val result = db.insert("Employee", null, values)
        return result != -1L

    }

    fun getAllEmployees(): String {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM Employee", null)
        val builder = StringBuilder()
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val email = cursor.getString(2)
                builder.append("ID: $id\n, Name: $name\n, Email: $email\n")
            } while (cursor.moveToNext())
        }else
        {
            builder.append("No record found.")
        }
        cursor.close()
        return builder.toString()
    }
    fun deleteEmployee(id: Int): Boolean {
        val db = writableDatabase
        val result = db.delete("Employee", "id=?", arrayOf(id.toString()))
        return result > 0
    }
}