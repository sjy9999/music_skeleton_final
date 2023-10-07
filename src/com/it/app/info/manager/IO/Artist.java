package com.it.app.info.manager.IO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Artist {
    private String id;
    private String name;
    private String address;
    private String birthday;
    private String bio;
    private ArrayList<String> occupations;
    private ArrayList<String> genres;
    private ArrayList<String> awards;

    public Artist(String id, String name, String address, String birthday, String bio, ArrayList<String> occupations, ArrayList<String> genres, ArrayList<String> awards) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.bio = bio;
        this.occupations = occupations;
        this.genres = genres;
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Address: " + address + ", Birthday: " + birthday + ", Bio: " + bio + ", Occupations: " + occupations + ", Genres: " + genres + ", Awards: " + awards;
    }

    public String AddArtist ()
    {
        if (isValidArtistID(id))
        {
            return "The Artist can be added";
        }
        if (isValidArtistAddress(address))
        {
            return "The Artist can be added";
        }
        if (isValidArtistBirthDate(birthday))
        {
            return "The Artist can be added";
        }
        if (isValidArtistBio(bio))
        {
            return "The Artist can be added";
        }
        if (isValidArtistOccupations(occupations))
        {
            return "The Artist can be added";
        }
        if (isValidArtistAwards(awards))
        {
            return "The Artist can be added";
        }
        if (isValidArtistGenres(genres))
        {
            return "The Artist can be added";
        }

//        if (countWord <2 || countWord >4)
//        {
//            return "The Artist cannot be added";
//        }
//        if ((bookType != "Kids" && (bookPrice <=5 || bookPrice >=250)) || (bookType
//                == "Kids" && (bookPrice <=5 || bookPrice >=40)))
//            return "The Artist cannot be added";
        return "The Artist can not be added";
    }

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

}
