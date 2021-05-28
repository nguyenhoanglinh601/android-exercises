package com.abc.bai2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class VNDActivity extends AppCompatActivity {

    ListView listViewTieuDe;
    ArrayList<String> arrTieuDe,arrDescription;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_n_d);

        Intent intent = getIntent();
        String from = intent.getStringExtra("from");

        if (from!= null){
            anhXa();
            listViewTieuDe.setAdapter(arrayAdapter);

            new VNDActivity.ReadRSS().execute(from);

            listViewTieuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(VNDActivity.this, CoverterActivity.class);
                    intent.putExtra("description", arrDescription.get(position));
                    startActivity(intent);
                }
            });
        }

    }

    private void anhXa() {
        listViewTieuDe = (ListView) findViewById(R.id.listViewTieuDe);
        arrTieuDe = new ArrayList<>();
        arrDescription = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,arrTieuDe);
    }

    private class ReadRSS extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line ="";
                while((line = bufferedReader.readLine())!=null){
                    content.append(line+"\n");
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
//            Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            XMLDOMParser xmldomParser = new XMLDOMParser();
            Document document = xmldomParser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
//            Toast.makeText(MainActivity.this,"Item: "+ nodeList.getLength(),Toast.LENGTH_LONG).show();
            String tieuDe = "";
            String description = "";
            for (int i= 0; i < nodeList.getLength();i++){
                Element element = (Element) nodeList.item(i);
                tieuDe = xmldomParser.getValue(element,"title");
                description = xmldomParser.getValue(element,"description");
                arrTieuDe.add(tieuDe);
                arrDescription.add(description);
            }
            arrayAdapter.notifyDataSetChanged();

        }
    }
}