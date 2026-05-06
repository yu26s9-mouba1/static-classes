package com.pluralsight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class NameFormatterTest {

        // Test simple first + last
        @Test
        public void format_shouldFormatFirstAndLastName() {

            String result = NameFormatter.format("Mel", "Johnson");

            assertEquals("Johnson, Mel", result);
        }

        // Test full 5-part name
        @Test
        public void format_shouldFormatCompleteNameWithPrefixMiddleSuffix() {

            String result = NameFormatter.format(
                    "Dr.",
                    "Mel",
                    "B",
                    "Johnson",
                    "PhD"
            );

            assertEquals("Johnson, Dr. Mel B, PhD", result);
        }

        // Test full name string with everything
        @Test
        public void format_shouldParseFullNameWithPrefixMiddleSuffix() {

            String result = NameFormatter.format("Dr. Mel B Johnson, PhD");

            assertEquals("Johnson, Dr. Mel B, PhD", result);
        }

        // Test full name string with first + last only
        @Test
        public void format_shouldParseSimpleFullName() {

            String result = NameFormatter.format("Mel Johnson");

            assertEquals("Johnson, Mel", result);
        }

        // Test full name with middle + suffix
        @Test
        public void format_shouldParseFullNameWithMiddleAndSuffix() {

            String result = NameFormatter.format("Mel B Johnson, PhD");

            assertEquals("Johnson, Mel B, PhD", result);
        }



}
