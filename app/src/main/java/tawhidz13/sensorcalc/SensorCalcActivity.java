package tawhidz13.sensorcalc;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SensorCalcActivity extends Activity implements SensorEventListener {
	
	private TextView acc,accV,light,lightV,prox,proxV;
	private SensorManager sm;
	private Sensor Accelerometer,Light,Proximity;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        acc=(TextView)findViewById(R.id.tvAcc);
        accV=(TextView)findViewById(R.id.tvAccV);
      
        light=(TextView)findViewById(R.id.tvLight);
        lightV=(TextView)findViewById(R.id.tvLightV);
        
        prox=(TextView)findViewById(R.id.tvProx);
        proxV=(TextView)findViewById(R.id.tvProxV);        
        
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Light=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
		Proximity=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        
    }
    
        
    



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		sm.unregisterListener(this);
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		sm.registerListener( this, Accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		sm.registerListener( this, Light, SensorManager.SENSOR_DELAY_NORMAL);
		sm.registerListener( this, Proximity, SensorManager.SENSOR_DELAY_NORMAL);
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}



	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}






	public void onAccuracyChanged(Sensor s, int value) {
		// TODO Auto-generated method stub 	
	}






	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		if (se.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			accV.setText("x: "+se.values[0]+"\ny: "+se.values[1]+"\nz: "+se.values[2]);
		}
		if (se.sensor.getType() == Sensor.TYPE_LIGHT) {
			lightV.setText(" "+ se.values[0]);
		}
		if (se.sensor.getType() == Sensor.TYPE_PROXIMITY) {
			proxV.setText(" "+ se.values[0]);
		}

	}

    
}