package com.budiagungfajariyanto_f55121064;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.budiagungfajariyanto_f55121064.aplikasi_uts_budi064.R;

import java.util.ArrayList;
import java.util.Locale;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<List> lits;

    public ListAdapter(Context context) {
        this.context = context;
        lits = new ArrayList<>();
    }

    public void setMembers(ArrayList<List> members) {
        this.lits = members;
    }

    @Override
    public int getCount() {
        return lits.size();
    }

    @Override
    public Object getItem(int i) {
        return lits.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list,
                    viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        List member = (List) getItem(i);
        viewHolder.bind(member);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind (List member) {
            txtName.setText(member.getName());
            txtDescription.setText(member.getDescription());
            imgPhoto.setImageResource(member.getPhoto());
        }
    }
}

