package college.edu.tomer.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class DateFragment extends Fragment implements View.OnClickListener {
    DatePicker datePicker;
    Button btnSetDate;
    private OnDateSelected listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_date, container, false);
        //findViewById
        datePicker = (DatePicker) v.findViewById(R.id.datePicker);
        btnSetDate = (Button) v.findViewById(R.id.btnSelect);
        btnSetDate.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        int dayOfMonth = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        if (listener!=null){
            listener.onDateSelected(dayOfMonth, month, year);
        }
    }

    public void setOnDateSelectedListener(OnDateSelected listener){
        this.listener = listener;
    }
    public interface OnDateSelected{
        void onDateSelected(int day, int month, int year);
    }
}
