package com.it.app.info.manager.test;

import com.it.app.info.manager.IO.Artist;
import com.it.app.info.manager.IO.IoAdd;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class test {
    public static void main(String[] args) {

    }

    @Test
    public void TestCase1(){
        String rightId = "888AAAAA!!";
        String wrongId = "88";
        boolean rightIdRes=isValidArtistID(rightId);
        boolean wrongIdRes=isValidArtistID(wrongId);
        // Assert that "rightIdRes" is true, meaning that "rightId" is a valid artist ID
        assertTrue(rightIdRes);
        // Assert that "wrongIdRes" is false, meaning that "wrongId" is not a valid artist ID
        assertFalse(wrongIdRes);

        //        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//        Artist artist1 = new Artist("99AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//        Artist artist2 = new Artist("88AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//        Artist artist3 = new Artist("77AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist3.AddArtist()));
//        IoAdd.Artist artist=new IoAdd.Artist();
//        id
//        String rightId = "888AAAAA!!";
//                boolean rightIdRes=isValidArtistID(rightId);
//        assertAll ("", ()->assertEquals(true,
//                assertTrue(rightIdRes)));
//    assertAll ("", ()->assertEquals("The book information can be added",
//                                    artist1.addArtist(IoAdd.Artist artist1)),
//            ()->assertEquals ("The book information can be added",
//                              booktestCase1Data2.AddBook()),
//            ()->assertEquals ("The book information can be
//                              added", booktestCase1Data3.AddBook()));
//
//}
    }

    @Test
    public void TestCase2(){
//Address
        String rightAddress = "Melbourne|Victoria|Australia";
        String wrongAddress = "Melbourne,Victoria,Australia";
// Check the validity of the "rightAddress" using the isValidArtistAddress() method
// and store the result in the "rightAddressRes" boolean variable
        boolean rightAddressRes=isValidArtistAddress(rightAddress);
        // Check the validity of the "wrongAddress" using the isValidArtistAddress() method
        // and store the result in the "wrongAddressRes" boolean variable
        boolean wrongAddressRes=isValidArtistAddress(wrongAddress);
        assertTrue(rightAddressRes);
        assertFalse(wrongAddressRes);

//        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//        Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne,Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//        Artist artist2 = new Artist("999AAAAA!!", "chengji", "Syd,New|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//        Artist artist3 = new Artist("999AAAAA!!", "chengji", "Bri,Queen|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist3.AddArtist()));
    }

    @Test
    public void TestCase3(){
//        Age

        String rightAge = "05-11-1980";
        String wrongAge = "05/Nov/1980";

        boolean rightAgeRes=isValidArtistBirthDate(rightAge);
        boolean wrongAgeRes=isValidArtistBirthDate(wrongAge);
        assertTrue(rightAgeRes);
        assertFalse(wrongAgeRes);

//        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//        Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01,1999", "He is a very good singer", occupations, genres, awards);
//        Artist artist2 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01,2009", "He is a very good singer", occupations, genres, awards);
//        Artist artist3 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01,1985", "He is a very good singer", occupations, genres, awards);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist3.AddArtist()));

    }

    @Test
    public void TestCase4(){
        //Bio

        String rightBio = "He is a very good singer";
        String wrongBio = "young boy";

        boolean rightBioRes=isValidArtistBio(rightBio);
        boolean wrongBioRes=isValidArtistBio(wrongBio);
        assertTrue(rightBioRes);
        assertFalse(wrongBioRes);

//        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//        Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "young boy", occupations, genres, awards);
//        Artist artist2 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "boy", occupations, genres, awards);
//        Artist artist3 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "young", occupations, genres, awards);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist3.AddArtist()));

    }

    @Test
    public void TestCase5(){
//    isValidOccupations
        //Occupations

        ArrayList<String> rightOccupations = new ArrayList<>(Arrays.asList("Singer", "Songwriter"));
        ArrayList<String> wrongOccupations =new ArrayList<>(Arrays.asList
                ("Singer", "Songwriter","Waiter", "Football Player","Tennis Player", "Swimmer Player"));

        boolean rightOccupationsRes=isValidArtistOccupations(rightOccupations);
        boolean wrongOccupationsRes=isValidArtistOccupations(wrongOccupations);
        assertTrue(rightOccupationsRes);
        assertFalse(wrongOccupationsRes);

//        ArrayList<String> occupations1 = new ArrayList<>(Arrays.asList("Singer", "Songwriter","Waiter", "Football Player","Tennis Player", "Swimmer Player"));
//        ArrayList<String> occupations2 = new ArrayList<>(Arrays.asList("Runner", "Songwriter","Waiter", "Football Player","Tennis Player", "Swimmer Player"));
//        ArrayList<String> occupations3 = new ArrayList<>(Arrays.asList("Walker", "Songwriter","Waiter", "Football Player","Tennis Player", "Swimmer Player"));
//        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//        Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations1, genres, awards);
//        Artist artist2 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations2, genres, awards);
//        Artist artist3 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations3, genres, awards);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist3.AddArtist()));


    }

    @Test
    public void TestCase6(){
//        addArtistAwards
                ArrayList<String> rightAwards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
        // Incorrect award format (because it contains 4 awards, exceeding the limit of 3)
        ArrayList<String> wrongAwards =new ArrayList<>(Arrays.asList(
                "2002, Best singer",
                "2000, Best singer",
                "2001, Best singer",
                "2003, Best singer"));

        boolean rightAwardsRes = isValidArtistAwards(rightAwards);
        boolean wrongAwardsRes = isValidArtistAwards(wrongAwards);
        assertTrue(rightAwardsRes);  //  This assertion should pass
        assertFalse(wrongAwardsRes); //  This assertion should also pass

//        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//        ArrayList<String> awards1 = new ArrayList<>(Arrays.asList(
//                "2002, Best singer",
//                "2000, Best singer",
//                "2001, Best singer",
//                "2003, Best singer"));
//        ArrayList<String> awards2 = new ArrayList<>(Arrays.asList("2002, Best singer",
//                "2009, Best singer",
//                "2008, Best singer",
//                "2007, Best singer"));
//        ArrayList<String> awards3 = new ArrayList<>(Arrays.asList("2002, Best singer",
//                "1999, Best singer",
//                "1988, Best singer",
//                "1977, Best singer"));
//
//        Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//            "01-01-2000", "He is a very good singer", occupations, genres, awards1);
//        Artist artist2 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards2);
//        Artist artist3 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards3);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                        artist3.AddArtist()));


    }

    @Test
    public void TestCase7(){
        //        //Genres
//        An artist should be active in at least two music genres and a maximum of five genres.
//        Artists cannot be active in 'pop' and 'rock' genres at the same time. Example: pop, classical, jazz
        ArrayList<String> rightGenres = new ArrayList<>(Arrays.asList("pop", "classical","jazz"));
        ArrayList<String> wrongGenres =new ArrayList<>(Arrays.asList
                ("pop", "rock"));
        boolean rightGenresRes=isValidArtistGenres(rightGenres);
        boolean wrongGenresRes=isValidArtistGenres(wrongGenres);
        assertTrue(rightGenresRes);
        assertFalse(wrongGenresRes);

//        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//        ArrayList<String> genres1 = new ArrayList<>(Arrays.asList("pop", "rock"));
//        ArrayList<String> genres2 = new ArrayList<>(Arrays.asList("pop"));
//        ArrayList<String> genres3 = new ArrayList<>(Arrays.asList("pop", "classical", "hip", "blue", "Country", "rap"));
//        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//        Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres1, awards);
//        Artist artist2 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres2, awards);
//        Artist artist3 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres3, awards);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                                         artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                                  artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                                  artist3.AddArtist()));


    }

    @Test
    public void TestCase8() {
        // birthDate format: DD-MM-YYYY
        String rightDate = "01-01-2001";
        String wrongDate = "01-01-1999";

        boolean rightDateRes = canChangeOccupation(rightDate);
        boolean wrongDateRes = canChangeOccupation(wrongDate);

        assertTrue(rightDateRes);  // Asserts that rightDateRes is true
        assertFalse(wrongDateRes);


//        // birthDate    DD-MM-YYYY
////        int birthYear = Integer.parseInt(birthDate.split("-")[2]);
//
//        String rightDate = "2001";
//        String wrongDate = "1999";
//
//        boolean rightDateRes=canChangeOccupation(rightDate);
//        boolean wrongDateRes=canChangeOccupation(wrongDate);
//        assertTrue(rightDateRes);
//        assertFalse(wrongDateRes);
//        canChangeOccupation
//// If the person was born before the year 2000
//        if (birthYear < 2000) {
//            canChangeOccupation
//            return currentOccupations.equals(newOccupations);
//        }
//        // If the person was born in the year 2000 or later, they can change occupations
//        return true;
    }

//    @Test
//    public void TestCase9(){
//        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//        Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//        Artist artist2 = new Artist("888AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//        Artist artist3 = new Artist("777AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//                "01-01-2000", "He is a very good singer", occupations, genres, awards);
//
//        assertAll ("", ()->assertEquals ("The Artist can be added",
//                                         artist1.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                                  artist2.AddArtist()),
//                ()->assertEquals ("The Artist can be added",
//                                  artist3.AddArtist()));
//    }

//    @Test
//    public void updateArtistOccupations(){
//        List<String> oldOccupations = Arrays.asList("Singer","SmallStaff");
//        List<String> newOccupations = Arrays.asList("Player","BigBoss");
//        //before 2000
////        assertFalse(canChangeOccupation
////                ("9-9-1999", "Singer", "Player"));  // false
//        assertFalse(canChangeOccupation
//                ("9-9-1999", oldOccupations, newOccupations));  // false
//
//        // after 2000
//        assertTrue(canChangeOccupation("9-9-2009", oldOccupations, newOccupations));  //can update
//    }
//

    public static boolean canChangeOccupation(String birthDate) {
        // birthDate format: DD-MM-YYYY
        int birthYear = Integer.parseInt(birthDate.split("-")[2]);
        // If the person was born before the year 2000
        if (birthYear < 2000) {
            return false;
        }
        // If the person was born in the year 2000 or later, they can change occupations
        return true;
    }

//    public static boolean canChangeOccupation(String birthDate) {
//        // birthDate    DD-MM-YYYY
//        int birthYear = Integer.parseInt(birthDate.split("-")[2]);
//// If the person was born before the year 2000
//        if (birthYear < 2000) {
////            return currentOccupations.equals(newOccupations);
//            return false;
//        }
//        // If the person was born in the year 2000 or later, they can change occupations
//        return true;
////        String birthDate, List<String> currentOccupations, List<String> newOccupations
//    }






    public static boolean isValidArtistID(String artistID) {
        // The artist ID should be of length 10
        if (artistID.length() != 10) {
            return false;
        }
        // The first three characters
        // digits between 5 and 9
        for (int i = 0; i < 3; i++) {
            char digit = artistID.charAt(i);
            if (digit < '5' || digit > '9') {
                return false;
            }
        }
        // from 4th to 8th position should be uppercase letters between 'A' and 'Z'
        for (int i = 3; i < 8; i++) {
            char character = artistID.charAt(i);
            if (character < 'A' || character > 'Z') {
                return false;
            }
        }
//        The second last character should be one of the following special characters: '!', '@', '#', '$'
        // and the last character should be either '%' or '^'
        char secondLastCharacter = artistID.charAt(8);
        char lastCharacter = artistID.charAt(9);

        if (!(secondLastCharacter == '!' || secondLastCharacter == '@' || secondLastCharacter == '#' || secondLastCharacter == '$' || lastCharacter == '%' || lastCharacter == '^')) {
            return false;
        }
        return true;
    }

    public static boolean isValidArtistAddress(String artistAddress) {
        String[] addressParts = artistAddress.split("\\|");

        //Check if the split resulted in exactly 3 parts
        if (addressParts.length != 3) {
            return false;
        }

        String city = addressParts[0];
        String state = addressParts[1];
        String country = addressParts[2];

        // Check if any of the parts (city, state, or country) is empty
        if (city.isEmpty() || state.isEmpty() || country.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean isValidArtistBirthDate(String artistBirthDate) {
        //The desired format is "dd-MM-yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); //

        try {
            // If the date is not in the "dd-MM-yyyy" format, this will throw a ParseException
            Date parsedDate = dateFormat.parse(artistBirthDate);
            String formattedDate = dateFormat.format(parsedDate);
            return formattedDate.equals(artistBirthDate);
        } catch (ParseException e) {

            return false;
        }
    }

    public static boolean isValidArtistBio(String artistBio) {
// Calculate the word count of the biography after removing spaces.
        int bioLength = artistBio.replaceAll("\\s+", "").length();

// Verify if the word count is within the specified range.
        return bioLength >= 10 && bioLength <= 30;
    }
    public static boolean isValidArtistOccupations(ArrayList<String> occupations) {
// Verify there is at least one occupation and at most five occupations
        if (occupations.size() >= 1 && occupations.size() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidArtistAwards(ArrayList<String> awards) {

        // should less than 3
        if (awards.size() > 3) {
            return false;
        }

//        Start with 4 digits (representing a year)
        String pattern = "\\d{4},\\s.{4,}";


        Pattern regex = Pattern.compile(pattern);

// Loop through each award in the list
        for (String award : awards) {
            Matcher matcher = regex.matcher(award);
//            // If any award does not match the expected pattern, return false
            if (!matcher.matches()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidArtistGenres(ArrayList<String> genres) {
        // Check if the artist is active in at least two genres and no more than five genres
        if (genres.size() < 2 || genres.size() > 5) {
            return false;
        }

        // Check if the artist is active in both 'pop' and 'rock' genres
        if (genres.contains("pop") && genres.contains("rock")) {
            return false;
        }

        return true;
    }




//    right input
//    ArrayList<String> occupations = new ArrayList<>(Arrays.asList("SongWriter", "PianoPlayer"));
//    ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
//    ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
//
//    Artist artist1 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//            "01-01-2000", "He is a very good singer", occupations, genres, awards);
//    Artist artist2 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//            "01-01-2000", "He is a very good singer", occupations, genres, awards);
//    Artist artist3 = new Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
//            "01-01-2000", "He is a very good singer", occupations, genres, awards);
//
//    assertAll ("", ()->assertEquals ("The Artist can be added",
//                                     artist1.AddArtist()),
//            ()->assertEquals ("The Artist can be added",
//                              artist2.AddArtist()),
//            ()->assertEquals ("The Artist can be added",
//                              artist3.AddArtist()));


}
