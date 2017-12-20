package com.imvt.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private String[] data={"A","B","C","D","E","F","G"};
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


                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data){
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
