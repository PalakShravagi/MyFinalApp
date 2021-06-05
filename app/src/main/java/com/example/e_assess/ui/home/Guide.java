package com.example.e_assess.ui.home;

public class Guide {
    String Student1,Student2,Student3,TopicName,GroupNo;


    public Guide(String GroupNo,String student1, String student2, String student3, String topicName) {
        Student1 = student1;
        Student2 = student2;
        Student3 = student3;
        TopicName = topicName;
        this.GroupNo=GroupNo;
    }

    public Guide() {
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

    public String getGroupNo() {
        return GroupNo;
    }

    public void setGroupNo(String groupNo) {
        GroupNo = groupNo;
    }
}