package fastcampus.aop.part2.componenttest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import java.util.*

class MainActivity : AppCompatActivity() {
    private val numberPicker: NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numberPicker).apply {
            minValue=0
            maxValue=9
        }
    }
    private val button: Button by lazy{
        findViewById(R.id.button)
    }
    private val editText: EditText by lazy{
        findViewById(R.id.editText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker

        button.setOnClickListener{
            val passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);
            passwordPreferences.edit{
                putString("password","7")
            }
            val passwordFromUser = numberPicker.value.toString()
            if (passwordPreferences.getString("password","3").equals(passwordFromUser)){
                editText.setText("정답")
            }
            else{
                AlertDialog.Builder(this)
                    .setTitle("실패")
                    .setMessage("비밀번호가 잘못 되었습니다.")
                    .setPositiveButton("확인"){_,_->}
                    .create()
                    .show()
            }
        }

    }


}