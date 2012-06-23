package com.fangbang8.client.common.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fangbang8.client.entity.School;

public class DBHelper extends SQLiteOpenHelper{
	/** 数据库名 */
	private final static String DATABASE_NAME = "fb8_db";
	/** 数据库版本 */
	private final static int DATABASE_VERSION = 1;
	/** 中卫热线收藏表 */
	private final static String TABLE_SCHOOL_COLLECT = "school_collect";
	/** 中卫热线收藏表 */
	private final static String TABLE_SCHOOL = "school";

	private static DBHelper dbHelper;
	/** 获取该类的操作实例 **/
	public static DBHelper getInstance(Context context) {
		if (dbHelper == null) {
			dbHelper = new DBHelper(context);
		}

		return dbHelper;
	}// end of getInstance method
	private DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/** 学校 */
		String createSC = "Create table "
				+ TABLE_SCHOOL_COLLECT
				+ " (id integer primary key autoincrement,"
				+ " name varchar(100) not null,province varchar(20) not null,grade varchar(20) not null,collect varchar(10)"
				+ " number integer not null);";
		/**学校收藏 */
		String createS = "Create table "
				+ TABLE_SCHOOL
				+ " (id integer primary key autoincrement,"
				+ " name varchar(100) not null,province varchar(20) not null,grade varchar(20) not null,"
				+ " number integer not null);";

		db.execSQL(createSC);
		db.execSQL(createS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String dropSC = " DROP TABLE IF EXISTS " + TABLE_SCHOOL_COLLECT;
		String dropS = " DROP TABLE IF EXISTS " + TABLE_SCHOOL;
		
		db.execSQL(dropSC);
		db.execSQL(dropS);
		onCreate(db);
	}
	
	/**
	 * 删除学校收藏
	 * @param id
	 * @return void
	 */
	public void deleteSC(int id) {
		String where = "id" + "=?";
		String[] whereValue = { Integer.toString(id) };
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_SCHOOL_COLLECT, where, whereValue);
	}
	/**
	 * 删除所有学校收藏
	 * @param id
	 * @return void
	 */
	public void deleteAllSC(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_SCHOOL_COLLECT, null, null);
	}
	/**
	 * 添加学校收藏
	 * @param sc
	 * @return
	 */
	public boolean insertSC(School sc) {
		if(selectSCHaveOrNot(sc.getNumber())){return false;}	
		
		ContentValues cv = new ContentValues();
		cv.put("name", sc.getName());
		cv.put("province", sc.getProvince());
		cv.put("grade", sc.getGrade());
		cv.put("number", sc.getNumber());
		SQLiteDatabase db = this.getWritableDatabase();
		db.insert(TABLE_SCHOOL_COLLECT, null, cv);
		return true;
	}

	/**
	 * 查找学校是否以收藏
	 * @param num
	 * @return
	 */
	public boolean selectSCHaveOrNot(String num  ) {				
		String selection = "number" + "=?";
		String[] selectionArgs = { num };
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_SCHOOL_COLLECT, null, selection,
				selectionArgs, null, null, null);
		boolean flag = cursor.moveToNext();
		db.close();
		return flag ;
	}
	
	/**
	 * 添加学校
	 * @param sc
	 * @return
	 */
	public boolean insertS(School sc) {
		ContentValues cv = new ContentValues();
		cv.put("name", sc.getName());
		cv.put("province", sc.getProvince());
		cv.put("grade", sc.getGrade());
		cv.put("number", sc.getNumber());
		cv.put("collect", sc.getCollect());
		SQLiteDatabase db = this.getWritableDatabase();
		db.insert(TABLE_SCHOOL, null, cv);
		return true;
	}
	/**
	 * 得到学校
	 * @param username
	 * @return 返回Cursor
	 */
	public ArrayList<School> selectS() {
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_SCHOOL, null, null,
				null, null, null, null);
		ArrayList<School> ss = new ArrayList<School>();
		while(cursor.moveToNext()){
			School s = new School();
			int idColumn = cursor.getColumnIndex("id");
			int nameColumn = cursor.getColumnIndex("name");
			int provinceColumn = cursor.getColumnIndex("province");
			int gradeColumn = cursor.getColumnIndex("grade");
			int numberColumn = cursor.getColumnIndex("number");
			int collectColumn = cursor.getColumnIndex("collect");
			
			s.setId(cursor.getInt(idColumn));
			s.setName(cursor.getString(nameColumn));
			s.setProvince(cursor.getString(provinceColumn));
			s.setGrade(cursor.getString(gradeColumn));
			s.setNumber(cursor.getString(numberColumn));
			s.setCollect(cursor.getString(collectColumn));
			ss.add(s);			
		}
		cursor.close();
		return ss;
	}
	/**
	 * 得到学校收藏
	 * @param username
	 * @return 返回Cursor
	 */
	public ArrayList<School> selectSC() {
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_SCHOOL_COLLECT, null, null,
				null, null, null, null);
		ArrayList<School> ss = new ArrayList<School>();
		while(cursor.moveToNext()){
			School s = new School();
			int idColumn = cursor.getColumnIndex("id");
			int nameColumn = cursor.getColumnIndex("name");
			int provinceColumn = cursor.getColumnIndex("province");
			int gradeColumn = cursor.getColumnIndex("grade");
			int numberColumn = cursor.getColumnIndex("number");
			
			s.setId(cursor.getInt(idColumn));
			s.setName(cursor.getString(nameColumn));
			s.setProvince(cursor.getString(provinceColumn));
			s.setGrade(cursor.getString(gradeColumn));
			s.setNumber(cursor.getString(numberColumn));
			ss.add(s);			
		}
		cursor.close();
		return ss;
	}
	/**
	 * 更新学校是否收藏
	 * @param id
	 *            [唯一标识]
	 * @param AmbitusInfo
	 *            [周边信息实体类]
	 * @return long[该数据所在行数]
	 */
	public void updateS( School s) {
		
		String where = "id" + "=?";
		String[] whereValue = { s.getId()+"" };
		ContentValues cv = new ContentValues();
		cv.put("name", s.getName());
		cv.put("province", s.getProvince());
		cv.put("grade", s.getGrade());
		cv.put("number", s.getNumber());
		cv.put("collect", s.getCollect());
		SQLiteDatabase db = this.getWritableDatabase();
		db.update(TABLE_SCHOOL, cv, where, whereValue);
		
	}
}
