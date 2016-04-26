package com.example.oster.easycake;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.oster.easycake.adapter.AdapterPerson;
import com.example.oster.easycake.model.Person;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.Arrays;
import java.util.List;


public class FragmentList extends Fragment {

    private ListView lstPerson;

    private List<Person> personList;

    public FragmentList() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_list, container, false);

        lstPerson = (ListView) myView.findViewById(R.id.lstPerson);
        lstPerson.setAdapter(new AdapterPerson(getActivity()));

        inquiryPersonList();

        return myView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    // ----
    // Http Response
    // ----
    private void inquiryPersonListSuccess(String response) {
        Toast.makeText(getActivity(), "Response success." , Toast.LENGTH_LONG).show();
        Log.d(FragmentList.this.getClass().getSimpleName(), response.toString());

        Person[] personArr = new Gson().fromJson(response, Person[].class);
        personList = Arrays.asList(personArr);

        AdapterPerson adapterPerson = (AdapterPerson) lstPerson.getAdapter();
        adapterPerson.setPersonList(personList);
        adapterPerson.notifyDataSetChanged();
    }

    // ----
    // Initial method
    // ----
    private void inquiryPersonList() {
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplication());

        StringRequest personRequest = new StringRequest(
                Request.Method.GET,
                "http://128.199.91.60/users/list",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        inquiryPersonListSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Something wrong. " + error.getMessage() , Toast.LENGTH_LONG).show();
                    }
                }

        );
        queue.add(personRequest);
    }


}
