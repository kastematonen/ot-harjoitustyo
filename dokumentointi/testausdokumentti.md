# Testausdokumentti

Ohjelmaa on testattu JUnitilla toiteutetuilla yksikkö- ja integraatiotesteillä sekä manuaalisilla järjestelmätason testeillä.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka
Sovelluslogiikan eli pakkauksen spaceinvaders.domain luokkien toimintaa on testattu kunkin luokan kohdalla omilla yksikkötesteillään. Game-luokka, joka kokoaa yhteen muiden luokkien ja pakkausten toiminnallisuutta, on testattu myös. Siinä tallennuksessa on käytetty pelin käyttämää FilePointDao-luokkaa ja erillistä testaustiedostoa pisteiden tallennukseen. Game luokan muita luokkia integroivat testit ovat hyödyntäneet muita domain-pakkauksen luokkia sekä dao-pakkauksen sisältöä simuloimalla oikeassa pelissä esiintyviä tilanteita.

### DAO-luokka
Dao-luokkaa on testattu luomalla sille oma testitiedosto, johon se tallentaa pisteitä. Tiedosto on erillinen pelin varsinaisesta pistetiedostosta, jotta testaaminen ei sekoittaisi pelin pisteitä. Tiedosto tyhjennetään kunkin testin lopuksi. Sovellus toimii, kun sen käyttämä tallennustiedosto on olemassa, ja jos sitä ei ole, osaa ohjelma tehdä uuden tiedoston. Tilanteet, joissa tiedostoihin ei ole käyttöoikeutta jäivät kuitenkin testaamatta.

### Testikattavuus
Testikattavuus sovellukselle poislukien käyttöliittymä on esitetty alla kuvassa. Sovelluksen rivikattavuus on 99% ja sen haarautumakattavuus on 100%.

![kattavuusraportti](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/testikattavuus.png)

## Järjestelmätestaus
Pelin toimivuus ja sen sääntöjen noudattaminen on testattu käsin.

### Asennus ja konfigurointi

Pelin asennusta on kokeiltu lataamalla spaceinvaders.jar-tiedosto ja asentamalla se  [käyttöohjeen](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md) mukaan Windows-ympäristössä. Sovellus toimi tilanteissa, joissa config.properties-tiedosto on ollut mukana (pisteet on tallennettu tiedostoon points.txt) ja joissa sitä ei ole ollut (pisteet on tallennettu tiedostoon pointFile). 

Sovellusta on testattu myös tilanteessa, jossa config.properties-tiedosto on ollut olemassa, samoin points.txt-tiedosto. Sovellus toimi tällöin odotetusti, ja kykeni lukemaan points.txt-tiedostoon oikeassa muodossa syötetyt pisteet pelin pistenäkymään.

### Toiminnallisuudet
Määrittelydokumentin mukaiset toiminnallisuudet on testattu läpi käsin yrittäen samalla rikkoa pelin sääntöjä ja toiminnallisuuksia, ja peli toimi tästä huolimatta hyvin.

## Sovelluksenn jääneet laatuongelmat

* Tilanteet, joisa käyttäjällä ei ole tallennustiedostoihin luku- tai kirjoitusoikeutta eivät tulleet testatuiksi sovellusta kehitettäessä, joten niiden antamia virheilmoituksia ei ole siistitty millään tavalla.
