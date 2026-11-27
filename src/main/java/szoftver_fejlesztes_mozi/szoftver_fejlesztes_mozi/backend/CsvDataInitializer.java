package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Model.*;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.Repository.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class CsvDataInitializer {

    @Bean
    CommandLineRunner loadAllCsvData(DolgozokRepository dolgRepo,FelhasznalokRepository felhRepo,KedvezmenyekRepository kedvRepo,FilmekRepository filmRepo, TermekRepository teremRepo, VetitesekRepository vetitesRepo) {
        return args -> {
            if (dolgRepo.count() == 0) {
                List<Dolgozok> dolgozo = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new ClassPathResource("CSV/Dolgozok.csv").getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    boolean firstLine = true;
                    while ((line = reader.readLine()) != null) {
                        if (firstLine) { firstLine = false; continue; }
                        String[] p = line.split(",");
                        if (p.length >= 2) {
                            Dolgozok d = new Dolgozok();
                            d.setNev(p[0].trim());
                            d.setMunkakor(p[1].trim());
                            dolgozo.add(d);
                        }
                    }
                    dolgRepo.saveAll(dolgozo);
                    System.out.println("Dolgozok sikeresen betöltve!");
                } catch (Exception e) {
                    System.out.println("Hiba Dolgozok olvasásakor: " + e.getMessage());
                }
            }

            if (felhRepo.count() == 0) {
                List<Felhasznalok> felhasznalo = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new ClassPathResource("CSV/Felhasznalok.csv").getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    boolean firstLine = true;
                    while ((line = reader.readLine()) != null) {
                        if (firstLine) { firstLine = false; continue; }
                        String[] p = line.split(",");
                        if (p.length >= 3) {
                            Felhasznalok fh = new Felhasznalok();
                            fh.setRegisztralt_nev(p[0].trim());
                            fh.setNev(p[1].trim());
                            fh.setJelszo(p[2].trim());
                            felhasznalo.add(fh);
                        }
                    }
                    felhRepo.saveAll(felhasznalo);
                    System.out.println("Felhasználok sikeresen betöltve!");
                } catch (Exception e) {
                    System.out.println("Hiba Felhasználok olvasásakor: " + e.getMessage());
                }
            }
            if (kedvRepo.count() == 0) {
                List<Kedvezmenyek> kedvezmeny = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new ClassPathResource("CSV/Kedvezmenyek.csv").getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    boolean firstLine = true;
                    while ((line = reader.readLine()) != null) {
                        if (firstLine) { firstLine = false; continue; }
                        String[] p = line.split(",");
                        if (p.length >= 2) {
                            Kedvezmenyek k = new Kedvezmenyek();
                            k.setElnevezes(p[0].trim());
                            k.setSzazalek(Integer.parseInt(p[1].trim()));
                            kedvezmeny.add(k);
                        }
                    }
                    kedvRepo.saveAll(kedvezmeny);
                    System.out.println("Kedvezmények sikeresen betöltve!");
                } catch (Exception e) {
                    System.out.println("Hiba Kedvezmények olvasásakor: " + e.getMessage());
                }
            }
            if (vetitesRepo.count() == 0) {
                if (filmRepo.count() == 0) {
                    List<Filmek> filmek = new ArrayList<>();
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                            new ClassPathResource("CSV/Filmek.csv").getInputStream(), StandardCharsets.UTF_8))) {
                        String line;
                        boolean firstLine = true;
                        while ((line = reader.readLine()) != null) {
                            if (firstLine) { firstLine = false; continue; }
                            String[] p = line.split(",");
                            if (p.length >= 5) {
                                Filmek f = new Filmek();
                                f.setCim(p[0].trim());
                                f.setRendezo(p[1].trim());
                                f.setKiadas_ev(Integer.parseInt(p[2].trim()));
                                f.setMufaj(p[3].trim());
                                f.setPlakat(p[4].trim());
                                filmek.add(f);
                            }
                        }
                        filmRepo.saveAll(filmek);
                        System.out.println("Filmek sikeresen betöltve!");
                    } catch (Exception e) {
                        System.out.println("Hiba filmek olvasásakor: " + e.getMessage());
                    }
                }
                if (teremRepo.count() == 0) {
                    List<Termek> termek = new ArrayList<>();
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                            new ClassPathResource("CSV/Termek.csv").getInputStream(), StandardCharsets.UTF_8))) {
                        String line;
                        boolean firstLine = true;
                        while ((line = reader.readLine()) != null) {
                            if (firstLine) { firstLine = false; continue; }
                            String[] p = line.split(",");
                            if (p.length >= 3) {
                                Termek t = new Termek();
                                t.setNev(p[0].trim());
                                t.setSorok_szama(Integer.parseInt(p[1].trim()));
                                t.setOszlopk_szama(Integer.parseInt(p[2].trim()));
                                termek.add(t);
                            }
                        }
                        teremRepo.saveAll(termek);
                        System.out.println("Termek sikeresen betöltve!");
                    } catch (Exception e) {
                        System.out.println("Hiba termek olvasásakor: " + e.getMessage());
                    }
                }
                List<Vetitesek> vetitesek = new ArrayList<>();
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new ClassPathResource("CSV/Vetitesek.csv").getInputStream(), StandardCharsets.UTF_8))) {
                    String line;
                    boolean firstLine = true;
                    while ((line = reader.readLine()) != null) {
                        if (firstLine) { firstLine = false; continue; }
                        String[] p = line.split(",");
                        if (p.length >= 4) {
                            String filmCim = p[0].trim();
                            Integer teremId = Integer.parseInt(p[1].trim());
                            LocalDateTime kezdes = LocalDateTime.parse(p[2].trim());
                            Integer alapar = Integer.parseInt(p[3].trim());

                            Filmek film = filmRepo.findById(filmCim).orElse(null);
                            Termek terem = teremRepo.findById(teremId).orElse(null);

                            if (film != null && terem != null) {
                                Vetitesek v = new Vetitesek();
                                v.setFilmek_id(film);
                                v.setTerem_id(terem);
                                v.setKezdes_idopont(kezdes);
                                v.setAlapar(alapar);
                                vetitesek.add(v);
                            }
                        }
                    }
                    vetitesRepo.saveAll(vetitesek);
                    System.out.println("Vetítések sikeresen betöltve!");
                } catch (Exception e) {
                    System.out.println("Hiba vetítések olvasásakor: " + e.getMessage());
                }

            }
        };
    }
}