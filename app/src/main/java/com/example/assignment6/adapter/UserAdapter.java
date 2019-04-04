package com.example.assignment6.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.assignment6.R;
import com.example.assignment6.callback.OnUserItemClick;
import com.example.assignment6.model.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<User> userArrayList;
    private Context mContext;
    private OnUserItemClick mListener;


    /**
     * UserAdapter constructor sets the values in the ArrayList and Context
     *
     * @param context
     * @param userList
     */

    public UserAdapter(Context context, ArrayList<User> userList,final OnUserItemClick itemClick) {
        userArrayList = userList;
        mContext = context;
        mListener = itemClick;

    }

    /**
     * Function CreateViewHolder in order to create ViewHolder
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View layoutInflater = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_view, viewGroup, false);
        return new UserViewHolder(layoutInflater);

    }


    /**
     * function BindViewHolder in order to bind data to the ViewHolder
     *
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        UserViewHolder userViewHolder = (UserViewHolder) viewHolder;
        userViewHolder.textViewName.setText(userArrayList.get(i).getName());
        userViewHolder.textViewUserName.setText("Username :" + " " + String.valueOf(userArrayList.get(i).getUsername()));
        userViewHolder.textViewEmail.setText("Email :" + " " + String.valueOf(userArrayList.get(i).getEmail()));

        userViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClickListener(viewHolder.getAdapterPosition());
            }
        });

    }


    /**
     * method to return size of list
     *
     * @return userArrayList size
     */
    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewUserName;
        TextView textViewEmail;

        /**
         * User View Holder for UserAdapter
         *
         * @param itemView
         */
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewUserName = itemView.findViewById(R.id.tv_user_name);
            textViewEmail = itemView.findViewById(R.id.tv_email);

        }
    }

}
