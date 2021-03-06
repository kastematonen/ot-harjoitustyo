# Arkkitehtuurikuvaus

## Rakenne

Ohjelman koodi on jaettu pakkauksiin seuraavasti:
- spaceinvaders.ui sisältää Java FX:llä tehdyn käyttöliittymän.
- spaceinvaders.domain vastaa sovelluslogiikasta ja siihen tarvittavista luokista
- spaceinvaders.dao hoitaa tietojen tallennusta

## Käyttöliittymä

Käyttöliittymän koodi on luokassa spaceinvaders.ui.SpaceinvadersUi.

Käyttöliittymässä on useampi näkymä:
- etusivu
- ohjesivu
- pelisivu
- pelin loppusivu
- huippupisteetsivu

Kukin näkymistä on rakennettu omaan Scene-olioonsa, ja vain yksi näistä on kerrallaan näkyvissä sovelluksen Stagessa. 

Käyttöliittymä on yhteydessä sovelluslogiikkaan logiikasta vastaavalla Game-oliolla, jonka metodeja tarpeen tullen kutsutaan muiden osien päivittämiseksi.

## Sovelluslogiikka

Sovelluksen logiikkapakkauksen luokat suhteutuvat toisiinsa seuraavasti:

![Luokkakaavio](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio.jpg)

Luokista Game kokoaa yhteen koko pelin toiminnallisuuden, ja muut luokat ovat Gamen käyttämiä ja päivittämiä ilmentymiä pelin elementeistä.

 Game-luokan pelikäskyjä ovat:
- void makeInvaders(int howMany)
- void launchMissile()
- void update()
- void isGameOver(ArrayList<Invader> invaders)
- boolean isCollision(Invader first, Missile second)
- void handleCollision(Missile missile, ArrayList<Invader> invaders)
- void newGame()
- void addPointsToList(int points, String name)
- List<Point> getLast10Points()
- List<Point> getAllPoints()
- String getBestPoints()

Sekvenssikaavio alla kuvaa tilannetta, jossa käyttäjä painaa etusivulla Peliin-nappulaa, ja peli lähtee pyörimään. Tällöin peli vaihtaa pelinäkymän ja päivittää pelin. Kaaviosta tulee hyvin ilmi se, että käyttöliittymän Game-luokan ilmentymä hoitaa yhteydet muihin domain-luokkiin. Käyttöliittymä ja sovelluslogiikka toimivat siis erillisissa luokissa ja pakkauksissa.

![Sekvenssikaavio_pelin_aloitus](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/sekvenssikaavio.jpg)

## Tietojen pysyväistallennus

Pelissä tallennetaan pelin loputtua pisteet ja pelaajan nimimerkki tiedostoon dao-pakkauksen FilePointDao-luokan toimesta. Sama tiedosto luetaan, kun pelin pistenäkymään asetetaan tallennettuja pisteitä.

### Tiedostot

Sovellus tallentaa pisteet ja ne saaneet nimimerkit yhteen tiedostoon. Tiedosto voidaan määritellä config.properties-tiedostolla (kts. [käyttöohjeet](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)) tai sen puuttuessa ohjelma tallentaa pisteitä ennaltanimettyyn tiedostoon "pointFile".

Sovellus tallentaa pisteet muodossa 

    30;player
    
eli pisteet;nimi puolipisteellä eroteltuna.

## Ohjelman rakenteeseen jääneet heikkoudet

- Käyttöliittymäluokan start-metodi on melko pitkä, joten sen eri näkymät voisi erottaa omiin tiedostoihinsa käyttämällä esimerkiksi FXML:ää.
- Pelin huippupisteiden näyttäminen ei toimi täysin kunnolla: jos pelaaja saa jo pistelistassa olevat parhaat pisteet, näkyy pistenäkymässä vain ne viimeisimmäksi saavuttanut nimimerkki
