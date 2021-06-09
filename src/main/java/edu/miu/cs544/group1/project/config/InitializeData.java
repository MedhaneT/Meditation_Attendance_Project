package edu.miu.cs544.group1.project.config;

import edu.miu.cs544.group1.project.controller.dto.LocationDto;
import edu.miu.cs544.group1.project.controller.dto.RegisterUserDto;
import edu.miu.cs544.group1.project.domain.*;
import edu.miu.cs544.group1.project.domain.enumerated.RoleCode;
import edu.miu.cs544.group1.project.repository.*;
import edu.miu.cs544.group1.project.service.LocationService;
import edu.miu.cs544.group1.project.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
@Log4j2
public class InitializeData {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;
    @Autowired
    private ClassSessionRepository classSessionRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private AttendanceRecordRepository attendanceRepository;

    @Bean
    public CommandLineRunner loadData(RoleRepository roleRepository,
                                      UserRepository userRepository,
                                      UserService userService,
                                      PasswordEncoder passwordEncoder,
                                      LocationRepository locationRepository,
                                      LocationService locationService) {
        return (args) -> {
            attendanceRepository.deleteAll();
            classSessionRepository.deleteAll();
            registrationRepository.deleteAll();
            courseOfferingRepository.deleteAll();
            courseRepository.deleteAll();
            facultyRepository.deleteAll();
            locationRepository.deleteAll();
            timeSlotRepository.deleteAll();
            userRepository.deleteAll();
            studentRepository.deleteAll();
            roleRepository.deleteAll();

            // save roles
            roleRepository.save(new Role(RoleCode.ADMIN));
            roleRepository.save(new Role(RoleCode.FACULTY));
            roleRepository.save(new Role(RoleCode.STUDENT));

            // fetch all roles
            log.info("Roles found with findAll():");
            log.info("--------------------------------------------------------------");
            for (Role role : roleRepository.findAll()) {
                log.info(role.toString());
            }
            // add test Student for barcode scanning
            {
                Student studnet = new Student("Berhane", "Teklehaimanot", "1", "/home/berhane/Desktop/barcode.png");
                studentRepository.save(studnet);
            }

            // add admin user
            User admin = null;
            User faculty = null;
            User student = null;
            {
                RegisterUserDto userDto = new RegisterUserDto("admin@miu.edu",
                        passwordEncoder.encode("123123"),
                        new Faculty("Payman", "Salek"), RoleCode.ADMIN);
                admin = userService.registerUser(userDto);
            }

            // add faculty user
            {
                RegisterUserDto userDto = new RegisterUserDto("faculty@miu.edu",
                        passwordEncoder.encode("123123"),
                        new Faculty("Anthony", "Sander"), RoleCode.FACULTY);
                faculty = userService.registerUser(userDto);
            }

            {
                RegisterUserDto userDto = new RegisterUserDto("najeeb@miu.edu",
                        passwordEncoder.encode("123123"),
                        new Faculty("Najeeb", "Najeeb"), RoleCode.FACULTY);
                userService.registerUser(userDto);
            }

            {
                RegisterUserDto userDto = new RegisterUserDto("rjong@miu.edu",
                        passwordEncoder.encode("123123"),
                        new Faculty("Ren de", "Jong"), RoleCode.FACULTY);
                userService.registerUser(userDto);
            }


            // add student user
            {
                RegisterUserDto userDto = new RegisterUserDto("tuannx87@gmail.com",
                        passwordEncoder.encode("123123"),
                        new Student("Xuan Tuan", "Nguyen",
                                "000-666999", "000-666999"), RoleCode.STUDENT);
                student = userService.registerUser(userDto);
            }

            {
                RegisterUserDto userDto = new RegisterUserDto("medhane@gmail.com", passwordEncoder.encode("123123"),
                        new Student("Medhane", "TS", "11111", "src/main/resources/barcodeImages/barcode.jpg"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("brhin@gmail.com", passwordEncoder.encode("222222"),
                        new Student("Brhane", "Dk", "11112", "000-222333"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("misgna@gmail.com", passwordEncoder.encode("333333"),
                        new Student("Misgna", "KK", "11113", "000-333444"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("Teddy@gmail.com", passwordEncoder.encode("444444"),
                        new Student("Teddy", "SS", "11114", "000-444555"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("Bob@gmail.com", passwordEncoder.encode("444444"),
                        new Student("Bob", "DD", "11115", "000-555666"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("john@gmail.com", passwordEncoder.encode("555555"),
                        new Student("John", "Dow", "11116", "000-677766"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("mohamed@gmail.com", passwordEncoder.encode("672456"),
                        new Student("Mohammed", "Beshir", "11117", "000-777888"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("sam@gmail.com", passwordEncoder.encode("672456"),
                        new Student("Sam", "Mm", "11118", "000-888999"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("isabella@gmail.com", passwordEncoder.encode("678756"),
                        new Student("Isabella", "Jocob", "11119", "000-999000"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("will@gmail.com", passwordEncoder.encode("678906"),
                        new Student("William", "Alex", "11120", "000-999111"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }
            {
                RegisterUserDto userDto = new RegisterUserDto("zoe@gmail.com", passwordEncoder.encode("678906"),
                        new Student("Hailey", "Caleb", "11121", "000-999222"), RoleCode.STUDENT);
                userService.registerUser(userDto);
            }


            //Locations
            {
                LocationDto location = new LocationDto(new Location(1, "VaryHoll", "VaryHoll", 50));
                locationService.createLocation(location);
            }
            {
                LocationDto location = new LocationDto(new Location(2, "Mclaughlin", "Mclaughlin", 45));
                locationService.createLocation(location);
            }
            {
                LocationDto location = new LocationDto(new Location(3, "Argiro", "Argiro", 60));
                locationService.createLocation(location);
            }
            Location location = null;
            {
                LocationDto locationDto = new LocationDto(new Location(4, "ASC-Dalby Hall", "ASC-Dalby Hall", 60));
                location = locationService.createLocation(locationDto);
            }

            // Misghinna's Damy data

            Course defaultCourse = null;
            //courses
            {
                Course course = new Course("CS544", "EA", "Enterprise Architecture");
                CourseOffering courseOffering = new CourseOffering();
                courseOffering.setStartDate(LocalDate.of(2021, 5, 25));
                courseOffering.setEndDate(LocalDate.of(2021, 6, 25));
                courseOffering.setFaculty((Faculty) faculty.getPerson());
                course.addCourseOffering(courseOffering);
                defaultCourse = courseRepository.save(course);
            }

            {
                Course course = new Course("CS472", "WAP", "Web Application Programming");
                CourseOffering courseOffering = new CourseOffering();
                courseOffering.setStartDate(LocalDate.of(2021, 6, 21));
                courseOffering.setEndDate(LocalDate.of(2021, 7, 21));
                courseOffering.setFaculty((Faculty) userRepository.findByEmail("admin@miu.edu").get().getPerson());
                course.addCourseOffering(courseOffering);
                courseRepository.save(course);
            }


            {
                Course course = new Course("CS72", "MWA", "Modern Web Application");
                CourseOffering courseOffering = new CourseOffering();
                courseOffering.setStartDate(LocalDate.of(2021, 7, 25));
                courseOffering.setEndDate(LocalDate.of(2021, 8, 25));
                courseOffering.setFaculty((Faculty) userRepository.findByEmail("najeeb@miu.edu").get().getPerson());
                course.addCourseOffering(courseOffering);
                courseRepository.save(course);
            }

            {
                Course course = new Course("CS582", "ML", "Enterprise Architecture");
                CourseOffering courseOffering = new CourseOffering();
                courseOffering.setStartDate(LocalDate.of(2021, 7, 25));
                courseOffering.setEndDate(LocalDate.of(2021, 8, 25));
                courseOffering.setFaculty((Faculty) userRepository.findByEmail("faculty@miu.edu").get().getPerson());
                course.addCourseOffering(courseOffering);
                courseRepository.save(course);
            }


            {
                Course course = new Course("CS525", "ASD", "Advanced Software Development");
                CourseOffering courseOffering = new CourseOffering();
                courseOffering.setStartDate(LocalDate.of(2021, 7, 25));
                courseOffering.setEndDate(LocalDate.of(2021, 8, 25));
                courseOffering.setFaculty((Faculty) userRepository.findByEmail("admin@miu.edu").get().getPerson());
                course.addCourseOffering(courseOffering);
                courseRepository.save(course);
            }

            //Time slots
            {
                TimeSlot timeSlot = new TimeSlot("AM", LocalTime.of(10, 00), LocalTime.of(12, 30), "it could be More than 2 hours");
                timeSlotRepository.save(timeSlot);
            }
            {
                TimeSlot timeSlot = new TimeSlot("PM", LocalTime.of(13, 30), LocalTime.of(15, 00), "it could be More than 1:30  hours");
                timeSlotRepository.save(timeSlot);
            }

            CourseOffering courseOffering = defaultCourse.getCourseOfferings().get(0);
            {
                for (int i = 0; i < 20; i++) {
                    {
                        ClassSession classSession = new ClassSession();
                        classSession.setLocation(location);
                        classSession.setStartDate(courseOffering.getStartDate().plusDays(i));
                        classSession.setCourseOffering(courseOffering);
                        classSession.addTimeSlot(timeSlotRepository.findByAbbreviation("AM").get());
                        classSessionRepository.save(classSession);
                    }
                    {
                        ClassSession classSession = new ClassSession();
                        classSession.setLocation(location);
                        classSession.setStartDate(courseOffering.getStartDate().plusDays(i));
                        classSession.setCourseOffering(courseOffering);
                        classSession.addTimeSlot(timeSlotRepository.findByAbbreviation("PM").get());
                        classSessionRepository.save(classSession);
                    }
                }
            }

            //Registration
            {
                {
                    Registration registration = new Registration();
                    registration.setRegistrationTime(LocalDateTime.of(2021, 8, 25, 12, 00));
                    registration.setStudent((Student) student.getPerson());
                    registration.setCourseOffering(courseOffering);
                    registrationRepository.save(registration);

                }
                {
                    Registration registration = new Registration();
                    registration.setRegistrationTime(LocalDateTime.of(2021, 8, 25, 12, 00));
                    registration.setStudent((Student) userRepository.findByEmail("misgna@gmail.com").get().getPerson());
                    registration.setCourseOffering(courseOffering);
                    registrationRepository.save(registration);

                }
                {
                    Registration registration = new Registration();
                    registration.setRegistrationTime(LocalDateTime.of(2021, 8, 25, 12, 00));
                    registration.setStudent((Student) userRepository.findByEmail("Teddy@gmail.com").get().getPerson());
                    registration.setCourseOffering(courseOffering);
                    registrationRepository.save(registration);

                }

            }

            // Attendance Record
            courseOffering = courseOfferingRepository.findById(courseOffering.getId()).get();
            {
                AttendanceRecord attendanceRecord = new AttendanceRecord();
                attendanceRecord.setScanTime(LocalDateTime.now());
                attendanceRecord.setStudent((Student) userRepository.findByEmail("Teddy@gmail.com").get().getPerson());
                attendanceRecord.setSession(courseOffering.getSessions().get(0));
                attendanceRepository.save(attendanceRecord);
            }

            {
                AttendanceRecord attendanceRecord = new AttendanceRecord();
                attendanceRecord.setScanTime(LocalDateTime.now());
                attendanceRecord.setStudent((Student) userRepository.findByEmail("misgna@gmail.com").get().getPerson());
                attendanceRecord.setSession(courseOffering.getSessions().get(0));
                attendanceRepository.save(attendanceRecord);
            }
            {
                AttendanceRecord attendanceRecord = new AttendanceRecord();
                attendanceRecord.setScanTime(LocalDateTime.now());
                attendanceRecord.setStudent((Student) userRepository.findByEmail("tuannx87@gmail.com").get().getPerson());
                attendanceRecord.setSession(courseOffering.getSessions().get(0));
                attendanceRepository.save(attendanceRecord);
            }

            log.info("Registered Users:");
            log.info("--------------------------------------------------------------");
            userRepository.findAll().forEach(user1 -> {
                log.info(user1);
                JPAUserDetails userDetails = new JPAUserDetails(user1);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            });

            System.out.println("current time slot: " + timeSlotRepository.getTimeSlot(LocalTime.now()));

            System.out.println("find today class session time slot: "
                    + classSessionRepository.findTodayClassSessionByLocationAndTimeSlot(
                    location, timeSlotRepository.getTimeSlot(LocalTime.now()).get()));
        };
    }
}