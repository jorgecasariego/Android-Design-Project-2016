package casariego.jorge.androiddesignproject;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import casariego.jorge.androiddesignproject.fragments.ConfiguracionesActivity;
import casariego.jorge.androiddesignproject.fragments.Fragment1;
import casariego.jorge.androiddesignproject.fragments.Fragment2;
import casariego.jorge.androiddesignproject.fragments.Fragment3;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private FloatingActionButton floatingActionButton;
    private CollapsingToolbarLayout collapsingToolbarLayout;



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

        navigationView.setNavigationItemSelectedListener(this);

        /*tabLayout = (TabLayout) findViewById(R.id.appbar_tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText("Estrenos"));
        tabLayout.addTab(tabLayout.newTab().setText("En Cartelera"));
        tabLayout.addTab(tabLayout.newTab().setText("50 %"));*/

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Utilizando Floating Button!", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Cerrar", mSnackBarClickListener)
                        .show();
            }
        });

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setTitle("Paseo Galería Cine World");
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.colorAccent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, android.R.color.white));

        //Hacemos que la primera vez ya cargue el fragment 1
        Fragment fragment = null;
        fragment = new Fragment1();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();


    }

    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Click sobre SnackBar", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


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
}


