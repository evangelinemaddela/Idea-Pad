import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IdeaPad{

    static ArrayList<String> ideas = new ArrayList<>();
    static final String FILE_NAME = "ideas.text"; //file to store notes

    public static void main( String args[]){
        loadIdeas(); //load ideas from file at start
        Scanner scanner = new Scanner(System.in);
        int choice;

        do { 
            System.out.println("\n---Ideas Manager---");
            System.out.println("1. Add Idea");
            System.out.println("2. View Idea");
            System.out.println("3. Search Idea");
            System.out.println("4. Delete Idea");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); //consume new line

            switch(choice){
                case 1:
                    addIdea(scanner);
                    break;
                case 2:
                    viewIdeas();
                    break;
                case 3:
                    searchIdea(scanner);
                    break;
                case 4:
                    deleteIdea(scanner);
                    break;
                case 5:
                    saveIdeas(); //saves before existing
                    System.out.println("Exiting...Bye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    //Add a new idea
    public static void addIdea(Scanner scanner){
        System.out.println("Enter your idea: ");
        String idea = scanner.nextLine();
        ideas.add(idea);
        System.out.println("Idea added successfully!");
    }

    //View all ideas
    public static void viewIdeas(){
        if(ideas.isEmpty()){
            System.out.println("No ideas found.");
        }else{
            System.out.println("\nYour Ideas: ");
            for(int i=0; i< ideas.size(); i++){
                System.out.println((i+1)+ ". " + ideas.get(i));            
            }
        }
    }

    //Search idea by keyword
    public static void searchIdea(Scanner scanner){
        System.out.println("Enter keyword to search: ");
        String keyword = scanner.nextLine();
        boolean found = false;
        for(String idea: ideas){
            if(idea.toLowerCase().contains(keyword.toLowerCase())){
                System.out.println("- "+ idea);
                found = true;
            }
        }
        if(!found){
            System.out.println("No matching ideas found.");
        }
    }

    //Delete idea
    public static void deleteIdea(Scanner scanner){
        System.out.println("Enter idea number to delete:  ");
        int index = scanner.nextInt();
        scanner.nextLine(); //consume new line

        if(index>0 && index <= ideas.size()){
            String removed = ideas.remove(index - 1);
            System.out.println("Deleted: "+ removed);
        }else{
            System.out.println("Invalid idea number!");
        }
    }

    //Load ideas from file
    public static void loadIdeas(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = br.readLine())!= null){
                ideas.add(line);
            }
        }catch (FileNotFoundException e){
            //File doesnt exist yet, no problem
        }catch(IOException e){
            System.out.println("Error reading ideas from file.");
        }
    }

    //Save ideas to file
    public static void saveIdeas(){
        try(BufferedWriter bw =  new BufferedWriter(new FileWriter(FILE_NAME))){
            for(String idea: ideas){
                bw.write(idea);
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("Error saving ideas to file.");
        }
    }
}