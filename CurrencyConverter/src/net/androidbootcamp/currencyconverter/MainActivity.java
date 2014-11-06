package net.androidbootcamp.currencyconverter;

import java.net.MalformedURLException;
import java.net.URL;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private static String CONV_URL = "http://rate-exchange.appspot.com/currency";
	private static String PARAM1 = "?from=";
	private static String PARAM2 = "&to=";
	private Spinner spinner1, spinner2;
	double currencyEntered, currencyConverted, rate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button button = (Button)findViewById(R.id.btnConvert);
        final EditText currency = (EditText) findViewById(R.id.txtCurrency);
        final TextView txtResult = (TextView)findViewById(R.id.result); 

        spinner1 = (Spinner) findViewById(R.id.spinnerFrom);
        spinner2 = (Spinner) findViewById(R.id.spinnerTo);
        
        button.setOnClickListener(new OnClickListener() {

        	@Override
			public void onClick(View v) {
				currencyEntered = Double.parseDouble(currency.getText().toString());
				//DecimalFormat tenth = new DecimalFormat("#.#");
				FetchConversionRateTask task = new FetchConversionRateTask(txtResult, currencyEntered);
				
				try {
					task.execute(new URL(CONV_URL + PARAM1 + String.valueOf(spinner1.getSelectedItem()) + PARAM2 + String.valueOf(spinner2.getSelectedItem())));
				} catch (MalformedURLException e) {
					// TODO add Toast or other notification
					e.printStackTrace();
				}

			}
			

        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
