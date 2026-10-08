# GatePass – Android UI

GatePass is an **Android-based digital visitor management system UI** designed for **MET College Institute**. The application provides separate interfaces for **Admin** and **Guard** to make visitor management more organized and easier to handle.


## 📌 Project Overview

At MET College, visitor entry can involve manual registration and record keeping. GatePass provides a digital interface where guards can display a **QR code for visitor registration**, manage visitor requests, and view accepted visitors.

The Admin interface allows administrators to **manage guards** and **view daily visitor records**.

The current project mainly focuses on the **UI and navigation flow**. Backend, database, and actual visitor registration processing can be integrated later.


# 🔄 Application Flow

                         ┌─────────────────┐
                         │  Splash Screen  │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │   Login Screen  │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │    Role Check   │
                         └────────┬────────┘
                                  │
                    ┌─────────────┴─────────────┐
                    │                           │
                    ▼                           ▼
            ┌───────────────┐           ┌───────────────┐
            │     Admin     │           │     Guard     │
            │   Dashboard   │           │   Dashboard   │
            └───────┬───────┘           └───────┬───────┘
                    │                           │
          ┌─────────┴─────────┐        ┌────────┴─────────┐
          │                   │        │                  │
          ▼                   ▼        ▼                  ▼
 ┌────────────────┐  ┌───────────────┐ ┌────────────┐ ┌──────────────────┐
 │ Manage Guards  │  │ Daily Records │ │  Show QR   │ │ Visitor Requests │
 └───────┬────────┘  └───────────────┘ └─────┬──────┘ └────────┬─────────┘
         │                                   │                 │
         ▼                                   ▼                 ▼
 ┌────────────────┐                   ┌────────────┐    ┌───────────────┐
 │ Add / View     │                   │  QR Popup  │    │Accept / Reject │
 │ Guards         │                   └─────┬──────┘    └───────┬───────┘
 └────────────────┘                         │                   │
                                            ▼                   ▼
                                   ┌─────────────────┐   ┌───────────────┐
                                   │ Visitor Scans QR│   │ Visitor List  │
                                   └────────┬────────┘   └───────┬───────┘
                                            │                    │
                                            ▼                    │
                                   ┌────────────────────┐        │
                                   │Visitor Registration│        │
                                   └────────────────────┘        │
                                                                 │
                                                                 ▼
                                                            ┌────────┐
                                                            │ Logout │
                                                            └───┬────┘
                                                                │
                                                                ▼
                                                             ┌───────┐
                                                             │ Login │
                                                             └───────┘

#👨‍💼 Admin Flow
After successful Admin login:

                    ┌───────────────┐
                    │  Admin Login  │
                    └───────┬───────┘
                            │
                            ▼
                  ┌───────────────────┐
                  │  Admin Dashboard  │
                  └─────────┬─────────┘
                            │
                 ┌──────────┴──────────┐
                 │                     │
                 ▼                     ▼
        ┌────────────────┐    ┌────────────────┐
        │ Manage Guards  │    │ Daily Records  │
        └───────┬────────┘    └───────┬────────┘
                │                     │
                ▼                     ▼
        ┌────────────────┐    ┌────────────────┐
        │  View Guards   │    │  View Records  │
        └───────┬────────┘    └────────────────┘
                │
                ▼
        ┌────────────────┐
        │   Add Guard    │
        └───────┬────────┘
                │
                ▼
        ┌────────────────┐
        │   Save Guard   │
        └───────┬────────┘
                │
                ▼
           ┌──────────┐
           │  Logout  │
           └────┬─────┘
                │
                ▼
           ┌──────────┐
           │  Login   │
           └──────────┘

**Admin Features**
- Manage Guards
  - View registered guards
  - Add new guard
  - Enter guard information
  - Assign gate shift
  - System-generated password information
- Daily Records
  - View visitor records
  - View daily entry information
  - Search records
  - Date-wise filtering
- Logout
  - Logout from Admin Dashboard
  - Return to Login screen
 
#🛡️ Guard Flow
After successful Guard login:

                    ┌───────────────┐
                    │  Guard Login  │
                    └───────┬───────┘
                            │
                            ▼
                  ┌───────────────────┐
                  │  Guard Dashboard  │
                  └─────────┬─────────┘
                            │
             ┌──────────────┼──────────────┐
             │              │              │
             ▼              ▼              ▼
       ┌───────────┐ ┌──────────────┐ ┌───────────────┐
       │  Show QR  │ │   Pending    │ │ Visitor List  │
       │           │ │   Requests   │ │               │
       └─────┬─────┘ └──────┬───────┘ └───────┬───────┘
             │              │                 │
             ▼              ▼                 ▼
       ┌───────────┐ ┌──────────────┐ ┌─────────────────┐
       │ QR Popup  │ │Accept/Reject │ │Accepted Visitors│
       └─────┬─────┘ └──────┬───────┘ └─────────────────┘
             │              │
             ▼              ▼
       ┌───────────────┐ ┌──────────────┐
       │Visitor Scans  │ │Visitor Status│
       │     QR        │ └──────────────┘
       └───────┬───────┘
               │
               ▼
       ┌────────────────────┐
       │Visitor Registration│
       └────────────────────┘
               │
               ▼
          ┌──────────┐
          │  Logout  │
          └────┬─────┘
               │
               ▼
          ┌──────────┐
          │  Login   │
          └──────────┘

**Guard Features**
🔐 Role-Based Login
- Admin login
- Guard login

👨‍💼 Admin Dashboard
- Manage Guards
- Daily Records

🛡️ Guard Dashboard
- Show Visitor QR
- Visitor Requests
- Visitor List

📱 QR-Based Visitor Registration
- Guard displays QR
- Visitor scans QR using phone
- Visitor registration process starts through the visitor's phone

✅ Visitor Request Management
- Accept visitor
- Reject visitor

👥 Guard Management
- Add and view guards
- Guard information and shift management

📊 Daily Records
- View visitor records
- Search records
- Date-wise filtering

🚪 Logout
- Available for both Admin and Guard


#🏗️ Project Structure
GatePass/
│
├── app/
│   └── src/
│       └── main/
│           │
│           ├── java/
│           │   └── com/ishwar/gatepass/
│           │       ├── SplashActivity.java
│           │       ├── LoginActivity.java
│           │       ├── MainActivity.java
│           │       ├── AdminDashboardActivity.java
│           │       ├── GuardDashboardActivity.java
│           │       └── DailyRecordsActivity.java
│           │
│           └── res/
│               ├── layout/
│               ├── drawable/
│               ├── mipmap/
│               └── values/
│
└── README.md

#🎯 Project Objectives
1. Reduce manual visitor registration.
2. Provide a simple digital interface for security guards.
3. Allow visitors to access registration through QR scanning.
4. Provide Admin with guard management.
5. Provide digital daily visitor records.
6. Make visitor approval easier for guards.
7. Provide a professional and organized college gate management interface.

#📌 Current Status
✅ UI Design
✅ Splash Screen
✅ Login Interface
✅ Admin Dashboard
✅ Guard Dashboard
✅ Manage Guards UI
✅ Add Guard UI
✅ Daily Records UI
✅ Visitor Request UI
✅ Visitor List UI
✅ QR Popup UI
✅ Logout UI

🔄 Backend Integration
🔄 Database Integration
🔄 Real-time Visitor Management

#👨‍💻 Developer
Ishwar Bachhav
Project: GatePass
Institute: MET College Institute
Platform: Android
Language: Java
UI: XML
      
