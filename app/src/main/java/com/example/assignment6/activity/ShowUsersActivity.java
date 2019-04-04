package com.example.assignment6.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment6.R;
import com.example.assignment6.adapter.UserAdapter;
import com.example.assignment6.callback.OnUserItemClick;
import com.example.assignment6.fragment.UserDetailsFragment;
import com.example.assignment6.model.Api;
import com.example.assignment6.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowUsersActivity extends AppCompatActivity implements OnUserItemClick {

    private ArrayList<User> users;
    private UserAdapter userAdapter;
    private int usersPostsPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_display_details_activity_main, new UserDetailsFragment());
        ft.commit();
        showUsers(this);

    }

    /**
     * Method showUser which takes data from the Base Url and convert it into Retrofit
     * Two methods have been override for call.enqueue
     */
    protected void showUsers(final OnUserItemClick mListner) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<ArrayList<User>> call = api.getUser();

        call.enqueue(new Callback<ArrayList<User>>() {


            /**
             * Method onResponse returns country list to the CountryAdapter
             *
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                users = response.body();

                final RecyclerView countryRecyclerView = findViewById(R.id.rv_users_activity_main);


                userAdapter = new UserAdapter(ShowUsersActivity.this, users, mListner);
                final RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(getApplicationContext());
                countryRecyclerView.setLayoutManager(layoutManager);
                countryRecyclerView.setAdapter(userAdapter);
                ProgressBar mProgressBar = findViewById(R.id.pb_activity_main);
                mProgressBar.setVisibility(View.GONE);
            }

            /**
             * Method onFinally runs when an error has to be set if the JsonCall could not be made
             * Displays a toast id error persists
             *
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), getString(R.string.toast_error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClickListener(int position) {

        usersPostsPosition = position;
        TextView username = findViewById(R.id.tv_user_name_fragment_user_details);
        TextView userEmail = findViewById(R.id.tv_email_fragment_user_details);
        TextView userAddress = findViewById(R.id.tv_address_fragment_user_details);
        TextView userId = findViewById(R.id.tv_user_id_fragment_user_details);
        userId.setText(users.get(position).getId() + "");
        username.setText("Name " + " : " + users.get(position).getName() + "\nUsername " + " : " + users.get(position).getUsername());
        userEmail.setText("Email " + " : " + users.get(position).getEmail());
        userAddress.setText("Address" + " : " + users.get(position).getAddress().getCity() + " " +
                users.get(position).getAddress().getStreet() + " " +
                users.get(position).getAddress().getSuite() + " " +
                users.get(position).getAddress().getZipcode()
        );
        FrameLayout frameLayout = findViewById(R.id.fl_display_details_activity_main);
        frameLayout.setVisibility(View.VISIBLE);


    }
}
