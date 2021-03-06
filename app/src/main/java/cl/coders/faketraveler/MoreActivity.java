package cl.coders.faketraveler;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

public class MoreActivity extends AppCompatActivity {

    static final String sharedPrefKey = "cl.coders.mockposition.sharedpreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        EditText editText2;
        EditText editText3;
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());

        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE);

        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        editText2.setText(sharedPref.getString("howManyTimes", "1"));
        editText3.setText(sharedPref.getString("timeInterval", "10"));

        editText2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                EditText editText2 = findViewById(R.id.editText2);
                Context context = getApplicationContext();
                SharedPreferences sharedPref = context.getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();
                if(editText2.getText().toString().isEmpty())
                    editor.putString("howManyTimes", "1");
                else
                    editor.putString("howManyTimes", editText2.getText().toString());
                editor.commit();
            }
        });

        editText3.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                EditText editText3 = findViewById(R.id.editText3);
                Context context = getApplicationContext();
                SharedPreferences sharedPref = context.getSharedPreferences(sharedPrefKey, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();
                if(editText3.getText().toString().isEmpty())
                    editor.putString("timeInterval", "10");
                else
                    editor.putString("timeInterval", editText3.getText().toString());
                editor.commit();
            }
        });
    }


}
