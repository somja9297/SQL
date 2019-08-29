package com.example.sqllitebase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText editRollno,editName,editMarks;
Button btnAdd,btnDelete,btnModify,btnView,btnViewAll,btnShow;
   SQLiteDatabase db;

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

    db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE,null);
db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR)");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnAdd:
 if(editRollno.getText().toString().trim().length()==0||editName.getText().toString().trim().length()==0||editMarks.getText().toString().trim().length()==0)

 {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();

             shwMsg("Error","Invalid Input");
                return;}
                db.execSQL("INSERT INTO student VALUES('"+editRollno.getText()+"','"+editName.getText()+
                        "','"+editMarks.getText()+"');");
                shwMsg("Success", "Record added");
cleartext();
        switch (view.getId()) {

            case R.id.btndelete:
                if (editRollno.getText().toString().trim().length() == 0) {
                    shwMsg("Error", "Please enter Rollno");
                    return;
                }
                Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno='" + editRollno.getText() + "'", null);
                if (c.moveToFirst()) {
                    db.execSQL("DELETE FROM student WHERE rollno='" + editRollno.getText() + "'");
                    shwMsg("Success", "Record Deleted");
                } else {
                    shwMsg("Error", "Invalid Rollno");
                }
                cleartext();
                break;

                    case R.id.btnModify:
                        if(editRollno.getText().toString().trim().length()==0)
                        {
                            shwMsg("Error", "Please enter Rollno");
                            return;
                        }
                        Cursor c1 =db.rawQuery("SELECT * FROM student WHERE rollno='"+editRollno.getText()+"'", null);
                        if(c1.moveToFirst())
                        {
                            db.execSQL("UPDATE student SET name='"+editName.getText()+"',marks='"+editMarks.getText()+
                                    "' WHERE rollno='"+editRollno.getText()+"'");
                            shwMsg("Success", "Record Modified");
                        }
                        else
                        {
                            shwMsg("Error", "Invalid Rollno");
                        }
                        cleartext();
break;


                            case R.id.btnShow:
                                Toast.makeText(this, "Show", Toast.LENGTH_SHORT).show();
shwMsg("Devloped By-","Mr.Soham Jagtap");
break;



                                    case R.id.btnView:
                                        Toast.makeText(this, "View", Toast.LENGTH_SHORT).show();


break;

                                            case R.id.btnViewAll:
                                                Cursor c3=db.rawQuery("SELECT * FROM student", null);
                                                if(c3.getCount()==0)
                                                {
                                                    shwMsg("Error", "No records found");
                                                    return;
                                                }
                                                StringBuffer buffer=new StringBuffer();
                                                while(c3.moveToNext())
                                                {
                                                    buffer.append("Rollno: "+c3.getString(0)+"\n");
                                                    buffer.append("Name: "+c3.getString(1)+"\n");
                                                    buffer.append("Marks: "+c3.getString(2)+"\n\n");
                                                }
                                                shwMsg("Student Details", buffer.toString());
                                                break;

                                }
}

    }

    private void cleartext() {
        editMarks.setText("");
        editName.setText("");
        editRollno.setText("");
    }

    private void shwMsg(String title, String Message) {
       AlertDialog.Builder alertDialog =new AlertDialog.Builder(this);
       alertDialog.setCancelable(true);
       alertDialog.setTitle(title);
       alertDialog.setMessage(Message);
       alertDialog.setIcon(R.mipmap.ic_launcher_round);
    alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
