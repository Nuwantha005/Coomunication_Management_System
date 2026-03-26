# Communication Management System

A Java Swing desktop application for managing a communication/mobile-phone retail store. It covers point-of-sale (POS) billing, inventory, supplier and staff management, financial tracking, and reporting — all backed by a local MySQL database.

---

## Table of Contents

1. [Project Overview](#1-project-overview)
2. [Architecture](#2-architecture)
3. [Technology Stack](#3-technology-stack)
4. [Module Descriptions](#4-module-descriptions)
5. [Data Model](#5-data-model)
6. [Build & Run Instructions](#6-build--run-instructions)
7. [Notable Issues & Improvement Opportunities](#7-notable-issues--improvement-opportunities)

---

## 1. Project Overview

**Communication Management System** is a single-tier desktop application built in Java (Swing/AWT) and managed as a NetBeans IDE project. It targets shop owners and staff of a communication (mobile-phone) store and provides:

- Role-based login (Admin / Cashier)
- Point-of-sale terminal for selling items and services
- Full inventory / stock lifecycle (GRN → sales → stock deduction)
- Supplier and customer master data
- Staff records, attendance tracking, and salary payments
- General income and expense bookkeeping
- Barcode and QR-code generation for stock items
- JasperReports-based printable receipts and reports
- JFreeChart / Orson Charts 3D data visualisations
- Email notifications to customers, staff, or suppliers
- Database backup and restore via `mysqldump`

---

## 2. Architecture

```
┌─────────────────────────────────────────────────────┐
│                  Java Swing Desktop UI               │
│                                                     │
│  commiunication_software.Commiunication_Software    │  ← entry point
│           │                                         │
│    MainFrames.LogInFrame                            │  ← login gate
│           │                                         │
│    MainFrames.MainFrame  (dashboard)                │  ← navigation hub
│     ┌─────┼──────────────────────────────────┐     │
│     ↓     ↓      ↓      ↓      ↓      ↓      ↓     │
│   POS  GRN   DataEntry Details Reports Charts More  │
│                                                     │
│  DataEnteringFrames.*  DetailsFrames.*              │
│  SubFrames.*           ReportFrames.*               │
└──────────────────────────┬──────────────────────────┘
                           │  JDBC (com.mysql.jdbc.Driver)
                           ▼
              ┌────────────────────────┐
              │  MySQL  localhost:3306  │
              │  DB: Communication_    │
              │       Software         │
              └────────────────────────┘
```

All database access goes through the `MyConn.MyConn` singleton which holds a single static `java.sql.Connection`.

---

## 3. Technology Stack

| Layer | Technology |
|---|---|
| Language | Java SE 8 |
| GUI framework | Java Swing / AWT |
| IDE / Build | NetBeans IDE, Apache Ant (`build.xml`) |
| Database | MySQL 5.x / 8.x (JDBC connector `com.mysql.jdbc.Driver`) |
| Reports | JasperReports (`.jrxml` templates compiled at runtime) |
| Charts | JFreeChart 2D + Orson Charts 3D |
| Email | JavaMail API (`javax.mail`) |
| Barcodes | Barbecue 1.5-beta1 + Barcode4J 2.0 |
| QR Codes | ZXing-based library |
| Date picker | `dateChooserCombo` component |

---

## 4. Module Descriptions

### 4.1 Entry Point
| Class | Description |
|---|---|
| `commiunication_software.Commiunication_Software` | `main()` – delegates immediately to `LogInFrame.main()` |

### 4.2 MainFrames (Core Navigation)
| Class | Description |
|---|---|
| `LogInFrame` | Login dialog; selects Admin or Cashier role; queries the `users` table |
| `MainFrame` | Full-screen dashboard; icon-based launcher for all major modules; shows low-stock notifications |
| `MainFrame2` | Secondary dashboard variant |
| `PosFrame` | Full POS terminal: add items/services to cart, set quantity and price, apply discount, print bill via JasperReports, update stock on save |
| `DataEnteringFrames` | Navigator frame that opens any `DataEnteringFrames.*` child window |
| `DetailsFrames` | Navigator frame that opens any `DetailsFrames.*` read-only window |
| `ReportFrame` | Navigator to printable JasperReports |
| `SummaryFrame` | Business summary view |
| `ChartFrame` | Generates 2D/3D charts (Value, GRN, Items, Services) using JFreeChart and Orson Charts |
| `EmailSendingFrame` | Sends email to customers, staff, or suppliers via JavaMail (Gmail SMTP) |
| `BarcodeGenarator` | Generates printable barcodes for stock items |
| `QRCodeGenarator` | Generates QR codes for stock items |
| `BackupAndRestore` | Calls `mysqldump` (backup) and `mysql source` (restore) as external processes |

### 4.3 DataEnteringFrames (CRUD Forms)
| Class | Description |
|---|---|
| `CustomerFrame` | Add/update customer records |
| `StaffFrame` | Add/update staff (NIC, name, gender, DOB, profession, salary, contact, active flag) |
| `StockFrame` | Add/update stock items (code, name, prices, active flag) |
| `SuppliersFrame` | Add/update supplier records |
| `GRNFrame` | Record goods received: links supplier → item, increments `inoinstock` |
| `ServicesFrame` | Add/update service catalog (price tiers, required stock items) |
| `ExpenceFrame` | Record a business expense against a reason category |
| `IncomeFrame` | Record other income against a reason category |
| `IncomeExpenceReasonsFrame` | Manage income/expense categories |
| `SalaryPayingFrame` | Record salary payment for a staff member for a given month |
| `StaffAttendingFrame` | Mark daily attendance (present/absent, in-time, out-time) |
| `ProfessionsFrame` | Manage job-role catalogue |
| `DueFinishingFrame` | Mark a credit sale as paid (sets `duefinisheddate`/`time`) |
| `UsersFrame` | Add/update system user credentials |

### 4.4 DetailsFrames (Read-only Views)
Each `DataEnteringFrames` module has a matching `DetailsFrames` window that displays data in a `JTable` (e.g. `CustomerDetailsFrame`, `StaffDetailsFrame`, `SalesDetailsFrame`, `GRNDetails`, etc.).

### 4.5 SubFrames (Helper Dialogs)
| Class | Description |
|---|---|
| `GRNForDueFrame` | GRN lookup helper used in due-payment flow |
| `MoreSalesDetailsFrame` | Shows line-item breakdown for a selected sale |
| `PrintingFrame` | Handles printing animation/feedback |
| `SetNeedItemsFrame` | Assigns required stock items to a service |
| `SetSupplyingItems` | Assigns items a supplier provides |
| `ViewNeededItemsForTheService` | Displays items required for a service |
| `ViewSuppliers` / `ViewSupplyingItemsFrame` | Supplier lookup helpers |

### 4.6 ReportFrames (JasperReports Viewers)
`GRNReport`, `SalesReport`, `IncomeReport`, `ExpenceReport` — each compiles a `.jrxml` template and displays it in a `JasperViewer`.

### 4.7 MyConn (Database Layer)
`MyConn.MyConn` — a static utility class with:
- `getMyConn()` — opens a JDBC connection (lazy-initialised)
- `save(String sql)` — executes a DML statement
- `search(String sql)` — executes a query and returns a `ResultSet`

---

## 5. Data Model

The following tables are inferred from SQL queries throughout the codebase:

| Table | Key Columns | Notes |
|---|---|---|
| `users` | `uid`, `uname`, `upassword`, `utype` (0=Cashier, 1=Admin) | System login credentials |
| `customers` | `CusID`, `CusName`, `CusTel`, `CusAddress`, `CusIsActive`, `cusemail` | Customer master |
| `stock` | `iid`, `icode`, `iname`, `irecommendprice`, `iminprice`, `imaxprice`, `inoinstock`, `iisactive` | Product inventory |
| `suppliers` | `sid`, `sname`, `semail`, …, `sisactive` | Supplier master |
| `suppliers_give_stock` | `suppliers_sid`, `stock_iid` | Supplier ↔ product mapping |
| `grn` | `id`, `stock_iid`, `suppliers_sid`, `date`, `time`, `count`, `buyingprice` | Goods received |
| `sales` | `invoice`, `customers_cusid`, `date`, `time`, `staff_sid`, `discount`, `total`, `due_dueid`? | Sale header |
| `sales_need_stock` | `sales_invoice`, `#`, `stock_iid`, `count` | Sale line-items (products) |
| `sales_has_services` | `sales_invoice`, `#`, `services_serid`, `count` | Sale line-items (services) |
| `services` | `serid`, `sercode`, `sername`, `serrecommendprice`, `serminprice`, `sermaxprice`, `serisactive`, `SerDiscription` | Service catalogue |
| `services_need_stock` | `services_serid`, `stock_iid`, `count` | Stock consumed per service |
| `professions` | `pid`, `pname` | Job roles |
| `staff` | `sid`, `snic`, `sfirstname`, `slastname`, `sgender`, `sdob`, `professions_pid`, `semail`, `saddress`, `stelephone1`, `stelephone2`, `ssalary`, `sisactive` | Staff members |
| `salarypaying` | `id`, `date`, `time`, `salaryfor`, `staff_sid` | Salary payments |
| `staffattending` | `date`, `staff_sid`, `ispresent`, `intime`, `outtime` | Daily attendance |
| `incomeexpence` | `invoice`, `type` (0=expense, 1=income), `date`, `time`, `value`, `incomeexpencereasons_rid` | General ledger entries |
| `incomeexpencereasons` | `rid`, `rname`, `rincomeorexpence` (0=expense, 1=income) | Transaction categories |
| `due` | `dueid`, `duetype`, `duefinishingdate`, `duefinisheddate`, `duefinishedtime` | Credit/due tracking |

---

## 6. Build & Run Instructions

### Prerequisites

| Requirement | Version |
|---|---|
| Java Development Kit (JDK) | 8 (recommended) |
| Apache Ant | 1.9+ |
| MySQL Server | 5.7 or 8.x |
| NetBeans IDE | 8.x (optional, for GUI editing) |

### Database Setup

1. Start MySQL and create the database:
   ```sql
   CREATE DATABASE Communication_Software;
   ```
2. Import the schema (if a `.sql` dump is available):
   ```bash
   mysql -uroot -p Communication_Software < schema.sql
   ```
3. The application connects as `root` with password `123` on `localhost:3306`. Update `src/MyConn/MyConn.java` if your credentials differ:
   ```java
   c = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/Communication_Software", "root", "123");
   ```

### Build with Ant

```bash
# Clean and compile
ant clean build

# Run directly
ant run

# Package as JAR
ant jar
# Output: dist/Commiunication_Software.jar
```

### Run the JAR

Ensure all dependency JARs (JasperReports, JFreeChart, MySQL Connector/J, JavaMail, etc.) are on the classpath or inside `dist/lib/`:

```bash
java -jar dist/Commiunication_Software.jar
```

### Default Login

| Field | Value |
|---|---|
| User Type | Admin |
| UserName | *(set in the `users` table)* |
| Password | *(set in the `users` table)* |

---

## 7. Notable Issues & Improvement Opportunities

### 🔴 Security — High Priority

| Issue | Location | Recommendation |
|---|---|---|
| **SQL Injection** | Every SQL statement in every frame (e.g. `"select * from users where utype = '" + userType + "'"`) | Replace all string-concatenation SQL with `PreparedStatement` |
| **Plaintext passwords** | `LogInFrame` compares `rs.getString(3).equals(jPasswordField1.getText())` | Hash passwords with BCrypt/PBKDF2 before storing; compare hashes |
| **Hardcoded DB credentials** | `MyConn.java` — `root` / `123` | Move to a config file or environment variable; restrict DB user privileges |
| **Hardcoded email credentials** | `EmailSendingFrame` | Use a config file or OS keychain |
| **Shell injection risk** | `BackupAndRestore.java` — path passed directly into `runtime.exec("mysqldump … -r " + backupPath.getText())` | Validate/sanitise the file path; use `ProcessBuilder` with an argument list |

### 🟠 Reliability — Medium Priority

| Issue | Location | Recommendation |
|---|---|---|
| **Empty `catch` blocks** | Throughout all frames (e.g. `catch (Exception e) {}`) | At minimum, log the exception; ideally surface a user-friendly error dialog |
| **Shared static `Connection`** | `MyConn.java` — single `static Connection c` | Use a connection pool (e.g. HikariCP) or create a new connection per operation |
| **Deprecated JDBC driver class** | `Class.forName("com.mysql.jdbc.Driver")` | Use `com.mysql.cj.jdbc.Driver` (new connector) or rely on auto-loading |
| **No input validation** | All data-entry frames | Validate required fields, data types, and lengths before executing SQL |
| **`ResultSet` / `Connection` not closed** | `MyConn.search()` returns an open `ResultSet` without try-with-resources | Close resources in `finally` blocks or use try-with-resources |

### 🟡 Code Quality — Lower Priority

| Issue | Recommendation |
|---|---|
| **No automated tests** | The `test/` folder contains experimental/prototype code only. Add JUnit unit tests for business logic |
| **God-class frames** | Some frames exceed 1 000 lines with mixed UI and business logic. Apply MVC/MVP separation |
| **Typo in project name** | "Commiunication" appears in class names, database references, and the bill template. Correct to "Communication" consistently |
| **Inconsistent naming** | Mix of camelCase, PascalCase, and abbreviations for variables. Follow Java naming conventions |
| **No `.gitignore`** | `build/`, `dist/`, `nbproject/private/`, and `hs_err_pid*.log` crash files are tracked in Git. Add a `.gitignore` to exclude them |
| **Hardcoded Windows paths** | `nbproject/project.properties` contains `D:\Java\Jars\` and `C:\Users\Nuwantha Kumara\...` paths. Use relative or portable paths |
| **Committed crash logs** | `hs_err_pid4664.log`, `hs_err_pid656.log` should not be in source control |

### 🟢 Feature / Architecture Suggestions

- **Role-based access control**: The Admin/Cashier distinction exists at login but is not enforced on individual modules. Add permission checks.
- **Audit trail**: No record is kept of who made which change. Add a `modified_by`/`modified_at` pattern to critical tables.
- **Soft deletes are partially implemented** (`isactive` flags exist) but are inconsistently used. Standardise across all entities.
- **Configuration file**: Externalise the database URL, credentials, and SMTP settings into a properties file so the application can be deployed in different environments without recompiling.
- **Upgrade to modern Java**: JDK 8 reached end-of-life. Consider migrating to JDK 17 LTS or later; also consider JavaFX for a more modern UI.
