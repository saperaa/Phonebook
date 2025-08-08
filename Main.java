import java.util.*;
import java.io.*;
//Mohamed alaa 23101900
//ahmed Kamel 23100760
//Hazem Ahmed Taher 23101380

public class Main {

    public static String[] lastNames;
    public static String[] firstNames;
    public static String[] addresses;
    public static String[] cities;
    public static String[] phoneNumbers;
    public static String fileName;
    public static boolean load_commandCalled = false;

    public static void main(String[] args) throws Exception {

        Scanner alaa = new Scanner(System.in);
        String entry;

        do {
            System.out.println("\nEnter a command(load,add,etc..):");
            System.out.println("LOAD: Load the phone directory from a file.");
            System.out.println("QUERY: Look up information about a specific entry.");
            System.out.println("ADD: Add a new record to the directory.");
            System.out.println("DELETE: Delete a record from the directory.");
            System.out.println("MODIFY: Modify information for a record.");
            System.out.println("PRINT: Print the entire directory.");
            System.out.println("SAVE: Save the directory to an external file.");
            System.out.println("QUIT: Exit (without saving the directory).");
            entry = alaa.nextLine().toUpperCase();
            if (load_commandCalled == false && !entry.equals("LOAD") && !entry.equals("QUIT")){
                System.out.println("You have to run the LOAD command first");
                continue;
                // contiue 3shan ys skip we y3ed tany
            }

            switch(entry){

                case "LOAD":
                    System.out.println("Input File Name to load this phone directory:");
                    fileName = alaa.nextLine();
                    System.out.println("Loading phone directory from file: "+fileName+".txt");
                    loadCommand(fileName);
                    load_commandCalled = true;
                    break;
                case "QUERY":
                    System.out.println("Enter last name to query user");
                    String queryInput = alaa.nextLine();
                    System.out.println("Searching for user with last name: "+queryInput+"...");
                    queryCommand(queryInput);
                    break;
                case "ADD":
                    addCommand();
                    break;
                case "DELETE":
                    deleteCommand();
                    break;
                case "MODIFY":
                    modifyCommand();
                    break;
                case "PRINT":
                    printCommand();
                    break;
                case "SAVE":
                    saveCommand();
                    break;
                case "QUIT":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.\n");
            }

        } while(! entry.equals("QUIT"));
    }

    // ArrayList is a resizable array
    public static void loadCommand(String fileName) {
        File file = new File(fileName + ".txt");
        BufferedReader br = null;
        ArrayList<String> lastNameList = new ArrayList<>();
        ArrayList<String> firstNameList = new ArrayList<>();
        ArrayList<String> addressList = new ArrayList<>();
        ArrayList<String> cityList = new ArrayList<>();
        ArrayList<String> phoneNumberList = new ArrayList<>();

        // try we catch finally method 3shan nload al file
        try {
            br = new BufferedReader(new FileReader(file));
            String fileContents;
            while ((fileContents = br.readLine()) != null) {
                String[] parts = fileContents.split(",");
                lastNameList.add(parts[0]);
                firstNameList.add(parts[1]);
                addressList.add(parts[2]);
                cityList.add(parts[3]);
                phoneNumberList.add(parts[4]);
            }
            lastNames = lastNameList.toArray(new String[lastNameList.size()]);
            firstNames = firstNameList.toArray(new String[firstNameList.size()]);
            addresses = addressList.toArray(new String[addressList.size()]);
            cities = cityList.toArray(new String[cityList.size()]);
            phoneNumbers = phoneNumberList.toArray(new String[phoneNumberList.size()]);

        } catch (FileNotFoundException e) {
            System.out.println("File was not found...");

        } catch (IOException e) {
            System.out.println("Error reading the file...");

        } finally {
            try {
                if (br != null)
                    br.close();
                System.out.println("File was loaded successfully...");
            } catch (IOException e) {
                System.out.println("Error closing the BufferedReader...");
            }
        }
    }

    public static void queryCommand(String query){
        for (int i = 0 ; i < lastNames.length ; i++){
            if (query.equalsIgnoreCase(lastNames[i])){
                System.out.println("Match found at line "+ (i+1) + " in file: "+ fileName + ".txt");
                System.out.println("Last Name: " + lastNames[i]);
                System.out.println("First Name: " + firstNames[i]);
                System.out.println("Address: " + addresses[i]);
                System.out.println("City: " + cities[i]);
                System.out.println("Phone Number: " + phoneNumbers[i]);
                System.out.println();
            }
        }
    }

    public static void addCommand(){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter last name: ");
        String lastNameInput = in.nextLine();
        System.out.println("Enter first name: ");
        String firstNameInput = in.nextLine();
        System.out.println("Enter address: ");
        String addressInput = in.nextLine();
        System.out.println("Enter city: ");
        String cityInput = in.nextLine();
        System.out.println("Enter phone number: ");
        String numberInput = in.nextLine();

        // array.copy di bta5od array we bt3mlo copy we byzod wa7ed fe sizo so we can put a new info
        lastNames = Arrays.copyOf(lastNames, lastNames.length + 1);
        lastNames[lastNames.length - 1] = lastNameInput;

        firstNames = Arrays.copyOf(firstNames, firstNames.length + 1);
        firstNames[firstNames.length - 1] = firstNameInput;

        addresses = Arrays.copyOf(addresses, addresses.length + 1);
        addresses[addresses.length - 1] = addressInput;

        cities = Arrays.copyOf(cities, cities.length + 1);
        cities[cities.length - 1] = cityInput;

        phoneNumbers = Arrays.copyOf(phoneNumbers, phoneNumbers.length + 1);
        phoneNumbers[phoneNumbers.length - 1] = numberInput;

        System.out.println("Record was added successfully to directory");
    }

    public static void deleteCommand(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter last name: ");
        String lastNameInput = in.nextLine();
        System.out.println("Enter first name: ");
        String firstNameInput = in.nextLine();
        firstNameInput = " " + firstNameInput; // Benhot space 3shan neb2a zay el file

        int indexToDelete = -1;

        for (int i = 0; i < lastNames.length ; i++){
            if (lastNameInput.equalsIgnoreCase(lastNames[i]) && firstNameInput.equalsIgnoreCase(firstNames[i]) ){
                indexToDelete = i;
                break;
            }
        }
        System.out.println("Index To Delete: "+indexToDelete);
        if (indexToDelete != -1){
            lastNames = removeElementAtIndex(lastNames, indexToDelete);
            firstNames = removeElementAtIndex(firstNames, indexToDelete);
            addresses = removeElementAtIndex(addresses, indexToDelete);
            cities = removeElementAtIndex(cities, indexToDelete);
            phoneNumbers = removeElementAtIndex(phoneNumbers, indexToDelete);
            System.out.println("Record deleted successfuly...");
        }else{
            System.out.println("Record not found...");
        }


        for (int i = 0 ; i < lastNames.length; i++){
            System.out.println(i+" :"+lastNames[i]);
        }
    }

    private static String[] removeElementAtIndex(String[] array, int index) {
        String[] newArray = new String[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            else {
                newArray[j++] = array[i];
            }

        }
        return newArray;
    }

    public static void modifyCommand(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter last name: ");
        String lastNameInput = in.nextLine();
        System.out.println("Enter first name: ");
        String firstNameInput = in.nextLine();
        firstNameInput = " " + firstNameInput;

        int indexToModify = -1;

        for (int i = 0; i < lastNames.length ; i++){
            if (lastNameInput.equalsIgnoreCase(lastNames[i]) && firstNameInput.equalsIgnoreCase(firstNames[i]) ){
                indexToModify = i;
                break;
            }
        }

        if (indexToModify != -1){
            System.out.println("Found match at index: " +(indexToModify+1));
            System.out.println("Printing Record...");
            System.out.println("Last Name: " + lastNames[indexToModify]);
            System.out.println("First Name: " + firstNames[indexToModify]);
            System.out.println("Address: " + addresses[indexToModify]);
            System.out.println("City: " + cities[indexToModify]);
            System.out.println("Phone Number: " + phoneNumbers[indexToModify]);
            System.out.println("Enter your modifications...");

            System.out.println("Enter last name modification if available: ");
            String lastNameInputModification = in.nextLine();
            System.out.println("Enter first name modification if available: ");
            String firstNameInputModification = in.nextLine();
            System.out.println("Enter address modification if available: ");
            String addressInputModification = in.nextLine();
            System.out.println("Enter city modification if available: ");
            String cityInputModification = in.nextLine();
            System.out.println("Enter phone number modification if available: ");
            String numberInputModification = in.nextLine();

            lastNames[indexToModify] = lastNameInputModification;
            firstNames[indexToModify] = firstNameInputModification;
            addresses[indexToModify] = addressInputModification;
            cities[indexToModify] = cityInputModification;
            phoneNumbers[indexToModify] = numberInputModification;

            System.out.println("Printing Modified Record...");
            System.out.println("Last Name: " + lastNames[indexToModify]);
            System.out.println("First Name: " + firstNames[indexToModify]);
            System.out.println("Address: " + addresses[indexToModify]);
            System.out.println("City: " + cities[indexToModify]);
            System.out.println("Phone Number: " + phoneNumbers[indexToModify]);
            System.out.println("Enter your modifications...");

        }
    }

    public static void printCommand(){
        Integer[] indices = new Integer[lastNames.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return lastNames[i1].compareTo(lastNames[i2]);
            }
        });

        for (int i = 0; i < lastNames.length; i++) {
            int index = indices[i];
            System.out.println(lastNames[index] + ", " + firstNames[index] + ", " + addresses[index] + ", " + cities[index] + ", " + phoneNumbers[index]);
        }
    }

    public static void saveCommand() throws IOException{
        BufferedWriter outputWriter = null;
        try {
            outputWriter = new BufferedWriter(new FileWriter(fileName+".txt"));
        } catch (IOException e) {
            System.out.println("Error saving in file...");
            e.printStackTrace();
        }
        for (int i = 0 ; i < lastNames.length; i++){
            try {
                String line = String.join(", ",
                        lastNames[i].trim(),
                        firstNames[i].trim(),
                        addresses[i].trim(),
                        cities[i].trim(),
                        phoneNumbers[i].trim());
                outputWriter.write(line);
                outputWriter.newLine();
            } catch (IOException e) {
                System.out.println("Error saving line: " + (i+1));
                e.printStackTrace();
            }
        }
        System.out.println("File " +fileName +".txt " +"was saved successfully");
        outputWriter.close();
    }

}