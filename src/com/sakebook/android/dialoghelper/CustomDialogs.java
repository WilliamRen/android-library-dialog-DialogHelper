package com.sakebook.android.dialoghelper;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class CustomDialogs extends DialogFragment implements OnClickListener {
	
	public CustomDialogsListener mListener;

	public CustomDialogs() {
	}

	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof CustomDialogsListener == false) {  
			Log.w(DialogHelper.class.getSimpleName(), "FragmentActivity �� CustomDialogListener ���������Ă��܂���.");
			this.dismiss();
        }  
        this.mListener = ((CustomDialogsListener) activity);  
	}

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setStyle(STYLE_NO_FRAME, R.style.Theme_dialogLayout);
		setRetainInstance(true);
	}

	
	/** singleton. �󂯎����layoutId�ƃC�x���g���N��������View��Id��bundle�ɃZ�b�g */
	public static CustomDialogs newInstance(int bodyLayoutId, ArrayList<Integer> eventList) {
		CustomDialogs instance = new CustomDialogs();
		Bundle bundle = new Bundle();
		bundle.putInt("body", bodyLayoutId);
		bundle.putIntegerArrayList("eventList", eventList);
		instance.setArguments(bundle);
		
		return instance;
	}

	
	/** �_�C�A���O�̒������ύX�������ꍇ��������g���B */
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		if (Build.VERSION.SDK_INT <= 10) {
			return super.onCreateDialog(savedInstanceState);
		}

		LayoutInflater inflater = getActivity().getLayoutInflater();
		View body = inflater.inflate(getArguments().getInt("body"), null, false);
		
		ArrayList<Integer> eventList = getArguments().getIntegerArrayList("eventList");
		for (int i=0; i< eventList.size(); i++) {
			body.findViewById(eventList.get(i)).setOnClickListener(this);
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setView(body);
		
		return builder.create();
	}
	
	
	/** 
	 * 2.x��̓t���[�����c���Ă��܂��̂ŁAonCreateDialog�ł͂Ȃ���������g���ă_�C�A���O���ꂩ�琶���B
	 * bundle�ɃZ�b�g���ꂽ���������A���C�A�E�g��Ԃ��B */
	@Override  
	public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle) {
		if (Build.VERSION.SDK_INT > 10) {
			return super.onCreateView(inflater, view, bundle);
		}
		View body = inflater.inflate(getArguments().getInt("body"), null, false);

		ArrayList<Integer> eventList = getArguments().getIntegerArrayList("eventList");
		for (int i=0; i< eventList.size(); i++) {
			body.findViewById(eventList.get(i)).setOnClickListener(this);
		}
		return body;
	}
	
	
	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		mListener.customCancel(CustomDialogsListener.BUTTON_CANCEL);
	}


	@Override
	public void onClick(View v) {
		mListener.customClick(CustomDialogsListener.BUTTON_CLICK, v);
		dismiss();
	}
}
