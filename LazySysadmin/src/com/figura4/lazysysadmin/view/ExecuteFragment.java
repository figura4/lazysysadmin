package com.figura4.lazysysadmin.view;

import com.figura4.lazysysadmin.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExecuteFragment extends Fragment {
	public static final String ARG_SHORTCUT_NUMBER = "shortcut_number";
	
    public ExecuteFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_execute, container, false);
        int i = getArguments().getInt(ARG_SHORTCUT_NUMBER);
        
        // TODO fetch titles from db
        String [] mMenuTitles = {"Dixie Flatline", "Henry Dorsett Case", "Settings", "New Shortcut"};

        getActivity().setTitle(mMenuTitles[i]);
        return rootView;
    }
}
