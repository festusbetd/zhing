package com.example.festu.project;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView mScannerView;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);


        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

         if (id == R.id.item_refresh){
            final ProgressDialog dialog = ProgressDialog.show(
                    this, "", "Please wait...", true);
            new Thread(new Runnable(){
                public void run(){
                    try {
//---simulate doing something lengthy---
                        Thread.sleep(4000);
//---dismiss the dialog---
                        dialog.dismiss();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
//---show the dialog---


      else if (id == R.id.action_balance){
            String code = Uri.encode("*") + 144 + Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + code)));
            return true;
        }
       else if (id == R.id.action_okoa){
            String code = Uri.encode("*") + 131 + Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + code)));
            return true;
        }
        else if (id == R.id.action_settings) {
             Toast.makeText(this, "Settings page", Toast.LENGTH_LONG).show();
             Intent intent = new Intent(this, SettingsActivityS.class);
             startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass;
        if (id == R.id.home) {
            Toast.makeText(this, "Home Menu", Toast.LENGTH_LONG).show();
            Intent mainIntent = new Intent(this, MainActivity.class);
            startActivity(mainIntent);
        }
        else if (id == R.id.nav_bundles) {
            String code = Uri.encode("*") + 544 + Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + code)));
        }
       else if (id == R.id.nav_sms) {
            String code = Uri.encode("*") + 188 + Uri.encode("#");
            startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + code)));
        }

        else if (id == R.id.nav_storo) {
            Toast.makeText(this, "tools page", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, NotificationActivity.class);
            startActivity(intent);  }


        else if (id == R.id.nav_settings) {
            Toast.makeText(this, "Settings page", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SettingsActivityS.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_help) {
            Toast.makeText(this, "help page", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, HelpActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_tools) {
            Toast.makeText(this, "tools page", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ToolsActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_rate) {

            }
        else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Jaza Credo");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "download Jaza credo ");
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void recharge(View view) {
        Toast.makeText(this, "qr code scanner", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, QrCodeScannerActivity.class);
        startActivity(intent);
    }

    public void serial(View view) {
        Toast.makeText(this, "Serial Numbers", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SerialActivity.class);
        startActivity(intent);

    }

    public void hisrory(View view) {
        Toast.makeText(this, "History", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

    public void errors(View view) {
        Toast.makeText(this, "errors", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ErrorsActivity.class);
        startActivity(intent);
    }

    public void transaction(View view) {
        Toast.makeText(this, "All transactions", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, TransactionsActivity.class);
        startActivity(intent);
    }

}
