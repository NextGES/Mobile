package com.example.myges;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

	protected static final String LOGIN_KEY = "login";
	String login, password;
	Button boutonConnexion;
	EditText editLogin, editPassword;
	public CheckBox box;
	String pref = "com.example.myges";
	String login_Putted = "login enregistred";
	String passwdPutted = "password enregistred";
	String loginEnregistred,passwordEnregistred;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page_layout);
		
		//Si ona avait coché la checkbox
		SharedPreferences localSharedPreferences = getSharedPreferences(pref, MODE_PRIVATE);
		loginEnregistred = localSharedPreferences.getString(login_Putted, null);
		passwordEnregistred = localSharedPreferences.getString(passwdPutted, null);
		box = (CheckBox) findViewById(R.id.checkbox01);

		if(login_Putted != null){
			editLogin = (EditText) findViewById(R.id.login);
			editLogin.setBackgroundResource(R.drawable.custom_edittext);
			editLogin.setText(loginEnregistred);
			
			editPassword = (EditText) findViewById(R.id.password);
			editPassword.setBackgroundResource(R.drawable.custom_edittext);
			editPassword.setText(passwordEnregistred);
			box.setChecked(true);
		}
		else {
			editLogin = (EditText) findViewById(R.id.login);
			editLogin.setBackgroundResource(R.drawable.custom_edittext);
			
			editPassword = (EditText) findViewById(R.id.password);
			editPassword.setBackgroundResource(R.drawable.custom_edittext);
			if(box.isChecked()){
				box = (CheckBox) findViewById(R.id.checkbox01);
				box.toggle();
			}
		}
		
		
		View editLayout = findViewById(R.id.LayoutId);
		editLayout.setBackgroundResource(R.drawable.customlayout);

		boutonConnexion = (Button) findViewById(R.id.buttonConnexion);
		boutonConnexion.setBackgroundResource(R.drawable.custombutton);

		box = (CheckBox) findViewById(R.id.checkbox01);	
		
		
		
		boutonConnexion.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				login = editLogin.getText().toString();
				password = editPassword.getText().toString();

				if ((login.equals("")) && (password.equals(""))) {
					Toast.makeText(LoginActivity.this,"Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
					return;
				}
				if (login.equals("")) {
					Toast.makeText(LoginActivity.this,"Veuillez remplir le champ login",Toast.LENGTH_SHORT).show();
					return;
				}
				if (password.equals("")) {
					Toast.makeText(LoginActivity.this,"Veuillez remplir le champ password",Toast.LENGTH_SHORT).show();
					return;
				}

				startActivity(new Intent(LoginActivity.this, MainPage.class));

				SharedPreferences.Editor localeditor = getSharedPreferences(pref, Context.MODE_PRIVATE).edit();
				
				if (box.isChecked()) {

					
					localeditor.putString(login_Putted, login);
					localeditor.putString(passwdPutted, password);
					localeditor.commit();
				}
				else{
					localeditor.putString(login_Putted, "");
					localeditor.putString(passwdPutted, "");
					localeditor.commit();
				}
				boutonConnexion.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
				
				//Dans tous les cas je put le login dans une key pour l'afficher sur la page suivante.
				localeditor.putString(LOGIN_KEY, login);
				localeditor.commit();
				
				//Toast.makeText(LoginActivity.this, "login enregistré : "+login+" Password enregistré : "+password, Toast.LENGTH_SHORT).show();
			}
		});


	}

	@Override
	protected void onResume() {
		super.onResume();
		boutonConnexion = (Button) findViewById(R.id.buttonConnexion);
		boutonConnexion.setBackgroundResource(R.drawable.custombutton);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
