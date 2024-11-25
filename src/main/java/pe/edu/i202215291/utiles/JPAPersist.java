package pe.edu.i202215291.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import pe.edu.i202215291.domain.City;
import pe.edu.i202215291.domain.Country;
import pe.edu.i202215291.domain.CountryLanguage;
import pe.edu.i202215291.domain.LanguagePk;

import java.util.Arrays;

public class JPAPersist {

    @Transactional
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cl1");
        EntityManager em = emf.createEntityManager();

        Country country = new Country("GGG","Gampi","South America","South America",30000.00,1541,50000,70.5,730.0,616.0,"Gogogolia","Republic","Dorian Galvez",4080,"GG",null,null);

        City city1 = new City(4080,"Gloglocity","Ciudad1",31000,country);
        City city2 = new City(4081,"Goliat","Ciudad2",35000,country);
        City city3 = new City(4082,"Gagaga","Ciudad3",4000,country);

        // Creamos las 2 lenguas para el país imaginario
        LanguagePk langPk1 = new LanguagePk("Spanish", "GGG");
        LanguagePk langPk2 = new LanguagePk("English", "GGG");

        CountryLanguage language1 = new CountryLanguage(langPk1,"T",58.0,country);
        CountryLanguage language2 = new CountryLanguage(langPk2,"T",93.0,country);

        //Referenciamos ciudades en paises
        country.setCiudades(Arrays.asList(city1,city2,city3));

        //Referenciamos lenguajes en paises
        country.setIdiomas(Arrays.asList(language1,language2));

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
