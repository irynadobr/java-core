import java.util.*;

public class Zooclub {
    Map<Person, List<Pet>> club = new HashMap<>();

    public Zooclub() {
    }

    public Zooclub(Map<Person, List<Pet>> club) {
        this.club = club;
    }

    public Map<Person, List<Pet>> getClub() {
        return club;
    }

    public void setClub(Map<Person, List<Pet>> club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zooclub zooclub = (Zooclub) o;
        return Objects.equals(club, zooclub.club);
    }

    @Override
    public int hashCode() {
        return Objects.hash(club);
    }

    @Override
    public String toString() {
        return "Zooclub{" +
                "club=" + club +
                '}';
    }

    public int scannerInt(String enter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(enter);
        int sk = scanner.nextInt();
        return sk;
    }

    public String scannerString(String enter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(enter);
        String sk = scanner.next();
        return sk;
    }

    public Person person() {
        int idPerson = scannerInt("Enter id Person: ");
        String namePerson = scannerString("Enter name Person: ");
        int age = scannerInt("Enter age Person: ");
        String city = scannerString("Enter city Person: ");
        Person person = new Person(idPerson, namePerson, age, city);
        return person;
    }

    public Pet pet() {
        int idPet = scannerInt("Enter id pet: ");
        String namePet = scannerString("Enter name Pet: ");
        int age = scannerInt("Enter age pet: ");
        Pet pet = new Pet(idPet, namePet, age);
        return pet;
    }

    //1) додати учасника в клуб
    public void addPerson() {
        Person newPerson = person();
        Set<Person> persons = club.keySet();
        for (Person person : persons) {
            if (newPerson.getId() == person.getId()) {
                System.out.println("Person з id - " + newPerson.getId() + " вже існує");
                return;
            }
        }
        club.put(newPerson, new ArrayList<>());
        System.out.println(" В зооклуб додано: " + newPerson);
        printZooClub(club);
    }

    //    2) додати тваринку до учасника клубу по id учасника-person
    public void addPetPersonId() {
        System.out.println("Учасники клубу: ");
        for (Person persons : club.keySet()) {
            System.out.println(persons);
        }
        int idPerson = scannerInt("Enter id Person: ");
        List<Person> personClub = new ArrayList<>();
        Set<Map.Entry<Person, List<Pet>>> entries = club.entrySet();
        for (Map.Entry<Person, List<Pet>> entry : entries) {
            if (idPerson == entry.getKey().getId()) {
                System.out.println("Введіть дані тваринки, яку необхідно додати до учасника з id: " + idPerson + ": ");
                Pet newPet = pet();
                personClub.add(entry.getKey());
                for (Pet pet : entry.getValue()) {
                    if (newPet.getId() == pet.getId()) {
                        System.out.println("Pet з id - " + newPet.getId() + " вже існує");
                        return;
                    }
                }
                club.get(entry.getKey()).add(newPet);
                System.out.println("До власника " + entry.getKey().getName() + " з id: " + idPerson +
                        " додано тваринку " + ": " + newPet);
                return;
            }
        }
        if (personClub.isEmpty()) {
            System.out.println("person з id: " + idPerson + " -  не є учасником клубу");
        }
        printZooClub(club);
    }

    //2) додати тваринку до учасника клубу
//    public void addPetPerson() {
//        Person personClub = person();
//        if (!club.containsKey(personClub)) {
//            System.out.println("Такий person -  не є учасником клубу");
//            return;
//        }
//        Pet newPet = pet();
//        Set<Map.Entry<Person, List<Pet>>> entries = club.entrySet();
//        for (Map.Entry<Person, List<Pet>> entry : entries) {
//            if (entry.getKey().equals(personClub)) {
//                for (Pet pet : entry.getValue()) {
//                    if (newPet.getId() == pet.getId()) {
//                        System.out.println("Pet з id - " + newPet.getId() + " вже існує");
//                        return;
//                    }
//                }
//                club.get(personClub).add(newPet);
//                System.out.println("До власника " + personClub + " додано тваринку " + ": " + newPet);
//                printZooClub(club);
//            }
//        }
//    }

    //3) видалити тваринку з власника
    public void removePetWithPerson() {
        Person personClub = person();
        if (!club.containsKey(personClub)) {
            System.out.println("Такий person -  не є учасником клубу");
            return;
        }
        Pet petPerson = pet();
        if (club.get(personClub).contains(petPerson)) {
            club.get(personClub).remove(petPerson);
            System.out.println("З власника " + personClub + " видалено тваринку " + ": " + petPerson);
        } else {
            System.out.println("У власника " + personClub + " не має тваринки " + ": " + petPerson);
        }
        printZooClub(club);
    }

    //4) видалити учасника клубу
    public void removePerson() {
        if (club.isEmpty()) {
            System.out.println("В zooklub немає учасників");
            return;
        }
        Person personClub = person();
        if (!club.containsKey(personClub)) {
            System.out.println(personClub.getName() + "-  не є учасником клубу");
            return;
        }
        club.remove(personClub);
        System.out.println("З зооклубу видалено:  " + personClub);
        printZooClub(club);
    }

    //5)вивести усіх тваринок конкретного власника
    public void printALLPetPerson(Map<Person, List<Pet>> club) {
        if (club.isEmpty()) {
            System.out.println("В zooklub немає учасників");
            return;
        }
        Person personClub = person();
        if (!club.containsKey(personClub)) {
            System.out.println("person - " + personClub.getName() + " не є учасником клубу");
            return;
        }
        Set<Map.Entry<Person, List<Pet>>> entries = club.entrySet();
        for (Map.Entry<Person, List<Pet>> entry : entries) {
            if (entry.getKey().getName().equals(personClub.getName())) {
                System.out.println("person - " + entry.getKey() + ": ");
                if (entry.getValue().isEmpty()) {
                    System.out.println(entry.getKey().getName() + " не має тваринок ");
                    return;
                }
                System.out.println("власник " + entry.getKey().getName() + " має тваринок: ");
                for (Pet pet : entry.getValue()) {
                    System.out.println("\t" + pet);
                }
            }
        }
        printZooClub(club);
    }

    //6) вивести на екран зооклуб
    public void printZooClub(Map<Person, List<Pet>> club) {
        if (club.isEmpty()) {
            System.out.println("В zooklub немає учасників");
        }
        System.out.println("Зооклуб: ");
        Set<Map.Entry<Person, List<Pet>>> entries = club.entrySet();
        for (Map.Entry<Person, List<Pet>> entry : entries) {
            System.out.println(entry.getKey() + ": ");
            for (Pet pet : entry.getValue()) {
                System.out.println("\t" + pet);
            }
        }
    }
}