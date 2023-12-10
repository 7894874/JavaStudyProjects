import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionId studentCourseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public SubscriptionId getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(SubscriptionId studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


    @Embeddable
    public static class SubscriptionId implements Serializable {

        @ManyToOne
        @JoinColumn(name = "student_id")
        private Student student;

        @ManyToOne
        @JoinColumn(name = "course_id")
        private Course course;

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        @Override
        public boolean equals(Object o) {
            if ((o == null) || !(o instanceof SubscriptionId)) { return false;}
            if (this == o) {
                return true;
            }
            SubscriptionId that = (SubscriptionId) o;
            return Objects.equals(student, that.student) &&
                    Objects.equals(course, that.course);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, course);
        }
    }

}
