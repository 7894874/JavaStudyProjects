
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "linkedPurchaselist")
public class LinkedPurchase {
    @EmbeddedId
    private LinkedPurchaseId linkedPurchaseId;

    public LinkedPurchaseId getLinkedPurchaseId() {
        return linkedPurchaseId;
    }



    public void setLinkedPurchaseId(int student_id, int course_id) {
        linkedPurchaseId = new LinkedPurchaseId(student_id, course_id);
    }

    @Embeddable
    public static class LinkedPurchaseId implements Serializable {

        private int studentId;

        private int courseId;

        public LinkedPurchaseId() {
        }

        public LinkedPurchaseId(int st, int c) {
            setStudentId(st);
            setCourseId(c);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LinkedPurchaseId)) return false;
            LinkedPurchaseId that = (LinkedPurchaseId) o;
            return studentId == that.studentId &&
                    courseId == that.courseId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, courseId);
        }
    }
}
