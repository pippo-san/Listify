package com.main.listify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GruppiAdapter extends ArrayAdapter<String> {
    Context context=null;

    public GruppiAdapter(Context context, ArrayList<String> listaGruppi) {
        super(context, 0, listaGruppi);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        String hotels = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_list_view_home, parent, false);
        }

        context=convertView.getContext();   //ReEdited to make the code work
        TextView textViewGruppo = (TextView) convertView.findViewById(R.id.itemTextView); // edited
        textViewGruppo.setTag("sassoi");

        textViewGruppo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("sas");
            }
        });
        return convertView;
        // return super.getView(position, convertView, parent);
    }
}
