package com.example.assignment6.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment6.R;
import com.example.assignment6.model.Api;
import com.example.assignment6.model.UserPosts;
import com.example.assignment6.util.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowPostsActivity extends AppCompatActivity {

    private TextView userPosts;
    private ArrayList<UserPosts> userPostsList;
    private Integer userId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_posts);
        userPostsList = new ArrayList<>();
        userId = Integer.parseInt(getIntent().getStringExtra(Constants.USERID));
        fetchPostFromApi(userId);

    }

    /**
     * init method used to initialise the variables and display the posts of the users
     * It also Hides the progress bar when the data is fetched from the database
     */
    private void init() {
        userPosts = findViewById(R.id.tv_user_posts);

        for (int i = 0; i < userPostsList.size(); i++) {
            userPosts.append("Post id : " + userPostsList.get(i).getId()
                    + "\n" + "Post Title : " + userPostsList.get(i).getTitle()
                    + "\n" + "Post Body : " + userPostsList.get(i).getBody() + "\n" + "\n");
        }
        ProgressBar mProgressBar = findViewById(R.id.pb_activity_show_posts);
        mProgressBar.setVisibility(View.GONE);


    }

    /**
     * Hits the API to get the Posts of the selected user
     *
     * @param userId from the user that is selected in the Recycler View User List's on click.
     */
    private void fetchPostFromApi(int userId) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Api usersApi = retrofit.create(Api.class);

        Call<ArrayList<UserPosts>> call = usersApi.getPosts(userId);

        call.enqueue(new Callback<ArrayList<UserPosts>>() {
            @Override
            public void onResponse(Call<ArrayList<UserPosts>> call,
                                   Response<ArrayList<UserPosts>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(ShowPostsActivity.this,
                            "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                userPostsList = response.body();
                init();

            }

            @Override
            public void onFailure(Call<ArrayList<UserPosts>> call, Throwable t) {
                Toast.makeText(ShowPostsActivity.this,
                        "Couldn't get Response " + t + " got thrown", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
