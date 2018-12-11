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

Käyttöliittymä on yhteydessä sovelluslogiikkaan logiikasta vastaavalla oliolla, jonka metodeja tarpeen tullen kutsutaan.

## Sovelluslogiikka

Sovelluksen logiikkapakkauksen luokat suhteutuvat toisiinsa seuraavasti:

![Luokkakaavio](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/luokkakaavio2.jpg)

Luokista Game kokoaa yhteen koko pelin toiminnallisuuden, ja muut luokat ovat Gamen käyttämiä ilmentymiä pelin elementeistä.

 Game-luokan pelikäskyjä ovat:
- void makeInvaders(int howMany)
- void launchMissile()
- void update()
- void isGameOver(ArrayList<Invader> invaders)
- boolean isCollision(Invader first, Missile second)
- void handleCollision(Missile missile, ArrayList<Invader> invaders)
- void newGame()
- void addPointsToList(int points, String name)

Sekvenssikaavio, kun käyttäjä painaa etusivulla Peliin-nappulaa, ja peli lähtee pyörimään.

![Sekvenssikaavio_pelin_aloitus](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/sekvenssikaavio.jpg)

## Tietojen pysyväistallennus
## Ohjelman rakenteeseen jääneet heikkoudet

- Käyttöliittymäluokan start-metodi tosi pitkä -> näkymien koodien eriyttäminen omaan luokkaan tms?
- pelin pisteiden tallennus ei toimi täysin kunnolla: jos pelaaja saa jo pistelistassa olevat pisteet, tallennetaan pelaajan pisteet ensimmäisten pisteiden päälle
