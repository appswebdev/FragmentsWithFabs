package college.edu.tomer.myapplication;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment implements View.OnClickListener {
    TimePicker timePicker;
    Button btnSetTime;
    private OnTimePickedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  v = inflater.inflate(R.layout.fragment_time, container, false);
        timePicker = (TimePicker) v.findViewById(R.id.timePicker);
        btnSetTime = (Button) v.findViewById(R.id.btnSetTime);
        btnSetTime.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {
        int hour, minute;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
            minute = timePicker.getMinute();
        }
        else {
            hour = timePicker.getCurrentHour();
            minute = timePicker.getCurrentMinute();
        }

        if (listener!=null){
            listener.onTimePicked(hour, minute);
        }
    }

    public void setListener(OnTimePickedListener listener) {
        this.listener = listener;
    }



    public interface OnTimePickedListener{
        void onTimePicked(int hour, int minute);
    }
}
