package com.sakebook.android.dialoghelper;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/**
 * Dialog���Ăяo���N���X�B
 * */
public class DialogHelper {
	
	
	/**
	 * �ʏ�̃_�C�A���O���Ăяo���B
	 * @param context �R���e�L�X�g�B�e�N���X��FragmentActivity���p�����Ă���K�v������B
	 * @param title �_�C�A���O�̃^�C�g���B�s�v�ȏꍇ��null������B
	 * @param message �_�C�A���O�̓��e�B�s�v�ȏꍇ��null������B
	 * @param positive �|�W�e�B�u�{�^���B�s�v�ȏꍇ��null������B
	 * @param negative �l�K�e�B�u�{�^���B�s�v�ȏꍇ��null������B
	 * @param neutral �j���[�g�����{�^���B�s�v�ȏꍇ��null������B
	 * @param tag �^�O�B�s�v�ȏꍇ��null������B
	 * */
	public static void callDialog(Context context, String title, 
			String message, String positive, String negative, String neutral, String tag) {
		if (checkExtends(context)) {
			FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
			SimpleDialogs dialog = SimpleDialogs.newInstance(title, message, positive, negative, neutral);
			dialog.show(manager, tag);
		}
	}
	
	
	/**
	 * �ʏ�̃_�C�A���O���Ăяo���B
	 * @param context �R���e�L�X�g�B�e�N���X��FragmentActivity���p�����Ă���K�v������B
	 * @param titleId �_�C�A���O�̃^�C�g���B�s�v�ȏꍇ��0������B
	 * @param messageId �_�C�A���O�̓��e�B�s�v�ȏꍇ��0������B
	 * @param positiveId �|�W�e�B�u�{�^���B�s�v�ȏꍇ��0������B
	 * @param negativeId �l�K�e�B�u�{�^���B�s�v�ȏꍇ��0������B
	 * @param neutralId �j���[�g�����{�^���B�s�v�ȏꍇ��0������B
	 * @param tag �^�O�B�s�v�ȏꍇ��null������B
	 * */
	public static void callDialog(Context context, int titleId, int messageId, 
			int positiveId, int negativeId, int neutralId, String tag) {
		if (checkExtends(context)){
			FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
			SimpleDialogs dialog = SimpleDialogs.newInstance(titleId, messageId, positiveId, negativeId, neutralId);
			dialog.show(manager, tag);
		}
	}
	
	
	/**
	 * CustomLayout�̃_�C�A���O���g���ꍇ�ɗp����B
	 * @param context �R���e�L�X�g�B�e�N���X��FragmentActivity���p�����Ă���K�v������B
	 * @param layoutId ���p���������C�A�E�g��ID�B
	 * @param eventList �N���b�N�C�x���g���N��������View��ID���l�߂�B
	 * @param tag �^�O�B�s�v�ȏꍇ��null������B
	 * */
	public static void callCustomDialog(Context context, int layoutId, ArrayList<Integer> eventList, String tag) {
		if (checkExtends(context)){
			FragmentManager manager = ((FragmentActivity)context).getSupportFragmentManager();
	        CustomDialogs dialogFragment = CustomDialogs.newInstance(layoutId, eventList);
	        dialogFragment.show(manager, tag);
		}
	}
	
	private static boolean checkExtends(Context context) {
		if (context instanceof FragmentActivity == false) {  
			Log.w(DialogHelper.class.getSimpleName(), "FragmentActivity ���p�����Ă��܂���.");
			return false;
        }  
		return true;
	}

}
