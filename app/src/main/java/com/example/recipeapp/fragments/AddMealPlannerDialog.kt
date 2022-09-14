import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.recipeapp.R
import java.lang.IllegalStateException

class AddMealPlannerDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val checkedItems = ArrayList<Int>()
            val alertBuilder = AlertDialog.Builder(it)

            alertBuilder.setTitle("Select an option")
            alertBuilder.setMultiChoiceItems(R.array.add_meal, null, DialogInterface.OnMultiChoiceClickListener { dialog, index, checked ->
                if (checked) {
                    checkedItems.add(index)
                } else if (checkedItems.contains(index)) {
                    checkedItems.remove(index)
                }
            })
            alertBuilder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id -> Log.d("DialogLog", "Ok pressed with checked items : " + checkedItems) })

            alertBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id -> Log.d("DialogLog", "Ok pressed with checked items : " + checkedItems) })
            alertBuilder.create()
        } ?: throw IllegalStateException("Exception !! Activity is null !!")
    }
}