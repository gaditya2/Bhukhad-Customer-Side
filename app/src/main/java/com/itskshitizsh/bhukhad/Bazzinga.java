package com.itskshitizsh.bhukhad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.Arrays;

public class Bazzinga extends AppCompatActivity {
    private RecyclerView listView;
    private MenuAdapter menuAdapter;
    Item[] items_bazzinga_mocktail = {

            new Item("Mint Lime Mojito", 40.0, 0),
            new Item("Orange Mojito", 40.0, 0),
            new Item("Strawberry Mojito", 40.0, 0)
    };

    Item[] items_bazzinga_shakes = {

            new Item("Banana shake", 30.0, 0
            ),
            new Item("Papaya shake", 30.0, 0),
            new Item("Banana shake(iceCream)", 35.0, 0),
            new Item("Papaya shake(iceCream)", 35.0, 0),
            new Item("Chocolate shake", 40.0, 0),
            new Item("Snickers shake", 40.0, 0),
            new Item("Oreo shake", 40.0, 0),
            new Item("Kitkat shake", 40.0, 0),
            new Item("Brownie shake", 60.0, 0)
    };


    Item[] items_bazzinga_smoothies = {
            new Item("Mango smoothie king", 40.0, 0),
            new Item("Pineapple smoothies", 40.0, 0)
    };


    Item[] items_bazzinga_coffee = {

            new Item("Cappuccino", 20.0, 0),
            new Item("Latte", 25.0, 0),
            new Item("Cold Coffee", 30.0, 0),
            new Item("Cold Coffee With Ice-Cream", 35.0, 0)
    };


    Item[] items_bazzinga_soups = {

            new Item("Hot and Soup", 30.0, 0),
            new Item("Manchow Soup", 30.0, 0),
            new Item("Chicken Soup", 60.0, 0)
    };

    Item[] items_bazzinga_appetizers = {

            new Item("Spring rolls(6pcs)", 20.0, 0),
            new Item("Momo Stream/Fry", 40.0, 0),
            new Item(" Chicken Momo Stream", 60.0, 0),
            new Item(" Chicken Momo Fry", 70.0, 0),
            new Item("Manchurian dry", 50.0, 0),
            new Item("Manchurian gravy", 60.0, 0),
            new Item("Vegnoodles", 70.0, 0),
            new Item("Hakkanoodles", 70.0, 0),
            new Item("Chicken noodles", 90.0, 0),
            new Item("Crispy corn", 60.0, 0),
            new Item("Honey Chilli Potato", 60.0, 0),
            new Item("Peri Peri French Fries", 60.0, 0),
            new Item("Veg Quesadilla", 70.0, 0),
            new Item("Paneer Tikka Quesadilla", 70.0, 0),
            new Item("Chicken Quesadilla", 70.0, 0),
            new Item("Chicken Tikka Quesadilla", 70.0, 0),
            new Item(" Chilli Chicken", 70.0, 0),
            new Item("Egg omelet(3eggs)", 70.0, 0),
            new Item("Pav Bhaji(2pcs)", 70.0, 0),
            new Item("Egg Bhurji Pav(2pcs)", 70.0, 0),
            new Item("Extra Pav", 70.0, 0),
            new Item("Fried Rice", 70.0, 0),
            new Item("Egg Fried Rice", 70.0, 0),
            new Item("Chicken Fried Rice", 70.0, 0),
            new Item("Egg Chicken Fried Rice", 70.0, 0)
    };

    Item[] items_bazzinga_paratha = {

            new Item("Aloo Paratha", 20.0, 0),
            new Item("Aloo Pyaz Paratha", 30.0, 0),
            new Item("Paneer Paratha", 20.0, 0),
            new Item("Mix Veg Paratha", 20.0, 0),
            new Item("Chicken Paratha", 20.0, 0)
    };


    Item[] items_bazzinga_sandwiches = {

            new Item("Aloo Bhujia Sandwich(cold)", 40.0, 0),
            new Item("Veg Cheese Grilled", 50.0, 0),
            new Item("Potato Grilled", 40.0, 0),
            new Item("Paneer Tikka Sandwich", 50.0, 0),
            new Item("Chicken Tikka Sandwich", 80.0, 0)
    };


    Item[] items_bazzinga_pasta = {

            new Item("Makhani Pasta(indian style)", 80.0, 0),
            new Item("Spicy Arrabbiata(veg)", 70.0, 0),
            new Item("Spicy Arrabbiata(non-veg)", 90.0, 0),
            new Item("Cheesy Alfredo(veg)", 80.0, 0),
            new Item("Cheesy Alfredo(non-veg)", 100.0, 0),
            new Item("Pasta Pink(veg)", 80.0, 0),
            new Item("Pasta Pink(non-veg)", 100.0, 0)
    };


    Item[] items_bazzinga_pizza = {

            new Item("Margaritta Pizza", 90.0, 0),
            new Item("Otc Pizza", 100.0, 0),
            new Item("Cheese Onion Capsicum Pizza", 100.0, 0),
            new Item("Veggie Own Pizza", 120.0, 0),
            new Item("Peri Peri Paneer Pizza(spicy)", 140.0, 0),
            new Item("Paneer Tikka Pizza", 140.0, 0),
            new Item("Chicken Tikka Pizza", 140.0, 0)
    };


    Item[] items_bazzinga_dessert = {

            new Item("Brownie With Ice-Cream", 50.0, 0),
            new Item("Sundae Fudge", 50.0, 0)
    };


    Item[] items_bazzinga_burgers = {

            new Item("Aloo Tikki Burger", 40.0, 0),
            new Item("Veg Cheese Burger", 50.0, 0),
            new Item("Peri Peri Burger", 50.0, 0),
            new Item("Cryspy Chicken Burger", 80.0, 0)
    };


    Item[] items_bazzinga_rolls = {

            new Item("Veg Roll", 30.0, 0),
            new Item("Egg Roll", 40.0, 0),
            new Item("Chilli Paneer Roll", 40.0, 0),
            new Item("Chicken Roll", 50.0, 0),
            new Item("Paneer Tikka Roll", 50.0, 0),
            new Item("Homemade Chicken Shawarma", 75.0, 0)
    };


    Item[] items_bazzinga_main_course = {

            new Item("Ghar Ka Chicken(2pcs)", 110.0, 0),
            new Item("Ghar Ka Chicken(4pcs)", 190.0, 0),
            new Item("Ghar Ka Chicken(8pcs)", 360.0, 0),
            new Item("Chicken Curry(2pcs)", 110.0, 0),
            new Item("Chicken Curry(4pcs)", 190.0, 0),
            new Item("Chicken Curry(8pcs)", 360.0, 0),
            new Item("Butter Chicken(2pcs)", 110.0, 0),
            new Item("Butter Chicken(4pcs)", 190.0, 0),
            new Item("Butter Chicken(8pcs)", 360.0, 0),
            new Item("Kadai Chicken(2pcs)", 110.0, 0),
            new Item("Kadai Chicken(4pcs)", 190.0, 0),
            new Item("Kadai Chicken(8pcs)", 360.0, 0),
            new Item("Egg Curry(2pcs)", 80.0, 0),
            new Item("Chicken Biryani(4pcs)", 185.0, 0),
            new Item("Tandoori Chicken(4pcs)", 200.0, 0),
            new Item("Tandoori Chicken(8pcs)", 380.0, 0),
    };


    Item[] items_bazzinga_tikka = {

            new Item("Paneer Tikka", 100.0, 0),
            new Item("Chicken Tikka", 120.0, 0)
    };


    Item[] items_bazzinga_main_course_veg = {

            new Item("Paneer Butter Masala(half)", 70.0, 0),
            new Item("Paneer Butter Masala(full)", 130.0, 0),
            new Item("Kadai Paneer(half)", 70.0, 0),
            new Item("Kadai Paneer(full)", 130.0, 0),
            new Item("Paneer Rajwada(half)", 80.0, 0),
            new Item("Paneer Rajwada(full)", 140.0, 0),
            new Item("Paneer Lababdar(half)", 85.0, 0),
            new Item("Paneer Lababdar(full)", 160.0, 0),
            new Item("Paneer Khurchan(half)", 85.0, 0),
            new Item("Paneer Khurchan(full)", 160.0, 0),
            new Item("Dal Tadka(full)", 80.0, 0),
            new Item("Dal Lehsuni(full)", 80.0, 0),
            new Item("Mix Veg(full)", 80.0, 0),
            new Item("Jeera Aloo(full)", 50.0, 0),
            new Item("Aloo Pyaz(full)", 55.0, 0),
            new Item("Aloo Gobhi(full)", 55.0, 0),
            new Item("Aloo Tamater(full)", 55.0, 0),
            new Item("Bhindi Masala(full)", 50.0, 0),
            new Item("Matar Masala(full)", 50.0, 0),
            new Item("Rajma Raseele(full)", 60.0, 0),
            new Item("Punjabi Chole(full)", 60.0, 0)
    };


    Item[] items_bazzinga_breads = {
            new Item("Tawa Roti", 12.0, 0),
            new Item("Butter Tawa Roti", 15.0, 0),
            new Item("Tandoori Roti", 12.0, 0),
            new Item("Butter Tandoori", 15.0, 0),
            new Item("Plain Naan", 20.0, 0),
            new Item("Lachcha Paratha", 30.0, 0),
            new Item("Butter Naan", 35.0, 0),
    };

    Item[] items_bazzinga_thali = {
            new Item("North Indian Thali", 35.0, 0),
            new Item("Egg Thali", 35.0, 0),
    };

    Item[] items_bazzinga_maggi = {
            new Item("Veg Masala Maggi", 35.0, 0),
            new Item("Cheese Maggi", 35.0, 0),
            new Item("Egg Maggi", 35.0, 0),
            new Item("Veg Cheese Maggi", 35.0, 0),
            new Item("Veg Butter Maggi", 35.0, 0)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazzinga);

        listView = findViewById(R.id.bazzingaMenu);
        int index = getIntent().getIntExtra("tag", 0);
        RecyclerView.LayoutManager ol = new LinearLayoutManager(getApplicationContext());
        listView.setLayoutManager(ol);
        switch (index) {
            case 0:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_mocktail));
                listView.setAdapter(menuAdapter);
                break;
            case 1:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_shakes));
                listView.setAdapter(menuAdapter);
                break;
            case 2:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_smoothies));
                listView.setAdapter(menuAdapter);
                break;
            case 3:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_coffee));
                listView.setAdapter(menuAdapter);
                break;
            case 4:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_soups));
                listView.setAdapter(menuAdapter);
                break;
            case 5:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_appetizers));
                listView.setAdapter(menuAdapter);
                break;
            case 6:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_paratha));
                listView.setAdapter(menuAdapter);
                break;
            case 7:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_main_course));
                listView.setAdapter(menuAdapter);
                break;
            case 8:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_tikka));
                listView.setAdapter(menuAdapter);
                break;
            case 9:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_breads));
                listView.setAdapter(menuAdapter);
                break;
            case 10:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_thali));
                listView.setAdapter(menuAdapter);
                break;

            case 11:
                menuAdapter = new MenuAdapter(this, Arrays.asList(items_bazzinga_maggi));
                listView.setAdapter(menuAdapter);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Not in List", Toast.LENGTH_SHORT).show();
                break;
        }



    }
}
//  Item[] items_bazzinga_sandwiches={
//
//            new Item("Aloo Bhujia Sandwich(cold)",40.0,“0”),
//            new Item("Veg Cheese Grilled",50.0,“0”),
//            new Item("Potato Grilled"",40.0,“0”),
//            new Item("Paneer Tikka Sandwich",50.0,“0”),
//            new Item("Chicken Tikka Sandwich",80.0,“0”)
//    };