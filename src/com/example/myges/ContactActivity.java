package com.example.myges;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class ContactActivity extends Fragment implements OnClickListener {

	ImageView ivIcon;
	TextView tvItemName;

	public static final String IMAGE_RESOURCE_ID = "iconResourceID";
	public static final String ITEM_NAME = "itemName";

	public ContactActivity() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.contact_layout, container, false);

		// ivIcon.setImageDrawable(view.getResources().getDrawable(
		// getArguments().getInt(IMAGE_RESOURCE_ID)));

		Button callPeter, callCaro, callStephanie, callMaylis, callLucile, callArnaud, callDaniel, callAurelien, callMayssa;
		Button mailPeter, mailCaro, mailStephanie, mailMaylis, mailLucile, mailArnaud, mailDaniel, mailAurelien, mailMayssa;

		callPeter = (Button) view.findViewById(R.id.callDirector);
		callCaro = (Button) view.findViewById(R.id.callCarolineP);
		callStephanie = (Button) view.findViewById(R.id.callStephanieP);
		callMaylis = (Button) view.findViewById(R.id.callMaylisL);
		callLucile = (Button) view.findViewById(R.id.callLucileM);
		callArnaud = (Button) view.findViewById(R.id.callArnaudP);
		callDaniel = (Button) view.findViewById(R.id.callDanielL);
		callAurelien = (Button) view.findViewById(R.id.callAurelienM);
		callMayssa = (Button) view.findViewById(R.id.callMayssaE);

		callPeter.setOnClickListener(this);
		callCaro.setOnClickListener(this);
		callStephanie.setOnClickListener(this);
		callMaylis.setOnClickListener(this);
		callLucile.setOnClickListener(this);
		callArnaud.setOnClickListener(this);
		callDaniel.setOnClickListener(this);
		callAurelien.setOnClickListener(this);
		callMayssa.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.callDirector:

			String DirectorNum = "01 53 95 15 98";
			Intent IntentCall = new Intent(Intent.ACTION_CALL);
			IntentCall.setData(Uri.parse("tel:" + Uri.encode(DirectorNum)));
			startActivity(IntentCall);

			break;

		default:
			break;
		}

	}

}