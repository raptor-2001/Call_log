package com.prathamyadav006.viewme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    List<ModelClass> userList;
    LinearLayoutManager linearManger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initdata();
        initRecycler();
        registerForContextMenu(recyclerView);
    }

    private void initdata() {

        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.ic_profile,"Pratham IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Mahesh CSE"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Sarthak IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Ankur IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Sudesh EN"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Mohit EN"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Kartik CSE -1"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Aaditya Patil IT -1"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Coordinator Mr. A"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Abhishek IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Mohit IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Mayuresh IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Hrishikesh IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Ashish IT"));
        userList.add(new ModelClass(R.drawable.ic_profile,"Onkar IT +1"));

    }

    @SuppressLint("NotifyDataSetChanged")
    private void initRecycler() {

        recyclerView = findViewById(R.id.recyclerView);
        linearManger = new LinearLayoutManager(this);
        linearManger.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearManger);
        adapter = new Adapter(userList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.call){
            Toast.makeText(this, "call selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.copy){
            Toast.makeText(this, "copy selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.sim1){
            Toast.makeText(this, "SIM 1 selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.sim2){
            Toast.makeText(this, "SIM 2 selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.edit){
            Toast.makeText(this, "Edit selected", Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.delete){
            Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return true;
    }
}