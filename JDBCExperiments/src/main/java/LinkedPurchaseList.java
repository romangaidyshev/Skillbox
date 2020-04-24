
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaseList")
@IdClass(LinkedPurchaseList.LinkedPurchaseListKey.class)
public class LinkedPurchaseList {

    @Id
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name", nullable = true)
    private String studentName;

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name", nullable = true)
    private String courseName;

    @Column(nullable = true)
    private Integer price;

   @Column(name = "subscription_date", nullable = true)
    private Date subscriptionDate;


    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(int studentId, String studentName, int courseId, String courseName, Integer price, Date subscriptionDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Embeddable
    public static class LinkedPurchaseListKey implements Serializable {

        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;


        public LinkedPurchaseListKey() {}

//        public LinkedPurchaseListKey(int studentId, int courseId) {
//            this.studentId = studentId;
//            this.courseId = courseId;
//        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinkedPurchaseListKey that = (LinkedPurchaseListKey) o;
            return getStudentId() == that.getStudentId() &&
                    getCourseId() == that.getCourseId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getStudentId(), getCourseId());
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
    }


}

