package in.techdrop.tejas.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Carl_johnson on 28-11-2017.
 */

public class MyDBFunctions extends SQLiteOpenHelper{

  private static final String DATABASE_NAME = "advancedemo";
  private static final String TABLE_NAME = "user";

  private Context context;
  private static final String TAB_ID = "user_id";
  private static final String TAB_NAME = "name";
  private static final String TAB_AGE = "age";

  public MyDBFunctions(Context context) {
    super(context, DATABASE_NAME, null, 1);
    this.context = context;
  }

  public MyDBFunctions(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
    super(context, DATABASE_NAME, null, 1, errorHandler);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

      String q1 = "CREATE TABLE "+TABLE_NAME+" ("+TAB_ID+"INTEGER PRIMARY KEY,"+TAB_NAME+" VARCHAR(30), "+TAB_AGE+" VARCHAR(30))";
      db.execSQL(q1);

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  /*Adding Data to Database*/

  /**
   *
   * @param dt
   */
  void addingDataToTable(DataTemp dt)
  {
      SQLiteDatabase sqldb = this.getWritableDatabase();

      ContentValues cv = new ContentValues();
      cv.put(TAB_NAME,dt.getName());
      cv.put(TAB_AGE,dt.getAge());

      sqldb.insert(TABLE_NAME,null,cv);

      Toast.makeText(context,"Inserted Successfully..",Toast.LENGTH_SHORT).show();

      sqldb.close();
  }

  /*Showing Data*/

  String[] myData ()
  {
      SQLiteDatabase sql = this.getWritableDatabase();

      String q = "SELECT * FROM "+TABLE_NAME;

      Cursor c =  sql.rawQuery(q,null);

      String[] reciveData = new String[c.getCount()];

      if (c.moveToFirst())
      {
          int Counter = 0;
          do {
            reciveData[Counter] = c.getString(c.getColumnIndex(TAB_NAME+"")) + "\n Age: "+
              c.getString(c.getColumnIndex(TAB_AGE+""));
            Counter = Counter+1;
          }while (c.moveToNext());
      }

    return reciveData;
  }


}
