// BAD CODE
/**
 * Changes (from 11-Oct-2001)
 * 11-Oct-2001 : Re-organised the class ...
 * 05-Nov-2001 : Added a getDescription() method ...
 */

/** The day of the month. */
private int dayOfMonth;

/**
 * Returns the day of the month.
 * @return the day of the month
 */
public int getDayOfMonth() {
    return dayOfMonth;
}


// GOOD CODE
// Copyright (C) 2011 by Osoco. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.

// Returns an instance of the Responder being tested.
protected abstract Responder responderInstance();

// Format matched kk:mm:ss EEE, MMM dd, yyyy
Pattern timeMatcher = Pattern.compile(
    "\\d*:\\d*:\\d* \\w*, \\w* \\d*, \\d*"
);

assertTrue(a.compareTo(b) == -1); // a < b
assertTrue(b.compareTo(a) == 1);  // b > a