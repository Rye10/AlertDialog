package com.imvt.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private String[] letter = { "A", "B", "C", "D",
            "E", "F", "G", "H","I","J", "K", "L", "M", "N","O","P", "Q",
            "R", "S", "T","W", "X", "Y", "Z" };
    private LayoutInflater layoutInflater;
    private ListView listView;
    private TextView cancel,choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutInflater=LayoutInflater.from(this);
        button= findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                View view=layoutInflater.inflate(R.layout.dialog,null);
                listView=view.findViewById(R.id.list);
                cancel=view.findViewById(R.id.cancel);
                choose=view.findViewById(R.id.choose);


                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,letter){
                    public View getView(int position, View convertView, ViewGroup parent){
                        View view1=super.getView(position,convertView,parent);
                        TextView textView=view1.findViewById(android.R.id.text1);
                        textView.setTextColor(Color.WHITE);
                        return view1;
                    }
                };
                listView.setAdapter(adapter);
                builder.setView(view);

                builder.create();

                final AlertDialog dialog=builder.show();
                WindowManager m=getWindowManager();
                Display d=m.getDefaultDisplay();                                                   //获取屏幕宽高
                android.view.WindowManager.LayoutParams p=dialog.getWindow().getAttributes();      //获取对话框当前参数值
                p.height= (int) (d.getHeight()*0.8);                                             //宽度设为屏幕的0.8
                p.width= (int) (d.getWidth()*0.9);                                               //高度设为屏幕的0.9
                dialog.getWindow().setAttributes(p);                                              //设置生效
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                choose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
