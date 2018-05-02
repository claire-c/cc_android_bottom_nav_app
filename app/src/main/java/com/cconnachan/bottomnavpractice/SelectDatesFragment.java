package com.cconnachan.bottomnavpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectDatesFragment extends Fragment implements View.OnClickListener{

    View viewToInflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate fragment.
        viewToInflate = inflater.inflate(R.layout.fragment_select_dates, null);

        //BUTTON

        Button button = viewToInflate.findViewById(R.id.selectDatesButtonId);
        button.setOnClickListener(this);

        //END BUTTON

        return viewToInflate;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.selectDatesButtonId:

                FoodRecord foodRecord = Persister.load(getContext());
                ArrayList<Food> foodBetweenDates = foodRecord.getFoodBetweenDates(getDateFrom(), getDateTo());


                Toast.makeText(getContext(), R.string.addfood_toast_confirmation,
                        Toast.LENGTH_SHORT).show();


                break;
        }
    }


    //To get back first date selected by the user.
    public String getDateFrom(){
        TextView firstDate = viewToInflate.findViewById(R.id.dateFromEditTextId);
        String dateFrom = firstDate.getText().toString();
        return dateFrom;
    }

    //To get back second date selected by the user.
    public String getDateTo(){
        TextView secondDate = viewToInflate.findViewById(R.id.dateToEditTextId);
        String dateTo = secondDate.getText().toString();
        return dateTo;
    }

}
