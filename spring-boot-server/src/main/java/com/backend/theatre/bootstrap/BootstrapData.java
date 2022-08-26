package com.backend.theatre.bootstrap;

import com.backend.theatre.models.Performance;
import com.backend.theatre.models.Type;
import com.backend.theatre.models.Writer;
import com.backend.theatre.repository.PerformanceRepository;
import com.backend.theatre.repository.TypeRepository;
import com.backend.theatre.repository.WriterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class BootstrapData implements CommandLineRunner {

    private final TypeRepository typeRepository;
    private final WriterRepository writerRepository;
    private final PerformanceRepository performanceRepository;

    // writer constants
    private static Writer FRANCESKO_CILEA;
    private static Writer DJUZEPE_VERDI;
    private static Writer RONALD_SAVKOVIC;
    private static Writer DEJAN_KOLAROV;
    private static Writer JAGOS_MARKOVIC;
    private static Writer LUDVIG_MINKUS;
    private static Writer ALEKSANDAR_POPOVIC;
    private static Writer VOLFGANG_AMADEUS_MOCART;
    private static Writer DUSAN_KOVACEVIC;
    private static Writer ZELJKO_HUBAC;
    private static Writer BRANISLAV_NUSIC;

    // type constants
    private static Type DRAMA;
    private static Type OPERA;
    private static Type BALLET;
    private static Type COMEDY;

    public BootstrapData(TypeRepository typeRepository, WriterRepository writerRepository, PerformanceRepository performanceRepository) {
        this.typeRepository = typeRepository;
        this.writerRepository = writerRepository;
        this.performanceRepository = performanceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // delete database data
        performanceRepository.deleteAll();
        writerRepository.deleteAll();
        typeRepository.deleteAll();

        // initialize database data
        initTypes();
        initWriters();
        initPerformances();
    }

    private void initTypes() {
        DRAMA = new Type();
        DRAMA.setType("Drama");

        OPERA = new Type();
        OPERA.setType("Opera");

        BALLET = new Type();
        BALLET.setType("Balet");

        COMEDY = new Type();
        COMEDY.setType("Komedija");

        typeRepository.save(DRAMA);
        typeRepository.save(OPERA);
        typeRepository.save(BALLET);
        typeRepository.save(COMEDY);
    }

    private void initWriters() {
        FRANCESKO_CILEA = new Writer();
        FRANCESKO_CILEA.setName("Francesko");
        FRANCESKO_CILEA.setSurname("Cilea");
        FRANCESKO_CILEA.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        DJUZEPE_VERDI = new Writer();
        DJUZEPE_VERDI.setName("Djuzepe");
        DJUZEPE_VERDI.setSurname("Verdi");
        DJUZEPE_VERDI.setBirthDate(Timestamp.valueOf("1813-10-25 9:15:15"));

        RONALD_SAVKOVIC = new Writer();
        RONALD_SAVKOVIC.setName("Ronald");
        RONALD_SAVKOVIC.setSurname("Savkovic");
        RONALD_SAVKOVIC.setBirthDate(Timestamp.valueOf("1975-9-11 9:15:15"));

        DEJAN_KOLAROV = new Writer();
        DEJAN_KOLAROV.setName("Dejan");
        DEJAN_KOLAROV.setSurname("Kolarov");
        DEJAN_KOLAROV.setBirthDate(Timestamp.valueOf("1981-10-10 9:15:15"));

        JAGOS_MARKOVIC = new Writer();
        JAGOS_MARKOVIC.setName("Jagos");
        JAGOS_MARKOVIC.setSurname("Markovic");
        JAGOS_MARKOVIC.setBirthDate(Timestamp.valueOf("1978-2-13 9:15:15"));

        LUDVIG_MINKUS = new Writer();
        LUDVIG_MINKUS.setName("Ludvig");
        LUDVIG_MINKUS.setSurname("Minkus");
        LUDVIG_MINKUS.setBirthDate(Timestamp.valueOf("1826-8-8 9:15:15"));

        ALEKSANDAR_POPOVIC = new Writer();
        ALEKSANDAR_POPOVIC.setName("Aleksandar");
        ALEKSANDAR_POPOVIC.setSurname("Popovic");
        ALEKSANDAR_POPOVIC.setBirthDate(Timestamp.valueOf("1929-5-5 9:15:15"));

        VOLFGANG_AMADEUS_MOCART = new Writer();
        VOLFGANG_AMADEUS_MOCART.setName("Volfgang Amadeus");
        VOLFGANG_AMADEUS_MOCART.setSurname("Mocart");
        VOLFGANG_AMADEUS_MOCART.setBirthDate(Timestamp.valueOf("1756-4-25 9:15:15"));

        DUSAN_KOVACEVIC = new Writer();
        DUSAN_KOVACEVIC.setName("Dusan");
        DUSAN_KOVACEVIC.setSurname("Kovacevic");
        DUSAN_KOVACEVIC.setBirthDate(Timestamp.valueOf("1948-9-9 9:15:15"));

        ZELJKO_HUBAC = new Writer();
        ZELJKO_HUBAC.setName("Zeljko");
        ZELJKO_HUBAC.setSurname("Hubac");
        ZELJKO_HUBAC.setBirthDate(Timestamp.valueOf("1971-9-9 9:15:15"));

        BRANISLAV_NUSIC = new Writer();
        BRANISLAV_NUSIC.setName("Branislav");
        BRANISLAV_NUSIC.setSurname("Nusic");
        BRANISLAV_NUSIC.setBirthDate(Timestamp.valueOf("1864-10-20 9:15:15"));

        writerRepository.save(FRANCESKO_CILEA);
        writerRepository.save(DJUZEPE_VERDI);
        writerRepository.save(RONALD_SAVKOVIC);
        writerRepository.save(DEJAN_KOLAROV);
        writerRepository.save(JAGOS_MARKOVIC);
        writerRepository.save(LUDVIG_MINKUS);
        writerRepository.save(ALEKSANDAR_POPOVIC);
        writerRepository.save(VOLFGANG_AMADEUS_MOCART);
        writerRepository.save(DUSAN_KOVACEVIC);
        writerRepository.save(ZELJKO_HUBAC);
        writerRepository.save(BRANISLAV_NUSIC);
    }
    private void initPerformances() {
        Performance performance = new Performance();
        performance.setTitle("ADRIJANA LEKUVRER");
        performance.setDescription("Obnova opere je niz zabluda i nesporazuma, kako u mišljenju tako i u praksi. ");
        performance.setType(OPERA);
        performance.setWriter(FRANCESKO_CILEA);
        performance.setDuration("150");

        Performance performance1 = new Performance();
        performance1.setTitle("AIDA");
        performance1.setDescription("Tri godine posle Don Karlosa, 16. jula 1870, Verdi je pisao jednom svome prijatelju: „Komponujem jednu operu za Kairo!");
        performance1.setType(OPERA);
        performance1.setWriter(DJUZEPE_VERDI);
        performance1.setDuration("140");

        Performance performance2 = new Performance();
        performance2.setTitle("ALEKSANDAR");
        performance2.setDescription("Slojevita ličnost Aleksandra Velikog, vojskovođe, poluboga, ljubavnika, osvajača sveta.");
        performance2.setType(BALLET);
        performance2.setWriter(RONALD_SAVKOVIC);
        performance2.setDuration("120");

        Performance performance3 = new Performance();
        performance3.setTitle("ALISA");
        performance3.setDescription("Rad na Alisi je bio najlakši zadatak na svetu. Nisam mogla da se odbranim od inspiracije. Doduše, brinula sam za Alisu.");
        performance3.setType(BALLET);
        performance3.setWriter(DEJAN_KOLAROV);
        performance3.setDuration("140");

        Performance performance4 = new Performance();
        performance4.setTitle("ANTIGONA");
        performance4.setDescription("Mit koji je Sofokle dramatizovao u Antigoni pripada krugu tebanskih legendi i ne može se naći u Homerovim epovima;");
        performance4.setType(DRAMA);
        performance4.setWriter(JAGOS_MARKOVIC);
        performance4.setDuration("110");

        Performance performance5 = new Performance();
        performance5.setTitle("ATILA");
        performance5.setDescription("Njegovu vrhovnu vlast priznavala su mnoga germanska i slovenska plemena, a povremeno i Vizantija.");
        performance5.setType(OPERA);
        performance5.setWriter(DJUZEPE_VERDI);
        performance5.setDuration("100");

        Performance performance6 = new Performance();
        performance6.setTitle("BAJADERA");
        performance6.setDescription("„Pojam bajadera koji potiče od portugalske reči – bailadeiras (plesačice), u zapadnu kulturu dolazi u drugoj polovini XVIII veka.");
        performance6.setType(BALLET);
        performance6.setWriter(LUDVIG_MINKUS);
        performance6.setDuration("111");

        Performance performance7 = new Performance();
        performance7.setTitle("VLAST");
        performance7.setDescription("Nušićev duh, njegovu ličnost, njegovu književničku prirodu otkrivamo već u Narodnom poslaniku.");
        performance7.setType(COMEDY);
        performance7.setWriter(BRANISLAV_NUSIC);
        performance7.setDuration("122");

        Performance performance8 = new Performance();
        performance8.setTitle("BAL POD MASKAMA");
        performance8.setDescription("Opera Bal pod maskama spada među najpopularnije opere Đuzepea Verdija.");
        performance8.setType(OPERA);
        performance8.setWriter(DJUZEPE_VERDI);
        performance8.setDuration("131");

        Performance performance9 = new Performance();
        performance9.setTitle("BALKANSKI ŠPIJUN");
        performance9.setDescription("Bibliografija radova o delu Dušana Kovačevića sadrži na stotine studija, kritičkih prikaza, doktorskih disertacija i diplomskih radova. ");
        performance9.setType(DRAMA);
        performance9.setWriter(DUSAN_KOVACEVIC);
        performance9.setDuration("121");

        Performance performance10 = new Performance();
        performance10.setTitle("BASTIJEN I BASTIJENA");
        performance10.setDescription("Jedna od najkraćih opera Volfganga Amadeusa Mocarta, Bastijen i Bastijena nastala je kada je Mocart imao samo dvanaest godina.");
        performance10.setType(OPERA);
        performance10.setWriter(VOLFGANG_AMADEUS_MOCART);
        performance10.setDuration("150");

        Performance performance11 = new Performance();
        performance11.setTitle("BELA KAFA");
        performance11.setDescription("Novi pozorišni komad Aleksandra Popovića, Bela kafa, navodi na pomisao da se osobeni pozorišni koncept ovoga uglednog autora.");
        performance11.setType(DRAMA);
        performance11.setWriter(ALEKSANDAR_POPOVIC);
        performance11.setDuration("90");

        Performance performance12 = new Performance();
        performance12.setTitle("BIZARNO");
        performance12.setDescription("Drama Bizarno je na konkursu Sterijinog pozorja 2008. godine, izabrana među pet najboljih i štampana u časopisu „Scena“.");
        performance12.setType(DRAMA);
        performance12.setWriter(ZELJKO_HUBAC);
        performance12.setDuration("80");

        performanceRepository.save(performance);
        performanceRepository.save(performance1);
        performanceRepository.save(performance2);
        performanceRepository.save(performance3);
        performanceRepository.save(performance4);
        performanceRepository.save(performance5);
        performanceRepository.save(performance6);
        performanceRepository.save(performance7);
        performanceRepository.save(performance8);
        performanceRepository.save(performance9);
        performanceRepository.save(performance10);
        performanceRepository.save(performance11);
        performanceRepository.save(performance12);
    }

}
