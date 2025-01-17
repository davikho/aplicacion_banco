// Generated by view binder compiler. Do not edit!
package app.example.pruebagit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import app.example.pruebagit.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityJuegoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatButton btnGuess;

  @NonNull
  public final Button btnReset;

  @NonNull
  public final EditText etGuess;

  @NonNull
  public final LinearLayout main;

  @NonNull
  public final TextView tvAttempts;

  @NonNull
  public final TextView tvFeedback;

  @NonNull
  public final ImageView vidas;

  private ActivityJuegoBinding(@NonNull LinearLayout rootView, @NonNull AppCompatButton btnGuess,
      @NonNull Button btnReset, @NonNull EditText etGuess, @NonNull LinearLayout main,
      @NonNull TextView tvAttempts, @NonNull TextView tvFeedback, @NonNull ImageView vidas) {
    this.rootView = rootView;
    this.btnGuess = btnGuess;
    this.btnReset = btnReset;
    this.etGuess = etGuess;
    this.main = main;
    this.tvAttempts = tvAttempts;
    this.tvFeedback = tvFeedback;
    this.vidas = vidas;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityJuegoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityJuegoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_juego, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityJuegoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnGuess;
      AppCompatButton btnGuess = ViewBindings.findChildViewById(rootView, id);
      if (btnGuess == null) {
        break missingId;
      }

      id = R.id.btnReset;
      Button btnReset = ViewBindings.findChildViewById(rootView, id);
      if (btnReset == null) {
        break missingId;
      }

      id = R.id.etGuess;
      EditText etGuess = ViewBindings.findChildViewById(rootView, id);
      if (etGuess == null) {
        break missingId;
      }

      LinearLayout main = (LinearLayout) rootView;

      id = R.id.tvAttempts;
      TextView tvAttempts = ViewBindings.findChildViewById(rootView, id);
      if (tvAttempts == null) {
        break missingId;
      }

      id = R.id.tvFeedback;
      TextView tvFeedback = ViewBindings.findChildViewById(rootView, id);
      if (tvFeedback == null) {
        break missingId;
      }

      id = R.id.vidas;
      ImageView vidas = ViewBindings.findChildViewById(rootView, id);
      if (vidas == null) {
        break missingId;
      }

      return new ActivityJuegoBinding((LinearLayout) rootView, btnGuess, btnReset, etGuess, main,
          tvAttempts, tvFeedback, vidas);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
