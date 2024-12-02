package ch05.SimpleDotCom;

public class SimpleDotCom {
    private int [] locationCells;
    private int numberOfHits;

    SimpleDotCom() {
        // locationCells = new int[7];
        // for(int i = 0 ; i < locationCells.length ; ++i) {
        //     locationCells[i] = -1;
        // }
        // locationCells[1] = 2;
        // locationCells[3] = 3;
        // locationCells[5] = 5;

        numberOfHits = 3;
    }
    /*
     * method: String checkYourself(String userGuess)
     *  Get: the user guess as a String parameter
     *  Convert: the user guess to an int
     *  Repeat: with each of the location cells in the int array
     *  // compare: the user guess to the location cell
     *      if the user guess matches
     *          increment the number of hits
     *          // find out if it was the last location cell
     *          if number of hits is 3, return 'Kill' as the result
     *          else it was not a kill, so return 'hit'
     *          end if
     *      else the user guess did not match, so return 'miss'
     *      end if
     *  end repeat
     * end method
     */
    public String checkYourself(String userGuess) {
        int guess = Integer.parseInt(userGuess);
        for (int i = 0 ; i < locationCells.length ; ++i) {
            if (guess == locationCells[i]) {
                numberOfHits = numberOfHits - 1;
                locationCells[i] = -1;
                if (numberOfHits == 0) {
                    return new String("Kill");
                } else {
                    return new String("Hit");
                }
            }
        }
        return new String("Miss");
    }
     /*
      * method: void setLocationCells(int[] cellLocations)
      *     Get: the cell locations as an int array parameter
      *     assign the cell locations parameter to the cell location instance variable
      * end method
      */
      public void setLocationCells(int[] locs) {
            locationCells = locs;
            // locationCells = new int[cellLocations.length];
            // for(int i = 0 ; i < cellLocations.length ; ++i) {
            //     locationCells[i] = cellLocations[i];
            // }
      }
}
