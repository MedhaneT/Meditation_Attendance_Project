# Meditation_Attendance_Project

Attendance Checking Software
We are trying to create a web application that will automate the process of creating attendance reports
for students, faculty and administrators.

- Students need to be able to login and view the list of courses that they have taken (or are
currently taking) and view their daily meditation attendance for that course.
- Faculty need to be able to login and view a list of courses that they are or have been teaching
for the past six months and view a class list along with attendance report for each student in
that class.
- Personnel need to be able to login and search for any student and view their all-time attendance
records. They should also be able to change any record (manually change an “absent” to
“present”) for any date.
- Administrators need to be able to login and assign roles. Administrators also have the same
privileges that personnel have.
- Users of this system can have multiple roles. For example a faculty can also be Personnel! 

Step 1 - Requirements
The system is based on a bar-code reader (similar to the one in use at the Dalby Hall for morning
meditations).
- The barcode reader creates a record of each scan by saving the bar-code ID, date, timeslot
(morning or afternoon) and location.
- Each student has an ID (000-xx-yyyy), first name, last name and a bar-code ID.
- Each timeslot has an abbreviation (such as AM, PM) which can be used as natural ID,
description, begin time and end time (which mark the beginning and end of that timeslot or
times during which scans are accepted)
- Each location has an ID and description
- Each student can sign up for one more course offerings
- Each course offering has id, Course Id, start and end dates and marks a particular offering of a
course
- Each course can be offered many times and has an ID, name and description
- Each course offering also can have multiple sessions
- Each “session” is a timeslot offered at a particular date for a particular course. So each “session”
record has an ID, Course Offering ID, Timeslot ID and date. 
