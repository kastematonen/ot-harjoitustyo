# Testausdokumentti

Ohjelmaa on testattu JUnitilla toiteutetuilla yksikkö- ja integraatiotesteillä sekä manuaalisilla järjestelmätason testeillä.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka
Sovelluslogiikan eli pakkauksen spaceinvaders.domain luokkien toimintaa on testattu kunkin luokan kohdalla omilla yksikkötesteillään. Game-luokka, joka kokoaa yhteen muiden luokkien ja pakkausten toiminnallisuutta, on testattu myös. Siinä tallennuksessa on käytetty pelin käyttämää FilePointDao-luokkaa ja erillistä testaustiedostoa pisteiden tallennukseen.

### DAO-luokka
Dao-luokkaa on testattu luomalla sille oma testitiedosto, johon se tallentaa pisteitä. Tiedosto on erillinen pelin varsinaisesta pistetiedostosta, jotta testaaminen ei sekoittaisi pelin pisteitä. Tiedosto tyhjennetään kunkin testin lopuksi.

### Testikattavuus
Testikattavuus sovellukselle poislukien käyttöliittymä on esitetty alla kuvassa. Sovelluksen rivikattavuus on 99% ja sen haarautumakattavuus on 100%.

![kattavuusraportti](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/testikattavuus.png)

## Järjestelmätestaus
Pelin toimivuus ja sen sääntöjen noudattaminen on testattu käsin.

### Asennus

### Toiminnallisuudet
Määrittelydokumentin mukaiset toiminnallisuudet on testattu läpi käsin yrittäen samalla rikkoa pelin sääntöjä ja toiminnallisuuksia, ja peli toimi tästä huolimatta hyvin.

## Sovelluksenn jääneet laatuongelmat
* ei järkeviä virheilmoituksia, jos config.properties-tiedostoa ei löydy?
* ei järkeviä virheilmoituksia, jos käyttäjällä ei tallennustiedostoihin luku/kirjoitusoikeuksia?
