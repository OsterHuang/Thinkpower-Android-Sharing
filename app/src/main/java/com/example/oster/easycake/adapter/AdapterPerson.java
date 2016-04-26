package com.example.oster.easycake.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.oster.easycake.R;
import com.example.oster.easycake.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oster on 2016/4/5.
 */
public class AdapterPerson extends BaseAdapter {

    private Context context;

    private List<Person> personList = new ArrayList<>();

    public AdapterPerson(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout._item_person, parent, false);

            ViewHold viewHold = new ViewHold();
            viewHold.txtPersonAge = (TextView) convertView.findViewById(R.id.txtPersonAge);
            viewHold.txtPersonCareer = (TextView) convertView.findViewById(R.id.txtPersonCareer);
            viewHold.txtPersonName = (TextView) convertView.findViewById(R.id.txtPersonName);

            convertView.setTag(viewHold);
        }

        Person person = personList.get(position);

        ViewHold viewHold = (ViewHold) convertView.getTag();
        viewHold.txtPersonAge.setText(String.valueOf(person.getAge()));
        viewHold.txtPersonCareer.setText(person.getCareer());
        viewHold.txtPersonName.setText(person.getName());

        return convertView;
    }

    // ----
    // Getter & setter
    // ----


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public class ViewHold {
        TextView txtPersonName;
        TextView txtPersonCareer;
        TextView txtPersonAge;
    }
}
