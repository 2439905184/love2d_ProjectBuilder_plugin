package com.hh128.test_launcher_love;
import android.widget.Toast;
import android.content.Context;

public class Easy {
    
    /**显示消息**/
    public static void showMsg(Context ctx,Object obj)
    {
        Toast.makeText(ctx,obj.toString(),Toast.LENGTH_LONG).show();
    }
}
