package processing.test.manual_m0016;
/*
Written by Javier Montaner montanerj@yahoo.com
This software is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.
This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.
You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class ConfigurarActivity extends Activity {

	  private static Button btnOk, btnCancel;

	  private static EditText nameText;
	  	  
	  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        btnOk = (Button) findViewById(R.id.ok);					
        btnCancel = (Button) findViewById(R.id.cancel);					
        nameText = (EditText) findViewById(R.id.nameString);
	    SharedPreferences settings = getSharedPreferences("MSM016", 0);        
        nameText.setText(settings.getString("nombre", "Makespacemadrid"));
        
        
        btnOk.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences("MSM016", 0);
                SharedPreferences.Editor editor = settings.edit();
            	editor.putString("nombre",nameText.getText().toString());
                editor.commit();
                setResult(Activity.RESULT_OK);
                finish();
                return;
            }
          });
		   

		btnCancel.setOnClickListener(new OnClickListener() {
		    public void onClick(View v) {
				finish();
				return;		    	
		    }
          });        		
    }
    
	
	
}