package in.techdrop.tejas.sqliteexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class AvdanceDemo extends AppCompatActivity {

  EditText etName ,etAge;
  Button btnSave,btnShow;
  ListView lv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_avdance_demo);

    etName = (EditText) findViewById(R.id.name);
    etAge = (EditText) findViewById(R.id.age);
    lv = (ListView) findViewById(R.id.listView);

    btnSave = (Button) findViewById(R.id.btnSave);
    btnShow = (Button) findViewById(R.id.btnShow);

    final MyDBFunctions mf = new MyDBFunctions(getApplicationContext());

    btnSave.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v)
      {
        String _name = etName.getText().toString();
        String _age = etAge.getText().toString();
        int id = 0;

        Log.d("name",""+_name);
        Log.d("_age",""+_age);
        DataTemp ft = new DataTemp(id,_name,_age);

        mf.addingDataToTable(ft);

      }
    });

    btnShow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v)
      {
          GetDateFromSQLite();
      }
    });

  }

  private void GetDateFromSQLite()
  {
      final MyDBFunctions mf =  new MyDBFunctions(getApplicationContext());

      String[] data = mf.myData();

      String s = "";
      Log.d("data",""+data);

      for (int i=0 ; i< data.length;i++)
      {
        s = s + data[i]+"\n\n";
      }

      

      lv.setAdapter(new BaseAdapter() {
        @Override
        public int getCount() {
          return 0;
        }

        @Override
        public Object getItem(int position) {
          return position;
        }

        @Override
        public long getItemId(int position) {
          return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {

            return null;
        }
      });
  }

}
