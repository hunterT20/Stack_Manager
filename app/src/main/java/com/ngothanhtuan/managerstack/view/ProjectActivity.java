package com.ngothanhtuan.managerstack.view;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ngothanhtuan.managerstack.R;
import com.ngothanhtuan.managerstack.view.AddProjectFragment;
import com.ngothanhtuan.managerstack.view.ListProjectFragment;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ListProjectFragment listProjectFragment = new ListProjectFragment();

        transaction.replace(R.id.frmProject,listProjectFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        MenuItem add = menu.findItem(R.id.ItemAdd);
        add.setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ItemAdd:
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                AddProjectFragment addProjectFragment = new AddProjectFragment();

                transaction.replace(R.id.frmProject,addProjectFragment);
                transaction.commit();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
