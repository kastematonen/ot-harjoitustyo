# Vaativuusmäärittely

## Sovelluksen tarkoitus
Sovelluksella on mahdollista peleta Space Invaders -tyylistä peliä, jossa tarkoituksena on ampua taivaalta tulevat valloittajat ennen kuin ne ehtivät planeetallemme asti.

## Käyttäjät
Sovelluksella on vain yhdenlaisia käyttäjiä, jotka voivat pelata peliä.

## Toiminnallisuus
* Aloitusnäkymä
  * voi siirtyä ohjesivulle
  * voi siityä peliin
  * voi siirtyä pistesivulle
  * voi sulkea sovelluksen
* Peli
  * voi liikuttaa hahmoa oikealle ja vasemmalle nuolinäppäimistä
  * voi ampua X-näppäimestä
  * näkee lähestyvät vastustajat
  * jos osuu ammuksella vastustajaan, saa pisteitä
  * näkee pisteet
  * jos vastustaja ehtii maahan ennen kuin se on ammuttu, peli loppuu
  * voi keskeyttää pelin painamalla siihen tarkoitettua nappia joko hiirellä tai välilyönnillä
  * pelin loppuessa siirrytään pistenäkymään
  * pisteiden tallentaminen nimimerkillä pelin pistenäkymässä
* Pistesivu
  * näytetään viimeisimpien 10 pelin pisteet ja ne saavuttaneet nimimerkit
  * näytetään kaikista parhaan tuloksen pisteet ja viimeisin sen saavuttanut nimimerkki

## Jatkokehitysideoita
* pisteiden tallentuminen verkkoon, jolloin pisteitä voisi vertailla myös kaverin pelien kanssa samassa näkymässä
* vaikeustason valinta pelissä: vaikka vastustajien nopeus kasvaakin pelin edetessä, ja peli vaikeutuu koko ajan, voisi vastustajien lukumäärän valinta olla hyvä lisä peliin.
