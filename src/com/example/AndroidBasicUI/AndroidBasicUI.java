package com.example.AndroidBasicUI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AndroidBasicUI extends Activity
{
    Button login_btLogin;
    EditText login_userName;
    EditText login_password;
    private static final String notifyInputBlank = "All field must not null";
    private static final String notifyAccountNotExist = "Account is not exist";
    private static final String notifyLoginSuccess = "Login is Success";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupViewLogin();
        login_btLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(checkLogin(login_userName, login_password)!=null && checkLogin(login_userName,login_password))
                {
                    Intent detailActivity = new Intent(v.getContext(), DetailActivity.class);
                    detailActivity.putExtra("account", login_userName.getText().toString());
                    v.getContext().startActivity(detailActivity);
                    finish();
                }
            }
        });
    }


    private Boolean checkLogin(EditText login_userName, EditText login_password)
    {
        String userName= login_userName.getText().toString();
        String password= login_password.getText().toString();
        if(userName.equals("android") && password.equals("1234"))
        {
            Toast.makeText(getApplicationContext(), notifyLoginSuccess , Toast.LENGTH_SHORT ).show();
            return true;
        }
        else if(userName.equals("") || password.equals(""))
        {
            Toast.makeText(getApplicationContext(), notifyInputBlank , Toast.LENGTH_SHORT ).show();
            return null;
        }
        else
        {
            Toast.makeText(getApplicationContext(), notifyAccountNotExist , Toast.LENGTH_SHORT ).show();
            return false;
        }
    }

    private void setupViewLogin()
    {
        login_btLogin = (Button) findViewById(R.id.login_btLogin);
        login_userName = (EditText) findViewById(R.id.login_etUserName);
        login_password = (EditText) findViewById(R.id.login_etPassWord);
    }
}
