package alesyasvitina.com.englishlearningapp.statistic

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

private val SQL = object {
    val DB = object {
        val NAME = "english_learning_app"
        val VERSION = 1
    }
    val TABLE = "statistic"
    val COLUMN = object {
        val ID = object {
            val NAME = "id"
            val IDX = 0
        }
        val DATE_TIME = object {
            val NAME = "date_time"
            val IDX = 1
        }
        val RESULT_IN_PERCENT = object {
            val NAME = "result_in_percent"
            val IDX = 2
        }
        val TIME_SPENT_IN_SECONDS = object {
            val NAME = "tine_spent_in_seconds"
            val IDX = 3
        }
    }
}

class StatisticRepository(context: Context?) :
    SQLiteOpenHelper(context, SQL.DB.NAME, null, SQL.DB.VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(
            """
            create table ${SQL.TABLE} (
                ${SQL.COLUMN.ID.NAME} integer primary key autoincrement,
                ${SQL.COLUMN.DATE_TIME.NAME} integer not null,
                ${SQL.COLUMN.RESULT_IN_PERCENT.NAME} integer not null,
                ${SQL.COLUMN.TIME_SPENT_IN_SECONDS.NAME} integer not null
            )
            """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists ${SQL.TABLE}")
        onCreate(db)
    }

    fun loadAll(): List<Statistic> {
        val db = readableDatabase!!
        val cursor = db.rawQuery(
            "select * from ${SQL.TABLE} order by ${SQL.COLUMN.DATE_TIME.NAME} desc", null
        )
        val result = ArrayList<Statistic>()
        cursor.use {
            if (cursor.moveToFirst()) {
                do {
                    result.add(
                        Statistic(
                            id = cursor.getLong(SQL.COLUMN.ID.IDX),
                            datetime = LocalDateTime.ofInstant(
                                Instant.ofEpochMilli(
                                    cursor.getLong(SQL.COLUMN.DATE_TIME.IDX)
                                ),
                                ZoneId.systemDefault()
                            ),
                            resultInPercent = cursor.getLong(SQL.COLUMN.RESULT_IN_PERCENT.IDX),
                            timeSpentInSeconds = cursor.getLong(SQL.COLUMN.TIME_SPENT_IN_SECONDS.IDX)
                        )
                    )
                } while (cursor.moveToNext())
            }
        }
        return result
    }

    fun saveNew(statistic: Statistic) {
        val db = writableDatabase!!
        db.use {
            val values = ContentValues()
            values.put(
                SQL.COLUMN.DATE_TIME.NAME,
                statistic.datetime
                    .atZone(ZoneId.systemDefault())
                    .toInstant()
                    .toEpochMilli()
            )
            values.put(
                SQL.COLUMN.RESULT_IN_PERCENT.NAME,
                statistic.resultInPercent
            )
            values.put(
                SQL.COLUMN.TIME_SPENT_IN_SECONDS.NAME,
                statistic.timeSpentInSeconds
            )
            db.insert(SQL.TABLE, null, values)
        }
    }

    fun deleteAll() {
        val db = writableDatabase!!
        db.use {
            db.execSQL("delete from ${SQL.TABLE}")
        }
    }
}
