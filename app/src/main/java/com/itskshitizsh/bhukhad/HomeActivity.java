package com.itskshitizsh.bhukhad;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.paperdb.Paper;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    boolean doubleBackToExitPressedOnce = false;

    String name, rollNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Shop List");

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        name = getIntent().getStringExtra("name");
        rollNo = getIntent().getStringExtra("rollNo");
        Paper.init(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        View view = navigationView.getHeaderView(0);
        TextView userId = view.findViewById(R.id.userId);
        TextView userName = view.findViewById(R.id.userName);
        if (rollNo != null) {
            userId.setText(rollNo.concat("@lnmiit.ac.in"));
        }
        if (name != null) {
            userName.setText(name);
        }

        TextView cardViewBazinga = findViewById(R.id.card_view_bazinga);
        cardViewBazinga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Bazzinga_category.class));
            }
        });


        TextView cardViewBabaJuice = findViewById(R.id.card_view_baba);
        cardViewBabaJuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BabaCateory.class));
            }
        });

        Button babaCall = findViewById(R.id.babaCall);
        Button babaFeedback = findViewById(R.id.babaFeedback);

        babaCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9461087404"));
                startActivity(intent);
            }
        });
        babaFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://goo.gl/forms/ipOSexs3CXEIPYjt1"));
                startActivity(i);
            }
        });

        Button bazzingaCall = findViewById(R.id.bazzingaCall);
        Button bazzingaFeedback = findViewById(R.id.bazzingaFeedback);

        bazzingaCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9589465439"));
                startActivity(intent);
            }
        });
        bazzingaFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://goo.gl/forms/Uo3cMzk1X902yLSJ3"));
                startActivity(i);
            }
        });


        Button amulCall = findViewById(R.id.amulCall);
        Button amulFeedback = findViewById(R.id.amulFeedback);

        amulCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876543210"));
                startActivity(intent);
            }
        });
        amulFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://goo.gl/forms/NgeRFF1KKAl8aNjo2"));
                startActivity(i);
            }
        });

/*
        CardView cardViewVinayak = findViewById(R.id.card_view_vinayak);
        cardViewVinayak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(HomeActivity.this,Bazzinga_category.class));
            }
        });
*/
        CardView cardViewAmul = findViewById(R.id.card_view_amul);
        cardViewAmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Amul.class));
            }
        });
/*
        CardView cardViewFoodBarn = findViewById(R.id.card_view_tfb);
        cardViewFoodBarn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(HomeActivity.this,Bazzinga_category.class));
            }
        });

        CardView cardViewStationary = findViewById(R.id.card_view_stationary);
        cardViewStationary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(HomeActivity.this,Bazzinga_category.class));
            }
        });*/

        FloatingActionButton floatingActionButton = findViewById(R.id.fab_cart);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CartActivity.class).putExtra("name", name).putExtra("id", rollNo));
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_cart:
                startActivity(new Intent(HomeActivity.this, CartActivity.class).putExtra("name", name).putExtra("id", rollNo));
                //finish();
                break;
            case R.id.nav_orders:
                startActivity(new Intent(HomeActivity.this, OrderActivity.class));
                //finish();
                break;
            case R.id.nav_profile:
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                //finish();
                break;
            case R.id.nav_settings:
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                //finish();
                break;
            case R.id.nav_feedback:
                startActivity(new Intent(HomeActivity.this, FeedbackActivity.class));
                //finish();
                break;
            //  Others!
            case R.id.nav_share:
                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_contact_us:
                Toast.makeText(getApplicationContext(), "Contact Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_sign_out:
                try {
                    Paper.book().destroy();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                finish();
                Toast.makeText(getApplicationContext(), "Sign Out", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press Back Again To Exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }
}