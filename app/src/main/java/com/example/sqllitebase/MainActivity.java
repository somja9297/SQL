package com.example.sqllitebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText editRollno,editName,editMarks;
Button btnAdd,btnDelete,btnModify,btnView,btnViewAll,btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMarks=findViewById(R.id.editMarks);
        editName=findViewById(R.id.editName);
        editRollno=findViewById(R.id.editRollno);
        btnAdd=findViewById(R.id.btnAdd);
        btnDelete=findViewById(R.id.btndelete);
        btnModify=findViewById(R.id.btnModify);
        btnView=findViewById(R.id.btnView);
        btnViewAll=findViewById(R.id.btnViewAll);
        btnShow=findViewById(R.id.btnShow);


        btnShow.setOnClickListener(this);
        btnViewAll.setOnClickListener(this);
        btnView.setOnClickListener(this);
        btnModify.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnAdd:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();

        }
        switch (view.getId()){

            case R.id.btndelete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();



                    case R.id.btnModify:
                        Toast.makeText(this, "Modify", Toast.LENGTH_SHORT).show();



                            case R.id.btnShow:
                                Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show();



                                    case R.id.btnView:
                                        Toast.makeText(this, "View", Toast.LENGTH_SHORT).show();




                                            case R.id.btnViewAll:
                                                Toast.makeText(this, "ViewAll", Toast.LENGTH_SHORT).show();


                                }
}}
