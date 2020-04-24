import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "purchaselist")
@IdClass(PurchaseList.PurchaseListKey.class)
public class PurchaseList {

    @Id
    @Column(name = "student_name", nullable = true)
    private String studentName;

    @Id
    @Column(name = "course_name", nullable = true)
    private String courseName;

    @Column(nullable = true)
    private Integer price;

    @Column(name = "subscription_date", nullable = true)
    private Date subscriptionDate;

    public PurchaseList(String studentName, String courseName, Integer price, Date subscriptionDate) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.price = price;
        this.subscriptionDate = subscriptionDate;
    }

    public PurchaseList() {
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

    @Embeddable
    public static class PurchaseListKey implements Serializable {

        @Column(name = "student_name", nullable = true)
        private String studentName;

        @Column(name = "course_name", nullable = true)
        private String courseName;

        public PurchaseListKey() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PurchaseListKey that = (PurchaseListKey) o;
            return studentName.equals(that.studentName) &&
                    courseName.equals(that.courseName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentName, courseName);
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
    }
}
