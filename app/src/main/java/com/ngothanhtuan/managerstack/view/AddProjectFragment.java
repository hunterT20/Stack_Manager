package com.ngothanhtuan.managerstack.view;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ngothanhtuan.managerstack.R;
import com.ngothanhtuan.managerstack.model.Project;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddProjectFragment extends Fragment{
    EditText edtName, edtType, edtChitiet;
    Button btnCancel,btnNext;

    private DatabaseReference mDatabase;

    public AddProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_project, container, false);

        addControls(view);
        addEvents();
        return view;
    }

    private void addControls(View view) {
        edtName = (EditText) view.findViewById(R.id.edtName);
        edtType = (EditText) view.findViewById(R.id.edtType);
        edtChitiet = (EditText) view.findViewById(R.id.edtChitiet);

        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    private void addEvents() {
        //set event Button Cancel
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                ListProjectFragment listProjectFragment = new ListProjectFragment();

                transaction.replace(R.id.frmProject,listProjectFragment);
                transaction.commit();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Project project = new Project();
                project.setDetailPR(edtChitiet.getText().toString());
                project.setTypePR(edtType.getText().toString());
                project.setNamePR(edtName.getText().toString());
                project.setIdPR("1");

                AddStackFragment addStackFragment = new AddStackFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("project",project);
                bundle.putString("namePR",edtName.getText().toString());
                addStackFragment.setArguments(bundle);


                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.frmProject,addStackFragment);
                transaction.commit();
            }
        });

    }
}
