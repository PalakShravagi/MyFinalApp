package com.example.e_assess.ui.admingroup;

public class moduleGroups {
    String Student1,Student2,Student3,TopicName, uerid;

    public moduleGroups() {
    }

    public moduleGroups(String Student1, String Student2, String Student3, String TopicName) {
        this.Student1 = Student1;
       this.Student2 = Student2;
        this.Student3 = Student3;
       this.TopicName = TopicName;
        this.uerid = uerid;
    }

    public moduleGroups(String student2) {
        Student2 = student2;
    }

    public String getStudent1() {
        return Student1;
    }

    public void setStudent1(String student1) {
        Student1 = student1;
    }

    public String getStudent2() {
        return Student2;
    }

    public void setStudent2(String student2) {
        Student2 = student2;
    }

    public String getStudent3() {
        return Student3;
    }

    public void setStudent3(String student3) {
        Student3 = student3;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String topicName) {
        TopicName = topicName;
    }
}