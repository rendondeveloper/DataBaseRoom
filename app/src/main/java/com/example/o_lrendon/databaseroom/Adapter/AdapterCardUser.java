package com.example.o_lrendon.databaseroom.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.o_lrendon.databaseroom.Model.User;
import com.example.o_lrendon.databaseroom.R;
import java.util.List;


public class AdapterCardUser extends RecyclerView.Adapter<AdapterCardUser.CardUserHolder>
{
    private final List<User> userList;
    private final int resource;
    private final Activity activity;

    public AdapterCardUser(final List<User> userList, final int resource, final Activity activity) {
        this.userList = userList;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public CardUserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(this.resource, parent, false);
        return new CardUserHolder(view);
    }

    @Override
    public void onBindViewHolder(CardUserHolder holder, int position) {
        final User user = userList.get(position);
        holder.tvNameAndLastName.setText(user.getNameAndLastName());
        holder.tvAddress.setText(user.getAddress());
        holder.tvEmail.setText(user.getEmail());
        holder.tvIdUser.setText(String.valueOf(user.getUid()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class CardUserHolder extends RecyclerView.ViewHolder {

        public final TextView tvEmail, tvNameAndLastName , tvAddress, tvIdUser;
        public final RelativeLayout rlBackground;
        public final LinearLayout llInfo;

        public CardUserHolder(View itemView) {
            super(itemView);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvNameAndLastName = itemView.findViewById(R.id.tvNameAndLastName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvIdUser = itemView.findViewById(R.id.tvIdUser);
            llInfo = itemView.findViewById(R.id.llInfo);
            rlBackground = itemView.findViewById(R.id.rlBackground);

        }
    }

    public void removeItem(final int position)
    {
        userList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(final User itemUser, final int position)
    {
        userList.add(position, itemUser);
        notifyItemInserted(position);
    }
}
