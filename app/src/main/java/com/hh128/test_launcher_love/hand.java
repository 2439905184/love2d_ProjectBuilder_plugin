package com.hh128.test_launcher_love;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.io.File;
import android.text.TextWatcher;
import android.text.Editable;
import android.net.Uri;
import android.widget.TextView;
//手动启动
public class hand  extends Activity
{
    String bin_path="/storage/emulated/0/love2d_project/bin/";
    PackageManager pack;
    Intent intent;
    EditText hand;
    String newText;
    TextView love_hint;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    { 
        setContentView(R.layout.hand);
        super.onCreate(savedInstanceState);
        pack=getPackageManager();
        intent=pack.getLaunchIntentForPackage("org.love2d.android");  
        hand=findViewById(R.id.hand);
        love_hint=findViewById(R. id.love_hint);
        hand.addTextChangedListener(new TextWatcher()
           {
                @Override
                public void beforeTextChanged(CharSequence p1,int p2,int p3,int p4)
                {
                }

                @Override
                public void onTextChanged(CharSequence p1,int p2,int p3,int p4)
                {
                 //newText=p1.toString();
                 love_hint.setText(bin_path+p1+".love");
                }

                @Override
                public void afterTextChanged(Editable p1)
                {
                }
                
            
        });
    }
  public void run(View v)
  {
      String text=hand.getText().toString();
     
      String final_love=bin_path+text+".love";
      Easy.showMsg(this,final_love);
      File file=new File(bin_path+text+".love");
      intent.setDataAndType(Uri.fromFile(file),"application/x-zip-compressed");
      startActivity(intent);
  }
}
