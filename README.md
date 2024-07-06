# Donation-System

This project was developed as part of our Object-Oriented Programming (OOP) course in Java to manage donations and distribute resources effectively.
Designed as a simple system to donate and assist underprivileged individuals by providing essential resources such as food, educational books, clothing, medications, and financial aid.
It allows users to register or sign in with a username and password, and includes a mechanism for password recovery. The system supports various types of donations and ensures data handling and error management using files.

## Features

- **User Registration and Login**: 
  - Users can create an account with a username and password.
  - Existing users can log in using their credentials.
  - A password recovery mechanism is available for users who forget their passwords.

- **Donation Types**:
  - **Books**: Donate books by specifying the book type.
  - **Clothes**: Donate clothes by specifying the clothe type and size.
  - **Food**: Donate food by specifying the food type.
  - **Medicine**: Donate medicine by specifying the medicine type.
  - **Education**: Donate towards education by specifying teaching stages.
  - **Health Care**: Donate towards health care needs.
  - **Poverty and Hunger**: Donate to help alleviate poverty and hunger.

- **Data Handling and Error Management**:
  - All data is saved using files.
  - Errors are managed and logged using files to ensure the system runs smoothly.

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/DonationManagementSystem.git
    ```

2. Navigate to the project directory:
    ```bash
    cd DonationManagementSystem
    ```

3. Compile the Java files:
    ```bash
    javac src/*.java
    ```

4. Run the application:
    ```bash
    java src/Main
    ```

## Usage

- **Register**: Create a new account by providing a username and password.
- **Login**: Sign in with your existing account.
- **Forgot Password**: Recover your password if you forget it.
- **Donate**: Choose a donation type and provide the required details.

## File Structure
DonationSystem/
│
├── src/
│ ├── BookType.java
│ ├── Books.java
│ ├── ClotheSize.java
│ ├── ClotheType.java
│ ├── Clothes.java
│ ├── Doctor.java
│ ├── Donation.java
│ ├── DonationsLists.java
│ ├── Donor.java
│ ├── Education.java
│ ├── Food.java
│ ├── FoodType.java
│ ├── HealthCare.java
│ ├── Hunger.java
│ ├── Main.java
│ ├── Medicine.java
│ ├── MedicineType.java
│ ├── Poverty.java
│ ├── Teacher.java
│ ├── TeachingStages.java
│ └── WayOfDonation.java
│
├── bin/ (compiled classes)
│
├── .classpath
├── .project
└── .settings/

## Contributors

- Amer Ashoush
- Mohamed Adil

## License

This project is licensed under the MIT License.
