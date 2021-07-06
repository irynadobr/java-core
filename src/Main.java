import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<>();
        computers.add(new Computer("Acer", 2000, 2, 1000, new Hard("Toshiba", TypeHard.HDD, 120, ProductionCountry.CHINA), new Processor("Ryzen", 2, 1000, ProductionCountry.CHINA)));
        computers.add(new Computer("PHP", 2002, 4, 5000, new Hard("Hitachi", TypeHard.SSD, 150, ProductionCountry.KOREA), new Processor("Ryzen", 2, 1200, ProductionCountry.KOREA)));
        computers.add(new Computer("lenovo", 2010, 2, 6000, new Hard("Toshiba", TypeHard.SSD, 120, ProductionCountry.CHINA), new Processor("Ryzen", 2, 1000, ProductionCountry.INDIA)));
        computers.add(new Computer("Acer", 2015, 2, 7000, new Hard("Hitachi", TypeHard.HDD, 130, ProductionCountry.INDIA), new Processor("Ryzen", 4, 1000, ProductionCountry.CHINA)));
        computers.add(new Computer("Asus", 2018, 2, 12000, new Hard("Toshiba", TypeHard.HDD, 150, ProductionCountry.KOREA), new Processor("Ryzen", 2, 1000, ProductionCountry.KOREA)));
        computers.add(new Computer("Acer", 2008, 2, 2000, new Hard("Toshiba", TypeHard.SSD, 140, ProductionCountry.USA), new Processor("Ryzen", 2, 1000, ProductionCountry.CHINA)));
        computers.add(new Computer("Dell", 2009, 2, 4000, new Hard("Hitachi", TypeHard.SSD, 120, ProductionCountry.CHINA), new Processor("Ryzen", 4, 1000, ProductionCountry.KOREA)));
        computers.add(new Computer("Dell", 2012, 2, 3000, new Hard("Toshiba", TypeHard.HDD, 130, ProductionCountry.CHINA), new Processor("Ryzen", 2, 1000, ProductionCountry.USA)));
        computers.add(new Computer("Acer", 2019, 2, 15000, new Hard("Hitachi", TypeHard.SSD, 160, ProductionCountry.KOREA), new Processor("Ryzen", 6, 1000, ProductionCountry.CHINA)));
        computers.add(new Computer("Asusr", 2020, 2, 21000, new Hard("Samsung", TypeHard.SSD, 200, ProductionCountry.USA), new Processor("Intel Core i5", 6, 1000, ProductionCountry.INDIA)));
        computers.add(new Computer("Asus", 2017, 2, 11000, new Hard("Toshiba", TypeHard.HDD, 170, ProductionCountry.USA), new Processor("Ryzen", 2, 1000, ProductionCountry.USA)));
        computers.add(new Computer("PHP", 2019, 2, 42000, new Hard("Samsung", TypeHard.SSD, 700, ProductionCountry.USA), new Processor("Intel Core i7", 6, 1000, ProductionCountry.CHINA)));
        computers.add(new Computer("Dell", 2018, 2, 21000, new Hard("Toshiba", TypeHard.SSD, 150, ProductionCountry.CHINA), new Processor("Intel Core i3", 4, 1000, ProductionCountry.CHINA)));
        computers.add(new Computer("Acer", 2019, 2, 22000, new Hard("Samsung", TypeHard.SSD, 180, ProductionCountry.INDIA), new Processor("Intel Core i5", 6, 1000, ProductionCountry.USA)));
        computers.add(new Computer("Dell", 2015, 2, 10500, new Hard("Hitachi", TypeHard.SSD, 150, ProductionCountry.CHINA), new Processor("Ryzen", 2, 1000, ProductionCountry.USA)));
        computers.add(new Computer("Dell", 2017, 2, 10800, new Hard("Samsung", TypeHard.HDD, 200, ProductionCountry.CHINA), new Processor("Ryzen", 4, 1000, ProductionCountry.USA)));
        computers.add(new Computer("Lenovo", 2020, 2, 11000, new Hard("Samsung", TypeHard.SSD, 800, ProductionCountry.USA), new Processor("Ryzen", 2, 1000, ProductionCountry.CHINA)));
        computers.add(new Computer("Asus", 2019, 2, 43000, new Hard("Hitachi", TypeHard.SSD, 600, ProductionCountry.USA), new Processor("Intel Core i7", 8, 1000, ProductionCountry.KOREA)));
        computers.add(new Computer("Dell", 2015, 2, 11000, new Hard("Samsung", TypeHard.HDD, 160, ProductionCountry.CHINA), new Processor("Ryzen", 2, 1000, ProductionCountry.KOREA)));
        computers.add(new Computer("Acer", 2020, 2, 41000, new Hard("Toshiba", TypeHard.SSD, 600, ProductionCountry.USA), new Processor("Intel Core i7", 8, 1000, ProductionCountry.USA)));


//         Знайти всі комп'ютери які мають рік випуску більше ніж 2010
        computers.stream()
                .filter(computer -> computer.getYear() > 2010)
                .collect(Collectors.toList())
                .forEach(System.out::println);

//        Знайти всі комп'ютери які мають рік випуску більше ніж 2010 та країну виробник SSD Китай
        computers.stream()
                .filter(computer -> computer.getYear() > 2010 && computer.getHard().getType().equals(TypeHard.SSD) && computer.getHard().getManufacturer().equals(ProductionCountry.CHINA))
                .collect(Collectors.toList())
                .forEach(System.out::println);

//        Знайти всі комп'ютери які мають рік випуску більше ніж 2010 та країну виробник дисків не Китай
        computers.stream()
                .filter(computer -> computer.getYear() > 2010 && !computer.getHard().getManufacturer().equals(ProductionCountry.CHINA))
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        Знайти всі комп'ютери які мають жорсткий диск більше 500гб
        computers.stream()
                .filter(computer -> computer.getHard().getVolume() > 500)
                .collect(Collectors.toList())
                .forEach(System.out::println);

//        Знайти всі комп'ютери які мають жорсткий ссд диск більше 500гб та процессор і7
        computers.stream()
                .filter(computer -> computer.getHard().getType().equals(TypeHard.SSD) && computer.getHard().getVolume() > 500 && computer.getProcessor().getType().equals("Intel Core i7"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        Знайти всі комп'ютери які мають жорсткий ссд диск більше 500гб та процессор і7 посортувати за ціною
        computers.stream()
                .filter(computer -> computer.getHard().getType().equals(TypeHard.SSD) && computer.getHard().getVolume() > 500 && computer.getProcessor().getType().equals("Intel Core i7"))
                .sorted((o1, o2) -> o1.getPrice() - o2.getPrice())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
