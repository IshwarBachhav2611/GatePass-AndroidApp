package com.ishwar.gatepass;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AdminDashboardActivity extends AppCompatActivity {

    private CardView cardManageGuards;
    private CardView cardDailyRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_dashboard);

        initializeViews();
        setupClickListeners();
    }

    // INITIALIZE VIEWS
    private void initializeViews() {

        cardManageGuards = findViewById(
                R.id.cardManageGuards
        );

        cardDailyRecords = findViewById(
                R.id.cardDailyRecords
        );
    }


    // CLICK LISTENERS
    private void setupClickListeners() {

        // Manage Guards
        cardManageGuards.setOnClickListener(
                v -> showManageGuardsPopup()
        );


        // Daily Records
        cardDailyRecords.setOnClickListener(
                v -> showDailyRecordsPopup()
        );


        // Menu
        TextView btnMenu = findViewById(R.id.btnMenu);

        if (btnMenu != null) {

            btnMenu.setOnClickListener(
                    v -> showAdminMenu(btnMenu)
            );
        }
    }

    // ADMIN CONTEXT MENU
    private void showAdminMenu(TextView anchor) {

        PopupMenu popupMenu = new PopupMenu(
                AdminDashboardActivity.this,
                anchor
        );

        // Add menu option
        popupMenu.getMenu().add("Logout");


        popupMenu.setOnMenuItemClickListener(
                item -> {

                    if (item.getTitle().toString().equals("Logout")) {

                        logout();

                        return true;
                    }

                    return false;
                }
        );

        popupMenu.show();
    }

    // LOGOUT
    private void logout() {

        Intent intent = new Intent(
                AdminDashboardActivity.this,
                LoginActivity.class
        );

        /*
         * Clear all previous activities.
         * User cannot press Back and return to dashboard.
         */
        intent.setFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK
        );

        startActivity(intent);

        finish();
    }

    // MANAGE GUARDS POPUP
    private void showManageGuardsPopup() {

        Dialog dialog = createDialog(
                R.layout.dialog_manage_guards
        );

        TextView btnAddGuard =
                dialog.findViewById(
                        R.id.btnAddGuard
                );

        TextView btnClose =
                dialog.findViewById(
                        R.id.btnCloseGuards
                );


        // Add Guard
        btnAddGuard.setOnClickListener(v -> {

            dialog.dismiss();

            showAddGuardDialog();
        });


        // Close
        btnClose.setOnClickListener(
                v -> dialog.dismiss()
        );


        dialog.show();

        setDialogSize(dialog);
    }

    // ADD GUARD DIALOG
    private void showAddGuardDialog() {

        Dialog dialog = createDialog(
                R.layout.dialog_add_guard
        );


        // Cancel button
        TextView btnCancel =
                dialog.findViewById(
                        R.id.btnCancelAddGuard
                );


        // Add Guard button
        TextView btnSave =
                dialog.findViewById(
                        R.id.btnSaveGuard
                );


        // Cancel
        btnCancel.setOnClickListener(
                v -> dialog.dismiss()
        );


        // Add Guard
        btnSave.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Guard added successfully",
                    Toast.LENGTH_SHORT
            ).show();

            dialog.dismiss();
        });


        dialog.show();

        setDialogSize(dialog);
    }

    // DAILY RECORDS
    private void showDailyRecordsPopup() {

        Intent intent = new Intent(
                AdminDashboardActivity.this,
                DailyRecordsActivity.class
        );

        startActivity(intent);
    }

    // CREATE DIALOG
    private Dialog createDialog(int layoutId) {

        Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(
                Window.FEATURE_NO_TITLE
        );

        dialog.setContentView(layoutId);

        if (dialog.getWindow() != null) {

            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );
        }

        return dialog;
    }

    // DIALOG SIZE
    private void setDialogSize(Dialog dialog) {

        if (dialog.getWindow() != null) {

            WindowManager.LayoutParams params =
                    dialog.getWindow().getAttributes();

            params.width =
                    WindowManager.LayoutParams.MATCH_PARENT;

            params.height =
                    WindowManager.LayoutParams.WRAP_CONTENT;

            dialog.getWindow().setAttributes(params);
        }
    }
}