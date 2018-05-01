package com.cconnachan.bottomnavpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddFoodFragment extends Fragment implements View.OnClickListener{

    Spinner spinner;
    ArrayAdapter<CharSequence> spinnerAdapter;
    View viewToInflate;
    String mealTypeSelected;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewToInflate = inflater.inflate(R.layout.fragment_add_food, null);

        mealTypeSelected = null;

        //SPINNER

        //This is initializing my spinner.
        spinner = viewToInflate.findViewById(R.id.spinner);
        //This is getting the stuff I need to put in the spinner and give it a look.
        spinnerAdapter = ArrayAdapter.createFromResource(getContext(), R.array.meal_types, android.R.layout.simple_spinner_item);
        //This is to give the spinner dropdown items a look.
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //This is to set the adapter
        spinner.setAdapter(spinnerAdapter);

        //This is what happens when there is a click on the dropdown. It's an override method.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //This is a toast that will pop up when the dropdown item is selected.
                Toast.makeText(getContext(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_SHORT).show();

                mealTypeSelected = (String) parent.getItemAtPosition(position);



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //END SPINNER

        //BUTTON

        Button button = viewToInflate.findViewById(R.id.addFoodButtonId);
        button.setOnClickListener(this);

        //END BUTTON


        return viewToInflate;
    }



    //For button onClick
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addFoodButtonId:
            //Create new food object.
                // Add new food object into the FoodRecord array.
                //Create a toast to say the item is added.

                break;
        }
    }

    //To get back food name input from user.
    public String getFoodName(){
        TextView name = viewToInflate.findViewById(R.id.foodInputTextViewId);
        String foodName = (String) name.getText();
        return foodName;
    }

    //To get back food date input from user.
    public String getFoodDate(){
        TextView date = viewToInflate.findViewById(R.id.dateInputTextViewId);
        String foodDate = (String) date.getText();
        return foodDate;
    }

    //To get back meal type input from user.
    public MealType getMealType()
    {   String spinnerResult = mealTypeSelected;
        MealType mealTypeToReturn = null;

        for (MealType meal : MealType.values()) {
            if (spinnerResult == meal.getEnumMealName()){
                mealTypeToReturn = meal;
            }
        }

        return mealTypeToReturn;
    }


}




