package com.ishwar.gatepass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView btnAdmin;
    private TextView btnGuard;
    private TextView btnLogin;

    private EditText edtUsername;
    private EditText edtPassword;

    private String selectedRole = "ADMIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        initializeViews();
        setupRoleSelection();
        setupLogin();
    }

    // INITIALIZE VIEWS
    private void initializeViews() {

        btnAdmin = findViewById(R.id.btnAdmin);
        btnGuard = findViewById(R.id.btnGuard);
        btnLogin = findViewById(R.id.btnLogin);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
    }

    // ROLE SELECTION
     private void setupRoleSelection() {

        btnAdmin.setOnClickListener(v -> {

            selectedRole = "ADMIN";

            updateRoleUI();
        });


        btnGuard.setOnClickListener(v -> {

            selectedRole = "GUARD";

            updateRoleUI();
        });
    }

    // UPDATE ROLE UI
     private void updateRoleUI() {

        if (selectedRole.equals("ADMIN")) {

            btnAdmin.setBackgroundColor(
                    getColor(android.R.color.holo_red_dark)
            );

            btnAdmin.setTextColor(
                    getColor(android.R.color.white)
            );

            btnGuard.setBackgroundColor(
                    getColor(android.R.color.white)
            );

            btnGuard.setTextColor(
                    getColor(android.R.color.darker_gray)
            );

        } else {

            btnGuard.setBackgroundColor(
                    getColor(android.R.color.holo_red_dark)
            );

            btnGuard.setTextColor(
                    getColor(android.R.color.white)
            );

            btnAdmin.setBackgroundColor(
                    getColor(android.R.color.white)
            );

            btnAdmin.setTextColor(
                    getColor(android.R.color.darker_gray)
            );
        }
    }

    // LOGIN
    private void setupLogin() {

        btnLogin.setOnClickListener(v -> {

            String username =
                    edtUsername.getText().toString().trim();

            String password =
                    edtPassword.getText().toString().trim();


            // Empty field validation
            if (username.isEmpty()) {

                edtUsername.setError(
                        "Enter username"
                );

                edtUsername.requestFocus();

                return;
            }


            if (password.isEmpty()) {

                edtPassword.setError(
                        "Enter password"
                );

                edtPassword.requestFocus();

                return;
            }


            // Temporary UI-only login
            if (selectedRole.equals("ADMIN")) {

                if (username.equals("admin")
                        && password.equals("admin123")) {

                    openAdminDashboard();

                } else {

                    showLoginError();
                }

            } else {

                if (username.equals("guard")
                        && password.equals("guard123")) {

                    openGuardDashboard();

                } else {

                    showLoginError();
                }
            }
        });
    }

    // OPEN ADMIN DASHBOARD
    private void openAdminDashboard() {

        Toast.makeText(
                this,
                "Admin login successful",
                Toast.LENGTH_SHORT
        ).show();

        Intent intent =
                new Intent(
                        LoginActivity.this,
                        AdminDashboardActivity.class
                );

        startActivity(intent);

        finish();
    }

    // OPEN GUARD DASHBOARD
    private void openGuardDashboard() {

        Toast.makeText(
                this,
                "Guard login successful",
                Toast.LENGTH_SHORT
        ).show();

        Intent intent =
                new Intent(
                        LoginActivity.this,
                        GuardDashboardActivity.class
                );

        startActivity(intent);

        finish();
    }

    // LOGIN ERROR
    private void showLoginError() {

        Toast.makeText(
                this,
                "Invalid username or password",
                Toast.LENGTH_SHORT
        ).show();
    }
}
