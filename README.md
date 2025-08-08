# Phonebook Management System

A command-line phonebook application written in Java that allows users to manage contact information including names, addresses, cities, and phone numbers.

## 📋 Features

- **Load**: Import phonebook data from text files
- **Query**: Search for contacts by last name
- **Add**: Add new contact records
- **Delete**: Remove existing contacts
- **Modify**: Edit contact information
- **Print**: Display all contacts sorted alphabetically by last name
- **Save**: Export phonebook data to text files
- **Quit**: Exit the application

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A text editor or IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/saperaa/Phonebook.git
   cd Phonebook
   ```

2. Compile the Java program:
   ```bash
   javac Main.java
   ```

3. Run the application:
   ```bash
   java Main
   ```

## 💾 Data Format

The phonebook uses comma-separated values (CSV) format for data storage. Each line represents one contact:

```
LastName, FirstName, Address, City, PhoneNumber
```

### Example:
```
Mahmoud, Ahmed, 26 Elhoreya Street, Alexandria, 4876321
Metwally, Ahmed, 60 Ammar Ibn Yasser, Cairo, 01001031618
```

## 🔧 Usage

### Starting the Application

When you run the program, you'll see a menu with available commands:

```
Enter a command(load,add,etc..):
LOAD: Load the phone directory from a file.
QUERY: Look up information about a specific entry.
ADD: Add a new record to the directory.
DELETE: Delete a record from the directory.
MODIFY: Modify information for a record.
PRINT: Print the entire directory.
SAVE: Save the directory to an external file.
QUIT: Exit (without saving the directory).
```

### Commands

#### LOAD
- **Purpose**: Load phonebook data from a file
- **Usage**: Enter `LOAD` and then specify the filename (without .txt extension)
- **Note**: You must load a file before using other commands

#### QUERY
- **Purpose**: Search for contacts by last name
- **Usage**: Enter `QUERY` and then type the last name to search for
- **Result**: Displays all matching contacts with full information

#### ADD
- **Purpose**: Add a new contact to the phonebook
- **Usage**: Enter `ADD` and follow the prompts to input:
  - Last name
  - First name
  - Address
  - City
  - Phone number

#### DELETE
- **Purpose**: Remove a contact from the phonebook
- **Usage**: Enter `DELETE` and provide:
  - Last name
  - First name
- **Note**: Both names must match exactly for deletion

#### MODIFY
- **Purpose**: Edit existing contact information
- **Usage**: Enter `MODIFY`, specify the contact by name, then enter new information for each field

#### PRINT
- **Purpose**: Display all contacts sorted alphabetically by last name
- **Usage**: Simply enter `PRINT`

#### SAVE
- **Purpose**: Save current phonebook data to the loaded file
- **Usage**: Enter `SAVE` to write changes to disk

#### QUIT
- **Purpose**: Exit the application
- **Usage**: Enter `QUIT`
- **Note**: Changes are not automatically saved

## 📁 Project Structure

```
Phonebook/
├── Main.java                  # Main application file
├── book.txt                   # Sample phonebook data
├── README.md                  # This file
├── .gitignore                 # Git ignore file
└── Phonebook.rar              # Compressed archive
```

## 🔍 Example Session

```
Enter a command(load,add,etc..):
LOAD
Input File Name to load this phone directory:
book
Loading phone directory from file: book.txt
File was loaded successfully...

Enter a command(load,add,etc..):
QUERY
Enter last name to query user
Mahmoud
Searching for user with last name: Mahmoud...
Match found at line 1 in file: book.txt
Last Name: Mahmoud
First Name: Ahmed
Address: 26 Elhoreya Street
City: Alexandria
Phone Number: 4876321
```

## 👥 Contributors

- Mohamed Alaa (23101900)


## 🛠️ Technical Details

- **Language**: Java
- **File I/O**: BufferedReader/BufferedWriter for file operations
- **Data Structure**: Arrays for storing contact information
- **Sorting**: Alphabetical sorting by last name using custom comparator

## ⚠️ Important Notes

- The application requires loading a file before performing any operations
- Contact data is stored in memory and must be explicitly saved
- First names are stored with a leading space in the internal format
- The application exits without auto-saving when using QUIT command

## 🐛 Known Issues

- First name matching requires exact spacing format
- No input validation for phone number format
- Limited error handling for malformed data files

## 📄 License

This project is created for educational purposes.
