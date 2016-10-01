package com.jose.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.jose.mascotas.adaptador.PageAdapter;
import com.jose.mascotas.fragment.PerfilFragment;
import com.jose.mascotas.fragment.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;

        switch (item.getItemId()){
            case R.id.mContacto:
                intent = new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                intent = new Intent(this, AcercaActivity.class);
                startActivity(intent);
                break;
            case R.id.mFavoritos:
                intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private List<Fragment> agregarFragments(){
        Log.e("MainActivity", "agregarFragments");
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        Log.e("MainActivity", "la ctd" + tabLayout.getTabCount());

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_detail);
    }
}
