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
            val checkedItemsDay = ArrayList<String>()
            val checkedItemsMeal = ArrayList<String>()
            val alertBuilder1 = AlertDialog.Builder(it)
            val alertBuilder2 = AlertDialog.Builder(it)
            var cont = false

            alertBuilder1.setTitle("Select a day")
            alertBuilder1.setMultiChoiceItems(R.array.day, null, DialogInterface.OnMultiChoiceClickListener { dialog, index, checked ->
                if (checked) {
                    checkedItemsDay.add(index.toString())
                } else if (checkedItemsDay.contains(index.toString())) {
                    checkedItemsDay.remove(index.toString())
                }
            })
            alertBuilder1.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id -> cont = true})
            alertBuilder1.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id -> Log.d("DialogLog", "Cancelled") })


            if (cont) {
                Log.d("DialogLog", "Cancelled")
                alertBuilder2.setTitle("Select a meal")
                alertBuilder2.setMultiChoiceItems(R.array.meal,
                    null,
                    DialogInterface.OnMultiChoiceClickListener { dialog, index, checked ->
                        if (checked) {
                            checkedItemsMeal.add(index.toString())
                        } else if (checkedItemsMeal.contains(index.toString())) {
                            checkedItemsMeal.remove(index.toString())
                        }
                    })
                alertBuilder2.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, id -> Log.d("DialogLog", "Ok pressed with checked meal: " + checkedItemsMeal + " Ok pressed with checked day: " + checkedItemsDay) })




                alertBuilder2.create()
            }

            alertBuilder1.create()

        } ?: throw IllegalStateException("Exception !! Activity is null !!")
    }
}