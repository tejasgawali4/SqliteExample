package in.techdrop.tejas.sqliteexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Carl_johnson on 28-11-2017.
 */

public class LandingActivity extends AppCompatActivity implements View.OnClickListener {

  Button btnSimpleDemo, btnAdvanceDemo;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.landing_activity);

    btnSimpleDemo = (Button) findViewById(R.id.btnSimpleDemo);
    btnAdvanceDemo = (Button) findViewById(R.id.btnAdvanceDemo);

    btnSimpleDemo.setOnClickListener(this);
    btnAdvanceDemo.setOnClickListener(this);
  }


  @Override
  public void onClick(View v) {
    if (btnSimpleDemo == v)
    {
      Intent i = new Intent(getApplicationContext(),MainActivity.class);
      startActivity(i);

    }
    else if (btnAdvanceDemo == v)
    {
      Intent i = new Intent(getApplicationContext(),AvdanceDemo.class);
      startActivity(i);
    }
  }
}
