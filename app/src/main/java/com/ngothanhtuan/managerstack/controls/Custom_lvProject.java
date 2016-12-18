package com.ngothanhtuan.managerstack.controls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ngothanhtuan.managerstack.R;
import com.ngothanhtuan.managerstack.model.Project;
import com.ngothanhtuan.managerstack.model.Stack;

import java.util.ArrayList;

/**
 * Created by MyPC on 12/18/2016.
 */

public class Custom_lvProject extends BaseAdapter {

    Context c;
    ArrayList<Project> project;

    public Custom_lvProject(Context c, ArrayList<Project> project) {
        this.c = c;
        this.project = project;
    }

    @Override
    public int getCount() {
        return project.size();
    }

    @Override
    public Object getItem(int position) {
        return project.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.custom_lvproject,parent,false);
        }
        TextView txtvNamepr = (TextView) convertView.findViewById(R.id.txtvNamePr);

        Project project = (Project) this.getItem(position);
        txtvNamepr.setText(project.getNamePR());
        return convertView;
    }
}
