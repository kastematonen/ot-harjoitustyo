# Ohjelmistotekniikan harjoitustyö 
# Space Invaders -tyylinen peli

Pelin tavoitteena on estää valloittajia pääsemästä planeetalle ampumalle ne, ennen kuin ne ovat liian lähellä. Jokaisesta ammutusta valloittajasta saa pisteitä.

## Dokumentaatio

[Alustava määrittelydokumentti](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/vaativuusmaarittely.md)

[Työaikakirjanpito](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Releaset


## Komentorivitoiminnot

### Testaus

Testit komennolla mvn test

Testikattavuusraportti komennolla mvn jacoco:report

Kattavuusraportin tulos avautuu selaimeen tiedostosta target/site/jacoco/index.html

### Checkstyle

Tiedoston [checkstyle.xml](https://github.com/kastematonen/ot-harjoitustyo/blob/master/Spaceinvaders/checkstyle.xml) 
tarkistukset komennolla mvn jxr:jxr checkstyle:checkstyle

Virheilmoitukset avautuvat selaimella tiedostosta target/site/checkstyle.html
