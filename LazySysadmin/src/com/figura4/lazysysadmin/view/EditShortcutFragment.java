package com.figura4.lazysysadmin.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.figura4.lazysysadmin.R;

public class EditShortcutFragment extends Fragment implements OnItemSelectedListener {
	public static final String ARG_SHORTCUT_NUMBER = "shortcut_number";
	
    public EditShortcutFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_shortcut, container, false);
        int i = getArguments().getInt(ARG_SHORTCUT_NUMBER);
        
        // TODO fetch titles from db
        String [] mMenuTitles = {"Dixie Flatline", "Henry Dorsett Case", "New Shortcut", "Settings"};

        getActivity().setTitle(mMenuTitles[i]);
        
        
        // Setting up command type spinner
        Spinner spinner = (Spinner) rootView.findViewById(R.id.command_type_spinner);
	    // Create an ArrayAdapter using the string array and a default spinner layout
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(),
	    		R.array.command_types_array, android.R.layout.simple_spinner_item);
	    // Specify the layout to use when the list of choices appears
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    // Apply the adapter to the spinner
	    spinner.setAdapter(adapter);
	    spinner.setOnItemSelectedListener(this);
        
        return rootView;
    }
    
    public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    	
    	Fragment fragment;
    	Bundle args = new Bundle();
    	
    	switch(pos) {
    	case 0:
    		fragment = new SshFragment();
    		args.putInt(SshFragment.ARG_SHORTCUT_TYPE, pos);
    		break;
    	case 1:
    		fragment = new WolFragment();
    		args.putInt(WolFragment.ARG_SHORTCUT_TYPE, pos);
    		break;
    		
    	default:
    		fragment = new SshFragment();
    	}
    			
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.new_shortcut_frame, fragment).commit();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
