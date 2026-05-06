package com.pluralsight;

public class NameFormatter {

    private  NameFormatter(){


    }


    public static String format(String firstName, String lastName){
        return lastName + ", " + firstName;



    }

    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {

        String formattedName = lastName + ", ";

        // Add prefix if exists
        if (prefix != null && !prefix.isEmpty()) {
            formattedName += prefix + " ";
        }


        // First name is required
        formattedName += firstName;

        // Add middle name if exists
        if (middleName != null && !middleName.isEmpty()) {
            formattedName += " " + middleName;
        }


        // Add suffix if exists
        if (suffix != null && !suffix.isEmpty()) {
            formattedName += ", " + suffix;
        }

        return formattedName;
    }



    // Format full name input:
    // "Dr. Mel B Johnson, PhD"
    // "Mel B Johnson, PhD"
    // "Mel Johnson"
    public static String format(String fullName) {

        String suffix = "";
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        // Separate suffix if comma exists
        String[] commaParts = fullName.split(",");

        String namePart = commaParts[0].trim();

        if (commaParts.length > 1) {
            suffix = commaParts[1].trim();
        }



        // Split main name into pieces
        String[] parts = namePart.split(" ");

        // If 4 parts → Prefix First Middle Last
        if (parts.length == 4) {
            prefix = parts[0];
            firstName = parts[1];
            middleName = parts[2];
            lastName = parts[3];
        }


        // If 3 parts → Could be Prefix First Last OR First Middle Last
        else if (parts.length == 3) {

            // Simple check for common prefix
            if (parts[0].endsWith(".")) {
                prefix = parts[0];
                firstName = parts[1];
                lastName = parts[2];
            } else {
                firstName = parts[0];
                middleName = parts[1];
                lastName = parts[2];
            }
        }


        // If 2 parts → First Last
        else if (parts.length == 2) {
            firstName = parts[0];
            lastName = parts[1];
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }





}
