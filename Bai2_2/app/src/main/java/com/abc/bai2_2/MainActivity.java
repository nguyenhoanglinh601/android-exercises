package com.abc.bai2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String from;
    ListView listView;
    ArrayList<Country> listCountry;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Anh xa
        listView = (ListView) findViewById(R.id.Countries);
        listCountry = new ArrayList<>();

        createListCountry();
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_expandable_list_item_1,listCountry);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, VNDActivity.class);
                from = listCountry.get(position).getLink();
                intent.putExtra("from", from);
                if (from!=null){
                    startActivity(intent);
                }
            }
        });

    }

    void createListCountry(){
        listCountry.add(new Country("AUD - Australian Dollar", "https://aud.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ALL - Albanian Lek", "https://all.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("DZD - Algerian Dinar", "https://dzd.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ARS - Argentine Peso", "https://ars.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("GBP - British Pound", "https://gbp.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BSD - Bahamian Dollar", "https://bsd.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BHD - Bahraini Dinar", "https://BHD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BDT - Bangladesh Taka", "https://BDT.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BBD - Barbados Dollar", "https://BBD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BZD - Belize Dollar", "https://BZD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BTN - Bhutan Ngultrum", "https://BTN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BOB - Bolivian Boliviano", "https://BOB.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BWP - Botswana Pula", "https://BWP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BRL - Brazilian Real", "https://BRL.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BND - Brunei Dollar", "https://BND.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BGN - Bulgarian Lev", "https://BGN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BIF - Burundi Franc", "https://BIF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CAD - Canadian Dollar", "https://CAD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CNY - Chinese Yuan", "https://CNY.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KHR - Cambodia Riel", "https://KHR.fxexchangerate.com/rss.xml"));

        listCountry.add(new Country("CVE - Cape Verde Escudo", "https://CVE.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("XOF - CFA Franc (BCEAO)", "https://XOF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("XAF - CFA Franc (BEAC)", "https://XAF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CLP - Chilean Peso", "https://CLP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("COP - Colombian Peso", "https://COP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KMF - Comoros Franc", "https://KMF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CRC - Costa Rica Colon", "https://CRC.fxexchangerate.com/rss.xml"));//
        listCountry.add(new Country("HRK - Croatian Kuna", "https://HRK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CUP - Cuban Peso", "https://CUP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CZK - Czech Koruna", "https://CZK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("EUR - Euro", "https://EUR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("DKK - Danish Krone", "https://DKK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("DJF - Djibouti Franc", "https://DJF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("DOP - Dominican Peso", "https://DOP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("XCD - East Caribbean Dollar", "https://XCD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("EGP - Egyptian Pound", "https://EGP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ETB - Ethiopian Birr", "https://ETB.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("FJD - Fiji Dollar", "https://FJD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("HKD - Hong Kong Dollar", "https://HKD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("IDR - Indonesian Rupiah", "https://IDR.fxexchangerate.com/rss.xml"));

        listCountry.add(new Country("INR - Indian Rupee", "https://INR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("GMD - Gambian Dalasi", "https://GMD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("GTQ - Guatemala Quetzal", "https://GTQ.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("GNF - Guinea Franc", "https://GNF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("GYD - Guyana Dollar", "https://GYD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("HTG - Haiti Gourde", "https://HTG.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("HNL - Honduras Lempira", "https://HNL.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("HUF - Hungarian Forint", "https://HUF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ISK - Iceland Krona", "https://ISK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("IRR - Iran Rial", "https://IRR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("IQD - Iraqi Dinar", "https://IQD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ILS - Israeli Shekel", "https://ILS.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("JPY - Japanese Yen", "https://JPY.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("JMD - Jamaican Dollar", "https://JMD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("JOD - Jordanian Dinar", "https://JOD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KZT - Kazakhstan Tenge", "https://KZT.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KES - Kenyan Shilling", "https://KES.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KRW - Korean Won", "https://KRW.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KWD - Kuwaiti Dinar", "https://KWD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("LAK - Lao Kip", "https://LAK.fxexchangerate.com/rss.xml"));

        listCountry.add(new Country("LBP - Lebanese Pound", "https://LBP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("LSL - Lesotho Loti", "https://LSL.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("LRD - Liberian Dollar", "https://LRD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("LYD - Libyan Dinar", "https://LYD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MOP - Macau Pataca", "https://MOP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MKD - Macedonian Denar", "https://MKD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MWK - Malawi Kwacha", "https://MWK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MYR - Malaysian Ringgit", "https://MYR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MVR - Maldives Rufiyaa", "https://MVR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MRO - Mauritania Ougulya", "https://MRO.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MUR - Mauritius Rupee", "https://MUR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MXN - Mexican Peso", "https://MXN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MDL - Moldovan Leu", "https://MDL.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MNT - Mongolian Tugrik", "https://MNT.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MAD - Moroccan Dirham", "https://MAD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MMK - Myanmar Kyat", "https://MMK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("NAD - Namibian Dollar", "https://NAD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("NPR - Nepalese Rupee", "https://NPR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("NZD - New Zealand Dollar", "https://NZD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("NIO - Nicaragua Cordoba", "https://NIO.fxexchangerate.com/rss.xml"));

        listCountry.add(new Country("NGN - Nigerian Naira", "https://NGN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KPW - North Korean Won", "https://KPW.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("NOK - Norwegian Krone", "https://NOK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("OMR - Omani Rial", "https://OMR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("PKR - Pakistani Rupee", "https://PKR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("PGK - Papua New Guinea Kina", "https://PGK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("PYG - Paraguayan Guarani", "https://PYG.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("PEN - Peruvian Nuevo Sol", "https://PEN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("PHP - Philippine Peso", "https://PHP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("PLN - Polish Zloty", "https://PLN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("QAR - Qatar Rial", "https://QAR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("RON - Romanian New Leu", "https://RON.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("RUB - Russian Rouble", "https://RUB.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("RWF - Rwanda Franc", "https://RWF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CHF - Swiss Franc", "https://CHF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("WST - Samoa Tala", "https://WST.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SAR - Saudi Arabian Riyal", "https://SAR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SCR - Seychelles Rupee", "https://SCR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SLL - Sierra Leone Leone", "https://SLL.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SGD - Singapore Dollar", "https://SGD.fxexchangerate.com/rss.xml"));

        listCountry.add(new Country("SBD - Solomon Islands Dollar", "https://SBD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SOS - Somali Shilling", "https://SOS.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ZAR - South African Rand", "https://ZAR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("LKR - Sri Lanka Rupee", "https://LKR.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SDG - Sudanese Pound", "https://SDG.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SZL - Swaziland Lilageni", "https://SZL.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SEK - Swedish Krona", "https://SEK.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SYP - Syrian Pound", "https://SYP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("USD - United States Dollar", "https://USD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("THB - Thai Baht", "https://THB.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("TRY - Turkish Lira", "https://TRY.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("TWD - Taiwan Dollar", "https://TWD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("TZS - Tanzanian Shilling", "https://TZS.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("TOP - Tongan paʻanga", "https://TOP.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("TTD - Trinidad Tobago Dollar", "https://TTD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("TND - Tunisian Dinar", "https://TND.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("AED - UAE Dirham", "https://AED.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("UGX - Ugandan Shilling", "https://UGX.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("UAH - Ukraine Hryvnia", "https://UAH.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("UYU - Uruguayan New Peso", "https://UAH.fxexchangerate.com/rss.xml"));

        listCountry.add(new Country("VUV - Vanuatu Vatu", "https://VUV.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("VND - Vietnam Dong", "https://VND.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("YER - Yemen Riyal", "https://YER.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("UZS - Uzbekistan Sum", "https://UZS.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("KGS - Kyrgyzstan Som", "https://KGS.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("GHS - Ghanaian Cedi", "https://GHS.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BYN - Belarusian ruble", "https://BYN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("AFN - Afghan afghani", "https://AFN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("AOA - Angolan kwanza", "https://AOA.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("AMD - Armenian dram", "https://AMD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("AMD - Azerbaijani manat", "https://AMD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("BAM - Convertible mark", "https://BAM.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("CDF - Congolese franc", "https://CDF.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ERN - Eritrean nakfa", "https://ERN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("GEL - Georgian lari", "https://GEL.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MGA - Malagasy ariary", "https://MGA.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("MZN - Mozambican metical", "https://MZN.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("RSD - Serbian dinar", "https://RSD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("SRD - Surinamese dollar", "https://SRD.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("TJS - Tajikistani somoni", "https://TJS.fxexchangerate.com/rss.xml"));

        listCountry.add(new Country("TMT - Turkmenistan manat", "https://TMT.fxexchangerate.com/rss.xml"));
        listCountry.add(new Country("ZMW - Zambian kwacha", "https://ZMW.fxexchangerate.com/rss.xml"));
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
            return "Country:" + name ;
        }
    }

}