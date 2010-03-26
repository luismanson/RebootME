package ar.com.ForoMilestone.RebootME;

//import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder; 
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
// import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
// import android.widget.TextView;
import android.widget.Toast;
import ar.com.ForoMilestone.RebootME.R;




public class RebootME extends Activity {
	private static final String TAG = "RebootMe ";
// private TextView TxtArea;

	@Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        TxtArea = (TextView) findViewById(R.id.TxtArea);

        Button rebootRecoveryUpdateZip = (Button) findViewById(R.id.rebootRecoveryUpdateZip);
        Button rebootRecovery = (Button) findViewById(R.id.BtnRebootRecovery);
        Button btnRebootNormal = (Button) findViewById(R.id.btnRebootNormal);
        Button btnSalir = (Button) findViewById(R.id.btnSalir);
        
        // esto pone todo la img como boton!
//        btnDummy.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.stopwatch_digital));
        
        final Builder builder = new AlertDialog.Builder(RebootME.this);
        
        builder.setTitle("Info");
        builder.setPositiveButton("Ok", null);
  
        
        
        // reboot y aplicar Update.zip
        rebootRecoveryUpdateZip.setOnClickListener(new Button.OnClickListener() {


        	public void onClick(View v) {
            	
            	Context context = getApplicationContext();
            	
// estas 2 sobran            	
//                    Process process = null;
//                    DataOutputStream os = null;
    			try {
    				Process p = Runtime.getRuntime().exec("su");
    				OutputStream os = p.getOutputStream();
    				os.write("busybox mkdir -p /cache/recovery/\n".getBytes());
    				os.write("echo 'boot-recovery' >/cache/recovery/command\n".getBytes());
    				//os.write("echo '--nandroid'  >> /cache/recovery/command\n".getBytes());
    				os.write("echo '--update_package=SDCARD:Update.zip' >> /cache/recovery/command\n".getBytes());
    				os.write("toolbox reboot recovery\n".getBytes());
    				
    				os.flush();

    				Toast.makeText(context, R.string.apply_trying_to_get_root_access, Toast.LENGTH_LONG).show();
    			} catch (IOException e) {
    				Log.e(TAG, "Unable to reboot into recovery mode:", e);
    				Toast.makeText(context, R.string.apply_unable_to_reboot_toast, Toast.LENGTH_LONG).show();
    			}
            	
            
                }  });

        
        
        // Reboot en recovery y punto
        rebootRecovery.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            	
            	Context context = getApplicationContext();
            	
// estas 2 sobran            	
//                    Process process = null;
//                    DataOutputStream os = null;
    			try {
    				Process p = Runtime.getRuntime().exec("su");
    				OutputStream os = p.getOutputStream();
//    				os.write("mkdir -p /cache/recovery/\n".getBytes());
//    				os.write("echo 'boot-recovery' >/cache/recovery/command\n".getBytes());
// NO usado aun 				if(mBackup) os.write("echo '--nandroid'  >> /cache/recovery/command\n".getBytes());
//    				os.write("echo '--update_package=SDCARD:update.zip' >> /cache/recovery/command\n".getBytes());
    				os.write("reboot recovery\n".getBytes());
    				
    				os.flush();

    				Toast.makeText(context, R.string.apply_trying_to_get_root_access, Toast.LENGTH_LONG).show();
    			} catch (IOException e) {
    				Log.e(TAG, "Unable to reboot into recovery mode:", e);
    				Toast.makeText(context, R.string.apply_unable_to_reboot_toast, Toast.LENGTH_LONG).show();
    			}
            	
            	
                }  });

        
  // dummy uptime  button      
        
        btnRebootNormal.setOnClickListener(new Button.OnClickListener() {

        	public void onClick(View v) {
 
               	
            	Context context = getApplicationContext();
            	
// estas 2 sobran            	
//                    Process process = null;
//                    DataOutputStream os = null;
    			try {
    				Process p = Runtime.getRuntime().exec("su");
    				OutputStream os = p.getOutputStream();
    				//os.write("busybox mkdir -p /cache/recovery/\n".getBytes());
    				//os.write("echo 'boot-recovery' >/cache/recovery/command\n".getBytes());
    				//os.write("echo '--nandroid'  >> /cache/recovery/command\n".getBytes());
    				//os.write("echo '--update_package=SDCARD:Update.zip' >> /cache/recovery/command\n".getBytes());
    				os.write("toolbox reboot\n".getBytes());
    				
    				os.flush();

    				Toast.makeText(context, R.string.apply_trying_to_get_root_access, Toast.LENGTH_LONG).show();
    			} catch (IOException e) {
    				Log.e(TAG, "Unable to reboot :", e);
    				Toast.makeText(context, R.string.apply_unable_to_reboot_toast, Toast.LENGTH_LONG).show();
    			}
            	
                   		
 
                }  });

        
        
        
        btnSalir.setOnClickListener(new Button.OnClickListener() {   
        	public void onClick(View v) {
        		System.exit(0);
            }  });
        
}}