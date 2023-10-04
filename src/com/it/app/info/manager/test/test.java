package com.it.app.info.manager.test;

import org.junit.Test;

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
    public void addArtistId(){
//        id
        String rightId = "888AAAAA!!";
        String wrongId = "88";
        boolean rightIdRes=isValidArtistID(rightId);
        boolean wrongIdRes=isValidArtistID(wrongId);
        assertTrue(rightIdRes);
        assertFalse(wrongIdRes);
    }

    @Test
    public void addArtistAddress(){
//Address

        String rightAddress = "Melbourne|Victoria|Australia";
        String wrongAddress = "Melbourne,Victoria";

        boolean rightAddressRes=isValidArtistAddress(rightAddress);
        boolean wrongAddressRes=isValidArtistAddress(wrongAddress);
        assertTrue(rightAddressRes);
        assertFalse(wrongAddressRes);
    }

    @Test
    public void addArtistAge(){
//Age

        String rightAge = "05-11-1980";
        String wrongAge = "05/Nov/1980";

        boolean rightAgeRes=isValidArtistBirthDate(rightAge);
        boolean wrongAgeRes=isValidArtistBirthDate(wrongAge);
        assertTrue(rightAgeRes);
        assertFalse(wrongAgeRes);
    }

    @Test
    public void addArtistBio(){
//Bio

        String rightBio = "He is a very good singer";
        String wrongBio = "young boy";

        boolean rightBioRes=isValidArtistBio(rightBio);
        boolean wrongBioRes=isValidArtistBio(wrongBio);
        assertTrue(rightBioRes);
        assertFalse(wrongBioRes);
    }
//    isValidOccupations
    @Test
    public void addArtistOccupations(){
    //Occupations

        ArrayList<String> rightOccupations = new ArrayList<>(Arrays.asList("Singer", "Songwriter"));
        ArrayList<String> wrongOccupations =new ArrayList<>(Arrays.asList
                ("Singer", "Songwriter","Waiter", "Football Player","Tennis Player", "Swimmer Player"));

        boolean rightOccupationsRes=isValidArtistOccupations(rightOccupations);
        boolean wrongOccupationsRes=isValidArtistOccupations(wrongOccupations);
        assertTrue(rightOccupationsRes);
        assertFalse(wrongOccupationsRes);
    }

    @Test
    public void addArtistAwards(){
        // 正确的奖项格式
        ArrayList<String> rightAwards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));
        // 不正确的奖项格式（因为它包含了4个奖项，超过了限制的3个）
        ArrayList<String> wrongAwards =new ArrayList<>(Arrays.asList(
                "2002, Best singer",
                "2000, Best singer",
                "2001, Best singer",
                "2003, Best singer"));

        boolean rightAwardsRes = isValidArtistAwards(rightAwards);
        boolean wrongAwardsRes = isValidArtistAwards(wrongAwards);
        assertTrue(rightAwardsRes);  // 这个断言应该通过
        assertFalse(wrongAwardsRes); // 这个断言也应该通过
    }

    @Test
    public void addArtistGenres(){
        //Genres

        ArrayList<String> rightGenres = new ArrayList<>(Arrays.asList("pop", "classical","jazz"));
        ArrayList<String> wrongGenres =new ArrayList<>(Arrays.asList
                ("pop", "rock"));
        boolean rightGenresRes=isValidArtistGenres(rightGenres);
        boolean wrongGenresRes=isValidArtistGenres(wrongGenres);
        assertTrue(rightGenresRes);
        assertFalse(wrongGenresRes);
    }

    @Test
    public void updateArtistOccupations(){
        List<String> oldOccupations = Arrays.asList("Singer","SmallStaff");
        List<String> newOccupations = Arrays.asList("Player","BigBoss");
        //before 2000
//        assertFalse(canChangeOccupation
//                ("9-9-1999", "Singer", "Player"));  // false
        assertFalse(canChangeOccupation
                ("9-9-1999", oldOccupations, newOccupations));  // false

        // after 2000
        assertTrue(canChangeOccupation("9-9-2009", oldOccupations, newOccupations));  //
    }
//    @Test
//    public void updateArtistOccupations(){
//        //before 2000
//        assertFalse(canChangeOccupation
//                ("9-9-1999", "Singer", "Player"));  // false
//
//        // after 2000
//        assertTrue(canChangeOccupation("9-9-2009", "Singer", "Player"));
//    }


//    public static boolean canChangeOccupation(String birthDate, String currentOccupation, String newOccupation) {
//        // birthDate    DD-MM-YYYY
//        int birthYear = Integer.parseInt(birthDate.split("-")[2]);
//
//        if (birthYear < 2000) {
//            return currentOccupation.equals(newOccupation); // true
//        }
//        return true;
//    }
    public static boolean canChangeOccupation(String birthDate, List<String> currentOccupations, List<String> newOccupations) {
        // birthDate    DD-MM-YYYY
        int birthYear = Integer.parseInt(birthDate.split("-")[2]);

        if (birthYear < 2000) {
            return currentOccupations.equals(newOccupations);
        }
        return true;
    }






    public static boolean isValidArtistID(String artistID) {
        // 10
        if (artistID.length() != 10) {
            return false;
        }
        // 5-9
        for (int i = 0; i < 3; i++) {
            char digit = artistID.charAt(i);
            if (digit < '5' || digit > '9') {
                return false;
            }
        }
        // 4-8
        for (int i = 3; i < 8; i++) {
            char character = artistID.charAt(i);
            if (character < 'A' || character > 'Z') {
                return false;
            }
        }
        char secondLastCharacter = artistID.charAt(8);
        char lastCharacter = artistID.charAt(9);

        if (!(secondLastCharacter == '!' || secondLastCharacter == '@' || secondLastCharacter == '#' || secondLastCharacter == '$' || lastCharacter == '%' || lastCharacter == '^')) {
            return false;
        }
        return true;
    }

    public static boolean isValidArtistAddress(String artistAddress) {
        // （|）
        String[] addressParts = artistAddress.split("\\|");

        //
        if (addressParts.length != 3) {
            return false;
        }

        String city = addressParts[0];
        String state = addressParts[1];
        String country = addressParts[2];

        //
        if (city.isEmpty() || state.isEmpty() || country.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean isValidArtistBirthDate(String artistBirthDate) {
        //
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); //

        try {

            Date parsedDate = dateFormat.parse(artistBirthDate);

            String formattedDate = dateFormat.format(parsedDate);
            return formattedDate.equals(artistBirthDate);
        } catch (ParseException e) {

            return false;
        }
    }

    public static boolean isValidArtistBio(String artistBio) {

        int bioLength = artistBio.replaceAll("\\s+", "").length();


        return bioLength >= 10 && bioLength <= 30;
    }
    public static boolean isValidArtistOccupations(ArrayList<String> occupations) {

        if (occupations.size() >= 1 && occupations.size() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidArtistAwards(ArrayList<String> awards) {

        // 3 false
        if (awards.size() > 3) {
            return false;
        }


        String pattern = "\\d{4},\\s.{4,}";


        Pattern regex = Pattern.compile(pattern);


        for (String award : awards) {
            Matcher matcher = regex.matcher(award);
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


}
