package in.techdrop.tejas.sqliteexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AgeOfFriend extends AppCompatActivity {

  TextView etName ,etAge;
  Button btnSave,btnShow;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_age_of_friend);

      etName = (TextView) findViewById(R.id.txtName);
      etAge = (TextView) findViewById(R.id.txtAge);

      btnSave = (Button) findViewById(R.id.btnSave);
      btnShow = (Button) findViewById(R.id.btnShow);

      final MyDBFunctions mf =  new MyDBFunctions(getApplicationContext());

      btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String[] data = mf.myData();

            String s = "";
            Log.d("data",""+data);

            for (int i=0 ; i< data.length;i++)
            {
                s = s + data[i]+"\n\n";
            }

            etName.setText(s);
        }
      });

  }
}
