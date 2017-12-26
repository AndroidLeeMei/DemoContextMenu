package com.example.auser.democontextmenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //註冊ContextMenu元件,registerForContextMenu()
        TextView tv=(TextView)findViewById(R.id.textView);
        registerForContextMenu(tv);
    }


    //系
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_main, menu);  //與onCreateOptionsMenu作法相同
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_settings:
                customToast2All(R.string.action_meowth,R.drawable.meowth);
                break;
            case R.id.item1:
                customToast2All(R.string.action_pikachu,R.drawable.pikachu);
                break;
            case R.id.item2:
                customToast2All(R.string.action_pokeball,R.drawable.pokeball);
                break;
            case R.id.item3:
                customToast2All(R.string.action_psyduck,R.drawable.psyduck);
                break;
            case R.id.item4:
                customToast2All(R.string.action_snorlax,R.drawable.snorlax);
                break;
            case R.id.item5:
                customToast2All(R.string.action_settings,R.drawable.venonat);
                break;
            case R.id.submtem1:
                customToast2All(R.string.action_settings,R.drawable.venonat);
                break;
            case R.id.submtem2:
                customToast2All(R.string.action_settings,R.drawable.venonat);
                break;
            case R.id.submtem3:
                customToast2All(R.string.action_settings,R.drawable.venonat);
                break;
            case R.id.submtem4:
                customToast2All(R.string.action_settings,R.drawable.venonat);
                break;
            case R.id.submtem5:
                customToast2All(R.string.action_settings,R.drawable.venonat);
                break;

            case R.id.action_browser:
                Uri myBlogUri = Uri.parse("https://sites.google.com./site/gasodroid/");
                intent = new Intent(Intent.ACTION_VIEW, myBlogUri);
                startActivity(intent);
                break;
            case R.id.action_map:
                Uri mapUri = Uri.parse("geo:38.899533,-77.036476");
                intent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(intent);
                break;
            case R.id.action_dial:
                Uri telUri = Uri.parse("tel:100861");
                intent = new Intent(Intent.ACTION_DIAL, telUri);
                startActivity(intent);
                break;
            case R.id.action_uninstall:
                Uri uninstallUri = Uri.fromParts("package", "xxx", null);
                intent = new Intent(Intent.ACTION_DELETE, uninstallUri);
                startActivity(intent);
                break;
            case R.id.action_install:
                Uri installUri = Uri.fromParts("package", "xxx", null);
                intent = new Intent(Intent.ACTION_PACKAGE_ADDED, installUri);
                startActivity(intent);
                break;
            case R.id.action_play_music:
                String baseDir = Environment.getExternalStorageDirectory().getAbsolutePath();
                intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                File file = new File(baseDir+"/music/bgm.mp3");
                intent.setDataAndType(Uri.fromFile(file), "audio/*");
                startActivity(intent);

                break;
            case R.id.action_call:
                Uri callUri = Uri.parse("tel:0972485245");
                intent = new Intent(Intent.ACTION_CALL, callUri);
//                startActivity(intent);
                break;


            case R.id.action_2nd_activity:
                intent=new Intent();
                intent.setClass(MainActivity.this,Report.class);
                startActivity(intent);
                break;

            default:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_LONG).show();
             //   customToast();


        }
        return super.onContextItemSelected(item);
    }
    //讓Toast有圖片
    void customToast2All(int intNum,int intImg){
        Toast toast=Toast.makeText(MainActivity.this, intNum, Toast.LENGTH_SHORT);
        View original=toast.getView();
        LinearLayout linearLayout=new LinearLayout(MainActivity.this);//改用程式動態建立,所不用findviewbyid
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ImageView img=new ImageView(MainActivity.this);
        img.setImageResource(intImg);
        linearLayout.addView(img);
        linearLayout.addView(original);
        toast.setView(linearLayout);
        toast.show();
    }

    void customToast(){
        Toast toast=Toast.makeText(MainActivity.this, R.string.action_settings, Toast.LENGTH_SHORT);
        View original=toast.getView();
        LinearLayout linearLayout=new LinearLayout(MainActivity.this);//改用程式動態建立,所不用findviewbyid
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ImageView img=new ImageView(MainActivity.this);
        img.setImageResource(R.drawable.meowth);
        linearLayout.addView(img);
        linearLayout.addView(original);
        toast.setView(linearLayout);
        toast.show();
    }

    void handle(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_browser:
                customToast2All(R.string.action_settings,R.drawable.venonat);



        }

    }
}
