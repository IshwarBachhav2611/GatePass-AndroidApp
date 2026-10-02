package com.ishwar.gatepass;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DailyRecordsActivity extends AppCompatActivity {

    private TextView btnBack;
    private EditText edtSearch;
    private TextView txtSelectedDate;
    private TextView btnDateFilter;
    private TextView txtRecordCount;

    private Calendar selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_daily_records);

        initializeViews();
        setupClickListeners();
        setupSearch();

        selectedDate = Calendar.getInstance();

        updateSelectedDate();
    }

    // INITIALIZE VIEWS
    private void initializeViews() {

        btnBack = findViewById(R.id.btnBack);

        edtSearch = findViewById(R.id.edtSearch);

        txtSelectedDate = findViewById(R.id.txtSelectedDate);

        btnDateFilter = findViewById(R.id.btnDateFilter);

        txtRecordCount = findViewById(R.id.txtRecordCount);
    }


    // CLICK LISTENERS
    private void setupClickListeners() {

        // Back
        btnBack.setOnClickListener(v -> finish());


        // Date Filter
        btnDateFilter.setOnClickListener(v -> showDatePicker());
    }


    // SEARCH
    private void setupSearch() {

        edtSearch.setOnEditorActionListener((v, actionId, event) -> {

            performSearch();

            return false;
        });

        edtSearch.addTextChangedListener(
                new android.text.TextWatcher() {

                    @Override
                    public void beforeTextChanged(
                            CharSequence s,
                            int start,
                            int count,
                            int after
                    ) {
                    }

                    @Override
                    public void onTextChanged(
                            CharSequence s,
                            int start,
                            int before,
                            int count
                    ) {
                        performSearch();
                    }

                    @Override
                    public void afterTextChanged(
                            android.text.Editable s
                    ) {
                    }
                }
        );
    }


    // SEARCH LOGIC - UI ONLY
    private void performSearch() {

        String searchText =
                edtSearch.getText()
                        .toString()
                        .trim()
                        .toLowerCase();

        /*
         * UI-only demonstration.
         *
         * Actual database filtering will be added later.
         */

        if (searchText.isEmpty()) {

            txtRecordCount.setText("12 Records");

        } else if (
                searchText.contains("gp-001")
                        || searchText.contains("john")
                        || searchText.contains("official")
        ) {

            txtRecordCount.setText("1 Record");

        } else if (
                searchText.contains("gp-002")
                        || searchText.contains("sneha")
                        || searchText.contains("interview")
        ) {

            txtRecordCount.setText("1 Record");

        } else if (
                searchText.contains("gp-003")
                        || searchText.contains("amit")
                        || searchText.contains("personal")
        ) {

            txtRecordCount.setText("1 Record");

        } else {

            txtRecordCount.setText("0 Records");
        }
    }

    // DATE PICKER
     private void showDatePicker() {

        Calendar calendar = Calendar.getInstance();

        if (selectedDate != null) {
            calendar = selectedDate;
        }

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(
                        this,
                        (view, selectedYear, selectedMonth, selectedDay) -> {

                            selectedDate = Calendar.getInstance();

                            selectedDate.set(
                                    selectedYear,
                                    selectedMonth,
                                    selectedDay
                            );

                            updateSelectedDate();

                            /*
                             * Later this will filter records
                             * from the database.
                             */
                            txtRecordCount.setText("12 Records");

                        },
                        year,
                        month,
                        day
                );

        datePickerDialog.show();
    }

    // UPDATE SELECTED DATE
    private void updateSelectedDate() {

        if (selectedDate == null) {
            return;
        }

        SimpleDateFormat dateFormat =
                new SimpleDateFormat(
                        "dd MMMM yyyy",
                        Locale.getDefault()
                );

        String formattedDate =
                dateFormat.format(selectedDate.getTime());

        txtSelectedDate.setText(formattedDate);
    }
}