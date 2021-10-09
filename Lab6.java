package com.example.droidcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ActionMode mAction; //for Action mode menu
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //--------------------for Floating Menu---------------------
        ImageView dounut_ImgView = findViewById(R.id.dounutImg);
        ImageView icecream_ImgView= findViewById(R.id.icecreamImg);
        ImageView yogurt_ImgView= findViewById(R.id.yogurtImg);

        registerForContextMenu(dounut_ImgView);
        registerForContextMenu(icecream_ImgView);
        registerForContextMenu(yogurt_ImgView);
        //---------------------------------------------------------



        //--------------------implementing Action Mode menu---------------------
        TextView dounutTV = findViewById(R.id.dounutID);
        TextView icecreamTV = findViewById(R.id.icecreamID);
        TextView yogurtTV = findViewById(R.id.yogurtID);

        //create all of these methods to the menu lifecycle
        ActionMode.Callback mActionCallbacks = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.action_mode_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_copy:
                        Toast.makeText(MainActivity.this,"This is a Copy action mode",Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this,"This is a Share action mode",Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                mAction = null;

            }
        };

        dounutTV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mAction != null) return false; //to check if the action mode menu opened
                mAction = MainActivity.this.startActionMode(mActionCallbacks);
                return false;
            }
        });

        icecreamTV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mAction != null) return false; //to check if the action mode menu opened
                mAction = MainActivity.this.startActionMode(mActionCallbacks);
                return false;
            }
        });

        yogurtTV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mAction != null) return false; //to check if the action mode menu opened
                mAction = MainActivity.this.startActionMode(mActionCallbacks);
                return true;
            }
        });
        //--------------------End of implementing the Action mode Menu---------------------

    }


    //--------------------implementing the floating Menu---------------------
    @Override
    //here we are showing the floating menu on ImgView but without any functionality
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.floating_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.floating_edit:
                Toast.makeText(this,"This is a Edit floating option",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.floating_share:
                Toast.makeText(this,"This is a Share floating option",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    //--------------------End of implementing the Floating Menu---------------------


    //--------------------implementing the Option Menu---------------------
    @Override
    //to show the option menu in the activity but doesn't do any action
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    //here we execute an action according to the user choice from the option menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_home:
                Toast.makeText(this,"This is a Home option",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_setting:
                Toast.makeText(this,"This is a Setting option",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_fav:
                Toast.makeText(this,"This is a Favorite option",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_info:
                Toast.makeText(this,"This is a Info option",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //--------------------End of implementing the Option Menu---------------------





}
