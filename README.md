# Ohjelmistotekniikan harjoitustyö 
# Space Invaders -tyylinen peli

Pelin tavoitteena on estää valloittajia pääsemästä planeetalle ampumalle ne, ennen kuin ne ovat liian lähellä. Jokaisesta ammutusta valloittajasta saa pisteitä.

## Dokumentaatio

[Vaativuusmäärittely](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/vaativuusmaarittely.md)

[Työaikakirjanpito](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Käyttöohje](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Testausdokumentti](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/testausdokumentti.md)

## Releaset
[Loppupalautus](https://github.com/kastematonen/ot-harjoitustyo/releases/tag/viikko7)

## Komentorivitoiminnot

### Testaus

Testit komennolla 

    mvn test

Testikattavuusraportti komennolla 

    mvn jacoco:report

Kattavuusraportin tulos avautuu selaimeen tiedostosta target/site/jacoco/index.html

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/kastematonen/ot-harjoitustyo/blob/master/Spaceinvaders/checkstyle.xml) 
tarkistukset komennolla 

    mvn jxr:jxr checkstyle:checkstyle

Virheilmoitukset avautuvat selaimella tiedostosta target/site/checkstyle.html

### Jarin generointi

Komennolla

    mvn package
    
saadaan jar-tiedosto Spaceinvaders-1.0-SNAPSHOT.jar

### JavaDoc:n generointi

Komennolla

    mvn javadoc:javadoc
    
Luotu JavaDoc löytyy tällöin hakemistosta target/site/apidocs/
