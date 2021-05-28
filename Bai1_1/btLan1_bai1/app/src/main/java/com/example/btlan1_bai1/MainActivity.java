package com.example.btlan1_bai1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button btnPlaceOrder, btnViewDetail, btnViewAddress;
    RadioButton rdoSizeLarge, rdoSizeMedium, rdoTortiallaCorn, rdoTortiallaFlour;
    CheckBox cbBeef, cbChicken, cbWhiteFish, cbRice, cbSeaFood, cbBean;
    SmsManager sms = SmsManager.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        sendMSG();
        viewDetailOrders();
        viewAddress();
    }

    private void initial() {
        btnPlaceOrder = findViewById(R.id.button_place);
        btnViewDetail = findViewById(R.id.button_detail);
        btnViewAddress = findViewById(R.id.button_address);
        rdoSizeLarge = findViewById(R.id.radioButtonSizeLagre);
        rdoSizeMedium = findViewById(R.id.radioButtonSizeMedium);
        rdoTortiallaCorn = findViewById(R.id.radioButtonTortiallaCorn);
        rdoTortiallaFlour = findViewById(R.id.radioButtonTortiallaFlour);
        cbBeef = findViewById(R.id.checkBoxBeef);
        cbChicken = findViewById(R.id.checkBoxChicken);
        cbWhiteFish = findViewById(R.id.checkBoxWhiteFish);
        cbRice = findViewById(R.id.checkBoxRice);
        cbSeaFood = findViewById(R.id.checkBoxSeaFood);
        cbBean = findViewById(R.id.checkBoxBean);
    }

    private void sendMSG() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Thông báo");
        b.setMessage("Bạn chưa chọn Loại bánh hoặc Kích cỡ");
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phonenumber = "0888888888";
                String message = "TOCO order: \n Cở bánh:\n";
                if(rdoSizeLarge.isChecked()){
                    message = message + rdoSizeLarge.getText() + ";\n ";
                }
                else if(rdoSizeMedium.isChecked()){
                    message += rdoSizeMedium.getText();
                    message += ";\n ";
                }
                message += "\nLoại vỏ:\n";
                if(rdoTortiallaCorn.isChecked()){
                    message += rdoTortiallaCorn.getText();
                    message += ";\n ";
                }
                if(rdoTortiallaFlour.isChecked()){
                    message += rdoTortiallaFlour.getText();
                    message += ";\n ";
                }
                message += "Nhân bánh:\n";
                if(cbBeef.isChecked()){
                    message += cbBeef.getText();
                    message += ";\n ";
                }
                if(cbChicken.isChecked()){
                    message += cbChicken.getText();
                    message += ";\n ";
                }
                if(cbWhiteFish.isChecked()){
                    message += cbWhiteFish.getText();
                    message += ";\n ";
                }
                if(cbRice.isChecked()){
                    message += cbRice.getText();
                    message += ";\n ";
                }
                if(cbSeaFood.isChecked()){
                    message += cbSeaFood.getText();
                    message += ";\n ";
                }
                if(cbBean.isChecked()){
                    message += cbBean.getText();
                    message += ";\n ";
                }

                if( (message.indexOf("Lớn")<=-1 && message.indexOf("Vừa")<=-1) || (message.indexOf("Bột bắp")<=-1 && message.indexOf("Bột mì")<=-1)) {
                    AlertDialog al = b.create();
                    al.show();
                }
                else {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + phonenumber));
                    intent.putExtra("sms_body", message);
                    startActivity(intent);
                }
            }
        });
    }

    private void viewDetailOrders() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Thông báo");
        b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        btnViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "TOCO order: \n\n\n    Cở bánh:\n";
                if(rdoSizeLarge.isChecked()){
                    message = message + rdoSizeLarge.getText() + ";\n";
                }
                else if(rdoSizeMedium.isChecked()){
                    message += rdoSizeMedium.getText();
                    message += ";\n";
                }
                message += "\n  Loại vỏ:\n";
                if(rdoTortiallaCorn.isChecked()){
                    message += rdoTortiallaCorn.getText();
                    message += ";\n";
                }
                if(rdoTortiallaFlour.isChecked()){
                    message += rdoTortiallaFlour.getText();
                    message += ";\n";
                }
                message += "\n  Nhân bánh:\n";
                if(cbBeef.isChecked()){
                    message += cbBeef.getText();
                    message += ";\n";
                }
                if(cbChicken.isChecked()){
                    message += cbChicken.getText();
                    message += ";\n";
                }
                if(cbWhiteFish.isChecked()){
                    message += cbWhiteFish.getText();
                    message += ";\n";
                }
                if(cbRice.isChecked()){
                    message += cbRice.getText();
                    message += ";\n";
                }
                if(cbSeaFood.isChecked()){
                    message += cbSeaFood.getText();
                    message += ";\n";
                }
                if(cbBean.isChecked()){
                    message += cbBean.getText();
                    message += ";\n";
                }

                if(message == ""){
                    b.setMessage("Hãy chọn món!");
                    AlertDialog al = b.create();
                    al.show();
                }
                else {
                    Intent it3 = new Intent(MainActivity.this, MainActivity3.class);
                    it3.putExtra("Key_1", message);
                    startActivity(it3);
                }
            }
        });
    }

    private void viewAddress() {
        btnViewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it2 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(it2);
            }
        });
    }
}