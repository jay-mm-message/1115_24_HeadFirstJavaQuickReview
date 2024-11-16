package ch01.BeerSong;

public class BeerSong {

    public void singBeerSong(int beerNum) {

        Tools t = new Tools();
        String word = "bottles";

        while(beerNum > 0) {

            if (beerNum == 1) {
                word = "bottle";
            }

            t.pl(beerNum + " " + word + " of beer on the wall");
            t.pl(beerNum + " " + word + " of beer.");
            t.pl("Take one down.");
            t.pl("Pass it around.");
            
            beerNum = beerNum - 1;
            
            if (beerNum > 0) {
                t.pl(beerNum + " " + word + " of beer on the wall");
            } else {
                t.pl("No more bottles of beer on the wall");
            }
        }

    }
}
