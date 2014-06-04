package com.example.myges;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AccueilFragment extends Fragment {

	ImageView ivIcon;
	TextView tvItemName;

	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
	public static final String ITEM_NAME = "itemName";
	String pref = "com.example.myges";

	
	public AccueilFragment() {

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                  Bundle savedInstanceState) {
 
            View view = inflater.inflate(R.layout.accueil_layout, container,false);
 

            tvItemName = (TextView) view.findViewById(R.id.frag1_text);
           
            SharedPreferences recupLogin = getActivity().getSharedPreferences(pref, 0);
            String login = recupLogin.getString(LoginActivity.LOGIN_KEY, null);
            
            tvItemName.setText("Bienvenue sur Myges "+ login);
           
            return view;
      }
}