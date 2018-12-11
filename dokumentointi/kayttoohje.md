# Käyttöohje

Lataa tiedosto spaceinvaders.jar

## Konfigurointi

## Ohjelman käynnistäminen

Ohjelma käynnistyy komennolla

    java -jar spaceinvaders.jar

## Aloitusnäkymä

Peli avautuu aloitusnäkymään:

![aloitusnäkymä](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/aloitusnakyma.png)

## Pelin ohjeiden lukeminen

Pelin ohjeita ja sääntöjä pääsee lukemaan, kun painaa aloitusnäkymässä "Ohjeisiin"-nappulaa.

Ohjenäkymä näyttää seuraavalta:

![ohjenäkymä](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/ohjeet.png)

Ohjeista pääsee takaisin aloitussivulle painamalla alanurkan nappia "Etusivulle".

## Pelin pelaaminen

Peliin pääsee aloitusnäkymän napilla "Peliin".

Avautuva pelinäkymä näyttää seuraavalta:

![pelinäkymä](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/peli.png)

Pelissä pelaajan hahmo on alhaalla näkyvä sininen pallo. Se liikkuu nuolinäppäimistä oikealle ja vasemmalle ja se ampuu keltaisen ammuksen X-näppäimestä. Ammus tulee näkyviin vain, kun sen on ampunut, ja niitä voi ampua kerrallaan vain yhden. 

Lentävä ammus näyttää seuraavanlaiselta:

![pelinäkymä, lentävä ammus](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/ammus.png)

Jos ammus osuu punaiseen vastustajahahmoon, saa pelaaja pisteitä, ja ammus palaa takaisin alkutilaansa odottamaan uutta laukaisua. Pisteet näkyvät ylänurkassa ja päivittyvät sitä mukaan, kun niitä tulee. Jos ammus ei osu matkallaan vastustajiin, se palaa alkutilaansa päästyään pelinäkymän pelialueen yläreunaan.

Jos peliä ei halua pelata loppuun, sen saa keskeytettyä nappulasta "Keskeytä peli", jolloin palataan takaisin aloitusnäkymään.

Peli loppuu, kun punaiset vatustajahahmot pääsevät liikkumaan pelialueen alareunaan. Tällöin pelin loppunäkymä avautuu käyttäjälle:

![pelin loppunäkymä](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/palinLoppu.png)

Loppunäkymä näyttää pelaajalle pisteet ja pyytää syöttämään tekstikenttään pelaajan nimen tai nimimerkin, jolla pisteet tallennetaan.Tallentaminen ja aloitusnäkymään siirtyminen tapahtuu "Tallenna pisteet"-napista.

## Pistetaulun katselu

Kaikkein korkeimpia pisteitä pääsee tarkastelemaan pistenäkymästä, jonne voi siirtyä aloitusnäkymän "Huippupisteet"-nappulasta.

Jos peliä on pelattu, näyttää näkymä seuraavanlaiselta:

![huippupisteet](https://github.com/kastematonen/ot-harjoitustyo/blob/master/dokumentointi/kuvat/huippupisteet_on_pisteita.png)

Aloitusnäkymään voi siirtyä nappulasta "Etusivulle".

## Ohjelman sulkeminen

Ohjelman voi sulkea joku pelin yläkulman ruksista tai aloitusnäkymän nappulasta "Lopeta".
