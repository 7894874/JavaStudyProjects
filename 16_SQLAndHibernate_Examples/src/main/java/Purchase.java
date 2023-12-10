import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Purchaselist")
public class Purchase {

    @EmbeddedId
    private PurchaseID nameCourseKey;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

        public PurchaseID getNameCourseKey() {
            return nameCourseKey;
        }

        public void setNameCourseKey(PurchaseID nameCourseKey) {
            this.nameCourseKey = nameCourseKey;
        }

    @Embeddable
    public static class PurchaseID implements Serializable {
        @Column(name = "student_name")
        private String studentName;


        @Column(name = "course_name")
        private String courseName;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PurchaseID)) return false;
            PurchaseID that = (PurchaseID) o;
            return Objects.equals(studentName, that.studentName) &&
                    Objects.equals(courseName, that.courseName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentName, courseName);
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

    }


}
