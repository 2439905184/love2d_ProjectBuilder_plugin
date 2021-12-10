package com.hh128.test_launcher_love;

import android.app.Activity;
import android.os.Bundle;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.widget.Toast;
import android.net.Uri;
import java.io.File;

public class MainActivity extends Activity
{ 

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PackageManager pack=getPackageManager();
        //用于获取数据的intent
        Intent app_intent= getIntent();
      //  app_intent.putExtra("abs","abs");
        String a= app_intent.getStringExtra("love");
        if(a==null)
        {
         Easy.showMsg(this,"没有值");
            //进入手动界面
            Intent h=new Intent(getApplicationContext(),hand.class);
            startActivity(h);
        } else
        {
         Easy.showMsg(this,"接受到值,启动love2d");
        Toast.makeText(this,a,Toast.LENGTH_LONG).show();
        Intent i= pack.getLaunchIntentForPackage("org.love2d.android");
        Toast.makeText(this,i.toString(),1000).show();
        File f=new File(a);
        i.setDataAndType(Uri.fromFile(f),"application/x-zip-compressed");
        startActivity(i);
    }
    }
} 
