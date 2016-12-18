package com.ngothanhtuan.managerstack.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngothanhtuan.managerstack.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListStackFragment extends Fragment {


    public ListStackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_stack, container, false);
    }

}
