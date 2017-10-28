package com.finepointmobile.famouspeople;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by danielmalone on 10/28/17.
 */

class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.firstName.setText(users.get(position).getFirstName());
        holder.lastName.setText(users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstName;
        public TextView lastName;
        public TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
