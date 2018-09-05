// Generated code from Butter Knife. Do not modify!
package com.example.o_lrendon.databaseroom;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.etEmail = Utils.findRequiredViewAsType(source, R.id.etEmail, "field 'etEmail'", EditText.class);
    target.etNameAnsLastName = Utils.findRequiredViewAsType(source, R.id.etNameAnsLastName, "field 'etNameAnsLastName'", EditText.class);
    target.etAdress = Utils.findRequiredViewAsType(source, R.id.etAdress, "field 'etAdress'", EditText.class);
    target.btnInformationSave = Utils.findRequiredViewAsType(source, R.id.btnInformationSave, "field 'btnInformationSave'", Button.class);
    target.rvCardUser = Utils.findRequiredViewAsType(source, R.id.rvCardUser, "field 'rvCardUser'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etEmail = null;
    target.etNameAnsLastName = null;
    target.etAdress = null;
    target.btnInformationSave = null;
    target.rvCardUser = null;
  }
}
