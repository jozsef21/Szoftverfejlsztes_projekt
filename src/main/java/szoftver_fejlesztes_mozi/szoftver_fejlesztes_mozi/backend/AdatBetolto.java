package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Dolgozok;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Felhasznalok;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Kedvezmenyek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.Termek;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.DolgozokRepository;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.FelhasznalokRepository;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.KedvezmenyekRepository;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.TermekRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdatBetolto implements CommandLineRunner {

    private final DolgozokRepository dolgozokRepository;
    private final KedvezmenyekRepository kedvezmenyekRepository;
    private final FelhasznalokRepository felhasznalokRepository;
    private final TermekRepository termekRepository;

    public AdatBetolto(DolgozokRepository dolgozokRepository,
                       KedvezmenyekRepository kedvezmenyekRepository,
                       FelhasznalokRepository felhasznalokRepository,
                       TermekRepository termekRepository) {
        this.dolgozokRepository = dolgozokRepository;
        this.kedvezmenyekRepository = kedvezmenyekRepository;
        this.felhasznalokRepository = felhasznalokRepository;
        this.termekRepository = termekRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (dolgozokRepository.count() == 0) {
            betoltDolgozok();
        }
        if (kedvezmenyekRepository.count() == 0) {
            betoltKedvezmenyek();
        }
        if (felhasznalokRepository.count() == 0) {
            betoltFelhasznalok();
        }
        if (termekRepository.count() == 0) {
            betoltTermek();
        }
    }

    private void betoltDolgozok() throws IOException {
        List<Dolgozok> lista = new ArrayList<>();
        for (String[] sor : beolvas("/csv/dolgozok.csv")) {
            Dolgozok d = new Dolgozok();
            d.setId(Integer.parseInt(sor[0].trim()));
            d.setNev(sor[1].trim());
            d.setMunkakor(sor[2].trim());
            lista.add(d);
        }
        dolgozokRepository.saveAll(lista);
        System.out.println("Dolgozók betöltve: " + lista.size());
    }

    private void betoltKedvezmenyek() throws IOException {
        List<Kedvezmenyek> lista = new ArrayList<>();
        for (String[] sor : beolvas("/csv/kedvezmenyek.csv")) {
            Kedvezmenyek k = new Kedvezmenyek();
            k.setElnevezes(sor[0].trim());
            k.setSzazalek(Integer.parseInt(sor[1].trim()));
            lista.add(k);
        }
        kedvezmenyekRepository.saveAll(lista);
        System.out.println("Kedvezmények betöltve: " + lista.size());
    }

    private void betoltFelhasznalok() throws IOException {
        List<Felhasznalok> lista = new ArrayList<>();
        for (String[] sor : beolvas("/csv/felhasznalok.csv")) {
            Felhasznalok f = new Felhasznalok();
            f.setRegisztralt_nev(sor[0].trim());
            f.setNev(sor[1].trim());
            f.setJelszo(sor[2].trim());
            lista.add(f);
        }
        felhasznalokRepository.saveAll(lista);
        System.out.println("Felhasználók betöltve: " + lista.size());
    }

    private void betoltTermek() throws IOException {
        List<Termek> lista = new ArrayList<>();
        for (String[] sor : beolvas("/csv/termek.csv")) {
            Termek t = new Termek();
            t.setID(Integer.parseInt(sor[0].trim()));
            t.setNev(sor[1].trim());
            t.setSorok_szama(Integer.parseInt(sor[2].trim()));
            t.setOszlopk_szama(Integer.parseInt(sor[3].trim()));
            lista.add(t);
        }
        termekRepository.saveAll(lista);
        System.out.println("Termek betöltve: " + lista.size());
    }

    // Beolvassa a CSV-t, a fejlécet átugorja, elválasztó: pontosvessző
    private List<String[]> beolvas(String utvonal) throws IOException {
        InputStream is = getClass().getResourceAsStream(utvonal);
        if (is == null) {
            System.out.println("Nem található a fájl: " + utvonal);
            return new ArrayList<>();
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1)
                    .filter(s -> !s.trim().isEmpty())
                    .map(s -> s.split(";"))
                    .collect(Collectors.toList());
        }
    }
}