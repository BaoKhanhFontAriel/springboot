1. name trong @Entity chỉ tên của model 
    name trong @Table chỉ tên của database  

2. bổ sung câu lệnh spring.jpa.show-sql=true

3. thêm câu lệnh pring.h2.console.enabled=true vào file application.properties
    nó sẽ bật web console để thao tác H2

4. @Transient

5. - tham số name = "" dùng để đổi tên
    - tham số nullable = false buộc trường không được nullable
    - tham số unique=true chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu

6.  @Formula và @Temporal 

7. @Embeddable và @Embedded


8. JPARepository kế thừa từ QueryByExampleExecutor và PagingAndSortingRepository

9. 
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}

10. không. vì mỗi dữ liệu có 1 id khác nhau

11.  - @Id xác định trường nào là primary key
    - @NaturalID tạo unique constrain lên một trường không phải PrimaryKey
        + Dùng cho những dữ liệu bản chất đã là unique mà không cần hệ thống sinh ví dụ như email, di động, mã căn cước, ISBN
    = @Id, primary cần giữ nguyên không đổi, nhưng @NaturalId có thể được phép thay đổi, miễn đảm bảo duy nhất

12. 

13. có thể sử dụng Custom ID Generator. 
    - tạo ra 1 class id generator 

public class RandomIDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session Object obj)
    throws HibernateException {

        RandomString randomString = new RandomString(10);//Sinh chuỗi ngẫu nhiên 10 ký tự

        return randomString.nextString();
    }
}

- sau đó dùng @GenericGenerator để gán class tạo id 

    @Data
    @Entity(name="bar")
    @Table(name="bar")
    public class Bar {
        @GenericGenerator(name = "random_id", strategy = "vn.techmaster.demojpa.model.id.RandomIDGenerator")

        @Id @GeneratedValue(generator="random_id")
        private String id;
        private String name;
    }


14. 

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmailAddressAndLastName(String emailAddress, String lastName);

    List<Employee> findDistinctEmployeeByEmailAddressOrLastName(String firstname, String lastName);

    List<Employee> findByLastnameOrderByFirstnameAsc(String lastname);

    List<Employee> findByLastnameIgnoreCase(String lastname);
}

15. - @Query sử dụng phía trên các method, sử dụng câu truy vấn JPQL (Hibernate) hoặc raw SQL.
    + năng động trong việc query nhưng phân tác và khó duy trì

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Khi được gắn @Query, thì tên của method không còn tác dụng nữa
    // Đây là JPQL
    @Query("select u from User u where u.email = ?1")
    User myCustomQuery(String email);

    // Đây là Native SQL
    @Query(value = "select * from user u where u.email = ?1", nativeQuery = true)
    User myCustomQuery2(String email);
}

    - @NamedQuery: phía trên các class Entity 
    + chỉ được compile 1 lần sau khi persitence unit được load. tập trung và dễ duy trì

@Table(name = "users")
@Entity
@NamedQuery(name = "UserEntity.findByUserId", query = "SELECT u FROM UserEntity u WHERE u.id=:userId")
public class UserEntity {

    @Id
    private Long id;
    private String name;
    //Standard constructor, getters and setters.

}

16. Quy tắc định nghĩa method:

📍 Tên method bắt đầu bằng một trong các tiền tố sau: findBy, readBy, queryBy, countBy, getBy.

📍 Tiêu chí tìm kiếm phải là các thuộc tính thuộc entity, nếu không sẽ gây ra lỗi. Param của method chính là các giá trị cần tìm kiếm. Có thể kết hợp nhiều tiêu chí tìm kiếm bằng các mệnh đề and or, ngoài so sánh giá trị bằng thì có thể có less than, after, before, like, …

ví dụ:

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmailAddressAndLastName(String emailAddress, String lastName);

    List<Employee> findDistinctEmployeeByEmailAddressOrLastName(String firstname, String lastName);

    List<Employee> findByLastnameOrderByFirstnameAsc(String lastname);

    List<Employee> findByLastnameIgnoreCase(String lastname);
}


17. 

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<User> findByLastname(String lastname, Sort sort);

    List<User> findByLastname(String lastname, Pageable pageable);
}

18. 

@Entity(name="product")
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;


    @ManyToMany
    @JoinTable(
      name = "product_tag",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
    )

    @JsonManagedReference
    private List<Tag> tags = new ArrayList<>();
}

@Entity(name="category")
@Table(name="category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "category")
    private List<Product> products = new ArrayList<>();


}

@Entity(name="tag")
@Table(name="tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    List<Product> products = new ArrayList<>();
}