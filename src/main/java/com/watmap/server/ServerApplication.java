package com.watmap.server;

import com.watmap.server.entity.Faculty;
import com.watmap.server.entity.Institute;
import com.watmap.server.repository.FacultyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(ServerApplication.class, args);

        FacultyRepository facultyRepository = configurableApplicationContext.getBean(FacultyRepository.class);
        createWatFaculties(facultyRepository);
    }

    public static void createWatFaculties(FacultyRepository facultyRepository) {
        Faculty wcy = new Faculty("Faculty of Cybernetics", "WCY", "https://wcy.wat.edu.pl", "wat");
        Institute institute1 = new Institute("Instytut Inżynieri Systemów", "65", 65, 0.0, 0.0, wcy);
        Institute institute2 = new Institute("Instytut Inżynieri Systemów", "100", 100, 0.0, 0.0, wcy);
        List<Institute> instituteList = Arrays.asList(institute1, institute2);
        wcy.setInstitutes(instituteList);

        Faculty wml = new Faculty("Faculty of Mechatronics, Armament and Aerospace", "WML", "https://wml.wat.edu.pl", "wat");
        Faculty wel = new Faculty("Faculty of Electronics", "WEL", "https://wel.wat.edu.pl", "wat");
        Faculty wtc = new Faculty("Faculty of New Technologies and Chemistry", "WTC", "https://wtc.wat.edu.pl", "wat");
        Faculty wlo = new Faculty("Faculty of Security, Logistics and Management", "WLO", "https://wlo.wat.edu.pl", "");
        Faculty wig = new Faculty("Faculty of Civil Engineering and Geodesy", "WIG", "https://wig.wat.edu.pl", "");
        Faculty wme = new Faculty("Faculty of Mechanical Engineering", "WME", "https://wme.wat.edu.pl", "");
        Faculty ioe = new Faculty("Institute of Optoelectronics", "IOE", "https://ioe.wat.edu.pl", "");
        Faculty swf = new Faculty("Study of physical education", "SWF", "https://www.wojsko-polskie.pl/wat/studium-wychowania-fizycznego/", "");
        Faculty other = new Faculty("Other", "other", "https://wat.edu.pl", "wat");
        Faculty akaWoj = new Faculty("Military dormitory", "aka_woj", "https://www.wojsko-polskie.pl/wat/domy-studenckie/", "wat");
        Faculty akaCyw = new Faculty("Civil dormitory", "aka_cyw", "https://www.wojsko-polskie.pl/wat/domy-studenckie/", "");
        Faculty sto = new Faculty("Military canteen", "sto", "https://www.wojsko-polskie.pl/wat/", "");
        Faculty stj = new Faculty("Study of foreign languages", "klub", "https://sjo.wat.edu.pl/", "");


        facultyRepository.save(swf);
        facultyRepository.save(wcy);
        facultyRepository.save(wme);
        facultyRepository.save(wml);
        facultyRepository.save(wel);
        facultyRepository.save(wtc);
        facultyRepository.save(wlo);
        facultyRepository.save(wig);
        facultyRepository.save(wme);
        facultyRepository.save(ioe);
        facultyRepository.save(other);
        facultyRepository.save(akaCyw);
        facultyRepository.save(akaWoj);
        facultyRepository.save(sto);
        facultyRepository.save(stj);

        Faculty bib = new Faculty("Main library", "bib", "https://www.bg.wat.edu.pl/", "wat");
        Faculty un = new Faculty("Other", "undefined", "https://wat.edu.pl", "wat");
        Faculty pl = new Faculty("Medical clinic of the military academy of technology", "przy", "http://www.plwat.pl/", "wat");
        Faculty as = new Faculty("Assistant's house", "dom_asy", "http://www.wat.edu.pl/", "wat");

        facultyRepository.save(bib);
        facultyRepository.save(un);
        facultyRepository.save(pl);
        facultyRepository.save(as);

        Faculty ent = new Faculty("Entrances", "entrances", "", "");
        Institute instituteA = new Institute("Entrance A", "65", 65, 52.25317522096048, 20.899552702903748, ent);
        Institute instituteB = new Institute("Entrance B", "100", 100, 52.2536251204248, 20.899547338485718, ent);
        Institute instituteC = new Institute("Entrance C", "100", 100, 52.25369736662887, 20.900727510452267, ent);
        Institute instituteE = new Institute("Entrance E", "100", 100, 52.252741736868266, 20.90075969696045, ent);
        Institute instituteG = new Institute("Entrance G", "100", 100, 52.2526727730994, 20.89965999126434, ent);
        Institute instituteRadiowa = new Institute("Entrance from Radiowa", "", 0, 52.25529988853865, 20.90469181537628, ent);
        Institute instituteLazurowa = new Institute("Entrance from Lazurowa", "", 0, 52.25222943202509, 20.90051293373108, ent);
        List<Institute> institutes = Arrays.asList(instituteA, instituteB, instituteC, instituteE, instituteG, instituteRadiowa, instituteLazurowa);
        ent.setInstitutes(institutes);
        facultyRepository.save(ent);

        Faculty ele = new Faculty("Elevators", "elevators", "", "");
        Institute ele1 = new Institute("Elevator 1", "", 65, 52.25517838788134, 20.904101729393002, ele);
        Institute ele2 = new Institute("Elevator 2", "", 100, 52.253677663130354, 20.900663137435913, ele);
        Institute ele3 = new Institute("Elevator 3", "", 100, 52.25273188490786, 20.90072214603424, ele);
        List<Institute> elevators = Arrays.asList(ele1, ele2, ele3);
        ele.setInstitutes(elevators);
        facultyRepository.save(ele);

        Faculty food = new Faculty("Food", "food", "", "");
        Institute bufet = new Institute("Bufet", "", 100, 52.253657959623055, 20.900191068649292, food);
        Institute hotdogi = new Institute("Hot dogi", "", 0, 52.25248558518625, 20.89802920818329, food);
        Institute klops = new Institute("Klops", "", 0, 52.25492774842464, 20.893665057211063, food);
        Institute kebab = new Institute("Kebab", "", 0, 52.25866401603555, 20.897256895536568, food);
        Institute loska = new Institute("Łośka", "", 0, 52.25955214746283, 20.89802832679216, food);
        List<Institute> foods = Arrays.asList(bufet, hotdogi, klops, kebab, loska);
        food.setInstitutes(foods);
        facultyRepository.save(food);

        Faculty shops = new Faculty("Shops", "shops", "", "");
        Institute lewiatan = new Institute("Lewiatan", "", 0, 52.24963744011332, 20.89395605472621, shops);
        Institute archimedes = new Institute("Archimedes-Sklep Spożywczy", "", 0, 52.25564675241641, 20.894356996656228, shops);
        List<Institute> shopList = Arrays.asList(lewiatan, archimedes);
        shops.setInstitutes(shopList);
        facultyRepository.save(shops);
    }

}
