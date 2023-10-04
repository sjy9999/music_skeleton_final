package com.it.app.info.manager.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Born1999UpdateFail {

    public boolean updateArtist(Artist artist) {
        System.out.println("Trying to update artist..."); // Debug statement
        if (meetAllAddCondi(artist)) {
            System.out.println("Artist meets all conditions."); // Debug statement
            try (FileWriter writer = new FileWriter("artists.txt", true)) {
                writer.write(artist.toString() + "\n");
                System.out.println("Artist successfully added to the file.");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to write the artist to the file due to an exception."); // Debug statement
                return false;
            }
        } else {
            System.out.println("Artist does not meet all conditions."); // Debug statement
            return false;
        }
    }

    private boolean meetAllAddCondi(Artist artist) {
        boolean idBoo=isValidArtistID(artist.id);
        boolean addressBoo=isValidArtistAddress(artist.address);
        boolean birthdayBoo=isValidArtistBirthDate(artist.birthday);
        boolean bioBoo=isValidArtistBio(artist.bio);
        boolean occupationsBoo=isValidArtistOccupations(artist.occupations);
        boolean awardsBoo=isValidArtistAwards(artist.awards);
        boolean genresBoo=isValidArtistGenres(artist.genres);

        List<String> oldOccupations = Arrays.asList("Singer","SmallStaff");
        List<String> newOccupations = Arrays.asList("Player","BigBoss");

        boolean genresChangeBoo=canChangeOccupation("9-9-1999",oldOccupations, newOccupations);
//        boolean genresChangeBoo=canChangeOccupation("9-9-2008",oldOccupations, newOccupations);
        if(idBoo && addressBoo && birthdayBoo && bioBoo && occupationsBoo && awardsBoo && genresBoo&&genresChangeBoo) {
            return true;
        } else {
            return false;
        }
    }

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


    public static void main(String[] args) {
        ArrayList<String> occupations = new ArrayList<>(Arrays.asList("Singer", "Songwriter"));
        ArrayList<String> genres = new ArrayList<>(Arrays.asList("Pop", "Classical"));
        ArrayList<String> awards = new ArrayList<>(Arrays.asList("2022, Best Song Written"));

        Born1999UpdateFail.Artist artist = new Born1999UpdateFail.Artist("999AAAAA!!", "chengji", "Melbourne|Victoria|Australia",
                "01-01-2000", "He is a very good singer", occupations, genres, awards);

        Born1999UpdateFail Born1999UpdateFail = new Born1999UpdateFail();
        Born1999UpdateFail.updateArtist(artist);
    }

    static class Artist {
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
