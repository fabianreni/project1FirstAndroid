package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfilActivity extends AppCompatActivity {
    protected static int nrCallsS=0;
    protected static int nrCallsR=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        Intent intent=getIntent();
        String  s_firstName=intent.getStringExtra("firstName");
        String  s_lastName=intent.getStringExtra("lastName");
        String  s_department=intent.getStringExtra("department");
        String  callingActivity=intent.getStringExtra("callingActivity");

        TextView tv_firstName=findViewById(R.id.tv_firstName);
        tv_firstName.setText(s_firstName);

        TextView tv_lastName=findViewById(R.id.tv_lastName);
        tv_lastName.setText(s_lastName);

        TextView tv_department=findViewById(R.id.tv_dep);
        tv_department.setText(s_department);

        if(callingActivity.equals("SingIn")){
            nrCallsS++;
        }
        if(callingActivity.equals("Register")){
            nrCallsR++;
        }
        TextView tv_nrCallsS=findViewById(R.id.tv_numSingValue);
        tv_nrCallsS.setText(String.valueOf(nrCallsS));

        TextView tv_nrCallsR=findViewById(R.id.tv_numRegValue);
        tv_nrCallsR.setText(String.valueOf(nrCallsR));

    }
    public void backButon (View view){
        Intent intent=getIntent();
        String callingActivity=intent.getStringExtra("callingActivity");

        if(callingActivity.equals("SingIn")){
            Intent intent1=new Intent(this ,MainActivity.class);
            intent1.putExtra("callingActivity","Profile");
            startActivity(intent1);
        }
      if(callingActivity.equals("Register")){
           Intent intent1=new Intent(this ,RegisterActivity.class);
           intent1.putExtra("callingActivity","Profile");

           TextView tv_firstName=findViewById(R.id.tv_firstName);
           String fName=tv_firstName.getText().toString();
           intent1.putExtra("firstName",fName);

           TextView tv_lastName=findViewById(R.id.tv_lastName);
           String lName=tv_lastName.getText().toString();
           intent1.putExtra("lastName",lName);

           TextView tv_department=findViewById(R.id.tv_dep);
           String dep=tv_department.getText().toString();
           intent1.putExtra("department",dep);

           startActivity(intent1);
       }
    }
}
