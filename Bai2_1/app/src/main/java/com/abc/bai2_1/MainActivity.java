package com.abc.bai2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String code;
    ListView listView;
    ArrayList<Country> listCountries;
    ArrayAdapter arrayAdapter;

    String countriesJSON = "https://raw.githubusercontent.com/dondyb/GeoNames-JSON/master/countries.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anh xa
        listView = (ListView) findViewById(R.id.listView);
        listCountries = new ArrayList<>();

        new ReadJSON().execute(countriesJSON);

        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1,listCountries);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CountryActivity.class);
                code = listCountries.get(position).getLink();
                intent.putExtra("code", code);
                if (code!=null){
                    startActivity(intent);
                }
            }
        });

    }

    private class ReadJSON extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {


                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";

                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONArray jsonArray = new JSONArray(s);
//                Toast.makeText(MainActivity.this, jsonArray.length()+"", Toast.LENGTH_LONG).show();
                for (int i = 0 ; i< jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    listCountries.add(new Country(jsonObject.getString
                        ("country_name"),
                            jsonObject.getString("country_code")));
                }
                arrayAdapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    private class Country{
    String name, link;

    public Country(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Country: " + name + "\nCode: "+ link;
    }
    }

}