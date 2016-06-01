package casariego.jorge.androiddesignproject;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import casariego.jorge.androiddesignproject.fragments.ConfiguracionesActivity;
import casariego.jorge.androiddesignproject.fragments.Fragment1;
import casariego.jorge.androiddesignproject.fragments.Fragment2;
import casariego.jorge.androiddesignproject.fragments.Fragment3;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.menu_seccion_1:
                        fragment = new Fragment1();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_seccion_2:
                        fragment = new Fragment2();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_seccion_3:
                        fragment = new Fragment3();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_opcion_1:
                        Intent i = new Intent(MainActivity.this, ConfiguracionesActivity.class);
                        startActivity(i);
                        break;
                    case R.id.menu_opcion_2:
                        Log.d("Navigation View", "Salir");
                        break;
                }

                if(fragmentTransaction){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_frame, fragment)
                            .commit();

                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                }

                drawerLayout.closeDrawers();

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


