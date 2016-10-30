package com.example.readfile;

import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.io.PrintStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
  
	private String fileName="content.txt";
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnWrite=(Button)this.findViewById(R.id.btnWrite);
		Button btnRead=(Button)this.findViewById(R.id.btnRead);
		final EditText editWrite=(EditText)this.findViewById(R.id.editWrite);
		final EditText editRead=(EditText)this.findViewById(R.id. editRead);
		
		btnRead.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
			    editRead.setText(read());
			    
			}
		});
		
		btnWrite.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				btnWrite(editWrite.getText().toString());
			}
		});
		
	}

   public void btnWrite(String content) {

		// TODO Auto-generated method stub
		try{
			FileOutputStream fos=openFileOutput(fileName,Context.MODE_APPEND);
			PrintStream ps=new PrintStream(fos);
			ps.print(content);
			ps.close();
			fos.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

   public String read() {          //从文件中读取内容

		// TODO Auto-generated method stub
		StringBuilder sbBuilder=new StringBuilder("");
		try{
			FileInputStream is=openFileInput(fileName);
			byte[] buffer=new byte[64];
			int hasRead;
			while ((hasRead = is.read(buffer)) != -1) {
				sbBuilder.append(new String(buffer, 0, hasRead));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sbBuilder.toString();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
