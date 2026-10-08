# 🚪 GatePass – Android UI

> Digital Visitor Management System UI for **MET College Institute**

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)
![Language](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)
![UI](https://img.shields.io/badge/UI-XML-blue)
![Status](https://img.shields.io/badge/Status-UI%20Complete-brightgreen)

---

## 📑 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Application Flow](#-application-flow)
- [Admin Module](#-admin-module)
- [Guard Module](#-guard-module)
- [Project Structure](#-project-structure)
- [Tech Stack](#-tech-stack)
- [Getting Started](#-getting-started)
- [Project Objectives](#-project-objectives)
- [Current Status](#-current-status)
- [Future Scope](#-future-scope)
- [Developer](#-developer)

---

## 📌 Overview

**GatePass** is an Android-based visitor management app UI designed for **MET College Institute**. Visitor entry at the college gate is currently registered manually. GatePass replaces this with a digital flow:

- The **Guard** shows a QR code at the gate.
- The **Visitor** scans it with their own phone and fills in a registration form.
- The **Guard** accepts or rejects the request and tracks accepted visitors.
- The **Admin** manages guards and reviews daily visitor records.

> ⚠️ This repository currently contains the **UI and navigation flow only**. Backend, database, and real visitor registration processing will be added later.

---

## ✨ Features

| Feature | Description |
|---|---|
| 🔐 Role-Based Login | Separate login for Admin and Guard |
| 👨‍💼 Admin Dashboard | Manage guards and view daily records |
| 🛡️ Guard Dashboard | Show QR, handle visitor requests, view visitor list |
| 📱 QR-Based Registration | Guard displays a QR; visitor scans it on their own phone |
| ✅ Request Management | Accept or reject visitor requests |
| 👥 Guard Management | Add and view guards, assign gate shifts |
| 📊 Daily Records | View, search, and filter visitor records by date |
| 🚪 Logout | Available for both Admin and Guard |

---

## 🔄 Application Flow

```text
Splash Screen
     │
     ▼
Login Screen
     │
     ▼
 Role Check
     │
 ┌───┴──────────────┐
 ▼                  ▼
Admin Dashboard   Guard Dashboard
 │                  │
 ├─ Manage Guards   ├─ Show QR
 └─ Daily Records   ├─ Visitor Requests
                    └─ Visitor List
     │                  │
     └────────┬─────────┘
              ▼
           Logout
              │
              ▼
        Login Screen
```

---

## 👨‍💼 Admin Module

```text
Admin Login → Admin Dashboard
                  │
        ┌─────────┴─────────┐
        ▼                   ▼
  Manage Guards        Daily Records
        │                   │
   View Guards         View Records
        │
    Add Guard
        │
    Save Guard
```

**Manage Guards**
- View registered guards
- Add a new guard
- Enter guard information
- Assign gate shift
- Auto-generated password information

**Daily Records**
- View visitor records and daily entry information
- Search records
- Filter by date

**Logout** – returns to the Login screen.

---

## 🛡️ Guard Module

```text
Guard Login → Guard Dashboard
                  │
     ┌────────────┼────────────────┐
     ▼            ▼                ▼
  Show QR   Visitor Requests   Visitor List
     │            │                │
  QR Popup   Accept / Reject   Accepted Visitors
     │            │
 Visitor      Visitor Status
 Scans QR
     │
 Visitor Registration
```

**📱 Show Visitor QR** – Opens a popup with the visitor registration QR code so visitors can register from their own phones.

**📋 Visitor Requests** – View incoming requests and **Accept** or **Reject** them.

**👥 Visitor List** – View accepted visitors and their entry information.

**🚪 Logout** – returns to the Login screen.

---

## 🏗️ Project Structure

```text
GatePass/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/ishwar/gatepass/
│           │   ├── SplashActivity.java
│           │   ├── LoginActivity.java
│           │   ├── MainActivity.java
│           │   ├── AdminDashboardActivity.java
│           │   ├── GuardDashboardActivity.java
│           │   └── DailyRecordsActivity.java
│           └── res/
│               ├── layout/
│               ├── drawable/
│               ├── mipmap/
│               └── values/
└── README.md
```

---

## 🧰 Tech Stack

| Category | Technology |
|---|---|
| Platform | Android |
| Language | Java |
| UI | XML layouts |
| IDE | Android Studio |

---

## 🚀 Getting Started

1. **Clone the repository**
```bash
   git clone https://github.com/<your-username>/GatePass.git
```
2. Open the project in **Android Studio**.
3. Let Gradle sync finish.
4. Run on an emulator or a physical Android device.

> The app uses dummy data for now, so no backend setup is needed.

---

## 🎯 Project Objectives

1. Reduce manual visitor registration.
2. Provide a simple digital interface for security guards.
3. Let visitors register through QR scanning.
4. Give the Admin control over guard management.
5. Maintain digital daily visitor records.
6. Make visitor approval easier for guards.
7. Offer a professional, organized gate management interface.

---

## 📌 Current Status

**Completed**
- [x] UI design
- [x] Splash screen
- [x] Login interface
- [x] Admin dashboard
- [x] Guard dashboard
- [x] Manage Guards and Add Guard UI
- [x] Daily Records UI
- [x] Visitor Request and Visitor List UI
- [x] QR popup UI
- [x] Logout flow

**In Progress / Planned**
- [ ] Backend integration
- [ ] Database integration
- [ ] Real-time visitor management

---

## 🔮 Future Scope

- Real QR generation linked to a visitor registration form
- Token generation with date, time, and reason for visit
- Persistent storage for guards and visitor records
- Exportable daily reports

---

## 👨‍💻 Developer

**Ishwar Bachhav**

| Detail | Information |
|---|---|
| Project | GatePass |
| Institute | MET College Institute |
| Platform | Android |
| Language | Java |
| UI | XML |
