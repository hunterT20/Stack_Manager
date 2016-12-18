package com.ngothanhtuan.managerstack.view;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ngothanhtuan.managerstack.R;
import com.ngothanhtuan.managerstack.controls.Custom_lvProject;
import com.ngothanhtuan.managerstack.model.Project;
import com.ngothanhtuan.managerstack.model.Stack;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListProjectFragment extends Fragment {

    ListView lvProject;
    Custom_lvProject adapter;

    DatabaseReference db;
    ArrayList<Project> list;
    private DatabaseReference mDatabase;


    public ListProjectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_project, container, false);
        addControls(view);
        addEvents();

        return view;
    }

    private void addControls(View view) {
        lvProject = (ListView) view.findViewById(R.id.lvProject);

        db = FirebaseDatabase.getInstance().getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        list = new ArrayList<>();
    }

    private void addEvents() {
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase.child(user.getUid()).child("Project").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Project project = dataSnapshot.getValue(Project.class);
                list.add(project);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        adapter = new Custom_lvProject(getActivity(),list);
        lvProject.setAdapter(adapter);

        lvProject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                mDatabase.child(user.getUid()).child("Stack").child(list.get(position).getIdPR()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Stack stack = dataSnapshot.getValue(Stack.class);
                        Toast.makeText(getActivity(), stack.getNameStack().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
