package com.figura4.lazysysadmin.view;

import com.figura4.lazysysadmin.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SshFragment extends Fragment {
	public static final String ARG_SHORTCUT_TYPE = "shortcut_type";
	
    public SshFragment() {
        // Empty constructor required for fragment subclasses
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ssh, container, false);
        return rootView;
    }
}
