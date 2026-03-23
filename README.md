# 🏦 Banking System

A desktop **Banking System** built with **Java Swing**, featuring a secure login page, live balance tracking, deposit/withdrawal operations, and transaction history — all with a clean, dark-themed UI.

---

## ✨ Features

- 🔐 **Secure Login** — Username & password authentication
- 💰 **Live Balance Display** — Updates instantly after every transaction
- ➕ **Deposit** — Add funds with input validation
- ➖ **Withdraw** — Withdraw with insufficient balance protection
- 📜 **Transaction History** — View all past transactions with balance snapshots
- 🚪 **Logout** — Returns safely to the login screen

---

## 🛠️ Tech Stack

| Technology | Usage |
|------------|-------|
| Java | Core language |
| Java Swing | GUI framework |
| AWT | Layout & styling |
| LinkedList | Transaction history storage |

---

## 📁 Project Structure

```
BankingSystem/
├── Login2.java       # Login page with authentication
└── Dashboard.java    # Main dashboard with banking features
```

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or terminal

### Run via Terminal

```bash
# Clone the repository
git clone https://github.com/your-username/your-repo-name.git

# Navigate into the project
cd your-repo-name

# Compile all files
javac Login2.java Dashboard.java

# Run the application
java Login2
```

### Run via IDE

1. Open the project folder in your IDE
2. Run `Login2.java` as the main entry point

---

## 🔑 Default Credentials

| Field | Value |
|-------|-------|
| Username | `admin` |
| Password | `1234` |

> ⚠️ These are hardcoded for demo purposes. Do not use in production.

---

## 💡 How It Works

1. Launch the app → **Login Page** appears
2. Enter credentials → redirects to **Dashboard**
3. Click **Deposit** → enter amount → balance updates live
4. Click **Withdraw** → enter amount → validates funds before deducting
5. Click **Transaction** → view full history of all operations
6. Click **Logout** → returns to Login Page

---

## 🗺️ Roadmap

- [ ] Add database integration (MySQL / SQLite)
- [ ] Support multiple user accounts
- [ ] Add transfer between accounts
- [ ] Export transaction history as PDF
- [ ] Add PIN change functionality

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork the repo and submit a pull request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---
