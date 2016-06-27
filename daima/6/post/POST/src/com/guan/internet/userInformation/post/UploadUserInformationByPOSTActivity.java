package com.guan.internet.userInformation.post;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.guan.internet.userInformation.post.R;
import com.guan.internet.userInformation.service.UploadUserInformationByPostService;

public class UploadUserInformationByPOSTActivity extends Activity {
	private EditText titleText;
    private EditText lengthText;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        titleText = (EditText) this.findViewById(R.id.title);
        lengthText = (EditText) this.findViewById(R.id.length);
    }
    
    public void save(View v){
    	String title = titleText.getText().toString();
    	String length = lengthText.getText().toString();
    	try {
    		boolean result = false;
    		
    		result = UploadUserInformationByPostService.save(title, length);
    	
    		if(result){
				Toast.makeText(this, R.string.success, 1).show();
			}else{
				Toast.makeText(this, R.string.fail, 1).show();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, R.string.fail, 1).show();
		}
    }
}