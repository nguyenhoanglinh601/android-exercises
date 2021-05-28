package com.abc.bai2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CountryActivity extends AppCompatActivity {

    TextView capital,languages,south,north,population,east,areaInSqKm,west,countryName,postalCodeFormat,continentName,currencyCode;
    ImageView flag;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        //http://api.geonames.org/countryInfoJSON?lang=it&country=TW&username=tony_842000

        anhXa();

        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        String countryJSON = "http://api.geonames.org/countryInfoJSON?lang=it&country="+code+"&username=tony_842000";
//        String countryJSON = "http://api.geonames.org/countryInfoJSON?lang=it&country=VN&username=tony_842000";

        new ReadJSON().execute(countryJSON);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CountryActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    private void anhXa() {
        capital     = (TextView) findViewById(R.id.capital);
        languages   = (TextView) findViewById(R.id.languages);
        south       = (TextView) findViewById(R.id.south);
        north       = (TextView) findViewById(R.id.north);
        population = (TextView) findViewById(R.id.population);
        east        = (TextView) findViewById(R.id.east);
        areaInSqKm  = (TextView) findViewById(R.id.areaInSqKm);
        west        = (TextView) findViewById(R.id.west);
        countryName = (TextView) findViewById(R.id.countryName);
        postalCodeFormat = (TextView) findViewById(R.id.postalCodeFormat);
        continentName   = (TextView) findViewById(R.id.continentName);
        currencyCode    = (TextView) findViewById(R.id.currencyCode);

        flag = (ImageView) findViewById(R.id.flag);

        back = (Button) findViewById(R.id.back);
    }

//    private class Country {
//        String capital,languages,south,north,population,east,areaInSqKm,west,countryName,postalCodeFormat,continentName,currencyCode;
//
//        @Override
//        public String toString() {
//            return "Country{" +
//                    "capital='" + capital + '\'' +
//                    ", languages='" + languages + '\'' +
//                    ", south='" + south + '\'' +
//                    ", north='" + north + '\'' +
//                    ", population='" + population + '\'' +
//                    ", east='" + east + '\'' +
//                    ", areaInSqKm='" + areaInSqKm + '\'' +
//                    ", west='" + west + '\'' +
//                    ", countryName='" + countryName + '\'' +
//                    ", postalCodeFormat='" + postalCodeFormat + '\'' +
//                    ", continentName='" + continentName + '\'' +
//                    ", currencyCode='" + currencyCode + '\'' +
//                    '}';
//        }
//
//        public String getCapital() {
//            return capital;
//        }
//
//        public void setCapital(String capital) {
//            this.capital = capital;
//        }
//
//        public String getLanguages() {
//            return languages;
//        }
//
//        public void setLanguages(String languages) {
//            this.languages = languages;
//        }
//
//        public String getSouth() {
//            return south;
//        }
//
//        public void setSouth(String south) {
//            this.south = south;
//        }
//
//        public String getNorth() {
//            return north;
//        }
//
//        public void setNorth(String north) {
//            this.north = north;
//        }
//
//        public String getPopulation() {
//            return population;
//        }
//
//        public void setPopulation(String population) {
//            this.population = population;
//        }
//
//        public String getEast() {
//            return east;
//        }
//
//        public void setEast(String east) {
//            this.east = east;
//        }
//
//        public String getAreaInSqKm() {
//            return areaInSqKm;
//        }
//
//        public void setAreaInSqKm(String areaInSqKm) {
//            this.areaInSqKm = areaInSqKm;
//        }
//
//        public String getWest() {
//            return west;
//        }
//
//        public void setWest(String west) {
//            this.west = west;
//        }
//
//        public String getCountryName() {
//            return countryName;
//        }
//
//        public void setCountryName(String countryName) {
//            this.countryName = countryName;
//        }
//
//        public String getPostalCodeFormat() {
//            return postalCodeFormat;
//        }
//
//        public void setPostalCodeFormat(String postalCodeFormat) {
//            this.postalCodeFormat = postalCodeFormat;
//        }
//
//        public String getContinentName() {
//            return continentName;
//        }
//
//        public void setContinentName(String continentName) {
//            this.continentName = continentName;
//        }
//
//        public String getCurrencyCode() {
//            return currencyCode;
//        }
//
//        public void setCurrencyCode(String currencyCode) {
//            this.currencyCode = currencyCode;
//        }
//
//        public Country(String capital, String languages, String south, String north, String population, String east, String areaInSqKm, String west, String countryName, String postalCodeFormat, String continentName, String currencyCode) {
//            this.capital = capital;
//            this.languages = languages;
//            this.south = south;
//            this.north = north;
//            this.population = population;
//            this.east = east;
//            this.areaInSqKm = areaInSqKm;
//            this.west = west;
//            this.countryName = countryName;
//            this.postalCodeFormat = postalCodeFormat;
//            this.continentName = continentName;
//            this.currencyCode = currencyCode;
//        }
//    }

    private class ReadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(@NotNull String... strings) {
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
                Toast.makeText(CountryActivity.this, "Front ", Toast.LENGTH_LONG).show();
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("geonames");
                for (int i = 0 ; i< jsonArray.length();i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    capital.setText("Thủ đô: "+jsonObject1.getString("capital"));
                    languages.setText("Ngôn ngữ: "+jsonObject1.getString("languages"));
                    south.setText("Phía Nam: "+jsonObject1.getString("south"));
                    north.setText("Phía Bắc: "+jsonObject1.getString("north"));
                    population.setText("Dân số: "+jsonObject1.getString("population"));
                    east.setText("Phía Đông: "+jsonObject1.getString("east"));
                    areaInSqKm.setText("Diện tích (\"\\u33A2\"): "+jsonObject1.getString("areaInSqKm"));
                    west.setText("Phía Tây: "+jsonObject1.getString("west"));
                    countryName.setText(jsonObject1.getString("countryName")+"");
                    postalCodeFormat.setText("Định dạng mã bưu chính: "+jsonObject1.getString("postalCodeFormat"));
                    continentName.setText("Châu lục: "+jsonObject1.getString("continentName"));
                    currencyCode.setText("Mã tiền tệ: "+jsonObject1.getString("currencyCode"));

                    String countryCode = jsonObject1.getString("countryCode").toLowerCase();

                    String urlFlag = "https://img.geonames.org/flags/x/"+countryCode+".gif";
                    Glide.with(CountryActivity.this).load(urlFlag).into(flag);

                }

            } catch (JSONException e) {
                Toast.makeText(CountryActivity.this, "ERROR ", Toast.LENGTH_LONG).show();

                e.printStackTrace();
            }

        }
    }
}