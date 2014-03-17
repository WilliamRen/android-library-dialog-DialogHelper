package com.sakebook.android.dialoghelper;

import android.view.View;

/**
 * �_�C�A���O�̃C�x���g�̃R�[���o�b�N.
 * id�͂����Œ�`���ďꍇ�����ɗp����B
 * v�̓C�x���g���N����View�B
 * */
public interface CustomDialogsListener {
	
	public static final int BUTTON_CLICK = 1;
	public static final int BUTTON_CANCEL = 0;
	
	public void customClick(int id, View v);
	public void customCancel(int id);
}
