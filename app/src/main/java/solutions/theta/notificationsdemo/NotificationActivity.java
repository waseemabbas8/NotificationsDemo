package solutions.theta.notificationsdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotificationActivity extends AppCompatActivity {

    Button mbtn;
    EditText mtitle;
    EditText msubject;
    EditText mbody;
    int mNotificationid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mbtn=(Button)findViewById(R.id.button);
        mbody=(EditText) findViewById(R.id.edbody);
        msubject=(EditText) findViewById(R.id.etsubject);
        mtitle=(EditText) findViewById(R.id.ettitle);

    }

    public void shownotification(View view) {
        long v[]=new long[]{100,100};
        NotificationManager mnotificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String mt=mtitle.getText().toString();
        String ms=msubject.getText().toString();
        String mb=mbody.getText().toString();
        Notification mnotification=new Notification.Builder(getApplicationContext()).setContentTitle(mt).setContentText(mb).setSubText(ms).setSmallIcon(R.mipmap.ic_launcher).setVibrate(v).build();
        mnotification.sound= Uri.parse("android.resource://"+getPackageName()+"/raw/tune");
        mnotification.flags  |=Notification.FLAG_AUTO_CANCEL;
       // mnotification.flags  |=Notification.DEFAULT_VIBRATE;
        mnotificationManager.notify(mNotificationid,mnotification);
        mNotificationid++;
    }
}