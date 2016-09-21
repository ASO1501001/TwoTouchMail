package st.asojuku.ac.jp.study2_2;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PickUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_up);

        Button btnSend = (Button)this.findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgPlace = (RadioGroup)findViewById(R.id.rg_place);
                int checkedId = rgPlace.getCheckedRadioButtonId();
                String strPlace = ((RadioButton)findViewById(checkedId)).getText().toString();
                EditText edit01 = (EditText)findViewById(R.id.editText);
                String title = edit01.getText().toString();

                Resources res = getResources();


                Uri uri = Uri.parse("mailto:"+ mailtoRandom(res));

                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra(Intent.EXTRA_SUBJECT,title);
                intent.putExtra(Intent.EXTRA_TEXT,strPlace+"に迎えにきて");

                startActivity(intent);

            }
        });
    }

    public String mailtoRandom(Resources res){
        int a = (((int)Math.random())*3)+1;
        switch (a) {
            case 1:
                return res.getString(R.string.mail_to1).toString();
            case 2:
                return res.getString(R.string.mail_to2).toString();
            case 3:
                return res.getString(R.string.mail_to3).toString();
            default:
                return "";
        }
    }
}
