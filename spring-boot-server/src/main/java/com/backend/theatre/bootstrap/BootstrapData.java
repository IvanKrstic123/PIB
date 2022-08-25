package com.backend.theatre.bootstrap;

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

    public BootstrapData(TypeRepository typeRepository, WriterRepository writerRepository, PerformanceRepository performanceRepository) {
        this.typeRepository = typeRepository;
        this.writerRepository = writerRepository;
        this.performanceRepository = performanceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // delete database data
        typeRepository.deleteAll();
        writerRepository.deleteAll();
        performanceRepository.deleteAll();

        // initialize database data
        initTypes();
        initWriters();
        // initPerformances();
    }

    private void initWriters() {
        Writer writer = new Writer();
        writer.setName("Francesko");
        writer.setSurname("Cilea");
        writer.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer1 = new Writer();
        writer1.setName("Francesko");
        writer1.setSurname("Cilea");
        writer1.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer2 = new Writer();
        writer2.setName("Francesko");
        writer2.setSurname("Cilea");
        writer2.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer3 = new Writer();
        writer3.setName("Francesko");
        writer3.setSurname("Cilea");
        writer3.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer4 = new Writer();
        writer4.setName("Francesko");
        writer4.setSurname("Cilea");
        writer4.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer5 = new Writer();
        writer5.setName("Francesko");
        writer5.setSurname("Cilea");
        writer5.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer6 = new Writer();
        writer6.setName("Francesko");
        writer6.setSurname("Cilea");
        writer6.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer7 = new Writer();
        writer7.setName("Francesko");
        writer7.setSurname("Cilea");
        writer7.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        Writer writer8 = new Writer();
        writer8.setName("Francesko");
        writer8.setSurname("Cilea");
        writer8.setBirthDate(Timestamp.valueOf("1886-4-25 9:15:15"));

        writerRepository.save(writer);
    }

    private void initTypes() {
        Type type = new Type();
        type.setType("Komedija");

        Type type1 = new Type();
        type1.setType("Drama");

        Type type2 = new Type();
        type2.setType("Triler");

        Type type3 = new Type();
        type3.setType("Biografija");

        Type type4 = new Type();
        type4.setType("Muzikl");

        Type type5 = new Type();
        type5.setType("Balet");

        Type type6 = new Type();
        type6.setType("Opera");

        typeRepository.save(type);
        typeRepository.save(type1);
        typeRepository.save(type2);
        typeRepository.save(type3);
        typeRepository.save(type4);
        typeRepository.save(type5);
        typeRepository.save(type6);
    }
}
