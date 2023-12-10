package com.placement.backendProject.Controller;

import com.placement.backendProject.Model.Student;
import com.placement.backendProject.service.iService;
import org.apache.camel.builder.RouteBuilder;

import java.util.List;

public class StudentRouteBuilder extends RouteBuilder {

    private final iService iser;

    public StudentRouteBuilder(iService iser) {
        this.iser = iser;
    }

    @Override
    public void configure() throws Exception {
        // Route for creating a new student
        from("direct:createStudent")
                .routeId("CreateStudentRoute")
                .process(exchange -> {
                    Student student = exchange.getIn().getBody(Student.class);
                    iser.createStudent(student);
                    exchange.getIn().setBody(student);
                })
                .to("json:output");

        // Route for retrieving all students
        from("direct:getAllStudents")
                .routeId("GetAllStudentsRoute")
                .process(exchange -> {
                    List<Student> students = iser.getAllStudents();
                    exchange.getIn().setBody(students);
                })
                .to("json:output");

        // Route for retrieving a student by ID
        from("direct:getStudentById")
                .routeId("GetStudentByIdRoute")
                .process(exchange -> {
                    long id = exchange.getIn().getHeader("studentId", Long.class);
                    Student student = iser.getStudentById(id);
                    exchange.getIn().setBody(student);
                })
                .to("json:output");

        // Route for updating a student
        from("direct:updateStudent")
                .routeId("UpdateStudentRoute")
                .process(exchange -> {
                    Student student = exchange.getIn().getBody(Student.class);
                    iser.updateStudent(student);
                    exchange.getIn().setBody(student);
                })
                .to("json:output");

        // Route for deleting a student
        from("direct:deleteStudent")
                .routeId("DeleteStudentRoute")
                .process(exchange -> {
                    long id = exchange.getIn().getHeader("studentId", Long.class);
                    Student student = iser.getStudentById(id);
                    iser.deleteStudent(student);
                    exchange.getIn().setBody(student);
                })
                .to("json:output");
    }

}