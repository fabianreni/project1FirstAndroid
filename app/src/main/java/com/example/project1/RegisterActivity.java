package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    protected static int nrCallsP=0;
    protected static int nrCallsS=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle extra=getIntent().getExtras();
        if(extra!=null){
            String callingActivity=extra.getString("callingActivity","0");
            if(callingActivity.equals("Profile"))
                nrCallsP++;

            if(callingActivity.equals("SingIn"))
                nrCallsS++;
        }

        TextView tv_nrCallsS=findViewById(R.id.tv_numProfValue);
        tv_nrCallsS.setText(String.valueOf(nrCallsP));

        TextView tv_nrCallsR=findViewById(R.id.tv_numSingValue);
        tv_nrCallsR.setText(String.valueOf(nrCallsS));
    }
    public void register_buton(View view){
        Intent intent =new Intent(this,ProfilActivity.class);
        intent.putExtra("callingActivity","Register");

        EditText et_fname=findViewById(R.id.et_firstName);
        String s_firstName=et_fname.getText().toString();
        intent.putExtra("firstName",s_firstName);

        EditText et_lname=findViewById(R.id.et_lastName);
        String s_lastName=et_lname.getText().toString();
        intent.putExtra("lastName", s_lastName);

        EditText et_depart=findViewById(R.id.et_department);
        String s_department=et_depart.getText().toString();
        intent.putExtra("department",s_department);

        startActivity(intent);

    }
}
