package com.itskshitizsh.bhukhad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class BabaCateory extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baba_cateory);
        intent = new Intent(BabaCateory.this, Baba.class);

        Category[] category_baba = {
                new Category("Parantha", R.drawable.paratha),
                new Category("Patties", R.drawable.loaf),
                new Category("Bhelpuri", R.drawable.appe),
                new Category("Snacks", R.drawable.tikka),
                new Category("Maggie", R.drawable.spaguetti),
                new Category("fruit plate", R.drawable.shakes),
                new Category("Cakes", R.drawable.smoothies),
                new Category("Juice", R.drawable.cocktail),
                new Category("Shakes", R.drawable.shakes),

        };
        ListView baba_list = findViewById(R.id.list_baba_category);
        com.itskshitizsh.bhukhad.CategoryAdapter categoryAdapter = new com.itskshitizsh.bhukhad.CategoryAdapter(this, 0, category_baba);
        baba_list.setAdapter(categoryAdapter);

        baba_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent.putExtra("tag_baba", i);
                startActivity(intent);
            }
        });
    }
}
