package com.example.e_assess.ui.dashboard;

public class ModelDashboard {
    String Student1,Student2,Student3,TopicName,GroupNo;

    public String getStudent1() {
        return Student1;
    }

    public void setStudent1(String student1) {
        Student1 = student1;
    }

    public void setStudent2(String student2) {
        Student2 = student2;
    }

    public void setStudent3(String student3) {
        Student3 = student3;
    }

    public void setTopicName(String topicName) {
        TopicName = topicName;
    }

    public String getStudent2() {
        return Student2;
    }

    public ModelDashboard(String student1, String student2, String student3, String topicName,String GroupNo) {
        Student1 = student1;
        Student2 = student2;
        Student3 = student3;
        TopicName = topicName;
        this.GroupNo=GroupNo;
    }

    public String getGroupNo() {
        return GroupNo;
    }

    public void setGroupNo(String groupNo) {
        GroupNo = groupNo;
    }

    public ModelDashboard() {
    }

    public String getStudent3() {
        return Student3;
    }

    public String getTopicName() {
        return TopicName;
    }
}
