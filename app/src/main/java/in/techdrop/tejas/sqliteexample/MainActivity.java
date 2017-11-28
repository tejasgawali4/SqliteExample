package in.techdrop.tejas.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  Button btnAdd , btnView ;
  EditText txtName , txtAge ;
  SQLiteDatabase myDatabase;
  ListView lv;
  ArrayList<String> name;
  ArrayList<Integer> age;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtName = (EditText) findViewById(R.id.name);
    txtAge = (EditText) findViewById(R.id.age);
    btnAdd = (Button) findViewById(R.id.btnAdd);
    btnView = (Button) findViewById(R.id.btnView);
    // Get a handle to the list view
    lv = (ListView) findViewById(R.id.listView);



    try
    {
//      Initialization
        myDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

//      Create new Database or Open Existing One
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

//
////      Delete User From perticular Users
//        myDatabase.execSQL("DELETE FROM users WHERE name = 'Cody' LIMIT 1");
//
////      Updating Values In Table
//        myDatabase.execSQL("UPDATE users SET age = 2 WHERE name = 'Rob' LIMIT 1");

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

  }

  void AddUser(View v)
  {
        String name = txtName.getText().toString();
        int age = Integer.parseInt(txtAge.getText().toString());

//      Insert into users
        myDatabase.execSQL("INSERT INTO users (name , age ) VALUES ('" + name + "'," + age + " )");

        Toast.makeText(getApplicationContext(),"Added User Successfully...",Toast.LENGTH_SHORT).show();
  }

  void ViewUser(View v)
  {
    Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);

    int nameIndex = c.getColumnIndex("name");
    int ageIndex = c.getColumnIndex("age");

    c.moveToFirst();

    while (c != null)
    {
        Log.i("Name:-" , c.getString(nameIndex));
        Log.i("Age" , Integer.toString(c.getInt(ageIndex)));

        name = new ArrayList<String>();//Creating arraylist
        name.add(c.getString(nameIndex));//Adding object in arraylist

        Log.i("Array List Name :- " , String.valueOf(name));

        age = new ArrayList<Integer>();//Creating arraylist
        age.add(Integer.valueOf(c.getString(ageIndex)));//Adding object in arraylist

        c.moveToNext();
    }

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
    lv.setAdapter(arrayAdapter);
  }




}
