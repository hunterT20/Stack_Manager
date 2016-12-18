package com.ngothanhtuan.managerstack.view;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ngothanhtuan.managerstack.R;
import com.ngothanhtuan.managerstack.model.Project;
import com.ngothanhtuan.managerstack.model.Stack;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddStackFragment extends Fragment {

    EditText edtnameST, edtMotaST;

    Button btnAdd, btnCancel;
    String uid, namePR;
    Project project;

    private DatabaseReference mDatabase;


    public AddStackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_stack, container, false);

        addControls(view);
        addEvents();
        return view;
    }

    private void addEvents() {
        project = getArguments().getParcelable("project");
        namePR = getArguments().getString("namePR");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    uid = user.getUid();
                    Stack stack = new Stack();
                    stack.setDetailStack(edtMotaST.getText().toString());
                    stack.setNameStack(edtnameST.getText().toString());

                    mDatabase.child(uid).child("Project").child(namePR).setValue(project);
                    mDatabase.child(uid).child("Stack").child(project.getIdPR()).setValue(stack);
                }
            }
        });

    }

    private void addControls(View view) {
        edtnameST = (EditText) view.findViewById(R.id.edtNameST);
        edtMotaST = (EditText) view.findViewById(R.id.edtMotaST);

        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

}
