package com.example.o_lrendon.databaseroom;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.o_lrendon.databaseroom.Adapter.AdapterCardUser;
import com.example.o_lrendon.databaseroom.Adapter.RecyclerItemTouchHelper;
import com.example.o_lrendon.databaseroom.DB.DataBase;
import com.example.o_lrendon.databaseroom.Model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etNameAnsLastName)
    EditText etNameAnsLastName;

    @BindView(R.id.etAdress)
    EditText etAdress;

    @BindView(R.id.btnInformationSave)
    Button btnInformationSave;

    @BindView(R.id.rvCardUser)
    RecyclerView rvCardUser;

    private DataBase db = null;
    private AdapterCardUser adapterCardUser;
    private List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        db = DataBase.getDataBase(this);
        btnInformationSave.setOnClickListener(this);
        userList = db.daoUser().getAllUser();
        userReload();

        ItemTouchHelper.SimpleCallback simpleCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);

        new ItemTouchHelper(simpleCallback).attachToRecyclerView(rvCardUser);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnInformationSave)
        {
            final User user = new User(etEmail.getText().toString(),etNameAnsLastName.getText().toString(),etAdress.getText().toString());
            long insert = db.daoUser().inserrUser(user);
            final List<User> userList =  db.daoUser().getAllUserbyId(etEmail.getText().toString());
            Snackbar.make(findViewById(R.id.clScreen),  insert > 0 ? "El registro se genero correctamente." : "No se pudo insertar el registro.", Snackbar.LENGTH_SHORT).show();
            if(insert > 0 && userList != null && !userList.isEmpty())
            {
                reload(userList.get(0));
            }
        }
    }

    private void userReload()
    {
        this.adapterCardUser = new AdapterCardUser(this.userList, R.layout.card, this);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        this.rvCardUser.setHasFixedSize(true);
        this.rvCardUser.setLayoutManager(linearLayoutManager);
        this.rvCardUser.setItemAnimator(new DefaultItemAnimator());
        this.rvCardUser.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        this.rvCardUser.setAdapter(this.adapterCardUser);
    }

    private void reload(final User user){
        this.userList.add(0,user);
        this.adapterCardUser.notifyItemInserted(0);
    }

    @Override
    protected void onDestroy() {
        DataBase.destroyInstance();
        super.onDestroy();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if(viewHolder instanceof AdapterCardUser.CardUserHolder)
        {
            final User user = new User(
                    Integer.parseInt(((AdapterCardUser.CardUserHolder) viewHolder).tvIdUser.getText().toString()),
                    ((AdapterCardUser.CardUserHolder) viewHolder).tvEmail.getText().toString(),
                    ((AdapterCardUser.CardUserHolder) viewHolder).tvNameAndLastName.getText().toString(),
                    ((AdapterCardUser.CardUserHolder) viewHolder).tvAddress.getText().toString());
            int delete = db.daoUser().deleteUser(user);

            if(delete > 0) {
                this.adapterCardUser.removeItem(viewHolder.getAdapterPosition());
                Snackbar.make(findViewById(R.id.clScreen), "Se elimino el registro", Snackbar.LENGTH_SHORT).setActionTextColor(Color.YELLOW).show();
            }
        }
    }
}
