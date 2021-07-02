import java.util.*;

public class Main {
    public static void main(String[] args) {
        Zooclub zooclub = new Zooclub();
//        List<Pet> pets = new ArrayList<>();
        Map<Person, List<Pet>> club = zooclub.getClub();

        boolean choice = true;
        while (choice) {
            System.out.println("1) додати учасника в клуб");
            System.out.println("2) додати тваринку до учасника клубу");
            System.out.println("3) видалити тваринку з власника");
            System.out.println("4) видалити учасника клубу");
            System.out.println("5) вивести усіх тваринок конкретного власника");
            System.out.println("6) вивести на екран зооклуб");
            System.out.println("7) вихід");

            switch (zooclub.scannerInt("зробіть свій вибір: ")) {
                case 1:
                    zooclub.addPerson();
                    break;
                case 2:
                    //додати тваринку до учасника клубу по  person:
                    zooclub.addPetPerson();
                    //додати тваринку до учасника клубу по id person:
                    zooclub.addPetPersonId();
                    break;
                case 3:
                    zooclub.removePetWithPerson();
                    break;
                case 4:
                    zooclub.removePerson();
                    break;
                case 5:
                    zooclub.printALLPetPerson(club);
                    break;
                case 6:
                    zooclub.printZooClub(club);
                    break;
                case 7:
                    choice = false;
                    break;
                default:
                    System.out.println("Введено не коректний номер, зробіть свій вибір ще раз: ");
                    break;
            }
        }
    }
}

